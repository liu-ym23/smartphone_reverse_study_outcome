package fb5;

import java.util.LinkedList;
import java.util.Set;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a implements c {
    public a() {
    }

    @Override // fb5.c
    public final Pair<String, Boolean> a(String r19) {
        Intrinsics.checkNotNullParameter(r19, "url");
        int r5 = 0;
        Set r2 = SetsKt.setOf(new Character[]{'(', '[', '{', '<'});
        Set r1 = SetsKt.setOf(new Character[]{')', ']', '}', '>'});
        LinkedList r11 = new LinkedList();
        char[] r14 = r19.toCharArray();
        int r16 = r14.length;
        int r17 = 0;
    L3:
        if (r5 >= r16) goto L44;
        char r7 = r14[r5];
        int r18 = r17 + 1;
        if (r2.contains(Character.valueOf(r7)) == false) goto L8;
        r11.push(new Pair(Character.valueOf(r7), Integer.valueOf(r17)));
    L42:
        r5 = r5 + 1;
        r17 = r18;
        goto L3
    L8:
        if (r1.contains(Character.valueOf(r7)) == false) goto L42;
        if (r11.isEmpty() == true) goto L46;
        Pair r8 = (Pair) r11.peekFirst();
        if (r8 == null) goto L15;
        Character r9 = (Character) r8.getFirst();
    L16:
        if (r9 != null) goto L19;
    L21:
        if (r9 != null) goto L24;
    L26:
        if (r9 != null) goto L29;
    L33:
        if (r9 == null) goto L40;
        if (r9.charValue() != '<') goto L40;
        if (r7 != '>') goto L40;
    L39:
        Pair r10 = (Pair) r11.pop();
    L40:
        r17 = ((Number) ((Pair) CollectionsKt.last(r11)).getSecond()).intValue();
        goto L46
    L29:
        if (r9.charValue() != '{') goto L33;
        if (r7 == '}') goto L39;
    L24:
        if (r9.charValue() != '[') goto L26;
        if (r7 == ']') goto L39;
    L19:
        if (r9.charValue() != '(') goto L21;
        if (r7 == ')') goto L39;
    L15:
        r9 = null;
    L46:
        int r3 = r17;
    L48:
        if (r3 < 0) goto L52;
        return new Pair(r19.substring(0, r3), Boolean.FALSE);
    L52:
        return new Pair(r19, Boolean.FALSE);
    L44:
        if ((!r11.isEmpty()) == false) goto L47;
        r17 = ((Number) ((Pair) CollectionsKt.last(r11)).getSecond()).intValue();
        goto L46
    L47:
        r3 = -1;
        goto L48
    }
}
