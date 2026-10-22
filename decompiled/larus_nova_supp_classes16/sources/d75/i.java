package d75;

import android.content.Context;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.drive.biz.versions.VersionHistoryRepository;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class i extends m75.a<c> {
    public final CompositeDisposable e;
    public final VersionHistoryRepository f;

    @Override // m75.a, m75.d
    public final void onDestroy() {
        super.onDestroy();
        this.e.clear();
    }

    public i(Context r1, NetService r2) {
        super(r1);
        this.e = new CompositeDisposable();
        this.f = new VersionHistoryRepository(r2);
    }

    public final void j(String r4, boolean r5) {
        if (r5 == false) goto L6;
        V r6 = this.a;
        if (r6 == 0) goto L6;
        ((c) r6).showLoading();
    L6:
        Disposable r7 = this.f.a(r4, 20, 0).observeOn(fo5.d.d()).subscribe(new e(this), new f(this));
        this.e.add(r7);
    }
}
