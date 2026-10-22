package com.larus.connector;

import com.larus.network.http.HttpExtKt;
import com.larus.network.http.ServiceType;
import com.larus.network.http.y;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import com.ss.ttm.player.MediaPlayer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.b1;
import kotlinx.coroutines.flow.j1;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class ConnectorListRepository {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConnectorListRepository f330182a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final CoroutineScope f330183b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f330184c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f330185d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static long f330186e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static Deferred<? extends p> f330187f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final StateFlowImpl f330188g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final b1 f330189h = null;

    public ConnectorListRepository() {
    }

    static {
        f330182a = new ConnectorListRepository();
        f330183b = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        f330184c = new Object();
        f330185d = AccountService.f365697a.getUserId();
        s r100 = s.f330225a;
        String r101 = f330185d;
        r100.getClass();
        StateFlowImpl r102 = j1.a(s.b(r101));
        f330188g = r102;
        f330189h = kotlinx.coroutines.flow.e.b(r102);
    }

    public static List b() {
        f(AccountService.f365697a.getUserId(), false);
        return (List) f330189h.getValue();
    }

    public static List c() {
        List r100 = b();
        if (r100 != null) goto L5;
        r100 = CollectionsKt.emptyList();
    L5:
        ArrayList r101 = new ArrayList();
        Iterator r102 = r100.iterator();
    L7:
        if (r102.hasNext() == false) goto L20;
        Object r103 = r102.next();
        n r104 = (n) r103;
        boolean r105 = false;
        if (r104.f330214e == 1) goto L11;
    L13:
        boolean r106 = false;
    L14:
        if (r106 == true) goto L16;
    L18:
        if (r105 == false) goto L7;
        r101.add(r103);
        goto L7
    L16:
        if (r104.f330216g == false) goto L18;
        r105 = true;
        goto L18
    L11:
        if (r104.f330215f != 1) goto L13;
        r106 = true;
        goto L14
    L20:
        return r101;
    }

    public static void f(String r100, boolean r101) {
        Object r102 = f330184c;
        monitor-enter(r102);
        if (r101 == false) goto L17;
    L9:
        f330186e++;     // Catch: Throwable -> L14
        f330185d = r100;     // Catch: Throwable -> L14
        Deferred<? extends p> r103 = f330187f;     // Catch: Throwable -> L14
        f330187f = null;     // Catch: Throwable -> L14
        StateFlowImpl r104 = f330188g;     // Catch: Throwable -> L14
        s.f330225a.getClass();     // Catch: Throwable -> L14
        r104.setValue(s.b(r100));     // Catch: Throwable -> L14
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L14
        monitor-exit(r102);
        if (r103 == null) goto L19;
        Job.DefaultImpls.cancel$default(r103, null, 1, null);
        return;
    L19:
        return;
    L14:
        th = move-exception;
        throw th;
    L17:
        if (Intrinsics.areEqual(f330185d, r100) == false) goto L9;
        monitor-exit(r102);
    }

    public final Object e(String r110, Continuation<? super p> r210) {
        if ((r210 instanceof ConnectorListRepository$refreshConnectorList$1) == false) goto L7;
        ConnectorListRepository$refreshConnectorList$1 r100 = (ConnectorListRepository$refreshConnectorList$1) r210;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        ConnectorListRepository$refreshConnectorList$1 r102 = r100;
        Object r103 = r102.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r102.label;
        if (r105 == 0) goto L17;
        if (r105 != 1) goto L16;
        ResultKt.throwOnFailure(r103);     // Catch: CancellationException -> L13
    L37:
        return (p) r103;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        ResultKt.throwOnFailure(r103);
        boolean r106 = false;
        f(AccountService.f365697a.getUserId(), false);
        Object r111 = f330184c;
        monitor-enter(r111);
        final Deferred<? extends p> r107 = f330187f;     // Catch: Throwable -> L44
        if (r107 != null) goto L22;
    L31:
        r107 = BuildersKt.async$default(f330183b, null, CoroutineStart.LAZY, new ConnectorListRepository$createRequestLocked$request$1(r110, f330185d, f330186e, null), 1, null);     // Catch: Throwable -> L44
        f330187f = r107;     // Catch: Throwable -> L44
        r107.invokeOnCompletion(new q(r107));     // Catch: Throwable -> L44
    L32:
        monitor-exit(r111);
        FLogger.f375446a.i("ConnectorListRepository", "[refreshConnectorList] start, scene=" + r110);
        r107.start();
        r102.label = 1;     // Catch: CancellationException -> L13
        r103 = r107.await(r102);     // Catch: CancellationException -> L13
        if (r103 != r104) goto L37;
        return r104;
    L22:
        if (r107.isCompleted() == false) goto L24;
    L26:
        if (r106 == true) goto L29;
        r107 = null;
    L29:
        if (r107 == null) goto L31;
        FLogger.f375446a.i("ConnectorListRepository", "[refreshConnectorList] reuse request, scene=" + r110);     // Catch: Throwable -> L44
        goto L32
    L24:
        if (r107.isCancelled() == true) goto L26;
        r106 = true;
    L44:
        th = move-exception;
        throw th;
    L13:
        e = move-exception;
        if (JobKt.isActive(r102.getContext()) == true) goto L42;
        throw e;
    L42:
        return p.b.f330222a;
    L7:
        r100 = new ConnectorListRepository$refreshConnectorList$1(this, r210);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Object a(ConnectorListRepository r210, String r211, Continuation r212) {
        r210.getClass();
        if ((r212 instanceof ConnectorListRepository$requestConnectorList$1) == false) goto L7;
        ConnectorListRepository$requestConnectorList$1 r100 = (ConnectorListRepository$requestConnectorList$1) r212;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        ConnectorListRepository$requestConnectorList$1 r110 = r100;
        Object r102 = r110.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r110.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        String r105 = (String) r110.L$0;
        ResultKt.throwOnFailure(r102);
        Object r106 = r102;
        String r107 = r105;
    L17:
        com.larus.network.http.a r108 = (com.larus.network.http.a) r106;
        String r109 = "";
        if ((r108 instanceof y) == false) goto L71;
        com.larus.bmhome.taskskill.network.c r111 = (com.larus.bmhome.taskskill.network.c) ((y) r108).f360135b;
        if (r111 == null) goto L22;
        List<com.larus.bmhome.taskskill.network.d> r112 = r111.a();
    L23:
        if (r112 != null) goto L25;
        r112 = CollectionsKt.emptyList();
    L25:
        List r113 = CollectionsKt.filterNotNull(r112);
        ArrayList r114 = new ArrayList();
        Iterator r115 = r113.iterator();
    L27:
        if (r115.hasNext() == false) goto L69;
        com.larus.bmhome.taskskill.network.d r116 = (com.larus.bmhome.taskskill.network.d) r115.next();
        String r117 = r116.b();
        if (r117 != null) goto L31;
    L66:
        n r118 = null;
    L67:
        if (r118 == null) goto L27;
        r114.add(r118);
        goto L27
    L31:
        if ((!StringsKt.isBlank(r117)) == false) goto L33;
        String r119 = r117;
    L34:
        if (r119 == null) goto L66;
        String r120 = r116.e();
        if (r120 != null) goto L39;
    L43:
        r120 = r116.i();
        if (r120 != null) goto L46;
        String r121 = "";
    L48:
        if (StringsKt.isBlank(r121) == true) goto L66;
        String r122 = r116.d();
        if (r122 != null) goto L53;
    L57:
        r122 = r116.c();
        if (r122 != null) goto L60;
        String r123 = "";
    L61:
        String r124 = r116.g();
        if (r124 != null) goto L64;
        String r125 = "";
    L65:
        r118 = new n(r119, r121, r123, r125, r116.h(), r116.a(), r116.f(), r116.j());
        goto L67
    L64:
        r125 = r124;
    L60:
        r123 = r122;
        goto L61
    L53:
        if ((!StringsKt.isBlank(r122)) == true) goto L56;
        r122 = null;
    L56:
        if (r122 != null) goto L60;
    L46:
        r121 = r120;
        goto L48
    L39:
        if ((!StringsKt.isBlank(r120)) == true) goto L42;
        r120 = null;
    L42:
        if (r120 != null) goto L46;
    L33:
        r119 = null;
        goto L34
    L69:
        FLogger.f375446a.i("ConnectorListRepository", "[requestConnectorList] success, scene=" + r107 + ", size=" + r114.size());
        Object r126 = new p.c(r114);
    L79:
        return r126;
    L22:
        r112 = null;
        goto L23
    L71:
        if ((r108 instanceof com.larus.network.http.f) == false) goto L77;
        FLogger r127 = FLogger.f375446a;
        StringBuilder r128 = new StringBuilder("[requestConnectorList] failed, scene=");
        r128.append(r107);
        r128.append(", code=");
        com.larus.network.http.f r129 = (com.larus.network.http.f) r108;
        r128.append(r129.f360157d.getCode());
        r128.append(", msg=");
        r128.append(r129.f360157d.getMessage());
        r127.w("ConnectorListRepository", r128.toString());
        String r130 = r129.f360157d.getMessage();
        if (r130 == null) goto L76;
        r109 = r130;
    L76:
        r126 = new p.a(r109);
        goto L79
    L77:
        r126 = new p.a("");
        goto L79
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r102);
        com.larus.bmhome.taskskill.network.b.f314373a.a();
        r107 = r211;
        r110.L$0 = r107;
        r110.label = 1;
        r106 = HttpExtKt.k(ServiceType.BASIC_SERVICE, com.larus.bmhome.taskskill.network.c.class, "/alice/office/skills/connector/list_by_user", new JSONObject(), null, null, true, null, null, null, r110, MediaPlayer.MEDIA_PLAYER_OPTION_HTTP2_PARAMS);
        if (r106 != r103) goto L17;
        return r103;
    L7:
        r100 = new ConnectorListRepository$requestConnectorList$1(r210, r212);
        goto L8
    }

    public static boolean d(String r100, String r110, boolean r111) {
        Object r101 = f330184c;
        monitor-enter(r101);
        boolean r102 = false;
        if (Intrinsics.areEqual(r100, f330185d) == true) goto L7;
    L23:
        Deferred<? extends p> r112 = null;
    L24:
        monitor-exit(r101);
        if (r112 == null) goto L27;
        Job.DefaultImpls.cancel$default(r112, null, 1, null);
    L27:
        return r102;
    L7:
        if (Intrinsics.areEqual(r100, AccountService.f365697a.getUserId()) == false) goto L23;
        List r103 = (List) f330188g.getValue();     // Catch: Throwable -> L28
        if (r103 == null) goto L23;
        List r104 = r103;     // Catch: Throwable -> L28
        ArrayList r105 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r104, 10));     // Catch: Throwable -> L28
        Iterator r106 = r104.iterator();     // Catch: Throwable -> L28
        boolean r107 = false;
    L14:
        if (r106.hasNext() == false) goto L19;
        n r108 = (n) r106.next();     // Catch: Throwable -> L28
        if (Intrinsics.areEqual(r108.f330210a, r110) == false) goto L18;
        r108 = n.a(r108, r111);     // Catch: Throwable -> L28
        r107 = true;
    L18:
        r105.add(r108);     // Catch: Throwable -> L28
        goto L14
    L19:
        if (r107 == false) goto L23;
        f330186e++;     // Catch: Throwable -> L28
        r112 = f330187f;     // Catch: Throwable -> L28
        f330187f = null;     // Catch: Throwable -> L28
        s.f330225a.getClass();     // Catch: Throwable -> L28
        s.c(r100, r105);     // Catch: Throwable -> L28
        f330188g.setValue(r105);     // Catch: Throwable -> L28
        r102 = true;
    L28:
        th = move-exception;
        throw th;
    }

    public final Object g(String r210, boolean r211, int r212, Continuation<? super Boolean> r213) {
        String r100 = r210;
        boolean r101 = r211;
        if ((r213 instanceof ConnectorListRepository$updateConnectorEnabled$1) == false) goto L7;
        ConnectorListRepository$updateConnectorEnabled$1 r102 = (ConnectorListRepository$updateConnectorEnabled$1) r213;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        ConnectorListRepository$updateConnectorEnabled$1 r110 = r102;
        Object r104 = r110.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r110.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        boolean r107 = r110.Z$0;
        String r108 = (String) r110.L$1;
        String r109 = (String) r110.L$0;
        ResultKt.throwOnFailure(r104);
        Object r111 = r104;
        r101 = r107;
        r100 = r109;
        String r112 = r108;
    L22:
        com.larus.network.http.a r113 = (com.larus.network.http.a) r111;
        if ((r113 instanceof y) == false) goto L29;
        if (d(r112, r100, r101) == true) goto L27;
        FLogger.f375446a.i("ConnectorListRepository", "[updateConnectorEnabled] drop stale response");
    L31:
        boolean r114 = false;
    L33:
        return Boxing.boxBoolean(r114);
    L27:
        FLogger.f375446a.i("ConnectorListRepository", "[updateConnectorEnabled] success, connectorId=" + r100 + ", enabled=" + r101);
        r114 = true;
        goto L33
    L29:
        if ((r113 instanceof com.larus.network.http.f) == false) goto L31;
        FLogger r115 = FLogger.f375446a;
        StringBuilder r116 = new StringBuilder("[updateConnectorEnabled] failed, connectorId=");
        r116.append(r100);
        r116.append(", enabled=");
        r116.append(r101);
        r116.append(", code=");
        com.larus.network.http.f r117 = (com.larus.network.http.f) r113;
        r116.append(r117.f360157d.getCode());
        r116.append(", msg=");
        r116.append(r117.f360157d.getMessage());
        r115.w("ConnectorListRepository", r116.toString());
        goto L31
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        f(AccountService.f365697a.getUserId(), false);
        Object r118 = f330184c;
        monitor-enter(r118);
        String r119 = f330185d;     // Catch: Throwable -> L34
        monitor-exit(r118);
        com.larus.bmhome.taskskill.network.b.f314373a.a();
        r110.L$0 = r100;
        r110.L$1 = r119;
        r110.Z$0 = r101;
        r110.label = 1;
        JSONObject r120 = new JSONObject();
        r120.put("connector_id", r100);
        r120.put("enabled", r101);
        r120.put("skill_type", r212);
        Unit r121 = Unit.INSTANCE;
        r111 = HttpExtKt.k(ServiceType.BASIC_SERVICE, Object.class, "/alice/office/skills/manage/connector/set_enabled", r120, null, null, true, null, null, null, r110, MediaPlayer.MEDIA_PLAYER_OPTION_HTTP2_PARAMS);
        if (r111 != r105) goto L21;
        return r105;
    L21:
        r112 = r119;
    L34:
        th = move-exception;
        throw th;
    L7:
        r102 = new ConnectorListRepository$updateConnectorEnabled$1(this, r213);
        goto L8
    }
}
