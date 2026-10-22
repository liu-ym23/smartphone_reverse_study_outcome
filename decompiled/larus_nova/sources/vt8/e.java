package vt8;

import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;

/* JADX INFO: loaded from: classes26.dex */
public final class e implements d {
    public e() {
    }

    @Override // vt8.d
    public final int b() {
        return 3;
    }

    @Override // vt8.d
    public final Pair<Integer, Integer> a(String r110, int r111) {
        Intrinsics.checkNotNullParameter(r110, "txt");
        int r100 = r111;
    L4:
        if (r100 <= 0) goto L9;
        int r101 = r100 - 1;
        if (r110.charAt(r101) == '\n') goto L9;
        r100 = r101;
    L9:
        if (r111 >= r110.length()) goto L13;
        if (r110.charAt(r111) == '\n') goto L13;
        r111 = r111 + 1;
    L13:
        String r102 = r110.substring(r100, r111);
        boolean r103 = false;
        int r104 = 0;
    L14:
        boolean r105 = true;
        if (r104 >= r102.length()) goto L25;
        char r106 = r102.charAt(r104);
        if (CharsKt.isWhitespace(r106) == false) goto L19;
    L22:
        if (r105 == false) goto L26;
        r104 = r104 + 1;
    L26:
        if (r103 == false) goto L35;
        if (r100 <= 0) goto L35;
        int r112 = r100 - 1;
    L29:
        if (r112 <= 0) goto L33;
        int r107 = r112 - 1;
        if (r110.charAt(r107) == '\n') goto L33;
        r112 = r107;
    L33:
        int r113 = r100;
        r100 = r112;
        r111 = r113;
    L35:
        return TuplesKt.to(Integer.valueOf(r100), Integer.valueOf(r111));
    L19:
        if (CollectionsKt.listOf(new Character[]{(char) 8203, (char) 8204, (char) 8205}).contains(Character.valueOf(r106)) == true) goto L22;
        r105 = false;
        goto L22
    L25:
        r103 = true;
        goto L26
    }
}
