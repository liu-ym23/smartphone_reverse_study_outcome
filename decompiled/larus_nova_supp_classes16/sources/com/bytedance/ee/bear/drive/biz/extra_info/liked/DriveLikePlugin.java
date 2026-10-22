package com.bytedance.ee.bear.drive.biz.extra_info.liked;

import android.widget.TextView;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.contract.ConnectionService;
import com.bytedance.ee.bear.drive.biz.extra_info.DriveSpaceFileExtraInfoViewPlugin;
import com.bytedance.ee.bear.drive.biz.extra_info.FileExtraInfoView;
import com.bytedance.ee.bear.drive.biz.extra_info.LikeCircleImageView;
import com.bytedance.ee.bear.drive.biz.extra_info.LikeInfoView;
import com.bytedance.ee.bear.drive.biz.permission.DriveMGPermissionVM;
import com.bytedance.ee.bear.drive.core.AbsDrivePlugin;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import com.bytedance.ee.bear.drive.core.DriveViewModel;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.DocPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission;
import com.bytedance.ee.util.ui.ColorUtils;
import com.bytedance.ee.util.ui.l;
import f55.c;
import f55.f;
import f55.k;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import w55.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u0007H\u0016J\b\u0010\u000b\u001a\u00020\u0007H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/extra_info/liked/DriveLikePlugin;", "Lcom/bytedance/ee/bear/drive/core/AbsDrivePlugin;", "<init>", "()V", "mLikeWrapper", "Lcom/bytedance/ee/bear/drive/biz/extra_info/liked/LikeWrapper;", "onAttachToHost", "", "host", "Lcom/bytedance/ee/bear/drive/core/DrivePluginHost;", "onAttachPreview", "onDetachPreview", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveLikePlugin extends AbsDrivePlugin {
    private f mLikeWrapper;

    public static final class a<T> implements Observer {
        public final /* synthetic */ DriveLikePlugin a;

        public a(DriveLikePlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            u55.b r4 = (u55.b) r3;
            f r0 = DriveLikePlugin.access$getMLikeWrapper$p(this.a);
            if (r0 == null) goto L11;
            if (r4 == null) goto L12;
            DocPermission r5 = r4.b;
            if (r5 == null) goto L13;
            IDocUserPermission r6 = r5.a;
            if (r6 == null) goto L14;
            r0.j = Boolean.valueOf(r6.canViewCollaboratorInfo());
            r0.c(r0.k, r0.l);
            return;
        L14:
            return;
        L13:
            return;
        L12:
            return;
        }
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ DriveLikePlugin a;

        public b(DriveLikePlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r11) {
            ConnectionService.NetworkState r12 = (ConnectionService.NetworkState) r11;
            if (r12 == null) goto L7;
            boolean r1 = true;
            if (r12.a() != true) goto L7;
        L9:
            if (r1 == false) goto L24;
            f r2 = DriveLikePlugin.access$getMLikeWrapper$p(this.a);
            if (r2 != null) goto L13;
            return;
        L13:
            if (r2.g == true) goto L42;
            tt5.a.h("LikeWrapper", "enableLikeView: ");
            LikeInfoView r6 = r2.a;
            if (r6.getState() != LikeInfoView.LikeState.LIKED) goto L18;
            r6.a.setImageResource(2131256002);
            l.c(r6.a, 2131105548);
            r6.a.setImageAlpha(255);
        L23:
            TextView r13 = r6.b;
            r13.setTextColor(ColorUtils.c(255, r13.getCurrentTextColor()));
            r2.a.setOnClickListener(r2.m);
            r2.b.setVisibility(0);
            r2.b.setOnClickListener(r2.n);
            return;
        L18:
            r6.a.setImageResource(2131256003);
            if (n.d == false) goto L21;
            l.c(r6.a, 2131102419);
        L22:
            r6.a.setImageAlpha(255);
            goto L23
        L21:
            l.c(r6.a, 2131102418);
            goto L22
        L42:
            return;
        L24:
            f r0 = DriveLikePlugin.access$getMLikeWrapper$p(this.a);
            if (r0 != null) goto L27;
            return;
        L27:
            if (r0.g == true) goto L43;
            tt5.a.h("LikeWrapper", "disableLikeView: ");
            LikeInfoView r3 = r0.a;
            if (r3.getState() != LikeInfoView.LikeState.LIKED) goto L32;
            r3.a.setImageResource(2131256002);
            l.c(r3.a, 2131105548);
            r3.a.setImageAlpha(127);
        L37:
            TextView r14 = r3.b;
            r14.setTextColor(ColorUtils.c(77, r14.getCurrentTextColor()));
            r0.a.setOnClickListener(null);
            r0.b.setVisibility(8);
            r0.b.setOnClickListener(null);
            return;
        L32:
            r3.a.setImageResource(2131256003);
            if (n.d == false) goto L35;
            l.c(r3.a, 2131102419);
        L36:
            r3.a.setImageAlpha(127);
            goto L37
        L35:
            l.c(r3.a, 2131102418);
            goto L36
        L43:
            return;
        L7:
            r1 = false;
            goto L9
        }
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onAttachPreview() {
        super.onAttachPreview();
        DriveSpaceFileExtraInfoViewPlugin r0 = (DriveSpaceFileExtraInfoViewPlugin) findPlugin(DriveSpaceFileExtraInfoViewPlugin.class);
        LikeCircleImageView r1 = null;
        if (r0 == null) goto L5;
        FileExtraInfoView r2 = r0.getFileExtraView();
    L6:
        DriveViewModel r3 = getHost().c;
        if (r2 == null) goto L9;
        LikeInfoView r4 = r2.getLikeInfoView();
    L10:
        if (r2 == null) goto L12;
        r1 = r2.getLikeCircleImageView();
    L12:
        this.mLikeWrapper = new f(r3, r4, r1);
        ((DriveMGPermissionVM) viewModel(DriveMGPermissionVM.class)).livePerm().observe(getLifecycleOwner(), new a(this));
        final f r5 = this.mLikeWrapper;
        if (r5 == null) goto L16;
        r5.e.add(((hg5.b) org.koin.java.a.a(hg5.b.class)).c(r5.h, new k(r5)));
        r5.e.add(((hg5.b) org.koin.java.a.a(hg5.b.class)).b(r5.h).subscribe(new f55.b(r5), new c()));
        return;
    L16:
        return;
    L9:
        r4 = null;
        goto L10
    L5:
        r2 = null;
        goto L6
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onDetachPreview() {
        super.onDetachPreview();
        f r0 = this.mLikeWrapper;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.f == null) goto L7;
        ((hg5.b) org.koin.java.a.a(hg5.b.class)).a(r0.f);
        r0.f = null;
    L7:
        ((hg5.b) org.koin.java.a.a(hg5.b.class)).clearCallback();
        CompositeDisposable r1 = r0.e;
        if (r1 == null) goto L12;
        r1.clear();
        return;
    }

    public DriveLikePlugin() {
    }

    public static final /* synthetic */ f access$getMLikeWrapper$p(DriveLikePlugin r0) {
        return r0.mLikeWrapper;
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onAttachToHost(DrivePluginHost r2) {
        Intrinsics.checkNotNullParameter(r2, "host");
        super.onAttachToHost(r2);
        k75.a.h(this, new b(this));
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DrivePluginHost) r1);
    }
}
