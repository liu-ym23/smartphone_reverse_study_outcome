package u07;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import com.facebook.drawee.drawable.BlurHashBitmapDrawable;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.imagepipeline.request.ImageRequest;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes21.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Bitmap f548158a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f548159b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ImageRequest f548160c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ GenericDraweeHierarchy f548161d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Drawable f548162e;

    @Override // java.lang.Runnable
    public final void run() {
        Bitmap r100 = this.f548158a;     // Catch: Throwable -> L8
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isRecycled() == true) goto L15;
        long r101 = SystemClock.uptimeMillis();     // Catch: Throwable -> L8
        long r102 = r101 - this.f548159b;     // Catch: Throwable -> L8
        this.f548160c.setPreviewDecodeTime(r102);     // Catch: Throwable -> L8
        this.f548160c.setPreviewDecodeEnd(r101);     // Catch: Throwable -> L8
        this.f548161d.setPlaceholderImage(this.f548162e, ScalingUtils.ScaleType.FIT_XY);     // Catch: Throwable -> L8
        return;
    L15:
        return;
    L8:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L16;
        throw th;
    }

    public b(Bitmap r100, long r101, ImageRequest r102, GenericDraweeHierarchy r103, BlurHashBitmapDrawable r104) {
        this.f548158a = r100;
        this.f548159b = r101;
        this.f548160c = r102;
        this.f548161d = r103;
        this.f548162e = r104;
    }
}
