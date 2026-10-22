package op9;

import android.util.LongSparseArray;
import android.util.SparseArray;
import com.larus.photopicker.v2.impl.model.MediaTab;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LongSparseArray<SparseArray<Integer>> f524785a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LongSparseArray<SparseArray<LongSparseArray<Integer>>> f524786b;

    public b() {
        this.f524785a = new LongSparseArray();
        this.f524786b = new LongSparseArray();
    }

    public final void a(long r100, MediaTab r110, List<mp9.c> r111) {
        Intrinsics.checkNotNullParameter(r110, "mediaTab");
        Intrinsics.checkNotNullParameter(r111, "newMediaList");
        SparseArray<Integer> r101 = this.f524785a.get(r100, null);
        SparseArray<LongSparseArray<Integer>> r102 = this.f524786b.get(r100, null);
        if (r101 == null) goto L24;
        if (r102 == null) goto L24;
        Integer r103 = r101.get(r110.getId(), -1);
        LongSparseArray<Integer> r104 = r102.get(r110.getId(), null);
        if (r103 != null) goto L10;
    L11:
        if (r104 == null) goto L22;
        Intrinsics.checkNotNull(r103);
        int r105 = r103.intValue();
        Iterator<T> r112 = r111.iterator();
        int r106 = 0;
    L15:
        if (r112.hasNext() == false) goto L20;
        Object r107 = r112.next();
        int r108 = r106 + 1;
        if (r106 >= 0) goto L19;
        CollectionsKt.throwIndexOverflow();
    L19:
        r104.put(((mp9.c) r107).f514732a, Integer.valueOf(r106 + r105));
        r106 = r108;
        goto L15
    L20:
        r101.put(r110.getId(), Integer.valueOf(r103.intValue() + r111.size()));
        r111.size();
        return;
    L22:
        b(r100, r110, r111);
        return;
    L10:
        if (r103.intValue() == (-1)) goto L22;
    L24:
        b(r100, r110, r111);
    }

    public final void b(long r100, MediaTab r101, List<mp9.c> r110) {
        Intrinsics.checkNotNullParameter(r101, "mediaTab");
        Intrinsics.checkNotNullParameter(r110, "mediaList");
        SparseArray<Integer> r102 = this.f524785a.get(r100, null);
        if (r102 != null) goto L5;
        r102 = new SparseArray();
        this.f524785a.put(r100, r102);
    L5:
        SparseArray<LongSparseArray<Integer>> r103 = this.f524786b.get(r100, null);
        if (r103 != null) goto L8;
        r103 = new SparseArray();
        this.f524786b.put(r100, r103);
    L8:
        r102.put(r101.getId(), Integer.valueOf(r110.size()));
        LongSparseArray<Integer> r104 = new LongSparseArray();
        Iterator<T> r105 = r110.iterator();
        int r106 = 0;
    L10:
        if (r105.hasNext() == false) goto L15;
        Object r107 = r105.next();
        int r108 = r106 + 1;
        if (r106 >= 0) goto L14;
        CollectionsKt.throwIndexOverflow();
    L14:
        r104.put(((mp9.c) r107).f514732a, Integer.valueOf(r106));
        r106 = r108;
        goto L10
    L15:
        r103.put(r101.getId(), r104);
        r110.size();
    }
}
