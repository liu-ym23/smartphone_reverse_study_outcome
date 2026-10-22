package q45;

import android.view.View;
import android.webkit.WebView;
import com.bytedance.ee.util.ui.n;
import com.ss.android.lark.chameleon.AbsChameleonService;
import kotlin.jvm.internal.Intrinsics;
import vv4.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a extends AbsChameleonService {
    public a() {
    }

    public final void onAttachToWeb(k r5) {
        Intrinsics.checkNotNullParameter(r5, "web");
        super.onAttachToWeb(r5);
        WebView r6 = r5.getWebView();
        r6.getSettings().setSupportMultipleWindows(true);
        r6.measure(View.MeasureSpec.makeMeasureSpec(n.v(), 1073741824), View.MeasureSpec.makeMeasureSpec((int) (n.t() * 0.9f), 1073741824));
        r6.layout(0, 0, r6.getMeasuredWidth(), r6.getMeasuredHeight());
    }

    public final void onDetachFromWeb(k r1) {
        super.onDetachFromWeb(r1);
    }
}
