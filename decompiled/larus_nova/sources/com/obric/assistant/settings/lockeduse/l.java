package com.obric.assistant.settings.lockeduse;

import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public abstract class l {

    public static final class a extends l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f392127a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            if (this.f392127a == ((a) r100).f392127a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f392127a;
        }

        public final String toString() {
            return "Hint(textRes=" + this.f392127a + ')';
        }

        public a(int r100) {
            this.f392127a = r100;
        }
    }

    public static final class b extends l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f392128a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f392129b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Integer f392130c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f392131d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f392128a, r101.f392128a) == true) goto L12;
            return false;
        L12:
            if (this.f392129b == r101.f392129b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f392130c, r101.f392130c) == true) goto L18;
            return false;
        L18:
            if (this.f392131d == r101.f392131d) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r100 = ((this.f392128a.hashCode() * 31) + this.f392129b) * 31;
            Integer r101 = this.f392130c;
            if (r101 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = (r100 + r102) * 31;
            if (this.f392131d == false) goto L9;
            int r104 = 1231;
        L11:
            return r103 + r104;
        L9:
            r104 = 1237;
            goto L11
        L5:
            r102 = r101.hashCode();
            goto L6
        }

        public final String toString() {
            return "Item(id=" + this.f392128a + ", titleRes=" + this.f392129b + ", subtitleRes=" + this.f392130c + ", enabled=" + this.f392131d + ')';
        }

        public b(String r100, int r101, Integer r102, boolean r103) {
            Intrinsics.checkNotNullParameter(r100, "id");
            this.f392128a = r100;
            this.f392129b = r101;
            this.f392130c = r102;
            this.f392131d = r103;
        }
    }

    public static final class c extends l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f392132a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L9;
            return false;
        L9:
            if (this.f392132a == ((c) r100).f392132a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f392132a;
        }

        public final String toString() {
            return "SectionTitle(titleRes=" + this.f392132a + ')';
        }

        public c() {
            this.f392132a = R.string.obric_setting_locked_use_section_title;
        }
    }

    public static final class d extends l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f392133a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f392134b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f392135c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f392136d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Integer f392137e;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L8;
            return false;
        L8:
            d r101 = (d) r100;
            if (this.f392133a == r101.f392133a) goto L12;
            return false;
        L12:
            if (this.f392134b == r101.f392134b) goto L15;
            return false;
        L15:
            if (this.f392135c == r101.f392135c) goto L18;
            return false;
        L18:
            if (this.f392136d == r101.f392136d) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f392137e, r101.f392137e) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            int r100 = ((this.f392133a * 31) + this.f392134b) * 31;
            int r101 = 1231;
            if (this.f392135c == false) goto L5;
            int r102 = 1231;
        L6:
            int r103 = (r100 + r102) * 31;
            if (this.f392136d == true) goto L10;
            r101 = 1237;
        L10:
            int r104 = (r103 + r101) * 31;
            Integer r105 = this.f392137e;
            if (r105 != null) goto L13;
            int r106 = 0;
        L15:
            return r104 + r106;
        L13:
            r106 = r105.hashCode();
            goto L15
        L5:
            r102 = 1237;
            goto L6
        }

        public final String toString() {
            return "Switch(titleRes=" + this.f392133a + ", subtitleRes=" + this.f392134b + ", enabled=" + this.f392135c + ", switchEnabled=" + this.f392136d + ", disabledToastTextRes=" + this.f392137e + ')';
        }

        public d(int r100, int r101, boolean r102, boolean r103, Integer r104) {
            this.f392133a = r100;
            this.f392134b = r101;
            this.f392135c = r102;
            this.f392136d = r103;
            this.f392137e = r104;
        }
    }

    public l() {
    }
}
