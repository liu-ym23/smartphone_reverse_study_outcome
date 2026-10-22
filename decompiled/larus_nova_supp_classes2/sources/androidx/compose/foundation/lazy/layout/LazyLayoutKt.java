package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.ComposeFoundationFlags;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.SaveableStateHolder;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.SubcomposeLayoutKt;
import androidx.compose.ui.layout.SubcomposeLayoutState;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.layout.flag.LocalPausableCompositionInPrefetchEnabledKt;
import androidx.compose.ui.precompose.Disposable;
import androidx.compose.ui.precompose.PausableSubPreComposeController;
import androidx.compose.ui.precompose.PausableSubPreComposeControllerKt;
import androidx.compose.ui.unit.Constraints;
import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000N\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aP\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\u001d\u0010\t\u001a\u0019\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\n¢\u0006\u0002\b\u000eH\u0007¢\u0006\u0002\u0010\u000f\u001a9\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\u0010H\u0007¢\u0006\u0002\u0010\u0011\"\u000e\u0010\u0012\u001a\u00020\u0013X\u0082T¢\u0006\u0002\n\u0000\"\u0019\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"LazyLayout", "", "itemProvider", "Lkotlin/Function0;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemProvider;", "modifier", "Landroidx/compose/ui/Modifier;", "prefetchState", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;", "measurePolicy", "Lkotlin/Function2;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/ui/layout/MeasureResult;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasurePolicy;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasurePolicy;Landroidx/compose/runtime/Composer;II)V", "MaxItemsToRetainForReuse", "", "LocalLazyLayoutPrefetchObserver", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchObserver;", "getLocalLazyLayoutPrefetchObserver", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class LazyLayoutKt {
    private static final ProvidableCompositionLocal<LazyLayoutPrefetchObserver> LocalLazyLayoutPrefetchObserver = null;
    private static final int MaxItemsToRetainForReuse = 7;

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.layout.LazyLayoutKt$LazyLayout$2, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class AnonymousClass2 implements Function3<SaveableStateHolder, Composer, Integer, Unit> {
        final /* synthetic */ State<Function0<LazyLayoutItemProvider>> $currentItemProvider;
        final /* synthetic */ boolean $isPausableCompositionInPrefetchEnabled;
        final /* synthetic */ LazyLayoutMeasurePolicy $measurePolicy;
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ LazyLayoutPrefetchState $prefetchState;

        public AnonymousClass2(LazyLayoutPrefetchState r1, boolean r2, Modifier r3, LazyLayoutMeasurePolicy r4, State<? extends Function0<? extends LazyLayoutItemProvider>> r5) {
            this.$prefetchState = r1;
            this.$isPausableCompositionInPrefetchEnabled = r2;
            this.$modifier = r3;
            this.$measurePolicy = r4;
            this.$currentItemProvider = r5;
        }

        public static /* synthetic */ DisposableEffectResult a(LazyLayoutPrefetchState r0, LazyLayoutItemContentFactory r1, SubcomposeLayoutState r2, PrefetchScheduler r3, boolean r4, DisposableEffectScope r5) {
            return invoke$lambda$5$lambda$4(r0, r1, r2, r3, r4, r5);
        }

        public static /* synthetic */ MeasureResult b(LazyLayoutItemContentFactory r0, LazyLayoutMeasurePolicy r1, SubcomposeMeasureScope r2, Constraints r3) {
            return invoke$lambda$8$lambda$7(r0, r1, r2, r3);
        }

        public static /* synthetic */ DisposableEffectResult c(PausableSubPreComposeController r0, boolean r1, LazyLayoutItemContentFactory r2, LazyLayoutPrefetchState r3, DisposableEffectScope r4) {
            return invoke$lambda$14$lambda$13(r0, r1, r2, r3, r4);
        }

        public static /* synthetic */ List d(LazyLayoutItemContentFactory r0, PausableSubPreComposeController r1, LazyLayoutPrefetchState r2) {
            return invoke$lambda$14$lambda$13$lambda$11(r0, r1, r2);
        }

        public static /* synthetic */ LazyLayoutItemProvider e(State r0) {
            return invoke$lambda$1$lambda$0(r0);
        }

        private static final LazyLayoutItemProvider invoke$lambda$1$lambda$0(State r0) {
            return (LazyLayoutItemProvider) ((Function0) r0.getValue()).invoke();
        }

        private static final List invoke$lambda$14$lambda$13$lambda$11(LazyLayoutItemContentFactory r2, PausableSubPreComposeController r3, final LazyLayoutPrefetchState r4) {
            LazyLayoutItemProvider r5 = (LazyLayoutItemProvider) r2.getItemProvider().invoke();
            if (r3.getPrecomposeCount() != (-1)) goto L5;
            int r6 = r5.getItemCount();
        L6:
            IntRange r7 = RangesKt.until(0, r6);
            ArrayList r8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));
            IntIterator r9 = r7.iterator();
        L8:
            if (r9.hasNext() == false) goto L10;
            final int r0 = r9.nextInt();
            r8.add(new LazyLayoutKt$LazyLayout$2$3$1$disposable$1$1$1(r4, r0));
            goto L8
        L10:
            return r8;
        L5:
            r6 = Math.min(r5.getItemCount(), r3.getPrecomposeCount());
            goto L6
        }

        public final void invoke(SaveableStateHolder r11, Composer r12, int r13) {
            if (ComposerKt.isTraceInProgress() == false) goto L5;
            ComposerKt.traceEventStart(-933153643, r13, -1, "androidx.compose.foundation.lazy.layout.LazyLayout.<anonymous> (LazyLayout.kt:124)");
        L5:
            final State<Function0<LazyLayoutItemProvider>> r14 = this.$currentItemProvider;
            Object r0 = r12.rememberedValue();
            Composer.Companion r1 = Composer.Companion;
            if (r0 != r1.getEmpty()) goto L8;
            r0 = new LazyLayoutItemContentFactory(r11, new o(r14));
            r12.updateRememberedValue(r0);
        L8:
            final LazyLayoutItemContentFactory r2 = (LazyLayoutItemContentFactory) r0;
            Object r15 = r12.rememberedValue();
            if (r15 != r1.getEmpty()) goto L11;
            r15 = new SubcomposeLayoutState(new LazyLayoutItemReusePolicy(r2));
            r12.updateRememberedValue(r15);
        L11:
            final SubcomposeLayoutState r16 = (SubcomposeLayoutState) r15;
            if (this.$prefetchState == null) goto L23;
            r12.startReplaceGroup(1743491779);
            PrefetchScheduler r17 = this.$prefetchState.getPrefetchScheduler$foundation_release();
            if (r17 != null) goto L16;
            r12.startReplaceGroup(887527095);
            r17 = PrefetchScheduler_androidKt.rememberDefaultPrefetchScheduler(r12, 0);
        L17:
            r12.endReplaceGroup();
            final PrefetchScheduler r6 = r17;
            LazyLayoutPrefetchState r3 = this.$prefetchState;
            Object[] r18 = {r3, r2, r16, r6};
            boolean r4 = (((r12.changed(r3) | r12.changedInstance(r2)) | r12.changedInstance(r16)) | r12.changedInstance(r6)) | r12.changed(this.$isPausableCompositionInPrefetchEnabled);
            final LazyLayoutPrefetchState r5 = this.$prefetchState;
            final boolean r7 = this.$isPausableCompositionInPrefetchEnabled;
            Object r8 = r12.rememberedValue();
            if (r4 == false) goto L20;
        L21:
            Function1 r9 = new p(r5, r2, r16, r6, r7);
            r12.updateRememberedValue(r9);
            r8 = r9;
        L22:
            EffectsKt.DisposableEffect(r18, (Function1) r8, r12, 0);
            r12.endReplaceGroup();
        L24:
            Modifier r10 = LazyLayoutPrefetchStateKt.traversablePrefetchState(this.$modifier, this.$prefetchState);
            boolean r19 = r12.changed(r2) | r12.changed(this.$measurePolicy);
            final LazyLayoutMeasurePolicy r20 = this.$measurePolicy;
            Object r21 = r12.rememberedValue();
            if (r19 == false) goto L27;
        L28:
            r21 = new q(r2, r20);
            r12.updateRememberedValue(r21);
        L29:
            SubcomposeLayoutKt.SubcomposeLayout(r16, r10, (Function2) r21, r12, SubcomposeLayoutState.$stable, 0);
            final PausableSubPreComposeController r110 = (PausableSubPreComposeController) r12.consume(PausableSubPreComposeControllerKt.getLocalPausableSubPreComposeController());
            Unit r111 = Unit.INSTANCE;
            boolean r22 = ((r12.changedInstance(r110) | r12.changed(this.$isPausableCompositionInPrefetchEnabled)) | r12.changedInstance(r2)) | r12.changed(this.$prefetchState);
            final boolean r23 = this.$isPausableCompositionInPrefetchEnabled;
            final LazyLayoutPrefetchState r24 = this.$prefetchState;
            Object r25 = r12.rememberedValue();
            if (r22 == false) goto L32;
        L33:
            r25 = new r(r110, r23, r2, r24);
            r12.updateRememberedValue(r25);
        L34:
            EffectsKt.DisposableEffect(r111, (Function1) r25, r12, 6);
            if (ComposerKt.isTraceInProgress() == false) goto L38;
            ComposerKt.traceEventEnd();
            return;
        L38:
            return;
        L32:
            if (r25 != r1.getEmpty()) goto L34;
        L27:
            if (r21 != r1.getEmpty()) goto L29;
        L20:
            if (r8 != r1.getEmpty()) goto L22;
        L16:
            r12.startReplaceGroup(887526010);
            goto L17
        L23:
            r12.startReplaceGroup(1744116429);
            r12.endReplaceGroup();
            goto L24
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
            invoke((SaveableStateHolder) r1, (Composer) r2, ((Number) r3).intValue());
            return Unit.INSTANCE;
        }

        private static final MeasureResult invoke$lambda$8$lambda$7(LazyLayoutItemContentFactory r1, LazyLayoutMeasurePolicy r2, SubcomposeMeasureScope r3, Constraints r4) {
            return r2.mo1082measure0kLqBqw(new LazyLayoutMeasureScopeImpl(r1, r3), r4.unbox-impl());
        }

        private static final DisposableEffectResult invoke$lambda$14$lambda$13(final PausableSubPreComposeController r0, boolean r1, final LazyLayoutItemContentFactory r2, final LazyLayoutPrefetchState r3, DisposableEffectScope r4) {
            if (r0 == null) goto L6;
            if (r1 == true) goto L6;
            boolean r5 = false;
        L7:
            if (r5 == false) goto L14;
            if (r0 == null) goto L10;
            final Disposable r6 = r0.registerSubPreComposeTask(new s(r2, r0, r3));
        L12:
            return new LazyLayoutKt$LazyLayout$2$invoke$lambda$14$lambda$13$$inlined$onDispose$1(r6);
        L10:
            r6 = null;
            goto L12
        L14:
            throw new IllegalArgumentException("PausableCompositionInPrefetch must be enabled when using PausablePreComposeView".toString());
        L6:
            r5 = true;
            goto L7
        }

        private static final DisposableEffectResult invoke$lambda$5$lambda$4(final LazyLayoutPrefetchState r0, LazyLayoutItemContentFactory r1, SubcomposeLayoutState r2, PrefetchScheduler r3, boolean r4, DisposableEffectScope r5) {
            r0.setPrefetchHandleProvider$foundation_release(new PrefetchHandleProvider(r1, r2, r3, r4));
            return new LazyLayoutKt$LazyLayout$2$invoke$lambda$5$lambda$4$$inlined$onDispose$1(r0);
        }
    }

    private static final Unit LazyLayout$lambda$0(Function0 r7, Modifier r8, LazyLayoutPrefetchState r9, Function2 r10, int r11, int r12, Composer r13, int r14) {
        LazyLayout(r7, r8, r9, r10, r13, RecomposeScopeImplKt.updateChangedFlags(r11 | 1), r12);
        return Unit.INSTANCE;
    }

    private static final Unit LazyLayout$lambda$1(Function0 r7, Modifier r8, LazyLayoutPrefetchState r9, LazyLayoutMeasurePolicy r10, int r11, int r12, Composer r13, int r14) {
        LazyLayout(r7, r8, r9, r10, r13, RecomposeScopeImplKt.updateChangedFlags(r11 | 1), r12);
        return Unit.INSTANCE;
    }

    private static final LazyLayoutPrefetchObserver LocalLazyLayoutPrefetchObserver$lambda$2() {
        return null;
    }

    public static /* synthetic */ LazyLayoutPrefetchObserver a() {
        return LocalLazyLayoutPrefetchObserver$lambda$2();
    }

    public static /* synthetic */ Unit b(Function0 r0, Modifier r1, LazyLayoutPrefetchState r2, Function2 r3, int r4, int r5, Composer r6, int r7) {
        return LazyLayout$lambda$0(r0, r1, r2, r3, r4, r5, r6, r7);
    }

    public static /* synthetic */ Unit c(Function0 r0, Modifier r1, LazyLayoutPrefetchState r2, LazyLayoutMeasurePolicy r3, int r4, int r5, Composer r6, int r7) {
        return LazyLayout$lambda$1(r0, r1, r2, r3, r4, r5, r6, r7);
    }

    static {
        LocalLazyLayoutPrefetchObserver = CompositionLocalKt.staticCompositionLocalOf(new m());
    }

    public static final ProvidableCompositionLocal<LazyLayoutPrefetchObserver> getLocalLazyLayoutPrefetchObserver() {
        return LocalLazyLayoutPrefetchObserver;
    }

    public static final void LazyLayout(final Function0<? extends LazyLayoutItemProvider> r14, Modifier r15, LazyLayoutPrefetchState r16, final LazyLayoutMeasurePolicy r17, Composer r18, final int r19, final int r20) {
        Composer r10 = r18.startRestartGroup(1055276397);
        if ((r20 & 1) == 0) goto L6;
        int r2 = r19 | 6;
    L13:
        int r3 = r20 & 2;
        if (r3 == 0) goto L17;
        r2 = r2 | 48;
    L24:
        int r5 = r20 & 4;
        if (r5 == 0) goto L28;
        r2 = r2 | 384;
    L34:
        LazyLayoutPrefetchState r6 = r16;
    L36:
        if ((r20 & 8) == 0) goto L39;
        r2 = r2 | 3072;
    L49:
        if ((r2 & 1171) == 1170) goto L51;
        boolean r7 = true;
    L53:
        if (r10.shouldExecute(r7, r2 & 1) == false) goto L71;
        if (r3 == 0) goto L56;
        Modifier r11 = Modifier.Companion;
    L57:
        if (r5 == 0) goto L59;
        LazyLayoutPrefetchState r13 = null;
    L61:
        if (ComposerKt.isTraceInProgress() == false) goto L63;
        ComposerKt.traceEventStart(1055276397, r2, -1, "androidx.compose.foundation.lazy.layout.LazyLayout (LazyLayout.kt:117)");
    L63:
        State r8 = SnapshotStateKt.rememberUpdatedState(r14, r10, r2 & 14);
        Boolean r0 = (Boolean) r10.consume(LocalPausableCompositionInPrefetchEnabledKt.getLocalPausableCompositionInPrefetchEnabled());
        if (r0 == null) goto L66;
        boolean r1 = r0.booleanValue();
    L67:
        LazySaveableStateHolderKt.LazySaveableStateHolderProvider(ComposableLambdaKt.rememberComposableLambda(-933153643, true, new AnonymousClass2(r13, r1, r11, r17, r8), r10, 54), r10, 6);
        if (ComposerKt.isTraceInProgress() == false) goto L70;
        ComposerKt.traceEventEnd();
    L70:
        final Modifier r4 = r11;
        final LazyLayoutPrefetchState r9 = r13;
    L72:
        ScopeUpdateScope r12 = r10.endRestartGroup();
        if (r12 == null) goto L76;
        r12.updateScope(new l(r14, r4, r9, r17, r19, r20));
        return;
    L76:
        return;
    L66:
        r1 = ComposeFoundationFlags.isPausableCompositionInPrefetchEnabled;
        goto L67
    L59:
        r13 = r6;
        goto L61
    L56:
        r11 = r15;
        goto L57
    L71:
        r10.skipToGroupEnd();
        r4 = r15;
        r9 = r6;
        goto L72
    L51:
        r7 = false;
        goto L53
    L39:
        if ((r19 & 3072) != 0) goto L49;
        if ((r19 & 4096) != 0) goto L43;
        boolean r21 = r10.changed(r17);
    L44:
        if (r21 == false) goto L46;
        int r22 = 2048;
    L47:
        r2 = r2 | r22;
        goto L49
    L46:
        r22 = 1024;
        goto L47
    L43:
        r21 = r10.changedInstance(r17);
        goto L44
    L28:
        if ((r19 & 384) != 0) goto L34;
        r6 = r16;
        if (r10.changed(r6) == false) goto L32;
        int r23 = 256;
    L33:
        r2 = r2 | r23;
        goto L36
    L32:
        r23 = 128;
        goto L33
    L17:
        if ((r19 & 48) != 0) goto L24;
        if (r10.changed(r15) == false) goto L21;
        int r24 = 32;
    L22:
        r2 = r2 | r24;
        goto L24
    L21:
        r24 = 16;
        goto L22
    L6:
        if ((r19 & 6) == 0) goto L8;
        r2 = r19;
        goto L13
    L8:
        if (r10.changedInstance(r14) == false) goto L10;
        int r25 = 4;
    L11:
        r2 = r25 | r19;
        goto L13
    L10:
        r25 = 2;
        goto L11
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Please use overload with LazyLayoutMeasurePolicy")
    public static final /* synthetic */ void LazyLayout(final Function0 r8, Modifier r9, LazyLayoutPrefetchState r10, final Function2 r11, Composer r12, final int r13, final int r14) {
        Composer r15 = r12.startRestartGroup(2002163445);
        if ((r14 & 1) == 0) goto L6;
        int r1 = r13 | 6;
    L13:
        int r2 = r14 & 2;
        if (r2 == 0) goto L17;
        r1 = r1 | 48;
    L23:
        int r3 = r14 & 4;
        if (r3 == 0) goto L27;
        r1 = r1 | 384;
    L34:
        if ((r14 & 8) == 0) goto L37;
        r1 = r1 | 3072;
    L44:
        if ((r1 & 1171) == 1170) goto L46;
        boolean r4 = true;
    L48:
        if (r15.shouldExecute(r4, r1 & 1) == false) goto L59;
        if (r2 == 0) goto L51;
        r9 = Modifier.Companion;
    L51:
        if (r3 == 0) goto L54;
        r10 = null;
    L54:
        if (ComposerKt.isTraceInProgress() == false) goto L56;
        ComposerKt.traceEventStart(2002163445, r1, -1, "androidx.compose.foundation.lazy.layout.LazyLayout (LazyLayout.kt:74)");
    L56:
        int r6 = ((r1 & 14) | (r1 & 112)) | (r1 & 896);
        Modifier r5 = r9;
        LazyLayoutPrefetchState r7 = r10;
        LazyLayout(r8, r5, r7, new LazyLayoutKt$sam$androidx_compose_foundation_lazy_layout_LazyLayoutMeasurePolicy$0(r11), r15, r6, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L60;
        ComposerKt.traceEventEnd();
    L60:
        final Modifier r16 = r9;
        final LazyLayoutPrefetchState r17 = r10;
        ScopeUpdateScope r18 = r15.endRestartGroup();
        if (r18 == null) goto L64;
        r18.updateScope(new n(r8, r16, r17, r11, r13, r14));
        return;
    L64:
        return;
    L59:
        r15.skipToGroupEnd();
        goto L60
    L46:
        r4 = false;
        goto L48
    L37:
        if ((r13 & 3072) != 0) goto L44;
        if (r15.changedInstance(r11) == false) goto L41;
        int r19 = 2048;
    L42:
        r1 = r1 | r19;
        goto L44
    L41:
        r19 = 1024;
        goto L42
    L27:
        if ((r13 & 384) != 0) goto L34;
        if (r15.changed(r10) == false) goto L31;
        int r20 = 256;
    L32:
        r1 = r1 | r20;
        goto L34
    L31:
        r20 = 128;
        goto L32
    L17:
        if ((r13 & 48) != 0) goto L23;
        if (r15.changed(r9) == false) goto L21;
        int r21 = 32;
    L22:
        r1 = r1 | r21;
        goto L23
    L21:
        r21 = 16;
        goto L22
    L6:
        if ((r13 & 6) == 0) goto L8;
        r1 = r13;
        goto L13
    L8:
        if (r15.changedInstance(r8) == false) goto L10;
        int r22 = 4;
    L11:
        r1 = r22 | r13;
        goto L13
    L10:
        r22 = 2;
        goto L11
    }
}
