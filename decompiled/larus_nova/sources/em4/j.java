package em4;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class j extends ClickableSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1<View, Unit> f473066a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f473067b;

    @Override // android.text.style.ClickableSpan
    public final void onClick(View r100) {
        Intrinsics.checkNotNullParameter(r100, "widget");
        this.f473066a.invoke(r100);
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r100) {
        Intrinsics.checkNotNullParameter(r100, "ds");
        super.updateDrawState(r100);
        r100.setUnderlineText(false);
        r100.setColor(this.f473067b);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public j(Function1<? super View, Unit> r100, int r101) {
        this.f473066a = r100;
        this.f473067b = r101;
    }
}
