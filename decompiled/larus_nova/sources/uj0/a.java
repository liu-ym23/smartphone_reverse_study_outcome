package uj0;

import android.graphics.Bitmap;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.live.livelink.kmp.api.core.mixer.RTCWaterMarkRegion;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import ti6.e;
import ti6.f;

/* JADX INFO: loaded from: classes46.dex */
public final class a implements d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, RTCWaterMarkRegion> f550235b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<ei6.a> f550236c;

    @Override // uj0.d
    public final void init() {
        if (this.f550236c.invoke() == null) goto L6;
        ALogger.d("MicseatMixer", "BitmapRenderer init");
        return;
    }

    @Override // uj0.d
    public final void release() {
        ei6.a r100 = this.f550236c.invoke();
        if (r100 == null) goto L11;
        ALogger.d("MicseatMixer", "BitmapRenderer release");
        ti6.d r101 = r100.p();
        if (r101 == null) goto L9;
        e r102 = r101.f();
        if (r102 == null) goto L9;
        r102.n();
    L9:
        ((LinkedHashMap) this.f550235b).clear();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(Function0<? extends ei6.a> r100) {
        Intrinsics.checkNotNullParameter(r100, "getRtcClient");
        this.f550236c = r100;
        this.f550235b = new LinkedHashMap();
    }

    @Override // uj0.d
    public final void a(com.bytedance.android.live.liveinteract.videotalk.avatarmix.d r100) {
        Intrinsics.checkNotNullParameter(r100, "struct");
        ALogger.d("MicseatMixer", "BitmapRenderer clear " + r100);
        ei6.a r101 = this.f550236c.invoke();
        if (r101 == null) goto L11;
        d.f550256a.getClass();
        String r102 = d.a.a(r100);
        ti6.d r103 = r101.p();
        if (r103 == null) goto L9;
        e r104 = r103.f();
        if (r104 == null) goto L9;
        r104.k(r102);
    L9:
        this.f550235b.remove(r102);
        return;
    }

    @Override // uj0.d
    public final void b(com.bytedance.android.live.liveinteract.videotalk.avatarmix.d r100, Bitmap r101) {
        Intrinsics.checkNotNullParameter(r100, "struct");
        Intrinsics.checkNotNullParameter(r101, SimplayerImageStrategy.RESULT_BITMAP);
        if (r101.isRecycled() == false) goto L5;
        return;
    L5:
        if (r101.getWidth() > 0) goto L7;
        return;
    L7:
        if (r101.getHeight() <= 0) goto L35;
        ALogger.d("MicseatMixer", "BitmapRenderer render " + r100 + ", bitmap: " + r101);
        ei6.a r102 = this.f550236c.invoke();
        if (r102 == null) goto L32;
        d.f550256a.getClass();
        String r103 = d.a.a(r100);
        f r104 = r100.f79079e;
        Intrinsics.checkNotNullParameter(r104, EffectConfiguration.KEY_REGION);
        Intrinsics.checkNotNullParameter(r101, SimplayerImageStrategy.RESULT_BITMAP);
        RTCWaterMarkRegion r105 = new RTCWaterMarkRegion();
        r105.f255235a = (float) r104.f546162d;
        r105.f255237c = (float) r104.f546164f;
        r105.f255236b = (float) r104.f546163e;
        r105.f255238d = (float) r104.f546165g;
        r105.f255239e = 0;
        r105.f255242h = r101;
        RTCWaterMarkRegion.TranscoderImageRenderMode r106 = RTCWaterMarkRegion.TranscoderImageRenderMode.RENDER_HIDDEN;
        Intrinsics.checkNotNullParameter(r106, "<set-?>");
        r105.f255241g = r106;
        if (((LinkedHashMap) this.f550235b).get(r103) == null) goto L18;
        ti6.d r107 = r102.p();
        if (r107 == null) goto L24;
        e r108 = r107.f();
        if (r108 == null) goto L24;
        System.currentTimeMillis();
        r108.b(r103, r105);
    L24:
        ti6.d r109 = r102.p();
        if (r109 == null) goto L33;
        e r110 = r109.f();
        if (r110 == null) goto L34;
        r110.o();
        return;
    L34:
        return;
    L33:
        return;
    L18:
        ti6.d r111 = r102.p();
        if (r111 == null) goto L23;
        e r112 = r111.f();
        if (r112 == null) goto L23;
        System.currentTimeMillis();
        r112.a(r103, r105);
    L23:
        this.f550235b.put(r103, r105);
        goto L24
    L32:
        return;
    }
}
