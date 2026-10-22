package com.larus.kmp.voice_setting.voice.screen.single;

import androidx.compose.runtime.MutableState;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class p0 implements Function1<c0, Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MutableState f354928a;

    public p0(MutableState r100) {
        this.f354928a = r100;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(c0 r100) {
        c0 r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        this.f354928a.setValue(r101);
        return Unit.INSTANCE;
    }
}
