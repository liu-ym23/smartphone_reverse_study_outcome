package com.larus.chat.gallery.impl.preview.toolbar.action;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes26.dex */
public final /* synthetic */ class h0 implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.BooleanRef f324748a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function0 f324749b;

    public /* synthetic */ h0(Ref.BooleanRef r100, Function0 r101) {
        this.f324748a = r100;
        this.f324749b = r101;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        Ref.BooleanRef r100 = this.f324748a;
        Function0 r101 = this.f324749b;
        if (r100.element == true) goto L6;
        r100.element = true;
        r101.invoke();
    L6:
        return Unit.INSTANCE;
    }
}
