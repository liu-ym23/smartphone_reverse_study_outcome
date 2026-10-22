package com.larus.bmhome.chat.nestedmenu.ui;

import com.larus.bmhome.taskskill.model.PcDevice;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import di8.d0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public abstract class w {

    public static final class a extends w {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final d0 f308363a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f308364b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f308363a, ((a) r100).f308363a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f308363a.hashCode();
        }

        public final String toString() {
            return "CloudComputer(model=" + this.f308363a + ')';
        }

        @Override // com.larus.bmhome.chat.nestedmenu.ui.w
        public final String a() {
            return this.f308364b;
        }

        @Override // com.larus.bmhome.chat.nestedmenu.ui.w
        public final d0 b() {
            return this.f308363a;
        }

        public a(d0 r100) {
            Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
            this.f308363a = r100;
            this.f308364b = "cloud";
        }
    }

    public static final class b extends w {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final d0 f308365a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f308366b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f308365a, ((b) r100).f308365a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f308365a.hashCode();
        }

        public final String toString() {
            return "LocalDevice(model=" + this.f308365a + ')';
        }

        public final PcDevice c() {
            PcDevice r100 = v.a(this.f308365a);
            if (r100 == null) goto L6;
            return r100;
        L6:
            throw new IllegalArgumentException("Required value was null.".toString());
        }

        @Override // com.larus.bmhome.chat.nestedmenu.ui.w
        public final String a() {
            return this.f308366b;
        }

        @Override // com.larus.bmhome.chat.nestedmenu.ui.w
        public final d0 b() {
            return this.f308365a;
        }

        public b(d0 r100) {
            Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
            this.f308365a = r100;
            String r101 = c().getDeviceId();
            if (r101 != null) goto L5;
            r101 = "";
        L5:
            this.f308366b = "local_".concat(r101);
        }
    }

    public w() {
    }

    public abstract String a();

    public abstract d0 b();
}
