package com.bytedance.tools.kcp.modelx.runtime.internal.decode;

import androidx.exifinterface.media.ExifInterface;
import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.lang.reflect.Constructor;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001:\u0001\u0015B\u0011\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0002\u0010\u0004J*\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u000e\"\u0004\b\u0000\u0010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u0013H\u0016J\u0006\u0010\u0014\u001a\u00020\u0007RC\u0010\u0005\u001a*\u0012\u000e\b\u0001\u0012\n \b*\u0004\u0018\u00010\u00070\u0007 \b*\u0014\u0012\u000e\b\u0001\u0012\n \b*\u0004\u0018\u00010\u00070\u0007\u0018\u00010\u00060\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u0012\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "Lcom/google/gson/TypeAdapterFactory;", "rawType", "Ljava/lang/Class;", "(Ljava/lang/Class;)V", "constructor", "Ljava/lang/reflect/Constructor;", "", "kotlin.jvm.PlatformType", "getConstructor", "()Ljava/lang/reflect/Constructor;", "constructor$delegate", "Lkotlin/Lazy;", "create", "Lcom/google/gson/TypeAdapter;", ExifInterface.GPS_DIRECTION_TRUE, "gson", "Lcom/google/gson/Gson;", "typeToken", "Lcom/google/gson/reflect/TypeToken;", "createInstance", "TypeAdapterImpl", "lib-modelx"}, k = 1, mv = {1, 4, 3})
public abstract class SerializableObjectJsonAdapterBase implements TypeAdapterFactory {
    private final Lazy constructor$delegate;
    private final Class<?> rawType;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase$TypeAdapterImpl;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/google/gson/TypeAdapter;", "lib-modelx"}, k = 1, mv = {1, 4, 3})
    public static final class TypeAdapterImpl<T> extends TypeAdapter<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Lazy f270969a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Gson f270970b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Class<?> f270971c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final TypeAdapterFactory f270972d;

        @Override // com.google.gson.TypeAdapter
        public final T read(JsonReader r100) {
            Intrinsics.checkNotNullParameter(r100, "in");
            return (T) ((TypeAdapter) this.f270969a.getValue()).read(r100);
        }

        @Override // com.google.gson.TypeAdapter
        public final void write(JsonWriter r100, T r101) {
            Intrinsics.checkNotNullParameter(r100, Argument.OUT);
            if (r101 != null) goto L6;
            r100.nullValue();
            return;
        L6:
            ((TypeAdapter) this.f270969a.getValue()).write(r100, r101);
        }

        public TypeAdapterImpl(Gson r100, Class<?> r101, TypeAdapterFactory r102) {
            Intrinsics.checkNotNullParameter(r100, "gson");
            Intrinsics.checkNotNullParameter(r101, "implType");
            Intrinsics.checkNotNullParameter(r102, "factory");
            this.f270970b = r100;
            this.f270971c = r101;
            this.f270972d = r102;
            this.f270969a = LazyKt.lazy(new SerializableObjectJsonAdapterBase$TypeAdapterImpl$delegateAdapter$2(this));
        }
    }

    private final Constructor<? extends Object> getConstructor() {
        return (Constructor) this.constructor$delegate.getValue();
    }

    public final Object createInstance() {
        return getConstructor().newInstance(new Object[0]);
    }

    public SerializableObjectJsonAdapterBase(Class<?> r100) {
        Intrinsics.checkNotNullParameter(r100, "rawType");
        this.rawType = r100;
        this.constructor$delegate = LazyKt.lazy(new SerializableObjectJsonAdapterBase$constructor$2(this));
    }

    public static final /* synthetic */ Class access$getRawType$p(SerializableObjectJsonAdapterBase r100) {
        return r100.rawType;
    }

    @Override // com.google.gson.TypeAdapterFactory
    public <T> TypeAdapter<T> create(Gson r100, TypeToken<T> r101) {
        Intrinsics.checkNotNullParameter(r100, "gson");
        Intrinsics.checkNotNullParameter(r101, "typeToken");
        return new TypeAdapterImpl(r100, this.rawType, this);
    }
}
