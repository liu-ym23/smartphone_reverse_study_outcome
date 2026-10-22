package org.apache.commons.text.translate;

import java.io.IOException;
import java.io.Writer;
import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes42.dex */
public class LookupTranslator extends CharSequenceTranslator {
    private final int longest;
    private final Map<String, String> lookupMap;
    private final HashSet<Character> prefixSet;
    private final int shortest;

    public LookupTranslator(Map<CharSequence, CharSequence> r100) {
        if (r100 == null) goto L15;
        this.lookupMap = new HashMap();
        this.prefixSet = new HashSet();
        Iterator<Map.Entry<CharSequence, CharSequence>> r101 = r100.entrySet().iterator();
        int r102 = Integer.MAX_VALUE;
        int r103 = 0;
    L6:
        if (r101.hasNext() == false) goto L12;
        Map.Entry<CharSequence, CharSequence> r104 = r101.next();
        this.lookupMap.put(r104.getKey().toString(), r104.getValue().toString());
        this.prefixSet.add(Character.valueOf(r104.getKey().charAt(0)));
        int r105 = r104.getKey().length();
        if (r105 >= r102) goto L10;
        r102 = r105;
    L10:
        if (r105 <= r103) goto L6;
        r103 = r105;
        goto L6
    L12:
        this.shortest = r102;
        this.longest = r103;
        return;
    L15:
        throw new InvalidParameterException("lookupMap cannot be null");
    }

    @Override // org.apache.commons.text.translate.CharSequenceTranslator
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
