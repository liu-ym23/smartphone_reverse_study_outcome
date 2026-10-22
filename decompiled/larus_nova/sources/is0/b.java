package is0;

import com.bytedance.android.live.player.api.PlayerFeatureEffectScope;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public abstract class b<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f495579a = 0;

    public static final class a {
        public static d b(String r100) {
            Intrinsics.checkNotNullParameter(r100, "feature");
            return new d(r100, 1, Boolean.TRUE);
        }

        public static d a(String r100, @PlayerFeatureEffectScope int r101, int r102) {
            Intrinsics.checkNotNullParameter(r100, "feature");
            return new d(r100, r101, Integer.valueOf(r102));
        }

        public static d c(String r100, @PlayerFeatureEffectScope int r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, "feature");
            Intrinsics.checkNotNullParameter(r102, "value");
            return new d(r100, r101, r102);
        }
    }

    static {
    }

    public b() {
    }

    public abstract int a();

    public abstract String b();

    public abstract T c();
}
