package com.ss.android.ugc.aweme.discover.ui.feedcontainer.modules.page.module.optimize.async;

import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.ugc.aweme.discover.ui.feedcontainer.modules.page.module.optimize.core.IDataProvider;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002¨\u0006\u0003"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/ui/feedcontainer/modules/page/module/optimize/async/IAsyncLoad;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/ss/android/ugc/aweme/discover/ui/feedcontainer/modules/page/module/optimize/core/IDataProvider;", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IAsyncLoad<T> extends IDataProvider<T> {
    void e(RecyclerView.ViewHolder r100, int r101, boolean r102);

    RecyclerView.ViewHolder g(int r100, boolean r101);
}
