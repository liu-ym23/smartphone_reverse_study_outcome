package androidx.compose.foundation.lazy.layout;

import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterSetKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.saveable.SaveableStateHolder;
import androidx.compose.runtime.saveable.SaveableStateRegistry;
import androidx.compose.runtime.saveable.SaveableStateRegistryKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.SaverScope;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u0000  2\u00020\u00012\u00020\u0002:\u0001 B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006B9\b\u0016\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001\u0012\u001c\u0010\b\u001a\u0018\u0012\u0004\u0012\u00020\n\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000b\u0018\u00010\t\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\rJ\u001c\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\n\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000b0\tH\u0016J(\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\f2\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00120\u0015¢\u0006\u0002\b\u0016H\u0017¢\u0006\u0002\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\fH\u0016J\u0011\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\fH\u0096\u0001J\u0013\u0010\u001c\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0013\u001a\u00020\nH\u0096\u0001J!\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0013\u001a\u00020\n2\u000e\u0010\u001f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0015H\u0096\u0001R\u000e\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\f0\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Landroidx/compose/foundation/lazy/layout/LazySaveableStateHolder;", "Landroidx/compose/runtime/saveable/SaveableStateRegistry;", "Landroidx/compose/runtime/saveable/SaveableStateHolder;", "wrappedRegistry", "wrappedHolder", "<init>", "(Landroidx/compose/runtime/saveable/SaveableStateRegistry;Landroidx/compose/runtime/saveable/SaveableStateHolder;)V", "parentRegistry", "restoredValues", "", "", "", "", "(Landroidx/compose/runtime/saveable/SaveableStateRegistry;Ljava/util/Map;Landroidx/compose/runtime/saveable/SaveableStateHolder;)V", "previouslyComposedKeys", "Landroidx/collection/MutableScatterSet;", "performSave", "SaveableStateProvider", "", "key", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "removeState", "canBeSaved", "", "value", "consumeRestored", "registerProvider", "Landroidx/compose/runtime/saveable/SaveableStateRegistry$Entry;", "valueProvider", "Companion", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class LazySaveableStateHolder implements SaveableStateRegistry, SaveableStateHolder {
    public static final Companion Companion = null;
    private final MutableScatterSet<Object> previouslyComposedKeys;
    private final SaveableStateHolder wrappedHolder;
    private final SaveableStateRegistry wrappedRegistry;

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J8\u0010\u0004\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\b\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t0\u00070\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r¨\u0006\u000e"}, d2 = {"Landroidx/compose/foundation/lazy/layout/LazySaveableStateHolder$Companion;", "", "<init>", "()V", "saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/foundation/lazy/layout/LazySaveableStateHolder;", "", "", "", "parentRegistry", "Landroidx/compose/runtime/saveable/SaveableStateRegistry;", "wrappedHolder", "Landroidx/compose/runtime/saveable/SaveableStateHolder;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public static /* synthetic */ LazySaveableStateHolder a(SaveableStateRegistry r0, SaveableStateHolder r1, Map r2) {
            return saver$lambda$2(r0, r1, r2);
        }

        public static /* synthetic */ Map b(SaverScope r0, LazySaveableStateHolder r1) {
            return saver$lambda$1(r0, r1);
        }

        private static final Map saver$lambda$1(SaverScope r0, LazySaveableStateHolder r1) {
            Map<String, List<Object>> r2 = r1.performSave();
            if (r2.isEmpty() == false) goto L6;
            return null;
        L6:
            return r2;
        }

        public final Saver<LazySaveableStateHolder, Map<String, List<Object>>> saver(final SaveableStateRegistry r3, final SaveableStateHolder r4) {
            return SaverKt.Saver(new g0(), new h0(r3, r4));
        }

        private static final LazySaveableStateHolder saver$lambda$2(SaveableStateRegistry r1, SaveableStateHolder r2, Map r3) {
            return new LazySaveableStateHolder(r1, r3, r2);
        }
    }

    static {
        Companion = new Companion(null);
    }

    private static final Unit SaveableStateProvider$lambda$5(LazySaveableStateHolder r0, Object r1, Function2 r2, int r3, Composer r4, int r5) {
        r0.SaveableStateProvider(r1, r2, r4, RecomposeScopeImplKt.updateChangedFlags(r3 | 1));
        return Unit.INSTANCE;
    }

    public static /* synthetic */ boolean a(SaveableStateRegistry r0, Object r1) {
        return _init_$lambda$0(r0, r1);
    }

    public static /* synthetic */ DisposableEffectResult b(LazySaveableStateHolder r0, Object r1, DisposableEffectScope r2) {
        return SaveableStateProvider$lambda$4$lambda$3(r0, r1, r2);
    }

    public static /* synthetic */ Unit c(LazySaveableStateHolder r0, Object r1, Function2 r2, int r3, Composer r4, int r5) {
        return SaveableStateProvider$lambda$5(r0, r1, r2, r3, r4, r5);
    }

    public boolean canBeSaved(Object r2) {
        return this.wrappedRegistry.canBeSaved(r2);
    }

    public Object consumeRestored(String r2) {
        return this.wrappedRegistry.consumeRestored(r2);
    }

    public SaveableStateRegistry.Entry registerProvider(String r2, Function0<? extends Object> r3) {
        return this.wrappedRegistry.registerProvider(r2, r3);
    }

    public Map<String, List<Object>> performSave() {
        MutableScatterSet<Object> r0 = this.previouslyComposedKeys;
        Object[] r1 = r0.elements;
        long[] r2 = r0.metadata;
        int r3 = r2.length - 2;
        if (r3 < 0) goto L20;
        int r4 = 0;
    L5:
        long r5 = r2[r4];
        if (((((~r5) << 7) & r5) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L17;
        int r7 = 8 - ((~(r4 - r3)) >>> 31);
        int r9 = 0;
    L8:
        if (r9 >= r7) goto L16;
        if ((255 & r5) >= 128) goto L12;
        boolean r10 = true;
    L13:
        if (r10 == false) goto L15;
        this.wrappedHolder.removeState(r1[(r4 << 3) + r9]);
    L15:
        r5 = r5 >> 8;
        r9 = r9 + 1;
        goto L8
    L12:
        r10 = false;
        goto L13
    L16:
        if (r7 != 8) goto L20;
    L17:
        if (r4 == r3) goto L20;
        r4 = r4 + 1;
    L20:
        return this.wrappedRegistry.performSave();
    }

    public static final /* synthetic */ MutableScatterSet access$getPreviouslyComposedKeys$p(LazySaveableStateHolder r0) {
        return r0.previouslyComposedKeys;
    }

    public void removeState(Object r2) {
        this.wrappedHolder.removeState(r2);
    }

    public LazySaveableStateHolder(SaveableStateRegistry r1, SaveableStateHolder r2) {
        this.wrappedRegistry = r1;
        this.wrappedHolder = r2;
        this.previouslyComposedKeys = ScatterSetKt.mutableScatterSetOf();
    }

    private static final boolean _init_$lambda$0(SaveableStateRegistry r0, Object r1) {
        if (r0 != null) goto L6;
        return true;
    L6:
        return r0.canBeSaved(r1);
    }

    public LazySaveableStateHolder(final SaveableStateRegistry r2, Map<String, ? extends List<? extends Object>> r3, SaveableStateHolder r4) {
        this(SaveableStateRegistryKt.SaveableStateRegistry(r3, new d0(r2)), r4);
    }

    private static final DisposableEffectResult SaveableStateProvider$lambda$4$lambda$3(final LazySaveableStateHolder r0, final Object r1, DisposableEffectScope r2) {
        r0.previouslyComposedKeys.minusAssign(r1);
        return new LazySaveableStateHolder$SaveableStateProvider$lambda$4$lambda$3$$inlined$onDispose$1(r0, r1);
    }

    public void SaveableStateProvider(final Object r5, final Function2<? super Composer, ? super Integer, Unit> r6, Composer r7, final int r8) {
        Composer r9 = r7.startRestartGroup(-858296452);
        if ((r8 & 6) == 0) goto L5;
        int r1 = r8;
    L11:
        if ((r8 & 48) != 0) goto L18;
        if (r9.changedInstance(r6) == false) goto L15;
        int r2 = 32;
    L16:
        r1 = r1 | r2;
        goto L18
    L15:
        r2 = 16;
    L18:
        if ((r8 & 384) != 0) goto L25;
        if (r9.changedInstance(this) == false) goto L22;
        int r3 = 256;
    L23:
        r1 = r1 | r3;
        goto L25
    L22:
        r3 = 128;
    L25:
        if ((r1 & 147) == 146) goto L27;
        boolean r4 = true;
    L29:
        if (r9.shouldExecute(r4, r1 & 1) == true) goto L31;
        r9.skipToGroupEnd();
    L42:
        ScopeUpdateScope r10 = r9.endRestartGroup();
        if (r10 == null) goto L46;
        r10.updateScope(new f0(this, r5, r6, r8));
        return;
    L46:
        return;
    L31:
        if (ComposerKt.isTraceInProgress() == false) goto L33;
        ComposerKt.traceEventStart(-858296452, r1, -1, "androidx.compose.foundation.lazy.layout.LazySaveableStateHolder.SaveableStateProvider (LazySaveableStateHolder.kt:74)");
    L33:
        int r11 = r1 & 14;
        this.wrappedHolder.SaveableStateProvider(r5, r6, r9, (r1 & 112) | r11);
        boolean r0 = r9.changedInstance(this) | r9.changedInstance(r5);
        Object r12 = r9.rememberedValue();
        if (r0 == false) goto L36;
    L37:
        r12 = new e0(this, r5);
        r9.updateRememberedValue(r12);
    L38:
        EffectsKt.DisposableEffect(r5, (Function1) r12, r9, r11);
        if (ComposerKt.isTraceInProgress() == false) goto L42;
        ComposerKt.traceEventEnd();
        goto L42
    L36:
        if (r12 != Composer.Companion.getEmpty()) goto L38;
    L27:
        r4 = false;
        goto L29
    L5:
        if (r9.changedInstance(r5) == false) goto L7;
        int r13 = 4;
    L8:
        r1 = r13 | r8;
        goto L11
    L7:
        r13 = 2;
        goto L8
    }
}
