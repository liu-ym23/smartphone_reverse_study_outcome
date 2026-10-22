package gb4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes11.dex */
public final class c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f480683b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<C6004c> f480684a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<C6004c> f480685a;

        public final c b() {
            return new c(this.f480685a);
        }

        public a() {
            this.f480685a = new ArrayList();
        }

        public a(c r100) {
            this.f480685a = new ArrayList(r100.f480684a);
        }

        public final void a(String r100, String r101) {
            List<C6004c> r102 = this.f480685a;
            ArrayList r103 = (ArrayList) r102;
            r103.add(new C6004c(r100, r101));
        }

        public final void c(String r100, String r101) {
            Iterator r102 = ((ArrayList) this.f480685a).iterator();
        L4:
            if (r102.hasNext() == false) goto L8;
            if (StringsKt.equals(((C6004c) r102.next()).f480686a, r100, true) == false) goto L4;
            r102.remove();
            goto L4
        L8:
            a(r100, r101);
        }
    }

    public static final class b {
    }

    /* JADX INFO: renamed from: gb4.c$c, reason: collision with other inner class name */
    public static final class C6004c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f480686a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f480687b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof C6004c) == false) goto L10;
            C6004c r101 = (C6004c) r100;
            if (Intrinsics.areEqual(this.f480686a, r101.f480686a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f480687b, r101.f480687b) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            String r100 = this.f480686a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            String r104 = this.f480687b;
            if (r104 == null) goto L10;
            r101 = r104.hashCode();
        L10:
            return r103 + r101;
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return this.f480686a + ": " + this.f480687b;
        }

        public C6004c(String r100, String r101) {
            this.f480686a = r100;
            this.f480687b = r101;
        }
    }

    static {
        f480683b = new c(new ArrayList());
    }

    public final String toString() {
        return this.f480684a.toString();
    }

    public c(List r100) {
        this.f480684a = r100;
    }

    public final String a(String r110) {
        List<C6004c> r100 = this.f480684a;
        ArrayList r101 = new ArrayList();
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        Object r103 = r102.next();
        if (StringsKt.equals(((C6004c) r103).f480686a, r110, true) == false) goto L4;
        r101.add(r103);
        goto L4
    L8:
        ArrayList r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator r111 = r101.iterator();
    L10:
        if (r111.hasNext() == false) goto L13;
        r104.add(((C6004c) r111.next()).f480687b);
        goto L10
    L13:
        return CollectionsKt.joinToString$default(r104, ",", null, null, 0, null, null, 62, null);
    }
}
