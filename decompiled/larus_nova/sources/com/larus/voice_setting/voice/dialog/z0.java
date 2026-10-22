package com.larus.voice_setting.voice.dialog;

import com.larus.voice_setting.impl.databinding.LarusDialogOptUserVoiceInfoBinding;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class z0 implements com.larus.common_ui.dialog.y0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LarusDialogOptUserVoiceInfoBinding f376704a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ UgcVoiceInfoOptimizeDialog f376705b;

    @Override // com.larus.common_ui.dialog.y0
    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        this.f376704a.f376093n.setText(r100);
        UgcVoiceInfoOptimizeDialog r101 = this.f376705b;
        r101.f376557n = r100;
        if (r101.f376552i == true) goto L5;
        return;
    L5:
        if (r101.f376560q == true) goto L9;
        r101.U90(true);
        this.f376705b.f376552i = false;
        return;
    }

    public z0(LarusDialogOptUserVoiceInfoBinding r100, UgcVoiceInfoOptimizeDialog r101) {
        this.f376704a = r100;
        this.f376705b = r101;
    }
}
