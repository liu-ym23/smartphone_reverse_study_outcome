package wsc;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ReplacementSpan;
import android.util.Size;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.larus.business.markdown.api.depend.IMarkdownLoggerKt;
import com.larus.business.markdown.fresco.DefaultImgWidget;
import java.util.Map;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class l extends ReplacementSpan implements com.larus.business.markdown.api.extplugin.image.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f561153a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f561154b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f561155c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final o f561156d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Integer f561157e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f561158f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f561159g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f561160h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Rect f561161i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final com.larus.business.markdown.api.extplugin.image.a f561162j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Map<String, Object> f561163k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public com.larus.business.markdown.api.extplugin.image.d f561164l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Rect f561165m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public TextView f561166n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Size f561167o;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.business.markdown.api.extplugin.image.c
    public final Integer e() {
        return this.f561157e;
    }

    @Override // com.larus.business.markdown.api.extplugin.image.c
    public final int f() {
        return this.f561158f;
    }

    @Override // com.larus.business.markdown.api.extplugin.image.c
    public final int getEndIndex() {
        return this.f561154b;
    }

    @Override // com.larus.business.markdown.api.extplugin.image.c
    public final int getStartIndex() {
        return this.f561153a;
    }

    @Override // com.larus.business.markdown.api.extplugin.image.c
    public final String getUrl() {
        return this.f561155c;
    }

    @Override // com.larus.business.markdown.api.extplugin.image.c
    public final com.larus.business.markdown.api.extplugin.image.d getWidget() {
        return this.f561164l;
    }

    @Override // com.larus.business.markdown.api.extplugin.image.c
    public final void a(TextView r100) {
        Intrinsics.checkNotNullParameter(r100, "textView");
        r100.getText();
    }

    @Override // com.larus.business.markdown.api.extplugin.image.c
    public final void c(TextView r100) {
        Intrinsics.checkNotNullParameter(r100, "textView");
        com.larus.business.markdown.api.extplugin.image.d r101 = this.f561164l;
        if (r101 == null) goto L12;
        DefaultImgWidget r102 = r101.asView();
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
        this.f561166n = null;
    }

    @Override // com.larus.business.markdown.api.extplugin.image.c
    public final void b(Spanned r100, com.larus.business.markdown.api.extplugin.image.c r101) {
        Intrinsics.checkNotNullParameter(r100, "text");
        Intrinsics.checkNotNullParameter(r101, "span");
        com.larus.business.markdown.api.extplugin.image.d r102 = this.f561164l;
        if (r102 == null) goto L6;
        r102.b(r100, this);
        return;
    }

    @Override // com.larus.business.markdown.api.extplugin.image.c
    public final void d(TextView r100, Spanned r101) {
        Intrinsics.checkNotNullParameter(r100, "textView");
        Intrinsics.checkNotNullParameter(r101, "text");
        int r102 = gw8.e.a(r101, this.f561153a);     // Catch: Exception -> L43
        o r103 = this.f561156d;     // Catch: Exception -> L43
        if (r103 == null) goto L17;
        o.a r104 = r103.f561173a;     // Catch: Exception -> L43
        float r105 = 0.0f;
        if (r104 == null) goto L8;
        float r106 = r104.f561175a;     // Catch: Exception -> L43
    L9:
        float r107 = 0;
        if (r106 <= r107) goto L17;
        o.a r108 = r103.f561174b;     // Catch: Exception -> L43
        if (r108 == null) goto L15;
        r105 = r108.f561175a;     // Catch: Exception -> L43
    L15:
        if (r105 <= r107) goto L17;
        int r109 = r.f561177a;     // Catch: Exception -> L43
        Rect r110 = r.a(r.b(r103, new Rect(), this.f561159g - r102), this.f561159g - r102, this.f561160h);     // Catch: Exception -> L43
    L24:
        this.f561166n = r100;     // Catch: Exception -> L43
        ViewParent r111 = r100.getParent();     // Catch: Exception -> L43
        if ((r111 instanceof FrameLayout) == false) goto L27;
        FrameLayout r112 = (FrameLayout) r111;     // Catch: Exception -> L43
    L29:
        if ((r100 instanceof ow8.a) == false) goto L40;
        if (r112 == null) goto L40;
        com.larus.business.markdown.api.extplugin.image.a r113 = this.f561162j;     // Catch: Exception -> L43
        if (r113 == null) goto L35;
        r113.c(r112, r100, r101, this);     // Catch: Exception -> L43
    L35:
        Context r114 = r112.getContext();     // Catch: Exception -> L43
        com.larus.business.markdown.api.extplugin.image.a r115 = this.f561162j;     // Catch: Exception -> L43
        if (r115 == null) goto L38;
        com.larus.business.markdown.api.extplugin.image.b r116 = r115.b();     // Catch: Exception -> L43
    L39:
        DefaultImgWidget r117 = new DefaultImgWidget(r114, null, r116);     // Catch: Exception -> L43
        Size r118 = r117.a(r100, r101, this, r110);     // Catch: Exception -> L43
        this.f561167o = r118;     // Catch: Exception -> L43
        r118.getWidth();     // Catch: Exception -> L43
        this.f561167o.getHeight();     // Catch: Exception -> L43
        r100.getText();     // Catch: Exception -> L43
        r117.setLayoutParams(new FrameLayout.LayoutParams(this.f561167o.getWidth(), this.f561167o.getHeight()));     // Catch: Exception -> L43
        r117.setVisibility(4);     // Catch: Exception -> L43
        this.f561164l = r117;     // Catch: Exception -> L43
        r112.addView(r117);     // Catch: Exception -> L43
        return;
    L38:
        r116 = null;
    L40:
        this.f561164l = null;     // Catch: Exception -> L43
        return;
    L27:
        r112 = null;
        goto L29
    L8:
        r106 = 0.0f;
    L17:
        Rect r119 = this.f561161i;     // Catch: Exception -> L43
        if (r119 != null) goto L20;
        return;
    L20:
        if (r119.width() > 0) goto L22;
        return;
    L22:
        if (this.f561161i.height() <= 0) goto L50;
        int r120 = this.f561161i.width() - r102;     // Catch: Exception -> L43
        int r121 = (int) ((this.f561161i.height() / this.f561161i.width()) * r120);     // Catch: Exception -> L43
        Rect r122 = this.f561161i;     // Catch: Exception -> L43
        Rect r123 = this.f561165m;     // Catch: Exception -> L43
        int r124 = r122.left;     // Catch: Exception -> L43
        int r125 = r122.top;     // Catch: Exception -> L43
        r123.set(r124, r125, r120 + r124, r121 + r125);     // Catch: Exception -> L43
        r110 = this.f561165m;     // Catch: Exception -> L43
        goto L24
    L50:
        return;
    L43:
        e = move-exception;
        com.larus.business.markdown.api.depend.d r126 = IMarkdownLoggerKt.a();
        if (r126 == null) goto L52;
        r126.e("CustomImgSpan", "beforeAttach error:" + e);
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
        this.f561167o.getHeight();
    L14:
        if (r104 == null) goto L16;
        int r106 = -this.f561167o.getHeight();
        r104.ascent = r106;
        r104.descent = 0;
        r104.top = r106;
        r104.bottom = 0;
    L16:
        this.f561167o.getWidth();
        return this.f561167o.getWidth();
    L10:
        TextView r107 = this.f561166n;
        if (r107 == null) goto L13;
        this.f561167o.getHeight();
        r107.getLineSpacingExtra();
        r107.getLineSpacingMultiplier();
        goto L14
    L13:
        this.f561167o.getHeight();
        goto L14
    L5:
        if (r101.length() != r103) goto L7;
        r105 = true;
        goto L8
    }

    @Override // android.text.style.ReplacementSpan
    public final void draw(Canvas r100, final CharSequence r101, final int r102, int r110, float r111, int r112, int r113, int r114, Paint r115) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        Intrinsics.checkNotNullParameter(r115, "paint");
        TextView r103 = this.f561166n;
        if (r103 != null) goto L5;
        return;
    L5:
        com.larus.business.markdown.api.extplugin.image.d r116 = this.f561164l;
        if (r116 != null) goto L8;
        return;
    L8:
        final DefaultImgWidget r117 = r116.asView();
        io.noties.markwon.core.spans.o r104 = null;
        if ((r101 instanceof SpannableString) == false) goto L11;
        SpannableString r118 = (SpannableString) r101;
    L12:
        if (r118 == null) goto L16;
        io.noties.markwon.core.spans.o[] r119 = (io.noties.markwon.core.spans.o[]) r118.getSpans(r102, r110, io.noties.markwon.core.spans.o.class);
        if (r119 == null) goto L16;
        r104 = (io.noties.markwon.core.spans.o) ArraysKt.firstOrNull(r119);
    L16:
        if (r104 == null) goto L18;
        float r120 = r104.getAlpha();
    L19:
        r117.setAlpha(r120 / 255);
        final int r105 = ((r112 + r103.getTop()) + r103.getPaddingTop()) + (((r114 - r112) - this.f561167o.getHeight()) / 2);
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
        r117.post(new k(this, r105, r101, r102, r117));
        return;
    L33:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L22:
        if (r107.leftMargin != r121) goto L28;
        if (r117.getVisibility() == 0) goto L35;
        r117.setVisibility(0);
        return;
    L35:
        return;
    L18:
        r120 = 255.0f;
        goto L19
    L11:
        r118 = null;
        goto L12
    }

    public l(int r100, int r101, String r102, msc.s r103, o r104, Integer r105, int r106, int r107, int r110, Rect r111, com.larus.business.markdown.api.extplugin.image.a r112, Map r113) {
        Intrinsics.checkNotNullParameter(r102, "url");
        Intrinsics.checkNotNullParameter(r103, "theme");
        this.f561153a = r100;
        this.f561154b = r101;
        this.f561155c = r102;
        this.f561156d = r104;
        this.f561157e = r105;
        this.f561158f = r106;
        this.f561159g = r107;
        this.f561160h = r110;
        this.f561161i = r111;
        this.f561162j = r112;
        this.f561163k = r113;
        this.f561164l = null;
        this.f561165m = new Rect();
        this.f561167o = new Size(0, 0);
    }
}
