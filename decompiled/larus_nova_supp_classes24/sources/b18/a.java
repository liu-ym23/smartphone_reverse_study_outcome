package b18;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a extends ClickableSpan {
    public final int a;
    public final View.OnClickListener b;

    @Override // android.text.style.ClickableSpan
    public final void onClick(View r2) {
        Intrinsics.checkNotNullParameter(r2, "widget");
        this.b.onClick(r2);
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r2) {
        Intrinsics.checkNotNullParameter(r2, "ds");
        r2.setColor(this.a);
        r2.setUnderlineText(false);
    }

    public a(int r2, View.OnClickListener r3) {
        Intrinsics.checkNotNullParameter(r3, "clickListener");
        this.a = r2;
        this.b = r3;
    }
}
