package jva;

import android.app.Activity;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public interface d {

    public interface a {
        void a(b r100);

        void b(b r100);
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f500586a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f500587b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f500588c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Activity f500589d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f500586a, r101.f500586a) == true) goto L12;
            return false;
        L12:
            if (this.f500587b == r101.f500587b) goto L15;
            return false;
        L15:
            if (this.f500588c == r101.f500588c) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f500589d, r101.f500589d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f500586a.hashCode() * 31;
            if (this.f500587b == false) goto L5;
            int r101 = 1231;
        L6:
            int r102 = (r100 + r101) * 31;
            long r103 = this.f500588c;
            int r104 = (r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31;
            Activity r105 = this.f500589d;
            if (r105 != null) goto L9;
            int r106 = 0;
        L11:
            return r104 + r106;
        L9:
            r106 = r105.hashCode();
            goto L11
        L5:
            r101 = 1237;
            goto L6
        }

        public final String toString() {
            return "ProcessState(name=" + this.f500586a + ", isForeground=" + this.f500587b + ", timestamp=" + this.f500588c + ", topActivity=" + this.f500589d + ')';
        }

        public final String a() {
            StringBuilder r100 = new StringBuilder("processName=");
            r100.append(this.f500586a);
            r100.append(", isForeground=");
            r100.append(this.f500587b);
            r100.append(", topActivity=");
            Activity r101 = this.f500589d;
            if (r101 == null) goto L5;
            String r102 = r101.getClass().getSimpleName();
        L6:
            r100.append(r102);
            r100.append(", timestamp=");
            r100.append(this.f500588c);
            return r100.toString();
        L5:
            r102 = null;
            goto L6
        }

        public b(String r100, boolean r101, long r102, Activity r103) {
            Intrinsics.checkNotNullParameter(r100, "name");
            this.f500586a = r100;
            this.f500587b = r101;
            this.f500588c = r102;
            this.f500589d = r103;
        }
    }

    jva.a a();

    String b();

    boolean isForeground();
}
