package com.bytedance.ee.bear.drive.biz.external;

import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BaseMoreMenuAction;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseOpenEntity;
import com.bytedance.ee.bear.drive.biz.preview.more.w;
import com.bytedance.ee.bear.drive.core.AbsDrivePlugin;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import com.bytedance.ee.bear.drivesdk.plugin.model.menu.OpenExternalMenu;
import io.reactivex.disposables.CompositeDisposable;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/external/DriveImFileOpenExternalPlugin;", "Lcom/bytedance/ee/bear/drive/core/AbsDrivePlugin;", "<init>", "()V", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "onAttachToHost", "", "host", "Lcom/bytedance/ee/bear/drive/core/DrivePluginHost;", "onDetachFromHost", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveImFileOpenExternalPlugin extends AbsDrivePlugin {
    private final CompositeDisposable compositeDisposable;

    public static final class a<T> implements Observer {
        public final /* synthetic */ BaseOpenEntity a;
        public final /* synthetic */ DrivePluginHost b;
        public final /* synthetic */ DriveImFileOpenExternalPlugin c;

        public a(BaseOpenEntity r1, DrivePluginHost r2, DriveImFileOpenExternalPlugin r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void onChanged(Object r6) {
            Void r7 = (Void) r6;
            ((com.bytedance.ee.bear.f) org.koin.java.a.c(com.bytedance.ee.bear.f.class, null, null, 6)).a(this.a);
            if (TextUtils.isEmpty(this.a.getFileId()) == true) goto L6;
            ((com.bytedance.ee.bear.middleground_permission_export.model.c) org.koin.java.a.c(com.bytedance.ee.bear.middleground_permission_export.model.c.class, null, null, 6)).k(this.a.getAppId(), this.a.getFileId(), Boolean.FALSE, null);
            ((zk5.a) org.koin.java.a.c(zk5.a.class, null, null, 6)).a(sbb.e.l.b, this.a.getFileId(), "open_with_other_app");
        L6:
            if (hu5.a.d(this.b.c.getOpenEntity().getMoreMenuActions()) == true) goto L26;
            Iterator<BaseMoreMenuAction> r8 = this.b.c.getOpenEntity().getMoreMenuActions().iterator();
        L9:
            if (r8.hasNext() == false) goto L28;
            BaseMoreMenuAction r1 = r8.next();
            if ((r1 instanceof OpenExternalMenu) == false) goto L9;
            if (((OpenExternalMenu) r1).a == null) goto L9;
            int r9 = w.a;     // Catch: Exception -> L16
            w.a.a(DriveImFileOpenExternalPlugin.access$getCompositeDisposable$p(this.c), DriveImFileOpenExternalPlugin.access$getActivity(this.c), r1, null);     // Catch: Exception -> L16
            return;
        L16:
            e = move-exception;
            tt5.a.e("DriveComponent", "liveInnerOpenExternal() custom OpenExternalMenu action error", e, false);
            return;
        L28:
            return;
        }
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public DriveImFileOpenExternalPlugin() {
        this.compositeDisposable = new CompositeDisposable();
    }

    public static final /* synthetic */ FragmentActivity access$getActivity(DriveImFileOpenExternalPlugin r0) {
        return r0.getActivity();
    }

    public static final /* synthetic */ CompositeDisposable access$getCompositeDisposable$p(DriveImFileOpenExternalPlugin r0) {
        return r0.compositeDisposable;
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onAttachToHost(DrivePluginHost r5) {
        Intrinsics.checkNotNullParameter(r5, "host");
        super.onAttachToHost(r5);
        BaseOpenEntity r0 = r5.c.getOpenEntity();
        k75.a.i(r5).liveInnerOpenExternal().observe(getLifecycleOwner(), new a(r0, r5, this));
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onDetachFromHost(DrivePluginHost r2) {
        Intrinsics.checkNotNullParameter(r2, "host");
        super.onDetachFromHost(r2);
        this.compositeDisposable.clear();
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DrivePluginHost) r1);
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r1) {
        onDetachFromHost((DrivePluginHost) r1);
    }
}
