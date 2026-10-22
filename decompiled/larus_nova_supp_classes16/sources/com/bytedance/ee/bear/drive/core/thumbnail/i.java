package com.bytedance.ee.bear.drive.core.thumbnail;

import com.bytedance.ee.util.glide.BearGlideUrl;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public abstract class i {

    public static final class a extends i {
        public final File a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((a) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "DriveThumbnailImageSource.Local";
        }

        public a(File r2) {
            Intrinsics.checkNotNullParameter(r2, "file");
            this.a = r2;
        }
    }

    public static final class b extends i {
        public final BearGlideUrl a;
        public final DriveThumbnailRemoteSource b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "DriveThumbnailImageSource.Remote(remoteSource=" + this.b + ')';
        }

        public b(BearGlideUrl r2, DriveThumbnailRemoteSource r3) {
            Intrinsics.checkNotNullParameter(r2, "glideUrl");
            Intrinsics.checkNotNullParameter(r3, "remoteSource");
            this.a = r2;
            this.b = r3;
        }
    }

    public i() {
    }
}
