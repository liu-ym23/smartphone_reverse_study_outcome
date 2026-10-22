package androidx.compose.material3;

import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.focus.FocusRequesterModifierKt;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J#\u0010\u0002\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0014\u0010\u0010\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0007H\u0016R\u0014\u0010\n\u001a\u00020\u00058PX\u0090\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00078PX\u0090\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"androidx/compose/material3/ExposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1", "Landroidx/compose/material3/ExposedDropdownMenuBoxScopeImpl;", "menuAnchor", "Landroidx/compose/ui/Modifier;", "type", "Landroidx/compose/material3/ExposedDropdownMenuAnchorType;", "enabled", "", "menuAnchor-2Hz36ac", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;Z)Landroidx/compose/ui/Modifier;", "anchorType", "getAnchorType-oYjWRB4$material3", "()Ljava/lang/String;", "alwaysFocusable", "getAlwaysFocusable$material3", "()Z", "exposedDropdownSize", "matchAnchorWidth", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ExposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1 extends ExposedDropdownMenuBoxScopeImpl {
    final /* synthetic */ MutableState<Boolean> $alwaysFocusable;
    final /* synthetic */ MutableState<ExposedDropdownMenuAnchorType> $anchorTypeState;
    final /* synthetic */ MutableIntState $anchorWidth$delegate;
    final /* synthetic */ String $collapsedDescription;
    final /* synthetic */ boolean $expanded;
    final /* synthetic */ String $expandedDescription;
    final /* synthetic */ FocusRequester $focusRequester;
    final /* synthetic */ SoftwareKeyboardController $keyboardController;
    final /* synthetic */ MutableIntState $menuMaxHeight$delegate;
    final /* synthetic */ Function1<Boolean, Unit> $onExpandedChange;
    final /* synthetic */ String $toggleDescription;

    public static /* synthetic */ Unit f(MutableState r0, String r1, Function1 r2, boolean r3) {
        return menuAnchor_2Hz36ac$lambda$1(r0, r1, r2, r3);
    }

    public static /* synthetic */ MeasureResult g(boolean r0, MutableIntState r1, MutableIntState r2, MeasureScope r3, Measurable r4, Constraints r5) {
        return exposedDropdownSize$lambda$3(r0, r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ Unit h(Placeable r0, Placeable.PlacementScope r1) {
        return exposedDropdownSize$lambda$3$lambda$2(r0, r1);
    }

    public static /* synthetic */ Unit i(String r0, MutableState r1) {
        return menuAnchor_2Hz36ac$lambda$0(r0, r1);
    }

    @Override // androidx.compose.material3.ExposedDropdownMenuBoxScope
    public boolean getAlwaysFocusable$material3() {
        return ((Boolean) this.$alwaysFocusable.getValue()).booleanValue();
    }

    @Override // androidx.compose.material3.ExposedDropdownMenuBoxScope
    /* JADX INFO: renamed from: getAnchorType-oYjWRB4$material3 */
    public String mo2681getAnchorTypeoYjWRB4$material3() {
        return ((ExposedDropdownMenuAnchorType) this.$anchorTypeState.getValue()).m2674unboximpl();
    }

    private static final Unit exposedDropdownSize$lambda$3$lambda$2(Placeable r7, Placeable.PlacementScope r8) {
        Placeable.PlacementScope.place$default(r8, r7, 0, 0, MenuKt.ClosedAlphaTarget, 4, null);
        return Unit.INSTANCE;
    }

    private static final Unit menuAnchor_2Hz36ac$lambda$0(String r1, MutableState r2) {
        if (ExposedDropdownMenuKt.m2690access$hasGreaterOrEqualPriorityThanvVDBVkM(r1, ((ExposedDropdownMenuAnchorType) r2.getValue()).m2674unboximpl()) == false) goto L6;
        r2.setValue(ExposedDropdownMenuAnchorType.m2668boximpl(r1));
    L6:
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.material3.ExposedDropdownMenuBoxScope
    public Modifier exposedDropdownSize(Modifier r4, final boolean r5) {
        final MutableIntState r0 = this.$anchorWidth$delegate;
        final MutableIntState r1 = this.$menuMaxHeight$delegate;
        return LayoutModifierKt.layout(r4, new bb(r5, r0, r1));
    }

    @Override // androidx.compose.material3.ExposedDropdownMenuBoxScope
    /* JADX INFO: renamed from: menuAnchor-2Hz36ac */
    public Modifier mo2682menuAnchor2Hz36ac(Modifier r10, final String r11, boolean r12) {
        Modifier r13 = FocusRequesterModifierKt.focusRequester(r10, this.$focusRequester);
        final MutableState<ExposedDropdownMenuAnchorType> r1 = this.$anchorTypeState;
        Modifier r14 = r13.then(new ExposedDropdownMenuAnchorElement(new cb(r11, r1)));
        if (r12 == true) goto L5;
        Modifier.Companion r15 = Modifier.Companion;
    L7:
        return r14.then(r15);
    L5:
        Modifier.Companion r0 = Modifier.Companion;
        final boolean r2 = this.$expanded;
        final MutableState<ExposedDropdownMenuAnchorType> r16 = this.$anchorTypeState;
        final Function1<Boolean, Unit> r3 = this.$onExpandedChange;
        r15 = ExposedDropdownMenuKt.m2689access$expandable32CpT8(r0, r2, new db(r16, r11, r3, r2), r11, this.$alwaysFocusable, this.$expandedDescription, this.$collapsedDescription, this.$toggleDescription, this.$keyboardController);
        goto L7
    }

    private static final Unit menuAnchor_2Hz36ac$lambda$1(MutableState r0, String r1, Function1 r2, boolean r3) {
        r0.setValue(ExposedDropdownMenuAnchorType.m2668boximpl(r1));
        r2.invoke(Boolean.valueOf(!r3));
        return Unit.INSTANCE;
    }

    private static final MeasureResult exposedDropdownSize$lambda$3(boolean r10, MutableIntState r11, MutableIntState r12, MeasureScope r13, Measurable r14, Constraints r15) {
        int r16 = ConstraintsKt.constrainWidth-K40F9xA(r15.unbox-impl(), ExposedDropdownMenuKt.access$ExposedDropdownMenuBox$lambda$5(r11));
        int r7 = ConstraintsKt.constrainHeight-K40F9xA(r15.unbox-impl(), ExposedDropdownMenuKt.access$ExposedDropdownMenuBox$lambda$8(r12));
        if (r10 == false) goto L5;
        int r4 = r16;
    L6:
        if (r10 == true) goto L9;
        r16 = Constraints.getMaxWidth-impl(r15.unbox-impl());
    L9:
        long r2 = r15.unbox-impl();
        final Placeable r17 = r14.measure-BRTryo0(Constraints.copy-Zbe2FdA$default(r2, r4, r16, 0, r7, 4, null));
        return MeasureScope.-CC.layout$default(r13, r17.getWidth(), r17.getHeight(), null, new ab(r17), 4, null);
    L5:
        r4 = Constraints.getMinWidth-impl(r15.unbox-impl());
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ExposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1(FocusRequester r1, boolean r2, MutableState<Boolean> r3, String r4, String r5, String r6, SoftwareKeyboardController r7, MutableState<ExposedDropdownMenuAnchorType> r8, Function1<? super Boolean, Unit> r9, MutableIntState r10, MutableIntState r11) {
        this.$focusRequester = r1;
        this.$expanded = r2;
        this.$alwaysFocusable = r3;
        this.$expandedDescription = r4;
        this.$collapsedDescription = r5;
        this.$toggleDescription = r6;
        this.$keyboardController = r7;
        this.$anchorTypeState = r8;
        this.$onExpandedChange = r9;
        this.$anchorWidth$delegate = r10;
        this.$menuMaxHeight$delegate = r11;
    }
}
