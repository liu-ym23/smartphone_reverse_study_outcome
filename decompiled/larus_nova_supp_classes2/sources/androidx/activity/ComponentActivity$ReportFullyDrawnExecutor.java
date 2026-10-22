package androidx.activity;

import android.view.View;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public interface ComponentActivity$ReportFullyDrawnExecutor extends Executor {
    void activityDestroyed();

    void viewCreated(View r1);
}
