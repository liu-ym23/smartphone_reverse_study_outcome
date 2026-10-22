package com.obric.sva.sdk.notification;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.service.notification.StatusBarNotification;
import com.bytedance.android.btm.impl.page.model.PageInfo;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.obric.assistant.NotificationSignatureWhiteItem;
import com.obric.assistant.OUseMemorySettingsConfig;
import com.obric.assistant.ObricPackageSignatureCache;
import com.obric.assistant.ObricSecuritySettingsPackageWhitelistConfig;
import com.obric.assistant.l;
import com.obric.assistant.spi.notification.IObricInteractorNotificationCallback;
import com.obric.sva.sdk.utils.LogUtils;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000'\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0005\u0018\u0000 \u000f2\u00020\u0001:\u0002\u000e\u000fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\r\u001a\u00020\bH\u0016R\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/obric/sva/sdk/notification/SvaNotificationDispatchService;", "Landroid/app/Service;", "<init>", "()V", "binder", "com/obric/sva/sdk/notification/SvaNotificationDispatchService$binder$1", "Lcom/obric/sva/sdk/notification/SvaNotificationDispatchService$binder$1;", WidgetCostModule.TYPE_ON_CREATE, "", "onBind", "Landroid/os/IBinder;", "intent", "Landroid/content/Intent;", LiveCommonConstants.REASON_ON_DEDTROY, "Dispatcher", "Companion", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SvaNotificationDispatchService extends Service {
    public static final Companion Companion = null;
    private static final String TAG = "SvaNotificationDispatch";
    private final SvaNotificationDispatchService$binder$1 binder;

    /* JADX INFO: loaded from: classes6.dex */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/sva/sdk/notification/SvaNotificationDispatchService$Companion;", "", "<init>", "()V", "TAG", "", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    /* JADX INFO: loaded from: classes6.dex */
    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\f\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006J\u001a\u0010\r\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\u0010\u0010\u0012\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\u0006\u0010\u0013\u001a\u00020\nJ\u0006\u0010\u0014\u001a\u00020\nJ\u0006\u0010\u0015\u001a\u00020\nJ\u001c\u0010\u0016\u001a\u00020\n2\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n0\u0018H\u0002J\u001a\u0010\u0019\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u001a\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0002J\u001a\u0010\u001d\u001a\u00020\b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001f\u001a\u00020 H\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/obric/sva/sdk/notification/SvaNotificationDispatchService$Dispatcher;", "", "<init>", "()V", "callbacks", "Landroid/os/RemoteCallbackList;", "Lcom/obric/assistant/spi/notification/IObricInteractorNotificationCallback;", "listenerConnected", "", "registerCallback", "", "callback", "unregisterCallback", "dispatchNotificationPosted", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "notification", "Landroid/service/notification/StatusBarNotification;", "dispatchNotificationRemoved", "dispatchListenerConnected", "dispatchListenerDisconnected", PageInfo.SCENE_KILL, "dispatch", "block", "Lkotlin/Function1;", "receiveNotificationData", "getAppName", "", "pkg", "isNotificationDataSafe", "pkgName", "config", "Lcom/obric/assistant/ObricSecuritySettingsPackageWhitelistConfig;", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Dispatcher {
        public static final Dispatcher INSTANCE = null;
        private static final RemoteCallbackList<IObricInteractorNotificationCallback> callbacks = null;
        private static boolean listenerConnected;

        private Dispatcher() {
        }

        public static /* synthetic */ Unit a(StatusBarNotification r100, IObricInteractorNotificationCallback r101) {
            return dispatchNotificationRemoved$lambda$1(r100, r101);
        }

        public static /* synthetic */ Unit b(IObricInteractorNotificationCallback r100) {
            return dispatchListenerDisconnected$lambda$3(r100);
        }

        public static /* synthetic */ Unit c(IObricInteractorNotificationCallback r100) {
            return dispatchListenerConnected$lambda$2(r100);
        }

        public static /* synthetic */ boolean d(String r100) {
            return isNotificationDataSafe$lambda$8(r100);
        }

        public static /* synthetic */ String e(String r100) {
            return isNotificationDataSafe$lambda$7(r100);
        }

        public static /* synthetic */ boolean f(String r100, NotificationSignatureWhiteItem r101) {
            return isNotificationDataSafe$lambda$5(r100, r101);
        }

        public static /* synthetic */ Sequence g(NotificationSignatureWhiteItem r100) {
            return isNotificationDataSafe$lambda$6(r100);
        }

        public static /* synthetic */ Unit h(StatusBarNotification r100, IObricInteractorNotificationCallback r101) {
            return dispatchNotificationPosted$lambda$0(r100, r101);
        }

        public final void dispatchListenerConnected() {
            listenerConnected = true;
            LogUtils.i(SvaNotificationDispatchService.TAG, "dispatchListenerConnected", new Object[0]);
            dispatch(new d());
        }

        public final void dispatchListenerDisconnected() {
            listenerConnected = false;
            LogUtils.i(SvaNotificationDispatchService.TAG, "dispatchListenerDisconnected", new Object[0]);
            dispatch(new i());
        }

        public final void kill() {
            listenerConnected = false;
            callbacks.kill();
        }

        static {
            INSTANCE = new Dispatcher();
            callbacks = new RemoteCallbackList();
        }

        private final void dispatch(Function1<? super IObricInteractorNotificationCallback, Unit> r100) {
            int r101 = callbacks.beginBroadcast();
            LogUtils.i(SvaNotificationDispatchService.TAG, "dispatch callback count: " + r101, new Object[0]);
            int r102 = 0;
        L3:
            if (r102 >= r101) goto L15;
            r100.invoke(callbacks.getBroadcastItem(r102));     // Catch: Throwable -> L7 RemoteException -> L9
        L11:
            r102 = r102 + 1;
        L7:
            th = move-exception;
            LogUtils.w(SvaNotificationDispatchService.TAG, "dispatch callback failed", new Object[]{th});     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            callbacks.finishBroadcast();
            throw th;
        L9:
            e = move-exception;
            LogUtils.w(SvaNotificationDispatchService.TAG, "dispatch remote callback failed", new Object[]{e});     // Catch: Throwable -> L12
            goto L11
        L15:
            callbacks.finishBroadcast();
        }

        private static final Unit dispatchListenerConnected$lambda$2(IObricInteractorNotificationCallback r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            r100.onListenerConnected();
            return Unit.INSTANCE;
        }

        private static final Unit dispatchListenerDisconnected$lambda$3(IObricInteractorNotificationCallback r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            r100.onListenerDisconnected();
            return Unit.INSTANCE;
        }

        private static final Sequence isNotificationDataSafe$lambda$6(NotificationSignatureWhiteItem r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            List<String> r101 = r100.getSignatures();
            if (r101 != null) goto L6;
            r101 = CollectionsKt.emptyList();
        L6:
            return CollectionsKt.asSequence(r101);
        }

        private static final String isNotificationDataSafe$lambda$7(String r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            return StringsKt.trim(r100).toString().toLowerCase(Locale.ROOT);
        }

        private static final boolean isNotificationDataSafe$lambda$8(String r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            return !StringsKt.isBlank(r100);
        }

        public final void dispatchNotificationRemoved(final StatusBarNotification r100) {
            if (r100 != null) goto L5;
            LogUtils.w(SvaNotificationDispatchService.TAG, "dispatchNotificationRemoved failed, notification is null", new Object[0]);
            return;
        L5:
            dispatch(new j(r100));
        }

        public final void registerCallback(IObricInteractorNotificationCallback r100) {
            if (r100 != null) goto L6;
            LogUtils.w(SvaNotificationDispatchService.TAG, "registerCallback failed, callback is null", new Object[0]);
            return;
        L6:
            callbacks.register(r100);
            LogUtils.i(SvaNotificationDispatchService.TAG, "registerCallback: " + r100 + ", listenerConnected: " + listenerConnected, new Object[0]);
            if (listenerConnected == true) goto L16;
            return;
        L16:
            r100.onListenerConnected();     // Catch: Throwable -> L11 RemoteException -> L13
            LogUtils.i(SvaNotificationDispatchService.TAG, "notify current listener connected to new callback", new Object[0]);     // Catch: Throwable -> L11 RemoteException -> L13
        L20:
            return;
        L13:
            e = move-exception;
            LogUtils.w(SvaNotificationDispatchService.TAG, "notify current listener connected failed", new Object[]{e});
            return;
        L11:
            th = move-exception;
            LogUtils.w(SvaNotificationDispatchService.TAG, "notify current listener connected failed", new Object[]{th});
        }

        public final void unregisterCallback(IObricInteractorNotificationCallback r100) {
            if (r100 != null) goto L6;
            LogUtils.w(SvaNotificationDispatchService.TAG, "unregisterCallback failed, callback is null", new Object[0]);
            return;
        L6:
            callbacks.unregister(r100);
            LogUtils.i(SvaNotificationDispatchService.TAG, "unregisterCallback: " + r100, new Object[0]);
        }

        private static final Unit dispatchNotificationPosted$lambda$0(StatusBarNotification r100, IObricInteractorNotificationCallback r101) {
            Intrinsics.checkNotNullParameter(r101, "it");
            r101.onNotificationPosted(r100);
            return Unit.INSTANCE;
        }

        private static final Unit dispatchNotificationRemoved$lambda$1(StatusBarNotification r100, IObricInteractorNotificationCallback r101) {
            Intrinsics.checkNotNullParameter(r101, "it");
            r101.onNotificationRemoved(r100);
            return Unit.INSTANCE;
        }

        private final String getAppName(Context r100, String r101) {
            if (r101 != null) goto L5;
        L8:
            boolean r102 = true;
        L9:
            if (r102 == false) goto L18;
            if (r101 != null) goto L20;
            return "";
        L20:
            return r101;
        L18:
            return r100.getPackageManager().getApplicationLabel(r100.getPackageManager().getApplicationInfo(r101, 0)).toString();
        L15:
            th = move-exception;
            LogUtils.w(SvaNotificationDispatchService.TAG, "getAppName failed, pkg=" + r101, new Object[]{th});
            return r101;
        L5:
            if (r101.length() == 0) goto L8;
            r102 = false;
            goto L9
        }

        private final boolean isNotificationDataSafe(final String r100, ObricSecuritySettingsPackageWhitelistConfig r101) {
            OUseMemorySettingsConfig r102 = l.f390022a;
            Intrinsics.checkNotNullParameter(r101, "<this>");
            boolean r103 = true;
            if (Intrinsics.areEqual(r101.getGlobalWhiteListSignatureCheckEnabled(), Boolean.TRUE) == true) goto L6;
            return true;
        L6:
            if (r100 == null) goto L33;
            String r104 = null;
            if ((!StringsKt.isBlank(r100)) == true) goto L11;
            r100 = null;
        L11:
            if (r100 == null) goto L33;
            List<NotificationSignatureWhiteItem> r105 = r101.getAppListSignatures();
            if (r105 != null) goto L16;
            r105 = CollectionsKt.emptyList();
        L16:
            Set r106 = SequencesKt.toSet(SequencesKt.filter(SequencesKt.map(SequencesKt.filterNotNull(SequencesKt.flatMap(SequencesKt.filter(CollectionsKt.asSequence(CollectionsKt.filterNotNull(r105)), new e(r100)), new f())), new g()), new h()));
            if (r106.isEmpty() == false) goto L19;
            return false;
        L19:
            String r107 = ObricPackageSignatureCache.f385175a.getOrCompute(r100);
            if (r107 == null) goto L24;
            String r108 = StringsKt.trim(r107).toString();
            if (r108 == null) goto L24;
            r104 = r108.toLowerCase(Locale.ROOT);
        L24:
            if (r104 != null) goto L26;
        L29:
            if (r103 == false) goto L32;
            return false;
        L32:
            return r106.contains(r104);
        L26:
            if (StringsKt.isBlank(r104) == true) goto L29;
            r103 = false;
        L33:
            return false;
        }

        private static final boolean isNotificationDataSafe$lambda$5(String r100, NotificationSignatureWhiteItem r101) {
            Intrinsics.checkNotNullParameter(r101, "it");
            return Intrinsics.areEqual(r101.getPkgName(), r100);
        }

        private final void receiveNotificationData(Context r110, StatusBarNotification r111) {
            LogUtils.w(SvaNotificationDispatchService.TAG, "receiveNotificationData", new Object[0]);
            if (r110 != null) goto L6;
            LogUtils.w(SvaNotificationDispatchService.TAG, "receiveNotificationData failed, context is null", new Object[0]);
            return;
        L6:
            BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new SvaNotificationDispatchService$Dispatcher$receiveNotificationData$1(r111, r110, null), 2, null);
        }

        public final void dispatchNotificationPosted(Context r100, final StatusBarNotification r101) {
            if (r101 != null) goto L6;
            LogUtils.w(SvaNotificationDispatchService.TAG, "dispatchNotificationPosted failed, notification is null", new Object[0]);
            return;
        L6:
            LogUtils.w(SvaNotificationDispatchService.TAG, "dispatchNotificationPosted: " + r101.getPackageName() + ", when: " + r101.getPostTime(), new Object[0]);
            receiveNotificationData(r100, r101);
            dispatch(new c(r101));
        }

        public static final /* synthetic */ String access$getAppName(Dispatcher r100, Context r101, String r102) {
            return r100.getAppName(r101, r102);
        }

        public static final /* synthetic */ boolean access$isNotificationDataSafe(Dispatcher r100, String r101, ObricSecuritySettingsPackageWhitelistConfig r102) {
            return r100.isNotificationDataSafe(r101, r102);
        }
    }

    static {
        Companion = new Companion(null);
    }

    @Override // android.app.Service
    public void onDestroy() {
        LogUtils.i(TAG, LiveCommonConstants.REASON_ON_DEDTROY, new Object[0]);
        Dispatcher.INSTANCE.kill();
        super.onDestroy();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.obric.sva.sdk.notification.SvaNotificationDispatchService$binder$1] */
    public SvaNotificationDispatchService() {
        this.binder = new SvaNotificationDispatchService$binder$1();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        LogUtils.i(TAG, WidgetCostModule.TYPE_ON_CREATE, new Object[0]);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent r100) {
        LogUtils.i(TAG, "onBind: " + r100, new Object[0]);
        return this.binder;
    }
}
