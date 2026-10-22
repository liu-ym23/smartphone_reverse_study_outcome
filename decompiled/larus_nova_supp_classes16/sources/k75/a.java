package k75;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.browser.plugin.BasePlugin;
import com.bytedance.ee.bear.browser.plugin.q;
import com.bytedance.ee.bear.contract.ConnectionService;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseOpenEntity;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.LocalOpenEntity;
import com.bytedance.ee.bear.contract.j;
import com.bytedance.ee.bear.drive.biz.preview.screen.DriveViewFullScreenVM;
import com.bytedance.ee.bear.drive.core.AbsDrivePlugin;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import com.bytedance.ee.bear.drive.report.c;
import com.bytedance.ee.bear.drive.view.preview.wrapper.PreviewViewModel;
import du5.d;
import kotlin.jvm.internal.Intrinsics;
import o75.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a {
    public static final void a(DrivePluginHost r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if (r2.c.isVCFollowMode() == false) goto L5;
        tt5.a.h("DriveComponent", "closePage()# is VC page, showRetry");
        i(r2).liveInnerShowRetryPage().postValue(null);
        return;
    L5:
        tt5.a.h("DriveComponent", "closePage()# start finish");
        FragmentActivity r3 = r2.getActivity();
        if (r3 == null) goto L10;
        r3.finish();
        return;
    }

    public static final com.bytedance.ee.bear.drive.report.a b(DrivePluginHost r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return b.a().Tb();
    }

    public static final c c(DrivePluginHost r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return b.a().Ke();
    }

    public static final String d(BasePlugin<DrivePluginHost> r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return ((DrivePluginHost) r1.getHost()).c.getOpenEntity().getFileId();
    }

    public static final DriveViewFullScreenVM e(DrivePluginHost r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        return (DriveViewFullScreenVM) q.c(r2, DriveViewFullScreenVM.class, null);
    }

    public static final boolean g(AbsDrivePlugin r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        j r2 = j.a.a;
        if (r2 != null) goto L5;
    L7:
        return false;
    L5:
        if (r2.getNetworkState().a() != true) goto L7;
        return true;
    }

    public static final PreviewViewModel i(DrivePluginHost r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        return (PreviewViewModel) q.c(r2, PreviewViewModel.class, null);
    }

    public static final String j(BaseOpenEntity r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if ((r2 instanceof LocalOpenEntity) == true) goto L5;
        String r3 = r2.getFileId();
        if (r3 != null) goto L10;
        return "";
    L10:
        return r3;
    L5:
        return "local_" + d.a(((LocalOpenEntity) r2).getLocalFilePath());
    }

    public static final boolean f(DrivePluginHost r3, com.bytedance.ee.bear.drive.biz.docplugin.d r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        if (r4 != null) goto L5;
    L12:
        return false;
    L5:
        if (r3.c.isInBlockState() == true) goto L12;
        BaseOpenEntity r5 = r3.c.getOpenEntity();
        int r1 = a95.a.d;
        if (a95.a.b.a(null).c.isCurrentEnable("ccm.drive.mobile.enable_thirdparty_exit_info") == false) goto L9;
        r4.c(new com.bytedance.ee.bear.drive.biz.docplugin.d.a(r5));
    L10:
        tt5.a.h("DriveComponent", "interceptVcModelBack() CMD_CLOSE");
        return true;
    L9:
        r4.c(new com.bytedance.ee.bear.drive.biz.docplugin.d.a(0));
        goto L10
    }

    public static final void h(AbsDrivePlugin r1, Observer<ConnectionService.NetworkState> r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "ob");
        j.a.a.a().observe(r1.getHost().getLifecycleOwner(), r2);
    }
}
