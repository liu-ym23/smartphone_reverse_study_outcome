package com.obric.capabilitykit.entity;

import androidx.exifinterface.media.ExifInterface;
import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.obric.capabilitykit.entity.app.ExtraEntity;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \n2\u00020\u0001:\u0002\n\u000bB\u0005¢\u0006\u0002\u0010\u0002J,\u0010\u0003\u001a\n\u0012\u0004\u0012\u0002H\u0005\u0018\u00010\u0004\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00050\tH\u0016¨\u0006\f"}, d2 = {"Lcom/obric/capabilitykit/entity/ExtraTypeAdapterFactory;", "Lcom/google/gson/TypeAdapterFactory;", "()V", "create", "Lcom/google/gson/TypeAdapter;", ExifInterface.GPS_DIRECTION_TRUE, "gson", "Lcom/google/gson/Gson;", "type", "Lcom/google/gson/reflect/TypeToken;", "Companion", "ExtraEntityTypeAdapter", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ExtraTypeAdapterFactory implements TypeAdapterFactory {
    public static final a Companion = null;
    private static final String KEY = "key";
    private static final String KEY_DATA_TYPE = "data_type";
    private static final String VALUE = "value";

    public static final class a {
        public a() {
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002R\u001d\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/obric/capabilitykit/entity/ExtraTypeAdapterFactory$ExtraEntityTypeAdapter;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/google/gson/TypeAdapter;", "delegate", "Lcom/google/gson/TypeAdapter;", "getDelegate", "()Lcom/google/gson/TypeAdapter;", "Lcom/google/gson/Gson;", "gson", "Lcom/google/gson/Gson;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1})
    public static final class b<T> extends TypeAdapter<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Gson f396202a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TypeAdapter<T> f396203b;

        @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"com/obric/capabilitykit/entity/ExtraTypeAdapterFactory$ExtraEntityTypeAdapter$read$listType$1", "Lcom/google/gson/reflect/TypeToken;", "", "Lcom/google/gson/JsonElement;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class a extends TypeToken<List<? extends JsonElement>> {
            public a() {
            }
        }

        public b(Gson r100, TypeAdapter<T> r101) {
            Intrinsics.checkNotNullParameter(r100, "gson");
            Intrinsics.checkNotNullParameter(r101, "delegate");
            this.f396202a = r100;
            this.f396203b = r101;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r3v6, types: [java.util.ArrayList] */
        @Override // com.google.gson.TypeAdapter
        public final T read(JsonReader r100) {
            Intrinsics.checkNotNullParameter(r100, "in");
            JsonObject r101 = new JsonParser().parse(r100).getAsJsonObject();
            JsonElement r102 = r101.get("value");
            r101.add("value", null);
            T r103 = this.f396203b.fromJsonTree(r101);
            if ((r103 instanceof ExtraEntity) == true) goto L5;
        L14:
            return r103;
        L5:
            if ((r102 instanceof JsonObject) == false) goto L14;
            JsonObject r104 = (JsonObject) r102;
            String r105 = r104.get("data_type").getAsString();
            JsonElement r106 = r104.get("value");
            ExtraEntity r107 = (ExtraEntity) r103;
            if (List.class.isAssignableFrom(a(r105)) == false) goto L12;
            Type r108 = new a().getType();
            List r109 = (List) GsonProtectorUtils.fromJson(this.f396202a, r106, r108);
            Object r110 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r109, 10));
            Iterator<T> r111 = r109.iterator();
        L10:
            if (r111.hasNext() == false) goto L13;
            JsonElement r112 = (JsonElement) r111.next();
            String r113 = r112.getAsJsonObject().get("data_type").getAsString();
            r110.add(GsonProtectorUtils.fromJson(this.f396202a, r112.getAsJsonObject().get("value"), a(r113)));
        L13:
            r107.setValue(r110);
            goto L14
        L12:
            r110 = GsonProtectorUtils.fromJson(this.f396202a, r106, a(r105));
            goto L13
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // com.google.gson.TypeAdapter
        public final void write(JsonWriter r110, T r111) {
            Intrinsics.checkNotNullParameter(r110, Argument.OUT);
            JsonObject r100 = this.f396203b.toJsonTree(r111).getAsJsonObject();
            if ((r111 instanceof ExtraEntity) == false) goto L19;
            ExtraEntity r112 = (ExtraEntity) r111;
            if (r112.getValue() == null) goto L19;
            JsonObject r101 = new JsonObject();
            Object r102 = r112.getValue();
            Intrinsics.checkNotNull(r102);
            r101.add("data_type", new JsonPrimitive(r102.getClass().getName()));
            if ((r112.getValue() instanceof List) == false) goto L17;
            JsonArray r103 = new JsonArray();
            Object r113 = r112.getValue();
            Intrinsics.checkNotNull(r113, "null cannot be cast to non-null type kotlin.collections.List<*>");
            Iterator<T> r114 = ((List) r113).iterator();
        L10:
            if (r114.hasNext() == false) goto L16;
            T r104 = r114.next();
            JsonObject r105 = new JsonObject();
            if (r104 == null) goto L14;
            String r106 = r104.getClass().getName();
        L15:
            r105.add("data_type", new JsonPrimitive(r106));
            r105.add("value", GsonProtectorUtils.toJsonTree(this.f396202a, r104));
            r103.add(r105);
            goto L10
        L14:
            r106 = null;
            goto L15
        L16:
            r101.add("value", r103);
        L18:
            r100.add("value", r101);
            goto L19
        L17:
            r101.add("value", GsonProtectorUtils.toJsonTree(this.f396202a, r112.getValue()));
        L19:
            this.f396202a.toJson(r100, r110);
        }

        @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
        public static Class a(String r100) throws ClassNotFoundException {
            ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
            FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
            if (el9.a.a() == true) goto L34;
            Class<?> r103 = Class.forName(r100);     // Catch: Throwable -> L8
            if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
            FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
        L7:
            return r103;
        L8:
            th = move-exception;
            if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
            FastClassNotFoundHandler.b(r100);
        L12:
            throw th;
        L34:
            Class<?> r104 = Class.forName(r100);     // Catch: Throwable -> L17
            if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
            FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
        L16:
            return r104;
        L17:
            th = move-exception;
            if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
            FastClassNotFoundHandler.b(r100);
        L22:
            if ((th instanceof PluginClassNotFoundException) == false) goto L24;
            throw th;
        L24:
            if ((th instanceof ClassNotFoundException) == true) goto L30;
            if ((th instanceof NoClassDefFoundError) == true) goto L30;
            throw th;
        L30:
            return MiraPluginFix.forName(r100);
        }
    }

    static {
        Companion = new a();
    }

    public ExtraTypeAdapterFactory() {
    }

    @Override // com.google.gson.TypeAdapterFactory
    public <T> TypeAdapter<T> create(Gson r100, TypeToken<T> r101) {
        Intrinsics.checkNotNullParameter(r100, "gson");
        Intrinsics.checkNotNullParameter(r101, "type");
        if (Intrinsics.areEqual(r101.getRawType(), ExtraEntity.class) == true) goto L7;
        return null;
    L7:
        return new b(r100, r100.getDelegateAdapter(this, r101));
    }
}
