package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.layout.slot;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.byted.cast.common.CastMonitor;
import com.bytedance.android.live.soloktv.SoloKtvContext;
import com.larksuite.component.ui.layout.LKUIRoundLinearLayout;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.blueprint.l;
import com.ss.android.lark.blueprint.s;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0007\u0018\u00002\u00020\u0001:\u0002&'B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0007H\u0016J\u0018\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0007H\u0014J\u0018\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0007H\u0002J\u0018\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0007H\u0002J\f\u0010\u0018\u001a\u00020\u0019*\u00020\u001aH\u0002J\u0018\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001aH\u0002J0\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\u00192\u0006\u0010 \u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u0007H\u0014J0\u0010$\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\u00192\u0006\u0010 \u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u0007H\u0003J0\u0010%\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\u00192\u0006\u0010 \u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u0007H\u0002R\u001a\u0010\n\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/chat/message/cellv2/layout/slot/StackSlot;", "Lcom/larksuite/component/ui/layout/LKUIRoundLinearLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "spacing", "getSpacing", "()I", "setSpacing", "(I)V", "mCurrentGravity", "setGravity", "", GXTemplateKey.GAIAX_LAYER_GRAVITY, "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "measureVertical", "measureHorizontal", "isSupportSpacing", "", "Landroid/view/View;", "resolveSpacing", SoloKtvContext.SOLO_PAGE_FIRST, "second", "onLayout", CastMonitor.EVENT_PARAM_BYTECAST_NETWORK_STATE_CHANGED, "l", "t", "r", "b", "layoutVertical", "layoutHorizontal", "MatchSiblingLayoutOption", "SpacingLayoutOption", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class StackSlot extends LKUIRoundLinearLayout {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f413323r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f413324s;

    public interface a extends s {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C4807a f413325a = null;

        /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.chat.message.cellv2.layout.slot.StackSlot$a$a, reason: collision with other inner class name */
        public static final class C4807a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ C4807a f413326a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final C4808a f413327b = null;

            /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.chat.message.cellv2.layout.slot.StackSlot$a$a$a, reason: collision with other inner class name */
            public static final class C4808a implements a {
                @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.layout.slot.StackSlot.a
                public final void c() {
                }

                public C4808a() {
                }
            }

            public C4807a() {
            }

            static {
                f413326a = new C4807a();
                f413327b = new C4808a();
            }
        }

        static {
            f413325a = C4807a.f413326a;
        }

        void c();
    }

    public interface b extends s {

        public static final class a implements Comparable<a> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final int f413328a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final int f413329b;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof a) == true) goto L8;
                return false;
            L8:
                a r101 = (a) r100;
                if (this.f413328a == r101.f413328a) goto L12;
                return false;
            L12:
                if (this.f413329b == r101.f413329b) goto L14;
                return false;
            L14:
                return true;
            }

            public final int hashCode() {
                return (this.f413328a * 31) + this.f413329b;
            }

            public final String toString() {
                return "SpacingConstraint(value=" + this.f413328a + ", priority=" + this.f413329b + ')';
            }

            public a(int r100) {
                this.f413328a = r100;
                this.f413329b = 500;
            }

            @Override // java.lang.Comparable
            public final int compareTo(a r100) {
                a r101 = r100;
                Intrinsics.checkNotNullParameter(r101, "other");
                return RangesKt.coerceIn(this.f413329b, 1, 999) - RangesKt.coerceIn(r101.f413329b, 1, 999);
            }
        }

        void a();

        a b();

        void f();

        void g();
    }

    public StackSlot(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public StackSlot(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final int getSpacing() {
        return this.f413323r;
    }

    public final boolean f(View r100) {
        if (getOrientation() != 1) goto L5;
        boolean r101 = true;
    L7:
        if (r100.getVisibility() != 0) goto L16;
        if (r101 == true) goto L10;
    L11:
        if (r101 == false) goto L13;
        return false;
    L13:
        if (r100.getMeasuredWidth() <= 0) goto L18;
    L14:
        return true;
    L18:
        return false;
    L10:
        if (r100.getMeasuredHeight() > 0) goto L14;
    L16:
        return false;
    L5:
        r101 = false;
        goto L7
    }

    @Override // android.widget.LinearLayout
    public void setGravity(int r100) {
        super.setGravity(r100);
        this.f413324s = r100;
    }

    public final void setSpacing(int r100) {
        this.f413323r = r100;
    }

    public final int g(View r100, View r101) {
        boolean r102 = true;
        if (getOrientation() == 1) goto L7;
        r102 = false;
    L7:
        if (r100.getVisibility() == 0) goto L9;
    L43:
        return 0;
    L9:
        if (r101.getVisibility() != 0) goto L43;
        if (r102 == true) goto L12;
    L15:
        if (r102 == false) goto L17;
    L21:
        s r103 = l.a(r100);
        b.a r104 = null;
        if ((r103 instanceof b) == false) goto L24;
        b r105 = (b) r103;
    L25:
        s r106 = l.a(r101);
        if ((r106 instanceof b) == false) goto L28;
        b r107 = (b) r106;
    L29:
        if (r102 == false) goto L32;
        if (r105 == null) goto L34;
        r105.g();
    L34:
        if (r102 == false) goto L37;
        if (r107 == null) goto L39;
        r104 = r107.b();
    L39:
        if (r104 == null) goto L42;
        return r104.f413328a;
    L42:
        return this.f413323r;
    L37:
        if (r107 == null) goto L39;
        r107.f();
        goto L39
    L32:
        if (r105 == null) goto L34;
        r105.a();
        goto L34
    L28:
        r107 = null;
        goto L29
    L24:
        r105 = null;
        goto L25
    L17:
        if (r100.getMeasuredWidth() == 0) goto L43;
        if (r101.getMeasuredWidth() != 0) goto L21;
    L12:
        if (r100.getMeasuredHeight() == 0) goto L43;
        if (r101.getMeasuredHeight() == 0) goto L43;
        goto L15
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r110, int r111) {
        if (getOrientation() != 1) goto L45;
        int r100 = getChildCount();
        int r112 = 0;
        int r113 = 0;
        View r114 = null;
        int r115 = 0;
    L5:
        if (r112 >= r100) goto L19;
        View r116 = getChildAt(r112);
        Intrinsics.checkNotNull(r116);
        if (r116.getVisibility() != 8) goto L9;
        boolean r117 = true;
    L10:
        if (r117 == true) goto L18;
        measureChild(r116, r110, r111);
        r113 = r113 + r116.getMeasuredHeight();
        if (f(r116) == false) goto L17;
        if (r114 == null) goto L16;
        r113 = r113 + g(r114, r116);
    L16:
        r114 = r116;
    L17:
        r115 = RangesKt.coerceAtLeast(r115, r116.getMeasuredWidth());
    L18:
        r112 = r112 + 1;
        goto L5
    L9:
        r117 = false;
        goto L10
    L19:
        int r101 = getChildCount();
        int r118 = 0;
    L20:
        if (r118 >= r101) goto L38;
        View r119 = getChildAt(r118);
        Intrinsics.checkNotNull(r119);
        if (r119.getVisibility() != 8) goto L24;
        boolean r120 = true;
    L25:
        if (r120 == true) goto L37;
        s r121 = l.a(r119);
        if ((r121 instanceof a) == false) goto L30;
        a r122 = (a) r121;
    L31:
        if (r122 == null) goto L33;
        r122.c();
        boolean r123 = true;
    L34:
        if (r123 == false) goto L37;
        r119.measure(View.MeasureSpec.makeMeasureSpec(r115, 1073741824), LinearLayout.getChildMeasureSpec(r111, getPaddingTop() + getPaddingBottom(), r119.getLayoutParams().height));
        goto L37
    L33:
        r123 = false;
        goto L34
    L30:
        r122 = null;
    L37:
        r118 = r118 + 1;
        goto L20
    L24:
        r120 = false;
        goto L25
    L38:
        int r124 = r115 + (getPaddingLeft() + getPaddingRight());
        int r102 = View.MeasureSpec.getMode(r110);
        int r103 = View.MeasureSpec.getSize(r110);
        if (r102 == Integer.MIN_VALUE) goto L43;
        if (r102 != 1073741824) goto L44;
        r124 = r103;
    L44:
        setMeasuredDimension(r124, (r113 + getPaddingTop()) + getPaddingBottom());
        return;
    L43:
        r124 = RangesKt.coerceAtMost(r124, r103);
        goto L44
    L45:
        int r104 = getChildCount();
        int r105 = 0;
        int r125 = 0;
        View r126 = null;
        int r127 = 0;
    L46:
        if (r105 >= r104) goto L60;
        View r128 = getChildAt(r105);
        Intrinsics.checkNotNull(r128);
        if (r128.getVisibility() != 8) goto L50;
        boolean r129 = true;
    L51:
        if (r129 == true) goto L59;
        measureChild(r128, r110, r111);
        r125 = r125 + r128.getMeasuredWidth();
        if (f(r128) == false) goto L58;
        if (r126 == null) goto L57;
        r125 = r125 + g(r126, r128);
    L57:
        r126 = r128;
    L58:
        r127 = RangesKt.coerceAtLeast(r127, r128.getMeasuredHeight());
    L59:
        r105 = r105 + 1;
        goto L46
    L50:
        r129 = false;
        goto L51
    L60:
        int r106 = getChildCount();
        int r107 = 0;
    L61:
        if (r107 >= r106) goto L79;
        View r130 = getChildAt(r107);
        Intrinsics.checkNotNull(r130);
        if (r130.getVisibility() != 8) goto L65;
        boolean r131 = true;
    L66:
        if (r131 == true) goto L78;
        s r132 = l.a(r130);
        if ((r132 instanceof a) == false) goto L71;
        a r133 = (a) r132;
    L72:
        if (r133 == null) goto L74;
        r133.c();
        boolean r134 = true;
    L75:
        if (r134 == false) goto L78;
        r130.measure(LinearLayout.getChildMeasureSpec(r110, getPaddingLeft() + getPaddingRight(), r130.getLayoutParams().width), View.MeasureSpec.makeMeasureSpec(r127, 1073741824));
        goto L78
    L74:
        r134 = false;
        goto L75
    L71:
        r133 = null;
    L78:
        r107 = r107 + 1;
        goto L61
    L65:
        r131 = false;
        goto L66
    L79:
        int r135 = r127 + (getPaddingTop() + getPaddingBottom());
        int r108 = View.MeasureSpec.getMode(r111);
        int r109 = View.MeasureSpec.getSize(r111);
        if (r108 == Integer.MIN_VALUE) goto L84;
        if (r108 != 1073741824) goto L85;
        r135 = r109;
    L85:
        setMeasuredDimension((r125 + getPaddingLeft()) + getPaddingRight(), r135);
        return;
    L84:
        r135 = RangesKt.coerceAtMost(r135, r109);
        goto L85
    }

    public StackSlot(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f413323r = UIUtils.dp2px(r100, 8.0f);
        this.f413324s = 8388659;
    }

    public /* synthetic */ StackSlot(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r110, int r111, int r112, int r113) {
        View r114 = null;
        if (getOrientation() != 1) goto L26;
        int r101 = getPaddingTop();
        int r102 = getPaddingLeft();
        if ((Gravity.getAbsoluteGravity(this.f413324s, getLayoutDirection()) & 7) != 5) goto L7;
        boolean r103 = true;
    L8:
        int r104 = getChildCount();
        int r105 = 0;
    L9:
        if (r105 >= r104) goto L41;
        View r106 = getChildAt(r105);
        Intrinsics.checkNotNull(r106);
        if (r106.getVisibility() != 8) goto L13;
        boolean r107 = true;
    L14:
        if (r107 == true) goto L25;
        if (f(r106) == false) goto L21;
        if (r114 == null) goto L20;
        r101 = r101 + g(r114, r106);
    L20:
        r114 = r106;
    L21:
        if (r103 == false) goto L23;
        r106.layout(getMeasuredWidth() - r106.getMeasuredWidth(), r101, getMeasuredWidth(), r106.getMeasuredHeight() + r101);
    L24:
        r101 = r101 + r106.getMeasuredHeight();
        goto L25
    L23:
        r106.layout(r102, r101, r106.getMeasuredWidth() + r102, r106.getMeasuredHeight() + r101);
    L25:
        r105 = r105 + 1;
        goto L9
    L13:
        r107 = false;
        goto L14
    L41:
        return;
    L7:
        r103 = false;
        goto L8
    L26:
        int r108 = getPaddingLeft();
        int r109 = getPaddingTop();
        int r115 = getChildCount();
        int r116 = 0;
    L27:
        if (r116 >= r115) goto L48;
        View r117 = getChildAt(r116);
        Intrinsics.checkNotNull(r117);
        if (r117.getVisibility() != 8) goto L31;
        boolean r118 = true;
    L32:
        if (r118 == true) goto L40;
        if (f(r117) == false) goto L39;
        if (r114 == null) goto L38;
        r108 = r108 + g(r114, r117);
    L38:
        r114 = r117;
    L39:
        r117.layout(r108, r109, r117.getMeasuredWidth() + r108, r117.getMeasuredHeight() + r109);
        r108 = r108 + r117.getMeasuredWidth();
    L40:
        r116 = r116 + 1;
        goto L27
    L31:
        r118 = false;
        goto L32
    }
}
