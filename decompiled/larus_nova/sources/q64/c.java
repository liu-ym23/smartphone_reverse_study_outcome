package q64;

import com.alipay.sdk.m.u.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes46.dex */
public final class c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f531789b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<C7284c> f531790a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<C7284c> f531791a;

        public a() {
            this.f531791a = new ArrayList();
        }

        public a(c r100) {
            Intrinsics.checkNotNullParameter(r100, "headers");
            this.f531791a = new ArrayList(r100.f531790a);
        }

        public final void a(Map r100) {
            Intrinsics.checkNotNullParameter(r100, "map");
            Iterator r101 = r100.entrySet().iterator();
        L4:
            if (r101.hasNext() == false) goto L6;
            Map.Entry r102 = (Map.Entry) r101.next();
            List<C7284c> r103 = this.f531791a;
            ArrayList r104 = (ArrayList) r103;
            r104.add(new C7284c((String) r102.getKey(), (String) r102.getValue()));
            goto L4
        }

        public final void b(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "key");
            Intrinsics.checkNotNullParameter(r101, "value");
            Intrinsics.checkNotNullParameter(r100, "key");
            Iterator r102 = ((ArrayList) this.f531791a).iterator();
        L4:
            if (r102.hasNext() == false) goto L8;
            if (StringsKt.equals(((C7284c) r102.next()).f531792a, r100, true) == false) goto L4;
            r102.remove();
            goto L4
        L8:
            Intrinsics.checkNotNullParameter(r100, "key");
            Intrinsics.checkNotNullParameter(r101, "value");
            List<C7284c> r103 = this.f531791a;
            ArrayList r104 = (ArrayList) r103;
            r104.add(new C7284c(r100, r101));
        }
    }

    public static final class b {
    }

    /* JADX INFO: renamed from: q64.c$c, reason: collision with other inner class name */
    public static final class C7284c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f531792a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f531793b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C7284c) == true) goto L8;
            return false;
        L8:
            C7284c r101 = (C7284c) r100;
            if (Intrinsics.areEqual(this.f531792a, r101.f531792a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f531793b, r101.f531793b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f531792a.hashCode() * 31) + this.f531793b.hashCode();
        }

        public final String toString() {
            return "{" + this.f531792a + ": " + this.f531793b + '}';
        }

        public C7284c(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "name");
            Intrinsics.checkNotNullParameter(r101, "value");
            this.f531792a = r100;
            this.f531793b = r101;
        }
    }

    static {
        f531789b = new c(new ArrayList());
    }

    public final String toString() {
        return this.f531790a.toString();
    }

    public c(List r100) {
        this.f531790a = r100;
    }

    public final String a(String r110) {
        Intrinsics.checkNotNullParameter(r110, "key");
        Intrinsics.checkNotNullParameter(r110, "key");
        List<C7284c> r100 = this.f531790a;
        ArrayList r101 = new ArrayList();
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        Object r103 = r102.next();
        if (StringsKt.equals(((C7284c) r103).f531792a, r110, true) == false) goto L4;
        r101.add(r103);
        goto L4
    L8:
        ArrayList r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator r111 = r101.iterator();
    L10:
        if (r111.hasNext() == false) goto L13;
        r104.add(((C7284c) r111.next()).f531793b);
        goto L10
    L13:
        return CollectionsKt.joinToString$default(r104, i.f25853b, null, null, 0, null, null, 62, null);
    }
}
