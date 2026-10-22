package hi5;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class y extends ClickableSpan {
    public final Context a;
    public final a b;
    public long c;

    public interface a extends View.OnClickListener {
        void QF();
    }

    @Override // android.text.style.ClickableSpan
    public final void onClick(View r8) {
        long r0 = SystemClock.elapsedRealtime();
        if ((r0 - this.c) <= 500) goto L8;
        this.c = r0;
        a r1 = this.b;
        if (r1 == null) goto L9;
        r1.onClick(r8);
        return;
    L9:
        return;
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r3) {
        super.updateDrawState(r3);
        this.b.QF();
        r3.setUnderlineText(false);
        r3.setColor(this.a.getResources().getColor(2131106616));
    }

    public y(Context r3, a r4) {
        this.c = 0;
        this.a = r3;
        this.b = r4;
    }
}
