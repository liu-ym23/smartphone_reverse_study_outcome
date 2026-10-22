package jd2;

import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.ControlRule;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f498226a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f498227b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f498228c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b f498229d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f498230e;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f498231a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f498232b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f498233c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f498234d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f498235e;

        public b() {
            this(0);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof b) == false) goto L16;
            b r101 = (b) r100;
            if (this.f498231a == r101.f498231a) goto L8;
            return false;
        L8:
            if (this.f498232b == r101.f498232b) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.f498233c, r101.f498233c) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f498234d, r101.f498234d) == true) goto L14;
            return false;
        L14:
            if (this.f498235e == r101.f498235e) goto L25;
            return false;
        L25:
            return true;
        L16:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v10 */
        /* JADX WARN: Type inference failed for: r0v11 */
        public final int hashCode() {
            boolean r100 = this.f498231a;
            ?? r101 = r100;
            if (r100 == false) goto L5;
            r101 = 1;
        L5:
            int r102 = ((r101 * 31) + this.f498232b) * 31;
            String r103 = this.f498233c;
            int r104 = 0;
            if (r103 == null) goto L8;
            int r105 = r103.hashCode();
        L9:
            int r106 = (r102 + r105) * 31;
            String r107 = this.f498234d;
            if (r107 == null) goto L13;
            r104 = r107.hashCode();
        L13:
            return ((r106 + r104) * 31) + this.f498235e;
        L8:
            r105 = 0;
            goto L9
        }

        public final String toString() {
            return "ExtraData(isSinger=" + this.f498231a + ", uiLayout=" + this.f498232b + ", idStr='" + this.f498233c + "', lyricUrl='" + this.f498234d + "', lyricType=" + this.f498235e + ')';
        }

        public /* synthetic */ b(int r100) {
            this(false, 0, "", "", 3);
        }

        public b(boolean r100, int r101, String r102, String r103, int r104) {
            Intrinsics.checkNotNullParameter(r102, "idStr");
            Intrinsics.checkNotNullParameter(r103, "lyricUrl");
            this.f498231a = r100;
            this.f498232b = r101;
            this.f498233c = r102;
            this.f498234d = r103;
            this.f498235e = r104;
        }
    }

    static {
    }

    public c() {
        this(0, 0, "", new b(0), "");
    }

    public static c a(int r100, long r101, String r110, b r111, String r112) {
        Intrinsics.checkNotNullParameter(r110, "musicId");
        Intrinsics.checkNotNullParameter(r111, ControlRule.KEY_EXTRA_DATA);
        Intrinsics.checkNotNullParameter(r112, "roomId");
        return new c(r100, r101, r110, r111, r112);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L16;
        c r101 = (c) r100;
        if (this.f498226a == r101.f498226a) goto L8;
        return false;
    L8:
        if (this.f498227b == r101.f498227b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f498228c, r101.f498228c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f498229d, r101.f498229d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f498230e, r101.f498230e) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        int r100 = this.f498226a * 31;
        long r101 = this.f498227b;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        String r103 = this.f498228c;
        int r104 = 0;
        if (r103 == null) goto L5;
        int r105 = r103.hashCode();
    L6:
        int r106 = (r102 + r105) * 31;
        b r107 = this.f498229d;
        if (r107 == null) goto L9;
        int r108 = r107.hashCode();
    L10:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f498230e;
        if (r110 == null) goto L14;
        r104 = r110.hashCode();
    L14:
        return r109 + r104;
    L9:
        r108 = 0;
        goto L10
    L5:
        r105 = 0;
        goto L6
    }

    public final String toString() {
        return "KtvSingStateData(singState=" + this.f498226a + ", singPlayProgress=" + this.f498227b + ", musicId='" + this.f498228c + "', extraData=" + this.f498229d + ", roomId='" + this.f498230e + "')";
    }

    public c(int r100, long r101, String r102, b r103, String r104) {
        Intrinsics.checkNotNullParameter(r102, "musicId");
        Intrinsics.checkNotNullParameter(r103, ControlRule.KEY_EXTRA_DATA);
        Intrinsics.checkNotNullParameter(r104, "roomId");
        this.f498226a = r100;
        this.f498227b = r101;
        this.f498228c = r102;
        this.f498229d = r103;
        this.f498230e = r104;
    }
}
