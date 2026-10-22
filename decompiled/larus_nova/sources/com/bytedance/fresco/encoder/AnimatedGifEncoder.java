package com.bytedance.fresco.encoder;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.Log;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import kotlin.UByte;

/* JADX INFO: loaded from: classes19.dex */
public class AnimatedGifEncoder {
    private static final double MIN_TRANSPARENT_PERCENTAGE = 4.0d;
    private static final String TAG = "AnimatedGifEncoder";
    private boolean closeStream;
    private int colorDepth;
    private byte[] colorTab;
    private int delay;
    private int dispose;
    private boolean firstFrame;
    private int fixedHeight;
    private int fixedWidth;
    private boolean hasTransparentPixels;
    private int height;
    private Bitmap image;
    private byte[] indexedPixels;
    private OutputStream out;
    private int palSize;
    private byte[] pixels;
    private int repeat;
    private int sample;
    private boolean sizeSet;
    private boolean started;
    private int transIndex;
    private Integer transparent;
    private boolean[] usedEntry;
    private int width;

    private void analyzePixels() {
        byte[] r100 = this.pixels;
        int r101 = r100.length;
        int r102 = r101 / 3;
        this.indexedPixels = new byte[r102];
        NeuQuant r103 = new NeuQuant(r100, r101, this.sample);
        this.colorTab = r103.process();
        int r104 = 0;
    L3:
        byte[] r105 = this.colorTab;
        if (r104 >= r105.length) goto L6;
        byte r106 = r105[r104];
        int r107 = r104 + 2;
        r105[r104] = r105[r107];
        r105[r107] = r106;
        this.usedEntry[r104 / 3] = false;
        r104 = r104 + 3;
        goto L3
    L6:
        int r108 = 0;
        int r109 = 0;
    L7:
        if (r108 >= r102) goto L9;
        byte[] r110 = this.pixels;
        int r111 = r109 + 1;
        int r112 = r111 + 1;
        int r113 = r103.map(r110[r109] & UByte.MAX_VALUE, r110[r111] & UByte.MAX_VALUE, r110[r112] & UByte.MAX_VALUE);
        this.usedEntry[r113] = true;
        this.indexedPixels[r108] = (byte) r113;
        r108 = r108 + 1;
        r109 = r112 + 1;
        goto L7
    L9:
        this.pixels = null;
        this.colorDepth = 8;
        this.palSize = 7;
        Integer r114 = this.transparent;
        if (r114 == null) goto L13;
        this.transIndex = findClosest(r114.intValue());
        return;
    L13:
        if (this.hasTransparentPixels == false) goto L19;
        this.transIndex = findClosest(0);
        return;
    }

    private void getImagePixels() {
        int r100 = this.image.getWidth();
        int r101 = this.image.getHeight();
        int r102 = this.width;
        if (r100 == r102) goto L5;
    L6:
        Bitmap r103 = Bitmap.createBitmap(r102, this.height, Bitmap.Config.ARGB_8888);
        new Canvas(r103).drawBitmap(r103, 0.0f, 0.0f, null);
        this.image = r103;
    L7:
        int r104 = r100 * r101;
        int[] r105 = new int[r104];
        this.image.getPixels(r105, 0, r100, 0, 0, r100, r101);
        this.pixels = new byte[r104 * 3];
        boolean r106 = false;
        this.hasTransparentPixels = false;
        int r107 = 0;
        int r108 = 0;
        int r109 = 0;
    L8:
        if (r107 >= r104) goto L14;
        int r110 = r105[r107];
        if (r110 != 0) goto L12;
        r108 = r108 + 1;
    L12:
        byte[] r111 = this.pixels;
        int r112 = r109 + 1;
        r111[r109] = (byte) (r110 & 255);
        int r113 = r112 + 1;
        r111[r112] = (byte) ((r110 >> 8) & 255);
        r111[r113] = (byte) ((r110 >> 16) & 255);
        r107 = r107 + 1;
        r109 = r113 + 1;
        goto L8
    L14:
        if ((((double) (r108 * 100)) / ((double) r104)) <= 4.0d) goto L16;
        r106 = true;
    L16:
        this.hasTransparentPixels = r106;
        if (Log.isLoggable(TAG, 3) == true) goto L19;
        return;
    L19:
        return;
    L5:
        if (r101 == this.height) goto L7;
        goto L6
    }

    private void writeLSD() throws IOException {
        writeShort(this.width);
        writeShort(this.height);
        this.out.write(this.palSize | 240);
        this.out.write(0);
        this.out.write(0);
    }

    private void writeNetscapeExt() throws IOException {
        this.out.write(33);
        this.out.write(255);
        this.out.write(11);
        writeString("NETSCAPE2.0");
        this.out.write(3);
        this.out.write(1);
        writeShort(this.repeat);
        this.out.write(0);
    }

    private void writePalette() throws IOException {
        OutputStream r100 = this.out;
        byte[] r101 = this.colorTab;
        r100.write(r101, 0, r101.length);
        int r102 = 768 - this.colorTab.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        this.out.write(0);
        r103 = r103 + 1;
        goto L3
    }

    private void writePixels() throws IOException {
        new LZWEncoder(this.width, this.height, this.indexedPixels, this.colorDepth).encode(this.out);
    }

    public boolean finish() {
        if (this.started == true) goto L5;
        return false;
    L5:
        this.started = false;
        this.out.write(59);     // Catch: IOException -> L10
        this.out.flush();     // Catch: IOException -> L10
        if (this.closeStream == false) goto L9;
        this.out.close();     // Catch: IOException -> L10
    L9:
        boolean r100 = true;
    L11:
        this.transIndex = 0;
        this.out = null;
        this.image = null;
        this.pixels = null;
        this.indexedPixels = null;
        this.colorTab = null;
        this.closeStream = false;
        this.firstFrame = true;
        return r100;
    L10:
        r100 = false;
        goto L11
    }

    public AnimatedGifEncoder() {
        this.transparent = null;
        this.repeat = -1;
        this.delay = 0;
        this.started = false;
        this.usedEntry = new boolean[256];
        this.palSize = 7;
        this.dispose = -1;
        this.closeStream = false;
        this.firstFrame = true;
        this.sizeSet = false;
        this.sample = 10;
    }

    private int findClosest(int r110) {
        if (this.colorTab != null) goto L6;
        return -1;
    L6:
        int r100 = Color.red(r110);
        int r101 = Color.green(r110);
        int r111 = Color.blue(r110);
        int r102 = this.colorTab.length;
        int r103 = 0;
        int r104 = 0;
        int r105 = 16777216;
    L7:
        if (r103 >= r102) goto L13;
        byte[] r106 = this.colorTab;
        int r107 = r103 + 1;
        int r108 = r100 - (r106[r103] & UByte.MAX_VALUE);
        int r109 = r107 + 1;
        int r112 = r101 - (r106[r107] & UByte.MAX_VALUE);
        int r113 = r111 - (r106[r109] & UByte.MAX_VALUE);
        int r114 = ((r108 * r108) + (r112 * r112)) + (r113 * r113);
        int r115 = r109 / 3;
        if (this.usedEntry[r115] == false) goto L12;
        if (r114 >= r105) goto L12;
        r105 = r114;
        r104 = r115;
    L12:
        r103 = r109 + 1;
        goto L7
    L13:
        return r104;
    }

    private void writeGraphicCtrlExt(int r100) throws IOException {
        this.out.write(33);
        this.out.write(249);
        this.out.write(4);
        if (this.transparent == null) goto L5;
    L7:
        int r101 = 1;
        int r102 = 2;
    L8:
        int r103 = this.dispose;
        if (r103 < 0) goto L11;
        r102 = r103 & 7;
    L11:
        this.out.write(r101 | (((r102 << 2) | 0) | 0));
        writeShort(Math.round(r100 / 10.0f));
        this.out.write(this.transIndex);
        this.out.write(0);
        return;
    L5:
        if (this.hasTransparentPixels == true) goto L7;
        r101 = 0;
        r102 = 0;
        goto L8
    }

    private void writeShort(int r100) throws IOException {
        this.out.write(r100 & 255);
        this.out.write((r100 >> 8) & 255);
    }

    private void writeString(String r100) throws IOException {
        int r101 = 0;
    L4:
        if (r101 >= r100.length()) goto L6;
        this.out.write((byte) r100.charAt(r101));
        r101 = r101 + 1;
        goto L4
    }

    public void setDelay(int r100) {
        this.delay = Math.round(r100 / 10.0f);
    }

    public void setDispose(int r100) {
        if (r100 < 0) goto L5;
        this.dispose = r100;
        return;
    }

    public void setFrameRate(float r100) {
        if (r100 == 0.0f) goto L6;
        this.delay = Math.round(100.0f / r100);
        return;
    }

    public void setQuality(int r100) {
        if (r100 >= 1) goto L5;
        r100 = 1;
    L5:
        this.sample = r100;
    }

    public void setRepeat(int r100) {
        if (r100 < 0) goto L5;
        this.repeat = r100;
        return;
    }

    public void setTransparent(int r100) {
        this.transparent = Integer.valueOf(r100);
    }

    public boolean start(String r100) {
        BufferedOutputStream r101 = new BufferedOutputStream(new PolarisFileOutputStreamWrapper(r100));     // Catch: IOException -> L4
        this.out = r101;     // Catch: IOException -> L4
        boolean r102 = start(r101);     // Catch: IOException -> L4
        this.closeStream = true;     // Catch: IOException -> L4
    L5:
        this.started = r102;
        return r102;
    L4:
        r102 = false;
        goto L5
    }

    public boolean start(OutputStream r100) {
        boolean r101 = false;
        if (r100 != null) goto L5;
        return false;
    L5:
        this.closeStream = false;
        this.out = r100;
        writeString("GIF89a");     // Catch: IOException -> L10
        r101 = true;
    L8:
        this.started = r101;
        return r101;
    }

    private void setFrameSize(int r100, int r101) {
        this.width = r100;
        this.height = r101;
    }

    private void writeImageDesc(int r100, int r101) throws IOException {
        this.out.write(44);
        writeShort(r100);
        writeShort(r101);
        writeShort(this.width);
        writeShort(this.height);
        if (this.firstFrame == false) goto L5;
        this.out.write(0);
        return;
    L5:
        this.out.write(this.palSize | 128);
    }

    public boolean addFrame(Bitmap r100, int r101) {
        return addFrame(r100, 0, 0, r101);
    }

    public void setSize(int r100, int r101) {
        if (this.started == false) goto L5;
        return;
    L5:
        this.fixedWidth = r100;
        this.fixedHeight = r101;
        if (r100 >= 1) goto L8;
        this.fixedWidth = 320;
    L8:
        if (r101 >= 1) goto L10;
        this.fixedHeight = 240;
    L10:
        this.sizeSet = true;
    }

    public boolean addFrame(Bitmap r100, int r101, int r102, int r103) {
        if (r100 != null) goto L5;
        return false;
    L5:
        if (this.started == false) goto L26;
        if (this.sizeSet == false) goto L10;
        setFrameSize(this.fixedWidth, this.fixedHeight);     // Catch: IOException -> L22
    L11:
        this.image = r100;     // Catch: IOException -> L22
        getImagePixels();     // Catch: IOException -> L22
        analyzePixels();     // Catch: IOException -> L22
        if (this.firstFrame == false) goto L16;
        writeLSD();     // Catch: IOException -> L22
        writePalette();     // Catch: IOException -> L22
        if (this.repeat < 0) goto L16;
        writeNetscapeExt();     // Catch: IOException -> L22
    L16:
        writeGraphicCtrlExt(r103);     // Catch: IOException -> L22
        writeImageDesc(r101, r102);     // Catch: IOException -> L22
        if (this.firstFrame == true) goto L19;
        writePalette();     // Catch: IOException -> L22
    L19:
        writePixels();     // Catch: IOException -> L22
        this.firstFrame = false;     // Catch: IOException -> L22
        return true;
    L10:
        setFrameSize(r100.getWidth(), r100.getHeight());     // Catch: IOException -> L22
    L27:
        return false;
    L26:
        return false;
    }
}
