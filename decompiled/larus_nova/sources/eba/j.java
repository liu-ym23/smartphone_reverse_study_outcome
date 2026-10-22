package eba;

import android.view.SurfaceControl;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.activation.presentation.runtime.surface.ObricRootSurfaceEvent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class j implements hba.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f471954a;

    @Override // hba.f
    public final void onRootSurfaceDestroyed() {
        this.f471954a.a();
    }

    public j(i r100) {
        this.f471954a = r100;
    }

    @Override // hba.f
    public final void onRootSurfaceUnavailable(String r100) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        FLogger.f375446a.w("ObricListeningChildWindow", "unavailable: side=child stage=surface reason=" + r100);
        this.f471954a.f(null);
    }

    @Override // hba.f
    public final void onRootSurfaceAvailable(SurfaceControl r100, ObricRootSurfaceEvent r101, SurfaceControl.Transaction r102) {
        Intrinsics.checkNotNullParameter(r100, "surface");
        Intrinsics.checkNotNullParameter(r101, "event");
        i r103 = this.f471954a;
        int r104 = r103.f471952y;
        int r105 = r103.A;
        Intrinsics.checkNotNullParameter(r101, "event");
        ObricRootSurfaceEvent r106 = ObricRootSurfaceEvent.REPLACED;
        boolean r107 = true;
        if (r101 != r106) goto L7;
        if (r104 <= 0) goto L7;
        if (r105 != r104) goto L7;
        boolean r108 = true;
    L8:
        if (r101 != r106) goto L10;
    L11:
        i r109 = this.f471954a;
        int r110 = r109.f471952y;
        if (r110 != Integer.MAX_VALUE) goto L14;
        int r111 = 1;
    L15:
        r109.f471952y = r111;
    L16:
        i r112 = this.f471954a;
        r112.f471951x = r100;
        if (r112.A == r112.f471952y) goto L19;
        r112.i(false, "child_surface_generation_changed");
    L19:
        if (r108 == false) goto L21;
    L22:
        i r113 = this.f471954a;
        r113.B = r113.f471952y;
    L23:
        this.f471954a.C = false;
        FLogger r114 = FLogger.f375446a;
        StringBuilder r115 = new StringBuilder("publish: side=child stage=surface generation=");
        r115.append(this.f471954a.f471952y);
        r115.append(" source=");
        r115.append(r101);
        r115.append(" display=");
        r115.append(this.f471954a.f471947t);
        r115.append(" type=");
        r115.append(this.f471954a.f471946s);
        r115.append(" wait=");
        i r116 = this.f471954a;
        if (r116.B == r116.f471952y) goto L27;
        r107 = false;
    L27:
        r115.append(r107);
        r114.i("ObricListeningChildWindow", r115.toString());
        i r117 = this.f471954a;
        r117.f471931d.invoke(r100, Integer.valueOf(r117.f471952y), Integer.valueOf(this.f471954a.f471947t), Integer.valueOf(this.f471954a.f471946s));
        return;
    L21:
        if (this.f471954a.C == false) goto L23;
    L14:
        r111 = r110 + 1;
        goto L15
    L10:
        if (this.f471954a.f471951x == r100) goto L16;
    L7:
        r108 = false;
        goto L8
    }
}
