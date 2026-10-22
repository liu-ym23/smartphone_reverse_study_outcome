package v19;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<q5> f552443a = null;

    static {
        f552443a = new ArrayList();
    }

    public static void a(q5 r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        ((ArrayList) f552443a).add(r100);
    }
}
