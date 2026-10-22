package com.larus.dora.obric.device_management.setting.g;

import com.monitor.cloudmessage.consts.CloudControlInf;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public abstract class s {

    public static final class a extends s {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f340608a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Map<String, Object> f340609b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f340608a, r101.f340608a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f340609b, r101.f340609b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f340608a.hashCode() * 31) + this.f340609b.hashCode();
        }

        public final String toString() {
            return "Route(route=" + this.f340608a + ", params=" + this.f340609b + ')';
        }

        public a(String r100, Map<String, ? extends Object> r101) {
            Intrinsics.checkNotNullParameter(r100, CloudControlInf.ROUTE);
            Intrinsics.checkNotNullParameter(r101, "params");
            this.f340608a = r100;
            this.f340609b = r101;
        }
    }

    public s() {
    }
}
