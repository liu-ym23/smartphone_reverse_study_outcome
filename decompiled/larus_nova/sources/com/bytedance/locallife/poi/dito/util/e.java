package com.bytedance.locallife.poi.dito.util;

import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes21.dex */
public final class e<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f262550a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.BooleanRef f262551b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function1<Boolean, Unit> f262552c;

    /* JADX WARN: Multi-variable type inference failed */
    public e(String r100, Ref.BooleanRef r101, Function1<? super Boolean, Unit> r102) {
        this.f262550a = r100;
        this.f262551b = r101;
        this.f262552c = r102;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        String r101 = (String) r100;
        Ref.BooleanRef r102 = this.f262551b;
        if (r102.element == true) goto L6;
        r102.element = true;
        this.f262552c.invoke(Boolean.TRUE);
        int r103 = i.f262558a;
        i.a(this.f262550a, r101);
        return;
    }
}
