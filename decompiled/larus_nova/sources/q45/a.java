package q45;

import android.view.View;
import android.webkit.WebView;
import com.bytedance.ee.util.ui.n;
import com.ss.android.lark.chameleon.AbsChameleonService;
import kotlin.jvm.internal.Intrinsics;
import vv4.k;

/* JADX INFO: loaded from: classes16.dex */
public final class a extends AbsChameleonService {
    public a() {
    }

    @Override // com.ss.android.lark.chameleon.AbsChameleonService, vv4.a
    public final void onAttachToWeb(k r100) {
        Intrinsics.checkNotNullParameter(r100, "web");
        super.onAttachToWeb(r100);
        WebView r101 = r100.getWebView();
        r101.getSettings().setSupportMultipleWindows(true);
        r101.measure(View.MeasureSpec.makeMeasureSpec(n.v(), 1073741824), View.MeasureSpec.makeMeasureSpec((int) (n.t() * 0.9f), 1073741824));
        r101.layout(0, 0, r101.getMeasuredWidth(), r101.getMeasuredHeight());
    }

    @Override // com.ss.android.lark.chameleon.AbsChameleonService, vv4.a, vv4.m
    public final void onDetachFromWeb(k r100) {
        super.onDetachFromWeb(r100);
    }
}
