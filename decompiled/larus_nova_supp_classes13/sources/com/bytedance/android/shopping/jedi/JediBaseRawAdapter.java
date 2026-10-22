package com.bytedance.android.shopping.jedi;

import androidx.lifecycle.LifecycleOwner;
import com.bytedance.jedi.arch.IReceiver;
import com.bytedance.jedi.ext.adapter.JediViewHolder;
import com.bytedance.jedi.ext.adapter.f;
import com.bytedance.jedi.ext.adapter.multitype.ViewHolderFactoryManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u0000*\u0014\b\u0000\u0010\u0003*\u000e\u0012\u0006\b\u0001\u0012\u00020\u0002\u0012\u0002\b\u00030\u00012\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00050\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/shopping/jedi/JediBaseRawAdapter;", "Lcom/bytedance/jedi/ext/adapter/JediViewHolder;", "Lcom/bytedance/jedi/arch/IReceiver;", "VH", "Lcom/bytedance/android/shopping/jedi/MultiTypeAdapter;", "Lcom/bytedance/jedi/ext/adapter/f;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class JediBaseRawAdapter<VH extends JediViewHolder<? extends IReceiver, ?>> extends MultiTypeAdapter<VH, f<VH>> {
    public final f<VH> u;

    public final ViewHolderFactoryManager n() {
        return this.u;
    }

    public JediBaseRawAdapter(LifecycleOwner r2) {
        Intrinsics.checkNotNullParameter(r2, "parent");
        f<VH> r0 = new f(r2);
        B2(r0);
        Unit r3 = Unit.INSTANCE;
        this.u = r0;
    }
}
