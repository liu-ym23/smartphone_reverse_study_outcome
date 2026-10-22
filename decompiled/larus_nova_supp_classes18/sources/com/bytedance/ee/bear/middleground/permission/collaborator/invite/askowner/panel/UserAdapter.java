package com.bytedance.ee.bear.middleground.permission.collaborator.invite.askowner.panel;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bytedance.ee.bear.contract.AccountService;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.bytedance.ee.bear.widgets.tagview.SpaceTagTitleView;
import com.bytedance.ee.bear.widgets.tagview.SpaceTagType;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.larksuite.component.universe_design.image.UDAvatar;
import com.ss.android.lark.image.entity.AvatarImage;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0010B!\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0002H\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/collaborator/invite/askowner/panel/UserAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/bytedance/ee/bear/share/export/UserInfo;", "Lcom/bytedance/ee/bear/middleground/permission/collaborator/invite/askowner/panel/UserAdapter$ViewHolder;", "locale", "Ljava/util/Locale;", "account", "Lcom/bytedance/ee/bear/contract/AccountService$Account;", "from", "", "<init>", "(Ljava/util/Locale;Lcom/bytedance/ee/bear/contract/AccountService$Account;I)V", "convert", "", "helper", "item", "ViewHolder", "middleground-permission_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UserAdapter extends BaseQuickAdapter<UserInfo, ViewHolder> {
    public final Locale a;
    public final AccountService.Account b;
    public final int c;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/collaborator/invite/askowner/panel/UserAdapter$ViewHolder;", "Lcom/chad/library/adapter/base/BaseViewHolder;", "root", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "userNameView", "Lcom/bytedance/ee/bear/widgets/tagview/SpaceTagTitleView;", "getUserNameView", "()Lcom/bytedance/ee/bear/widgets/tagview/SpaceTagTitleView;", "labelView", "Landroid/widget/TextView;", "getLabelView", "()Landroid/widget/TextView;", "avatarView", "Lcom/larksuite/component/universe_design/image/UDAvatar;", "getAvatarView", "()Lcom/larksuite/component/universe_design/image/UDAvatar;", "divider", "getDivider", "()Landroid/view/View;", "middleground-permission_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ViewHolder extends BaseViewHolder {
        public final SpaceTagTitleView a;
        public final TextView b;
        public final UDAvatar c;
        public final View d;

        public ViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "root");
            super(r2);
            this.a = (SpaceTagTitleView) r2.findViewById(2131391986);
            this.b = (TextView) r2.findViewById(2131377095);
            this.c = r2.findViewById(2131363638);
            this.d = r2.findViewById(2131369197);
        }
    }

    public final void convert(BaseViewHolder r7, Object r8) {
        ViewHolder r9 = (ViewHolder) r7;
        UserInfo r10 = (UserInfo) r8;
        Intrinsics.checkNotNullParameter(r9, "helper");
        Intrinsics.checkNotNullParameter(r10, "item");
        r9.a.setTitle(r10.getDisplayName(this.a));
        SpaceTagTitleView r0 = r9.a;
        boolean r1 = true;
        int r3 = SpaceTagType.e;
        String r4 = r10.getOrganizationTagValue();
        boolean r5 = r10.isExternal();
        int r6 = ui5.c.a;
        SpaceTagType r11 = SpaceTagType.Companion.f(r4, r5, ui5.c.a(this.b));
        int r12 = 0;
        r0.setLabels(new SpaceTagType[]{r11});
        String r2 = r10.getDisplayLabel();
        TextView r13 = r9.b;
        if (TextUtils.isEmpty(r2) == false) goto L5;
        int r14 = 8;
    L6:
        r13.setVisibility(r14);
        r9.b.setText(r2);
        if (this.c != 2) goto L9;
        Intrinsics.checkNotNull(Glide.with(((RecyclerView.ViewHolder) r9).itemView.getContext()).load(AvatarImage.Builder.obtain(r10.getAvatarUrl(), r10.getId(), 240, 240).build()).placeholder(2131235295).into(r9.c));
    L11:
        if (r9.getAdapterPosition() == (getData().size() - 1)) goto L14;
        r1 = false;
    L14:
        View r15 = r9.d;
        if (r1 == false) goto L17;
        r12 = 8;
    L17:
        r15.setVisibility(r12);
        return;
    L9:
        pg5.a.b(r9.c, r10);
        goto L11
    L5:
        r14 = 0;
        goto L6
    }

    public UserAdapter(Locale r2, AccountService.Account r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "locale");
        super(2131564197);
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
