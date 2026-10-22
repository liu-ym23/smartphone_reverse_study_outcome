package im5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d {
    static {
    }

    public static boolean a() {
        boolean r0 = com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.docx.mobile_prompt_pending_ssr");
        Boolean r1 = ((xm4.a.a) org.koin.java.a.c(xm4.a.a.class, null, null, 6)).a(c.class.getName());
        if (r1 == null) goto L5;
        boolean r2 = r1.booleanValue();
    L6:
        tt5.a.h("PreFetchSsrSettings", "fg is " + r0 + " , abTest is " + r2);
        if (r0 == false) goto L11;
        if (r2 == false) goto L12;
        return true;
    L12:
        return false;
    L11:
        return false;
    L5:
        r2 = false;
        goto L6
    }
}
