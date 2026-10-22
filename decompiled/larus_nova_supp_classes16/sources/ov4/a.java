package ov4;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.bytedance.ee.bear.bizwidget.at.AtUserSupportTextView;
import com.bytedance.ee.bear.quoto.f0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a extends ClickableSpan {
    public final /* synthetic */ View.OnClickListener a;
    public final /* synthetic */ AtUserSupportTextView b;

    @Override // android.text.style.ClickableSpan
    public final void onClick(View r2) {
        this.a.onClick(r2);
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r3) {
        super.updateDrawState(r3);
        r3.setUnderlineText(false);
        r3.setColor(this.b.getResources().getColor(2131106616));
        r3.clearShadowLayer();
    }

    public a(AtUserSupportTextView r1, f0.b r2) {
        this.b = r1;
        this.a = r2;
    }
}
