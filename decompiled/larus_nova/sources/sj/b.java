package sj;

import com.bytedance.android.ec.hybrid.card.util.q;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c<String, Pair<Object, Boolean>> f542261a = null;

    static {
        f542261a = new c();
    }

    public static boolean a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "schema");
        String r101 = q.b(r100);
        if (r101 != null) goto L5;
        return false;
    L5:
        c<String, Pair<Object, Boolean>> r102 = f542261a;
        if (r102.f542262a.containsKey(r101) == false) goto L8;
    L9:
        return true;
    L8:
        if (r102.f542263b.containsKey(r101) == true) goto L9;
        return false;
    }
}
