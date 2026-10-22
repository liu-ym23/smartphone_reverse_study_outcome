package h9b;

import android.util.Pair;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f484352a = 0;

    static {
    }

    public static HashMap a(Pair... r100) {
        Intrinsics.checkNotNullParameter(r100, "pairs");
        HashMap r101 = new HashMap();
        int r102 = r100.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        Pair r104 = r100[r103];
        r101.put(r104.first, r104.second);
        r103 = r103 + 1;
        goto L3
    L5:
        return r101;
    }
}
