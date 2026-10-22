package androidx.compose.material3;

import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.saveable.ListSaverKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverScope;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0014\n\u0002\b \n\u0002\u0010\u000b\n\u0002\b*\b\u0007\u0018\u0000 y2\u00020\u0001:\u0001yBG\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0005\u001a\u00020\u0006\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010f\u001a\u00020\t2\u0006\u0010g\u001a\u00020P2\u0006\u0010h\u001a\u00020\u0003H\u0000¢\u0006\u0002\biJ/\u0010r\u001a\u00020)2\u0006\u0010g\u001a\u00020P2\u0006\u0010b\u001a\u00020\u00032\u0006\u0010^\u001a\u00020\u00032\u0006\u0010h\u001a\u00020)H\u0002¢\u0006\u0004\bs\u0010tJ \u0010u\u001a\u00020\u00032\u0006\u0010b\u001a\u00020\u00032\u0006\u0010^\u001a\u00020\u00032\u0006\u0010v\u001a\u00020\u0003H\u0002J\r\u0010w\u001a\u00020\tH\u0000¢\u0006\u0002\bxR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\"\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R+\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00038B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR+\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00038B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b!\u0010\u001d\u001a\u0004\b\u001f\u0010\u0019\"\u0004\b \u0010\u001bR$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\u00038F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b#\u0010\u0019\"\u0004\b$\u0010\u001bR$\u0010\u0004\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\u00038F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b%\u0010\u0019\"\u0004\b&\u0010\u001bR(\u0010'\u001a\u0010\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\t\u0018\u00010(X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u0014\u0010.\u001a\u00020/X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R+\u00102\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00038@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\b5\u0010\u001d\u001a\u0004\b3\u0010\u0019\"\u0004\b4\u0010\u001bR+\u00106\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00038@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\b9\u0010\u001d\u001a\u0004\b7\u0010\u0019\"\u0004\b8\u0010\u001bR+\u0010:\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00038@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\b=\u0010\u001d\u001a\u0004\b;\u0010\u0019\"\u0004\b<\u0010\u001bR+\u0010>\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00038@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\bA\u0010\u001d\u001a\u0004\b?\u0010\u0019\"\u0004\b@\u0010\u001bR+\u0010B\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00068@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\bF\u0010G\u001a\u0004\bC\u0010\u000f\"\u0004\bD\u0010ER+\u0010H\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00038@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\bK\u0010\u001d\u001a\u0004\bI\u0010\u0019\"\u0004\bJ\u0010\u001bR+\u0010L\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00038@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\bO\u0010\u001d\u001a\u0004\bM\u0010\u0019\"\u0004\bN\u0010\u001bR+\u0010Q\u001a\u00020P2\u0006\u0010\u0016\u001a\u00020P8@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\bV\u0010W\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR+\u0010X\u001a\u00020P2\u0006\u0010\u0016\u001a\u00020P8@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\b[\u0010W\u001a\u0004\bY\u0010S\"\u0004\bZ\u0010UR \u0010\\\u001a\u000e\u0012\u0004\u0012\u00020P\u0012\u0004\u0012\u00020\t0(X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b]\u0010+R+\u0010^\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00038B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\ba\u0010\u001d\u001a\u0004\b_\u0010\u0019\"\u0004\b`\u0010\u001bR+\u0010b\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00038B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\be\u0010\u001d\u001a\u0004\bc\u0010\u0019\"\u0004\bd\u0010\u001bR\u0014\u0010j\u001a\u00020\u00038@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bk\u0010\u0019R\u0014\u0010l\u001a\u00020\u00038@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bm\u0010\u0019R\u0014\u0010n\u001a\u00020\u00068@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bo\u0010\u000fR\u0014\u0010p\u001a\u00020\u00068@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bq\u0010\u000f¨\u0006z"}, d2 = {"Landroidx/compose/material3/RangeSliderState;", "", "activeRangeStart", "", "activeRangeEnd", "steps", "", "onValueChangeFinished", "Lkotlin/Function0;", "", "valueRange", "Lkotlin/ranges/ClosedFloatingPointRange;", "<init>", "(FFILkotlin/jvm/functions/Function0;Lkotlin/ranges/ClosedFloatingPointRange;)V", "getSteps", "()I", "getOnValueChangeFinished", "()Lkotlin/jvm/functions/Function0;", "setOnValueChangeFinished", "(Lkotlin/jvm/functions/Function0;)V", "getValueRange", "()Lkotlin/ranges/ClosedFloatingPointRange;", "<set-?>", "activeRangeStartState", "getActiveRangeStartState", "()F", "setActiveRangeStartState", "(F)V", "activeRangeStartState$delegate", "Landroidx/compose/runtime/MutableFloatState;", "activeRangeEndState", "getActiveRangeEndState", "setActiveRangeEndState", "activeRangeEndState$delegate", "newVal", "getActiveRangeStart", "setActiveRangeStart", "getActiveRangeEnd", "setActiveRangeEnd", "onValueChange", "Lkotlin/Function1;", "Landroidx/compose/material3/SliderRange;", "getOnValueChange$material3", "()Lkotlin/jvm/functions/Function1;", "setOnValueChange$material3", "(Lkotlin/jvm/functions/Function1;)V", "tickFractions", "", "getTickFractions$material3", "()[F", "startThumbWidth", "getStartThumbWidth$material3", "setStartThumbWidth$material3", "startThumbWidth$delegate", "startThumbHeight", "getStartThumbHeight$material3", "setStartThumbHeight$material3", "startThumbHeight$delegate", "endThumbWidth", "getEndThumbWidth$material3", "setEndThumbWidth$material3", "endThumbWidth$delegate", "endThumbHeight", "getEndThumbHeight$material3", "setEndThumbHeight$material3", "endThumbHeight$delegate", "totalWidth", "getTotalWidth$material3", "setTotalWidth$material3", "(I)V", "totalWidth$delegate", "Landroidx/compose/runtime/MutableIntState;", "rawOffsetStart", "getRawOffsetStart$material3", "setRawOffsetStart$material3", "rawOffsetStart$delegate", "rawOffsetEnd", "getRawOffsetEnd$material3", "setRawOffsetEnd$material3", "rawOffsetEnd$delegate", "", "isDragging", "isDragging$material3", "()Z", "setDragging$material3", "(Z)V", "isDragging$delegate", "Landroidx/compose/runtime/MutableState;", "isRtl", "isRtl$material3", "setRtl$material3", "isRtl$delegate", "gestureEndAction", "getGestureEndAction$material3", "maxPx", "getMaxPx", "setMaxPx", "maxPx$delegate", "minPx", "getMinPx", "setMinPx", "minPx$delegate", "onDrag", "isStart", "offset", "onDrag$material3", "coercedActiveRangeStartAsFraction", "getCoercedActiveRangeStartAsFraction$material3", "coercedActiveRangeEndAsFraction", "getCoercedActiveRangeEndAsFraction$material3", "startSteps", "getStartSteps$material3", "endSteps", "getEndSteps$material3", "scaleToUserValue", "scaleToUserValue-8bqG3aw", "(ZFFJ)J", "scaleToOffset", "userValue", "updateMinMaxPx", "updateMinMaxPx$material3", "Companion", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class RangeSliderState {
    public static final int $stable = 0;
    public static final Companion Companion = null;
    private final MutableFloatState activeRangeEndState$delegate;
    private final MutableFloatState activeRangeStartState$delegate;
    private final MutableFloatState endThumbHeight$delegate;
    private final MutableFloatState endThumbWidth$delegate;
    private final Function1<Boolean, Unit> gestureEndAction;
    private final MutableState isDragging$delegate;
    private final MutableState isRtl$delegate;
    private final MutableFloatState maxPx$delegate;
    private final MutableFloatState minPx$delegate;
    private Function1<? super SliderRange, Unit> onValueChange;
    private Function0<Unit> onValueChangeFinished;
    private final MutableFloatState rawOffsetEnd$delegate;
    private final MutableFloatState rawOffsetStart$delegate;
    private final MutableFloatState startThumbHeight$delegate;
    private final MutableFloatState startThumbWidth$delegate;
    private final int steps;
    private final float[] tickFractions;
    private final MutableIntState totalWidth$delegate;
    private final ClosedFloatingPointRange<Float> valueRange;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J.\u0010\u0004\u001a\f\u0012\u0004\u0012\u00020\u0006\u0012\u0002\b\u00030\u00052\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¨\u0006\r"}, d2 = {"Landroidx/compose/material3/RangeSliderState$Companion;", "", "<init>", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/material3/RangeSliderState;", "onValueChangeFinished", "Lkotlin/Function0;", "", "valueRange", "Lkotlin/ranges/ClosedFloatingPointRange;", "", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public static /* synthetic */ RangeSliderState a(Function0 r0, ClosedFloatingPointRange r1, List r2) {
            return Saver$lambda$1(r0, r1, r2);
        }

        public static /* synthetic */ List b(SaverScope r0, RangeSliderState r1) {
            return Saver$lambda$0(r0, r1);
        }

        private static final List Saver$lambda$0(SaverScope r2, RangeSliderState r3) {
            return CollectionsKt.listOf(new Object[]{Float.valueOf(r3.getActiveRangeStart()), Float.valueOf(r3.getActiveRangeEnd()), Integer.valueOf(r3.getSteps())});
        }

        public final Saver<RangeSliderState, ?> Saver(final Function0<Unit> r3, final ClosedFloatingPointRange<Float> r4) {
            return ListSaverKt.listSaver(new vk(), new wk(r3, r4));
        }

        private static final RangeSliderState Saver$lambda$1(Function0 r7, ClosedFloatingPointRange r8, List r9) {
            Object r0 = ListProtector.get(r9, 0);
            Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type kotlin.Float");
            float r2 = ((Float) r0).floatValue();
            Object r1 = ListProtector.get(r9, 1);
            Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type kotlin.Float");
            float r3 = ((Float) r1).floatValue();
            Object r10 = ListProtector.get(r9, 2);
            Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type kotlin.Int");
            return new RangeSliderState(r2, r3, ((Integer) r10).intValue(), r7, r8);
        }
    }

    static {
        Companion = new Companion(null);
        $stable = 8;
    }

    public RangeSliderState() {
        this(MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 0, null, null, 31, null);
    }

    public static /* synthetic */ Unit a(RangeSliderState r0, boolean r1) {
        return gestureEndAction$lambda$0(r0, r1);
    }

    private final float getActiveRangeEndState() {
        return this.activeRangeEndState$delegate.getFloatValue();
    }

    private final float getActiveRangeStartState() {
        return this.activeRangeStartState$delegate.getFloatValue();
    }

    private final float getMaxPx() {
        return this.maxPx$delegate.getFloatValue();
    }

    private final float getMinPx() {
        return this.minPx$delegate.getFloatValue();
    }

    public final float getCoercedActiveRangeEndAsFraction$material3() {
        return SliderKt.access$calcFraction(((Number) this.valueRange.getStart()).floatValue(), ((Number) this.valueRange.getEndInclusive()).floatValue(), getActiveRangeEnd());
    }

    public final float getCoercedActiveRangeStartAsFraction$material3() {
        return SliderKt.access$calcFraction(((Number) this.valueRange.getStart()).floatValue(), ((Number) this.valueRange.getEndInclusive()).floatValue(), getActiveRangeStart());
    }

    public final int getEndSteps$material3() {
        return (int) Math.floor(this.steps * (1.0f - getCoercedActiveRangeStartAsFraction$material3()));
    }

    public final float getEndThumbHeight$material3() {
        return this.endThumbHeight$delegate.getFloatValue();
    }

    public final float getEndThumbWidth$material3() {
        return this.endThumbWidth$delegate.getFloatValue();
    }

    public final float getRawOffsetEnd$material3() {
        return this.rawOffsetEnd$delegate.getFloatValue();
    }

    public final float getRawOffsetStart$material3() {
        return this.rawOffsetStart$delegate.getFloatValue();
    }

    public final int getStartSteps$material3() {
        return (int) Math.floor(this.steps * getCoercedActiveRangeEndAsFraction$material3());
    }

    public final float getStartThumbHeight$material3() {
        return this.startThumbHeight$delegate.getFloatValue();
    }

    public final float getStartThumbWidth$material3() {
        return this.startThumbWidth$delegate.getFloatValue();
    }

    public final int getTotalWidth$material3() {
        return this.totalWidth$delegate.getIntValue();
    }

    public final boolean isDragging$material3() {
        return ((Boolean) this.isDragging$delegate.getValue()).booleanValue();
    }

    public final boolean isRtl$material3() {
        return ((Boolean) this.isRtl$delegate.getValue()).booleanValue();
    }

    public final float getActiveRangeEnd() {
        return getActiveRangeEndState();
    }

    public final float getActiveRangeStart() {
        return getActiveRangeStartState();
    }

    public final void updateMinMaxPx$material3() {
        float r2 = 2;
        float r0 = Math.max(getTotalWidth$material3() - (getEndThumbWidth$material3() / r2), MenuKt.ClosedAlphaTarget);
        float r1 = Math.min(getStartThumbWidth$material3() / r2, r0);
        if (isDragging$material3() == true) goto L21;
        boolean r3 = true;
        if (getMinPx() != r1) goto L7;
        boolean r4 = true;
    L8:
        if (r4 == true) goto L10;
    L19:
        setMinPx(r1);
        setMaxPx(r0);
        setRawOffsetStart$material3(scaleToOffset(getMinPx(), getMaxPx(), getActiveRangeStart()));
        setRawOffsetEnd$material3(scaleToOffset(getMinPx(), getMaxPx(), getActiveRangeEnd()));
        return;
    L10:
        if (getMaxPx() != r0) goto L12;
        boolean r5 = true;
    L13:
        if (r5 == false) goto L19;
        if (getActiveRangeStart() == getActiveRangeEnd()) goto L18;
        r3 = false;
    L18:
        if (r3 == false) goto L19;
        return;
    L12:
        r5 = false;
        goto L13
    L7:
        r4 = false;
        goto L8
    }

    public final Function1<Boolean, Unit> getGestureEndAction$material3() {
        return this.gestureEndAction;
    }

    public final Function1<SliderRange, Unit> getOnValueChange$material3() {
        return this.onValueChange;
    }

    public final Function0<Unit> getOnValueChangeFinished() {
        return this.onValueChangeFinished;
    }

    public final int getSteps() {
        return this.steps;
    }

    public final float[] getTickFractions$material3() {
        return this.tickFractions;
    }

    public final ClosedFloatingPointRange<Float> getValueRange() {
        return this.valueRange;
    }

    private final void setActiveRangeEndState(float r2) {
        this.activeRangeEndState$delegate.setFloatValue(r2);
    }

    private final void setActiveRangeStartState(float r2) {
        this.activeRangeStartState$delegate.setFloatValue(r2);
    }

    private final void setMaxPx(float r2) {
        this.maxPx$delegate.setFloatValue(r2);
    }

    private final void setMinPx(float r2) {
        this.minPx$delegate.setFloatValue(r2);
    }

    public final void setActiveRangeEnd(float r4) {
        setActiveRangeEndState(SliderKt.access$snapValueToTick(RangesKt.coerceIn(r4, getActiveRangeStart(), ((Number) this.valueRange.getEndInclusive()).floatValue()), this.tickFractions, ((Number) this.valueRange.getStart()).floatValue(), ((Number) this.valueRange.getEndInclusive()).floatValue()));
    }

    public final void setActiveRangeStart(float r4) {
        setActiveRangeStartState(SliderKt.access$snapValueToTick(RangesKt.coerceIn(r4, ((Number) this.valueRange.getStart()).floatValue(), getActiveRangeEnd()), this.tickFractions, ((Number) this.valueRange.getStart()).floatValue(), ((Number) this.valueRange.getEndInclusive()).floatValue()));
    }

    public final void setDragging$material3(boolean r2) {
        this.isDragging$delegate.setValue(Boolean.valueOf(r2));
    }

    public final void setEndThumbHeight$material3(float r2) {
        this.endThumbHeight$delegate.setFloatValue(r2);
    }

    public final void setEndThumbWidth$material3(float r2) {
        this.endThumbWidth$delegate.setFloatValue(r2);
    }

    public final void setOnValueChange$material3(Function1<? super SliderRange, Unit> r1) {
        this.onValueChange = r1;
    }

    public final void setOnValueChangeFinished(Function0<Unit> r1) {
        this.onValueChangeFinished = r1;
    }

    public final void setRawOffsetEnd$material3(float r2) {
        this.rawOffsetEnd$delegate.setFloatValue(r2);
    }

    public final void setRawOffsetStart$material3(float r2) {
        this.rawOffsetStart$delegate.setFloatValue(r2);
    }

    public final void setRtl$material3(boolean r2) {
        this.isRtl$delegate.setValue(Boolean.valueOf(r2));
    }

    public final void setStartThumbHeight$material3(float r2) {
        this.startThumbHeight$delegate.setFloatValue(r2);
    }

    public final void setStartThumbWidth$material3(float r2) {
        this.startThumbWidth$delegate.setFloatValue(r2);
    }

    public final void setTotalWidth$material3(int r2) {
        this.totalWidth$delegate.setIntValue(r2);
    }

    private static final Unit gestureEndAction$lambda$0(RangeSliderState r0, boolean r1) {
        Function0<Unit> r2 = r0.onValueChangeFinished;
        if (r2 == null) goto L6;
        r2.invoke();
    L6:
        return Unit.INSTANCE;
    }

    public final void onDrag$material3(boolean r9, float r10) {
        if (r9 == false) goto L4;
        setRawOffsetStart$material3(getRawOffsetStart$material3() + r10);
        setRawOffsetEnd$material3(scaleToOffset(getMinPx(), getMaxPx(), getActiveRangeEnd()));
        float r11 = getRawOffsetEnd$material3();
        long r0 = SliderKt.SliderRange(RangesKt.coerceAtMost(SliderKt.access$snapValueToTick(RangesKt.coerceIn(getRawOffsetStart$material3(), getMinPx(), r11), this.tickFractions, getMinPx(), getMaxPx()), r11), r11);
    L5:
        float r4 = getMinPx();
        float r5 = getMaxPx();
        long r12 = m3022scaleToUserValue8bqG3aw(r9, r4, r5, r0);
        if (SliderRange.m3185equalsimpl0(r12, SliderKt.SliderRange(getActiveRangeStart(), getActiveRangeEnd())) == true) goto L13;
        Function1<? super SliderRange, Unit> r1 = this.onValueChange;
        if (r1 == null) goto L11;
        if (r1 == null) goto L14;
        r1.invoke(SliderRange.m3182boximpl(r12));
        return;
    L14:
        return;
    L11:
        setActiveRangeStart(SliderRange.m3187getStartimpl(r12));
        setActiveRangeEnd(SliderRange.m3186getEndInclusiveimpl(r12));
        return;
    L13:
        return;
    L4:
        setRawOffsetEnd$material3(getRawOffsetEnd$material3() + r10);
        setRawOffsetStart$material3(scaleToOffset(getMinPx(), getMaxPx(), getActiveRangeStart()));
        float r13 = getRawOffsetStart$material3();
        r0 = SliderKt.SliderRange(r13, RangesKt.coerceAtLeast(SliderKt.access$snapValueToTick(RangesKt.coerceIn(getRawOffsetEnd$material3(), r13, getMaxPx()), this.tickFractions, getMinPx(), getMaxPx()), r13));
        goto L5
    }

    private final float scaleToOffset(float r3, float r4, float r5) {
        return SliderKt.access$scale(((Number) this.valueRange.getStart()).floatValue(), ((Number) this.valueRange.getEndInclusive()).floatValue(), r5, r3, r4);
    }

    /* JADX INFO: renamed from: scaleToUserValue-8bqG3aw, reason: not valid java name */
    private final long m3022scaleToUserValue8bqG3aw(boolean r9, float r10, float r11, long r12) {
        return SliderKt.m3173access$scale2geJ7wY(r9, r10, r11, r12, ((Number) this.valueRange.getStart()).floatValue(), ((Number) this.valueRange.getEndInclusive()).floatValue());
    }

    public RangeSliderState(float r1, float r2, int r3, Function0<Unit> r4, ClosedFloatingPointRange<Float> r5) {
        this.steps = r3;
        this.onValueChangeFinished = r4;
        this.valueRange = r5;
        this.activeRangeStartState$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(r1);
        this.activeRangeEndState$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(r2);
        this.tickFractions = SliderKt.access$stepsToTickFractions(r3);
        this.startThumbWidth$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(MenuKt.ClosedAlphaTarget);
        this.startThumbHeight$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(MenuKt.ClosedAlphaTarget);
        this.endThumbWidth$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(MenuKt.ClosedAlphaTarget);
        this.endThumbHeight$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(MenuKt.ClosedAlphaTarget);
        this.totalWidth$delegate = SnapshotIntStateKt.mutableIntStateOf(0);
        this.rawOffsetStart$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(MenuKt.ClosedAlphaTarget);
        this.rawOffsetEnd$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(MenuKt.ClosedAlphaTarget);
        Boolean r6 = Boolean.FALSE;
        this.isDragging$delegate = SnapshotStateKt.mutableStateOf$default(r6, null, 2, null);
        this.isRtl$delegate = SnapshotStateKt.mutableStateOf$default(r6, null, 2, null);
        this.gestureEndAction = new uk(this);
        this.maxPx$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(MenuKt.ClosedAlphaTarget);
        this.minPx$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(MenuKt.ClosedAlphaTarget);
    }

    public /* synthetic */ RangeSliderState(float r6, float r7, int r8, Function0 r9, ClosedFloatingPointRange r10, int r11, DefaultConstructorMarker r12) {
        if ((r11 & 1) == 0) goto L5;
        float r13 = MenuKt.ClosedAlphaTarget;
    L7:
        if ((r11 & 2) == 0) goto L9;
        float r2 = 1.0f;
    L11:
        if ((r11 & 4) == 0) goto L13;
        int r3 = 0;
    L15:
        if ((r11 & 8) == 0) goto L17;
        r9 = null;
    L17:
        Function0 r4 = r9;
        if ((r11 & 16) == 0) goto L20;
        r10 = RangesKt.rangeTo(MenuKt.ClosedAlphaTarget, 1.0f);
    L20:
        float r14 = r13;
        float r15 = r2;
        int r16 = r3;
        this(r14, r15, r16, r4, r10);
        return;
    L13:
        r3 = r8;
        goto L15
    L9:
        r2 = r7;
        goto L11
    L5:
        r13 = r6;
        goto L7
    }
}
