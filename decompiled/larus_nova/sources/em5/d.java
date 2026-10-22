package em5;

import com.ss.android.lark.picker.config.condition.DocType;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class d {
    public static final Set<DocType> a(ArrayList<Integer> r100) {
        Intrinsics.checkNotNullParameter(r100, "types");
        HashSet r101 = new HashSet();
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L30;
        int r103 = ((Number) r102.next()).intValue();
        if (r103 != 0) goto L8;
        Set r104 = SetsKt.setOf(DocType.FOLDER);
    L29:
        r101.addAll(r104);
        goto L4
    L8:
        if (r103 != 8) goto L10;
        r104 = SetsKt.setOf(DocType.BITABLE);
        goto L29
    L10:
        if (r103 != 22) goto L12;
        r104 = SetsKt.setOf(new DocType[]{DocType.DOC, DocType.DOCX});
        goto L29
    L12:
        if (r103 == 30) goto L25;
        if (r103 != 2) goto L15;
        r104 = SetsKt.setOf(new DocType[]{DocType.DOC, DocType.DOCX});
        goto L29
    L15:
        if (r103 != 3) goto L17;
        r104 = SetsKt.setOf(DocType.SHEET);
        goto L29
    L17:
        if (r103 != 11) goto L19;
        r104 = SetsKt.setOf(DocType.MINDNOTE);
        goto L29
    L19:
        if (r103 == 12) goto L21;
        r104 = SetsKt.setOf(DocType.NONE);
        goto L29
    L21:
        r104 = SetsKt.setOf(DocType.FILE);
        goto L29
    L25:
        r104 = SetsKt.setOf(DocType.SLIDES);
        goto L29
    L30:
        return r101;
    }
}
