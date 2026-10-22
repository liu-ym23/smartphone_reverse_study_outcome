package kmc;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import vlc.g;

/* JADX INFO: loaded from: classes36.dex */
public final class d implements vlc.c, g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ vlc.c f504131a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ g f504132b;

    @Override // vlc.c
    public final boolean a() {
        return this.f504131a.a();
    }

    @Override // vlc.g
    public final void b(String r100, Throwable r101) {
        this.f504132b.b(r100, r101);
    }

    @Override // vlc.g
    public final void d(long r100, JSONObject r101, JSONObject r110, JSONObject r111) {
        this.f504132b.d(r100, r101, r110, r111);
    }

    @Override // vlc.g
    public final void e(String r100, JSONObject r101, JSONObject r102, JSONObject r103) {
        this.f504132b.e(r100, r101, r102, r103);
    }

    @Override // vlc.c
    public final void log(String r100, String r101) {
        this.f504131a.log(r100, r101);
    }

    public d(vlc.c r100, g r101) {
        Intrinsics.checkNotNullParameter(r100, "logger");
        Intrinsics.checkNotNullParameter(r101, "monitor");
        this.f504131a = r100;
        this.f504132b = r101;
    }
}
