package com.vivo.push.h;

import android.content.Context;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.vivo.push.model.InsideNotificationItem;
import com.vivo.push.model.NotifyArriveCallbackByUser;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes41.dex */
final class v implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ InsideNotificationItem f462375a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ com.vivo.push.b.q f462376b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ boolean f462377c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ u f462378d;

    @Override // java.lang.Runnable
    public final void run() {
        com_vivo_push_h_v_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    public final void com_vivo_push_h_v__run$___twin___() {
        if (this.f462375a.isNoShowOnForeground() == false) goto L7;
        com.vivo.push.util.t.d("OnNotificationArrivedTask", "msg " + this.f462375a.getMsgId() + " no show on foreground");
        this.f462378d.f462339b.onForegroundMessageArrived(com.vivo.push.util.u.a(this.f462375a));
        return;
    L7:
        if (this.f462375a.isAppInstallCompleteMsg() == false) goto L10;
        com.vivo.push.util.t.d("OnNotificationArrivedTask", "msg " + this.f462375a.getMsgId() + " notify app install");
        this.f462378d.f462339b.onAppInstallCompleteShowMsg(this.f462375a.getThirdPackageName());
        return;
    L10:
        u r100 = this.f462378d;
        NotifyArriveCallbackByUser r110 = r100.f462339b.onNotificationMessageArrived(u.a(r100), com.vivo.push.util.u.a(this.f462375a));
        int r101 = this.f462378d.a(r110);
        if (r101 <= 0) goto L14;
        com.vivo.push.util.f.a(r101, this.f462378d.a(this.f462376b.h()));
        return;
    L14:
        int r102 = this.f462378d.b();
        if (r102 <= 0) goto L19;
        com.vivo.push.util.t.b("OnNotificationArrivedTask", "pkg name : " + u.b(this.f462378d).getPackageName() + " notify channel switch is " + r102);
        com.vivo.push.util.t.b(u.c(this.f462378d), "允许通知开关或者推送通知渠道开关关闭，导致通知无法展示，请到设置页打开应用通知开关 ".concat(String.valueOf(r102)));
        com.vivo.push.util.f.a((long) r102, this.f462378d.a(this.f462376b.h()));
        return;
    L19:
        if (this.f462377c == true) goto L21;
    L26:
        Context r103 = u.e(this.f462378d);
        InsideNotificationItem r104 = this.f462375a;
        long r105 = this.f462376b.h();
        u r106 = this.f462378d;
        com.vivo.push.util.o r107 = new com.vivo.push.util.o(r103, r104, r105, r106.f462339b.isAllowNet(u.f(r106)), new w(this), r110);
        boolean r108 = this.f462375a.isShowBigPicOnMobileNet();
        String r109 = this.f462375a.getPurePicUrl();
        if (TextUtils.isEmpty(r109) == false) goto L30;
        r109 = this.f462375a.getCoverUrl();
    L30:
        if (TextUtils.isEmpty(r109) == true) goto L48;
        com.vivo.push.util.t.c("OnNotificationArrivedTask", "showCode=".concat(String.valueOf(r108)));
        if (r108 == true) goto L47;
        com.vivo.push.util.t.a(u.g(this.f462378d), "mobile net unshow");
        NetworkInfo r111 = com.vivo.push.util.x.a(u.h(this.f462378d));
        if (r111 != null) goto L37;
    L35:
        char r112 = 0;
    L45:
        if (r112 != 1) goto L48;
        this.f462375a.clearCoverUrl();
        this.f462375a.clearPurePicUrl();
        r109 = null;
        goto L48
    L37:
        if (r111.getState() != NetworkInfo.State.CONNECTED) goto L35;
        int r113 = r111.getType();
        if (r113 != 1) goto L42;
        r112 = 2;
        goto L45
    L42:
        if (r113 != 0) goto L44;
        r112 = 1;
        goto L45
    L44:
        r112 = 3;
        goto L45
    L47:
        com.vivo.push.util.t.a(u.i(this.f462378d), "mobile net show");
    L48:
        r107.execute1(new String[]{this.f462375a.getIconUrl(), r109});
        return;
    L21:
        if (this.f462375a.isOperateMsg() == false) goto L26;
        if (com.vivo.push.util.ai.a().a(this.f462375a.getWindowPeriod()) == true) goto L26;
        com.vivo.push.util.f.a(1017, this.f462378d.a(this.f462376b.h()));
        com.vivo.push.util.t.b(u.d(this.f462378d), "内部运营消息不在窗口期内，不做展示");
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void com_vivo_push_h_v_com_larus_apm_impl_protector_RunnableLancet_run(v r100) {
        r100.com_vivo_push_h_v__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public v(u r100, InsideNotificationItem r101, com.vivo.push.b.q r102, boolean r103) {
        this.f462378d = r100;
        this.f462375a = r101;
        this.f462376b = r102;
        this.f462377c = r103;
    }
}
