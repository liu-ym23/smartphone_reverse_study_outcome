package gxb;

import android.content.Context;
import com.ss.android.lark.officewebview.base.OfficeWebView;
import com.ss.android.lark.officewebview.service.listener.OnViewScrollListener;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import oxb.h;
import oxb.n;

/* JADX INFO: loaded from: classes37.dex */
public final class d implements OnViewScrollListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final exb.b f483289a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final exb.a f483290b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final gxb.a f483291c;

    public static final class a {
    }

    static {
    }

    @Override // com.ss.android.lark.officewebview.service.listener.OnViewScrollListener
    public final void a() {
    }

    @Override // com.ss.android.lark.officewebview.service.listener.OnViewScrollListener
    public final void b() {
    }

    @Override // com.ss.android.lark.officewebview.service.listener.OnViewScrollListener
    public final void c(int r100, int r101) {
        gxb.a r102 = this.f483291c;
        r102.f483276a = r100;
        r102.f483277b = r101;
        r102.requestLayout();
    }

    public d(Context r100, exb.b r101, OfficeWebView r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "manager");
        Intrinsics.checkNotNullParameter(r102, "webView");
        this.f483289a = r101;
        this.f483290b = r101.f474734a;
        this.f483291c = new gxb.a(r100);
        n r103 = r102.getServiceManager();
        if (r103 == null) goto L8;
        h r104 = (h) r103.a(h.class);
        if (r104 == null) goto L9;
        r104.K(this);
        return;
    L9:
        return;
    }
}
