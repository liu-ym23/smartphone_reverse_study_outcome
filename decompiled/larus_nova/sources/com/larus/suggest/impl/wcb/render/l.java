package com.larus.suggest.impl.wcb.render;

import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public interface l {

    public static final class a implements l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final i f370056a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f370057b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f370056a, r101.f370056a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f370057b, r101.f370057b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f370056a.hashCode() * 31;
            String r101 = this.f370057b;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return r100 + r102;
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        public final String toString() {
            return "Add(presentation=" + this.f370056a + ", localMessageId=" + this.f370057b + ')';
        }

        public a(i r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "presentation");
            this.f370056a = r100;
            this.f370057b = r101;
        }
    }

    public static final class b implements l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final p f370058a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f370058a, ((b) r100).f370058a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f370058a.hashCode();
        }

        public final String toString() {
            return "Deprecate(target=" + this.f370058a + ')';
        }

        public b(p r100) {
            Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
            this.f370058a = r100;
        }
    }

    public static final class c implements l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final p f370059a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final i f370060b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.f370059a, r101.f370059a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f370060b, r101.f370060b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f370059a.hashCode() * 31) + this.f370060b.hashCode();
        }

        public final String toString() {
            return "Update(target=" + this.f370059a + ", presentation=" + this.f370060b + ')';
        }

        public c(p r100, i r101) {
            Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
            Intrinsics.checkNotNullParameter(r101, "presentation");
            this.f370059a = r100;
            this.f370060b = r101;
        }
    }
}
