package org.apache.commons.lang3.text.translate;

import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.HashSet;

/* JADX INFO: loaded from: classes42.dex */
public class LookupTranslator extends CharSequenceTranslator {
    private final int longest;
    private final HashMap<String, String> lookupMap;
    private final HashSet<Character> prefixSet;
    private final int shortest;

    public LookupTranslator(CharSequence[]... r110) {
        this.lookupMap = new HashMap();
        this.prefixSet = new HashSet();
        int r100 = Integer.MAX_VALUE;
        int r101 = 0;
        if (r110 == null) goto L13;
        int r102 = r110.length;
        int r103 = 0;
        int r104 = 0;
    L5:
        if (r103 >= r102) goto L12;
        CharSequence[] r105 = r110[r103];
        this.lookupMap.put(r105[0].toString(), r105[1].toString());
        this.prefixSet.add(Character.valueOf(r105[0].charAt(0)));
        int r106 = r105[0].length();
        if (r106 >= r100) goto L9;
        r100 = r106;
    L9:
        if (r106 <= r104) goto L11;
        r104 = r106;
    L11:
        r103 = r103 + 1;
        goto L5
    L12:
        r101 = r104;
    L13:
        this.shortest = r100;
        this.longest = r101;
    }

    @Override // org.apache.commons.lang3.text.translate.CharSequenceTranslator
    public int translate(CharSequence r100, int r101, Writer r102) throws IOException {
        if (this.prefixSet.contains(Character.valueOf(r100.charAt(r101))) == false) goto L14;
        int r103 = this.longest;
        if ((r101 + r103) <= r100.length()) goto L8;
        r103 = r100.length() - r101;
    L8:
        if (r103 < this.shortest) goto L19;
        String r104 = this.lookupMap.get(r100.subSequence(r101, r101 + r103).toString());
        if (r104 != null) goto L11;
        r103 = r103 - 1;
        goto L8
    L11:
        r102.write(r104);
        return r103;
    L19:
        return 0;
    L14:
        return 0;
    }
}
