package androidx.compose.material;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public final class ScaffoldKt$Scaffold$child$1 implements Function3<Modifier, Composer, Integer, Unit> {
    final /* synthetic */ long $backgroundColor;
    final /* synthetic */ Function2<Composer, Integer, Unit> $bottomBar;
    final /* synthetic */ Function3<PaddingValues, Composer, Integer, Unit> $content;
    final /* synthetic */ long $contentColor;
    final /* synthetic */ WindowInsets $contentWindowInsets;
    final /* synthetic */ Function2<Composer, Integer, Unit> $floatingActionButton;
    final /* synthetic */ int $floatingActionButtonPosition;
    final /* synthetic */ boolean $isFloatingActionButtonDocked;
    final /* synthetic */ MutableWindowInsets $safeInsets;
    final /* synthetic */ ScaffoldState $scaffoldState;
    final /* synthetic */ Function3<SnackbarHostState, Composer, Integer, Unit> $snackbarHost;
    final /* synthetic */ Function2<Composer, Integer, Unit> $topBar;

    /* JADX WARN: Multi-variable type inference failed */
    public ScaffoldKt$Scaffold$child$1(MutableWindowInsets r1, WindowInsets r2, long r3, long r5, boolean r7, int r8, Function2<? super Composer, ? super Integer, Unit> r9, Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> r10, Function2<? super Composer, ? super Integer, Unit> r11, Function2<? super Composer, ? super Integer, Unit> r12, Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> r13, ScaffoldState r14) {
        this.$safeInsets = r1;
        this.$contentWindowInsets = r2;
        this.$backgroundColor = r3;
        this.$contentColor = r5;
        this.$isFloatingActionButtonDocked = r7;
        this.$floatingActionButtonPosition = r8;
        this.$topBar = r9;
        this.$content = r10;
        this.$floatingActionButton = r11;
        this.$bottomBar = r12;
        this.$snackbarHost = r13;
        this.$scaffoldState = r14;
    }

    public static /* synthetic */ Unit a(MutableWindowInsets r0, WindowInsets r1, WindowInsets r2) {
        return invoke$lambda$1$lambda$0(r0, r1, r2);
    }

    private static final Unit invoke$lambda$1$lambda$0(MutableWindowInsets r0, WindowInsets r1, WindowInsets r2) {
        r0.setInsets(WindowInsetsKt.exclude(r1, r2));
        return Unit.INSTANCE;
    }

    public final void invoke(Modifier r24, Composer r25, int r26) {
        if ((r26 & 6) == 0) goto L5;
        int r2 = r26;
    L11:
        if ((r2 & 19) == 18) goto L13;
        boolean r3 = true;
    L15:
        if (r25.shouldExecute(r3, r2 & 1) == true) goto L17;
        r25.skipToGroupEnd();
        return;
    L17:
        if (ComposerKt.isTraceInProgress() == false) goto L19;
        ComposerKt.traceEventStart(-1236753028, r2, -1, "androidx.compose.material.Scaffold.<anonymous> (Scaffold.kt:200)");
    L19:
        boolean r4 = r25.changed(this.$safeInsets) | r25.changed(this.$contentWindowInsets);
        final MutableWindowInsets r5 = this.$safeInsets;
        final WindowInsets r6 = this.$contentWindowInsets;
        Object r7 = r25.rememberedValue();
        if (r4 == false) goto L22;
    L23:
        r7 = new a9(r5, r6);
        r25.updateRememberedValue(r7);
    L24:
        Modifier r1 = WindowInsetsPaddingKt.onConsumedWindowInsetsChanged(r24, (Function1) r7);
        long r8 = this.$backgroundColor;
        long r9 = this.$contentColor;
        final boolean r12 = this.$isFloatingActionButtonDocked;
        final int r13 = this.$floatingActionButtonPosition;
        final Function2<Composer, Integer, Unit> r14 = this.$topBar;
        final Function3<PaddingValues, Composer, Integer, Unit> r11 = this.$content;
        final Function2<Composer, Integer, Unit> r10 = this.$floatingActionButton;
        final MutableWindowInsets r15 = this.$safeInsets;
        final Function2<Composer, Integer, Unit> r16 = this.$bottomBar;
        final Function3<SnackbarHostState, Composer, Integer, Unit> r17 = this.$snackbarHost;
        final ScaffoldState r18 = this.$scaffoldState;
        SurfaceKt.m2175SurfaceFjzlyU(r1, null, r8, r9, null, androidx.compose.material3.MenuKt.ClosedAlphaTarget, ComposableLambdaKt.rememberComposableLambda(-1761194824, true, new AnonymousClass2(r12, r13, r14, r11, r10, r15, r16, r17, r18), r25, 54), r25, 1572864, 50);
        if (ComposerKt.isTraceInProgress() == false) goto L29;
        ComposerKt.traceEventEnd();
        return;
    L29:
        return;
    L22:
        if (r7 != Composer.Companion.getEmpty()) goto L24;
    L13:
        r3 = false;
        goto L15
    L5:
        if (r25.changed(r24) == false) goto L7;
        int r19 = 4;
    L8:
        r2 = r26 | r19;
        goto L11
    L7:
        r19 = 2;
        goto L8
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
        invoke((Modifier) r1, (Composer) r2, ((Number) r3).intValue());
        return Unit.INSTANCE;
    }
}
