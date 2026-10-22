package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.meta;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public abstract class c implements com.ss.android.lark.officesdk.minutes.service.foundation.mvi.repo.b {

    public static final class a extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f435042a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f435043b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f435042a, r101.f435042a) == true) goto L12;
            return false;
        L12:
            if (this.f435043b == r101.f435043b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f435042a.hashCode() * 31;
            if (this.f435043b == false) goto L5;
            int r101 = 1231;
        L7:
            return r100 + r101;
        L5:
            r101 = 1237;
            goto L7
        }

        public final String toString() {
            return "UpdateTitleFailed(originalTitle=" + this.f435042a + ", isNetworkError=" + this.f435043b + ')';
        }

        public a(String r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, "originalTitle");
            this.f435042a = r100;
            this.f435043b = r101;
        }
    }

    public c() {
    }
}
