package com.larus.network.http;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00030\u0002B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u0007R\u001d\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0019\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\r"}, d2 = {"Lcom/larus/network/http/AsyncLiveData;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/MutableLiveData;", "Lcom/larus/network/http/Async;", "<init>", "()V", "asyncLiveData", "Landroidx/lifecycle/LiveData;", "getAsyncLiveData", "()Landroidx/lifecycle/LiveData;", "dataLiveData", "getDataLiveData", "toLiveData", "network_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AsyncLiveData<T> extends MutableLiveData<a<? extends T>> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f360111c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LiveData<a<T>> f360112a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LiveData<T> f360113b;

    public AsyncLiveData() {
        super(z.f360206d);
        this.f360112a = Transformations.distinctUntilChanged(this);
        this.f360113b = Transformations.distinctUntilChanged(Transformations.map(this, new c()));
    }
}
