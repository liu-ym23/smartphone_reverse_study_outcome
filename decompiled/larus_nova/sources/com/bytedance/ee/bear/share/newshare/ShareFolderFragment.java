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
import com.bytedance.ee.bear.widgets.universedesign.SpaceSettingGroupLayout;
import com.larus.nova.R;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 52\u00020\u0001:\u00015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\u001a\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010\u001b\u001a\u00020\u000bH\u0016J\b\u0010\u001c\u001a\u00020\u000bH\u0016J\b\u0010\u001d\u001a\u00020\u000bH\u0002J\b\u0010\u001e\u001a\u00020\u000bH\u0002J\b\u0010\u001f\u001a\u00020 H\u0002J\u0010\u0010!\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020#H\u0002J\n\u0010!\u001a\u0004\u0018\u00010$H\u0016J\u0010\u0010%\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010&\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020\u0014H\u0002J\u0010\u0010(\u001a\u00020\u00142\u0006\u0010)\u001a\u00020*H\u0002J\u0010\u0010+\u001a\u00020*2\u0006\u0010'\u001a\u00020\u0014H\u0002J\b\u0010,\u001a\u00020*H\u0016J\b\u0010-\u001a\u00020\u0014H\u0002J\b\u0010.\u001a\u00020\u0014H\u0002J\u0010\u0010/\u001a\u00020\u000b2\u0006\u00100\u001a\u000201H\u0016J\u0010\u00102\u001a\u00020\u00142\u0006\u00100\u001a\u000201H\u0016J\n\u00103\u001a\u0004\u0018\u000104H\u0002R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lcom/bytedance/ee/bear/share/newshare/ShareFolderFragment;", "Lcom/bytedance/ee/bear/share/newshare/BaseShareFragment;", "<init>", "()V", "shareContainerFromXml", "Landroid/widget/LinearLayout;", "getShareContainerFromXml", "()Landroid/widget/LinearLayout;", "setShareContainerFromXml", "(Landroid/widget/LinearLayout;)V", "clearFromXmlViewCache", "", "onDestroyView", "shareFolderInfo", "Lcom/bytedance/ee/bear/middleground/permission/share/info/ShareFolderInfo;", "folderPermSetInfoToViewList", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/middleground_permission_export/model/permissionset/IFolderPermSetInfo;", "Lkotlin/collections/ArrayList;", "shareItemUpdate", "", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "addPermSetInfoView", "onResume", "updatePermission", "fetchFolderPerm", "failToFetchPerm", "getPersonalFolderUserPerm", "Lcom/bytedance/ee/bear/middleground_permission_export/model/folder/ShareFolderUserPermission;", "getShareInfo", "shareFolderPerm", "Lcom/bytedance/ee/bear/middleground_permission_export/model/folder/ShareFolderPermission;", "Lcom/bytedance/ee/bear/share/export/IShareInfo;", "updateFolderPermSetInfo", "updateShareItemState", "update", "hideTopArea", "modelParams", "Lcom/bytedance/ee/bear/share/externalshare/DocumentShareItemModelParams;", "buildModelParams", "buildShareItemModelParams", "linkShareViewEnable", "isDisableShareChannel", "doShareToType", "shareType", "Lcom/bytedance/ee/bear/bizwidget/shareview/ShareType;", "canShareToType", "createPasswordLinkHandler", "Lcom/bytedance/ee/bear/share/externalshare/external/handler/OpenFolderPasswordLinkHandler;", "Companion", "features-share-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ShareFolderFragment extends BaseShareFragment {
    public static final /* synthetic */ int C = 0;
    public final ArrayList<ej5.b> A;
    public boolean B;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public LinearLayout f237173y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public ShareFolderInfo f237174z;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f237175a = null;

        static {
            int[] r100 = new int[ShareType.values().length];
            r100[ShareType.CopyLink.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L21:
            r100[ShareType.PasswordLink.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L31:
            r100[ShareType.More.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L23:
            r100[ShareType.Weibo.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L25:
            r100[ShareType.Wechat.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L19:
            r100[ShareType.WechatMoments.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L27:
            r100[ShareType.QQ.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L10:
            f237175a = r100;
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
        String r100 = oa0().getToken();
    L12:
        Disposable r101 = ((cj5.b) this.f237136r.getValue()).aa().e(r100, oa0().getFolderVersion(), oa0().isShareRoot()).map(new k(this)).observeOn(fo5.d.d()).subscribe(new l(this), new m(this));
        this.f237134p.add(r101);
        return;
    L11:
        r100 = oa0().getSpaceId();
    L14:
        if (oa0().getFolderVersion().isPersonalFolder() == true) goto L16;
        return;
    L16:
        if (oa0().isOwner() == false) goto L18;
        int r102 = 2;
    L19:
        PermissionAction.Companion.getClass();
        PermissionAction r103 = new PermissionAction(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 32767, null);
        r103.setView(1);
        r103.setEdit(1);
        r103.setManage_collaborator(1);
        r103.setManage_meta(1);
        r103.setCreate_sub_node(1);
        r103.setDownload(1);
        r103.setCollect(1);
        r103.setOperate_from_dusbin(1);
        r103.setOperate_entity(1);
        r103.setInvite_full_access(1);
        r103.setInvite_can_edit(1);
        r103.setInvite_can_view(1);
        r103.setBe_moved(1);
        r103.setMove_from(1);
        r103.setMove_to(1);
        ShareFolderInfo r104 = Ua0(new ShareFolderPermission(new ShareFolderUserPermission(r102, r103, oa0().getFolderVersion(), oa0().isShareRoot(), null, 16, null), new DefaultFolderPublicPermission(oa0().isOwner())));
        this.f237174z = r104;
        Intrinsics.checkNotNull(r104);
        Wa0(r104);
        Ga0();
        return;
    L18:
        r102 = 1;
        goto L19
    L21:
        if (oa0().getFolderVersion().isShareFolderV2() == false) goto L23;
        String r105 = oa0().getToken();
    L24:
        Disposable r106 = ((cj5.b) this.f237136r.getValue()).aa().e(r105, oa0().getFolderVersion(), oa0().isShareRoot()).map(new n(this)).observeOn(fo5.d.d()).subscribe(new o(this), new p(this));
        this.f237134p.add(r106);
        return;
    L23:
        r105 = oa0().getSpaceId();
        goto L24
    }

    public final LinearLayout Ta0() {
        View r100 = this.f237173y;
        if (r100 != null) goto L10;
        View r101 = getView();
        if (r101 == null) goto L7;
        r100 = r101.findViewById(R.id.shareContainer);
    L8:
        this.f237173y = (LinearLayout) r100;
        goto L10
    L7:
        r100 = null;
    L10:
        return (LinearLayout) r100;
    }

    @Override // com.bytedance.ee.bear.share.newshare.BaseShareFragment
    public final km5.a ga0() {
        return Ra0(this.B);
    }

    public ShareFolderFragment() {
        this.A = new ArrayList();
    }

    public final com.bytedance.ee.bear.share.externalshare.external.handler.h Sa0() {
        Context r100 = getContext();
        if (r100 != null) goto L7;
        return null;
    L7:
        return new com.bytedance.ee.bear.share.externalshare.external.handler.h(r100, this.f237174z, oa0(), na0(), new ShareFolderFragment$createPasswordLinkHandler$1(this), new ShareFolderFragment$createPasswordLinkHandler$2(this));
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
        this.f237173y = null;
    }

    @Override // com.bytedance.ee.bear.share.newshare.BaseShareFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        ha0();
    }

    @Override // com.bytedance.ee.bear.share.newshare.BaseShareFragment, androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        Pa0();
    }

    @Override // com.bytedance.ee.bear.share.newshare.BaseShareFragment
    public final com.bytedance.ee.bear.share.export.f sa0() {
        return this.f237174z;
    }

    public static final void Qa0(ShareFolderFragment r100) {
        ArrayList<ej5.b> r101 = r100.A;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.size() <= 0) goto L13;
        Iterator<ej5.b> r102 = r100.A.iterator();
    L9:
        if (r102.hasNext() == false) goto L14;
        r102.next().s();
        goto L9
    L14:
        return;
    }

    public final km5.a Ra0(boolean r210) {
        km5.a r110 = new km5.a(oa0().getSource(), oa0().getType(), oa0().getToken(), oa0().isWiki(), false, oa0().getMindnoteViewType(), oa0().getDisabledShareTypes(), oa0().getBadgeShareTypes(), oa0().isAtVC(), oa0().getAdminPerceiveControl(), r210, false, null, null, false, oa0().getShowExportImage(), null, 81920);
        r110.f504082r = r110.f504082r;
        return r110;
    }

    public final ShareFolderInfo Ua0(ShareFolderPermission r110) {
        return new ShareFolderInfo(oa0().getType(), oa0().getUrl(), oa0().getToken(), oa0().getOwnerUid(), oa0().getCreateTime(), oa0().getSpaceId(), oa0().getOwnerTenantId(), oa0().getFolderVersion(), r110, 512);
    }

    public final void Wa0(ShareFolderInfo r110) {
        FolderPermSetInfo r111 = new FolderPermSetInfo(oa0().getType(), oa0().getUrl(), oa0().getToken(), oa0().getDocName(), oa0().getOwnerUid(), oa0().getOwnerName(), r110.f234255d, r110.f234256e, r110.f234258g, r110.f234260i, oa0().getSpaceId(), oa0().getFolderVersion(), oa0().isShareRoot());
        Iterator<ej5.b> r100 = this.A.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        r100.next().setFolderPermSetInfo(r111);
        goto L4
    L6:
        ShareFolderPermission r101 = r110.f234260i;
        ShareFolderUserPermission r102 = r101.f234425a;
        String r103 = r101.f234426b.reportJson();
        Ha0(r102.getReportJson(), r103, false);
    }

    public final void Xa0(boolean r100) {
        this.B = r100;
        km5.a r101 = ga0();
        List<ShareItemModel> r102 = pa0().getProvider().a(r101);     // Catch: Throwable -> L5
    L7:
        ra0().b(r102);
        return;
    L5:
        th = move-exception;
        tt5.a.e("ShareFolderFragment", "updateShareItemState failed", th, false);
        r102 = CollectionsKt.emptyList();
        goto L7
    }

    @Override // com.bytedance.ee.bear.share.newshare.BaseShareFragment, com.bytedance.ee.bear.bizwidget.shareview.b
    public final boolean Yl(ShareType r100) {
        Intrinsics.checkNotNullParameter(r100, "shareType");
        switch(b.f237175a[r100.ordinal()]) {
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
        if (jg5.e.a.f499003a.i() == false) goto L16;
        ShareFolderInfo r101 = this.f237174z;
        if (r101 == null) goto L13;
        boolean r102 = r101.e();
        boolean r103 = r101.isLinkShareAnyoneRead();
        if (r102 == true) goto L13;
        if (r103 == true) goto L13;
        boolean r104 = true;
    L14:
        if (r104 == false) goto L16;
        Toast.showFailureText(getContext(), R.string.LarkCCM_CM_Mobile_ExSharing_TurnOnSwitchToViewOrEdit_Toast);
    L20:
        return false;
    L13:
        r104 = false;
    L16:
        Intrinsics.checkNotNullParameter(r100, "shareType");
        return true;
    L17:
        com.bytedance.ee.bear.share.externalshare.external.handler.h r105 = Sa0();
        if (r105 == null) goto L20;
        return r105.a();
    L21:
        Intrinsics.checkNotNullParameter(r100, "shareType");
        return true;
    }

    @Override // com.bytedance.ee.bear.share.newshare.BaseShareFragment, com.bytedance.ee.bear.bizwidget.shareview.b
    public final void s10(ShareType r100) {
        Intrinsics.checkNotNullParameter(r100, "shareType");
        int r101 = b.f237175a[r100.ordinal()];
        boolean r102 = true;
        if (r101 != 1) goto L5;
        ya0();
        ShareFolderInfo r103 = this.f237174z;
        if (r103 == null) goto L18;
        ShareFolderPermission r104 = r103.f234260i;
        if (r104 == null) goto L18;
        IFolderPublicPermission r105 = r104.f234426b;
    L19:
        if (r105 != null) goto L21;
    L23:
        r102 = false;
    L24:
        if (r105 == null) goto L27;
        String r106 = r105.linkPassword();
        if (r106 == null) goto L27;
    L28:
        za0(r102, r106);
        return;
    L27:
        r106 = "";
        goto L28
    L21:
        if (r105.hasLinkPassword() != true) goto L23;
    L18:
        r105 = null;
        goto L19
    L5:
        if (r101 == 2) goto L7;
        super.s10(r100);
        return;
    L7:
        tt5.a.h("BaseShareFragment", "onPasswordLink()...");
        this.f237141w = ShareType.PasswordLink;
        com.bytedance.ee.bear.share.externalshare.external.handler.h r107 = Sa0();
        if (r107 == null) goto L31;
        ShareFolderInfo r108 = r107.f237094b;
        if (r108 == null) goto L33;
        r107.b(r108);
        return;
    L33:
        return;
    }

    @Override // com.bytedance.ee.bear.share.newshare.BaseShareFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r110, Bundle r111) {
        Intrinsics.checkNotNullParameter(r110, "view");
        super.onViewCreated(r110, r111);
        ViewGroup.LayoutParams r112 = new ViewGroup.LayoutParams(-1, -2);
        km5.a r100 = Ra0(false);
        boolean r101 = pa0().getProvider().b(r100);     // Catch: Throwable -> L5
    L7:
        if (r101 == true) goto L26;
        View r102 = pa0().I7(getActivity(), oa0().getType(), oa0().getToken(), oa0().getSpaceId(), oa0().getModule(), oa0().getFolderVersion(), oa0().isShareRoot(), Va0(), this);
        Ta0().addView(r102, r112);
        Intrinsics.checkNotNull(r102);
        if ((r102 instanceof ej5.b) == false) goto L11;
        this.A.add(r102);
    L11:
        SpaceSettingGroupLayout r113 = va0();
        if (Va0() == false) goto L17;
        View r103 = pa0().T8(getContext(), oa0().isShareRoot(), oa0().getModule());
        Ta0().addView(r113);
        r113.addView(r103);
        Intrinsics.checkNotNull(r103);
        if ((r103 instanceof ej5.b) == false) goto L17;
        this.A.add(r103);
    L17:
        if (oa0().getFolderVersion().isShareFolderV2() == false) goto L26;
        View r104 = pa0().g2(getContext(), oa0());
        if (Va0() == true) goto L21;
        Ta0().addView(r113);
    L21:
        if (r104 == null) goto L23;
        r104.setVisibility(8);
    L23:
        r113.addView(r104);
        Intrinsics.checkNotNull(r104);
        if ((r104 instanceof ej5.b) == false) goto L26;
        this.A.add(r104);
    L26:
        Xa0(false);
        return;
    L5:
        th = move-exception;
        tt5.a.e("ShareFolderFragment", "hideTopArea failed", th, false);
        r101 = false;
        goto L7
    }
}
