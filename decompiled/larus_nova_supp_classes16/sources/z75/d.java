package z75;

import android.text.TextUtils;
import com.bytedance.ee.bear.doc.docupgrade.DocRedirectToDocxPlugin;
import com.bytedance.ee.bear.drive.biz.preview.route.DriveWikiNavPlugin;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.JvmStatic;
import s45.p;
import sbb.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d {
    static {
    }

    @JvmStatic
    public static final String a(String r1, String r2, String r3) {
        if (TextUtils.isEmpty(r3) == true) goto L6;
        if (r3 == null) goto L6;
        return r3;
    L6:
        tt5.a.k("FileUrlExt", "genFileProductUrl(): url is null ,gen by token...");
        return p.a().ua(e.l.getType(), r1, r2);
    }

    @JvmStatic
    public static final String b(String r2, Map<String, String> r3, String r4) {
        if (TextUtils.isEmpty(r2) == false) goto L6;
        tt5.a.k("FileUrlExt", "genMoveProductUrl(): token is null");
        return "";
    L6:
        if (r3 != null) goto L9;
        r3 = new HashMap();
    L9:
        if (r3.containsKey(DocRedirectToDocxPlugin.FROM) == true) goto L12;
        r3.put(DocRedirectToDocxPlugin.FROM, DriveWikiNavPlugin.FROM_MOV_WIKI);
    L12:
        return p.a().Fd(r4, e.n.getType(), r2, r3);
    }
}
