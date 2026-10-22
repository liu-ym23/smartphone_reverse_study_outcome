package com.obric.assistant.settings.voiceprint;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes33.dex */
public final /* synthetic */ class b implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ObricVoicePrintManagementActivity f392441a;

    public /* synthetic */ b(ObricVoicePrintManagementActivity r100) {
        this.f392441a = r100;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        ObricVoicePrintManagementActivity r100 = this.f392441a;
        int r101 = ObricVoicePrintManagementActivity.f392409q;
        r100.U1(false, true);
        if (r100.isFinishing() == true) goto L8;
        if (r100.isDestroyed() == true) goto L8;
        r100.finish();
    L8:
        return Unit.INSTANCE;
    }
}
