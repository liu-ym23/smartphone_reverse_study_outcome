package com.larus.dora.impl.device.manage.viewmodel;

import com.bytedance.dora.device.DoraDevice;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public interface a {

    /* JADX INFO: renamed from: com.larus.dora.impl.device.manage.viewmodel.a$a, reason: collision with other inner class name */
    public static final class C4221a implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final DoraDevice f334048a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C4221a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f334048a, ((C4221a) r100).f334048a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f334048a.hashCode();
        }

        public final String toString() {
            return "NeedUnbind(device=" + this.f334048a + ')';
        }

        public C4221a(DoraDevice r100) {
            Intrinsics.checkNotNullParameter(r100, "device");
            this.f334048a = r100;
        }
    }

    public static final class b implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final DoraDevice f334049a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f334049a, ((b) r100).f334049a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f334049a.hashCode();
        }

        public final String toString() {
            return "ShowDisconnectFailedDialog(device=" + this.f334049a + ')';
        }

        public b(DoraDevice r100) {
            Intrinsics.checkNotNullParameter(r100, "device");
            this.f334049a = r100;
        }
    }

    public static final class c implements a {
        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            ((c) r100).getClass();
            if (Intrinsics.areEqual(null, null) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            throw null;
        }

        public final String toString() {
            return "ShowFailureToast(text=null)";
        }
    }

    public static final class d implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final DoraDevice f334050a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f334050a, ((d) r100).f334050a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f334050a.hashCode();
        }

        public final String toString() {
            return "SwitchToDynamicPage(device=" + this.f334050a + ')';
        }

        public d(DoraDevice r100) {
            Intrinsics.checkNotNullParameter(r100, "device");
            this.f334050a = r100;
        }
    }
}
