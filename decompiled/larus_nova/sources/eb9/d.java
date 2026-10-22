package eb9;

import com.larus.home.impl.main.side_bar.view.group.assembly.SideBarGroupSelectionId;
import com.larus.home.impl.main.side_bar.view.group.assembly.SideBarGroupToggleId;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public abstract class d {

    public static final class a extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Enum<?> f471859a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final k f471860b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final q f471861c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f471862d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f471859a, r101.f471859a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f471860b, r101.f471860b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f471861c, r101.f471861c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f471862d, r101.f471862d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            return (((((this.f471859a.hashCode() * 31) + this.f471860b.hashCode()) * 31) + this.f471861c.hashCode()) * 31) + this.f471862d.hashCode();
        }

        public final String toString() {
            return "Action(id=" + this.f471859a + ", ui=" + this.f471860b + ", handler=" + this.f471861c + ", groupId=" + this.f471862d + ')';
        }

        @Override // eb9.d
        public final String a() {
            return this.f471862d;
        }

        @Override // eb9.d
        public final q b() {
            return this.f471861c;
        }

        @Override // eb9.d
        public final Enum<?> c() {
            return this.f471859a;
        }

        public /* synthetic */ a(Enum r100, k r101, q r102) {
            this(r100, r101, r102, "");
        }

        public a(Enum<?> r100, k r101, q r102, String r103) {
            Intrinsics.checkNotNullParameter(r100, "id");
            Intrinsics.checkNotNullParameter(r101, "ui");
            Intrinsics.checkNotNullParameter(r102, "handler");
            Intrinsics.checkNotNullParameter(r103, "groupId");
            this.f471859a = r100;
            this.f471860b = r101;
            this.f471861c = r102;
            this.f471862d = r103;
        }
    }

    public static final class b extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Enum<?> f471863a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final k f471864b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Function1<o<?>, e> f471865c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Function1<o<?>, List<c>> f471866d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final q f471867e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String f471868f;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f471863a, r101.f471863a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f471864b, r101.f471864b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f471865c, r101.f471865c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f471866d, r101.f471866d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f471867e, r101.f471867e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f471868f, r101.f471868f) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            return (((((((((this.f471863a.hashCode() * 31) + this.f471864b.hashCode()) * 31) + this.f471865c.hashCode()) * 31) + this.f471866d.hashCode()) * 31) + this.f471867e.hashCode()) * 31) + this.f471868f.hashCode();
        }

        public final String toString() {
            return "Selection(id=" + this.f471863a + ", ui=" + this.f471864b + ", currentValue=" + this.f471865c + ", options=" + this.f471866d + ", handler=" + this.f471867e + ", groupId=" + this.f471868f + ')';
        }

        @Override // eb9.d
        public final String a() {
            return this.f471868f;
        }

        @Override // eb9.d
        public final q b() {
            return this.f471867e;
        }

        @Override // eb9.d
        public final Enum<?> c() {
            return this.f471863a;
        }

        public b(SideBarGroupSelectionId r100, k r101, Function1 r102, Function1 r103, q r104, String r105) {
            Intrinsics.checkNotNullParameter(r100, "id");
            Intrinsics.checkNotNullParameter(r101, "ui");
            Intrinsics.checkNotNullParameter(r102, "currentValue");
            Intrinsics.checkNotNullParameter(r103, "options");
            Intrinsics.checkNotNullParameter(r104, "handler");
            Intrinsics.checkNotNullParameter(r105, "groupId");
            this.f471863a = r100;
            this.f471864b = r101;
            this.f471865c = r102;
            this.f471866d = r103;
            this.f471867e = r104;
            this.f471868f = r105;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f471869a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final e f471870b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f471871c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.f471869a, r101.f471869a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f471870b, r101.f471870b) == true) goto L15;
            return false;
        L15:
            if (this.f471871c == r101.f471871c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = ((this.f471869a.hashCode() * 31) + this.f471870b.hashCode()) * 31;
            if (this.f471871c == false) goto L5;
            int r101 = 1231;
        L7:
            return r100 + r101;
        L5:
            r101 = 1237;
            goto L7
        }

        public final String toString() {
            return "SelectionOption(id=" + this.f471869a + ", title=" + this.f471870b + ", selected=" + this.f471871c + ')';
        }

        public c(String r100, e.b r101, boolean r102) {
            Intrinsics.checkNotNullParameter(r100, "id");
            Intrinsics.checkNotNullParameter(r101, "title");
            this.f471869a = r100;
            this.f471870b = r101;
            this.f471871c = r102;
        }
    }

    /* JADX INFO: renamed from: eb9.d$d, reason: collision with other inner class name */
    public static final class C5763d extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Enum<?> f471872a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final k f471873b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Function1<o<?>, Boolean> f471874c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final q f471875d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f471876e;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C5763d) == true) goto L8;
            return false;
        L8:
            C5763d r101 = (C5763d) r100;
            if (Intrinsics.areEqual(this.f471872a, r101.f471872a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f471873b, r101.f471873b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f471874c, r101.f471874c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f471875d, r101.f471875d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f471876e, r101.f471876e) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            return (((((((this.f471872a.hashCode() * 31) + this.f471873b.hashCode()) * 31) + this.f471874c.hashCode()) * 31) + this.f471875d.hashCode()) * 31) + this.f471876e.hashCode();
        }

        public final String toString() {
            return "Toggle(id=" + this.f471872a + ", ui=" + this.f471873b + ", checked=" + this.f471874c + ", handler=" + this.f471875d + ", groupId=" + this.f471876e + ')';
        }

        @Override // eb9.d
        public final String a() {
            return this.f471876e;
        }

        @Override // eb9.d
        public final q b() {
            return this.f471875d;
        }

        @Override // eb9.d
        public final Enum<?> c() {
            return this.f471872a;
        }

        public C5763d(SideBarGroupToggleId r100, k r101, com.larus.home.impl.main.side_bar.view.group.module.j r102, com.larus.home.impl.main.side_bar.view.group.module.i r103, String r104) {
            Intrinsics.checkNotNullParameter(r100, "id");
            Intrinsics.checkNotNullParameter(r101, "ui");
            Intrinsics.checkNotNullParameter(r102, "checked");
            Intrinsics.checkNotNullParameter(r103, "handler");
            Intrinsics.checkNotNullParameter(r104, "groupId");
            this.f471872a = r100;
            this.f471873b = r101;
            this.f471874c = r102;
            this.f471875d = r103;
            this.f471876e = r104;
        }
    }

    public d() {
    }

    public abstract String a();

    public abstract q b();

    public abstract Enum<?> c();
}
