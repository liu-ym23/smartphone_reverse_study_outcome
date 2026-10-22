package ne1;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class c implements ne1.a<Object> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f518867d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Object> f518868a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f518869b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f518870c;

    public static final class a {
        @JvmStatic
        public static c a(com.bytedance.android.livesdk.arch.comp.b r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "comp");
            Intrinsics.checkNotNullParameter(r101, "msg");
            return new c(r101);
        }
    }

    static {
    }

    @Override // ne1.a
    public final Map<String, Object> getParams() {
        return this.f518868a;
    }

    public c(String r100) {
        this.f518870c = r100;
        this.f518868a = new LinkedHashMap();
    }

    public final void b(Pair... r100) {
        Intrinsics.checkNotNullParameter(r100, "pairs");
        Intrinsics.checkNotNullParameter(r100, "pairs");
        int r101 = r100.length;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L10;
        Pair r103 = r100[r102];
        if (r103 == null) goto L9;
        Object r104 = r103.getSecond();
        if (r104 == null) goto L9;
        a((String) r103.getFirst(), r104);
    L9:
        r102 = r102 + 1;
        goto L3
    }

    public final void a(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        ne1.a.C6915a.a(this, r100, r101);
    }
}
