package com.bytedance.ee.bear.drive.biz.preview.more.manager;

import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.contract.drive.sdk.entity.menu.c;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.BinderOpenLifecycle;
import com.bytedance.ee.bear.document.comment.bean.JSEventListener;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class DriveIMAttachmentMoreMenuManager implements c {
    public final e65.a a;
    public final Sence b;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0007\u001a\u00020\bj\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\t"}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/preview/more/manager/DriveIMAttachmentMoreMenuManager$Sence;", "", "<init>", "(Ljava/lang/String;I)V", "IM_SHEET_FILE", "IM_PPTX_FILE", "UNKNOW", "isSheetFile", "", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Sence extends Enum<Sence> {
        public static final Sence IM_PPTX_FILE = null;
        public static final Sence IM_SHEET_FILE = null;
        public static final Sence UNKNOW = null;
        public static final /* synthetic */ Sence[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<Sence> getEntries() {
            return b;
        }

        static {
            Sence r0 = new Sence("IM_SHEET_FILE", 0);
            IM_SHEET_FILE = r0;
            Sence r1 = new Sence("IM_PPTX_FILE", 1);
            IM_PPTX_FILE = r1;
            Sence r3 = new Sence("UNKNOW", 2);
            UNKNOW = r3;
            Sence[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
        }

        public static Sence[] values() {
            return (Sence[]) a.clone();
        }

        public final boolean isSheetFile() {
            if (IM_SHEET_FILE != this) goto L5;
            return true;
        L5:
            return false;
        }

        public static Sence valueOf(String r1) {
            return (Sence) r27.a.a(Sence.class, r1);
        }

        public Sence(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a<T> implements Observer {
        public final /* synthetic */ DriveIMAttachmentMoreMenuManager a;
        public final /* synthetic */ com.bytedance.ee.bear.contract.drive.sdk.entity.menu.b b;

        public a(DriveIMAttachmentMoreMenuManager r1, com.bytedance.ee.bear.contract.drive.sdk.entity.menu.b r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onChanged(Object r3) {
            Intrinsics.checkNotNullParameter((com.bytedance.ee.bear.contract.drive.sdk.entity.menu.a) r3, "it");
            e65.a r4 = this.a.a;
            r4.d.handleFileDownloadMenuClick(this.b, r4);
        }
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ DriveIMAttachmentMoreMenuManager a;
        public final /* synthetic */ com.bytedance.ee.bear.contract.drive.sdk.entity.menu.b b;

        public b(DriveIMAttachmentMoreMenuManager r1, com.bytedance.ee.bear.contract.drive.sdk.entity.menu.b r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onChanged(Object r3) {
            if (((String) r3) != null) goto L5;
            tt5.a.k("DriveSdk", "DriveIMAttachmentMoreMenuManager#liveFileToken() error state, fileToken is null");
            return;
        L5:
            e65.a r4 = this.a.a;
            r4.c.setSaveToSpaceMenuState(this.b, r4);
        }
    }

    @Override // com.bytedance.ee.bear.contract.drive.sdk.entity.menu.c
    public final void b() {
        BinderOpenLifecycle r0 = this.a.a.getBinderOpenLifecycle();
        if (r0 == null) goto L6;
        r0.onClose();
        return;
    }

    @Override // com.bytedance.ee.bear.contract.drive.sdk.entity.menu.c
    public final void a(com.bytedance.ee.bear.contract.drive.sdk.entity.menu.b r3) {
        Intrinsics.checkNotNullParameter(r3, JSEventListener.ACTION);
        Observer<com.bytedance.ee.bear.contract.drive.sdk.entity.menu.a> r0 = r3.e;
        if (r0 == null) goto L5;
        this.a.d.getLiveDownload().removeObserver(r0);
    L5:
        Observer<String> r4 = r3.f;
        if (r4 == null) goto L8;
        this.a.c.getLiveFileToken().removeObserver(r4);
    L8:
        this.a.d.releaseDownloadActionsInterface();
        this.a.c.detachPush();
    }

    @Override // com.bytedance.ee.bear.contract.drive.sdk.entity.menu.c
    public final com.bytedance.ee.bear.drive.biz.preview.more.manager.a c(com.bytedance.ee.bear.contract.drive.sdk.entity.menu.b r2) {
        Intrinsics.checkNotNullParameter(r2, JSEventListener.ACTION);
        return new com.bytedance.ee.bear.drive.biz.preview.more.manager.a(r2, this);
    }

    @Override // com.bytedance.ee.bear.contract.drive.sdk.entity.menu.c
    public final void d(com.bytedance.ee.bear.contract.drive.sdk.entity.menu.b r4) {
        Intrinsics.checkNotNullParameter(r4, JSEventListener.ACTION);
        a r0 = new a(this, r4);
        r4.e = r0;
        this.a.d.getLiveDownload().observe(r4.c.getHost().getLifecycleOwner(), r0);
        this.a.d.initDownloadActionsInterface(r4, this.a);
        b r1 = new b(this, r4);
        r4.f = r1;
        this.a.c.getLiveFileToken().observe(r4.c.getHost().getLifecycleOwner(), r1);
        e65.a r2 = this.a;
        r2.c.setSaveToSpaceMenuState(r4, r2);
        this.a.c.attachPush();
    }

    public DriveIMAttachmentMoreMenuManager(e65.a r2, Sence r3) {
        Intrinsics.checkNotNullParameter(r2, "menuContext");
        Intrinsics.checkNotNullParameter(r3, "scene");
        this.a = r2;
        this.b = r3;
    }
}
