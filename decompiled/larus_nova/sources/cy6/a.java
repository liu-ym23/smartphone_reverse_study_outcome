package cy6;

import io.reactivex.Single;

/* JADX INFO: loaded from: classes21.dex */
public interface a {
    Single<d> a();

    boolean hasMore();

    Single<d> refresh();

    void release();
}
