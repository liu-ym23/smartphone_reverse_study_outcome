package com.ss.android.lark.chat.chatwindow.chat.message.cell.mergeforward;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.byted.cast.common.CastMonitor;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 -2\u00020\u0001:\u0002-.B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0007H\u0014J(\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u0007H\u0002J0\u0010!\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u00072\u0006\u0010'\u001a\u00020\u0007H\u0014J\u0012\u0010(\u001a\u00020)2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020)H\u0014J\b\u0010+\u001a\u00020)H\u0014J\u0012\u0010,\u001a\u00020#2\b\u0010*\u001a\u0004\u0018\u00010)H\u0014R\u001a\u0010\n\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0012\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00070\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00070\u0016X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/chat/message/cell/mergeforward/AutoWrapLayout;", "Landroid/view/ViewGroup;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", GXTemplateKey.GAIAX_LAYER_GRAVITY, "getGravity", "()I", "setGravity", "(I)V", "horizontalGap", "getHorizontalGap", "setHorizontalGap", "verticalGap", "getVerticalGap", "setVerticalGap", "lineHeights", "", "lineWidths", "onMeasure", "", "widthMeasureSpec", "heightMeasureSpec", "measureChildWrapper", MapBundleKey.OfflineMapKey.OFFLINE_CHILD, "Landroid/view/View;", "allowDrawWidth", "lineWidth", "onLayout", CastMonitor.EVENT_PARAM_BYTECAST_NETWORK_STATE_CHANGED, "", "l", "t", "r", "b", "generateLayoutParams", "Landroid/view/ViewGroup$LayoutParams;", "p", "generateDefaultLayoutParams", "checkLayoutParams", "Companion", "LayoutParams", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AutoWrapLayout extends ViewGroup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f412613a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f412614b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f412615c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<Integer> f412616d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<Integer> f412617e;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u0019\b\u0016\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0006\u0010\u000bB\u0011\b\u0016\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u0006\u0010\u000eB\u0011\b\u0016\u0012\u0006\u0010\f\u001a\u00020\u0001¢\u0006\u0004\b\u0006\u0010\u000fB\u0011\b\u0016\u0012\u0006\u0010\f\u001a\u00020\u0000¢\u0006\u0004\b\u0006\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0014\"\u0004\b\u0018\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/chat/message/cell/mergeforward/AutoWrapLayout$LayoutParams;", "Landroid/view/ViewGroup$MarginLayoutParams;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "width", "", "height", "(II)V", "source", "Landroid/view/ViewGroup$LayoutParams;", "(Landroid/view/ViewGroup$LayoutParams;)V", "(Landroid/view/ViewGroup$MarginLayoutParams;)V", "(Lcom/ss/android/lark/chat/chatwindow/chat/message/cell/mergeforward/AutoWrapLayout$LayoutParams;)V", "allowNewLine", "", "getAllowNewLine", "()Z", "setAllowNewLine", "(Z)V", "isDivisionView", "setDivisionView", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class LayoutParams extends ViewGroup.MarginLayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f412618a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f412619b;

        public LayoutParams() {
            super(-1, -1);
            this.f412618a = true;
        }

        public LayoutParams(LayoutParams r100) {
            Intrinsics.checkNotNullParameter(r100, "source");
            super(r100);
            this.f412618a = true;
            this.f412618a = r100.f412618a;
            this.f412619b = r100.f412619b;
        }

        public LayoutParams(ViewGroup.LayoutParams r100) {
            Intrinsics.checkNotNullParameter(r100, "source");
            super(r100);
            this.f412618a = true;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams r100) {
            Intrinsics.checkNotNullParameter(r100, "source");
            super(r100);
            this.f412618a = true;
        }

        public LayoutParams(Context r100, AttributeSet r101) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            super(r100, r101);
            this.f412618a = true;
            TypedArray r102 = r100.obtainStyledAttributes(r101, new int[]{R.attr.allow_new_line, R.attr.is_division});
            this.f412618a = r102.getBoolean(0, true);
            this.f412619b = r102.getBoolean(1, false);
            r102.recycle();
        }
    }

    public static final class a {
    }

    static {
    }

    public AutoWrapLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public AutoWrapLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    public final int getGravity() {
        return this.f412613a;
    }

    public final int getHorizontalGap() {
        return this.f412614b;
    }

    public final int getVerticalGap() {
        return this.f412615c;
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams r100) {
        return r100 instanceof LayoutParams;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r100) {
        Intrinsics.checkNotNullParameter(r100, "p");
        if ((r100 instanceof LayoutParams) == false) goto L6;
        return new LayoutParams((LayoutParams) r100);
    L6:
        if ((r100 instanceof ViewGroup.MarginLayoutParams) == false) goto L9;
        return new LayoutParams((ViewGroup.MarginLayoutParams) r100);
    L9:
        return new LayoutParams(r100);
    }

    public final void setGravity(int r100) {
        this.f412613a = r100;
    }

    public final void setHorizontalGap(int r100) {
        this.f412614b = r100;
    }

    public final void setVerticalGap(int r100) {
        this.f412615c = r100;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet r100) {
        return new LayoutParams(getContext(), r100);
    }

    @Override // android.view.View
    public final void onMeasure(int r210, int r211) {
        if (getChildCount() <= 0) goto L42;
        if (r210 == 0) goto L42;
        int r100 = View.MeasureSpec.getSize(r210);
        int r101 = View.MeasureSpec.getSize(r211);
        int r102 = View.MeasureSpec.getMode(r210);
        int r103 = View.MeasureSpec.getMode(r211);
        int r104 = (r100 - getPaddingStart()) - getPaddingEnd();
        int r105 = getChildCount();
        int r106 = 0;
        int r110 = 0;
        int r111 = 0;
        int r112 = 0;
        int r113 = 0;
    L7:
        if (r106 >= r105) goto L33;
        View r114 = getChildAt(r106);
        Intrinsics.checkNotNull(r114);
        if (com.ss.android.lark.chat.chatwindow.chat.message.cell.mergeforward.a.b(r114) == true) goto L13;
        if (r114.getVisibility() != 8) goto L13;
        r106 = r106 + 1;
    L13:
        a(r114, r211, r104, r111);
        int r115 = (r114.getMeasuredWidth() + com.ss.android.lark.chat.chatwindow.chat.message.cell.mergeforward.a.c(r114)) + com.ss.android.lark.chat.chatwindow.chat.message.cell.mergeforward.a.d(r114);
        int r116 = (r114.getMeasuredHeight() + com.ss.android.lark.chat.chatwindow.chat.message.cell.mergeforward.a.e(r114)) + com.ss.android.lark.chat.chatwindow.chat.message.cell.mergeforward.a.a(r114);
        if (com.ss.android.lark.chat.chatwindow.chat.message.cell.mergeforward.a.b(r114) == true) goto L16;
    L24:
        int r117 = r100;
        int r212 = r101;
        int r213 = r105;
    L25:
        int r107 = r116;
        boolean r108 = false;
    L26:
        if (r108 == false) goto L28;
    L31:
        int r109 = Math.max(r110, r111 - this.f412614b);
        int r118 = r115 + this.f412614b;
        r112 = r112 + (r113 + this.f412615c);
        r113 = r107;
        r110 = r109;
        r111 = r118;
    L32:
        r106 = r106 + 1;
        r100 = r117;
        r101 = r212;
        r105 = r213;
        goto L7
    L28:
        if ((r111 + r115) > r104) goto L31;
        r111 = r111 + (r115 + this.f412614b);
        r113 = Math.max(r113, r107);
        goto L32
    L16:
        if (r106 >= (r105 - 1)) goto L24;
        int r119 = r106 + 1;
        r117 = r100;
        View r120 = getChildAt(r119);
        r212 = r101;
        int r121 = r111 + r115;
        r213 = r105;
        int r122 = this.f412614b + r121;
        Intrinsics.checkNotNull(r120);
        a(r120, r211, r104, r122);
        int r214 = (r120.getMeasuredWidth() + com.ss.android.lark.chat.chatwindow.chat.message.cell.mergeforward.a.c(r120)) + com.ss.android.lark.chat.chatwindow.chat.message.cell.mergeforward.a.d(r120);
        int r215 = (r120.getMeasuredHeight() + com.ss.android.lark.chat.chatwindow.chat.message.cell.mergeforward.a.e(r120)) + com.ss.android.lark.chat.chatwindow.chat.message.cell.mergeforward.a.a(r120);
        if (r121 <= r104) goto L20;
    L23:
        r114.setVisibility(8);
        r106 = r119;
        r115 = r214;
        r107 = r215;
        r108 = true;
        goto L26
    L20:
        if ((r122 + r214) > r104) goto L23;
        r114.setVisibility(0);
        goto L25
    L33:
        int r123 = r100;
        int r216 = r101;
        int r124 = Math.max(r110, r111 - this.f412614b);
        int r125 = r112 + r113;
        if (r102 != 1073741824) goto L36;
        int r126 = r123;
    L37:
        if (r103 != 1073741824) goto L39;
        int r127 = r216;
    L40:
        setMeasuredDimension(r126, r127);
        return;
    L39:
        r127 = (r125 + getPaddingTop()) + getPaddingBottom();
        goto L40
    L36:
        r126 = (r124 + getPaddingStart()) + getPaddingEnd();
    L42:
        super.onMeasure(r210, r211);
    }

    public AutoWrapLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f412613a = 8388659;
        TypedArray r103 = r100.obtainStyledAttributes(r101, new int[]{android.R.attr.gravity, R.attr.horizontal_gap, R.attr.vertical_gap});
        this.f412613a = r103.getInt(0, this.f412613a);
        this.f412614b = r103.getDimensionPixelSize(1, 0);
        this.f412615c = r103.getDimensionPixelSize(2, 0);
        r103.recycle();
        this.f412616d = new ArrayList();
        this.f412617e = new ArrayList();
    }

    public /* synthetic */ AutoWrapLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    public final void a(View r100, int r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        ViewGroup.LayoutParams r104 = r100.getLayoutParams();
        if ((r104 instanceof LayoutParams) == false) goto L5;
        LayoutParams r105 = (LayoutParams) r104;
    L6:
        if (r105 == null) goto L8;
        boolean r106 = r105.f412618a;
    L9:
        if (r106 == true) goto L13;
        if (r102 <= r103) goto L13;
        r102 = r102 - r103;
    L13:
        int r107 = (r102 - com.ss.android.lark.chat.chatwindow.chat.message.cell.mergeforward.a.c(r100)) - com.ss.android.lark.chat.chatwindow.chat.message.cell.mergeforward.a.d(r100);
        if (r100.getLayoutParams().width != (-2)) goto L16;
        int r108 = Integer.MIN_VALUE;
    L17:
        measureChild(r100, View.MeasureSpec.makeMeasureSpec(r107, r108), r101);
        return;
    L16:
        r108 = 1073741824;
        goto L17
    L8:
        r106 = true;
        goto L9
    L5:
        r105 = null;
        goto L6
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r110, int r111, int r210, int r211, int r212) {
        ((ArrayList) this.f412616d).clear();
        ((ArrayList) this.f412617e).clear();
        int r100 = getPaddingStart();
        int r101 = getWidth();
        int r102 = (r101 - r100) - getPaddingEnd();
        int r103 = getChildCount();
        int r104 = 0;
        int r105 = 0;
        int r106 = 0;
    L3:
        int r107 = 8;
        int r112 = 1;
        if (r104 >= r103) goto L27;
        View r113 = getChildAt(r104);
        Intrinsics.checkNotNull(r113);
        if (com.ss.android.lark.chat.chatwindow.chat.message.cell.mergeforward.a.b(r113) == true) goto L10;
        if (r113.getVisibility() != 8) goto L10;
        r104 = r104 + 1;
    L10:
        int r108 = (r113.getMeasuredWidth() + com.ss.android.lark.chat.chatwindow.chat.message.cell.mergeforward.a.c(r113)) + com.ss.android.lark.chat.chatwindow.chat.message.cell.mergeforward.a.d(r113);
        int r114 = (r113.getMeasuredHeight() + com.ss.android.lark.chat.chatwindow.chat.message.cell.mergeforward.a.e(r113)) + com.ss.android.lark.chat.chatwindow.chat.message.cell.mergeforward.a.a(r113);
        if (com.ss.android.lark.chat.chatwindow.chat.message.cell.mergeforward.a.b(r113) == true) goto L13;
    L19:
        boolean r109 = false;
    L20:
        if (r109 == false) goto L22;
    L25:
        ((ArrayList) this.f412616d).add(Integer.valueOf(r105));
        ((ArrayList) this.f412617e).add(Integer.valueOf(r106 - this.f412614b));
        r106 = r108 + this.f412614b;
        r105 = r114;
    L26:
        r104 = r104 + 1;
        goto L3
    L22:
        if ((r108 + r106) > r102) goto L25;
        r106 = r106 + (r108 + this.f412614b);
        r105 = Math.max(r105, r114);
        goto L26
    L13:
        if (r104 >= (r103 - 1)) goto L19;
        int r115 = r104 + 1;
        View r116 = getChildAt(r115);
        int r117 = r116.getMeasuredWidth();
        Intrinsics.checkNotNull(r116);
        int r118 = (r117 + com.ss.android.lark.chat.chatwindow.chat.message.cell.mergeforward.a.c(r116)) + com.ss.android.lark.chat.chatwindow.chat.message.cell.mergeforward.a.d(r116);
        int r119 = (r116.getMeasuredHeight() + com.ss.android.lark.chat.chatwindow.chat.message.cell.mergeforward.a.e(r116)) + com.ss.android.lark.chat.chatwindow.chat.message.cell.mergeforward.a.a(r116);
        int r120 = r106 + r108;
        if (r120 <= r102) goto L17;
    L18:
        r104 = r115;
        r108 = r118;
        r114 = r119;
        r109 = true;
        goto L20
    L17:
        if (((r120 + this.f412614b) + r118) <= r102) goto L19;
    L27:
        ((ArrayList) this.f412616d).add(Integer.valueOf(r105));
        ((ArrayList) this.f412617e).add(Integer.valueOf(r106 - this.f412614b));
        int r121 = this.f412613a;
        int r122 = r121 & 7;
        int r123 = r121 & 112;
        int r124 = getPaddingTop();
        int r125 = ((ArrayList) this.f412616d).size();
        int r126 = r124;
        int r127 = 0;
        int r128 = 0;
    L28:
        if (r127 >= r125) goto L57;
        int r129 = ((Number) ListProtector.get(this.f412616d, r127)).intValue();
        int r130 = ((Number) ListProtector.get(this.f412617e, r127)).intValue();
        if (r122 != r112) goto L32;
        int r131 = (r101 - r130) / 2;
    L36:
        int r132 = r131 + r100;
    L37:
        if (r128 >= r103) goto L56;
        if (r132 >= (r130 + r100)) goto L56;
        View r133 = getChildAt(r128);
        if (r133.getVisibility() != r107) goto L44;
        r128 = r128 + 1;
        goto L37
    L44:
        Intrinsics.checkNotNull(r133);
        int r134 = com.ss.android.lark.chat.chatwindow.chat.message.cell.mergeforward.a.c(r133) + r132;
        if (r123 != 16) goto L47;
        int r135 = (((((r129 - r133.getMeasuredHeight()) - com.ss.android.lark.chat.chatwindow.chat.message.cell.mergeforward.a.e(r133)) - com.ss.android.lark.chat.chatwindow.chat.message.cell.mergeforward.a.a(r133)) / 2) + r126) + com.ss.android.lark.chat.chatwindow.chat.message.cell.mergeforward.a.e(r133);
    L55:
        r133.layout(r134, r135, r134 + r133.getMeasuredWidth(), r135 + r133.getMeasuredHeight());
        r132 = r132 + (((r133.getMeasuredWidth() + com.ss.android.lark.chat.chatwindow.chat.message.cell.mergeforward.a.c(r133)) + com.ss.android.lark.chat.chatwindow.chat.message.cell.mergeforward.a.d(r133)) + this.f412614b);
        r128 = r128 + 1;
        r100 = r100;
        r101 = r101;
        r107 = 8;
        goto L37
    L47:
        if (r123 != 48) goto L49;
        int r136 = com.ss.android.lark.chat.chatwindow.chat.message.cell.mergeforward.a.e(r133);
    L53:
        r135 = r136 + r126;
        goto L55
    L49:
        if (r123 == 80) goto L51;
        r136 = com.ss.android.lark.chat.chatwindow.chat.message.cell.mergeforward.a.e(r133);
        goto L53
    L51:
        r136 = (r129 - r133.getMeasuredHeight()) - com.ss.android.lark.chat.chatwindow.chat.message.cell.mergeforward.a.a(r133);
    L56:
        r126 = r126 + (r129 + this.f412615c);
        r127 = r127 + 1;
        r100 = r100;
        r101 = r101;
        r107 = 8;
        r112 = 1;
        goto L28
    L32:
        if (r122 == 8388613) goto L34;
        r132 = r100;
        goto L37
    L34:
        r131 = r101 - r130;
        goto L36
    }
}
