package io.noties.markwon.syntax;

import android.text.SpannableStringBuilder;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.ss.android.ugc.aweme.discover.model.CommodityText;
import io.noties.markwon.core.spans.k;
import io.noties.markwon.core.spans.t;

/* JADX INFO: loaded from: classes5.dex */
public final class a extends Prism4jThemeBase {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f492660b;

    @Override // etc.d
    public final void c() {
    }

    public a() {
        this.f492660b = 0;
    }

    @Override // etc.d
    public final int a() {
        return this.f492660b;
    }

    @Override // io.noties.markwon.syntax.Prism4jThemeBase
    public final void d(String r100, String r101, String r102, int r103, SpannableStringBuilder r104, int r105, int r106) {
        if (GXTemplateKey.GAIAX_CSS.equals(r100) == false) goto L9;
        if (Prism4jThemeBase.e("string", r101, r102) == false) goto L9;
        r104.setSpan(new ForegroundColorSpan(-6656454), r105, r106, 33);
        r104.setSpan(new BackgroundColorSpan(-2130706433), r105, r106, 33);
        return;
    L9:
        if (Prism4jThemeBase.e("namespace", r101, r102) == false) goto L11;
        r103 = (r103 & 16777215) | (((int) 179.0f) << 24);
    L11:
        r104.setSpan(new ForegroundColorSpan(r103), r105, r106, 33);
        if (Prism4jThemeBase.e("important", r101, r102) == false) goto L14;
    L15:
        r104.setSpan(new t(), r105, r106, 33);
    L17:
        if (Prism4jThemeBase.e("italic", r101, r102) == false) goto L20;
        r104.setSpan(new k(), r105, r106, 33);
        return;
    L20:
        return;
    L14:
        if (Prism4jThemeBase.e(CommodityText.BOLD, r101, r102) == false) goto L17;
        goto L15
    }
}
