package com.larus.profile.impl.view;

import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.ixigua.lib.list.simple.ListViewHolder;
import com.larus.nova.R;
import com.larus.platform.service.z2;
import com.larus.utils.e1;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0002H\u0016R\u0016\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \t*\u0004\u0018\u00010\u000b0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/larus/profile/impl/view/ProfileBotListEmptyViewHolder;", "Lcom/ixigua/lib/list/simple/ListViewHolder;", "Lcom/larus/profile/api/bean/ProfileBotListEmptyData;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", KtvSubElement.CONTAINER, "Landroidx/constraintlayout/widget/ConstraintLayout;", "kotlin.jvm.PlatformType", "description", "Landroid/widget/TextView;", "bindData", "", "data", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ProfileBotListEmptyViewHolder extends ListViewHolder<fs9.q> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f366880g = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ConstraintLayout f366881e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextView f366882f;

    public ProfileBotListEmptyViewHolder(ConstraintLayout r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
        this.f366881e = (ConstraintLayout) r100.findViewById(R.id.container);
        this.f366882f = (TextView) r100.findViewById(R.id.profile_info_nickname);
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [T, fs9.q, java.lang.Object] */
    @Override // com.ixigua.lib.list.simple.ListViewHolder
    public final void T3(fs9.q r100) {
        fs9.q r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "data");
        this.f278523a = r101;
        int r102 = 0;
        if (r101.f478681a == false) goto L9;
        TextView r103 = this.f366882f;
        if (z2.f365865a.botCreateEnable() == true) goto L8;
        r102 = 8;
    L8:
        r103.setVisibility(r102);
    L10:
        e1.d(this.f366881e, new h(this));
        return;
    L9:
        this.f366882f.setVisibility(0);
        this.f366882f.setText(this.itemView.getContext().getString(R.string.larus_empty_profile_placeholder_other_user));
        goto L10
    }
}
