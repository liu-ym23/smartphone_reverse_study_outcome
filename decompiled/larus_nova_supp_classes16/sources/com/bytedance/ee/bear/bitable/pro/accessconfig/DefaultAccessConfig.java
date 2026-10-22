package com.bytedance.ee.bear.bitable.pro.accessconfig;

import com.bytedance.ee.bear.bitable.pro.DefaultConfig;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.bytedance.ee.util.io.NonProguard;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
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
        int r0 = com.bytedance.ee.bear.bitable.pro.e.a;
        if (com.bytedance.ee.bear.bitable.core.usercomponent.b.d("ccm.bitable.mobile_advance_sysrole_update_tips.enable") == false) goto L11;
        DefaultConfig r1 = this.defaultConfig;
        if (r1 == null) goto L7;
        boolean r2 = r1.getEnableSysRole();
    L8:
        if (r2 == false) goto L12;
        return true;
    L12:
        return false;
    L7:
        r2 = false;
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

    public final ArrayList<MultiItemEntity> getMemberList(int r6) {
        ArrayList<MultiItemEntity> r0 = new ArrayList();
        IDocPublicPermission r1 = this.publicPermission;
        if (r1 != null) goto L5;
    L18:
        int r2 = this.userList.size();
        int r3 = (r2 - r6) + 1;
        if (r2 <= r6) goto L21;
        r2 = r6 - 1;
    L21:
        int r7 = this.userList.size();
        int r4 = 0;
    L22:
        if (r4 >= r7) goto L27;
        MultiItemEntity r5 = (UserInfo) ListProtector.get(this.userList, r4);
        if (r4 >= r2) goto L26;
        r0.add(r5);
        r4 = r4 + 1;
        goto L22
    L26:
        DefaultMemberExtraInfo r8 = new DefaultMemberExtraInfo();
        r8.setExtraMemberNumber(r3);
        r0.add(r8);
    L27:
        return r0;
    L5:
        if (r1.isLinkShareClose() == true) goto L18;
        DefaultMemberLinkInfo r9 = new DefaultMemberLinkInfo();
        if (r1.isLinkShareInternalRead() == false) goto L9;
    L16:
        int r10 = 2131253887;
    L17:
        r9.setLinkResId(r10);
        r6 = r6 - 1;
        r0.add(r9);
        goto L18
    L9:
        if (r1.isLinkShareInternalEdit() == true) goto L16;
        if (r1.isLinkSharePartnerTenantRead() == true) goto L16;
        if (r1.isLinkSharePartnerTenantEdit() == true) goto L16;
        r10 = 2131254976;
        goto L17
    }

    public final void setDefaultConfig(DefaultConfig r1) {
        this.defaultConfig = r1;
    }

    public final void setPublicPermission(IDocPublicPermission r1) {
        this.publicPermission = r1;
    }

    public final void setUserList(ArrayList<UserInfo> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.userList = r2;
    }
}
