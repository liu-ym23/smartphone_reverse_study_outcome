package com.ss.android.ugc.aweme.search.common;

import com.byted.cast.linkcommon.cybergarage.xml.XML;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: loaded from: classes40.dex */
public class SearchJsonTypeAdapter extends TypeAdapter<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TypeAdapter<Object> f451396a;

    /* JADX INFO: renamed from: com.ss.android.ugc.aweme.search.common.SearchJsonTypeAdapter$3, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass3 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f451397a = null;

        static {
            int[] r100 = new int[JsonToken.values().length];
            f451397a = r100;
            r100[JsonToken.BEGIN_ARRAY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L16:
            f451397a[JsonToken.BEGIN_OBJECT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L20:
            f451397a[JsonToken.STRING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L26:
            f451397a[JsonToken.NUMBER.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L18:
            f451397a[JsonToken.BOOLEAN.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L22:
            f451397a[JsonToken.NULL.ordinal()] = 6;     // Catch: NoSuchFieldError -> L15
            return;
        }
    }

    public SearchJsonTypeAdapter() {
        this.f451396a = new Gson().getAdapter(Object.class);
    }

    public static Map b(String r100) {
        String r101 = a(r100, Boolean.FALSE);
        return (Map) GsonProtectorUtils.fromJson(new GsonBuilder().registerTypeAdapter(new AnonymousClass1().getType(), new SearchJsonTypeAdapter()).create(), r101, new AnonymousClass2().getType());
    }

    @Override // com.google.gson.TypeAdapter
    public final Object read(JsonReader r100) throws IOException {
        JsonToken r101 = r100.peek();
        switch(AnonymousClass3.f451397a[r101.ordinal()]) {
            case 1: goto L28;
            case 2: goto L22;
            case 3: goto L21;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L6;
            default: goto L5;
        };
    L6:
        r100.nextNull();
        return r101;
    L10:
        double r102 = r100.nextDouble();
        if (r102 > 9.223372036854776E18d) goto L13;
        long r103 = (long) r102;
        if (r102 != r103) goto L19;
        return Long.valueOf(r103);
    L19:
        return Double.valueOf(r102);
    L13:
        return String.valueOf(r102);
    L22:
        LinkedTreeMap r104 = new LinkedTreeMap();
        r100.beginObject();
    L24:
        if (r100.hasNext() == false) goto L26;
        r104.put(r100.nextName(), read(r100));
        goto L24
    L26:
        r100.endObject();
        return r104;
    L28:
        ArrayList r105 = new ArrayList();
        r100.beginArray();
    L30:
        if (r100.hasNext() == false) goto L32;
        r105.add(read(r100));
        goto L30
    L32:
        r100.endArray();
        return r105;
    L5:
        throw new IllegalStateException();
    L9:
        return Boolean.valueOf(r100.nextBoolean());
    L21:
        return r100.nextString();
    }

    public static String a(String r100, Boolean r101) {
        return URLDecoder.decode(r100, XML.CHARSET_UTF8);
    L4:
        e = move-exception;
        if (r101.booleanValue() == true) goto L11;
        if ((e instanceof IllegalArgumentException) == false) goto L11;
        return a(r100.replaceAll("%(?![0-9a-fA-F]{2})", "%25"), Boolean.TRUE);
    L11:
        return "";
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter r100, Object r101) throws IOException {
        this.f451396a.write(r100, r101);
    }
}
