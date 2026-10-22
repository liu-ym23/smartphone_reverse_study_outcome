package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0001\u0018\u00002\u00020\u0001B3\u0012\u0011\u0010\u0002\u001a\r\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\b\u0005\u0012\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00040\u0007¢\u0006\u0002\b\u0005¢\u0006\u0004\b\t\u0010\nJ\r\u0010\r\u001a\u00020\u0004H\u0017¢\u0006\u0002\u0010\u000eJ\u0015\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\bH\u0017¢\u0006\u0002\u0010\u0011R\u001b\u0010\u0002\u001a\r\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\b\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000bR!\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00040\u0007¢\u0006\u0002\b\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\f¨\u0006\u0012"}, d2 = {"Landroidx/compose/material3/CustomAppBarItem;", "Landroidx/compose/material3/AppBarItem;", "appbarContent", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "menuContent", "Lkotlin/Function1;", "Landroidx/compose/material3/AppBarMenuState;", "<init>", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;)V", "Lkotlin/jvm/functions/Function2;", "Lkotlin/jvm/functions/Function3;", "AppbarContent", "(Landroidx/compose/runtime/Composer;I)V", "MenuContent", "state", "(Landroidx/compose/material3/AppBarMenuState;Landroidx/compose/runtime/Composer;I)V", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class CustomAppBarItem implements AppBarItem {
    public static final int $stable = 0;
    private final Function2<Composer, Integer, Unit> appbarContent;
    private final Function3<AppBarMenuState, Composer, Integer, Unit> menuContent;

    private static final Unit AppbarContent$lambda$0(CustomAppBarItem r0, int r1, Composer r2, int r3) {
        r0.AppbarContent(r2, RecomposeScopeImplKt.updateChangedFlags(r1 | 1));
        return Unit.INSTANCE;
    }

    private static final Unit MenuContent$lambda$1(CustomAppBarItem r0, AppBarMenuState r1, int r2, Composer r3, int r4) {
        r0.MenuContent(r1, r3, RecomposeScopeImplKt.updateChangedFlags(r2 | 1));
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(CustomAppBarItem r0, int r1, Composer r2, int r3) {
        return AppbarContent$lambda$0(r0, r1, r2, r3);
    }

    public static /* synthetic */ Unit b(CustomAppBarItem r0, AppBarMenuState r1, int r2, Composer r3, int r4) {
        return MenuContent$lambda$1(r0, r1, r2, r3, r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CustomAppBarItem(Function2<? super Composer, ? super Integer, Unit> r1, Function3<? super AppBarMenuState, ? super Composer, ? super Integer, Unit> r2) {
        this.appbarContent = r1;
        this.menuContent = r2;
    }

    @Override // androidx.compose.material3.AppBarItem
    public void AppbarContent(Composer r6, final int r7) {
        Composer r8 = r6.startRestartGroup(1121775917);
        if ((r7 & 6) == 0) goto L5;
        int r1 = r7;
    L11:
        if ((r1 & 3) == 2) goto L13;
        boolean r2 = true;
    L15:
        if (r8.shouldExecute(r2, r1 & 1) == true) goto L17;
        r8.skipToGroupEnd();
    L23:
        ScopeUpdateScope r9 = r8.endRestartGroup();
        if (r9 == null) goto L27;
        r9.updateScope(new i4(this, r7));
        return;
    L27:
        return;
    L17:
        if (ComposerKt.isTraceInProgress() == false) goto L19;
        ComposerKt.traceEventStart(1121775917, r1, -1, "androidx.compose.material3.CustomAppBarItem.AppbarContent (AppBarDsl.kt:228)");
    L19:
        this.appbarContent.invoke(r8, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L23;
        ComposerKt.traceEventEnd();
        goto L23
    L13:
        r2 = false;
        goto L15
    L5:
        if (r8.changed(this) == false) goto L7;
        int r3 = 4;
    L8:
        r1 = r3 | r7;
        goto L11
    L7:
        r3 = 2;
        goto L8
    }

    @Override // androidx.compose.material3.AppBarItem
    public void MenuContent(final AppBarMenuState r5, Composer r6, final int r7) {
        Composer r8 = r6.startRestartGroup(-1853735176);
        if ((r7 & 6) == 0) goto L5;
        int r1 = r7;
    L11:
        if ((r7 & 48) != 0) goto L18;
        if (r8.changed(this) == false) goto L15;
        int r2 = 32;
    L16:
        r1 = r1 | r2;
        goto L18
    L15:
        r2 = 16;
    L18:
        if ((r1 & 19) == 18) goto L20;
        boolean r3 = true;
    L22:
        if (r8.shouldExecute(r3, r1 & 1) == true) goto L24;
        r8.skipToGroupEnd();
    L30:
        ScopeUpdateScope r9 = r8.endRestartGroup();
        if (r9 == null) goto L34;
        r9.updateScope(new j4(this, r5, r7));
        return;
    L34:
        return;
    L24:
        if (ComposerKt.isTraceInProgress() == false) goto L26;
        ComposerKt.traceEventStart(-1853735176, r1, -1, "androidx.compose.material3.CustomAppBarItem.MenuContent (AppBarDsl.kt:233)");
    L26:
        this.menuContent.invoke(r5, r8, Integer.valueOf(r1 & 14));
        if (ComposerKt.isTraceInProgress() == false) goto L30;
        ComposerKt.traceEventEnd();
        goto L30
    L20:
        r3 = false;
        goto L22
    L5:
        if (r8.changed(r5) == false) goto L7;
        int r4 = 4;
    L8:
        r1 = r4 | r7;
        goto L11
    L7:
        r4 = 2;
        goto L8
    }
}
