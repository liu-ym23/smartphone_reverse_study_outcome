package com.bytedance.ee.bear.bitable.card.view.cell.chatter;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.bytedance.ee.bear.widgets.tagview.SpaceTagTitleView;
import com.chad.library.adapter.base.BaseViewHolder;
import com.larksuite.component.universe_design.checkbox.UDCheckBox;
import com.larksuite.component.universe_design.image.UDAvatar;
import com.larus.nova.R;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u001e\u001a\u00020\u001fH\u0002R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001a\u001a\u00020\u001b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u0006 "}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/view/cell/chatter/SuggestChatterViewHolder;", "Lcom/chad/library/adapter/base/BaseViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "avatarRIV", "Lcom/larksuite/component/universe_design/image/UDAvatar;", "getAvatarRIV", "()Lcom/larksuite/component/universe_design/image/UDAvatar;", "nameTv", "Lcom/bytedance/ee/bear/widgets/tagview/SpaceTagTitleView;", "getNameTv", "()Lcom/bytedance/ee/bear/widgets/tagview/SpaceTagTitleView;", "departmentTv", "Landroid/widget/TextView;", "getDepartmentTv", "()Landroid/widget/TextView;", "selectCb", "Lcom/larksuite/component/universe_design/checkbox/UDCheckBox;", "getSelectCb", "()Lcom/larksuite/component/universe_design/checkbox/UDCheckBox;", "userInfoIcon", "Landroidx/appcompat/widget/AppCompatImageView;", "getUserInfoIcon", "()Landroidx/appcompat/widget/AppCompatImageView;", "userInfoLayout", "Landroid/widget/LinearLayout;", "getUserInfoLayout", "()Landroid/widget/LinearLayout;", "initView", "", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SuggestChatterViewHolder extends BaseViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final UDAvatar f207555a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SpaceTagTitleView f207556b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f207557c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final UDCheckBox f207558d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AppCompatImageView f207559e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final LinearLayout f207560f;

    public SuggestChatterViewHolder(View r100) {
        super(r100);
        UDAvatar r101 = (UDAvatar) this.itemView.findViewById(R.id.riv_suggest_user_avatar);
        this.f207555a = r101;
        SpaceTagTitleView r102 = (SpaceTagTitleView) this.itemView.findViewById(R.id.tv_user_name);
        this.f207556b = r102;
        TextView r103 = (TextView) this.itemView.findViewById(R.id.tv_user_department);
        this.f207557c = r103;
        this.f207558d = (UDCheckBox) this.itemView.findViewById(R.id.iv_select_user_checkbox);
        this.f207559e = (AppCompatImageView) this.itemView.findViewById(R.id.user_info_icon);
        this.f207560f = (LinearLayout) this.itemView.findViewById(R.id.ll_user_info);
        r103.setVisibility(8);
        com.bytedance.ee.util.ui.l.b(r101, R.color.bg_body);
        r102.setTitleSize(16.0f);
    }
}
