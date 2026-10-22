package com.obric.oui.lisitem;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.view.GravityCompat;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.larus.nova.R;
import com.obric.oui.checkbox.OCheckBoxLayout;
import com.obric.oui.checkbox.OCheckMark;
import com.obric.oui.common.style.OStateGradientDrawable;
import com.obric.oui.constraintlayout.widget.ConstraintLayout;
import com.obric.oui.image.OImageAppIcon;
import com.obric.oui.layout.OUIFrameLayout;
import com.obric.oui.oswitch.OSwitch;
import com.obric.oui.swipeaction.OSwipeLayout;
import com.obric.oui.text.OTextView;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001:\u0001cB'\b\u0007\u0012\u0006\u0010]\u001a\u00020\\\u0012\n\b\u0002\u0010_\u001a\u0004\u0018\u00010^\u0012\b\b\u0002\u0010`\u001a\u00020\u0002¢\u0006\u0004\ba\u0010bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007J\u0006\u0010\b\u001a\u00020\u0007J\u0010\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0007J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\nJ\u0006\u0010\u000f\u001a\u00020\nJ\u000e\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0002J\u0006\u0010\u0012\u001a\u00020\u0002J\u0006\u0010\u0013\u001a\u00020\u0002J\u0006\u0010\u0014\u001a\u00020\u0001J\u0006\u0010\u0015\u001a\u00020\u0001J\u0006\u0010\u0017\u001a\u00020\u0016J\u0010\u0010\u001a\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018J\u000e\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u0002J\u000e\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0002J\b\u0010\u001e\u001a\u0004\u0018\u00010\u0018J\b\u0010 \u001a\u0004\u0018\u00010\u001fJ\u0010\u0010#\u001a\u00020\u00042\b\u0010\"\u001a\u0004\u0018\u00010!J\u000e\u0010#\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u0002J\u0010\u0010$\u001a\u00020\u00042\b\u0010\"\u001a\u0004\u0018\u00010!J\u000e\u0010$\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u0002J\u0006\u0010&\u001a\u00020%J\u0010\u0010)\u001a\u00020\u00042\b\u0010(\u001a\u0004\u0018\u00010'J\b\u0010*\u001a\u0004\u0018\u00010'J\u0006\u0010,\u001a\u00020+J\u0010\u0010-\u001a\u00020\u00042\b\u0010(\u001a\u0004\u0018\u00010'J\b\u0010.\u001a\u0004\u0018\u00010'J\u0006\u0010/\u001a\u00020+J\u0006\u00101\u001a\u000200J\u0010\u00102\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018J\u000e\u00102\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u0002J\u000e\u00104\u001a\u00020\u00042\u0006\u00103\u001a\u00020\u0002J\b\u00105\u001a\u0004\u0018\u00010\u0018J\b\u00106\u001a\u0004\u0018\u00010\u001fJ\b\u00108\u001a\u0004\u0018\u000107J\b\u0010:\u001a\u0004\u0018\u000109J\b\u0010;\u001a\u0004\u0018\u00010+J\u0010\u0010<\u001a\u00020\u00042\b\u0010\"\u001a\u0004\u0018\u00010!J\u000e\u0010<\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u0002J\u000e\u0010>\u001a\u00020\u00042\u0006\u0010=\u001a\u00020\u0002J\u0006\u0010?\u001a\u00020%J\u000e\u0010A\u001a\u00020\u00042\u0006\u0010@\u001a\u00020\nJ\u000e\u0010B\u001a\u00020\u00042\u0006\u0010@\u001a\u00020\nJ\u0010\u0010C\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018J\u000e\u0010C\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u0002J\u0006\u0010E\u001a\u00020DJ\b\u0010F\u001a\u0004\u0018\u00010\u0018J\u0010\u0010I\u001a\u00020\u00042\b\u0010H\u001a\u0004\u0018\u00010GJ\u0010\u0010K\u001a\u00020\u00042\b\u0010H\u001a\u0004\u0018\u00010JJ\u0010\u0010M\u001a\u00020\u00042\u0006\u0010L\u001a\u00020\nH\u0016R*\u0010U\u001a\u00020\u00072\u0006\u0010N\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\u0012\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR*\u0010X\u001a\u00020\n2\u0006\u0010N\u001a\u00020\n8F@FX\u0086\u000e¢\u0006\u0012\n\u0004\bV\u0010W\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[¨\u0006d"}, d2 = {"Lcom/obric/oui/lisitem/OCardListItem;", "Landroid/widget/FrameLayout;", "", "color", "", "setBgColor", "setContentColor", "Landroid/content/res/ColorStateList;", "getContentColor", "setContentMarkColor", "", "checked", "setContentChecked", "show", "setShowCardBg", "getShowCardBg", "type", "setCardType", "getCardType", "getCardPosition", "getCardRoot", "getCardContainer", "Lcom/obric/oui/lisitem/OUICardConstraintLayout;", "getContentContainer", "Landroid/view/View;", "view", "setCustomStartView", "resId", "defaultCustomStart", "setDefaultCustomStartView", "getCustomStartView", "Lcom/obric/oui/checkbox/OCheckBoxLayout;", "getStartCheckBox", "Landroid/graphics/drawable/Drawable;", "drawable", "setIcon", "setAppIcon", "Landroid/widget/ImageView;", "getIconView", "", "text", com.alipay.sdk.m.x.d.f25925o, "getTitle", "Lcom/obric/oui/text/OTextView;", "getTitleView", "setSubTitle", "getSubTitle", "getSubTitleView", "Landroid/widget/LinearLayout;", "getTitleContainer", "setCustomEndView", "defaultCustomEnd", "setDefaultCustomEndView", "getCustomEndView", "getEndCheckBox", "Lcom/obric/oui/oswitch/OSwitch;", "getEndSwitch", "Lcom/obric/oui/checkbox/OCheckMark;", "getEndMark", "getEndDetail", "setTailIcon", "defaultTailIcon", "setDefaultTailIcon", "getTailIconView", "enable", "setEnableSwipeDivider", "setEnableSwipe", "setSwipeView", "Lcom/obric/oui/swipeaction/OSwipeLayout;", "getSwipeLayout", "getSwipeView", "Landroid/view/View$OnClickListener;", "listener", "setOnContentClickListener", "Landroid/view/View$OnLongClickListener;", "setOnContentLongClickListener", "enabled", "setEnabled", "value", "G", "Landroid/content/res/ColorStateList;", "getContentContainerBgColor", "()Landroid/content/res/ColorStateList;", "setContentContainerBgColor", "(Landroid/content/res/ColorStateList;)V", "contentContainerBgColor", FaceService.neutralLabel, "Z", "isMark", "()Z", "setMark", "(Z)V", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "b", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public class OCardListItem extends FrameLayout {
    public static final /* synthetic */ int I = 0;
    public int A;
    public boolean B;
    public int C;
    public int D;
    public int E;
    public int F;
    public ColorStateList G;
    public boolean H;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f401318a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f401319b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f401320c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final FrameLayout f401321d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final OUIFrameLayout f401322e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final OUICardConstraintLayout f401323f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final OStateGradientDrawable f401324g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ColorStateList f401325h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ColorStateList f401326i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final FrameLayout f401327j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final FrameLayout f401328k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ImageView f401329l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public OImageAppIcon f401330m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final LinearLayout f401331n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final OTextView f401332o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f401333p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final OTextView f401334q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f401335r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final FrameLayout f401336s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final ImageView f401337t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final View f401338u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final com.obric.oui.lisitem.a f401339v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final int f401340w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final int f401341x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final OSwipeLayout f401342y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final FrameLayout f401343z;

    public static final class a implements OSwipeLayout.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OCardListItem f401344a;

        @Override // com.obric.oui.swipeaction.OSwipeLayout.j
        public final void a() {
        }

        @Override // com.obric.oui.swipeaction.OSwipeLayout.j
        public final void b() {
        }

        @Override // com.obric.oui.swipeaction.OSwipeLayout.j
        public final void onOpen() {
        }

        @Override // com.obric.oui.swipeaction.OSwipeLayout.j
        public final void onClose() {
            this.f401344a.setContentChecked(false);
        }

        public a(OCardListItem r100) {
            this.f401344a = r100;
        }

        @Override // com.obric.oui.swipeaction.OSwipeLayout.j
        public final void c(OSwipeLayout r100) {
            this.f401344a.setContentChecked(true);
        }

        @Override // com.obric.oui.swipeaction.OSwipeLayout.j
        public final void onUpdate(int r100) {
            OCardListItem r101 = this.f401344a;
            r101.A = r100;
            if (r101.f401338u.getVisibility() != 0) goto L5;
            boolean r102 = true;
        L6:
            if (r102 == false) goto L13;
            OCardListItem r103 = this.f401344a;
            View r104 = r103.f401338u;
            if (r103.B == false) goto L10;
            float r105 = r100;
        L11:
            r104.setTranslationX(r105);
            return;
        L10:
            r105 = 0.0f;
            goto L11
        L13:
            return;
        L5:
            r102 = false;
            goto L6
        }
    }

    public static final class b {
    }

    static {
    }

    public OCardListItem(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public OCardListItem(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void setCardPosition(int r100) {
        h(this, r100);
    }

    public final void a() {
        OImageAppIcon r100 = (OImageAppIcon) this.f401328k.findViewById(R.id.o_list_item_app_icon);
        this.f401330m = r100;
        int r101 = 0;
        if (r100 != null) goto L5;
        OImageAppIcon r102 = new OImageAppIcon(getContext(), null, 6, r101);
        r102.setId(R.id.o_list_item_app_icon);
        r102.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.f401330m = r102;
        this.f401328k.addView(r102);
        return;
    L5:
        r100.setVisibility(0);
    }

    public final void b() {
        if (this.f401323f.hasOnClickListeners() == false) goto L5;
    L8:
        this.f401323f.setBackground(this.f401324g);
        return;
    L5:
        if (this.f401323f.hasOnLongClickListeners() == true) goto L8;
        this.f401323f.setBackground(null);
    }

    public final View c() {
        if (this.f401331n.getChildCount() == 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == true) goto L8;
        return null;
    L8:
        return this.f401331n.getChildAt(0);
    L5:
        r100 = false;
        goto L6
    }

    public final void e() {
        if (this.f401319b == false) goto L5;
        int r100 = 12;
    L6:
        int r101 = pla.d.n(this, r100);
        OStateGradientDrawable r102 = this.f401324g;
        if (r102 == null) goto L10;
        r102.setSolidColors(getContentContainerBgColor());
    L10:
        OStateGradientDrawable r103 = this.f401324g;
        if (r103 == null) goto L14;
        r103.setCornerRadius(r101);
    L14:
        b();
        if (this.f401319b == false) goto L17;
        int r104 = pla.d.n(this, 12);
    L18:
        OSwipeLayout r105 = this.f401342y;
        boolean r106 = this.f401319b;
        boolean r107 = false;
        if (r106 == false) goto L21;
        int r108 = r104;
    L22:
        if (r106 == true) goto L25;
        r104 = 0;
    L25:
        r105.f401297b.x(r108, 0, r104, 0);
        if (this.f401338u.getVisibility() != 0) goto L28;
        r107 = true;
    L28:
        if (r107 == false) goto L31;
        u();
        return;
    L31:
        return;
    L21:
        r108 = 0;
        goto L22
    L17:
        r104 = pla.d.n(this, 20);
        goto L18
    L5:
        r100 = 20;
        goto L6
    }

    public final void f() {
        boolean r100 = true;
        if (this.f401336s.getVisibility() != 0) goto L5;
        boolean r101 = true;
    L7:
        if (r101 == false) goto L45;
        View r102 = getCustomEndView();
        ViewGroup.LayoutParams r103 = this.f401336s.getLayoutParams();
        ViewGroup.MarginLayoutParams r104 = null;
        if ((r103 instanceof ConstraintLayout.LayoutParams) == false) goto L11;
        ConstraintLayout.LayoutParams r105 = (ConstraintLayout.LayoutParams) r103;
    L12:
        if (r102 == null) goto L22;
        if ((r102.getLayoutParams() instanceof FrameLayout.LayoutParams) == false) goto L22;
        ViewGroup.LayoutParams r106 = r102.getLayoutParams();
        if (r106 == null) goto L20;
        ((FrameLayout.LayoutParams) r106).gravity = GravityCompat.END;
        goto L22
    L20:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    L22:
        if ((r102 instanceof OTextView) == false) goto L42;
        OTextView r107 = (OTextView) r102;
        if (TextUtils.isEmpty(r107.getText()) == true) goto L42;
        if (r105 == null) goto L28;
        r105.P = this.E;
    L28:
        ViewGroup.LayoutParams r108 = r107.getLayoutParams();
        if ((r108 instanceof ViewGroup.MarginLayoutParams) == false) goto L31;
        r104 = (ViewGroup.MarginLayoutParams) r108;
    L31:
        if (r104 == null) goto L41;
        int r109 = r104.leftMargin;
        int r110 = r104.topMargin;
        if (this.f401337t.getVisibility() == 0) goto L37;
        r100 = false;
    L37:
        if (r100 == false) goto L39;
        int r111 = pla.d.n(this, 0);
    L40:
        r104.setMargins(r109, r110, r111, r104.bottomMargin);
        goto L41
    L39:
        r111 = pla.d.n(this, 6);
    L41:
        r107.setLayoutParams(r104);
        return;
    L42:
        if (r105 == null) goto L53;
        r105.P = -2;
        return;
    L53:
        return;
    L11:
        r105 = null;
        goto L12
    L45:
        FrameLayout r112 = this.f401336s;
        ViewGroup.LayoutParams r113 = r112.getLayoutParams();
        if (r113 == null) goto L50;
        ConstraintLayout.LayoutParams r114 = (ConstraintLayout.LayoutParams) r113;
        r114.P = -2;
        r112.setLayoutParams(r114);
        return;
    L50:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L5:
        r101 = false;
        goto L7
    }

    public final void g() {
        boolean r100 = true;
        if (this.f401327j.getVisibility() != 8) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L10;
        if ((getCustomStartView() instanceof OCheckBoxLayout) == true) goto L10;
    L15:
        LinearLayout r102 = this.f401331n;
        r102.setPadding(0, r102.getPaddingTop(), this.f401331n.getPaddingRight(), this.f401331n.getPaddingBottom());
    L17:
        if (this.f401338u.getVisibility() == 0) goto L20;
        r100 = false;
    L20:
        if (r100 == false) goto L22;
        u();
    L22:
        requestLayout();
        return;
    L10:
        if (this.f401328k.getVisibility() != 8) goto L12;
        boolean r103 = true;
    L13:
        if (r103 == false) goto L15;
        this.f401331n.setPadding(pla.d.n(this, 12), this.f401331n.getPaddingTop(), this.f401331n.getPaddingRight(), this.f401331n.getPaddingBottom());
        goto L17
    L12:
        r103 = false;
        goto L13
    L5:
        r101 = false;
        goto L6
    }

    public final View getCustomEndView() {
        if (this.f401336s.getChildCount() == 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == true) goto L8;
        return null;
    L8:
        return this.f401336s.getChildAt(0);
    L5:
        r100 = false;
        goto L6
    }

    public final View getCustomStartView() {
        if (this.f401327j.getChildCount() == 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == true) goto L8;
        return null;
    L8:
        return this.f401327j.getChildAt(0);
    L5:
        r100 = false;
        goto L6
    }

    public final CharSequence getSubTitle() {
        return this.f401334q.getText();
    }

    public final View getSwipeView() {
        if (this.f401343z.getChildCount() != 0) goto L5;
        return null;
    L5:
        return this.f401343z.getChildAt(0);
    }

    public final CharSequence getTitle() {
        return this.f401332o.getText();
    }

    public final void t() {
        OSwipeLayout r100 = this.f401342y;
        if (r100.f403103u == false) goto L6;
        r100.g(true);
        return;
    }

    public final void u() {
        this.f401338u.post(new com.obric.oui.lisitem.b(this));
        requestLayout();
    }

    public final ColorStateList getContentColor() {
        return getContentContainerBgColor();
    }

    public final OCheckBoxLayout getEndCheckBox() {
        if ((getCustomEndView() instanceof OCheckBoxLayout) == false) goto L10;
        View r100 = getCustomEndView();
        if (r100 == null) goto L9;
        return (OCheckBoxLayout) r100;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.checkbox.OCheckBoxLayout");
    L10:
        return null;
    }

    public final OTextView getEndDetail() {
        if ((getCustomEndView() instanceof OTextView) == false) goto L10;
        View r100 = getCustomEndView();
        if (r100 == null) goto L9;
        return (OTextView) r100;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.text.OTextView");
    L10:
        return null;
    }

    public final OCheckMark getEndMark() {
        if ((getCustomEndView() instanceof OCheckMark) == false) goto L10;
        View r100 = getCustomEndView();
        if (r100 == null) goto L9;
        return (OCheckMark) r100;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.checkbox.OCheckMark");
    L10:
        return null;
    }

    public final OSwitch getEndSwitch() {
        if ((getCustomEndView() instanceof OSwitch) == false) goto L10;
        View r100 = getCustomEndView();
        if (r100 == null) goto L9;
        return (OSwitch) r100;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.oswitch.OSwitch");
    L10:
        return null;
    }

    public final OCheckBoxLayout getStartCheckBox() {
        if ((getCustomStartView() instanceof OCheckBoxLayout) == false) goto L10;
        View r100 = getCustomStartView();
        if (r100 == null) goto L9;
        return (OCheckBoxLayout) r100;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.checkbox.OCheckBoxLayout");
    L10:
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        OStateGradientDrawable r100 = this.f401324g;
        if (r100 == null) goto L6;
        r100.endAnimation();
    L6:
        this.f401327j.addOnLayoutChangeListener(this.f401339v);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f401327j.removeOnLayoutChangeListener(this.f401339v);
    }

    public final FrameLayout getCardContainer() {
        return this.f401322e;
    }

    public final int getCardPosition() {
        return this.C;
    }

    public final FrameLayout getCardRoot() {
        return this.f401321d;
    }

    public final int getCardType() {
        return this.D;
    }

    public final OUICardConstraintLayout getContentContainer() {
        return this.f401323f;
    }

    public final ColorStateList getContentContainerBgColor() {
        return this.G;
    }

    public final ImageView getIconView() {
        return this.f401329l;
    }

    public final boolean getShowCardBg() {
        return this.f401319b;
    }

    public final OTextView getSubTitleView() {
        return this.f401334q;
    }

    public final OSwipeLayout getSwipeLayout() {
        return this.f401342y;
    }

    public final ImageView getTailIconView() {
        return this.f401337t;
    }

    public final LinearLayout getTitleContainer() {
        return this.f401331n;
    }

    public final OTextView getTitleView() {
        return this.f401332o;
    }

    public final void m(boolean r100) {
        FrameLayout r101 = this.f401336s;
        if (r100 == false) goto L5;
        int r102 = 0;
    L6:
        r101.setVisibility(r102);
        f();
        return;
    L5:
        r102 = 8;
        goto L6
    }

    public final void n(boolean r100) {
        FrameLayout r101 = this.f401327j;
        if (r100 == false) goto L5;
        int r102 = 0;
    L6:
        r101.setVisibility(r102);
        g();
        return;
    L5:
        r102 = 8;
        goto L6
    }

    public final void o(boolean r100) {
        View r101 = this.f401338u;
        if (r100 == false) goto L5;
        int r102 = 0;
    L6:
        r101.setVisibility(r102);
        if (r100 == false) goto L14;
        View r103 = this.f401338u;
        if (this.B == false) goto L11;
        float r104 = this.A;
    L12:
        r103.setTranslationX(r104);
        u();
        return;
    L11:
        r104 = 0.0f;
        goto L12
    L14:
        return;
    L5:
        r102 = 8;
        goto L6
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration r100) {
        super.onConfigurationChanged(r100);
        this.E = pla.d.n(this, 168);
    }

    public final void p(boolean r100) {
        FrameLayout r101 = this.f401328k;
        if (r100 == false) goto L5;
        int r102 = 0;
    L6:
        r101.setVisibility(r102);
        g();
        return;
    L5:
        r102 = 8;
        goto L6
    }

    public final void q(boolean r100) {
        CharSequence r101 = getSubTitle();
        int r102 = 0;
        if (r101 != null) goto L5;
    L8:
        boolean r103 = true;
    L10:
        if (r103 == true) goto L16;
        OTextView r104 = this.f401334q;
        if (r100 == true) goto L15;
        r102 = 8;
    L15:
        r104.setVisibility(r102);
        return;
    L16:
        this.f401334q.setVisibility(8);
        return;
    L5:
        if (r101.length() == 0) goto L8;
        r103 = false;
        goto L10
    }

    public final void r(boolean r100) {
        ImageView r101 = this.f401337t;
        if (r100 == false) goto L5;
        int r102 = 0;
    L6:
        r101.setVisibility(r102);
        f();
        return;
    L5:
        r102 = 8;
        goto L6
    }

    public final void s(boolean r100) {
        CharSequence r101 = getTitle();
        int r102 = 0;
        if (r101 != null) goto L5;
    L8:
        boolean r103 = true;
    L10:
        if (r103 == true) goto L16;
        OTextView r104 = this.f401332o;
        if (r100 == true) goto L15;
        r102 = 8;
    L15:
        r104.setVisibility(r102);
        return;
    L16:
        this.f401332o.setVisibility(8);
        return;
    L5:
        if (r101.length() == 0) goto L8;
        r103 = false;
        goto L10
    }

    public final void setAppIcon(int r100) {
        this.f401329l.setVisibility(8);
        a();
        if (r100 == 0) goto L8;
        OImageAppIcon r101 = this.f401330m;
        if (r101 == null) goto L13;
        r101.setImageResource(r100);
    L13:
        if (this.f401338u.getVisibility() != 0) goto L15;
        boolean r102 = true;
    L16:
        if (r102 == false) goto L19;
        u();
        return;
    L19:
        return;
    L15:
        r102 = false;
        goto L16
    L8:
        OImageAppIcon r103 = this.f401330m;
        if (r103 == null) goto L13;
        r103.setImageDrawable(null);
        goto L13
    }

    public final void setBgColor(int r100) {
        d r101 = this.f401318a;
        r101.f401394d = r100;
        r101.a(r101.f401393c, r101.f401395e, false);
    }

    public final void setCardType(int r100) {
        this.D = r100;
        boolean r101 = true;
        if (r100 == 0) goto L18;
        if (r100 != 1) goto L6;
        this.f401323f.setPaddingRelative(0, 0, pla.d.n(this, 4), 0);
        this.f401323f.setMinimumHeight(pla.d.n(this, 60));
        this.f401331n.setVisibility(0);
        FrameLayout r102 = this.f401327j;
        ViewGroup.LayoutParams r103 = r102.getLayoutParams();
        if (r103 == null) goto L17;
        ConstraintLayout.LayoutParams r104 = (ConstraintLayout.LayoutParams) r103;
        ((ViewGroup.MarginLayoutParams) r104).width = -2;
        r102.setLayoutParams(r104);
        FrameLayout r105 = this.f401328k;
        ViewGroup.LayoutParams r106 = r105.getLayoutParams();
        r106.width = pla.d.n(this, 60);
        r106.height = pla.d.n(this, 60);
        r105.setLayoutParams(r106);
        this.f401328k.setPadding(pla.d.n(this, 12), pla.d.n(this, 12), pla.d.n(this, 12), pla.d.n(this, 12));
    L21:
        this.f401329l.setClipToOutline(true);
        this.f401329l.setOutlineProvider(new c(this));
        this.f401329l.invalidateOutline();
        if (this.f401338u.getVisibility() == 0) goto L25;
        r101 = false;
    L25:
        if (r101 == false) goto L30;
        u();
        return;
    L30:
        return;
    L17:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L6:
        if (r100 != 2) goto L21;
        this.f401323f.setPaddingRelative(0, 0, 0, 0);
        this.f401323f.setMinimumHeight(0);
        this.f401331n.setVisibility(8);
        FrameLayout r107 = this.f401327j;
        ViewGroup.LayoutParams r108 = r107.getLayoutParams();
        if (r108 == null) goto L12;
        ConstraintLayout.LayoutParams r109 = (ConstraintLayout.LayoutParams) r108;
        ((ViewGroup.MarginLayoutParams) r109).width = -1;
        r107.setLayoutParams(r109);
        n(true);
        goto L21
    L12:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L18:
        this.f401323f.setPaddingRelative(0, 0, pla.d.n(this, 4), 0);
        this.f401323f.setMinimumHeight(pla.d.n(this, 48));
        this.f401331n.setVisibility(0);
        FrameLayout r110 = this.f401327j;
        ViewGroup.LayoutParams r111 = r110.getLayoutParams();
        if (r111 == null) goto L29;
        ConstraintLayout.LayoutParams r112 = (ConstraintLayout.LayoutParams) r111;
        ((ViewGroup.MarginLayoutParams) r112).width = -2;
        r110.setLayoutParams(r112);
        FrameLayout r113 = this.f401328k;
        ViewGroup.LayoutParams r114 = r113.getLayoutParams();
        r114.width = pla.d.n(this, 48);
        r114.height = pla.d.n(this, 48);
        r113.setLayoutParams(r114);
        this.f401328k.setPadding(pla.d.n(this, 10), pla.d.n(this, 10), pla.d.n(this, 10), pla.d.n(this, 10));
        goto L21
    L29:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.constraintlayout.widget.ConstraintLayout.LayoutParams");
    }

    public final void setContentChecked(boolean r100) {
        if (r100 == false) goto L9;
        this.f401323f.setSelected(true);
        if (getContentContainerBgColor().isStateful() == true) goto L11;
        OStateGradientDrawable r101 = this.f401324g;
        if (r101 == null) goto L13;
        r101.setColor(getResources().getColor(R.color.oui_state_overlay_pressed));
        return;
    L13:
        return;
    L11:
        return;
    L9:
        this.f401323f.setSelected(false);
    }

    public final void setContentColor(ColorStateList r100) {
        Intrinsics.checkNotNullParameter(r100, "color");
        setContentContainerBgColor(r100);
    }

    public final void setContentContainerBgColor(ColorStateList r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        if (Intrinsics.areEqual(this.G, r100) == true) goto L9;
        this.G = r100;
        OStateGradientDrawable r101 = this.f401324g;
        if (r101 == null) goto L10;
        r101.setSolidColors(r100);
        return;
    L10:
        return;
    }

    public final void setContentMarkColor(ColorStateList r100) {
        this.f401326i = r100;
        if (r100 != null) goto L6;
        setContentContainerBgColor(this.f401325h);
        return;
    }

    public final void setCustomEndView(View r100) {
        this.f401336s.removeAllViews();
        if (r100 != null) goto L6;
    L13:
        f();
        return;
    L6:
        if ((r100.getParent() instanceof ViewGroup) == false) goto L12;
        ViewParent r101 = r100.getParent();
        if (r101 == null) goto L11;
        ((ViewGroup) r101).removeView(r100);
        goto L12
    L11:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L12:
        this.f401336s.addView(r100);
        goto L13
    }

    public final void setCustomStartView(int r100) {
        this.f401327j.removeAllViews();
        if (r100 == 0) goto L8;
        FrameLayout.inflate(getContext(), r100, this.f401327j);     // Catch: Exception -> L6
    L8:
        if (this.f401338u.getVisibility() != 0) goto L10;
        boolean r101 = true;
    L11:
        if (r101 == false) goto L16;
        u();
        return;
    L16:
        return;
    L10:
        r101 = false;
        goto L11
    }

    public final void setDefaultCustomEndView(int r100) {
        this.f401336s.removeAllViews();
        if (r100 != 0) goto L5;
        setCustomEndView(R.layout.o_card_list_item_custom_end_checkbox);
        return;
    L5:
        if (r100 != 1) goto L7;
        setCustomEndView(R.layout.o_card_list_item_custom_end_switch);
        return;
    L7:
        if (r100 != 2) goto L9;
        setCustomEndView(R.layout.o_card_list_item_custom_end_mark);
        return;
    L9:
        if (r100 != 3) goto L11;
        setCustomEndView(R.layout.o_card_list_item_custom_end_detail);
        return;
    L11:
        if (r100 == 4) goto L13;
        setCustomEndView(null);
        return;
    L13:
        setCustomEndView(R.layout.o_card_list_item_custom_end_handle);
    }

    public final void setDefaultCustomStartView(int r100) {
        this.f401327j.removeAllViews();
        if (r100 != 0) goto L6;
        setCustomStartView(R.layout.o_card_list_item_custom_start_checkbox);
    L6:
        if (this.f401338u.getVisibility() != 0) goto L8;
        boolean r101 = true;
    L9:
        if (r101 == false) goto L12;
        u();
        return;
    L12:
        return;
    L8:
        r101 = false;
        goto L9
    }

    public final void setDefaultTailIcon(int r100) {
        if (r100 != 0) goto L4;
        setTailIcon(getResources().getDrawable(R.drawable.o_card_list_item_tail_icon_arrow));
        return;
    L4:
        if (r100 != 1) goto L10;
        setTailIcon(getResources().getDrawable(R.drawable.o_card_list_item_tail_icon_chevron));
        return;
    }

    public final void setEnableSwipe(boolean r100) {
        this.f401342y.setSwipeEnabled(r100);
        FrameLayout r101 = this.f401343z;
        if (r100 == false) goto L5;
        int r102 = 0;
    L6:
        r101.setVisibility(r102);
        return;
    L5:
        r102 = 8;
        goto L6
    }

    public final void setEnableSwipeDivider(boolean r100) {
        this.B = r100;
        if (this.f401338u.getVisibility() != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L13;
        View r102 = this.f401338u;
        if (this.B == false) goto L10;
        float r103 = this.A;
    L11:
        r102.setTranslationX(r103);
        return;
    L10:
        r103 = 0.0f;
        goto L11
    L13:
        return;
    L5:
        r101 = false;
        goto L6
    }

    @Override // android.view.View
    public void setEnabled(boolean r100) {
        super.setEnabled(r100);
        this.f401323f.setEnabled(r100);
        this.f401327j.setEnabled(r100);
        this.f401328k.setEnabled(r100);
        this.f401329l.setEnabled(r100);
        OImageAppIcon r101 = this.f401330m;
        if (r101 == null) goto L6;
        r101.setEnabled(r100);
    L6:
        this.f401331n.setEnabled(r100);
        this.f401332o.setEnabled(r100);
        this.f401334q.setEnabled(r100);
        this.f401336s.setEnabled(r100);
        this.f401337t.setEnabled(r100);
        this.f401342y.setEnabled(r100);
        d(this.f401327j, r100);
        d(this.f401336s, r100);
        d(this.f401343z, r100);
    }

    public final void setEndDetailText(CharSequence r100) {
        k(r100, -1);
    }

    public final void setIcon(int r100) {
        boolean r101 = false;
        this.f401329l.setVisibility(0);
        OImageAppIcon r102 = this.f401330m;
        if (r102 == null) goto L6;
        r102.setVisibility(8);
    L6:
        if (r100 == 0) goto L8;
        this.f401329l.setImageResource(r100);
    L10:
        if (this.f401338u.getVisibility() != 0) goto L12;
        r101 = true;
    L12:
        if (r101 == false) goto L15;
        u();
        return;
    L15:
        return;
    L8:
        this.f401329l.setImageDrawable(null);
        goto L10
    }

    public final void setMark(boolean r100) {
        if (this.H == r100) goto L12;
        this.H = r100;
        if (r100 == false) goto L10;
        ColorStateList r101 = this.f401326i;
        if (r101 == null) goto L14;
        setContentContainerBgColor(r101);
        return;
    L14:
        return;
    L10:
        setContentContainerBgColor(this.f401325h);
        return;
    }

    public final void setOnContentClickListener(View.OnClickListener r100) {
        this.f401323f.setOnClickListener(r100);
        b();
    }

    public final void setOnContentLongClickListener(View.OnLongClickListener r100) {
        this.f401323f.setOnLongClickListener(r100);
        b();
    }

    public final void setShowCardBg(boolean r100) {
        this.f401319b = r100;
        e();
        d r101 = this.f401318a;
        r101.a(this.f401319b, r101.f401395e, false);
    }

    public final void setSubTitle(CharSequence r100) {
        this.f401334q.setText(r100);
    }

    public final void setSwipeView(int r100) {
        this.f401343z.removeAllViews();
        if (r100 == 0) goto L9;
        FrameLayout.inflate(getContext(), r100, this.f401343z);     // Catch: Exception -> L6
        return;
    L10:
        return;
    }

    public final void setTailIcon(int r100) {
        if (r100 == 0) goto L4;
        this.f401337t.setImageResource(r100);
        return;
    L4:
        this.f401337t.setImageDrawable(null);
    }

    public final void setTitle(CharSequence r100) {
        this.f401332o.setText(r100);
    }

    public final void setAppIcon(Drawable r100) {
        this.f401329l.setVisibility(8);
        a();
        if (r100 == null) goto L8;
        OImageAppIcon r101 = this.f401330m;
        if (r101 == null) goto L13;
        r101.setImageDrawable(r100);
    L13:
        if (this.f401338u.getVisibility() != 0) goto L15;
        boolean r102 = true;
    L16:
        if (r102 == false) goto L19;
        u();
        return;
    L19:
        return;
    L15:
        r102 = false;
        goto L16
    L8:
        OImageAppIcon r103 = this.f401330m;
        if (r103 == null) goto L13;
        r103.setImageDrawable(null);
        goto L13
    }

    public final void setContentColor(int r100) {
        setContentColor(ColorStateList.valueOf(r100));
    }

    public final void setCustomEndView(int r100) {
        this.f401336s.removeAllViews();
        if (r100 != 0) goto L8;
    L5:
        f();
        return;
    L8:
        FrameLayout.inflate(getContext(), r100, this.f401336s);     // Catch: Exception -> L7
        goto L5
    }

    public final void setCustomStartView(View r100) {
        this.f401327j.removeAllViews();
        if (r100 == null) goto L6;
        this.f401327j.addView(r100);
    L6:
        if (this.f401338u.getVisibility() != 0) goto L8;
        boolean r101 = true;
    L9:
        if (r101 == false) goto L12;
        u();
        return;
    L12:
        return;
    L8:
        r101 = false;
        goto L9
    }

    public final void setIcon(Drawable r100) {
        boolean r101 = false;
        this.f401329l.setVisibility(0);
        OImageAppIcon r102 = this.f401330m;
        if (r102 == null) goto L6;
        r102.setVisibility(8);
    L6:
        if (r100 == null) goto L8;
        this.f401329l.setImageDrawable(r100);
    L10:
        if (this.f401338u.getVisibility() != 0) goto L12;
        r101 = true;
    L12:
        if (r101 == false) goto L15;
        u();
        return;
    L15:
        return;
    L8:
        this.f401329l.setImageDrawable(null);
        goto L10
    }

    public final void setSwipeView(View r100) {
        this.f401343z.removeAllViews();
        if (r100 == null) goto L6;
        this.f401343z.addView(r100);
        return;
    }

    public final void setTailIcon(Drawable r100) {
        if (r100 == null) goto L5;
        this.f401337t.setImageDrawable(r100);
        return;
    }

    public static void d(View r100, boolean r101) {
        if ((r100 instanceof ViewGroup) == false) goto L7;
        ViewGroup r102 = (ViewGroup) r100;
        int r103 = r102.getChildCount();
        int r104 = 0;
    L5:
        if (r104 >= r103) goto L9;
        int r105 = r104 + 1;
        View r106 = r102.getChildAt(r104);
        r106.setEnabled(r101);
        d(r106, r101);
        r104 = r105;
        goto L5
    L9:
        return;
    }

    public static void h(OCardListItem r100, int r101) {
        r100.C = r101;
        d r102 = r100.f401318a;
        r102.a(r102.f401393c, r101, false);
    }

    public static void j(OCardListItem r100, int r101) {
        if (r101 != 1) goto L5;
        boolean r102 = true;
    L6:
        int r103 = r100.F;
        if (r103 != r101) goto L20;
        if (r103 != 1) goto L14;
        LinearLayout r104 = r100.f401331n;
        ViewGroup.LayoutParams r105 = r104.getLayoutParams();
        if (r105 == null) goto L13;
        ConstraintLayout.LayoutParams r106 = (ConstraintLayout.LayoutParams) r105;
        ((ViewGroup.MarginLayoutParams) r106).width = 0;
        r106.W = false;
        r106.L = 0;
        r104.setLayoutParams(r106);
        return;
    L13:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L14:
        LinearLayout r107 = r100.f401331n;
        ViewGroup.LayoutParams r108 = r107.getLayoutParams();
        if (r108 == null) goto L18;
        ConstraintLayout.LayoutParams r109 = (ConstraintLayout.LayoutParams) r108;
        ((ViewGroup.MarginLayoutParams) r109).width = -2;
        r109.W = true;
        r109.L = 1;
        r107.setLayoutParams(r109);
        return;
    L18:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L20:
        if (r103 < 0) goto L26;
        if (r103 == r101) goto L26;
        View r110 = r100.f401331n.findViewById(R.id.custom_title_container);
        if (r110 == null) goto L26;
        r100.f401331n.removeView(r110);
    L26:
        r100.F = r101;
        if (r101 == 0) goto L39;
        if (r101 == 1) goto L38;
        r100.F = -1;
        View r111 = r100.f401331n.findViewById(R.id.custom_title_container);
        if (r111 == null) goto L33;
        r100.f401331n.removeView(r111);
    L33:
        LinearLayout r112 = r100.f401331n;
        ViewGroup.LayoutParams r113 = r112.getLayoutParams();
        if (r113 == null) goto L37;
        ConstraintLayout.LayoutParams r114 = (ConstraintLayout.LayoutParams) r113;
        ((ViewGroup.MarginLayoutParams) r114).width = -2;
        r114.W = true;
        r114.L = 1;
        r112.setLayoutParams(r114);
        return;
    L37:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L38:
        r100.i(R.layout.o_card_list_item_custom_title_detail, r102);
        return;
    L39:
        r100.i(R.layout.o_card_list_item_custom_title_icon, r102);
        return;
    L5:
        r102 = false;
        goto L6
    }

    public final void i(int r100, boolean r101) {
        if (r100 != 0) goto L25;
        return;
    L25:
        int r102 = 0;
        View r103 = LayoutInflater.from(getContext()).inflate(r100, this.f401331n, false);     // Catch: Exception -> L24
        if (r103 == null) goto L6;
        this.f401331n.addView(r103, 0);     // Catch: Exception -> L24
    L6:
        LinearLayout r104 = this.f401331n;     // Catch: Exception -> L24
        ViewGroup.LayoutParams r105 = r104.getLayoutParams();     // Catch: Exception -> L24
        if (r105 == null) goto L22;
        ConstraintLayout.LayoutParams r106 = (ConstraintLayout.LayoutParams) r105;     // Catch: Exception -> L24
        if (r101 == false) goto L11;
        int r107 = 0;
    L12:
        ((ViewGroup.MarginLayoutParams) r106).width = r107;     // Catch: Exception -> L24
        if (r101 == true) goto L15;
        boolean r108 = true;
    L16:
        r106.W = r108;     // Catch: Exception -> L24
        if (r101 == true) goto L20;
        r102 = 1;
    L20:
        r106.L = r102;     // Catch: Exception -> L24
        r104.setLayoutParams(r106);     // Catch: Exception -> L24
        return;
    L15:
        r108 = false;
        goto L16
    L11:
        r107 = -2;
        goto L12
    L22:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.constraintlayout.widget.ConstraintLayout.LayoutParams");     // Catch: Exception -> L24
    }

    public final void k(CharSequence r100, int r101) {
        if (r101 <= 0) goto L4;
        this.E = r101;
    L6:
        if ((getCustomEndView() instanceof OTextView) == false) goto L12;
        View r102 = getCustomEndView();
        if (r102 == null) goto L11;
        ((OTextView) r102).setText(r100);
    L19:
        f();
        return;
    L11:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.text.OTextView");
    L12:
        setDefaultCustomEndView(3);
        if ((getCustomEndView() instanceof OTextView) == false) goto L19;
        View r103 = getCustomEndView();
        if (r103 == null) goto L18;
        ((OTextView) r103).setText(r100);
        goto L19
    L18:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.text.OTextView");
    L4:
        this.E = pla.d.n(this, 168);
        goto L6
    }

    public final void l(int r100, int r101) {
        this.f401333p = r100;
        this.f401335r = r101;
        this.f401332o.setTextColor(r100);
        this.f401334q.setTextColor(this.f401335r);
    }

    /* JADX WARN: Type inference failed for: r6v31, types: [com.obric.oui.lisitem.a] */
    public OCardListItem(Context r100, AttributeSet r110, int r111) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r110, r111);
        this.f401319b = true;
        this.f401320c = getResources().getColor(R.color.oui_fill_list_item_card);
        this.f401324g = new OStateGradientDrawable();
        this.f401325h = getResources().getColorStateList(R.color.o_card_list_item_content_bg_color);
        this.f401333p = getResources().getColor(R.color.oui_basic_text_1);
        this.f401335r = getResources().getColor(R.color.oui_basic_text_3);
        this.f401340w = -1;
        this.f401341x = -1;
        this.B = true;
        this.F = -1;
        this.G = this.f401325h;
        this.E = pla.d.n(this, 168);
        setClipChildren(false);
        setClipToPadding(false);
        if (getLayoutParams() != null) goto L5;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    L5:
        View r101 = LayoutInflater.from(r100).inflate(R.layout.o_card_list_item_layout, this, true);
        if (r101 == null) goto L87;
        FrameLayout r102 = (FrameLayout) r101;
        FrameLayout r103 = (FrameLayout) findViewById(R.id.card_list_item_root);
        this.f401321d = r103;
        r103.setClickable(true);
        OUIFrameLayout r104 = (OUIFrameLayout) findViewById(R.id.card_container);
        this.f401322e = r104;
        r104.setChangeAlphaWhenPress(false);
        r104.setChangeAlphaWhenDisable(false);
        OUICardConstraintLayout r105 = (OUICardConstraintLayout) findViewById(R.id.content_container);
        this.f401323f = r105;
        r105.setChangeAlphaWhenPress(false);
        r105.setChangeAlphaWhenDisable(true);
        this.f401327j = (FrameLayout) findViewById(R.id.custom_start_container);
        this.f401328k = (FrameLayout) findViewById(R.id.icon_container);
        this.f401329l = (ImageView) findViewById(R.id.icon);
        this.f401331n = (LinearLayout) findViewById(R.id.title_container);
        this.f401332o = (OTextView) findViewById(R.id.title);
        this.f401334q = (OTextView) findViewById(R.id.sub_title);
        this.f401336s = (FrameLayout) findViewById(R.id.custom_end_container);
        this.f401337t = (ImageView) findViewById(R.id.tail_icon);
        this.f401338u = findViewById(R.id.card_divider);
        this.f401339v = new com.obric.oui.lisitem.a(this);
        OSwipeLayout r106 = (OSwipeLayout) findViewById(R.id.swipe_layout);
        this.f401342y = r106;
        r106.setChangeAlphaWhenPress(false);
        r106.setChangeAlphaWhenDisable(false);
        r106.setSwipeEnabled(false);
        a r107 = new a(this);
        ((ArrayList) r106.f403098p).add(r107);
        this.f401343z = (FrameLayout) findViewById(R.id.swip_container);
        if (r110 == null) goto L81;
        TypedArray r112 = getContext().obtainStyledAttributes(r110, new int[]{R.attr.ocardlistitem_bgColor, R.attr.ocardlistitem_cardPosition, R.attr.ocardlistitem_cardType, R.attr.ocardlistitem_contentColorList, R.attr.ocardlistitem_customEnd, R.attr.ocardlistitem_customStart, R.attr.ocardlistitem_defaultCustomEnd, R.attr.ocardlistitem_defaultCustomStart, R.attr.ocardlistitem_defaultCustomTitle, R.attr.ocardlistitem_defaultTailIcon, R.attr.ocardlistitem_endDetailText, R.attr.ocardlistitem_icon, R.attr.ocardlistitem_showCardBg, R.attr.ocardlistitem_showCustomEnd, R.attr.ocardlistitem_showCustomStart, R.attr.ocardlistitem_showDivider, R.attr.ocardlistitem_showIcon, R.attr.ocardlistitem_showSubTitle, R.attr.ocardlistitem_showTailIcon, R.attr.ocardlistitem_showTitle, R.attr.ocardlistitem_subTitle, R.attr.ocardlistitem_subTitleColor, R.attr.ocardlistitem_tailIcon, R.attr.ocardlistitem_title, R.attr.ocardlistitem_titleColor});
    L83:
        th = move-exception;
        r112.recycle();
        throw th;
    L12:
        if (r112.hasValue(12) == false) goto L14;
        this.f401319b = r112.getBoolean(12, true);     // Catch: Throwable -> L83
    L14:
        this.f401320c = r112.getColor(0, getResources().getColor(R.color.oui_fill_list_item_card));     // Catch: Throwable -> L83
        if (r112.hasValue(3) == false) goto L21;
        ColorStateList r108 = r112.getColorStateList(3);     // Catch: Throwable -> L83
        if (r108 != null) goto L19;
        r108 = getResources().getColorStateList(R.color.o_card_list_item_content_bg_color);     // Catch: Throwable -> L83
    L19:
        this.f401325h = r108;     // Catch: Throwable -> L83
        setContentContainerBgColor(r108);     // Catch: Throwable -> L83
    L21:
        if (r112.hasValue(2) == false) goto L24;
        this.D = r112.getInt(2, 0);     // Catch: Throwable -> L83
    L24:
        if (r112.hasValue(1) == false) goto L27;
        this.C = r112.getInt(1, 0);     // Catch: Throwable -> L83
    L27:
        if (r112.hasValue(5) == false) goto L30;
        setCustomStartView(r112.getResourceId(5, 0));     // Catch: Throwable -> L83
    L30:
        if (r112.hasValue(7) == false) goto L33;
        setDefaultCustomStartView(r112.getInt(7, 0));     // Catch: Throwable -> L83
    L33:
        if (r112.hasValue(11) == false) goto L36;
        setIcon(r112.getResourceId(11, 0));     // Catch: Throwable -> L83
    L36:
        if (r112.hasValue(23) == false) goto L38;
        setTitle(r112.getString(23));     // Catch: Throwable -> L83
    L38:
        this.f401333p = r112.getColor(24, getResources().getColor(R.color.oui_basic_text_1));     // Catch: Throwable -> L83
        if (r112.hasValue(20) == false) goto L41;
        setSubTitle(r112.getString(20));     // Catch: Throwable -> L83
    L41:
        this.f401335r = r112.getColor(21, getResources().getColor(R.color.oui_basic_text_3));     // Catch: Throwable -> L83
        if (r112.hasValue(8) == false) goto L45;
        j(this, r112.getInt(8, 0));     // Catch: Throwable -> L83
    L45:
        if (r112.hasValue(4) == false) goto L48;
        setCustomEndView(r112.getResourceId(4, 0));     // Catch: Throwable -> L83
    L48:
        if (r112.hasValue(6) == false) goto L51;
        setDefaultCustomEndView(r112.getInt(6, 0));     // Catch: Throwable -> L83
    L51:
        if (r112.hasValue(10) == false) goto L54;
        k(r112.getString(10), -1);     // Catch: Throwable -> L83
    L54:
        if (r112.hasValue(22) == false) goto L57;
        setTailIcon(r112.getResourceId(22, 0));     // Catch: Throwable -> L83
    L57:
        if (r112.hasValue(9) == false) goto L60;
        setDefaultTailIcon(r112.getInt(9, 0));     // Catch: Throwable -> L83
    L60:
        if (r112.hasValue(14) == false) goto L63;
        n(r112.getBoolean(14, false));     // Catch: Throwable -> L83
    L63:
        if (r112.hasValue(16) == false) goto L66;
        p(r112.getBoolean(16, false));     // Catch: Throwable -> L83
    L66:
        if (r112.hasValue(19) == false) goto L69;
        s(r112.getBoolean(19, false));     // Catch: Throwable -> L83
    L69:
        if (r112.hasValue(17) == false) goto L72;
        q(r112.getBoolean(17, false));     // Catch: Throwable -> L83
    L72:
        if (r112.hasValue(13) == false) goto L75;
        m(r112.getBoolean(13, false));     // Catch: Throwable -> L83
    L75:
        if (r112.hasValue(18) == false) goto L78;
        r(r112.getBoolean(18, false));     // Catch: Throwable -> L83
    L78:
        if (r112.hasValue(15) == false) goto L80;
        o(r112.getBoolean(15, false));     // Catch: Throwable -> L83
    L80:
        r112.recycle();
    L81:
        e();
        setCardType(this.D);
        l(this.f401333p, this.f401335r);
        this.f401318a = new d(r104, this.f401319b, this.f401320c, this.C);
        return;
    L87:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout");
    }

    public /* synthetic */ OCardListItem(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
