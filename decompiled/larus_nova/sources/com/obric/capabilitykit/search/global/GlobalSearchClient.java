package com.obric.capabilitykit.search.global;

import aja.c;
import aja.d;
import aja.e;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.ies.xelement.LynxVideoManagerLite;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.obric.capabilitykit.PackageUtils;
import com.obric.capabilitykit.apphost.AppHost;
import com.obric.capabilitykit.entity.memory.MemoryServiceStatus;
import com.obric.capabilitykit.entity.search.global.GlobalSearchRequest;
import com.obric.capabilitykit.entity.search.global.GlobalSearchResult;
import com.obric.capabilitykit.entity.search.global.IGlobalSearchService;
import com.obric.capabilitykit.logger.Logger;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u000b\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0019\u001a\u00020\u0011H\u0002J\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0006J\u0018\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\tH\u0002J\u001e\u0010\u001f\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#J\u0006\u0010$\u001a\u00020\u001bJ\b\u0010%\u001a\u00020\u001bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0016\u0010\r\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0014\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00160\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/obric/capabilitykit/search/global/GlobalSearchClient;", "", "()V", "NONE_ERROR_ENTITY_TYPE", "", "TAG", "", "businessMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", WsConstants.KEY_CONNECTION, "com/obric/capabilitykit/search/global/GlobalSearchClient$connection$1", "Lcom/obric/capabilitykit/search/global/GlobalSearchClient$connection$1;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "kotlin.jvm.PlatformType", "isBound", "", "mainHandler", "Landroid/os/Handler;", "pendingOperations", "Ljava/util/Queue;", "Lkotlin/Function0;", "service", "Lcom/obric/capabilitykit/entity/search/global/IGlobalSearchService;", "bindService", "cancel", "", "businessName", "isCancelled", "timestamp", "startGlobalSearch", "request", "Lcom/obric/capabilitykit/entity/search/global/GlobalSearchRequest;", "callback", "Lcom/obric/capabilitykit/search/global/IGlobalSearchCallback;", "stop", "unbindService", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class GlobalSearchClient {
    public static final GlobalSearchClient INSTANCE = null;
    public static final int NONE_ERROR_ENTITY_TYPE = -1;
    private static final String TAG = "GlobalSearchClient";
    private static final ConcurrentHashMap<String, Long> businessMap = null;
    private static final a connection = null;
    private static final Context context = null;
    private static boolean isBound;
    private static final Handler mainHandler = null;
    private static final Queue<Function0<Object>> pendingOperations = null;
    private static IGlobalSearchService service;

    public static final class a implements ServiceConnection {
        public a() {
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName r100, IBinder r101) {
            GlobalSearchClient r102 = GlobalSearchClient.INSTANCE;
            GlobalSearchClient.access$setService$p(IGlobalSearchService.Stub.asInterface(r101));
            Logger.INSTANCE.d(GlobalSearchClient.TAG, "onServiceConnected " + r100);
            GlobalSearchClient.access$setBound$p(true);
        L4:
            if ((!GlobalSearchClient.access$getPendingOperations$p().isEmpty()) == false) goto L8;
            Function0 r103 = (Function0) GlobalSearchClient.access$getPendingOperations$p().poll();
            if (r103 == null) goto L4;
            r103.invoke();
            goto L4
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName r100) {
            Logger.INSTANCE.d(GlobalSearchClient.TAG, "onServiceDisconnected " + r100);
            GlobalSearchClient.access$setService$p(null);
            GlobalSearchClient.access$setBound$p(false);
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class b extends Lambda implements Function0<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IGlobalSearchCallback f396283a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f396284b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ GlobalSearchRequest f396285c;

        @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J \u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH\u0016¨\u0006\u000e"}, d2 = {"com/obric/capabilitykit/search/global/GlobalSearchClient$startGlobalSearch$operation$1$1", "Lcom/obric/capabilitykit/entity/search/global/IGlobalSearchCallback$Stub;", "onAllCompleted", "", LynxVideoManagerLite.EVENT_ON_PLAY_COMPLETED, "entityType", "", LynxVideoManagerLite.EVENT_ON_ERROR, "errorCode", "errorMsg", "", "onSearchResult", "result", "Lcom/obric/capabilitykit/entity/search/global/GlobalSearchResult;", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class a extends com.obric.capabilitykit.entity.search.global.IGlobalSearchCallback.Stub {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f396286a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ long f396287b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ IGlobalSearchCallback f396288c;

            public a(String r100, long r101, IGlobalSearchCallback r102) {
                this.f396286a = r100;
                this.f396287b = r101;
                this.f396288c = r102;
            }

            private static final void a(String r100, long r101, IGlobalSearchCallback r102) {
                Intrinsics.checkNotNullParameter(r100, "$businessName");
                Intrinsics.checkNotNullParameter(r102, "$callback");
                if (GlobalSearchClient.access$isCancelled(GlobalSearchClient.INSTANCE, r100, r101) == true) goto L6;
                r102.onAllCompleted();
                GlobalSearchClient.access$getBusinessMap$p().remove(r100);
                return;
            }

            private static final void a(String r100, long r101, IGlobalSearchCallback r102, int r103) {
                Intrinsics.checkNotNullParameter(r100, "$businessName");
                Intrinsics.checkNotNullParameter(r102, "$callback");
                if (GlobalSearchClient.access$isCancelled(GlobalSearchClient.INSTANCE, r100, r101) == true) goto L6;
                r102.onCompleted(r103);
                return;
            }

            private static final void a(String r100, long r101, IGlobalSearchCallback r102, int r103, String r104) {
                Intrinsics.checkNotNullParameter(r100, "$businessName");
                Intrinsics.checkNotNullParameter(r102, "$callback");
                Intrinsics.checkNotNullParameter(r104, "$errorMsg");
                if (GlobalSearchClient.access$isCancelled(GlobalSearchClient.INSTANCE, r100, r101) == true) goto L6;
                r102.onError(r103, -1, r104);
                GlobalSearchClient.access$getBusinessMap$p().remove(r100);
                return;
            }

            private static final void a(String r100, long r101, IGlobalSearchCallback r102, GlobalSearchResult r103) {
                Intrinsics.checkNotNullParameter(r100, "$businessName");
                Intrinsics.checkNotNullParameter(r102, "$callback");
                Intrinsics.checkNotNullParameter(r103, "$result");
                if (GlobalSearchClient.access$isCancelled(GlobalSearchClient.INSTANCE, r100, r101) == true) goto L6;
                r102.onSearchResult(r103);
                return;
            }

            public static /* synthetic */ void b(String r100, long r101, IGlobalSearchCallback r102) {
                a(r100, r101, r102);
            }

            public static /* synthetic */ void c(String r100, long r101, IGlobalSearchCallback r102, int r103) {
                a(r100, r101, r102, r103);
            }

            public static /* synthetic */ void d(String r100, long r101, IGlobalSearchCallback r102, int r103, String r104) {
                a(r100, r101, r102, r103, r104);
            }

            public static /* synthetic */ void e(String r100, long r101, IGlobalSearchCallback r102, GlobalSearchResult r103) {
                a(r100, r101, r102, r103);
            }

            @Override // com.obric.capabilitykit.entity.search.global.IGlobalSearchCallback
            public void onAllCompleted() {
                Logger.INSTANCE.d(GlobalSearchClient.TAG, "onAllCompleted");
                Handler r100 = GlobalSearchClient.access$getMainHandler$p();
                final String r101 = this.f396286a;
                final long r102 = this.f396287b;
                final IGlobalSearchCallback r103 = this.f396288c;
                r100.post(new aja.b(r101, r102, r103));
            }

            @Override // com.obric.capabilitykit.entity.search.global.IGlobalSearchCallback
            public void onCompleted(final int r100) {
                Logger.INSTANCE.d(GlobalSearchClient.TAG, "onCompleted " + r100);
                Handler r101 = GlobalSearchClient.access$getMainHandler$p();
                final String r102 = this.f396286a;
                final long r103 = this.f396287b;
                final IGlobalSearchCallback r104 = this.f396288c;
                r101.post(new e(r102, r103, r104, r100));
            }

            @Override // com.obric.capabilitykit.entity.search.global.IGlobalSearchCallback
            public void onError(final int r100, int r110, final String r111) {
                Intrinsics.checkNotNullParameter(r111, "errorMsg");
                Logger.INSTANCE.w(GlobalSearchClient.TAG, "onError: " + r100 + ' ' + r111);
                Handler r112 = GlobalSearchClient.access$getMainHandler$p();
                final String r101 = this.f396286a;
                final long r102 = this.f396287b;
                final IGlobalSearchCallback r103 = this.f396288c;
                r112.post(new c(r101, r102, r103, r100, r111));
            }

            @Override // com.obric.capabilitykit.entity.search.global.IGlobalSearchCallback
            public void onSearchResult(final GlobalSearchResult r100) {
                Intrinsics.checkNotNullParameter(r100, "result");
                Logger.INSTANCE.d(GlobalSearchClient.TAG, "onSearchResult: " + r100);
                Handler r101 = GlobalSearchClient.access$getMainHandler$p();
                final String r102 = this.f396286a;
                final long r103 = this.f396287b;
                final IGlobalSearchCallback r104 = this.f396288c;
                r101.post(new d(r102, r103, r104, r100));
            }
        }

        public b(IGlobalSearchCallback r100, String r101, GlobalSearchRequest r102) {
            this.f396283a = r100;
            this.f396284b = r101;
            this.f396285c = r102;
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
        L11:
            th = move-exception;
            th.printStackTrace();
            Logger.INSTANCE.e(GlobalSearchClient.TAG, "exception " + th.getMessage());
            Handler r100 = GlobalSearchClient.access$getMainHandler$p();
            final IGlobalSearchCallback r101 = this.f396283a;
            return Boolean.valueOf(r100.post(new aja.a(r101, th)));
        L3:
            if (GlobalSearchClient.access$getService$p() != null) goto L5;
            this.f396283a.onError(2, -1, "service not ready");     // Catch: Throwable -> L11
        L8:
            return Unit.INSTANCE;
        L5:
            long r102 = System.currentTimeMillis();     // Catch: Throwable -> L11
            GlobalSearchClient.access$getBusinessMap$p().put(this.f396284b, Long.valueOf(r102));     // Catch: Throwable -> L11
            IGlobalSearchService r103 = GlobalSearchClient.access$getService$p();     // Catch: Throwable -> L11
            if (r103 == null) goto L10;
            r103.startGlobalSearch(this.f396284b, this.f396285c, new a(this.f396284b, r102, this.f396283a));     // Catch: Throwable -> L11
            goto L8
        L10:
            return null;
        }
    }

    static {
        INSTANCE = new GlobalSearchClient();
        context = AppHost.Companion.getApplication().getApplicationContext();
        mainHandler = new Handler(Looper.getMainLooper());
        pendingOperations = new LinkedList();
        businessMap = new ConcurrentHashMap();
        connection = new a();
    }

    private GlobalSearchClient() {
    }

    public static final /* synthetic */ ConcurrentHashMap access$getBusinessMap$p() {
        return businessMap;
    }

    public static final /* synthetic */ Handler access$getMainHandler$p() {
        return mainHandler;
    }

    public static final /* synthetic */ Queue access$getPendingOperations$p() {
        return pendingOperations;
    }

    public static final /* synthetic */ IGlobalSearchService access$getService$p() {
        return service;
    }

    public static final /* synthetic */ boolean access$isCancelled(GlobalSearchClient r100, String r101, long r102) {
        return r100.isCancelled(r101, r102);
    }

    public static final /* synthetic */ void access$setBound$p(boolean r100) {
        isBound = r100;
    }

    public static final /* synthetic */ void access$setService$p(IGlobalSearchService r100) {
        service = r100;
    }

    private final boolean bindService() {
        Logger.INSTANCE.d(TAG, "start bindService");
        Intent r100 = new Intent("com.obric.memorydata.action.GLOBAL_SEARCH_SERVICE");
        List<ResolveInfo> r101 = context.getPackageManager().queryIntentServices(r100, 0);
        ArrayList r102 = new ArrayList();
        Iterator<T> r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L8;
        ServiceInfo r104 = ((ResolveInfo) r103.next()).serviceInfo;
        if (r104 == null) goto L4;
        r102.add(r104);
        goto L4
    L8:
        Iterator r105 = r102.iterator();
    L9:
        String r106 = null;
        if (r105.hasNext() == false) goto L14;
        Object r107 = r105.next();
        if (PackageUtils.INSTANCE.checkSignature(((ServiceInfo) r107).packageName) == false) goto L9;
    L15:
        ServiceInfo r108 = (ServiceInfo) r107;
        if (r108 != null) goto L19;
        Logger.INSTANCE.e(TAG, "No trusted service found for action: " + r100.getAction());
        return false;
    L19:
        r100.setComponent(new ComponentName(r108.packageName, r108.name));
        r100.setPackage(r108.packageName);
        boolean r109 = context.bindService(r100, connection, 1);
        if (r109 == true) goto L25;
        Logger r110 = Logger.INSTANCE;
        StringBuilder r111 = new StringBuilder("not found service ");
        ComponentName r112 = r100.getComponent();
        if (r112 == null) goto L24;
        r106 = r112.getShortClassName();
    L24:
        r111.append(r106);
        r110.w(TAG, r111.toString());
    L25:
        return r109;
    L14:
        r107 = null;
        goto L15
    }

    private final boolean isCancelled(String r100, long r101) {
        Long r102 = businessMap.get(r100);
        if (r102 != null) goto L6;
    L7:
        Logger.INSTANCE.d(TAG, "ignore expired search");
        return true;
    L6:
        if (r102.longValue() != r101) goto L7;
        return false;
    }

    private final void unbindService() {
        if (isBound == false) goto L6;
        context.unbindService(connection);
        isBound = false;
        return;
    }

    public final void stop() {
        int r100 = yia.a.f568002a;
        Context r101 = context;
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (yia.a.c(r101, "com.obric.memorydata.action.GLOBAL_SEARCH_SERVICE") == MemoryServiceStatus.AVAILABLE) goto L6;
        Logger.INSTANCE.w(TAG, "Global search service is not available, skip stop");
        return;
    L6:
        businessMap.clear();
        unbindService();
    }

    public final void cancel(String r100) {
        Intrinsics.checkNotNullParameter(r100, "businessName");
        int r101 = yia.a.f568002a;
        Context r102 = context;
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (yia.a.c(r102, "com.obric.memorydata.action.GLOBAL_SEARCH_SERVICE") == MemoryServiceStatus.AVAILABLE) goto L6;
        Logger.INSTANCE.w(TAG, "Global search service is not available, skip cancel");
        return;
    L6:
        businessMap.remove(r100);
        if (isBound == false) goto L17;
        IGlobalSearchService r103 = service;     // Catch: RemoteException -> L12
        if (r103 == null) goto L18;
        r103.cancel(r100);     // Catch: RemoteException -> L12
        return;
    L18:
        return;
    L12:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public final void startGlobalSearch(String r100, GlobalSearchRequest r101, IGlobalSearchCallback r102) {
        Intrinsics.checkNotNullParameter(r100, "businessName");
        Intrinsics.checkNotNullParameter(r101, "request");
        Intrinsics.checkNotNullParameter(r102, "callback");
        int r103 = yia.a.f568002a;
        Context r104 = context;
        Intrinsics.checkNotNullParameter(r104, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (yia.a.c(r104, "com.obric.memorydata.action.GLOBAL_SEARCH_SERVICE") == MemoryServiceStatus.AVAILABLE) goto L6;
        Logger.INSTANCE.w(TAG, "Global search service is not available, skip startGlobalSearch");
        r102.onError(6, -1, "Global search service is not available");
        return;
    L6:
        b r105 = new b(r102, r100, r101);
        if (isBound == false) goto L9;
        r105.invoke();
        return;
    L9:
        pendingOperations.add(r105);
        bindService();
    }
}
