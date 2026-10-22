package com.larus.bmhome.view.resourcebar.viewholder;

import com.larus.bmhome.view.resourcebar.bean.ResourceBarConfig;
import com.larus.bmhome.view.resourcebar.bean.ResourceItemBean;
import com.larus.chat.common.databinding.LarusAddResourceItemViewBinding;
import com.larus.utils.e1;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0011"}, d2 = {"Lcom/larus/bmhome/view/resourcebar/viewholder/AddResourceViewHolder;", "Lcom/larus/bmhome/view/resourcebar/viewholder/BaseResourceViewHolder;", "config", "Lcom/larus/bmhome/view/resourcebar/bean/ResourceBarConfig;", "viewBinding", "Lcom/larus/chat/common/databinding/LarusAddResourceItemViewBinding;", "<init>", "(Lcom/larus/bmhome/view/resourcebar/bean/ResourceBarConfig;Lcom/larus/chat/common/databinding/LarusAddResourceItemViewBinding;)V", "getViewBinding", "()Lcom/larus/chat/common/databinding/LarusAddResourceItemViewBinding;", "bind", "", "data", "Lcom/larus/bmhome/view/resourcebar/bean/ResourceItemBean;", "callback", "Lcom/larus/bmhome/view/resourcebar/viewholder/BaseResourceViewHolder$Callback;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AddResourceViewHolder extends BaseResourceViewHolder {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f317157c = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LarusAddResourceItemViewBinding f317158b;

    public static final class a {
    }

    static {
    }

    public AddResourceViewHolder(ResourceBarConfig r100, LarusAddResourceItemViewBinding r101) {
        Intrinsics.checkNotNullParameter(r100, "config");
        Intrinsics.checkNotNullParameter(r101, "viewBinding");
        super(r100, r101.f323903a);
        this.f317158b = r101;
    }

    @Override // com.larus.bmhome.view.resourcebar.viewholder.BaseResourceViewHolder
    public final void T3(final ResourceItemBean r100, final lt8.a r101) {
        Intrinsics.checkNotNullParameter(r100, "data");
        e1.d(this.f317158b.f323903a, new com.larus.bmhome.view.resourcebar.viewholder.a(r101, r100));
    }
}
