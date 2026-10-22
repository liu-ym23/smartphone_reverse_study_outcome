package com.lynx.canvas;

import android.util.Pair;
import com.bytedance.mt.protector.impl.PatternProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import java.util.regex.Matcher;

/* JADX INFO: loaded from: classes32.dex */
public class KryptonUniformLayoutSTD140Fix {
    public KryptonUniformLayoutSTD140Fix() {
    }

    public static String polyfill(String r100) {
        if (PatternProtector.compile("^\\\\s*#version\\\\s+300\\\\s+es").matcher(r100).matches() == false) goto L5;
        return r100;
    L5:
        Matcher r101 = PatternProtector.compile("(es|;)\\s*uniform\\s+([a-zA-Z_][a-zA-Z0-9_]*)\\s+\\{").matcher(r100);
        ArrayList r102 = new ArrayList();
    L7:
        if (r101.find() == false) goto L12;
        String r103 = ";\n layout(std140) uniform " + r101.group(2) + " {";
        if (Objects.equals(r101.group(1), "es") == false) goto L11;
        r103 = "es\n layout(std140) uniform " + r101.group(2) + " {";
    L11:
        r102.add(new Pair(r101.group(), r103));
        goto L7
    L12:
        Iterator r104 = r102.iterator();
    L14:
        if (r104.hasNext() == false) goto L16;
        Pair r105 = (Pair) r104.next();
        r100 = r100.replace((CharSequence) r105.first, (CharSequence) r105.second);
        goto L14
    L16:
        return r100;
    }
}
