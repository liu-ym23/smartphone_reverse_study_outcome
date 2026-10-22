package so8;

import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Set<String> f542790a = null;

    static {
        f542790a = new LinkedHashSet();
    }

    public static void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "animationID");
        f542790a.add(r100);
    }
}
