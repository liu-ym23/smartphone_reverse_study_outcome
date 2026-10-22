package com.ss.android.ugc.aweme.search.common.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonToken;

/* JADX INFO: loaded from: classes40.dex */
public class JsonParseUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final TypeAdapter<Boolean> f452255a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final TypeAdapter<Integer> f452256b = null;

    /* JADX INFO: renamed from: com.ss.android.ugc.aweme.search.common.utils.JsonParseUtils$3, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass3 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f452257a = null;

        static {
            int[] r100 = new int[JsonToken.values().length];
            f452257a = r100;
            r100[JsonToken.BOOLEAN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            f452257a[JsonToken.NULL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            f452257a[JsonToken.NUMBER.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            f452257a[JsonToken.STRING.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    static {
        f452255a = new AnonymousClass1();
        f452256b = new AnonymousClass2();
    }

    public static Gson a() {
        GsonBuilder r100 = new GsonBuilder();
        TypeAdapter<Boolean> r101 = f452255a;
        GsonBuilder r102 = r100.registerTypeAdapter(Boolean.class, r101).registerTypeAdapter(Boolean.TYPE, r101);
        TypeAdapter<Integer> r103 = f452256b;
        return r102.registerTypeAdapter(Integer.class, r103).registerTypeAdapter(Integer.TYPE, r103).setLenient().create();
    }

    public static <T> T b(String r100, Class<T> r101) {
        return (T) a().fromJson(r100, r101);
    L5:
        return null;
    }
}
