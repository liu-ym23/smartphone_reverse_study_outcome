package com.bytedance.locallife.common.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonToken;

/* JADX INFO: loaded from: classes21.dex */
public final class JsonParseUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final TypeAdapter<Boolean> f257131a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final TypeAdapter<Integer> f257132b = null;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f257133a = null;

        static {
            int[] r100 = new int[JsonToken.values().length];
            f257133a = r100;
            r100[JsonToken.BOOLEAN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            f257133a[JsonToken.NULL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            f257133a[JsonToken.NUMBER.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            f257133a[JsonToken.STRING.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    static {
        f257131a = new AnonymousClass1();
        f257132b = new AnonymousClass2();
    }

    public static Gson a() {
        GsonBuilder r100 = new GsonBuilder();
        TypeAdapter<Boolean> r101 = f257131a;
        GsonBuilder r102 = r100.registerTypeAdapter(Boolean.class, r101).registerTypeAdapter(Boolean.TYPE, r101);
        TypeAdapter<Integer> r103 = f257132b;
        return r102.registerTypeAdapter(Integer.class, r103).registerTypeAdapter(Integer.TYPE, r103).setLenient().create();
    }
}
