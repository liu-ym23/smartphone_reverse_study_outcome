package com.larus.dora.impl.onboarding;

import com.bytedance.dora.device.DoraDevice;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public interface q0 {

    public static final class a implements q0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final DoraDevice f337327a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f337327a, ((a) r100).f337327a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f337327a.hashCode();
        }

        public final String toString() {
            return "DeviceConnectFailed(device=" + this.f337327a + ')';
        }

        public a(DoraDevice r100) {
            Intrinsics.checkNotNullParameter(r100, "device");
            this.f337327a = r100;
        }
    }

    public static final class b implements q0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final DoraDevice f337328a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f337328a, ((b) r100).f337328a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f337328a.hashCode();
        }

        public final String toString() {
            return "DeviceConnected(device=" + this.f337328a + ')';
        }

        public b(DoraDevice r100) {
            Intrinsics.checkNotNullParameter(r100, "device");
            this.f337328a = r100;
        }
    }

    public static final class c implements q0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final DoraDevice f337329a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f337329a, ((c) r100).f337329a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f337329a.hashCode();
        }

        public final String toString() {
            return "DeviceConnecting(device=" + this.f337329a + ')';
        }

        public c(DoraDevice r100) {
            Intrinsics.checkNotNullParameter(r100, "device");
            this.f337329a = r100;
        }
    }

    public static final class d implements q0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final DoraDevice f337330a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f337330a, ((d) r100).f337330a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f337330a.hashCode();
        }

        public final String toString() {
            return "DeviceFound(device=" + this.f337330a + ')';
        }

        public d(DoraDevice r100) {
            Intrinsics.checkNotNullParameter(r100, "device");
            this.f337330a = r100;
        }
    }

    public static final class e implements q0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f337331a = null;

        static {
            f337331a = new e();
        }

        public e() {
        }
    }

    public static final class f implements q0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f337332a = null;

        static {
            f337332a = new f();
        }

        public f() {
        }
    }
}
