package vp9;

import android.graphics.drawable.Animatable;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.imagepipeline.image.ImageInfo;
import com.larus.photopicker.v2.impl.e0;
import com.larus.photopicker.v2.impl.ui.ClickType;
import com.larus.photopicker.v2.impl.ui.MediaViewHolder;

/* JADX INFO: loaded from: classes31.dex */
public final class y extends BaseControllerListener<ImageInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f556705a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MediaViewHolder f556706b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ op9.d f556707c;

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void onFailure(String r100, Throwable r101) {
        int r102 = e0.f364440a;
        e0.c(this.f556706b.f364669d, "onFailure: " + r100 + ", " + r101);
        int r103 = this.f556705a;
        if (r103 != 0) goto L6;
        this.f556706b.f364668c.invoke(this.f556707c, Integer.valueOf(r103), ClickType.ON_FIRST_IMAGE_LOAD_FAILURE);
        return;
    }

    public y(int r100, MediaViewHolder r101, op9.d r102) {
        this.f556705a = r100;
        this.f556706b = r101;
        this.f556707c = r102;
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void onFinalImageSet(String r100, Object r101, Animatable r102) {
        ImageInfo r103 = (ImageInfo) r101;
        int r104 = this.f556705a;
        if (r104 != 0) goto L6;
        this.f556706b.f364668c.invoke(this.f556707c, Integer.valueOf(r104), ClickType.ON_FIRST_IMAGE_LOAD_SUCCESS);
        return;
    }
}
