package k87;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.bytedance.common.push.ActivityLifecycleObserver;
import com.bytedance.common.support.PushCommonSupport;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.push.PushSupporter;
import com.bytedance.push.helper.NetWorkStatusMonitorHelper;
import com.bytedance.push.third.PushManager;
import com.bytedance.push.utils.f;
import com.ss.android.message.AppProvider;
import com.ss.android.message.PushThreadHandlerManager;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import v67.w;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements w, Handler.Callback, Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b87.b f502096a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<Integer> f502097b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<Integer, c> f502098c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicBoolean f502099d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f502100e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f502101f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f502102g;

    /* JADX INFO: renamed from: k87.a$a, reason: collision with other inner class name */
    public class C6520a {
        public C6520a() {
        }
    }

    /* JADX INFO: loaded from: classes21.dex */
    public class b implements NetWorkStatusMonitorHelper.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f502103a;

        public b(a r100) {
            this.f502103a = r100;
        }

        @Override // com.bytedance.push.helper.NetWorkStatusMonitorHelper.a
        public final void a(String r100, String r101) {
            f.g("TokenRetryService", "[onAvailableNetworkTypeChanged]lastType:" + r100 + " curType:" + r101);
            Map<Integer, c> r102 = this.f502103a.f502098c;
            monitor-enter(r102);
        L15:
            th = move-exception;
            throw th;
        L5:
            if (((HashMap) this.f502103a.f502098c).isEmpty() == false) goto L9;
            f.g("TokenRetryService", "[onCapabilitiesChanged]unregister NetworkCallback because  mTokenRetryTaskMap is empty");     // Catch: Throwable -> L15
            monitor-exit(r102);     // Catch: Throwable -> L15
            return;
        L9:
            Iterator r103 = ((HashMap) this.f502103a.f502098c).values().iterator();     // Catch: Throwable -> L15
        L11:
            if (r103.hasNext() == false) goto L13;
            c.a((c) r103.next(), "network_type_changed-" + r101);     // Catch: Throwable -> L15
            goto L11
        L13:
            monitor-exit(r102);     // Catch: Throwable -> L15
        }
    }

    /* JADX INFO: loaded from: classes21.dex */
    public class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f502104a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f502105b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final AtomicBoolean f502106c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ a f502107d;

        public final void b(String r100) {
            f.g("TokenRetryTask", "[retryFailed]pushType:" + this.f502104a + " retryReason:" + r100);
            PushSupporter.get().getPushSdkMonitorService().onTokenRetryResult(this.f502104a, false, r100);
            this.f502106c.set(false);
            this.f502105b = null;
        }

        public c(a r100, int r101) {
            this.f502107d = r100;
            this.f502106c = new AtomicBoolean(false);
            this.f502104a = r101;
        }

        public static void a(c r100, String r101) {
            r100.getClass();
            f.g("TokenRetryTask", "[startRetry]pushType:" + r100.f502104a + " retryReason:" + r101 + " mRetrying:" + r100.f502106c + " mRetryingReason:" + r100.f502105b);
            if (r100.f502106c.compareAndSet(false, true) == false) goto L5;
            r100.f502105b = r101;
            f.g("TokenRetryTask", "[retryForEnterBackground]retry token register because " + r101);
            PushManager.inst().registerPush(AppProvider.getApp(), r100.f502104a);
            PushSupporter.get().getPushSdkMonitorService().onTokenRetry(r100.f502104a, r101);
            long r102 = r100.f502107d.f502096a.tokenRegisterTimeout * 1000;
            f.g("TokenRetryTask", "[retryForEnterBackground]send token register timeout message after " + r102);
            WeakHandler r103 = PushThreadHandlerManager.inst().getHandler();
            Message r104 = r103.obtainMessage(20250116, Integer.valueOf(r100.f502104a));
            Bundle r105 = new Bundle();
            r105.putString("retry_reason", r101);
            r104.setData(r105);
            r103.sendMessageDelayed(r104, r102);
            return;
        L5:
            f.g("TokenRetryTask", "[retryForEnterBackground]do nothing because mRetryingReason:" + r100.f502105b);
        }
    }

    public a() {
        this.f502097b = new HashSet();
        this.f502098c = new HashMap();
        this.f502099d = new AtomicBoolean(false);
        new C6520a();
        this.f502100e = 0;
        this.f502101f = false;
        this.f502102g = false;
        com.ss.android.pushmanager.setting.b.b().getClass();
        this.f502096a = com.ss.android.pushmanager.setting.b.d().u();
        PushThreadHandlerManager.inst().addHandlerCallback(this);
    }

    public final void a(int r100) {
        f.g("TokenRetryService", "[onPushAdapterRegister]pushType:" + r100);
        b87.b r101 = this.f502096a;
        if (r101.enableTokenRetry == true) goto L7;
        f.g("TokenRetryService", "[onPushAdapterRegister]do nothing because enableTokenRetry is false");
        return;
    L7:
        if (r101.needRetryChannel.contains(Integer.valueOf(r100)) == true) goto L10;
        f.g("TokenRetryService", "[onPushAdapterRegister]do nothing because needRetryChannel not contains " + r100);
        return;
    L10:
        Set<Integer> r102 = this.f502097b;
        monitor-enter(r102);
    L21:
        th = move-exception;
        throw th;
    L13:
        if (((HashSet) this.f502097b).contains(Integer.valueOf(r100)) == false) goto L17;
        f.g("TokenRetryService", "[onPushAdapterRegister]do nothing because mNeedRetrySenderSet has contains " + r100);     // Catch: Throwable -> L21
        monitor-exit(r102);     // Catch: Throwable -> L21
        return;
    L17:
        ((HashSet) this.f502097b).add(Integer.valueOf(r100));     // Catch: Throwable -> L21
        monitor-exit(r102);     // Catch: Throwable -> L21
        long r103 = this.f502096a.tokenRegisterTimeout * 1000;
        f.g("TokenRetryService", "[onPushAdapterRegister]send token register timeout message after " + r103);
        WeakHandler r104 = PushThreadHandlerManager.inst().getHandler();
        r104.sendMessageDelayed(r104.obtainMessage(20250115, Integer.valueOf(r100)), r103);
    }

    public final void b(int r100) {
        f.g("TokenRetryService", "[onUpdateTokenSuccess]pushType:" + r100);
        if (this.f502096a.enableTokenRetry == true) goto L6;
        f.g("TokenRetryService", "[onUpdateTokenSuccess]do nothing because enableTokenRetry is false");
        return;
    L6:
        Set<Integer> r101 = this.f502097b;
        monitor-enter(r101);
    L28:
        th = move-exception;
        throw th;
    L9:
        if (((HashSet) this.f502097b).contains(Integer.valueOf(r100)) == true) goto L13;
        f.g("TokenRetryService", "[onUpdateTokenSuccess]needn't retry:" + r100);     // Catch: Throwable -> L28
        monitor-exit(r101);     // Catch: Throwable -> L28
        return;
    L13:
        ((HashSet) this.f502097b).remove(Integer.valueOf(r100));     // Catch: Throwable -> L28
        monitor-exit(r101);     // Catch: Throwable -> L28
        Map<Integer, c> r102 = this.f502098c;
        monitor-enter(r102);
    L25:
        th = move-exception;
        throw th;
    L18:
        if (((HashMap) this.f502098c).isEmpty() == true) goto L22;
        c r103 = (c) ((HashMap) this.f502098c).get(Integer.valueOf(r100));     // Catch: Throwable -> L25
        if (r103 == null) goto L22;
        PushSupporter.get().getPushSdkMonitorService().onTokenRetryResult(r100, true, r103.f502105b);     // Catch: Throwable -> L25
        ((HashMap) this.f502098c).remove(Integer.valueOf(r100));     // Catch: Throwable -> L25
    L22:
        monitor-exit(r102);     // Catch: Throwable -> L25
        f.g("TokenRetryService", "[onUpdateTokenSuccess]remove timeout message for " + r100);
        PushThreadHandlerManager.inst().getHandler().removeMessages(20250115, Integer.valueOf(r100));
    }

    public final void c(int r100) {
        Map<Integer, c> r101 = this.f502098c;
        monitor-enter(r101);
    L25:
        th = move-exception;
        throw th;
    L5:
        if (((c) ((HashMap) this.f502098c).get(Integer.valueOf(r100))) != null) goto L7;
        c r102 = new c(this, r100);     // Catch: Throwable -> L25
        ((HashMap) this.f502098c).put(Integer.valueOf(r100), r102);     // Catch: Throwable -> L25
    L7:
        monitor-exit(r101);     // Catch: Throwable -> L25
        if (this.f502099d.compareAndSet(false, true) == false) goto L30;
        f.g("TokenRetryService", "[registerTokenRetryCallback]retryAfterNetworkChanged:" + this.f502096a.retryAfterNetworkChanged + " loopRetryIntervalInSecond:" + this.f502096a.loopRetryIntervalInSecond + " triggerRetryEventList.size:" + this.f502096a.triggerRetryEventList.size() + " retryAfterEnterBackground:" + this.f502096a.retryAfterEnterBackground);
        if (this.f502096a.retryAfterNetworkChanged == false) goto L14;
        NetWorkStatusMonitorHelper.b().a(new b(this));
    L14:
        if (this.f502096a.loopRetryIntervalInSecond <= 0) goto L17;
        WeakHandler r103 = PushThreadHandlerManager.inst().getHandler();
        r103.sendMessageDelayed(r103.obtainMessage(20250117), this.f502096a.loopRetryIntervalInSecond * 1000);
    L17:
        if (this.f502096a.triggerRetryEventList.isEmpty() == true) goto L20;
        PushCommonSupport.getInstance().getPushConfigurationService().getPushCommonConfiguration().mIPushCommonConfiguration.getEventReportListener();
        f.g("TokenRetryService", "[registerTokenRetryCallback]eventReportListener:null");
        f.i("TokenRetryService", "[registerTokenRetryCallback]not monitor event report because eventReportListener is null");
    L20:
        if (this.f502096a.retryAfterEnterBackground == false) goto L31;
        f.g("TokenRetryService", "[registerTokenRetryCallback]mHasRegisterAppStatusObserver:" + this.f502102g);
        if (this.f502102g == true) goto L32;
        this.f502102g = true;
        this.f502101f = ActivityLifecycleObserver.getIns().isBackGround();
        ActivityLifecycleObserver.getIns().addObserver(this);
        return;
    L32:
        return;
    L31:
        return;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message r100) {
        int r101 = r100.what;
        if (r101 != 20250115) goto L7;
        f.g("TokenRetryService", "[handleMessage]MSG_WHAT_TOKEN_REGISTER_TIMEOUT:" + r100.obj);
        c(((Integer) r100.obj).intValue());
        return true;
    L7:
        if (r101 != 20250117) goto L31;
        f.g("TokenRetryService", "[handleMessage]MSG_WHAT_TOKEN_REGISTER_AGAIN");
        Map<Integer, c> r102 = this.f502098c;
        monitor-enter(r102);
    L27:
        th = move-exception;
        throw th;
    L11:
        if (((HashMap) this.f502098c).isEmpty() == true) goto L24;
        f.g("TokenRetryService", "[handleMessage]maxLoopRetryTimes:" + this.f502096a.maxLoopRetryTimes + " mLoopRetryTimes:" + this.f502100e);     // Catch: Throwable -> L27
        int r103 = this.f502096a.maxLoopRetryTimes;     // Catch: Throwable -> L27
        if (r103 > 0) goto L15;
    L19:
        this.f502100e++;     // Catch: Throwable -> L27
        f.g("TokenRetryService", "[handleMessage]update mLoopRetryTimes to " + this.f502100e);     // Catch: Throwable -> L27
        Iterator r104 = ((HashMap) this.f502098c).values().iterator();     // Catch: Throwable -> L27
    L21:
        if (r104.hasNext() == false) goto L23;
        c.a((c) r104.next(), "interval_loop");     // Catch: Throwable -> L27
        goto L21
    L23:
        WeakHandler r105 = PushThreadHandlerManager.inst().getHandler();     // Catch: Throwable -> L27
        r105.sendMessageDelayed(r105.obtainMessage(20250117), this.f502096a.loopRetryIntervalInSecond * 1000);     // Catch: Throwable -> L27
    L25:
        monitor-exit(r102);     // Catch: Throwable -> L27
        return true;
    L15:
        if (this.f502100e < r103) goto L19;
        f.g("TokenRetryService", "[handleMessage]not loop retry because mLoopRetryTimes >maxRetryTimes,mLoopRetryTimes:" + this.f502100e + " maxRetryTimes:" + this.f502096a.maxLoopRetryTimes);     // Catch: Throwable -> L27
        monitor-exit(r102);     // Catch: Throwable -> L27
        return true;
    L24:
        this.f502100e = 0;     // Catch: Throwable -> L27
        f.g("TokenRetryService", "[handleMessage]update mLoopRetryTimes to 0");     // Catch: Throwable -> L27
        goto L25
    L31:
        if (r101 != 20250116) goto L45;
        int r106 = ((Integer) r100.obj).intValue();
        String r107 = r100.getData().getString("retry_reason");
        f.g("TokenRetryService", "[handleMessage]MSG_WHAT_TOKEN_RETRY_TIMEOUT:" + r100.obj + " retryReason:" + r107);
        Map<Integer, c> r108 = this.f502098c;
        monitor-enter(r108);
    L42:
        th = move-exception;
        throw th;
    L35:
        if (((HashMap) this.f502098c).isEmpty() == true) goto L40;
        c r109 = (c) ((HashMap) this.f502098c).get(Integer.valueOf(r106));     // Catch: Throwable -> L42
        if (r109 == null) goto L39;
        r109.b(r107);     // Catch: Throwable -> L42
        goto L40
    L39:
        PushSupporter.get().getPushSdkMonitorService().onTokenRetryResult(r106, true, r107);     // Catch: Throwable -> L42
    L40:
        monitor-exit(r108);     // Catch: Throwable -> L42
    L45:
        return false;
    }

    @Override // java.util.Observer
    public void update(Observable r100, Object r101) {
        boolean r102 = ((Boolean) r101).booleanValue();
        f.g("TokenRetryService", "app status changed,mIsBackground:" + this.f502101f + " isBackground:" + r102);
        if (this.f502101f == true) goto L16;
        if (r102 == false) goto L16;
        Map<Integer, c> r103 = this.f502098c;
        monitor-enter(r103);
        Iterator r104 = ((HashMap) this.f502098c).values().iterator();     // Catch: Throwable -> L13
    L9:
        if (r104.hasNext() == false) goto L11;
        c.a((c) r104.next(), "enter_background");     // Catch: Throwable -> L13
        goto L9
    L11:
        monitor-exit(r103);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    L16:
        this.f502101f = r102;
    }
}
