package com.larus.common_ui.dialog;

import com.larus.common_ui.widget.UrlSpanTextView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class n implements UrlSpanTextView.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AlignedSpanableDialog f327365a;

    public n(AlignedSpanableDialog r100) {
        this.f327365a = r100;
    }

    @Override // com.larus.common_ui.widget.UrlSpanTextView.a
    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        if (Intrinsics.areEqual(r100, "tos") == false) goto L8;
        k1 r101 = this.f327365a.f327120m;
        if (r101 == null) goto L13;
        r101.a();
        return;
    L13:
        return;
    L8:
        if (Intrinsics.areEqual(r100, "pp") == false) goto L15;
        k1 r102 = this.f327365a.f327120m;
        if (r102 == null) goto L16;
        r102.b();
        return;
    L16:
        return;
    }
}
