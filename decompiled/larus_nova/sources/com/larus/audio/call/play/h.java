package com.larus.audio.call.play;

import java.util.Arrays;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import ouc.d0;

/* JADX INFO: loaded from: classes24.dex */
public abstract class h {

    public static final class a extends h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final byte[] f289331a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f289332b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f289333c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final d0 f289334d;

        public final String toString() {
            return "Play(data=" + Arrays.toString(this.f289331a) + ", sectionId=" + this.f289332b + ", queryRound=" + this.f289333c + ", extra=" + this.f289334d + ')';
        }

        public final int hashCode() {
            int r100 = ((Arrays.hashCode(this.f289331a) * 31) + this.f289332b.hashCode()) * 31;
            d0 r101 = this.f289334d;
            if (r101 == null) goto L5;
            int r102 = r101.hashCode();
        L7:
            return r100 + r102;
        L5:
            r102 = 0;
            goto L7
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if (r100 != null) goto L9;
            return false;
        L9:
            if (a.class == r100.getClass()) goto L11;
            return false;
        L11:
            a r101 = (a) r100;
            if (Arrays.equals(this.f289331a, r101.f289331a) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f289332b, r101.f289332b) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f289334d, r101.f289334d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public a(byte[] r100, String r101, String r102, d0 r103) {
            Intrinsics.checkNotNullParameter(r100, "data");
            Intrinsics.checkNotNullParameter(r101, "sectionId");
            Intrinsics.checkNotNullParameter(r102, "queryRound");
            this.f289331a = r100;
            this.f289332b = r101;
            this.f289333c = r102;
            this.f289334d = r103;
        }
    }

    public static final class b extends h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f289335a = null;

        static {
            f289335a = new b();
        }

        public b() {
        }
    }

    public static final class c extends h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map<String, String> f289336a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f289336a, ((c) r100).f289336a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            Map<String, String> r100 = this.f289336a;
            if (r100 != null) goto L6;
            return 0;
        L6:
            return r100.hashCode();
        }

        public final String toString() {
            return "TtsStart(extra=" + this.f289336a + ')';
        }

        public c(Map<String, String> r100) {
            this.f289336a = r100;
        }
    }

    public static final class d extends h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final byte[] f289337a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f289337a, ((d) r100).f289337a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return Arrays.hashCode(this.f289337a);
        }

        public final String toString() {
            return "Warmup(data=" + Arrays.toString(this.f289337a) + ')';
        }

        public d(byte[] r100) {
            Intrinsics.checkNotNullParameter(r100, "data");
            this.f289337a = r100;
        }
    }

    public h() {
    }
}
