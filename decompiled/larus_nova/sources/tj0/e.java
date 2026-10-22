package tj0;

import android.graphics.Bitmap;
import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class e<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f546385a;

    public e(g r100) {
        this.f546385a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Pair r101 = (Pair) r100;
        com.bytedance.android.live.liveinteract.videotalk.avatarmix.d r102 = (com.bytedance.android.live.liveinteract.videotalk.avatarmix.d) r101.component1();
        Bitmap r103 = (Bitmap) r101.component2();
        ALogger.d("MicseatMixer", "get bitmap success, struct: " + r102);
        com.bytedance.android.live.liveinteract.videotalk.avatarmix.bitmap.a r104 = this.f546385a.f546389c;
        if (r104 == null) goto L5;
        Intrinsics.checkNotNullParameter(r102, "struct");
        Intrinsics.checkNotNullParameter(r103, "cache");
        ConcurrentHashMap<String, Pair<String, Bitmap>> r105 = r104.f79072a;
        int r106 = com.bytedance.android.live.liveinteract.videotalk.avatarmix.bitmap.a.f79071b;
        r105.put(com.bytedance.android.live.liveinteract.videotalk.avatarmix.bitmap.a.C1233a.a(r102), TuplesKt.to(r102.f79077c, r103));
    L5:
        this.f546385a.f546392f.b(r102, r103.copy(Bitmap.Config.ARGB_8888, false));
    }
}
