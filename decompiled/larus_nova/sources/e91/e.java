package e91;

import android.graphics.Bitmap;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livehostapi.foundation.IHostFrescoHelper;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class e implements IHostFrescoHelper.GetBitmapCallBack {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f471440a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ImageView f471441b;

    @Override // com.bytedance.android.livehostapi.foundation.IHostFrescoHelper.GetBitmapCallBack
    public final void fail(IHostFrescoHelper.BitmapDataSource r100) {
        this.f471440a.f471423a = false;
    }

    @Override // com.bytedance.android.livehostapi.foundation.IHostFrescoHelper.GetBitmapCallBack
    public final void onNewResultImpl(Bitmap r100) {
        Intrinsics.checkNotNullParameter(r100, SimplayerImageStrategy.RESULT_BITMAP);
        this.f471440a.f471423a = false;
        if (r100.isRecycled() == false) goto L5;
        return;
    L5:
        ImageView r101 = this.f471441b;
        if (r101 == null) goto L8;
        ViewParent r102 = r101.getParent();
    L9:
        if (r102 == null) goto L20;
        f r103 = this.f471440a;
        ImageView r104 = this.f471441b;
        r103.getClass();
        if (r100.getHeight() > 0) goto L13;
    L18:
        this.f471441b.setImageBitmap(r100.copy(Bitmap.Config.ARGB_8888, false));
        this.f471440a.f471424b.onShow();
        return;
    L13:
        if (r100.getWidth() <= 0) goto L18;
        int r105 = UtilityKotlinExtentionsKt.i(8);
        int r106 = (r100.getWidth() / r100.getHeight()) * r105;
        if (r104 == null) goto L18;
        LinearLayout.LayoutParams r107 = new LinearLayout.LayoutParams(r106, r105);
        r107.gravity = 16;
        Unit r108 = Unit.INSTANCE;
        r104.setLayoutParams(r107);
        goto L18
    L20:
        return;
    L8:
        r102 = null;
        goto L9
    }

    public e(f r100, ImageView r101) {
        this.f471440a = r100;
        this.f471441b = r101;
    }
}
