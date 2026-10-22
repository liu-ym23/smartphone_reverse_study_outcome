package com.vivo.push.h;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import com.ss.ttvideoengine.DataLoaderHelper;
import com.vivo.push.model.NotifyArriveCallbackByUser;
import com.vivo.push.sdk.PushMessageCallback;
import com.vivo.push.util.NotifyAdapterUtil;
import java.security.PublicKey;
import java.util.HashMap;

/* JADX INFO: loaded from: classes41.dex */
public abstract class ab extends com.vivo.push.s {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected PushMessageCallback f462339b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f462340c;

    public final int b() {
        int r100 = Build.VERSION.SDK_INT;
        if (r100 < 24) goto L24;
        NotificationManager r101 = (NotificationManager) this.f462510a.getSystemService("notification");
        if (r101 == null) goto L11;
        if (r101.areNotificationsEnabled() == true) goto L11;
        return DataLoaderHelper.DATALOADER_KEY_INT_DEV_MEMORY_SIZE_MB;
    L11:
        if (r100 < 26) goto L25;
        if (r101 == null) goto L26;
        NotificationChannel r102 = r101.getNotificationChannel(NotifyAdapterUtil.PRIMARY_CHANNEL);     // Catch: Exception -> L19
        if (r102 == null) goto L27;
        if (r102.getImportance() != 0) goto L28;
        return 2121;
    L28:
        return 0;
    L27:
        return 0;
    L19:
        com.vivo.push.util.t.b("OnVerifyCallBackCommand", "判断通知通道出现系统错误");
        return 0;
    L26:
        return 0;
    L25:
        return 0;
    L24:
        return 0;
    }

    public final int c() {
        return this.f462340c;
    }

    public ab(com.vivo.push.v r100) {
        super(r100);
        this.f462340c = 0;
    }

    public final int a(NotifyArriveCallbackByUser r100) {
        if (r100 != null) goto L7;
        com.vivo.push.util.t.b("OnVerifyCallBackCommand", "pkg name : " + this.f462510a.getPackageName() + " 应用到达回调返回值为空，不做处理");
        com.vivo.push.util.t.b(this.f462510a, "应用到达回调返回值异常，导致通知无法展示，如需打开请在onNotificationMessageArrived中返回正确的对象");
        return 2163;
    L7:
        if (r100.isIntercept() == false) goto L10;
        com.vivo.push.util.t.b("OnVerifyCallBackCommand", "pkg name : " + this.f462510a.getPackageName() + " 应用主动拦截通知");
        com.vivo.push.util.t.b(this.f462510a, "应用主动拦截通知，导致通知无法展示，如需打开请在onNotificationMessageArrived中返回false");
        return 2120;
    L10:
        return 0;
    }

    public final HashMap<String, String> a(long r100) {
        HashMap<String, String> r101 = new HashMap();
        r101.put(com.heytap.mcssdk.constant.b.f276353c, String.valueOf(r100));
        String r102 = com.vivo.push.restructure.a.a().e().a();
        if (TextUtils.isEmpty(r102) == true) goto L5;
        r101.put("remoteAppId", r102);
    L5:
        Context r103 = this.f462510a;
        r101.put("clientsdkver", String.valueOf(com.vivo.push.util.ah.c(r103, r103.getPackageName())));
        return r101;
    }

    public final void a(int r100) {
        this.f462340c = r100;
    }

    public final void a(PushMessageCallback r100) {
        this.f462339b = r100;
    }

    public final boolean a(PublicKey r100, String r101, String r102) {
        if (com.vivo.push.m.a().d() == true) goto L7;
        com.vivo.push.util.t.d("OnVerifyCallBackCommand", "vertify is not support , vertify is ignore");
        return true;
    L7:
        if (r100 != null) goto L11;
        com.vivo.push.util.t.d("OnVerifyCallBackCommand", "vertify key is null");
        return false;
    L11:
        if (TextUtils.isEmpty(r101) == false) goto L15;
        com.vivo.push.util.t.d("OnVerifyCallBackCommand", "contentTag is null");
        return false;
    L15:
        if (TextUtils.isEmpty(r102) == false) goto L27;
        com.vivo.push.util.t.d("OnVerifyCallBackCommand", "vertify id is null");
        return false;
    L27:
        com.vivo.push.util.t.d("OnVerifyCallBackCommand", r101.hashCode() + " = " + r102);     // Catch: Exception -> L22
        if (com.vivo.push.util.ab.a(r101.getBytes("UTF-8"), r100, Base64.decode(r102, 2)) == false) goto L20;
        com.vivo.push.util.t.d("OnVerifyCallBackCommand", "vertify id is success");     // Catch: Exception -> L22
        return true;
    L20:
        com.vivo.push.util.t.d("OnVerifyCallBackCommand", "vertify fail srcDigest is ".concat(r101));     // Catch: Exception -> L22
        com.vivo.push.util.t.c(this.f462510a, "vertify fail srcDigest is ".concat(r101));     // Catch: Exception -> L22
        return false;
    L22:
        e = move-exception;
        e.printStackTrace();
        com.vivo.push.util.t.d("OnVerifyCallBackCommand", "vertify exception");
        return false;
    }
}
