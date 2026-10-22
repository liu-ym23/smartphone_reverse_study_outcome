package com.ss.android.lark.officesdk.minutes.ui.record.recording.subtitle.ui;

import com.ss.android.lark.officesdk.minutes.ui.record.recording.subtitle.MmSubtitleScrollMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public abstract class y implements com.ss.android.lark.officesdk.minutes.service.foundation.mvi.vm.j {

    public static final class a extends y {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f436546a = null;

        static {
            f436546a = new a();
        }

        public final String toString() {
            return "LoadForwardSubtitle";
        }

        public a() {
        }
    }

    public static final class b extends y {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote.k f436547a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f436547a, ((b) r100).f436547a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f436547a.hashCode();
        }

        public final String toString() {
            return "MarkSubtitle(request=" + this.f436547a + ')';
        }

        public b(com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote.k r100) {
            Intrinsics.checkNotNullParameter(r100, "request");
            this.f436547a = r100;
        }
    }

    public static final class c extends y {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final MmSubtitleScrollMode f436548a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L9;
            return false;
        L9:
            if (this.f436548a == ((c) r100).f436548a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f436548a.hashCode();
        }

        public final String toString() {
            return "SwitchScrollMode(" + this.f436548a + ')';
        }

        public c(MmSubtitleScrollMode r100) {
            Intrinsics.checkNotNullParameter(r100, "mode");
            this.f436548a = r100;
        }
    }

    public static final class d extends y {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f436549a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f436549a, ((d) r100).f436549a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f436549a.hashCode();
        }

        public final String toString() {
            return "UnmarkSubtitle(markId=" + this.f436549a + ')';
        }

        public d(String r100) {
            Intrinsics.checkNotNullParameter(r100, "markId");
            this.f436549a = r100;
        }
    }

    public y() {
    }
}
