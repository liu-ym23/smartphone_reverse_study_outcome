package com.larus.dora.impl.device;

import com.larus.dora.impl.settings.DoraPushSummaryConfig;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public interface b {

    public static final class a implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f333581a = null;

        static {
            f333581a = new a();
        }

        public a() {
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.b$b, reason: collision with other inner class name */
    public static final class C4216b implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final sk4.e f333582a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final DoraPushSummaryConfig f333583b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C4216b) == true) goto L8;
            return false;
        L8:
            C4216b r101 = (C4216b) r100;
            if (Intrinsics.areEqual(this.f333582a, r101.f333582a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f333583b, r101.f333583b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f333582a.hashCode() * 31) + this.f333583b.hashCode();
        }

        public final String toString() {
            return "Success(protocolInfo=" + this.f333582a + ", proactiveSettings=" + this.f333583b + ')';
        }

        public C4216b(sk4.e r100, DoraPushSummaryConfig r101) {
            Intrinsics.checkNotNullParameter(r100, "protocolInfo");
            Intrinsics.checkNotNullParameter(r101, "proactiveSettings");
            this.f333582a = r100;
            this.f333583b = r101;
        }
    }
}
