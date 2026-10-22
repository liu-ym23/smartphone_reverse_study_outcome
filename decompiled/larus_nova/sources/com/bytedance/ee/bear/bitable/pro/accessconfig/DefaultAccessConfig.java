package com.bytedance.ee.bear.bitable.pro.accessconfig;

import com.bytedance.ee.bear.bitable.pro.DefaultConfig;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.bytedance.ee.util.io.NonProguard;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.larus.nova.R;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u00190\u000bj\b\u0012\u0004\u0012\u00020\u0019`\r2\u0006\u0010\u001a\u001a\u00020\u001bJ\u0006\u0010\u001c\u001a\u00020\u001dR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR*\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u001f"}, d2 = {"Lcom/bytedance/ee/bear/bitable/pro/accessconfig/DefaultAccessConfig;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "defaultConfig", "Lcom/bytedance/ee/bear/bitable/pro/DefaultConfig;", "getDefaultConfig", "()Lcom/bytedance/ee/bear/bitable/pro/DefaultConfig;", "setDefaultConfig", "(Lcom/bytedance/ee/bear/bitable/pro/DefaultConfig;)V", "userList", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/share/export/UserInfo;", "Lkotlin/collections/ArrayList;", "getUserList", "()Ljava/util/ArrayList;", "setUserList", "(Ljava/util/ArrayList;)V", "publicPermission", "Lcom/bytedance/ee/bear/middleground_permission_export/model/doc/IDocPublicPermission;", "getPublicPermission", "()Lcom/bytedance/ee/bear/middleground_permission_export/model/doc/IDocPublicPermission;", "setPublicPermission", "(Lcom/bytedance/ee/bear/middleground_permission_export/model/doc/IDocPublicPermission;)V", "getMemberList", "Lcom/chad/library/adapter/base/entity/MultiItemEntity;", "maxNumber", "", "isSystemRole", "", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DefaultAccessConfig implements NonProguard {
    public static final a Companion = null;
    public static final int EXTRA_ITEM_TYPE = 2;
    public static final int LINK_ITEM_TYPE = 0;
    private DefaultConfig defaultConfig;
    private IDocPublicPermission publicPermission;
    private ArrayList<UserInfo> userList;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public final boolean isSystemRole() {
        int r100 = com.bytedance.ee.bear.bitable.pro.e.f215169a;
        if (com.bytedance.ee.bear.bitable.core.usercomponent.b.d("ccm.bitable.mobile_advance_sysrole_update_tips.enable") == false) goto L11;
        DefaultConfig r101 = this.defaultConfig;
        if (r101 == null) goto L7;
        boolean r102 = r101.getEnableSysRole();
    L8:
        if (r102 == false) goto L12;
        return true;
    L12:
        return false;
    L7:
        r102 = false;
        goto L8
    L11:
        return false;
    }

    public DefaultAccessConfig() {
        this.userList = new ArrayList();
    }

    public final DefaultConfig getDefaultConfig() {
        return this.defaultConfig;
    }

    public final IDocPublicPermission getPublicPermission() {
        return this.publicPermission;
    }

    public final ArrayList<UserInfo> getUserList() {
        return this.userList;
    }

    public final ArrayList<MultiItemEntity> getMemberList(int r100) {
        ArrayList<MultiItemEntity> r101 = new ArrayList();
        IDocPublicPermission r102 = this.publicPermission;
        if (r102 != null) goto L5;
    L18:
        int r103 = this.userList.size();
        int r104 = (r103 - r100) + 1;
        if (r103 <= r100) goto L21;
        r103 = r100 - 1;
    L21:
        int r105 = this.userList.size();
        int r106 = 0;
    L22:
        if (r106 >= r105) goto L27;
        UserInfo r107 = (UserInfo) ListProtector.get(this.userList, r106);
        if (r106 >= r103) goto L26;
        r101.add(r107);
        r106 = r106 + 1;
        goto L22
    L26:
        DefaultMemberExtraInfo r108 = new DefaultMemberExtraInfo();
        r108.setExtraMemberNumber(r104);
        r101.add(r108);
    L27:
        return r101;
    L5:
        if (r102.isLinkShareClose() == true) goto L18;
        DefaultMemberLinkInfo r109 = new DefaultMemberLinkInfo();
        if (r102.isLinkShareInternalRead() == false) goto L9;
    L16:
        int r110 = R.drawable.ud_icon_building_outlined;
    L17:
        r109.setLinkResId(r110);
        r100 = r100 - 1;
        r101.add(r109);
        goto L18
    L9:
        if (r102.isLinkShareInternalEdit() == true) goto L16;
        if (r102.isLinkSharePartnerTenantRead() == true) goto L16;
        if (r102.isLinkSharePartnerTenantEdit() == true) goto L16;
        r110 = R.drawable.ud_icon_language_outlined;
        goto L17
    }

    public final void setDefaultConfig(DefaultConfig r100) {
        this.defaultConfig = r100;
    }

    public final void setPublicPermission(IDocPublicPermission r100) {
        this.publicPermission = r100;
    }

    public final void setUserList(ArrayList<UserInfo> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.userList = r100;
    }
}
