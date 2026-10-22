package io.noties.markwon.ext.tables;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.Layout;
import android.text.SpanWatcher;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.text.style.LeadingMarginSpan;
import android.text.style.UpdateAppearance;
import android.text.style.UpdateLayout;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes41.dex */
public final class TableRowSpan2 extends a implements SpanWatcher {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f492488b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList<Layout> f492489c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextPaint f492490d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Rect f492491e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Paint f492492f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final GradientDrawable f492493g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Paint f492494h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f492495i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final GradientDrawable f492496j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f492497k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final u f492498l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ctc.e f492499m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final List<g.b> f492500n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final g.b f492501o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final ctc.a f492502p;

    public final int d() {
        Iterator<T> r100 = this.f492489c.iterator();
        int r101 = 0;
    L4:
        if (r100.hasNext() == false) goto L6;
        r101 = r101 + (((Layout) r100.next()).getWidth() + (this.f492498l.f492556f * 2));
        goto L4
    L6:
        return r101;
    }

    public final int e() {
        u r100 = this.f492498l;
        if (r100.f492565o == false) goto L6;
        return r100.f492557g - this.f492497k;
    L6:
        return Math.min(d(), this.f492498l.f492557g - this.f492497k);
    }

    public static g.b c(g.b r100) {
        int r101 = r100.f492527a;
        List<g.a> r102 = r100.f492528b;
        ArrayList r103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
        Iterator<T> r104 = r102.iterator();
    L4:
        if (r104.hasNext() == false) goto L11;
        g.a r105 = (g.a) r104.next();
        int r106 = r105.f492525d;
        CharSequence r107 = r105.f492526e;
        if ((r107 instanceof Spanned) == false) goto L8;
        CharSequence r108 = new SpannableString(r107);
    L9:
        g.a r109 = new g.a(r106, r108);
        r109.f492522a = r105.f492522a;
        r109.f492523b = r105.f492523b;
        r109.f492524c = r105.f492524c;
        r103.add(r109);
        goto L4
    L8:
        r108 = r107.toString();
        goto L9
    L11:
        return new g.b(r101, r103, r100.f492529c);
    }

    public final <Span> void b(Class<Span> r110) {
        Iterator<Layout> r100 = this.f492489c.iterator();
    L4:
        if (r100.hasNext() == false) goto L19;
        Layout r101 = r100.next();
        int r102 = r101.getText().length();
        CharSequence r103 = r101.getText();
        if ((r103 instanceof Spanned) == true) goto L8;
        r103 = null;
    L8:
        Spanned r104 = (Spanned) r103;
        if (r104 == null) goto L4;
        int r105 = 0;
        Object[] r106 = r104.getSpans(0, r102, r110);
        int r107 = r106.length;
    L11:
        if (r105 >= r107) goto L4;
        Object r108 = r106[r105];
        CharSequence r109 = r101.getText();
        if ((r109 instanceof SpannableString) == true) goto L15;
        r109 = null;
    L15:
        SpannableString r111 = (SpannableString) r109;
        if (r111 == null) goto L18;
        r111.removeSpan(r108);
    L18:
        r105 = r105 + 1;
        goto L11
    }

    public final <coveredSpan, setSpan> void h(Class<coveredSpan> r110, Function1<? super coveredSpan, ? extends setSpan> r111) {
        Iterator<g.a> r100 = this.f492501o.f492528b.iterator();
    L4:
        if (r100.hasNext() == false) goto L13;
        g.a r101 = r100.next();
        int r102 = r101.f492526e.length();
        CharSequence r103 = r101.f492526e;
        if ((r103 instanceof Spannable) == true) goto L8;
        r103 = null;
    L8:
        Spannable r104 = (Spannable) r103;
        if (r104 == null) goto L4;
        int r105 = 0;
        Object[] r106 = r104.getSpans(0, r102, r110);
        int r107 = r106.length;
    L11:
        if (r105 >= r107) goto L4;
        Object r108 = r106[r105];
        r104.setSpan(r111.invoke(r108), r104.getSpanStart(r108), r104.getSpanEnd(r108), 17);
        r105 = r105 + 1;
        goto L11
    }

    @Override // io.noties.markwon.ext.tables.a
    public final <Span> Span[] a(int r100, int r101, Class<Span> r102) {
        int r103 = r101 - this.f492498l.f492555e;
        int r104 = r100 - MathKt.roundToInt(this.f492502p.f465380a);
        int r105 = this.f492498l.f492556f;
        Iterator<Layout> r106 = this.f492489c.iterator();
    L4:
        if (r106.hasNext() == false) goto L21;
        Layout r107 = r106.next();
        int r108 = r107.getWidth() + r105;
        if (r105 > r104) goto L20;
        if (r108 < r104) goto L20;
        int r109 = r107.getHeight();
        if (r103 < 0) goto L20;
        if (r109 < r103) goto L20;
        int r110 = r107.getOffsetForHorizontal(r107.getLineForVertical(r103), r104 - r105);
        CharSequence r111 = r107.getText();
        if ((r111 instanceof Spanned) == true) goto L16;
        r111 = null;
    L16:
        Spanned r112 = (Spanned) r111;
        if (r112 != null) goto L19;
        return null;
    L19:
        return (Span[]) r112.getSpans(r110, r110, r102);
    L20:
        r105 = (this.f492498l.f492556f * 2) + r108;
        goto L4
    L21:
        return null;
    }

    public final void f(CharSequence r110, int r111, int r112) {
        this.f492497k = 0;
        if ((r110 instanceof SpannableString) == true) goto L5;
        CharSequence r100 = null;
    L6:
        SpannableString r101 = (SpannableString) r100;
        if (r101 == null) goto L12;
        Object[] r113 = r101.getSpans(r111, r112, LeadingMarginSpan.class);
        int r114 = r113.length;
        int r102 = 0;
        int r103 = 0;
    L9:
        if (r102 >= r114) goto L11;
        r103 = r103 + ((LeadingMarginSpan) r113[r102]).getLeadingMargin(false);
        r102 = r102 + 1;
        goto L9
    L11:
        this.f492497k = r103 + 0;
    L12:
        this.f492490d.setFakeBoldText(this.f492501o.f492529c);
        this.f492489c.clear();
        g.b r115 = this.f492501o;
        if (r115.f492527a == 0) goto L18;
        g.a r116 = (g.a) CollectionsKt.firstOrNull(r115.f492528b);
        if (r116 != null) goto L17;
    L41:
        Iterator<T> r117 = this.f492501o.f492528b.iterator();
    L43:
        if (r117.hasNext() == false) goto L45;
        float r118 = ((g.a) r117.next()).f492524c;
        int r119 = this.f492498l.f492556f;
        goto L43
    L45:
        Iterator<T> r120 = this.f492501o.f492528b.iterator();
        int r121 = 0;
    L47:
        if (r120.hasNext() == false) goto L99;
        Object r104 = r120.next();
        int r105 = r121 + 1;
        if (r121 >= 0) goto L51;
        CollectionsKt.throwIndexOverflow();
    L51:
        g.a r106 = (g.a) r104;
        SpannableString r107 = new SpannableString(r106.f492526e);
        if ((r110 instanceof Spanned) == false) goto L63;
        int r108 = r106.f492522a;
        if (r108 <= (-1)) goto L63;
        int r109 = r106.f492523b;
        if (r109 <= (-1)) goto L63;
        CharacterStyle[] r122 = (CharacterStyle[]) ((Spanned) r110).getSpans(r108, r109, CharacterStyle.class);
        int r123 = r122.length;
        int r124 = 0;
    L58:
        if (r124 >= r123) goto L63;
        CharacterStyle r125 = r122[r124];
        if (r125 == this) goto L62;
        r107.setSpan(r125, 0, r107.length(), 33);
    L62:
        r124 = r124 + 1;
    L63:
        int r126 = this.f492498l.f492556f * 2;
        int r127 = this.f492501o.f492528b.size();
        int r128 = Math.min(Math.max(this.f492498l.f492558h, ((int) r106.f492524c) + r126), this.f492498l.f492559i);
        if (this.f492498l.f492565o == false) goto L69;
        if (r127 <= 0) goto L69;
        int r129 = e() - d();
        if (r121 != (r127 - 1)) goto L69;
        r128 = Math.max(r129, r128);
    L69:
        int r130 = r128 - r126;
        int r131 = r106.f492525d;
        if (r131 == 1) goto L74;
        if (r131 == 2) goto L73;
        Layout.Alignment r132 = Layout.Alignment.ALIGN_NORMAL;
    L75:
        Layout r133 = g(r107, r130, r132);
        io.noties.markwon.core.spans.u[] r134 = (io.noties.markwon.core.spans.u[]) r107.getSpans(0, r107.length(), io.noties.markwon.core.spans.u.class);
        if (r134 == null) goto L80;
        int r135 = r134.length;
        int r136 = 0;
    L78:
        if (r136 >= r135) goto L80;
        r107.removeSpan(r134[r136]);
        r136 = r136 + 1;
    L80:
        r107.setSpan(new io.noties.markwon.core.spans.u(r133), 0, r107.length(), 18);
        ListProtector.add(this.f492489c, r121, r133);
        wsc.f[] r137 = (wsc.f[]) r107.getSpans(0, r107.length(), wsc.f.class);
        if (r137 == null) goto L98;
        if (r137.length != 0) goto L85;
        boolean r138 = true;
    L87:
        if ((!r138) == false) goto L98;
        int r139 = r137.length;
        int r140 = 0;
    L89:
        if (r140 >= r139) goto L98;
        wsc.a r141 = r137[r140].f561138b;
        if (r141.getCallback() == null) goto L93;
        boolean r142 = true;
    L94:
        if (r142 == true) goto L97;
        r141.c(new n(this));
    L97:
        r140 = r140 + 1;
        goto L89
    L93:
        r142 = false;
        goto L94
    L85:
        r138 = false;
    L98:
        r121 = r105;
        goto L47
    L73:
        r132 = Layout.Alignment.ALIGN_OPPOSITE;
        goto L75
    L74:
        r132 = Layout.Alignment.ALIGN_CENTER;
        goto L75
    L99:
        return;
    L17:
        if (r116.f492524c != 0.0f) goto L41;
    L18:
        g.b r143 = (g.b) CollectionsKt.firstOrNull(this.f492500n);
        if (r143 == null) goto L23;
        List<g.a> r144 = r143.f492528b;
        if (r144 == null) goto L23;
        int r145 = r144.size();
    L24:
        Iterator<Integer> r146 = RangesKt.until(0, r145).iterator();
    L26:
        if (r146.hasNext() == false) goto L41;
        int r147 = ((IntIterator) r146).nextInt();
        Iterator<T> r148 = this.f492500n.iterator();
        float r149 = 0.0f;
    L29:
        if (r148.hasNext() == false) goto L37;
        g.b r150 = (g.b) r148.next();
        CharSequence r151 = ((g.a) ListProtector.get(r150.f492528b, r147)).f492526e;
        int r152 = ((g.a) ListProtector.get(r150.f492528b, r147)).f492525d;
        if (r152 == 1) goto L35;
        if (r152 == 2) goto L34;
        Layout.Alignment r153 = Layout.Alignment.ALIGN_NORMAL;
    L36:
        r149 = Math.max(r149, g(r151, Integer.MAX_VALUE, r153).getLineWidth(0));
        goto L29
    L34:
        r153 = Layout.Alignment.ALIGN_OPPOSITE;
        goto L36
    L35:
        r153 = Layout.Alignment.ALIGN_CENTER;
        goto L36
    L37:
        Iterator<T> r154 = this.f492500n.iterator();
    L39:
        if (r154.hasNext() == false) goto L26;
        ((g.a) ListProtector.get(((g.b) r154.next()).f492528b, r147)).f492524c = r149;
    L23:
        r145 = 0;
        goto L24
    L5:
        r100 = r110;
        goto L6
    }

    public final Layout g(CharSequence r110, int r111, Layout.Alignment r112) {
        if (Build.VERSION.SDK_INT < 23) goto L6;
        return StaticLayout.Builder.obtain(r110, 0, r110.length(), this.f492490d, r111).setIncludePad(false).setAlignment(r112).setLineSpacing(0.0f, 1.0f).setMaxLines(Integer.MAX_VALUE).build();
    L6:
        return new StaticLayout(r110, this.f492490d, r111, r112, 1.0f, 0.0f, false);
    }

    @Override // android.text.SpanWatcher
    public final void onSpanAdded(Spannable r100, Object r101, int r102, int r103) {
        if ((r101 instanceof UpdateAppearance) == true) goto L5;
        return;
    L5:
        if ((r101 instanceof UpdateLayout) == true) goto L9;
        this.f492495i = true;
        return;
    }

    @Override // android.text.SpanWatcher
    public final void onSpanRemoved(Spannable r100, Object r101, int r102, int r103) {
        if ((r101 instanceof UpdateAppearance) == true) goto L5;
        return;
    L5:
        if ((r101 instanceof UpdateLayout) == true) goto L9;
        this.f492495i = true;
        return;
    }

    public TableRowSpan2(u r100, ctc.e r101, List<g.b> r102, g.b r103, ctc.a r104) {
        this.f492498l = r100;
        this.f492499m = r101;
        this.f492500n = r102;
        this.f492501o = r103;
        this.f492502p = r104;
        this.f492489c = new ArrayList(r103.f492528b.size());
        TextPaint r105 = new TextPaint();
        r105.setTextSize(r100.f492561k);
        r105.setColor(r100.f492564n);
        this.f492490d = r105;
        this.f492491e = new Rect();
        this.f492492f = new Paint(1);
        this.f492493g = new GradientDrawable();
        Paint r106 = new Paint();
        r106.setStyle(Paint.Style.FILL);
        this.f492494h = r106;
        GradientDrawable r107 = new GradientDrawable();
        r107.setColor(r101.f465406d);
        r107.setBounds(0, 0, r101.f465403a, r101.f465404b);
        r107.setCornerRadius(r101.f465404b * 0.5f);
        this.f492496j = r107;
    }

    @Override // android.text.style.ReplacementSpan
    public final int getSize(Paint r100, CharSequence r101, int r102, int r103, Paint.FontMetricsInt r104) {
        f(r101, r102, r103);
        ctc.a r105 = this.f492502p;
        r105.f465381b = Math.max(0.0f, Math.max(r105.f465381b, d() - (this.f492498l.f492557g - this.f492497k)));
        if (this.f492489c.size() <= 0) goto L19;
        if (r104 == null) goto L19;
        if (this.f492501o.f492527a != CollectionsKt.getLastIndex(this.f492500n)) goto L8;
        int r106 = this.f492498l.f492555e;
        ctc.e r107 = this.f492499m;
        int r108 = Math.max(r106, MathKt.roundToInt(r107.f465404b + r107.f465405c));
    L9:
        ArrayList<Layout> r109 = this.f492489c;
        ArrayList r110 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r109, 10));
        Iterator<Layout> r111 = r109.iterator();
    L11:
        if (r111.hasNext() == false) goto L13;
        r110.add(Integer.valueOf(r111.next().getHeight()));
        goto L11
    L13:
        Integer r112 = (Integer) CollectionsKt.max(r110);
        if (r112 == null) goto L16;
        int r113 = r112.intValue();
    L17:
        int r114 = -((r113 + this.f492498l.f492555e) + r108);
        r104.ascent = r114;
        r104.descent = 0;
        r104.top = r114;
        r104.bottom = 0;
        this.f492495i = false;
        goto L19
    L16:
        r113 = 0;
        goto L17
    L8:
        r108 = this.f492498l.f492555e;
    L19:
        return e();
    }

    @Override // android.text.SpanWatcher
    public final void onSpanChanged(Spannable r100, Object r101, int r102, int r103, int r104, int r105) {
        if ((r101 instanceof UpdateAppearance) == true) goto L5;
        return;
    L5:
        if ((r101 instanceof UpdateLayout) == true) goto L9;
        this.f492495i = true;
        return;
    }

    /* JADX WARN: Type inference failed for: r0v38, types: [io.noties.markwon.ext.tables.TableRowSpan2$draw$3] */
    @Override // android.text.style.ReplacementSpan
    public final void draw(final Canvas r210, CharSequence r211, int r212, int r213, float r214, int r215, int r216, int r217, Paint r218) {
        if (this.f492495i == false) goto L5;
        f(r211, r212, r213);
    L5:
        Paint r100 = this.f492492f;
        g.b r101 = this.f492501o;
        if (r101.f492529c == false) goto L9;
        int r102 = this.f492498l.f492550d;
    L12:
        r100.setColor(r102);
        this.f492492f.setStyle(Paint.Style.FILL);
        u r103 = this.f492498l;
        Paint r104 = this.f492492f;
        int r105 = r103.f492548b;
        if (r105 != (-1)) goto L15;
        r105 = (int) (r104.getStrokeWidth() + 0.5f);
    L15:
        final Ref.FloatRef r106 = new Ref.FloatRef();
        r106.element = this.f492498l.f492563m;
        final Ref.FloatRef r110 = new Ref.FloatRef();
        u r111 = this.f492498l;
        r110.element = r111.f492562l;
        c r112 = r111.f492566p;
        if (r112 == null) goto L18;
        Drawable r107 = r112.a(r211, r212, r213);
    L20:
        if (this.f492492f.getColor() == 0) goto L22;
    L24:
        int r108 = r210.save();
        this.f492493g.setStroke(r105, this.f492498l.f492547a);     // Catch: Throwable -> L90
        int r113 = (r217 - r215) + r105;     // Catch: Throwable -> L90
        this.f492493g.setBounds(0, 0, e(), r113);     // Catch: Throwable -> L90
        int r114 = this.f492501o.f492527a;     // Catch: Throwable -> L90
        if (r114 != 0) goto L28;
        float r115 = this.f492498l.f492563m;     // Catch: Throwable -> L90
    L29:
        r106.element = r115;     // Catch: Throwable -> L90
        if (r114 != CollectionsKt.getLastIndex(this.f492500n)) goto L32;
        float r116 = this.f492498l.f492562l;     // Catch: Throwable -> L90
    L33:
        r110.element = r116;     // Catch: Throwable -> L90
        float r117 = r106.element;     // Catch: Throwable -> L90
        if (r117 == 0.0f) goto L36;
    L39:
        this.f492493g.setCornerRadii(new float[]{r117, r117, r117, r117, r116, r116, r116, r116});     // Catch: Throwable -> L90
    L40:
        this.f492493g.setColor(this.f492492f.getColor());     // Catch: Throwable -> L90
        r210.translate(r214, r215);     // Catch: Throwable -> L90
        this.f492493g.draw(r210);     // Catch: Throwable -> L90
        if (r107 == null) goto L43;
        r107.setBounds(0, 0, e(), r113);     // Catch: Throwable -> L90
        r107.draw(r210);     // Catch: Throwable -> L90
    L43:
        r210.restoreToCount(r108);
    L44:
        this.f492492f.set(r218);
        u r109 = this.f492498l;
        Paint r118 = this.f492492f;
        int r119 = r109.f492547a;
        if (r119 != 0) goto L47;
        r119 = ftc.a.a(r118.getColor(), 75);
    L47:
        r118.setColor(r119);
        r118.setStyle(Paint.Style.FILL);
        int r120 = r105 / 2;
        int r121 = r217 - r215;
        Iterator r122 = this.f492489c.iterator();
        int r123 = 0;
        int r124 = 0;
    L49:
        if (r122.hasNext() == false) goto L64;
        Object r125 = r122.next();
        int r126 = r123 + 1;
        if (r123 >= 0) goto L53;
        CollectionsKt.throwIndexOverflow();
    L53:
        Layout r127 = (Layout) r125;
        int r128 = r210.save();
        Iterator r219 = r122;
        int r129 = (int) r214;
        r210.clipRect(r129, r215, r129 + e(), r217);     // Catch: Throwable -> L60
        r210.translate((r124 + r214) + this.f492502p.f465380a, r215);     // Catch: Throwable -> L60
        r124 = r124 + (r127.getWidth() + (this.f492498l.f492556f * 2));     // Catch: Throwable -> L60
        if (r105 <= 0) goto L58;
        if (r123 == 0) goto L58;
        this.f492491e.set(-r120, 0, r120, r121);     // Catch: Throwable -> L60
        r210.drawRect(this.f492491e, this.f492492f);     // Catch: Throwable -> L60
    L58:
        u r130 = this.f492498l;     // Catch: Throwable -> L60
        r210.translate(r130.f492556f, r130.f492555e + r105);     // Catch: Throwable -> L60
        r127.draw(r210);     // Catch: Throwable -> L60
        r210.restoreToCount(r128);
        r122 = r219;
        r123 = r126;
    L60:
        th = move-exception;
        r210.restoreToCount(r128);
        throw th;
    L64:
        if (this.f492502p.a() == false) goto L77;
        u r131 = this.f492498l;
        if (r131.f492560j == 0) goto L77;
        if (r131.f492562l == 0.0f) goto L77;
        ?? r132 = new AnonymousClass3(this, r106, r110, r210);
        int r133 = r210.save();
        r210.translate(r214, r215);
        if (Math.abs(this.f492502p.f465380a) <= 0.0f) goto L73;
        r132.invoke(true);
    L73:
        if (Math.abs(this.f492502p.f465380a) >= this.f492502p.f465381b) goto L75;
        r132.invoke(false);
    L75:
        r210.restoreToCount(r133);
    L77:
        if (this.f492501o.f492527a == CollectionsKt.getLastIndex(this.f492500n)) goto L79;
        return;
    L79:
        if (this.f492488b == true) goto L100;
        int r134 = r210.save();
        ctc.a r135 = this.f492502p;     // Catch: Throwable -> L86
        float r136 = (-r135.f465380a) / r135.f465381b;     // Catch: Throwable -> L86
        int r137 = this.f492498l.f492557g - this.f492497k;     // Catch: Throwable -> L86
        ctc.e r138 = this.f492499m;     // Catch: Throwable -> L86
        r210.translate(r136 * (r137 - r138.f465403a), (r217 - r138.f465404b) - r138.f465405c);     // Catch: Throwable -> L86
        if (this.f492496j.getBounds().left != 0) goto L84;
        this.f492496j.getBounds().left += this.f492497k;     // Catch: Throwable -> L86
        this.f492496j.getBounds().right += this.f492497k;     // Catch: Throwable -> L86
    L84:
        this.f492496j.draw(r210);     // Catch: Throwable -> L86
        r210.restoreToCount(r134);
        return;
    L86:
        th = move-exception;
        r210.restoreToCount(r134);
        throw th;
    L100:
        return;
    L36:
        if (r116 != 0.0f) goto L39;
        this.f492493g.setCornerRadius(0.0f);     // Catch: Throwable -> L90
        goto L40
    L32:
        r116 = 0.0f;
        goto L33
    L28:
        r115 = 0.0f;
    L90:
        th = move-exception;
        r210.restoreToCount(r108);
        throw th;
    L22:
        if (this.f492498l.f492547a != 0) goto L24;
        if (r107 == null) goto L44;
    L18:
        r107 = null;
        goto L20
    L9:
        if ((r101.f492527a % 2) != 1) goto L11;
        r102 = this.f492498l.f492549c;
        goto L12
    L11:
        this.f492498l.getClass();
        r102 = 0;
        goto L12
    }
}
