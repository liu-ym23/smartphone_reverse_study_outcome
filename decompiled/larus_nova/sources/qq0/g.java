package qq0;

import com.bytedance.android.live.openplatform.impl.miniappaudience.shelf.view.AudienceShelfDisplayDialog;
import com.bytedance.android.livesdk.widget.MaxHeightRecyclerView;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import java.util.List;

/* JADX INFO: loaded from: classes46.dex */
public final class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AudienceShelfDisplayDialog f534452a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ List f534453b;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g f534454a;

        public a(g r100) {
            this.f534454a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            AudienceShelfDisplayDialog.ba0(this.f534454a.f534452a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public g(AudienceShelfDisplayDialog r100, List r101) {
        this.f534452a = r100;
        this.f534453b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AudienceShelfDisplayDialog r100 = this.f534452a;     // Catch: Throwable -> L8
        if (r100.f84969m == false) goto L5;
        ((MaxHeightRecyclerView) r100.T90(R.id.shelf_page_list)).post(new a(this));     // Catch: Throwable -> L8
    L6:
        this.f534452a.f84969m = false;     // Catch: Throwable -> L8
        return;
    L5:
        AudienceShelfDisplayDialog.ba0(r100);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L12;
        return;
    L12:
        throw th;
    }
}
