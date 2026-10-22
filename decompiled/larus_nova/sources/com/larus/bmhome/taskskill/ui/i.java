package com.larus.bmhome.taskskill.ui;

import com.larus.bmhome.taskskill.model.PcDevice;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public abstract class i {

    public static final class a extends i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f314568a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final String f314569b = null;

        static {
            f314568a = new a();
            f314569b = "add_computer";
        }

        public a() {
        }

        @Override // com.larus.bmhome.taskskill.ui.i
        public final String a() {
            return f314569b;
        }
    }

    public static final class b extends i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final PcDevice f314570a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f314571b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f314572c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f314570a, r101.f314570a) == true) goto L12;
            return false;
        L12:
            if (this.f314571b == r101.f314571b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f314570a.hashCode() * 31;
            if (this.f314571b == false) goto L5;
            int r101 = 1231;
        L7:
            return r100 + r101;
        L5:
            r101 = 1237;
            goto L7
        }

        public final String toString() {
            return "Device(device=" + this.f314570a + ", selected=" + this.f314571b + ')';
        }

        @Override // com.larus.bmhome.taskskill.ui.i
        public final String a() {
            return this.f314572c;
        }

        public b(PcDevice r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, "device");
            this.f314570a = r100;
            this.f314571b = r101;
            String r102 = r100.getDeviceId();
            if (r102 != null) goto L5;
            r102 = "";
        L5:
            this.f314572c = "device_".concat(r102);
        }
    }

    public static final class c extends i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f314573a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f314574b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L9;
            return false;
        L9:
            if (this.f314573a == ((c) r100).f314573a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            if (this.f314573a == false) goto L5;
            return 1231;
        L5:
            return 1237;
        }

        public final String toString() {
            return "DoNotUseComputer(selected=" + this.f314573a + ')';
        }

        @Override // com.larus.bmhome.taskskill.ui.i
        public final String a() {
            return this.f314574b;
        }

        public c(boolean r100) {
            this.f314573a = r100;
            this.f314574b = "do_not_use_computer";
        }
    }

    public static final class d extends i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f314575a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final String f314576b = null;

        static {
            f314575a = new d();
            f314576b = "loading";
        }

        public d() {
        }

        @Override // com.larus.bmhome.taskskill.ui.i
        public final String a() {
            return f314576b;
        }
    }

    public i() {
    }

    public abstract String a();
}
