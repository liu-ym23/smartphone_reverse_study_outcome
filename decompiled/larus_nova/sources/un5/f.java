package un5;

import android.content.Context;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes18.dex */
public final class f extends ClickableSpan implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f550795a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f550796b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f550797c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f550798d;

    @Override // un5.i
    public final boolean E() {
        return false;
    }

    @Override // un5.i
    public final /* synthetic */ int F() {
        throw null;
    }

    @Override // android.text.style.ClickableSpan
    public final void onClick(View r100) {
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r100) {
        super.updateDrawState(r100);
        r100.setUnderlineText(false);
        int r101 = this.f550798d;
        if (r101 != (-1)) goto L6;
        r101 = this.f550795a.getResources().getColor(R.color.text_link_normal);
    L6:
        r100.setColor(r101);
    }

    public f(Context r100, String r101) {
        this.f550798d = -1;
        this.f550795a = r100;
        this.f550796b = r101;
        this.f550797c = null;
    }
}
