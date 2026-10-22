package com.ss.android.ugc.aweme.utils;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.ss.android.ugc.aweme.discover.utils.GsonUtil;
import java.io.IOException;

/* JADX INFO: loaded from: classes40.dex */
public class LiveStringJsonAdapterFactory implements TypeAdapterFactory {

    /* JADX INFO: renamed from: com.ss.android.ugc.aweme.utils.LiveStringJsonAdapterFactory$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f454348a = null;

        static {
            int[] r100 = new int[JsonToken.values().length];
            f454348a = r100;
            r100[JsonToken.NULL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            f454348a[JsonToken.STRING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public static class Adapter<T> extends TypeAdapter<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Gson f454349a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TypeToken<T> f454350b;

        @Override // com.google.gson.TypeAdapter
        public final T read(JsonReader r100) throws IOException {
            JsonToken r101 = r100.peek();
            int r102 = AnonymousClass1.f454348a[r101.ordinal()];
            if (r102 != 1) goto L5;
            r100.nextNull();
            return null;
        L5:
            if (r102 == 2) goto L9;
            return (T) GsonProtectorUtils.fromJson(this.f454349a, r100, this.f454350b.getType());
        L9:
            if (GsonUtil.f450786a != null) goto L21;
            monitor-enter(GsonUtil.class);
        L17:
            th = move-exception;
            throw th;
        L13:
            if (GsonUtil.f450786a != null) goto L15;
            GsonUtil.f450786a = new Gson();     // Catch: Throwable -> L17
        L15:
            monitor-exit(GsonUtil.class);     // Catch: Throwable -> L17
        L21:
            return (T) GsonProtectorUtils.fromJson(GsonUtil.f450786a, r100.nextString(), this.f454350b.getType());
        }

        public Adapter(Gson r100, TypeToken<T> r101) {
            this.f454349a = r100;
            this.f454350b = r101;
        }

        @Override // com.google.gson.TypeAdapter
        public final void write(JsonWriter r100, T r101) throws IOException {
            r100.value(GsonProtectorUtils.toJson(this.f454349a, r101));
        }
    }

    public LiveStringJsonAdapterFactory() {
    }

    @Override // com.google.gson.TypeAdapterFactory
    public final <T> TypeAdapter<T> create(Gson r100, TypeToken<T> r101) {
        return new Adapter(r100, r101);
    }
}
