package com.bytedance.ee.bear.bitable.card.view.cell.chatter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.chad.library.adapter.base.BaseViewHolder;
import com.larksuite.component.universe_design.image.UDAvatar;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0012\u001a\u00020\u0013H\u0002R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/view/cell/chatter/SelectedChatterViewHolder;", "Lcom/chad/library/adapter/base/BaseViewHolder;", "rootView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "avatarRIV", "Lcom/larksuite/component/universe_design/image/UDAvatar;", "getAvatarRIV", "()Lcom/larksuite/component/universe_design/image/UDAvatar;", "nameTv", "Landroid/widget/TextView;", "getNameTv", "()Landroid/widget/TextView;", "removeBtn", "Landroid/widget/ImageView;", "getRemoveBtn", "()Landroid/widget/ImageView;", "initView", "", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SelectedChatterViewHolder extends BaseViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final UDAvatar f207544a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f207545b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageView f207546c;

    public SelectedChatterViewHolder(View r100) {
        Intrinsics.checkNotNullParameter(r100, "rootView");
        super(r100);
        UDAvatar r101 = (UDAvatar) this.itemView.findViewById(R.id.riv_selected_user_avatar);
        this.f207544a = r101;
        this.f207545b = (TextView) this.itemView.findViewById(R.id.tv_selected_user_name);
        ImageView r102 = (ImageView) this.itemView.findViewById(R.id.iv_remove_selected_user);
        this.f207546c = r102;
        com.bytedance.ee.util.ui.l.b(r101, R.color.icon_n1);
        com.bytedance.ee.util.ui.l.b(r102, R.color.icon_n1);
    }
}
