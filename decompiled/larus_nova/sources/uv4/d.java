package uv4;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.text.style.URLSpan;
import android.view.View;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class d extends ClickableSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f551855a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ URLSpan f551856b;

    @Override // android.text.style.ClickableSpan
    public final void onClick(View r100) {
        Intrinsics.checkNotNullParameter(r100, "widget");
        c r101 = this.f551855a;
        URLSpan r102 = this.f551856b;
        r101.getClass();
        String r103 = c.b(r102);
        if (r103 == null) goto L8;
        c.a r104 = this.f551855a.f551854k;
        if (r104 == null) goto L9;
        r104.b(r103);
        return;
    L9:
        return;
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r100) {
        Intrinsics.checkNotNullParameter(r100, "ds");
        super.updateDrawState(r100);
        r100.setUnderlineText(false);
        r100.setColor(eu5.b.f474075a.getResources().getColor(R.color.primary_fill_default));
    }

    public d(c r100, URLSpan r101) {
        this.f551855a = r100;
        this.f551856b = r101;
    }
}
