package jt5;

import android.content.Context;
import com.bytedance.ee.larkwebview.base.LarkWebView;
import com.bytedance.ee.larkwebview.service.listener.OnViewScrollListener;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import st5.i;
import st5.o;

/* JADX INFO: loaded from: classes19.dex */
public final class d implements OnViewScrollListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ht5.b f500313a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ht5.a f500314b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final jt5.a f500315c;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ee.larkwebview.service.listener.OnViewScrollListener
    public final void a() {
    }

    @Override // com.bytedance.ee.larkwebview.service.listener.OnViewScrollListener
    public final void b() {
    }

    @Override // com.bytedance.ee.larkwebview.service.listener.OnViewScrollListener
    public final void c(int r100, int r101) {
        jt5.a r102 = this.f500315c;
        r102.f500300a = r100;
        r102.f500301b = r101;
        r102.requestLayout();
    }

    public d(Context r100, ht5.b r101, LarkWebView r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "manager");
        Intrinsics.checkNotNullParameter(r102, "webView");
        this.f500313a = r101;
        this.f500314b = r101.f487132a;
        this.f500315c = new jt5.a(r100);
        o r103 = r102.getServiceManager();
        if (r103 == null) goto L8;
        i r104 = (i) r103.a(i.class);
        if (r104 == null) goto L9;
        r104.I(this);
        return;
    L9:
        return;
    }
}
