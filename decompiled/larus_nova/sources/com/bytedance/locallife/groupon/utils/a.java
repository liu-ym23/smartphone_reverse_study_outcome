package com.bytedance.locallife.groupon.utils;

import com.google.gson.stream.JsonToken;

/* JADX INFO: loaded from: classes21.dex */
public final /* synthetic */ class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f258853a = null;

    static {
        int[] r100 = new int[JsonToken.values().length];
        f258853a = r100;
        r100[JsonToken.BOOLEAN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
    L12:
        f258853a[JsonToken.NULL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
    L14:
        f258853a[JsonToken.NUMBER.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
    L18:
        f258853a[JsonToken.STRING.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
        return;
    }
}
