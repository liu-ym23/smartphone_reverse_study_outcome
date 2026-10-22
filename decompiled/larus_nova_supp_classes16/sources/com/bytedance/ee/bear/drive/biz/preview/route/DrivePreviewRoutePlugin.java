package com.bytedance.ee.bear.drive.biz.preview.route;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.drive.core.AbsDrivePlugin;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import com.bytedance.ee.bear.route.RouteBean;
import com.bytedance.ee.bear.route.h;
import k75.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import w75.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0012\u0010\n\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003H\u0016¨\u0006\f"}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/preview/route/DrivePreviewRoutePlugin;", "Lcom/bytedance/ee/bear/drive/core/AbsDrivePlugin;", "Landroidx/lifecycle/Observer;", "", "<init>", "()V", "onAttachToHost", "", "host", "Lcom/bytedance/ee/bear/drive/core/DrivePluginHost;", "onChanged", "url", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DrivePreviewRoutePlugin extends AbsDrivePlugin implements Observer<String> {
    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public DrivePreviewRoutePlugin() {
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onAttachToHost(DrivePluginHost r2) {
        Intrinsics.checkNotNullParameter(r2, "host");
        super.onAttachToHost(r2);
        a.i(r2).liveInnerRoute().observe(getLifecycleOwner(), this);
    }

    public void onChanged(String r5) {
        if (TextUtils.isEmpty(r5) == true) goto L15;
        w75.a r0 = getHost().c.getFileModel();
        if (r0 == null) goto L9;
        b r1 = r0.c();
        if (r1 == null) goto L9;
        String r2 = r1.a;
    L9:
        w75.a r3 = getHost().c.getFileModel();
        if (r3 == null) goto L14;
        b r4 = r3.c();
        if (r4 == null) goto L14;
        String r6 = r4.k;
    L14:
        na5.b r7 = new na5.b();
        Bundle r8 = new Bundle();
        r8.putString("lk_seclink_params", mu5.b.e(r7));
        RouteBean r9 = new RouteBean();
        r9.n = r8;
        ((h) org.koin.java.a.c(h.class, null, null, 6)).m9(r5, r9);
        return;
    L15:
        tt5.a.d("DriveSdk", "liveInnerRoute() url is empty");
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DrivePluginHost) r1);
    }

    public /* bridge */ /* synthetic */ void onChanged(Object r1) {
        onChanged((String) r1);
    }
}
