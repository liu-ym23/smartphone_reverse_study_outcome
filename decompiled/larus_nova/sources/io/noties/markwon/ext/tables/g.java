package io.noties.markwon.ext.tables;

import android.text.Spanned;
import android.widget.TextView;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import org.commonmark.ext.gfm.tables.TableBlock;
import org.commonmark.ext.gfm.tables.TableBody;
import org.commonmark.ext.gfm.tables.TableCell;
import org.commonmark.ext.gfm.tables.TableHead;
import org.commonmark.ext.gfm.tables.TableRow;

/* JADX INFO: loaded from: classes5.dex */
public final class g extends lsc.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f492518a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final u f492519b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ctc.e f492520c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final f f492521d;

    /* JADX INFO: loaded from: classes41.dex */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f492522a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f492523b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f492524c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f492525d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final CharSequence f492526e;

        public final boolean equals(Object r100) {
            if (this != r100) goto L5;
        L15:
            return true;
        L5:
            if ((r100 instanceof a) == false) goto L14;
            a r101 = (a) r100;
            if (this.f492525d != r101.f492525d) goto L9;
            boolean r102 = true;
        L10:
            if (r102 == false) goto L14;
            if (Intrinsics.areEqual(this.f492526e, r101.f492526e) == false) goto L14;
        L9:
            r102 = false;
        L14:
            return false;
        }

        public final int hashCode() {
            int r100 = this.f492525d * 31;
            CharSequence r101 = this.f492526e;
            if (r101 == null) goto L5;
            int r102 = r101.hashCode();
        L7:
            return r100 + r102;
        L5:
            r102 = 0;
            goto L7
        }

        public final String toString() {
            return "Cell(alignment=" + this.f492525d + ", text=" + this.f492526e + ")";
        }

        public a(int r100, CharSequence r101) {
            this.f492525d = r100;
            this.f492526e = r101;
            this.f492522a = -1;
            this.f492523b = -1;
        }
    }

    /* JADX INFO: loaded from: classes41.dex */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f492527a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<a> f492528b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f492529c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L5;
        L20:
            return true;
        L5:
            if ((r100 instanceof b) == false) goto L19;
            b r101 = (b) r100;
            if (this.f492527a != r101.f492527a) goto L9;
            boolean r102 = true;
        L10:
            if (r102 == false) goto L19;
            if (Intrinsics.areEqual(this.f492528b, r101.f492528b) == false) goto L19;
            if (this.f492529c != r101.f492529c) goto L16;
            boolean r103 = true;
        L17:
            if (r103 == false) goto L19;
        L16:
            r103 = false;
            goto L17
        L9:
            r102 = false;
        L19:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v4, types: [int] */
        /* JADX WARN: Type inference failed for: r1v4, types: [int] */
        /* JADX WARN: Type inference failed for: r1v5 */
        /* JADX WARN: Type inference failed for: r1v7 */
        public final int hashCode() {
            int r100 = this.f492527a * 31;
            List<a> r101 = this.f492528b;
            if (r101 == null) goto L5;
            int r102 = r101.hashCode();
        L6:
            int r103 = (r100 + r102) * 31;
            boolean r104 = this.f492529c;
            ?? r105 = r104;
            if (r104 == false) goto L10;
            r105 = 1;
        L10:
            return r103 + r105;
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "Row(index=" + this.f492527a + ", cells=" + this.f492528b + ", isHeader=" + this.f492529c + ")";
        }

        public b(int r100, List<a> r101, boolean r102) {
            this.f492527a = r100;
            this.f492528b = r101;
            this.f492529c = r102;
        }
    }

    public final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<a> f492530a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<b> f492531b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f492532c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f492533d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ g f492534e;

        public c(g r100) {
            this.f492534e = r100;
            this.f492530a = new ArrayList();
            this.f492531b = new ArrayList();
        }
    }

    @Override // lsc.a, lsc.j
    public final void G4(TextView r100) {
        io.noties.markwon.ext.tables.a[] r101 = q.a(r100);
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.length > 0) goto L7;
        return;
    L7:
        if (r100.getTag(R.id.markwon_tables_scheduler) != null) goto L9;
        o r102 = new o(r100);
        r100.addOnAttachStateChangeListener(r102);
        r100.setTag(R.id.markwon_tables_scheduler, r102);
    L9:
        p r103 = new p(r100);
        int r104 = r101.length;
        int r105 = 0;
    L10:
        if (r105 >= r104) goto L15;
        r101[r105].f492506a = r103;
        r105 = r105 + 1;
        goto L10
    }

    @Override // lsc.a, lsc.j
    public final void c(lsc.p.a r100) {
        c r101 = this.f492518a;
        r101.getClass();
        r100.a(TableBlock.class, new h(r101));
        r100.a(TableTitle.class, i.f492536a);
        r100.a(TableBody.class, j.f492537a);
        r100.a(TableRow.class, new k(r101));
        r100.a(TableHead.class, new l(r101));
        r100.a(TableCell.class, new m(r101));
    }

    @Override // lsc.a, lsc.j
    public final void k(vvc.e.a r100) {
        r100.b(SetsKt.setOf(new v(this.f492521d)));
    }

    @Override // lsc.a, lsc.j
    public final void f(TextView r100, Spanned r101) {
        io.noties.markwon.ext.tables.a[] r102 = q.a(r100);
        if (r102 != null) goto L5;
        return;
    L5:
        if (r102.length <= 0) goto L11;
        int r103 = r102.length;
        int r104 = 0;
    L7:
        if (r104 >= r103) goto L12;
        r102[r104].f492506a = null;
        r104 = r104 + 1;
        goto L7
    L12:
        return;
    }

    public g(u r100, ctc.e r101, f r102) {
        this.f492519b = r100;
        this.f492520c = r101;
        this.f492521d = r102;
        this.f492518a = new c(this);
    }
}
