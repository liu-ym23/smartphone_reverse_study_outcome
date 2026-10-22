package by3;

import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.awemeopen.infra.base.log.AoLogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final /* synthetic */ class a implements Runnable {
    public final /* synthetic */ RecyclerView.Adapter a;

    public /* synthetic */ a(RecyclerView.Adapter r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        RecyclerView.Adapter r0 = this.a;
        r0.notifyDataSetChanged();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        AoLogger.c("CrashlyticsWrapper", new Object[]{r0.getClass().getName(), e});
    }
}
