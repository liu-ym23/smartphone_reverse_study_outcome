package tk0;

import com.bytedance.android.live.pushstream.d;
import com.bytedance.android.live.pushstream.model.LiveRequestSourceRole;
import kotlin.jvm.internal.Intrinsics;
import uf2.d0;

/* JADX INFO: loaded from: classes46.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f546466a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d0 f546467b;

    public final boolean a() {
        return this.f546466a.t0();
    }

    public final boolean b() {
        return this.f546466a.N();
    }

    public final void e() {
        this.f546466a.getLiveCore().h();
    }

    public final void f(String r100) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        this.f546466a.M0(r100, new uv0.a(LiveRequestSourceRole.Business, "AndroidAudioCaptureApi.startAudioCapture", null));
    }

    public final void g(String r100) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        this.f546466a.f1(r100, new uv0.a(LiveRequestSourceRole.Business, "AndroidAudioCaptureApi.stopAudioCapture", null));
    }

    public a(d r100, d0 r101) {
        Intrinsics.checkNotNullParameter(r100, "liveStream");
        Intrinsics.checkNotNullParameter(r101, "liveCore");
        this.f546466a = r100;
        this.f546467b = r101;
    }

    public final void c(boolean r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "reason");
        this.f546466a.Q0(r100, r101, new uv0.a(LiveRequestSourceRole.Business, "AndroidAudioCaptureApi.setAudioMute", null));
    }

    public final void d(boolean r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "reason");
        this.f546466a.R0(r100, r101, new uv0.a(LiveRequestSourceRole.Business, "AndroidAudioCaptureApi.setAudioMuteRaw", null));
    }
}
