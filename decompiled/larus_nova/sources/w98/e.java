package w98;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Long, a> f558788a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f558789b;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<tf9.a> f558790a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<we9.e> f558791b;

        public a() {
            this(null);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f558790a, r101.f558790a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f558791b, r101.f558791b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f558790a.hashCode() * 31) + this.f558791b.hashCode();
        }

        public final String toString() {
            return "TimestampBucket(videoFrames=" + this.f558790a + ", ocrModels=" + this.f558791b + ')';
        }

        public a(Object r100) {
            ArrayList r101 = new ArrayList();
            ArrayList r102 = new ArrayList();
            Intrinsics.checkNotNullParameter(r101, "videoFrames");
            Intrinsics.checkNotNullParameter(r102, "ocrModels");
            this.f558790a = r101;
            this.f558791b = r102;
        }
    }

    public final List<c> a() {
        if (this.f558788a.isEmpty() == true) goto L5;
        List r100 = CollectionsKt.createListBuilder();
        Iterator r101 = CollectionsKt.sorted(((LinkedHashMap) this.f558788a).keySet()).iterator();
    L8:
        if (r101.hasNext() == false) goto L17;
        long r102 = ((Number) r101.next()).longValue();
        a r103 = (a) MapsKt.getValue(this.f558788a, Long.valueOf(r102));
        Iterator<T> r104 = r103.f558790a.iterator();
    L11:
        if (r104.hasNext() == false) goto L13;
        r100.add(new c.b((tf9.a) r104.next()));
        goto L11
    L13:
        Iterator<T> r105 = r103.f558791b.iterator();
    L15:
        if (r105.hasNext() == false) goto L8;
        r100.add(new c.a((we9.e) r105.next()));
        goto L15
    L17:
        List<c> r106 = CollectionsKt.build(r100);
        ((LinkedHashMap) this.f558788a).clear();
        this.f558789b = 0;
        return r106;
    L5:
        return CollectionsKt.emptyList();
    }

    public e() {
        this.f558788a = new LinkedHashMap();
    }
}
