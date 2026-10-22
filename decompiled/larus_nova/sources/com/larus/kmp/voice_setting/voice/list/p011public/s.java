package com.larus.kmp.voice_setting.voice.list.p011public;

import androidx.compose.runtime.MutableState;
import com.larus.kmp.voice_setting.voice.component.b5;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class s implements Function1<b5, Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MutableState f353596a;

    public s(MutableState r100) {
        this.f353596a = r100;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(b5 r100) {
        b5 r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        this.f353596a.setValue(r101);
        return Unit.INSTANCE;
    }
}
