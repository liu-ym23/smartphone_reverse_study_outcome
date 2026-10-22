package db5;

import android.text.SpannableStringBuilder;
import io.reactivex.functions.Function;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class l implements Function<g, db5.a> {

    public class a implements Comparator<bo4.a> {
        public a() {
        }

        @Override // java.util.Comparator
        public final int compare(bo4.a r1, bo4.a r2) {
            return r1.a - r2.a;
        }
    }

    public class b implements Comparator<j> {
        public b() {
        }

        @Override // java.util.Comparator
        public final int compare(j r1, j r2) {
            return r1.a - r2.a;
        }
    }

    public l() {
    }

    public void e(SpannableStringBuilder r1, un5.k[] r2, List<bo4.a> r3) {
    }

    public final /* bridge */ /* synthetic */ Object apply(Object r1) throws Exception {
        return c((g) r1);
    }

    public final db5.a c(g r39) throws Exception {
        SpannableStringBuilder r1 = new SpannableStringBuilder(r39.a);
        int r4 = 0;
        Object[] r2 = (un5.d[]) r1.getSpans(0, r1.length(), un5.d.class);
        int r3 = r2.length;
        int r5 = 0;
    L3:
        if (r5 >= r3) goto L5;
        Object r6 = r2[r5];
        r1.delete(r1.getSpanStart(r6), r1.getSpanEnd(r6));
        r5 = r5 + 1;
        goto L3
    L5:
        un5.l[] r7 = (un5.l[]) r1.getSpans(0, r1.length(), un5.l.class);
        un5.f[] r8 = (un5.f[]) r1.getSpans(0, r1.length(), un5.f.class);
        un5.e[] r9 = (un5.e[]) r1.getSpans(0, r1.length(), un5.e.class);
        un5.h[] r10 = (un5.h[]) r1.getSpans(0, r1.length(), un5.h.class);
        un5.k[] r11 = (un5.k[]) r1.getSpans(0, r1.length(), un5.k.class);
        LinkedList r12 = new LinkedList();
        int r13 = r7.length;
        int r14 = 0;
    L6:
        if (r14 >= r13) goto L12;
        un5.l r16 = r7[r14];
        int r17 = r1.getSpanStart(r16);
        int r18 = r1.getSpanEnd(r16);
        if (r17 == r18) goto L11;
        String r19 = r1.subSequence(r17, r18).toString();
        String r110 = r16.d;
        String r111 = r16.e;
        String r112 = r16.r;
        String r113 = r16.f;
        String r114 = r16.g;
        boolean r115 = r16.l;
        boolean r116 = r16.m;
        r12.add(new bo4.a(r17, r18, 0, -1, r110, r111, r19, r113, r114, null, null, "", null, null, 0, r115, r16.n, r116, r16.o, "", "", r16.p, null, r112, 0));
    L11:
        r14 = r14 + 1;
        goto L6
    L12:
        e(r1, r11, r12);
        int r20 = r8.length;
        int r21 = 0;
    L13:
        if (r21 >= r20) goto L19;
        un5.f r22 = r8[r21];
        int r117 = r1.getSpanStart(r22);
        int r118 = r1.getSpanEnd(r22);
        if (r117 == r118) goto L18;
        String r119 = r1.subSequence(r117, r118).toString();
        r12.add(new bo4.a(r117, r118, 6, -1, r22.b, r22.c, r119, null, null, null, null, "", null, null, 0, false, null, false, false, "", "", null, null, null, 0));
    L18:
        r21 = r21 + 1;
        goto L13
    L19:
        int r23 = r9.length;
    L20:
        if (r4 >= r23) goto L26;
        un5.e r24 = r9[r4];
        int r120 = r1.getSpanStart(r24);
        int r121 = r1.getSpanEnd(r24);
        if (r120 == r121) goto L25;
        String r122 = r1.subSequence(r120, r121).toString();
        int r123 = r24.getType();
        int r124 = r24.g;
        String r125 = r24.d;
        String r126 = r24.e;
        int r26 = r24.j;
        String r27 = r24.i;
        String r28 = r24.h;
        r12.add(new bo4.a(r120, r121, r123, r124, r125, r126, r122, null, null, null, null, r24.l, r28, r27, r26, false, null, false, false, "", "", null, null, null, 0));
    L25:
        r4 = r4 + 1;
        goto L20
    L26:
        List<j> r29 = d(r1, r10);
        Collections.sort(r12, new a());
        Collections.sort(r29, new b());
        bo4.a[] r30 = new bo4.a[r12.size()];
        r12.toArray(r30);
        j[] r31 = new j[r29.size()];
        r29.toArray(r31);
        return new db5.a(r1.toString(), r30, r31);
    }

    public List<j> d(SpannableStringBuilder r11, un5.h[] r12) {
        LinkedList r0 = new LinkedList();
        int r1 = r12.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L9;
        un5.h r3 = r12[r2];
        int r4 = r11.getSpanStart(r3);
        int r5 = r11.getSpanEnd(r3);
        if (r4 == r5) goto L8;
        r0.add(new j(r4, r5, r11.subSequence(r4, r5).toString(), r3.d.replace(" ", "")));
    L8:
        r2 = r2 + 1;
        goto L3
    L9:
        return r0;
    }
}
