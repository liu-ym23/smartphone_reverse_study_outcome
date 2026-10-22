package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public abstract class i implements com.ss.android.lark.officesdk.minutes.service.foundation.mvi.repo.b {

    public static final class a extends i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f434769a = null;

        static {
            f434769a = new a();
        }

        public a() {
        }
    }

    public static final class b extends i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final HeadsetPromptSource f434770a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            if (this.f434770a == ((b) r100).f434770a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f434770a.hashCode();
        }

        public final String toString() {
            return "HeadsetForceRequired(source=" + this.f434770a + ')';
        }

        public b(HeadsetPromptSource r100) {
            Intrinsics.checkNotNullParameter(r100, "source");
            this.f434770a = r100;
        }
    }

    public static final class c extends i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final HeadsetPromptSource f434771a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L9;
            return false;
        L9:
            if (this.f434771a == ((c) r100).f434771a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f434771a.hashCode();
        }

        public final String toString() {
            return "HeadsetRecommended(source=" + this.f434771a + ')';
        }

        public c(HeadsetPromptSource r100) {
            Intrinsics.checkNotNullParameter(r100, "source");
            this.f434771a = r100;
        }
    }

    public static final class d extends i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f434772a = null;

        static {
            f434772a = new d();
        }

        public d() {
        }
    }

    public static final class e extends i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f434773a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof e) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f434773a, ((e) r100).f434773a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            String r100 = this.f434773a;
            if (r100 != null) goto L6;
            return 0;
        L6:
            return r100.hashCode();
        }

        public final String toString() {
            return "SpokenLanguageNotSupported(spokenLanguage=" + this.f434773a + ')';
        }

        public e(String r100) {
            this.f434773a = r100;
        }
    }

    public i() {
    }
}
