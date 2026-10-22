package com.bytedance.locallife.poi.dito.util;

import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes21.dex */
public final class f<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.BooleanRef f262553a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function1<Boolean, Unit> f262554b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f262555c;

    /* JADX WARN: Multi-variable type inference failed */
    public f(Ref.BooleanRef r100, Function1<? super Boolean, Unit> r101, String r102) {
        this.f262553a = r100;
        this.f262554b = r101;
        this.f262555c = r102;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        Ref.BooleanRef r102 = this.f262553a;
        if (r102.element == true) goto L6;
        r102.element = true;
        this.f262554b.invoke(Boolean.TRUE);
        int r103 = i.f262558a;
        i.a(this.f262555c, "error");
        return;
    }
}
