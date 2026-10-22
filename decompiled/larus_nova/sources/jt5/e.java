package jt5;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.map.api.monitor.MapMonitorConst;
import kotlin.jvm.internal.Intrinsics;
import otb.i;

/* JADX INFO: loaded from: classes19.dex */
public final class e implements otb.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f500316a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i f500317b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ht5.d f500318c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ViewGroup f500319d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ht5.a f500320e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f500321f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public c f500322g;

    public static final class a {
    }

    static {
    }

    @Override // otb.c
    public final void destroy() {
        this.f500320e.getClass();
        ht5.a.b("OverlayPlatformViewPlugin", MapMonitorConst.EVENT_DESTROY);
        View r100 = this.f500321f;
        if (r100 == null) goto L5;
        this.f500319d.removeView(r100);
    L5:
        this.f500321f = null;
        this.f500317b.destroy();
        this.f500318c.a(this.f500316a);
    }

    @Override // otb.c
    public final i a() {
        return this.f500317b;
    }

    @Override // otb.c
    public final String getViewId() {
        return this.f500316a;
    }

    public e(String r100, i r101, ht5.d r102, jt5.a r103) {
        Intrinsics.checkNotNullParameter(r100, "viewId");
        Intrinsics.checkNotNullParameter(r101, "platformViewFactory");
        Intrinsics.checkNotNullParameter(r102, "platformViewRegistry");
        Intrinsics.checkNotNullParameter(r103, KtvSubElement.CONTAINER);
        this.f500316a = r100;
        this.f500317b = r101;
        this.f500318c = r102;
        this.f500319d = r103;
        this.f500320e = r102.f487138a;
    }
}
