package psc;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class c extends ClickableSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f530595a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final lw8.c f530596b;

    @Override // android.text.style.ClickableSpan
    public final void onClick(View r100) {
        Intrinsics.checkNotNullParameter(r100, "widget");
        this.f530596b.a(r100, this.f530595a);
        if ((r100 instanceof TextView) == false) goto L5;
        TextView r101 = (TextView) r100;
    L6:
        if (r101 == null) goto L10;
        r101.setHighlightColor(0);
        return;
    L10:
        return;
    L5:
        r101 = null;
        goto L6
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r100) {
        Intrinsics.checkNotNullParameter(r100, "ds");
        r100.setUnderlineText(false);
    }

    public c(d r100, lw8.c r101) {
        Intrinsics.checkNotNullParameter(r100, "codeCopyInfoSpan");
        Intrinsics.checkNotNullParameter(r101, "listener");
        this.f530595a = r100;
        this.f530596b = r101;
    }
}
