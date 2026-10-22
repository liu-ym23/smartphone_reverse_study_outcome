package com.bytedance.ee.bear.more.itemv2;

import android.app.Activity;
import android.app.Dialog;
import android.text.TextUtils;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.middleground.feed.export.bean.DocFeed$Value$Result;
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
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import oj5.f;
import rj5.a0;
import rj5.x;
import rj5.y;
import rj5.z;
import sbb.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class RenameItemV2 extends BaseMoreItem implements ITextMoreItem {
    private static final String TAG = "RenameItemV2";
    private final Activity mActivity;

    public static class a implements c {
        public final WeakReference<RenameItemV2> a;
        public final String b;
        public final String c;
        public final String d;

        public final void a() {
            tt5.a.d(RenameItemV2.TAG, "rename sheet fail");
            if (this.a.get() == null) goto L6;
            RenameItemV2 r0 = this.a.get();
            Toast.showFailureText(RenameItemV2.access$000(r0), RenameItemV2.access$000(r0).getString(2131887815), 0);
            return;
        }

        public a(RenameItemV2 r2, String r3, String r4, String r5) {
            this.a = new WeakReference(r2);
            this.b = r3;
            this.c = r5;
            this.d = r4;
        }
    }

    public static /* synthetic */ void a(RenameItemV2 r0, String r1) {
        r0.lambda$onClick$2(r1);
    }

    public static /* synthetic */ boolean b(RenameItemV2 r0, int r1) {
        return r0.lambda$handleCopyPermission$3(r1);
    }

    public static /* synthetic */ Boolean c(boolean r0, boolean r1, Boolean r2) {
        return lambda$onClick$0(r0, r1, r2);
    }

    public static /* synthetic */ void d(RenameItemV2 r0, oj5.c r1, String r2) {
        r0.lambda$onClick$1(r1, r2);
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem
    public int getIcon() {
        return 2131254065;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem
    public int getIconTint() {
        return 2131102418;
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
        final oj5.c r1 = getMoreInfo();
        tt5.a.b(TAG, "onItemClick: docInfoData = " + r1);
        com.bytedance.ee.bear.more.c.b(r1, "rename");
        if (r1 == null) goto L8;
        final boolean r2 = r1.y();
        final boolean r3 = ((fu5.a) org.koin.java.a.a(fu5.a.class)).o();
        getHost().a();
        gp5.a r4 = (gp5.a) new gp5.a(this.mActivity).title(2131888030);
        r4.f(2131888029);
        r4.e(r1.getTitle());
        r4.t = new x(r3, r2);
        r4.a(2131887719);
        gp5.a.InterfaceC0236a r5 = new y(this, r1);
        Intrinsics.checkNotNullParameter(r5, "value");
        r4.r = r5;
        r4.c();
        gp5.a.InterfaceC0236a r6 = new z(this);
        Intrinsics.checkNotNullParameter(r6, "value");
        r4.s = r6;
        Dialog r7 = r4.show();
        handleCopyPermission(r4);
        ((zo5.b) org.koin.java.a.a(zo5.b.class)).j(r1.getToken(), r1.getType(), r7);
        if ((r1 instanceof oj5.a) == false) goto L9;
        ((com.bytedance.ee.bear.more.b) org.koin.java.a.a(com.bytedance.ee.bear.more.b.class)).c(new i(getHost().getHostFragment().getArguments(), r1.getToken(), r1.getType(), r1.isShareFolder(), r1.b(), "rename", "ccm_space_drive_rename_view", "", "", r1 instanceof f, ((oj5.a) r1).k, r1.H(), r1.isOwner(), r1.L()));
        return;
    L9:
        return;
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem
    public String getTitle() {
        return getString(2131888030);
    }

    @Override // com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem
    public String getUnableTips() {
        oj5.c r0 = getMoreInfo();
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L10;
        Activity r2 = this.mActivity;
        int r3 = 2131887778;
    L11:
        String r4 = r2.getString(r3);
        return xo5.a.c(this.mActivity, 2131887777, ResourceData.KEY_TYPE, r4);
    L10:
        r2 = this.mActivity;
        r3 = 2131887780;
        goto L11
    L5:
        if (r0.getType() != e.i.b) goto L7;
        r1 = true;
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
        boolean r1 = false;
        if (isItemInvisibleByJSMsg() == false) goto L6;
        return false;
    L6:
        if (isItemInvisibleByBenefit() == false) goto L8;
        return false;
    L8:
        oj5.c r0 = getMoreInfo();
        if (r0 != null) goto L11;
    L19:
        boolean r3 = false;
    L21:
        if (com.bytedance.ee.bear.more.protocol3.panel.y.a() == true) goto L24;
        com.bytedance.ee.bear.more.protocol3.panel.y.c(TAG, getId());
        return r3;
    L24:
        if (r3 == true) goto L26;
    L28:
        String r5 = getId();
        if (r1 == false) goto L31;
        String r2 = "";
    L32:
        boolean r6 = r1;
        boolean r7 = r1;
        com.bytedance.ee.bear.more.protocol3.panel.y.b(TAG, r5, r6, r7, r2, "rename_edit_permission,baselineVisible=" + r3);
        return r1;
    L31:
        r2 = "edit_permission";
        goto L32
    L26:
        if (canEdit(r0) == false) goto L28;
        r1 = true;
        goto L28
    L11:
        if (r0.getType() != e.h.b) goto L13;
    L18:
        r3 = true;
        goto L21
    L13:
        if (r0.getType() == e.i.b) goto L18;
        if (r0.getType() != e.m.b) goto L19;
        if (com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.mobile.slides_enabled") == false) goto L19;
        goto L18
    }

    public RenameItemV2(Activity r1) {
        this.mActivity = r1;
    }

    public static /* synthetic */ Activity access$000(RenameItemV2 r0) {
        return r0.mActivity;
    }

    private boolean canEdit(oj5.c r8) {
        if (r8 != null) goto L6;
        return false;
    L6:
        if ((r8 instanceof oj5.b) == false) goto L8;
        return false;
    L8:
        ((cj5.b) org.koin.java.a.a(cj5.b.class)).getConfig();
        if (jg5.e.a.a.g() == false) goto L13;
        return ((com.bytedance.ee.bear.more.b) org.koin.java.a.a(com.bytedance.ee.bear.more.b.class)).t(r8.getToken(), r8, BizDomain.FileBizDomainCCM, "EDIT", r8.c().a).getAllow();
    L13:
        return r8.n();
    }

    private void handleCopyPermission(gp5.a r2) {
        SpaceEditText r3 = r2.g();
        if (r3 != null) goto L5;
        return;
    L5:
        if (((fu5.a) org.koin.java.a.a(fu5.a.class)).b() == true) goto L10;
        r3.setInterceptor(new a0(this));
        return;
    }

    private boolean lambda$handleCopyPermission$3(int r7) {
        oj5.c r2 = getMoreInfo();
        if (r2 != null) goto L5;
        return false;
    L5:
        if (this.mActivity != null) goto L8;
        return false;
    L8:
        if (r7 != 16908321) goto L10;
    L11:
        ((cj5.b) org.koin.java.a.a(cj5.b.class)).getConfig();
        if (jg5.e.a.a.g() == false) goto L23;
        PermissionResponse r8 = ((com.bytedance.ee.bear.more.b) org.koin.java.a.a(com.bytedance.ee.bear.more.b.class)).t(r2.getToken(), r2, BizDomain.FileBizDomainCCM, "CONTENT_COPY", r2.c().a);
        r8.getCallback().a(this.mActivity, r8);
        if (r8.getAllow() == true) goto L19;
        if (((ph5.c) org.koin.java.a.a(ph5.c.class)).d(r8) == true) goto L19;
        Toast.showFailureText(this.mActivity, 2131887613);
    L19:
        return !r8.getAllow();
    L23:
        return false;
    L10:
        if (r7 == 16908320) goto L11;
        return false;
    }

    private /* synthetic */ void lambda$onClick$2(String r1) {
        reportMoreItemClick(DocFeed$Value$Result.CANCEL);
    }

    private void reportMoreItemClick(String r19) {
        oj5.c r0 = getMoreInfo();
        if ((r0 instanceof oj5.a) == false) goto L6;
        ((com.bytedance.ee.bear.more.b) org.koin.java.a.a(com.bytedance.ee.bear.more.b.class)).c(new i(getHost().getHostFragment().getArguments(), r0.getToken(), r0.getType(), r0.isShareFolder(), r0.b(), r19, "ccm_space_drive_rename_view", "", "", r0 instanceof f, ((oj5.a) r0).k, r0.H(), r0.isOwner(), r0.L()));
        return;
    }

    private /* synthetic */ void lambda$onClick$1(oj5.c r2, String r3) {
        if (TextUtils.equals(r2.getTitle(), r3) == false) goto L5;
        tt5.a.h(TAG, "onClick Positive: title doesn't changed, so dismiss dialog");
    L6:
        reportMoreItemClick("confirm");
        return;
    L5:
        renameTitle(r2, r3);
        goto L6
    }

    private void renameTitle(oj5.c r7, String r8) {
        if ((r7 instanceof f) == false) goto L5;
        String r0 = ((f) r7).O;
    L7:
        if (r7.getToken() == null) goto L18;
        if (r8 == null) goto L19;
        NetService r1 = (NetService) org.koin.java.a.a(NetService.class);
        String r2 = r7.getToken();
        int r3 = r7.getType();
        final a r4 = new a(this, r7.getToken(), r0, r8);
        NetService.d r9 = r1.Vc(new d());
        if (3 != r3) goto L13;
        String r5 = "/api/sheet/update_meta/";
    L16:
        NetService.f r6 = new NetService.f(r5);
        ((NetService.e) r6).c = 1;
        HashMap r10 = new HashMap();
        r10.put(ResourceData.KEY_TOKEN, r2);
        r10.put("title", r8);
        r10.put(ResourceData.KEY_TYPE, String.valueOf(r3));
        r6.d(r10);
        r9.a(r6).subscribe(new com.bytedance.ee.bear.more.rename.a(r4), new com.bytedance.ee.bear.more.rename.b(r4));
        return;
    L13:
        if (30 != r3) goto L15;
        r5 = "/api/meta/update/";
        goto L16
    L15:
        r5 = "/api/bitable/update_meta/";
        goto L16
    L19:
        return;
    L18:
        return;
    L5:
        r0 = "";
        goto L7
    }

    private static /* synthetic */ Boolean lambda$onClick$0(boolean r0, boolean r1, Boolean r2) {
        if (r0 == false) goto L11;
        if (r1 == false) goto L5;
    L7:
        boolean r3 = false;
    L9:
        return Boolean.valueOf(r3);
    L5:
        if (r2.booleanValue() == false) goto L7;
        r3 = true;
        goto L9
    L11:
        return Boolean.TRUE;
    }
}
