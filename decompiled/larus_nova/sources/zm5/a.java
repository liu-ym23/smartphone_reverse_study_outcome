package zm5;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.CharacterStyle;
import com.bytedance.ee.bear.sheet.inputbar.at.segment.SegmentStyle;
import com.bytedance.ee.util.ui.ColorUtils;
import com.larus.nova.R;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes18.dex */
public abstract class a extends CharacterStyle implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f572861a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SegmentStyle f572862b;

    @Override // un5.i
    public final /* synthetic */ int F() {
        return 33;
    }

    public a a() throws CloneNotSupportedException {
        a r100 = (a) super.clone();
        SegmentStyle r101 = this.f572862b;
        if (r101 == null) goto L5;
        r100.f572862b = r101.clone();
    L5:
        return r100;
    }

    public /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
        return a();
    }

    @Override // zm5.h
    public final SegmentStyle getStyle() {
        SegmentStyle r100 = getSegment().getStyle();
        if (r100 == null) goto L5;
        return r100;
    L5:
        return this.f572862b;
    }

    @Override // zm5.d
    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ d mo11005clone() throws CloneNotSupportedException {
        return a();
    }

    public a(Context r100) {
        this.f572861a = r100;
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint r100) {
        SegmentStyle r101 = getStyle();
        if (r101 != null) goto L5;
        r101 = this.f572862b;
    L5:
        if (r101 == null) goto L28;
        b(r100, r101);
        if (r101.getFontWeight() != 700) goto L12;
        if ("italic".equals(r101.getFontStyle()) == false) goto L12;
        int r102 = h18.e.f483540a;
        r100.setTypeface(h18.e.b(this.f572861a, 3));
    L18:
        if (TextUtils.isEmpty(r101.getTextDecoration()) == true) goto L33;
        String r103 = r101.getTextDecoration();
        Pattern r104 = yu5.c.f569228a;
        String[] r105 = r103.split(" ");
        int r106 = r105.length;
        int r107 = 0;
    L20:
        if (r107 >= r106) goto L34;
        String r108 = r105[r107];
        if (SegmentStyle.LINE_THROUGH.equals(r108) == false) goto L25;
        r100.setStrikeThruText(true);
    L27:
        r107 = r107 + 1;
        goto L20
    L25:
        if (SegmentStyle.UNDERLINE.equals(r108) == false) goto L27;
        r100.setUnderlineText(true);
        goto L27
    L34:
        return;
    L33:
        return;
    L12:
        if (r101.getFontWeight() != 700) goto L15;
        int r109 = h18.e.f483540a;
        r100.setTypeface(h18.e.b(this.f572861a, Typeface.DEFAULT_BOLD.getStyle()));
        goto L18
    L15:
        if ("italic".equals(r101.getFontStyle()) == false) goto L18;
        int r110 = h18.e.f483540a;
        r100.setTypeface(h18.e.b(this.f572861a, 2));
        goto L18
    }

    public void b(TextPaint r100, SegmentStyle r101) {
        if (TextUtils.isEmpty(r101.getColor()) == true) goto L20;
        int r102 = ColorUtils.h(r101.getColor());     // Catch: Exception -> L16
        boolean r103 = ColorUtils.b(this.f572861a);     // Catch: Exception -> L16
        if (ColorUtils.e(r102) == false) goto L8;
        if (r103 == false) goto L8;
    L10:
        boolean r104 = true;
    L12:
        if (r104 == false) goto L14;
        r102 = this.f572861a.getResources().getColor(R.color.text_title);     // Catch: Exception -> L16
    L14:
        r100.setColor(r102);     // Catch: Exception -> L16
        return;
    L8:
        if (ColorUtils.g(r102) == false) goto L11;
        if (r103 == false) goto L10;
    L11:
        r104 = false;
    L16:
        tt5.a.d("AbsStyleSpan", "onSetSpanColor failed, color = " + r101.getColor());
        return;
    }
}
