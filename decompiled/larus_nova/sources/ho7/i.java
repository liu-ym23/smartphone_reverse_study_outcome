package ho7;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.bytedance.ug.sdk.share.api.entity.ShareContent;
import com.bytedance.ug.sdk.share.api.panel.ShareChannelType;
import java.lang.ref.WeakReference;
import java.util.Locale;
import oo7.p;

/* JADX INFO: loaded from: classes22.dex */
public final class i {
    public i() {
    }

    public final void b(ShareContent r110, co7.e r111) {
        if (r110 != null) goto L5;
        r111.a();
        return;
    L5:
        String r100 = r110.getVideoUrl();
        if (TextUtils.isEmpty(r100) == false) goto L9;
        r111.a();
        return;
    L9:
        eo7.a r101 = eo7.a.b.f473353a;
        Activity r102 = r101.h();
        if (r102 != null) goto L14;
        r111.a();
        return;
    L14:
        if (oo7.g.a(r100) == true) goto L17;
        a(r102, r110, r111);
        return;
    L17:
        Activity r112 = r101.h();
        if (TextUtils.isEmpty(r110.getVideoUrl()) == true) goto L31;
        if (r112 == null) goto L31;
        String r103 = r110.getVideoUrl();
        mn7.a r104 = r110.getDownloadProgressDialog();
        if (r104 != null) goto L26;
        r104 = r101.b(r112);
        if (r104 != null) goto L26;
        return;
    L26:
        WeakReference r105 = new WeakReference(r104);
        String r106 = oo7.f.f();
        if (TextUtils.isEmpty(r110.getVideoName()) == true) goto L29;
        String r107 = r110.getVideoName();
    L30:
        r104.a();
        jo7.c.a(new h(this, r110, r107, r106, r103, r105, r112, r111));
        return;
    L29:
        r107 = String.format(Locale.getDefault(), "%d.mp4", new Object[]{Integer.valueOf(oo7.h.a(r103, r106))});
    L31:
        r111.a();
    }

    public static void a(Activity r100, ShareContent r101, co7.e r102) {
        if (r101 != null) goto L4;
        return;
    L4:
        if (r102 != null) goto L6;
        String r103 = ShareChannelType.getSharePackageName(r101.getShareChanelType());
        Intent r104 = r100.getPackageManager().getLaunchIntentForPackage(r103);
        if (r104 == null) goto L12;
        p.c(r100, r104);
    L12:
        kn7.b.a(10000, r101);
        return;
    L6:
        if (TextUtils.isEmpty(r101.getVideoUrl()) == true) goto L8;
        r102.b(r101.getVideoUrl());
        return;
    L8:
        r102.a();
    }
}
