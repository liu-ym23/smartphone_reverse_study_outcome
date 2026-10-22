package qw8;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ReplacementSpan;
import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.larus.business.markdown.api.depend.IMarkdownLoggerKt;
import com.larus.nova.R;
import io.noties.markwon.core.spans.o;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import kotlin.TypeCastException;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class c extends ReplacementSpan implements jw8.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Object> f535051a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f535052b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f535053c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f535054d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Integer f535055e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f535056f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final jw8.a f535057g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f535058h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public TextView f535059i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Size f535060j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public jw8.c f535061k;

    public static final class a {
    }

    static {
    }

    @Override // jw8.b
    public final void m(Spanned r100, jw8.b r101) {
        Intrinsics.checkNotNullParameter(r100, "text");
        Intrinsics.checkNotNullParameter(r101, "span");
    }

    @Override // jw8.b
    public final String getCode() {
        return this.f535052b;
    }

    @Override // jw8.b
    public final Integer getEndIndex() {
        return this.f535055e;
    }

    @Override // jw8.b
    public final String getLanguage() {
        return this.f535053c;
    }

    @Override // jw8.b
    public final Integer getStartIndex() {
        return this.f535054d;
    }

    @Override // jw8.b
    public final void a(TextView r100) {
        Intrinsics.checkNotNullParameter(r100, "textView");
        n(r100.getText());
    }

    @Override // tsc.o
    public final void f(TextView r100) {
        Intrinsics.checkNotNullParameter(r100, "textView");
        jw8.c r101 = this.f535061k;
        if (r101 == null) goto L6;
        r101.f();
        return;
    }

    public final void n(CharSequence r100) {
        Objects.toString(r100);
    }

    @Override // jw8.b
    public final void e(TextView r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "textView");
        if (r101 == false) goto L14;
        jw8.c r102 = this.f535061k;
        if (r102 == null) goto L14;
        View r103 = r102.a(r100.getContext());
        if (r103 == null) goto L14;
        ViewParent r104 = r103.getParent();
        if ((r104 instanceof ViewGroup) == false) goto L11;
        ViewGroup r105 = (ViewGroup) r104;
    L12:
        if (r105 == null) goto L14;
        r105.removeView(r103);
        goto L14
    L11:
        r105 = null;
    L14:
        this.f535059i = null;
        n(null);
    }

    @Override // jw8.b
    public final void b(TextView r110, Spanned r111, lw8.d r112) {
        Intrinsics.checkNotNullParameter(r110, "textView");
        Intrinsics.checkNotNullParameter(r111, "text");
        this.f535059i = r110;     // Catch: Exception -> L57
        ViewParent r100 = r110.getParent();     // Catch: Exception -> L57
        Map r101 = null;
        if ((r100 instanceof FrameLayout) == false) goto L6;
        FrameLayout r102 = (FrameLayout) r100;     // Catch: Exception -> L57
    L8:
        if ((r110 instanceof ow8.a) == false) goto L55;
        if (r102 == null) goto L55;
        Integer r103 = this.f535054d;     // Catch: Exception -> L57
        if (r103 == null) goto L19;
        Object r104 = r110.getTag(R.id.markwon_cached_code_widget_list);     // Catch: Exception -> L57
        if (TypeIntrinsics.isMutableMap(r104) == false) goto L17;
        Map r105 = (Map) r104;     // Catch: Exception -> L57
    L18:
        if (r105 == null) goto L19;
        jw8.c r106 = (jw8.c) r105.get(r103);     // Catch: Exception -> L57
    L21:
        if (r106 != null) goto L36;
        jw8.a r107 = this.f535057g;     // Catch: Exception -> L57
        if (r107 == null) goto L26;
        jw8.c r113 = r107.a(r102, r110, r111, this, r112);     // Catch: Exception -> L57
        if (r113 == null) goto L26;
    L27:
        r106 = r113;
        Integer r114 = this.f535054d;     // Catch: Exception -> L57
        if (r114 == null) goto L36;
        Object r108 = r110.getTag(R.id.markwon_cached_code_widget_list);     // Catch: Exception -> L57
        if (TypeIntrinsics.isMutableMap(r108) == false) goto L33;
        r101 = (Map) r108;     // Catch: Exception -> L57
    L33:
        if (r101 != null) goto L35;
        r101 = new LinkedHashMap();     // Catch: Exception -> L57
    L35:
        r101.put(r114, r106);     // Catch: Exception -> L57
        r110.setTag(R.id.markwon_cached_code_widget_list, r101);     // Catch: Exception -> L57
    L26:
        r113 = new com.larus.business.markdown.impl.markwon.core.spans.codeblock.replacementspan.normal.a();     // Catch: Exception -> L57
    L36:
        jw8.c r115 = r106;
        Map<String, Object> r109 = this.f535051a;     // Catch: Exception -> L57
        Integer r116 = this.f535054d;     // Catch: Exception -> L57
        if (r116 != null) goto L39;
        int r117 = this.f535056f;     // Catch: Exception -> L57
    L40:
        Size r118 = r115.b(r110, r111, this, r109, r117, this.f535058h);     // Catch: Exception -> L57
        this.f535060j = r118;     // Catch: Exception -> L57
        r118.getWidth();     // Catch: Exception -> L57
        this.f535060j.getHeight();     // Catch: Exception -> L57
        n(r110.getText());     // Catch: Exception -> L57
        View r119 = r115.a(r110.getContext());     // Catch: Exception -> L57
        ViewGroup.LayoutParams r120 = r119.getLayoutParams();     // Catch: Exception -> L57
        if (r120 != null) goto L44;
        r119.setLayoutParams(new FrameLayout.LayoutParams(this.f535060j.getWidth(), this.f535060j.getHeight()));     // Catch: Exception -> L57
        r119.setVisibility(4);     // Catch: Exception -> L57
    L50:
        this.f535061k = r115;     // Catch: Exception -> L57
        if (r119.getParent() != null) goto L63;
        r102.addView(r119);     // Catch: Exception -> L57
        return;
    L63:
        return;
    L44:
        if (r120.width == this.f535060j.getWidth()) goto L46;
    L47:
        ViewGroup.LayoutParams r121 = r119.getLayoutParams();     // Catch: Exception -> L57
        if (r121 == null) goto L54;
        r121.width = this.f535060j.getWidth();     // Catch: Exception -> L57
        r121.height = this.f535060j.getHeight();     // Catch: Exception -> L57
        r119.setLayoutParams(r121);     // Catch: Exception -> L57
        goto L50
    L54:
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");     // Catch: Exception -> L57
    L46:
        if (r120.height == this.f535060j.getHeight()) goto L50;
    L39:
        r117 = this.f535056f - gw8.e.a(r111, r116.intValue());     // Catch: Exception -> L57
        goto L40
    L17:
        r105 = null;
    L19:
        r106 = null;
    L55:
        this.f535061k = null;     // Catch: Exception -> L57
        return;
    L6:
        r102 = null;
    L57:
        e = move-exception;
        com.larus.business.markdown.api.depend.d r122 = IMarkdownLoggerKt.a();
        if (r122 == null) goto L65;
        r122.e("CustomCodeSpan", "beforeAttach error:" + e);
        return;
    }

    @Override // android.text.style.ReplacementSpan
    public final int getSize(Paint r100, CharSequence r101, int r102, int r103, Paint.FontMetricsInt r104) {
        Intrinsics.checkNotNullParameter(r100, "paint");
        if (r101 != null) goto L5;
    L7:
        boolean r105 = false;
    L8:
        if (r105 == false) goto L10;
        int r106 = this.f535060j.getHeight();
    L14:
        if (r104 == null) goto L16;
        int r107 = -r106;
        r104.ascent = r107;
        r104.descent = 0;
        r104.top = r107;
        r104.bottom = 0;
    L16:
        this.f535060j.getWidth();
        n(r101);
        return this.f535060j.getWidth();
    L10:
        TextView r108 = this.f535059i;
        if (r108 == null) goto L13;
        r106 = (int) ((this.f535060j.getHeight() - r108.getLineSpacingExtra()) / r108.getLineSpacingMultiplier());
        goto L14
    L13:
        r106 = this.f535060j.getHeight();
        goto L14
    L5:
        if (r101.length() != r103) goto L7;
        r105 = true;
        goto L8
    }

    public c(Map<String, ? extends Object> r100, String r101, String r102, Integer r103, Integer r104, int r105, jw8.a r106, boolean r107) {
        this.f535051a = r100;
        this.f535052b = r101;
        this.f535053c = r102;
        this.f535054d = r103;
        this.f535055e = r104;
        this.f535056f = r105;
        this.f535057g = r106;
        this.f535058h = r107;
        this.f535060j = new Size(0, 0);
    }

    @Override // android.text.style.ReplacementSpan
    public final void draw(Canvas r100, final CharSequence r101, final int r102, int r110, float r111, int r112, int r113, int r114, Paint r115) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        Intrinsics.checkNotNullParameter(r115, "paint");
        TextView r103 = this.f535059i;
        if (r103 != null) goto L5;
        return;
    L5:
        jw8.c r116 = this.f535061k;
        if (r116 != null) goto L8;
        return;
    L8:
        final View r117 = r116.a(r103.getContext());
        o r104 = null;
        if ((r101 instanceof SpannableString) == false) goto L11;
        SpannableString r118 = (SpannableString) r101;
    L12:
        if (r118 == null) goto L16;
        o[] r119 = (o[]) r118.getSpans(r102, r110, o.class);
        if (r119 == null) goto L16;
        r104 = (o) ArraysKt.firstOrNull(r119);
    L16:
        if (r104 == null) goto L18;
        float r120 = r104.getAlpha();
    L19:
        r117.setAlpha(r120 / 255);
        final int r105 = ((r112 + r103.getTop()) + r103.getPaddingTop()) + (((r114 - r112) - this.f535060j.getHeight()) / 2);
        int r121 = (((int) r111) + r103.getLeft()) + r103.getPaddingLeft();
        ViewGroup.LayoutParams r106 = r117.getLayoutParams();
        Intrinsics.checkNotNull(r106, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r107 = (ViewGroup.MarginLayoutParams) r106;
        if (r107.topMargin == r105) goto L22;
    L28:
        ViewGroup.LayoutParams r108 = r117.getLayoutParams();
        if (r108 == null) goto L33;
        ViewGroup.MarginLayoutParams r109 = (ViewGroup.MarginLayoutParams) r108;
        r109.topMargin = r105;
        r109.leftMargin = r121;
        r117.setLayoutParams(r109);
        r117.setVisibility(4);
        r117.post(new b(this, r105, r101, r102, r117));
        return;
    L33:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L22:
        if (r107.leftMargin != r121) goto L28;
        if (r117.getVisibility() == 0) goto L27;
        n(r101);
        r117.setVisibility(0);
        return;
    L27:
        n(r101);
        return;
    L18:
        r120 = 255.0f;
        goto L19
    L11:
        r118 = null;
        goto L12
    }
}
