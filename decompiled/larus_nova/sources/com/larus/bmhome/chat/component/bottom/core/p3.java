package com.larus.bmhome.chat.component.bottom.core;

import androidx.appcompat.widget.AppCompatImageView;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final /* synthetic */ class p3 implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CoreInputComponent f299344a;

    public /* synthetic */ p3(CoreInputComponent r100) {
        this.f299344a = r100;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r100) {
        CoreInputComponent r101 = this.f299344a;
        int r102 = CoreInputComponent.f298338d3;
        Intrinsics.checkNotNullParameter((AppCompatImageView) r100, "it");
        r101.y5(null);
        return Unit.INSTANCE;
    }
}
