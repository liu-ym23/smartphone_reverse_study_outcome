package androidx.compose.foundation.lazy;

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
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a4\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\tH\u0001¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"rememberLazyListItemProviderLambda", "Lkotlin/Function0;", "Landroidx/compose/foundation/lazy/LazyListItemProvider;", "state", "Landroidx/compose/foundation/lazy/LazyListState;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/LazyListScope;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/lazy/LazyListState;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)Lkotlin/jvm/functions/Function0;", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class LazyListItemProviderKt {
    public static /* synthetic */ LazyListIntervalContent a(State r0) {
        return rememberLazyListItemProviderLambda$lambda$2$lambda$0(r0);
    }

    public static /* synthetic */ LazyListItemProviderImpl b(State r0, LazyListState r1, LazyItemScopeImpl r2) {
        return rememberLazyListItemProviderLambda$lambda$2$lambda$1(r0, r1, r2);
    }

    private static final LazyListIntervalContent rememberLazyListItemProviderLambda$lambda$2$lambda$0(State r1) {
        return new LazyListIntervalContent((Function1) r1.getValue());
    }

    private static final LazyListItemProviderImpl rememberLazyListItemProviderLambda$lambda$2$lambda$1(State r2, LazyListState r3, LazyItemScopeImpl r4) {
        LazyListIntervalContent r5 = (LazyListIntervalContent) r2.getValue();
        return new LazyListItemProviderImpl(r3, r5, r4, new NearestRangeKeyIndexMap(r3.getNearestRange$foundation_release(), r5));
    }

    public static final Function0<LazyListItemProvider> rememberLazyListItemProviderLambda(final LazyListState r3, Function1<? super LazyListScope, Unit> r4, Composer r5, int r6) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-343736148, r6, -1, "androidx.compose.foundation.lazy.rememberLazyListItemProviderLambda (LazyListItemProvider.kt:41)");
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
        final LazyItemScopeImpl r9 = new LazyItemScopeImpl();
        final State r10 = SnapshotStateKt.derivedStateOf(SnapshotStateKt.referentialEqualityPolicy(), new k(r7));
        final State r11 = SnapshotStateKt.derivedStateOf(SnapshotStateKt.referentialEqualityPolicy(), new l(r10, r3, r9));
        r0 = new LazyListItemProviderKt$rememberLazyListItemProviderLambda$1$1(r11);
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
