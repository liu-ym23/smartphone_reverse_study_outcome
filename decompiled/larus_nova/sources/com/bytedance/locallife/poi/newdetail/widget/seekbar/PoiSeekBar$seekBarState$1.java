package com.bytedance.locallife.poi.newdetail.widget.seekbar;

import android.animation.Animator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
public /* synthetic */ class PoiSeekBar$seekBarState$1 extends FunctionReferenceImpl implements Function2<SeekBarState.State, SeekBarState.Action, Unit> {
    public PoiSeekBar$seekBarState$1(Object r100) {
        super(2, r100, PoiSeekBar.class, "newState", "newState(Lcom/bytedance/locallife/poi/newdetail/widget/seekbar/SeekBarState$State;Lcom/bytedance/locallife/poi/newdetail/widget/seekbar/SeekBarState$Action;)V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(SeekBarState.State r100, SeekBarState.Action r101) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        Intrinsics.checkNotNullParameter(r101, "p1");
        PoiSeekBar r102 = (PoiSeekBar) this.receiver;
        if (r102.f263448i == true) goto L6;
        return;
    L6:
        if (r102.f263450k == false) goto L37;
        Animator r103 = r102.f263459t;
        if (r103 == null) goto L10;
        r103.cancel();
    L10:
        int r104 = PoiSeekBar.c.f263467b[r100.ordinal()];
        if (r104 != 1) goto L13;
        r102.b(r102.getFrozenStyleConfig());
    L38:
        r102.B.a(r102.G.f263477c, r100, r101);
        return;
    L13:
        if (r104 == 2) goto L27;
        if (r104 == 3) goto L18;
        if (r104 != 4) goto L38;
        r102.e(r102.getDragStyleConfig());
        goto L38
    L18:
        int r105 = PoiSeekBar.c.f263466a[r101.ordinal()];
        if (r105 != 5) goto L21;
        r102.removeCallbacks(r102.H);
        r102.b(r102.getActiveStyleConfig());
        goto L38
    L21:
        if (r105 != 6) goto L23;
    L25:
        r102.e(r102.getActiveStyleConfig());
        goto L38
    L23:
        if (r105 == 7) goto L25;
    L27:
        int r106 = PoiSeekBar.c.f263466a[r101.ordinal()];
        if (r106 == 1) goto L35;
        if (r106 == 2) goto L34;
        if (r106 == 3) goto L34;
        if (r106 != 4) goto L38;
        r102.e(r102.getDefaultStyleConfig());
    L34:
        r102.b(r102.getDefaultStyleConfig());
        goto L38
    L35:
        r102.b(r102.getDefaultStyleConfig());
        goto L38
    L37:
        r102.c(r100);
        goto L38
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(SeekBarState.State r100, SeekBarState.Action r101) {
        invoke2(r100, r101);
        return Unit.INSTANCE;
    }
}
