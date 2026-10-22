package z19;

import android.graphics.drawable.Animatable;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.imagepipeline.image.ImageInfo;
import com.larus.common_ui.widget.CircleSimpleDraweeView;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes27.dex */
public final class h extends BaseControllerListener<ImageInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k f569696a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.BooleanRef f569697b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ CircleSimpleDraweeView f569698c;

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void onFailure(String r100, Throwable r101) {
        this.f569698c.setCurrentUrl("");
        k r102 = this.f569696a;
        if (r102 == null) goto L6;
        r102.onFailure(r101);
        return;
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void onSubmit(String r100, Object r101) {
        super.onSubmit(r100, r101);
        k r102 = this.f569696a;
        if (r102 == null) goto L6;
        r102.b();
        return;
    }

    public h(k r100, Ref.BooleanRef r101, CircleSimpleDraweeView r102) {
        this.f569696a = r100;
        this.f569697b = r101;
        this.f569698c = r102;
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void onFinalImageSet(String r100, Object r101, Animatable r102) {
        super.onFinalImageSet(r100, (ImageInfo) r101, r102);
        k r103 = this.f569696a;
        if (r103 == null) goto L6;
        r103.a(this.f569697b.element);
        return;
    }
}
