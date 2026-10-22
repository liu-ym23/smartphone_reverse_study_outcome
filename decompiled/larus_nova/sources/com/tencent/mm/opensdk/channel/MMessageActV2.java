package com.tencent.mm.opensdk.channel;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.tencent.mm.opensdk.channel.a.a;
import com.tencent.mm.opensdk.constants.Build;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.b;

/* JADX INFO: loaded from: classes40.dex */
public class MMessageActV2 {
    public static final String DEFAULT_ENTRY_CLASS_NAME = ".wxapi.WXEntryActivity";
    public static final String MM_ENTRY_PACKAGE_NAME = "com.tencent.mm";
    public static final String MM_MSG_ENTRY_CLASS_NAME = "com.tencent.mm.plugin.base.stub.WXEntryActivity";
    private static final String TAG = "MicroMsg.SDK.MMessageAct";

    public static class Args {
        public static final int INVALID_FLAGS = -1;
        public Bundle bundle;
        public String content;
        public int flags;
        public int launchMode;
        public String targetClassName;
        public String targetPkgName;
        public String token;

        public Args() {
            this.flags = -1;
            this.launchMode = 2;
        }

        public String toString() {
            return "targetPkgName:" + this.targetPkgName + ", targetClassName:" + this.targetClassName + ", content:" + this.content + ", flags:" + this.flags + ", bundle:" + this.bundle;
        }
    }

    public MMessageActV2() {
    }

    public static boolean send(Context r100, Args r101) {
        if (r100 == null) goto L31;
        if (r101 == null) goto L31;
        if (b.b(r101.targetPkgName) == false) goto L12;
        String r102 = "send fail, invalid targetPkgName, targetPkgName = " + r101.targetPkgName;
    L9:
        Log.e(TAG, r102);
        return false;
    L12:
        if (b.b(r101.targetClassName) == false) goto L14;
        r101.targetClassName = r101.targetPkgName + DEFAULT_ENTRY_CLASS_NAME;
    L14:
        Log.i(TAG, "send, targetPkgName = " + r101.targetPkgName + ", targetClassName = " + r101.targetClassName + ", launchMode = " + r101.launchMode);
        Intent r103 = new Intent();
        r103.setClassName(r101.targetPkgName, r101.targetClassName);
        Bundle r104 = r101.bundle;
        if (r104 == null) goto L17;
        r103.putExtras(r104);
    L17:
        String r105 = r100.getPackageName();
        r103.putExtra(ConstantsAPI.SDK_VERSION, Build.SDK_INT);
        r103.putExtra(ConstantsAPI.APP_PACKAGE, r105);
        r103.putExtra(ConstantsAPI.CONTENT, r101.content);
        r103.putExtra(ConstantsAPI.CHECK_SUM, a.a(r101.content, Build.SDK_INT, r105));
        r103.putExtra(ConstantsAPI.TOKEN, r101.token);
        int r106 = r101.flags;
        if (r106 != (-1)) goto L20;
        r103.addFlags(268435456).addFlags(AMapEngineUtils.HALF_MAX_P20_WIDTH);
    L32:
    L29:
        e = move-exception;
        r102 = "send fail, ex = " + e.getMessage();
        goto L9
    L22:
        if (android.os.Build.VERSION.SDK_INT >= 29) goto L24;
    L26:
        r100.startActivity(r103);     // Catch: Exception -> L29
    L27:
        Log.d(TAG, "send mm message, intent=" + r103);
        return true;
    L24:
        if (r101.launchMode != 2) goto L26;
        sendUsingPendingIntent(r100, r103);     // Catch: Exception -> L29
        goto L27
    L20:
        r103.setFlags(r106);
    L31:
        r102 = "send fail, invalid argument";
        goto L9
    }

    private static void sendUsingPendingIntent(Context r100, Intent r110) {
        Log.i(TAG, "sendUsingPendingIntent");     // Catch: Exception -> L5
        PendingIntent.getActivity(r100, 3, r110, AMapEngineUtils.HALF_MAX_P20_WIDTH).send(r100, 4, null, new AnonymousClass1(), null);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        Log.e(TAG, "sendUsingPendingIntent fail, ex = " + e.getMessage());
        r100.startActivity(r110);
    }
}
