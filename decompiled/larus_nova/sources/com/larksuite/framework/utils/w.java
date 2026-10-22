package com.larksuite.framework.utils;

/* JADX INFO: loaded from: classes24.dex */
public final class w {
    public static String a(Object r100) {
        return r100.getClass().getCanonicalName() + "@" + Integer.toHexString(System.identityHashCode(r100));
    }
}
