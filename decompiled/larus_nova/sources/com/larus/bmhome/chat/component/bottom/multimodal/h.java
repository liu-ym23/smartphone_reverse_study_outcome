package com.larus.bmhome.chat.component.bottom.multimodal;

import android.view.View;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public interface h extends t1a.a {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f299779a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f299780b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f299781c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f299782d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f299783e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Function1<View, Unit> f299784f;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f299779a, r101.f299779a) == true) goto L12;
            return false;
        L12:
            if (this.f299780b == r101.f299780b) goto L15;
            return false;
        L15:
            if (this.f299781c == r101.f299781c) goto L18;
            return false;
        L18:
            if (this.f299782d == r101.f299782d) goto L21;
            return false;
        L21:
            if (this.f299783e == r101.f299783e) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f299784f, r101.f299784f) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            int r100 = ((((this.f299779a.hashCode() * 31) + this.f299780b) * 31) + this.f299781c) * 31;
            int r101 = 1231;
            if (this.f299782d == false) goto L5;
            int r102 = 1231;
        L6:
            int r103 = (r100 + r102) * 31;
            if (this.f299783e == true) goto L10;
            r101 = 1237;
        L10:
            int r104 = (r103 + r101) * 31;
            Function1<View, Unit> r105 = this.f299784f;
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
            return "PanelItemConfig(id=" + this.f299779a + ", iconRes=" + this.f299780b + ", nameRes=" + this.f299781c + ", enabled=" + this.f299782d + ", visible=" + this.f299783e + ", onClick=" + this.f299784f + ')';
        }

        public static a a(a r100, Function1 r101) {
            String r102 = r100.f299779a;
            int r103 = r100.f299780b;
            int r104 = r100.f299781c;
            boolean r105 = r100.f299782d;
            boolean r106 = r100.f299783e;
            Intrinsics.checkNotNullParameter(r102, "id");
            return new a(r102, r103, r104, r105, r106, r101);
        }

        public /* synthetic */ a(String r100, int r101, int r110, Function1 r111) {
            this(r100, r101, r110, true, true, r111);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a(String r100, int r101, int r102, boolean r103, boolean r104, Function1<? super View, Unit> r105) {
            Intrinsics.checkNotNullParameter(r100, "id");
            this.f299779a = r100;
            this.f299780b = r101;
            this.f299781c = r102;
            this.f299782d = r103;
            this.f299783e = r104;
            this.f299784f = r105;
        }
    }

    public interface b {
        List<a> a(List<a> r100);
    }

    void d6();

    void q80(b r100);

    void xp(b r100);
}
