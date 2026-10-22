package com.larus.kmp.voice_setting.voice.screen.doubletab;

import androidx.compose.runtime.MutableState;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class i3 implements Function1<com.larus.kmp.voice_setting.voice.component.o1, Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MutableState f354366a;

    public i3(MutableState r100) {
        this.f354366a = r100;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(com.larus.kmp.voice_setting.voice.component.o1 r100) {
        com.larus.kmp.voice_setting.voice.component.o1 r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        this.f354366a.setValue(r101);
        return Unit.INSTANCE;
    }
}
