package dagger.hilt.android.internal.managers;

import android.content.ComponentCallbacks2;
import android.content.Context;
import dagger.hilt.android.internal.Contexts;
import dagger.hilt.internal.GeneratedComponentManager;
import dagger.hilt.internal.Preconditions;

/* JADX INFO: loaded from: classes41.dex */
public final class BroadcastReceiverComponentManager {
    private BroadcastReceiverComponentManager() {
    }

    public static Object generatedComponent(Context r100) {
        ComponentCallbacks2 r101 = Contexts.getApplication(r100.getApplicationContext());
        Preconditions.checkArgument(r101 instanceof GeneratedComponentManager, "Hilt BroadcastReceiver must be attached to an @AndroidEntryPoint Application. Found: %s", new Object[]{r101.getClass()});
        return ((GeneratedComponentManager) r101).generatedComponent();
    }
}
