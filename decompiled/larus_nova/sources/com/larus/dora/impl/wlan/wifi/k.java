package com.larus.dora.impl.wlan.wifi;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public interface k {

    public static final class a implements k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f338307a = null;

        static {
            f338307a = new a();
        }

        public a() {
        }
    }

    public static final class b implements k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<DoraWifiEntity> f338308a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f338308a, ((b) r100).f338308a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f338308a.hashCode();
        }

        public final String toString() {
            return "Success(apList=" + this.f338308a + ')';
        }

        public b(List<DoraWifiEntity> r100) {
            Intrinsics.checkNotNullParameter(r100, "apList");
            this.f338308a = r100;
        }
    }
}
