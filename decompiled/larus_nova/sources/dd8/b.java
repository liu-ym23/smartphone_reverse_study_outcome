package dd8;

import android.util.LruCache;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f468034a = null;

    public static final class a extends LruCache<String, Long> {
        @Override // android.util.LruCache
        public final Long create(String r100) {
            return null;
        }

        @Override // android.util.LruCache
        public final void entryRemoved(boolean r100, String r101, Long r102, Long r103) {
        }

        @Override // android.util.LruCache
        public final int sizeOf(String r100, Long r101) {
            return 1;
        }

        public a() {
            super(100);
        }
    }

    static {
        f468034a = new a();
    }

    public static boolean a(String r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "localMessageId");
        a r102 = f468034a;
        Long r103 = r102.get(r100);
        if (r103 == null) goto L5;
        long r104 = r103.longValue();
    L7:
        if ((System.currentTimeMillis() - r104) < (r101 + 2000)) goto L9;
        return true;
    L9:
        return false;
    L5:
        long r105 = System.currentTimeMillis();
        r102.put(r100, Long.valueOf(r105));
        r104 = r105;
        goto L7
    }
}
