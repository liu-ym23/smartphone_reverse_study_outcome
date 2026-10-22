package com.larus.suggest.impl.wcb.render;

import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public interface o {

    public static final class a implements o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f370065a = null;

        static {
            f370065a = new a();
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
            return 810333684;
        }

        public final String toString() {
            return "Add";
        }
    }

    public static final class b implements o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f370066a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f370066a, ((b) r100).f370066a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f370066a.hashCode();
        }

        public final String toString() {
            return "Ignore(reason=" + this.f370066a + ')';
        }

        public b() {
            Intrinsics.checkNotNullParameter("regenerate target missing", "reason");
            this.f370066a = "regenerate target missing";
        }
    }

    public static final class c implements o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final p f370067a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f370067a, ((c) r100).f370067a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f370067a.hashCode();
        }

        public final String toString() {
            return "Update(target=" + this.f370067a + ')';
        }

        public c(p r100) {
            Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
            this.f370067a = r100;
        }
    }
}
