package og6;

import java.util.List;
import jy0.b;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import vm2.l;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f523192a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<String> f523193b = null;

    public a() {
    }

    static {
        f523192a = l.a();
        f523193b = CollectionsKt.mutableListOf(new String[]{"WindowListHelper"});
    }

    public static void a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "subTag");
        Intrinsics.checkNotNullParameter(r101, "content");
        if (f523192a == false) goto L7;
        b.d("LinkDebugLog", "subTag: " + r100 + " | content: " + r101);
        return;
    }
}
