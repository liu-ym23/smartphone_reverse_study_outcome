package androidx.work;

import android.content.Context;
import androidx.startup.Initializer;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class WorkManagerInitializer implements Initializer<WorkManager> {
    private static final String TAG = null;

    public WorkManagerInitializer() {
    }

    static {
        TAG = Logger.tagWithPrefix("WrkMgrInitializer");
    }

    @Override // androidx.startup.Initializer
    public List<Class<? extends Initializer<?>>> dependencies() {
        return Collections.emptyList();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.startup.Initializer
    public WorkManager create(Context r5) {
        Logger.get().debug(TAG, "Initializing WorkManager with default configuration.", new Throwable[0]);
        WorkManager.initialize(r5, new Configuration.Builder().build());
        return WorkManager.getInstance(r5);
    }

    @Override // androidx.startup.Initializer
    public /* bridge */ /* synthetic */ WorkManager create(Context r1) {
        return create(r1);
    }
}
