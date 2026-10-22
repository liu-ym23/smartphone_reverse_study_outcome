package com.bytedance.applet.aibridge.datepicker.picker.reels.views;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kv3.e;
import kv3.h;
import kv3.i;
import kv3.j;
import kv3.k;
import kv3.l;
import kv3.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0087\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\r\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b#\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001M\u0018\u0000 \u0091\u00012\u00020\u0001:\u0006\u0091\u0001\u0092\u0001\u0093\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010O\u001a\u00020P2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002J\u0010\u0010j\u001a\u0004\u0018\u0001042\u0006\u0010k\u001a\u00020\u0007J\u0018\u0010n\u001a\u00020P2\u0006\u0010k\u001a\u00020\u00072\b\b\u0002\u0010q\u001a\u00020\u001fJ\u001f\u0010r\u001a\u00020P2\u0012\u0010s\u001a\n\u0012\u0006\b\u0001\u0012\u00020u0t\"\u00020u¢\u0006\u0002\u0010vJ\u0016\u0010r\u001a\u00020P2\u000e\u0010s\u001a\n\u0012\u0004\u0012\u00020u\u0018\u00010wJ\u000e\u0010x\u001a\u00020P2\u0006\u0010y\u001a\u000204J\b\u0010z\u001a\u00020PH\u0002J\b\u0010{\u001a\u00020PH\u0002J\u0016\u0010|\u001a\u00020P2\f\u0010}\u001a\b\u0012\u0004\u0012\u0002040wH\u0002J\u0016\u0010~\u001a\u00020P2\u0006\u0010k\u001a\u00020\u00072\u0006\u0010\u007f\u001a\u00020\u001fJ\u001a\u0010\u0080\u0001\u001a\u00020P2\u0007\u0010\u0081\u0001\u001a\u00020\u00072\u0006\u0010\u007f\u001a\u00020\u001fH\u0002J\t\u0010\u0082\u0001\u001a\u00020\u0007H\u0002J\u0012\u0010\u0083\u0001\u001a\u00020\u00072\u0007\u0010\u0084\u0001\u001a\u00020\u0007H\u0002J\u0011\u0010\u0085\u0001\u001a\u00020\u001f2\u0006\u0010k\u001a\u00020\u0007H\u0002J\u001b\u0010\u0086\u0001\u001a\u00020P2\u0007\u0010\u0087\u0001\u001a\u00020\u00072\u0007\u0010\u0088\u0001\u001a\u00020\u0007H\u0014J\t\u0010\u0089\u0001\u001a\u00020PH\u0002J\u0012\u0010\u008a\u0001\u001a\u00020P2\u0007\u0010\u008b\u0001\u001a\u00020\u0007H\u0002J\t\u0010\u008c\u0001\u001a\u00020PH\u0002J\f\u0010\u008d\u0001\u001a\u0005\u0018\u00010\u008e\u0001H\u0002J\t\u0010\u008f\u0001\u001a\u00020\u0007H\u0002J\t\u0010\u0090\u0001\u001a\u00020\u0007H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u00060\u0013R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010&\u001a\u00020\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001a\u0010+\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R$\u00101\u001a\u00020\u001f2\u0006\u00100\u001a\u00020\u001f@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010(\"\u0004\b2\u0010*R\u001c\u00103\u001a\u0004\u0018\u000104X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R*\u0010:\u001a\u0004\u0018\u00010\u00072\b\u00109\u001a\u0004\u0018\u00010\u0007@FX\u0086\u000e¢\u0006\u0010\n\u0002\u0010?\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R$\u0010@\u001a\u00020\u00072\u0006\u00109\u001a\u00020\u0007@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010-\"\u0004\bB\u0010/R$\u0010C\u001a\u00020\u00072\u0006\u00109\u001a\u00020\u0007@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010-\"\u0004\bE\u0010/R\u001c\u0010F\u001a\u0004\u0018\u00010GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\u0010\u0010L\u001a\u00020MX\u0082\u0004¢\u0006\u0004\n\u0002\u0010NR$\u0010Q\u001a\u00020\u00072\u0006\u00109\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bR\u0010-\"\u0004\bS\u0010/R$\u0010T\u001a\u00020\u00072\u0006\u00109\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bU\u0010-\"\u0004\bV\u0010/R$\u0010W\u001a\u00020\u00072\u0006\u00109\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bX\u0010-\"\u0004\bY\u0010/R$\u0010Z\u001a\u00020\u00072\u0006\u00109\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b[\u0010-\"\u0004\b\\\u0010/R$\u0010]\u001a\u00020\u00162\u0006\u00109\u001a\u00020\u00168F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR$\u0010b\u001a\u00020\u00072\u0006\u00109\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bc\u0010-\"\u0004\bd\u0010/R$\u0010e\u001a\u00020\u00162\u0006\u00109\u001a\u00020\u00168F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bf\u0010_\"\u0004\bg\u0010aR\u0011\u0010h\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\bi\u0010-R$\u0010l\u001a\u00020\u00072\u0006\u0010k\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bm\u0010-\"\u0004\bn\u0010/R\u0013\u0010o\u001a\u0004\u0018\u0001048F¢\u0006\u0006\u001a\u0004\bp\u00106¨\u0006\u0094\u0001"}, d2 = {"Lcom/bytedance/applet/aibridge/datepicker/picker/reels/views/WheelView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "tvTag", "Landroid/widget/TextView;", "layoutManager", "Lcom/bytedance/applet/aibridge/datepicker/picker/reels/views/WheelLayoutManager;", "snapHelper", "Landroidx/recyclerview/widget/LinearSnapHelper;", "adapter", "Lcom/bytedance/applet/aibridge/datepicker/picker/reels/views/WheelView$WheelAdapter;", "itemHeight", "maxTextWidth", "", "visibleRowCount", "wheelTextSizePx", "normalTextSizePx", "selectedTextSizePx", "lastHapticIndex", "lastCenterIndex", "lastChangedDataIndex", "userScrolling", "", "programmaticScrolling", "pendingInitialIndex", "pendingInitialScrollPosition", "pendingVerifyCenterAdapterPosition", "suppressNextSnapOnce", "pendingUserStoppedCallback", "showDivider", "getShowDivider", "()Z", "setShowDivider", "(Z)V", "highlightConorRadiusPx", "getHighlightConorRadiusPx", "()I", "setHighlightConorRadiusPx", "(I)V", "cyclic", "isCyclic", "setCyclic", "wheelTagText", "", "getWheelTagText", "()Ljava/lang/CharSequence;", "setWheelTagText", "(Ljava/lang/CharSequence;)V", "value", "tagGap", "getTagGap", "()Ljava/lang/Integer;", "setTagGap", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "selectedTextColor", "getSelectedTextColor", "setSelectedTextColor", "normalTextColor", "getNormalTextColor", "setNormalTextColor", "onWheelChangedListener", "Lcom/bytedance/applet/aibridge/datepicker/picker/reels/views/OnWheelChangedListener;", "getOnWheelChangedListener", "()Lcom/bytedance/applet/aibridge/datepicker/picker/reels/views/OnWheelChangedListener;", "setOnWheelChangedListener", "(Lcom/bytedance/applet/aibridge/datepicker/picker/reels/views/OnWheelChangedListener;)V", "scrollListener", "com/bytedance/applet/aibridge/datepicker/picker/reels/views/WheelView$scrollListener$1", "Lcom/bytedance/applet/aibridge/datepicker/picker/reels/views/WheelView$scrollListener$1;", "initAttrs", "", "startIndex", "getStartIndex", "setStartIndex", "itemCount", "getItemCount", "setItemCount", "itemHeightPx", "getItemHeightPx", "setItemHeightPx", "selectedItemHeightPx", "getSelectedItemHeightPx", "setSelectedItemHeightPx", "textSizePx", "getTextSizePx", "()F", "setTextSizePx", "(F)V", "textColor", "getTextColor", "setTextColor", "selectedTextSizePxProp", "getSelectedTextSizePxProp", "setSelectedTextSizePxProp", "itemSize", "getItemSize", "getItem", "index", "currentIndex", "getCurrentIndex", "setCurrentIndex", "currentItem", "getCurrentItem", "animated", "setEntries", "entries", "", "", "([Ljava/lang/String;)V", "", "setTagText", "tag", "scheduleInitialSelectionIfNeeded", "applyPendingInitialSelection", "setItems", "items", "setSelectedIndex", "animate", "centerToPosition", "position", "halfRows", "adapterToDataIndex", "adapterPos", "isValidDataIndex", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "snapToNearestCenter", "animateMove", "delta", "updateRecyclerPaddingForCenter", "findCenterChild", "Landroid/view/View;", "findNearestCenterIndex", "recyclerCenterY", "Companion", "WheelAdapter", "WheelVH", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WheelView extends FrameLayout {
    public static final /* synthetic */ int C = 0;
    public int A;
    public e B;
    public final RecyclerView a;
    public final TextView b;
    public final WheelLayoutManager c;
    public final b d;
    public int e;
    public float f;
    public int g;
    public float h;
    public float i;
    public float j;
    public int k;
    public int l;
    public int m;
    public boolean n;
    public boolean o;
    public int p;
    public int q;
    public int r;
    public boolean s;
    public boolean t;
    public boolean u;
    public int v;
    public boolean w;
    public CharSequence x;
    public Integer y;
    public int z;

    public static final class a {
    }

    public final class b extends RecyclerView.Adapter<c> {
        public final ArrayList<CharSequence> a;
        public final /* synthetic */ WheelView b;

        public final int getItemCount() {
            int r0 = this.a.size();
            if (r0 != 0) goto L6;
            return 0;
        L6:
            WheelView r1 = this.b;
            if (r1.w == false) goto L10;
            return r0 * ECDraweeView.SQUARE;
        L10:
            return r0 + (r1.g() * 2);
        }

        public b(WheelView r1) {
            this.b = r1;
            this.a = new ArrayList();
        }

        public final void onBindViewHolder(RecyclerView.ViewHolder r5, int r6) {
            final c r7 = (c) r5;
            Intrinsics.checkNotNullParameter(r7, "holder");
            WheelView r0 = this.b;
            int r1 = WheelView.C;
            int r8 = r0.c(r6);
            WheelView r2 = this.b;
            if (r2.w == false) goto L6;
            r7.a.setAlpha(1.0f);
            r7.a.setTextSize(0, this.b.h);
            r7.a.setText((CharSequence) ListProtector.get(this.a, r8));
            View r9 = ((RecyclerView.ViewHolder) r7).itemView;
            final WheelView r3 = this.b;
            r9.setOnClickListener(new l(r7, r3));
            return;
        L6:
            if (r2.h(r8) == false) goto L8;
            r7.a.setAlpha(1.0f);
            r7.a.setTextSize(0, this.b.h);
            r7.a.setText((CharSequence) ListProtector.get(this.a, r8));
            View r10 = ((RecyclerView.ViewHolder) r7).itemView;
            final WheelView r4 = this.b;
            r10.setOnClickListener(new m(r7, r4));
            return;
        L8:
            r7.a.setAlpha(0.0f);
            r7.a.setText("");
            ((RecyclerView.ViewHolder) r7).itemView.setOnClickListener(null);
        }

        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
            Intrinsics.checkNotNullParameter(r4, "parent");
            TextView r6 = new TextView(r4.getContext());
            WheelView r7 = this.b;
            r6.setId(R.id.text1);
            r6.setLayoutParams(new RecyclerView.LayoutParams(-1, r7.e));
            r6.setGravity(17);
            r6.setTextSize(0, r7.h);
            r6.setIncludeFontPadding(false);
            return new c(r6);
        }
    }

    public static final class c extends RecyclerView.ViewHolder {
        public final TextView a;

        public c(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
            this.a = (TextView) r2.findViewById(R.id.text1);
        }
    }

    static {
    }

    public WheelView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public WheelView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public static /* synthetic */ void a(WheelView r0) {
        setItems$lambda$4(r0);
    }

    public final void d() {
        int r0 = this.q;
        if (r0 != (-1)) goto L6;
        return;
    L6:
        if (this.d.a.size() != 0) goto L9;
        return;
    L9:
        if (this.a.getChildCount() != 0) goto L11;
        return;
    L11:
        this.q = -1;
        e(r0, false);
        this.a.post(new i(this));
    }

    public final int f() {
        WheelLayoutManager r0 = this.c;
        int r2 = 0;
        if (r0.i != 0) goto L5;
    L11:
        int r1 = -1;
    L12:
        if (r1 == (-1)) goto L14;
        return r1;
    L14:
        int r3 = ((this.a.getPaddingTop() + this.a.getHeight()) - this.a.getPaddingBottom()) / 2;
        int r4 = this.a.getChildCount();
        View r5 = null;
        float r6 = Float.MAX_VALUE;
    L15:
        if (r2 >= r4) goto L23;
        View r7 = this.a.getChildAt(r2);
        if (r7 == null) goto L22;
        float r8 = Math.abs(((r7.getTop() + r7.getBottom()) / 2.0f) - r3);
        if (r8 >= r6) goto L22;
        r5 = r7;
        r6 = r8;
    L22:
        r2 = r2 + 1;
        goto L15
    L23:
        if (r5 != null) goto L26;
        return -1;
    L26:
        return this.a.getChildAdapterPosition(r5);
    L5:
        if (r0.getItemCount() == 0) goto L11;
        int r9 = MathKt.roundToInt(r0.j / r0.i);
        if (r0.l == false) goto L10;
        r1 = RangesKt.coerceIn(r9, 0, r0.getItemCount() - 1);
        goto L12
    L10:
        int r10 = r0.m;
        r1 = RangesKt.coerceIn(r9, r10, RangesKt.coerceAtLeast((r0.getItemCount() - r0.m) - 1, r10));
        goto L12
    }

    public final int g() {
        return RangesKt.coerceAtLeast((this.g + 2) / 2, 1);
    }

    public final int getItemSize() {
        return this.d.a.size();
    }

    public final void i() {
        int r0 = this.d.a.size();
        if (r0 != 0) goto L5;
        return;
    L5:
        int r1 = RangesKt.coerceIn(this.p, 0, r0 - 1);
        if (this.w == false) goto L8;
        int r2 = ((r0 * ECDraweeView.SQUARE) / 2) + r1;
    L9:
        this.q = r2;
        if (this.a.getChildCount() <= 0) goto L13;
        d();
        return;
    L13:
        return;
    L8:
        r2 = g() + r1;
        goto L9
    }

    public final void k() {
        this.a.stopScroll();
        WheelLayoutManager r0 = this.c;
        if (r0.i != 0) goto L5;
    L15:
        int r1 = 0;
    L16:
        if (r1 == 0) goto L21;
        this.s = true;
        if (r1 == 0) goto L22;
        this.o = true;
        this.a.smoothScrollBy(0, r1, new jv3.a(), 400);
        return;
    L22:
        return;
    L21:
        return;
    L5:
        if (r0.getChildCount() == 0) goto L15;
        if (r0.getItemCount() <= 0) goto L15;
        float r2 = r0.j / r0.i;
        if (r0.l == false) goto L13;
        int r3 = RangesKt.coerceIn(MathKt.roundToInt(r2), 0, r0.getItemCount() - 1);
    L14:
        r1 = MathKt.roundToInt((r3 * r0.i) - r0.j);
        goto L16
    L13:
        int r4 = r0.m;
        r3 = RangesKt.coerceIn(MathKt.roundToInt(r2), r4, RangesKt.coerceAtLeast((r0.getItemCount() - r0.m) - 1, r4));
        goto L14
    }

    public final int getCurrentIndex() {
        int r0 = f();
        if (r0 != (-1)) goto L5;
        return 0;
    L5:
        int r1 = c(r0);
        if (h(r1) == true) goto L8;
        return 0;
    L8:
        return r1;
    }

    public final CharSequence getCurrentItem() {
        int r0 = getCurrentIndex();
        return (CharSequence) CollectionsKt.getOrNull(this.d.a, r0);
    }

    public final int getHighlightConorRadiusPx() {
        return this.v;
    }

    public final int getItemCount() {
        return this.g;
    }

    public final int getItemHeightPx() {
        return this.e;
    }

    public final int getNormalTextColor() {
        return this.A;
    }

    public final e getOnWheelChangedListener() {
        return this.B;
    }

    public final int getSelectedItemHeightPx() {
        return this.e;
    }

    public final int getSelectedTextColor() {
        return this.z;
    }

    public final float getSelectedTextSizePxProp() {
        return this.j;
    }

    public final boolean getShowDivider() {
        return this.u;
    }

    public final int getStartIndex() {
        return this.p;
    }

    public final Integer getTagGap() {
        return this.y;
    }

    public final int getTextColor() {
        return this.A;
    }

    public final float getTextSizePx() {
        return this.i;
    }

    public final CharSequence getWheelTagText() {
        return this.x;
    }

    public static DisplayMetrics b(Resources r1) {
        return WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics());
    }

    private final void setItems(List<? extends CharSequence> r4) {
        this.r = -1;
        b r0 = this.d;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r4, "data");
        r0.a.clear();
        r0.a.addAll(r4);
        r0.notifyDataSetChanged();
        TextView r1 = new TextView(getContext());
        r1.setTextSize(22.0f);
        TextPaint r2 = r1.getPaint();
        this.f = 0.0f;
        Iterator<? extends CharSequence> r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L8;
        float r3 = r2.measureText(r5.next().toString());
        if (r3 <= this.f) goto L4;
        this.f = r3;
        goto L4
    L8:
        ViewGroup.LayoutParams r6 = this.b.getLayoutParams();
        if ((r6 instanceof ViewGroup.MarginLayoutParams) == false) goto L15;
        ViewGroup.MarginLayoutParams r7 = (ViewGroup.MarginLayoutParams) r6;
        int r8 = (int) (this.f / 2.0f);
        Integer r9 = this.y;
        if (r9 == null) goto L13;
        int r10 = r9.intValue();
    L14:
        r7.setMarginStart(r8 + r10);
        this.b.setLayoutParams(r6);
        goto L15
    L13:
        r10 = 0;
    L15:
        post(new h(this));
    }

    private static final void setItems$lambda$4(WheelView r4) {
        r4.requestLayout();
        if (r4.a.getHeight() <= 0) goto L7;
        RecyclerView r0 = r4.a;
        r0.setPadding(r0.getPaddingLeft(), 0, r4.a.getPaddingRight(), 0);
    L7:
        if (r4.q == (-1)) goto L9;
        r4.d();
        return;
    L9:
        r4.i();
    }

    public final int c(int r3) {
        int r0 = this.d.a.size();
        if (r0 != 0) goto L7;
        return -1;
    L7:
        if (this.w == false) goto L12;
        int r4 = r3 % r0;
        if (r4 < 0) goto L14;
        return r4;
    L14:
        return r4 + r0;
    L12:
        return r3 - g();
    }

    public final boolean h(int r3) {
        if (r3 >= 0) goto L5;
        return false;
    L5:
        if (r3 >= this.d.a.size()) goto L9;
        return true;
    L9:
        return false;
    }

    public final void setCurrentIndex(int r2) {
        j(r2, false);
    }

    public final void setCyclic(boolean r2) {
        this.w = r2;
        WheelLayoutManager r0 = this.c;
        r0.l = r2;
        if (r2 == false) goto L5;
        int r3 = 0;
    L6:
        r0.m = r3;
        requestLayout();
        return;
    L5:
        r3 = g();
        goto L6
    }

    public final void setEntries(List<String> r3) {
        if (r3 == null) goto L7;
        List<String> r4 = r3;
        List<? extends CharSequence> r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10));
        Iterator<T> r5 = r4.iterator();
    L5:
        if (r5.hasNext() == false) goto L8;
        r0.add((String) r5.next());
    L8:
        setItems(r0);
        return;
    L7:
        r0 = CollectionsKt.emptyList();
        goto L8
    }

    public final void setHighlightConorRadiusPx(int r1) {
        this.v = r1;
    }

    public final void setItemCount(int r2) {
        this.g = r2;
        WheelLayoutManager r3 = this.c;
        if (this.w == false) goto L5;
        int r0 = 0;
    L6:
        r3.m = r0;
        requestLayout();
        return;
    L5:
        r0 = g();
        goto L6
    }

    public final void setItemHeightPx(int r1) {
        this.e = r1;
        this.d.notifyDataSetChanged();
        requestLayout();
    }

    public final void setNormalTextColor(int r2) {
        this.A = r2;
        this.c.e = r2;
        this.a.requestLayout();
    }

    public final void setOnWheelChangedListener(e r1) {
        this.B = r1;
    }

    public final void setSelectedItemHeightPx(int r1) {
        this.e = r1;
        this.d.notifyDataSetChanged();
        requestLayout();
    }

    public final void setSelectedTextColor(int r2) {
        this.z = r2;
        this.c.d = r2;
        this.a.requestLayout();
    }

    public final void setSelectedTextSizePxProp(float r2) {
        this.j = r2;
        this.h = Math.max(this.i, r2);
        this.d.notifyDataSetChanged();
        requestLayout();
    }

    public final void setShowDivider(boolean r1) {
        this.u = r1;
    }

    public final void setStartIndex(int r3) {
        this.p = r3;
        if (this.d.a.size() <= 0) goto L6;
        j(RangesKt.coerceIn(r3, 0, this.d.a.size() - 1), false);
        return;
    }

    public final void setTagGap(Integer r1) {
        this.y = r1;
        requestLayout();
    }

    public final void setTagText(CharSequence r2) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        this.x = r2;
        if (r2 != null) goto L5;
    L8:
        boolean r3 = true;
    L9:
        if (r3 == false) goto L11;
        this.b.setVisibility(8);
        return;
    L11:
        this.b.setVisibility(0);
        this.b.setText(this.x);
        return;
    L5:
        if (r2.length() == 0) goto L8;
        r3 = false;
        goto L9
    }

    public final void setTextColor(int r1) {
        setNormalTextColor(r1);
    }

    public final void setTextSizePx(float r2) {
        this.i = r2;
        this.h = Math.max(r2, this.j);
        this.d.notifyDataSetChanged();
        requestLayout();
    }

    public final void setWheelTagText(CharSequence r1) {
        this.x = r1;
    }

    public final void setEntries(String... r2) {
        Intrinsics.checkNotNullParameter(r2, "entries");
        setItems(ArraysKt.toList(r2));
    }

    public final void e(final int r6, boolean r7) {
        this.a.stopScroll();
        if (r7 == false) goto L18;
        this.o = true;
        this.r = r6;
        WheelLayoutManager r8 = this.c;
        if (r8.i != 0) goto L7;
    L14:
        int r9 = 0;
    L15:
        if (r9 == 0) goto L20;
        if (r9 == 0) goto L21;
        this.o = true;
        this.a.smoothScrollBy(0, r9, new jv3.a(), 400);
        return;
    L21:
        return;
    L20:
        return;
    L7:
        if (r8.getItemCount() == 0) goto L14;
        if (r8.l == false) goto L12;
        int r10 = RangesKt.coerceIn(r6, 0, r8.getItemCount() - 1);
    L13:
        r9 = MathKt.roundToInt((r10 * r8.i) - r8.j);
        goto L15
    L12:
        int r1 = r8.m;
        r10 = RangesKt.coerceIn(r6, r1, RangesKt.coerceAtLeast((r8.getItemCount() - r8.m) - 1, r1));
        goto L13
    L18:
        this.o = true;
        this.a.scrollToPosition(r6);
        post(new k(this, r6));
    }

    public final void j(int r11, boolean r12) {
        this.q = -1;
        this.r = -1;
        int r1 = this.d.a.size();
        if (r1 != 0) goto L6;
        this.p = r11;
        return;
    L6:
        boolean r3 = false;
        int r13 = RangesKt.coerceIn(r11, 0, r1 - 1);
        if (this.w == false) goto L30;
        int r2 = f();
        if (this.a.getChildCount() <= 0) goto L29;
        if (r2 == (-1)) goto L29;
        int r0 = this.d.getItemCount();
        int r4 = (r2 - (r2 % r1)) + r13;
        Ref.IntRef r14 = new Ref.IntRef();
        r14.element = r4;
        Ref.IntRef r5 = new Ref.IntRef();
        r5.element = Math.abs(r4 - r2);
        int r6 = r4 - r1;
        if (r6 < 0) goto L15;
        if (r6 >= r0) goto L15;
        boolean r8 = true;
    L16:
        if (r8 == false) goto L20;
        int r9 = Math.abs(r6 - r2);
        if (r9 >= r5.element) goto L20;
        r14.element = r6;
        r5.element = r9;
    L20:
        int r7 = r4 + r1;
        if (r7 < 0) goto L24;
        if (r7 >= r0) goto L24;
        r3 = true;
    L24:
        if (r3 == false) goto L28;
        int r10 = Math.abs(r7 - r2);
        if (r10 >= r5.element) goto L28;
        r14.element = r7;
        r5.element = r10;
    L28:
        int r15 = r14.element;
    L31:
        e(r15, r12);
        return;
    L15:
        r8 = false;
    L29:
        r15 = r13 + ((r1 * ECDraweeView.SQUARE) / 2);
        goto L31
    L30:
        r15 = r13 + g();
        goto L31
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r6, int r7) {
        int r8 = View.MeasureSpec.makeMeasureSpec((((int) (((this.e / ((float) Math.tan(0.5235988f))) * 2.0f) + this.e)) + getPaddingTop()) + getPaddingBottom(), 1073741824);
        int r1 = View.MeasureSpec.getMode(r6);
        int r9 = View.MeasureSpec.getSize(r6);
        int r2 = Math.max((int) (this.f + MathKt.roundToInt(TypedValue.applyDimension(1, 28, b(Resources.getSystem())))), getMinimumWidth());
        if (r1 == Integer.MIN_VALUE) goto L6;
        if (r1 == 1073741824) goto L7;
        r9 = r2;
    L7:
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(r9, 1073741824), r8);
        return;
    L6:
        r9 = Math.min(r2, r9);
        goto L7
    }

    public WheelView(Context r18, AttributeSet r19, int r20) {
        Intrinsics.checkNotNullParameter(r18, "context");
        super(r18, r19, r20);
        WheelLayoutManager r2 = new WheelLayoutManager(r18);
        this.c = r2;
        LinearSnapHelper r3 = new LinearSnapHelper();
        b r4 = new b(this);
        this.d = r4;
        this.e = MathKt.roundToInt(TypedValue.applyDimension(1, 50.0f, b(Resources.getSystem())));
        this.g = 5;
        this.h = TypedValue.applyDimension(1, 22.0f, b(Resources.getSystem()));
        this.i = TypedValue.applyDimension(1, 22.0f, b(Resources.getSystem()));
        this.j = TypedValue.applyDimension(1, 22.0f, b(Resources.getSystem()));
        this.k = -1;
        this.l = -1;
        this.m = -1;
        this.q = -1;
        this.r = -1;
        this.v = MathKt.roundToInt(TypedValue.applyDimension(1, 8, b(Resources.getSystem())));
        this.z = ContextCompat.getColor(r18, 2131103178);
        this.A = ContextCompat.getColor(r18, 2131103179);
        RecyclerView.OnScrollListener r11 = new WheelView$scrollListener$1(this);
        FrameLayout.inflate(r18, 2131561813, this);
        RecyclerView r1 = (RecyclerView) findViewById(2131384070);
        this.a = r1;
        this.b = (TextView) findViewById(2131391552);
        r1.setLayoutManager(r2);
        r2.m = g();
        r1.setAdapter(r4);
        r1.setClipToPadding(false);
        r1.setOverScrollMode(0);
        r3.attachToRecyclerView(r1);
        r1.addOnScrollListener(r11);
        r1.getViewTreeObserver().addOnGlobalLayoutListener(new j(this));
        TypedArray r5 = getContext().obtainStyledAttributes(r19, new int[]{2130968826, 2130968827, 2130968828, 2130968829, 2130968830, 2130968831, 2130968832, 2130968833, 2130968834, 2130968835, 2130968836, 2130968837, 2130968838});
        boolean r6 = r5.getBoolean(0, false);
        int r7 = r5.getInt(10, 0);
        int r12 = r5.getInt(4, 5);
        int r8 = r5.getDimensionPixelOffset(5, MathKt.roundToInt(TypedValue.applyDimension(1, 50, b(Resources.getSystem()))));
        int r13 = r5.getDimensionPixelSize(12, MathKt.roundToInt(TypedValue.applyDimension(1, 22.0f, b(Resources.getSystem()))));
        int r14 = r5.getDimensionPixelSize(12, MathKt.roundToInt(TypedValue.applyDimension(1, 14.0f, b(Resources.getSystem()))));
        int r10 = r5.getColor(11, ContextCompat.getColor(getContext(), 2131103179));
        int r9 = r5.getColor(7, ContextCompat.getColor(getContext(), 2131103178));
        int r15 = r5.getDimensionPixelSize(8, MathKt.roundToInt(TypedValue.applyDimension(1, 22.0f, b(Resources.getSystem()))));
        CharSequence[] r16 = r5.getTextArray(1);
        if (r16 == null) goto L7;
        ArrayList r17 = new ArrayList(r16.length);
        int r110 = r16.length;
        int r111 = 0;
    L5:
        if (r111 >= r110) goto L8;
        r17.add(r16[r111].toString());
        r111 = r111 + 1;
    L8:
        r5.recycle();
        setCyclic(r6);
        this.p = r7;
        this.g = r12;
        this.e = r8;
        float r21 = r13;
        this.i = r21;
        float r22 = r15;
        this.j = r22;
        this.h = RangesKt.coerceAtLeast(r22, r21);
        setSelectedTextColor(r9);
        this.b.setTextSize(0, r14);
        this.b.setTextColor(r10);
        if (r17 == null) goto L11;
        setItems(r17);
        return;
    L11:
        i();
        return;
    L7:
        r17 = null;
        goto L8
    }

    public /* synthetic */ WheelView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
