package com.larus.dora.impl.device.ailab;

import com.larus.nova.R;

/* JADX INFO: loaded from: classes27.dex */
public interface b {

    public static final class a implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f333535a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            if (this.f333535a == ((a) r100).f333535a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f333535a;
        }

        public final String toString() {
            return "UpDatePrecaptureUploadFailed(toastResId=" + this.f333535a + ')';
        }

        public a() {
            this.f333535a = R.string.larus_dora_onboarding_button_setting_failed_cn;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.ailab.b$b, reason: collision with other inner class name */
    public static final class C4215b implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f333536a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C4215b) == true) goto L9;
            return false;
        L9:
            if (this.f333536a == ((C4215b) r100).f333536a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f333536a;
        }

        public final String toString() {
            return "UpdateConvStartEndSoundFailed(taostResId=" + this.f333536a + ')';
        }

        public C4215b() {
            this.f333536a = R.string.larus_dora_setting_failed_default_cn;
        }
    }
}
