package tw8;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ReplacementSpan;
import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.larus.nova.R;
import io.noties.markwon.core.spans.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.TypeCastException;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;
import usc.d;
import usc.e;
import usc.f;

/* JADX INFO: loaded from: classes26.dex */
public final class b extends ReplacementSpan implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f547780a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f547781b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f547782c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f547783d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f547784e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f547785f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f547786g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f547787h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final com.larus.business.markdown.api.depend.a f547788i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Map<String, ? extends Object> f547789j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f547790k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f547791l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f547792m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f547793n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public TextView f547794o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Spanned f547795p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public f f547796q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Size f547797r;

    public static final class a {
    }

    static {
    }

    public b() {
        throw null;
    }

    @Override // usc.e
    public final void j() {
        this.f547793n = true;
    }

    public final boolean o() {
        if (Intrinsics.areEqual(this.f547780a, "mixed_media_card") == true) goto L9;
        if (Intrinsics.areEqual(this.f547780a, "creation") == true) goto L9;
        if (Intrinsics.areEqual(this.f547780a, "vlm_mixed_media_card") == true) goto L9;
    L11:
        return false;
    L9:
        if (this.f547790k == false) goto L11;
        return true;
    }

    @Override // usc.e
    public final String getDataType() {
        return this.f547780a;
    }

    @Override // usc.e
    public final String h() {
        return this.f547781b;
    }

    @Override // usc.e
    public final String i() {
        return this.f547784e;
    }

    @Override // usc.e
    public final String k() {
        return this.f547782c;
    }

    @Override // usc.e
    public final String l() {
        return this.f547783d;
    }

    @Override // usc.e
    public final void a(TextView r100) {
        Intrinsics.checkNotNullParameter(r100, "textView");
        r100.getText();
    }

    @Override // usc.e
    public final void c(TextView r100) {
        Intrinsics.checkNotNullParameter(r100, "textView");
        f r101 = this.f547796q;
        if (r101 == null) goto L12;
        View r102 = r101.asView();
        if (r102 == null) goto L12;
        ViewParent r103 = r102.getParent();
        if ((r103 instanceof ViewGroup) == false) goto L9;
        ViewGroup r104 = (ViewGroup) r103;
    L10:
        if (r104 == null) goto L12;
        r104.removeView(r102);
        goto L12
    L9:
        r104 = null;
    L12:
        this.f547794o = null;
    }

    @Override // tsc.o
    public final void f(TextView r100) {
        Intrinsics.checkNotNullParameter(r100, "textView");
        f r101 = this.f547796q;
        if (r101 == null) goto L6;
        r101.f();
        return;
    }

    public final int n(Spanned r100) {
        if (o() == false) goto L13;
        int r101 = this.f547787h;
        TextView r102 = this.f547794o;
        int r103 = 0;
        if (r102 == null) goto L7;
        int r104 = r102.getPaddingStart();
    L8:
        int r105 = r101 + r104;
        TextView r106 = this.f547794o;
        if (r106 == null) goto L17;
        r103 = r106.getPaddingEnd();
    L17:
        return r105 + r103;
    L7:
        r104 = 0;
        goto L8
    L13:
        if (this.f547790k == false) goto L16;
        return this.f547787h;
    L16:
        return this.f547787h - gw8.e.a(r100, this.f547785f);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // usc.e
    public final void d(TextView r210, Spanned r211) {
        Intrinsics.checkNotNullParameter(r210, "textView");
        Intrinsics.checkNotNullParameter(r211, "text");
        this.f547794o = r210;
        this.f547795p = r211;
        Object r100 = r210.getTag(R.id.textview_padding_start);
        Object r101 = null;
        ViewGroup r102 = null;
        if ((r100 instanceof Integer) == false) goto L5;
        Integer r103 = (Integer) r100;
    L7:
        if (r103 == null) goto L29;
        int r104 = r103.intValue();
        Object r105 = r210.getTag(R.id.textview_padding_top);
        if ((r105 instanceof Integer) == false) goto L11;
        Integer r106 = (Integer) r105;
    L12:
        if (r106 == null) goto L29;
        int r107 = r106.intValue();
        Object r108 = r210.getTag(R.id.textview_padding_end);
        if ((r108 instanceof Integer) == false) goto L16;
        Integer r109 = (Integer) r108;
    L17:
        if (r109 == null) goto L29;
        int r110 = r109.intValue();
        Object r111 = r210.getTag(R.id.textview_padding_bottom);
        if ((r111 instanceof Integer) == false) goto L21;
        Integer r112 = (Integer) r111;
    L22:
        if (r112 == null) goto L29;
        int r113 = r112.intValue();
        if (Intrinsics.areEqual(this.f547784e, "data-block-full") == false) goto L27;
        this.f547787h += r104 + r110;
        r210.setPadding(0, 0, 0, 0);
        goto L29
    L27:
        if (r210.getPaddingStart() != 0) goto L29;
        r210.setPadding(r104, r107, r110, r113);
        goto L29
    L21:
        r112 = null;
        goto L22
    L16:
        r109 = null;
        goto L17
    L11:
        r106 = null;
    L29:
        String r114 = this.f547780a;
        Intrinsics.checkNotNullParameter(r114, "dataType");
        if (Intrinsics.areEqual(r114, "lynx") == false) goto L32;
    L35:
        boolean r115 = true;
    L37:
        if (r115 == false) goto L39;
    L44:
        boolean r116 = true;
    L46:
        if (r116 == false) goto L123;
        ViewParent r117 = r210.getParent();
        if ((r117 instanceof FrameLayout) == false) goto L50;
        FrameLayout r118 = (FrameLayout) r117;
    L52:
        if ((r210 instanceof ow8.a) == false) goto L122;
        if (r118 == null) goto L122;
        if (Intrinsics.areEqual(this.f547780a, "search_reference") == false) goto L65;
        int r119 = StringsKt.indexOf$default(this.f547782c, "_", 0, false, 6, null);
        if (r119 != (-1)) goto L60;
        String r120 = this.f547782c;
    L66:
        String r121 = r120;
        int r122 = d.f551580a;
        int r123 = this.f547785f;
        int r124 = this.f547786g;
        String r125 = this.f547780a;
        String r126 = this.f547781b;
        String r127 = this.f547784e;
        Object r128 = r118.getTag(R.id.markwon_cached_lynx_widget_list);
        if (TypeIntrinsics.isMutableList(r128) == true) goto L69;
        r128 = null;
    L69:
        List r129 = (List) r128;
        if (r129 == null) goto L95;
        Iterator r130 = r129.iterator();
    L73:
        if (r130.hasNext() == false) goto L91;
        Object r131 = r130.next();
        usc.b r132 = (usc.b) r131;
        if (r132.f551568a == r123) goto L77;
    L87:
        boolean r133 = false;
    L88:
        if (r133 == false) goto L73;
    L92:
        usc.b r134 = (usc.b) r131;
        if (r134 == null) goto L95;
        f r135 = r134.f551574g;
    L97:
        if (r135 == null) goto L112;
        Size r136 = r135.d(r210, r211, this, n(r211), this.f547789j);
        this.f547797r = r136;
        r136.getWidth();
        this.f547797r.getHeight();
        r210.getText();
        this.f547796q = r135;
        View r137 = r135.asView();
        ViewGroup.LayoutParams r138 = r137.getLayoutParams();
        if (r138.width == this.f547797r.getWidth()) goto L101;
    L102:
        ViewGroup.LayoutParams r139 = r137.getLayoutParams();
        if (r139 == null) goto L111;
        r139.width = this.f547797r.getWidth();
        r139.height = -2;
        r137.setLayoutParams(r139);
    L105:
        ViewParent r140 = r137.getParent();
        if ((r140 instanceof ViewGroup) == false) goto L108;
        r102 = (ViewGroup) r140;
    L108:
        if (r102 == null) goto L121;
        r102.removeView(r137);
    L121:
        r118.addView(r137);
        return;
    L111:
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L101:
        if (r138.height == this.f547797r.getHeight()) goto L105;
    L112:
        f r141 = this.f547788i.b(r118, r210, r211, this, this.f547789j);
        Size r142 = r141.d(r210, r211, this, n(r211), this.f547789j);
        this.f547797r = r142;
        r142.getWidth();
        this.f547797r.getHeight();
        r210.getText();
        r137 = r141.asView();
        r137.setLayoutParams(new FrameLayout.LayoutParams(this.f547797r.getWidth(), -2));
        r137.setVisibility(4);
        this.f547796q = r141;
        int r143 = d.f551580a;
        int r144 = this.f547785f;
        int r145 = this.f547786g;
        String r146 = this.f547780a;
        String r147 = this.f547781b;
        String r148 = this.f547784e;
        Object r149 = r118.getTag(R.id.markwon_cached_lynx_widget_list);
        if (TypeIntrinsics.isMutableList(r149) == false) goto L116;
        r101 = r149;
    L116:
        List r150 = (List) r101;
        if (r150 != null) goto L120;
        r150 = new ArrayList();
    L120:
        r150.add(new usc.b(r144, r145, r146, r147, r121, r148, r141));
        r118.setTag(R.id.markwon_cached_lynx_widget_list, r150);
        goto L121
    L77:
        if (r132.f551569b != r124) goto L87;
        if (Intrinsics.areEqual(r132.f551570c, r125) == false) goto L87;
        if (Intrinsics.areEqual(r132.f551571d, r126) == false) goto L87;
        if (Intrinsics.areEqual(r132.f551572e, r121) == false) goto L87;
        if (Intrinsics.areEqual(r132.f551573f, r127) == false) goto L87;
        r133 = true;
        goto L88
    L91:
        r131 = null;
    L95:
        r135 = null;
        goto L97
    L60:
        StringBuilder r151 = new StringBuilder();
        String r152 = this.f547782c;
        int r153 = r119 + 1;
        if (r152 == null) goto L64;
        r151.append(r152.substring(0, r153));
        r151.append(this.f547785f);
        r120 = r151.toString();
        goto L66
    L64:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L65:
        r120 = this.f547782c;
    L122:
        this.f547796q = null;
        return;
    L50:
        r118 = null;
        goto L52
    L123:
        ViewParent r154 = r210.getParent();
        if ((r154 instanceof FrameLayout) == false) goto L126;
        FrameLayout r155 = (FrameLayout) r154;
    L128:
        if ((r210 instanceof ow8.a) == false) goto L171;
        if (r155 == null) goto L171;
        int r156 = this.f547785f;
        int r157 = this.f547786g;
        String r158 = this.f547780a;
        String r159 = this.f547781b;
        String r160 = this.f547782c;
        Object r161 = r155.getTag(R.id.markwon_cached_widget_list);
        if (TypeIntrinsics.isMutableList(r161) == true) goto L134;
        r161 = null;
    L134:
        List r162 = (List) r161;
        if (r162 == null) goto L158;
        Iterator r163 = r162.iterator();
    L138:
        if (r163.hasNext() == false) goto L154;
        Object r164 = r163.next();
        usc.b r165 = (usc.b) r164;
        if (r165.f551568a == r156) goto L142;
    L150:
        boolean r166 = false;
    L151:
        if (r166 == false) goto L138;
    L155:
        usc.b r167 = (usc.b) r164;
        if (r167 == null) goto L158;
        r162.remove(r167);
        r155.setTag(R.id.markwon_cached_widget_list, r162);
        f r168 = r167.f551574g;
    L159:
        if (r168 == null) goto L169;
        Size r169 = r168.d(r210, r211, this, n(r211), this.f547789j);
        this.f547797r = r169;
        r169.getWidth();
        this.f547797r.getHeight();
        r210.getText();
        this.f547796q = r168;
        View r170 = r168.asView();
        ViewGroup.LayoutParams r171 = r170.getLayoutParams();
        if (r171.width == this.f547797r.getWidth()) goto L163;
    L164:
        ViewGroup.LayoutParams r172 = r170.getLayoutParams();
        if (r172 == null) goto L168;
        r172.width = this.f547797r.getWidth();
        r172.height = this.f547797r.getHeight();
        r170.setLayoutParams(r172);
    L170:
        r155.addView(r170);
        return;
    L168:
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L163:
        if (r171.height == this.f547797r.getHeight()) goto L170;
    L169:
        f r173 = this.f547788i.b(r155, r210, r211, this, this.f547789j);
        Size r174 = r173.d(r210, r211, this, n(r211), this.f547789j);
        this.f547797r = r174;
        r174.getWidth();
        this.f547797r.getHeight();
        r210.getText();
        r170 = r173.asView();
        r170.setLayoutParams(new FrameLayout.LayoutParams(this.f547797r.getWidth(), this.f547797r.getHeight()));
        r170.setVisibility(4);
        this.f547796q = r173;
        goto L170
    L142:
        if (r165.f551569b != r157) goto L150;
        if (Intrinsics.areEqual(r165.f551570c, r158) == false) goto L150;
        if (Intrinsics.areEqual(r165.f551571d, r159) == false) goto L150;
        if (Intrinsics.areEqual(r165.f551572e, r160) == false) goto L150;
        r166 = true;
        goto L151
    L154:
        r164 = null;
    L158:
        r168 = null;
    L171:
        this.f547796q = null;
        return;
    L126:
        r155 = null;
        goto L128
    L39:
        if (Intrinsics.areEqual(this.f547780a, "applet") == true) goto L44;
        if (Intrinsics.areEqual(this.f547780a, "search_reference") == true) goto L44;
        r116 = false;
        goto L46
    L32:
        if (Intrinsics.areEqual(r114, "lynx_ruyi") == true) goto L35;
        r115 = false;
        goto L37
    L5:
        r103 = null;
        goto L7
    }

    @Override // usc.e
    public final void g(TextView r100, Spanned r101) {
        Intrinsics.checkNotNullParameter(r100, "textView");
        Intrinsics.checkNotNullParameter(r101, "text");
        f r102 = this.f547796q;
        if (r102 != null) goto L5;
        return;
    L5:
        Size r103 = r102.c(r100, this, this.f547789j);
        if (r103 != null) goto L8;
        return;
    L8:
        this.f547797r = r103;
        View r104 = r102.asView();
        ViewGroup.LayoutParams r105 = r104.getLayoutParams();
        if (r105 != null) goto L12;
        return;
    L12:
        if (r105.width == this.f547797r.getWidth()) goto L14;
    L15:
        ViewGroup.LayoutParams r106 = r104.getLayoutParams();
        if (r106 == null) goto L20;
        r106.width = this.f547797r.getWidth();
        r106.height = this.f547797r.getHeight();
        r104.setLayoutParams(r106);
        return;
    L20:
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L14:
        if (r105.height != this.f547797r.getHeight()) goto L15;
    }

    @Override // android.text.style.ReplacementSpan
    public final int getSize(Paint r100, CharSequence r101, int r102, int r103, Paint.FontMetricsInt r104) {
        Intrinsics.checkNotNullParameter(r100, "paint");
        int r105 = 0;
        if (r101 != null) goto L5;
    L7:
        boolean r106 = false;
    L8:
        if (r106 == false) goto L10;
        int r107 = this.f547797r.getHeight();
    L15:
        if (this.f547791l == false) goto L19;
        f r108 = this.f547796q;
        if (r108 == null) goto L19;
        r108.e();
    L19:
        if (r104 == null) goto L21;
        int r109 = -r107;
        r104.ascent = r109;
        r104.descent = 0;
        r104.top = r109;
        r104.bottom = 0;
    L21:
        this.f547797r.getWidth();
        int r110 = this.f547787h;
        Spanned r111 = this.f547795p;
        if (r111 == null) goto L25;
        r105 = gw8.e.a(r111, this.f547785f);
    L25:
        return Math.min(r110 - r105, this.f547797r.getWidth());
    L10:
        TextView r112 = this.f547794o;
        if (r112 == null) goto L13;
        r107 = (int) ((this.f547797r.getHeight() - r112.getLineSpacingExtra()) / r112.getLineSpacingMultiplier());
        goto L15
    L13:
        r107 = this.f547797r.getHeight();
        goto L15
    L5:
        if (r101.length() != r103) goto L7;
        r106 = true;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.text.style.ReplacementSpan
    public final void draw(Canvas r110, final CharSequence r111, final int r112, int r113, float r114, int r115, int r116, int r210, Paint r211) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        Intrinsics.checkNotNullParameter(r211, "paint");
        TextView r100 = this.f547794o;
        if (r100 != null) goto L5;
        return;
    L5:
        f r101 = this.f547796q;
        if (r101 != null) goto L8;
        return;
    L8:
        final View r102 = r101.asView();
        if ((r111 instanceof SpannableString) == false) goto L11;
        SpannableString r103 = (SpannableString) r111;
    L12:
        if (r103 == null) goto L17;
        o[] r104 = (o[]) r103.getSpans(r112, r113, o.class);
        if (r104 == null) goto L17;
        o r105 = (o) ArraysKt.firstOrNull(r104);
    L18:
        if (r105 == null) goto L20;
        float r106 = r105.getAlpha();
    L21:
        r102.setAlpha(r106 / 255);
        final Ref.IntRef r107 = new Ref.IntRef();
        r107.element = (r115 + r100.getTop()) + r100.getPaddingTop();
        if (o() == false) goto L25;
        int r108 = r100.getLeft();
    L29:
        r101.a();
        Integer r109 = r101.b(this.f547797r, r100, r110, r211);
        if (r109 == null) goto L32;
        r108 = r108 + r109.intValue();
    L32:
        ViewGroup.LayoutParams r117 = r102.getLayoutParams();
        if ((r117 instanceof ViewGroup.MarginLayoutParams) == false) goto L35;
        ViewGroup.MarginLayoutParams r118 = (ViewGroup.MarginLayoutParams) r117;
    L37:
        if ((r102 instanceof nw8.a) == false) goto L39;
        ((nw8.a) r102).k(Integer.valueOf(r108), Integer.valueOf(r107.element), null, null);
        return;
    L39:
        if (r118 == null) goto L50;
        if (r118.topMargin == r107.element) goto L43;
    L44:
        ViewGroup.LayoutParams r119 = r102.getLayoutParams();
        if (r119 == null) goto L48;
        ViewGroup.MarginLayoutParams r120 = (ViewGroup.MarginLayoutParams) r119;
        r120.topMargin = r107.element;
        r120.leftMargin = r108;
        r102.setLayoutParams(r120);
        r102.setVisibility(4);
        r102.post(new tw8.a(this, r107, r111, r112, r102));
        return;
    L48:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L43:
        if (r118.leftMargin != r108) goto L44;
    L50:
        if (r102.getVisibility() == 0) goto L53;
        r102.setVisibility(0);
        return;
    L53:
        return;
    L35:
        r118 = null;
        goto L37
    L25:
        if (this.f547790k == false) goto L28;
        int r121 = r100.getLeft();
        int r122 = r100.getPaddingLeft();
    L27:
        r108 = r121 + r122;
        goto L29
    L28:
        r121 = ((int) r114) + r100.getLeft();
        r122 = r100.getPaddingLeft();
        goto L27
    L20:
        r106 = 255.0f;
    L17:
        r105 = null;
        goto L18
    L11:
        r103 = null;
        goto L12
    }

    public b(String r100, String r101, String r102, String r103, String r104, int r105, int r106, int r107, com.larus.business.markdown.api.depend.a r110, Map r111, boolean r112, boolean r113, boolean r114) {
        Intrinsics.checkNotNullParameter(r100, "dataType");
        Intrinsics.checkNotNullParameter(r101, "dataValue");
        Intrinsics.checkNotNullParameter(r102, "dataValueId");
        Intrinsics.checkNotNullParameter(r104, "dataTag");
        Intrinsics.checkNotNullParameter(r110, "dataHandler");
        this.f547780a = r100;
        this.f547781b = r101;
        this.f547782c = r102;
        this.f547783d = r103;
        this.f547784e = r104;
        this.f547785f = r105;
        this.f547786g = r106;
        this.f547787h = r107;
        this.f547788i = r110;
        this.f547789j = r111;
        this.f547790k = r112;
        this.f547791l = r113;
        this.f547792m = r114;
        this.f547793n = false;
        this.f547797r = new Size(0, 0);
        new Rect();
    }
}
