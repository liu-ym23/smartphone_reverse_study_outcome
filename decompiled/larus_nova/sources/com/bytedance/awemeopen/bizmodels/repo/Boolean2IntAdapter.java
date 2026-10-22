package com.bytedance.awemeopen.bizmodels.repo;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* JADX INFO: loaded from: classes44.dex */
public class Boolean2IntAdapter extends TypeAdapter<Integer> {

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f198204a = null;

        static {
            int[] r100 = new int[JsonToken.values().length];
            f198204a = r100;
            r100[JsonToken.NULL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            f198204a[JsonToken.BOOLEAN.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public Boolean2IntAdapter() {
    }

    @Override // com.google.gson.TypeAdapter
    public final Integer read(JsonReader r100) throws IOException {
        JsonToken r101 = r100.peek();
        int r102 = a.f198204a[r101.ordinal()];
        if (r102 != 1) goto L5;
        r100.nextNull();
        return 0;
    L5:
        if (r102 == 2) goto L11;
        return Integer.valueOf(r100.nextInt());
    L11:
        return Integer.valueOf(r100.nextBoolean() ? 1 : 0);
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter r100, Integer r101) throws IOException {
        r100.value(r101);
    }
}
