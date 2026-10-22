package com.ss.android.ugc.aweme.search.optimize;

import androidx.exifinterface.media.ExifInterface;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/ss/android/ugc/aweme/search/optimize/BaseOptimize;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/ss/android/ugc/aweme/search/optimize/IOptimize;", "trade-search-impl_release"}, k = 1, mv = {1, 4, 3})
public abstract class BaseOptimize<T> implements IOptimize {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IOptimizeCore<T> f453350a;

    @Override // com.ss.android.ugc.aweme.search.optimize.IEventDispatcher
    public void a(Object r100, SearchOptimizeRequestContext r101) {
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
    }

    @Override // com.ss.android.ugc.aweme.search.optimize.IEventDispatcher
    public void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "scene");
    }

    @Override // com.ss.android.ugc.aweme.search.optimize.IEventDispatcher
    public void c(boolean r100, SearchOptimizeRequestContext r101) {
    }

    @Override // com.ss.android.ugc.aweme.search.optimize.IEventDispatcher
    public void d(ResponseStatus r100) {
        Intrinsics.checkNotNullParameter(r100, "responseStatus");
    }

    public BaseOptimize(IOptimizeCore<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "core");
        this.f453350a = r100;
    }
}
