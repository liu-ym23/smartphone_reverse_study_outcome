package com.larus.utils.gson;

import androidx.exifinterface.media.ExifInterface;
import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0007"}, d2 = {"Lcom/larus/utils/gson/FilterNonNullTypeAdapterFactory;", "Lcom/google/gson/TypeAdapterFactory;", "<init>", "()V", "BaseTypeAdapter", "CollectionTypeAdapter", "MapTypeAdapter", "extension_release"}, k = 1, mv = {1, 7, 1})
public final class FilterNonNullTypeAdapterFactory implements TypeAdapterFactory {

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0012\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/larus/utils/gson/FilterNonNullTypeAdapterFactory$BaseTypeAdapter;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/google/gson/TypeAdapter;", "Ljava/lang/reflect/Type;", "b", "Ljava/lang/reflect/Type;", "getType", "()Ljava/lang/reflect/Type;", "type", "extension_release"}, k = 1, mv = {1, 7, 1})
    public static class BaseTypeAdapter<T> extends TypeAdapter<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TypeAdapter<T> f375393a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Type f375394b;

        public final Type getType() {
            return this.f375394b;
        }

        @Override // com.google.gson.TypeAdapter
        public final T read(JsonReader r100) {
            Intrinsics.checkNotNullParameter(r100, "in");
            T r101 = this.f375393a.read(r100);
            d r102 = d.f375407a;
            Type r103 = this.f375394b;
            r102.getClass();
            if (r101 != null) goto L28;
        L27:
            return r101;
        L28:
            Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L19
            if (r103 == null) goto L8;
            String r105 = r103.toString();     // Catch: Throwable -> L19
        L9:
            if (r105 != null) goto L11;
        L14:
            boolean r106 = true;
        L15:
            if (r106 == false) goto L17;
            r105 = "UNKNOWN";
        L17:
            d.a(r101, r105);     // Catch: Throwable -> L19
            Object r107 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L19
        L21:
            Throwable r108 = Result.m9452exceptionOrNullimpl(r107);
            if (r108 == null) goto L27;
            e r109 = d.f375408b;
            if (r109 == null) goto L27;
            r109.log("handle error: " + r108);
            goto L27
        L11:
            if (r105.length() == 0) goto L14;
            r106 = false;
            goto L15
        L8:
            r105 = null;
        L19:
            th = move-exception;
            Result.Companion r110 = Result.Companion;
            r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L21
        }

        public BaseTypeAdapter(TypeAdapter<T> r100, Type r101) {
            Intrinsics.checkNotNullParameter(r100, "proxy");
            this.f375393a = r100;
            this.f375394b = r101;
        }

        @Override // com.google.gson.TypeAdapter
        public final void write(JsonWriter r100, T r101) {
            Intrinsics.checkNotNullParameter(r100, Argument.OUT);
            this.f375393a.write(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002¨\u0006\u0003"}, d2 = {"Lcom/larus/utils/gson/FilterNonNullTypeAdapterFactory$CollectionTypeAdapter;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/larus/utils/gson/FilterNonNullTypeAdapterFactory$BaseTypeAdapter;", "extension_release"}, k = 1, mv = {1, 7, 1})
    public static final class CollectionTypeAdapter<T> extends BaseTypeAdapter<T> {
        public CollectionTypeAdapter(TypeAdapter<T> r100, Type r101) {
            Intrinsics.checkNotNullParameter(r100, "proxy");
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002¨\u0006\u0003"}, d2 = {"Lcom/larus/utils/gson/FilterNonNullTypeAdapterFactory$MapTypeAdapter;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/larus/utils/gson/FilterNonNullTypeAdapterFactory$BaseTypeAdapter;", "extension_release"}, k = 1, mv = {1, 7, 1})
    public static final class MapTypeAdapter<T> extends BaseTypeAdapter<T> {
        public MapTypeAdapter(TypeAdapter<T> r100, Type r101) {
            Intrinsics.checkNotNullParameter(r100, "proxy");
            super(r100, r101);
        }
    }

    public FilterNonNullTypeAdapterFactory() {
    }

    @Override // com.google.gson.TypeAdapterFactory
    public final <T> TypeAdapter<T> create(Gson r100, TypeToken<T> r101) {
        Intrinsics.checkNotNullParameter(r100, "gson");
        Intrinsics.checkNotNullParameter(r101, "typeToken");
        d.f375407a.getClass();
        e r102 = d.f375408b;
        if (r102 == null) goto L5;
        c r103 = r102.getConfig();
    L6:
        if (r103 != null) goto L9;
        return null;
    L9:
        if (r103.f375404a == true) goto L12;
        return null;
    L12:
        if (r103.f375405b == false) goto L21;
        if (Collection.class.isAssignableFrom(r101.getRawType()) == false) goto L21;
        TypeAdapter r104 = r100.getAdapter(r101);
        if (r104 != null) goto L19;
        return null;
    L19:
        return new CollectionTypeAdapter(r104, r101.getType());
    L21:
        if (r103.f375406c == true) goto L23;
    L29:
        return null;
    L23:
        if (Map.class.isAssignableFrom(r101.getRawType()) == false) goto L29;
        TypeAdapter r105 = r100.getAdapter(r101);
        if (r105 != null) goto L28;
        return null;
    L28:
        return new MapTypeAdapter(r105, r101.getType());
    L5:
        r103 = null;
        goto L6
    }
}
