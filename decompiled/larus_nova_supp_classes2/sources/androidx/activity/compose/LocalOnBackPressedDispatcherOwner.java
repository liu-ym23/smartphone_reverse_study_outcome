package androidx.activity.compose;

import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.activity.ViewTreeOnBackPressedDispatcherOwner;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0019\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\n2\u0006\u0010\u000b\u001a\u00020\u0005H\u0086\u0004R\u0016\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u00058G¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Landroidx/activity/compose/LocalOnBackPressedDispatcherOwner;", "", "()V", "LocalOnBackPressedDispatcherOwner", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/activity/OnBackPressedDispatcherOwner;", "current", "getCurrent", "(Landroidx/compose/runtime/Composer;I)Landroidx/activity/OnBackPressedDispatcherOwner;", "provides", "Landroidx/compose/runtime/ProvidedValue;", "dispatcherOwner", "activity-compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LocalOnBackPressedDispatcherOwner {
    public static final int $stable = 0;
    public static final LocalOnBackPressedDispatcherOwner INSTANCE = null;
    private static final ProvidableCompositionLocal<OnBackPressedDispatcherOwner> LocalOnBackPressedDispatcherOwner = null;

    private LocalOnBackPressedDispatcherOwner() {
    }

    static {
        INSTANCE = new LocalOnBackPressedDispatcherOwner();
        LocalOnBackPressedDispatcherOwner = CompositionLocalKt.compositionLocalOf$default(null, LocalOnBackPressedDispatcherOwner$LocalOnBackPressedDispatcherOwner$1.INSTANCE, 1, null);
    }

    public final ProvidedValue<OnBackPressedDispatcherOwner> provides(OnBackPressedDispatcherOwner r2) {
        return LocalOnBackPressedDispatcherOwner.provides(r2);
    }

    public final OnBackPressedDispatcherOwner getCurrent(Composer r2, int r3) {
        r2.startReplaceableGroup(-2068013981);
        OnBackPressedDispatcherOwner r4 = (OnBackPressedDispatcherOwner) r2.consume(LocalOnBackPressedDispatcherOwner);
        r2.startReplaceableGroup(1680121597);
        if (r4 != null) goto L5;
        r4 = ViewTreeOnBackPressedDispatcherOwner.get((View) r2.consume(AndroidCompositionLocals_androidKt.getLocalView()));
    L5:
        r2.endReplaceableGroup();
        if (r4 != null) goto L16;
        Context r5 = (Context) r2.consume(AndroidCompositionLocals_androidKt.getLocalContext());
    L9:
        if ((r5 instanceof ContextWrapper) == false) goto L14;
        if ((r5 instanceof OnBackPressedDispatcherOwner) == true) goto L15;
        r5 = ((ContextWrapper) r5).getBaseContext();
    L15:
        r4 = (OnBackPressedDispatcherOwner) r5;
        goto L16
    L14:
        r5 = null;
    L16:
        r2.endReplaceableGroup();
        return r4;
    }
}
