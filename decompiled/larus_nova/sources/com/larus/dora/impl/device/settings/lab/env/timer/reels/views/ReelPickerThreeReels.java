package com.larus.dora.impl.device.settings.lab.env.timer.reels.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.byted.cast.common.CastMonitor;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import t49.b;
import v49.c;
import v49.d;
import v49.e;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002:\u0001,B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ$\u0010\u0018\u001a\u00020\u0019*\u00020\f2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\bH\u0002J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\u0012\u0010 \u001a\u0004\u0018\u00010\f2\u0006\u0010!\u001a\u00020\bH\u0016J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010!\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0018\u0010\"\u001a\u00020\u00192\u0006\u0010#\u001a\u00020\b2\u0006\u0010$\u001a\u00020\bH\u0014J0\u0010%\u001a\u00020\u00192\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\b2\u0006\u0010)\u001a\u00020\b2\u0006\u0010*\u001a\u00020\b2\u0006\u0010+\u001a\u00020\bH\u0014R\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0011\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0012\u0010\u000eR\u001b\u0010\u0014\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0010\u001a\u0004\b\u0015\u0010\u000eR\u000e\u0010\u0017\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/larus/dora/impl/device/settings/lab/env/timer/reels/views/ReelPickerThreeReels;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/larus/dora/impl/device/settings/lab/env/timer/reels/ReelPicker;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "wv1", "Lcom/larus/dora/impl/device/settings/lab/env/timer/reels/views/WheelView;", "getWv1", "()Lcom/larus/dora/impl/device/settings/lab/env/timer/reels/views/WheelView;", "wv1$delegate", "Lkotlin/Lazy;", "wv2", "getWv2", "wv2$delegate", "wv3", "getWv3", "wv3$delegate", "reelsCount", "configure", "", "reel", "Lcom/larus/dora/impl/device/settings/lab/env/timer/reels/ReelPicker$Reel;", "colIndex", "maxColIndex", "asView", "Landroid/view/View;", "getReelView", "col", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onLayout", CastMonitor.EVENT_PARAM_BYTECAST_NETWORK_STATE_CHANGED, "", "left", "top", "right", "bottom", "Builder", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class ReelPickerThreeReels extends ConstraintLayout {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f334665d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f334666a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f334667b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f334668c;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f334669a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<b> f334670b;

        public a(int r100) {
            this.f334669a = r100;
            this.f334670b = new ArrayList();
        }

        public final void a(b r100) {
            Intrinsics.checkNotNullParameter(r100, "reel");
            ((ArrayList) this.f334670b).add(r100);
        }

        public final ReelPickerThreeReels b(Context r100, AttributeSet r101, int r102) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            ReelPickerThreeReels r103 = new ReelPickerThreeReels(r100, r101, r102);
            List<b> r104 = this.f334670b;
            int r105 = ((ArrayList) r104).size();
            if (r105 != 0) goto L5;
        L11:
            r103.setLayoutParams(new LinearLayout.LayoutParams(-1, this.f334669a));
            return r103;
        L5:
            if (r105 != 1) goto L7;
            ReelPickerThreeReels.R5(r103, ReelPickerThreeReels.S5(r103), (b) ListProtector.get(r104, 0), 0, 0);
            ReelPickerThreeReels.T5(r103).setVisibility(8);
            ReelPickerThreeReels.U5(r103).setVisibility(8);
            goto L11
        L7:
            if (r105 == 2) goto L9;
            ReelPickerThreeReels.R5(r103, ReelPickerThreeReels.S5(r103), (b) ListProtector.get(r104, 0), 0, 2);
            ReelPickerThreeReels.R5(r103, ReelPickerThreeReels.T5(r103), (b) ListProtector.get(r104, 1), 1, 2);
            ReelPickerThreeReels.R5(r103, ReelPickerThreeReels.U5(r103), (b) ListProtector.get(r104, 2), 2, 2);
            goto L11
        L9:
            ReelPickerThreeReels.R5(r103, ReelPickerThreeReels.S5(r103), (b) ListProtector.get(r104, 0), 0, 1);
            ReelPickerThreeReels.R5(r103, ReelPickerThreeReels.T5(r103), (b) ListProtector.get(r104, 1), 1, 1);
            ReelPickerThreeReels.U5(r103).setVisibility(8);
            goto L11
        }
    }

    public ReelPickerThreeReels(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ReelPickerThreeReels(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    private final WheelView getWv1() {
        return (WheelView) this.f334666a.getValue();
    }

    private final WheelView getWv2() {
        return (WheelView) this.f334667b.getValue();
    }

    private final WheelView getWv3() {
        return (WheelView) this.f334668c.getValue();
    }

    public final WheelView V5() {
        return getWv1();
    }

    public static final /* synthetic */ WheelView S5(ReelPickerThreeReels r100) {
        return r100.getWv1();
    }

    public static final /* synthetic */ WheelView T5(ReelPickerThreeReels r100) {
        return r100.getWv2();
    }

    public static final /* synthetic */ WheelView U5(ReelPickerThreeReels r100) {
        return r100.getWv3();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
    }

    public ReelPickerThreeReels(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f334666a = LazyKt.lazy(new v49.b(this));
        this.f334667b = LazyKt.lazy(new c(this));
        this.f334668c = LazyKt.lazy(new d(this));
        LayoutInflater.from(r100).inflate(R.layout.larus_dora_reel_picker_3_reels, this);
    }

    public /* synthetic */ ReelPickerThreeReels(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    public static final void R5(ReelPickerThreeReels r100, WheelView r101, b r102, int r103, int r104) {
        r101.setVisibility(0);
        CharSequence r105 = r102.f544605c;
        if (r105 == null) goto L5;
        r101.setTagText(r105);
    L5:
        r101.setLayoutParams(new LinearLayout.LayoutParams(0, -1, r102.f544606d));
        r101.setOnWheelChangedListener(new e(r102));
        r101.setEntries(r102.f544604b);
        int r106 = r102.f544607e;
        if (r106 < 0) goto L8;
        r101.b(Math.min(r106, r102.f544604b.size() - 1), false);
    L8:
        if (r103 != 0) goto L10;
        r101.setShowTopLeftCorner(true);
        r101.setShowBottomLeftCorner(true);
    L10:
        if (1 > r103) goto L13;
        if (r103 >= r104) goto L13;
        boolean r107 = true;
    L14:
        if (r107 == false) goto L16;
        r101.setShowTopLeftCorner(false);
        r101.setShowBottomLeftCorner(false);
        r101.setShowTopRightCorner(false);
        r101.setShowBottomRightCorner(false);
    L16:
        if (r103 != r104) goto L19;
        r101.setShowTopRightCorner(true);
        r101.setShowBottomRightCorner(true);
        return;
    L19:
        return;
    L13:
        r107 = false;
        goto L14
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
    }
}
