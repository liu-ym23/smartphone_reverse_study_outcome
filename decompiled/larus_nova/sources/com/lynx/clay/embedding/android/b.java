package com.lynx.clay.embedding.android;

import android.graphics.Matrix;
import android.view.InputDevice;
import android.view.MotionEvent;
import androidx.camera.video.AudioStats;
import com.lynx.clay.embedding.engine.renderer.FlutterRenderer;
import com.ss.ttm.player.MediaPlayer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes32.dex */
public final class b {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Matrix f380636f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FlutterRenderer f380637a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i f380638b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f380639c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public MotionEvent f380640d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f380641e;

    public static int b(int r100) {
        if (r100 != 0) goto L6;
        return 4;
    L6:
        if (r100 != 1) goto L9;
        return 6;
    L9:
        if (r100 != 5) goto L11;
        return 4;
    L11:
        if (r100 != 6) goto L14;
        return 6;
    L14:
        if (r100 != 2) goto L17;
        return 5;
    L17:
        if (r100 != 7) goto L19;
        return 3;
    L19:
        if (r100 != 3) goto L23;
        return 0;
    L23:
        if (r100 != 8) goto L25;
        return 3;
    L25:
        return -1;
    }

    static {
        f380636f = new Matrix();
    }

    public b(FlutterRenderer r100, boolean r101) {
        this.f380640d = null;
        this.f380641e = false;
        this.f380637a = r100;
        if (i.f380663c != null) goto L5;
        i.f380663c = new i();
    L5:
        this.f380638b = i.f380663c;
        this.f380639c = r101;
    }

    public final ByteBuffer c(MotionEvent r110, Matrix r111) {
        int r100 = r110.getPointerCount();
        ByteBuffer r101 = ByteBuffer.allocateDirect((r100 * 37) * 8);
        r101.order(ByteOrder.LITTLE_ENDIAN);
        int r102 = r110.getActionMasked();
        int r103 = b(r110.getActionMasked());
        if (r102 != 0) goto L5;
    L8:
        boolean r104 = true;
    L9:
        if (r104 == true) goto L14;
        if (r102 != 1) goto L12;
    L13:
        boolean r105 = true;
    L15:
        if (r104 == false) goto L17;
        a(r110, r110.getActionIndex(), r103, 0, r111, r101);
    L31:
        if ((r101.position() % MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_BUFFER_THRESHOLD_CONTROL) != 0) goto L34;
        return r101;
    L34:
        throw new AssertionError("Packet position is not on field boundary");
    L17:
        if (r105 == false) goto L27;
        int r112 = 0;
    L19:
        if (r112 >= r100) goto L26;
        if (r112 == r110.getActionIndex()) goto L25;
        if (r110.getToolType(r112) != 1) goto L25;
        a(r110, r112, 5, 1, r111, r101);
    L25:
        r112 = r112 + 1;
        goto L19
    L26:
        a(r110, r110.getActionIndex(), r103, 0, r111, r101);
        goto L31
    L27:
        int r113 = 0;
    L28:
        if (r113 >= r100) goto L31;
        a(r110, r113, r103, 0, r111, r101);
        r113 = r113 + 1;
        goto L28
    L12:
        if (r102 == 6) goto L13;
    L14:
        r105 = false;
        goto L15
    L5:
        if (r102 == 5) goto L8;
        r104 = false;
        goto L9
    }

    public final boolean d(MotionEvent r100, Matrix r101) {
        if (r100.getActionMasked() != 0) goto L5;
    L6:
        this.f380640d = r100;
        this.f380641e = false;
    L8:
        if (this.f380641e == false) goto L10;
        return false;
    L10:
        ByteBuffer r102 = c(r100, r101);
        FlutterRenderer r103 = this.f380637a;
        int r104 = r102.position();
        boolean r105 = r103.f380933a.dispatchPointerDataPacket(r102, r104);
        if (r105 == true) goto L20;
        this.f380641e = true;
        MotionEvent r106 = this.f380640d;
        if (r106 == null) goto L20;
        MotionEvent r107 = MotionEvent.obtain(r106);
        r107.setAction(3);
        ByteBuffer r108 = c(r107, r101);     // Catch: Throwable -> L17
        FlutterRenderer r109 = this.f380637a;     // Catch: Throwable -> L17
        int r110 = r108.position();     // Catch: Throwable -> L17
        r109.f380933a.dispatchPointerDataPacket(r108, r110);     // Catch: Throwable -> L17
        r107.recycle();
    L17:
        th = move-exception;
        r107.recycle();
        throw th;
    L20:
        return r105;
    L5:
        if (r100.getActionMasked() != 3) goto L8;
        goto L6
    }

    public final void a(MotionEvent r210, int r211, int r212, int r213, Matrix r214, ByteBuffer r215) {
        if (r212 != (-1)) goto L6;
        return;
    L6:
        if (this.f380639c == false) goto L8;
        i r100 = this.f380638b;
        r100.getClass();
        long r101 = i.a.f380666a.incrementAndGet();
        r100.f380664a.put(r101, MotionEvent.obtain(r210));
        r100.f380665b.add(Long.valueOf(r101));
    L9:
        int r102 = r210.getToolType(r211);
        if (r102 == 1) goto L18;
        if (r102 == 2) goto L17;
        int r110 = 3;
        if (r102 == 3) goto L16;
        if (r102 == 4) goto L20;
        r110 = 5;
    L20:
        if (r210.getActionMasked() != 8) goto L22;
        int r103 = 1;
    L23:
        long r111 = r210.getEventTime() * 1000;
        r215.putLong(r101);
        r215.putLong(r111);
        r215.putLong(r212);
        r215.putLong(r110);
        r215.putLong(r103);
        r215.putLong(r210.getPointerId(r211));
        r215.putLong(0);
        float[] r104 = {r210.getX(r211), r210.getY(r211)};
        r214.mapPoints(r104);
        r215.putDouble(r104[0]);
        r215.putDouble(r104[1]);
        r215.putDouble(AudioStats.AUDIO_AMPLITUDE_NONE);
        r215.putDouble(AudioStats.AUDIO_AMPLITUDE_NONE);
        if (r110 != 1) goto L36;
        long r112 = r210.getButtonState() & 31;
        if (r112 == 0) goto L28;
    L34:
        long r113 = r112;
    L39:
        r215.putLong(r113);
        r215.putLong(0);
        r215.putLong(0);
        r215.putDouble(r210.getPressure(r211));
        if (r210.getDevice() == null) goto L44;
        InputDevice.MotionRange r105 = r210.getDevice().getMotionRange(2);
        if (r105 == null) goto L44;
        double r114 = r105.getMin();
        double r115 = r105.getMax();
    L45:
        r215.putDouble(r114);
        r215.putDouble(r115);
        if (r110 != 2) goto L48;
        r215.putDouble(r210.getAxisValue(24, r211));
        r215.putDouble(AudioStats.AUDIO_AMPLITUDE_NONE);
    L49:
        r215.putDouble(r210.getSize(r211));
        r215.putDouble(r210.getToolMajor(r211));
        r215.putDouble(r210.getToolMinor(r211));
        r215.putDouble(AudioStats.AUDIO_AMPLITUDE_NONE);
        r215.putDouble(AudioStats.AUDIO_AMPLITUDE_NONE);
        r215.putDouble(r210.getAxisValue(8, r211));
        if (r110 != 2) goto L52;
        r215.putDouble(r210.getAxisValue(25, r211));
    L53:
        r215.putLong(r213);
        if (r103 != 1) goto L56;
        r215.putDouble(-r210.getAxisValue(10));
        r215.putDouble(-r210.getAxisValue(9));
    L57:
        r215.putDouble(AudioStats.AUDIO_AMPLITUDE_NONE);
        r215.putDouble(AudioStats.AUDIO_AMPLITUDE_NONE);
        r215.putDouble(AudioStats.AUDIO_AMPLITUDE_NONE);
        r215.putDouble(AudioStats.AUDIO_AMPLITUDE_NONE);
        r215.putDouble(1.0d);
        r215.putDouble(AudioStats.AUDIO_AMPLITUDE_NONE);
        r215.putLong(r210.getSource());
        r215.putLong(1);
        return;
    L56:
        r215.putDouble(AudioStats.AUDIO_AMPLITUDE_NONE);
        r215.putDouble(AudioStats.AUDIO_AMPLITUDE_NONE);
        goto L57
    L52:
        r215.putDouble(AudioStats.AUDIO_AMPLITUDE_NONE);
        goto L53
    L48:
        r215.putDouble(AudioStats.AUDIO_AMPLITUDE_NONE);
        r215.putDouble(AudioStats.AUDIO_AMPLITUDE_NONE);
    L44:
        r115 = 1.0d;
        r114 = 0.0d;
        goto L45
    L28:
        if (r210.getSource() != 8194) goto L34;
        if (r212 != 4) goto L32;
    L33:
        r113 = 1;
        goto L39
    L32:
        if (r212 != 5) goto L34;
    L36:
        if (r110 != 2) goto L38;
        r113 = (r210.getButtonState() >> 4) & 15;
        goto L39
    L38:
        r113 = 0;
        goto L39
    L22:
        r103 = 0;
        goto L23
    L16:
        r110 = 1;
        goto L20
    L17:
        r110 = 2;
        goto L20
    L18:
        r110 = 0;
        goto L20
    L8:
        r101 = 0;
        goto L9
    }
}
