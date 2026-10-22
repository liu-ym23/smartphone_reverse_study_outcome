package com.bytedance.jedi.ext.adapter;

import android.view.ViewGroup;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.jedi.ext.adapter.multitype.MultiTypeViewHolder;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lcom/bytedance/jedi/ext/adapter/multitype/MultiTypeViewHolder;", ExifInterface.GPS_DIRECTION_TRUE, "it", "Landroid/view/ViewGroup;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 1, 16})
final class DiffableSingleTypeAdapter$registerFactories$1 extends Lambda implements Function1<ViewGroup, MultiTypeViewHolder<Object>> {
    final /* synthetic */ DiffableSingleTypeAdapter this$0;

    public DiffableSingleTypeAdapter$registerFactories$1(DiffableSingleTypeAdapter r100) {
        this.this$0 = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final MultiTypeViewHolder<Object> invoke2(ViewGroup r100) {
        return this.this$0.A2();
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ MultiTypeViewHolder<Object> invoke(ViewGroup r100) {
        return invoke2(r100);
    }
}
