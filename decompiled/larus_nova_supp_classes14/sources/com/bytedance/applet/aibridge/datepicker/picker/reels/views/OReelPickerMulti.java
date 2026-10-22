package com.bytedance.applet.aibridge.datepicker.picker.reels.views;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\"B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u0013\u001a\u00020\u0014H\u0014J\u001f\u0010\u0015\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002¢\u0006\u0002\u0010\u0019J$\u0010\u001a\u001a\u00020\u0014*\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\bH\u0002J\b\u0010\u001f\u001a\u00020\u000eH\u0016J\u0012\u0010 \u001a\u0004\u0018\u00010\u00112\u0006\u0010!\u001a\u00020\bH\u0016J\u0018\u0010\u001a\u001a\u00020\u00142\u0006\u0010!\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/bytedance/applet/aibridge/datepicker/picker/reels/views/OReelPickerMulti;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/bytedance/applet/aibridge/datepicker/picker/reels/OReelPicker;", "context", "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "reelsContainer", "Landroid/widget/LinearLayout;", "highlightView", "Landroid/view/View;", "wheelViews", "", "Lcom/bytedance/applet/aibridge/datepicker/picker/reels/views/WheelView;", "reelsCount", "onAttachedToWindow", "", "addWheelView", "width", "weight", "", "(Ljava/lang/Integer;F)Lcom/bytedance/applet/aibridge/datepicker/picker/reels/views/WheelView;", "configure", "reel", "Lcom/bytedance/applet/aibridge/datepicker/picker/reels/OReelPicker$Reel;", "colIndex", "maxColIndex", "asView", "getReelView", "col", "Builder", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OReelPickerMulti extends ConstraintLayout {
    public final LinearLayout a;
    public final View b;
    public final List<WheelView> c;

    public static final class a {
        public final List<iv3.a> a;
        public final int b;
        public final int c;

        public a() {
            this.a = new ArrayList();
            Resources r1 = Resources.getSystem();
            this.b = MathKt.roundToInt(TypedValue.applyDimension(1, 328, WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics())));
            Resources r2 = Resources.getSystem();
            this.c = MathKt.roundToInt(TypedValue.applyDimension(1, 240, WindowDisplayMetricsOverride.apply(r2, r2.getDisplayMetrics())));
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [android.view.ViewGroup, com.bytedance.applet.aibridge.datepicker.picker.reels.views.OReelPickerMulti] */
        public final OReelPickerMulti a(Context r7, AttributeSet r8, int r9) {
            Intrinsics.checkNotNullParameter(r7, "context");
            ?? r0 = new OReelPickerMulti(r7, r8, r9);
            r0.setLayoutParams(new LinearLayout.LayoutParams(this.b, this.c));
            ArrayList r10 = (ArrayList) this.a;
            r10.size();
            ((ArrayList) r0.c).clear();
            r0.a.removeAllViews();
            Iterator r11 = r10.iterator();
        L4:
            if (r11.hasNext() == false) goto L10;
            Integer r12 = ((iv3.a) r11.next()).e;
            if (r12 == null) goto L8;
            LinearLayout.LayoutParams r3 = new LinearLayout.LayoutParams(r12.intValue(), -1);
        L9:
            WheelView r13 = new WheelView(r0.getContext(), null, 6, 0);
            r13.setLayoutParams(r3);
            r13.setCyclic(false);
            r0.a.addView(r13);
            ((ArrayList) r0.c).add(r13);
            goto L4
        L8:
            r3 = new LinearLayout.LayoutParams(-2, -1);
            goto L9
        L10:
            Iterator r14 = r10.iterator();
            int r15 = 0;
        L12:
            if (r14.hasNext() == false) goto L32;
            Object r16 = r14.next();
            int r4 = r15 + 1;
            if (r15 >= 0) goto L16;
            CollectionsKt.throwIndexOverflow();
        L16:
            iv3.a r17 = (iv3.a) r16;
            Intrinsics.checkNotNullParameter(r17, "reel");
            WheelView r18 = r0.R5(r15);
            if (r18 == null) goto L31;
            r18.setItemCount(5);
            CharSequence r5 = r17.c;
            if (r5 == null) goto L21;
            r18.setTagText(r5);
        L21:
            Integer r6 = r17.g;
            if (r6 == null) goto L24;
            r18.setTagGap(Integer.valueOf(r6.intValue()));
        L24:
            Integer r19 = r17.f;
            if (r19 == null) goto L27;
            r18.setMinimumWidth(r19.intValue());
        L27:
            r18.setOnWheelChangedListener(new kv3.a(r17));
            int r20 = r17.h;
            if (r20 < 0) goto L30;
            r18.j(Math.min(r20, r17.b.size() - 1), false);
        L30:
            r18.setEntries(r17.b);
        L31:
            r15 = r4;
            goto L12
        L32:
            return r0;
        }
    }

    public OReelPickerMulti(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public OReelPickerMulti(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onAttachedToWindow() {
        super/*android.view.ViewGroup*/.onAttachedToWindow();
        LinearLayout r0 = this.a;
        ConstraintLayout.LayoutParams r1 = r0.getLayoutParams();
        if (r1 == null) goto L11;
        ConstraintLayout.LayoutParams r2 = r1;
        r2.startToStart = 0;
        r2.endToEnd = 0;
        r2.topToTop = 0;
        r2.bottomToBottom = 0;
        r0.setLayoutParams(r2);
        View r3 = this.b;
        ViewGroup.LayoutParams r4 = r3.getLayoutParams();
        if (r4 == null) goto L9;
        ConstraintLayout.LayoutParams r5 = (ConstraintLayout.LayoutParams) r4;
        r5.startToStart = this.a.getId();
        r5.endToEnd = this.a.getId();
        r5.topToTop = this.a.getId();
        r5.bottomToBottom = this.a.getId();
        Resources r6 = Resources.getSystem();
        ((ViewGroup.MarginLayoutParams) r5).height = MathKt.roundToInt(TypedValue.applyDimension(1, 36, WindowDisplayMetricsOverride.apply(r6, r6.getDisplayMetrics())));
        ((ViewGroup.MarginLayoutParams) r5).width = 0;
        r3.setLayoutParams(r5);
        return;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L11:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    }

    public final WheelView R5(int r2) {
        return (WheelView) CollectionsKt.getOrNull(this.c, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OReelPickerMulti(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        LinearLayout r5 = new LinearLayout(r2);
        r5.setId(View.generateViewId());
        r5.setOrientation(0);
        r5.setGravity(17);
        r5.setLayoutParams(new ConstraintLayout.LayoutParams(-2, -2));
        this.a = r5;
        View r6 = new View(r2);
        r6.setId(View.generateViewId());
        r6.setBackgroundResource(2131238493);
        this.b = r6;
        this.c = new ArrayList();
        addView(r6);
        addView(r5);
    }

    public /* synthetic */ OReelPickerMulti(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
