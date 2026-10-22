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

/* JADX INFO: loaded from: classes16.dex */
public final class a {
    public static final void a(DrivePluginHost r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.f224125c.isVCFollowMode() == false) goto L5;
        tt5.a.h("DriveComponent", "closePage()# is VC page, showRetry");
        i(r100).liveInnerShowRetryPage().postValue(null);
        return;
    L5:
        tt5.a.h("DriveComponent", "closePage()# start finish");
        FragmentActivity r101 = r100.getActivity();
        if (r101 == null) goto L10;
        r101.finish();
        return;
    }

    public static final com.bytedance.ee.bear.drive.report.a b(DrivePluginHost r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return b.a().Tb();
    }

    public static final c c(DrivePluginHost r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return b.a().Ke();
    }

    public static final String d(BasePlugin<DrivePluginHost> r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return ((DrivePluginHost) r100.getHost()).f224125c.getOpenEntity().getFileId();
    }

    public static final DriveViewFullScreenVM e(DrivePluginHost r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return (DriveViewFullScreenVM) q.c(r100, DriveViewFullScreenVM.class, null);
    }

    public static final boolean g(AbsDrivePlugin r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        j r101 = j.a.f217090a;
        if (r101 != null) goto L5;
    L7:
        return false;
    L5:
        if (r101.getNetworkState().a() != true) goto L7;
        return true;
    }

    public static final PreviewViewModel i(DrivePluginHost r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return (PreviewViewModel) q.c(r100, PreviewViewModel.class, null);
    }

    public static final String j(BaseOpenEntity r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if ((r100 instanceof LocalOpenEntity) == true) goto L5;
        String r101 = r100.getFileId();
        if (r101 != null) goto L10;
        return "";
    L10:
        return r101;
    L5:
        return "local_" + d.a(((LocalOpenEntity) r100).getLocalFilePath());
    }

    public static final boolean f(DrivePluginHost r100, com.bytedance.ee.bear.drive.biz.docplugin.d r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r101 != null) goto L5;
    L12:
        return false;
    L5:
        if (r100.f224125c.isInBlockState() == true) goto L12;
        BaseOpenEntity r102 = r100.f224125c.getOpenEntity();
        int r103 = a95.a.f2276d;
        if (a95.a.b.a(null).f2279c.isCurrentEnable("ccm.drive.mobile.enable_thirdparty_exit_info") == false) goto L9;
        r101.c(new com.bytedance.ee.bear.drive.biz.docplugin.d.a(r102));
    L10:
        tt5.a.h("DriveComponent", "interceptVcModelBack() CMD_CLOSE");
        return true;
    L9:
        r101.c(new com.bytedance.ee.bear.drive.biz.docplugin.d.a(0));
        goto L10
    }

    public static final void h(AbsDrivePlugin r100, Observer<ConnectionService.NetworkState> r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "ob");
        j.a.f217090a.a().observe(r100.getHost().getLifecycleOwner(), r101);
    }
}
