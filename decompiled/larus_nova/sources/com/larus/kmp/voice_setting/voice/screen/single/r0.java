package com.larus.kmp.voice_setting.voice.screen.single;

import androidx.compose.runtime.MutableState;
import com.larus.kmp.voice_setting.voice.component.o1;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class r0 implements Function1<o1, Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MutableState f354949a;

    public r0(MutableState r100) {
        this.f354949a = r100;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(o1 r100) {
        o1 r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        this.f354949a.setValue(r101);
        return Unit.INSTANCE;
    }
}
