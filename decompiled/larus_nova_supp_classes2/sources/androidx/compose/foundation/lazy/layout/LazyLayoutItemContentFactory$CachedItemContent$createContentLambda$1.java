package androidx.compose.foundation.lazy.layout;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public final class LazyLayoutItemContentFactory$CachedItemContent$createContentLambda$1 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ LazyLayoutItemContentFactory this$0;
    final /* synthetic */ LazyLayoutItemContentFactory.CachedItemContent this$1;

    public LazyLayoutItemContentFactory$CachedItemContent$createContentLambda$1(LazyLayoutItemContentFactory r1, LazyLayoutItemContentFactory.CachedItemContent r2) {
        this.this$0 = r1;
        this.this$1 = r2;
    }

    public static /* synthetic */ DisposableEffectResult a(LazyLayoutItemContentFactory.CachedItemContent r0, DisposableEffectScope r1) {
        return invoke$lambda$2$lambda$1(r0, r1);
    }

    private static final DisposableEffectResult invoke$lambda$2$lambda$1(final LazyLayoutItemContentFactory.CachedItemContent r0, DisposableEffectScope r1) {
        return new LazyLayoutItemContentFactory$CachedItemContent$createContentLambda$1$invoke$lambda$2$lambda$1$$inlined$onDispose$1(r0);
    }

    public final void invoke(Composer r10, int r11) {
        if ((r11 & 3) == 2) goto L5;
        boolean r0 = true;
    L7:
        if (r10.shouldExecute(r0, r11 & 1) == true) goto L9;
        r10.skipToGroupEnd();
        return;
    L9:
        if (ComposerKt.isTraceInProgress() == false) goto L11;
        ComposerKt.traceEventStart(818252804, r11, -1, "androidx.compose.foundation.lazy.layout.LazyLayoutItemContentFactory.CachedItemContent.createContentLambda.<anonymous> (LazyLayoutItemContentFactory.kt:85)");
    L11:
        LazyLayoutItemProvider r3 = (LazyLayoutItemProvider) this.this$0.getItemProvider().invoke();
        int r12 = this.this$1.getIndex();
        if (r12 < r3.getItemCount()) goto L14;
    L15:
        r12 = r3.getIndex(this.this$1.getKey());
        if (r12 == (-1)) goto L18;
        LazyLayoutItemContentFactory.CachedItemContent.access$setIndex$p(this.this$1, r12);
    L18:
        int r5 = r12;
        if (r5 == (-1)) goto L21;
        r10.startReplaceGroup(-1664741271);
        LazyLayoutItemContentFactoryKt.m1157access$SkippableItemJVlU9Rs(r3, StableValue.m1198constructorimpl(LazyLayoutItemContentFactory.access$getSaveableStateHolder$p(this.this$0)), r5, StableValue.m1198constructorimpl(this.this$1.getKey()), r10, 0);
        r10.endReplaceGroup();
    L22:
        Object r13 = this.this$1.getKey();
        boolean r1 = r10.changedInstance(this.this$1);
        final LazyLayoutItemContentFactory.CachedItemContent r2 = this.this$1;
        Object r4 = r10.rememberedValue();
        if (r1 == false) goto L25;
    L26:
        r4 = new j(r2);
        r10.updateRememberedValue(r4);
    L27:
        EffectsKt.DisposableEffect(r13, (Function1) r4, r10, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L32;
        ComposerKt.traceEventEnd();
        return;
    L32:
        return;
    L25:
        if (r4 != Composer.Companion.getEmpty()) goto L27;
    L21:
        r10.startReplaceGroup(-1664505826);
        r10.endReplaceGroup();
        goto L22
    L14:
        if (Intrinsics.areEqual(r3.getKey(r12), this.this$1.getKey()) == true) goto L18;
    L5:
        r0 = false;
        goto L7
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke((Composer) r1, ((Number) r2).intValue());
        return Unit.INSTANCE;
    }
}
