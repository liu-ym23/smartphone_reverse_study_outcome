package com.larus.agents.impl.webfetch;

import android.os.Handler;
import android.os.Looper;
import com.larus.im.callback.IIMError;
import com.larus.im.internal.jni.bean.DispatchCommand;
import com.larus.im.internal.jni.bean.DispatchCommandBody;
import com.larus.im.internal.jni.bean.DispatchCommandPayload;
import com.larus.im.internal.jni.bean.DispatchErrorCode;
import com.larus.im.internal.jni.bean.GetWebpageRequestPayload;
import com.larus.im.internal.jni.bean.OmniDispatchCommandFrom;
import com.larus.im.internal.jni.bean.OmniDispatchCommandResponse;
import com.larus.im.service.a0;
import com.larus.utils.logger.FLogger;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f286844a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Handler f286845b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f286846c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final CoroutineScope f286847d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static boolean f286848e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static volatile WebFetchCommandProcessor f286849f;

    public c() {
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.agents.impl.webfetch.a] */
    static {
        f286844a = new c();
        f286845b = new Handler(Looper.getMainLooper());
        f286846c = new a();
        f286847d = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getDefault()));
    }

    /* JADX WARN: Type inference failed for: r4v0, types: [com.larus.agents.impl.webfetch.b] */
    public final void b() {
        if (f286849f == null) goto L5;
        return;
    L5:
        f286849f = new WebFetchCommandProcessor(f286847d, new d(), new b());
        com.larus.im.d.b().registerDispatchCommandListener(this);     // Catch: Exception -> L8
        FLogger.f375446a.i("WebPageFetch", "runtime_initialize_complete");     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        f286849f = null;
        FLogger.f375446a.i("WebPageFetch", "runtime_initialize_failed exception_type=".concat(e.getClass().getSimpleName()));
    }

    /* JADX WARN: Type inference failed for: r6v13, types: [T, com.larus.agents.impl.webfetch.WebFetchCommandProcessor$b, java.lang.Object] */
    @Override // com.larus.im.service.a0
    public final void onReceiveDispatchCommand(OmniDispatchCommandResponse r110) {
        Intrinsics.checkNotNullParameter(r110, "response");
        DispatchCommandPayload r100 = r110.payload;
        if (r100 != null) goto L6;
        return;
    L6:
        if (r100.command == DispatchCommand.GET_WEBPAGE_REQUEST) goto L8;
        return;
    L8:
        String r101 = k.a(r100.commandId);
        FLogger r102 = FLogger.f375446a;
        r102.i("WebPageFetch", "command_received command_id=".concat(r101));
        if (r110.from == OmniDispatchCommandFrom.FROM_DISPATCHER) goto L13;
        r102.i("WebPageFetch", "command_rejected command_id=" + r101 + " reason=invalid_source");
        return;
    L13:
        if (r100.errorCode == DispatchErrorCode.DISPATCH_ERROR_CODE_SUCCESS) goto L16;
        r102.i("WebPageFetch", "command_rejected command_id=" + r101 + " reason=dispatch_error code=" + r100.errorCode);
        return;
    L16:
        DispatchCommandBody r103 = r100.body;
        if (r103 == null) goto L19;
        GetWebpageRequestPayload r104 = r103.getWebpageRequest;
    L20:
        WebFetchCommandProcessor r105 = f286849f;
        if (r105 != null) goto L24;
        r102.i("WebPageFetch", "command_rejected command_id=" + r101 + " reason=runtime_unavailable");
        return;
    L24:
        String r106 = r100.commandId;
        if (r106 != null) goto L27;
        r106 = "";
    L27:
        String r107 = r106;
        String r108 = r100.sourceDeviceId;
        if (r108 != null) goto L30;
        r108 = "";
    L30:
        String r109 = r108;
        int r111 = r100.sourceAppId;
        if (r104 == null) goto L33;
        String r112 = r104.url;
    L34:
        int r113 = 0;
        if (r104 == null) goto L37;
        boolean r114 = r104.useCookie;
    L38:
        if (r104 == null) goto L40;
        int r115 = r104.maxBytes;
    L41:
        i r116 = new i(r107, r109, r111, r112, r114, r115);
        Intrinsics.checkNotNullParameter(r116, "command");
        boolean r117 = true;
        if ((!StringsKt.isBlank(r116.f286859a)) == true) goto L44;
    L52:
        boolean r118 = false;
    L53:
        if (r118 == true) goto L55;
        WebFetchCommandProcessor.c(r116, "command_rejected reason=invalid_route");
    L109:
        r117 = false;
    L114:
        FLogger r119 = FLogger.f375446a;
        StringBuilder r120 = new StringBuilder("command_submit command_id=");
        r120.append(r101);
        r120.append(" accepted=");
        r120.append(r117);
        r120.append(" url_length=");
        if (r104 == null) goto L119;
        String r121 = r104.url;
        if (r121 == null) goto L119;
        r113 = r121.length();
    L119:
        r120.append(r113);
        r119.i("WebPageFetch", r120.toString());
        return;
    L55:
        int r122 = h.f286854e;
        if (h.a.a().f286858d == false) goto L58;
        WebFetchCommandProcessor.c(r116, "command_rejected reason=disabled");
        goto L109
    L58:
        Ref.ObjectRef r123 = new Ref.ObjectRef();
        Object r124 = r105.f286808f;
        monitor-enter(r124);
        final double r125 = r105.f286805c.invoke().doubleValue();     // Catch: Throwable -> L121
        CollectionsKt.removeAll(r105.f286809g.entrySet(), new j(r125));     // Catch: Throwable -> L121
        WebFetchCommandProcessor.b r126 = r105.f286809g.get(r116.f286859a);     // Catch: Throwable -> L121
        if (r126 == null) goto L69;
        boolean r127 = Intrinsics.areEqual(r126.f286811a, r116);     // Catch: Throwable -> L121
        StringBuilder r128 = new StringBuilder("command_duplicate identical=");     // Catch: Throwable -> L121
        r128.append(r127);     // Catch: Throwable -> L121
        r128.append(" completed=");     // Catch: Throwable -> L121
        if (r126.f286813c != null) goto L66;
        r117 = false;
    L66:
        r128.append(r117);     // Catch: Throwable -> L121
        WebFetchCommandProcessor.c(r116, r128.toString());     // Catch: Throwable -> L121
        monitor-exit(r124);
        r117 = r127;
        goto L114
    L69:
        Collection<WebFetchCommandProcessor.b> r129 = r105.f286809g.values();     // Catch: Throwable -> L121
        if ((r129 instanceof Collection) == true) goto L72;
    L74:
        Iterator<T> r130 = r129.iterator();     // Catch: Throwable -> L121
        int r131 = 0;
    L76:
        if (r130.hasNext() == false) goto L86;
        if (((WebFetchCommandProcessor.b) r130.next()).f286813c != null) goto L80;
        boolean r132 = true;
    L81:
        if (r132 == false) goto L76;
        r131 = r131 + 1;     // Catch: Throwable -> L121
        if (r131 >= 0) goto L76;
        CollectionsKt.throwCountOverflow();     // Catch: Throwable -> L121
        goto L76
    L80:
        r132 = false;
    L86:
        if (r131 < 12) goto L91;
        WebFetchCommandProcessor.c(r116, "command_rejected reason=active_capacity active_count=" + r131);     // Catch: Throwable -> L121
        monitor-exit(r124);
        goto L109
    L91:
        if (r105.f286809g.size() < 64) goto L111;
        Iterator<T> r133 = r105.f286809g.entrySet().iterator();     // Catch: Throwable -> L121
    L94:
        if (r133.hasNext() == false) goto L101;
        Object r134 = r133.next();     // Catch: Throwable -> L121
        if (((WebFetchCommandProcessor.b) ((Map.Entry) r134).getValue()).f286813c == null) goto L98;
        boolean r135 = true;
    L99:
        if (r135 == false) goto L94;
    L102:
        Map.Entry r136 = (Map.Entry) r134;     // Catch: Throwable -> L121
        if (r136 == null) goto L105;
        String r137 = (String) r136.getKey();     // Catch: Throwable -> L121
    L106:
        if (r137 != null) goto L110;
        WebFetchCommandProcessor.c(r116, "command_rejected reason=tracked_capacity tracked_count=" + r105.f286809g.size());     // Catch: Throwable -> L121
        monitor-exit(r124);
        goto L109
    L110:
        r105.f286809g.remove(r137);     // Catch: Throwable -> L121
        goto L111
    L105:
        r137 = null;
        goto L106
    L98:
        r135 = false;
        goto L99
    L101:
        r134 = null;
    L111:
        ?? r138 = new WebFetchCommandProcessor.b(r116, r125);     // Catch: Throwable -> L121
        r123.element = r138;     // Catch: Throwable -> L121
        r105.f286809g.put(r116.f286859a, (WebFetchCommandProcessor.b) r138);     // Catch: Throwable -> L121
        WebFetchCommandProcessor.c(r116, "command_queued active_count=" + (r131 + 1) + " tracked_count=" + r105.f286809g.size());     // Catch: Throwable -> L121
        Unit r139 = Unit.INSTANCE;     // Catch: Throwable -> L121
        monitor-exit(r124);
        BuildersKt.launch$default(r105.f286803a, null, null, new WebFetchCommandProcessor$submit$2(r105, r123, null), 3, null);
        goto L114
    L72:
        if (r129.isEmpty() == false) goto L74;
        r131 = 0;
    L121:
        th = move-exception;
        throw th;
    L44:
        if (r116.f286859a.length() > 128) goto L52;
        if ((!StringsKt.isBlank(r116.f286860b)) == false) goto L52;
        if (r116.f286860b.length() > 128) goto L52;
        if (r116.f286861c <= 0) goto L52;
        r118 = true;
        goto L53
    L40:
        r115 = 0;
        goto L41
    L37:
        r114 = false;
        goto L38
    L33:
        r112 = null;
        goto L34
    L19:
        r104 = null;
        goto L20
    }

    @Override // com.larus.im.service.a0
    public final void a(String r100, String r101, IIMError r102) {
        a0.a.a(r100, r101, r102);
    }
}
