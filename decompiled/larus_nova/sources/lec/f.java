package lec;

import android.content.Context;
import android.text.TextUtils;
import com.larksuite.framework.utils.CollectionUtils;
import com.larus.nova.R;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.richtext.h;
import com.ss.android.lark.widget.richtext.preprocess.ElementExtra;
import com.ss.android.lark.widget.span.TextStyleInfo;
import java.util.Map;

/* JADX INFO: loaded from: classes38.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f509022a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f509023b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f509024c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f509025d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f509026e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f509027f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f509028g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Context f509029h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f509030i;

    public final void d() {
        this.f509022a = -1;
        this.f509023b = 0;
        this.f509024c = 0;
        this.f509025d = false;
        this.f509026e = false;
        this.f509027f = false;
        this.f509028g = false;
        this.f509030i = false;
    }

    public f(Context r100) {
        this.f509022a = -1;
        this.f509023b = 0;
        this.f509024c = 0;
        this.f509025d = false;
        this.f509026e = false;
        this.f509027f = false;
        this.f509028g = false;
        this.f509030i = false;
        this.f509029h = r100;
    }

    public final void a(TextStyleInfo r100) {
        r100.textSize = this.f509022a;
        r100.textColor = this.f509023b;
        r100.textBgColor = this.f509024c;
        r100.isBold = this.f509025d;
        r100.isItalic = this.f509026e;
        r100.isUnderlineText = this.f509027f;
        r100.isStrikeThruText = this.f509028g;
    }

    public final void b(ElementExtra r110) {
        Map<String, Integer> r100 = r110.getLocalStyle();
        if (CollectionUtils.isEmpty(r100) == true) goto L28;
        Integer r101 = r100.get("localFontSize");
        Integer r102 = r100.get("localFontSizeV2");
        Integer r103 = r100.get("localFontColorRes");
        Integer r104 = r100.get("localFontColorInt");
        Integer r105 = r100.get("localFontBgColor");
        Integer r106 = r100.get("localFontWeight");
        Integer r107 = r100.get("localFontStyle");
        Integer r108 = r100.get("localTextDecoration");
        if (r101 == null) goto L8;
        this.f509022a = (int) this.f509029h.getResources().getDimension(r101.intValue());
        this.f509030i = true;
    L8:
        if (r102 == null) goto L10;
        int r109 = this.f509029h.getResources().getInteger(r102.intValue());
        this.f509022a = (int) zz7.b.h(this.f509029h, r109);
        this.f509030i = true;
    L10:
        if (r104 == null) goto L12;
        this.f509023b = r104.intValue();
        this.f509030i = true;
    L14:
        if (r105 == null) goto L16;
        this.f509024c = this.f509029h.getResources().getColor(r105.intValue());
        this.f509030i = true;
    L16:
        if (r106 != null) goto L18;
    L20:
        if (r107 != null) goto L22;
    L24:
        if (r108 == null) goto L28;
        if (r108.intValue() != R.string.local_text_decoration_underline) goto L28;
        this.f509027f = true;
        this.f509030i = true;
        goto L28
    L22:
        if (r107.intValue() != R.string.local_font_style_italic) goto L24;
        this.f509026e = true;
        this.f509030i = true;
        goto L24
    L18:
        if (r106.intValue() != R.string.local_font_weight_bold) goto L20;
        this.f509025d = true;
        this.f509030i = true;
        goto L20
    L12:
        if (r103 == null) goto L14;
        this.f509023b = this.f509029h.getResources().getColor(r103.intValue());
        this.f509030i = true;
    L28:
        c(r110.getRemoteStyle());
    }

    public final void c(Map r100) {
        if (CollectionUtils.isEmpty(r100) == false) goto L6;
        return;
    L6:
        if (r100.containsKey("color") == false) goto L9;
        this.f509023b = h.a((String) r100.get("color"));
        this.f509030i = true;
    L9:
        if (r100.containsKey("backgroundColor") == false) goto L11;
        this.f509024c = h.a((String) r100.get("backgroundColor"));
        this.f509030i = true;
    L11:
        String r101 = (String) r100.get("fontWeight");
        String r102 = UIHelper.getString(R.string.remote_font_weight_bold);
        if (TextUtils.isEmpty(r101) == false) goto L14;
    L16:
        String r103 = (String) r100.get("fontStyle");
        String r104 = UIHelper.getString(R.string.remote_font_style_italic);
        if (TextUtils.isEmpty(r103) == true) goto L22;
        if (r103.trim().equals(r104) == false) goto L22;
        this.f509026e = true;
        this.f509030i = true;
    L22:
        if (r100.containsKey("-lark-textDecoration") == false) goto L30;
        String r105 = (String) r100.get("-lark-textDecoration");
        if (r105.contains(UIHelper.getString(R.string.remote_text_lark_decoration_underline)) == false) goto L27;
        this.f509027f = true;
        this.f509030i = true;
    L27:
        if (r105.contains(UIHelper.getString(R.string.remote_text_lark_decoration_line_through)) == false) goto L31;
        this.f509028g = true;
        this.f509030i = true;
        return;
    L31:
        return;
    L30:
        return;
    L14:
        if (r101.trim().equals(r102) == false) goto L16;
        this.f509025d = true;
        this.f509030i = true;
        goto L16
    }

    public final TextStyleInfo e(String r100) {
        if (this.f509030i == true) goto L6;
        return null;
    L6:
        TextStyleInfo r101 = new TextStyleInfo();
        r101.type = 4;
        r101.text = r100;
        r101.textSize = this.f509022a;
        r101.textColor = this.f509023b;
        r101.textBgColor = this.f509024c;
        r101.isBold = this.f509025d;
        r101.isItalic = this.f509026e;
        r101.isUnderlineText = this.f509027f;
        r101.isStrikeThruText = this.f509028g;
        r101.isIndependent = false;
        r101.isGlobalSpanInfo = true;
        return r101;
    }
}
