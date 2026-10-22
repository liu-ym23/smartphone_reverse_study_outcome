package com.larus.bmhome.view;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.larus.nova.R;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class u3 extends ClickableSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MessageRiskWarningTextView f317516a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f317517b;

    @Override // android.text.style.ClickableSpan
    public final void onClick(View r100) {
        Intrinsics.checkNotNullParameter(r100, "widget");
        com.larus.platform.service.q.f365787a.e(this.f317516a.getContext(), com.larus.utils.f.c(new Pair[]{TuplesKt.to("link_url", this.f317517b)}), null);
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r100) {
        Intrinsics.checkNotNullParameter(r100, "ds");
        super.updateDrawState(r100);
        r100.setUnderlineText(false);
        r100.setColor(ContextCompat.getColor(this.f317516a.getContext(), v19.c.b(R.attr.larus_primary_60, this.f317516a.getContext(), R.color.larus_primary_60)));
    }

    public u3(MessageRiskWarningTextView r100, String r101) {
        this.f317516a = r100;
        this.f317517b = r101;
    }
}
