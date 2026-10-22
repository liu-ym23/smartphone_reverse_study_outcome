package androidx.activity.result;

import androidx.activity.result.contract.ActivityResultContract;
import androidx.core.app.ActivityOptionsCompat;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public abstract class ActivityResultLauncher<I> {
    public ActivityResultLauncher() {
    }

    public abstract ActivityResultContract<I, ?> getContract();

    public abstract void launch(I r1, ActivityOptionsCompat r2);

    public abstract void unregister();

    public void launch(I r2) {
        launch(r2, null);
    }
}
