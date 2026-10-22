package ra2;

import android.graphics.drawable.Animatable;
import com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.match.ui.MatchHotMsgView;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.imagepipeline.image.ImageInfo;
import com.lynx.tasm.LynxError;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class q extends BaseControllerListener<ImageInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MatchHotMsgView f536829a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f536830b;

    public q(MatchHotMsgView r100, int r101) {
        this.f536829a = r100;
        this.f536830b = r101;
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void onFailure(String r100, Throwable r101) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, LynxError.LYNX_THROWABLE);
        int r102 = this.f536830b;
        if (r102 != 0) goto L6;
        com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.match.utils.a.b("MatchHotMsgView icon webp image load failed. exception is " + r101.getMessage());
    L8:
        pa2.a r103 = this.f536829a.f140126h;
        if (r103 == null) goto L12;
        r103.a();
        return;
    L12:
        return;
    L6:
        if (r102 != 1) goto L8;
        com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.match.utils.a.b("MatchHotMsgView bg spread webp image load failed. exception is " + r101.getMessage());
        goto L8
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void onFinalImageSet(String r100, Object r101, Animatable r102) {
        ImageInfo r103 = (ImageInfo) r101;
        Intrinsics.checkNotNullParameter(r100, "id");
        int r104 = this.f536830b;
        if (r104 != 0) goto L5;
        com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.match.utils.a.a("MatchHotMsgView icon webp image load SUCCESS.");
    L7:
        MatchHotMsgView r105 = this.f536829a;
        r105.setImgLoadCount(r105.getImgLoadCount() + 1);
        if (this.f536829a.getImgLoadCount() != 2) goto L13;
        pa2.a r106 = this.f536829a.f140126h;
        if (r106 == null) goto L14;
        r106.b();
        return;
    L14:
        return;
    L13:
        return;
    L5:
        if (r104 != 1) goto L7;
        com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.match.utils.a.a("MatchHotMsgView bg spread webp image load SUCCESS.");
        goto L7
    }
}
