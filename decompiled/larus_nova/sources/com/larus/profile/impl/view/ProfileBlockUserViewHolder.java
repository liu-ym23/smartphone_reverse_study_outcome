package com.larus.profile.impl.view;

import android.view.View;
import com.ixigua.lib.list.simple.ListViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0016¨\u0006\n"}, d2 = {"Lcom/larus/profile/impl/view/ProfileBlockUserViewHolder;", "Lcom/ixigua/lib/list/simple/ListViewHolder;", "Lcom/larus/profile/api/bean/ProfileBlockUserData;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "bindData", "", "data", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ProfileBlockUserViewHolder extends ListViewHolder<fs9.m> {
    public ProfileBlockUserViewHolder(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [T, fs9.m, java.lang.Object] */
    @Override // com.ixigua.lib.list.simple.ListViewHolder
    public final void T3(fs9.m r100) {
        fs9.m r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "data");
        this.f278523a = r101;
    }
}
