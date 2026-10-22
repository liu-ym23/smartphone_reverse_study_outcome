package com.ss.android.lark.emoji_office;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.byted.cast.common.CastMonitor;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.lynx.tasm.LynxTemplateRender;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import q2c.c;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 :2\u00020\u0001:\u0002:;B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010'\u001a\u00020\u00002\u0006\u0010#\u001a\u00020$H\u0007J\u0010\u0010(\u001a\u00020\u00002\b\u0010)\u001a\u0004\u0018\u00010&J\u0016\u0010*\u001a\u00020\u00002\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0+H\u0007J\b\u0010,\u001a\u00020-H\u0002J\u0010\u0010.\u001a\u00020-2\u0006\u0010/\u001a\u00020\u0007H\u0002J\u0018\u00100\u001a\u00020-2\u0006\u00101\u001a\u00020\u00072\u0006\u00102\u001a\u00020\u0007H\u0014J0\u00103\u001a\u00020-2\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\u00072\u0006\u00107\u001a\u00020\u00072\u0006\u00108\u001a\u00020\u00072\u0006\u00109\u001a\u00020\u0007H\u0014R!\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR'\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u000b0\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0010\u001a\u0004\b\u0013\u0010\u000eR!\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00070\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0010\u001a\u0004\b\u0016\u0010\u000eR\u001b\u0010\u0018\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0010\u001a\u0004\b\u0019\u0010\u001aR\u001b\u0010\u001c\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0010\u001a\u0004\b\u001d\u0010\u001aR!\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u0010\u001a\u0004\b!\u0010\u000eR\u000e\u0010#\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006<"}, d2 = {"Lcom/ss/android/lark/emoji_office/OfficeReactionView;", "Landroid/view/ViewGroup;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "itemViewPool", "", "Lcom/ss/android/lark/emoji_office/OfficeReactionItemView;", "getItemViewPool", "()Ljava/util/List;", "itemViewPool$delegate", "Lkotlin/Lazy;", "lineViews", "Landroid/view/View;", "getLineViews", "lineViews$delegate", "lineWidths", "getLineWidths", "lineWidths$delegate", "itemHeight", "getItemHeight", "()I", "itemHeight$delegate", "itemSpacing", "getItemSpacing", "itemSpacing$delegate", "dataList", "Lcom/ss/android/lark/reaction/widget/flowlayout/bean/ReactionFlowLayoutViewModel;", "getDataList", "dataList$delegate", "align", "Lcom/ss/android/lark/emoji_office/OfficeReactionView$Align;", "onReactionClickListener", "Lcom/ss/android/lark/emoji_office/OnReactionClickListener;", "setAlign", "setOnReactionClickListener", "listener", LynxTemplateRender.RENDER_PHASE_SETUP, "", "buildViews", "", "ensureItemViews", "requiredCount", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onLayout", CastMonitor.EVENT_PARAM_BYTECAST_NETWORK_STATE_CHANGED, "", "l", "t", "r", "b", "Companion", "Align", "lark-emoji-office_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeReactionView extends ViewGroup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f420633a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f420634b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f420635c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f420636d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f420637e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f420638f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Align f420639g;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/emoji_office/OfficeReactionView$Align;", "", "<init>", "(Ljava/lang/String;I)V", "LEFT", "RIGHT", "lark-emoji-office_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Align extends Enum<Align> {
        public static final Align LEFT = null;
        public static final Align RIGHT = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Align[] f420640a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f420641b = null;

        public static EnumEntries<Align> getEntries() {
            return f420641b;
        }

        static {
            Align r100 = new Align("LEFT", 0);
            LEFT = r100;
            Align r101 = new Align("RIGHT", 1);
            RIGHT = r101;
            Align[] r102 = {r100, r101};
            f420640a = r102;
            f420641b = EnumEntriesKt.enumEntries(r102);
        }

        public static Align[] values() {
            return (Align[]) f420640a.clone();
        }

        public static Align valueOf(String r100) {
            return (Align) r27.a.a(Align.class, r100);
        }

        public Align(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
    }

    static {
    }

    public OfficeReactionView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public OfficeReactionView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    private final List<c> getDataList() {
        return (List) this.f420638f.getValue();
    }

    private final int getItemHeight() {
        return ((Number) this.f420636d.getValue()).intValue();
    }

    private final int getItemSpacing() {
        return ((Number) this.f420637e.getValue()).intValue();
    }

    private final List<OfficeReactionItemView> getItemViewPool() {
        return (List) this.f420633a.getValue();
    }

    private final List<List<View>> getLineViews() {
        return (List) this.f420634b.getValue();
    }

    private final List<Integer> getLineWidths() {
        return (List) this.f420635c.getValue();
    }

    @Override // android.view.View
    public final void onMeasure(int r110, int r111) {
        getLineViews().clear();
        getLineWidths().clear();
        int r100 = View.MeasureSpec.getSize(r110);
        if (View.MeasureSpec.getMode(r110) != 0) goto L5;
        r100 = Integer.MAX_VALUE;
    L5:
        ArrayList r101 = new ArrayList();
        int r102 = getChildCount();
        int r103 = 0;
        int r104 = 0;
        int r105 = 0;
        int r106 = 0;
    L6:
        if (r104 >= r102) goto L20;
        View r107 = getChildAt(r104);
        measureChild(r107, r110, r111);
        int r108 = r107.getMeasuredWidth();
        if (((getItemSpacing() + r105) + r108) <= r100) goto L16;
        if ((!r101.isEmpty()) == false) goto L16;
        getLineViews().add(r101);
        getLineWidths().add(Integer.valueOf(r105));
        if (r106 <= 0) goto L14;
        r106 = r106 + getItemSpacing();
    L14:
        r106 = r106 + getItemHeight();
        r101 = new ArrayList();
        r105 = 0;
    L16:
        if ((!r101.isEmpty()) == false) goto L18;
        r105 = r105 + getItemSpacing();
    L18:
        r105 = r105 + r108;
        r101.add(r107);
        r104 = r104 + 1;
        goto L6
    L20:
        if ((!r101.isEmpty()) == false) goto L25;
        getLineViews().add(r101);
        getLineWidths().add(Integer.valueOf(r105));
        if (r106 <= 0) goto L24;
        r106 = r106 + getItemSpacing();
    L24:
        r106 = r106 + getItemHeight();
    L25:
        Integer r109 = (Integer) CollectionsKt.maxOrNull(getLineWidths());
        if (r109 == null) goto L28;
        r103 = r109.intValue();
    L28:
        setMeasuredDimension(ViewGroup.resolveSize(r103, r110), ViewGroup.resolveSize(r106, r111));
    }

    public OfficeReactionView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f420633a = LazyKt.lazy(OfficeReactionView$itemViewPool$2.INSTANCE);
        this.f420634b = LazyKt.lazy(OfficeReactionView$lineViews$2.INSTANCE);
        this.f420635c = LazyKt.lazy(OfficeReactionView$lineWidths$2.INSTANCE);
        this.f420636d = LazyKt.lazy(OfficeReactionView$itemHeight$2.INSTANCE);
        this.f420637e = LazyKt.lazy(OfficeReactionView$itemSpacing$2.INSTANCE);
        this.f420638f = LazyKt.lazy(OfficeReactionView$dataList$2.INSTANCE);
        this.f420639g = Align.LEFT;
    }

    public /* synthetic */ OfficeReactionView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r110) {
        int r104 = getPaddingTop();
        int r105 = getLineViews().size();
        int r106 = 0;
    L3:
        if (r106 >= r105) goto L13;
        List r111 = (List) ListProtector.get(getLineViews(), r106);
        int r107 = ((Number) ListProtector.get(getLineWidths(), r106)).intValue();
        if (this.f420639g != Align.RIGHT) goto L7;
        int r108 = getWidth() - r107;
    L8:
        Iterator r112 = r111.iterator();
    L10:
        if (r112.hasNext() == false) goto L12;
        View r109 = (View) r112.next();
        int r113 = r109.getMeasuredWidth();
        r109.layout(r108, r104, r108 + r113, getItemHeight() + r104);
        r108 = r108 + (r113 + getItemSpacing());
        goto L10
    L12:
        r104 = r104 + (getItemHeight() + getItemSpacing());
        r106 = r106 + 1;
        goto L3
    L7:
        r108 = 0;
        goto L8
    }
}
