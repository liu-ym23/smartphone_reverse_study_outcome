package ov4;

import android.content.Context;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes16.dex */
public final class b extends ClickableSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f526900a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f526901b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f526902c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f526903d;

    public interface a {
        void a(String r100);
    }

    @Override // android.text.style.ClickableSpan
    public final void onClick(View r100) {
        a r101 = this.f526903d;
        if (r101 == null) goto L6;
        r101.a(this.f526901b);
        return;
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r100) {
        super.updateDrawState(r100);
        r100.setUnderlineText(false);
        r100.setColor(this.f526900a.getResources().getColor(R.color.text_link_normal));
        r100.clearShadowLayer();
    }

    public b(Context r100, String r101, String r102, a r103) {
        this.f526900a = r100;
        this.f526901b = r101;
        this.f526902c = r102;
        this.f526903d = r103;
    }
}
