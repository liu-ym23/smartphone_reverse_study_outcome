package androidx.activity.compose;

import android.content.Context;
import android.content.ContextWrapper;
import androidx.activity.result.ActivityResultRegistryOwner;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0019\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\n2\u0006\u0010\u000b\u001a\u00020\u0005H\u0086\u0004R\u0016\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u00058G¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Landroidx/activity/compose/LocalActivityResultRegistryOwner;", "", "()V", "LocalComposition", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/activity/result/ActivityResultRegistryOwner;", "current", "getCurrent", "(Landroidx/compose/runtime/Composer;I)Landroidx/activity/result/ActivityResultRegistryOwner;", "provides", "Landroidx/compose/runtime/ProvidedValue;", "registryOwner", "activity-compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LocalActivityResultRegistryOwner {
    public static final int $stable = 0;
    public static final LocalActivityResultRegistryOwner INSTANCE = null;
    private static final ProvidableCompositionLocal<ActivityResultRegistryOwner> LocalComposition = null;

    private LocalActivityResultRegistryOwner() {
    }

    static {
        INSTANCE = new LocalActivityResultRegistryOwner();
        LocalComposition = CompositionLocalKt.compositionLocalOf$default(null, LocalActivityResultRegistryOwner$LocalComposition$1.INSTANCE, 1, null);
    }

    public final ProvidedValue<ActivityResultRegistryOwner> provides(ActivityResultRegistryOwner r2) {
        return LocalComposition.provides(r2);
    }

    public final ActivityResultRegistryOwner getCurrent(Composer r2, int r3) {
        r2.startReplaceableGroup(1418020823);
        ActivityResultRegistryOwner r4 = (ActivityResultRegistryOwner) r2.consume(LocalComposition);
        if (r4 != null) goto L13;
        Context r5 = (Context) r2.consume(AndroidCompositionLocals_androidKt.getLocalContext());
    L6:
        if ((r5 instanceof ContextWrapper) == false) goto L11;
        if ((r5 instanceof ActivityResultRegistryOwner) == true) goto L12;
        r5 = ((ContextWrapper) r5).getBaseContext();
    L12:
        r4 = (ActivityResultRegistryOwner) r5;
        goto L13
    L11:
        r5 = null;
    L13:
        r2.endReplaceableGroup();
        return r4;
    }
}
