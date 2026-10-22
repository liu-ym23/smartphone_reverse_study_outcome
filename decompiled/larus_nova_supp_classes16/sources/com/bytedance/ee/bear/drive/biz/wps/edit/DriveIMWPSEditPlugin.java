package com.bytedance.ee.bear.drive.biz.wps.edit;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.drive.biz.permission.model.DrivePermissionInfoViewModel;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import com.bytedance.ee.bear.drive.loader.download.platform.api.DriveDocumentEditType;
import com.bytedance.ee.bear.drive.loader.download.platform.api.imfile.FileAbilityPuller;
import com.bytedance.ee.bear.drive.loader.model.InfoCode;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.DefaultDocPublicPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.DefaultDocUserPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.DocPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission;
import io.reactivex.Flowable;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u000b\u001a\u00020\bH\u0003J\u0006\u0010\r\u001a\u00020\bJ\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/wps/edit/DriveIMWPSEditPlugin;", "Lcom/bytedance/ee/bear/drive/biz/wps/edit/DriveBaseWPSEditPlugin;", "<init>", "()V", "isExcelPermission", "", "isEditable", "onAttachToHost", "", "pluginHost", "Lcom/bytedance/ee/bear/drive/core/DrivePluginHost;", "fileAbilityPuller", "isFirst", "postFilePermissionChange", "postFileEditPermission", "editable", "Companion", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveIMWPSEditPlugin extends DriveBaseWPSEditPlugin {
    public static final int ABILITY_SUPPORT_EDIT = 1;
    public static final a Companion = null;
    public static final String TAG = "DriveIMWPSEditPlugin";
    private boolean isExcelPermission;
    private boolean isFirst;

    public static final class a {
        public a() {
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ DriveIMWPSEditPlugin a;

        public b(DriveIMWPSEditPlugin r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            FileAbilityPuller.Result r4 = (FileAbilityPuller.Result) r3;
            tt5.a.h(DriveIMWPSEditPlugin.TAG, "doc ability is " + r4.getAbility() + ",  permission is " + r4.getPermission());
            if (r4.getAbility() == 1) goto L5;
        L7:
            DriveIMWPSEditPlugin.access$postFileEditPermission(this.a, false);
            return;
        L5:
            if (r4.getPermission() != 1) goto L7;
            DriveIMWPSEditPlugin.access$postFileEditPermission(this.a, true);
        }
    }

    public static final class c<T> implements Consumer {
        public static final c<T> a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final void accept(Object r3) {
            tt5.a.d(DriveIMWPSEditPlugin.TAG, "getFileAbility()...Failed: " + ((Throwable) r3));
        }
    }

    public static final class d extends u75.b.C0306b {
        public final /* synthetic */ String a;
        public final /* synthetic */ DriveIMWPSEditPlugin b;

        public d(String r1, DriveIMWPSEditPlugin r2) {
            this.a = r1;
            this.b = r2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // u75.b.C0306b, u75.b.a
        public final <T> void a(InfoCode r2, T r3) {
            Intrinsics.checkNotNullParameter(r2, "code");
            Intrinsics.checkNotNullParameter(r2, "code");
            if (r2 == InfoCode.SheetInfoSuccess) goto L5;
            return;
        L5:
            if ((r3 instanceof w75.a) == true) goto L7;
            return;
        L7:
            if ("xlsx".equalsIgnoreCase(this.a) == false) goto L20;
            StringBuilder r4 = new StringBuilder("InfoCode.SheetInfoSuccess  data.documentEditType: ");
            w75.a r5 = (w75.a) r3;
            r4.append(r5.y);
            tt5.a.h(DriveIMWPSEditPlugin.TAG, r4.toString());
            if (DriveIMWPSEditPlugin.access$isExcelPermission$p(this.b) == true) goto L21;
            DriveIMWPSEditPlugin r6 = this.b;
            if (r6.isEditable() == true) goto L13;
        L15:
            boolean r7 = false;
        L16:
            DriveIMWPSEditPlugin.access$postFileEditPermission(r6, r7);
            return;
        L13:
            if (DriveDocumentEditType.Companion.isTypeUseWpsCanWrite(Integer.valueOf(r5.y)) == false) goto L15;
            r7 = true;
            goto L16
        L21:
            return;
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.drive.biz.wps.edit.DriveBaseWPSEditPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    @Override // com.bytedance.ee.bear.drive.biz.wps.edit.DriveBaseWPSEditPlugin
    public boolean isEditable() {
        boolean r0 = com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.drive.im_wps_edit_enable");
        boolean r1 = getHost().c.isHistoryMode();
        if (r0 == false) goto L6;
        if (r1 == true) goto L6;
        return true;
    L6:
        return false;
    }

    public final void postFilePermissionChange() {
        tt5.a.h(TAG, "  postFilePermissionChange  isFirst: " + this.isFirst);
        if (this.isExcelPermission == true) goto L6;
        return;
    L6:
        if (this.isFirst == false) goto L9;
        this.isFirst = false;
        return;
    L9:
        fileAbilityPuller();
    }

    public DriveIMWPSEditPlugin() {
        this.isFirst = true;
    }

    private final void fileAbilityPuller() {
        boolean r0 = isEditable();
        String r1 = com.bytedance.ee.util.io.a.c(getHost().c.getFileName());
        boolean r4 = false;
        if ("xls".equalsIgnoreCase(r1) == false) goto L5;
    L12:
        boolean r3 = true;
    L14:
        if (this.isExcelPermission == true) goto L16;
    L27:
        tt5.a.h(TAG, "fileAbilityPuller isExcelPermission: " + this.isExcelPermission + ",  isEditable: " + r0 + ",  extension: " + r1 + ",  isSupportWpsEditType: " + r3);
        if (r0 == false) goto L34;
        if (r3 == false) goto L35;
        FileAbilityPuller r2 = new FileAbilityPuller((NetService) getHost().getUserComponent().a(NetService.class));
        FileAbilityPuller.Params r5 = new FileAbilityPuller.Params();
        r5.setFileToken(getHost().c.getFileId());
        Flowable<FileAbilityPuller.Result> r6 = r2.pull(r5);
        if (r6 == null) goto L36;
        r6.subscribe(new b(this), c.a);
        return;
    L36:
        return;
    L35:
        return;
    L34:
        return;
    L16:
        if ("xlsx".equalsIgnoreCase(r1) == false) goto L18;
    L25:
        r4 = true;
    L26:
        r3 = r4;
        goto L27
    L18:
        if ("xls".equalsIgnoreCase(r1) == true) goto L25;
        if ("xlsm".equalsIgnoreCase(r1) == true) goto L25;
        if ("xlm".equalsIgnoreCase(r1) == true) goto L25;
        if ("et".equalsIgnoreCase(r1) == false) goto L26;
    L5:
        if ("xlsm".equalsIgnoreCase(r1) == true) goto L12;
        if ("xlm".equalsIgnoreCase(r1) == true) goto L12;
        if ("et".equalsIgnoreCase(r1) == true) goto L12;
        r3 = false;
        goto L14
    }

    public static final /* synthetic */ boolean access$isExcelPermission$p(DriveIMWPSEditPlugin r0) {
        return r0.isExcelPermission;
    }

    private final void postFileEditPermission(final boolean r6) {
        MutableLiveData<u55.b> r0 = ((DrivePermissionInfoViewModel) viewModel(DrivePermissionInfoViewModel.class)).getLiveInnerFilePermissionChanged();
        if (this.isExcelPermission == false) goto L16;
        u55.b r1 = (u55.b) r0.getValue();
        boolean r3 = false;
        if (r1 == null) goto L13;
        DocPermission r2 = r1.b;
        if (r2 == null) goto L13;
        IDocUserPermission r4 = r2.a;
        if (r4 == null) goto L13;
        if (r6 != r4.canEdit()) goto L13;
        r3 = true;
    L13:
        if (r3 == false) goto L16;
        tt5.a.h(TAG, "  postFilePermissionChange editable == lastPermisssion, editable: " + r6);
        return;
    L16:
        u55.b r5 = new u55.b();
        DocPermission r7 = r5.b;
        DefaultDocUserPermission r8 = new DriveIMWPSEditPlugin$postFileEditPermission$permissionInfo$1$1$1(r6);
        r7.getClass();
        Intrinsics.checkNotNullParameter(r8, "<set-?>");
        r7.a = r8;
        DefaultDocPublicPermission r9 = new DriveIMWPSEditPlugin$postFileEditPermission$permissionInfo$1$1$2();
        Intrinsics.checkNotNullParameter(r9, "<set-?>");
        r7.b = r9;
        tt5.a.h(TAG, "permission changed... token=" + du5.b.g(getHost().c.getFileId()) + ", canEdit=" + r5.c() + ", isOwner=" + r5.k());
        r0.postValue(r5);
    }

    @Override // com.bytedance.ee.bear.drive.biz.wps.edit.DriveBaseWPSEditPlugin
    public void onAttachToHost(DrivePluginHost r3) {
        super.onAttachToHost(r3);
        this.isExcelPermission = ((dn4.a) getHost().getUserComponent().a(dn4.a.class)).a().isCurrentEnable("lark.im_excel.permission_switch");
        String r4 = com.bytedance.ee.util.io.a.c(getHost().c.getFileName());
        getHost().c().c(new d(r4, this));
        fileAbilityPuller();
    }

    @Override // com.bytedance.ee.bear.drive.biz.wps.edit.DriveBaseWPSEditPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DrivePluginHost) r1);
    }

    public static final /* synthetic */ void access$postFileEditPermission(DriveIMWPSEditPlugin r0, boolean r1) {
        r0.postFileEditPermission(r1);
    }
}
