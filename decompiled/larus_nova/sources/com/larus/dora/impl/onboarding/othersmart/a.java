package com.larus.dora.impl.onboarding.othersmart;

import com.bytedance.dora.device.DoraDevice;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public interface a {

    /* JADX INFO: renamed from: com.larus.dora.impl.onboarding.othersmart.a$a, reason: collision with other inner class name */
    public static final class C4273a implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final DoraDevice f337100a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C4273a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f337100a, ((C4273a) r100).f337100a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f337100a.hashCode();
        }

        public final String toString() {
            return "Connected(device=" + this.f337100a + ')';
        }

        public C4273a(DoraDevice r100) {
            Intrinsics.checkNotNullParameter(r100, "device");
            this.f337100a = r100;
        }
    }

    public static final class b implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f337101a = null;

        static {
            f337101a = new b();
        }

        public b() {
        }
    }
}
