package m9a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes32.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f512654a = 0;

    static {
    }

    public static Integer a(Integer r100) {
        if (r100 == null) goto L11;
        int r101 = r100.intValue();
        if (r101 >= 0) goto L6;
    L8:
        boolean r102 = false;
    L9:
        if (r102 == false) goto L11;
        return r100;
    L6:
        if (r101 >= 10000) goto L8;
        r102 = true;
    L11:
        return null;
    }

    public static List b(List r100) {
        if (r100 != null) goto L4;
        r100 = CollectionsKt.emptyList();
    L4:
        ArrayList r101 = new ArrayList();
        Iterator r102 = r100.iterator();
    L6:
        if (r102.hasNext() == false) goto L10;
        Object r103 = r102.next();
        if (StringsKt.startsWith$default((String) r103, "__omni_feedback_amount=", false, 2, null) == true) goto L6;
        r101.add(r103);
        goto L6
    L10:
        return r101;
    }
}
