package ho7;

import android.app.Activity;
import android.text.TextUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.ug.sdk.share.api.entity.ShareContent;
import com.larus.nova.R;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Locale;
import oo7.o;

/* JADX INFO: loaded from: classes22.dex */
public final class e implements in7.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Activity f486238a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ShareContent f486239b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ g f486240c;

    @Override // in7.g
    public final void onDenied() {
        o.a(this.f486238a, this.f486239b, 7, R.string.share_sdk_video_share_save_failed);
    }

    @Override // in7.g
    public final void onGranted() {
        g r100 = this.f486240c;
        Activity r101 = this.f486238a;
        ShareContent r102 = this.f486239b;
        r100.getClass();
        if (r101 == null) goto L25;
        if (r102 != null) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r102.getVideoUrl()) == true) goto L28;
        String r103 = r102.getVideoUrl();
        mn7.a r104 = r102.getDownloadProgressDialog();
        if (r104 != null) goto L13;
        r104 = eo7.a.b.f473353a.b(r101);
        if (r104 != null) goto L13;
        return;
    L13:
        WeakReference r105 = new WeakReference(r104);
        String r106 = oo7.f.e();
        if (TextUtils.isEmpty(r106) == false) goto L17;
        return;
    L17:
        if (TextUtils.isEmpty(r102.getVideoName()) == true) goto L19;
        String r107 = r102.getVideoName();
    L20:
        String r108 = r106 + File.separator + r107;
        if (new PolarisFileWrapper(r108).exists() == false) goto L23;
        oo7.f.j(r101, r108, false);
        bo7.a.C0322a.f19870a.b(r107, false);
        r102.setVideoUrl(r108);
        g.a(r101, r102);
        return;
    L23:
        r104.a();
        eo7.a r109 = eo7.a.b.f473353a;
        jo7.c.a(new f(r100, r102, r107, r106, r103, r105, r101, r108));
        return;
    L19:
        r107 = String.format(Locale.getDefault(), "%d.mp4", new Object[]{Integer.valueOf(oo7.h.a(r103, r106))});
        goto L20
    L28:
        return;
    }

    public e(g r100, Activity r101, ShareContent r102) {
        this.f486240c = r100;
        this.f486238a = r101;
        this.f486239b = r102;
    }
}
