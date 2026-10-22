package com.xiaomi.mipush.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import com.xiaomi.push.ad;
import com.xiaomi.push.ds;
import com.xiaomi.push.ec;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes41.dex */
public class MessageHandleService extends BaseService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static ConcurrentLinkedQueue<a> f463031a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static ExecutorService f146a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Intent f463034a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private PushMessageReceiver f148a;

        public Intent a() {
            return this.f463034a;
        }

        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        public PushMessageReceiver m8736a() {
            return this.f148a;
        }

        public a(Intent r100, PushMessageReceiver r101) {
            this.f148a = r101;
            this.f463034a = r100;
        }
    }

    @Override // com.xiaomi.mipush.sdk.BaseService, android.app.Service
    public IBinder onBind(Intent r100) {
        return null;
    }

    static {
        f463031a = new ConcurrentLinkedQueue();
        f146a = new PThreadPoolExecutor(1, 1, 15, TimeUnit.SECONDS, new LinkedBlockingQueue(), new DefaultThreadFactory("MessageHandleService"));
    }

    @Override // com.xiaomi.mipush.sdk.BaseService
    /* JADX INFO: renamed from: a */
    public boolean mo8742a() {
        ConcurrentLinkedQueue<a> r100 = f463031a;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.size() <= 0) goto L7;
        return true;
    }

    public MessageHandleService() {
    }

    public static /* synthetic */ void a(Context r100) {
        c(r100);
    }

    private static void b(final Context r100) {
        if (f146a.isShutdown() == true) goto L6;
        f146a.execute(new AnonymousClass2(r100));
        return;
    }

    private static void c(Context r100) {
        a(r100, f463031a.poll());     // Catch: RuntimeException -> L4
        return;
    L4:
        e = move-exception;
        com.xiaomi.channel.commonutils.logger.b.a(e);
    }

    public static void startService(final Context r100) {
        final Intent r101 = new Intent();
        r101.setComponent(new ComponentName(r100, MessageHandleService.class));
        ad.a(r100).a(new AnonymousClass1(r100, r101));
    }

    public static void a(Context r110, a r111) {
        if (r111 != null) goto L54;
        return;
    L54:
        PushMessageReceiver r100 = r111.m8736a();     // Catch: RuntimeException -> L51
        Intent r101 = r111.a();     // Catch: RuntimeException -> L51
        int r112 = r101.getIntExtra("message_type", 1);     // Catch: RuntimeException -> L51
        if (r112 != 1) goto L9;
        PushMessageHandler.a r102 = t.a(r110).a(r101);     // Catch: RuntimeException -> L51
        int r113 = r101.getIntExtra("eventMessageType", -1);     // Catch: RuntimeException -> L51
        if (r102 != null) goto L26;
        com.xiaomi.channel.commonutils.logger.b.d("MessageHandleService", "no message from raw for receiver");     // Catch: RuntimeException -> L51
        return;
    L26:
        if ((r102 instanceof MiPushMessage) == false) goto L42;
        MiPushMessage r103 = (MiPushMessage) r102;     // Catch: RuntimeException -> L51
        if (r103.isArrivedMessage() == true) goto L31;
        r100.onReceiveMessage(r110, r103);     // Catch: RuntimeException -> L51
    L31:
        if (r103.getPassThrough() != 1) goto L34;
        ds.a(r110.getApplicationContext()).a(r110.getPackageName(), r101, 2004, null);     // Catch: RuntimeException -> L51
        com.xiaomi.channel.commonutils.logger.b.d("MessageHandleService", "begin execute onReceivePassThroughMessage from " + r103.getMessageId());     // Catch: RuntimeException -> L51
        r100.onReceivePassThroughMessage(r110, r103);     // Catch: RuntimeException -> L51
        return;
    L34:
        if (r103.isNotified() == true) goto L36;
        com.xiaomi.channel.commonutils.logger.b.d("MessageHandleService", "begin execute onNotificationMessageArrived from " + r103.getMessageId());     // Catch: RuntimeException -> L51
        r100.onNotificationMessageArrived(r110, r103);     // Catch: RuntimeException -> L51
        return;
    L36:
        if (r113 != 1000) goto L38;
        ds.a(r110.getApplicationContext()).a(r110.getPackageName(), r101, 1007, null);     // Catch: RuntimeException -> L51
    L39:
        com.xiaomi.channel.commonutils.logger.b.d("MessageHandleService", "begin execute onNotificationMessageClicked from\u3000" + r103.getMessageId());     // Catch: RuntimeException -> L51
        r100.onNotificationMessageClicked(r110, r103);     // Catch: RuntimeException -> L51
        return;
    L38:
        ds.a(r110.getApplicationContext()).a(r110.getPackageName(), r101, 3007, null);     // Catch: RuntimeException -> L51
        goto L39
    L42:
        if ((r102 instanceof MiPushCommandMessage) == false) goto L48;
        MiPushCommandMessage r104 = (MiPushCommandMessage) r102;     // Catch: RuntimeException -> L51
        com.xiaomi.channel.commonutils.logger.b.d("MessageHandleService", "begin execute onCommandResult, command=" + r104.getCommand() + ", resultCode=" + r104.getResultCode() + ", reason=" + r104.getReason());     // Catch: RuntimeException -> L51
        r100.onCommandResult(r110, r104);     // Catch: RuntimeException -> L51
        if (TextUtils.equals(r104.getCommand(), ec.f463424a.f477a) == false) goto L64;
        r100.onReceiveRegisterResult(r110, r104);     // Catch: RuntimeException -> L51
        PushMessageHandler.a(r110, r104);     // Catch: RuntimeException -> L51
        if (r104.getResultCode() != 0) goto L65;
        f.b(r110);     // Catch: RuntimeException -> L51
        return;
    L65:
        return;
    L64:
        return;
    L48:
        com.xiaomi.channel.commonutils.logger.b.d("MessageHandleService", "unknown raw message: " + r102);     // Catch: RuntimeException -> L51
        return;
    L9:
        if (r112 != 3) goto L11;
        MiPushCommandMessage r105 = (MiPushCommandMessage) r101.getSerializableExtra(PushMessageHelper.KEY_COMMAND);     // Catch: RuntimeException -> L51
        com.xiaomi.channel.commonutils.logger.b.e("(Local) begin execute onCommandResult, command=" + r105.getCommand() + ", resultCode=" + r105.getResultCode() + ", reason=" + r105.getReason());     // Catch: RuntimeException -> L51
        r100.onCommandResult(r110, r105);     // Catch: RuntimeException -> L51
        if (TextUtils.equals(r105.getCommand(), ec.f463424a.f477a) == false) goto L58;
        r100.onReceiveRegisterResult(r110, r105);     // Catch: RuntimeException -> L51
        PushMessageHandler.a(r110, r105);     // Catch: RuntimeException -> L51
        if (r105.getResultCode() != 0) goto L59;
        f.b(r110);     // Catch: RuntimeException -> L51
        return;
    L59:
        return;
    L58:
        return;
    L11:
        if (r112 == 5) goto L14;
        return;
    L14:
        if (PushMessageHelper.ERROR_TYPE_NEED_PERMISSION.equals(r101.getStringExtra("error_type")) == false) goto L55;
        String[] r106 = r101.getStringArrayExtra("error_message");     // Catch: RuntimeException -> L51
        if (r106 == null) goto L56;
        com.xiaomi.channel.commonutils.logger.b.e("begin execute onRequirePermissions, lack of necessary permissions");     // Catch: RuntimeException -> L51
        r100.onRequirePermissions(r110, r106);     // Catch: RuntimeException -> L51
        return;
    L56:
        return;
    L55:
        return;
    L51:
        e = move-exception;
        com.xiaomi.channel.commonutils.logger.b.a("MessageHandleService", e);
    }

    public static void addJob(Context r100, a r101) {
        if (r101 == null) goto L5;
        f463031a.add(r101);
        b(r100);
        startService(r100);
        return;
    }

    @Override // com.xiaomi.mipush.sdk.BaseService, android.app.Service
    public void onStart(Intent r100, int r101) {
        super.onStart(r100, r101);
    }

    public static void a(Context r100, Intent r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        b(r100);
    }
}
