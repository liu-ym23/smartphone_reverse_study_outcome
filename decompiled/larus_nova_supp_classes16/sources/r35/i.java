package r35;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.ee.bear.doc.docupgrade.DocRedirectToDocxPlugin;
import com.bytedance.ee.bear.document.imageviewer.diagram.DiagramData$RESULT;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.route.PostCard;
import com.bytedance.ee.bear.route.RouteBean;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class i extends com.bytedance.ee.bear.route.a {
    public static final HashMap<String, Integer> a = null;

    public final String e(BearUrl r1, RouteBean r2) {
        return "/doc/like/activity";
    }

    static {
        HashMap<String, Integer> r0 = new HashMap();
        a = r0;
        r0.put(sbb.e.g.getType(), 1);
        r0.put(sbb.e.h.getType(), 2);
        r0.put(sbb.e.i.getType(), 4);
        r0.put(sbb.e.o.getType(), 22);
        r0.put(sbb.e.l.getType(), 6);
    }

    public i() {
    }

    public final boolean b(Context r5, final BearUrl r6, final RouteBean r7) {
        Uri r8 = UriProtector.parse(r6.e);
        if (TextUtils.equals(UriProtector.getQueryParameter(r8, "show_like_list"), DiagramData$RESULT.SUCCESS) == true) goto L5;
        return false;
    L5:
        if (TextUtils.equals(UriProtector.getQueryParameter(r8, DocRedirectToDocxPlugin.FROM), "message_card") == false) goto L19;
        tt5.a.h("LikeInterceptor", "dispatchUrl()..." + r6.a);
        if (TextUtils.equals(sbb.e.n.getType(), r6.a) == false) goto L9;
        ((com.bytedance.ee.bear.contract.route.parcelable.a) org.koin.java.a.a(com.bytedance.ee.bear.contract.route.parcelable.a.class)).p(r6.b).observeOn(fo5.d.d()).subscribe(new g(this, r6, r7), new h());
    L16:
        return true;
    L9:
        String r9 = r6.b;
        String r1 = r6.a;
        if (TextUtils.isEmpty(r1) == true) goto L14;
        HashMap<String, Integer> r2 = a;
        if (r2.containsKey(r1) == false) goto L14;
        int r3 = r2.get(r1).intValue();
    L15:
        f(r6, r7, r9, r3);
    L14:
        r3 = 1;
        goto L15
    L19:
        return false;
    }

    public final void f(BearUrl r2, RouteBean r3, String r4, int r5) {
        PostCard r6 = d(r2, r3);
        r6.i("doc_token", r4).j("ref_type", r5).i(DocRedirectToDocxPlugin.FROM, "from_lark_info").i("url", r2.e);
        if (((com.bytedance.ee.bear.route.h) org.koin.java.a.a(com.bytedance.ee.bear.route.h.class)).getCurrentActivity() != null) goto L5;
        r6.m(268435456);
    L5:
        r6.e();
    }
}
