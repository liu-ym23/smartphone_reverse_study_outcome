package com.ss.android.vesdk.algorithm;

import android.graphics.Bitmap;
import com.ss.android.ttve.model.VEFrame;
import com.ss.android.ttve.nativePort.e;
import java.lang.reflect.Array;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes40.dex */
public class VEBachQRCodeResult extends VEScanResult {
    private long afterAlgorithmDuring;
    private long algorithmDuring;
    private long algorithmInitCostTime;
    private float avgTimeForNonQRCodeMs;
    private float avgTimeForQRCodeMs;
    private long beforeAlgorithmDuring;
    private int bodyCount;
    private List<Float> bodyRectF;
    private int bottom;
    private float cameraProcessFPS;
    private Bitmap currentFrame;
    private int currentFrameHeight;
    private int currentFrameWidth;
    private int faceCount;
    private List<Float> faceRectF;
    private boolean isFromBach;
    private int left;
    private int mCodeType;
    private float[][] mLocation;
    private String mResult;
    private int right;
    private String sourceImageKey;
    private int top;
    private long totalSendFrameCostTime;
    private float zoomRefactor;

    public String toString() {
        return "VEBachQRCodeResult{mResult='" + this.mResult + "', mCodeType=" + this.mCodeType + ", zoomRefactor=" + this.zoomRefactor + ", left=" + this.left + ", right=" + this.right + ", top=" + this.top + ", bottom=" + this.bottom + ", isFromBach=" + this.isFromBach + ", currentFrameWidth=" + this.currentFrameWidth + ", currentFrameHeight=" + this.currentFrameHeight + '}';
    }

    public VEBachQRCodeResult() {
        this.mResult = "";
        this.mCodeType = 0;
        this.zoomRefactor = 0.0f;
        Class r100 = Float.TYPE;
        this.mLocation = (float[][]) Array.newInstance(r100, new int[]{4, 2});
        this.currentFrameWidth = 0;
        this.currentFrameHeight = 0;
        this.currentFrame = null;
        this.sourceImageKey = null;
        this.cameraProcessFPS = -1.0f;
        this.avgTimeForQRCodeMs = -1.0f;
        this.avgTimeForNonQRCodeMs = -1.0f;
        this.algorithmInitCostTime = -1;
        this.totalSendFrameCostTime = -1;
        this.beforeAlgorithmDuring = -1;
        this.algorithmDuring = -1;
        this.afterAlgorithmDuring = -1;
        this.faceCount = 0;
        this.bodyCount = 0;
        this.faceRectF = new ArrayList();
        this.bodyRectF = new ArrayList();
        this.left = 0;
        this.right = 0;
        this.top = 0;
        this.bottom = 0;
        this.isFromBach = true;
        this.type = 0;
    }

    public long getAfterAlgorithmDuring() {
        return this.afterAlgorithmDuring;
    }

    public long getAlgorithmDuring() {
        return this.algorithmDuring;
    }

    public long getAlgorithmInitCostTime() {
        return this.algorithmInitCostTime;
    }

    public float getAvgTimeForNonQRCodeMs() {
        return this.avgTimeForNonQRCodeMs;
    }

    public float getAvgTimeForQRCodeMs() {
        return this.avgTimeForQRCodeMs;
    }

    public long getBeforeAlgorithmDuring() {
        return this.beforeAlgorithmDuring;
    }

    public int getBodyCount() {
        return this.bodyCount;
    }

    public List<Float> getBodyRectF() {
        return this.bodyRectF;
    }

    public int getBottom() {
        return this.bottom;
    }

    public float getCameraProcessFPS() {
        return this.cameraProcessFPS;
    }

    public int getCodeType() {
        return this.mCodeType;
    }

    public Bitmap getCurrentFrame() {
        return this.currentFrame;
    }

    public int getCurrentFrameHeight() {
        return this.currentFrameHeight;
    }

    public int getCurrentFrameWidth() {
        return this.currentFrameWidth;
    }

    public int getFaceCount() {
        return this.faceCount;
    }

    public List<Float> getFaceRectF() {
        return this.faceRectF;
    }

    public boolean getIsFromBach() {
        return this.isFromBach;
    }

    public int getLeft() {
        return this.left;
    }

    public float[][] getLocation() {
        return this.mLocation;
    }

    public String getResult() {
        return this.mResult;
    }

    public int getRight() {
        return this.right;
    }

    public String getSourceImageKey() {
        return this.sourceImageKey;
    }

    public int getTop() {
        return this.top;
    }

    public long getTotalSendFrameCostTime() {
        return this.totalSendFrameCostTime;
    }

    public float getZoomRefactor() {
        return this.zoomRefactor;
    }

    public static List<VEBachQRCodeResult> makeList(byte[] r100) {
        e r101 = new e(r100);
        int r102 = r101.c();
        ArrayList r103 = new ArrayList();
        int r104 = 0;
    L3:
        if (r104 >= r102) goto L5;
        r103.add(_fromTEParcel(r101, true));
        r104 = r104 + 1;
        goto L3
    L5:
        return r103;
    }

    public void setAfterAlgorithmDuring(long r100) {
        this.afterAlgorithmDuring = r100;
    }

    public void setAlgorithmDuring(long r100) {
        this.algorithmDuring = r100;
    }

    public void setAlgorithmInitCostTime(long r100) {
        this.algorithmInitCostTime = r100;
    }

    public void setAvgTimeForNonQRCodeMs(float r100) {
        this.avgTimeForNonQRCodeMs = r100;
    }

    public void setAvgTimeForQRCodeMs(float r100) {
        this.avgTimeForQRCodeMs = r100;
    }

    public void setBeforeAlgorithmDuring(long r100) {
        this.beforeAlgorithmDuring = r100;
    }

    public void setBodyCount(int r100) {
        this.bodyCount = r100;
    }

    public void setBodyRectF(List<Float> r100) {
        this.bodyRectF = r100;
    }

    public void setBottom(int r100) {
        this.bottom = r100;
    }

    public void setCameraProcessFPS(float r100) {
        this.cameraProcessFPS = r100;
    }

    public void setCodeType(int r100) {
        this.mCodeType = r100;
    }

    public void setCurrentFrame(Bitmap r100) {
        this.currentFrame = r100;
    }

    public void setCurrentFrameHeight(int r100) {
        this.currentFrameHeight = r100;
    }

    public void setCurrentFrameWidth(int r100) {
        this.currentFrameWidth = r100;
    }

    public void setFaceCount(int r100) {
        this.faceCount = r100;
    }

    public void setFaceRectF(List<Float> r100) {
        this.faceRectF = r100;
    }

    public void setIsFromBach(boolean r100) {
        this.isFromBach = r100;
    }

    public void setLeft(int r100) {
        this.left = r100;
    }

    public void setLocation(float[][] r100) {
        this.mLocation = r100;
    }

    public void setResult(String r100) {
        this.mResult = r100;
    }

    public void setRight(int r100) {
        this.right = r100;
    }

    public void setSourceImageKey(String r100) {
        this.sourceImageKey = r100;
    }

    public void setTop(int r100) {
        this.top = r100;
    }

    public void setTotalSendFrameCostTime(long r100) {
        this.totalSendFrameCostTime = r100;
    }

    public void setZoomRefactor(float r100) {
        this.zoomRefactor = r100;
    }

    private static VEBachQRCodeResult _fromTEParcel(e r110, boolean r111) {
        VEBachQRCodeResult r100 = new VEBachQRCodeResult();
        r100.setRetCode(r110.c());
        r100.setCodeType(r110.c());
        r100.setZoomRefactor(r110.b());
        int r101 = r110.c();
        int r102 = r110.c();
        r100.setCurrentFrameHeight(r101);
        r100.setCurrentFrameWidth(r102);
        Class r103 = Float.TYPE;
        float[][] r104 = (float[][]) Array.newInstance(r103, new int[]{4, 2});
        boolean r105 = false;
        int r106 = 0;
    L4:
        if (r106 >= 4) goto L6;
        r104[r106][0] = r110.b();
        r104[r106][1] = r110.b();
        r106 = r106 + 1;
        goto L4
    L6:
        r100.setCameraProcessFPS(r110.b());
        r100.setAvgTimeForQRCodeMs(r110.b());
        r100.setAvgTimeForNonQRCodeMs(r110.b());
        r100.setAlgorithmInitCostTime(r110.e().longValue());
        r100.setTotalSendFrameCostTime(r110.e().longValue());
        r100.setBeforeAlgorithmDuring(r110.e().longValue());
        r100.setAlgorithmDuring(r110.e().longValue());
        r100.setAfterAlgorithmDuring(r110.e().longValue());
        int r107 = r110.c();
        r100.setFaceCount(r107);
        ArrayList r108 = new ArrayList();
        int r109 = 0;
    L8:
        if (r109 >= (r107 * 4)) goto L10;
        r108.add(Float.valueOf(r110.b()));
        r109 = r109 + 1;
        goto L8
    L10:
        r100.setFaceRectF(r108);
        int r112 = r110.c();
        r100.setBodyCount(r112);
        ArrayList r113 = new ArrayList();
        int r114 = 0;
    L12:
        if (r114 >= (r112 * 4)) goto L14;
        r113.add(Float.valueOf(r110.b()));
        r114 = r114 + 1;
        goto L12
    L14:
        r100.setBodyRectF(r113);
        if (r111 == false) goto L20;
        String r115 = r110.g(r110.c());
        if (r102 <= 0) goto L21;
        if (r101 <= 0) goto L21;
        r100.setSourceImageKey(r110.g(r110.c()));
    L21:
        int r116 = r110.c();
        int r117 = r110.c();
        int r118 = r110.c();
        int r119 = r110.c();
        if (r110.c() == 0) goto L24;
        r105 = true;
    L24:
        r100.setIsFromBach(r105);
        if (r100.isFromBach == true) goto L27;
        r100.setLeft(r116);
        r100.setRight(r117);
        r100.setTop(r118);
        r100.setBottom(r119);
    L27:
        r100.setResult(r115);
        r100.setLocation(r104);
        return r100;
    L20:
        r115 = r110.f();
        goto L21
    }

    public static VEBachQRCodeResult fromCameraParcel(byte[] r100, ByteBuffer r101) {
        VEBachQRCodeResult r102 = _fromTEParcel(new e(r100), false);
        if (r101 == null) goto L9;
        int r103 = r102.currentFrameHeight;
        if (r103 <= 0) goto L9;
        int r104 = r102.currentFrameWidth;
        if (r104 <= 0) goto L9;
        r102.setCurrentFrame(VEFrame.createByteBufferFrame(r101, r104, r103, 0, 0, VEFrame.ETEPixelFormat.TEPixFmt_RGBA8).toBitmap());
    L9:
        return r102;
    }

    private static VEBachQRCodeResult _fromTEParcelThird(e r100, boolean r101, int r102) {
        VEBachQRCodeResult r103 = new VEBachQRCodeResult();
        r103.setRetCode(r100.c());
        r103.setCodeType(r100.c());
        r103.setZoomRefactor(r100.b());
        int r104 = r100.c();
        int r105 = r100.c();
        r103.setCurrentFrameHeight(r104);
        r103.setCurrentFrameWidth(r105);
        if (r101 == false) goto L8;
        String r106 = r100.g(r100.c());
        if (r105 <= 0) goto L9;
        if (r104 <= 0) goto L9;
        r103.setSourceImageKey(r100.g(r100.c()));
    L9:
        r103.setResult(r106);
        r103.setLeft(r100.c());
        r103.setRight(r100.c());
        r103.setTop(r100.c());
        r103.setBottom(r100.c());
        r103.setIsFromBach(r100.a());
        return r103;
    L8:
        r106 = r100.f();
        goto L9
    }

    public static VEBachQRCodeResult fromCameraParcelThirdParty(byte[] r100, ByteBuffer r101, int r102) {
        VEBachQRCodeResult r103 = _fromTEParcelThird(new e(r100), false, 0);
        if (r101 == null) goto L9;
        int r104 = r103.currentFrameHeight;
        if (r104 <= 0) goto L9;
        int r105 = r103.currentFrameWidth;
        if (r105 <= 0) goto L9;
        r103.setCurrentFrame(VEFrame.createByteBufferFrame(r101, r105, r104, 0, 0, VEFrame.ETEPixelFormat.TEPixFmt_RGBA8).toBitmap());
    L9:
        return r103;
    }
}
