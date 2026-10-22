package com.ss.android.ugc.aweme.discover.ui.feedcontainer.modules.page.module.optimize.core;

import androidx.exifinterface.media.ExifInterface;
import com.ss.android.ugc.aweme.discover.model.SearchAggregateCommodity;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/ui/feedcontainer/modules/page/module/optimize/core/IDataProvider;", ExifInterface.GPS_DIRECTION_TRUE, "", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IDataProvider<T> {
    boolean c(int r100);

    SearchAggregateCommodity getData(int r100);

    boolean h(T r100, T r101);

    int positionOf(T r100);
}
