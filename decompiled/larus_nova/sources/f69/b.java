package f69;

import com.larus.dora.impl.onboarding.lite.y0;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f475719a = null;

    static {
        f475719a = LazyKt.lazy(new a());
    }

    public static List b() {
        return (List) f475719a.getValue();
    }

    public static String a(y0 r100) {
        Intrinsics.checkNotNullParameter(r100, "wakeupQueryUiState");
        if ((r100 instanceof y0.g) == false) goto L8;
        String r101 = (String) CollectionsKt.getOrNull(b(), 0);
        if (r101 != null) goto L29;
    L27:
        return "";
    L29:
        return r101;
    L8:
        if ((r100 instanceof y0.d) == false) goto L10;
    L25:
        String r102 = (String) CollectionsKt.getOrNull(b(), 1);
        if (r102 == null) goto L27;
        return r102;
    L10:
        if ((r100 instanceof y0.e) == true) goto L25;
        if ((r100 instanceof y0.a) == false) goto L15;
    L22:
        String r103 = (String) CollectionsKt.getOrNull(b(), 2);
        if (r103 == null) goto L27;
        return r103;
    L15:
        if ((r100 instanceof y0.c) == true) goto L22;
        if ((r100 instanceof y0.f) == false) goto L27;
        String r104 = (String) CollectionsKt.getOrNull(b(), 3);
        if (r104 == null) goto L27;
        return r104;
    }
}
