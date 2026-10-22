package com.bytedance.lego.init.util;

import com.bytedance.lego.init.InitScheduler;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    public c() {
    }

    static {
    }

    public static /* synthetic */ void b(String r1) {
        a(XmlPullParser.NO_NAMESPACE, r1);
    }

    public static void a(String r5, String r6) {
        if (InitScheduler.INSTANCE.isDebug$initscheduler_release() == true) goto L5;
        return;
    L5:
        String r7 = r5 + ' ' + r6;
        int r8 = r7.length();
        int r0 = 3072;
        int r1 = 1;
        int r2 = 0;
    L7:
        if (r1 > 100) goto L14;
        if (r8 <= r0) goto L10;
        r7.substring(r2, r0);
        r1 = r1 + 1;
        r2 = r0;
        r0 = r0 + 3072;
        goto L7
    L10:
        r7.substring(r2, r8);
        return;
    }

    public static void c(String r5, String r6) {
        if (InitScheduler.INSTANCE.isDebug$initscheduler_release() == true) goto L5;
        return;
    L5:
        String r7 = r5 + ' ' + r6;
        int r8 = r7.length();
        int r0 = 3072;
        int r1 = 1;
        int r2 = 0;
    L7:
        if (r1 > 100) goto L14;
        if (r8 <= r0) goto L10;
        r7.substring(r2, r0);
        r1 = r1 + 1;
        r2 = r0;
        r0 = r0 + 3072;
        goto L7
    L10:
        r7.substring(r2, r8);
        return;
    }
}
