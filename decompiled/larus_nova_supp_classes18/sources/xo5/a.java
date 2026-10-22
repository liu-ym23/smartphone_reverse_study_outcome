package xo5;

import android.content.Context;
import android.text.TextUtils;
import com.larksuite.framework.utils.UIUtils;
import com.samskivert.mustache.e;
import com.samskivert.mustache.h;
import com.ss.android.lark.utils.LarkContext;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a {
    public static final Map<String, h> a = null;

    static {
        a = new HashMap();
    }

    public static int a(float r1) {
        return UIUtils.dp2px(LarkContext.getApplication(), r1);
    }

    public static h b(String r2) {
        HashMap r0 = (HashMap) a;
        h r1 = (h) r0.get(r2);
        if (r1 != null) goto L6;
        h r3 = e.a().b().a(r2);
        r0.put(r2, r3);
        return r3;
    L6:
        return r1;
    }

    public static String d(Context r1, int r2, Map<String, String> r3) {
        String r4 = r1.getString(r2);
        if (TextUtils.isEmpty(r4) == true) goto L12;
        if (r3 == null) goto L12;
        if (r3.isEmpty() == true) goto L12;
        return b(r4).b(r3);
    L10:
        e = move-exception;
        tt5.a.f("UIHelper", e, false);
    L12:
        return r4;
    }

    public static String c(Context r1, int r2, String r3, String r4) {
        String r5 = r1.getString(r2);
        if (r3 == null) goto L11;
        if (r4 == null) goto L11;
        HashMap r6 = new HashMap(1);
        r6.put(r3, r4);
        return b(r5).b(r6);
    L9:
        e = move-exception;
        tt5.a.f("UIHelper", e, false);
    L11:
        return r5;
    }
}
