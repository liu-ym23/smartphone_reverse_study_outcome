package fu;

import android.graphics.drawable.Animatable;
import com.facebook.imagepipeline.image.ImageInfo;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class g implements d.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f478844a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f478845b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ d.a f478846c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Map f478847d;

    @Override // fu.d.a
    public final void onRelease(String r100) {
        d.a r101 = this.f478846c;
        if (r101 == null) goto L6;
        r101.onRelease(r100);
        return;
    }

    @Override // fu.d.a
    public final void c(String r100, ImageInfo r101) {
        d.a r102 = this.f478846c;
        if (r102 == null) goto L6;
        r102.c(r100, r101);
        return;
    }

    @Override // fu.d.a
    public final void onIntermediateImageFailed(String r100, Throwable r101) {
        d.a r102 = this.f478846c;
        if (r102 == null) goto L6;
        r102.onIntermediateImageFailed(r100, r101);
        return;
    }

    public g(String r100, d.a r101, Map r102) {
        this.f478845b = r100;
        this.f478846c = r101;
        this.f478847d = r102;
        this.f478844a = "";
    }

    @Override // fu.d.a
    public final void a(String r100, Object r101, boolean r102, String r103) {
        Intrinsics.checkNotNullParameter(r103, "imageUrl");
        LocalTestManager.a(new Class[]{uv.a.class});
        this.f478844a = r103;
        d.a r104 = this.f478846c;
        if (r104 == null) goto L6;
        r104.a(r100, r101, r102, r103);
        return;
    }

    @Override // fu.d.a
    public final void d(String r110, Throwable r111, long r112, boolean r113) {
        LocalTestManager.a(new Class[]{uv.a.class});
        boolean r100 = d.f478832a;
        String r101 = this.f478845b;
        Map r102 = this.f478847d;
        if (r111 == null) goto L5;
        String r103 = r111.getMessage();
    L6:
        d.a(r101, false, r112, r113, r102, r103, this.f478844a);
        d.a r104 = this.f478846c;
        if (r104 == null) goto L10;
        r104.d(r110, r111, r112, r113);
        return;
    L10:
        return;
    L5:
        r103 = null;
        goto L6
    }

    @Override // fu.d.a
    public final void b(String r110, ImageInfo r111, Animatable r210, long r211, boolean r212) {
        LocalTestManager.a(new Class[]{uv.a.class});
        boolean r100 = d.f478832a;
        d.a(this.f478845b, true, r211, r212, this.f478847d, "", this.f478844a);
        d.a r112 = this.f478846c;
        if (r112 == null) goto L6;
        r112.b(r110, r111, r210, r211, r212);
        return;
    }
}
