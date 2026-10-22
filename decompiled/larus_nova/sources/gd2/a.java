package gd2;

import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type.LiveWrappedNetworkDetectionLinkType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public abstract class a implements e {
    public a() {
    }

    @Override // gd2.e
    public void a(String r100) {
    }

    @Override // gd2.e
    public void b(String r100) {
    }

    @Override // gd2.e
    public final void c() {
    }

    @Override // gd2.e
    public final void e() {
    }

    @Override // gd2.e
    public void f(String r100) {
    }

    @Override // gd2.e
    public void g(String r100, Boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "interactId");
    }

    @Override // gd2.e
    public final void h() {
    }

    @Override // gd2.e
    public void k1() {
    }

    @Override // gd2.e
    public final void onUserJoined(String r100) {
        Intrinsics.checkNotNullParameter(r100, "s");
    }

    @Override // gd2.e
    public void Z4(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "interactId");
        Intrinsics.checkNotNullParameter(r100, "interactId");
    }

    @Override // gd2.e
    public void d5(dg2.e r100, dg2.e[] r101) {
        Intrinsics.checkNotNullParameter(r100, "localQuality");
        Intrinsics.checkNotNullParameter(r101, "remoteQualities");
        Intrinsics.checkNotNullParameter(r100, "localQuality");
        Intrinsics.checkNotNullParameter(r101, "remoteQualities");
    }

    @Override // gd2.e
    public void x1(LiveWrappedNetworkDetectionLinkType r100, int r101, double r102) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r100, "type");
    }
}
