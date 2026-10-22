package com.larus.avlink.aiproactive.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.byted.cast.common.CastMonitor;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import t88.b;
import t88.o;
import v19.c;

/* JADX INFO: loaded from: classes23.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u00010B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\rJ\b\u0010\u001c\u001a\u0004\u0018\u00010\rJ\u0010\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0010\u0010 \u001a\u00020\u00112\u0006\u0010!\u001a\u00020\"H\u0002J\u0018\u0010#\u001a\u00020\u001a2\u0006\u0010$\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u0007H\u0014J0\u0010&\u001a\u00020\u001a2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\u00072\u0006\u0010,\u001a\u00020\u0007H\u0014J\u0010\u0010-\u001a\u00020\u00072\u0006\u0010.\u001a\u00020/H\u0002R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u00061"}, d2 = {"Lcom/larus/avlink/aiproactive/widget/AiProactiveTaskSlotLayout;", "Landroid/view/ViewGroup;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "lineSpacing", "horizontalSpacing", "currentDraft", "Lcom/larus/avlink/aiproactive/model/UserAonTaskDraft;", "allLines", "", "", "Landroid/view/View;", "lineHeights", "listener", "Lcom/larus/avlink/aiproactive/widget/AiProactiveTaskSlotLayout$Listener;", "getListener", "()Lcom/larus/avlink/aiproactive/widget/AiProactiveTaskSlotLayout$Listener;", "setListener", "(Lcom/larus/avlink/aiproactive/widget/AiProactiveTaskSlotLayout$Listener;)V", "setData", "", "draft", "getCurrentDraft", "createPlainCharView", "ch", "", "createSelectorSlotView", "slot", "Lcom/larus/avlink/aiproactive/model/AonTaskDescriptionSlot;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onLayout", CastMonitor.EVENT_PARAM_BYTECAST_NETWORK_STATE_CHANGED, "", "l", "t", "r", "b", "dp2px", "dpValue", "", "Listener", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AiProactiveTaskSlotLayout extends ViewGroup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f291614a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f291615b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public o f291616c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<List<View>> f291617d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<Integer> f291618e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public a f291619f;

    public interface a {
        void a(b r100, View r101);
    }

    public AiProactiveTaskSlotLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public AiProactiveTaskSlotLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final o getCurrentDraft() {
        return this.f291616c;
    }

    public final a getListener() {
        return this.f291619f;
    }

    public final View a(String r100) {
        TextView r101 = new TextView(getContext());
        r101.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        r101.setText(r100);
        r101.setTextColor(c.a(R.attr.larus_neutral_100, r101.getContext(), R.color.larus_neutral_100));
        r101.setTextSize(14.0f);
        r101.setIncludeFontPadding(false);
        return r101;
    }

    public final int b(float r100) {
        Resources r101 = getContext().getResources();
        return (int) TypedValue.applyDimension(1, r100, WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()));
    }

    public final void setData(o r110) {
        this.f291616c = r110;
        removeAllViews();
        if (r110 == null) goto L7;
        List<b> r111 = r110.b();
        if (r111 == null) goto L7;
        List r112 = CollectionsKt.filterNotNull(r111);
    L8:
        if (r112 != null) goto L10;
        r112 = CollectionsKt.emptyList();
    L10:
        Iterator r113 = r112.iterator();
    L12:
        if (r113.hasNext() == false) goto L43;
        final b r100 = (b) r113.next();
        Integer r101 = r100.e();
        int r102 = 0;
        if (r101 == null) goto L16;
        int r103 = r101.intValue();
    L17:
        String r104 = "";
        if (r103 != 0) goto L20;
        String r105 = r100.d();
        if (r105 == null) goto L40;
        r104 = r105;
    L40:
        int r106 = r104.length();
    L41:
        if (r102 >= r106) goto L12;
        addView(a(String.valueOf(r104.charAt(r102))));
        r102 = r102 + 1;
        goto L41
    L20:
        if (r103 != 2) goto L21;
        final LinearLayout r107 = new LinearLayout(getContext());
        r107.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        r107.setOrientation(0);
        r107.setGravity(16);
        r107.setBackgroundResource(R.drawable.larus_bg_ai_proactive_slot_box);
        r107.setPadding(b(14.0f), b(8.0f), b(14.0f), b(8.0f));
        TextView r108 = new TextView(getContext());
        String r109 = r100.d();
        if (r109 != null) goto L35;
        List<String> r114 = r100.c();
        if (r114 == null) goto L34;
        r109 = (String) CollectionsKt.firstOrNull(r114);
        goto L35
    L34:
        r109 = null;
    L35:
        r108.setText(r109);
        r108.setTextColor(c.a(R.attr.larus_neutral_100, r108.getContext(), R.color.larus_neutral_100));
        r108.setTextSize(14.0f);
        r108.setIncludeFontPadding(false);
        ImageView r115 = new ImageView(getContext());
        r115.setImageResource(R.drawable.icon_more_small_si);
        LinearLayout.LayoutParams r116 = new LinearLayout.LayoutParams(-2, -2);
        r116.leftMargin = b(4.0f);
        r115.setLayoutParams(r116);
        r107.addView(r108);
        r107.addView(r115);
        r107.setOnClickListener(new u88.a(this, r100, r107));
        addView(r107);
        goto L12
    L21:
        String r117 = r100.d();
        if (r117 == null) goto L25;
        r104 = r117;
    L25:
        int r118 = r104.length();
    L26:
        if (r102 >= r118) goto L12;
        addView(a(String.valueOf(r104.charAt(r102))));
        r102 = r102 + 1;
        goto L26
    L16:
        r103 = 0;
        goto L17
    L43:
        requestLayout();
        return;
    L7:
        r112 = null;
        goto L8
    }

    public final void setListener(a r100) {
        this.f291619f = r100;
    }

    @Override // android.view.View
    public final void onMeasure(int r110, int r210) {
        ((ArrayList) this.f291617d).clear();
        ((ArrayList) this.f291618e).clear();
        int r100 = View.MeasureSpec.getMode(r110);
        int r101 = View.MeasureSpec.getSize(r110);
        int r102 = View.MeasureSpec.getMode(r210);
        int r103 = View.MeasureSpec.getSize(r210);
        if (r100 != 0) goto L5;
        int r104 = 1073741823;
    L6:
        int r105 = View.MeasureSpec.makeMeasureSpec(0, 0);
        int r106 = getChildCount();
        int r107 = 0;
    L7:
        int r111 = 8;
        if (r107 >= r106) goto L13;
        View r112 = getChildAt(r107);
        if (r112.getVisibility() == 8) goto L12;
        r112.measure(r105, r105);
    L12:
        r107 = r107 + 1;
        goto L7
    L13:
        ArrayList r108 = new ArrayList();
        int r109 = getChildCount();
        int r113 = 0;
        int r114 = 0;
        int r115 = 0;
        int r116 = 0;
        int r117 = 0;
    L14:
        if (r113 >= r109) goto L32;
        View r118 = getChildAt(r113);
        if (r118.getVisibility() == r111) goto L31;
        int r119 = r118.getMeasuredWidth();
        int r120 = r118.getMeasuredHeight();
        boolean r121 = !r108.isEmpty();
        if (r121 == false) goto L20;
        int r122 = this.f291615b + r119;
    L21:
        if (r121 == true) goto L23;
    L25:
        Intrinsics.checkNotNull(r118);
        r108.add(r118);
        if (r108.size() == 1) goto L29;
        r119 = r119 + this.f291615b;
    L29:
        r117 = r117 + r119;
        r114 = Math.max(r114, r120);
        goto L31
    L23:
        if ((r122 + r117) <= r104) goto L25;
        ((ArrayList) this.f291617d).add(r108);
        ((ArrayList) this.f291618e).add(Integer.valueOf(r114));
        r115 = r115 + (r114 + this.f291614a);
        r116 = Math.max(r116, r117);
        r108 = new ArrayList();
        r114 = 0;
        r117 = 0;
        goto L25
    L20:
        r122 = r119;
    L31:
        r113 = r113 + 1;
        r101 = r101;
        r111 = 8;
        goto L14
    L32:
        int r123 = r101;
        if ((!r108.isEmpty()) == false) goto L36;
        ((ArrayList) this.f291617d).add(r108);
        ((ArrayList) this.f291618e).add(Integer.valueOf(r114));
        r115 = r115 + r114;
        r116 = Math.max(r116, r117);
    L36:
        if (r100 != 1073741824) goto L38;
        int r124 = r123;
    L43:
        if (r102 == 1073741824) goto L46;
        r103 = (r115 + getPaddingTop()) + getPaddingBottom();
    L46:
        setMeasuredDimension(r124, r103);
        return;
    L38:
        int r125 = (r116 + getPaddingLeft()) + getPaddingRight();
        if (r100 != 0) goto L41;
        int r126 = Integer.MAX_VALUE;
    L42:
        r124 = RangesKt.coerceAtMost(r125, r126);
        goto L43
    L41:
        r126 = r123;
        goto L42
    L5:
        r104 = RangesKt.coerceAtLeast((r101 - getPaddingLeft()) - getPaddingRight(), 0);
        goto L6
    }

    public AiProactiveTaskSlotLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f291614a = b(6.0f);
        this.f291615b = b(2.0f);
        this.f291617d = new ArrayList();
        this.f291618e = new ArrayList();
    }

    public /* synthetic */ AiProactiveTaskSlotLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r110, int r111, int r112, int r113, int r114) {
        int r115 = getPaddingTop();
        int r116 = this.f291617d.size();
        int r117 = 0;
    L3:
        if (r117 >= r116) goto L13;
        List r118 = (List) ListProtector.get(this.f291617d, r117);
        int r100 = ((Number) ListProtector.get(this.f291618e, r117)).intValue();
        int r101 = getPaddingLeft();
        Iterator r102 = r118.iterator();
        int r103 = 0;
    L6:
        if (r102.hasNext() == false) goto L12;
        int r104 = r103 + 1;
        View r105 = (View) r102.next();
        int r106 = r105.getMeasuredWidth();
        int r107 = r105.getMeasuredHeight();
        int r108 = ((r100 - r107) / 2) + r115;
        r105.layout(r101, r108, r101 + r106, r107 + r108);
        if (r103 == (r118.size() - 1)) goto L10;
        int r109 = this.f291615b;
    L11:
        r101 = r101 + (r106 + r109);
        r103 = r104;
        goto L6
    L10:
        r109 = 0;
        goto L11
    L12:
        r115 = r115 + (r100 + this.f291614a);
        r117 = r117 + 1;
        goto L3
    }
}
