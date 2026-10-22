package com.bytedance.jedi.ext.adapter;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.jedi.ext.adapter.multitype.MultiTypeViewHolder;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B%\b\u0016\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/jedi/ext/adapter/DiffableSingleTypeAdapter;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/bytedance/jedi/ext/adapter/DiffableMultiTypeAdapter;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "diffCallback", "Lcom/bytedance/jedi/arch/ext/list/differ/JediListPrefetcher$Fetcher;", "fetcher", "<init>", "(Landroid/support/v7/util/DiffUtil$ItemCallback;Lcom/bytedance/jedi/arch/ext/list/differ/JediListPrefetcher$Fetcher;)V", "ext_adapter_release"}, k = 1, mv = {1, 4, 0})
public abstract class DiffableSingleTypeAdapter<T> extends DiffableMultiTypeAdapter<T> {
    public abstract MultiTypeViewHolder A2();
}
