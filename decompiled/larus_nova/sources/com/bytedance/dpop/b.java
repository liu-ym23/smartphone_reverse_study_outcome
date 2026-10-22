package com.bytedance.dpop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes15.dex */
public final class b {
    public static final String a(byte[] r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        ArrayList r101 = new ArrayList(r100.length);
        int r102 = r100.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        byte r104 = r100[r103];
        StringCompanionObject r105 = StringCompanionObject.INSTANCE;
        r101.add(String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(r104)}, 1)));
        r103 = r103 + 1;
        goto L3
    L5:
        StringBuilder r106 = new StringBuilder();
        r106.append("(hex:" + r101.size() + ')');
        Iterator r107 = r101.iterator();
    L7:
        if (r107.hasNext() == false) goto L10;
        r106.append((String) r107.next());
        r106.append(" ");
        goto L7
    L10:
        return r106.toString();
    }
}
