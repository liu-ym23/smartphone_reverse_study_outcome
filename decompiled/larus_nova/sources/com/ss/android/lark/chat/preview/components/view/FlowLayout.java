package com.ss.android.lark.chat.preview.components.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.byted.cast.common.CastMonitor;
import com.ss.android.lark.chat.preview.components.a0;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 ;2\u00020\u0001:\u00039:;B\u0013\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001d\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB%\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\nH\u0014J\u000e\u0010\u001f\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020\nJ0\u0010!\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\n2\u0006\u0010%\u001a\u00020\n2\u0006\u0010&\u001a\u00020\n2\u0006\u0010'\u001a\u00020\nH\u0014JX\u0010(\u001a\u00020\u001c2\u0006\u0010)\u001a\u00020\n2\u0006\u0010*\u001a\u00020\n2\u0006\u0010+\u001a\u00020\n2\u0006\u0010,\u001a\u00020\n2\u0006\u0010-\u001a\u00020\n2\u0006\u0010.\u001a\u00020\n2\u0006\u0010/\u001a\u00020\n2\u0006\u00100\u001a\u00020\n2\u0006\u00101\u001a\u00020\n2\u0006\u00102\u001a\u00020\nH\u0002J\u0014\u00103\u001a\u00020\u001c2\f\u00104\u001a\b\u0012\u0004\u0012\u00020605J\u000e\u00107\u001a\u00020\u001c2\u0006\u00108\u001a\u00020\nR&\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000e0\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006<"}, d2 = {"Lcom/ss/android/lark/chat/preview/components/view/FlowLayout;", "Landroid/view/ViewGroup;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mChildrenPositionList", "", "Landroid/graphics/Rect;", "getMChildrenPositionList", "()Ljava/util/Map;", "setMChildrenPositionList", "(Ljava/util/Map;)V", "mMaxLines", "visibleItemCount", "getVisibleItemCount", "()I", "setVisibleItemCount", "(I)V", "widthAndHeight", "", "onMeasure", "", "widthMeasureSpec", "heightMeasureSpec", "measureWidthAndHeight", "widthSize", "onLayout", CastMonitor.EVENT_PARAM_BYTECAST_NETWORK_STATE_CHANGED, "", "l", "t", "r", "b", "saveChildrenPosition", RXScreenCaptureService.KEY_INDEX, "maxWidth", "width", "height", "leftMargin", "topMargin", "rightMargin", "bottomMargin", "childWidth", "childHeight", "setAdapter", "adapter", "Lcom/ss/android/lark/chat/preview/components/view/FlowLayout$Adapter;", "Lcom/ss/android/lark/chat/preview/components/view/FlowLayout$ViewHolder;", "setMaxLines", "maxLines", "Adapter", "ViewHolder", "Companion", "chat-preview_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FlowLayout extends ViewGroup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<Integer, Rect> f416118a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f416119b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f416120c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int[] f416121d;

    public static abstract class a<VH extends c> {
        public a() {
        }

        public abstract int a();

        public abstract void b(VH r100, int r101, int r102);

        public abstract a0.a c(ViewGroup r100);
    }

    public static final class b {
    }

    public static abstract class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f416122a;

        public c(View r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            this.f416122a = r100;
        }
    }

    static {
    }

    public final Map<Integer, Rect> getMChildrenPositionList() {
        return this.f416118a;
    }

    public final int getVisibleItemCount() {
        return this.f416120c;
    }

    public FlowLayout(Context r100) {
        super(r100);
        this.f416118a = new LinkedHashMap();
        this.f416119b = Integer.MAX_VALUE;
        this.f416121d = new int[2];
    }

    public final void setAdapter(a<c> r100) {
        Intrinsics.checkNotNullParameter(r100, "adapter");
        removeAllViews();
        int r101 = r100.a();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L11;
        a0.a r103 = r100.c(this);
        if (r102 >= this.f416118a.size()) goto L9;
        Rect r104 = this.f416118a.get(Integer.valueOf(r102));
        if (r104 == null) goto L9;
        int r105 = r104.width();
    L10:
        r100.b(r103, r102, r105);
        addView(r103.f416122a);
        r102 = r102 + 1;
    L9:
        r105 = 0;
        goto L10
    }

    public final void setMChildrenPositionList(Map<Integer, Rect> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f416118a = r100;
    }

    public final void setMaxLines(int r100) {
        if (r100 > 0) goto L5;
        r100 = Integer.MAX_VALUE;
    L5:
        this.f416119b = r100;
    }

    public final void setVisibleItemCount(int r100) {
        this.f416120c = r100;
    }

    public FlowLayout(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f416118a = new LinkedHashMap();
        this.f416119b = Integer.MAX_VALUE;
        this.f416121d = new int[2];
    }

    @Override // android.view.View
    public final void onMeasure(int r210, int r211) {
        this.f416118a.clear();
        measureChildren(r210, r211);
        int r110 = View.MeasureSpec.getSize(r210);
        int r111 = View.MeasureSpec.getMode(r210);
        int r112 = View.MeasureSpec.getSize(r211);
        int r113 = View.MeasureSpec.getMode(r211);
        int r100 = getPaddingLeft();
        int r101 = getPaddingTop();
        int r114 = getChildCount();
        int r102 = r100;
        int r115 = r101;
        int r103 = 0;
        int r104 = 1;
        int r105 = 0;
        boolean r116 = true;
    L3:
        if (r105 >= r114) goto L30;
        View r106 = getChildAt(r105);
        ViewGroup.LayoutParams r107 = r106.getLayoutParams();
        if ((r107 instanceof ViewGroup.MarginLayoutParams) == false) goto L7;
        ViewGroup.MarginLayoutParams r108 = (ViewGroup.MarginLayoutParams) r107;
    L8:
        if (r108 == null) goto L10;
        int r109 = r108.leftMargin;
    L11:
        if (r108 == null) goto L13;
        int r117 = r108.rightMargin;
    L14:
        if (r108 == null) goto L16;
        int r118 = r108.topMargin;
    L17:
        if (r108 == null) goto L19;
        int r119 = r108.bottomMargin;
    L20:
        int r212 = (r106.getMeasuredWidth() + r109) + r117;
        int r120 = (r106.getMeasuredHeight() + r118) + r119;
        int r213 = Math.max(r103, r120);
        int r214 = r102 + r212;
        if ((r214 + getPaddingRight()) <= r110) goto L28;
        int r121 = r104 + 1;
        if (r121 > this.f416119b) goto L24;
        int r215 = r120;
        int r122 = getPaddingLeft();
        int r216 = r115 + r213;
        r213 = r215;
        boolean r217 = false;
        int r123 = r121;
    L29:
        int r218 = r114;
        a(r105, r110, r122, r216, r109, r118, r117, r119, r212, r215);
        r102 = r122 + r212;
        r105 = r105 + 1;
        r104 = r123;
        r103 = r213;
        r115 = r216;
        r116 = r217;
        r114 = r218;
        goto L3
    L24:
        if (r105 != 0) goto L26;
        a(r105, r110, r102, r115, r109, r118, r117, r119, r212, r120);
        r102 = r214;
    L26:
        r103 = r213;
        goto L30
    L28:
        r215 = r120;
        r216 = r115;
        r217 = r116;
        r123 = r104;
        r122 = r102;
        goto L29
    L19:
        r119 = 0;
        goto L20
    L16:
        r118 = 0;
        goto L17
    L13:
        r117 = 0;
        goto L14
    L10:
        r109 = 0;
        goto L11
    L7:
        r108 = null;
    L30:
        int[] r124 = this.f416121d;
        if (r116 == false) goto L33;
        int r125 = getPaddingRight() + r102;
    L34:
        r124[0] = r125;
        this.f416121d[1] = (r115 + r103) + getPaddingBottom();
        int[] r126 = this.f416121d;
        if (r111 == 1073741824) goto L38;
        r110 = r126[0];
    L38:
        if (r113 == 1073741824) goto L41;
        r112 = r126[1];
    L41:
        setMeasuredDimension(r110, r112);
        return;
    L33:
        r125 = r110;
        goto L34
    }

    public FlowLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f416118a = new LinkedHashMap();
        this.f416119b = Integer.MAX_VALUE;
        this.f416121d = new int[2];
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        int r105 = Math.min(getChildCount(), this.f416118a.size());
        int r106 = 0;
    L3:
        if (r106 >= r105) goto L9;
        View r107 = getChildAt(r106);
        Rect r108 = this.f416118a.get(Integer.valueOf(r106));
        if (r108 == null) goto L8;
        r107.layout(r108.left, r108.top, r108.right, r108.bottom);
    L8:
        r106 = r106 + 1;
        goto L3
    L9:
        this.f416120c = r105;
    }

    public final void a(int r100, int r101, int r102, int r103, int r104, int r105, int r106, int r110, int r111, int r112) {
        Rect r107 = this.f416118a.get(Integer.valueOf(r100));
        if (r107 != null) goto L5;
        r107 = new Rect();
    L5:
        r107.left = r104 + r102;
        r107.top = r105 + r103;
        if (r111 <= r101) goto L8;
        r107.right = r101 - r106;
    L9:
        r107.bottom = (r103 + r112) - r110;
        Integer r108 = Integer.valueOf(r100);
        this.f416118a.put(r108, r107);
        return;
    L8:
        r107.right = (r102 + r111) - r106;
        goto L9
    }
}
