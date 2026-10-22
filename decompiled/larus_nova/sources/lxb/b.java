package lxb;

import com.ss.android.lark.officesdk.utils.di.TTWebViewUtil;
import com.ss.android.lark.officewebview.base.OfficeWebView;
import com.ss.android.lark.officewebview.quality.hang.HangRecoveryStrategy;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import otb.n;

/* JADX INFO: loaded from: classes37.dex */
public final class b implements lxb.a {

    public static final class a {
    }

    static {
    }

    public b() {
        HangRecoveryStrategy r100 = HangRecoveryStrategy.TERMINATE_RENDER_PROCESS;
    }

    @Override // lxb.a
    public final boolean a(OfficeWebView r100) {
        Intrinsics.checkNotNullParameter(r100, "webView");
        Lazy<n> r101 = TTWebViewUtil.f437209a;
        TTWebViewUtil.a.d(null);
        return false;
    }
}
