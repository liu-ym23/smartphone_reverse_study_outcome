package com.bytedance.ee.bear.middleground.drive.rustsdk;

import android.content.ContentResolver;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.ss.android.lark.utils.LarkContext;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class DriveFdGetter {
    private static final String TAG = "DriveFdGetter";

    public DriveFdGetter() {
    }

    public static long getFdWithUri(String r3) {
        long r0 = com_bytedance_ee_bear_middleground_drive_rustsdk_DriveFdGetter_android_content_ContentResolver_openFileDescriptor(LarkContext.getApplication().getContentResolver(), UriProtector.parse(r3), "r").detachFd();     // Catch: Throwable -> L5
    L6:
        tt5.a.h(TAG, "DriveFdGetter getFdWithUri" + r0);
        return r0;
    L5:
        r0 = -1;
        goto L6
    }

    private static ParcelFileDescriptor com_bytedance_ee_bear_middleground_drive_rustsdk_DriveFdGetter_android_content_ContentResolver_openFileDescriptor(ContentResolver r18, Uri r19, String r20) {
        ArrayList r0 = new ArrayList();
        Object[] r1 = {r19, r20};
        f06.b r11 = new f06.b();
        g06.a r2 = (g06.a) ApiHookConfig.b.get(240020);
        if (r2 == null) goto L5;
        f06.a[] r3 = r2.i;
    L6:
        f06.a[] r15 = r3;
        int r9 = r15.length;
        int r8 = 0;
    L8:
        if (r8 >= r9) goto L15;
        f06.a r7 = r15[r8];
        int r16 = r8;
        int r17 = r9;
        f06.d r4 = r7.preInvoke(240020, "android/content/ContentResolver", "openFileDescriptor", r18, r1, "android.os.ParcelFileDescriptor", r11);     // Catch: Exception -> L22
        if (r4.a == true) goto L17;
        r0.add(r7);     // Catch: Exception -> L22
    L17:
        if (r4.a == false) goto L21;
        return (ParcelFileDescriptor) r4.b;
    L21:
        return ContentResolverWrapper.openFileDescriptor(r18, r19, r20);
    L14:
        r8 = r16 + 1;
        r9 = r17;
        goto L8
    L15:
        r4 = new f06.d(false, null);
        goto L17
    L5:
        r3 = ApiHookConfig.d;
        goto L6
    }
}
