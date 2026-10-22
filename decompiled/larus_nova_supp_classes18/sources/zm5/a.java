package zm5;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.CharacterStyle;
import com.bytedance.ee.bear.sheet.inputbar.at.segment.SegmentStyle;
import com.bytedance.ee.util.ui.ColorUtils;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public abstract class a extends CharacterStyle implements h {
    public final Context a;
    public SegmentStyle b;

    @Override // un5.i
    public final /* synthetic */ int F() {
        return 33;
    }

    public a a() throws CloneNotSupportedException {
        a r0 = (a) super.clone();
        SegmentStyle r1 = this.b;
        if (r1 == null) goto L5;
        r0.b = r1.clone();
    L5:
        return r0;
    }

    public /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
        return a();
    }

    @Override // zm5.h
    public final SegmentStyle getStyle() {
        SegmentStyle r0 = getSegment().getStyle();
        if (r0 == null) goto L5;
        return r0;
    L5:
        return this.b;
    }

    @Override // zm5.d
    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ d mo752clone() throws CloneNotSupportedException {
        return a();
    }

    public a(Context r1) {
        this.a = r1;
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint r7) {
        SegmentStyle r0 = getStyle();
        if (r0 != null) goto L5;
        r0 = this.b;
    L5:
        if (r0 == null) goto L28;
        b(r7, r0);
        if (r0.getFontWeight() != 700) goto L12;
        if (SegmentStyle.FONT_STYLE_ITALIC.equals(r0.getFontStyle()) == false) goto L12;
        int r1 = h18.e.a;
        r7.setTypeface(h18.e.b(this.a, 3));
    L18:
        if (TextUtils.isEmpty(r0.getTextDecoration()) == true) goto L33;
        String r2 = r0.getTextDecoration();
        Pattern r3 = yu5.c.a;
        String[] r4 = r2.split(" ");
        int r5 = r4.length;
        int r6 = 0;
    L20:
        if (r6 >= r5) goto L34;
        String r8 = r4[r6];
        if (SegmentStyle.LINE_THROUGH.equals(r8) == false) goto L25;
        r7.setStrikeThruText(true);
    L27:
        r6 = r6 + 1;
        goto L20
    L25:
        if (SegmentStyle.UNDERLINE.equals(r8) == false) goto L27;
        r7.setUnderlineText(true);
        goto L27
    L34:
        return;
    L33:
        return;
    L12:
        if (r0.getFontWeight() != 700) goto L15;
        int r9 = h18.e.a;
        r7.setTypeface(h18.e.b(this.a, Typeface.DEFAULT_BOLD.getStyle()));
        goto L18
    L15:
        if (SegmentStyle.FONT_STYLE_ITALIC.equals(r0.getFontStyle()) == false) goto L18;
        int r10 = h18.e.a;
        r7.setTypeface(h18.e.b(this.a, 2));
        goto L18
    }

    public void b(TextPaint r4, SegmentStyle r5) {
        if (TextUtils.isEmpty(r5.getColor()) == true) goto L20;
        int r0 = ColorUtils.h(r5.getColor());     // Catch: Exception -> L16
        boolean r1 = ColorUtils.b(this.a);     // Catch: Exception -> L16
        if (ColorUtils.e(r0) == false) goto L8;
        if (r1 == false) goto L8;
    L10:
        boolean r2 = true;
    L12:
        if (r2 == false) goto L14;
        r0 = this.a.getResources().getColor(2131106622);     // Catch: Exception -> L16
    L14:
        r4.setColor(r0);     // Catch: Exception -> L16
        return;
    L8:
        if (ColorUtils.g(r0) == false) goto L11;
        if (r1 == false) goto L10;
    L11:
        r2 = false;
    L16:
        tt5.a.d("AbsStyleSpan", "onSetSpanColor failed, color = " + r5.getColor());
        return;
    }
}
