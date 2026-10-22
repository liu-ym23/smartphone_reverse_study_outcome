package com.larus.asr.session;

import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final /* synthetic */ class i implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AtomicBoolean f287869a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ComponentAsrSession f287870b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f287871c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ com.larus.asr.session.component.b0 f287872d;

    public /* synthetic */ i(AtomicBoolean r100, ComponentAsrSession r101, int r102, com.larus.asr.session.component.b0 r103) {
        this.f287869a = r100;
        this.f287870b = r101;
        this.f287871c = r102;
        this.f287872d = r103;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r100) {
        AtomicBoolean r101 = this.f287869a;
        ComponentAsrSession r102 = this.f287870b;
        int r103 = this.f287871c;
        com.larus.asr.session.component.b0 r104 = this.f287872d;
        com.larus.asr.session.component.c0 r105 = (com.larus.asr.session.component.c0) r100;
        Intrinsics.checkNotNullParameter(r105, "result");
        if (r101.compareAndSet(false, true) == true) goto L6;
        return Unit.INSTANCE;
    L6:
        if (Intrinsics.areEqual(r105, com.larus.asr.session.component.c0.b.f287688a) == false) goto L9;
        r102.c(r103 + 1, r104);
    L12:
        return Unit.INSTANCE;
    L9:
        if (Intrinsics.areEqual(r105, com.larus.asr.session.component.c0.a.f287687a) == false) goto L14;
        com.larus.asr.session.component.f0 r106 = r104.getContext();
        r102.getClass();
        r106.f287706h.set(true);
        r106.f(true);
        goto L12
    L14:
        throw new NoWhenBranchMatchedException();
    }
}
