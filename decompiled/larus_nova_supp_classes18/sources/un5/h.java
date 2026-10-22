package un5;

import android.content.Context;
import android.text.TextPaint;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class h extends un5.a {
    public final Context c;
    public final String d;

    public static final class a {
    }

    static {
    }

    @Override // un5.i
    public final boolean E() {
        return true;
    }

    public final boolean g1() {
        return false;
    }

    public final Context getContext() {
        return this.c;
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint r3) {
        Intrinsics.checkNotNullParameter(r3, "ds");
        super.updateDrawState(r3);
        r3.setUnderlineText(false);
        int r0 = this.b;
        if (r0 == (-1)) goto L5;
        r3.setColor(r0);
        return;
    L5:
        r3.setColor(this.c.getResources().getColor(2131106616));
    }

    public h(Context r2, String r3, un5.a.InterfaceC0318a r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "href");
        this.c = r2;
        this.d = r3;
        this.a = r4;
    }
}
