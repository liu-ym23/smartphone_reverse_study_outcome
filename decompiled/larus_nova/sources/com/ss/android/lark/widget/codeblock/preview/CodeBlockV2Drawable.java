package com.ss.android.lark.widget.codeblock.preview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import com.larksuite.component.universe_design.dimension.UDDimension;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.codeblock.entity.LineContent;
import com.ss.android.lark.widget.codeblock.process.CodeBlockV2ProcessParams;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class CodeBlockV2Drawable extends Drawable {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final /* synthetic */ int f445663w = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f445664a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<LineContent> f445665b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CodeBlockV2ProcessParams f445666c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CodeBlockV2ProcessParams.CodeZoneParams f445667d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CodeBlockV2ProcessParams.LineCountParams f445668e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final CodeBlockV2ProcessParams.BorderParams f445669f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f445670g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float f445671h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f445672i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f445673j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f445674k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f445675l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f445676m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f445677n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f445678o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final RectF f445679p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final RectF f445680q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final RectF f445681r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Lazy f445682s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Lazy f445683t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Lazy f445684u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Drawable f445685v;

    public static final class a {
    }

    static {
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r100) {
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r100) {
    }

    public final bcc.a a() {
        return (bcc.a) this.f445672i.getValue();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return ((Number) this.f445678o.getValue()).intValue();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return this.f445666c.getWholeWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        if (((Boolean) this.f445673j.getValue()).booleanValue() == true) goto L5;
        return;
    L5:
        this.f445679p.set(0.0f, 0.0f, this.f445666c.getWholeWidth(), ((Number) this.f445678o.getValue()).intValue());
        if (this.f445669f.getShowBorder() == false) goto L9;
        this.f445680q.set(this.f445679p);
        RectF r100 = this.f445680q;
        float r101 = this.f445670g / 2;
        r100.inset(r101, r101);
        RectF r102 = this.f445680q;
        float r103 = this.f445671h;
        r110.drawRoundRect(r102, r103, r103, (Paint) this.f445682s.getValue());
    L9:
        this.f445681r.set(this.f445679p);
        RectF r104 = this.f445681r;
        float r105 = this.f445670g;
        r104.inset(r105, r105);
        RectF r106 = this.f445681r;
        float r107 = this.f445671h;
        r110.drawRoundRect(r106, r107, r107, (Paint) this.f445683t.getValue());
        r110.save();
        r110.translate(this.f445666c.getHorizontalPadding() + this.f445670g, this.f445666c.getTopPadding() + this.f445670g);
        if (((Boolean) this.f445674k.getValue()).booleanValue() == false) goto L15;
        Layout r108 = a().f18605b;
        if (r108 == null) goto L14;
        r108.draw(r110, null, null, 0);
    L14:
        float r109 = a().f18606c + this.f445667d.getLineNumEndMargin();
        r110.translate(r109, 0.0f);
    L16:
        Layout r111 = a().f18604a;
        if (r111 == null) goto L20;
        r111.draw(r110, null, null, 0);
    L20:
        if (((Boolean) this.f445675l.getValue()).booleanValue() == false) goto L26;
        r110.translate(-r109, ((Number) this.f445676m.getValue()).intValue() + this.f445668e.getDividerVerticalMargin());
        float r112 = 2;
        r110.drawRoundRect(0.0f, 0.0f, (this.f445666c.getWholeWidth() - (this.f445666c.getHorizontalPadding() * 2)) - (this.f445670g * r112), this.f445668e.getDividerWidth(), 0.0f, 0.0f, (Paint) this.f445684u.getValue());
        r110.translate(0.0f, this.f445668e.getDividerWidth() + this.f445668e.getDividerVerticalMargin());
        Layout r113 = a().f18608e;
        if (r113 == null) goto L25;
        r113.draw(r110, null, null, 0);
    L25:
        r110.translate(a().f18609f + this.f445668e.getArrowStartMargin(), ((((Number) this.f445677n.getValue()).intValue() - this.f445668e.getArrowSize()) * 1.0f) / r112);
        this.f445685v.draw(r110);
    L26:
        r110.restore();
        return;
    L15:
        r109 = 0.0f;
        goto L16
    }

    public CodeBlockV2Drawable(Context r100, List<LineContent> r101, CodeBlockV2ProcessParams r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "lineContents");
        Intrinsics.checkNotNullParameter(r102, "params");
        this.f445664a = r100;
        this.f445665b = r101;
        this.f445666c = r102;
        this.f445667d = r102.getCodeZoneParams();
        CodeBlockV2ProcessParams.LineCountParams r103 = r102.getLineCountParams();
        this.f445668e = r103;
        CodeBlockV2ProcessParams.BorderParams r104 = r102.getBorderParams();
        this.f445669f = r104;
        float r105 = 0.0f;
        if (r104.getShowBorder() == false) goto L5;
        float r106 = r104.getBorderWidth();
    L6:
        this.f445670g = r106;
        if (r104.getShowBorder() == false) goto L9;
        r105 = r104.getRadius();
    L9:
        this.f445671h = r105;
        this.f445672i = LazyKt.lazy(new CodeBlockV2Drawable$processResult$2(this));
        this.f445673j = LazyKt.lazy(new CodeBlockV2Drawable$showCodeLayout$2(this));
        this.f445674k = LazyKt.lazy(new CodeBlockV2Drawable$showLineNumLayout$2(this));
        this.f445675l = LazyKt.lazy(new CodeBlockV2Drawable$showLineCountLayout$2(this));
        this.f445676m = LazyKt.lazy(new CodeBlockV2Drawable$codeZoneHeight$2(this));
        this.f445677n = LazyKt.lazy(new CodeBlockV2Drawable$lineCountHeight$2(this));
        Lazy r107 = LazyKt.lazy(new CodeBlockV2Drawable$wholeHeight$2(this));
        this.f445678o = r107;
        this.f445679p = new RectF();
        this.f445680q = new RectF();
        this.f445681r = new RectF();
        this.f445682s = LazyKt.lazy(new CodeBlockV2Drawable$borderPaint$2(this));
        this.f445683t = LazyKt.lazy(new CodeBlockV2Drawable$bgPaint$2(this));
        this.f445684u = LazyKt.lazy(new CodeBlockV2Drawable$dividerPaint$2(this));
        this.f445685v = UDIconUtils.getIconDrawable(r100, R.drawable.ud_icon_right_small_ccm_outlined, UIUtils.getColor(r100, R.color.icon_n3), new UDDimension.a(r103.getArrowSize()));
        setBounds(0, 0, getIntrinsicWidth(), ((Number) r107.getValue()).intValue());
        return;
    L5:
        r106 = 0.0f;
        goto L6
    }
}
