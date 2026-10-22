package com.bytedance.ee.bear.middleground.drive.rustsdk;

import android.content.ContentResolver;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.ss.android.lark.utils.LarkContext;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes18.dex */
public class DriveFdGetter {
    private static final String TAG = "DriveFdGetter";

    public DriveFdGetter() {
    }

    public static long getFdWithUri(String r100) {
        long r101 = com_bytedance_ee_bear_middleground_drive_rustsdk_DriveFdGetter_android_content_ContentResolver_openFileDescriptor(LarkContext.getApplication().getContentResolver(), UriProtector.parse(r100), "r").detachFd();     // Catch: Throwable -> L5
    L6:
        tt5.a.h(TAG, "DriveFdGetter getFdWithUri" + r101);
        return r101;
    L5:
        r101 = -1;
        goto L6
    }

    private static ParcelFileDescriptor com_bytedance_ee_bear_middleground_drive_rustsdk_DriveFdGetter_android_content_ContentResolver_openFileDescriptor(ContentResolver r110, Uri r111, String r210) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r111, r210};
        f06.b r112 = new f06.b();
        g06.a r102 = ApiHookConfig.f245611b.get(240020);
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r113 = r103;
        int r104 = r113.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L15;
        f06.a r106 = r113[r105];
        int r114 = r105;
        int r115 = r104;
        f06.d r107 = r106.preInvoke(240020, "android/content/ContentResolver", "openFileDescriptor", r110, r101, "android.os.ParcelFileDescriptor", r112);     // Catch: Exception -> L22
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L22
    L17:
        if (r107.f474982a == false) goto L21;
        return (ParcelFileDescriptor) r107.f474983b;
    L21:
        return ContentResolverWrapper.openFileDescriptor(r110, r111, r210);
    L14:
        r105 = r114 + 1;
        r104 = r115;
        goto L8
    L15:
        r107 = new f06.d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }
}
