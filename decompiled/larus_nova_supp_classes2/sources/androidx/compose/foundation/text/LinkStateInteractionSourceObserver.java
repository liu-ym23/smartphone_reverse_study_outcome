package androidx.compose.foundation.text;

import androidx.collection.MutableObjectList;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.SnapshotIntStateKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\f\u001a\u00020\rH\u0086@¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000f\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0013\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011¨\u0006\u0014"}, d2 = {"Landroidx/compose/foundation/text/LinkStateInteractionSourceObserver;", "", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "<init>", "(Landroidx/compose/foundation/interaction/InteractionSource;)V", "Focused", "", "Hovered", "Pressed", "interactionState", "Landroidx/compose/runtime/MutableIntState;", "collectInteractionsForLinks", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isFocused", "", "()Z", "isHovered", "isPressed", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LinkStateInteractionSourceObserver {
    public static final int $stable = 0;
    private final int Focused;
    private final int Hovered;
    private final int Pressed;
    private final InteractionSource interactionSource;
    private final MutableIntState interactionState;

    public final boolean isFocused() {
        if ((this.interactionState.getIntValue() & this.Focused) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isHovered() {
        if ((this.interactionState.getIntValue() & this.Hovered) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isPressed() {
        if ((this.interactionState.getIntValue() & this.Pressed) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public LinkStateInteractionSourceObserver(InteractionSource r1) {
        this.interactionSource = r1;
        this.Focused = 1;
        this.Hovered = 2;
        this.Pressed = 4;
        this.interactionState = SnapshotIntStateKt.mutableIntStateOf(0);
    }

    public static final /* synthetic */ int access$getFocused$p(LinkStateInteractionSourceObserver r0) {
        return r0.Focused;
    }

    public static final /* synthetic */ int access$getHovered$p(LinkStateInteractionSourceObserver r0) {
        return r0.Hovered;
    }

    public static final /* synthetic */ MutableIntState access$getInteractionState$p(LinkStateInteractionSourceObserver r0) {
        return r0.interactionState;
    }

    public static final /* synthetic */ int access$getPressed$p(LinkStateInteractionSourceObserver r0) {
        return r0.Pressed;
    }

    public final Object collectInteractionsForLinks(Continuation<? super Unit> r5) {
        int r3 = 0;
        final MutableObjectList r0 = new MutableObjectList(r3, 1, null);
        Object r6 = this.interactionSource.getInteractions().collect(new AnonymousClass2(r0, this), r5);
        if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r6;
    L6:
        return Unit.INSTANCE;
    }
}
