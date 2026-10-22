package com.obric.oui.picker.reels.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/obric/oui/picker/reels/views/OReelPickerMulti;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lgma/a;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attributeSet", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public final class OReelPickerMulti extends ConstraintLayout implements gma.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f402141a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<WheelView> f402142b;

    public OReelPickerMulti(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public OReelPickerMulti(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // gma.a
    public final View asView() {
        return this;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        LinearLayout r100 = this.f402141a;
        ViewGroup.LayoutParams r101 = r100.getLayoutParams();
        if (r101 == null) goto L7;
        ConstraintLayout.LayoutParams r102 = (ConstraintLayout.LayoutParams) r101;
        r102.startToStart = 0;
        r102.endToEnd = 0;
        r102.topToTop = 0;
        r102.bottomToBottom = 0;
        r100.setLayoutParams(r102);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    }

    @Override // gma.a
    public final WheelView L0(int r100) {
        return (WheelView) CollectionsKt.getOrNull(this.f402142b, r100);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        if (getAlpha() >= 1.0f) goto L7;
        return true;
    L7:
        return super.dispatchTouchEvent(r100);
    }

    public final void R5(int r100, gma.a.b r101) {
        Intrinsics.checkNotNullParameter(r101, "reel");
        WheelView r102 = L0(r100);
        if (r102 == null) goto L19;
        r102.setItemCount(5);
        CharSequence r103 = r101.f481778c;
        if (r103 == null) goto L9;
        r102.setTagText(r103);
    L9:
        Integer r104 = r101.f481782g;
        if (r104 == null) goto L13;
        r102.setTagGap(Integer.valueOf(r104.intValue()));
    L13:
        Integer r105 = r101.f481781f;
        if (r105 == null) goto L17;
        r102.setMinimumWidth(r105.intValue());
    L17:
        r102.setOnWheelChangedListener(new a(r101));
        List<String> r106 = r101.f481777b;
        r102.j(r106, RangesKt.coerceIn(r101.f481783h, 0, RangesKt.coerceAtLeast(r106.size() - 1, 0)));
        return;
    }

    public OReelPickerMulti(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        LinearLayout r103 = new LinearLayout(r100);
        r103.setId(ViewGroup.generateViewId());
        r103.setOrientation(0);
        r103.setGravity(17);
        r103.setLayoutParams(new ConstraintLayout.LayoutParams(-2, -2));
        this.f402141a = r103;
        this.f402142b = new ArrayList();
        addView(r103);
    }

    public /* synthetic */ OReelPickerMulti(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
