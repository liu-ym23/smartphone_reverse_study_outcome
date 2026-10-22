package com.larus.dora.impl.device;

import com.bytedance.dora.device.DoraDevice;
import com.larus.dora.impl.DoraSimpleDevice;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public interface c {

    public static final class a implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f333620a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final DoraDevice f333621b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f333620a == r101.f333620a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f333621b, r101.f333621b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            long r100 = this.f333620a;
            return (((int) (r100 ^ (r100 >>> 32))) * 31) + this.f333621b.hashCode();
        }

        public final String toString() {
            return "Connected(seq=" + this.f333620a + ", device=" + this.f333621b + ')';
        }

        public a(long r100, DoraDevice r101) {
            Intrinsics.checkNotNullParameter(r101, "device");
            this.f333620a = r100;
            this.f333621b = r101;
        }
    }

    public static final class b implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f333622a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final DoraSimpleDevice f333623b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (this.f333622a == r101.f333622a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f333623b, r101.f333623b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            if (this.f333622a == false) goto L5;
            int r100 = 1231;
        L6:
            int r101 = r100 * 31;
            DoraSimpleDevice r102 = this.f333623b;
            if (r102 != null) goto L9;
            int r103 = 0;
        L11:
            return r101 + r103;
        L9:
            r103 = r102.hashCode();
            goto L11
        L5:
            r100 = 1237;
            goto L6
        }

        public final String toString() {
            return "Disconnected(isRetrying=" + this.f333622a + ", lastConnectedDevice=" + this.f333623b + ')';
        }

        public b(boolean r100, DoraSimpleDevice r101) {
            this.f333622a = r100;
            this.f333623b = r101;
        }

        public static b a(b r100, boolean r101) {
            DoraSimpleDevice r102 = r100.f333623b;
            r100.getClass();
            return new b(r101, r102);
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.c$c, reason: collision with other inner class name */
    public static final class C4217c implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C4217c f333624a = null;

        static {
            f333624a = new C4217c();
        }

        public C4217c() {
        }
    }

    public static final class d implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f333625a = null;

        static {
            f333625a = new d();
        }

        public d() {
        }
    }
}
