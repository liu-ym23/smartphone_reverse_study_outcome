package z75;

import android.text.TextUtils;
import com.bytedance.ee.bear.drive.biz.preview.route.DriveWikiNavPlugin;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.JvmStatic;
import s45.p;
import sbb.e;

/* JADX INFO: loaded from: classes16.dex */
public final class d {
    static {
    }

    @JvmStatic
    public static final String a(String r100, String r101, String r102) {
        if (TextUtils.isEmpty(r102) == true) goto L6;
        if (r102 == null) goto L6;
        return r102;
    L6:
        tt5.a.k("FileUrlExt", "genFileProductUrl(): url is null ,gen by token...");
        return p.a().ua(e.f541301l.getType(), r100, r101);
    }

    @JvmStatic
    public static final String b(String r100, Map<String, String> r101, String r102) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        tt5.a.k("FileUrlExt", "genMoveProductUrl(): token is null");
        return "";
    L6:
        if (r101 != null) goto L9;
        r101 = new HashMap();
    L9:
        if (r101.containsKey("from") == true) goto L12;
        r101.put("from", DriveWikiNavPlugin.FROM_MOV_WIKI);
    L12:
        return p.a().Fd(r102, e.f541303n.getType(), r100, r101);
    }
}
