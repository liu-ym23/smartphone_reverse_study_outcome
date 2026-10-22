package ov4;

import android.content.Context;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b extends ClickableSpan {
    public final Context a;
    public final String b;
    public final String c;
    public final a d;

    public interface a {
        void a(String r1);
    }

    @Override // android.text.style.ClickableSpan
    public final void onClick(View r2) {
        a r3 = this.d;
        if (r3 == null) goto L6;
        r3.a(this.b);
        return;
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r3) {
        super.updateDrawState(r3);
        r3.setUnderlineText(false);
        r3.setColor(this.a.getResources().getColor(2131106616));
        r3.clearShadowLayer();
    }

    public b(Context r1, String r2, String r3, a r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
