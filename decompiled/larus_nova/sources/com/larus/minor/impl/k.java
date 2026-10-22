package com.larus.minor.impl;

import java.math.BigInteger;
import java.security.MessageDigest;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes30.dex */
public final class k {
    public static final String a(String r100) {
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L13;
        return "";
    L13:
        return StringsKt.padStart(new BigInteger(1, MessageDigest.getInstance("SHA-256").digest(r100.getBytes(Charsets.UTF_8))).toString(16), 32, '0');
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L9
    }
}
