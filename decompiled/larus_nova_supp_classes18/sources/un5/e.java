package un5;

import android.content.Context;
import android.text.TextPaint;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class e extends a {
    public final Context c;
    public final String d;
    public final String e;
    public final int f;
    public final int g;
    public final String h;
    public final String i;
    public final int j;
    public boolean k;
    public final String l;

    @Override // un5.i
    public final boolean E() {
        return false;
    }

    public final boolean g1() {
        return false;
    }

    public int getType() {
        return this.f;
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint r4) {
        super.updateDrawState(r4);
        r4.setUnderlineText(false);
        int r0 = this.c.getResources().getColor(2131106616);
        int r1 = this.b;
        if (r1 == (-1)) goto L6;
        r0 = r1;
    L8:
        r4.setColor(r0);
        return;
    L6:
        if (this.k == false) goto L8;
        r0 = this.c.getResources().getColor(2131103454);
        goto L8
    }

    public e(Context r1, String r2, int r3, int r4, String r5, String r6, int r7, String r8, String r9, a.InterfaceC0318a r10) {
        this.c = r1;
        this.d = r2;
        this.f = r3;
        this.g = r4;
        this.e = r5;
        this.j = r7;
        this.i = r8;
        this.h = r9;
        this.a = r10;
        this.l = r6;
    }
}
