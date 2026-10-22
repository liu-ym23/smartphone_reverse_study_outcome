package uj0;

import android.graphics.Bitmap;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.disposables.Disposable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class c<T> implements SingleOnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f550253a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.live.liveinteract.videotalk.avatarmix.d f550254b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Bitmap f550255c;

    public c(b r100, com.bytedance.android.live.liveinteract.videotalk.avatarmix.d r101, Bitmap r102) {
        this.f550253a = r100;
        this.f550254b = r101;
        this.f550255c = r102;
    }

    @Override // io.reactivex.SingleOnSubscribe
    public final void subscribe(SingleEmitter<b.a> r100) {
        Intrinsics.checkNotNullParameter(r100, "emitter");
        d.a r101 = d.f550256a;
        com.bytedance.android.live.liveinteract.videotalk.avatarmix.d r102 = this.f550254b;
        r101.getClass();
        String r103 = d.a.a(r102);
        Map<String, b.a> r104 = this.f550253a.f550238c;
        int r105 = com.bytedance.android.live.liveinteract.videotalk.avatarmix.bitmap.a.f79071b;
        LinkedHashMap r106 = (LinkedHashMap) r104;
        b.a r107 = (b.a) r106.get(com.bytedance.android.live.liveinteract.videotalk.avatarmix.bitmap.a.C1233a.a(this.f550254b));
        if (r107 == null) goto L6;
        r107.getClass();
    L6:
        if (this.f550255c != null) goto L9;
        r100.onError(new Throwable("bitmap is null"));
        return;
    L9:
        Disposable r108 = (Disposable) ((LinkedHashMap) this.f550253a.f550237b).get(r103);
        if (r108 == null) goto L12;
        r108.dispose();
    L12:
        this.f550253a.getClass();
    }
}
