package d76;

import android.graphics.Bitmap;
import com.bytedance.ies.xelement.alphavideo.LynxAlphaVideo;
import com.ss.android.ugc.aweme.live.alphaplayer.model.DataSource;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes19.dex */
public final class v implements LynxAlphaVideo.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<Bitmap> f467288a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LynxAlphaVideo f467289b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f467290c;

    @Override // com.bytedance.ies.xelement.alphavideo.LynxAlphaVideo.a
    public final void onFailed() {
        LynxAlphaVideo r100 = this.f467289b;
        DataSource r101 = r100.f249703c;
        if (r101 == null) goto L6;
        r101.f451130g = true;
    L6:
        r100.V("set video lastFrame failed, lastFrame is " + this.f467290c, this.f467289b.f249709i, -16);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ies.xelement.alphavideo.LynxAlphaVideo.a
    public final void onSuccess(Bitmap r100) {
        if (r100 == 0) goto L5;
        this.f467288a.element = r100;
        return;
    }

    public v(Ref.ObjectRef<Bitmap> r100, LynxAlphaVideo r101, String r102) {
        this.f467288a = r100;
        this.f467289b = r101;
        this.f467290c = r102;
    }
}
