package com.ss.android.lark.forwardv3.recentforward.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.larksuite.component.universe_design.checkbox.UDCheckBox;
import com.larksuite.component.universe_design.image.UDAvatar;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\"\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\"\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\n\u001a\u0004\u0018\u00010\u000f@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\"\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\n\u001a\u0004\u0018\u00010\u0013@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\"\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\n\u001a\u0004\u0018\u00010\u0017@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\"\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010\n\u001a\u0004\u0018\u00010\u001b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Lcom/ss/android/lark/forwardv3/recentforward/viewholder/RecentForwardViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "viewType", "", "<init>", "(Landroid/view/View;I)V", "getViewType", "()I", "value", "Lcom/larksuite/component/universe_design/image/UDAvatar;", "avatarView", "getAvatarView", "()Lcom/larksuite/component/universe_design/image/UDAvatar;", "Lcom/larksuite/component/universe_design/checkbox/UDCheckBox;", "userCheckBox", "getUserCheckBox", "()Lcom/larksuite/component/universe_design/checkbox/UDCheckBox;", "Landroid/widget/TextView;", "userNameTv", "getUserNameTv", "()Landroid/widget/TextView;", "Landroid/widget/ImageView;", "otherIcon", "getOtherIcon", "()Landroid/widget/ImageView;", "Landroid/widget/LinearLayout;", "recentForwardContainer", "getRecentForwardContainer", "()Landroid/widget/LinearLayout;", "forward-new_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RecentForwardViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f425515a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final UDAvatar f425516b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final UDCheckBox f425517c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f425518d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ImageView f425519e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final LinearLayout f425520f;

    public RecentForwardViewHolder(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super(r100);
        this.f425515a = r101;
        this.f425516b = (UDAvatar) r100.findViewById(R.id.avatar_view);
        this.f425517c = (UDCheckBox) r100.findViewById(R.id.user_check_box);
        this.f425518d = (TextView) r100.findViewById(R.id.user_name_tv);
        this.f425519e = (ImageView) r100.findViewById(R.id.other_icon);
        this.f425520f = (LinearLayout) r100.findViewById(R.id.recent_forward_container);
    }
}
