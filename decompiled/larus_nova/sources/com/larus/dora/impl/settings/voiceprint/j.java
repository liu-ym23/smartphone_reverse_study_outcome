package com.larus.dora.impl.settings.voiceprint;

import com.enroll.audio.enroll.IVoiceEnrollService;
import com.larus.common_ui.dialog.p0;
import com.larus.dora.impl.util.PacificInterfaceManager;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class j implements p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VoicePrintManagementActivity f338055a;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.larus.dora.impl.settings.voiceprint.h, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v1, types: [com.larus.dora.impl.util.p0] */
    @Override // com.larus.common_ui.dialog.p0
    public final void confirm() {
        final VoicePrintManagementActivity r100 = this.f338055a;
        int r101 = VoicePrintManagementActivity.f338037l;
        r100.getClass();
        Function1<? super Boolean, Unit> r102 = PacificInterfaceManager.f338120a;
        final String r103 = r100.f338039h;
        final ?? r104 = new h(r100);
        Intrinsics.checkNotNullParameter(r103, "mac");
        Intrinsics.checkNotNullParameter(r104, "callback");
        String r105 = PacificInterfaceManager.f(r103);
        if (r105 == null) goto L6;
        r103 = r105;
    L6:
        g49.d.d("PacificInterfaceManager", "deleteVoicePrint start");
        IVoiceEnrollService.f273709a.getClass();
        IVoiceEnrollService r106 = IVoiceEnrollService.a.a();
        if (r106 == 0) goto L10;
        r106.j(r103, new com.larus.dora.impl.util.p0(r103, r104));
        return;
    }

    public j(VoicePrintManagementActivity r100) {
        this.f338055a = r100;
    }
}
