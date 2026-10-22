package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import java.util.Map;

/* JADX INFO: loaded from: classes41.dex */
public class FTOSPushHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static long f463029a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static volatile boolean f145a;

    public FTOSPushHelper() {
    }

    public static boolean getNeedRegister() {
        return f145a;
    }

    private static void a(Context r100) {
        AbstractPushManager r101 = e.a(r100).a(d.f463058d);
        if (r101 == null) goto L6;
        com.xiaomi.channel.commonutils.logger.b.m8718a("ASSEMBLE_PUSH :  register fun touch os when network change!");
        r101.register();
        return;
    }

    public static void doInNetworkChange(Context r100) {
        long r101 = SystemClock.elapsedRealtime();
        if (getNeedRegister() == false) goto L10;
        long r102 = f463029a;
        if (r102 > 0) goto L7;
    L8:
        f463029a = r101;
        a(r100);
        return;
    L7:
        if ((r102 + 300000) <= r101) goto L8;
        return;
    }

    public static boolean hasNetwork(Context r100) {
        return f.m8766a(r100);
    }

    public static void setNeedRegister(boolean r100) {
        f145a = r100;
    }

    public static void notifyFTOSNotificationClicked(Context r100, Map<String, String> r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        if (r101.containsKey(WikiFolderPushPlugin.PUSH_MSG) == false) goto L18;
        String r102 = r101.get(WikiFolderPushPlugin.PUSH_MSG);
        if (TextUtils.isEmpty(r102) == true) goto L16;
        PushMessageReceiver r103 = f.a(r100);
        if (r103 == null) goto L17;
        MiPushMessage r104 = f.a(r102);
        if (r104.getExtra().containsKey("notify_effect") == false) goto L13;
        return;
    L13:
        r103.onNotificationMessageClicked(r100, r104);
        return;
    L17:
        return;
    L16:
        return;
    }

    public static void uploadToken(Context r100, String r101) {
        f.m8765a(r100, d.f463058d, r101);
    }
}
