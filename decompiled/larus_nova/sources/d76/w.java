package d76;

import android.graphics.Bitmap;
import com.bytedance.ies.xelement.alphavideo.LynxAlphaVideo;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes19.dex */
public final class w implements LynxAlphaVideo.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<Bitmap> f467291a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LynxAlphaVideo f467292b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f467293c;

    @Override // com.bytedance.ies.xelement.alphavideo.LynxAlphaVideo.a
    public final void onFailed() {
        this.f467292b.V("set video poster failed, poster is " + this.f467293c, this.f467292b.f249709i, -15);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ies.xelement.alphavideo.LynxAlphaVideo.a
    public final void onSuccess(Bitmap r100) {
        if (r100 == 0) goto L5;
        this.f467291a.element = r100;
        return;
    }

    public w(Ref.ObjectRef<Bitmap> r100, LynxAlphaVideo r101, String r102) {
        this.f467291a = r100;
        this.f467292b = r101;
        this.f467293c = r102;
    }
}
