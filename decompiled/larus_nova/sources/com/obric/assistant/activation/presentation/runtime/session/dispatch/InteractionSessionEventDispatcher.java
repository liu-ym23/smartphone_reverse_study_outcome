package com.obric.assistant.activation.presentation.runtime.session.dispatch;

import android.app.assist.AssistContent;
import android.app.assist.AssistStructure;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.SystemClock;
import android.service.voice.VoiceInteractionSession;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.activation.presentation.runtime.manager.ObricListeningChildCoordinator;
import com.obric.assistant.activation.presentation.runtime.manager.s;
import com.obric.assistant.activation.presentation.runtime.session.InteractionSessionProxy$controller$1;
import com.obric.assistant.activation.presentation.runtime.session.client.InteractionSessionProxyClient;
import com.obric.assistant.activation.presentation.runtime.session.client.b;
import com.obric.assistant.activation.presentation.runtime.session.client.h;
import com.obric.assistant.activation.presentation.runtime.session.client.j;
import com.obric.assistant.activation.presentation.runtime.session.client.k;
import com.obric.assistant.activation.presentation.runtime.session.client.l;
import com.obric.assistant.activation.presentation.runtime.session.client.m;
import com.obric.assistant.activation.presentation.runtime.session.client.n;
import com.obric.assistant.activation.presentation.runtime.session.client.o;
import com.obric.assistant.activation.presentation.runtime.session.client.p;
import com.obric.assistant.common.utils.i;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.Channel;

/* JADX INFO: loaded from: classes32.dex */
public final class InteractionSessionEventDispatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final InteractionSessionEventDispatcher f385541a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final com.obric.assistant.activation.presentation.runtime.session.dispatch.a<a> f385542b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Long f385543c;

    public interface a {

        /* JADX INFO: renamed from: com.obric.assistant.activation.presentation.runtime.session.dispatch.InteractionSessionEventDispatcher$a$a, reason: collision with other inner class name */
        public static final class C4590a implements a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final long f385544a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final VoiceInteractionSession.AssistState f385545b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final String f385546c;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof C4590a) == true) goto L8;
                return false;
            L8:
                C4590a r101 = (C4590a) r100;
                if (this.f385544a == r101.f385544a) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.f385545b, r101.f385545b) == true) goto L14;
                return false;
            L14:
                return true;
            }

            public final int hashCode() {
                long r100 = this.f385544a;
                return (((int) (r100 ^ (r100 >>> 32))) * 31) + this.f385545b.hashCode();
            }

            public final String toString() {
                return "Assist(sessionId=" + this.f385544a + ", state=" + this.f385545b + ')';
            }

            @Override // com.obric.assistant.activation.presentation.runtime.session.dispatch.InteractionSessionEventDispatcher.a
            public final String getName() {
                return this.f385546c;
            }

            @Override // com.obric.assistant.activation.presentation.runtime.session.dispatch.InteractionSessionEventDispatcher.a
            public final long getSessionId() {
                return this.f385544a;
            }

            public C4590a(long r100, VoiceInteractionSession.AssistState r101) {
                Intrinsics.checkNotNullParameter(r101, "state");
                this.f385544a = r100;
                this.f385545b = r101;
                this.f385546c = "onHandleAssist";
            }
        }

        public static final class b implements a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final long f385547a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final Bitmap f385548b;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof b) == true) goto L8;
                return false;
            L8:
                b r101 = (b) r100;
                if (this.f385547a == r101.f385547a) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.f385548b, r101.f385548b) == true) goto L14;
                return false;
            L14:
                return true;
            }

            @Override // com.obric.assistant.activation.presentation.runtime.session.dispatch.InteractionSessionEventDispatcher.a
            public final String getName() {
                return "onHandleScreenshot";
            }

            public final int hashCode() {
                long r100 = this.f385547a;
                int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
                Bitmap r102 = this.f385548b;
                if (r102 != null) goto L5;
                int r103 = 0;
            L7:
                return r101 + r103;
            L5:
                r103 = r102.hashCode();
                goto L7
            }

            public final String toString() {
                return "Screenshot(sessionId=" + this.f385547a + ", bitmap=" + this.f385548b + ')';
            }

            @Override // com.obric.assistant.activation.presentation.runtime.session.dispatch.InteractionSessionEventDispatcher.a
            public final long getSessionId() {
                return this.f385547a;
            }

            public b(long r100, Bitmap r101) {
                this.f385547a = r100;
                this.f385548b = r101;
            }
        }

        public static final class c implements a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final long f385549a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final Bundle f385550b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final int f385551c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final String f385552d;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof c) == true) goto L8;
                return false;
            L8:
                c r101 = (c) r100;
                if (this.f385549a == r101.f385549a) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.f385550b, r101.f385550b) == true) goto L15;
                return false;
            L15:
                if (this.f385551c == r101.f385551c) goto L17;
                return false;
            L17:
                return true;
            }

            public final int hashCode() {
                long r100 = this.f385549a;
                return (((((int) (r100 ^ (r100 >>> 32))) * 31) + this.f385550b.hashCode()) * 31) + this.f385551c;
            }

            public final String toString() {
                return "Show(sessionId=" + this.f385549a + ", args=" + this.f385550b + ", showFlags=" + this.f385551c + ')';
            }

            @Override // com.obric.assistant.activation.presentation.runtime.session.dispatch.InteractionSessionEventDispatcher.a
            public final String getName() {
                return this.f385552d;
            }

            @Override // com.obric.assistant.activation.presentation.runtime.session.dispatch.InteractionSessionEventDispatcher.a
            public final long getSessionId() {
                return this.f385549a;
            }

            public c(long r100, Bundle r101, int r102) {
                Intrinsics.checkNotNullParameter(r101, "args");
                this.f385549a = r100;
                this.f385550b = r101;
                this.f385551c = r102;
                this.f385552d = SendEventContainerMethodParamModel.EventKinds.onShow;
            }
        }

        String getName();

        long getSessionId();
    }

    public InteractionSessionEventDispatcher() {
    }

    static {
        f385541a = new InteractionSessionEventDispatcher();
        f385542b = new com.obric.assistant.activation.presentation.runtime.session.dispatch.a();
    }

    public final synchronized void c(Context r100) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);     // Catch: Throwable -> L7
        Channel<InteractionSessionProxyClient.a> r101 = InteractionSessionProxyClient.f385484a;     // Catch: Throwable -> L7
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);     // Catch: Throwable -> L7
        final Context r102 = r100.getApplicationContext();     // Catch: Throwable -> L7
        InteractionSessionProxyClient.g("init", new b(r102));     // Catch: Throwable -> L7
        ObricListeningChildCoordinator r103 = ObricListeningChildCoordinator.f385289a;     // Catch: Throwable -> L7
        InteractionSessionEventDispatcher$init$1 r104 = new InteractionSessionEventDispatcher$init$1(this);     // Catch: Throwable -> L7
        r103.getClass();     // Catch: Throwable -> L7
        ObricListeningChildCoordinator.i(new s(r104));     // Catch: Throwable -> L7
        FLogger.f375446a.i("InteractionSessionED", "dispatcher_initialized: activeSessionId=" + f385543c + " waitingForAiKey=" + f385542b.f385554b);     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final synchronized boolean e(final long r100) {
        monitor-enter(this);
        Long r101 = f385543c;     // Catch: Throwable -> L17
        if (r101 != null) goto L8;
    L10:
        boolean r102 = false;
    L11:
        if (r102 == false) goto L13;
        a("session_destroyed", Long.valueOf(r100));     // Catch: Throwable -> L17
        f385543c = null;     // Catch: Throwable -> L17
    L14:
        InteractionSessionProxyClient.g("onSessionDestroyed", new h(r100));     // Catch: Throwable -> L17
        monitor-exit(this);
        return r102;
    L13:
        FLogger.f375446a.i("InteractionSessionED", "stale_session_destroyed: incoming=" + r100 + " active=" + f385543c);     // Catch: Throwable -> L17
        goto L14
    L8:
        if (r101.longValue() != r100) goto L10;
        r102 = true;
    L17:
        th = move-exception;
        throw th;
    }

    public static void a(String r100, Long r101) {
        com.obric.assistant.activation.presentation.runtime.session.dispatch.a<a> r102 = f385542b;
        boolean r103 = r102.f385554b;
        List<a> r104 = r102.b();
        r102.f385554b = false;
        FLogger r105 = FLogger.f375446a;
        r105.i("AiKeySessionEventGate", "gate_cleared: waitingBefore=" + r103 + " dropped=" + r104.size());
        r105.i("InteractionSessionED", "session_event_gate_cleared: reason=" + r100 + " sessionId=" + r101 + " dropped=" + r104.size());
    }

    public static void b(String r110, Integer r111, com.obric.assistant.activation.presentation.runtime.session.dispatch.a.b r210) {
        Iterator r100 = r210.f385557c.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        a r101 = (a) r100.next();
        FLogger.f375446a.w("InteractionSessionED", "gated_session_event_dropped: trigger=" + r110 + " dropped=" + r101.getName() + " sessionId=" + r101.getSessionId());
        goto L4
    L6:
        FLogger.f375446a.i("InteractionSessionED", "session_event_gate_result: trigger=" + r110 + " invocationType=" + r111 + " buffered=" + r210.f385556b + " released=" + r210.f385555a.size() + " waiting=" + f385542b.f385554b);
        Iterator r102 = r210.f385555a.iterator();
    L8:
        if (r102.hasNext() == false) goto L21;
        a r103 = (a) r102.next();
        FLogger.f375446a.i("InteractionSessionED", "session_event_admitted: name=" + r103.getName() + " sessionId=" + r103.getSessionId());
        if ((r103 instanceof a.c) == false) goto L13;
        a.c r104 = (a.c) r103;
        r104.f385550b.putLong("o_dispatch_to_main_process_time", SystemClock.uptimeMillis());
        Channel<InteractionSessionProxyClient.a> r105 = InteractionSessionProxyClient.f385484a;
        final long r106 = r104.f385549a;
        final Bundle r107 = r104.f385550b;
        final int r108 = r104.f385551c;
        Intrinsics.checkNotNullParameter(r107, "args");
        Intrinsics.checkNotNullParameter(r107, "<this>");
        final int r112 = r107.getInt("invocation_type");
        final InteractionSessionProxyClient.b r113 = new InteractionSessionProxyClient.b(SendEventContainerMethodParamModel.EventKinds.onShow, new j(r106, r107, r108));
        InteractionSessionProxyClient.g(r113.f385497a, new k(r106, r108, r112, r113));
    L18:
        r102 = r102;
        goto L8
    L13:
        if ((r103 instanceof a.C4590a) == false) goto L16;
        Channel<InteractionSessionProxyClient.a> r109 = InteractionSessionProxyClient.f385484a;
        a.C4590a r114 = (a.C4590a) r103;
        final long r115 = r114.f385544a;
        VoiceInteractionSession.AssistState r116 = r114.f385545b;
        Intrinsics.checkNotNullParameter(r116, "assistState");
        final int r117 = r116.getIndex();
        final int r118 = r116.getCount();
        final boolean r119 = r116.isFocused();
        final Bundle r120 = r116.getAssistData();
        final AssistStructure r121 = r116.getAssistStructure();
        final AssistContent r122 = r116.getAssistContent();
        final InteractionSessionProxyClient.b r123 = new InteractionSessionProxyClient.b("onHandleAssist", new l(r115, r117, r118, r119, r120, r121, r122));
        InteractionSessionProxyClient.g(r123.f385497a, new m(r115, r117, r118, r119, r123));
        goto L18
    L16:
        if ((r103 instanceof a.b) == false) goto L20;
        Channel<InteractionSessionProxyClient.a> r124 = InteractionSessionProxyClient.f385484a;
        a.b r125 = (a.b) r103;
        final long r126 = r125.f385547a;
        final Bitmap r127 = r125.f385548b;
        final InteractionSessionProxyClient.b r128 = new InteractionSessionProxyClient.b("onHandleScreenshot", new o(r126, r127));
        InteractionSessionProxyClient.g(r128.f385497a, new p(r126, r127, r128));
        goto L18
    L20:
        throw new NoWhenBranchMatchedException();
    }

    public final synchronized void d(Context r100, final long r101, final InteractionSessionProxy$controller$1 r110) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);     // Catch: Throwable -> L18
        Intrinsics.checkNotNullParameter(r110, "controller");     // Catch: Throwable -> L18
        Long r102 = f385543c;     // Catch: Throwable -> L18
        if (r102 != null) goto L7;
    L9:
        f385543c = Long.valueOf(r101);     // Catch: Throwable -> L18
        FLogger r103 = FLogger.f375446a;     // Catch: Throwable -> L18
        StringBuilder r104 = new StringBuilder("session_created: id=");     // Catch: Throwable -> L18
        r104.append(r101);     // Catch: Throwable -> L18
        r104.append(" replaced=");     // Catch: Throwable -> L18
        if (r102 != null) goto L12;
    L14:
        boolean r105 = false;
    L15:
        r104.append(r105);     // Catch: Throwable -> L18
        r103.i("InteractionSessionED", r104.toString());     // Catch: Throwable -> L18
        Channel<InteractionSessionProxyClient.a> r106 = InteractionSessionProxyClient.f385484a;     // Catch: Throwable -> L18
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);     // Catch: Throwable -> L18
        Intrinsics.checkNotNullParameter(r110, "controller");     // Catch: Throwable -> L18
        final Context r107 = r100.getApplicationContext();     // Catch: Throwable -> L18
        InteractionSessionProxyClient.g("onSessionCreated", new n(r107, r101, r110));     // Catch: Throwable -> L18
        monitor-exit(this);
        return;
    L12:
        if (r102.longValue() == r101) goto L14;
        r105 = true;
        goto L15
    L7:
        if (r102.longValue() == r101) goto L9;
        a("session_replaced", r102);     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;
    }

    public final synchronized void f(long r100, Bundle r101, int r102) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r101, "args");     // Catch: Throwable -> L13
        i.a r103 = i.a("InteractionSessionED_onShow");     // Catch: Throwable -> L13
        int r104 = r101.getInt("invocation_type", Integer.MIN_VALUE);     // Catch: Throwable -> L9
        a.c r105 = new a.c(r100, r101, r102);     // Catch: Throwable -> L9
        InteractionSessionEventDispatcher r106 = f385541a;     // Catch: Throwable -> L9
        String r107 = r105.f385552d;     // Catch: Throwable -> L9
        Integer r108 = Integer.valueOf(r104);     // Catch: Throwable -> L9
        com.obric.assistant.activation.presentation.runtime.session.dispatch.a.b r109 = f385542b.d(r104, r105);     // Catch: Throwable -> L9
        r106.getClass();     // Catch: Throwable -> L9
        b(r107, r108, r109);     // Catch: Throwable -> L9
        Unit r110 = Unit.INSTANCE;     // Catch: Throwable -> L9
        if (r103 == null) goto L7;
        r103.a();     // Catch: Throwable -> L13
    L7:
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        if (r103 == null) goto L12;
        r103.a();     // Catch: Throwable -> L13
    L12:
        throw th;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }
}
