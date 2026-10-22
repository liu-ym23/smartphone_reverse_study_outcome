package mi5;

import android.app.Application;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.middleground.permission.share.info.ShareDocInfo;
import com.bytedance.ee.bear.share.export.ShareParams;
import com.larus.nova.R;
import com.lynx.tasm.LynxError;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class a extends com.bytedance.ee.bear.share.newshare.extension.a<ShareDocInfo> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ShareParams f514071c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ShareDocInfo f514072d;

    /* JADX INFO: renamed from: mi5.a$a, reason: collision with other inner class name */
    public static final class C6818a {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.share.newshare.extension.a
    public final void a() {
        tt5.a.h("DocShareInfoBehavior", "create");
        c(this.f514072d);
    }

    public static void d(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, LynxError.LYNX_THROWABLE);
        if (ax4.d.b(r100, 1002) == false) goto L5;
    L8:
        Toast.showFailureText(eu5.b.f474075a, R.string.CreationMobile_ECM_shortcut_sharing_failed_NoPermission_toast);
        return;
    L5:
        if (ax4.d.b(r100, 4) == true) goto L8;
        Application r101 = eu5.b.f474075a;
        Toast.showFailureText(r101, r101.getString(R.string.Doc_Share_LoadFailed));
    }

    public a(ShareParams r100, ShareDocInfo r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "initState");
        this.f514071c = r100;
        this.f514072d = r101;
    }
}
