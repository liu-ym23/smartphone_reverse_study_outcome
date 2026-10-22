package q35;

import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b extends ClickableSpan {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ Function1<String, Unit> b;
    public final /* synthetic */ a c;
    public final /* synthetic */ a.b d;

    @Override // android.text.style.ClickableSpan
    public final void onClick(View r4) {
        Intrinsics.checkNotNullParameter(r4, "view");
        Function1<String, Unit> r5 = this.b;
        SpannableStringBuilder r0 = this.c.b;
        a.b r1 = this.d;
        r5.invoke(r0.subSequence(r1.a, r1.b).toString());
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r2) {
        Intrinsics.checkNotNullParameter(r2, "ds");
        super.updateDrawState(r2);
        if (this.a == true) goto L6;
        r2.setUnderlineText(false);
        r2.bgColor = 0;
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(boolean r1, Function1<? super String, Unit> r2, a r3, a.b r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
