package ui4;

import android.graphics.drawable.Animatable;
import android.net.Uri;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.imagepipeline.image.ImageInfo;

/* JADX INFO: loaded from: classes15.dex */
public final class x extends BaseControllerListener<ImageInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ w.a f550201a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f550202b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ki4.r f550203c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Uri f550204d;

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void onFailure(String r100, Throwable r101) {
        a r102 = this.f550201a.f550197c;
        if (r102 == null) goto L6;
        r102.v0(r100, r101, this.f550202b);
        return;
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void onFinalImageSet(String r100, Object r110, Animatable r111) {
        ImageInfo r101 = (ImageInfo) r110;
        a r102 = this.f550201a.f550197c;
        if (r102 == null) goto L6;
        r102.L1(r100, r101, r111, this.f550202b, this.f550203c.getDate(), this.f550204d.toString());
        return;
    }

    public x(w.a r100, int r101, ki4.r r102, Uri r103) {
        this.f550201a = r100;
        this.f550202b = r101;
        this.f550203c = r102;
        this.f550204d = r103;
    }
}
