package ix8;

import com.larus.camera.api.vlm.VLMIntent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final VLMIntent f496391a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f496392b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final g f496393c;

    public static final class a extends d {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final e f496394d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final g f496395e;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f496394d, r101.f496394d) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f496395e, r101.f496395e) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f496394d.hashCode() * 31) + this.f496395e.hashCode();
        }

        public final String toString() {
            return "Common(status=" + this.f496394d + ", preProcessInfo=" + this.f496395e + ')';
        }

        @Override // ix8.d
        public final g a() {
            return this.f496395e;
        }

        @Override // ix8.d
        public final e b() {
            return this.f496394d;
        }

        public /* synthetic */ a(e r100) {
            this(r100, new g(0));
        }

        public a(e r100, g r101) {
            Intrinsics.checkNotNullParameter(r100, "status");
            Intrinsics.checkNotNullParameter(r101, "preProcessInfo");
            super(VLMIntent.COMMON, r100, r101);
            this.f496394d = r100;
            this.f496395e = r101;
        }
    }

    public static final class b extends d {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final e f496396d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f496397e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f496398f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final String f496399g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final f f496400h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final String f496401i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final String f496402j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final g f496403k;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f496396d, r101.f496396d) == true) goto L12;
            return false;
        L12:
            if (this.f496397e == r101.f496397e) goto L15;
            return false;
        L15:
            if (this.f496398f == r101.f496398f) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f496399g, r101.f496399g) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f496400h, r101.f496400h) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f496401i, r101.f496401i) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.f496402j, r101.f496402j) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.f496403k, r101.f496403k) == true) goto L32;
            return false;
        L32:
            return true;
        }

        public final int hashCode() {
            int r100 = ((((this.f496396d.hashCode() * 31) + this.f496397e) * 31) + this.f496398f) * 31;
            String r101 = this.f496399g;
            int r102 = 0;
            if (r101 != null) goto L5;
            int r103 = 0;
        L6:
            int r104 = (r100 + r103) * 31;
            f r105 = this.f496400h;
            if (r105 != null) goto L9;
            int r106 = 0;
        L10:
            int r107 = (r104 + r106) * 31;
            String r108 = this.f496401i;
            if (r108 != null) goto L13;
            int r109 = 0;
        L14:
            int r110 = (r107 + r109) * 31;
            String r111 = this.f496402j;
            if (r111 == null) goto L19;
            r102 = r111.hashCode();
        L19:
            return ((r110 + r102) * 31) + this.f496403k.hashCode();
        L13:
            r109 = r108.hashCode();
            goto L14
        L9:
            r106 = r105.hashCode();
            goto L10
        L5:
            r103 = r101.hashCode();
            goto L6
        }

        public final String toString() {
            return "Edu(status=" + this.f496396d + ", requestImageWidth=" + this.f496397e + ", requestImageHeight=" + this.f496398f + ", data=" + this.f496399g + ", enableChoice=" + this.f496400h + ", requestId=" + this.f496401i + ", eduExtraParam=" + this.f496402j + ", preProcessInfo=" + this.f496403k + ')';
        }

        @Override // ix8.d
        public final g a() {
            return this.f496403k;
        }

        @Override // ix8.d
        public final e b() {
            return this.f496396d;
        }

        public b(e.d r100, int r101, int r102, String r103, f r104, String r105, String r106, g r107) {
            Intrinsics.checkNotNullParameter(r100, "status");
            Intrinsics.checkNotNullParameter(r107, "preProcessInfo");
            super(VLMIntent.EDU, r100, r107);
            this.f496396d = r100;
            this.f496397e = r101;
            this.f496398f = r102;
            this.f496399g = r103;
            this.f496400h = r104;
            this.f496401i = r105;
            this.f496402j = r106;
            this.f496403k = r107;
        }
    }

    public g a() {
        return this.f496393c;
    }

    public e b() {
        return this.f496392b;
    }

    public d(VLMIntent r100, e r101, g r102) {
        this.f496391a = r100;
        this.f496392b = r101;
        this.f496393c = r102;
    }
}
