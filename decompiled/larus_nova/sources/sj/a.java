package sj;

import com.bytedance.android.ec.hybrid.card.util.q;
import java.util.ArrayList;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c<String, List<Pair<String, Object>>> f542260a = null;

    static {
        f542260a = new c();
    }

    public static List a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "cardSchema");
        c<String, List<Pair<String, Object>>> r101 = f542260a;
        List<Pair<String, Object>> r102 = r101.a("common_components");
        String r103 = q.b(r100);
        if (r103 != null) goto L5;
        return r102;
    L5:
        ArrayList r104 = new ArrayList();
        if (r102 == null) goto L8;
        r104.addAll(r102);
    L8:
        List<Pair<String, Object>> r105 = r101.a(r103);
        if (r105 == null) goto L11;
        r104.addAll(r105);
    L11:
        return r104;
    }
}
