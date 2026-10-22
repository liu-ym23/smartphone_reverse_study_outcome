package com.obric.assistant.interaction.impl.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.MutableLiveData;
import c29.a;
import com.byted.cast.common.CastMonitor;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.larus.common_ui.widget.roundlayout.RoundTextView;
import com.larus.nova.R;
import com.larus.utils.i;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import iea.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import v19.c;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001<B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u001e\u0010!\u001a\u00020\"2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0#2\b\b\u0002\u0010$\u001a\u00020%J\"\u0010&\u001a\u00020\"2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0#2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020%0(J\b\u0010)\u001a\u00020\"H\u0002J0\u0010*\u001a\u00020\"2\u0006\u0010+\u001a\u00020%2\u0006\u0010,\u001a\u00020\u00072\u0006\u0010-\u001a\u00020\u00072\u0006\u0010.\u001a\u00020\u00072\u0006\u0010/\u001a\u00020\u0007H\u0014J\u0018\u00101\u001a\u00020\"2\u0006\u00102\u001a\u00020\u00072\u0006\u00103\u001a\u00020\u0007H\u0014J\u001a\u00108\u001a\u00020\"2\u0012\u00109\u001a\u000e\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u00020705J\u0010\u0010:\u001a\u0002072\u0006\u0010;\u001a\u000206H\u0002R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u001e\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0014\u00100\u001a\b\u0012\u0004\u0012\u00020\u00070\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u00104\u001a\u0010\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u000207\u0018\u000105X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006="}, d2 = {"Lcom/obric/assistant/interaction/impl/view/ObricFlowTagLayout;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "horSpace", "verSpace", "textHorPadding", "textVerPadding", "textSizePx", "", "textViewRadius", "textViewStrokeWidth", "textColor", "textSelectedColor", "textViewStrokeColor", "textViewStrokeSelectColor", "textViewBcgNormalColor", "textViewBcgPressColor", "textViewBcgSelectedColor", "textViewMinHeight", PromotionProductPrivilegesStruct.TAGS, "", "Lcom/obric/assistant/interaction/impl/view/ObricFlowTagLayout$TagBean;", "value", "curSelectedTagBean", "getCurSelectedTagBean", "()Lcom/obric/assistant/interaction/impl/view/ObricFlowTagLayout$TagBean;", "addTags", "", "", "enableClick", "", "addTagsInformSelected", "isSelected", "Landroidx/lifecycle/MutableLiveData;", "updateSelectedStatus", "onLayout", CastMonitor.EVENT_PARAM_BYTECAST_NETWORK_STATE_CHANGED, "left", "top", "right", "bottom", "nextChildIndex", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "providerTagView", "Lkotlin/Function1;", "", "Landroid/widget/TextView;", "setTagViewProvide", ShortVideoSegments.KEY_PROP_PROVIDER, "buildTextView", "text", "TagBean", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricFlowTagLayout extends FrameLayout {
    private TagBean curSelectedTagBean;
    private final int horSpace;
    private final List<Integer> nextChildIndex;
    private Function1<? super String, ? extends TextView> providerTagView;
    private final List<TagBean> tags;
    private final int textColor;
    private final int textHorPadding;
    private final int textSelectedColor;
    private final float textSizePx;
    private final int textVerPadding;
    private final int textViewBcgNormalColor;
    private final int textViewBcgPressColor;
    private final int textViewBcgSelectedColor;
    private final int textViewMinHeight;
    private final int textViewRadius;
    private final int textViewStrokeColor;
    private final int textViewStrokeSelectColor;
    private final int textViewStrokeWidth;
    private final int verSpace;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÆ\u0003J)\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/obric/assistant/interaction/impl/view/ObricFlowTagLayout$TagBean;", "", "txt", "", "tag", "", "extra", "<init>", "(Ljava/lang/String;ILjava/lang/Object;)V", "getTxt", "()Ljava/lang/String;", "getTag", "()I", "getExtra", "()Ljava/lang/Object;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class TagBean {
        private final Object extra;
        private final int tag;
        private final String txt;

        public static /* synthetic */ TagBean copy$default(TagBean r100, String r101, int r102, Object r103, int r104, Object r105) {
            if ((r104 & 1) == 0) goto L6;
            r101 = r100.txt;
        L6:
            if ((r104 & 2) == 0) goto L9;
            r102 = r100.tag;
        L9:
            if ((r104 & 4) == 0) goto L12;
            r103 = r100.extra;
        L12:
            return r100.copy(r101, r102, r103);
        }

        public final String component1() {
            return this.txt;
        }

        public final int component2() {
            return this.tag;
        }

        public final Object component3() {
            return this.extra;
        }

        public final TagBean copy(String r100, int r101, Object r102) {
            Intrinsics.checkNotNullParameter(r100, "txt");
            return new TagBean(r100, r101, r102);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof TagBean) == true) goto L8;
            return false;
        L8:
            TagBean r101 = (TagBean) r100;
            if (Intrinsics.areEqual(this.txt, r101.txt) == true) goto L12;
            return false;
        L12:
            if (this.tag == r101.tag) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.extra, r101.extra) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            int r100 = ((this.txt.hashCode() * 31) + this.tag) * 31;
            Object r101 = this.extra;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return r100 + r102;
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        public String toString() {
            return "TagBean(txt=" + this.txt + ", tag=" + this.tag + ", extra=" + this.extra + ')';
        }

        public final Object getExtra() {
            return this.extra;
        }

        public final int getTag() {
            return this.tag;
        }

        public final String getTxt() {
            return this.txt;
        }

        public TagBean(String r100, int r101, Object r102) {
            Intrinsics.checkNotNullParameter(r100, "txt");
            this.txt = r100;
            this.tag = r101;
            this.extra = r102;
        }

        public /* synthetic */ TagBean(String r100, int r101, Object r102, int r103, DefaultConstructorMarker r104) {
            if ((r103 & 4) == 0) goto L5;
            r102 = null;
        L5:
            this(r100, r101, r102);
        }
    }

    public ObricFlowTagLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null, 0, 6, null);
    }

    public ObricFlowTagLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0, 4, null);
    }

    public static /* synthetic */ void a(ObricFlowTagLayout r100, TagBean r101, MutableLiveData r102, View r103) {
        addTagsInformSelected$lambda$3$lambda$2(r100, r101, r102, r103);
    }

    public static /* synthetic */ void b(ObricFlowTagLayout r100, TagBean r101, View r102) {
        addTags$lambda$1$lambda$0(r100, r101, r102);
    }

    private final void updateSelectedStatus() {
        int r100 = getChildCount();
        int r101 = 0;
    L3:
        if (r101 >= r100) goto L12;
        View r102 = getChildAt(r101);
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type com.larus.common_ui.widget.roundlayout.RoundTextView");
        RoundTextView r103 = (RoundTextView) r102;
        if (r103.getTag() != this.curSelectedTagBean) goto L7;
        boolean r104 = true;
    L8:
        if (r104 == false) goto L10;
        r103.setTextColor(this.textSelectedColor);
        a r105 = r103.getDelegate();
        r105.i(this.textViewStrokeWidth);
        r105.g(this.textViewStrokeSelectColor);
        r105.a(this.textViewBcgSelectedColor);
    L11:
        r101 = r101 + 1;
        goto L3
    L10:
        r103.setTextColor(this.textColor);
        a r106 = r103.getDelegate();
        r106.i(this.textViewStrokeWidth);
        r106.g(this.textViewStrokeColor);
        r106.a(this.textViewBcgNormalColor);
        goto L11
    L7:
        r104 = false;
        goto L8
    }

    public final TagBean getCurSelectedTagBean() {
        return this.curSelectedTagBean;
    }

    private final TextView buildTextView(String r100) {
        Function1<? super String, ? extends TextView> r101 = this.providerTagView;
        if (r101 == null) goto L7;
        TextView r102 = r101.invoke(r100);
        if (r102 == null) goto L7;
        return r102;
    L7:
        RoundTextView r103 = new RoundTextView(getContext());
        r103.setMinHeight(this.textViewMinHeight);
        r103.setTextColor(this.textColor);
        r103.setTextSize(0, this.textSizePx);
        int r104 = this.textHorPadding;
        int r105 = this.textVerPadding;
        r103.setPadding(r104, r105, r104, r105);
        r103.setText(r100);
        r103.setGravity(8388627);
        a r106 = r103.getDelegate();
        r106.j(this.textColor);
        r106.e(this.textViewRadius);
        r106.i(this.textViewStrokeWidth);
        r106.g(this.textViewStrokeColor);
        r106.h(this.textViewStrokeColor);
        r106.a(this.textViewBcgNormalColor);
        r106.b(this.textViewBcgPressColor);
        return r103;
    }

    public final void setTagViewProvide(Function1<? super String, ? extends TextView> r100) {
        Intrinsics.checkNotNullParameter(r100, ShortVideoSegments.KEY_PROP_PROVIDER);
        this.providerTagView = r100;
    }

    public final void addTags(List<TagBean> r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, PromotionProductPrivilegesStruct.TAGS);
        this.tags.clear();
        this.tags.addAll(r100);
        removeAllViews();
        Iterator<T> r102 = this.tags.iterator();
    L4:
        if (r102.hasNext() == false) goto L9;
        final TagBean r103 = (TagBean) r102.next();
        TextView r104 = buildTextView(r103.getTxt());
        r104.setTag(r103);
        if (r101 == false) goto L8;
        r104.setOnClickListener(new b(this, r103));
    L8:
        addView(r104, new FrameLayout.LayoutParams(-2, -2));
        goto L4
    }

    public final void addTagsInformSelected(List<TagBean> r100, final MutableLiveData<Boolean> r101) {
        Intrinsics.checkNotNullParameter(r100, PromotionProductPrivilegesStruct.TAGS);
        Intrinsics.checkNotNullParameter(r101, "isSelected");
        this.tags.clear();
        this.tags.addAll(r100);
        removeAllViews();
        Iterator<T> r102 = this.tags.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        final TagBean r103 = (TagBean) r102.next();
        TextView r104 = buildTextView(r103.getTxt());
        r104.setTag(r103);
        r104.setOnClickListener(new iea.a(this, r103, r101));
        addView(r104, new FrameLayout.LayoutParams(-2, -2));
        goto L4
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int r110, int r111) {
        super.onMeasure(r110, r111);
        this.nextChildIndex.clear();
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
        this.nextChildIndex.add(Integer.valueOf(r100));
        r101 = 0.0f;
    L32:
        r100 = r100 + 1;
        goto L3
    L10:
        if (this.nextChildIndex.isEmpty() == false) goto L12;
    L13:
        this.nextChildIndex.add(Integer.valueOf(r106));
        goto L14
    L12:
        if (((Number) CollectionsKt.last(this.nextChildIndex)).intValue() == r106) goto L14;
    L15:
        int r107 = this.horSpace;
        float r108 = r105;
        if (((r107 + r101) + r108) <= r112) goto L26;
        int r109 = r100 - 1;
        if (r109 >= 0) goto L20;
    L24:
        r101 = r108;
        goto L32
    L20:
        if (this.nextChildIndex.isEmpty() == false) goto L22;
    L23:
        this.nextChildIndex.add(Integer.valueOf(r109));
        goto L24
    L22:
        if (((Number) CollectionsKt.last(this.nextChildIndex)).intValue() == r109) goto L24;
    L26:
        if (r101 == 0.0f) goto L29;
        r102 = false;
    L29:
        if (r102 == true) goto L24;
        r101 = r101 + (r107 + r105);
        goto L32
    L34:
        if ((!this.tags.isEmpty()) == false) goto L40;
        int r114 = CollectionsKt.getLastIndex(this.tags);
        if (this.nextChildIndex.isEmpty() == false) goto L38;
    L39:
        this.nextChildIndex.add(Integer.valueOf(r114));
        goto L40
    L38:
        if (((Number) CollectionsKt.last(this.nextChildIndex)).intValue() != r114) goto L39;
    L40:
        Iterator<T> r115 = this.nextChildIndex.iterator();
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
        r116 = r116 + (this.verSpace + r120.getMeasuredHeight());
        goto L50
    L51:
        setMeasuredDimension(r112, r116);
    }

    public ObricFlowTagLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.horSpace = r100.getResources().getDimensionPixelSize(c.b(R.attr.larus_dp_10, r100, R.dimen.larus_dp_10));
        this.verSpace = r100.getResources().getDimensionPixelSize(c.b(R.attr.larus_dp_8, r100, R.dimen.larus_dp_8));
        this.textHorPadding = r100.getResources().getDimensionPixelSize(c.b(R.attr.larus_dp_14, r100, R.dimen.larus_dp_14));
        this.textVerPadding = r100.getResources().getDimensionPixelSize(c.b(R.attr.larus_dp_9, r100, R.dimen.larus_dp_9));
        this.textViewRadius = r100.getResources().getDimensionPixelSize(c.b(R.attr.larus_dp_12, r100, R.dimen.larus_dp_12));
        this.textViewStrokeWidth = r100.getResources().getDimensionPixelSize(c.b(R.attr.larus_dp_1, r100, R.dimen.larus_dp_1));
        this.textViewMinHeight = r100.getResources().getDimensionPixelSize(c.b(R.attr.larus_dp_36, r100, R.dimen.larus_dp_36));
        this.textSizePx = r100.getResources().getDimensionPixelSize(c.b(R.attr.larus_dp_16, r100, R.dimen.larus_dp_16));
        this.textViewBcgNormalColor = ContextCompat.getColor(r100, c.b(R.attr.larus_base_3_overlay, r100, R.color.larus_base_3_overlay));
        this.textViewBcgPressColor = ContextCompat.getColor(r100, c.b(R.attr.larus_press, r100, R.color.larus_press));
        this.textViewBcgSelectedColor = ContextCompat.getColor(r100, c.b(R.attr.larus_primary_transparent_1, r100, R.color.larus_primary_transparent_1));
        this.textViewStrokeColor = ContextCompat.getColor(r100, c.b(R.attr.larus_neutral_transparent_2, r100, R.color.larus_neutral_transparent_2));
        this.textViewStrokeSelectColor = ContextCompat.getColor(r100, c.b(R.attr.larus_primary_transparent_3, r100, R.color.larus_primary_transparent_3));
        this.textColor = ContextCompat.getColor(r100, c.b(R.attr.larus_neutral_100, r100, R.color.larus_neutral_100));
        this.textSelectedColor = ContextCompat.getColor(r100, c.b(R.attr.larus_primary_50, r100, R.color.larus_primary_50));
        this.tags = new ArrayList();
        this.nextChildIndex = new ArrayList();
    }

    private static final void addTags$lambda$1$lambda$0(ObricFlowTagLayout r100, TagBean r101, View r102) {
        r100.curSelectedTagBean = r101;
        r100.updateSelectedStatus();
    }

    private static final void addTagsInformSelected$lambda$3$lambda$2(ObricFlowTagLayout r100, TagBean r101, MutableLiveData r102, View r103) {
        r100.curSelectedTagBean = r101;
        r100.updateSelectedStatus();
        r102.postValue(Boolean.TRUE);
    }

    public /* synthetic */ ObricFlowTagLayout(Context r100, AttributeSet r101, int r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = 0;
    L8:
        this(r100, r101, r102);
    }

    public static /* synthetic */ void addTags$default(ObricFlowTagLayout r100, List r101, boolean r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L5;
        r102 = true;
    L5:
        r100.addTags(r101, r102);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        int r105 = getChildCount();
        int r106 = 0;
        if (i.h(getContext()) == false) goto L11;
        int r107 = r103 - r101;
        int r108 = r107;
        int r109 = 0;
    L5:
        if (r106 >= r105) goto L18;
        View r110 = getChildAt(r106);
        r110.layout(r108 - r110.getMeasuredWidth(), r109, r108, r110.getMeasuredHeight() + r109);
        if (this.nextChildIndex.contains(Integer.valueOf(r106)) == false) goto L9;
        r109 = r109 + (this.verSpace + r110.getMeasuredHeight());
        r108 = r107;
    L10:
        r106 = r106 + 1;
        goto L5
    L9:
        r108 = (r108 - this.horSpace) - r110.getMeasuredWidth();
        goto L10
    L18:
        return;
    L11:
        int r111 = 0;
        int r112 = 0;
        int r113 = 0;
    L12:
        if (r111 >= r105) goto L25;
        View r114 = getChildAt(r111);
        r114.layout(r112, r113, r114.getMeasuredWidth() + r112, r114.getMeasuredHeight() + r113);
        if (this.nextChildIndex.contains(Integer.valueOf(r111)) == false) goto L16;
        r113 = r113 + (this.verSpace + r114.getMeasuredHeight());
        r112 = 0;
    L17:
        r111 = r111 + 1;
        goto L12
    L16:
        r112 = r112 + (this.horSpace + r114.getMeasuredWidth());
        goto L17
    }
}
