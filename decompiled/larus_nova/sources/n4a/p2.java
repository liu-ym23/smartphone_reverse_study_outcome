package n4a;

import com.loc.dv;
import com.loc.dw;
import com.loc.dx;
import com.loc.dy;
import com.loc.dz;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes32.dex */
public final class p2 {

    public static class a implements n2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f517583a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f517584b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f517585c;

        public a(int r100, int r101, int r102) {
            this.f517583a = r100;
            this.f517584b = r101;
            this.f517585c = r102;
        }

        @Override // n4a.n2
        public final long a() {
            int r100 = this.f517583a;
            int r101 = this.f517584b;
            long r102 = (((long) r100) & BodyPartID.bodyIdMax) << 32;
            return (((long) r101) & BodyPartID.bodyIdMax) | r102;
        }

        @Override // n4a.n2
        public final int b() {
            return this.f517585c;
        }
    }

    public static class b implements n2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f517586a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f517587b;

        public b(long r100, int r101) {
            this.f517586a = r100;
            this.f517587b = r101;
        }

        @Override // n4a.n2
        public final long a() {
            return this.f517586a;
        }

        @Override // n4a.n2
        public final int b() {
            return this.f517587b;
        }
    }

    public static synchronized void a(List<dv> r100) {
        monitor-enter(p2.class);
        if (r100 != null) goto L32;
    L30:
        monitor-exit(p2.class);
        return;
    L32:
    L27:
        th = move-exception;
        throw th;
    L6:
        if (r100.isEmpty() == true) goto L30;
        ArrayList r101 = new ArrayList(r100.size());     // Catch: Throwable -> L27
        Iterator<dv> r102 = r100.iterator();     // Catch: Throwable -> L27
    L10:
        if (r102.hasNext() == false) goto L24;
        dv r103 = r102.next();     // Catch: Throwable -> L27
        if ((r103 instanceof dx) == true) goto L13;
        if ((r103 instanceof dy) == true) goto L17;
        if ((r103 instanceof dz) == true) goto L20;
        if ((r103 instanceof dw) == false) goto L10;
        dw r104 = (dw) r103;     // Catch: Throwable -> L27
        a r105 = new a(r104.f380018k, r104.f380019l, r104.f380010c);     // Catch: Throwable -> L27
    L14:
        r101.add(r105);     // Catch: Throwable -> L27
        goto L10
    L20:
        dz r106 = (dz) r103;     // Catch: Throwable -> L27
        r105 = new a(r106.f380033j, r106.f380034k, r106.f380010c);     // Catch: Throwable -> L27
        goto L14
    L17:
        dy r107 = (dy) r103;     // Catch: Throwable -> L27
        r105 = new a(r107.f380028j, r107.f380029k, r107.f380010c);     // Catch: Throwable -> L27
        goto L14
    L13:
        dx r108 = (dx) r103;     // Catch: Throwable -> L27
        r105 = new a(r108.f380022j, r108.f380023k, r108.f380010c);     // Catch: Throwable -> L27
        goto L14
    L24:
        o2.a().c(r101);     // Catch: Throwable -> L27
        monitor-exit(p2.class);
    }
}
