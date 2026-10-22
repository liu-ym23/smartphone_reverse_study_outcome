package com.larus.business.markdown.impl.markwon.core.spans.codeblock;

import android.text.style.ClickableSpan;
import android.view.View;
import io.noties.markwon.core.spans.CustomCitationSpan;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class f extends ClickableSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CustomCitationSpan f320635a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final lw8.b f320636b;

    @Override // android.text.style.ClickableSpan
    public final void onClick(View r100) {
        Intrinsics.checkNotNullParameter(r100, "widget");
        CustomCitationSpan r101 = this.f320635a;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "view");
        r101.f492281b.d(r100, r101.f492284e);
        lw8.b r102 = this.f320636b;
        if (r102 == null) goto L6;
        r102.a(this.f320635a);
        return;
    }

    public f(CustomCitationSpan r100, lw8.b r101) {
        Intrinsics.checkNotNullParameter(r100, "span");
        this.f320635a = r100;
        this.f320636b = r101;
    }
}
