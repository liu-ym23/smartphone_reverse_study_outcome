package com.bytedance.ee.bear.middleground.permission.collaborator.invite;

import android.text.TextUtils;
import android.widget.TextView;
import com.bytedance.ee.bear.contract.AccountService;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.bytedance.ee.bear.widgets.tagview.SpaceTagTitleView;
import com.bytedance.ee.bear.widgets.tagview.SpaceTagType;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.Locale;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class BaseInviteCollaboratorManageAdapter extends BaseQuickAdapter<UserInfo, BaseViewHolder> {
    public final Locale a;
    public final AccountService.Account b;
    public a c;

    public interface a {
        void a(UserInfo r1, int r2);
    }

    public BaseInviteCollaboratorManageAdapter(Locale r2, AccountService.Account r3) {
        super(2131564509);
        this.a = r2;
        this.b = r3;
    }

    public /* bridge */ /* synthetic */ void convert(BaseViewHolder r1, Object r2) {
        y2(r1, (UserInfo) r2);
    }

    public void y2(BaseViewHolder r7, UserInfo r8) {
        pg5.a.b(r7.getView(2131386088), r8);
        SpaceTagTitleView r0 = (SpaceTagTitleView) r7.getView(2131386091);
        String r1 = r8.getDisplayName(this.a);
        if (ou5.a.e() == false) goto L5;
        r1 = ou5.c.e(this.a.getLanguage(), r8.getI18nNames(), r1);
    L5:
        r0.setTitle(r1);
        String r2 = r8.getOrganizationTagValue();
        boolean r3 = r8.isExternal();
        int r4 = ui5.c.a;
        boolean r5 = ui5.c.a(this.b);
        int r6 = SpaceTagType.e;
        SpaceTagType r9 = SpaceTagType.Companion.f(r2, r3, r5);
        int r10 = 0;
        r0.setLabels(new SpaceTagType[]{r9});
        TextView r11 = (TextView) r7.getView(2131386094);
        if (r8.getOwnerType() == 2) goto L15;
        if (r8.getOwnerType() == 29) goto L15;
        if (TextUtils.isEmpty(r8.getDisplayLabel()) == false) goto L13;
        r10 = 8;
    L13:
        r11.setVisibility(r10);
        r11.setText(r8.getDisplayLabel());
        return;
    L15:
        if (TextUtils.isEmpty(r8.getLabel()) == false) goto L17;
        r10 = 8;
    L17:
        r11.setVisibility(r10);
        r11.setText(r8.getLabel());
    }
}
