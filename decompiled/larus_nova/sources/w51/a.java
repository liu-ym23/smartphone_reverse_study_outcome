package w51;

import com.bytedance.android.live.core.log.ALogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f558315a = 0;

    /* JADX INFO: renamed from: w51.a$a, reason: collision with other inner class name */
    public static final class C8068a {
        public static void a(String r100) {
            Intrinsics.checkNotNullParameter("VipRepository", "tag");
            Intrinsics.checkNotNullParameter(r100, "msg");
            ALogger.d("VipRepository", r100);
        }

        public static void b(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "tag");
            Intrinsics.checkNotNullParameter(r101, "msg");
            ALogger.e(r100, r101);
        }
    }

    static {
    }
}
