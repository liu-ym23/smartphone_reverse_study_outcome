package com.bytedance.locallife.dito.common.plugin;

import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes21.dex */
public final class g extends BaseDataSubscriber<Void> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DitoImagePrefetchPlugin f257581a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DataSource<Void> f257582b;

    @Override // com.facebook.datasource.BaseDataSubscriber
    public final void onFailureImpl(DataSource<Void> r100) {
        List<DataSource<?>> r101 = this.f257581a.f257466g;
        CopyOnWriteArrayList r102 = (CopyOnWriteArrayList) r101;
        r102.remove(this.f257582b);
    }

    @Override // com.facebook.datasource.BaseDataSubscriber
    public final void onNewResultImpl(DataSource<Void> r100) {
        List<DataSource<?>> r101 = this.f257581a.f257466g;
        CopyOnWriteArrayList r102 = (CopyOnWriteArrayList) r101;
        r102.remove(this.f257582b);
    }

    public g(DitoImagePrefetchPlugin r100, DataSource<Void> r101) {
        this.f257581a = r100;
        this.f257582b = r101;
    }
}
