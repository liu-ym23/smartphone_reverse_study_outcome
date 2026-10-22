package er7;

import android.text.TextUtils;
import android.webkit.WebBackForwardList;
import android.webkit.WebHistoryItem;
import android.webkit.WebView;
import com.bytedance.security.android.polaris.PolarisUri;
import com.bytedance.webx.seclink.util.ReportUtil;
import java.util.List;

/* JADX INFO: loaded from: classes22.dex */
public abstract class a implements dr7.c {
    public a() {
    }

    public static boolean e(WebView r100, boolean r101) {
        if (cr7.a.f465094c == true) goto L5;
        return r101;
    L5:
        WebBackForwardList r102 = r100.copyBackForwardList();
        if (r102 == null) goto L23;
        WebHistoryItem r103 = r102.getCurrentItem();
        if (r103 == null) goto L23;
        if (cr7.a.f465093b == null) goto L23;
        if (r103.getUrl().startsWith(com.bytedance.webx.seclink.setting.c.d().g()) == false) goto L16;
        return r100.canGoBackOrForward(-2);
    L16:
        if (r102.getSize() != 2) goto L23;
        WebHistoryItem r104 = r102.getItemAtIndex(r102.getCurrentIndex() - 1);
        if (r104 == null) goto L23;
        if (ir7.c.g(r104.getUrl()) == false) goto L23;
        return r100.canGoBackOrForward(-2);
    L23:
        return r101;
    }

    public int f(String r100, String r101) {
        boolean r102 = true;
        if (cr7.a.f465094c == true) goto L6;
        return 1;
    L6:
        if (ir7.c.f(r100, r101) == true) goto L9;
        return 2;
    L9:
        gr7.a r103 = cr7.a.f465093b;
        if (r103 == null) goto L21;
        List<String> r104 = r103.f482372g;
        if (r104 == null) goto L21;
        if (r104.size() <= 0) goto L21;
        if (TextUtils.isEmpty(r100) == true) goto L21;
        boolean r105 = PolarisUri.isUriInAllowList(r100, r103.f482372g);     // Catch: Exception -> L19
    L22:
        if (r105 == false) goto L25;
        return 3;
    L25:
        hr7.c r106 = fr7.a.a().b(r101, r100);
        if (r106 != null) goto L28;
    L35:
        hr7.d.b().getClass();
        if ((System.currentTimeMillis() - hr7.d.f486906g) < hr7.d.f486909j) goto L39;
        r102 = false;
    L39:
        if (r102 == false) goto L42;
        return 5;
    L42:
        return 0;
    L28:
        if (r106.f486897c == true) goto L35;
        if (getClass() != e.class) goto L32;
        String r107 = "sec_link_strategy_v2";
    L33:
        ReportUtil.d(r100, r101, r107, false, "url_pre_check");
        return 4;
    L32:
        r107 = "sec_link_strategy";
    L19:
        e = move-exception;
        e.printStackTrace();
    L21:
        r105 = false;
        goto L22
    }
}
