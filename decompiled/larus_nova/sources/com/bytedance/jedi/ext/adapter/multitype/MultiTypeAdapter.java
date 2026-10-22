package com.bytedance.jedi.ext.adapter.multitype;

import com.bytedance.jedi.ext.adapter.multitype.MultiTypeViewHolder;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\f\b\u0000\u0010\u0002*\u0006\u0012\u0002\b\u00030\u00012\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u0003B\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/jedi/ext/adapter/multitype/MultiTypeAdapter;", "Lcom/bytedance/jedi/ext/adapter/multitype/MultiTypeViewHolder;", "VH", "Lcom/bytedance/jedi/ext/adapter/multitype/MultiTypeRawAdapter;", "Lcom/bytedance/jedi/ext/adapter/multitype/ViewHolderFactoryManager;", "<init>", "()V", "ext_adapter_release"}, k = 1, mv = {1, 4, 0})
public abstract class MultiTypeAdapter<VH extends MultiTypeViewHolder<?>> extends MultiTypeRawAdapter<VH, ViewHolderFactoryManager<VH>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewHolderFactoryManager<VH> f251034a;

    public MultiTypeAdapter() {
        ViewHolderFactoryManager<VH> r100 = new ViewHolderFactoryManager();
        z2(r100);
        this.f251034a = r100;
    }

    @Override // com.bytedance.jedi.ext.adapter.multitype.b
    public final ViewHolderFactoryManager<VH> n() {
        return this.f251034a;
    }
}
