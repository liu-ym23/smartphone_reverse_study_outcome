package com.larus.home.impl.main.side_bar.data;

import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes29.dex */
public final /* synthetic */ class m0 implements Function2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f344522a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.BooleanRef f344523b;

    public /* synthetic */ m0(Ref.ObjectRef r100, Ref.BooleanRef r101) {
        this.f344522a = r100;
        this.f344523b = r101;
    }

    /* JADX WARN: Type inference failed for: r5v1, types: [T, java.lang.Object, java.util.List] */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object r100, Object r101) {
        Ref.ObjectRef r102 = this.f344522a;
        Ref.BooleanRef r103 = this.f344523b;
        List r104 = (List) r100;
        ?? r105 = (List) r101;
        Intrinsics.checkNotNullParameter(r104, "originalChildren");
        Intrinsics.checkNotNullParameter(r105, "reorderedChildren");
        r102.element = r105;
        if (r103.element == false) goto L5;
    L8:
        boolean r106 = true;
    L9:
        r103.element = r106;
        return Unit.INSTANCE;
    L5:
        if (Intrinsics.areEqual(r104, r105) == false) goto L8;
        r106 = false;
        goto L9
    }
}
