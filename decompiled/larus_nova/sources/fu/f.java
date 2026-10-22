package fu;

import android.graphics.drawable.Animatable;
import android.view.View;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.imagepipeline.image.ImageInfo;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import java.lang.ref.WeakReference;
import kotlin.Result;
import kotlin.ResultKt;

/* JADX INFO: loaded from: classes44.dex */
public final class f implements ControllerListener<ImageInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f478839a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f478840b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ d.a f478841c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f478842d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ View f478843e;

    @Override // com.facebook.drawee.controller.ControllerListener
    public final void onRelease(String r100) {
        d.a r101 = this.f478841c;
        if (r101 == null) goto L6;
        r101.onRelease(r100);
        return;
    }

    @Override // com.facebook.drawee.controller.ControllerListener
    public final void onFailure(String r110, Throwable r111) {
        long r100 = System.currentTimeMillis() - this.f478839a;
        LocalTestManager.a(new Class[]{uv.a.class});
        boolean r101 = d.f478832a;
        String r102 = this.f478842d;
        boolean r103 = this.f478840b;
        if (r111 == null) goto L5;
        String r104 = r111.getMessage();
    L6:
        d.f(r102, false, r100, r103, r104, null, 32);
        d.a r105 = this.f478841c;
        if (r105 == null) goto L10;
        r105.d(r110, r111, r100, this.f478840b);
        return;
    L10:
        return;
    L5:
        r104 = null;
        goto L6
    }

    @Override // com.facebook.drawee.controller.ControllerListener
    public final void onIntermediateImageFailed(String r100, Throwable r101) {
        d.a r102 = this.f478841c;
        if (r102 == null) goto L6;
        r102.onIntermediateImageFailed(r100, r101);
        return;
    }

    @Override // com.facebook.drawee.controller.ControllerListener
    public final void onIntermediateImageSet(String r100, ImageInfo r101) {
        ImageInfo r102 = r101;
        d.a r103 = this.f478841c;
        if (r103 == null) goto L6;
        r103.c(r100, r102);
        return;
    }

    @Override // com.facebook.drawee.controller.ControllerListener
    public final void onSubmit(String r100, Object r101) {
        this.f478839a = System.currentTimeMillis();
        LocalTestManager.a(new Class[]{uv.a.class});
        d.a r102 = this.f478841c;
        if (r102 == null) goto L6;
        r102.a(r100, r101, this.f478840b, this.f478842d);
        return;
    }

    @Override // com.facebook.drawee.controller.ControllerListener
    public final void onFinalImageSet(String r110, ImageInfo r111, Animatable r112) {
        ImageInfo r113 = r111;
        long r100 = System.currentTimeMillis() - this.f478839a;
        LocalTestManager.a(new Class[]{uv.a.class});
        boolean r101 = d.f478832a;
        String r102 = this.f478842d;
        View r103 = this.f478843e;
        if (r113 != null) goto L17;
    L13:
        boolean r104 = d.f478832a;
        d.f(this.f478842d, true, r100, this.f478840b, null, r113, 16);
        d.a r105 = this.f478841c;
        if (r105 == null) goto L19;
        r105.b(r110, r113, r112, r100, this.f478840b);
        return;
    L19:
        return;
    L17:
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L11
        View r107 = (View) new WeakReference(r103).get();     // Catch: Throwable -> L11
        if (r107 == null) goto L8;
        Boolean r108 = Boolean.valueOf(r107.post(new e(r107, r103, r113, r102)));     // Catch: Throwable -> L11
    L9:
        Result.m9449constructorimpl(r108);     // Catch: Throwable -> L11
        goto L13
    L8:
        r108 = null;
    L11:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L13
    }

    public f(boolean r100, g r101, String r102, View r103) {
        this.f478840b = r100;
        this.f478841c = r101;
        this.f478842d = r102;
        this.f478843e = r103;
    }
}
