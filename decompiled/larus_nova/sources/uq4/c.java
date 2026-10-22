package uq4;

import com.bytedance.ee.bear.bitable.cardview.viewsetting.adapter.SelectFieldViewHolder;
import com.bytedance.ee.bear.bitable.cardview.viewsetting.adapter.ViewSettingSelectFieldListAdapter;
import com.bytedance.ee.bear.bitable.filter.model.FilterFieldOption;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes15.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ViewSettingSelectFieldListAdapter<SelectFieldViewHolder> f551290a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ List<FilterFieldOption> f551291b;

    /* JADX WARN: Multi-variable type inference failed */
    public c(ViewSettingSelectFieldListAdapter<SelectFieldViewHolder> r100, List<? extends FilterFieldOption> r101) {
        this.f551290a = r100;
        this.f551291b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ((ArrayList) this.f551290a.f209246d).clear();     // Catch: Throwable -> L4
        List<FilterFieldOption> r100 = this.f551290a.f209246d;     // Catch: Throwable -> L4
        ArrayList r101 = (ArrayList) r100;     // Catch: Throwable -> L4
        r101.addAll(this.f551291b);     // Catch: Throwable -> L4
        this.f551290a.notifyDataSetChanged();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
