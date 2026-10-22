package com.ss.android.ugc.aweme.search.dynamic.base;

import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/search/dynamic/base/DefaultHostControllerDelegate;", "Landroidx/recyclerview/widget/RecyclerView;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/ss/android/ugc/aweme/search/dynamic/base/IDynamicHostControllerDelegate;", "trade-search-impl_release"}, k = 1, mv = {1, 4, 3})
public class DefaultHostControllerDelegate<T extends RecyclerView> implements IDynamicHostControllerDelegate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f452584a;

    @Override // com.ss.android.ugc.aweme.search.dynamic.base.IDynamicHostControllerDelegate
    public final View getHostView() {
        return this.f452584a;
    }

    public DefaultHostControllerDelegate(View r100) {
        this.f452584a = r100;
    }
}
