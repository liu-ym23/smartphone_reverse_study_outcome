package fh8;

import android.text.Spanned;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.noties.markwon.core.spans.CustomLinkSpan;
import io.noties.markwon.ext.tables.TableRowSpan2;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import org.commonmark.node.Code;
import org.commonmark.node.HardLineBreak;
import org.commonmark.node.SoftLineBreak;
import org.commonmark.node.Text;

/* JADX INFO: loaded from: classes25.dex */
public final class o {

    public static final class a<T> implements Comparator {
        public a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            return ComparisonsKt.compareValues((Integer) ((Pair) r100).getFirst(), (Integer) ((Pair) r101).getFirst());
        }
    }

    public static final List<k> a(final lw8.l r110) {
        Intrinsics.checkNotNullParameter(r110, "<this>");
        Lazy r100 = LazyKt.lazy(LazyThreadSafetyMode.NONE, new m(r110));
        List r101 = c(r110.e(), CustomLinkSpan.class);
        ArrayList r102 = new ArrayList();
        Iterator r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L29;
        CustomLinkSpan r104 = (CustomLinkSpan) r103.next();
        int r105 = r110.e().getSpanStart(r104);
        int r106 = r110.e().getSpanEnd(r104);
        int r107 = 0;
        k r108 = null;
        if (r105 >= 0) goto L8;
    L15:
        Iterator r109 = ((List) r100.getValue()).iterator();
    L17:
        if (r109.hasNext() == false) goto L22;
        if (Intrinsics.areEqual(((lw8.k) r109.next()).f511084a, r104.f492298b) == true) goto L23;
        r107 = r107 + 1;
    L23:
        if (r107 < 0) goto L25;
        lw8.k r111 = (lw8.k) ListProtector.remove((List) r100.getValue(), r107);
    L26:
        r108 = new k(r104, r111);
    L27:
        if (r108 == null) goto L4;
        r102.add(r108);
        goto L4
    L25:
        r111 = new lw8.k(r104.f492298b, "", null, null);
        goto L26
    L22:
        r107 = -1;
        goto L23
    L8:
        if (r106 > r110.e().length()) goto L15;
        if (r105 >= r106) goto L15;
        CharSequence r112 = r110.e().subSequence(r105, r106);
        if (r112.length() <= 0) goto L13;
        r107 = 1;
    L13:
        if (r107 == 0) goto L27;
        r108 = new k(r104, new lw8.k(r104.f492298b, r112.toString(), Integer.valueOf(r105), Integer.valueOf(r106)));
        goto L27
    L29:
        return r102;
    }

    public static final void b(StringBuilder r100, uvc.b r101) {
    L2:
        if (r101 == null) goto L17;
        if ((r101 instanceof Text) == false) goto L7;
        r100.append(((Text) r101).f525783h);
    L16:
        r101 = r101.f551904e;
        goto L2
    L7:
        if ((r101 instanceof Code) == false) goto L10;
        r100.append(((Code) r101).f525760h);
        goto L16
    L10:
        if ((r101 instanceof SoftLineBreak) == false) goto L12;
    L15:
        r100.append('\n');
        goto L16
    L12:
        if ((r101 instanceof HardLineBreak) == true) goto L15;
        b(r100, r101.f551901b);
        Unit r102 = Unit.INSTANCE;
        goto L16
    }

    public static final <T> List<T> c(Spanned r110, Class<T> r111) {
        Intrinsics.checkNotNullParameter(r110, "<this>");
        Intrinsics.checkNotNullParameter(r111, "kind");
        Object[] r100 = r110.getSpans(0, r110.length(), r111);
        ArrayList r101 = new ArrayList(r100.length);
        int r102 = r100.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        Object r104 = r100[r103];
        r101.add(TuplesKt.to(Integer.valueOf(r110.getSpanStart(r104)), r104));
        r103 = r103 + 1;
        goto L3
    L5:
        List r105 = CollectionsKt.toMutableList(r101);
        Iterator<T> r106 = ArraysKt.sortedWith(r110.getSpans(0, r110.length(), TableRowSpan2.class), new q(r110)).iterator();
    L7:
        if (r106.hasNext() == false) goto L28;
        TableRowSpan2 r107 = (TableRowSpan2) r106.next();
        int r108 = r110.getSpanStart(r107);
        r107.getClass();
        ArrayList r109 = new ArrayList();
        List<io.noties.markwon.ext.tables.g.a> r112 = r107.f492501o.f492528b;
        ArrayList r113 = new ArrayList();
        Iterator<T> r114 = r112.iterator();
    L10:
        if (r114.hasNext() == false) goto L20;
        CharSequence r115 = ((io.noties.markwon.ext.tables.g.a) r114.next()).f492526e;
        Object[] r116 = null;
        if ((r115 instanceof Spanned) == true) goto L14;
        CharSequence r117 = null;
    L15:
        Spanned r118 = (Spanned) r117;
        if (r118 == null) goto L18;
        r116 = r118.getSpans(0, r115.length(), r111);
    L18:
        if (r116 == null) goto L10;
        r113.add(r116);
        goto L10
    L14:
        r117 = r115;
        goto L15
    L20:
        Iterator r119 = r113.iterator();
    L22:
        if (r119.hasNext() == false) goto L24;
        CollectionsKt.addAll(r109, (Object[]) r119.next());
        goto L22
    L24:
        Iterator r120 = r109.iterator();
    L26:
        if (r120.hasNext() == false) goto L7;
        r105.add(TuplesKt.to(Integer.valueOf(r108), r120.next()));
        goto L26
    L28:
        List r121 = CollectionsKt.sortedWith(r105, new a());
        ArrayList r122 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r121, 10));
        Iterator<T> r123 = r121.iterator();
    L30:
        if (r123.hasNext() == false) goto L33;
        r122.add(((Pair) r123.next()).getSecond());
        goto L30
    L33:
        return CollectionsKt.distinct(r122);
    }
}
