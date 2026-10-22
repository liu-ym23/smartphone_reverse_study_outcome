package f88;

import com.larus.platform.api.o0;
import com.larus.utils.logger.FLogger;
import com.ss.ttvideoengine.VideoEngineInfos;
import kotlin.jvm.internal.Intrinsics;
import tx9.i1;

/* JADX INFO: loaded from: classes24.dex */
public final class p implements o0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.larus.audioplayer.impl.news.b f475915a;

    public p(com.larus.audioplayer.impl.news.b r100) {
        this.f475915a = r100;
    }

    @Override // com.larus.platform.api.o0
    public final void a(yq9.e r110) {
        Intrinsics.checkNotNullParameter(r110, "info");
        if (Intrinsics.areEqual(r110.f568873a, VideoEngineInfos.USING_MDL_HIT_CACHE_SIZE) == false) goto L10;
        FLogger.f375446a.i("UrlAudioPlayer", "url media hit cache info: " + r110);
        com.larus.audioplayer.impl.news.b r100 = this.f475915a;
        if (r110.f568876d <= 0) goto L7;
        boolean r101 = true;
    L8:
        r100.f290348u = r101;
        String r102 = r100.a();
        com.larus.audioplayer.impl.news.b r103 = this.f475915a;
        i1.k(r102, r103.f290328a, r103.f290348u, r110.f568876d, r103.f290332e, 32);
        return;
    L7:
        r101 = false;
        goto L8
    }
}
