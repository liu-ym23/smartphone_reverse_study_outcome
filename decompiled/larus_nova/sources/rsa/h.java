package rsa;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;

/* JADX INFO: loaded from: classes34.dex */
public final class h extends ClickableSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View.OnClickListener f539158a;

    public h(qsa.c r100) {
        this.f539158a = r100;
    }

    @Override // android.text.style.ClickableSpan
    public final void onClick(View r100) {
        View.OnClickListener r101 = this.f539158a;
        if (r101 == null) goto L6;
        r101.onClick(r100);
        return;
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r100) {
        super.updateDrawState(r100);
        r100.setUnderlineText(false);
    }
}
