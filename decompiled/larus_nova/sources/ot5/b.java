package ot5;

import com.bytedance.ee.larkwebview.base.LarkWebView;
import com.bytedance.ee.larkwebview.quality.hang.HangRecoveryStrategy;
import com.ss.android.lark.officesdk.utils.di.TTWebViewUtil;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import otb.n;

/* JADX INFO: loaded from: classes19.dex */
public final class b implements ot5.a {

    public static final class a {
    }

    static {
    }

    public b() {
        HangRecoveryStrategy r100 = HangRecoveryStrategy.TERMINATE_RENDER_PROCESS;
    }

    @Override // ot5.a
    public final boolean a(LarkWebView r100) {
        Intrinsics.checkNotNullParameter(r100, "webView");
        Lazy<n> r101 = TTWebViewUtil.f437209a;
        TTWebViewUtil.a.d(null);
        return false;
    }
}
