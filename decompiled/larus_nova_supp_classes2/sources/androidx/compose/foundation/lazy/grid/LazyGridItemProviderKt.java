package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.lazy.layout.NearestRangeKeyIndexMap;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a4\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\tH\u0001¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"rememberLazyGridItemProviderLambda", "Lkotlin/Function0;", "Landroidx/compose/foundation/lazy/grid/LazyGridItemProvider;", "state", "Landroidx/compose/foundation/lazy/grid/LazyGridState;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/grid/LazyGridScope;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/lazy/grid/LazyGridState;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)Lkotlin/jvm/functions/Function0;", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class LazyGridItemProviderKt {
    public static /* synthetic */ LazyGridIntervalContent a(State r0) {
        return rememberLazyGridItemProviderLambda$lambda$2$lambda$0(r0);
    }

    public static /* synthetic */ LazyGridItemProviderImpl b(State r0, LazyGridState r1) {
        return rememberLazyGridItemProviderLambda$lambda$2$lambda$1(r0, r1);
    }

    private static final LazyGridIntervalContent rememberLazyGridItemProviderLambda$lambda$2$lambda$0(State r1) {
        return new LazyGridIntervalContent((Function1) r1.getValue());
    }

    private static final LazyGridItemProviderImpl rememberLazyGridItemProviderLambda$lambda$2$lambda$1(State r2, LazyGridState r3) {
        LazyGridIntervalContent r4 = (LazyGridIntervalContent) r2.getValue();
        return new LazyGridItemProviderImpl(r3, r4, new NearestRangeKeyIndexMap(r3.getNearestRange$foundation_release(), r4));
    }

    public static final Function0<LazyGridItemProvider> rememberLazyGridItemProviderLambda(final LazyGridState r3, Function1<? super LazyGridScope, Unit> r4, Composer r5, int r6) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-1898306282, r6, -1, "androidx.compose.foundation.lazy.grid.rememberLazyGridItemProviderLambda (LazyGridItemProvider.kt:40)");
    L5:
        final State r7 = SnapshotStateKt.rememberUpdatedState(r4, r5, (r6 >> 3) & 14);
        if (((r6 & 14) ^ 6) <= 4) goto L10;
        if (r5.changed(r3) == false) goto L10;
    L11:
        boolean r8 = true;
    L13:
        Object r0 = r5.rememberedValue();
        if (r8 == false) goto L16;
    L17:
        final State r9 = SnapshotStateKt.derivedStateOf(SnapshotStateKt.referentialEqualityPolicy(), new n(r7));
        final State r10 = SnapshotStateKt.derivedStateOf(SnapshotStateKt.referentialEqualityPolicy(), new o(r9, r3));
        r0 = new LazyGridItemProviderKt$rememberLazyGridItemProviderLambda$1$1(r10);
        r5.updateRememberedValue(r0);
    L18:
        KProperty0 r1 = (KProperty0) r0;
        if (ComposerKt.isTraceInProgress() == false) goto L21;
        ComposerKt.traceEventEnd();
    L21:
        return r1;
    L16:
        if (r0 != Composer.Companion.getEmpty()) goto L18;
    L10:
        if ((r6 & 6) == 4) goto L11;
        r8 = false;
        goto L13
    }
}
