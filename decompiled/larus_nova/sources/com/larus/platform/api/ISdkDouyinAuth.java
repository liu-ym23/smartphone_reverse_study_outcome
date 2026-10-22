package com.larus.platform.api;

import android.os.Bundle;
import com.larus.login.api.CommonDouYinLoginUtil;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\n\u0010\u0007\u001a\u0004\u0018\u00010\bH&J \u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH&J.\u0010\u000f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u0015H&J8\u0010\u0016\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u0015H&J(\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u001cH&J(\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000eH&J?\u0010\u001e\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u00122\b\b\u0002\u0010!\u001a\u00020\u00122\b\b\u0002\u0010\"\u001a\u00020\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010#H&¢\u0006\u0002\u0010$J*\u0010%\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u00122\b\b\u0002\u0010!\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020&H&J\b\u0010'\u001a\u00020\u0003H&J2\u0010(\u001a\u00020\u00032\b\b\u0002\u0010)\u001a\u00020*2\b\b\u0002\u0010+\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010,H&J\b\u0010-\u001a\u00020\u0003H&J\b\u0010.\u001a\u00020\u0003H&¨\u0006/"}, d2 = {"Lcom/larus/platform/api/ISdkDouyinAuth;", "", "registerAccountBindStatusListener", "", "listener", "Lcom/larus/platform/api/SdkAccountBindStatusListener;", "unregisterAccountBindStatusListener", "getCachedDouyinToken", "Lcom/larus/platform/api/SdkDouyinToken;", "requestDouyinToken", "forceRequestServer", "triggerScene", "Lcom/larus/platform/api/SdkOauthTokenTriggerScene;", "callback", "Lcom/larus/platform/api/SdkDouyinTokenCallback;", "updateDouyinAccountToken", "Lcom/larus/platform/api/SdkAccountTokenUpdateCallback;", "token", "", "isFromDelete", "extraInfo", "Landroid/os/Bundle;", "updateDouyinProviderToken", "enableBindDirect", "bindDouyin", "platformAppId", "platform", "authCode", "Lcom/larus/platform/api/SdkBindCallback;", "updateDouyinAuthorizeInfo", "startDouyinAuth", "clientKey", "scope", "state", "isMiniApplication", "Lcom/larus/platform/api/SdkDouyinAuthCallback;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLcom/larus/platform/api/SdkDouyinAuthCallback;)Ljava/lang/Boolean;", "checkDouyinAuthStatus", "Lcom/larus/platform/api/SdkDouyinAuthStatusCallback;", "isDouyinHeartbeatImplemented", "tryDouyinHeartbeat", "delay", "", "immediate", "Lcom/larus/platform/api/SdkDouyinHeartbeatCallback;", "clearDouyinHeartbeatTokenCache", "hasDouyinHeartbeatSucceeded", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ISdkDouyinAuth {

    public static final class a {
        public static /* synthetic */ boolean a(ISdkDouyinAuth r100, e5 r101, int r102) {
            if ((r102 & 2) == 0) goto L5;
            boolean r103 = false;
        L7:
            if ((r102 & 4) == 0) goto L9;
            SdkOauthTokenTriggerScene r104 = SdkOauthTokenTriggerScene.Request;
        L11:
            if ((r102 & 8) == 0) goto L14;
            r101 = null;
        L14:
            return r100.d(0, r103, r104, r101);
        L9:
            r104 = null;
            goto L11
        L5:
            r103 = true;
            goto L7
        }
    }

    boolean a(boolean r100, SdkOauthTokenTriggerScene r101, h5 r102);

    g5 b();

    boolean c(com.bytedance.applet.impl.w1 r100);

    boolean d(long r100, boolean r101, SdkOauthTokenTriggerScene r102, e5 r103);

    boolean e();

    Boolean f(String r100, String r101, String r102, c5 r103);

    boolean g(String r100, z4 r101);

    boolean h(CommonDouYinLoginUtil.k r100, String r101, boolean r102, Bundle r103);

    boolean i(String r100, String r101, String r102, d5 r103);

    boolean j(String r100, com.larus.login.api.c0 r101);

    boolean k(com.bytedance.applet.aibridge.auth.d r100, String r101, boolean r102, boolean r103, Bundle r104);
}
