package com.larus.bmhome.chat.component.bottom.multimodal;

import android.net.Uri;
import com.larus.platform.api.FlowDriveFileType;
import com.ss.android.socialbase.appdownloader.util.parser.zip.UnixStat;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Uri f299718a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f299719b;

    /* JADX INFO: renamed from: com.larus.bmhome.chat.component.bottom.multimodal.a$a, reason: collision with other inner class name */
    public static final class C4037a extends a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Uri f299720c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f299721d;

        public C4037a() {
            this(null, null, 3);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C4037a) == true) goto L8;
            return false;
        L8:
            C4037a r101 = (C4037a) r100;
            if (Intrinsics.areEqual(this.f299720c, r101.f299720c) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f299721d, r101.f299721d) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            Uri r100 = this.f299720c;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            String r104 = this.f299721d;
            if (r104 == null) goto L11;
            r101 = r104.hashCode();
        L11:
            return r103 + r101;
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "Entity(uri=" + this.f299720c + ", path=" + this.f299721d + ')';
        }

        @Override // com.larus.bmhome.chat.component.bottom.multimodal.a
        public final String a() {
            return this.f299721d;
        }

        @Override // com.larus.bmhome.chat.component.bottom.multimodal.a
        public final Uri b() {
            return this.f299720c;
        }

        public C4037a(Uri r100, String r101, int r102) {
            if ((r102 & 1) == 0) goto L6;
            r100 = null;
        L6:
            if ((r102 & 2) == 0) goto L8;
            r101 = null;
        L8:
            super(r100, r101);
            this.f299720c = r100;
            this.f299721d = r101;
        }
    }

    public static final class b extends a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Uri f299722c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f299723d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f299724e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Long f299725f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final String f299726g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final FlowDriveFileType f299727h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final int f299728i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final String f299729j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final float f299730k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final String f299731l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final String f299732m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final Map<String, String> f299733n;

        public b() {
            this(null, null, null, null, null, 0, null, 0.0f, null, null, null, UnixStat.PERM_MASK);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f299722c, r101.f299722c) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f299723d, r101.f299723d) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f299724e, r101.f299724e) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f299725f, r101.f299725f) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f299726g, r101.f299726g) == true) goto L24;
            return false;
        L24:
            if (this.f299727h == r101.f299727h) goto L27;
            return false;
        L27:
            if (this.f299728i == r101.f299728i) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.f299729j, r101.f299729j) == true) goto L33;
            return false;
        L33:
            if (Float.compare(this.f299730k, r101.f299730k) == 0) goto L36;
            return false;
        L36:
            if (Intrinsics.areEqual(this.f299731l, r101.f299731l) == true) goto L39;
            return false;
        L39:
            if (Intrinsics.areEqual(this.f299732m, r101.f299732m) == true) goto L42;
            return false;
        L42:
            if (Intrinsics.areEqual(this.f299733n, r101.f299733n) == true) goto L44;
            return false;
        L44:
            return true;
        }

        public final int hashCode() {
            Uri r100 = this.f299722c;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            String r104 = this.f299723d;
            if (r104 != null) goto L9;
            int r105 = 0;
        L10:
            int r106 = (r103 + r105) * 31;
            String r107 = this.f299724e;
            if (r107 != null) goto L13;
            int r108 = 0;
        L14:
            int r109 = (r106 + r108) * 31;
            Long r110 = this.f299725f;
            if (r110 != null) goto L17;
            int r111 = 0;
        L18:
            int r112 = (r109 + r111) * 31;
            String r113 = this.f299726g;
            if (r113 != null) goto L21;
            int r114 = 0;
        L22:
            int r115 = (((((r112 + r114) * 31) + this.f299727h.hashCode()) * 31) + this.f299728i) * 31;
            String r116 = this.f299729j;
            if (r116 != null) goto L25;
            int r117 = 0;
        L26:
            int r118 = (((r115 + r117) * 31) + Float.floatToIntBits(this.f299730k)) * 31;
            String r119 = this.f299731l;
            if (r119 != null) goto L29;
            int r120 = 0;
        L30:
            int r121 = (r118 + r120) * 31;
            String r122 = this.f299732m;
            if (r122 != null) goto L33;
            int r123 = 0;
        L34:
            int r124 = (r121 + r123) * 31;
            Map<String, String> r125 = this.f299733n;
            if (r125 == null) goto L39;
            r101 = r125.hashCode();
        L39:
            return r124 + r101;
        L33:
            r123 = r122.hashCode();
            goto L34
        L29:
            r120 = r119.hashCode();
            goto L30
        L25:
            r117 = r116.hashCode();
            goto L26
        L21:
            r114 = r113.hashCode();
            goto L22
        L17:
            r111 = r110.hashCode();
            goto L18
        L13:
            r108 = r107.hashCode();
            goto L14
        L9:
            r105 = r104.hashCode();
            goto L10
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "RemoteEntity(uri=" + this.f299722c + ", path=" + this.f299723d + ", fileName=" + this.f299724e + ", fileSize=" + this.f299725f + ", fileUrl=" + this.f299726g + ", fileType=" + this.f299727h + ", ccmType=" + this.f299728i + ", videoCoverUrl=" + this.f299729j + ", videoDuration=" + this.f299730k + ", originImgUrl=" + this.f299731l + ", thumbImgUrl=" + this.f299732m + ", extra=" + this.f299733n + ')';
        }

        @Override // com.larus.bmhome.chat.component.bottom.multimodal.a
        public final String a() {
            return this.f299723d;
        }

        @Override // com.larus.bmhome.chat.component.bottom.multimodal.a
        public final Uri b() {
            return this.f299722c;
        }

        public final int c() {
            return this.f299728i;
        }

        public final Map<String, String> d() {
            return this.f299733n;
        }

        public final String e() {
            return this.f299724e;
        }

        public final Long f() {
            return this.f299725f;
        }

        public final FlowDriveFileType g() {
            return this.f299727h;
        }

        public final String h() {
            return this.f299726g;
        }

        public final String i() {
            return this.f299731l;
        }

        public final String j() {
            return this.f299732m;
        }

        public final float k() {
            return this.f299730k;
        }

        public b(Uri r100, String r101, Long r102, String r103, FlowDriveFileType r104, int r105, String r106, float r110, String r111, String r112, Map r113, int r114) {
            if ((r114 & 1) == 0) goto L6;
            r100 = null;
        L6:
            if ((r114 & 4) == 0) goto L9;
            r101 = null;
        L9:
            if ((r114 & 8) == 0) goto L12;
            r102 = null;
        L12:
            if ((r114 & 16) == 0) goto L15;
            r103 = null;
        L15:
            if ((r114 & 32) == 0) goto L18;
            r104 = FlowDriveFileType.FILE;
        L18:
            if ((r114 & 64) == 0) goto L21;
            r105 = 12;
        L21:
            if ((r114 & 128) == 0) goto L24;
            r106 = null;
        L24:
            if ((r114 & 256) == 0) goto L27;
            r110 = 0.0f;
        L27:
            if ((r114 & 512) == 0) goto L30;
            r111 = null;
        L30:
            if ((r114 & 1024) == 0) goto L33;
            r112 = null;
        L33:
            if ((r114 & 2048) == 0) goto L35;
            r113 = null;
        L35:
            Intrinsics.checkNotNullParameter(r104, "fileType");
            super(r100, null);
            this.f299722c = r100;
            this.f299723d = null;
            this.f299724e = r101;
            this.f299725f = r102;
            this.f299726g = r103;
            this.f299727h = r104;
            this.f299728i = r105;
            this.f299729j = r106;
            this.f299730k = r110;
            this.f299731l = r111;
            this.f299732m = r112;
            this.f299733n = r113;
        }
    }

    public String a() {
        return this.f299719b;
    }

    public Uri b() {
        return this.f299718a;
    }

    public a(Uri r100, String r101) {
        this.f299718a = r100;
        this.f299719b = r101;
    }
}
