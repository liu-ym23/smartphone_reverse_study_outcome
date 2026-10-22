package w68;

import com.larus.im.service.audio.l;
import com.larus.im.service.audio.t;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final w68.a f558435a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f558436b = null;

    public static final class a implements t {
        public a() {
        }

        @Override // com.larus.im.service.audio.t
        public final l a(l r100) {
            Intrinsics.checkNotNullParameter(r100, "frame");
            return r100;
        }

        @Override // com.larus.im.service.audio.t
        public final Pair<l, l> c(l r100, l r101) {
            Intrinsics.checkNotNullParameter(r100, "micFrame");
            Intrinsics.checkNotNullParameter(r101, "refFrame");
            return TuplesKt.to(r100, r101);
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [w68.a] */
    static {
        f558435a = new w68.a();
        f558436b = new a();
    }
}
