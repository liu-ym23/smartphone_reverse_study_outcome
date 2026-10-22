package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"rememberAppBarOverflowState", "Landroidx/compose/material3/AppBarOverflowState;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/AppBarOverflowState;", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class AppBarDslKt {
    public static /* synthetic */ AppBarOverflowStateImpl a() {
        return rememberAppBarOverflowState$lambda$1$lambda$0();
    }

    private static final AppBarOverflowStateImpl rememberAppBarOverflowState$lambda$1$lambda$0() {
        return new AppBarOverflowStateImpl();
    }

    public static final AppBarOverflowState rememberAppBarOverflowState(Composer r3, int r4) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(209837519, r4, -1, "androidx.compose.material3.rememberAppBarOverflowState (AppBarDsl.kt:264)");
    L5:
        Object[] r5 = new Object[0];
        Saver<AppBarOverflowStateImpl, ?> r0 = AppBarOverflowStateImpl.Companion.getSaver();
        Object r1 = r3.rememberedValue();
        if (r1 != Composer.Companion.getEmpty()) goto L8;
        r1 = new q();
        r3.updateRememberedValue(r1);
    L8:
        AppBarOverflowStateImpl r6 = (AppBarOverflowStateImpl) RememberSaveableKt.rememberSaveable(r5, r0, (Function0) r1, r3, 384);
        if (ComposerKt.isTraceInProgress() == false) goto L11;
        ComposerKt.traceEventEnd();
    L11:
        return r6;
    }
}
