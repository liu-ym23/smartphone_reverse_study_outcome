package com.bytedance.ee.bear.more.itemv2;

import android.app.Activity;
import android.text.TextUtils;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.BizDomain;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionResponse;
import com.bytedance.ee.bear.more.i;
import com.bytedance.ee.bear.more.moreprotocol.BaseMoreItem;
import com.bytedance.ee.bear.more.moreprotocol.CommonMoreItemId;
import com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem;
import com.bytedance.ee.bear.more.moreprotocol.MoreUiAction;
import com.bytedance.ee.bear.more.rename.c;
import com.bytedance.ee.bear.more.rename.d;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEditText;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.larus.nova.R;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import oj5.f;
import rj5.a0;
import rj5.x;
import rj5.y;
import rj5.z;
import sbb.e;

/* JADX INFO: loaded from: classes18.dex */
public class RenameItemV2 extends BaseMoreItem implements ITextMoreItem {
    private static final String TAG = "RenameItemV2";
    private final Activity mActivity;

    public static class a implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<RenameItemV2> f234585a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f234586b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f234587c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f234588d;

        public final void a() {
            tt5.a.d(RenameItemV2.TAG, "rename sheet fail");
            if (this.f234585a.get() == null) goto L6;
            RenameItemV2 r100 = this.f234585a.get();
            Toast.showFailureText(RenameItemV2.access$000(r100), RenameItemV2.access$000(r100).getString(R.string.Doc_Facade_RenameFailed), 0);
            return;
        }

        public a(RenameItemV2 r100, String r101, String r102, String r103) {
            this.f234585a = new WeakReference(r100);
            this.f234586b = r101;
            this.f234587c = r103;
            this.f234588d = r102;
        }
    }

    public static /* synthetic */ void a(RenameItemV2 r100, String r101) {
        r100.lambda$onClick$2(r101);
    }

    public static /* synthetic */ boolean b(RenameItemV2 r100, int r101) {
        return r100.lambda$handleCopyPermission$3(r101);
    }

    public static /* synthetic */ Boolean c(boolean r100, boolean r101, Boolean r102) {
        return lambda$onClick$0(r100, r101, r102);
    }

    public static /* synthetic */ void d(RenameItemV2 r100, oj5.c r101, String r102) {
        r100.lambda$onClick$1(r101, r102);
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem
    public int getIcon() {
        return R.drawable.ud_icon_ccm_rename_outlined;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem
    public int getIconTint() {
        return R.color.icon_n1;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem
    public final /* synthetic */ MoreUiAction getMoreAction() {
        return ITextMoreItem.CC.$default$getMoreAction(this);
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem
    public String getStateTips() {
        return "";
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem
    public boolean needShowBadge() {
        return false;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem
    public void onDisableClick() {
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IBaseMoreItem
    public String getId() {
        return CommonMoreItemId.RENAME.getId();
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem
    public void onClick() {
        final oj5.c r100 = getMoreInfo();
        tt5.a.b(TAG, "onItemClick: docInfoData = " + r100);
        com.bytedance.ee.bear.more.c.b(r100, "rename");
        if (r100 == null) goto L8;
        final boolean r101 = r100.y();
        final boolean r102 = ((fu5.a) org.koin.java.a.a(fu5.a.class)).o();
        getHost().a();
        gp5.a r103 = new gp5.a(this.mActivity).title(R.string.Doc_More_RenameSheetTitle);
        r103.f(R.string.Doc_More_RenameSheetPlaceholder);
        r103.e(r100.getTitle());
        r103.f482032t = new x(r102, r101);
        r103.a(R.string.Doc_Facade_Confirm);
        gp5.a.InterfaceC6049a r104 = new y(this, r100);
        Intrinsics.checkNotNullParameter(r104, "value");
        r103.f482030r = r104;
        r103.c();
        gp5.a.InterfaceC6049a r105 = new z(this);
        Intrinsics.checkNotNullParameter(r105, "value");
        r103.f482031s = r105;
        UDDialog r106 = r103.show();
        handleCopyPermission(r103);
        ((zo5.b) org.koin.java.a.a(zo5.b.class)).j(r100.getToken(), r100.getType(), r106);
        if ((r100 instanceof oj5.a) == false) goto L9;
        ((com.bytedance.ee.bear.more.b) org.koin.java.a.a(com.bytedance.ee.bear.more.b.class)).c(new i(getHost().getHostFragment().getArguments(), r100.getToken(), r100.getType(), r100.isShareFolder(), r100.b(), "rename", "ccm_space_drive_rename_view", "", "", r100 instanceof f, ((oj5.a) r100).f523540k, r100.H(), r100.isOwner(), r100.L()));
        return;
    L9:
        return;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem
    public String getTitle() {
        return getString(R.string.Doc_More_RenameSheetTitle);
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem
    public String getUnableTips() {
        oj5.c r100 = getMoreInfo();
        if (r100 != null) goto L5;
    L7:
        boolean r101 = false;
    L8:
        if (r101 == false) goto L10;
        Activity r102 = this.mActivity;
        int r103 = R.string.Doc_Facade_MoreRenameTypeBitable;
    L11:
        String r104 = r102.getString(r103);
        return xo5.a.c(this.mActivity, R.string.Doc_Facade_MoreRenameTips, "type", r104);
    L10:
        r102 = this.mActivity;
        r103 = R.string.Doc_Facade_MoreRenameTypeSheet;
        goto L11
    L5:
        if (r100.getType() != e.f541298i.f541317b) goto L7;
        r101 = true;
        goto L8
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem
    public boolean isEnable() {
        if (isItemDisabledByJSMsg() == false) goto L6;
        return false;
    L6:
        if (isVisible() == true) goto L8;
        return false;
    L8:
        if (canEdit(getMoreInfo()) == false) goto L12;
        return true;
    L12:
        return false;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IBaseMoreItem
    public boolean isVisible() {
        boolean r100 = false;
        if (isItemInvisibleByJSMsg() == false) goto L6;
        return false;
    L6:
        if (isItemInvisibleByBenefit() == false) goto L8;
        return false;
    L8:
        oj5.c r101 = getMoreInfo();
        if (r101 != null) goto L11;
    L19:
        boolean r102 = false;
    L21:
        if (com.bytedance.ee.bear.more.protocol3.panel.y.a() == true) goto L24;
        com.bytedance.ee.bear.more.protocol3.panel.y.c(TAG, getId());
        return r102;
    L24:
        if (r102 == true) goto L26;
    L28:
        String r103 = getId();
        if (r100 == false) goto L31;
        String r104 = "";
    L32:
        boolean r105 = r100;
        boolean r106 = r100;
        com.bytedance.ee.bear.more.protocol3.panel.y.b(TAG, r103, r105, r106, r104, "rename_edit_permission,baselineVisible=" + r102);
        return r100;
    L31:
        r104 = "edit_permission";
        goto L32
    L26:
        if (canEdit(r101) == false) goto L28;
        r100 = true;
        goto L28
    L11:
        if (r101.getType() != e.f541297h.f541317b) goto L13;
    L18:
        r102 = true;
        goto L21
    L13:
        if (r101.getType() == e.f541298i.f541317b) goto L18;
        if (r101.getType() != e.f541302m.f541317b) goto L19;
        if (com.bytedance.ee.bear.appsetting.c.a.f206237a.g("ccm.mobile.slides_enabled") == false) goto L19;
        goto L18
    }

    public RenameItemV2(Activity r100) {
        this.mActivity = r100;
    }

    public static /* synthetic */ Activity access$000(RenameItemV2 r100) {
        return r100.mActivity;
    }

    private boolean canEdit(oj5.c r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if ((r100 instanceof oj5.b) == false) goto L8;
        return false;
    L8:
        ((cj5.b) org.koin.java.a.a(cj5.b.class)).getConfig();
        if (jg5.e.a.f499003a.g() == false) goto L13;
        return ((com.bytedance.ee.bear.more.b) org.koin.java.a.a(com.bytedance.ee.bear.more.b.class)).t(r100.getToken(), r100, BizDomain.FileBizDomainCCM, "EDIT", r100.c().f234419a).getAllow();
    L13:
        return r100.n();
    }

    private void handleCopyPermission(gp5.a r100) {
        SpaceEditText r101 = r100.g();
        if (r101 != null) goto L5;
        return;
    L5:
        if (((fu5.a) org.koin.java.a.a(fu5.a.class)).b() == true) goto L10;
        r101.setInterceptor(new a0(this));
        return;
    }

    private boolean lambda$handleCopyPermission$3(int r100) {
        oj5.c r101 = getMoreInfo();
        if (r101 != null) goto L5;
        return false;
    L5:
        if (this.mActivity != null) goto L8;
        return false;
    L8:
        if (r100 != 16908321) goto L10;
    L11:
        ((cj5.b) org.koin.java.a.a(cj5.b.class)).getConfig();
        if (jg5.e.a.f499003a.g() == false) goto L23;
        PermissionResponse r102 = ((com.bytedance.ee.bear.more.b) org.koin.java.a.a(com.bytedance.ee.bear.more.b.class)).t(r101.getToken(), r101, BizDomain.FileBizDomainCCM, "CONTENT_COPY", r101.c().f234419a);
        r102.getCallback().a(this.mActivity, r102);
        if (r102.getAllow() == true) goto L19;
        if (((ph5.c) org.koin.java.a.a(ph5.c.class)).d(r102) == true) goto L19;
        Toast.showFailureText(this.mActivity, R.string.Doc_Comment_CopyFailed);
    L19:
        return !r102.getAllow();
    L23:
        return false;
    L10:
        if (r100 == 16908320) goto L11;
        return false;
    }

    private /* synthetic */ void lambda$onClick$2(String r100) {
        reportMoreItemClick("cancel");
    }

    private void reportMoreItemClick(String r110) {
        oj5.c r100 = getMoreInfo();
        if ((r100 instanceof oj5.a) == false) goto L6;
        ((com.bytedance.ee.bear.more.b) org.koin.java.a.a(com.bytedance.ee.bear.more.b.class)).c(new i(getHost().getHostFragment().getArguments(), r100.getToken(), r100.getType(), r100.isShareFolder(), r100.b(), r110, "ccm_space_drive_rename_view", "", "", r100 instanceof f, ((oj5.a) r100).f523540k, r100.H(), r100.isOwner(), r100.L()));
        return;
    }

    private /* synthetic */ void lambda$onClick$1(oj5.c r100, String r101) {
        if (TextUtils.equals(r100.getTitle(), r101) == false) goto L5;
        tt5.a.h(TAG, "onClick Positive: title doesn't changed, so dismiss dialog");
    L6:
        reportMoreItemClick("confirm");
        return;
    L5:
        renameTitle(r100, r101);
        goto L6
    }

    private void renameTitle(oj5.c r100, String r101) {
        if ((r100 instanceof f) == false) goto L5;
        String r102 = ((f) r100).O;
    L7:
        if (r100.getToken() == null) goto L18;
        if (r101 == null) goto L19;
        NetService r103 = (NetService) org.koin.java.a.a(NetService.class);
        String r104 = r100.getToken();
        int r105 = r100.getType();
        final a r106 = new a(this, r100.getToken(), r102, r101);
        NetService.d r107 = r103.Vc(new d());
        if (3 != r105) goto L13;
        String r108 = "/api/sheet/update_meta/";
    L16:
        NetService.e r109 = new NetService.f(r108);
        r109.f216906c = 1;
        HashMap r110 = new HashMap();
        r110.put("token", r104);
        r110.put("title", r101);
        r110.put("type", String.valueOf(r105));
        r109.d(r110);
        r107.a(r109).subscribe(new com.bytedance.ee.bear.more.rename.a(r106), new com.bytedance.ee.bear.more.rename.b(r106));
        return;
    L13:
        if (30 != r105) goto L15;
        r108 = "/api/meta/update/";
        goto L16
    L15:
        r108 = "/api/bitable/update_meta/";
        goto L16
    L19:
        return;
    L18:
        return;
    L5:
        r102 = "";
        goto L7
    }

    private static /* synthetic */ Boolean lambda$onClick$0(boolean r100, boolean r101, Boolean r102) {
        if (r100 == false) goto L11;
        if (r101 == false) goto L5;
    L7:
        boolean r103 = false;
    L9:
        return Boolean.valueOf(r103);
    L5:
        if (r102.booleanValue() == false) goto L7;
        r103 = true;
        goto L9
    L11:
        return Boolean.TRUE;
    }
}
