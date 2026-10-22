package fu;

import android.util.Log;
import com.bytedance.android.gamecp.business.gamedetail.util.GameDetailImagePreloadUtil$preLoadGameDetailIcon$1;
import com.bytedance.android.gamecp.common.utils.e0;
import com.facebook.imagepipeline.listener.BaseRequestListener;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.Map;

/* JADX INFO: loaded from: classes44.dex */
public final class i extends BaseRequestListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j.c f478848a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Map f478849b;

    public i(GameDetailImagePreloadUtil$preLoadGameDetailIcon$1 r100, Map r101) {
        this.f478848a = r100;
        this.f478849b = r101;
    }

    @Override // com.facebook.imagepipeline.listener.BaseRequestListener, com.facebook.imagepipeline.listener.RequestListener
    public final void onRequestSuccess(ImageRequest r100, String r101, boolean r102) {
        super.onRequestSuccess(r100, r101, r102);
        this.f478848a.onResult(true, e0.e(this.f478849b));
    }

    @Override // com.facebook.imagepipeline.listener.BaseRequestListener, com.facebook.imagepipeline.listener.RequestListener
    public final void onRequestFailure(ImageRequest r100, String r101, Throwable r102, boolean r103) {
        super.onRequestFailure(r100, r101, r102, r103);
        this.f478849b.put("error_message", Log.getStackTraceString(r102));
        this.f478848a.onResult(false, e0.e(this.f478849b));
    }
}
