package n79;

import android.widget.ImageView;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.image.ImageInfo;
import com.larus.drive.biz.impl.search.kmp.KmpRecentDriveCell;
import com.larus.utils.e1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class h extends BaseControllerListener<ImageInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ KmpRecentDriveCell f518214a;

    public h(KmpRecentDriveCell r100) {
        this.f518214a = r100;
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void onFailure(String r100, Throwable r101) {
        SimpleDraweeView r102 = this.f518214a.f341240c;
        ImageView r103 = null;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("thumbnailView");
        r102 = null;
    L5:
        e1.q(r102);
        ImageView r104 = this.f518214a.f341239b;
        if (r104 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("iconView");
    L9:
        e1.x(r103);
        return;
    L8:
        r103 = r104;
        goto L9
    }
}
