package com.larus.voicecall.impl;

import com.larus.platform.api.g1;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class n implements g1.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function2<Boolean, Boolean, Unit> f378394a;

    @Override // com.larus.platform.api.g1.b
    public final void onGoSettingsDialogDismiss(boolean r100) {
    }

    @Override // com.larus.platform.api.g1.b
    public final void onGoSettingsDialogShow() {
    }

    @Override // com.larus.platform.api.g1.b
    public final void onSettingPageReturn() {
    }

    public n(com.larus.voicecall.impl.component.core.d0 r100) {
        this.f378394a = r100;
    }

    @Override // com.larus.platform.api.g1.c
    public final void onResult(boolean r100, List<String> r101, List<String> r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r101, "grantedList");
        Intrinsics.checkNotNullParameter(r102, "deniedList");
        this.f378394a.invoke(Boolean.valueOf(r100), Boolean.valueOf(r103));
    }
}
