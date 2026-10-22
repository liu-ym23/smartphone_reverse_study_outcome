package un5;

import android.content.Context;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f extends ClickableSpan implements i {
    public final Context a;
    public final String b;
    public final String c;
    public final int d;

    @Override // un5.i
    public final boolean E() {
        return false;
    }

    @Override // un5.i
    public final /* synthetic */ int F() {
        throw null;
    }

    @Override // android.text.style.ClickableSpan
    public final void onClick(View r1) {
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r3) {
        super.updateDrawState(r3);
        r3.setUnderlineText(false);
        int r0 = this.d;
        if (r0 != (-1)) goto L6;
        r0 = this.a.getResources().getColor(2131106616);
    L6:
        r3.setColor(r0);
    }

    public f(Context r2, String r3) {
        this.d = -1;
        this.a = r2;
        this.b = r3;
        this.c = null;
    }
}
