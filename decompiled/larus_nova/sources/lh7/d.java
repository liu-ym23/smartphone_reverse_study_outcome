package lh7;

import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.obric.aivoice.core.data.NameKeys;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, a> f509290a = null;

    public interface a {
        oh7.a a(Map<String, String> r100);
    }

    public static final class b implements a {
        public b() {
        }

        @Override // lh7.d.a
        public final oh7.a a(Map<String, String> r100) {
            String r101 = r100.get("period");
            if (r101 != null) goto L6;
            r101 = String.valueOf(60000);
        L6:
            boolean r102 = false;
            int r103 = 0;
        L8:
            if (r103 >= r101.length()) goto L13;
            if (Character.isDigit(r101.charAt(r103)) == false) goto L14;
            r103 = r103 + 1;
        L14:
            if (r102 == false) goto L18;
            return new oh7.b(CastLongProtector.parseLong(r101));
        L18:
            return new oh7.b(60000);
        L13:
            r102 = true;
            goto L14
        }
    }

    public static final class c implements a {
        public c() {
        }

        @Override // lh7.d.a
        public final oh7.a a(Map<String, String> r100) {
            return new oh7.c();
        }
    }

    static {
        f509290a = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("period", new b()), TuplesKt.to(NameKeys.LoadStrategy_Persist, new c())});
    }

    public static oh7.a a(String r100, Map r101) {
        Map<String, a> r102 = f509290a;
        if (r102.get(r100) == null) goto L9;
        a r103 = r102.get(r100);
        if (r103 != null) goto L8;
        Intrinsics.throwNpe();
    L8:
        return r103.a(r101);
    L9:
        int r104 = com.bytedance.timonbase.b.f270799a;
        com.bytedance.timonbase.b.c("CacheEnv", "getStrategy " + r100 + " error");
        return null;
    }
}
