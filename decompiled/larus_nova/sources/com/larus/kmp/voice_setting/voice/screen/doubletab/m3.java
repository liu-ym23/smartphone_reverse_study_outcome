package com.larus.kmp.voice_setting.voice.screen.doubletab;

import androidx.compose.runtime.MutableState;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class m3 implements Function1<h, Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MutableState f354485a;

    public m3(MutableState r100) {
        this.f354485a = r100;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(h r100) {
        h r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        this.f354485a.setValue(r101);
        return Unit.INSTANCE;
    }
}
