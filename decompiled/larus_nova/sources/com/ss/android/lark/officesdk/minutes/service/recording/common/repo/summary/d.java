package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.summary;

/* JADX INFO: loaded from: classes37.dex */
public abstract class d implements com.ss.android.lark.officesdk.minutes.service.foundation.mvi.repo.b {

    public static final class a extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f435352a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            if (this.f435352a == ((a) r100).f435352a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            if (this.f435352a == false) goto L5;
            return 1231;
        L5:
            return 1237;
        }

        public final String toString() {
            return "FishBoneMarkResult(marked=" + this.f435352a + ')';
        }

        public a(boolean r100) {
            this.f435352a = r100;
        }
    }

    public static final class b extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f435353a = null;

        static {
            f435353a = new b();
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            b r101 = (b) r100;
            return true;
        }

        public final int hashCode() {
            return 1869041905;
        }

        public final String toString() {
            return "RequestVibrate";
        }

        public b() {
        }
    }

    public d() {
    }
}
