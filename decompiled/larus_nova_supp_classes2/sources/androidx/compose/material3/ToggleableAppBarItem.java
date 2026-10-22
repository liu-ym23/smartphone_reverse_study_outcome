package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001BF\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0011\u0010\u0007\u001a\r\u0012\u0004\u0012\u00020\u00060\b¢\u0006\u0002\b\t\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u0010\u001a\u00020\u0006H\u0017¢\u0006\u0002\u0010\u0011J\u0015\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0014H\u0017¢\u0006\u0002\u0010\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\r\u0012\u0004\u0012\u00020\u00060\b¢\u0006\u0002\b\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000fR\u000e\u0010\n\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Landroidx/compose/material3/ToggleableAppBarItem;", "Landroidx/compose/material3/AppBarItem;", "checked", "", "onCheckedChange", "Lkotlin/Function1;", "", "icon", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "enabled", "label", "", "<init>", "(ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;ZLjava/lang/String;)V", "Lkotlin/jvm/functions/Function2;", "AppbarContent", "(Landroidx/compose/runtime/Composer;I)V", "MenuContent", "state", "Landroidx/compose/material3/AppBarMenuState;", "(Landroidx/compose/material3/AppBarMenuState;Landroidx/compose/runtime/Composer;I)V", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ToggleableAppBarItem implements AppBarItem {
    public static final int $stable = 0;
    private final boolean checked;
    private final boolean enabled;
    private final Function2<Composer, Integer, Unit> icon;
    private final String label;
    private final Function1<Boolean, Unit> onCheckedChange;

    private static final Unit AppbarContent$lambda$0(ToggleableAppBarItem r0, int r1, Composer r2, int r3) {
        r0.AppbarContent(r2, RecomposeScopeImplKt.updateChangedFlags(r1 | 1));
        return Unit.INSTANCE;
    }

    private static final Unit MenuContent$lambda$3(ToggleableAppBarItem r0, AppBarMenuState r1, int r2, Composer r3, int r4) {
        r0.MenuContent(r1, r3, RecomposeScopeImplKt.updateChangedFlags(r2 | 1));
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(ToggleableAppBarItem r0, AppBarMenuState r1) {
        return MenuContent$lambda$2$lambda$1(r0, r1);
    }

    public static /* synthetic */ Unit b(ToggleableAppBarItem r0, AppBarMenuState r1, int r2, Composer r3, int r4) {
        return MenuContent$lambda$3(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ Unit c(ToggleableAppBarItem r0, int r1, Composer r2, int r3) {
        return AppbarContent$lambda$0(r0, r1, r2, r3);
    }

    public static final /* synthetic */ boolean access$getChecked$p(ToggleableAppBarItem r0) {
        return r0.checked;
    }

    public static final /* synthetic */ boolean access$getEnabled$p(ToggleableAppBarItem r0) {
        return r0.enabled;
    }

    public static final /* synthetic */ Function2 access$getIcon$p(ToggleableAppBarItem r0) {
        return r0.icon;
    }

    public static final /* synthetic */ String access$getLabel$p(ToggleableAppBarItem r0) {
        return r0.label;
    }

    public static final /* synthetic */ Function1 access$getOnCheckedChange$p(ToggleableAppBarItem r0) {
        return r0.onCheckedChange;
    }

    private static final Unit MenuContent$lambda$2$lambda$1(ToggleableAppBarItem r1, AppBarMenuState r2) {
        r1.onCheckedChange.invoke(Boolean.valueOf(!r1.checked));
        r2.dismiss();
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.material3.AppBarItem
    public void AppbarContent(Composer r19, final int r20) {
        Composer r15 = r19.startRestartGroup(-53051696);
        if ((r20 & 6) == 0) goto L5;
        int r3 = r20;
    L11:
        if ((r3 & 3) == 2) goto L13;
        boolean r4 = true;
    L15:
        if (r15.shouldExecute(r4, r3 & 1) == true) goto L17;
        r15.skipToGroupEnd();
    L23:
        ScopeUpdateScope r2 = r15.endRestartGroup();
        if (r2 == null) goto L27;
        r2.updateScope(new pw(this, r20));
        return;
    L27:
        return;
    L17:
        if (ComposerKt.isTraceInProgress() == false) goto L19;
        ComposerKt.traceEventStart(-53051696, r3, -1, "androidx.compose.material3.ToggleableAppBarItem.AppbarContent (AppBarDsl.kt:193)");
    L19:
        TooltipKt.TooltipBox(TooltipDefaults.INSTANCE.m3549rememberTooltipPositionProviderHu5FAss(TooltipAnchorPosition.Companion.m3535getAbovelOKsHw4(), MenuKt.ClosedAlphaTarget, r15, 390, 2), ComposableLambdaKt.rememberComposableLambda(-1965247803, true, new AnonymousClass1(this), r15, 54), TooltipKt.rememberTooltipState(false, false, null, r15, 0, 7), null, null, false, false, false, ComposableLambdaKt.rememberComposableLambda(694023085, true, new AnonymousClass2(this), r15, 54), r15, 100663344, 248);
        if (ComposerKt.isTraceInProgress() == false) goto L23;
        ComposerKt.traceEventEnd();
        goto L23
    L13:
        r4 = false;
        goto L15
    L5:
        if (r15.changed(this) == false) goto L7;
        int r5 = 4;
    L8:
        r3 = r5 | r20;
        goto L11
    L7:
        r5 = 2;
        goto L8
    }

    @Override // androidx.compose.material3.AppBarItem
    public void MenuContent(final AppBarMenuState r18, Composer r19, final int r20) {
        Composer r15 = r19.startRestartGroup(-1187385573);
        if ((r20 & 6) == 0) goto L5;
        int r4 = r20;
    L11:
        if ((r20 & 48) == 0) goto L13;
    L17:
        boolean r9 = false;
        if ((r4 & 19) == 18) goto L20;
        boolean r6 = true;
    L22:
        if (r15.shouldExecute(r6, r4 & 1) == true) goto L24;
        Composer r3 = r15;
        r3.skipToGroupEnd();
    L42:
        ScopeUpdateScope r5 = r3.endRestartGroup();
        if (r5 == null) goto L46;
        r5.updateScope(new rw(this, r18, r20));
        return;
    L46:
        return;
    L24:
        if (ComposerKt.isTraceInProgress() == false) goto L26;
        ComposerKt.traceEventStart(-1187385573, r4, -1, "androidx.compose.material3.ToggleableAppBarItem.MenuContent (AppBarDsl.kt:211)");
    L26:
        boolean r7 = this.enabled;
        ComposableLambda r8 = ComposableLambdaKt.rememberComposableLambda(-269621941, true, new C02821(this), r15, 54);
        if ((r4 & 112) != 32) goto L29;
        boolean r10 = true;
    L31:
        if ((r4 & 14) != 4) goto L33;
        r9 = true;
    L33:
        boolean r11 = r10 | r9;
        Object r12 = r15.rememberedValue();
        if (r11 == false) goto L36;
    L37:
        r12 = new qw(this, r18);
        r15.updateRememberedValue(r12);
    L38:
        r3 = r15;
        AndroidMenu_androidKt.DropdownMenuItem(r8, (Function0) r12, null, null, null, r7, null, null, null, r15, 6, 476);
        if (ComposerKt.isTraceInProgress() == false) goto L42;
        ComposerKt.traceEventEnd();
        goto L42
    L36:
        if (r12 != Composer.Companion.getEmpty()) goto L38;
    L29:
        r10 = false;
        goto L31
    L20:
        r6 = false;
        goto L22
    L13:
        if (r15.changed(this) == false) goto L15;
        int r13 = 32;
    L16:
        r4 = r4 | r13;
        goto L17
    L15:
        r13 = 16;
        goto L16
    L5:
        if (r15.changed(r18) == false) goto L7;
        int r14 = 4;
    L8:
        r4 = r14 | r20;
        goto L11
    L7:
        r14 = 2;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ToggleableAppBarItem(boolean r1, Function1<? super Boolean, Unit> r2, Function2<? super Composer, ? super Integer, Unit> r3, boolean r4, String r5) {
        this.checked = r1;
        this.onCheckedChange = r2;
        this.icon = r3;
        this.enabled = r4;
        this.label = r5;
    }
}
