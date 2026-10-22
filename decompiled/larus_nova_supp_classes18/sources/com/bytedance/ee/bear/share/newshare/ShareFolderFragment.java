package com.bytedance.ee.bear.share.newshare;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.bytedance.ee.bear.bizwidget.shareview.ShareItemModel;
import com.bytedance.ee.bear.bizwidget.shareview.ShareType;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.middleground.permission.share.info.ShareFolderInfo;
import com.bytedance.ee.bear.middleground_permission_export.model.folder.DefaultFolderPublicPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.folder.PermissionAction;
import com.bytedance.ee.bear.middleground_permission_export.model.folder.ShareFolderPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.folder.ShareFolderUserPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.permissionset.FolderPermSetInfo;
import com.larksuite.component.ignition.widget.setting_group.SettingGroupLayout;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 52\u00020\u0001:\u00015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\u001a\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010\u001b\u001a\u00020\u000bH\u0016J\b\u0010\u001c\u001a\u00020\u000bH\u0016J\b\u0010\u001d\u001a\u00020\u000bH\u0002J\b\u0010\u001e\u001a\u00020\u000bH\u0002J\b\u0010\u001f\u001a\u00020 H\u0002J\u0010\u0010!\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020#H\u0002J\n\u0010!\u001a\u0004\u0018\u00010$H\u0016J\u0010\u0010%\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010&\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020\u0014H\u0002J\u0010\u0010(\u001a\u00020\u00142\u0006\u0010)\u001a\u00020*H\u0002J\u0010\u0010+\u001a\u00020*2\u0006\u0010'\u001a\u00020\u0014H\u0002J\b\u0010,\u001a\u00020*H\u0016J\b\u0010-\u001a\u00020\u0014H\u0002J\b\u0010.\u001a\u00020\u0014H\u0002J\u0010\u0010/\u001a\u00020\u000b2\u0006\u00100\u001a\u000201H\u0016J\u0010\u00102\u001a\u00020\u00142\u0006\u00100\u001a\u000201H\u0016J\n\u00103\u001a\u0004\u0018\u000104H\u0002R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lcom/bytedance/ee/bear/share/newshare/ShareFolderFragment;", "Lcom/bytedance/ee/bear/share/newshare/BaseShareFragment;", "<init>", "()V", "shareContainerFromXml", "Landroid/widget/LinearLayout;", "getShareContainerFromXml", "()Landroid/widget/LinearLayout;", "setShareContainerFromXml", "(Landroid/widget/LinearLayout;)V", "clearFromXmlViewCache", "", "onDestroyView", "shareFolderInfo", "Lcom/bytedance/ee/bear/middleground/permission/share/info/ShareFolderInfo;", "folderPermSetInfoToViewList", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/middleground_permission_export/model/permissionset/IFolderPermSetInfo;", "Lkotlin/collections/ArrayList;", "shareItemUpdate", "", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "addPermSetInfoView", "onResume", "updatePermission", "fetchFolderPerm", "failToFetchPerm", "getPersonalFolderUserPerm", "Lcom/bytedance/ee/bear/middleground_permission_export/model/folder/ShareFolderUserPermission;", "getShareInfo", "shareFolderPerm", "Lcom/bytedance/ee/bear/middleground_permission_export/model/folder/ShareFolderPermission;", "Lcom/bytedance/ee/bear/share/export/IShareInfo;", "updateFolderPermSetInfo", "updateShareItemState", "update", "hideTopArea", "modelParams", "Lcom/bytedance/ee/bear/share/externalshare/DocumentShareItemModelParams;", "buildModelParams", "buildShareItemModelParams", "linkShareViewEnable", "isDisableShareChannel", "doShareToType", "shareType", "Lcom/bytedance/ee/bear/bizwidget/shareview/ShareType;", "canShareToType", "createPasswordLinkHandler", "Lcom/bytedance/ee/bear/share/externalshare/external/handler/OpenFolderPasswordLinkHandler;", "Companion", "features-share-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ShareFolderFragment extends BaseShareFragment {
    public static final /* synthetic */ int C = 0;
    public final ArrayList<ej5.b> A;
    public boolean B;
    public LinearLayout y;
    public ShareFolderInfo z;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ShareType.values().length];
            r0[ShareType.CopyLink.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L21:
            r0[ShareType.PasswordLink.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L31:
            r0[ShareType.More.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L23:
            r0[ShareType.Weibo.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L25:
            r0[ShareType.Wechat.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L19:
            r0[ShareType.WechatMoments.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L27:
            r0[ShareType.QQ.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L10:
            a = r0;
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.share.newshare.BaseShareFragment
    public final void Pa0() {
        if (oa0().getFolderVersion().isFolderV1() == false) goto L21;
        if (oa0().getFolderVersion().isOldShareFolder() == false) goto L14;
        if (oa0().getFolderVersion().isPersonalFolder() == true) goto L14;
        if (oa0().getFolderVersion().isShareFolderV2() == false) goto L11;
        String r1 = oa0().getToken();
    L12:
        Disposable r2 = ((cj5.b) this.r.getValue()).aa().e(r1, oa0().getFolderVersion(), oa0().isShareRoot()).map(new k(this)).observeOn(fo5.d.d()).subscribe(new l(this), new m(this));
        this.p.add(r2);
        return;
    L11:
        r1 = oa0().getSpaceId();
    L14:
        if (oa0().getFolderVersion().isPersonalFolder() == true) goto L16;
        return;
    L16:
        if (oa0().isOwner() == false) goto L18;
        int r5 = 2;
    L19:
        PermissionAction.Companion.getClass();
        PermissionAction r3 = new PermissionAction(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 32767, null);
        r3.setView(1);
        r3.setEdit(1);
        r3.setManage_collaborator(1);
        r3.setManage_meta(1);
        r3.setCreate_sub_node(1);
        r3.setDownload(1);
        r3.setCollect(1);
        r3.setOperate_from_dusbin(1);
        r3.setOperate_entity(1);
        r3.setInvite_full_access(1);
        r3.setInvite_can_edit(1);
        r3.setInvite_can_view(1);
        r3.setBe_moved(1);
        r3.setMove_from(1);
        r3.setMove_to(1);
        ShareFolderInfo r4 = Ua0(new ShareFolderPermission(new ShareFolderUserPermission(r5, r3, oa0().getFolderVersion(), oa0().isShareRoot(), null, 16, null), new DefaultFolderPublicPermission(oa0().isOwner())));
        this.z = r4;
        Intrinsics.checkNotNull(r4);
        Wa0(r4);
        Ga0();
        return;
    L18:
        r5 = 1;
        goto L19
    L21:
        if (oa0().getFolderVersion().isShareFolderV2() == false) goto L23;
        String r6 = oa0().getToken();
    L24:
        Disposable r7 = ((cj5.b) this.r.getValue()).aa().e(r6, oa0().getFolderVersion(), oa0().isShareRoot()).map(new n(this)).observeOn(fo5.d.d()).subscribe(new o(this), new p(this));
        this.p.add(r7);
        return;
    L23:
        r6 = oa0().getSpaceId();
        goto L24
    }

    public final LinearLayout Ta0() {
        View r0 = this.y;
        if (r0 != null) goto L10;
        View r1 = getView();
        if (r1 == null) goto L7;
        r0 = r1.findViewById(2131386050);
    L8:
        this.y = (LinearLayout) r0;
        goto L10
    L7:
        r0 = null;
    L10:
        return (LinearLayout) r0;
    }

    @Override // com.bytedance.ee.bear.share.newshare.BaseShareFragment
    public final km5.a ga0() {
        return Ra0(this.B);
    }

    public ShareFolderFragment() {
        this.A = new ArrayList();
    }

    public final com.bytedance.ee.bear.share.externalshare.external.handler.h Sa0() {
        Context r1 = getContext();
        if (r1 != null) goto L7;
        return null;
    L7:
        return new com.bytedance.ee.bear.share.externalshare.external.handler.h(r1, this.z, oa0(), na0(), new ShareFolderFragment$createPasswordLinkHandler$1(this), new ShareFolderFragment$createPasswordLinkHandler$2(this));
    }

    public final boolean Va0() {
        if (oa0().getFolderVersion().isShareFolderV2() == false) goto L6;
        return true;
    L6:
        if (oa0().getFolderVersion().isPersonalFolder() == false) goto L11;
        return false;
    L11:
        return true;
    }

    @Override // com.bytedance.ee.bear.share.newshare.BaseShareFragment
    public final void ha0() {
        super.ha0();
        this.y = null;
    }

    @Override // com.bytedance.ee.bear.share.newshare.BaseShareFragment
    public final void onDestroyView() {
        super.onDestroyView();
        ha0();
    }

    @Override // com.bytedance.ee.bear.share.newshare.BaseShareFragment
    public final void onResume() {
        super.onResume();
        Pa0();
    }

    @Override // com.bytedance.ee.bear.share.newshare.BaseShareFragment
    public final com.bytedance.ee.bear.share.export.f sa0() {
        return this.z;
    }

    public static final void Qa0(ShareFolderFragment r1) {
        ArrayList<ej5.b> r0 = r1.A;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.size() <= 0) goto L13;
        Iterator<ej5.b> r2 = r1.A.iterator();
    L9:
        if (r2.hasNext() == false) goto L14;
        r2.next().s();
        goto L9
    L14:
        return;
    }

    public final km5.a Ra0(boolean r21) {
        km5.a r15 = new km5.a(oa0().getSource(), oa0().getType(), oa0().getToken(), oa0().isWiki(), false, oa0().getMindnoteViewType(), oa0().getDisabledShareTypes(), oa0().getBadgeShareTypes(), oa0().isAtVC(), oa0().getAdminPerceiveControl(), r21, false, null, null, false, oa0().getShowExportImage(), null, 81920);
        r15.r = r15.r;
        return r15;
    }

    public final ShareFolderInfo Ua0(ShareFolderPermission r13) {
        return new ShareFolderInfo(oa0().getType(), oa0().getUrl(), oa0().getToken(), oa0().getOwnerUid(), oa0().getCreateTime(), oa0().getSpaceId(), oa0().getOwnerTenantId(), oa0().getFolderVersion(), r13, 512);
    }

    public final void Wa0(ShareFolderInfo r18) {
        FolderPermSetInfo r15 = new FolderPermSetInfo(oa0().getType(), oa0().getUrl(), oa0().getToken(), oa0().getDocName(), oa0().getOwnerUid(), oa0().getOwnerName(), r18.d, r18.e, r18.g, r18.i, oa0().getSpaceId(), oa0().getFolderVersion(), oa0().isShareRoot());
        Iterator<ej5.b> r2 = this.A.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        r2.next().setFolderPermSetInfo(r15);
        goto L4
    L6:
        ShareFolderPermission r1 = r18.i;
        ShareFolderUserPermission r3 = r1.a;
        String r4 = r1.b.reportJson();
        Ha0(r3.getReportJson(), r4, false);
    }

    public final void Xa0(boolean r4) {
        this.B = r4;
        km5.a r5 = ga0();
        List<ShareItemModel> r6 = pa0().getProvider().a(r5);     // Catch: Throwable -> L5
    L7:
        ra0().b(r6);
        return;
    L5:
        th = move-exception;
        tt5.a.e("ShareFolderFragment", "updateShareItemState failed", th, false);
        r6 = CollectionsKt.emptyList();
        goto L7
    }

    @Override // com.bytedance.ee.bear.share.newshare.BaseShareFragment
    public final boolean Yl(ShareType r7) {
        Intrinsics.checkNotNullParameter(r7, "shareType");
        switch(b.a[r7.ordinal()]) {
            case 2: goto L17;
            case 3: goto L5;
            case 4: goto L5;
            case 5: goto L5;
            case 6: goto L5;
            case 7: goto L5;
            default: goto L21;
        };
    L5:
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        if (jg5.e.a.a.i() == false) goto L16;
        ShareFolderInfo r1 = this.z;
        if (r1 == null) goto L13;
        boolean r4 = r1.e();
        boolean r2 = r1.isLinkShareAnyoneRead();
        if (r4 == true) goto L13;
        if (r2 == true) goto L13;
        boolean r3 = true;
    L14:
        if (r3 == false) goto L16;
        Toast.showFailureText(getContext(), 2131888785);
    L20:
        return false;
    L13:
        r3 = false;
    L16:
        Intrinsics.checkNotNullParameter(r7, "shareType");
        return true;
    L17:
        com.bytedance.ee.bear.share.externalshare.external.handler.h r8 = Sa0();
        if (r8 == null) goto L20;
        return r8.a();
    L21:
        Intrinsics.checkNotNullParameter(r7, "shareType");
        return true;
    }

    @Override // com.bytedance.ee.bear.share.newshare.BaseShareFragment
    public final void s10(ShareType r3) {
        Intrinsics.checkNotNullParameter(r3, "shareType");
        int r0 = b.a[r3.ordinal()];
        boolean r1 = true;
        if (r0 != 1) goto L5;
        ya0();
        ShareFolderInfo r4 = this.z;
        if (r4 == null) goto L18;
        ShareFolderPermission r5 = r4.i;
        if (r5 == null) goto L18;
        IFolderPublicPermission r6 = r5.b;
    L19:
        if (r6 != null) goto L21;
    L23:
        r1 = false;
    L24:
        if (r6 == null) goto L27;
        String r7 = r6.linkPassword();
        if (r7 == null) goto L27;
    L28:
        za0(r1, r7);
        return;
    L27:
        r7 = "";
        goto L28
    L21:
        if (r6.hasLinkPassword() != true) goto L23;
    L18:
        r6 = null;
        goto L19
    L5:
        if (r0 == 2) goto L7;
        super.s10(r3);
        return;
    L7:
        tt5.a.h("BaseShareFragment", "onPasswordLink()...");
        this.w = ShareType.PasswordLink;
        com.bytedance.ee.bear.share.externalshare.external.handler.h r8 = Sa0();
        if (r8 == null) goto L31;
        ShareFolderInfo r2 = r8.b;
        if (r2 == null) goto L33;
        r8.b(r2);
        return;
    L33:
        return;
    }

    @Override // com.bytedance.ee.bear.share.newshare.BaseShareFragment
    public final void onViewCreated(View r12, Bundle r13) {
        Intrinsics.checkNotNullParameter(r12, "view");
        super.onViewCreated(r12, r13);
        ViewGroup.LayoutParams r14 = new ViewGroup.LayoutParams(-1, -2);
        km5.a r0 = Ra0(false);
        boolean r1 = pa0().getProvider().b(r0);     // Catch: Throwable -> L5
    L7:
        if (r1 == true) goto L26;
        View r2 = pa0().I7(getActivity(), oa0().getType(), oa0().getToken(), oa0().getSpaceId(), oa0().getModule(), oa0().getFolderVersion(), oa0().isShareRoot(), Va0(), this);
        Ta0().addView(r2, r14);
        Intrinsics.checkNotNull(r2);
        if ((r2 instanceof ej5.b) == false) goto L11;
        this.A.add(r2);
    L11:
        SettingGroupLayout r15 = va0();
        if (Va0() == false) goto L17;
        View r3 = pa0().T8(getContext(), oa0().isShareRoot(), oa0().getModule());
        Ta0().addView(r15);
        r15.addView(r3);
        Intrinsics.checkNotNull(r3);
        if ((r3 instanceof ej5.b) == false) goto L17;
        this.A.add(r3);
    L17:
        if (oa0().getFolderVersion().isShareFolderV2() == false) goto L26;
        View r4 = pa0().g2(getContext(), oa0());
        if (Va0() == true) goto L21;
        Ta0().addView(r15);
    L21:
        if (r4 == null) goto L23;
        r4.setVisibility(8);
    L23:
        r15.addView(r4);
        Intrinsics.checkNotNull(r4);
        if ((r4 instanceof ej5.b) == false) goto L26;
        this.A.add(r4);
    L26:
        Xa0(false);
        return;
    L5:
        th = move-exception;
        tt5.a.e("ShareFolderFragment", "hideTopArea failed", th, false);
        r1 = false;
        goto L7
    }
}
