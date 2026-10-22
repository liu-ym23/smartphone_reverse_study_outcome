package ifa;

import com.larus.im.bean.message.block.Block;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public interface d {

    public static final class a implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Block f489672a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ifa.b f489673b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f489672a, r101.f489672a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f489673b, r101.f489673b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f489672a.hashCode() * 31) + this.f489673b.hashCode();
        }

        public final String toString() {
            return "File(block=" + this.f489672a + ", fileResult=" + this.f489673b + ')';
        }

        public a(Block r100, ifa.b r101) {
            Intrinsics.checkNotNullParameter(r100, "block");
            Intrinsics.checkNotNullParameter(r101, "fileResult");
            this.f489672a = r100;
            this.f489673b = r101;
        }
    }

    public static final class b implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Block f489674a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final c f489675b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f489674a, r101.f489674a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f489675b, r101.f489675b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f489674a.hashCode() * 31) + this.f489675b.hashCode();
        }

        public final String toString() {
            return "Media(block=" + this.f489674a + ", mediaItem=" + this.f489675b + ')';
        }

        public b(Block r100, c r101) {
            Intrinsics.checkNotNullParameter(r100, "block");
            Intrinsics.checkNotNullParameter(r101, "mediaItem");
            this.f489674a = r100;
            this.f489675b = r101;
        }
    }
}
