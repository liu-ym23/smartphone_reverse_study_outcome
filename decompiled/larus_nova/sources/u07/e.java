package u07;

import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;

/* JADX INFO: loaded from: classes21.dex */
public final class e extends BaseDataSubscriber<Void> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ v7a.e f548202a;

    public e(v7a.e r100) {
        this.f548202a = r100;
    }

    @Override // com.facebook.datasource.BaseDataSubscriber
    public final void onFailureImpl(DataSource<Void> r100) {
        if (r100.getFailureCause() == null) goto L5;
        this.f548202a.onFailure(u7a.b.a(r100.getFailureCause()), r100.getFailureCause());
        return;
    L5:
        this.f548202a.onFailure(-1, new Throwable("image prefetch to bitmap cache failed."));
    }

    @Override // com.facebook.datasource.BaseDataSubscriber
    public final void onNewResultImpl(DataSource<Void> r100) {
        this.f548202a.onSuccess(null, null, null);
    }
}
