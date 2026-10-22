package d1a;

import android.graphics.drawable.Animatable;
import com.facebook.drawee.controller.BaseControllerListener;

/* JADX INFO: loaded from: classes31.dex */
public final class d extends BaseControllerListener<Object> {
    public d() {
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void onFailure(String r100, Throwable r101) {
        w0a.a.c("CreationSelfPrivateViewHolder", "cover image failed");
        super.onFailure(r100, r101);
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void onSubmit(String r100, Object r101) {
        w0a.a.c("CreationSelfPrivateViewHolder", "cover image submit");
        super.onSubmit(r100, r101);
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void onFinalImageSet(String r100, Object r101, Animatable r102) {
        super.onFinalImageSet(r100, r101, r102);
        w0a.a.c("CreationSelfPrivateViewHolder", "cover image set");
    }
}
