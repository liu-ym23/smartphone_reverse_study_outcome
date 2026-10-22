package com.larus.bmhome.resource.access;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes26.dex */
public abstract class j0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ResourceInputType f313688a;

    public static final class a extends j0 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f313689b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f313689b, ((a) r100).f313689b) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f313689b.hashCode();
        }

        public final String toString() {
            return "ContentUri(uri=" + this.f313689b + ')';
        }

        @Override // com.larus.bmhome.resource.access.j0
        public final String a() {
            return this.f313689b;
        }

        public a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "uri");
            super(ResourceInputType.CONTENT_URI);
            this.f313689b = r100;
        }
    }

    public static final class b extends j0 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f313690b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f313691c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Boolean f313692d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Long f313693e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final mr9.c f313694f;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f313690b, r101.f313690b) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f313691c, r101.f313691c) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f313692d, r101.f313692d) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f313693e, r101.f313693e) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f313694f, r101.f313694f) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f313690b.hashCode() * 31;
            String r101 = this.f313691c;
            int r102 = 0;
            if (r101 != null) goto L5;
            int r103 = 0;
        L6:
            int r104 = (r100 + r103) * 31;
            Boolean r105 = this.f313692d;
            if (r105 != null) goto L9;
            int r106 = 0;
        L10:
            int r107 = (r104 + r106) * 31;
            Long r108 = this.f313693e;
            if (r108 != null) goto L13;
            int r109 = 0;
        L14:
            int r110 = (r107 + r109) * 31;
            mr9.c r111 = this.f313694f;
            if (r111 == null) goto L19;
            r102 = r111.hashCode();
        L19:
            return r110 + r102;
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
            return "LocalPath(path=" + this.f313690b + ", originPath=" + this.f313691c + ", originPathIsUri=" + this.f313692d + ", uploadFileSize=" + this.f313693e + ", instantUploadPolicy=" + this.f313694f + ')';
        }

        @Override // com.larus.bmhome.resource.access.j0
        public final String a() {
            String r100 = this.f313691c;
            if (r100 == null) goto L13;
            if (r100.length() <= 0) goto L7;
            boolean r101 = true;
        L8:
            if (r101 == true) goto L11;
            r100 = null;
        L11:
            if (r100 == null) goto L13;
            return r100;
        L7:
            r101 = false;
        L13:
            return this.f313690b;
        }

        public /* synthetic */ b(String r100, String r110, Boolean r111, Long r112, int r113) {
            if ((r113 & 2) == 0) goto L5;
            String r101 = null;
        L7:
            if ((r113 & 4) == 0) goto L9;
            Boolean r102 = null;
        L11:
            if ((r113 & 8) == 0) goto L13;
            Long r103 = null;
        L14:
            this(r100, r101, r102, r103, null);
            return;
        L13:
            r103 = r112;
            goto L14
        L9:
            r102 = r111;
            goto L11
        L5:
            r101 = r110;
            goto L7
        }

        public b(String r100, String r101, Boolean r102, Long r103, mr9.c r104) {
            Intrinsics.checkNotNullParameter(r100, "path");
            super(ResourceInputType.LOCAL_PATH);
            this.f313690b = r100;
            this.f313691c = r101;
            this.f313692d = r102;
            this.f313693e = r103;
            this.f313694f = r104;
        }
    }

    public static final class c extends j0 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f313695b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f313695b, ((c) r100).f313695b) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f313695b.hashCode();
        }

        public final String toString() {
            return "RemoteUrl(url=" + this.f313695b + ')';
        }

        @Override // com.larus.bmhome.resource.access.j0
        public final String a() {
            return StringsKt.trim(this.f313695b).toString();
        }

        public c(String r100) {
            Intrinsics.checkNotNullParameter(r100, "url");
            super(ResourceInputType.REMOTE_URL);
            this.f313695b = r100;
        }
    }

    public static final class d extends j0 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f313696b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f313696b, ((d) r100).f313696b) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f313696b.hashCode();
        }

        public final String toString() {
            return "TosKey(tosKey=" + this.f313696b + ')';
        }

        @Override // com.larus.bmhome.resource.access.j0
        public final String a() {
            return this.f313696b;
        }

        public d(String r100) {
            Intrinsics.checkNotNullParameter(r100, "tosKey");
            super(ResourceInputType.TOS_KEY);
            this.f313696b = r100;
        }
    }

    public abstract String a();

    public final ResourceInputType getType() {
        return this.f313688a;
    }

    public j0(ResourceInputType r100) {
        this.f313688a = r100;
    }
}
