package rkb;

import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;

/* JADX INFO: loaded from: classes36.dex */
public interface a<T> {

    /* JADX INFO: renamed from: rkb.a$a, reason: collision with other inner class name */
    public interface InterfaceC7498a<T> {
        void onDataReady(T r100);

        void onLoadFailed(Exception r100);
    }

    void cancel();

    void cleanup();

    Class<T> getDataClass();

    DataSource getDataSource();

    void loadData(Priority r100, InterfaceC7498a<? super T> r101);
}
