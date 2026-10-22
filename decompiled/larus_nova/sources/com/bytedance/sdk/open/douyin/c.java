package com.bytedance.sdk.open.douyin;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.sdk.open.aweme.common.constants.ParamKeyConstants;
import com.bytedance.sdk.open.aweme.helper.OpenEventHelper;
import com.bytedance.sdk.open.aweme.utils.LogUtils;
import com.bytedance.sdk.open.douyin.model.OpenRecord;

/* JADX INFO: loaded from: classes22.dex */
public class c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f269630b = "OpenRecordImpl";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f269631a;

    public c(String r100) {
        this.f269631a = r100;
    }

    private String a(String r100) {
        return "com.ss.android.ugc.aweme." + r100;
    }

    public void a(Activity r100, String r101, String r102, String r110, OpenRecord.Request r111, String r112, String r113) {
        if (r100 != null) goto L6;
        LogUtils.w(f269630b, new Object[]{"openRecord: activity is null"});
        return;
    L6:
        if (TextUtils.isEmpty(r102) == false) goto L8;
        LogUtils.w(f269630b, new Object[]{"openRecord: remotePackageName is " + r102});
        return;
    L8:
        if (r111 != null) goto L10;
        LogUtils.w(f269630b, new Object[]{"openRecord: request is null"});
        return;
    L10:
        Bundle r103 = new Bundle();
        r111.toBundle(r103);
        r103.putString(ParamKeyConstants.ShareParams.CLIENT_KEY, this.f269631a);
        r103.putString(ParamKeyConstants.ShareParams.CALLER_PKG, r100.getPackageName());
        if (TextUtils.isEmpty(r111.callerLocalEntry) == false) goto L13;
        r103.putString(ParamKeyConstants.ShareParams.CALLER_LOCAL_ENTRY, r100.getPackageName() + "." + r101);
    L13:
        Bundle r104 = r111.extras;
        if (r104 == null) goto L16;
        r103.putBundle(ParamKeyConstants.BaseParams.EXTRA, r104);
    L16:
        r103.putString(ParamKeyConstants.BaseParams.CALLER_BASE_OPEN_SDK_NAME, r112);
        r103.putString(ParamKeyConstants.BaseParams.CALLER_BASE_OPEN_SDK_VERSION, r113);
        Intent r105 = new Intent();
        r105.setComponent(new ComponentName(r102, a(r110)));
        r105.putExtras(r103);
        r105.addFlags(268435456);
        r105.addFlags(32768);
        r100.startActivityForResult(r105, 102);     // Catch: Exception -> L29
        if (TextUtils.equals("com.ss.android.ugc.aweme", r102) == false) goto L21;
        String r106 = "douyin";
    L27:
        OpenEventHelper.mobSdkCallHost(r106, "open_record");     // Catch: Exception -> L29
        return;
    L21:
        if (TextUtils.equals("com.ss.android.ugc.aweme.lite", r102) == false) goto L24;
        r106 = "douyinLite";
        goto L27
    L24:
        if (TextUtils.equals("com.ss.android.ugc.live", r102) == false) goto L26;
        r106 = "dyhts";
        goto L27
    L26:
        r106 = "";
    L29:
        e = move-exception;
        LogUtils.e(f269630b, new Object[]{e});
    }
}
