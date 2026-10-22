package com.bytedance.locallife.common.adapter;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* JADX INFO: loaded from: classes21.dex */
public class StringJsonAdapterFactory implements TypeAdapterFactory {

    public static class Adapter<T> extends TypeAdapter<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Gson f257127a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TypeToken<T> f257128b;

        @Override // com.google.gson.TypeAdapter
        public final T read(JsonReader r100) throws IOException {
            JsonToken r101 = r100.peek();
            int r102 = a.f257129a[r101.ordinal()];
            if (r102 != 1) goto L5;
            r100.nextNull();
            return null;
        L5:
            if (r102 == 2) goto L9;
            return (T) GsonProtectorUtils.fromJson(this.f257127a, r100, this.f257128b.getType());
        L9:
            return (T) GsonProtectorUtils.fromJson(this.f257127a, r100.nextString(), this.f257128b.getType());
        }

        public Adapter(Gson r100, TypeToken<T> r101) {
            this.f257127a = r100;
            this.f257128b = r101;
        }

        @Override // com.google.gson.TypeAdapter
        public final void write(JsonWriter r100, T r101) throws IOException {
            r100.value(GsonProtectorUtils.toJson(this.f257127a, r101));
        }
    }

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f257129a = null;

        static {
            int[] r100 = new int[JsonToken.values().length];
            f257129a = r100;
            r100[JsonToken.NULL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            f257129a[JsonToken.STRING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public StringJsonAdapterFactory() {
    }

    @Override // com.google.gson.TypeAdapterFactory
    public final <T> TypeAdapter<T> create(Gson r100, TypeToken<T> r101) {
        return new Adapter(r100, r101);
    }
}
