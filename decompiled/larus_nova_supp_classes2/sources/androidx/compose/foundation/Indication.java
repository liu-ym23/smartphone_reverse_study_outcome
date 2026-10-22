package androidx.compose.foundation;

import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0015\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0017¢\u0006\u0002\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0001"}, d2 = {"Landroidx/compose/foundation/Indication;", "", "rememberUpdatedInstance", "Landroidx/compose/foundation/IndicationInstance;", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "(Landroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/IndicationInstance;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface Indication {

    /* JADX INFO: renamed from: androidx.compose.foundation.Indication$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        @Deprecated(level = DeprecationLevel.WARNING, message = "rememberUpdatedInstance has been deprecated - implementers should instead implement IndicationNodeFactory#create for improved performance and efficiency. Callers should check if the Indication is an IndicationNodeFactory, and call that API instead. For a migration guide and background information, please visit developer.android.com")
        public static IndicationInstance $default$rememberUpdatedInstance(Indication r1, InteractionSource r2, Composer r3, int r4) {
            r3.startReplaceGroup(1257603829);
            if (ComposerKt.isTraceInProgress() == false) goto L5;
            ComposerKt.traceEventStart(1257603829, r4, -1, "androidx.compose.foundation.Indication.rememberUpdatedInstance (Indication.kt:74)");
        L5:
            NoIndicationInstance r5 = NoIndicationInstance.INSTANCE;
            if (ComposerKt.isTraceInProgress() == false) goto L8;
            ComposerKt.traceEventEnd();
        L8:
            r3.endReplaceGroup();
            return r5;
        }
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "rememberUpdatedInstance has been deprecated - implementers should instead implement IndicationNodeFactory#create for improved performance and efficiency. Callers should check if the Indication is an IndicationNodeFactory, and call that API instead. For a migration guide and background information, please visit developer.android.com")
    IndicationInstance rememberUpdatedInstance(InteractionSource r1, Composer r2, int r3);
}
