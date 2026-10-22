package db5;

import android.text.SpannableStringBuilder;
import io.reactivex.functions.Function;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes16.dex */
public class l implements Function<g, db5.a> {

    public class a implements Comparator<bo4.a> {
        public a() {
        }

        @Override // java.util.Comparator
        public final int compare(bo4.a r100, bo4.a r101) {
            return r100.f19811a - r101.f19811a;
        }
    }

    public class b implements Comparator<j> {
        public b() {
        }

        @Override // java.util.Comparator
        public final int compare(j r100, j r101) {
            return r100.f467826a - r101.f467826a;
        }
    }

    public l() {
    }

    public void e(SpannableStringBuilder r100, un5.k[] r101, List<bo4.a> r102) {
    }

    @Override // io.reactivex.functions.Function
    public final /* bridge */ /* synthetic */ db5.a apply(g r100) throws Exception {
        return c(r100);
    }

    public final db5.a c(g r310) throws Exception {
        SpannableStringBuilder r100 = new SpannableStringBuilder(r310.f467817a);
        int r101 = 0;
        Object[] r102 = (un5.d[]) r100.getSpans(0, r100.length(), un5.d.class);
        int r103 = r102.length;
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L5;
        Object r105 = r102[r104];
        r100.delete(r100.getSpanStart(r105), r100.getSpanEnd(r105));
        r104 = r104 + 1;
        goto L3
    L5:
        un5.l[] r106 = (un5.l[]) r100.getSpans(0, r100.length(), un5.l.class);
        un5.f[] r107 = (un5.f[]) r100.getSpans(0, r100.length(), un5.f.class);
        un5.e[] r108 = (un5.e[]) r100.getSpans(0, r100.length(), un5.e.class);
        un5.h[] r109 = (un5.h[]) r100.getSpans(0, r100.length(), un5.h.class);
        un5.k[] r110 = (un5.k[]) r100.getSpans(0, r100.length(), un5.k.class);
        LinkedList r111 = new LinkedList();
        int r112 = r106.length;
        int r113 = 0;
    L6:
        if (r113 >= r112) goto L12;
        un5.l r114 = r106[r113];
        int r115 = r100.getSpanStart(r114);
        int r116 = r100.getSpanEnd(r114);
        if (r115 == r116) goto L11;
        String r117 = r100.subSequence(r115, r116).toString();
        String r118 = r114.f550815d;
        String r119 = r114.f550816e;
        String r120 = r114.f550829r;
        String r121 = r114.f550817f;
        String r122 = r114.f550818g;
        boolean r123 = r114.f550823l;
        boolean r124 = r114.f550824m;
        r111.add(new bo4.a(r115, r116, 0, -1, r118, r119, r117, r121, r122, null, null, "", null, null, 0, r123, r114.f550825n, r124, r114.f550826o, "", "", r114.f550827p, null, r120, 0));
    L11:
        r113 = r113 + 1;
        goto L6
    L12:
        e(r100, r110, r111);
        int r125 = r107.length;
        int r126 = 0;
    L13:
        if (r126 >= r125) goto L19;
        un5.f r127 = r107[r126];
        int r128 = r100.getSpanStart(r127);
        int r129 = r100.getSpanEnd(r127);
        if (r128 == r129) goto L18;
        String r130 = r100.subSequence(r128, r129).toString();
        r111.add(new bo4.a(r128, r129, 6, -1, r127.f550796b, r127.f550797c, r130, null, null, null, null, "", null, null, 0, false, null, false, false, "", "", null, null, null, 0));
    L18:
        r126 = r126 + 1;
        goto L13
    L19:
        int r131 = r108.length;
    L20:
        if (r101 >= r131) goto L26;
        un5.e r132 = r108[r101];
        int r133 = r100.getSpanStart(r132);
        int r134 = r100.getSpanEnd(r132);
        if (r133 == r134) goto L25;
        String r135 = r100.subSequence(r133, r134).toString();
        int r136 = r132.getType();
        int r137 = r132.f550789g;
        String r138 = r132.f550786d;
        String r139 = r132.f550787e;
        int r140 = r132.f550792j;
        String r141 = r132.f550791i;
        String r142 = r132.f550790h;
        r111.add(new bo4.a(r133, r134, r136, r137, r138, r139, r135, null, null, null, null, r132.f550794l, r142, r141, r140, false, null, false, false, "", "", null, null, null, 0));
    L25:
        r101 = r101 + 1;
        goto L20
    L26:
        List<j> r143 = d(r100, r109);
        Collections.sort(r111, new a());
        Collections.sort(r143, new b());
        bo4.a[] r144 = new bo4.a[r111.size()];
        r111.toArray(r144);
        j[] r145 = new j[r143.size()];
        r143.toArray(r145);
        return new db5.a(r100.toString(), r144, r145);
    }

    public List<j> d(SpannableStringBuilder r110, un5.h[] r111) {
        LinkedList r100 = new LinkedList();
        int r101 = r111.length;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L9;
        un5.h r103 = r111[r102];
        int r104 = r110.getSpanStart(r103);
        int r105 = r110.getSpanEnd(r103);
        if (r104 == r105) goto L8;
        r100.add(new j(r104, r105, r110.subSequence(r104, r105).toString(), r103.f550805d.replace(" ", "")));
    L8:
        r102 = r102 + 1;
        goto L3
    L9:
        return r100;
    }
}
