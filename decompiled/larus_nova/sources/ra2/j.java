package ra2;

import android.graphics.drawable.Animatable;
import com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.match.ui.GroupMsgView;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.imagepipeline.image.ImageInfo;
import com.lynx.tasm.LynxError;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class j extends BaseControllerListener<ImageInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GroupMsgView f536823a;

    public j(GroupMsgView r100) {
        this.f536823a = r100;
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void onFailure(String r100, Throwable r101) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, LynxError.LYNX_THROWABLE);
        com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.match.utils.a.b("GroupMsgView image load FAILED. icon webp load failed. That's all. exception is " + r101.getMessage());
        GroupMsgView r102 = this.f536823a;
        r102.G = Boolean.FALSE;
        qa2.l r103 = r102.f140091l;
        if (r103 == null) goto L6;
        r103.a();
        return;
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void onFinalImageSet(String r100, Object r101, Animatable r102) {
        ImageInfo r103 = (ImageInfo) r101;
        Intrinsics.checkNotNullParameter(r100, "id");
        com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.match.utils.a.a("GroupMsgView icon webp image load SUCCESS.");
        GroupMsgView.a(this.f536823a);
    }
}
