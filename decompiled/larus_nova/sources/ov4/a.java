package ov4;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.bytedance.ee.bear.bizwidget.at.AtUserSupportTextView;
import com.bytedance.ee.bear.quoto.f0;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes16.dex */
public final class a extends ClickableSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View.OnClickListener f526898a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AtUserSupportTextView f526899b;

    @Override // android.text.style.ClickableSpan
    public final void onClick(View r100) {
        this.f526898a.onClick(r100);
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r100) {
        super.updateDrawState(r100);
        r100.setUnderlineText(false);
        r100.setColor(this.f526899b.getResources().getColor(R.color.text_link_normal));
        r100.clearShadowLayer();
    }

    public a(AtUserSupportTextView r100, f0.b r101) {
        this.f526899b = r100;
        this.f526898a = r101;
    }
}
