package com.larus.dora.impl.device.settings.lab;

import com.larus.nova.R;

/* JADX INFO: loaded from: classes27.dex */
public interface b {

    public static final class a implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f334564a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            if (this.f334564a == ((a) r100).f334564a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f334564a;
        }

        public final String toString() {
            return "SetAllowDoubaoViewImagesSwitchFailed(toastResId=" + this.f334564a + ')';
        }

        public a() {
            this.f334564a = R.string.larus_dora_toast_update_failed_cn;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.lab.b$b, reason: collision with other inner class name */
    public static final class C4231b implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f334565a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C4231b) == true) goto L9;
            return false;
        L9:
            if (this.f334565a == ((C4231b) r100).f334565a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f334565a;
        }

        public final String toString() {
            return "SetBehaviorAwareSwitchFailed(toastResId=" + this.f334565a + ')';
        }

        public C4231b() {
            this.f334565a = R.string.larus_dora_toast_update_failed_cn;
        }
    }

    public static final class c implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f334566a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L9;
            return false;
        L9:
            if (this.f334566a == ((c) r100).f334566a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f334566a;
        }

        public final String toString() {
            return "SetQuickContinuousConversationSwitchFailed(toastResId=" + this.f334566a + ')';
        }

        public c(int r100) {
            this.f334566a = r100;
        }
    }

    public static final class d implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f334567a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L9;
            return false;
        L9:
            if (this.f334567a == ((d) r100).f334567a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f334567a;
        }

        public final String toString() {
            return "SetRTCTransportModeFailed(toastResId=" + this.f334567a + ')';
        }

        public d(int r100) {
            this.f334567a = r100;
        }
    }
}
