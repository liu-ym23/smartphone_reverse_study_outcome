package fh8;

import android.util.LruCache;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes25.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f477068a = null;

    public static final class a extends LruCache<String, Object> {
        public a() {
            super(1048576);
        }

        @Override // android.util.LruCache
        public final int sizeOf(String r100, Object r101) {
            Intrinsics.checkNotNullParameter(r100, "key");
            Intrinsics.checkNotNullParameter(r101, "value");
            return r101.toString().getBytes(Charsets.UTF_8).length;
        }
    }

    static {
        f477068a = new a();
    }

    public static Object a(usc.e r100, Function1 r101) {
        Intrinsics.checkNotNullParameter(r100, "span");
        Intrinsics.checkNotNullParameter(r101, "parseCallback");
        String r102 = r100.getDataType() + "->" + r100.h() + "->" + r100.k();
        a r103 = f477068a;
        Object r104 = r103.get(r102);
        if (r104 != null) goto L5;
        r104 = null;
    L5:
        if (r104 == null) goto L7;
        return r104;
    L7:
        Object r105 = r101.invoke(r100);
        r103.put(r102, r105);
        return r105;
    }
}
