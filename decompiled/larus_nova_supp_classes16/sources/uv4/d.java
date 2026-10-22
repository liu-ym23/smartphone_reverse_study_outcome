package uv4;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.text.style.URLSpan;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d extends ClickableSpan {
    public final /* synthetic */ c a;
    public final /* synthetic */ URLSpan b;

    @Override // android.text.style.ClickableSpan
    public final void onClick(View r2) {
        Intrinsics.checkNotNullParameter(r2, "widget");
        c r3 = this.a;
        URLSpan r0 = this.b;
        r3.getClass();
        String r4 = c.b(r0);
        if (r4 == null) goto L8;
        c.a r1 = this.a.k;
        if (r1 == null) goto L9;
        r1.b(r4);
        return;
    L9:
        return;
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r3) {
        Intrinsics.checkNotNullParameter(r3, "ds");
        super.updateDrawState(r3);
        r3.setUnderlineText(false);
        r3.setColor(eu5.b.a.getResources().getColor(2131105548));
    }

    public d(c r1, URLSpan r2) {
        this.a = r1;
        this.b = r2;
    }
}
