package em5;

import com.ss.android.lark.picker.config.condition.DocType;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d {
    public static final Set<DocType> a(ArrayList<Integer> r6) {
        Intrinsics.checkNotNullParameter(r6, "types");
        HashSet r0 = new HashSet();
        Iterator<T> r7 = r6.iterator();
    L4:
        if (r7.hasNext() == false) goto L30;
        int r1 = ((Number) r7.next()).intValue();
        if (r1 != 0) goto L8;
        Set r2 = SetsKt.setOf(DocType.FOLDER);
    L29:
        r0.addAll(r2);
        goto L4
    L8:
        if (r1 != 8) goto L10;
        r2 = SetsKt.setOf(DocType.BITABLE);
        goto L29
    L10:
        if (r1 != 22) goto L12;
        r2 = SetsKt.setOf(new DocType[]{DocType.DOC, DocType.DOCX});
        goto L29
    L12:
        if (r1 == 30) goto L25;
        if (r1 != 2) goto L15;
        r2 = SetsKt.setOf(new DocType[]{DocType.DOC, DocType.DOCX});
        goto L29
    L15:
        if (r1 != 3) goto L17;
        r2 = SetsKt.setOf(DocType.SHEET);
        goto L29
    L17:
        if (r1 != 11) goto L19;
        r2 = SetsKt.setOf(DocType.MINDNOTE);
        goto L29
    L19:
        if (r1 == 12) goto L21;
        r2 = SetsKt.setOf(DocType.NONE);
        goto L29
    L21:
        r2 = SetsKt.setOf(DocType.FILE);
        goto L29
    L25:
        r2 = SetsKt.setOf(DocType.SLIDES);
        goto L29
    L30:
        return r0;
    }
}
