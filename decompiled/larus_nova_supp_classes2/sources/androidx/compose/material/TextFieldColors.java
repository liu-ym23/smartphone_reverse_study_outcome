package androidx.compose.material;

import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\bg\u0018\u00002\u00020\u0001J\u001b\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H'¢\u0006\u0002\u0010\u0007J\u001b\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H'¢\u0006\u0002\u0010\u0007J\u001b\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H'¢\u0006\u0002\u0010\u0007J+\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rH'¢\u0006\u0002\u0010\u000eJ#\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0006H'¢\u0006\u0002\u0010\u0011J+\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rH\u0017¢\u0006\u0002\u0010\u000eJ#\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0006H'¢\u0006\u0002\u0010\u0011J+\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rH\u0017¢\u0006\u0002\u0010\u000eJ+\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rH'¢\u0006\u0002\u0010\u000eJ\u001b\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0010\u001a\u00020\u0006H'¢\u0006\u0002\u0010\u0007ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0015À\u0006\u0001"}, d2 = {"Landroidx/compose/material/TextFieldColors;", "", "textColor", "Landroidx/compose/runtime/State;", "Landroidx/compose/ui/graphics/Color;", "enabled", "", "(ZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "backgroundColor", "placeholderColor", "labelColor", "error", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "(ZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "leadingIconColor", "isError", "(ZZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "trailingIconColor", "indicatorColor", "cursorColor", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface TextFieldColors {

    /* JADX INFO: renamed from: androidx.compose.material.TextFieldColors$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static State $default$leadingIconColor(TextFieldColors r2, boolean r3, boolean r4, InteractionSource r5, Composer r6, int r7) {
            r6.startReplaceGroup(-1036335134);
            if (ComposerKt.isTraceInProgress() == false) goto L5;
            ComposerKt.traceEventStart(-1036335134, r7, -1, "androidx.compose.material.TextFieldColors.leadingIconColor (TextFieldDefaults.kt:123)");
        L5:
            State<Color> r8 = r2.leadingIconColor(r3, r4, r6, ((r7 & 14) | (r7 & 112)) | ((r7 >> 3) & 896));
            if (ComposerKt.isTraceInProgress() == false) goto L8;
            ComposerKt.traceEventEnd();
        L8:
            r6.endReplaceGroup();
            return r8;
        }

        public static State $default$trailingIconColor(TextFieldColors r2, boolean r3, boolean r4, InteractionSource r5, Composer r6, int r7) {
            r6.startReplaceGroup(454310320);
            if (ComposerKt.isTraceInProgress() == false) goto L5;
            ComposerKt.traceEventStart(454310320, r7, -1, "androidx.compose.material.TextFieldColors.trailingIconColor (TextFieldDefaults.kt:155)");
        L5:
            State<Color> r8 = r2.trailingIconColor(r3, r4, r6, ((r7 & 14) | (r7 & 112)) | ((r7 >> 3) & 896));
            if (ComposerKt.isTraceInProgress() == false) goto L8;
            ComposerKt.traceEventEnd();
        L8:
            r6.endReplaceGroup();
            return r8;
        }
    }

    State<Color> backgroundColor(boolean r1, Composer r2, int r3);

    State<Color> cursorColor(boolean r1, Composer r2, int r3);

    State<Color> indicatorColor(boolean r1, boolean r2, InteractionSource r3, Composer r4, int r5);

    State<Color> labelColor(boolean r1, boolean r2, InteractionSource r3, Composer r4, int r5);

    State<Color> leadingIconColor(boolean r1, boolean r2, InteractionSource r3, Composer r4, int r5);

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use/implement overload with interactionSource parameter", replaceWith = @ReplaceWith(expression = "leadingIconColor(enabled, isError, interactionSource)", imports = {}))
    State<Color> leadingIconColor(boolean r1, boolean r2, Composer r3, int r4);

    State<Color> placeholderColor(boolean r1, Composer r2, int r3);

    State<Color> textColor(boolean r1, Composer r2, int r3);

    State<Color> trailingIconColor(boolean r1, boolean r2, InteractionSource r3, Composer r4, int r5);

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use/implement overload with interactionSource parameter", replaceWith = @ReplaceWith(expression = "trailingIconColor(enabled, isError, interactionSource)", imports = {}))
    State<Color> trailingIconColor(boolean r1, boolean r2, Composer r3, int r4);
}
