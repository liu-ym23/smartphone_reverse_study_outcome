package com.obric.assistant.privacy.dialog;

import com.larus.common_ui.widget.UrlSpanTextView;
import com.larus.network.HttpConst;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class n implements UrlSpanTextView.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GRPrivacyDialog f391130a;

    public n(GRPrivacyDialog r100) {
        this.f391130a = r100;
    }

    @Override // com.larus.common_ui.widget.UrlSpanTextView.a
    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        int r101 = r100.hashCode();
        if (r101 == 3584) goto L18;
        if (r101 == 3646) goto L14;
        if (r101 == 115032) goto L10;
        return;
    L10:
        if (r100.equals("tos") == false) goto L25;
        GRPrivacyDialog r102 = this.f391130a;
        HttpConst.f359979a.getClass();
        GRPrivacyDialog.S90(r102, HttpConst.L);
        return;
    L25:
        return;
    L14:
        if (r100.equals("rp") == false) goto L26;
        GRPrivacyDialog r103 = this.f391130a;
        String r104 = com.larus.setting.api.u.f367928a;
        GRPrivacyDialog.S90(r103, com.larus.setting.api.u.f367931d);
        return;
    L26:
        return;
    L18:
        if (r100.equals("pp") == false) goto L27;
        GRPrivacyDialog r105 = this.f391130a;
        HttpConst.f359979a.getClass();
        GRPrivacyDialog.S90(r105, HttpConst.M);
        return;
    }
}
