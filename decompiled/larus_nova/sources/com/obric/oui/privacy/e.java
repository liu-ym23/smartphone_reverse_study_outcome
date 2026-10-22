package com.obric.oui.privacy;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.larus.nova.R;
import com.obric.oui.text.OTextView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class e extends ClickableSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f402476a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f402477b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ OTextView f402478c;

    @Override // android.text.style.ClickableSpan
    public final void onClick(View r100) {
        Intrinsics.checkNotNullParameter(r100, "widget");
        i r101 = this.f402476a.f402473e;
        if (r101 == null) goto L7;
        r101.c(this.f402477b);
        return;
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r100) {
        Intrinsics.checkNotNullParameter(r100, "ds");
        super.updateDrawState(r100);
        r100.setColor(ContextCompat.getColor(this.f402478c.getContext(), R.color.oui_functional_blue_6));
        r100.setUnderlineText(false);
    }

    public e(c r100, String r101, OTextView r102) {
        this.f402476a = r100;
        this.f402477b = r101;
        this.f402478c = r102;
    }
}
