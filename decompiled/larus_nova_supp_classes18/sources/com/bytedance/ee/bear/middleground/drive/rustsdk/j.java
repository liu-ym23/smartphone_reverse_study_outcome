package com.bytedance.ee.bear.middleground.drive.rustsdk;

import android.text.TextUtils;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final /* synthetic */ class j implements hu5.b.a {
    public final /* synthetic */ DriveRustPBWrapper a;

    public /* synthetic */ j(DriveRustPBWrapper r1) {
        this.a = r1;
    }

    public final boolean accept(Object r5) {
        String r6 = (String) r5;
        c0 r0 = this.a.b;
        r0.getClass();
        String r1 = e0.c(r6);
        String r2 = e0.b(r6);
        if (TextUtils.isEmpty(r2) == true) goto L12;
        Set r3 = (Set) ((ConcurrentHashMap) r0.a).get(r1);
        if (r3 == null) goto L12;
        Iterator r4 = r3.iterator();
    L8:
        if (r4.hasNext() == false) goto L12;
        if (TextUtils.equals(r2, ((c0.a) r4.next()).b) == true) goto L8;
        boolean r7 = true;
    L13:
        tt5.a.h("Middleground_Drive_DriveUploadStateListener", "hasOtherRegisterToSameTask, taskId: " + r6 + ", res: " + r7);
        return r7;
    L12:
        r7 = false;
        goto L13
    }
}
