package t25;

import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d {
    public static Boolean a;
    public static Boolean b;

    static {
    }

    public static boolean a() {
        if (a != null) goto L12;
        boolean r0 = com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.docs.preload_priority_enable");
        Boolean r2 = ((xm4.a.a) org.koin.java.a.c(xm4.a.a.class, null, null, 6)).a(c.class.getName());
        if (r2 == null) goto L11;
        if (r0 == true) goto L8;
    L10:
        r0 = false;
        goto L11
    L8:
        if (r2.booleanValue() == false) goto L10;
        r0 = true;
    L11:
        a = Boolean.valueOf(r0);
        Log.i("PreloadTaskOptConfig", "isEnablePriority: " + r0);
    L12:
        Boolean r1 = a;
        if (r1 != null) goto L15;
        return false;
    L15:
        return r1.booleanValue();
    }
}
