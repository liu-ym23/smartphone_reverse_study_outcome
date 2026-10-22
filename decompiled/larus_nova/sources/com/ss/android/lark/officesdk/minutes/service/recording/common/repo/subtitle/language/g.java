package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public abstract class g implements com.ss.android.lark.officesdk.minutes.service.foundation.mvi.repo.b {

    public static final class a extends g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final h f435302a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f435302a, ((a) r100).f435302a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f435302a.hashCode();
        }

        public final String toString() {
            return "AutoTranslationApplied(language=" + this.f435302a + ')';
        }

        public a(h r100) {
            Intrinsics.checkNotNullParameter(r100, "language");
            this.f435302a = r100;
        }
    }

    public static final class b extends g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final h f435303a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f435303a, ((b) r100).f435303a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f435303a.hashCode();
        }

        public final String toString() {
            return "TranslateLanguageSetSuccess(language=" + this.f435303a + ')';
        }

        public b(h r100) {
            Intrinsics.checkNotNullParameter(r100, "language");
            this.f435303a = r100;
        }
    }

    public g() {
    }
}
