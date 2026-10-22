package com.bytedance.ee.bear.drive.core;

import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import com.bytedance.ee.bear.browser.plugin.BasePlugin;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.drive.loader.model.InfoCode;
import com.bytedance.ee.drive.preview.f;
import com.bytedance.ee.drive.render.k;
import i75.j;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b&\u0018\u0000 \u001e2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001d\u001eB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002H\u0016J\u0010\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002H\u0016J\b\u0010\u0015\u001a\u00020\u0012H\u0016J\b\u0010\u0016\u001a\u00020\u0012H\u0016J#\u0010\u0017\u001a\u0004\u0018\u0001H\u0018\"\b\b\u0000\u0010\u0018*\u00020\u00192\b\b\u0001\u0010\u001a\u001a\u00020\u001bH\u0007¢\u0006\u0002\u0010\u001cR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\u0004\u0018\u00010\u000e8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001f"}, d2 = {"Lcom/bytedance/ee/bear/drive/core/AbsDrivePlugin;", "Lcom/bytedance/ee/bear/browser/plugin/BasePlugin;", "Lcom/bytedance/ee/bear/drive/core/DrivePluginHost;", "<init>", "()V", "mAttachStateListener", "Lcom/bytedance/ee/bear/drive/core/load/IFileLoader$LoadListener;", "driveUserComponentAbility", "Lcom/bytedance/ee/bear/drive/usercomponent/DriveUserComponentAbility;", "getDriveUserComponentAbility", "()Lcom/bytedance/ee/bear/drive/usercomponent/DriveUserComponentAbility;", "setDriveUserComponentAbility", "(Lcom/bytedance/ee/bear/drive/usercomponent/DriveUserComponentAbility;)V", "driveUIConfig", "Lcom/bytedance/ee/drive/render/IDriveUIConfig;", "getDriveUIConfig", "()Lcom/bytedance/ee/drive/render/IDriveUIConfig;", "onAttachToHost", "", "host", "onDetachFromHost", "onAttachPreview", "onDetachPreview", "findViewById", ExifInterface.GPS_DIRECTION_TRUE, "Landroid/view/View;", "idRes", "", "(I)Landroid/view/View;", "AttachStateListener", "Companion", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbsDrivePlugin extends BasePlugin<DrivePluginHost> {
    public static final b Companion = null;
    private static final String TAG = "AbsDrivePlugin";
    private a95.a driveUserComponentAbility;
    private u75.b.a mAttachStateListener;

    public final class a extends u75.b.C7844b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AbsDrivePlugin f224110a;

        public a(AbsDrivePlugin r100) {
            this.f224110a = r100;
        }

        @Override // u75.b.C7844b, u75.b.a
        public final <T> void a(InfoCode r100, T r101) {
            Intrinsics.checkNotNullParameter(r100, "code");
            if (r100 != InfoCode.OnAttach) goto L6;
            this.f224110a.onAttachPreview();
            return;
        L6:
            if (r100 != InfoCode.OnDetach) goto L10;
            this.f224110a.onDetachPreview();
            return;
        }
    }

    public static final class b {
        public b() {
        }
    }

    static {
        Companion = new b();
    }

    public final k getDriveUIConfig() {
        return ((f) org.koin.java.a.c(f.class, null, null, 6)).U4(getContext()).b();
    L5:
        th = move-exception;
        tt5.a.e(TAG, "resolve drive ui config failed", th, false);
        return null;
    }

    public void onAttachPreview() {
    }

    public void onDetachPreview() {
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r100) {
    }

    public AbsDrivePlugin() {
        this.driveUserComponentAbility = new a95.a();
    }

    public final a95.a getDriveUserComponentAbility() {
        return this.driveUserComponentAbility;
    }

    public final <T extends View> T findViewById(int r100) {
        int r101 = j.f488468a;
        return (T) j.a.a(r100, (Fragment) getLifecycleOwner());
    }

    public void onAttachToHost(DrivePluginHost r100) {
        Intrinsics.checkNotNullParameter(r100, "host");
        super.onAttachToHost(r100);
        this.mAttachStateListener = new a(this);
        u75.b r101 = r100.c();
        u75.b.a r102 = this.mAttachStateListener;
        Intrinsics.checkNotNull(r102);
        r101.c(r102);
    }

    public void onDetachFromHost(DrivePluginHost r100) {
        Intrinsics.checkNotNullParameter(r100, "host");
        super.onDetachFromHost(r100);
        u75.b.a r101 = this.mAttachStateListener;
        if (r101 == null) goto L6;
        r100.c().g(r101);
        return;
    }

    public final void setDriveUserComponentAbility(a95.a r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.driveUserComponentAbility = r100;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r100) {
        onAttachToHost((DrivePluginHost) r100);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r100) {
        onDetachFromHost((DrivePluginHost) r100);
    }
}
