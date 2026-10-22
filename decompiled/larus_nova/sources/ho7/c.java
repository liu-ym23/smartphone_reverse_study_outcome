package ho7;

import android.graphics.Bitmap;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import java.io.File;
import oo7.j;
import oo7.k;

/* JADX INFO: loaded from: classes22.dex */
public final class c implements in7.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ co7.b f486236a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f486237b;

    @Override // in7.a
    public final void onFailed() {
        j.a();
        co7.b r100 = this.f486236a;
        if (r100 == null) goto L6;
        r100.a();
        return;
    }

    @Override // in7.a
    public final void onSuccess(Bitmap r100) {
        j.a();
        if (r100 != null) goto L5;
    L23:
        co7.b r101 = this.f486236a;
        if (r101 == null) goto L30;
        r101.a();
        return;
    L30:
        return;
    L5:
        if (r100.isRecycled() == true) goto L23;
        String r102 = "share_image_" + System.currentTimeMillis() + ".jpeg";
        if (this.f486237b == false) goto L10;
        String r103 = oo7.f.e();
    L11:
        boolean r104 = oo7.f.h(r100, r103, r102);
        k.e("ImageShareHelper", "saveImage saveBits = " + r104 + " , dir = " + r103 + " , path = " + r102);
        if (r104 == true) goto L14;
        co7.b r105 = this.f486236a;
        if (r105 == null) goto L29;
        r105.a();
        return;
    L29:
        return;
    L14:
        if (this.f486237b == false) goto L16;
        oo7.f.j(com.bytedance.ug.sdk.share.impl.manager.h.g.f272345a.f272326a, r103 + HTTP.URL_DEFAULT + r102, true);
    L16:
        co7.b r106 = this.f486236a;
        if (r106 == null) goto L27;
        r106.b(r103 + File.separator + r102);
        return;
    L27:
        return;
    L10:
        r103 = oo7.f.f();
        goto L11
    }

    public c(co7.b r100, boolean r101) {
        this.f486236a = r100;
        this.f486237b = r101;
    }
}
