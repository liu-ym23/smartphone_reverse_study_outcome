package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta;

/* JADX INFO: loaded from: classes37.dex */
public abstract class d implements com.ss.android.lark.officesdk.minutes.service.foundation.mvi.repo.b {

    public static final class a extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f434917a = null;

        static {
            f434917a = new a();
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
            return 1295931848;
        }

        public final String toString() {
            return "AsrQuotaRecovered";
        }

        public a() {
        }
    }

    public d() {
    }
}
