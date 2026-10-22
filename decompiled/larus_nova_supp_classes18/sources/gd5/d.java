package gd5;

import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.listsync.entity.SyncPushConfig;
import com.bytedance.ee.bear.list.recent.u;
import com.bytedance.ee.bear.list.recent.v;
import io.reactivex.disposables.Disposable;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d {
    public final v a;
    public List<Document> b;
    public boolean c;
    public Disposable d;
    public long e;
    public final a f;

    public final void a() {
        tt5.a.h("RecentSyncManager", "refresh()...");
        long r1 = System.currentTimeMillis();
        if (((r1 - this.e) / 1000) >= SyncPushConfig.instance().getRefresh_interval()) goto L6;
        tt5.a.h("RecentSyncManager", "less than the time interval.");
        return;
    L6:
        this.e = r1;
        Disposable r0 = this.d;
        if (r0 != null) goto L9;
    L11:
        this.d = this.a.C().subscribe(new b(this), new c());
        return;
    L9:
        if (r0.isDisposed() == true) goto L11;
        this.d.dispose();
        goto L11
    }

    public d(v r1, u r2) {
        this.a = r1;
        this.f = r2;
    }
}
