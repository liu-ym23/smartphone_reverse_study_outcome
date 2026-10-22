package com.larus.feedback.api.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.byted.cast.common.CastMonitor;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.larus.bmhome.auth.FeedbackMeta;
import com.larus.common_ui.widget.roundlayout.RoundTextView;
import com.larus.nova.R;
import com.larus.utils.i;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0017\u0018\u0000 M2\u00020\u0001:\u0003KLMB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020&J\u001e\u0010.\u001a\u00020,2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0/2\b\b\u0002\u00100\u001a\u000201J\"\u00102\u001a\u00020,2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0/2\f\u00103\u001a\b\u0012\u0004\u0012\u00020104J\u0014\u00105\u001a\u00020,2\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u001c07J\u0006\u00108\u001a\u00020,J\f\u00109\u001a\b\u0012\u0004\u0012\u00020\u001c0/J\u001a\u0010:\u001a\u00020,2\u0012\u0010;\u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020*0(J0\u0010<\u001a\u00020,2\u0006\u0010=\u001a\u0002012\u0006\u0010>\u001a\u00020\u00072\u0006\u0010?\u001a\u00020\u00072\u0006\u0010@\u001a\u00020\u00072\u0006\u0010A\u001a\u00020\u0007H\u0014J\u0018\u0010B\u001a\u00020,2\u0006\u0010C\u001a\u00020\u00072\u0006\u0010D\u001a\u00020\u0007H\u0014J\u0010\u0010E\u001a\u00020,2\u0006\u0010F\u001a\u00020\u001cH\u0002J\b\u0010G\u001a\u00020,H\u0002J\b\u0010H\u001a\u00020,H\u0002J\u0010\u0010I\u001a\u00020*2\u0006\u0010J\u001a\u00020)H\u0002R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u001c0\u001ej\b\u0012\u0004\u0012\u00020\u001c`\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00070\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\"\u001a\u0004\u0018\u00010\u001c2\b\u0010!\u001a\u0004\u0018\u00010\u001c@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u000e\u0010%\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010'\u001a\u0010\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020*\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006N"}, d2 = {"Lcom/larus/feedback/api/view/FlowTagLayout;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "horSpace", "verSpace", "textHorPadding", "textVerPadding", "textSizePx", "", "textViewRadius", "textViewStrokeWidth", "textViewMinHeight", "textViewBcgNormalColor", "textViewBcgPressColor", "textViewBcgSelectedColor", "textViewStrokeColor", "textViewStrokeSelectColor", "textColor", "textSelectedColor", PromotionProductPrivilegesStruct.TAGS, "", "Lcom/larus/feedback/api/view/FlowTagLayout$TagBean;", "selectedTagSet", "Ljava/util/LinkedHashSet;", "Lkotlin/collections/LinkedHashSet;", "nextChildIndex", "value", "curSelectedTagBean", "getCurSelectedTagBean", "()Lcom/larus/feedback/api/view/FlowTagLayout$TagBean;", "selectionMode", "Lcom/larus/feedback/api/view/FlowTagLayout$SelectionMode;", "providerTagView", "Lkotlin/Function1;", "", "Landroid/widget/TextView;", "setSelectionMode", "", "mode", "addTags", "", "enableClick", "", "addTagsInformSelected", "isSelected", "Landroidx/lifecycle/MutableLiveData;", "setSelectedTags", "selectedTags", "", "clearSelection", "getSelectedTagBeans", "setTagViewProvide", ShortVideoSegments.KEY_PROP_PROVIDER, "onLayout", CastMonitor.EVENT_PARAM_BYTECAST_NETWORK_STATE_CHANGED, "left", "top", "right", "bottom", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onTagClicked", "tagBean", "syncSelectionState", "updateSelectedStatus", "buildTextView", "text", "SelectionMode", "TagBean", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FlowTagLayout extends FrameLayout {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final /* synthetic */ int f343035v = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f343036a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f343037b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f343038c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f343039d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f343040e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f343041f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f343042g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f343043h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f343044i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f343045j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f343046k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f343047l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f343048m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f343049n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f343050o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final List<b> f343051p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final LinkedHashSet<b> f343052q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final List<Integer> f343053r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public b f343054s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public SelectionMode f343055t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Function1<? super String, ? extends TextView> f343056u;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/feedback/api/view/FlowTagLayout$SelectionMode;", "", "<init>", "(Ljava/lang/String;I)V", "SINGLE", "MULTI", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum SelectionMode extends Enum<SelectionMode> {
        public static final SelectionMode MULTI = null;
        public static final SelectionMode SINGLE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ SelectionMode[] f343057a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f343058b = null;

        public static EnumEntries<SelectionMode> getEntries() {
            return f343058b;
        }

        static {
            SelectionMode r100 = new SelectionMode("SINGLE", 0);
            SINGLE = r100;
            SelectionMode r101 = new SelectionMode("MULTI", 1);
            MULTI = r101;
            SelectionMode[] r102 = {r100, r101};
            f343057a = r102;
            f343058b = EnumEntriesKt.enumEntries(r102);
        }

        public static SelectionMode[] values() {
            return (SelectionMode[]) f343057a.clone();
        }

        public static SelectionMode valueOf(String r100) {
            return (SelectionMode) r27.a.a(SelectionMode.class, r100);
        }

        public SelectionMode(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
        public static int a(int r100, Context r101) {
            Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
            Resources r102 = r101.getResources();
            return (int) TypedValue.applyDimension(1, r100, WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()));
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f343059a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f343060b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Object f343061c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f343059a, r101.f343059a) == true) goto L12;
            return false;
        L12:
            if (this.f343060b == r101.f343060b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f343061c, r101.f343061c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = ((this.f343059a.hashCode() * 31) + this.f343060b) * 31;
            Object r101 = this.f343061c;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return r100 + r102;
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        public final String toString() {
            return "TagBean(txt=" + this.f343059a + ", tag=" + this.f343060b + ", extra=" + this.f343061c + ')';
        }

        public b(String r100, int r101, FeedbackMeta r102) {
            Intrinsics.checkNotNullParameter(r100, "txt");
            this.f343059a = r100;
            this.f343060b = r101;
            this.f343061c = r102;
        }
    }

    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f343062a = null;

        static {
            int[] r100 = new int[SelectionMode.values().length];
            r100[SelectionMode.SINGLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[SelectionMode.MULTI.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f343062a = r100;
        }
    }

    static {
    }

    public FlowTagLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public FlowTagLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void a() {
        if (this.f343055t != SelectionMode.SINGLE) goto L17;
        b r100 = (b) CollectionsKt.lastOrNull(this.f343052q);
        if (r100 != null) goto L7;
        r100 = this.f343054s;
    L7:
        this.f343052q.clear();
        if (r100 != null) goto L10;
    L12:
        r100 = null;
    L13:
        this.f343054s = r100;
        if (r100 == null) goto L19;
        this.f343052q.add(r100);
        return;
    L19:
        return;
    L10:
        if (((ArrayList) this.f343051p).contains(r100) == false) goto L12;
    L17:
        this.f343052q.retainAll(CollectionsKt.toSet(this.f343051p));
        this.f343054s = (b) CollectionsKt.lastOrNull(this.f343052q);
    }

    public final List<b> getSelectedTagBeans() {
        return CollectionsKt.toList(this.f343052q);
    }

    public final void b() {
        int r100 = getChildCount();
        int r101 = 0;
    L3:
        if (r101 >= r100) goto L17;
        View r102 = getChildAt(r101);
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type com.larus.common_ui.widget.roundlayout.RoundTextView");
        RoundTextView r103 = (RoundTextView) r102;
        Object r104 = r103.getTag();
        if ((r104 instanceof b) == false) goto L7;
        b r105 = (b) r104;
    L8:
        if (r105 != null) goto L10;
    L12:
        boolean r106 = false;
    L13:
        if (r106 == false) goto L15;
        r103.setTextColor(this.f343050o);
        c29.a r107 = r103.getDelegate();
        r107.i(this.f343042g);
        r107.g(this.f343048m);
        r107.a(this.f343046k);
    L16:
        r101 = r101 + 1;
        goto L3
    L15:
        r103.setTextColor(this.f343049n);
        c29.a r108 = r103.getDelegate();
        r108.i(this.f343042g);
        r108.g(this.f343047l);
        r108.a(this.f343044i);
        goto L16
    L10:
        if (this.f343052q.contains(r105) == false) goto L12;
        r106 = true;
        goto L13
    L7:
        r105 = null;
        goto L8
    }

    public final b getCurSelectedTagBean() {
        return this.f343054s;
    }

    public final void setSelectedTags(Collection<b> r100) {
        Intrinsics.checkNotNullParameter(r100, "selectedTags");
        this.f343052q.clear();
        SelectionMode r101 = this.f343055t;
        int r102 = c.f343062a[r101.ordinal()];
        if (r102 != 1) goto L5;
        b r103 = (b) CollectionsKt.lastOrNull(r100);
        this.f343054s = r103;
        if (r103 == null) goto L18;
        this.f343052q.add(r103);
    L18:
        b();
        return;
    L5:
        if (r102 != 2) goto L14;
        Iterator<T> r104 = r100.iterator();
    L8:
        if (r104.hasNext() == false) goto L12;
        b r105 = (b) r104.next();
        if (((ArrayList) this.f343051p).contains(r105) == false) goto L8;
        this.f343052q.add(r105);
        goto L8
    L12:
        this.f343054s = (b) CollectionsKt.lastOrNull(this.f343052q);
        goto L18
    L14:
        throw new NoWhenBranchMatchedException();
    }

    public final void setSelectionMode(SelectionMode r100) {
        Intrinsics.checkNotNullParameter(r100, "mode");
        this.f343055t = r100;
        a();
        b();
    }

    public final void setTagViewProvide(Function1<? super String, ? extends TextView> r100) {
        Intrinsics.checkNotNullParameter(r100, ShortVideoSegments.KEY_PROP_PROVIDER);
        this.f343056u = r100;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r110, int r111) {
        super.onMeasure(r110, r111);
        ((ArrayList) this.f343053r).clear();
        int r112 = View.MeasureSpec.getSize(r110);
        int r113 = getChildCount();
        int r100 = 0;
        int r101 = 0;
        float r102 = 0.0f;
    L3:
        boolean r103 = true;
        if (r101 >= r113) goto L34;
        View r104 = getChildAt(r101);
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type android.widget.TextView");
        TextView r105 = (TextView) r104;
        r105.setMaxWidth(r112);
        r105.measure(View.MeasureSpec.makeMeasureSpec(r112, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(0, 0));
        int r106 = r105.getMeasuredWidth();
        if (r106 < r112) goto L15;
        int r107 = r101 - 1;
        if (r107 >= 0) goto L10;
    L14:
        ((ArrayList) this.f343053r).add(Integer.valueOf(r101));
        r102 = 0.0f;
    L32:
        r101 = r101 + 1;
        goto L3
    L10:
        if (((ArrayList) this.f343053r).isEmpty() == false) goto L12;
    L13:
        ((ArrayList) this.f343053r).add(Integer.valueOf(r107));
        goto L14
    L12:
        if (((Number) CollectionsKt.last(this.f343053r)).intValue() == r107) goto L14;
    L15:
        int r108 = this.f343036a;
        float r109 = r106;
        if (((r108 + r102) + r109) <= r112) goto L26;
        int r114 = r101 - 1;
        if (r114 >= 0) goto L20;
    L24:
        r102 = r109;
        goto L32
    L20:
        if (((ArrayList) this.f343053r).isEmpty() == false) goto L22;
    L23:
        ((ArrayList) this.f343053r).add(Integer.valueOf(r114));
        goto L24
    L22:
        if (((Number) CollectionsKt.last(this.f343053r)).intValue() == r114) goto L24;
    L26:
        if (r102 == 0.0f) goto L29;
        r103 = false;
    L29:
        if (r103 == true) goto L24;
        r109 = r109 + (r102 + r108);
        goto L24
    L34:
        if ((!this.f343051p.isEmpty()) == false) goto L40;
        int r115 = CollectionsKt.getLastIndex(this.f343051p);
        if (((ArrayList) this.f343053r).isEmpty() == false) goto L38;
    L39:
        ((ArrayList) this.f343053r).add(Integer.valueOf(r115));
        goto L40
    L38:
        if (((Number) CollectionsKt.last(this.f343053r)).intValue() != r115) goto L39;
    L40:
        Iterator<T> r116 = this.f343053r.iterator();
        int r117 = 0;
    L42:
        if (r116.hasNext() == false) goto L51;
        Object r118 = r116.next();
        int r119 = r117 + 1;
        if (r117 >= 0) goto L46;
        CollectionsKt.throwIndexOverflow();
    L46:
        View r120 = getChildAt(((Number) r118).intValue());
        if (r117 != 0) goto L49;
        int r121 = r120.getMeasuredHeight();
    L50:
        r100 = r100 + r121;
        r117 = r119;
        goto L42
    L49:
        r121 = this.f343037b + r120.getMeasuredHeight();
        goto L50
    L51:
        setMeasuredDimension(r112, r100);
    }

    public FlowTagLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f343036a = a.a(10, r100);
        this.f343037b = a.a(8, r100);
        this.f343038c = a.a(14, r100);
        this.f343039d = a.a(9, r100);
        this.f343040e = a.a(16, r100);
        this.f343041f = a.a(12, r100);
        this.f343042g = a.a(1, r100);
        this.f343043h = a.a(36, r100);
        this.f343044i = ContextCompat.getColor(r100, v19.c.b(R.attr.larus_base_3_overlay, r100, R.color.larus_base_3_overlay));
        this.f343045j = ContextCompat.getColor(r100, v19.c.b(R.attr.larus_press, r100, R.color.larus_press));
        this.f343046k = ContextCompat.getColor(r100, v19.c.b(R.attr.larus_primary_transparent_1, r100, R.color.larus_primary_transparent_1));
        this.f343047l = ContextCompat.getColor(r100, v19.c.b(R.attr.larus_neutral_transparent_2, r100, R.color.larus_neutral_transparent_2));
        this.f343048m = ContextCompat.getColor(r100, v19.c.b(R.attr.larus_primary_transparent_3, r100, R.color.larus_primary_transparent_3));
        this.f343049n = ContextCompat.getColor(r100, v19.c.b(R.attr.larus_neutral_100, r100, R.color.larus_neutral_100));
        this.f343050o = ContextCompat.getColor(r100, v19.c.b(R.attr.larus_primary_50, r100, R.color.larus_primary_50));
        this.f343051p = new ArrayList();
        this.f343052q = new LinkedHashSet();
        this.f343053r = new ArrayList();
        this.f343055t = SelectionMode.SINGLE;
    }

    public /* synthetic */ FlowTagLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        int r105 = getChildCount();
        int r106 = 0;
        if (i.h(getContext()) == false) goto L12;
        int r107 = r103 - r101;
        int r108 = r107;
        int r109 = 0;
    L5:
        if (r106 >= r105) goto L11;
        View r110 = getChildAt(r106);
        r110.layout(r108 - r110.getMeasuredWidth(), r109, r108, r110.getMeasuredHeight() + r109);
        List<Integer> r111 = this.f343053r;
        ArrayList r112 = (ArrayList) r111;
        if (r112.contains(Integer.valueOf(r106)) == false) goto L9;
        r109 = r109 + (this.f343037b + r110.getMeasuredHeight());
        r108 = r107;
    L10:
        r106 = r106 + 1;
        goto L5
    L9:
        r108 = (r108 - this.f343036a) - r110.getMeasuredWidth();
        goto L10
    L11:
        return;
    L12:
        int r113 = 0;
        int r114 = 0;
        int r115 = 0;
    L13:
        if (r113 >= r105) goto L19;
        View r116 = getChildAt(r113);
        r116.layout(r114, r115, r116.getMeasuredWidth() + r114, r116.getMeasuredHeight() + r115);
        List<Integer> r117 = this.f343053r;
        ArrayList r118 = (ArrayList) r117;
        if (r118.contains(Integer.valueOf(r113)) == false) goto L17;
        r115 = r115 + (this.f343037b + r116.getMeasuredHeight());
        r114 = 0;
    L18:
        r113 = r113 + 1;
        goto L13
    L17:
        r114 = r114 + (this.f343036a + r116.getMeasuredWidth());
        goto L18
    }
}
