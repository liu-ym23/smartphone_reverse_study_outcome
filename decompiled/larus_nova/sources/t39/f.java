package t39;

import com.larus.dora.api.DoraServerResourceSource;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public abstract class f {

    public static final class a extends f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f544467a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            if (this.f544467a == ((a) r100).f544467a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f544467a;
        }

        public final String toString() {
            return "Apk(resourceId=" + this.f544467a + ')';
        }

        public a(int r100) {
            this.f544467a = r100;
            DoraServerResourceSource r101 = DoraServerResourceSource.APK;
        }
    }

    public static final class b extends f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final File f544468a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final DoraServerResourceSource f544469b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f544468a, r101.f544468a) == true) goto L12;
            return false;
        L12:
            if (this.f544469b == r101.f544469b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f544468a.hashCode() * 31) + this.f544469b.hashCode();
        }

        public final String toString() {
            return "FileResource(file=" + this.f544468a + ", source=" + this.f544469b + ')';
        }

        public b(File r100, DoraServerResourceSource r101) {
            Intrinsics.checkNotNullParameter(r100, "file");
            Intrinsics.checkNotNullParameter(r101, "source");
            this.f544468a = r100;
            this.f544469b = r101;
            if (r101 == DoraServerResourceSource.APK) goto L5;
            boolean r102 = true;
        L6:
            if (r102 == false) goto L9;
            return;
        L9:
            throw new IllegalArgumentException("Failed requirement.".toString());
        L5:
            r102 = false;
            goto L6
        }
    }

    public f() {
    }
}
