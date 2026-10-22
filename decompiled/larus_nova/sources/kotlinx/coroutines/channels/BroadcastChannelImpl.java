package kotlinx.coroutines.channels;

import com.ss.ttvideoengine.model.VideoRef;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;

/* JADX INFO: loaded from: classes42.dex */
public final class BroadcastChannelImpl<E> extends BufferedChannel<E> implements BroadcastChannel<E> {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f504645m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final ReentrantLock f504646n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public List<? extends BufferedChannel<E>> f504647o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Object f504648p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final HashMap<kotlinx.coroutines.selects.l<?>, Object> f504649q;

    public final class a extends BufferedChannel<E> {

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ BroadcastChannelImpl<E> f504650m;

        public a(BroadcastChannelImpl r100) {
            this.f504650m = r100;
            super(r100.f504645m, null);
        }

        @Override // kotlinx.coroutines.channels.BufferedChannel
        public final boolean f(Throwable r100) {
            BroadcastChannelImpl<E> r101 = this.f504650m;
            ReentrantLock r102 = r101.f504646n;
            r102.lock();
            BroadcastChannelImpl.N(r101, this);     // Catch: Throwable -> L6
            boolean r103 = super.f(r100);     // Catch: Throwable -> L6
            r102.unlock();
            return r103;
        L6:
            th = move-exception;
            r102.unlock();
            throw th;
        }
    }

    public final class b extends i<E> {

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final /* synthetic */ BroadcastChannelImpl<E> f504651n;

        public b(BroadcastChannelImpl r100) {
            this.f504651n = r100;
            super(1, BufferOverflow.DROP_OLDEST, null);
        }

        @Override // kotlinx.coroutines.channels.BufferedChannel
        public final boolean f(Throwable r100) {
            BroadcastChannelImpl.N(this.f504651n, this);
            return super.f(r100);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.channels.BroadcastChannelImpl$send$1, reason: invalid class name */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.channels.BroadcastChannelImpl", f = "BroadcastChannel.kt", i = {0, 0}, l = {VideoRef.VALUE_VIDEO_REF_POPULARITY_LEVEL}, m = "send", n = {"this", "element"}, s = {"L$0", "L$1"})
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ BroadcastChannelImpl<E> this$0;

        public AnonymousClass1(BroadcastChannelImpl<E> r100, Continuation<? super AnonymousClass1> r101) {
            this.this$0 = r100;
            super(r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            this.result = r100;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.send(null, this);
        }
    }

    public final E O() {
        ReentrantLock r100 = this.f504646n;
        r100.lock();
    L15:
        th = move-exception;
        r100.unlock();
        throw th;
    L4:
        if (isClosedForSend() == false) goto L9;
        Throwable r101 = m();     // Catch: Throwable -> L15
        if (r101 == null) goto L8;
        throw r101;     // Catch: Throwable -> L15
    L8:
        throw new IllegalStateException("This broadcast channel is closed");     // Catch: Throwable -> L15
    L9:
        E r102 = (E) this.f504648p;
        if (r102 == d.f504675a) goto L14;
        r100.unlock();
        return r102;
    L14:
        throw new IllegalStateException("No value".toString());     // Catch: Throwable -> L15
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel, kotlinx.coroutines.channels.SendChannel
    public final boolean isClosedForSend() {
        ReentrantLock r100 = this.f504646n;
        r100.lock();
        boolean r101 = super.isClosedForSend();     // Catch: Throwable -> L6
        r100.unlock();
        return r101;
    L6:
        th = move-exception;
        r100.unlock();
        throw th;
    }

    @Override // kotlinx.coroutines.channels.BroadcastChannel
    public final ReceiveChannel<E> openSubscription() {
        ReentrantLock r100 = this.f504646n;
        r100.lock();
    L20:
        th = move-exception;
        r100.unlock();
        throw th;
    L4:
        if (this.f504645m != (-1)) goto L6;
        a r101 = new b(this);     // Catch: Throwable -> L20
    L8:
        if (isClosedForSend() == false) goto L15;
        if (this.f504648p != d.f504675a) goto L15;
        SendChannel r102 = (BufferedChannel) r101;
        r102.close(m());     // Catch: Throwable -> L20
        r100.unlock();
        return r101;
    L15:
        if (this.f504648p == d.f504675a) goto L17;
        SendChannel r103 = (BufferedChannel) r101;
        r103.mo10962trySendJP2dKIU(O());     // Catch: Throwable -> L20
    L17:
        this.f504647o = CollectionsKt.plus(this.f504647o, r101);     // Catch: Throwable -> L20
        r100.unlock();
        return r101;
    L6:
        r101 = new a(this);     // Catch: Throwable -> L20
        goto L8
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel
    public final String toString() {
        StringBuilder r100 = new StringBuilder();
        if (this.f504648p == d.f504675a) goto L5;
        String r101 = "CONFLATED_ELEMENT=" + this.f504648p + "; ";
    L6:
        r100.append(r101);
        r100.append("BROADCAST=<");
        r100.append(super.toString());
        r100.append(">; SUBSCRIBERS=");
        r100.append(CollectionsKt.joinToString$default(this.f504647o, com.alipay.sdk.m.u.i.f25853b, "<", ">", 0, null, null, 56, null));
        return r100.toString();
    L5:
        r101 = "";
        goto L6
    }

    public BroadcastChannelImpl(int r100) {
        boolean r101 = false;
        super(0, null);
        this.f504645m = r100;
        if (r100 < 1) goto L5;
    L6:
        r101 = true;
    L7:
        if (r101 == false) goto L11;
        this.f504646n = new ReentrantLock();
        this.f504647o = CollectionsKt.emptyList();
        this.f504648p = d.f504675a;
        this.f504649q = new HashMap();
        return;
    L11:
        throw new IllegalArgumentException(("BroadcastChannel capacity must be positive or Channel.CONFLATED, but " + r100 + " was specified").toString());
    L5:
        if (r100 != (-1)) goto L7;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.channels.BufferedChannel, kotlinx.coroutines.channels.SendChannel
    public final boolean close(Throwable r100) {
        ReentrantLock r101 = this.f504646n;
        r101.lock();
        Iterator<T> r102 = this.f504647o.iterator();     // Catch: Throwable -> L16
    L5:
        if (r102.hasNext() == false) goto L7;
        ((BufferedChannel) r102.next()).close(r100);     // Catch: Throwable -> L16
        goto L5
    L7:
        List<? extends BufferedChannel<E>> r103 = this.f504647o;     // Catch: Throwable -> L16
        ArrayList r104 = new ArrayList();     // Catch: Throwable -> L16
        Iterator<T> r105 = r103.iterator();     // Catch: Throwable -> L16
    L9:
        if (r105.hasNext() == false) goto L13;
        Object r106 = r105.next();     // Catch: Throwable -> L16
        if (((BufferedChannel) r106).r() == false) goto L9;
        r104.add(r106);     // Catch: Throwable -> L16
        goto L9
    L13:
        this.f504647o = r104;     // Catch: Throwable -> L16
        boolean r107 = g(r100, false);     // Catch: Throwable -> L16
        r101.unlock();
        return r107;
    L16:
        th = move-exception;
        r101.unlock();
        throw th;
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel
    public final boolean f(Throwable r100) {
        ReentrantLock r101 = this.f504646n;
        r101.lock();
        Iterator<T> r102 = this.f504647o.iterator();     // Catch: Throwable -> L10
    L5:
        if (r102.hasNext() == false) goto L7;
        ((BufferedChannel) r102.next()).f(r100);     // Catch: Throwable -> L10
        goto L5
    L7:
        this.f504648p = d.f504675a;     // Catch: Throwable -> L10
        boolean r103 = super.f(r100);     // Catch: Throwable -> L10
        r101.unlock();
        return r103;
    L10:
        th = move-exception;
        r101.unlock();
        throw th;
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel, kotlinx.coroutines.channels.SendChannel
    /* JADX INFO: renamed from: trySend-JP2dKIU, reason: not valid java name */
    public final Object mo10962trySendJP2dKIU(E r100) {
        ReentrantLock r101 = this.f504646n;
        r101.lock();
    L33:
        th = move-exception;
        r101.unlock();
        throw th;
    L4:
        if (isClosedForSend() == false) goto L8;
        Object r102 = super.mo10962trySendJP2dKIU(r100);     // Catch: Throwable -> L33
        r101.unlock();
        return r102;
    L8:
        List<? extends BufferedChannel<E>> r103 = this.f504647o;     // Catch: Throwable -> L33
        boolean r104 = false;
        if ((r103 instanceof Collection) == true) goto L11;
    L13:
        Iterator<T> r105 = r103.iterator();     // Catch: Throwable -> L33
    L15:
        if (r105.hasNext() == false) goto L19;
        if (((BufferedChannel) r105.next()).H() == false) goto L15;
        r104 = true;
    L19:
        if (r104 == false) goto L24;
        g.c r106 = g.f504696b;     // Catch: Throwable -> L33
        g.c r107 = g.f504696b;     // Catch: Throwable -> L33
        r101.unlock();
        return r107;
    L24:
        if (this.f504645m != (-1)) goto L26;
        this.f504648p = r100;     // Catch: Throwable -> L33
    L26:
        Iterator<T> r108 = this.f504647o.iterator();     // Catch: Throwable -> L33
    L28:
        if (r108.hasNext() == false) goto L30;
        ((BufferedChannel) r108.next()).mo10962trySendJP2dKIU(r100);     // Catch: Throwable -> L33
        goto L28
    L30:
        g.c r109 = g.f504696b;     // Catch: Throwable -> L33
        Unit r110 = Unit.INSTANCE;     // Catch: Throwable -> L33
        r101.unlock();
        return r110;
    L11:
        if (r103.isEmpty() == false) goto L13;
        goto L13
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void N(BroadcastChannelImpl r100, ReceiveChannel r101) {
        ReentrantLock r102 = r100.f504646n;
        r102.lock();
        List<? extends BufferedChannel<E>> r103 = r100.f504647o;     // Catch: Throwable -> L15
        ArrayList r104 = new ArrayList();     // Catch: Throwable -> L15
        Iterator<T> r105 = r103.iterator();     // Catch: Throwable -> L15
    L5:
        if (r105.hasNext() == false) goto L12;
        Object r106 = r105.next();     // Catch: Throwable -> L15
        if (((BufferedChannel) r106) == r101) goto L9;
        boolean r107 = true;
    L10:
        if (r107 == false) goto L5;
        r104.add(r106);     // Catch: Throwable -> L15
        goto L5
    L9:
        r107 = false;
        goto L10
    L12:
        r100.f504647o = r104;     // Catch: Throwable -> L15
        Unit r108 = Unit.INSTANCE;     // Catch: Throwable -> L15
        r102.unlock();
        return;
    L15:
        th = move-exception;
        r102.unlock();
        throw th;
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel
    public final void E(kotlinx.coroutines.selects.l<?> r100, Object r101) {
        ReentrantLock r102 = this.f504646n;
        r102.lock();
        Object r103 = this.f504649q.remove(r100);     // Catch: Throwable -> L11
        if (r103 == null) goto L8;
        r100.c(r103);     // Catch: Throwable -> L11
        r102.unlock();
        return;
    L8:
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L11
        r102.unlock();
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(r100.getContext()), null, CoroutineStart.UNDISPATCHED, new BroadcastChannelImpl$registerSelectForSend$2(this, r101, r100, null), 1, null);
        return;
    L11:
        th = move-exception;
        r102.unlock();
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x007a -> B:28:0x007d). Please report as a decompilation issue!!! */
    @Override // kotlinx.coroutines.channels.BufferedChannel, kotlinx.coroutines.channels.SendChannel
    public final Object send(E r100, Continuation<? super Unit> r101) {
        if ((r101 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r102 = (AnonymousClass1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        Iterator r107 = (Iterator) r102.L$2;
        Object r108 = r102.L$1;
        BroadcastChannelImpl<E> r109 = (BroadcastChannelImpl) r102.L$0;
        ResultKt.throwOnFailure(r104);
    L29:
        if (((Boolean) r104).booleanValue() == false) goto L31;
    L35:
        Object r110 = r108;
    L23:
        if (r107.hasNext() == false) goto L37;
        BufferedChannel r111 = (BufferedChannel) r107.next();
        r102.L$0 = r109;
        r102.L$1 = r110;
        r102.L$2 = r107;
        r102.label = 1;
        Object r112 = r111.G(r110, r102);
        if (r112 != r105) goto L27;
        return r105;
    L27:
        r108 = r110;
        r104 = r112;
        goto L29
    L37:
        return Unit.INSTANCE;
    L31:
        if (r109.isClosedForSend() == false) goto L35;
        throw r109.p();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        ReentrantLock r113 = this.f504646n;
        r113.lock();
    L40:
        th = move-exception;
        r113.unlock();
        throw th;
    L16:
        if (isClosedForSend() == true) goto L39;
        if (this.f504645m != (-1)) goto L20;
        this.f504648p = r100;     // Catch: Throwable -> L40
    L20:
        List<? extends BufferedChannel<E>> r114 = this.f504647o;     // Catch: Throwable -> L40
        r113.unlock();
        r109 = this;
        r110 = r100;
        r107 = r114.iterator();
        goto L23
    L39:
        throw p();     // Catch: Throwable -> L40
    L7:
        r102 = new AnonymousClass1(this, r101);
        goto L8
    }
}
