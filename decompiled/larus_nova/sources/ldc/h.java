package ldc;

import com.ss.android.lark.log.Log;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f508886a = 0;

    public static final class a {
        public a() {
        }
    }

    public static final class b {
        public static void a(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "tag");
            Intrinsics.checkNotNullParameter(r101, "msg");
            int r102 = h.f508886a;
            Intrinsics.checkNotNullParameter(r100, "tag");
            Intrinsics.checkNotNullParameter(r101, "msg");
            Log.e(r100, r101);
        }
    }

    static {
        new a();
    }
}
