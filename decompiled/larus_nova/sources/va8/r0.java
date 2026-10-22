package va8;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes25.dex */
public final class r0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f553977a = 0;

    static {
    }

    public static List a(String r210) {
        Intrinsics.checkNotNullParameter(r210, "keyword");
        String r100 = StringsKt.trim(r210).toString();
        if (r100.length() != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L8;
        String r102 = StringsKt.trim(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(r100, "<em>", "", false, 4, null), "</em>", "", false, 4, null), "<highlight>", "", false, 4, null), "</highlight>", "", false, 4, null)).toString();
        String r103 = StringsKt.trim(r102, new char[]{8230, '.', ' '});
        List r104 = CollectionsKt.createListBuilder();
        r104.add(r102);
        r104.add(r103);
        Iterator r105 = StringsKt.split$default(r103, new char[]{8230}, false, 0, 6, null).iterator();
    L11:
        if (r105.hasNext() == false) goto L13;
        r104.add(StringsKt.trim((String) r105.next()).toString());
        goto L11
    L13:
        List r106 = CollectionsKt.build(r104);
        ArrayList r107 = new ArrayList();
        Iterator r108 = r106.iterator();
    L15:
        if (r108.hasNext() == false) goto L23;
        Object r109 = r108.next();
        if (((String) r109).length() <= 0) goto L19;
        boolean r110 = true;
    L20:
        if (r110 == false) goto L15;
        r107.add(r109);
        goto L15
    L19:
        r110 = false;
        goto L20
    L23:
        return CollectionsKt.distinct(r107);
    L8:
        return CollectionsKt.emptyList();
    L5:
        r101 = false;
        goto L6
    }
}
