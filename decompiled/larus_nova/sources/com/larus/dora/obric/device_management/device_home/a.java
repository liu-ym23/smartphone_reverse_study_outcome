package com.larus.dora.obric.device_management.device_home;

import com.bytedance.dora.device.DoraDevice;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public interface a {

    /* JADX INFO: renamed from: com.larus.dora.obric.device_management.device_home.a$a, reason: collision with other inner class name */
    public static final class C4287a implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final DoraDevice f339166a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C4287a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f339166a, ((C4287a) r100).f339166a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f339166a.hashCode();
        }

        public final String toString() {
            return "NeedUnbind(device=" + this.f339166a + ')';
        }

        public C4287a(DoraDevice r100) {
            Intrinsics.checkNotNullParameter(r100, "device");
            this.f339166a = r100;
        }
    }

    public static final class b implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final DoraDevice f339167a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f339167a, ((b) r100).f339167a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f339167a.hashCode();
        }

        public final String toString() {
            return "ShowDisconnectFailedDialog(device=" + this.f339167a + ')';
        }

        public b(DoraDevice r100) {
            Intrinsics.checkNotNullParameter(r100, "device");
            this.f339167a = r100;
        }
    }

    public static final class c implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final DoraDevice f339168a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f339169b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.f339168a, r101.f339168a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f339169b, r101.f339169b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            DoraDevice r100 = this.f339168a;
            if (r100 != null) goto L5;
            int r101 = 0;
        L7:
            return (r101 * 31) + this.f339169b.hashCode();
        L5:
            r101 = r100.hashCode();
            goto L7
        }

        public final String toString() {
            return "ShowQuickActionReconnectDialog(device=" + this.f339168a + ", featureName=" + this.f339169b + ')';
        }

        public c(DoraDevice r100, String r101) {
            Intrinsics.checkNotNullParameter(r101, "featureName");
            this.f339168a = r100;
            this.f339169b = r101;
        }
    }
}
