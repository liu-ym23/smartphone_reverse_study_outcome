package com.larus.bmhome.chat.component.bottom.core.inputtext.panel;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.larus.bmhome.chat.component.bottom.core.inputtext.t1;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public abstract class o {

    public static final class a {
    }

    public static final class b extends o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f299086a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f299086a, ((b) r100).f299086a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f299086a.hashCode();
        }

        public final String toString() {
            return "Header(title=" + this.f299086a + ')';
        }

        public b(String r100) {
            Intrinsics.checkNotNullParameter(r100, "title");
            this.f299086a = r100;
        }
    }

    public static final class c extends o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f299087a = null;

        static {
            f299087a = new c();
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L9;
            return false;
        L9:
            c r101 = (c) r100;
            return true;
        }

        public final int hashCode() {
            return 1636342859;
        }

        public final String toString() {
            return "Loading";
        }

        public c() {
        }
    }

    public static final class d extends o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f299088a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f299089b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f299090c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final float f299091d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final t1 f299092e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Integer f299093f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final Drawable f299094g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final Integer f299095h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final Integer f299096i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final Integer f299097j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final boolean f299098k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final String f299099l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final Function0<Unit> f299100m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final Function1<View, Unit> f299101n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final Function0<Unit> f299102o;

        public d() {
            throw null;
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L8;
            return false;
        L8:
            d r101 = (d) r100;
            if (Intrinsics.areEqual(this.f299088a, r101.f299088a) == true) goto L12;
            return false;
        L12:
            if (this.f299089b == r101.f299089b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f299090c, r101.f299090c) == true) goto L18;
            return false;
        L18:
            if (Float.compare(this.f299091d, r101.f299091d) == 0) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f299092e, r101.f299092e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f299093f, r101.f299093f) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.f299094g, r101.f299094g) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.f299095h, r101.f299095h) == true) goto L33;
            return false;
        L33:
            if (Intrinsics.areEqual(this.f299096i, r101.f299096i) == true) goto L36;
            return false;
        L36:
            if (Intrinsics.areEqual(this.f299097j, r101.f299097j) == true) goto L39;
            return false;
        L39:
            if (this.f299098k == r101.f299098k) goto L42;
            return false;
        L42:
            if (Intrinsics.areEqual(this.f299099l, r101.f299099l) == true) goto L45;
            return false;
        L45:
            if (Intrinsics.areEqual(this.f299100m, r101.f299100m) == true) goto L48;
            return false;
        L48:
            if (Intrinsics.areEqual(this.f299101n, r101.f299101n) == true) goto L51;
            return false;
        L51:
            if (Intrinsics.areEqual(this.f299102o, r101.f299102o) == true) goto L53;
            return false;
        L53:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f299088a.hashCode() * 31;
            int r101 = 1231;
            if (this.f299089b == false) goto L5;
            int r102 = 1231;
        L6:
            int r103 = (((((r100 + r102) * 31) + this.f299090c.hashCode()) * 31) + Float.floatToIntBits(this.f299091d)) * 31;
            t1 r104 = this.f299092e;
            int r105 = 0;
            if (r104 != null) goto L9;
            int r106 = 0;
        L10:
            int r107 = (r103 + r106) * 31;
            Integer r108 = this.f299093f;
            if (r108 != null) goto L13;
            int r109 = 0;
        L14:
            int r110 = (r107 + r109) * 31;
            Drawable r111 = this.f299094g;
            if (r111 != null) goto L17;
            int r112 = 0;
        L18:
            int r113 = (r110 + r112) * 31;
            Integer r114 = this.f299095h;
            if (r114 != null) goto L21;
            int r115 = 0;
        L22:
            int r116 = (r113 + r115) * 31;
            Integer r117 = this.f299096i;
            if (r117 != null) goto L25;
            int r118 = 0;
        L26:
            int r119 = (r116 + r118) * 31;
            Integer r120 = this.f299097j;
            if (r120 != null) goto L29;
            int r121 = 0;
        L30:
            int r122 = (r119 + r121) * 31;
            if (this.f299098k == true) goto L34;
            r101 = 1237;
        L34:
            int r123 = (r122 + r101) * 31;
            String r124 = this.f299099l;
            if (r124 != null) goto L37;
            int r125 = 0;
        L38:
            int r126 = (r123 + r125) * 31;
            Function0<Unit> r127 = this.f299100m;
            if (r127 != null) goto L41;
            int r128 = 0;
        L42:
            int r129 = (r126 + r128) * 31;
            Function1<View, Unit> r130 = this.f299101n;
            if (r130 == null) goto L47;
            r105 = r130.hashCode();
        L47:
            return ((r129 + r105) * 31) + this.f299102o.hashCode();
        L41:
            r128 = r127.hashCode();
            goto L42
        L37:
            r125 = r124.hashCode();
            goto L38
        L29:
            r121 = r120.hashCode();
            goto L30
        L25:
            r118 = r117.hashCode();
            goto L26
        L21:
            r115 = r114.hashCode();
            goto L22
        L17:
            r112 = r111.hashCode();
            goto L18
        L13:
            r109 = r108.hashCode();
            goto L14
        L9:
            r106 = r104.hashCode();
            goto L10
        L5:
            r102 = 1237;
            goto L6
        }

        public final String toString() {
            return "Row(title=" + this.f299088a + ", fadeTitleEnd=" + this.f299089b + ", description=" + this.f299090c + ", descriptionAlpha=" + this.f299091d + ", skillMatch=" + this.f299092e + ", iconRes=" + this.f299093f + ", iconDrawable=" + this.f299094g + ", iconTintColor=" + this.f299095h + ", trailingIconRes=" + this.f299096i + ", trailingIconTintColor=" + this.f299097j + ", enabled=" + this.f299098k + ", exposeId=" + this.f299099l + ", onShow=" + this.f299100m + ", onLongClick=" + this.f299101n + ", action=" + this.f299102o + ')';
        }

        public d(String r110, boolean r111, String r112, float r210, t1 r211, Integer r212, Drawable r213, Integer r214, Integer r215, Integer r216, String r217, Function0 r218, com.larus.bmhome.chat.component.bottom.core.inputtext.slash.m r219, Function0 r310, int r311) {
            boolean r100 = false;
            if ((r311 & 2) == 0) goto L5;
            boolean r101 = false;
        L7:
            if ((r311 & 4) == 0) goto L9;
            String r102 = "";
        L11:
            if ((r311 & 8) == 0) goto L13;
            float r103 = 0.55f;
        L14:
            com.larus.bmhome.chat.component.bottom.core.inputtext.slash.m r104 = null;
            if ((r311 & 16) == 0) goto L17;
            t1 r105 = null;
        L19:
            if ((r311 & 64) == 0) goto L21;
            Drawable r113 = null;
        L23:
            if ((r311 & 128) == 0) goto L25;
            Integer r114 = null;
        L27:
            if ((r311 & 256) == 0) goto L29;
            Integer r115 = null;
        L31:
            if ((r311 & 512) == 0) goto L33;
            Integer r116 = null;
        L35:
            if ((r311 & 1024) == 0) goto L38;
            r100 = true;
        L38:
            if ((r311 & 2048) == 0) goto L40;
            String r117 = null;
        L42:
            if ((r311 & 4096) == 0) goto L44;
            Function0 r118 = null;
        L46:
            if ((r311 & 8192) != 0) goto L49;
            r104 = r219;
        L49:
            Intrinsics.checkNotNullParameter(r110, "title");
            Intrinsics.checkNotNullParameter(r102, "description");
            Intrinsics.checkNotNullParameter(r310, "action");
            this.f299088a = r110;
            this.f299089b = r101;
            this.f299090c = r102;
            this.f299091d = r103;
            this.f299092e = r105;
            this.f299093f = r212;
            this.f299094g = r113;
            this.f299095h = r114;
            this.f299096i = r115;
            this.f299097j = r116;
            this.f299098k = r100;
            this.f299099l = r117;
            this.f299100m = r118;
            this.f299101n = r104;
            this.f299102o = r310;
            return;
        L44:
            r118 = r218;
            goto L46
        L40:
            r117 = r217;
            goto L42
        L33:
            r116 = r216;
            goto L35
        L29:
            r115 = r215;
            goto L31
        L25:
            r114 = r214;
            goto L27
        L21:
            r113 = r213;
            goto L23
        L17:
            r105 = r211;
            goto L19
        L13:
            r103 = r210;
            goto L14
        L9:
            r102 = r112;
            goto L11
        L5:
            r101 = r111;
            goto L7
        }
    }

    static {
    }

    public o() {
    }
}
