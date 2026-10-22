package tj0;

import android.graphics.Bitmap;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import io.reactivex.functions.Function;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class c<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.live.liveinteract.videotalk.avatarmix.d f546383a;

    public c(com.bytedance.android.live.liveinteract.videotalk.avatarmix.d r100) {
        this.f546383a = r100;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        Bitmap r101 = (Bitmap) r100;
        Intrinsics.checkNotNullParameter(r101, SimplayerImageStrategy.RESULT_BITMAP);
        return TuplesKt.to(this.f546383a, r101);
    }
}
