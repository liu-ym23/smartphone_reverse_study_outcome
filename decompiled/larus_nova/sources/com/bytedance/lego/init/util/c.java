package com.bytedance.lego.init.util;

import com.bytedance.lego.init.InitScheduler;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f254571a = 0;

    public c() {
    }

    static {
    }

    public static /* synthetic */ void b(String r100) {
        a("", r100);
    }

    public static void a(String r100, String r101) {
        if (InitScheduler.INSTANCE.isDebug$initscheduler_release() == true) goto L5;
        return;
    L5:
        String r102 = r100 + ' ' + r101;
        int r103 = r102.length();
        int r104 = 3072;
        int r105 = 1;
        int r106 = 0;
    L7:
        if (r105 > 100) goto L14;
        if (r103 <= r104) goto L10;
        r102.substring(r106, r104);
        r105 = r105 + 1;
        r106 = r104;
        r104 = r104 + 3072;
        goto L7
    L10:
        r102.substring(r106, r103);
        return;
    }

    public static void c(String r100, String r101) {
        if (InitScheduler.INSTANCE.isDebug$initscheduler_release() == true) goto L5;
        return;
    L5:
        String r102 = r100 + ' ' + r101;
        int r103 = r102.length();
        int r104 = 3072;
        int r105 = 1;
        int r106 = 0;
    L7:
        if (r105 > 100) goto L14;
        if (r103 <= r104) goto L10;
        r102.substring(r106, r104);
        r105 = r105 + 1;
        r106 = r104;
        r104 = r104 + 3072;
        goto L7
    L10:
        r102.substring(r106, r103);
        return;
    }
}
