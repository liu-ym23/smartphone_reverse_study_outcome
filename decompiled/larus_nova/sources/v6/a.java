package v6;

import androidx.collection.LruCache;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.text.MatchGroup;
import kotlin.text.MatchGroupCollection;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes43.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Regex f553365a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final LruCache<String, Boolean> f553366b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Set<Integer> f553367c;

    static {
        f553365a = new Regex("\"rit\":(\\d+)");
        f553366b = new LruCache(5);
    }

    public static Set a() {
        if (f553367c != null) goto L12;
        b r100 = c.f553368a.get();
        if (r100 == null) goto L9;
        List<Integer> r101 = r100.a();
        if (r101 == null) goto L9;
        Set<Integer> r102 = CollectionsKt.toSet(r101);
    L10:
        f553367c = r102;
    L9:
        r102 = null;
    L12:
        return f553367c;
    }

    public static boolean b(String r100) {
        boolean r101 = true;
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == true) goto L50;
        Set r103 = a();
        if (r103 != null) goto L13;
    L16:
        boolean r104 = true;
    L17:
        if (r104 == true) goto L50;
        LruCache<String, Boolean> r105 = f553366b;
        Boolean r106 = r105.get(r100);
        if (r106 != null) goto L49;
        if (r100 != null) goto L23;
    L26:
        boolean r107 = true;
    L27:
        Integer r108 = null;
        if (r107 == true) goto L39;
        MatchResult r109 = Regex.find$default(f553365a, r100, 0, 2, null);
        if (r109 == null) goto L39;
        MatchGroupCollection r110 = r109.getGroups();
        if (r110 == null) goto L39;
        MatchGroup r111 = r110.get(1);
        if (r111 == null) goto L39;
        String r112 = r111.getValue();
        if (r112 == null) goto L39;
        r108 = StringsKt.toIntOrNull(r112);
    L39:
        if (r108 == null) goto L46;
        Set r113 = a();
        if (r113 == null) goto L46;
        if (r113.contains(r108) != true) goto L46;
    L47:
        r105.put(r100, Boolean.valueOf(r101));
        return r101;
    L46:
        r101 = false;
        goto L47
    L23:
        if (r100.length() == 0) goto L26;
        r107 = false;
        goto L27
    L49:
        return r106.booleanValue();
    L13:
        if (r103.isEmpty() == true) goto L16;
        r104 = false;
    L50:
        return false;
    L5:
        if (r100.length() == 0) goto L8;
        r102 = false;
        goto L9
    }
}
