package com.larus.voice_setting.voice.dialog;

import com.larus.voice_setting.impl.databinding.LarusDialogEditUserVoiceInfoBinding;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class g0 implements com.larus.common_ui.dialog.y0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UgcVoiceInfoEditDialog f376581a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LarusDialogEditUserVoiceInfoBinding f376582b;

    @Override // com.larus.common_ui.dialog.y0
    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        if (Intrinsics.areEqual(r100, this.f376581a.f376540m) == true) goto L5;
        this.f376581a.f376544q = false;
    L5:
        this.f376582b.f376077k.setText(r100);
        UgcVoiceInfoEditDialog r101 = this.f376581a;
        r101.f376540m = r100;
        if (r101.f376536i == false) goto L9;
        r101.U90(true);
        this.f376581a.f376536i = false;
        return;
    }

    public g0(UgcVoiceInfoEditDialog r100, LarusDialogEditUserVoiceInfoBinding r101) {
        this.f376581a = r100;
        this.f376582b = r101;
    }
}
