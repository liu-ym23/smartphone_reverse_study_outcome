package com.bytedance.ee.bear.drive.core;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.q;
import com.bytedance.ee.bear.document.s4;
import com.bytedance.ee.bear.drive.core.fragment.AbsLazyLoadFragment;
import com.bytedance.ee.bear.drive.core.fragment.DriveMediaImmersiveVM;
import com.bytedance.ee.bear.drive.view.preview.wrapper.ViewOwner;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import u75.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010 \u001a\u00020!H\u0016J\b\u0010\"\u001a\u00020\u0004H\u0016J\b\u0010#\u001a\u00020!H\u0016J\r\u0010$\u001a\u00020%H\u0016¢\u0006\u0002\u0010&J\b\u0010'\u001a\u0004\u0018\u00010(J\u0006\u0010)\u001a\u00020%J\u0018\u0010*\u001a\u0004\u0018\u00010\u00042\u0006\u0010+\u001a\u00020%2\u0006\u0010,\u001a\u00020%J\u000e\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u000200J\u0006\u00101\u001a\u00020\u0018R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\nX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0012\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010\u001e\u001a\u0004\u0018\u00010\n2\b\u0010\u001d\u001a\u0004\u0018\u00010\n8F@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\f¨\u00062"}, d2 = {"Lcom/bytedance/ee/bear/drive/core/DrivePluginHost;", "Lcom/bytedance/ee/bear/browser/plugin/PluginHost;", "Lcom/bytedance/ee/bear/document/FragmentHostAbility;", "driveFragment", "Landroidx/fragment/app/Fragment;", "arguments", "Landroid/os/Bundle;", "<init>", "(Landroidx/fragment/app/Fragment;Landroid/os/Bundle;)V", "parentViewOwner", "Lcom/bytedance/ee/bear/drive/view/preview/wrapper/ViewOwner;", "getParentViewOwner", "()Lcom/bytedance/ee/bear/drive/view/preview/wrapper/ViewOwner;", "setParentViewOwner", "(Lcom/bytedance/ee/bear/drive/view/preview/wrapper/ViewOwner;)V", "driveViewModel", "Lcom/bytedance/ee/bear/drive/core/DriveViewModel;", "fileLoader", "Lcom/bytedance/ee/bear/drive/core/load/IFileLoader;", "getFileLoader", "()Lcom/bytedance/ee/bear/drive/core/load/IFileLoader;", "setFileLoader", "(Lcom/bytedance/ee/bear/drive/core/load/IFileLoader;)V", "driveUserComponentAbility", "Lcom/bytedance/ee/bear/drive/usercomponent/DriveUserComponentAbility;", "getDriveUserComponentAbility", "()Lcom/bytedance/ee/bear/drive/usercomponent/DriveUserComponentAbility;", "setDriveUserComponentAbility", "(Lcom/bytedance/ee/bear/drive/usercomponent/DriveUserComponentAbility;)V", "value", "viewOwner", "getViewOwner", "getFragmentTitle", "", "getFragment", "getToken", "canRead", "", "()Ljava/lang/Boolean;", "mediaImmersiveVM", "Lcom/bytedance/ee/bear/drive/core/fragment/DriveMediaImmersiveVM;", "isMediaImmersiveActiveForCurrentOpen", "getDriveTopFragment", "isVc", "isWiki", "addLoadListener", "", "listener", "Lcom/bytedance/ee/bear/drive/core/load/IFileLoader$LoadListener;", "findDriveUserComponentAbility", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DrivePluginHost extends PluginHost implements s4 {
    public final Fragment a;
    public ViewOwner b;
    public final DriveViewModel c;
    public b d;
    public a95.a e;
    public ViewOwner f;

    @Override // com.bytedance.ee.bear.document.s4
    public final String getToken() {
        return "";
    }

    public final a95.a b() {
        a95.a r0 = this.e;
        if (r0 != null) goto L6;
        a95.a r1 = new a95.a(getUserComponent());
        this.e = r1;
        return r1;
    L6:
        return r0;
    }

    public final b c() {
        b r0 = this.d;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("fileLoader");
        return null;
    }

    @Override // com.bytedance.ee.bear.document.s4
    public final Boolean canRead() {
        return Boolean.valueOf(this.c.canRead());
    }

    public final ViewOwner d() {
        ViewOwner r0 = this.b;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("parentViewOwner");
        return null;
    }

    public final ViewOwner e() {
        if (this.f != null) goto L6;
        this.f = new ViewOwner(this, getLifecycleOwner());
    L6:
        return this.f;
    }

    public final DriveMediaImmersiveVM f() {
        FragmentActivity r0 = this.a.getActivity();
        if (r0 != null) goto L6;
        tt5.a.k(this.TAG, "mediaImmersiveVM skipped: activity null");
        return null;
    L6:
        tt5.a.h(this.TAG, "mediaImmersiveVM resolved");
        return (DriveMediaImmersiveVM) new ViewModelProvider(r0).get(DriveMediaImmersiveVM.class);
    }

    @Override // com.bytedance.ee.bear.document.s4
    public final String h7() {
        String r0 = this.c.getFileName();
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0;
    }

    @Override // com.bytedance.ee.bear.document.s4
    public final Fragment getFragment() {
        return this.a;
    }

    public final void a(b.C0306b r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        if (this.d == null) goto L6;
        c().c(r2);
        return;
    }

    public DrivePluginHost(AbsLazyLoadFragment r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "driveFragment");
        this.a = r2;
        this.c = (DriveViewModel) q.c(this, DriveViewModel.class, DriveViewModel.newFactory(r3));
    }
}
