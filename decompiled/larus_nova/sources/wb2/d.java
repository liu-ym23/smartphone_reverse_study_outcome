package wb2;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public class d extends ClickableSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f558922a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f558923b;

    public interface a {
        boolean d(View r100, d r101);
    }

    @Override // android.text.style.ClickableSpan
    public final void onClick(View r100) {
        Intrinsics.checkNotNullParameter(r100, "widget");
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r100) {
        Intrinsics.checkNotNullParameter(r100, "ds");
    }

    public d(Object r100) {
        this.f558923b = r100;
    }
}
