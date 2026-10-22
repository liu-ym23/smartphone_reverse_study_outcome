package com.ss.android.lark.widget.light.span;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.larus.nova.R;
import com.ss.android.lark.utils.UIHelper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class f extends ClickableSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f446239a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f446240b;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.text.style.ClickableSpan
    public final void onClick(View r100) {
        Intrinsics.checkNotNullParameter(r100, "widget");
        if ((r100 instanceof mcc.m) == true) goto L5;
        return;
    L5:
        ((mcc.j) r100).k(r100, this.f446239a, this.f446240b);
        if (r100.getTag(R.id.tag_long_press) == null) goto L8;
        r100.setTag(R.id.tag_long_press, null);
        ((mcc.j) r100).k(r100, this.f446239a, this.f446240b);
        return;
    L8:
        ((mcc.j) r100).f(r100, this.f446239a, this.f446240b);
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r100) {
        Intrinsics.checkNotNullParameter(r100, "ds");
        r100.setColor(UIHelper.getColor(R.color.text_link_normal));
        r100.setUnderlineText(false);
        r100.clearShadowLayer();
    }

    public f(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, "content");
        this.f446239a = r100;
        this.f446240b = r101;
    }
}
