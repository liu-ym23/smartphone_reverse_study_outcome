package com.bytedance.ee.bear.drive.biz.preview.more.manager;

import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.contract.drive.sdk.entity.menu.c;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.BinderOpenLifecycle;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class DriveIMAttachmentMoreMenuManager implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e65.a f223542a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Sence f223543b;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0007\u001a\u00020\bj\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\t"}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/preview/more/manager/DriveIMAttachmentMoreMenuManager$Sence;", "", "<init>", "(Ljava/lang/String;I)V", "IM_SHEET_FILE", "IM_PPTX_FILE", "UNKNOW", "isSheetFile", "", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Sence extends Enum<Sence> {
        public static final Sence IM_PPTX_FILE = null;
        public static final Sence IM_SHEET_FILE = null;
        public static final Sence UNKNOW = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Sence[] f223544a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f223545b = null;

        public static EnumEntries<Sence> getEntries() {
            return f223545b;
        }

        static {
            Sence r100 = new Sence("IM_SHEET_FILE", 0);
            IM_SHEET_FILE = r100;
            Sence r101 = new Sence("IM_PPTX_FILE", 1);
            IM_PPTX_FILE = r101;
            Sence r102 = new Sence("UNKNOW", 2);
            UNKNOW = r102;
            Sence[] r103 = {r100, r101, r102};
            f223544a = r103;
            f223545b = EnumEntriesKt.enumEntries(r103);
        }

        public static Sence[] values() {
            return (Sence[]) f223544a.clone();
        }

        public final boolean isSheetFile() {
            if (IM_SHEET_FILE != this) goto L5;
            return true;
        L5:
            return false;
        }

        public static Sence valueOf(String r100) {
            return (Sence) r27.a.a(Sence.class, r100);
        }

        public Sence(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DriveIMAttachmentMoreMenuManager f223546a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.ee.bear.contract.drive.sdk.entity.menu.b f223547b;

        public a(DriveIMAttachmentMoreMenuManager r100, com.bytedance.ee.bear.contract.drive.sdk.entity.menu.b r101) {
            this.f223546a = r100;
            this.f223547b = r101;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            Intrinsics.checkNotNullParameter((com.bytedance.ee.bear.contract.drive.sdk.entity.menu.a) r100, "it");
            e65.a r101 = this.f223546a.f223542a;
            r101.f471141d.handleFileDownloadMenuClick(this.f223547b, r101);
        }
    }

    public static final class b<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DriveIMAttachmentMoreMenuManager f223548a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.ee.bear.contract.drive.sdk.entity.menu.b f223549b;

        public b(DriveIMAttachmentMoreMenuManager r100, com.bytedance.ee.bear.contract.drive.sdk.entity.menu.b r101) {
            this.f223548a = r100;
            this.f223549b = r101;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            if (((String) r100) != null) goto L5;
            tt5.a.k("DriveSdk", "DriveIMAttachmentMoreMenuManager#liveFileToken() error state, fileToken is null");
            return;
        L5:
            e65.a r101 = this.f223548a.f223542a;
            r101.f471140c.setSaveToSpaceMenuState(this.f223549b, r101);
        }
    }

    @Override // com.bytedance.ee.bear.contract.drive.sdk.entity.menu.c
    public final void b() {
        BinderOpenLifecycle r100 = this.f223542a.f471138a.getBinderOpenLifecycle();
        if (r100 == null) goto L6;
        r100.onClose();
        return;
    }

    @Override // com.bytedance.ee.bear.contract.drive.sdk.entity.menu.c
    public final void a(com.bytedance.ee.bear.contract.drive.sdk.entity.menu.b r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        Observer<com.bytedance.ee.bear.contract.drive.sdk.entity.menu.a> r101 = r100.f217028e;
        if (r101 == null) goto L5;
        this.f223542a.f471141d.getLiveDownload().removeObserver(r101);
    L5:
        Observer<String> r102 = r100.f217029f;
        if (r102 == null) goto L8;
        this.f223542a.f471140c.getLiveFileToken().removeObserver(r102);
    L8:
        this.f223542a.f471141d.releaseDownloadActionsInterface();
        this.f223542a.f471140c.detachPush();
    }

    @Override // com.bytedance.ee.bear.contract.drive.sdk.entity.menu.c
    public final com.bytedance.ee.bear.drive.biz.preview.more.manager.a c(com.bytedance.ee.bear.contract.drive.sdk.entity.menu.b r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        return new com.bytedance.ee.bear.drive.biz.preview.more.manager.a(r100, this);
    }

    @Override // com.bytedance.ee.bear.contract.drive.sdk.entity.menu.c
    public final void d(com.bytedance.ee.bear.contract.drive.sdk.entity.menu.b r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        a r101 = new a(this, r100);
        r100.f217028e = r101;
        this.f223542a.f471141d.getLiveDownload().observe(r100.f217026c.getHost().getLifecycleOwner(), r101);
        this.f223542a.f471141d.initDownloadActionsInterface(r100, this.f223542a);
        b r102 = new b(this, r100);
        r100.f217029f = r102;
        this.f223542a.f471140c.getLiveFileToken().observe(r100.f217026c.getHost().getLifecycleOwner(), r102);
        e65.a r103 = this.f223542a;
        r103.f471140c.setSaveToSpaceMenuState(r100, r103);
        this.f223542a.f471140c.attachPush();
    }

    public DriveIMAttachmentMoreMenuManager(e65.a r100, Sence r101) {
        Intrinsics.checkNotNullParameter(r100, "menuContext");
        Intrinsics.checkNotNullParameter(r101, "scene");
        this.f223542a = r100;
        this.f223543b = r101;
    }
}
