package oe8;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes25.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f523018a = 0;

    static {
    }

    public static String b(String r100) {
        if (StringsKt.startsWith$default(r100, "~~~", false, 2, null) == false) goto L5;
    L6:
        r100 = r100.substring(3);
    L8:
        if (StringsKt.endsWith$default(r100, "~~~", false, 2, null) == true) goto L12;
        if (StringsKt.endsWith$default(r100, "```", false, 2, null) == true) goto L12;
        return r100;
    L12:
        return r100.substring(0, r100.length() - 3);
    L5:
        if (StringsKt.startsWith$default(r100, "```", false, 2, null) == false) goto L8;
        goto L6
    }

    public static b a(String r110, boolean r111) {
        Intrinsics.checkNotNullParameter(r110, "code");
        String r112 = StringsKt.trim(r110, new char[]{'\n', ' '});
        List r100 = StringsKt.lines(r112);
        if (r100.isEmpty() == true) goto L5;
        boolean r101 = false;
        String r102 = (String) ListProtector.get(r100, 0);
        if (StringsKt.startsWith$default(r102, "```", false, 2, null) == false) goto L28;
        String r103 = StringsKt.trim(r102.substring(3)).toString();
        if (r111 == false) goto L16;
        if (r103.length() <= 0) goto L13;
        r101 = true;
    L13:
        if (r101 == true) goto L26;
    L25:
        r103 = null;
    L26:
        Pair r113 = TuplesKt.to('`', r103);
    L49:
        if (r113 == null) goto L51;
        ((Character) r113.component1()).charValue();
        String r114 = (String) r113.component2();
        if (r100.size() < 2) goto L55;
        List r115 = r100.subList(1, r100.size());
    L57:
        return new b(r114, b(CollectionsKt.joinToString$default(r115, "\n", null, null, 0, null, null, 62, null)));
    L55:
        r115 = CollectionsKt.emptyList();
        goto L57
    L51:
        return new b(null, b(r112));
    L16:
        if (r103.length() <= 0) goto L18;
        r101 = true;
    L18:
        if (r101 == false) goto L20;
        String r104 = r103;
    L21:
        if (r104 == null) goto L25;
        List r116 = StringsKt.split$default(r104, new String[]{" "}, false, 0, 6, null);
        if (r116 == null) goto L25;
        r103 = (String) CollectionsKt.firstOrNull(r116);
        goto L26
    L20:
        r104 = null;
        goto L21
    L28:
        if (StringsKt.startsWith$default(r102, "~~~", false, 2, null) == false) goto L48;
        String r105 = StringsKt.trim(r102.substring(3)).toString();
        if (r111 == false) goto L37;
        if (r105.length() <= 0) goto L34;
        r101 = true;
    L34:
        if (r101 == true) goto L47;
    L46:
        r105 = null;
    L47:
        r113 = TuplesKt.to('~', r105);
        goto L49
    L37:
        if (r105.length() <= 0) goto L39;
        r101 = true;
    L39:
        if (r101 == false) goto L41;
        String r106 = r105;
    L42:
        if (r106 == null) goto L46;
        List r117 = StringsKt.split$default(r106, new String[]{" "}, false, 0, 6, null);
        if (r117 == null) goto L46;
        r105 = (String) CollectionsKt.firstOrNull(r117);
        goto L47
    L41:
        r106 = null;
        goto L42
    L48:
        r113 = null;
        goto L49
    L5:
        return new b(null, "");
    }
}
