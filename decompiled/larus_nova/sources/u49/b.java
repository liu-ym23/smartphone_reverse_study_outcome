package u49;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes27.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f548731a = 0;

    static {
    }

    public b() {
    }

    public static List a(int r100, int r101) {
        Intrinsics.checkNotNullParameter("", "suffix");
        ArrayList r102 = new ArrayList();
        if (r100 > r101) goto L7;
    L4:
        r102.add(StringsKt.padStart(String.valueOf(r100), 2, '0') + "");
        if (r100 == r101) goto L7;
        r100 = r100 + 1;
    L7:
        return r102;
    }
}
