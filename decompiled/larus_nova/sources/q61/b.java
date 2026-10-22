package q61;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public interface b {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map<String, String> f531758a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Map<String, String> f531759b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final cz.c f531760c;

        public a(cz.c r100) {
            Intrinsics.checkNotNullParameter(r100, "scene");
            this.f531760c = r100;
            LinkedHashMap r101 = new LinkedHashMap();
            this.f531758a = r101;
            this.f531759b = r101;
        }

        public final void a(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "key");
            Intrinsics.checkNotNullParameter(r101, "value");
            this.f531758a.put(r100, r101);
        }
    }

    Map<String, String> getLogParams();

    cz.c getScene();
}
