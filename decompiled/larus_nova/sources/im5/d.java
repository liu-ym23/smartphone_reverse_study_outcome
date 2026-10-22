package im5;

/* JADX INFO: loaded from: classes18.dex */
public final class d {
    static {
    }

    public static boolean a() {
        boolean r100 = com.bytedance.ee.bear.appsetting.c.a.f206237a.g("ccm.docx.mobile_prompt_pending_ssr");
        Boolean r101 = ((xm4.a.InterfaceC8255a) org.koin.java.a.c(xm4.a.InterfaceC8255a.class, null, null, 6)).a(c.class.getName());
        if (r101 == null) goto L5;
        boolean r102 = r101.booleanValue();
    L6:
        tt5.a.h("PreFetchSsrSettings", "fg is " + r100 + " , abTest is " + r102);
        if (r100 == false) goto L11;
        if (r102 == false) goto L12;
        return true;
    L12:
        return false;
    L11:
        return false;
    L5:
        r102 = false;
        goto L6
    }
}
