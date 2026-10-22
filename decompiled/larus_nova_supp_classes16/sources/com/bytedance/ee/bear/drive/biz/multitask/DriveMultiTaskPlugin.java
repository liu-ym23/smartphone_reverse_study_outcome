package com.bytedance.ee.bear.drive.biz.multitask;

import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseOpenEntity;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.SpaceFileOpenEntity;
import com.bytedance.ee.bear.document.pageedit.PageEditPlugin;
import com.bytedance.ee.bear.document.r4;
import com.bytedance.ee.bear.drive.biz.permission.DriveMGPermissionVM;
import com.bytedance.ee.bear.drive.core.AbsDrivePlugin;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import com.bytedance.ee.bear.drive.core.DriveViewModel;
import com.bytedance.ee.bear.facade.common.BaseActivity;
import com.bytedance.ee.bear.lark.dependency.s;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sbb.e;
import u55.b;
import wb5.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005J\b\u0010\t\u001a\u00020\u0007H\u0016J\u0018\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0012\u0010\u000f\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0002J\u0012\u0010\u0012\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0011H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/multitask/DriveMultiTaskPlugin;", "Lcom/bytedance/ee/bear/drive/core/AbsDrivePlugin;", "<init>", "()V", "needAddVisitRecord", "", "setNeedAddVisitRecord", "", PageEditPlugin.ADD, "onAttachPreview", "onAttachToUIContainer", "host", "Lcom/bytedance/ee/bear/drive/core/DrivePluginHost;", "uiContainer", "Lcom/bytedance/ee/bear/browser/plugin/UIContainer;", "onResume", "checkPermissionTitle", "", "onPause", "createMainNavInfo", "Lcom/bytedance/ee/bear/lark/dependency/params/MainNavParams;", "titleName", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveMultiTaskPlugin extends AbsDrivePlugin {
    private boolean needAddVisitRecord;

    public static final class a<T> implements Observer {
        public final /* synthetic */ DriveMultiTaskPlugin a;
        public final /* synthetic */ DrivePluginHost b;

        public a(DriveMultiTaskPlugin r1, DrivePluginHost r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onChanged(Object r3) {
            r4.a r4 = (r4.a) r3;
            if (DriveMultiTaskPlugin.access$isUIContainerAttached(this.a) == false) goto L14;
            DriveViewModel r0 = this.b.c;
            if (r4 != null) goto L7;
        L11:
            boolean r5 = false;
        L12:
            r0.setIsDeleted(r5);
            return;
        L7:
            if ((r4 instanceof r4.a.C0096a) == false) goto L11;
            if (((r4.a.C0096a) r4).a != (-55)) goto L11;
            r5 = true;
            goto L12
        }
    }

    private final String checkPermissionTitle() {
        b r0 = (b) ((DriveMGPermissionVM) viewModel(DriveMGPermissionVM.class)).livePerm().getValue();
        if (r0 != null) goto L5;
        return "";
    L5:
        if (r0.e() == true) goto L12;
        String r1 = getString(2131889846);
        if (r1 != null) goto L10;
        return "";
    L10:
        return r1;
    L12:
        return "";
    }

    public DriveMultiTaskPlugin() {
        this.needAddVisitRecord = true;
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onAttachPreview() {
        super.onAttachPreview();
        ((DriveMultiTaskVM) new ViewModelProvider(getActivity()).get(DriveMultiTaskVM.class)).setCurrentDriveViewModel(getHost().c);
    }

    public static final /* synthetic */ boolean access$isUIContainerAttached(DriveMultiTaskPlugin r0) {
        return r0.isUIContainerAttached();
    }

    private final d createMainNavInfo(String r11) {
        DrivePluginHost r0 = getHost();
        if (r0 == null) goto L32;
        DriveViewModel r1 = r0.c;
        if (r1 == null) goto L32;
        String r3 = com.bytedance.ee.util.io.a.c(r1.getFileName());
        if ((r1.getOpenEntity() instanceof SpaceFileOpenEntity) == true) goto L9;
    L13:
        String r4 = "";
    L14:
        String r5 = r1.getFileId();
        if ((getActivity() instanceof BaseActivity) == false) goto L28;
        BaseActivity r6 = getActivity();
        if ((r6 instanceof BaseActivity) == false) goto L19;
        BaseActivity r7 = r6;
    L20:
        if (r7 == null) goto L28;
        xj5.a r8 = r7.vb(xj5.a.class);
        if (r8 == null) goto L26;
        msb.a r9 = r8.a;
        if (r9 == null) goto L26;
        r9.b();
    L26:
        r5 = "";
        goto L28
    L19:
        r7 = null;
    L28:
        if (TextUtils.isEmpty(r1.getFileName()) == false) goto L30;
        String r2 = ((rc5.a) org.koin.java.a.c(rc5.a.class, null, null, 6)).getDocumentDefaultName(getActivity(), 12);
    L31:
        Intrinsics.checkNotNull(r2);
        int r10 = e.l.b;
        String r12 = r4;
    L34:
        if (TextUtils.isEmpty(r11) == true) goto L36;
        String r13 = r11;
        String r14 = "";
        int r16 = -1;
    L38:
        return new d(r5, r13, r12, r16, r14);
    L36:
        r14 = r3;
        r16 = r10;
        r13 = r2;
        goto L38
    L30:
        r2 = r1.getFileName();
        goto L31
    L9:
        if (r1.isTypeWiki() == false) goto L11;
        BaseOpenEntity r17 = r1.getOpenEntity();
        Intrinsics.checkNotNull(r17, "null cannot be cast to non-null type com.bytedance.ee.bear.contract.drive.sdk.entity.open.SpaceFileOpenEntity");
        r4 = ((SpaceFileOpenEntity) r17).getWikiUrl();
        Intrinsics.checkNotNull(r4);
        goto L14
    L11:
        BaseOpenEntity r18 = r1.getOpenEntity();
        Intrinsics.checkNotNull(r18, "null cannot be cast to non-null type com.bytedance.ee.bear.contract.drive.sdk.entity.open.SpaceFileOpenEntity");
        r4 = ((SpaceFileOpenEntity) r18).getUrl();
        if (r4 != null) goto L14;
    L32:
        r2 = "";
        r3 = r2;
        r5 = r3;
        r12 = r5;
        r10 = -1;
        goto L34
    }

    public void onPause(DrivePluginHost r4) {
        super.onPause(r4);
        if (this.needAddVisitRecord == true) goto L5;
        return;
    L5:
        d r5 = createMainNavInfo(checkPermissionTitle());
        if (r5 == null) goto L9;
        ((s) org.koin.java.a.c(s.class, null, null, 6)).b(r5);
        return;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onResume(PluginHost r1) {
        onResume((DrivePluginHost) r1);
    }

    public final void setNeedAddVisitRecord(boolean r1) {
        this.needAddVisitRecord = r1;
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
        onPause((DrivePluginHost) r1);
    }

    public void onResume(DrivePluginHost r1) {
        super.onResume(r1);
    }

    public void onAttachToUIContainer(DrivePluginHost r3, t r4) {
        Intrinsics.checkNotNullParameter(r3, "host");
        Intrinsics.checkNotNullParameter(r4, "uiContainer");
        super.onAttachToUIContainer(r3, r4);
        r4 r5 = (r4) getHostAbilityOrNull(r4.class);
        if (r5 == null) goto L8;
        LiveData<r4.a> r6 = r5.getLoadState();
        if (r6 == null) goto L9;
        r6.observe(r3.getLifecycleOwner(), new a(this, r3));
        return;
    L9:
        return;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r1, t r2) {
        onAttachToUIContainer((DrivePluginHost) r1, r2);
    }
}
