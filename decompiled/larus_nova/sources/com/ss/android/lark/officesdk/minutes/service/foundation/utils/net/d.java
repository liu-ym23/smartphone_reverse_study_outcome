package com.ss.android.lark.officesdk.minutes.service.foundation.utils.net;

import com.ss.android.lark.pb.videochat.Image;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public interface d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f434054a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f434055a = null;

        static {
            f434055a = new a();
        }

        public a() {
        }
    }

    public static final class b implements d {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f434056b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f434057c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f434058d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f434059e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Image f434060f;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f434056b, r101.f434056b) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f434057c, r101.f434057c) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f434058d, r101.f434058d) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f434059e, r101.f434059e) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f434060f, r101.f434060f) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            int r100 = ((((((this.f434056b.hashCode() * 31) + this.f434057c.hashCode()) * 31) + this.f434058d.hashCode()) * 31) + this.f434059e.hashCode()) * 31;
            Image r101 = this.f434060f;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return r100 + r102;
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        public final String toString() {
            return "Lark(id=" + this.f434056b + ", name=" + this.f434057c + ", department=" + this.f434058d + ", avatarKey=" + this.f434059e + ", image=" + this.f434060f + ')';
        }

        public b(String r100, String r101, String r102, String r103, Image r104) {
            Intrinsics.checkNotNullParameter(r100, "id");
            Intrinsics.checkNotNullParameter(r101, "name");
            Intrinsics.checkNotNullParameter(r102, "department");
            Intrinsics.checkNotNullParameter(r103, "avatarKey");
            this.f434056b = r100;
            this.f434057c = r101;
            this.f434058d = r102;
            this.f434059e = r103;
            this.f434060f = r104;
        }
    }

    public static final class c implements d {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f434061b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f434062c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f434063d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.f434061b, r101.f434061b) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f434062c, r101.f434062c) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f434063d, r101.f434063d) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.f434061b.hashCode() * 31) + this.f434062c.hashCode()) * 31) + this.f434063d.hashCode();
        }

        public final String toString() {
            return "NonLark(id=" + this.f434061b + ", name=" + this.f434062c + ", avatarUrl=" + this.f434063d + ')';
        }

        public c(String r100, String r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, "id");
            Intrinsics.checkNotNullParameter(r101, "name");
            Intrinsics.checkNotNullParameter(r102, "avatarUrl");
            this.f434061b = r100;
            this.f434062c = r101;
            this.f434063d = r102;
        }
    }

    static {
        f434054a = a.f434055a;
    }
}
