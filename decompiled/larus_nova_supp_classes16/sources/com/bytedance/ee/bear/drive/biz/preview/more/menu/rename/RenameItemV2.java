package com.bytedance.ee.bear.drive.biz.preview.more.menu.rename;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import b95.d;
import b95.l;
import com.bytedance.ee.bear.DocMetaInfo;
import com.bytedance.ee.bear.browser.plugin.q;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseOpenEntity;
import com.bytedance.ee.bear.contract.k0;
import com.bytedance.ee.bear.document.comment.bean.JSEventListener;
import com.bytedance.ee.bear.document.tips.TipCallBackData;
import com.bytedance.ee.bear.drive.biz.extra_info.meta.DriveMetaInfoVM;
import com.bytedance.ee.bear.drive.cache.t;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import com.bytedance.ee.bear.drive.core.DriveViewModel;
import com.bytedance.ee.bear.drive.report.c;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.BizDomain;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionResponse;
import com.bytedance.ee.bear.more.i;
import com.bytedance.ee.bear.more.m;
import com.bytedance.ee.bear.more.moreprotocol.BaseMoreItem;
import com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem;
import com.bytedance.ee.bear.more.moreprotocol.MoreUiAction;
import com.bytedance.ee.bear.widgets.dialog.BearUDDialogBuilder;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEditText;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.larksuite.component.universe_design.toast.UDToast;
import com.ss.android.lark.compose.foundation.toast.FlowToast;
import kotlin.jvm.internal.Intrinsics;
import oj5.f;
import sbb.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class RenameItemV2 extends BaseMoreItem implements ITextMoreItem {
    public static final String ID_RENAME = "item_renameV2";
    private static final String TAG = "DRIVE_RenameItemV2";
    private Context mContext;
    private t mDriveCacheManager;
    private l mDriveDialogManager;
    private c mDriveReport;
    private f85.a mFileModel;
    private String mNewName;
    private UpdateFileInfoRepository mUpdateFileInfoRepository;
    private DrivePluginHost pluginHost;

    public class a implements UpdateFileInfoRepository.d {
        public final /* synthetic */ String a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ RenameItemV2 c;

        public final void a(int r3) {
            tt5.a.h(RenameItemV2.TAG, "renameFile onFailure errorCode = " + r3);
            if (RenameItemV2.access$000(this.c) != null) goto L7;
            tt5.a.d(RenameItemV2.TAG, "onFailure context is null");
            return;
        L7:
            if (k0.b(r3) == false) goto L10;
            return;
        L10:
            if (r3 != 10009) goto L13;
            int r4 = 2131888427;
        L16:
            Toast.showFailureText(RenameItemV2.access$000(this.c), RenameItemV2.access$000(this.c).getString(r4), 0);
            return;
        L13:
            if (r3 != 90003088) goto L15;
            r4 = 2131889780;
            goto L16
        L15:
            r4 = 2131888443;
            goto L16
        }

        public a(RenameItemV2 r1, String r2, boolean r3) {
            this.c = r1;
            this.a = r2;
            this.b = r3;
        }
    }

    public class b implements l.a {
        public final /* synthetic */ RenameItemV2 a;

        @Override // b95.l.a
        public final void cancel() {
            c r0 = RenameItemV2.access$400(this.a);
            c.b r1 = c.e(RenameItemV2.access$200(this.a));
            r0.getClass();
            r0.F(r1.a, r1.b, "click_rename_confirm", "use_old");
            String r2 = ((f85.a.C0229a) RenameItemV2.access$200(this.a).a).k;
            String r3 = com.bytedance.ee.util.io.a.d(RenameItemV2.access$500(this.a));
            RenameItemV2 r4 = this.a;
            if (TextUtils.isEmpty(r2) == true) goto L6;
            r3 = r3.concat(".").concat(r2);
        L6:
            RenameItemV2.access$502(r4, r3);
            RenameItemV2 r5 = this.a;
            RenameItemV2.access$600(r5, RenameItemV2.access$500(r5), false);
        }

        @Override // b95.l.a
        public final void confirm() {
            c r0 = RenameItemV2.access$400(this.a);
            c.b r1 = c.e(RenameItemV2.access$200(this.a));
            r0.getClass();
            r0.F(r1.a, r1.b, "click_rename_confirm", "use_new");
            RenameItemV2 r2 = this.a;
            RenameItemV2.access$600(r2, RenameItemV2.access$500(r2), true);
        }

        public b(RenameItemV2 r1) {
            this.a = r1;
        }
    }

    public static /* synthetic */ boolean a(RenameItemV2 r0, int r1) {
        return r0.lambda$handleCopyPermission$3(r1);
    }

    public static /* synthetic */ void b(RenameItemV2 r0, String r1) {
        r0.lambda$showFileNameEditView$2(r1);
    }

    public static /* synthetic */ void c(RenameItemV2 r0, String r1) {
        r0.lambda$showFileNameEditView$1(r1);
    }

    public static /* synthetic */ void d(RenameItemV2 r0, com.ss.android.lark.compose.foundation.toast.b r1) {
        r0.lambda$forceSecretToast$0(r1);
    }

    public int getIcon() {
        return 2131254065;
    }

    public int getIconTint() {
        return 2131102418;
    }

    public String getId() {
        return ID_RENAME;
    }

    public final /* synthetic */ MoreUiAction getMoreAction() {
        return ITextMoreItem.-CC.$default$getMoreAction(this);
    }

    public String getStateTips() {
        return "";
    }

    public String getUnableTips() {
        return "";
    }

    public boolean isVisible() {
        return true;
    }

    public boolean needShowBadge() {
        return false;
    }

    public void onDetach() {
        this.mContext = null;
        this.mFileModel = null;
    }

    public void onDisableClick() {
    }

    private void confirmSecondary() {
        Context r0 = this.mContext;
        if (r0 != null) goto L6;
        tt5.a.k(TAG, "confirmSecondary()...mContext == null");
        return;
    L6:
        String r1 = xo5.a.c(r0, 2131888458, "ext", "." + com.bytedance.ee.util.io.a.c(this.mNewName));
        String r2 = xo5.a.c(this.mContext, 2131888414, "ext", "." + com.bytedance.ee.util.io.a.c(((f85.a.C0229a) this.mFileModel.a).b));
        final l r3 = this.mDriveDialogManager;
        Context r4 = this.mContext;
        final b r5 = new b(this);
        r3.getClass();
        BearUDDialogBuilder r6 = new BearUDDialogBuilder(r4);
        r6.a.title(2131888372);
        r6.a.message(2131888394);
        r6.a.messageTextSize(16);
        r6.c(2131391777, r1, 2131105548, new b95.a(r5));
        r6.c(2131391778, r2, 2131105548, new b95.c(r5));
        r6.a(BearUDDialogBuilder.ActionBottomOrientation.VERTICAL);
        r6.a.cancelable(false);
        r6.a.width(303.0f);
        r6.a.marginInDp(0);
        final Dialog r7 = r6.h();
        r3.a.put(Integer.valueOf(r7.hashCode()), r7);
        r7.setOnDismissListener(new d(r3, r7));
    }

    private boolean isForceSecret() {
        DriveMetaInfoVM r0 = (DriveMetaInfoVM) q.c(this.pluginHost, DriveMetaInfoVM.class, null);
        oj5.c r1 = getMoreInfo();
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.getLiveMetaInfo().getValue() != null) goto L7;
        return false;
    L7:
        if (r1.c() != null) goto L9;
        return false;
    L9:
        return fj5.a.d(((u55.a) r0.getLiveMetaInfo().getValue()).b, r1.c().a);
    }

    private void showFileNameEditView() {
        if (this.mContext != null) goto L5;
        return;
    L5:
        gp5.a r0 = (gp5.a) new gp5.a(this.mContext).title(2131888442);
        r0.f(2131888432);
        r0.e(((f85.a.C0229a) this.mFileModel.a).b);
        r0.m = getCursorIndex(((f85.a.C0229a) this.mFileModel.a).b);
        r0.a(2131888375);
        gp5.a.a r1 = new g65.c(this);
        Intrinsics.checkNotNullParameter(r1, "value");
        r0.r = r1;
        r0.c();
        gp5.a.a r2 = new g65.d(this);
        Intrinsics.checkNotNullParameter(r2, "value");
        r0.s = r2;
        r0.o = true;
        UDDialog r3 = r0.show();
        handleCopyPermission(r0);
        ((zo5.b) org.koin.java.a.a(zo5.b.class)).d(r3);
        if ((getMoreInfo() instanceof oj5.a) == false) goto L9;
        oj5.a r4 = getMoreInfo();
        String r12 = r4.i.a.getReportJson();
        ((com.bytedance.ee.bear.more.b) org.koin.java.a.a(com.bytedance.ee.bear.more.b.class)).I(new com.bytedance.ee.bear.more.l("ccm_space_drive_rename_view", getHost().getHostFragment().getArguments(), r4.c, r4.getType(), r4.b(), r4 instanceof f, r4.k, r4.isOwner(), false, r12));
        return;
    }

    public String forceSecretToast() {
        if (this.mContext != null) goto L6;
        return "";
    L6:
        if (isForceSecret() == false) goto L9;
        Context r0 = this.mContext;
        Intrinsics.checkNotNullParameter(r0, "context");
        FlowToast.a r2 = FlowToast.a(r0);
        r2.d(UDToast.access$createTintedIcon(UDToast.INSTANCE, r0, 2131256189));
        r2.e(2131889918);
        UDToast.b r1 = new g65.a(this);
        Intrinsics.checkNotNullParameter(r1, JSEventListener.ACTION);
        r2.b(2131889947, new com.larksuite.component.universe_design.toast.a(r1));
        r2.a().show();
        return "";
    L9:
        String r3 = this.mContext.getString(2131887779);
        return xo5.a.c(this.mContext, 2131887777, "type", r3);
    }

    public void onNameNoChange() {
        this.mDriveReport.E(c.e(this.mFileModel), "use_old");
        c r0 = this.mDriveReport;
        c.b r1 = c.e(this.mFileModel);
        r0.getClass();
        r0.F(r1.a, r1.b, "click_rename_confirm", "use_new");
        Toast.showSuccessText(eu5.b.a, 2131888444);
        callbackRename(((f85.a.C0229a) this.mFileModel.a).b, false);
    }

    public String getTitle() {
        return getString(2131888442);
    }

    public boolean isEnable() {
        if (getMoreInfo() != null) goto L5;
    L7:
        return false;
    L5:
        if (getMoreInfo().n() == false) goto L7;
        return true;
    }

    public void onClick() {
        if (isForceSecret() == false) goto L6;
        forceSecretToast();
        return;
    L6:
        showFileNameEditView();
        if (getMoreInfo() == null) goto L9;
        oj5.c r0 = getMoreInfo();
        ((com.bytedance.ee.bear.more.b) org.koin.java.a.a(com.bytedance.ee.bear.more.b.class)).c(new i(getHost().getHostFragment().getArguments(), r0.getToken(), r0.getType(), false, r0.b(), "rename", "ccm_space_drive_rename_view", "", "", false, this.mDriveReport.j(), r0.H(), r0.isOwner(), r0.L()));
    L9:
        getHost().a();
    }

    public static /* synthetic */ Context access$000(RenameItemV2 r0) {
        return r0.mContext;
    }

    public static /* synthetic */ f85.a access$200(RenameItemV2 r0) {
        return r0.mFileModel;
    }

    public static /* synthetic */ t access$300(RenameItemV2 r0) {
        return r0.mDriveCacheManager;
    }

    public static /* synthetic */ c access$400(RenameItemV2 r0) {
        return r0.mDriveReport;
    }

    public static /* synthetic */ String access$500(RenameItemV2 r0) {
        return r0.mNewName;
    }

    private void callbackConfirm(String r2) {
        if (TextUtils.equals(((f85.a.C0229a) this.mFileModel.a).b, r2) == false) goto L6;
        onNameNoChange();
        return;
    L6:
        if (checkTypeModify(r2) == false) goto L8;
        onTypeModify(r2);
        return;
    L8:
        onNameModify(r2);
    }

    private boolean checkTypeModify(String r2) {
        f85.a r0 = this.mFileModel;
        if (r0 != null) goto L5;
        String r1 = "";
    L7:
        return !TextUtils.equals(r1, com.bytedance.ee.util.io.a.c(r2));
    L5:
        r1 = ((f85.a.C0229a) r0.a).k;
        goto L7
    }

    private int getCursorIndex(String r2) {
        if (r2 != null) goto L5;
        return -1;
    L5:
        int r0 = r2.lastIndexOf(".");
        if (r0 < 0) goto L8;
        return r0;
    L8:
        return r2.length();
    }

    private void handleCopyPermission(gp5.a r2) {
        SpaceEditText r3 = r2.g();
        if (r3 != null) goto L5;
        return;
    L5:
        if (((fu5.a) org.koin.java.a.a(fu5.a.class)).b() == true) goto L10;
        r3.setInterceptor(new g65.b(this));
        return;
    }

    private void lambda$forceSecretToast$0(com.larksuite.component.universe_design.toast.c r8) {
        DriveMetaInfoVM r9 = (DriveMetaInfoVM) q.c(this.pluginHost, DriveMetaInfoVM.class, null);
        if (r9 != null) goto L5;
        return;
    L5:
        if (r9.getLiveMetaInfo().getValue() == null) goto L9;
        DocMetaInfo r4 = ((u55.a) r9.getLiveMetaInfo().getValue()).b;
        ((cj5.c) org.koin.java.a.a(cj5.c.class)).r3(this.pluginHost.getActivity(), ((f85.a.C0229a) this.mFileModel.a).a, e.l.b, r4, "", "from_banner");
        getHost().a();
        return;
    }

    private boolean lambda$handleCopyPermission$3(int r7) {
        oj5.c r2 = getMoreInfo();
        if (r2 != null) goto L5;
        return false;
    L5:
        if (this.mContext != null) goto L8;
        return false;
    L8:
        if (r7 != 16908321) goto L10;
    L11:
        ((cj5.b) org.koin.java.a.a(cj5.b.class)).getConfig();
        if (jg5.e.a.a.g() == false) goto L23;
        PermissionResponse r8 = ((com.bytedance.ee.bear.more.b) org.koin.java.a.a(com.bytedance.ee.bear.more.b.class)).t(r2.getToken(), r2, BizDomain.FileBizDomainCCM, "CONTENT_COPY", r2.c().a);
        r8.getCallback().a(this.mContext, r8);
        if (r8.getAllow() == true) goto L19;
        if (((ph5.c) org.koin.java.a.a(ph5.c.class)).d(r8) == true) goto L19;
        Toast.showFailureText(this.mContext, 2131887613);
    L19:
        return !r8.getAllow();
    L23:
        return false;
    L10:
        if (r7 == 16908320) goto L11;
        return false;
    }

    private /* synthetic */ void lambda$showFileNameEditView$1(String r1) {
        callbackConfirm(yu5.c.m(r1));
        reportMoreItemClick(TipCallBackData.CONFIRM);
    }

    private /* synthetic */ void lambda$showFileNameEditView$2(String r3) {
        this.mDriveReport.E(c.e(this.mFileModel), "use_old");
        reportMoreItemClick("cancel");
    }

    private void reportMoreItemClick(String r14) {
        if (getMoreInfo() == null) goto L8;
        oj5.a r0 = getMoreInfo();
        if ((r0 instanceof oj5.a) == false) goto L9;
        String r11 = r0.i.a.getReportJson();
        ((com.bytedance.ee.bear.more.b) org.koin.java.a.a(com.bytedance.ee.bear.more.b.class)).E(new m(getHost().getHostFragment().getArguments(), r0.getToken(), r0.getType(), r0.b(), r0 instanceof f, r0.k, r14, r0.isOwner(), r11));
        return;
    L9:
        return;
    }

    public void onNameModify(String r6) {
        if (r6.equals(this.mNewName) == false) goto L5;
        this.mDriveReport.E(c.e(this.mFileModel), "use_old");
    L6:
        c r0 = this.mDriveReport;
        c.b r2 = c.e(this.mFileModel);
        r0.getClass();
        r0.F(r2.a, r2.b, "click_rename_confirm", "use_new");
        this.mNewName = r6;
        renameFile(r6, false);
        return;
    L5:
        this.mDriveReport.E(c.e(this.mFileModel), "use_new");
        goto L6
    }

    public void onTypeModify(String r1) {
        this.mNewName = r1;
        confirmSecondary();
    }

    public RenameItemV2(Context r2, DrivePluginHost r3) {
        this.mContext = r2;
        this.pluginHost = r3;
        this.mUpdateFileInfoRepository = new UpdateFileInfoRepository((NetService) org.koin.java.a.a(NetService.class));
        this.mFileModel = (f85.a) r3.c.getFileModel();
        this.mDriveDialogManager = o75.b.a().H7();
        this.mDriveCacheManager = o75.b.a().getCacheManager();
        this.mDriveReport = o75.b.a().Ke();
    }

    public static /* synthetic */ String access$502(RenameItemV2 r0, String r1) {
        r0.mNewName = r1;
        return r1;
    }

    private void callbackRename(String r5, boolean r6) {
        u55.a r0 = (u55.a) ((DriveMetaInfoVM) q.c(this.pluginHost, DriveMetaInfoVM.class, null)).getLiveMetaInfo().getValue();
        if (r0 == null) goto L5;
        r0.b.setTitle(r5);
    L5:
        BaseOpenEntity r1 = this.pluginHost.c.getOpenEntity();
        String r2 = "";
        if (r1 == null) goto L8;
        String r3 = r1.getFileId();
    L10:
        if (this.pluginHost.c.isTypeWiki() == false) goto L18;
        DriveViewModel r4 = this.pluginHost.c;
        if (r4 != null) goto L14;
    L19:
        if (r6 == true) goto L30;
        f85.a r7 = (f85.a) this.pluginHost.c.getFileModel();
        if (r7 == null) goto L29;
        f85.a.C0229a r8 = (f85.a.C0229a) r7.a;
        if (r8 == null) goto L29;
        tt5.a.h("DriveComponent", "Meta Builder#setName() name=" + du5.b.g(r5) + " srcName=" + du5.b.g(r8.b));
        r8.b = r5;
        String r9 = com.bytedance.ee.util.io.a.c(r5);
        if (r9 == null) goto L28;
        r2 = r9;
    L28:
        r8.k = r2;
    L29:
        this.pluginHost.c.setFileName(r5);
        k75.a.i(this.pluginHost).liveInnerFileNameChanged().postValue(r5);
        return;
    L30:
        tt5.a.h(TAG, "onFileRenamed() needRefresh, startLoad");
        DrivePluginHost r10 = this.pluginHost;
        DriveViewModel r11 = r10.c;
        a95.a r12 = r10.b();
        int r13 = com.bytedance.ee.bear.drive.biz.cache.a.a;
        com.bytedance.ee.bear.drive.biz.cache.a.C0118a.b(r11, null, r12);
        this.pluginHost.d.load();
        return;
    L14:
        if (r4.getWikiInfo() == null) goto L19;
        if (TextUtils.isEmpty(this.pluginHost.c.getWikiInfo().getWikiToken()) == true) goto L19;
        ((rc5.a) org.koin.java.a.a(rc5.a.class)).T(this.pluginHost.c.getWikiInfo().getWikiToken(), r5);
        goto L19
    L18:
        ((rc5.a) org.koin.java.a.a(rc5.a.class)).T(r3, r5);
        goto L19
    L8:
        r3 = "";
        goto L10
    }

    private void renameFile(String r5, boolean r6) {
        UpdateFileInfoRepository r0 = this.mUpdateFileInfoRepository;
        w75.b r1 = this.mFileModel.a;
        r0.update(((f85.a.C0229a) r1).a, r5, ((f85.a.C0229a) r1).n, new a(this, r5, r6));
    }

    public static /* synthetic */ void access$100(RenameItemV2 r0, String r1, boolean r2) {
        r0.callbackRename(r1, r2);
    }

    public static /* synthetic */ void access$600(RenameItemV2 r0, String r1, boolean r2) {
        r0.renameFile(r1, r2);
    }
}
