package com.bytedance.jedi.ext.adapter;

import android.view.ViewGroup;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.shopping.deepfeed.ui.vh.AbsDeepFeedProductVH;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B-\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nB)\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\r¢\u0006\u0004\b\t\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/jedi/ext/adapter/JediAdapter;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/bytedance/jedi/ext/adapter/JediMultiTypeAdapter;", "Landroidx/lifecycle/LifecycleOwner;", "parent", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "diffCallback", "Lcom/bytedance/jedi/arch/ext/list/differ/JediListPrefetcher$Fetcher;", "fetcher", "<init>", "(Landroid/arch/lifecycle/LifecycleOwner;Landroid/support/v7/util/DiffUtil$ItemCallback;Lcom/bytedance/jedi/arch/ext/list/differ/JediListPrefetcher$Fetcher;)V", "Lcom/bytedance/jedi/arch/ext/list/differ/JediListPrefetcher;", "prefetcher", "Lcom/bytedance/jedi/arch/ext/list/differ/JediDifferConfig;", "config", "(Landroid/arch/lifecycle/LifecycleOwner;Lcom/bytedance/jedi/arch/ext/list/differ/JediListPrefetcher;Lcom/bytedance/jedi/arch/ext/list/differ/JediDifferConfig;)V", "ext_adapter_release"}, k = 1, mv = {1, 4, 0})
public abstract class JediAdapter<T> extends JediMultiTypeAdapter<T> {
    public abstract AbsDeepFeedProductVH A2(ViewGroup r100);
}
