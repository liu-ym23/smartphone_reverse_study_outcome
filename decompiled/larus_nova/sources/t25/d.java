package t25;

import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: classes16.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Boolean f544231a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Boolean f544232b;

    static {
    }

    public static boolean a() {
        if (f544231a != null) goto L12;
        boolean r100 = com.bytedance.ee.bear.appsetting.c.a.f206237a.g("ccm.docs.preload_priority_enable");
        Boolean r101 = ((xm4.a.InterfaceC8255a) org.koin.java.a.c(xm4.a.InterfaceC8255a.class, null, null, 6)).a(c.class.getName());
        if (r101 == null) goto L11;
        if (r100 == true) goto L8;
    L10:
        r100 = false;
        goto L11
    L8:
        if (r101.booleanValue() == false) goto L10;
        r100 = true;
    L11:
        f544231a = Boolean.valueOf(r100);
        Log.i("PreloadTaskOptConfig", "isEnablePriority: " + r100);
    L12:
        Boolean r102 = f544231a;
        if (r102 != null) goto L15;
        return false;
    L15:
        return r102.booleanValue();
    }
}
