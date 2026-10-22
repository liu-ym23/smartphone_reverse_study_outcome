package com.bytedance.ee.bear.drive.biz.preview.rename;

import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseOpenEntity;
import com.bytedance.ee.bear.drive.core.AbsDrivePlugin;
import com.bytedance.ee.bear.drive.loader.download.platform.api.FileInfoPuller;
import com.bytedance.ee.bear.drive.loader.download.platform.api.IApiPuller;
import com.bytedance.ee.bear.drive.loader.download.platform.api.drive.FileInfoV1Puller;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.Metadata;
import sbb.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/preview/rename/DriveRenameUpdatePlugin;", "Lcom/bytedance/ee/bear/drive/core/AbsDrivePlugin;", "<init>", "()V", "driveRenamePush", "Lcom/bytedance/ee/bear/drive/biz/preview/rename/DriveRenamePush;", "netService", "Lcom/bytedance/ee/bear/contract/NetService;", "mCompositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "onAttachPreview", "", "onDetachPreview", "Companion", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveRenameUpdatePlugin extends AbsDrivePlugin {
    public static final a Companion = null;
    public static final String TAG = "DriveRenameUpdatePlugin";
    private i65.b driveRenamePush;
    private final CompositeDisposable mCompositeDisposable;
    private NetService netService;

    public static final class a {
        public a() {
        }
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ DriveRenameUpdatePlugin a;

        public b(DriveRenameUpdatePlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r11) {
            String r0 = k75.a.d(this.a);
            if (TextUtils.equals(r0, (String) r11) == false) goto L14;
            DriveRenameUpdatePlugin r12 = this.a;
            DriveRenameUpdatePlugin.access$setNetService$p(r12, (NetService) r12.getHost().getUserComponent().a(NetService.class));
            NetService r13 = DriveRenameUpdatePlugin.access$getNetService$p(this.a);
            if (r13 == null) goto L13;
            DriveRenameUpdatePlugin r1 = this.a;
            CompositeDisposable r2 = DriveRenameUpdatePlugin.access$getMCompositeDisposable$p(r1);
            IApiPuller<FileInfoV1Puller.Params, f85.a> r14 = FileInfoPuller.V1(r13);
            String r3 = k75.a.d(r1);
            BaseOpenEntity r4 = r1.getHost().c.getOpenEntity();
            if (r4 == null) goto L10;
            String r5 = r4.getMountPoint();
        L11:
            r2.add(r14.pull(new FileInfoV1Puller.Params(r3, null, r5, null, null, null)).subscribe(new com.bytedance.ee.bear.drive.biz.preview.rename.a(r1), com.bytedance.ee.bear.drive.biz.preview.rename.b.a));
            return;
        L10:
            r5 = null;
            goto L11
        L13:
            return;
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public DriveRenameUpdatePlugin() {
        this.mCompositeDisposable = new CompositeDisposable();
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onAttachPreview() {
        super.onAttachPreview();
        String r1 = k75.a.d(this);
        i65.b r0 = new i65.b(r1);
        this.driveRenamePush = r0;
        if (r1 == null) goto L9;
        i65.a r2 = r0.b;
        if (r2 == null) goto L8;
        ((com.bytedance.ee.space.sync.b) org.koin.java.a.c(com.bytedance.ee.space.sync.b.class, null, null, 6)).q1(r2);
    L8:
        i65.a r3 = new i65.a(r0);
        r0.b = r3;
        ((com.bytedance.ee.space.sync.b) org.koin.java.a.c(com.bytedance.ee.space.sync.b.class, null, null, 6)).M6(r1, e.l.b, r3);
    L9:
        i65.b r4 = this.driveRenamePush;
        if (r4 == null) goto L15;
        MutableLiveData<String> r5 = r4.d;
        if (r5 == null) goto L16;
        r5.observe(getLifecycleOwner(), new b(this));
        return;
    L16:
        return;
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onDetachPreview() {
        super.onDetachPreview();
        i65.b r0 = this.driveRenamePush;
        if (r0 == null) goto L8;
        i65.a r1 = r0.b;
        if (r1 == null) goto L7;
        ((com.bytedance.ee.space.sync.b) org.koin.java.a.c(com.bytedance.ee.space.sync.b.class, null, null, 6)).q1(r1);
    L7:
        r0.c.clear();
    L8:
        this.mCompositeDisposable.clear();
    }

    public static final /* synthetic */ CompositeDisposable access$getMCompositeDisposable$p(DriveRenameUpdatePlugin r0) {
        return r0.mCompositeDisposable;
    }

    public static final /* synthetic */ NetService access$getNetService$p(DriveRenameUpdatePlugin r0) {
        return r0.netService;
    }

    public static final /* synthetic */ void access$setNetService$p(DriveRenameUpdatePlugin r0, NetService r1) {
        r0.netService = r1;
    }
}
