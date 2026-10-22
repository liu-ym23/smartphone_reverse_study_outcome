package com.larus.dora.impl.wlan.wifi.add;

import com.larus.dora.impl.wlan.wifi.DoraWifiEntity;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public interface g {

    public static final class a implements g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f338285a = null;

        static {
            f338285a = new a();
        }

        public a() {
        }
    }

    public static final class b implements g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f338286a = null;

        static {
            f338286a = new b();
        }

        public b() {
        }
    }

    public static final class c implements g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<DoraWifiEntity> f338287a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f338287a, ((c) r100).f338287a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f338287a.hashCode();
        }

        public final String toString() {
            return "ScanResult(wifiList=" + this.f338287a + ')';
        }

        public c(List<DoraWifiEntity> r100) {
            Intrinsics.checkNotNullParameter(r100, "wifiList");
            this.f338287a = r100;
        }
    }

    public static final class d implements g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f338288a = null;

        static {
            f338288a = new d();
        }

        public d() {
        }
    }
}
