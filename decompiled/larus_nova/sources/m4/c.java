package m4;

import androidx.core.util.Consumer;
import com.bytedance.ai.bridge.protocol.model.ProtocolMessage;
import com.google.gson.JsonObject;
import d3.b0;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public abstract class c {
    private static final String BRIDGE_READY_MESSAGE = "__bridge_ready__";
    public static final a Companion = null;
    private b0 bridge;
    private final AtomicBoolean isClosed;
    private final s4.c<n4.c> localMessageCache;
    private volatile Function0<Unit> remoteReadyListener;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ void a(c r100, Consumer r101, n4.d r102) {
        setOnMessageCallback$lambda$0(r100, r101, r102);
    }

    public static /* synthetic */ void b(c r100, n4.c r101) {
        onRemoteReady$lambda$3(r100, r101);
    }

    public abstract void realPostMessage(n4.c r100);

    public abstract void realSetOnMessageCallback(Consumer<n4.d> r100);

    public void close() {
        this.localMessageCache.a();
        this.isClosed.compareAndSet(false, true);
    }

    public void onRemoteReady() {
        com.bytedance.ai.applet.base.log.b r100 = com.bytedance.ai.applet.base.log.a.f34518a;
        com.bytedance.ai.applet.base.log.a.a("ai_bridge", "[" + getClass().getSimpleName() + "] remoteReady");
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L9
        Function0<Unit> r102 = this.remoteReadyListener;     // Catch: Throwable -> L9
        if (r102 == null) goto L6;
        r102.invoke();     // Catch: Throwable -> L9
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L9
    L7:
        Object r104 = Result.m9449constructorimpl(r103);     // Catch: Throwable -> L9
    L11:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
        if (r105 == null) goto L14;
        com.bytedance.ai.applet.base.log.b r106 = com.bytedance.ai.applet.base.log.a.f34518a;
        com.bytedance.ai.applet.base.log.a.b("ai_bridge", "[" + getClass().getSimpleName() + "] remote ready listener failed: " + r105.getMessage(), null);
    L14:
        this.localMessageCache.d(new m4.a(this));
        return;
    L6:
        r103 = null;
    L9:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L11
    }

    public c() {
        this.isClosed = new AtomicBoolean(false);
        this.localMessageCache = new s4.c();
    }

    public final b0 getBridge$applet_bridge_release() {
        return this.bridge;
    }

    public final AtomicBoolean isClosed() {
        return this.isClosed;
    }

    public final com.bytedance.ai.bridge.core.a<JsonObject> handleSyncMessage(JsonObject r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        if (this.isClosed.get() == false) goto L6;
        int r101 = com.bytedance.ai.bridge.core.a.f35243a;
        return com.bytedance.ai.bridge.core.a.C0684a.a(0, "port is already closed");
    L6:
        b0 r102 = this.bridge;
        if (r102 != null) goto L11;
        int r103 = com.bytedance.ai.bridge.core.a.f35243a;
        return com.bytedance.ai.bridge.core.a.C0684a.a(0, "bridge is not initialized");
    L11:
        return r102.b(r100);
    }

    public final void postMessage$applet_bridge_release(n4.c r100) {
        Intrinsics.checkNotNullParameter(r100, "messageWrapper");
        n4.b r101 = r100.f517035b;
        if (r101 == null) goto L5;
        r101.a();
    L5:
        this.localMessageCache.b(r100);
    }

    public final void setBridge$applet_bridge_release(b0 r100) {
        this.bridge = r100;
    }

    public final void setOnMessageCallback$applet_bridge_release(final Consumer<n4.d> r100) {
        Intrinsics.checkNotNullParameter(r100, "consumer");
        realSetOnMessageCallback(new b(this, r100));
    }

    public final void setRemoteReadyListener(Function0<Unit> r100) {
        this.remoteReadyListener = r100;
    }

    private static final void onRemoteReady$lambda$3(c r100, n4.c r101) {
        if (r100.isClosed.get() == false) goto L5;
        return;
    L5:
        com.bytedance.ai.applet.base.log.b r102 = com.bytedance.ai.applet.base.log.a.f34518a;
        com.bytedance.ai.applet.base.log.a.a("ai_bridge", "[" + r100.getClass().getSimpleName() + "] post msg to view " + r101.f517034a);
        n4.b r103 = r101.f517035b;
        if (r103 == null) goto L8;
        r103.b();
    L8:
        Intrinsics.checkNotNull(r101);
        r100.realPostMessage(r101);
    }

    private static final void setOnMessageCallback$lambda$0(c r100, Consumer r101, n4.d r102) {
        ProtocolMessage r103 = r102.f517034a;
        if (r103.getType() == ProtocolMessage.Type.Event) goto L5;
    L8:
        r101.accept(r102);
        return;
    L5:
        if (Intrinsics.areEqual(r103.e(), BRIDGE_READY_MESSAGE) == false) goto L8;
        r100.onRemoteReady();
    }
}
