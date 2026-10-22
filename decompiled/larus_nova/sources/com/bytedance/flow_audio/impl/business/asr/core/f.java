package com.bytedance.flow_audio.impl.business.asr.core;

import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;

/* JADX INFO: loaded from: classes19.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FlowAsrEventProcessor f243928a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<d, Unit> f243929b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<Throwable, Unit> f243930c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Channel<a> f243931d;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final d f243932a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final CompletableDeferred<Result<Unit>> f243933b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f243932a, r101.f243932a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f243933b, r101.f243933b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f243932a.hashCode() * 31;
            CompletableDeferred<Result<Unit>> r101 = this.f243933b;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return r100 + r102;
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        public final String toString() {
            return "EventEnvelope(event=" + this.f243932a + ", completion=" + this.f243933b + ')';
        }

        public a(d r100, CompletableDeferred<Result<Unit>> r101) {
            Intrinsics.checkNotNullParameter(r100, "event");
            this.f243932a = r100;
            this.f243933b = r101;
        }
    }

    public final boolean a(d r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        Object r101 = this.f243931d.mo10962trySendJP2dKIU(new a(r100, null));
        kotlinx.coroutines.channels.g.c r102 = kotlinx.coroutines.channels.g.f504696b;
        boolean r103 = r101 instanceof kotlinx.coroutines.channels.g.c;
        if (r103 == false) goto L6;
        this.f243929b.invoke(r100);
    L6:
        return !r103;
    }

    public f(CoroutineScope r100, FlowAsrEventProcessor r101, y r102, z r110) {
        Intrinsics.checkNotNullParameter(r100, "scope");
        Intrinsics.checkNotNullParameter(r101, "processor");
        Intrinsics.checkNotNullParameter(r102, "onDispatchFailed");
        Intrinsics.checkNotNullParameter(r110, "onLoopFailure");
        this.f243928a = r101;
        this.f243929b = r102;
        this.f243930c = r110;
        this.f243931d = ChannelKt.Channel$default(Integer.MAX_VALUE, null, null, 6, null);
        BuildersKt.launch$default(r100, null, null, new FlowAsrEventLoop$1(this, null), 3, null);
    }
}
