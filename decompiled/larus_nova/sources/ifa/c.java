package ifa;

import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public interface c {

    public static final class a implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f489655a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f489656b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f489657c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f489658d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Integer f489659e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Integer f489660f;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f489655a, r101.f489655a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f489656b, r101.f489656b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f489657c, r101.f489657c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f489658d, r101.f489658d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f489659e, r101.f489659e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f489660f, r101.f489660f) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            int r100 = ((((((this.f489655a.hashCode() * 31) + this.f489656b.hashCode()) * 31) + this.f489657c.hashCode()) * 31) + this.f489658d.hashCode()) * 31;
            Integer r101 = this.f489659e;
            int r102 = 0;
            if (r101 != null) goto L5;
            int r103 = 0;
        L6:
            int r104 = (r100 + r103) * 31;
            Integer r105 = this.f489660f;
            if (r105 == null) goto L11;
            r102 = r105.hashCode();
        L11:
            return r104 + r102;
        L5:
            r103 = r101.hashCode();
            goto L6
        }

        public final String toString() {
            return "Image(id=" + this.f489655a + ", blockId=" + this.f489656b + ", path=" + this.f489657c + ", fileUri=" + this.f489658d + ", width=" + this.f489659e + ", height=" + this.f489660f + ')';
        }

        @Override // ifa.c
        public final String a() {
            return this.f489656b;
        }

        @Override // ifa.c
        public final String getId() {
            return this.f489655a;
        }

        public a(String r100, String r101, String r102, String r103, Integer r104, Integer r105) {
            Intrinsics.checkNotNullParameter(r100, "id");
            Intrinsics.checkNotNullParameter(r101, WikiFolderPushPlugin.BLOCK_ID);
            Intrinsics.checkNotNullParameter(r102, "path");
            Intrinsics.checkNotNullParameter(r103, "fileUri");
            this.f489655a = r100;
            this.f489656b = r101;
            this.f489657c = r102;
            this.f489658d = r103;
            this.f489659e = r104;
            this.f489660f = r105;
        }
    }

    public static final class b implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f489661a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f489662b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f489663c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f489664d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f489665e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String f489666f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final Integer f489667g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final Integer f489668h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final Integer f489669i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final Integer f489670j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final Double f489671k;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f489661a, r101.f489661a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f489662b, r101.f489662b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f489663c, r101.f489663c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f489664d, r101.f489664d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f489665e, r101.f489665e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f489666f, r101.f489666f) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.f489667g, r101.f489667g) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.f489668h, r101.f489668h) == true) goto L33;
            return false;
        L33:
            if (Intrinsics.areEqual(this.f489669i, r101.f489669i) == true) goto L36;
            return false;
        L36:
            if (Intrinsics.areEqual(this.f489670j, r101.f489670j) == true) goto L39;
            return false;
        L39:
            if (Intrinsics.areEqual(this.f489671k, r101.f489671k) == true) goto L41;
            return false;
        L41:
            return true;
        }

        public final int hashCode() {
            int r100 = ((((((this.f489661a.hashCode() * 31) + this.f489662b.hashCode()) * 31) + this.f489663c.hashCode()) * 31) + this.f489664d.hashCode()) * 31;
            String r101 = this.f489665e;
            int r102 = 0;
            if (r101 != null) goto L5;
            int r103 = 0;
        L6:
            int r104 = (r100 + r103) * 31;
            String r105 = this.f489666f;
            if (r105 != null) goto L9;
            int r106 = 0;
        L10:
            int r107 = (r104 + r106) * 31;
            Integer r108 = this.f489667g;
            if (r108 != null) goto L13;
            int r109 = 0;
        L14:
            int r110 = (r107 + r109) * 31;
            Integer r111 = this.f489668h;
            if (r111 != null) goto L17;
            int r112 = 0;
        L18:
            int r113 = (r110 + r112) * 31;
            Integer r114 = this.f489669i;
            if (r114 != null) goto L21;
            int r115 = 0;
        L22:
            int r116 = (r113 + r115) * 31;
            Integer r117 = this.f489670j;
            if (r117 != null) goto L25;
            int r118 = 0;
        L26:
            int r119 = (r116 + r118) * 31;
            Double r120 = this.f489671k;
            if (r120 == null) goto L31;
            r102 = r120.hashCode();
        L31:
            return r119 + r102;
        L25:
            r118 = r117.hashCode();
            goto L26
        L21:
            r115 = r114.hashCode();
            goto L22
        L17:
            r112 = r111.hashCode();
            goto L18
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
            return "Video(id=" + this.f489661a + ", blockId=" + this.f489662b + ", path=" + this.f489663c + ", fileUri=" + this.f489664d + ", coverPath=" + this.f489665e + ", coverFileUri=" + this.f489666f + ", coverWidth=" + this.f489667g + ", coverHeight=" + this.f489668h + ", width=" + this.f489669i + ", height=" + this.f489670j + ", duration=" + this.f489671k + ')';
        }

        @Override // ifa.c
        public final String a() {
            return this.f489662b;
        }

        @Override // ifa.c
        public final String getId() {
            return this.f489661a;
        }

        public b(String r100, String r101, String r102, String r103, String r104, String r105, Integer r106, Integer r107, Integer r110, Integer r111, Double r112) {
            Intrinsics.checkNotNullParameter(r100, "id");
            Intrinsics.checkNotNullParameter(r101, WikiFolderPushPlugin.BLOCK_ID);
            Intrinsics.checkNotNullParameter(r102, "path");
            Intrinsics.checkNotNullParameter(r103, "fileUri");
            this.f489661a = r100;
            this.f489662b = r101;
            this.f489663c = r102;
            this.f489664d = r103;
            this.f489665e = r104;
            this.f489666f = r105;
            this.f489667g = r106;
            this.f489668h = r107;
            this.f489669i = r110;
            this.f489670j = r111;
            this.f489671k = r112;
        }
    }

    String a();

    String getId();
}
