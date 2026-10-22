package com.bytedance.jedi.model.datasource;

import com.bytedance.jedi.model.util.WeakRefStore;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/jedi/model/datasource/DataSourceStore;", "", "Lcom/bytedance/jedi/model/datasource/IDataSource;", "<init>", "()V", "model_release"}, k = 1, mv = {1, 7, 1})
public final class DataSourceStore {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final DataSourceStore f251063b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WeakRefStore<IDataSource<?, ?>> f251064a;

    static {
        f251063b = new DataSourceStore();
    }

    private DataSourceStore() {
        this.f251064a = new WeakRefStore();
    }
}
