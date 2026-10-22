package p2a;

import com.larus.im.bean.bot.SpeakerVoice;
import kotlin.jvm.internal.Intrinsics;
import ouc.d0;

/* JADX INFO: loaded from: classes32.dex */
public final class z implements h {

    public static final class a implements p2a.a {
        public a() {
        }

        @Override // p2a.a
        public final boolean a() {
            return false;
        }

        @Override // p2a.a
        public final boolean b(String r100) {
            return false;
        }

        @Override // p2a.a
        public final boolean d(String r100) {
            return false;
        }

        @Override // p2a.a
        public final boolean e() {
            return false;
        }

        @Override // p2a.a
        public final p c() {
            return new p(0);
        }
    }

    public static final class b implements v2a.b {
        public b() {
        }

        @Override // v2a.b
        public final void a(w2a.f r100, String r101, String r102, String r103, SpeakerVoice r104, String r105) {
            Intrinsics.checkNotNullParameter(r101, "previousPage");
            Intrinsics.checkNotNullParameter(r103, "scene");
        }
    }

    public static final class c implements d {
        public c() {
        }

        @Override // p2a.d
        public final void a(SpeakerVoice r100, String r101, boolean r102, String r103, String r104, String r105, String r106, String r110, String r111, String r112, Float r113, Float r114, Integer r115, String r116, String r117, String r118, String r119, String r210, String r211, String r212, String r213, d0 r214) {
            Intrinsics.checkNotNullParameter(r214, "params");
        }
    }

    public z() {
    }

    @Override // p2a.h
    public final void G(d0 r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
    }

    @Override // p2a.h
    public final void T0(d0 r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
    }

    @Override // p2a.h
    public final void X2(d0 r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
    }

    @Override // p2a.h
    public final d a3() {
        return new c();
    }

    @Override // p2a.h
    public final v2a.b f7() {
        return new b();
    }

    @Override // p2a.h
    public final p2a.a l2() {
        return new a();
    }
}
