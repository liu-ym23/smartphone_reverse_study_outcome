package com.bytedance.jedi.ext.adapter.multitype;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u0002B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/jedi/ext/adapter/multitype/SingleTypeAdapter;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/bytedance/jedi/ext/adapter/multitype/MultiTypeAdapter;", "Lcom/bytedance/jedi/ext/adapter/multitype/MultiTypeViewHolder;", "<init>", "()V", "ext_adapter_release"}, k = 1, mv = {1, 4, 0})
public abstract class SingleTypeAdapter<T> extends MultiTypeAdapter<MultiTypeViewHolder<T>> {
    public abstract MultiTypeViewHolder A2();

    public SingleTypeAdapter() {
    }

    @Override // com.bytedance.jedi.ext.adapter.multitype.MultiTypeRawAdapter
    public final void z2(c<MultiTypeViewHolder<T>> r100) {
        ViewHolderFactoryManager r101 = (ViewHolderFactoryManager) r100;
        c.a.a(r101, null, new SingleTypeAdapter$registerFactories$1(this), 3);
    }
}
