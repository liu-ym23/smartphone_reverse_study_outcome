package com.larksuite.component.universe_design.badge;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.service.manager.alliance.IAllianceService;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import h18.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001e\b\u0017\u0018\u00002\u00020\u0001:\u0001HB\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bB+\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\rJ*\u0010#\u001a\u00020$2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0002J\b\u0010%\u001a\u00020$H\u0002J\u0018\u0010&\u001a\u00020$2\u0006\u0010'\u001a\u00020\n2\u0006\u0010(\u001a\u00020\nH\u0014J\u0010\u0010)\u001a\u00020$2\u0006\u0010*\u001a\u00020+H\u0014J\u000e\u0010,\u001a\u00020$2\u0006\u0010-\u001a\u00020\u000fJ\u000e\u0010.\u001a\u00020$2\u0006\u0010/\u001a\u00020\u0011J\u0010\u00100\u001a\u00020$2\b\b\u0001\u00101\u001a\u00020\nJ\u0010\u00102\u001a\u00020$2\b\b\u0001\u00103\u001a\u00020\nJ\u000e\u00104\u001a\u00020$2\u0006\u00105\u001a\u00020\u0011J\u0010\u00106\u001a\u00020$2\b\b\u0001\u00101\u001a\u00020\nJ\u0010\u00107\u001a\u00020$2\b\b\u0001\u00103\u001a\u00020\nJ\u000e\u00108\u001a\u00020$2\u0006\u00105\u001a\u00020\u0011J\u0010\u00109\u001a\u00020$2\b\b\u0001\u00101\u001a\u00020\nJ\u0010\u0010:\u001a\u00020$2\b\b\u0001\u00103\u001a\u00020\nJ\u0010\u0010;\u001a\u00020$2\b\b\u0001\u0010<\u001a\u00020\nJ\u000e\u0010;\u001a\u00020$2\u0006\u0010\u001d\u001a\u00020\u001eJ\u000e\u0010=\u001a\u00020$2\u0006\u0010>\u001a\u00020 J\u0010\u0010?\u001a\u00020$2\b\b\u0001\u0010@\u001a\u00020\nJ\u000e\u0010?\u001a\u00020$2\u0006\u0010\u0017\u001a\u00020\u0018J\u0010\u0010A\u001a\u00020$2\b\b\u0001\u0010\u001a\u001a\u00020\nJ\u0010\u0010B\u001a\u00020$2\b\b\u0001\u00103\u001a\u00020\nJ\u000e\u0010C\u001a\u00020$2\u0006\u0010\u0019\u001a\u00020\u0011J\u000e\u0010D\u001a\u00020$2\u0006\u0010>\u001a\u00020\u0011J\u000e\u0010E\u001a\u00020$2\u0006\u0010F\u001a\u00020\nJ\u0006\u0010G\u001a\u00020$R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006I"}, d2 = {"Lcom/larksuite/component/universe_design/badge/UDBadgeView;", "Landroid/view/View;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "badgeType", "Lcom/larksuite/component/universe_design/badge/UDBadge$BadgeType;", "badgeSize", "", "badgeColor", "outerBorderWidth", "outerBorderColor", "innerBorderWidth", "innerBorderColor", "text", "", "textSize", "textColor", "textWidthPadding", "textMaxLength", "icon", "Landroid/graphics/drawable/Drawable;", "iconPadding", "Landroid/graphics/RectF;", IAllianceService.CONTENT_TYPE_BADGE, "Lcom/larksuite/component/universe_design/badge/UDBadge;", "init", "", "updateModel", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onDraw", "canvas", "Landroid/graphics/Canvas;", "setBadgeType", "type", "setBadgeSize", "size", "setBadgeColor", "color", "setBadgeColorRes", "colorRes", "setOuterBorderWidth", "width", "setOuterBorderColor", "setOuterBorderColorRes", "setInnerBorderWidth", "setInnerBorderColor", "setInnerBorderColorRes", "setIcon", "iconResId", "setIconPadding", GXTemplateKey.FLEXBOX_PADDING, "setText", "textResId", "setTextColor", "setTextColorRes", "setTextSize", "setTextWidthPadding", "setTextMaxLength", "maxLength", "applyChanges", "Builder", "universe-ui-badge_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class UDBadgeView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public UDBadge.BadgeType f284522a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f284523b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f284524c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f284525d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f284526e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f284527f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f284528g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f284529h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f284530i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f284531j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f284532k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f284533l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Drawable f284534m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public RectF f284535n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final UDBadge f284536o;

    public final void b() {
        UDBadge r100 = this.f284536o;
        UDBadge.c r101 = new UDBadge.c();
        UDBadge.BadgeType r102 = this.f284522a;
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        r101.f284507a = r102;
        r101.f284508b = this.f284523b;
        r101.f284509c = this.f284524c;
        r101.f284510d = this.f284525d;
        r101.f284511e = this.f284526e;
        r101.f284512f = this.f284527f;
        r101.f284513g = this.f284528g;
        String r103 = this.f284529h;
        r101.f284514h = r103;
        r101.f284516j = this.f284531j;
        r101.f284515i = this.f284530i;
        r101.f284517k = this.f284532k;
        r101.f284518l = this.f284534m;
        r101.f284519m = this.f284535n;
        boolean r104 = false;
        if (this.f284522a != UDBadge.BadgeType.TEXT) goto L23;
        if (r103 == null) goto L23;
        if (r103.length() <= 0) goto L8;
        boolean r105 = true;
    L9:
        if (r105 == true) goto L11;
    L13:
        boolean r106 = false;
    L14:
        Drawable r107 = null;
        if (r106 == true) goto L18;
        r103 = null;
    L18:
        if (r103 == null) goto L23;
        Drawable r108 = getContext().getDrawable(R.drawable.ud_icon_more_outlined);
        if (r108 == null) goto L22;
        r107 = r108.mutate();
        r107.setTint(UDColorUtils.getColor(getContext(), R.color.static_white));
    L22:
        r101.f284518l = r107;
        UDBadge.BadgeType r109 = UDBadge.BadgeType.ICON;
        Intrinsics.checkNotNullParameter(r109, "<set-?>");
        r101.f284507a = r109;
        float r110 = d.a(getContext(), 4.0f);
        r101.f284519m = new RectF(r110, 0.0f, r110, 0.0f);
        goto L23
    L11:
        if (r103.length() <= this.f284533l) goto L13;
        r106 = true;
        goto L14
    L8:
        r105 = false;
    L23:
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "newModel");
        if (r101.f284507a == UDBadge.BadgeType.UNKNOWN) goto L70;
        if (r101.f284508b <= 0.0f) goto L68;
        r100.f284493b.update(r101);
        UDBadge.b r111 = r100.f284494c;
        UDBadge.c r112 = r111.f284505g.f284493b;
        float r113 = r112.f284508b;
        float r114 = 2;
        float r115 = r112.f284512f * r114;
        float r116 = r113 - r115;
        float r117 = (r112.f284510d * r114) + r115;
        int r118 = UDBadge.b.a.f284506a[r112.f284507a.ordinal()];
        if (r118 == 1) goto L57;
        if (r118 == 2) goto L31;
        RectF r119 = r111.f284502d;
        r119.left = 0.0f;
        r119.top = 0.0f;
        float r120 = r116 + r117;
        r119.right = r120;
        r119.bottom = r120;
    L65:
        r100.f284495d = r100.f284494c.f284502d.width();
        r100.f284496e = r100.f284494c.f284502d.height();
        return;
    L31:
        UDBadge.c r121 = r111.f284505g.f284493b;
        Drawable r122 = r121.f284518l;
        if (r122 == null) goto L65;
        RectF r123 = r121.f284519m;
        if (r123 == null) goto L36;
        float r124 = r123.top;
    L37:
        if (r123 == null) goto L39;
        float r125 = r123.bottom;
    L40:
        if (r123 == null) goto L42;
        float r126 = r123.left;
    L43:
        if (r123 == null) goto L45;
        float r127 = r123.right;
    L46:
        float r128 = (r116 - r124) - r125;
        float r129 = r122.getIntrinsicWidth() * 1.0f;
        float r130 = r122.getIntrinsicHeight() * 1.0f;
        if (r130 != r128) goto L49;
        r104 = true;
    L49:
        if (r104 == true) goto L51;
        float r131 = (r128 / r130) * r129;
    L52:
        float r132 = (r126 + r131) + r127;
        if (r132 > r116) goto L56;
        r132 = r116;
    L56:
        RectF r133 = r111.f284502d;
        r133.left = 0.0f;
        r133.top = 0.0f;
        r133.right = r132 + r117;
        r133.bottom = r116 + r117;
        RectF r134 = r111.f284504f;
        float r135 = r131 / r114;
        r134.left = r133.centerX() - r135;
        float r136 = r128 / r114;
        r134.top = r111.f284502d.centerY() - r136;
        r134.right = r111.f284502d.centerX() + r135;
        r134.bottom = r111.f284502d.centerY() + r136;
        goto L65
    L51:
        r128 = r130 * 1.0f;
        r131 = r129 * 1.0f;
        goto L52
    L45:
        r127 = 0.0f;
        goto L46
    L42:
        r126 = 0.0f;
        goto L43
    L39:
        r125 = 0.0f;
        goto L40
    L36:
        r124 = 0.0f;
        goto L37
    L57:
        String r137 = r111.f284505g.f284493b.f284514h;
        if (TextUtils.isEmpty(r137) == true) goto L63;
        r111.f284501c.setColor(r111.f284505g.f284493b.f284516j);
        r111.f284501c.setTextSize(r111.f284505g.f284493b.f284515i);
        r111.f284501c.setLetterSpacing(0.02f);
        float r138 = r111.f284501c.measureText(r137);
        float r139 = (r111.f284505g.f284493b.f284517k * r114) + r138;
        if (r139 > r116) goto L64;
        r139 = r116;
    L64:
        RectF r140 = r111.f284502d;
        r140.left = 0.0f;
        r140.top = 0.0f;
        r140.right = r139 + r117;
        r140.bottom = r116 + r117;
        Paint.FontMetricsInt r141 = r111.f284501c.getFontMetricsInt();
        float r142 = r111.f284502d.centerY();
        int r143 = r141.descent;
        float r144 = ((r142 - r143) + ((r143 - r141.ascent) / 2)) - 0.5f;
        float r145 = (r111.f284502d.centerX() - (r138 / r114)) - 0.5f;
        PointF r146 = r111.f284503e;
        r146.x = r145;
        r146.y = r144;
        goto L65
    L63:
        r139 = r116;
        r138 = 0.0f;
        goto L64
    L68:
        throw new IllegalArgumentException("BadgeSize is 0, please set first.");
    L70:
        throw new IllegalArgumentException("BadgeType is unknown, please set first.");
    }

    public final void a() {
        b();
        if (isAttachedToWindow() == false) goto L6;
        requestLayout();
        invalidate();
        return;
    }

    public UDBadgeView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
        UDBadge r101 = this.f284536o;
        if (r100 != null) goto L5;
        r101.getClass();
        return;
    L5:
        UDBadge.b r102 = r101.f284494c;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, "canvas");
        r102.f284499a.setStyle(Paint.Style.STROKE);
        r102.f284499a.setColor(r102.f284505g.f284493b.f284511e);
        r102.f284499a.setStrokeWidth(r102.f284505g.f284493b.f284510d);
        UDBadge r103 = r102.f284505g;
        float r104 = 2;
        float r105 = r103.f284493b.f284510d / r104;
        float r106 = UDBadge.a(r103);
        float r107 = UDBadge.b(r102.f284505g);
        RectF r108 = new RectF();
        RectF r109 = r102.f284502d;
        r108.left = (r109.left + r105) + r106;
        r108.top = (r109.top + r105) + r107;
        r108.right = (r109.right - r105) + r106;
        r108.bottom = (r109.bottom - r105) + r107;
        float r110 = Math.min(r108.height() / r104, r108.height() / r104);
        r100.drawRoundRect(r108, r110, r110, r102.f284499a);
        r102.f284499a.setStyle(Paint.Style.STROKE);
        r102.f284499a.setColor(r102.f284505g.f284493b.f284513g);
        r102.f284499a.setStrokeWidth(r102.f284505g.f284493b.f284512f);
        UDBadge r111 = r102.f284505g;
        float r112 = r111.f284493b.f284512f / r104;
        float r113 = UDBadge.a(r111);
        float r114 = UDBadge.b(r102.f284505g);
        RectF r115 = new RectF();
        RectF r116 = r102.f284502d;
        r115.left = (r116.left + r112) + r113;
        r115.top = (r116.top + r112) + r114;
        r115.right = (r116.right - r112) + r113;
        r115.bottom = (r116.bottom - r112) + r114;
        float r117 = Math.min(r115.height() / r104, r115.height() / r104);
        r100.drawRoundRect(r115, r117, r117, r102.f284499a);
        r102.f284500b.setStyle(Paint.Style.FILL);
        r102.f284500b.setColor(r102.f284505g.f284493b.f284509c);
        UDBadge r118 = r102.f284505g;
        UDBadge.c r119 = r118.f284493b;
        float r120 = r119.f284510d + r119.f284512f;
        float r121 = UDBadge.a(r118);
        float r122 = UDBadge.b(r102.f284505g);
        RectF r123 = new RectF();
        RectF r124 = r102.f284502d;
        r123.left = (r124.left + r120) + r121;
        r123.top = (r124.top + r120) + r122;
        r123.right = (r124.right - r120) + r121;
        r123.bottom = (r124.bottom - r120) + r122;
        float r125 = Math.min(r123.height() / r104, r123.height() / r104);
        r100.drawRoundRect(r123, r125, r125, r102.f284500b);
        UDBadge r126 = r102.f284505g;
        UDBadge.c r127 = r126.f284493b;
        UDBadge.BadgeType r128 = r127.f284507a;
        if (r128 != UDBadge.BadgeType.TEXT) goto L12;
        String r129 = r127.f284514h;
        if (r129 == null) goto L21;
        float r130 = UDBadge.a(r126);
        float r131 = UDBadge.b(r102.f284505g);
        PointF r132 = r102.f284503e;
        r100.drawText(r129, r132.x + r130, r132.y + r131, r102.f284501c);
        return;
    L21:
        return;
    L12:
        if (r128 != UDBadge.BadgeType.ICON) goto L20;
        Drawable r133 = r127.f284518l;
        if (r133 == null) goto L22;
        float r134 = UDBadge.a(r126);
        float r135 = UDBadge.b(r102.f284505g);
        Rect r136 = new Rect();
        RectF r137 = r102.f284504f;
        r136.left = (int) (r137.left + r134);
        r136.top = (int) (r137.top + r135);
        r136.right = (int) (r137.right + r134);
        r136.bottom = (int) (r137.bottom + r135);
        r133.setBounds(r136);
        r133.draw(r100);
        return;
    L22:
        return;
    }

    public final void setBadgeColor(int r100) {
        this.f284524c = r100;
    }

    public final void setBadgeColorRes(int r100) {
        this.f284524c = ContextCompat.getColor(getContext(), r100);
    }

    public final void setBadgeSize(float r100) {
        this.f284523b = r100;
    }

    public final void setBadgeType(UDBadge.BadgeType r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        this.f284522a = r100;
    }

    public final void setIcon(int r100) {
        this.f284534m = ContextCompat.getDrawable(getContext(), r100);
    }

    public final void setIconPadding(RectF r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.FLEXBOX_PADDING);
        this.f284535n = r100;
    }

    public final void setInnerBorderColor(int r100) {
        this.f284528g = r100;
    }

    public final void setInnerBorderColorRes(int r100) {
        this.f284528g = ContextCompat.getColor(getContext(), r100);
    }

    public final void setInnerBorderWidth(float r100) {
        this.f284527f = r100;
    }

    public final void setOuterBorderColor(int r100) {
        this.f284526e = r100;
    }

    public final void setOuterBorderColorRes(int r100) {
        this.f284526e = ContextCompat.getColor(getContext(), r100);
    }

    public final void setOuterBorderWidth(float r100) {
        this.f284525d = r100;
    }

    public final void setText(int r100) {
        this.f284529h = getContext().getResources().getString(r100);
    }

    public final void setTextColor(int r100) {
        this.f284531j = r100;
    }

    public final void setTextColorRes(int r100) {
        this.f284531j = ContextCompat.getColor(getContext(), r100);
    }

    public final void setTextMaxLength(int r100) {
        this.f284533l = r100;
    }

    public final void setTextSize(float r100) {
        this.f284530i = r100;
    }

    public final void setTextWidthPadding(float r100) {
        this.f284532k = r100;
    }

    public final void setIcon(Drawable r100) {
        Intrinsics.checkNotNullParameter(r100, "icon");
        this.f284534m = r100;
    }

    public final void setText(String r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        this.f284529h = r100;
    }

    public UDBadgeView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        UDBadge r102 = this.f284536o;
        float r103 = r102.f284495d;
        setMeasuredDimension((int) r103, (int) r102.f284496e);
    }

    public UDBadgeView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, r102, 0);
    }

    public UDBadgeView(Context r100, AttributeSet r101, int r110, int r111) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r110, r111);
        UDBadge.BadgeType r102 = UDBadge.BadgeType.UNKNOWN;
        this.f284522a = r102;
        this.f284533l = 3;
        this.f284536o = new UDBadge(getContext());
        TypedArray r103 = r100.obtainStyledAttributes(r101, new int[]{R.attr.ud_badge_color, R.attr.ud_badge_icon, R.attr.ud_badge_iconPadding, R.attr.ud_badge_innerBorderColor, R.attr.ud_badge_innerBorderWidth, R.attr.ud_badge_outerBorderColor, R.attr.ud_badge_outerBorderWidth, R.attr.ud_badge_size, R.attr.ud_badge_text, R.attr.ud_badge_textColor, R.attr.ud_badge_textMaxLength, R.attr.ud_badge_textSize, R.attr.ud_badge_textWidthPadding, R.attr.ud_badge_type}, r110, r111);
        int r104 = r103.getInt(13, -1);
        if (r104 == 0) goto L9;
        if (r104 == 1) goto L8;
        if (r104 != 2) goto L10;
        r102 = UDBadge.BadgeType.ICON;
    L10:
        this.f284522a = r102;
        this.f284523b = r103.getDimension(7, d.a(r100, 16.0f));
        this.f284524c = r103.getColor(0, 0);
        this.f284525d = r103.getDimension(6, 0.0f);
        this.f284526e = r103.getColor(5, 0);
        this.f284527f = r103.getDimension(4, 0.0f);
        this.f284528g = r103.getColor(3, 0);
        this.f284529h = r103.getString(8);
        this.f284531j = r103.getColor(9, 0);
        this.f284530i = r103.getDimension(11, d.f(r100, 12.0f));
        this.f284532k = r103.getDimension(12, 0.0f);
        this.f284533l = r103.getInt(10, this.f284533l);
        this.f284534m = r103.getDrawable(1);
        float r105 = r103.getDimension(2, d.a(r100, 4.0f));
        this.f284535n = new RectF(r105, r105, r105, r105);
        r103.recycle();
        if (r101 != null) goto L14;
        if (r110 != 0) goto L14;
        if (r111 != 0) goto L14;
        return;
    L14:
        b();
        return;
    L8:
        r102 = UDBadge.BadgeType.TEXT;
        goto L10
    L9:
        r102 = UDBadge.BadgeType.DOT;
        goto L10
    }
}
