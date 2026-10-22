package io.ktor.websocket;

import com.bytedance.android.ecom.arch.slice.slices.template.TemplateNodeType;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.pitaya.api.PTYSocketStateCallback;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.a0;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.channels.SendChannel;

/* JADX INFO: loaded from: classes41.dex */
public final class DefaultWebSocketSessionImpl implements io.ktor.websocket.a, m {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f492142k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f492143l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f492144m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final c.e f492145n = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m f492146a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CompletableDeferred<CloseReason> f492147b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Channel<c> f492148c;
    private volatile /* synthetic */ int closed;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Channel<c> f492149d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CompletableJob f492150e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<j<?>> f492151f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final CoroutineContext f492152g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f492153h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f492154i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final CompletableDeferred f492155j;
    volatile /* synthetic */ Object pinger;
    private volatile /* synthetic */ int started;

    public static final class a {
    }

    static {
        f492145n = new c.e(new byte[0], e.f492176a);
        f492142k = AtomicReferenceFieldUpdater.newUpdater(DefaultWebSocketSessionImpl.class, Object.class, "pinger");
        f492143l = AtomicIntegerFieldUpdater.newUpdater(DefaultWebSocketSessionImpl.class, PTYSocketStateCallback.CLOSED);
        f492144m = AtomicIntegerFieldUpdater.newUpdater(DefaultWebSocketSessionImpl.class, "started");
    }

    @Override // io.ktor.websocket.m
    public final long WH() {
        return this.f492146a.WH();
    }

    public final void c() {
        long r100 = this.f492153h;
        if (this.closed == 0) goto L6;
    L4:
        Throwable r101 = null;
        Channel r102 = null;
    L9:
        SendChannel r103 = (SendChannel) f492142k.getAndSet(this, r102);
        if (r103 == null) goto L12;
        r103.close(r101);
    L12:
        if (r102 == null) goto L15;
        Object r104 = r102.mo10962trySendJP2dKIU(f492145n);
        kotlinx.coroutines.channels.g.c r105 = kotlinx.coroutines.channels.g.f504696b;
        boolean r106 = r104 instanceof kotlinx.coroutines.channels.g.c;
    L15:
        if (this.closed == 0) goto L19;
        if (r102 == null) goto L20;
        c();
        return;
    L20:
        return;
    L19:
        return;
    L6:
        if (r100 <= 0) goto L4;
        SendChannel<c> r110 = this.f492146a.Ec();
        long r111 = this.f492154i;
        DefaultWebSocketSessionImpl$runOrCancelPinger$newPinger$1 r112 = new DefaultWebSocketSessionImpl$runOrCancelPinger$newPinger$1(this, null);
        a0 r107 = f.f492177a;
        Intrinsics.checkNotNullParameter(this, "<this>");
        Intrinsics.checkNotNullParameter(r110, "outgoing");
        Intrinsics.checkNotNullParameter(r112, "onTimeout");
        final CompletableJob r108 = JobKt.Job$default(null, 1, null);
        Channel r113 = ChannelKt.Channel$default(Integer.MAX_VALUE, null, null, 6, null);
        r101 = null;
        BuildersKt.launch$default(this, r108.plus(f.f492178b), null, new PingPongKt$pinger$1(r100, r111, r112, r113, r110, null), 2, null);
        CoroutineContext.Element r109 = this.f492152g.get(Job.Key);
        Intrinsics.checkNotNull(r109);
        ((Job) r109).invokeOnCompletion(new PingPongKt$pinger$2(r108));
        r102 = r113;
        goto L9
    }

    @Override // io.ktor.websocket.m
    public final SendChannel<c> Ec() {
        return this.f492149d;
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public final CoroutineContext getCoroutineContext() {
        return this.f492152g;
    }

    @Override // io.ktor.websocket.m
    public final ReceiveChannel<c> oT() {
        return this.f492148c;
    }

    @Override // io.ktor.websocket.a
    public final void Ja(List<? extends j<?>> r110) {
        Intrinsics.checkNotNullParameter(r110, "negotiatedExtensions");
        if (f492144m.compareAndSet(this, 0, 1) == false) goto L7;
        b.f492163a.trace("Starting default WebSocketSession(" + this + ") with negotiated extensions: " + CollectionsKt.joinToString$default(r110, null, null, null, 0, null, null, 63, null));
        ((ArrayList) this.f492151f).addAll(r110);
        c();
        Channel<c> r111 = this.f492149d;
        a0 r100 = f.f492177a;
        Intrinsics.checkNotNullParameter(this, "<this>");
        Intrinsics.checkNotNullParameter(r111, "outgoing");
        Channel r101 = ChannelKt.Channel$default(5, null, null, 6, null);
        BuildersKt.launch$default(this, f.f492177a, null, new PingPongKt$ponger$1(r101, r111, null), 2, null);
        BuildersKt.launch$default(this, b.f492164b.plus(Dispatchers.getUnconfined()), null, new DefaultWebSocketSessionImpl$runIncomingProcessor$1(this, r101, null), 2, null);
        BuildersKt.launch(this, b.f492165c.plus(Dispatchers.getUnconfined()), CoroutineStart.UNDISPATCHED, new DefaultWebSocketSessionImpl$runOutgoingProcessor$1(this, null));
        return;
    L7:
        throw new IllegalStateException(("WebSocket session " + this + " is already started.").toString());
    }

    @Override // io.ktor.websocket.m
    public final void XO(long r100) {
        this.f492146a.XO(r100);
    }

    @Override // io.ktor.websocket.m
    public final Object hW(Continuation<? super Unit> r100) {
        Object r101 = this.f492146a.hW(r100);
        if (r101 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r101;
    L6:
        return Unit.INSTANCE;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x00ed -> B:20:0x0063). Please report as a decompilation issue!!! */
    public static final Object b(DefaultWebSocketSessionImpl r110, Continuation r111) {
        r110.getClass();
        if ((r111 instanceof DefaultWebSocketSessionImpl$outgoingProcessorLoop$1) == false) goto L7;
        DefaultWebSocketSessionImpl$outgoingProcessorLoop$1 r100 = (DefaultWebSocketSessionImpl$outgoingProcessorLoop$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r112 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L19;
        if (r103 == 1) goto L17;
        if (r103 == 2) goto L16;
        if (r103 != 3) goto L15;
        ChannelIterator<c> r113 = (ChannelIterator) r100.L$1;
        DefaultWebSocketSessionImpl r104 = (DefaultWebSocketSessionImpl) r100.L$0;
        ResultKt.throwOnFailure(r112);
        ChannelIterator<c> r114 = r113;
        r110 = r104;
    L20:
        r100.L$0 = r110;
        r100.L$1 = r114;
        r100.label = 1;
        Object r105 = r114.hasNext(r100);
        if (r105 == r102) goto L48;
        DefaultWebSocketSessionImpl$outgoingProcessorLoop$1 r106 = r100;
        ChannelIterator<c> r107 = r114;
        r112 = r105;
    L18:
        Object r108 = r102;
        DefaultWebSocketSessionImpl$outgoingProcessorLoop$1 r109 = r106;
        if (((Boolean) r112).booleanValue() == false) goto L45;
        c r115 = r107.next();
        b.f492163a.trace("Sending " + r115 + " from session " + r110);
        if ((r115 instanceof c.b) == false) goto L32;
        CloseReason r116 = d.a((c.b) r115);
        r109.L$0 = null;
        r109.L$1 = null;
        r109.label = 2;
        if (r110.d(r116, null, r109) != r108) goto L45;
    L47:
        return r108;
    L32:
        if ((r115 instanceof c.f) == false) goto L34;
        boolean r117 = true;
    L35:
        if (r117 == false) goto L40;
        Iterator r118 = ((ArrayList) r110.f492151f).iterator();
    L38:
        if (r118.hasNext() == false) goto L40;
        r115 = ((j) r118.next()).c();
    L40:
        SendChannel<c> r119 = r110.f492146a.Ec();
        r109.L$0 = r110;
        r109.L$1 = r107;
        r109.label = 3;
        if (r119.send(r115, r109) == r108) goto L47;
        r114 = r107;
        r100 = r109;
        r102 = r108;
        goto L20
    L34:
        r117 = r115 instanceof c.a;
    L45:
        return Unit.INSTANCE;
    L48:
        return r102;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r112);
        goto L45
    L17:
        ChannelIterator<c> r120 = (ChannelIterator) r100.L$1;
        DefaultWebSocketSessionImpl r121 = (DefaultWebSocketSessionImpl) r100.L$0;
        ResultKt.throwOnFailure(r112);
        r106 = r100;
        r107 = r120;
        r110 = r121;
        goto L18
    L19:
        ResultKt.throwOnFailure(r112);
        r114 = r110.f492149d.iterator();
    L7:
        r100 = new DefaultWebSocketSessionImpl$outgoingProcessorLoop$1(r110, r111);
        goto L8
    }

    @Override // io.ktor.websocket.m
    public final Object FQ(c.b r100, Continuation r101) {
        Object r102 = Ec().send(r100, r101);
        if (r102 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L7;
        r102 = Unit.INSTANCE;
    L7:
        if (r102 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L10;
        return r102;
    L10:
        return Unit.INSTANCE;
    }

    public DefaultWebSocketSessionImpl(m r100, long r101, long r102) {
        Intrinsics.checkNotNullParameter(r100, TemplateNodeType.RAW);
        this.f492146a = r100;
        this.pinger = null;
        CompletableDeferred<CloseReason> r103 = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        this.f492147b = r103;
        int r104 = 8;
        this.f492148c = ChannelKt.Channel$default(8, null, null, 6, null);
        String r105 = System.getProperty("io.ktor.websocket.outgoingChannelCapacity");
        if (r105 == null) goto L5;
        r104 = CastIntegerProtector.parseInt(r105);
    L5:
        this.f492149d = ChannelKt.Channel$default(r104, null, null, 6, null);
        this.closed = 0;
        CompletableJob r106 = JobKt.Job((Job) r100.getCoroutineContext().get(Job.Key));
        this.f492150e = r106;
        this.f492151f = new ArrayList();
        this.started = 0;
        this.f492152g = r100.getCoroutineContext().plus(r106).plus(new a0("ws-default"));
        this.f492153h = r101;
        this.f492154i = r102;
        this.f492155j = r103;
    }

    public final Object d(CloseReason r100, Throwable r101, Continuation<? super Unit> r102) {
        if ((r102 instanceof DefaultWebSocketSessionImpl$sendCloseSequence$1) == false) goto L7;
        DefaultWebSocketSessionImpl$sendCloseSequence$1 r103 = (DefaultWebSocketSessionImpl$sendCloseSequence$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L18;
        if (r107 != 1) goto L17;
        r100 = (CloseReason) r103.L$2;
        r101 = (Throwable) r103.L$1;
        DefaultWebSocketSessionImpl r108 = (DefaultWebSocketSessionImpl) r103.L$0;
        ResultKt.throwOnFailure(r105);     // Catch: Throwable -> L14
    L31:
        r108.f492147b.complete(r100);
        if (r101 == null) goto L35;
        r108.f492149d.close(r101);
        r108.f492148c.close(r101);
    L35:
        return Unit.INSTANCE;
    L14:
        th = th;
    L38:
        r108.f492147b.complete(r100);
        if (r101 == null) goto L41;
        r108.f492149d.close(r101);
        r108.f492148c.close(r101);
    L41:
        throw th;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r105);
        if (f492143l.compareAndSet(this, 0, 1) == false) goto L21;
        b.f492163a.trace("Sending Close Sequence for session " + this + " with reason " + r100 + " and exception " + r101);
        this.f492150e.complete();
        if (r100 != null) goto L44;
        r100 = new CloseReason(CloseReason.Codes.NORMAL, "");
    L44:
        c();     // Catch: Throwable -> L36
        if (r100.f492138a == CloseReason.Codes.CLOSED_ABNORMALLY.getCode()) goto L30;
        SendChannel<c> r109 = this.f492146a.Ec();     // Catch: Throwable -> L36
        c.b r110 = new c.b(r100);     // Catch: Throwable -> L36
        r103.L$0 = this;     // Catch: Throwable -> L36
        r103.L$1 = r101;     // Catch: Throwable -> L36
        r103.L$2 = r100;     // Catch: Throwable -> L36
        r103.label = 1;     // Catch: Throwable -> L36
        if (r109.send(r110, r103) != r106) goto L30;
        return r106;
    L30:
        r108 = this;
    L36:
        th = th;
        r108 = this;
        goto L38
    L21:
        return Unit.INSTANCE;
    L7:
        r103 = new DefaultWebSocketSessionImpl$sendCloseSequence$1(this, r102);
        goto L8
    }

    public static final Object a(DefaultWebSocketSessionImpl r100, io.ktor.utils.io.core.j r101, c r110, Continuation r111) {
        r100.getClass();
        if ((r111 instanceof DefaultWebSocketSessionImpl$checkMaxFrameSize$1) == false) goto L7;
        DefaultWebSocketSessionImpl$checkMaxFrameSize$1 r102 = (DefaultWebSocketSessionImpl$checkMaxFrameSize$1) r111;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r112 = r102.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r102.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L12;
        int r106 = r102.I$0;
        ResultKt.throwOnFailure(r112);
    L27:
        throw new FrameTooBigException(r106);
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r112);
        int r113 = r110.f492170c.length;
        if (r101 == null) goto L17;
        int r114 = r101.i();
    L18:
        int r115 = r113 + r114;
        if (r115 <= r100.WH()) goto L29;
        if (r101 == null) goto L22;
        r101.close();
    L22:
        CloseReason r107 = new CloseReason(CloseReason.Codes.TOO_BIG, "Frame is too big: " + r115 + ". Max size is " + r100.WH());
        r102.I$0 = r115;
        r102.label = 1;
        if (WebSocketSessionKt.a(r100, r107, r102) == r104) goto L30;
        r106 = r115;
        goto L27
    L30:
        return r104;
    L29:
        return Unit.INSTANCE;
    L17:
        r114 = 0;
    L7:
        r102 = new DefaultWebSocketSessionImpl$checkMaxFrameSize$1(r100, r111);
        goto L8
    }
}
