package gxb;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.map.api.monitor.MapMonitorConst;
import kotlin.jvm.internal.Intrinsics;
import otb.i;

/* JADX INFO: loaded from: classes37.dex */
public final class e implements otb.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f483292a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i f483293b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final exb.d f483294c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ViewGroup f483295d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final exb.a f483296e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f483297f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public c f483298g;

    public static final class a {
    }

    static {
    }

    @Override // otb.c
    public final void destroy() {
        this.f483296e.getClass();
        exb.a.c("OverlayPlatformViewPlugin", MapMonitorConst.EVENT_DESTROY);
        View r100 = this.f483297f;
        if (r100 == null) goto L5;
        this.f483295d.removeView(r100);
    L5:
        this.f483297f = null;
        this.f483293b.destroy();
        this.f483294c.a(this.f483292a);
    }

    @Override // otb.c
    public final i a() {
        return this.f483293b;
    }

    @Override // otb.c
    public final String getViewId() {
        return this.f483292a;
    }

    public e(String r100, i r101, exb.d r102, gxb.a r103) {
        Intrinsics.checkNotNullParameter(r100, "viewId");
        Intrinsics.checkNotNullParameter(r101, "platformViewFactory");
        Intrinsics.checkNotNullParameter(r102, "platformViewRegistry");
        Intrinsics.checkNotNullParameter(r103, KtvSubElement.CONTAINER);
        this.f483292a = r100;
        this.f483293b = r101;
        this.f483294c = r102;
        this.f483295d = r103;
        this.f483296e = r102.f474740a;
    }
}
