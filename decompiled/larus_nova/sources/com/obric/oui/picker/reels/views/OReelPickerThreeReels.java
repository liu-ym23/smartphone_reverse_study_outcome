package com.obric.oui.picker.reels.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002:\u0002\u0004\tB'\b\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016R\u001b\u0010\b\u001a\u00020\u00038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\u000b\u001a\u00020\u00038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007R\u001b\u0010\u000e\u001a\u00020\u00038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\u0005\u001a\u0004\b\r\u0010\u0007¨\u0006\u0017"}, d2 = {"Lcom/obric/oui/picker/reels/views/OReelPickerThreeReels;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lgma/a;", "Lcom/obric/oui/picker/reels/views/WheelView;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lkotlin/Lazy;", "getWv1", "()Lcom/obric/oui/picker/reels/views/WheelView;", "wv1", "b", "getWv2", "wv2", "c", "getWv3", "wv3", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attributeSet", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public class OReelPickerThreeReels extends ConstraintLayout implements gma.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f402143a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f402144b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f402145c;

    public static final class a implements gma.a.InterfaceC6040a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<gma.a.b> f402146a;

        public a() {
            this.f402146a = new ArrayList();
        }

        public final gma.a.InterfaceC6040a a(gma.a.b r100) {
            Intrinsics.checkNotNullParameter(r100, "reel");
            ((ArrayList) this.f402146a).add(r100);
            return this;
        }

        public final gma.a b(Context r100, AttributeSet r101, int r102) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            OReelPickerThreeReels r103 = new OReelPickerThreeReels(r100, r101, r102);
            List<gma.a.b> r104 = this.f402146a;
            int r105 = ((ArrayList) r104).size();
            if (r105 != 0) goto L5;
        L11:
            r103.setLayoutParams(new LinearLayout.LayoutParams(-1, pla.d.n(r103, 240)));
            return r103;
        L5:
            if (r105 != 1) goto L7;
            r103.V5(OReelPickerThreeReels.R5(r103), (gma.a.b) ListProtector.get(r104, 0));
            OReelPickerThreeReels.S5(r103).setVisibility(8);
            OReelPickerThreeReels.T5(r103).setVisibility(8);
            goto L11
        L7:
            if (r105 == 2) goto L9;
            r103.V5(OReelPickerThreeReels.R5(r103), (gma.a.b) ListProtector.get(r104, 0));
            r103.V5(OReelPickerThreeReels.S5(r103), (gma.a.b) ListProtector.get(r104, 1));
            r103.V5(OReelPickerThreeReels.T5(r103), (gma.a.b) ListProtector.get(r104, 2));
            goto L11
        L9:
            r103.V5(OReelPickerThreeReels.R5(r103), (gma.a.b) ListProtector.get(r104, 0));
            r103.V5(OReelPickerThreeReels.S5(r103), (gma.a.b) ListProtector.get(r104, 1));
            OReelPickerThreeReels.T5(r103).setVisibility(8);
            goto L11
        }
    }

    public static final class b {
    }

    static {
    }

    public OReelPickerThreeReels(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public OReelPickerThreeReels(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // gma.a
    public final View asView() {
        return this;
    }

    private final WheelView getWv1() {
        return (WheelView) this.f402143a.getValue();
    }

    private final WheelView getWv2() {
        return (WheelView) this.f402144b.getValue();
    }

    private final WheelView getWv3() {
        return (WheelView) this.f402145c.getValue();
    }

    public static final /* synthetic */ WheelView R5(OReelPickerThreeReels r100) {
        return r100.getWv1();
    }

    public static final /* synthetic */ WheelView S5(OReelPickerThreeReels r100) {
        return r100.getWv2();
    }

    public static final /* synthetic */ WheelView T5(OReelPickerThreeReels r100) {
        return r100.getWv3();
    }

    @Override // gma.a
    public final WheelView L0(int r100) {
        if (r100 == 0) goto L11;
        if (r100 == 1) goto L14;
        if (r100 == 2) goto L13;
        return null;
    L13:
        return getWv3();
    L14:
        return getWv2();
    L11:
        return getWv1();
    }

    public final void U5(int r100, gma.a.b r101) {
        Intrinsics.checkNotNullParameter(r101, "reel");
        WheelView r102 = L0(r100);
        if (r102 == null) goto L7;
        V5(r102, r101);
        return;
    }

    public final void V5(WheelView r100, gma.a.b r101) {
        r100.setVisibility(0);
        CharSequence r102 = r101.f481778c;
        if (r102 == null) goto L6;
        r100.setTagText(r102);
    L6:
        r100.setLayoutParams(new LinearLayout.LayoutParams(0, -1, r101.f481779d));
        r100.setOnWheelChangedListener(new com.obric.oui.picker.reels.views.b(r101));
        List<String> r103 = r101.f481777b;
        r100.j(r103, RangesKt.coerceIn(r101.f481783h, 0, RangesKt.coerceAtLeast(r103.size() - 1, 0)));
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
    }

    public OReelPickerThreeReels(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f402143a = LazyKt.lazy(new OReelPickerThreeReels$wv1$2(this));
        this.f402144b = LazyKt.lazy(new OReelPickerThreeReels$wv2$2(this));
        this.f402145c = LazyKt.lazy(new OReelPickerThreeReels$wv3$2(this));
        LayoutInflater.from(r100).inflate(R.layout.o_reel_picker_3_reels, this);
    }

    public /* synthetic */ OReelPickerThreeReels(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
    }
}
