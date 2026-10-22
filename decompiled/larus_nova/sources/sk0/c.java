package sk0;

import com.bytedance.android.live.livelink.platformapi.avclient.video.AndroidVideoStreamApi;
import com.bytedance.android.live.pushstream.d;
import com.google.gson.JsonElement;
import fr2.u;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import uf2.d0;
import uf2.h0;

/* JADX INFO: loaded from: classes46.dex */
public final class c implements ec6.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d0 f542318a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final sk0.a f542319b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final tk0.a f542320c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.bytedance.android.live.livelink.platformapi.avclient.video.a f542321d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AndroidVideoStreamApi f542322e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final uk0.a f542323f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final HashMap<u, h0.c> f542324g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final HashMap<u, h0.b> f542325h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final d f542326i;

    public static final class a implements h0.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ u f542327a;

        public a(u r100) {
            this.f542327a = r100;
        }
    }

    public static final class b implements h0.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ u f542328a;

        public b(u r100) {
            this.f542328a = r100;
        }
    }

    @Override // ec6.b
    public final void b() {
        this.f542326i.f0(false);
    }

    public final void j() {
        this.f542326i.O(true);
    }

    public final void g() {
        this.f542326i.release();
    }

    public final void i() {
        this.f542326i.getLiveCore().resume();
    }

    public final void k() {
        this.f542326i.s();
    }

    public final void l() {
        this.f542326i.getLiveCore().stop();
    }

    @Override // ec6.b
    public final sk0.a c() {
        return this.f542319b;
    }

    @Override // ec6.b
    public final uk0.a d() {
        return this.f542323f;
    }

    @Override // ec6.b
    public final com.bytedance.android.live.livelink.platformapi.avclient.video.a e() {
        return this.f542321d;
    }

    public c(d r100) {
        Intrinsics.checkNotNullParameter(r100, "liveStream");
        this.f542326i = r100;
        d0 r101 = r100.getLiveCore();
        this.f542318a = r101;
        this.f542319b = new sk0.a(r100, r101);
        this.f542320c = new tk0.a(r100, r101);
        this.f542321d = new com.bytedance.android.live.livelink.platformapi.avclient.video.a(r100, r101);
        Intrinsics.checkNotNullParameter(r100, "liveStream");
        Intrinsics.checkNotNullParameter(r101, "liveCore");
        this.f542322e = new AndroidVideoStreamApi(r100);
        this.f542323f = new uk0.a(r100);
        this.f542324g = new HashMap();
        this.f542325h = new HashMap();
    }

    public final void a(u r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        b r101 = new b(r100);
        a r102 = new a(r100);
        this.f542324g.put(r100, r101);
        this.f542325h.put(r100, r102);
        this.f542326i.I0(r101);
        this.f542326i.D0(r102);
    }

    public final void h(u r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        h0.c r101 = this.f542324g.get(r100);
        h0.b r102 = this.f542325h.get(r100);
        this.f542326i.h1(r101);
        this.f542326i.e1(r102);
        this.f542324g.remove(r100);
        this.f542325h.remove(r100);
    }

    public final int f(String r100, JsonElement r101, int r102, boolean r110, boolean r111) {
        return this.f542326i.c1(r100, r101, r102, r110, r111);
    }
}
