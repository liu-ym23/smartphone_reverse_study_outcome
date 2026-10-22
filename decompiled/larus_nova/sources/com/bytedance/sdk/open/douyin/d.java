package com.bytedance.sdk.open.douyin;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.sdk.open.aweme.helper.OpenEventHelper;
import com.bytedance.sdk.open.aweme.utils.LogUtils;

/* JADX INFO: loaded from: classes22.dex */
public class d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f269632b = "ShareToContactImpl";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f269633a;

    public d(String r100) {
        this.f269633a = r100;
    }

    private String a(String r100) {
        return "com.ss.android.ugc.aweme." + r100;
    }

    public boolean a(Activity r100, String r101, String r102, String r103, ShareToContact.Request r104) {
        if (r100 != null) goto L6;
        LogUtils.w(f269632b, new Object[]{"shareToContacts: activity is null"});
    L13:
        return false;
    L6:
        if (TextUtils.isEmpty(r102) == false) goto L8;
        LogUtils.w(f269632b, new Object[]{"shareToContacts: remotePackageName is " + r102});
        goto L13
    L8:
        if (r104 != null) goto L11;
        LogUtils.w(f269632b, new Object[]{"shareToContacts: request is null"});
        goto L13
    L11:
        if (r104.checkArgs() == true) goto L14;
        LogUtils.w(f269632b, new Object[]{"shareToContacts: checkArgs fail"});
        goto L13
    L14:
        Bundle r105 = new Bundle();
        r104.toBundle(r105);
        r105.putString(com.bytedance.sdk.open.tt.b.a.f269779c, this.f269633a);
        if (TextUtils.isEmpty(r104.callerLocalEntry) == false) goto L17;
        r105.putString(com.bytedance.sdk.open.tt.b.a.f269789m, r100.getPackageName() + "." + r101);
    L17:
        Bundle r106 = r104.extras;
        if (r106 == null) goto L20;
        r105.putBundle(com.bytedance.sdk.open.tt.b.a.f269781e, r106);
    L20:
        Intent r107 = new Intent();
        r107.setComponent(new ComponentName(r102, a(r103)));
        r107.putExtras(r105);
        r107.addFlags(32768);
        r100.startActivityForResult(r107, 101);
        if (TextUtils.equals("com.ss.android.ugc.aweme", r102) == false) goto L24;
        String r108 = "douyin";
    L30:
        OpenEventHelper.mobSdkCallHost(r108, "im");
        return true;
    L24:
        if (TextUtils.equals("com.ss.android.ugc.aweme.lite", r102) == false) goto L27;
        r108 = "douyinLite";
        goto L30
    L27:
        if (TextUtils.equals("com.ss.android.ugc.live", r102) == false) goto L29;
        r108 = "dyhts";
        goto L30
    L29:
        r108 = "";
        goto L30
    }
}
