package eab;

import com.ss.android.lark.widget.table.entity.Column;
import com.ss.android.lark.widget.table.entity.HorizontalAlign;
import com.ss.android.lark.widget.table.entity.VerticalAlign;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import v7b.f0;
import v7b.s;

/* JADX INFO: loaded from: classes35.dex */
public final class h extends v7b.a {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f471752j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final List<Column> f471753k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final List<b> f471754l;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f471755a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f471756b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final HorizontalAlign f471757c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final VerticalAlign f471758d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f471759e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final s f471760f;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f471755a == r101.f471755a) goto L12;
            return false;
        L12:
            if (this.f471756b == r101.f471756b) goto L15;
            return false;
        L15:
            if (this.f471757c == r101.f471757c) goto L18;
            return false;
        L18:
            if (this.f471758d == r101.f471758d) goto L21;
            return false;
        L21:
            if (this.f471759e == r101.f471759e) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f471760f, r101.f471760f) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            int r100 = ((this.f471755a * 31) + this.f471756b) * 31;
            HorizontalAlign r101 = this.f471757c;
            int r102 = 0;
            if (r101 != null) goto L5;
            int r103 = 0;
        L6:
            int r104 = (r100 + r103) * 31;
            VerticalAlign r105 = this.f471758d;
            if (r105 == null) goto L10;
            r102 = r105.hashCode();
        L10:
            int r106 = (r104 + r102) * 31;
            if (this.f471759e == false) goto L13;
            int r107 = 1231;
        L15:
            return ((r106 + r107) * 31) + this.f471760f.hashCode();
        L13:
            r107 = 1237;
            goto L15
        L5:
            r103 = r101.hashCode();
            goto L6
        }

        public final String toString() {
            return "TableCellData(columnSpan=" + this.f471755a + ", rowSpan=" + this.f471756b + ", horizontalAlign=" + this.f471757c + ", verticalAlign=" + this.f471758d + ", isMerged=" + this.f471759e + ", content=" + this.f471760f + ')';
        }

        public a(int r100, int r101, HorizontalAlign r102, VerticalAlign r103, boolean r104, v7b.e r105) {
            Intrinsics.checkNotNullParameter(r105, "content");
            this.f471755a = r100;
            this.f471756b = r101;
            this.f471757c = r102;
            this.f471758d = r103;
            this.f471759e = r104;
            this.f471760f = r105;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f471761a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final HorizontalAlign f471762b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final VerticalAlign f471763c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final List<a> f471764d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (this.f471761a == r101.f471761a) goto L12;
            return false;
        L12:
            if (this.f471762b == r101.f471762b) goto L15;
            return false;
        L15:
            if (this.f471763c == r101.f471763c) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f471764d, r101.f471764d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            if (this.f471761a == false) goto L5;
            int r100 = 1231;
        L6:
            int r101 = r100 * 31;
            HorizontalAlign r102 = this.f471762b;
            int r103 = 0;
            if (r102 != null) goto L9;
            int r104 = 0;
        L10:
            int r105 = (r101 + r104) * 31;
            VerticalAlign r106 = this.f471763c;
            if (r106 == null) goto L15;
            r103 = r106.hashCode();
        L15:
            return ((r105 + r103) * 31) + this.f471764d.hashCode();
        L9:
            r104 = r102.hashCode();
            goto L10
        L5:
            r100 = 1237;
            goto L6
        }

        public final String toString() {
            return "TableRowData(isHeader=" + this.f471761a + ", horizontalAlign=" + this.f471762b + ", verticalAlign=" + this.f471763c + ", tableCells=" + this.f471764d + ')';
        }

        public b(boolean r100, HorizontalAlign r101, VerticalAlign r102, List<a> r103) {
            Intrinsics.checkNotNullParameter(r103, "tableCells");
            this.f471761a = r100;
            this.f471762b = r101;
            this.f471763c = r102;
            this.f471764d = r103;
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h) == true) goto L8;
        return false;
    L8:
        h r101 = (h) r100;
        if (Intrinsics.areEqual(this.f471752j, r101.f471752j) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f471753k, r101.f471753k) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f471754l, r101.f471754l) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f471752j.hashCode() * 31) + this.f471753k.hashCode()) * 31) + this.f471754l.hashCode();
    }

    @Override // v7b.s
    public final String toString() {
        return "TableNode(id=" + this.f471752j + ", columns=" + this.f471753k + ", tableRows=" + this.f471754l + ')';
    }

    @Override // v7b.s
    public final s h() {
        return new h(this.f471752j, this.f471753k, this.f471754l);
    }

    @Override // v7b.s
    public final void c(f0 r100) {
        if (r100 == null) goto L5;
        r100.a(this);
        return;
    }

    public h(String r100, List<Column> r101, List<b> r102) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, "columns");
        Intrinsics.checkNotNullParameter(r102, "tableRows");
        this.f471752j = r100;
        this.f471753k = r101;
        this.f471754l = r102;
    }
}
