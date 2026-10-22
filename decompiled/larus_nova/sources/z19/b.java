package z19;

import android.graphics.drawable.Animatable;
import com.facebook.drawee.controller.BaseControllerListener;
import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: classes27.dex */
public final class b extends BaseControllerListener<Object> {
    public b() {
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void onFailure(String r100, Throwable r101) {
        super.onFailure(r100, r101);
        FLogger.f375446a.e("AvatarTagView", "[setupAvatarTag] onFailure, e:" + r101);
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void onFinalImageSet(String r100, Object r101, Animatable r102) {
        super.onFinalImageSet(r100, r101, r102);
        FLogger.f375446a.i("AvatarTagView", "[setupAvatarTag] onFinalImageSet");
    }
}
