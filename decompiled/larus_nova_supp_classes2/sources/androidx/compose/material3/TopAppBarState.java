package androidx.compose.material3;

import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.saveable.ListSaverKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverScope;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR$\u0010\u000e\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00038F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\fR+\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00038F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\n\"\u0004\b\u0014\u0010\fR\u0011\u0010\u0017\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\nR\u0011\u0010\u0019\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\nR\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Landroidx/compose/material3/TopAppBarState;", "", "initialHeightOffsetLimit", "", "initialHeightOffset", "initialContentOffset", "<init>", "(FFF)V", "heightOffsetLimit", "getHeightOffsetLimit", "()F", "setHeightOffsetLimit", "(F)V", "newOffset", "heightOffset", "getHeightOffset", "setHeightOffset", "<set-?>", "contentOffset", "getContentOffset", "setContentOffset", "contentOffset$delegate", "Landroidx/compose/runtime/MutableFloatState;", "collapsedFraction", "getCollapsedFraction", "overlappedFraction", "getOverlappedFraction", "_heightOffset", "Landroidx/compose/runtime/MutableFloatState;", "Companion", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TopAppBarState {
    public static final int $stable = 0;
    public static final Companion Companion = null;
    private static final Saver<TopAppBarState, ?> Saver = null;
    private MutableFloatState _heightOffset;
    private final MutableFloatState contentOffset$delegate;
    private float heightOffsetLimit;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001b\u0010\u0004\u001a\f\u0012\u0004\u0012\u00020\u0006\u0012\u0002\b\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroidx/compose/material3/TopAppBarState$Companion;", "", "<init>", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/material3/TopAppBarState;", "getSaver", "()Landroidx/compose/runtime/saveable/Saver;", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final Saver<TopAppBarState, ?> getSaver() {
            return TopAppBarState.access$getSaver$cp();
        }
    }

    public static /* synthetic */ List a(SaverScope r0, TopAppBarState r1) {
        return Saver$lambda$0(r0, r1);
    }

    public static /* synthetic */ TopAppBarState b(List r0) {
        return Saver$lambda$1(r0);
    }

    static {
        Companion = new Companion(null);
        Saver = ListSaverKt.listSaver(new px(), new qx());
    }

    public final float getCollapsedFraction() {
        if (this.heightOffsetLimit != MenuKt.ClosedAlphaTarget) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return MenuKt.ClosedAlphaTarget;
    L8:
        return getHeightOffset() / this.heightOffsetLimit;
    L5:
        r0 = false;
        goto L6
    }

    public final float getContentOffset() {
        return this.contentOffset$delegate.getFloatValue();
    }

    public final float getHeightOffset() {
        return this._heightOffset.getFloatValue();
    }

    public final float getOverlappedFraction() {
        float r0 = this.heightOffsetLimit;
        if (r0 != MenuKt.ClosedAlphaTarget) goto L5;
        boolean r3 = true;
    L6:
        if (r3 == false) goto L8;
        return MenuKt.ClosedAlphaTarget;
    L8:
        return 1 - (RangesKt.coerceIn(r0 - getContentOffset(), this.heightOffsetLimit, MenuKt.ClosedAlphaTarget) / this.heightOffsetLimit);
    L5:
        r3 = false;
        goto L6
    }

    public static final /* synthetic */ Saver access$getSaver$cp() {
        return Saver;
    }

    public final float getHeightOffsetLimit() {
        return this.heightOffsetLimit;
    }

    private static final TopAppBarState Saver$lambda$1(List r4) {
        return new TopAppBarState(((Number) ListProtector.get(r4, 0)).floatValue(), ((Number) ListProtector.get(r4, 1)).floatValue(), ((Number) ListProtector.get(r4, 2)).floatValue());
    }

    public final void setContentOffset(float r2) {
        this.contentOffset$delegate.setFloatValue(r2);
    }

    public final void setHeightOffset(float r4) {
        this._heightOffset.setFloatValue(RangesKt.coerceIn(r4, this.heightOffsetLimit, MenuKt.ClosedAlphaTarget));
    }

    public final void setHeightOffsetLimit(float r1) {
        this.heightOffsetLimit = r1;
    }

    private static final List Saver$lambda$0(SaverScope r2, TopAppBarState r3) {
        return CollectionsKt.listOf(new Float[]{Float.valueOf(r3.heightOffsetLimit), Float.valueOf(r3.getHeightOffset()), Float.valueOf(r3.getContentOffset())});
    }

    public TopAppBarState(float r1, float r2, float r3) {
        this.heightOffsetLimit = r1;
        this.contentOffset$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(r3);
        this._heightOffset = PrimitiveSnapshotStateKt.mutableFloatStateOf(r2);
    }
}
