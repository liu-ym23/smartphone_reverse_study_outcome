package com.bytedance.ee.bear.drive.core.thumbnail;

import com.bytedance.ee.util.glide.BearGlideUrl;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public abstract class i {

    public static final class a extends i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final File f224381a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f224381a, ((a) r100).f224381a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f224381a.hashCode();
        }

        public final String toString() {
            return "DriveThumbnailImageSource.Local";
        }

        public a(File r100) {
            Intrinsics.checkNotNullParameter(r100, "file");
            this.f224381a = r100;
        }
    }

    public static final class b extends i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final BearGlideUrl f224382a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final DriveThumbnailRemoteSource f224383b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f224382a, r101.f224382a) == true) goto L12;
            return false;
        L12:
            if (this.f224383b == r101.f224383b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f224382a.hashCode() * 31) + this.f224383b.hashCode();
        }

        public final String toString() {
            return "DriveThumbnailImageSource.Remote(remoteSource=" + this.f224383b + ')';
        }

        public b(BearGlideUrl r100, DriveThumbnailRemoteSource r101) {
            Intrinsics.checkNotNullParameter(r100, "glideUrl");
            Intrinsics.checkNotNullParameter(r101, "remoteSource");
            this.f224382a = r100;
            this.f224383b = r101;
        }
    }

    public i() {
    }
}
