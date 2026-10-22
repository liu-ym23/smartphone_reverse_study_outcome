package com.bytedance.locallife.photo.photopage.adapter;

import androidx.exifinterface.media.ExifInterface;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/locallife/photo/photopage/adapter/BaseAdapter;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/bytedance/locallife/photo/photopage/adapter/LoadMoreRecyclerViewAdapter;", "<init>", "()V", "locallife-photo-impl_release"}, k = 1, mv = {1, 4, 3})
public abstract class BaseAdapter<T> extends LoadMoreRecyclerViewAdapter {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List<T> f262151c;

    @Override // com.bytedance.locallife.photo.photopage.adapter.LoadMoreRecyclerViewAdapter, com.bytedance.locallife.photo.photopage.adapter.RecyclerViewWithFooterAdapter
    public final int getBasicItemCount() {
        List<T> r100 = this.f262151c;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.size();
    }

    public BaseAdapter() {
        registerAdapterDataObserver(new AnonymousClass1(this));
    }

    public final void y2(boolean r100) {
        if (r100 == false) goto L4;
        notifyItemInserted(getItemCount() - 1);
    L5:
        getItemCount();
        return;
    L4:
        notifyItemRemoved(getItemCount());
        goto L5
    }
}
