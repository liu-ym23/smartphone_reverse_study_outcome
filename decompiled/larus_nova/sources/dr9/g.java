package dr9;

import com.larus.platform.model.preview.AttachmentSnapshot;
import com.larus.platform.model.preview.InputDraftSnapshot;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes31.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f469794a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<String, a<InputDraftSnapshot>> f469795b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Long> f469796c = null;

    public static final class a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final T f469797a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f469798b;

        public a() {
            throw null;
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f469797a, r101.f469797a) == true) goto L12;
            return false;
        L12:
            if (this.f469798b == r101.f469798b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            T r100 = this.f469797a;
            if (r100 != null) goto L5;
            int r101 = 0;
        L6:
            long r102 = this.f469798b;
            return (r101 * 31) + ((int) (r102 ^ (r102 >>> 32)));
        L5:
            r101 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "StoredEntry(value=" + this.f469797a + ", createdAt=" + this.f469798b + ')';
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a(InputDraftSnapshot r100) {
            long r101 = System.currentTimeMillis();
            this.f469797a = r100;
            this.f469798b = r101;
        }
    }

    public g() {
    }

    static {
        f469794a = new g();
        f469795b = new ConcurrentHashMap();
        f469796c = new ConcurrentHashMap();
    }

    public static List c(List r210) {
        List r100 = r210;
        ArrayList r101 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r100, 10));
        Iterator r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        AttachmentSnapshot r103 = (AttachmentSnapshot) r102.next();
        r101.add(AttachmentSnapshot.copy$default(r103, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, 0, null, MapsKt.toMap(r103.getExtra()), 65535, null));
        goto L4
    L6:
        return r101;
    }

    public static InputDraftSnapshot d(String r110) {
        ConcurrentHashMap<String, a<InputDraftSnapshot>> r100 = f469795b;
        if (r110 == null) goto L14;
        a<InputDraftSnapshot> r101 = r100.get(r110);
        if (r101 == null) goto L14;
        if ((System.currentTimeMillis() - r101.f469798b) <= 1800000) goto L11;
        boolean r102 = true;
    L12:
        if (r102 == false) goto L15;
        r100.remove(r110, r101);
        goto L14
    L15:
        InputDraftSnapshot r111 = r101.f469797a;
    L16:
        InputDraftSnapshot r103 = r111;
        if (r103 != null) goto L20;
        return null;
    L20:
        return InputDraftSnapshot.copy$default(r103, null, c(r103.getAttachments()), null, 0, 13, null);
    L11:
        r102 = false;
    L14:
        r111 = null;
        goto L16
    }

    public static String e(String r100) {
        Intrinsics.checkNotNullParameter(r100, "prefix");
        return r100 + '-' + UUID.randomUUID();
    }

    public static void f(String r100) {
        a<InputDraftSnapshot> r101 = f469795b.remove(r100);
    }

    public static void g(g r100) {
        final long r101 = System.currentTimeMillis();
        r100.getClass();
        final long r102 = 1800000;
        CollectionsKt.removeAll(f469795b.entrySet(), new e(r102, r101));
        CollectionsKt.removeAll(f469796c.entrySet(), new f(r101, r102));
    }

    public final boolean a(String r100) {
        if (StringsKt.isBlank(r100) == false) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L8;
        return false;
    L8:
        g(this);
        if (f469796c.remove(r100) != null) goto L13;
        return false;
    L13:
        return true;
    L5:
        r101 = false;
        goto L6
    }

    public final String b(InputDraftSnapshot r110) {
        Intrinsics.checkNotNullParameter(r110, "snapshot");
        String r100 = e("input");
        Intrinsics.checkNotNullParameter(r100, "snapshotId");
        Intrinsics.checkNotNullParameter(r110, "snapshot");
        g(this);
        f469795b.put(r100, new a(InputDraftSnapshot.copy$default(r110, null, c(r110.getAttachments()), null, 0, 13, null)));
        return r100;
    }
}
