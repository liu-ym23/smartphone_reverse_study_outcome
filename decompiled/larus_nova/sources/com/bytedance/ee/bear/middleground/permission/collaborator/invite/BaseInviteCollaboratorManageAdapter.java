package com.bytedance.ee.bear.middleground.permission.collaborator.invite;

import android.text.TextUtils;
import android.widget.TextView;
import com.bytedance.ee.bear.contract.AccountService$Account;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.bytedance.ee.bear.widgets.tagview.SpaceTagTitleView;
import com.bytedance.ee.bear.widgets.tagview.SpaceTagType;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.larksuite.component.universe_design.image.UDAvatar;
import com.larus.nova.R;
import java.util.Locale;

/* JADX INFO: loaded from: classes18.dex */
public class BaseInviteCollaboratorManageAdapter extends BaseQuickAdapter<UserInfo, BaseViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Locale f233162a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AccountService$Account f233163b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a f233164c;

    public interface a {
        void a(UserInfo r100, int r101);
    }

    public BaseInviteCollaboratorManageAdapter(Locale r100, AccountService$Account r101) {
        super(R.layout.share_folder_permission_manage_item);
        this.f233162a = r100;
        this.f233163b = r101;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public /* bridge */ /* synthetic */ void convert(BaseViewHolder r100, UserInfo r101) {
        y2(r100, r101);
    }

    public void y2(BaseViewHolder r100, UserInfo r101) {
        pg5.a.b((UDAvatar) r100.getView(R.id.share_item_icon), r101);
        SpaceTagTitleView r102 = (SpaceTagTitleView) r100.getView(R.id.share_item_name);
        String r103 = r101.getDisplayName(this.f233162a);
        if (ou5.a.e() == false) goto L5;
        r103 = ou5.c.e(this.f233162a.getLanguage(), r101.getI18nNames(), r103);
    L5:
        r102.setTitle(r103);
        String r104 = r101.getOrganizationTagValue();
        boolean r105 = r101.isExternal();
        int r106 = ui5.c.f550208a;
        boolean r107 = ui5.c.a(this.f233163b);
        int r108 = SpaceTagType.f240339e;
        SpaceTagType r109 = SpaceTagType.Companion.f(r104, r105, r107);
        int r110 = 0;
        r102.setLabels(new SpaceTagType[]{r109});
        TextView r111 = (TextView) r100.getView(R.id.share_item_subtitle);
        if (r101.getOwnerType() == 2) goto L15;
        if (r101.getOwnerType() == 29) goto L15;
        if (TextUtils.isEmpty(r101.getDisplayLabel()) == false) goto L13;
        r110 = 8;
    L13:
        r111.setVisibility(r110);
        r111.setText(r101.getDisplayLabel());
        return;
    L15:
        if (TextUtils.isEmpty(r101.getLabel()) == false) goto L17;
        r110 = 8;
    L17:
        r111.setVisibility(r110);
        r111.setText(r101.getLabel());
    }
}
