package com.larus.dora.impl.nl;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes27.dex */
public final class x0 implements com.larus.common_ui.dialog.p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f336403a;

    @Override // com.larus.common_ui.dialog.p0
    public final void confirm() {
        g49.d.d("ProactiveSettingsFragment", "showHeadControlDisableDialog: go to settings clicked");
        this.f336403a.invoke();
    }

    public x0(c0 r100) {
        this.f336403a = r100;
    }
}
