package com.larus.dora.obric.device_management.setting.g;

import com.bytedance.dora.device.DoraDevice;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public abstract class a {

    /* JADX INFO: renamed from: com.larus.dora.obric.device_management.setting.g.a$a, reason: collision with other inner class name */
    public static final class C4292a extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final DoraDevice f340259a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C4292a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f340259a, ((C4292a) r100).f340259a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f340259a.hashCode();
        }

        public final String toString() {
            return "NeedUnbind(device=" + this.f340259a + ')';
        }

        public C4292a(DoraDevice r100) {
            Intrinsics.checkNotNullParameter(r100, "device");
            this.f340259a = r100;
        }
    }

    public static final class b extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final DoraDevice f340260a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f340260a, ((b) r100).f340260a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            DoraDevice r100 = this.f340260a;
            if (r100 != null) goto L6;
            return 0;
        L6:
            return r100.hashCode();
        }

        public final String toString() {
            return "ShowConnectFailedDialog(device=" + this.f340260a + ')';
        }

        public b(DoraDevice r100) {
            this.f340260a = r100;
        }
    }

    public static final class c extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f340261a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L9;
            return false;
        L9:
            if (this.f340261a == ((c) r100).f340261a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f340261a;
        }

        public final String toString() {
            return "Toast(resId=" + this.f340261a + ')';
        }

        public c(int r100) {
            this.f340261a = r100;
        }
    }

    public static final class d extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f340262a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f340262a, ((d) r100).f340262a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f340262a.hashCode();
        }

        public final String toString() {
            return "ToastText(text=" + this.f340262a + ')';
        }

        public d(String r100) {
            Intrinsics.checkNotNullParameter(r100, "text");
            this.f340262a = r100;
        }
    }

    public static final class e extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f340263a = null;

        static {
            f340263a = new e();
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof e) == true) goto L9;
            return false;
        L9:
            e r101 = (e) r100;
            return true;
        }

        public final int hashCode() {
            return 466071147;
        }

        public final String toString() {
            return "UnbindSuccess";
        }

        public e() {
        }
    }

    public a() {
    }
}
