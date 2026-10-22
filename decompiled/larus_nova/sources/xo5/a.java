package xo5;

import android.content.Context;
import android.text.TextUtils;
import com.larksuite.framework.utils.UIUtils;
import com.samskivert.mustache.e;
import com.samskivert.mustache.h;
import com.ss.android.lark.utils.LarkContext;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes18.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, h> f564679a = null;

    static {
        f564679a = new HashMap();
    }

    public static int a(float r100) {
        return UIUtils.dp2px(LarkContext.getApplication(), r100);
    }

    public static h b(String r100) {
        HashMap r101 = (HashMap) f564679a;
        h r102 = (h) r101.get(r100);
        if (r102 != null) goto L6;
        h r103 = e.a().b().a(r100);
        r101.put(r100, r103);
        return r103;
    L6:
        return r102;
    }

    public static String d(Context r100, int r101, Map<String, String> r102) {
        String r103 = r100.getString(r101);
        if (TextUtils.isEmpty(r103) == true) goto L12;
        if (r102 == null) goto L12;
        if (r102.isEmpty() == true) goto L12;
        return b(r103).b(r102);
    L10:
        e = move-exception;
        tt5.a.f("UIHelper", e, false);
    L12:
        return r103;
    }

    public static String c(Context r100, int r101, String r102, String r103) {
        String r104 = r100.getString(r101);
        if (r102 == null) goto L11;
        if (r103 == null) goto L11;
        HashMap r105 = new HashMap(1);
        r105.put(r102, r103);
        return b(r104).b(r105);
    L9:
        e = move-exception;
        tt5.a.f("UIHelper", e, false);
    L11:
        return r104;
    }
}
