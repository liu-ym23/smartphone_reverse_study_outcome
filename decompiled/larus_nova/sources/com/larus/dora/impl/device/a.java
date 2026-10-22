package com.larus.dora.impl.device;

import com.bytedance.dora.device.DoraDevice;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public interface a {

    /* JADX INFO: renamed from: com.larus.dora.impl.device.a$a, reason: collision with other inner class name */
    public static final class C4214a implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final DoraDevice f333500a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f333501b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C4214a) == true) goto L8;
            return false;
        L8:
            C4214a r101 = (C4214a) r100;
            if (Intrinsics.areEqual(this.f333500a, r101.f333500a) == true) goto L12;
            return false;
        L12:
            if (this.f333501b == r101.f333501b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f333500a.hashCode() * 31;
            if (this.f333501b == false) goto L5;
            int r101 = 1231;
        L7:
            return r100 + r101;
        L5:
            r101 = 1237;
            goto L7
        }

        public final String toString() {
            return "LaunchOnboarding(device=" + this.f333500a + ", autoConnect=" + this.f333501b + ')';
        }

        public C4214a(DoraDevice r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, "device");
            this.f333500a = r100;
            this.f333501b = r101;
        }
    }

    public static final class b implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final DoraDevice f333502a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f333502a, ((b) r100).f333502a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f333502a.hashCode();
        }

        public final String toString() {
            return "NeedUnbind(device=" + this.f333502a + ')';
        }

        public b(DoraDevice r100) {
            Intrinsics.checkNotNullParameter(r100, "device");
            this.f333502a = r100;
        }
    }

    public static final class c implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f333503a = null;

        static {
            f333503a = new c();
        }

        public c() {
        }
    }

    public static final class d implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f333504a = null;

        static {
            f333504a = new d();
        }

        public d() {
        }
    }
}
