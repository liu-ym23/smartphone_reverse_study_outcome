package com.xiaomi.mipush.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.os.IBinder;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import com.xiaomi.push.ds;
import com.xiaomi.push.ec;
import com.xiaomi.push.gi;
import com.xiaomi.push.ho;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes41.dex */
public class PushMessageHandler extends BaseService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static List<MiPushClient.ICallbackResult> f463042a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static ThreadPoolExecutor f160a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static List<MiPushClient.MiPushClientCallback> f463043b;

    public interface a extends Serializable {
    }

    @Override // com.xiaomi.mipush.sdk.BaseService, android.app.Service
    public IBinder onBind(Intent r100) {
        return null;
    }

    static {
        f463042a = new ArrayList();
        f463043b = new ArrayList();
        f160a = new PThreadPoolExecutor(1, 1, 15, TimeUnit.SECONDS, new LinkedBlockingQueue(), new DefaultThreadFactory("PushMessageHandler"));
    }

    public static void b() {
        List<MiPushClient.ICallbackResult> r100 = f463042a;
        monitor-enter(r100);
        f463042a.clear();     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.xiaomi.mipush.sdk.BaseService
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean mo8742a() {
        ThreadPoolExecutor r100 = f160a;
        if (r100 != null) goto L5;
    L9:
        return false;
    L5:
        if (r100.getQueue() == null) goto L9;
        if (f160a.getQueue().size() <= 0) goto L9;
        return true;
    }

    public PushMessageHandler() {
    }

    public static void a() {
        List<MiPushClient.MiPushClientCallback> r100 = f463043b;
        monitor-enter(r100);
        f463043b.clear();     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public static boolean m8741b() {
        return f463043b.isEmpty();
    }

    public static void a(Context r100) {
        Intent r101 = new Intent();
        r101.setComponent(new ComponentName(r100, PushMessageHandler.class));
        r100.startService(r101);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        com.xiaomi.channel.commonutils.logger.b.m8719a("PushMessageHandler", e.getMessage());
    }

    private static void b(Context r100) {
        Intent r101 = new Intent();     // Catch: Exception -> L4
        r101.setPackage(r100.getPackageName());     // Catch: Exception -> L4
        r101.setAction("action_clicked_activity_finish");     // Catch: Exception -> L4
        r100.sendBroadcast(r101, c.a(r100));     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        com.xiaomi.channel.commonutils.logger.b.m8719a("PushMessageHandler", "callback sync error" + e);
    }

    public static void a(MiPushClient.ICallbackResult r100) {
        List<MiPushClient.ICallbackResult> r101 = f463042a;
        monitor-enter(r101);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (f463042a.contains(r100) == true) goto L7;
        f463042a.add(r100);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r101);     // Catch: Throwable -> L9
    }

    public static void a(MiPushClient.MiPushClientCallback r100) {
        List<MiPushClient.MiPushClientCallback> r101 = f463043b;
        monitor-enter(r101);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (f463043b.contains(r100) == true) goto L7;
        f463043b.add(r100);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r101);     // Catch: Throwable -> L9
    }

    public static void a(Context r110, a r111) {
        if ((r111 instanceof MiPushMessage) == false) goto L6;
        a(r110, (MiPushMessage) r111);
        return;
    L6:
        if ((r111 instanceof MiPushCommandMessage) == false) goto L41;
        MiPushCommandMessage r112 = (MiPushCommandMessage) r111;
        String r100 = r112.getCommand();
        String r101 = null;
        if (ec.f463424a.f477a.equals(r100) == false) goto L16;
        List<String> r113 = r112.getCommandArguments();
        if (r113 != null) goto L12;
    L14:
        a(r112.getResultCode(), r112.getReason(), r101);
        return;
    L12:
        if (r113.isEmpty() == true) goto L14;
        r101 = (String) ListProtector.get(r113, 0);
        goto L14
    L16:
        if (ec.f463426c.f477a.equals(r100) == false) goto L18;
    L38:
        a(r110, r112.getCategory(), r100, r112.getResultCode(), r112.getReason(), r112.getCommandArguments());
        return;
    L18:
        if (ec.f463427d.f477a.equals(r100) == true) goto L38;
        if (ec.f463432i.f477a.equals(r100) == true) goto L38;
        if (ec.f463430g.f477a.equals(r100) == false) goto L31;
        List<String> r102 = r112.getCommandArguments();
        if (r102 != null) goto L27;
    L29:
        String r103 = r112.getCategory();
        long r104 = r112.getResultCode();
        String r105 = r112.getReason();
        a(r110, r103, r104, r105, r101);
        return;
    L27:
        if (r102.isEmpty() == true) goto L29;
        r101 = (String) ListProtector.get(r102, 0);
        goto L29
    L31:
        if (ec.f463431h.f477a.equals(r100) == false) goto L44;
        List<String> r106 = r112.getCommandArguments();
        if (r106 != null) goto L35;
    L37:
        String r107 = r112.getCategory();
        long r108 = r112.getResultCode();
        String r109 = r112.getReason();
        b(r110, r107, r108, r109, r101);
        return;
    L35:
        if (r106.isEmpty() == true) goto L37;
        r101 = (String) ListProtector.get(r106, 0);
        goto L37
    L44:
        return;
    }

    public static void b(Context r100, Intent r101) {
        boolean r102 = r101.getBooleanExtra("is_clicked_activity_call", false);     // Catch: Throwable -> L5
    L58:
        com.xiaomi.channel.commonutils.logger.b.m8720a("PushMessageHandler", new Object[]{"-->onHandleIntent(): action=", r101.getAction()});     // Catch: Throwable -> L48
        if ("com.xiaomi.mipush.SEND_TINYDATA".equals(r101.getAction()) == false) goto L12;
        gi r103 = new gi();     // Catch: Throwable -> L48
        ho.a(r103, r101.getByteArrayExtra("mipush_payload"));     // Catch: Throwable -> L48
        com.xiaomi.channel.commonutils.logger.b.m8723b("PushMessageHandler", "PushMessageHandler.onHandleIntent " + r103.d());     // Catch: Throwable -> L48
        MiTinyDataClient.upload(r100, r103);     // Catch: Throwable -> L48
    L46:
        if (r102 == false) goto L72;
    L51:
        b(r100);
        return;
    L72:
        return;
    L12:
        if (1 != PushMessageHelper.getPushMode(r100)) goto L23;
        if (m8741b() == false) goto L19;
        com.xiaomi.channel.commonutils.logger.b.c("PushMessageHandler", "receive a message before application calling initialize");     // Catch: Throwable -> L48
        if (r102 == false) goto L71;
        b(r100);
        return;
    L71:
        return;
    L19:
        a r104 = t.a(r100).a(r101);     // Catch: Throwable -> L48
        if (r104 == null) goto L46;
        a(r100, r104);     // Catch: Throwable -> L48
        goto L46
    L23:
        if ("com.xiaomi.mipush.sdk.SYNC_LOG".equals(r101.getAction()) == true) goto L46;
        Intent r105 = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");     // Catch: Throwable -> L48
        r105.setPackage(r100.getPackageName());     // Catch: Throwable -> L48
        r105.putExtras(r101);     // Catch: Throwable -> L48
        List<ResolveInfo> r106 = r100.getPackageManager().queryBroadcastReceivers(r105, 32);     // Catch: Exception -> L44 Throwable -> L48
        if (r106 == null) goto L39;
        Iterator<ResolveInfo> r107 = r106.iterator();     // Catch: Exception -> L44 Throwable -> L48
    L31:
        if (r107.hasNext() == false) goto L39;
        ResolveInfo r108 = r107.next();     // Catch: Exception -> L44 Throwable -> L48
        ActivityInfo r109 = r108.activityInfo;     // Catch: Exception -> L44 Throwable -> L48
        if (r109 == null) goto L31;
        if (r109.packageName.equals(r100.getPackageName()) == false) goto L31;
        if (PushMessageReceiver.class.isAssignableFrom(com.xiaomi.push.q.a(r100, r108.activityInfo.name)) == false) goto L31;
    L40:
        if (r108 == null) goto L42;
        a(r100, r105, r108, r102);     // Catch: Exception -> L44 Throwable -> L48
        goto L46
    L42:
        com.xiaomi.channel.commonutils.logger.b.c("PushMessageHandler", "cannot find the receiver to handler this message, check your manifest");     // Catch: Exception -> L44 Throwable -> L48
        ds.a(r100).a(r100.getPackageName(), r101, "11");     // Catch: Exception -> L44 Throwable -> L48
    L39:
        r108 = null;
    L44:
        e = move-exception;
        com.xiaomi.channel.commonutils.logger.b.a("PushMessageHandler", e);     // Catch: Throwable -> L48
        ds.a(r100).a(r100.getPackageName(), r101, com.tencent.connect.common.Constants.VIA_SHARE_TYPE_MINI_PROGRAM);     // Catch: Throwable -> L48
    L48:
        th = move-exception;
        com.xiaomi.channel.commonutils.logger.b.a("PushMessageHandler", th);     // Catch: Throwable -> L53
        ds.a(r100).a(r100.getPackageName(), r101, com.tencent.connect.common.Constants.VIA_REPORT_TYPE_SHARE_TO_QQ);     // Catch: Throwable -> L53
        if (r102 == true) goto L51;
        return;
    L53:
        th = move-exception;
        if (r102 == false) goto L56;
        b(r100);
    L56:
        throw th;
    L5:
        th = move-exception;
        com.xiaomi.channel.commonutils.logger.b.m8719a("PushMessageHandler", "intent unparcel error:" + th);
        r102 = false;
        goto L58
    }

    private static void c(final Context r100, final Intent r101) {
        if (r101 == null) goto L7;
        if (f160a.isShutdown() == true) goto L7;
        f160a.execute(new AnonymousClass1(r100, r101));
        return;
    L7:
        if (r101 != null) goto L9;
        String r102 = "0";
    L10:
        com.xiaomi.channel.commonutils.logger.b.d("PushMessageHandler", "-->scheduleJob() fail, case".concat(r102));
        return;
    L9:
        r102 = "1";
        goto L10
    }

    @Override // com.xiaomi.mipush.sdk.BaseService, android.app.Service
    public void onStart(Intent r100, int r101) {
        super.onStart(r100, r101);
        c(getApplicationContext(), r100);
    }

    public static void a(Context r100, MiPushCommandMessage r101) {
        List<MiPushClient.ICallbackResult> r102 = f463042a;
        monitor-enter(r102);
        Iterator<MiPushClient.ICallbackResult> r103 = f463042a.iterator();     // Catch: Throwable -> L19
    L6:
        if (r103.hasNext() == false) goto L17;
        MiPushClient.ICallbackResult r104 = r103.next();     // Catch: Throwable -> L19
        if ((r104 instanceof MiPushClient.UPSRegisterCallBack) == false) goto L6;
        MiPushClient.TokenResult r105 = new MiPushClient.TokenResult();     // Catch: Throwable -> L19
        if (r101 != null) goto L12;
    L16:
        r104.onResult(r105);     // Catch: Throwable -> L19
        goto L6
    L12:
        if (r101.getCommandArguments() == null) goto L16;
        if (r101.getCommandArguments().size() <= 0) goto L16;
        r105.setResultCode(r101.getResultCode());     // Catch: Throwable -> L19
        r105.setToken(r101.getCommandArguments().get(0));     // Catch: Throwable -> L19
        goto L16
    L17:
        monitor-exit(r102);     // Catch: Throwable -> L19
        return;
    L19:
        th = move-exception;
        throw th;
    }

    public static void a(Context r100, MiPushMessage r101) {
        List<MiPushClient.MiPushClientCallback> r102 = f463043b;
        monitor-enter(r102);
        Iterator<MiPushClient.MiPushClientCallback> r103 = f463043b.iterator();     // Catch: Throwable -> L12
    L6:
        if (r103.hasNext() == false) goto L10;
        MiPushClient.MiPushClientCallback r104 = r103.next();     // Catch: Throwable -> L12
        if (a(r101.getCategory(), r104.getCategory()) == false) goto L6;
        r104.onReceiveMessage(r101.getContent(), r101.getAlias(), r101.getTopic(), r101.isNotified());     // Catch: Throwable -> L12
        r104.onReceiveMessage(r101);     // Catch: Throwable -> L12
        goto L6
    L10:
        monitor-exit(r102);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public static void a(Context r100, Intent r101) {
        com.xiaomi.channel.commonutils.logger.b.m8723b("PushMessageHandler", "addjob PushMessageHandler " + r101);
        if (r101 == null) goto L6;
        c(r100, r101);
        a(r100);
        return;
    }

    public static boolean a(String r100, String r101) {
        if (TextUtils.isEmpty(r100) == false) goto L7;
        if (TextUtils.isEmpty(r101) == false) goto L7;
    L8:
        return true;
    L7:
        if (TextUtils.equals(r100, r101) == true) goto L8;
        return false;
    }

    public static void a(long r100, String r101, String r102) {
        List<MiPushClient.MiPushClientCallback> r103 = f463043b;
        monitor-enter(r103);
        Iterator<MiPushClient.MiPushClientCallback> r104 = f463043b.iterator();     // Catch: Throwable -> L10
    L6:
        if (r104.hasNext() == false) goto L8;
        r104.next().onInitializeResult(r100, r101, r102);     // Catch: Throwable -> L10
        goto L6
    L8:
        monitor-exit(r103);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private static void a(Context r100, Intent r101, ResolveInfo r102, boolean r103) {
        MessageHandleService.a r104 = new MessageHandleService.a(r101, (PushMessageReceiver) com.xiaomi.push.q.a(r100, r102.activityInfo.name).newInstance());     // Catch: Throwable -> L8
        if (r103 == false) goto L5;
        MessageHandleService.a(r100.getApplicationContext(), r104);     // Catch: Throwable -> L8
    L6:
        MessageHandleService.a(r100, new Intent(r100.getApplicationContext(), MessageHandleService.class));     // Catch: Throwable -> L8
        return;
    L5:
        MessageHandleService.addJob(r100.getApplicationContext(), r104);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        com.xiaomi.channel.commonutils.logger.b.a(th);
    }

    public static void a(Context r100, String r101, long r102, String r103, String r104) {
        List<MiPushClient.MiPushClientCallback> r105 = f463043b;
        monitor-enter(r105);
        Iterator<MiPushClient.MiPushClientCallback> r106 = f463043b.iterator();     // Catch: Throwable -> L12
    L6:
        if (r106.hasNext() == false) goto L10;
        MiPushClient.MiPushClientCallback r107 = r106.next();     // Catch: Throwable -> L12
        if (a(r101, r107.getCategory()) == false) goto L6;
        r107.onSubscribeResult(r102, r103, r104);     // Catch: Throwable -> L12
        goto L6
    L10:
        monitor-exit(r105);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public static void b(Context r100, String r101, long r102, String r103, String r104) {
        List<MiPushClient.MiPushClientCallback> r105 = f463043b;
        monitor-enter(r105);
        Iterator<MiPushClient.MiPushClientCallback> r106 = f463043b.iterator();     // Catch: Throwable -> L12
    L6:
        if (r106.hasNext() == false) goto L10;
        MiPushClient.MiPushClientCallback r107 = r106.next();     // Catch: Throwable -> L12
        if (a(r101, r107.getCategory()) == false) goto L6;
        r107.onUnsubscribeResult(r102, r103, r104);     // Catch: Throwable -> L12
        goto L6
    L10:
        monitor-exit(r105);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public static void a(Context r100, String r101, String r110, long r111, String r112, List<String> r113) {
        List<MiPushClient.MiPushClientCallback> r102 = f463043b;
        monitor-enter(r102);
        Iterator<MiPushClient.MiPushClientCallback> r103 = f463043b.iterator();     // Catch: Throwable -> L12
    L6:
        if (r103.hasNext() == false) goto L10;
        MiPushClient.MiPushClientCallback r104 = r103.next();     // Catch: Throwable -> L12
        if (a(r101, r104.getCategory()) == false) goto L6;
        r104.onCommandResult(r110, r111, r112, r113);     // Catch: Throwable -> L12
        goto L6
    L10:
        monitor-exit(r102);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }
}
