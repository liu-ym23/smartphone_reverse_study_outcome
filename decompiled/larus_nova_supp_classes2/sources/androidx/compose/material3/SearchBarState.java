package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.saveable.ListSaverKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.ui.layout.LayoutCoordinates;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 +2\u00020\u0001:\u0001+B9\b\u0002\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007¢\u0006\u0004\b\t\u0010\nB-\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007¢\u0006\u0004\b\t\u0010\rJ\u000e\u0010$\u001a\u00020%H\u0086@¢\u0006\u0002\u0010&J\u000e\u0010'\u001a\u00020%H\u0086@¢\u0006\u0002\u0010&J\u0016\u0010(\u001a\u00020%2\u0006\u0010)\u001a\u00020\u0004H\u0086@¢\u0006\u0002\u0010*R\u001a\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R/\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0017\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001a\u001a\u00020\u001b8F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001cR\u0011\u0010\u001d\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u001b\u0010 \u001a\u00020\f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b!\u0010\u001f¨\u0006,"}, d2 = {"Landroidx/compose/material3/SearchBarState;", "", "animatable", "Landroidx/compose/animation/core/Animatable;", "", "Landroidx/compose/animation/core/AnimationVector1D;", "animationSpecForExpand", "Landroidx/compose/animation/core/AnimationSpec;", "animationSpecForCollapse", "<init>", "(Landroidx/compose/animation/core/Animatable;Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/animation/core/AnimationSpec;)V", "initialValue", "Landroidx/compose/material3/SearchBarValue;", "(Landroidx/compose/material3/SearchBarValue;Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/animation/core/AnimationSpec;)V", "<set-?>", "Landroidx/compose/ui/layout/LayoutCoordinates;", "collapsedCoords", "getCollapsedCoords", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "setCollapsedCoords", "(Landroidx/compose/ui/layout/LayoutCoordinates;)V", "collapsedCoords$delegate", "Landroidx/compose/runtime/MutableState;", "progress", "getProgress", "()F", "isAnimating", "", "()Z", "targetValue", "getTargetValue", "()Landroidx/compose/material3/SearchBarValue;", "currentValue", "getCurrentValue", "currentValue$delegate", "Landroidx/compose/runtime/State;", "animateToExpanded", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animateToCollapsed", "snapTo", "fraction", "(FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SearchBarState {
    public static final int $stable = 0;
    private static final float Collapsed = 0.0f;
    public static final Companion Companion = null;
    private static final float Expanded = 1.0f;
    private final Animatable<Float, AnimationVector1D> animatable;
    private final AnimationSpec<Float> animationSpecForCollapse;
    private final AnimationSpec<Float> animationSpecForExpand;
    private final MutableState collapsedCoords$delegate;
    private final State currentValue$delegate;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J,\u0010\u0007\u001a\f\u0012\u0004\u0012\u00020\t\u0012\u0002\b\u00030\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Landroidx/compose/material3/SearchBarState$Companion;", "", "<init>", "()V", "Collapsed", "", "Expanded", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/material3/SearchBarState;", "animationSpecForExpand", "Landroidx/compose/animation/core/AnimationSpec;", "animationSpecForCollapse", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public static /* synthetic */ List a(SaverScope r0, SearchBarState r1) {
            return Saver$lambda$0(r0, r1);
        }

        public static /* synthetic */ SearchBarState b(AnimationSpec r0, AnimationSpec r1, List r2) {
            return Saver$lambda$1(r0, r1, r2);
        }

        private static final List Saver$lambda$0(SaverScope r0, SearchBarState r1) {
            return CollectionsKt.listOf(Float.valueOf(r1.getProgress()));
        }

        public final Saver<SearchBarState, ?> Saver(final AnimationSpec<Float> r3, final AnimationSpec<Float> r4) {
            return ListSaverKt.listSaver(new bn(), new cn(r3, r4));
        }

        private static final SearchBarState Saver$lambda$1(AnimationSpec r9, AnimationSpec r10, List r11) {
            return new SearchBarState(new Animatable(ListProtector.get(r11, 0), VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE), null, null, 12, null), r9, r10, null);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public /* synthetic */ SearchBarState(Animatable r1, AnimationSpec r2, AnimationSpec r3, DefaultConstructorMarker r4) {
        this(r1, r2, r3);
    }

    public static /* synthetic */ SearchBarValue a(SearchBarState r0) {
        return currentValue_delegate$lambda$0(r0);
    }

    public final LayoutCoordinates getCollapsedCoords() {
        return (LayoutCoordinates) this.collapsedCoords$delegate.getValue();
    }

    public final SearchBarValue getCurrentValue() {
        return (SearchBarValue) this.currentValue$delegate.getValue();
    }

    public final float getProgress() {
        return RangesKt.coerceIn(this.animatable.getValue().floatValue(), 0.0f, 1.0f);
    }

    public final SearchBarValue getTargetValue() {
        if (this.animatable.getTargetValue().floatValue() != 1.0f) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        return SearchBarValue.Expanded;
    L9:
        return SearchBarValue.Collapsed;
    L5:
        r0 = false;
        goto L6
    }

    public final boolean isAnimating() {
        return this.animatable.isRunning();
    }

    private static final SearchBarValue currentValue_delegate$lambda$0(SearchBarState r1) {
        if (r1.animatable.getValue().floatValue() != 0.0f) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L9;
        return SearchBarValue.Collapsed;
    L9:
        return SearchBarValue.Expanded;
    L5:
        r2 = false;
        goto L6
    }

    public final Object animateToCollapsed(Continuation<? super Unit> r9) {
        Object r10 = Animatable.animateTo$default(this.animatable, Boxing.boxFloat(0.0f), this.animationSpecForCollapse, null, null, r9, 12, null);
        if (r10 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r10;
    L6:
        return Unit.INSTANCE;
    }

    public final Object animateToExpanded(Continuation<? super Unit> r9) {
        Object r10 = Animatable.animateTo$default(this.animatable, Boxing.boxFloat(1.0f), this.animationSpecForExpand, null, null, r9, 12, null);
        if (r10 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r10;
    L6:
        return Unit.INSTANCE;
    }

    public final void setCollapsedCoords(LayoutCoordinates r2) {
        this.collapsedCoords$delegate.setValue(r2);
    }

    public final Object snapTo(float r2, Continuation<? super Unit> r3) {
        Object r4 = this.animatable.snapTo(Boxing.boxFloat(r2), r3);
        if (r4 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r4;
    L6:
        return Unit.INSTANCE;
    }

    private SearchBarState(Animatable<Float, AnimationVector1D> r1, AnimationSpec<Float> r2, AnimationSpec<Float> r3) {
        this.animatable = r1;
        this.animationSpecForExpand = r2;
        this.animationSpecForCollapse = r3;
        this.collapsedCoords$delegate = SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.currentValue$delegate = SnapshotStateKt.derivedStateOf(new an(this));
    }

    public SearchBarState(SearchBarValue r4, AnimationSpec<Float> r5, AnimationSpec<Float> r6) {
        if (r4 != SearchBarValue.Expanded) goto L5;
        float r7 = 1.0f;
    L6:
        this(AnimatableKt.Animatable$default(r7, 0.0f, 2, null), r5, r6);
        return;
    L5:
        r7 = 0.0f;
        goto L6
    }
}
