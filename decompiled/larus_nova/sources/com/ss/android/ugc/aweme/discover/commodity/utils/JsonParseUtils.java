package com.ss.android.ugc.aweme.discover.commodity.utils;

import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.C$Gson$Types;
import com.google.gson.stream.JsonToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes40.dex */
public class JsonParseUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final TypeAdapter<Boolean> f450373a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final TypeAdapter<Integer> f450374b = null;

    /* JADX INFO: renamed from: com.ss.android.ugc.aweme.discover.commodity.utils.JsonParseUtils$3, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass3 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f450375a = null;

        static {
            int[] r100 = new int[JsonToken.values().length];
            f450375a = r100;
            r100[JsonToken.BOOLEAN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            f450375a[JsonToken.NULL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            f450375a[JsonToken.NUMBER.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            f450375a[JsonToken.STRING.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    static {
        f450373a = new AnonymousClass1();
        f450374b = new AnonymousClass2();
    }

    public static <T> List<T> a(String r100, Class<T> r101) {
        GsonBuilder r102 = new GsonBuilder();
        TypeAdapter<Boolean> r103 = f450373a;
        GsonBuilder r104 = r102.registerTypeAdapter(Boolean.class, r103).registerTypeAdapter(Boolean.TYPE, r103);
        TypeAdapter<Integer> r105 = f450374b;
        return (List) r104.registerTypeAdapter(Integer.class, r105).registerTypeAdapter(Integer.TYPE, r105).setLenient().create().fromJson(r100, C$Gson$Types.newParameterizedTypeWithOwner(null, ArrayList.class, new Type[]{r101}));
    L6:
        return new ArrayList();
    }
}
