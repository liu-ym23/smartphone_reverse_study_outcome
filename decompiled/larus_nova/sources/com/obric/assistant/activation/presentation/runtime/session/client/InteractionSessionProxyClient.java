package com.obric.assistant.activation.presentation.runtime.session.client;

import android.content.ComponentName;
import android.content.Context;
import android.os.DeadObjectException;
import android.os.RemoteException;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.activation.presentation.contract.ipc.IInteractionSessionProxy;
import com.obric.assistant.activation.presentation.contract.ipc.IObricInteractorBridgeService;
import com.obric.assistant.activation.presentation.contract.ipc.VoiceInteractionSessionController;
import com.obric.assistant.activation.presentation.runtime.manager.ObricInteractorPresentationBridge$binder$1;
import com.obric.assistant.activation.presentation.runtime.service.ObricMainProcessVoiceInteractionGatewayService;
import java.util.ArrayDeque;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelKt;

/* JADX INFO: loaded from: classes32.dex */
public final class InteractionSessionProxyClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Channel<a> f385484a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final CoroutineScope f385485b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static com.obric.assistant.activation.presentation.runtime.session.client.a f385486c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Context f385487d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Long f385488e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static VoiceInteractionSessionController f385489f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static ObricInteractorPresentationBridge$binder$1 f385490g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static IInteractionSessionProxy f385491h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static Long f385492i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static boolean f385493j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final ArrayDeque<b> f385494k = null;

    /* JADX INFO: renamed from: com.obric.assistant.activation.presentation.runtime.session.client.InteractionSessionProxyClient$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.activation.presentation.runtime.session.client.InteractionSessionProxyClient$1", f = "InteractionSessionProxyClient.kt", i = {}, l = {70}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;

        public AnonymousClass1(Continuation<? super AnonymousClass1> r100) {
            super(2, r100);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass1(r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0034 -> B:13:0x0039). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r110) {
            Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r101 = this.label;
            if (r101 == 0) goto L8;
            if (r101 != 1) goto L7;
            ChannelIterator<a> r102 = (ChannelIterator) this.L$0;
            ResultKt.throwOnFailure(r110);
            ChannelIterator<a> r103 = r102;
            Object r104 = r100;
            AnonymousClass1 r105 = this;
        L14:
            if (((Boolean) r110).booleanValue() == false) goto L26;
            a r111 = r103.next();
            r111.f385496b.invoke();     // Catch: Exception -> L18 CancellationException -> L20
        L23:
            AnonymousClass1 r112 = r105;
            r100 = r104;
            ChannelIterator<a> r106 = r103;
        L9:
            r112.L$0 = r106;
            r112.label = 1;
            Object r107 = r106.hasNext(r112);
            if (r107 != r100) goto L12;
            return r100;
        L12:
            Object r108 = r100;
            r105 = r112;
            r110 = r107;
            r103 = r106;
            r104 = r108;
            goto L14
        L20:
            e = move-exception;
            throw e;
        L18:
            e = move-exception;
            FLogger.f375446a.w("InteractionSessionPC", "command " + r111.f385495a + " failed", e);
            goto L23
        L26:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r110);
            r106 = InteractionSessionProxyClient.f385484a.iterator();
            r112 = this;
            goto L9
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f385495a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Function0<Unit> f385496b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f385495a, r101.f385495a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f385496b, r101.f385496b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f385495a.hashCode() * 31) + this.f385496b.hashCode();
        }

        public final String toString() {
            return "ClientCommand(name=" + this.f385495a + ", action=" + this.f385496b + ')';
        }

        public a(String r100, Function0<Unit> r101) {
            Intrinsics.checkNotNullParameter(r100, "name");
            Intrinsics.checkNotNullParameter(r101, "action");
            this.f385495a = r100;
            this.f385496b = r101;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f385497a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Function1<IInteractionSessionProxy, Unit> f385498b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f385497a, r101.f385497a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f385498b, r101.f385498b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f385497a.hashCode() * 31) + this.f385498b.hashCode();
        }

        public final String toString() {
            return "PendingSessionEvent(name=" + this.f385497a + ", dispatch=" + this.f385498b + ')';
        }

        /* JADX WARN: Multi-variable type inference failed */
        public b(String r100, Function1<? super IInteractionSessionProxy, Unit> r101) {
            Intrinsics.checkNotNullParameter(r100, "name");
            Intrinsics.checkNotNullParameter(r101, "dispatch");
            this.f385497a = r100;
            this.f385498b = r101;
        }
    }

    static {
        f385484a = ChannelKt.Channel$default(Integer.MAX_VALUE, null, null, 6, null);
        CoroutineScope r100 = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        f385485b = r100;
        f385494k = new ArrayDeque();
        BuildersKt.launch$default(r100, null, null, new AnonymousClass1(null), 3, null);
    }

    public static String a() {
        StringBuilder r100 = new StringBuilder("activeSessionId=");
        r100.append(f385488e);
        r100.append(", serviceAlive=");
        com.obric.assistant.activation.presentation.runtime.session.client.a r101 = f385486c;
        if (r101 == null) goto L5;
        IObricInteractorBridgeService r102 = r101.c();
    L6:
        boolean r103 = false;
        if (r102 == null) goto L9;
        boolean r104 = true;
    L10:
        r100.append(r104);
        r100.append(", sessionAlive=");
        if (b() == null) goto L13;
        r103 = true;
    L13:
        r100.append(r103);
        r100.append(", pending=");
        r100.append(f385494k.size());
        return r100.toString();
    L9:
        r104 = false;
        goto L10
    L5:
        r102 = null;
        goto L6
    }

    public static IInteractionSessionProxy b() {
        IInteractionSessionProxy r100 = f385491h;
        if (r100 != null) goto L5;
    L7:
        return null;
    L5:
        if (r100.asBinder().isBinderAlive() == false) goto L7;
        return r100;
    }

    public static void c(b r100) {
        if (f385493j == true) goto L6;
        FLogger.f375446a.i("InteractionSessionPC", "drop " + r100.f385497a + ": client is not initialized");
        return;
    L6:
        IInteractionSessionProxy r101 = b();
        if (r101 != null) goto L11;
        d(r100);
        FLogger.f375446a.i("InteractionSessionPC", r100.f385497a + " queued, size=" + f385494k.size());
        f(r100.f385497a);
        return;
    L11:
        if (e(r101) == true) goto L27;
        d(r100);
        FLogger.f375446a.i("InteractionSessionPC", r100.f385497a + " queued after handshake failure, size=" + f385494k.size());
        StringBuilder r102 = new StringBuilder();
        r102.append(r100.f385497a);
        r102.append("_handshake");
        f(r102.toString());
        return;
    L27:
        r100.f385498b.invoke(r101);     // Catch: RemoteException -> L16
        FLogger.f375446a.i("InteractionSessionPC", r100.f385497a + " dispatched");     // Catch: RemoteException -> L16
        return;
    L16:
        e = move-exception;
        if ((e instanceof DeadObjectException) == false) goto L25;
        ArrayDeque<b> r103 = f385494k;
        if (r103.size() < 32) goto L22;
        b r104 = r103.removeLast();
        FLogger.f375446a.w("InteractionSessionPC", "pending queue full, drop newest " + r104.f385497a + " to preserve failed " + r100.f385497a);
    L22:
        r103.addFirst(r100);
        FLogger.f375446a.w("InteractionSessionPC", r100.f385497a + " hit dead Session Binder, queued for replay, pending=" + r103.size(), e);
        f385491h = null;
        f385492i = null;
        com.obric.assistant.activation.presentation.runtime.session.client.a r105 = f385486c;
        if (r105 == null) goto L29;
        r105.d(f385487d);
        return;
    L29:
        return;
    L25:
        FLogger.f375446a.w("InteractionSessionPC", r100.f385497a + " dispatch failed and dropped", e);
    }

    public static void d(b r100) {
        ArrayDeque<b> r101 = f385494k;
        if (r101.size() < 32) goto L5;
        b r102 = r101.removeFirst();
        FLogger.f375446a.w("InteractionSessionPC", "pending queue full, drop oldest " + r102.f385497a + ", capacity=32");
    L5:
        r101.addLast(r100);
    }

    public static boolean e(IInteractionSessionProxy r100) {
        Long r101 = f385488e;
        if (r101 == null) goto L23;
        long r102 = r101.longValue();
        VoiceInteractionSessionController r103 = f385489f;
        if (r103 != null) goto L7;
        return true;
    L7:
        Long r104 = f385492i;
        if (r104 != null) goto L11;
    L21:
        r100.onSessionCreated(r102, r103);     // Catch: RemoteException -> L15
        f385492i = Long.valueOf(r102);     // Catch: RemoteException -> L15
        FLogger.f375446a.i("InteractionSessionPC", "active session handshake dispatched on demand, id=" + r102);     // Catch: RemoteException -> L15
        return true;
    L15:
        e = move-exception;
        FLogger.f375446a.w("InteractionSessionPC", "session handshake failed, id=" + r102, e);
        f385491h = null;
        f385492i = null;
        com.obric.assistant.activation.presentation.runtime.session.client.a r105 = f385486c;
        if (r105 == null) goto L19;
        r105.d(f385487d);
    L19:
        return false;
    L11:
        if (r104.longValue() != r102) goto L21;
        return true;
    L23:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v7, types: [com.obric.assistant.activation.presentation.runtime.session.client.c] */
    public static void f(String r100) {
        Context r101 = f385487d;
        if (r101 != null) goto L6;
        FLogger.f375446a.e("InteractionSessionPC", "cannot bind main process: application context is null, reason=" + r100);
        return;
    L6:
        FLogger r102 = FLogger.f375446a;
        r102.i("InteractionSessionPC", "main process connection requested, reason=" + r100);
        if (f385486c != null) goto L20;
        r102.i("InteractionSessionPC", "create service connection with class reference, component=".concat(ObricMainProcessVoiceInteractionGatewayService.class.getName()));
        com.obric.assistant.activation.presentation.runtime.session.client.a.C4589a r103 = com.obric.assistant.activation.presentation.runtime.session.client.a.f385499i;
        ComponentName r104 = new ComponentName(r101, ObricMainProcessVoiceInteractionGatewayService.class);
        Intrinsics.checkNotNullParameter(r104, "connName");
        com.obric.assistant.activation.presentation.runtime.session.client.a r105 = com.obric.assistant.activation.presentation.runtime.session.client.a.f385500j;
        if (r105 != 0) goto L19;
        monitor-enter(r103);
        com.obric.assistant.activation.presentation.runtime.session.client.a r106 = com.obric.assistant.activation.presentation.runtime.session.client.a.f385500j;     // Catch: Throwable -> L16
        r105 = r106;
        if (r106 != null) goto L14;
        com.obric.assistant.activation.presentation.runtime.session.client.a r107 = new com.obric.assistant.activation.presentation.runtime.session.client.a(r104);     // Catch: Throwable -> L16
        com.obric.assistant.activation.presentation.runtime.session.client.a.f385500j = r107;     // Catch: Throwable -> L16
        r105 = r107;
    L14:
        monitor-exit(r103);
    L16:
        th = move-exception;
        throw th;
    L19:
        r105.f(new c());
        r105.e(new d());
        f385486c = r105;
    L20:
        r102.i("InteractionSessionPC", "ensure service connection, " + a());
        com.obric.assistant.activation.presentation.runtime.session.client.a r108 = f385486c;
        if (r108 == null) goto L26;
        r108.a(r101);
        return;
    }

    public static void g(String r100, Function0 r101) {
        Object r102 = f385484a.mo10962trySendJP2dKIU(new a(r100, r101));
        kotlinx.coroutines.channels.g.c r103 = kotlinx.coroutines.channels.g.f504696b;
        if ((r102 instanceof kotlinx.coroutines.channels.g.c) == false) goto L9;
        FLogger r104 = FLogger.f375446a;
        String r105 = "enqueue command failed, name=".concat(r100);
        Throwable r106 = kotlinx.coroutines.channels.g.a(r102);
        if (r106 != null) goto L7;
        r106 = new IllegalStateException("command queue rejected ".concat(r100));
    L7:
        r104.w("InteractionSessionPC", r105, r106);
        return;
    }
}
