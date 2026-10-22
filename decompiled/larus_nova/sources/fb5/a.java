package fb5;

import java.util.LinkedList;
import java.util.Set;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes16.dex */
public final class a implements c {
    public a() {
    }

    @Override // fb5.c
    public final Pair<String, Boolean> a(String r110) {
        Intrinsics.checkNotNullParameter(r110, "url");
        int r100 = 0;
        Set r101 = SetsKt.setOf(new Character[]{'(', '[', '{', Character.valueOf(Typography.less)});
        Set r102 = SetsKt.setOf(new Character[]{')', ']', '}', Character.valueOf(Typography.greater)});
        LinkedList r111 = new LinkedList();
        char[] r112 = r110.toCharArray();
        int r113 = r112.length;
        int r114 = 0;
    L3:
        if (r100 >= r113) goto L44;
        char r103 = r112[r100];
        int r115 = r114 + 1;
        if (r101.contains(Character.valueOf(r103)) == false) goto L8;
        r111.push(new Pair(Character.valueOf(r103), Integer.valueOf(r114)));
    L42:
        r100 = r100 + 1;
        r114 = r115;
        goto L3
    L8:
        if (r102.contains(Character.valueOf(r103)) == false) goto L42;
        if (r111.isEmpty() == true) goto L46;
        Pair r104 = (Pair) r111.peekFirst();
        if (r104 == null) goto L15;
        Character r105 = (Character) r104.getFirst();
    L16:
        if (r105 != null) goto L19;
    L21:
        if (r105 != null) goto L24;
    L26:
        if (r105 != null) goto L29;
    L33:
        if (r105 == null) goto L40;
        if (r105.charValue() != '<') goto L40;
        if (r103 != '>') goto L40;
    L39:
        Pair r106 = (Pair) r111.pop();
    L40:
        r114 = ((Number) ((Pair) CollectionsKt.last(r111)).getSecond()).intValue();
        goto L46
    L29:
        if (r105.charValue() != '{') goto L33;
        if (r103 == '}') goto L39;
    L24:
        if (r105.charValue() != '[') goto L26;
        if (r103 == ']') goto L39;
    L19:
        if (r105.charValue() != '(') goto L21;
        if (r103 == ')') goto L39;
    L15:
        r105 = null;
    L46:
        int r107 = r114;
    L48:
        if (r107 < 0) goto L52;
        return new Pair(r110.substring(0, r107), Boolean.FALSE);
    L52:
        return new Pair(r110, Boolean.FALSE);
    L44:
        if ((!r111.isEmpty()) == false) goto L47;
        r114 = ((Number) ((Pair) CollectionsKt.last(r111)).getSecond()).intValue();
        goto L46
    L47:
        r107 = -1;
        goto L48
    }
}
