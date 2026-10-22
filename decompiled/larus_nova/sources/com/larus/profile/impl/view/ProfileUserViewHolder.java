package com.larus.profile.impl.view;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.ixigua.lib.list.simple.ListViewHolder;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0002H\u0016R\u0016\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/larus/profile/impl/view/ProfileUserViewHolder;", "Lcom/ixigua/lib/list/simple/ListViewHolder;", "Lcom/larus/profile/api/bean/ProfilePageHeaderInfo;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "userInfo", "Lcom/larus/profile/impl/view/ProfileHeaderUserInfoView;", "kotlin.jvm.PlatformType", "bindData", "", "data", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ProfileUserViewHolder extends ListViewHolder<fs9.v> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f366909f = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ProfileHeaderUserInfoView f366910e;

    public ProfileUserViewHolder(ConstraintLayout r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
        this.f366910e = (ProfileHeaderUserInfoView) r100.findViewById(R.id.header_user_info);
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [T, fs9.v, java.lang.Object] */
    @Override // com.ixigua.lib.list.simple.ListViewHolder
    public final void T3(fs9.v r100) {
        fs9.v r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "data");
        this.f278523a = r101;
        this.f366910e.S5(r101.f478684a, r101.f478685b);
        this.f366910e.setAvatarClick(new y(this));
        this.f366910e.setEditClick(new z(this));
        this.f366910e.setQrCodeClick(new a0(this));
    }
}
