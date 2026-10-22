package e91;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livehostapi.foundation.IHostFrescoHelper;
import py.k;

/* JADX INFO: loaded from: classes47.dex */
public final class g implements IHostFrescoHelper.GetBitmapCallBack {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f471443a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ k f471444b;

    @Override // com.bytedance.android.livehostapi.foundation.IHostFrescoHelper.GetBitmapCallBack
    public final void fail(IHostFrescoHelper.BitmapDataSource r100) {
        this.f471443a.f471423a = false;
        ALogger.e("room_cert", "render cert UI failed：the image download fail");
    }

    @Override // com.bytedance.android.livehostapi.foundation.IHostFrescoHelper.GetBitmapCallBack
    public final void onNewResultImpl(Bitmap r100) {
        this.f471443a.f471423a = false;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isRecycled() == true) goto L16;
        ImageView r101 = this.f471443a.f471445c;
        if (r101 != null) goto L10;
        return;
    L10:
        if (r101.getParent() == null) goto L15;
        this.f471443a.f471424b.b(r100, r101, this.f471444b);
        r101.setImageBitmap(r100.copy(Bitmap.Config.ARGB_8888, false));
        this.f471443a.f471424b.onShow();
        return;
    L15:
        return;
    }

    public g(h r100, k r101) {
        this.f471443a = r100;
        this.f471444b = r101;
    }
}
