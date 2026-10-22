package kh0;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class d implements c.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f503422a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ WeakReference f503423b;

    @Override // kh0.c.a
    public final void a(Sticker r100) {
        Intrinsics.checkNotNullParameter(r100, "sticker");
        Map<String, Sticker> r101 = c.f503421a;
        c.f503421a.put(this.f503422a, r100);
        r100.setDownloading(false);
        r100.setDownloaded(true);
        WeakReference r102 = this.f503423b;
        if (r102 == null) goto L7;
        c.a r103 = (c.a) r102.get();
        if (r103 == null) goto L7;
        r103.a(r100);
    L7:
        ALogger.i("CommonStickerManager", "#RevenueStickerDebug# download success for effectName: " + this.f503422a);
    }

    @Override // kh0.c.a
    public final void onError(Exception r100) {
        Intrinsics.checkNotNullParameter(r100, "e");
        WeakReference r101 = this.f503423b;
        if (r101 == null) goto L7;
        c.a r102 = (c.a) r101.get();
        if (r102 == null) goto L7;
        r102.onError(r100);
    L7:
        ALogger.w("CommonStickerManager", "#RevenueStickerDebug# download error for effectName: " + this.f503422a);
    }

    public d(String r100, WeakReference r101) {
        this.f503422a = r100;
        this.f503423b = r101;
    }
}
