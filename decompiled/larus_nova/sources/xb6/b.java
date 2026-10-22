package xb6;

import com.bytedance.android.livesdk.link.model.bridge.h1;
import com.bytedance.android.livesdk.link.model.bridge.z0;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public interface b {

    public static final class a {
        public static Pair a() {
            return TuplesKt.to(Boolean.FALSE, "");
        }

        public static Pair b() {
            return TuplesKt.to(Boolean.FALSE, "");
        }

        public static Pair c() {
            return TuplesKt.to(Boolean.FALSE, "");
        }

        public static Pair e() {
            return TuplesKt.to(Boolean.FALSE, "");
        }

        public static Pair g() {
            return TuplesKt.to(Boolean.FALSE, "");
        }

        public static Pair i() {
            return TuplesKt.to(Boolean.FALSE, "");
        }

        public static Pair k() {
            return TuplesKt.to(Boolean.FALSE, "");
        }

        public static Pair l() {
            return TuplesKt.to(Boolean.FALSE, "");
        }

        public static Pair d(z0 r100) {
            Intrinsics.checkNotNullParameter(r100, "msg");
            return TuplesKt.to(Boolean.FALSE, "");
        }

        public static Pair f(z0 r100) {
            Intrinsics.checkNotNullParameter(r100, "msg");
            return TuplesKt.to(Boolean.FALSE, "");
        }

        public static Pair h(z0 r100) {
            Intrinsics.checkNotNullParameter(r100, "msg");
            return TuplesKt.to(Boolean.FALSE, "");
        }

        public static Pair m(h1 r100) {
            Intrinsics.checkNotNullParameter(r100, "msg");
            return TuplesKt.to(Boolean.FALSE, "");
        }

        public static Pair j(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "secToUserId");
            Intrinsics.checkNotNullParameter(r101, "toUserIdString");
            return TuplesKt.to(Boolean.FALSE, "");
        }
    }

    Pair<Boolean, String> a();

    Pair<Boolean, String> b();

    Pair<Boolean, String> c();

    Pair<Boolean, String> d(z0 r100);

    Pair<Boolean, String> e();

    Pair f(com.bytedance.android.live.liveinteract.multianchor.model.b r100);

    Pair<Boolean, String> g();

    Pair<Boolean, String> h();

    Pair<Boolean, String> i(long r100, String r101, String r102, int r103, int r104);

    Pair<Boolean, String> j(z0 r100);

    Pair<Boolean, String> k();

    Pair<Boolean, String> l(h1 r100);

    Pair<Boolean, String> m();
}
