package o7a;

import android.view.Choreographer;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.utils.DeviceUtils;

/* JADX INFO: loaded from: classes32.dex */
public final class b implements Choreographer.FrameCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.lynx.tasm.fluency.b f522290a;

    public b(com.lynx.tasm.fluency.b r100) {
        this.f522290a = r100;
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long r100) {
        com.lynx.tasm.fluency.b r101 = this.f522290a;
        if (r101.f383359f != (-1)) goto L5;
        r101.f383359f = r100;
    L5:
        r101.f383361h++;
        if (r101.f383355b == false) goto L8;
        Choreographer.getInstance().postFrameCallback(this);
    L8:
        com.lynx.tasm.fluency.b r102 = this.f522290a;
        long r103 = r102.f383360g;
        if (r103 <= 0) goto L34;
        double r104 = (r100 - r103) / 1000000.0d;
        if (((long) r104) <= 0) goto L34;
        if (r102.f383364k != (-1)) goto L31;
        LynxContext r105 = r102.f383354a.get();
        if (r105 == null) goto L28;
        float r106 = DeviceUtils.c(r105.getContext());
        if (Math.abs(r106 - 60.0f) < 5.1f) goto L28;
        if (Math.abs(r106 - 90.0f) >= 5.1f) goto L25;
        int r107 = 90;
    L29:
        r102.f383364k = r107;
        goto L31
    L25:
        if (Math.abs(r106 - 120.0f) >= 5.1f) goto L27;
        r107 = 120;
        goto L29
    L27:
        r107 = (int) r106;
    L28:
        r107 = 60;
    L31:
        if (r102.f383358e.size() <= 20000) goto L33;
        r102.f383358e.poll();
    L33:
        r102.f383358e.add(Long.valueOf((long) (r104 * 100.0d)));
    L34:
        this.f522290a.f383360g = r100;
    }
}
