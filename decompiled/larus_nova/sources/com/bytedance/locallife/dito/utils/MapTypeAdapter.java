package com.bytedance.locallife.dito.utils;

import androidx.collection.SieveCacheKt;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes21.dex */
public class MapTypeAdapter extends TypeAdapter<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TypeAdapter<Object> f258682a;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f258683a = null;

        static {
            int[] r100 = new int[JsonToken.values().length];
            f258683a = r100;
            r100[JsonToken.BEGIN_ARRAY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L16:
            f258683a[JsonToken.BEGIN_OBJECT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L20:
            f258683a[JsonToken.STRING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L26:
            f258683a[JsonToken.NUMBER.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L18:
            f258683a[JsonToken.BOOLEAN.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L22:
            f258683a[JsonToken.NULL.ordinal()] = 6;     // Catch: NoSuchFieldError -> L15
            return;
        }
    }

    public MapTypeAdapter() {
        this.f258682a = new Gson().getAdapter(Object.class);
    }

    @Override // com.google.gson.TypeAdapter
    public final Object read(JsonReader r100) throws IOException {
        JsonToken r101 = r100.peek();
        switch(a.f258683a[r101.ordinal()]) {
            case 1: goto L33;
            case 2: goto L27;
            case 3: goto L26;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L6;
            default: goto L5;
        };
    L6:
        r100.nextNull();
        return null;
    L10:
        String r102 = r100.nextString();
        if (r102.contains(".") == true) goto L24;
        if (r102.contains("e") == true) goto L24;
        if (r102.contains(ExifInterface.LONGITUDE_EAST) == true) goto L24;
        if (CastLongProtector.parseLong(r102) > SieveCacheKt.NodeLinkMask) goto L22;
        return Integer.valueOf(CastIntegerProtector.parseInt(r102));
    L22:
        return Long.valueOf(CastLongProtector.parseLong(r102));
    L24:
        return Double.valueOf(CastDoubleProtector.parseDouble(r102));
    L27:
        LinkedTreeMap r103 = new LinkedTreeMap();
        r100.beginObject();
    L29:
        if (r100.hasNext() == false) goto L31;
        r103.put(r100.nextName(), read(r100));
        goto L29
    L31:
        r100.endObject();
        return r103;
    L33:
        ArrayList r104 = new ArrayList();
        r100.beginArray();
    L35:
        if (r100.hasNext() == false) goto L37;
        r104.add(read(r100));
        goto L35
    L37:
        r100.endArray();
        return r104;
    L5:
        throw new IllegalStateException();
    L9:
        return Boolean.valueOf(r100.nextBoolean());
    L26:
        return r100.nextString();
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter r100, Object r101) throws IOException {
        this.f258682a.write(r100, r101);
    }
}
