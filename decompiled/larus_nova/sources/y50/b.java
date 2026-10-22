package y50;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f566204a = 0;

    public static final class a {
        public static void a(JSONObject r100, String r101, float r102) {
            Intrinsics.checkNotNullParameter(r100, "json");
            Intrinsics.checkNotNullParameter(r101, "key");
            r100.put(r101, r102);     // Catch: Throwable -> L5
            return;
        L5:
            th = move-exception;
            jy0.b.b("BaseMonitor", "", th);
        }

        public static void b(JSONObject r100, String r101, int r102) {
            Intrinsics.checkNotNullParameter(r100, "json");
            Intrinsics.checkNotNullParameter(r101, "key");
            r100.put(r101, r102);     // Catch: Throwable -> L5
            return;
        L5:
            th = move-exception;
            jy0.b.b("BaseMonitor", "", th);
        }

        public static void c(JSONObject r100, String r101, long r102) {
            Intrinsics.checkNotNullParameter(r100, "json");
            Intrinsics.checkNotNullParameter(r101, "key");
            r100.put(r101, r102);     // Catch: Throwable -> L5
            return;
        L5:
            th = move-exception;
            jy0.b.b("BaseMonitor", "", th);
        }

        public static void d(JSONObject r100, String r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, "json");
            Intrinsics.checkNotNullParameter(r101, "key");
            r100.put(r101, r102);     // Catch: Throwable -> L5
            return;
        L5:
            th = move-exception;
            jy0.b.b("BaseMonitor", "", th);
        }

        public static void e(JSONObject r100, String r101, boolean r102) {
            Intrinsics.checkNotNullParameter(r100, "json");
            Intrinsics.checkNotNullParameter(r101, "key");
            r100.put(r101, r102);     // Catch: Throwable -> L5
            return;
        L5:
            th = move-exception;
            jy0.b.b("BaseMonitor", "", th);
        }
    }

    static {
    }

    public b() {
    }
}
