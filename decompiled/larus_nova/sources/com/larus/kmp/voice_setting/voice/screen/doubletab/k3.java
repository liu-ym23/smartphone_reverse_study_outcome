package com.larus.kmp.voice_setting.voice.screen.doubletab;

import androidx.compose.runtime.MutableState;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class k3 implements Function1<i, Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MutableState f354420a;

    public k3(MutableState r100) {
        this.f354420a = r100;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(i r100) {
        i r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        this.f354420a.setValue(r101);
        return Unit.INSTANCE;
    }
}
