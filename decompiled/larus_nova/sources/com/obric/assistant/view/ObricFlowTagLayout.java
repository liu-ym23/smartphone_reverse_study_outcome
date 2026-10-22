package com.obric.assistant.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.byted.cast.common.CastMonitor;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.larus.common_ui.widget.roundlayout.RoundTextView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001>B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u001e\u0010!\u001a\u00020\"2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0#2\b\b\u0002\u0010$\u001a\u00020%JF\u0010&\u001a\u00020\"2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0#2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020%0(2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u001c2\u0016\b\u0002\u0010*\u001a\u0010\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\"\u0018\u00010+J\b\u0010,\u001a\u00020\"H\u0002J0\u0010-\u001a\u00020\"2\u0006\u0010.\u001a\u00020%2\u0006\u0010/\u001a\u00020\u00072\u0006\u00100\u001a\u00020\u00072\u0006\u00101\u001a\u00020\u00072\u0006\u00102\u001a\u00020\u0007H\u0014J\u0018\u00104\u001a\u00020\"2\u0006\u00105\u001a\u00020\u00072\u0006\u00106\u001a\u00020\u0007H\u0014J\u001a\u0010:\u001a\u00020\"2\u0012\u0010;\u001a\u000e\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u0002090+J\u0010\u0010<\u001a\u0002092\u0006\u0010=\u001a\u000208H\u0002R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u001e\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0014\u00103\u001a\b\u0012\u0004\u0012\u00020\u00070\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u00107\u001a\u0010\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u000209\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006?"}, d2 = {"Lcom/obric/assistant/view/ObricFlowTagLayout;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "horSpace", "verSpace", "textHorPadding", "textVerPadding", "textSizePx", "", "textViewRadius", "textViewStrokeWidth", "textColor", "textSelectedColor", "textViewStrokeColor", "textViewStrokeSelectColor", "textViewBcgNormalColor", "textViewBcgPressColor", "textViewBcgSelectedColor", "textViewMinHeight", PromotionProductPrivilegesStruct.TAGS, "", "Lcom/obric/assistant/view/ObricFlowTagLayout$TagBean;", "value", "curSelectedTagBean", "getCurSelectedTagBean", "()Lcom/obric/assistant/view/ObricFlowTagLayout$TagBean;", "addTags", "", "", "enableClick", "", "addTagsInformSelected", "isSelected", "Landroidx/lifecycle/MutableLiveData;", "defaultSelectedTag", "onSelectedChanged", "Lkotlin/Function1;", "updateSelectedStatus", "onLayout", CastMonitor.EVENT_PARAM_BYTECAST_NETWORK_STATE_CHANGED, "left", "top", "right", "bottom", "nextChildIndex", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "providerTagView", "", "Landroid/widget/TextView;", "setTagViewProvide", ShortVideoSegments.KEY_PROP_PROVIDER, "buildTextView", "text", "TagBean", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricFlowTagLayout extends FrameLayout {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final /* synthetic */ int f393937t = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f393938a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f393939b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f393940c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f393941d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f393942e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f393943f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f393944g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f393945h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f393946i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f393947j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f393948k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f393949l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f393950m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f393951n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f393952o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final List<a> f393953p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public a f393954q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final List<Integer> f393955r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Function1<? super String, ? extends TextView> f393956s;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f393957a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f393958b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Object f393959c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f393957a, r101.f393957a) == true) goto L12;
            return false;
        L12:
            if (this.f393958b == r101.f393958b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f393959c, r101.f393959c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = ((this.f393957a.hashCode() * 31) + this.f393958b) * 31;
            Object r101 = this.f393959c;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return r100 + r102;
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        public final String toString() {
            return "TagBean(txt=" + this.f393957a + ", tag=" + this.f393958b + ", extra=" + this.f393959c + ')';
        }

        public a(String r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "txt");
            this.f393957a = r100;
            this.f393958b = r101;
            this.f393959c = null;
        }
    }

    public ObricFlowTagLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ObricFlowTagLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void a() {
        int r100 = getChildCount();
        int r101 = 0;
    L3:
        if (r101 >= r100) goto L12;
        View r102 = getChildAt(r101);
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type com.larus.common_ui.widget.roundlayout.RoundTextView");
        RoundTextView r103 = (RoundTextView) r102;
        if (r103.getTag() != this.f393954q) goto L7;
        boolean r104 = true;
    L8:
        if (r104 == false) goto L10;
        r103.setTextColor(this.f393946i);
        c29.a r105 = r103.getDelegate();
        r105.i(this.f393944g);
        r105.g(this.f393948k);
        r105.a(this.f393951n);
    L11:
        r101 = r101 + 1;
        goto L3
    L10:
        r103.setTextColor(this.f393945h);
        c29.a r106 = r103.getDelegate();
        r106.i(this.f393944g);
        r106.g(this.f393947j);
        r106.a(this.f393949l);
        goto L11
    L7:
        r104 = false;
        goto L8
    }

    public final a getCurSelectedTagBean() {
        return this.f393954q;
    }

    public final void setTagViewProvide(Function1<? super String, ? extends TextView> r100) {
        Intrinsics.checkNotNullParameter(r100, ShortVideoSegments.KEY_PROP_PROVIDER);
        this.f393956s = r100;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r110, int r111) {
        super.onMeasure(r110, r111);
        ((ArrayList) this.f393955r).clear();
        int r112 = View.MeasureSpec.getSize(r110);
        int r113 = getChildCount();
        int r100 = 0;
        float r101 = 0.0f;
    L3:
        boolean r102 = true;
        if (r100 >= r113) goto L34;
        View r103 = getChildAt(r100);
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type android.widget.TextView");
        TextView r104 = (TextView) r103;
        r104.setMaxWidth(r112);
        r104.measure(View.MeasureSpec.makeMeasureSpec(r112, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(0, 0));
        int r105 = r104.getMeasuredWidth();
        if (r105 < r112) goto L15;
        int r106 = r100 - 1;
        if (r106 >= 0) goto L10;
    L14:
        ((ArrayList) this.f393955r).add(Integer.valueOf(r100));
        r101 = 0.0f;
    L32:
        r100 = r100 + 1;
        goto L3
    L10:
        if (((ArrayList) this.f393955r).isEmpty() == false) goto L12;
    L13:
        ((ArrayList) this.f393955r).add(Integer.valueOf(r106));
        goto L14
    L12:
        if (((Number) CollectionsKt.last(this.f393955r)).intValue() == r106) goto L14;
    L15:
        int r107 = this.f393938a;
        float r108 = r105;
        if (((r107 + r101) + r108) <= r112) goto L26;
        int r109 = r100 - 1;
        if (r109 >= 0) goto L20;
    L24:
        r101 = r108;
        goto L32
    L20:
        if (((ArrayList) this.f393955r).isEmpty() == false) goto L22;
    L23:
        ((ArrayList) this.f393955r).add(Integer.valueOf(r109));
        goto L24
    L22:
        if (((Number) CollectionsKt.last(this.f393955r)).intValue() == r109) goto L24;
    L26:
        if (r101 == 0.0f) goto L29;
        r102 = false;
    L29:
        if (r102 == true) goto L24;
        r101 = r101 + (r107 + r105);
        goto L32
    L34:
        if ((!this.f393953p.isEmpty()) == false) goto L40;
        int r114 = CollectionsKt.getLastIndex(this.f393953p);
        if (((ArrayList) this.f393955r).isEmpty() == false) goto L38;
    L39:
        ((ArrayList) this.f393955r).add(Integer.valueOf(r114));
        goto L40
    L38:
        if (((Number) CollectionsKt.last(this.f393955r)).intValue() != r114) goto L39;
    L40:
        Iterator<T> r115 = this.f393955r.iterator();
        int r116 = 0;
        int r117 = 0;
    L42:
        if (r115.hasNext() == false) goto L51;
        Object r118 = r115.next();
        int r119 = r117 + 1;
        if (r117 >= 0) goto L46;
        CollectionsKt.throwIndexOverflow();
    L46:
        View r120 = getChildAt(((Number) r118).intValue());
        if (r102 == false) goto L49;
        r116 = r120.getMeasuredHeight();
    L50:
        r117 = r119;
        r102 = false;
        goto L42
    L49:
        r116 = r116 + (this.f393939b + r120.getMeasuredHeight());
        goto L50
    L51:
        setMeasuredDimension(r112, r116);
    }

    public ObricFlowTagLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f393938a = r100.getResources().getDimensionPixelSize(v19.c.b(R.attr.larus_dp_10, r100, R.dimen.larus_dp_10));
        this.f393939b = r100.getResources().getDimensionPixelSize(v19.c.b(R.attr.larus_dp_8, r100, R.dimen.larus_dp_8));
        this.f393940c = r100.getResources().getDimensionPixelSize(v19.c.b(R.attr.larus_dp_14, r100, R.dimen.larus_dp_14));
        this.f393941d = r100.getResources().getDimensionPixelSize(v19.c.b(R.attr.larus_dp_9, r100, R.dimen.larus_dp_9));
        this.f393943f = r100.getResources().getDimensionPixelSize(v19.c.b(R.attr.larus_dp_12, r100, R.dimen.larus_dp_12));
        this.f393944g = r100.getResources().getDimensionPixelSize(v19.c.b(R.attr.larus_dp_1, r100, R.dimen.larus_dp_1));
        this.f393952o = r100.getResources().getDimensionPixelSize(v19.c.b(R.attr.larus_dp_36, r100, R.dimen.larus_dp_36));
        this.f393942e = r100.getResources().getDimensionPixelSize(v19.c.b(R.attr.larus_dp_16, r100, R.dimen.larus_dp_16));
        this.f393949l = ContextCompat.getColor(r100, v19.c.b(R.attr.larus_base_3_overlay, r100, R.color.larus_base_3_overlay));
        this.f393950m = ContextCompat.getColor(r100, v19.c.b(R.attr.larus_press, r100, R.color.larus_press));
        this.f393951n = ContextCompat.getColor(r100, v19.c.b(R.attr.larus_primary_transparent_1, r100, R.color.larus_primary_transparent_1));
        this.f393947j = ContextCompat.getColor(r100, v19.c.b(R.attr.larus_neutral_transparent_2, r100, R.color.larus_neutral_transparent_2));
        this.f393948k = ContextCompat.getColor(r100, v19.c.b(R.attr.larus_primary_transparent_3, r100, R.color.larus_primary_transparent_3));
        this.f393945h = ContextCompat.getColor(r100, v19.c.b(R.attr.larus_neutral_100, r100, R.color.larus_neutral_100));
        this.f393946i = ContextCompat.getColor(r100, v19.c.b(R.attr.larus_primary_50, r100, R.color.larus_primary_50));
        this.f393953p = new ArrayList();
        this.f393955r = new ArrayList();
    }

    public /* synthetic */ ObricFlowTagLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        int r105 = getChildCount();
        int r106 = 0;
        if (com.larus.utils.i.h(getContext()) == false) goto L11;
        int r107 = r103 - r101;
        int r108 = r107;
        int r109 = 0;
    L5:
        if (r106 >= r105) goto L18;
        View r110 = getChildAt(r106);
        r110.layout(r108 - r110.getMeasuredWidth(), r109, r108, r110.getMeasuredHeight() + r109);
        List<Integer> r111 = this.f393955r;
        ArrayList r112 = (ArrayList) r111;
        if (r112.contains(Integer.valueOf(r106)) == false) goto L9;
        r109 = r109 + (this.f393939b + r110.getMeasuredHeight());
        r108 = r107;
    L10:
        r106 = r106 + 1;
        goto L5
    L9:
        r108 = (r108 - this.f393938a) - r110.getMeasuredWidth();
        goto L10
    L18:
        return;
    L11:
        int r113 = 0;
        int r114 = 0;
        int r115 = 0;
    L12:
        if (r113 >= r105) goto L25;
        View r116 = getChildAt(r113);
        r116.layout(r114, r115, r116.getMeasuredWidth() + r114, r116.getMeasuredHeight() + r115);
        List<Integer> r117 = this.f393955r;
        ArrayList r118 = (ArrayList) r117;
        if (r118.contains(Integer.valueOf(r113)) == false) goto L16;
        r115 = r115 + (this.f393939b + r116.getMeasuredHeight());
        r114 = 0;
    L17:
        r113 = r113 + 1;
        goto L12
    L16:
        r114 = r114 + (this.f393938a + r116.getMeasuredWidth());
        goto L17
    }
}
