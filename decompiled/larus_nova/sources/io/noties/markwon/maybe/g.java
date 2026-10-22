package io.noties.markwon.maybe;

import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.text.StringsKt;
import org.commonmark.ext.gfm.tables.TableBlock;
import org.commonmark.ext.gfm.tables.TableCell;
import org.commonmark.ext.gfm.tables.TableHead;
import org.commonmark.ext.gfm.tables.TableRow;
import zsc.i;
import zsc.j;

/* JADX INFO: loaded from: classes41.dex */
public final class g extends i {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Pattern f492650f = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AtomicReference<String> f492651e;

    public static final class a {
    }

    @Override // zsc.i
    public final char d() {
        return '|';
    }

    static {
        f492650f = PatternProtector.compile("^\\|.*\\|.*$|^\\|([^\\|\\n]*\\|)+ ?\\n *\\|?[- :\\|]*$");
    }

    @Override // zsc.i
    public final uvc.b b() {
        if (StringsKt.endsWith$default(StringsKt.removeSuffix(this.f492651e.get(), "\n"), ((j) this.f573518a).f573533g, false, 2, null) == false) goto L34;
        String r100 = a(f492650f);
        if (r100 == null) goto L34;
        TableBlock r101 = new TableBlock();
        uvc.b r102 = new TableHead();
        uvc.b r103 = new TableRow();
        int r104 = StringsKt.indexOf$default(r100, '\n', 0, false, 6, null);
        if (r104 <= 0) goto L9;
        String r105 = r100.substring(0, r104);
    L10:
        List r106 = StringsKt.split$default(r105, new char[]{'|'}, false, 0, 6, null);
        ArrayList r107 = new ArrayList();
        Iterator r108 = r106.iterator();
    L12:
        if (r108.hasNext() == false) goto L19;
        String r109 = (String) r108.next();
        if (r109 == null) goto L17;
        r107.add(StringsKt.trim(r109).toString());
        goto L12
    L17:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
    L19:
        if ((!r107.isEmpty()) == false) goto L24;
        if (StringsKt.isBlank((CharSequence) CollectionsKt.last(r107)) == false) goto L24;
        ListProtector.remove(r107, CollectionsKt.getLastIndex(r107));
    L24:
        if ((!r107.isEmpty()) == true) goto L26;
    L28:
        Iterator r110 = r107.iterator();
    L30:
        if (r110.hasNext() == false) goto L32;
        String r111 = (String) r110.next();
        TableCell r112 = new TableCell();
        r112.f525648h = true;
        r112.f525649i = TableCell.Alignment.LEFT;
        r112.b(f(r111));
        r103.b(r112);
        goto L30
    L32:
        r101.b(r102);
        r102.b(r103);
        MaybeNode r113 = new MaybeNode(r101);
        r113.b(f(r100));
        return r113;
    L26:
        if (StringsKt.isBlank((CharSequence) CollectionsKt.first(r107)) == false) goto L28;
        ListProtector.remove(r107, 0);
        goto L28
    L9:
        r105 = r100;
    L34:
        return null;
    }

    public g(AtomicReference<String> r100) {
        this.f492651e = r100;
    }
}
