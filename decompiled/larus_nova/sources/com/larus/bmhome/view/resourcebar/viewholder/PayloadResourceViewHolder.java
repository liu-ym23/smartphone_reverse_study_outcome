package com.larus.bmhome.view.resourcebar.viewholder;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.larus.bmhome.view.resourcebar.bean.ResourceBarConfig;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\b&\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH&¨\u0006\r"}, d2 = {"Lcom/larus/bmhome/view/resourcebar/viewholder/PayloadResourceViewHolder;", "Lcom/larus/bmhome/view/resourcebar/viewholder/BaseResourceViewHolder;", "config", "Lcom/larus/bmhome/view/resourcebar/bean/ResourceBarConfig;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/larus/bmhome/view/resourcebar/bean/ResourceBarConfig;Landroid/view/View;)V", "bindPayloads", "", "payloads", "", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class PayloadResourceViewHolder extends BaseResourceViewHolder {
    public abstract void U3(List<Object> r100);

    public PayloadResourceViewHolder(ResourceBarConfig r100, ConstraintLayout r101) {
        Intrinsics.checkNotNullParameter(r100, "config");
        Intrinsics.checkNotNullParameter(r101, "itemView");
        super(r100, r101);
    }
}
