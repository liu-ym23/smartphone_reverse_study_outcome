package rk9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public abstract class k {

    public static final class a extends k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f538421a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            if (this.f538421a == ((a) r100).f538421a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            if (this.f538421a == false) goto L5;
            return 1231;
        L5:
            return 1237;
        }

        public final String toString() {
            return "BluetoothSco(wasBluetoothScoOn=" + this.f538421a + ')';
        }

        public a(boolean r100) {
            this.f538421a = r100;
        }
    }

    public static final class b extends k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f538422a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f538422a, ((b) r100).f538422a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            Object r100 = this.f538422a;
            if (r100 != null) goto L6;
            return 0;
        L6:
            return r100.hashCode();
        }

        public final String toString() {
            return "CommunicationDevice(device=" + this.f538422a + ')';
        }

        public b(Object r100) {
            this.f538422a = r100;
        }
    }

    public k() {
    }
}
