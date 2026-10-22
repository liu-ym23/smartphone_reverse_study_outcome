package lb3;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<String, C6670a> f508345a;

    /* JADX INFO: renamed from: lb3.a$a, reason: collision with other inner class name */
    public static final class C6670a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f508346a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f508347b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f508348c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f508349d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof C6670a) == false) goto L14;
            C6670a r101 = (C6670a) r100;
            if (Intrinsics.areEqual(this.f508346a, r101.f508346a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f508347b, r101.f508347b) == true) goto L10;
            return false;
        L10:
            if (this.f508348c == r101.f508348c) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f508349d, r101.f508349d) == true) goto L22;
            return false;
        L22:
            return true;
        L14:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v6, types: [int] */
        /* JADX WARN: Type inference failed for: r2v4, types: [int] */
        /* JADX WARN: Type inference failed for: r2v6 */
        /* JADX WARN: Type inference failed for: r2v8 */
        public final int hashCode() {
            String r100 = this.f508346a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            String r104 = this.f508347b;
            if (r104 == null) goto L9;
            int r105 = r104.hashCode();
        L10:
            int r106 = (r103 + r105) * 31;
            boolean r107 = this.f508348c;
            ?? r108 = r107;
            if (r107 == false) goto L13;
            r108 = 1;
        L13:
            int r109 = (r106 + r108) * 31;
            String r110 = this.f508349d;
            if (r110 == null) goto L17;
            r101 = r110.hashCode();
        L17:
            return r109 + r101;
        L9:
            r105 = 0;
            goto L10
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "Info(eventName=" + this.f508346a + ", opportunity=" + this.f508347b + ", needHold=" + this.f508348c + ", renderNodeKey=" + this.f508349d + ")";
        }

        public C6670a(String r100, String r101, boolean r102, String r103) {
            Intrinsics.checkNotNullParameter(r100, "eventName");
            Intrinsics.checkNotNullParameter(r101, "opportunity");
            Intrinsics.checkNotNullParameter(r103, "renderNodeKey");
            this.f508346a = r100;
            this.f508347b = r101;
            this.f508348c = r102;
            this.f508349d = r103;
        }
    }

    public a() {
        this.f508345a = new ConcurrentHashMap();
    }
}
