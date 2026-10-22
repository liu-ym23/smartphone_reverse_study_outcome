package com.larus.dora.impl.onboarding;

import com.bytedance.dora.device.DoraDevice;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public interface o0 {

    public static final class a implements o0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f337034a = null;

        static {
            f337034a = new a();
        }

        public a() {
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            a r101 = (a) r100;
            return true;
        }

        public final int hashCode() {
            return 973411519;
        }

        public final String toString() {
            return "AuthDeviceFailed";
        }
    }

    public static final class b implements o0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final DoraDevice f337035a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f337035a, ((b) r100).f337035a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f337035a.hashCode();
        }

        public final String toString() {
            return "AuthDeviceSuccess(device=" + this.f337035a + ')';
        }

        public b(DoraDevice r100) {
            Intrinsics.checkNotNullParameter(r100, "device");
            this.f337035a = r100;
        }
    }

    public static final class c implements o0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final DoraDevice f337036a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f337036a, ((c) r100).f337036a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f337036a.hashCode();
        }

        public final String toString() {
            return "ShowNeedUnbindDialog(device=" + this.f337036a + ')';
        }

        public c(DoraDevice r100) {
            Intrinsics.checkNotNullParameter(r100, "device");
            this.f337036a = r100;
        }
    }

    public static final class d implements o0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f337037a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TOAST_TYPE f337038b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L8;
            return false;
        L8:
            d r101 = (d) r100;
            if (Intrinsics.areEqual(this.f337037a, r101.f337037a) == true) goto L12;
            return false;
        L12:
            if (this.f337038b == r101.f337038b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f337037a.hashCode() * 31) + this.f337038b.hashCode();
        }

        public final String toString() {
            return "ShowToast(text=" + this.f337037a + ", type=" + this.f337038b + ')';
        }

        public final TOAST_TYPE getType() {
            return this.f337038b;
        }

        public /* synthetic */ d(String r100) {
            this(r100, TOAST_TYPE.TOAST_TYPE_ERROR);
        }

        public d(String r100, TOAST_TYPE r101) {
            Intrinsics.checkNotNullParameter(r100, "text");
            Intrinsics.checkNotNullParameter(r101, "type");
            this.f337037a = r100;
            this.f337038b = r101;
        }
    }
}
