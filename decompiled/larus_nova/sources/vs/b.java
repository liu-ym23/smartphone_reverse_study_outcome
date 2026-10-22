package vs;

import android.graphics.Bitmap;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.image.ImageInfo;

/* JADX INFO: loaded from: classes44.dex */
public final class b extends BaseControllerListener<ImageInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e.a f556965a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DataSource f556966b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ImageView f556967c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Drawable f556968d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ d f556969e;

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void onFailure(String r100, Throwable r101) {
        Drawable r102 = this.f556968d;
        if (r102 == null) goto L5;
        this.f556967c.setImageDrawable(r102);
        this.f556967c.setScaleType(ImageView.ScaleType.FIT_CENTER);
    L5:
        e.a r103 = this.f556965a;
        if (r103 == null) goto L9;
        ((com.bytedance.android.gamecp.business.gallery.transfer.c.a) r103).a(0);
        return;
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void onSubmit(String r100, Object r101) {
        e.a r102 = this.f556965a;
        if (r102 == null) goto L8;
        com.bytedance.android.gamecp.business.gallery.transfer.c.a r103 = (com.bytedance.android.gamecp.business.gallery.transfer.c.a) r102;
        ys.a r104 = r103.f53240a;
        int r105 = r103.f53241b;
        View r106 = r104.f568984a.get(r105);
        if (r106 == null) goto L9;
        r106.setVisibility(0);
        return;
    L9:
        return;
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void onFinalImageSet(String r100, Object r101, Animatable r102) {
        ImageInfo r103 = (ImageInfo) r101;
        CloseableReference r104 = (CloseableReference) this.f556966b.getResult();     // Catch: Throwable -> L17
        if (r104 != null) goto L21;
    L13:
        this.f556966b.close();
        CloseableReference.closeSafely(r104);
        e.a r105 = this.f556965a;
        if (r105 == null) goto L25;
        ((com.bytedance.android.gamecp.business.gallery.transfer.c.a) r105).a(1);
        return;
    L25:
        return;
    L21:
        CloseableImage r106 = (CloseableImage) r104.get();     // Catch: Throwable -> L11
        if ((r106 instanceof CloseableStaticBitmap) == false) goto L13;
        Bitmap r107 = ((CloseableStaticBitmap) r106).getUnderlyingBitmap();     // Catch: Throwable -> L11
        if (r107 == null) goto L13;
        ImageView r108 = this.f556967c;     // Catch: Throwable -> L11
        this.f556969e.getClass();     // Catch: Throwable -> L11
        r108.setImageBitmap(d.d(r107));     // Catch: Throwable -> L11
        this.f556967c.setScaleType(ImageView.ScaleType.FIT_CENTER);     // Catch: Throwable -> L11
    L11:
        Throwable th10 = th;
    L19:
        this.f556966b.close();
        CloseableReference.closeSafely(r104);
        throw th10;
    L17:
        th = move-exception;
        th10 = th;
        r104 = null;
        goto L19
    }

    public b(d r100, com.bytedance.android.gamecp.business.gallery.transfer.c.a r101, DataSource r102, ImageView r103, Drawable r104) {
        this.f556969e = r100;
        this.f556965a = r101;
        this.f556966b = r102;
        this.f556967c = r103;
        this.f556968d = r104;
    }
}
