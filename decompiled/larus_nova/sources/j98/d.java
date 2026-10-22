package j98;

import com.larus.utils.o0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<String> f497806a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<String> f497807b = null;

    static {
        f497806a = CollectionsKt.listOf(new String[]{"文笔流畅", "文笔优美", "逻辑清晰", "详略得当"});
        f497807b = CollectionsKt.listOf(new String[]{"文笔粗糙", "语句不通", "逻辑不清", "详略不当"});
    }

    public static final List<String> b(Map<String, ? extends List<String>> r100, int r101) {
        if (r100 != null) goto L10;
        if (r101 == 1) goto L9;
        if (r101 == 2) goto L35;
        return CollectionsKt.emptyList();
    L35:
        return f497807b;
    L9:
        return f497806a;
    L10:
        List<String> r102 = r100.get(String.valueOf(r101));
        if (r102 != null) goto L13;
        r102 = CollectionsKt.emptyList();
    L13:
        ArrayList r103 = new ArrayList();
        Iterator<T> r104 = r102.iterator();
    L15:
        if (r104.hasNext() == false) goto L19;
        Object r105 = r104.next();
        if (o0.d((String) r105) == false) goto L15;
        r103.add(r105);
        goto L15
    L19:
        boolean r106 = r103.isEmpty();
        List<String> r107 = r103;
        if (r106 == false) goto L28;
        if (r101 == 1) goto L25;
        if (r101 == 2) goto L24;
        List<String> r108 = CollectionsKt.emptyList();
    L26:
        r107 = r108;
        goto L28
    L24:
        r108 = f497807b;
        goto L26
    L25:
        r108 = f497806a;
    L28:
        return CollectionsKt.filterNotNull(r107);
    }

    public static final String a(String r100, String r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "userId");
        Intrinsics.checkNotNullParameter(r101, "diaryId");
        return r100 + '_' + r101 + '_' + r102;
    }
}
