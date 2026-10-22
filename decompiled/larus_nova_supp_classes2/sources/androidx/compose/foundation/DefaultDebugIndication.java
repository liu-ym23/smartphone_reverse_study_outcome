package androidx.compose.foundation;

import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.material3.MenuKt;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DrawModifierNode;
import kotlin.Metadata;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\u00020\u0001:\u0001\u000eB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\tH\u0016J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0096\u0002¨\u0006\u000f"}, d2 = {"Landroidx/compose/foundation/DefaultDebugIndication;", "Landroidx/compose/foundation/IndicationNodeFactory;", "<init>", "()V", "create", "Landroidx/compose/ui/node/DelegatableNode;", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "hashCode", "", "equals", "", "other", "", "DefaultDebugIndicationInstance", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class DefaultDebugIndication implements IndicationNodeFactory {
    public static final DefaultDebugIndication INSTANCE = null;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u000b\u001a\u00020\fH\u0016J\f\u0010\r\u001a\u00020\f*\u00020\u000eH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Landroidx/compose/foundation/DefaultDebugIndication$DefaultDebugIndicationInstance;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/DrawModifierNode;", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "<init>", "(Landroidx/compose/foundation/interaction/InteractionSource;)V", "isPressed", "", "isHovered", "isFocused", "onAttach", "", "draw", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultDebugIndicationInstance extends Modifier.Node implements DrawModifierNode {
        private final InteractionSource interactionSource;
        private boolean isFocused;
        private boolean isHovered;
        private boolean isPressed;

        public final /* synthetic */ void onMeasureResultChanged() {
            DrawModifierNode.-CC.$default$onMeasureResultChanged(this);
        }

        public void onAttach() {
            BuildersKt.launch$default(getCoroutineScope(), null, null, new DefaultDebugIndication$DefaultDebugIndicationInstance$onAttach$1(this, null), 3, null);
        }

        public DefaultDebugIndicationInstance(InteractionSource r1) {
            this.interactionSource = r1;
        }

        public static final /* synthetic */ InteractionSource access$getInteractionSource$p(DefaultDebugIndicationInstance r0) {
            return r0.interactionSource;
        }

        public static final /* synthetic */ boolean access$isFocused$p(DefaultDebugIndicationInstance r0) {
            return r0.isFocused;
        }

        public static final /* synthetic */ boolean access$isHovered$p(DefaultDebugIndicationInstance r0) {
            return r0.isHovered;
        }

        public static final /* synthetic */ boolean access$isPressed$p(DefaultDebugIndicationInstance r0) {
            return r0.isPressed;
        }

        public void draw(ContentDrawScope r24) {
            r24.drawContent();
            if (this.isPressed == false) goto L6;
            DrawScope.-CC.drawRect-n-J9OG0$default(r24, Color.copy-wmQWz5c$default(Color.Companion.getBlack-0d7_KjU(), 0.3f, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null), 0, r24.getSize-NH-jbRc(), MenuKt.ClosedAlphaTarget, null, null, 0, 122, null);
            return;
        L6:
            if (this.isHovered == false) goto L8;
        L9:
            DrawScope.-CC.drawRect-n-J9OG0$default(r24, Color.copy-wmQWz5c$default(Color.Companion.getBlack-0d7_KjU(), 0.1f, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null), 0, r24.getSize-NH-jbRc(), MenuKt.ClosedAlphaTarget, null, null, 0, 122, null);
            return;
        L8:
            if (this.isFocused == true) goto L9;
        }

        public static final /* synthetic */ void access$setFocused$p(DefaultDebugIndicationInstance r0, boolean r1) {
            r0.isFocused = r1;
        }

        public static final /* synthetic */ void access$setHovered$p(DefaultDebugIndicationInstance r0, boolean r1) {
            r0.isHovered = r1;
        }

        public static final /* synthetic */ void access$setPressed$p(DefaultDebugIndicationInstance r0, boolean r1) {
            r0.isPressed = r1;
        }
    }

    static {
        INSTANCE = new DefaultDebugIndication();
    }

    private DefaultDebugIndication() {
    }

    @Override // androidx.compose.foundation.IndicationNodeFactory
    public boolean equals(Object r1) {
        if (r1 != this) goto L4;
        return true;
    L4:
        return false;
    }

    @Override // androidx.compose.foundation.IndicationNodeFactory
    public int hashCode() {
        return -1;
    }

    @Override // androidx.compose.foundation.Indication
    public final /* synthetic */ IndicationInstance rememberUpdatedInstance(InteractionSource r1, Composer r2, int r3) {
        return Indication.CC.$default$rememberUpdatedInstance(this, r1, r2, r3);
    }

    @Override // androidx.compose.foundation.IndicationNodeFactory
    public DelegatableNode create(InteractionSource r2) {
        return new DefaultDebugIndicationInstance(r2);
    }
}
