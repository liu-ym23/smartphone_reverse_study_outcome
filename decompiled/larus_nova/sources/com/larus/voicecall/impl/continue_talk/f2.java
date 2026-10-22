package com.larus.voicecall.impl.continue_talk;

import android.animation.Animator;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes32.dex */
public final /* synthetic */ class f2 implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h2 f378145a;

    public /* synthetic */ f2(h2 r100) {
        this.f378145a = r100;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r100) {
        Animator r101 = (Animator) r100;
        this.f378145a.a();
        return Unit.INSTANCE;
    }
}
