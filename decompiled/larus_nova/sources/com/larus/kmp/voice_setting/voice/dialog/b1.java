package com.larus.kmp.voice_setting.voice.dialog;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes30.dex */
public final class b1 implements Function2<Composer, Integer, Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function3<e1, Composer, Integer, Unit> f352708a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e1 f352709b;

    /* JADX WARN: Multi-variable type inference failed */
    public b1(Function3<? super e1, ? super Composer, ? super Integer, Unit> r100, e1 r101) {
        this.f352708a = r100;
        this.f352709b = r101;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Unit invoke(Composer r100, Integer r101) {
        Composer r102 = r100;
        int r103 = r101.intValue();
        if ((r103 & 3) == 2) goto L5;
        boolean r104 = true;
    L7:
        if (r102.shouldExecute(r104, r103 & 1) == true) goto L9;
        r102.skipToGroupEnd();
    L16:
        return Unit.INSTANCE;
    L9:
        if (ComposerKt.isTraceInProgress() == false) goto L11;
        ComposerKt.traceEventStart(-1219506180, r103, -1, "com.larus.kmp.voice_setting.voice.dialog.VoiceLegacyCenterDialogScaffold.<anonymous>.<anonymous> (UgcVoiceContainerDialogUi.kt:766)");
    L11:
        this.f352708a.invoke(this.f352709b, r102, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L16;
        ComposerKt.traceEventEnd();
        goto L16
    L5:
        r104 = false;
        goto L7
    }
}
