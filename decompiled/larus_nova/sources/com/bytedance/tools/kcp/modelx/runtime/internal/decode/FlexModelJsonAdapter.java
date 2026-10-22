package com.bytedance.tools.kcp.modelx.runtime.internal.decode;

import androidx.exifinterface.media.ExifInterface;
import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import com.bytedance.android.ec.slice.SliceInitService;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.CompositeModelExtensionInfoHolder;
import com.bytedance.tools.kcp.modelx.runtime.internal.ModelExtensionProcessor;
import com.bytedance.tools.kcp.modelx.runtime.internal.d;
import com.bytedance.tools.kcp.modelx.runtime.internal.reflect.ModelXReflections;
import com.bytedance.tools.kcp.modelx.runtime.internal.reflect.f;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.Streams;
import com.google.gson.internal.bind.JsonTreeReader;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import vh7.e;

/* JADX INFO: loaded from: classes22.dex */
@Deprecated(message = "use FlexModelTypeAdapterFactory")
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/FlexModelJsonAdapter;", "Lcom/google/gson/TypeAdapterFactory;", "<init>", "()V", "TypeAdapterImpl", "lib-modelx"}, k = 1, mv = {1, 4, 3})
public class FlexModelJsonAdapter implements TypeAdapterFactory {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/FlexModelJsonAdapter$TypeAdapterImpl;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/google/gson/TypeAdapter;", "lib-modelx"}, k = 1, mv = {1, 4, 3})
    public static final class TypeAdapterImpl<T> extends TypeAdapter<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Class<?> f270963a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Class<?> f270964b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public TypeAdapter<Object> f270965c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Gson f270966d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Class<?> f270967e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final TypeAdapterFactory f270968f;

        public final TypeAdapter<Object> b() {
            TypeAdapter<Object> r100 = this.f270965c;
            if (r100 != null) goto L13;
            Class<?> r101 = c();
            if (r101 == null) goto L11;
            Gson r102 = this.f270966d;
            TypeAdapterFactory r103 = this.f270968f;
            TypeToken<T> r104 = TypeToken.get(r101);
            Intrinsics.checkNotNull(r104);
            TypeAdapter<T> r105 = r102.getDelegateAdapter(r103, r104);
            Intrinsics.checkNotNull(r105);
            if (r105 == null) goto L10;
            this.f270965c = r105;
            return r105;
        L10:
            throw new NullPointerException("null cannot be cast to non-null type com.google.gson.TypeAdapter<kotlin.Any>");
        L11:
            return null;
        L13:
            return r100;
        }

        public final Class<?> c() {
            Class<?> r100 = this.f270964b;
            if (r100 != null) goto L13;
            r100 = this.f270967e;
            Class<?> r101 = d();
            if (FlexModelBase.class.isAssignableFrom(r100) == false) goto L7;
        L12:
            this.f270964b = r100;
            goto L13
        L7:
            if (vh7.c.a.class.isAssignableFrom(r100) == true) goto L12;
            if (r101 == null) goto L11;
            r100 = ModelExtensionProcessor.f270937a.c(r101);
            goto L12
        L11:
            r100 = null;
        L13:
            return r100;
        }

        public final Class<?> d() {
            Class<?> r100 = this.f270963a;
            if (r100 != null) goto L6;
            Class<?> r101 = a(this.f270967e);
            this.f270963a = r101;
            return r101;
        L6:
            return r100;
        }

        public static Class a(Class r100) {
            if (r100.isInterface() == true) goto L5;
            Class<?> r101 = ModelExtensionProcessor.f270937a.d(r100);
            if (r101 != null) goto L16;
        L12:
            return null;
        L16:
            return a(r101);
        L5:
            if (e.class.isAssignableFrom(r100) == false) goto L14;
            d r102 = ModelExtensionProcessor.f270937a.a(r100);
            if (r102 == null) goto L12;
            return r102.f270958a;
        L14:
            return r100;
        }

        @Override // com.google.gson.TypeAdapter
        public final T read(JsonReader r110) {
            Intrinsics.checkNotNullParameter(r110, "in");
            JsonElement r100 = Streams.parse(r110);
            Intrinsics.checkNotNull(r100);
            if (r100.isJsonNull() == false) goto L5;
            return null;
        L5:
            Class<?> r101 = this.f270967e;
            Class<?> r102 = c();
            if (r102 != null) goto L15;
            if (r101.isInterface() == false) goto L10;
            Class<?> r103 = r101;
        L11:
            if (r103 == null) goto L13;
            r102 = ModelExtensionProcessor.f270937a.f(r103);
            goto L15
        L13:
            r102 = null;
            goto L15
        L10:
            r103 = null;
        L15:
            if (r102 != null) goto L20;
            if (r101.isInterface() == false) goto L33;
            Object r104 = ModelXReflections.g(new Class[]{r101}, f.a.f270991b);
        L106:
            return (T) r104;
        L33:
            r104 = ModelXReflections.f(r101, SliceInitService.DEFAULT_SWITCH, true);
            goto L106
        L20:
            if (Intrinsics.areEqual(r102, r101) == false) goto L28;
            TypeAdapter<Object> r105 = b();
            if (r105 == null) goto L24;
            Object r106 = r105.read(new JsonTreeReader(r100));
        L26:
            if ((r106 instanceof Object) == true) goto L29;
            r106 = null;
        L29:
            if (r106 == null) goto L31;
            Class<?> r107 = d();
            if (r107 == null) goto L38;
            List<d> r108 = ModelExtensionProcessor.f270937a.b(r107);
        L39:
            if (r108 != null) goto L49;
            if (e.class.isAssignableFrom(r101) == false) goto L47;
            CompositeModelExtensionInfoHolder r109 = ModelExtensionProcessor.f270937a;
            d r111 = r109.a(r101);
            if (r111 == null) goto L46;
            r108 = r109.b(r111.f270958a);
            if (r108 != null) goto L49;
        L46:
            r108 = CollectionsKt.emptyList();
            goto L49
        L47:
            r108 = ModelExtensionProcessor.f270937a.b(r101);
        L49:
            if (r108.isEmpty() == false) goto L57;
            if (Intrinsics.areEqual(r101, d()) == true) goto L92;
            if (Intrinsics.areEqual(r101, r102) == true) goto L92;
            return (T) com.bytedance.tools.kcp.modelx.runtime.internal.e.a((vh7.c) r106, r101);
        L92:
            return (T) r106;
        L57:
            if ((r106 instanceof vh7.c.a) == false) goto L59;
            FlexModelBase r112 = ((vh7.c.a) r106).getDelegate();
        L60:
            com.bytedance.tools.kcp.modelx.runtime.internal.c<Map<Class<?>, Object>> r113 = r112.extensionValues;
            r112.setThreadSafe(false);
            JsonObject r114 = r100.getAsJsonObject();     // Catch: Throwable -> L93
            Intrinsics.checkNotNull(r114);     // Catch: Throwable -> L93
            Set<Map.Entry<String, JsonElement>> r115 = r114.entrySet();     // Catch: Throwable -> L93
            Intrinsics.checkNotNull(r115);     // Catch: Throwable -> L93
            Iterator<T> r116 = r115.iterator();     // Catch: Throwable -> L93
        L62:
            if (r116.hasNext() == false) goto L85;
            Map.Entry r117 = (Map.Entry) r116.next();     // Catch: Throwable -> L93
            String r118 = (String) r117.getKey();     // Catch: Throwable -> L93
            JsonElement r119 = (JsonElement) r117.getValue();     // Catch: Throwable -> L93
            Iterator<T> r120 = r108.iterator();     // Catch: Throwable -> L93
            int r121 = -1;
            HashMap r122 = null;
        L66:
            if (r120.hasNext() == false) goto L80;
            d r123 = (d) r120.next();     // Catch: Throwable -> L93
            Pair<Integer, Type> r124 = r123.f270962e.b(r123.f270960c, r118);     // Catch: Throwable -> L93
            int r125 = r124.component1().intValue();     // Catch: Throwable -> L93
            Type r126 = r124.component2();     // Catch: Throwable -> L93
            if (r125 < 0) goto L78;
            if (r121 < 0) goto L73;
            if (r121 == r125) goto L73;
            com.bytedance.tools.kcp.modelx.runtime.internal.b.a(r123.f270959b, r118, r121, r125);     // Catch: Throwable -> L93
        L73:
            Object r127 = this.f270966d.fromJson(r119, r126);     // Catch: Throwable -> L93
            if (r127 == null) goto L79;
            if (r122 != null) goto L77;
            r122 = new HashMap(4);     // Catch: Throwable -> L93
        L77:
            Intrinsics.checkNotNull(r122);     // Catch: Throwable -> L93
            r122.put(r123.f270959b, r127);     // Catch: Throwable -> L93
            r121 = r125;
        L79:
            r116 = r116;
            goto L66
        L78:
            r116 = r116;
            goto L79
        L80:
            Iterator<T> r128 = r116;
            if (r121 < 0) goto L84;
            r113.c(r121, r122);     // Catch: Throwable -> L93
        L84:
            r116 = r128;
            goto L62
        L85:
            r112.setThreadSafe(true);
            if (Intrinsics.areEqual(r101, d()) == true) goto L92;
            if (Intrinsics.areEqual(r101, r102) == true) goto L92;
            return (T) com.bytedance.tools.kcp.modelx.runtime.internal.e.a((vh7.c) r106, r101);
        L93:
            th = move-exception;
            r112.setThreadSafe(true);
            throw th;
        L59:
            r112 = (FlexModelBase) r106;
            goto L60
        L38:
            r108 = null;
            goto L39
        L31:
            if (r101.isInterface() == false) goto L33;
            r104 = ModelXReflections.g(new Class[]{r101}, f.a.f270991b);
            goto L106
        L24:
            r106 = null;
            goto L26
        L28:
            r106 = GsonProtectorUtils.fromJson(this.f270966d, r100, r102);
            goto L29
        }

        @Override // com.google.gson.TypeAdapter
        public final void write(JsonWriter r210, T r211) {
            JsonWriter r100 = r210;
            Intrinsics.checkNotNullParameter(r100, Argument.OUT);
            if (r211 != null) goto L6;
            r210.nullValue();
            return;
        L6:
            Class<?> r101 = this.f270967e;
            vh7.c r102 = (vh7.c) r211;
            Function1<Object, JsonObject> r103 = new FlexModelJsonAdapter$TypeAdapterImpl$write$tree$1(this);
            CompositeModelExtensionInfoHolder r104 = ModelExtensionProcessor.f270937a;
            Intrinsics.checkNotNullParameter(r102, "message");
            Intrinsics.checkNotNullParameter(r101, "type");
            if (vh7.c.class.isAssignableFrom(r101) == true) goto L9;
        L11:
            boolean r105 = false;
        L13:
            if (r101.isInterface() == false) goto L15;
            Class<?> r106 = r101;
        L16:
            if (r106 != null) goto L18;
            List r107 = CollectionsKt.emptyList();
        L36:
            if ((r102 instanceof e) == false) goto L38;
            JsonObject r108 = r103.invoke(((e) r102).getFlexInstance());
        L40:
            if (r107.isEmpty() == true) goto L167;
            Iterator<T> r109 = r107.iterator();
        L44:
            if (r109.hasNext() == false) goto L166;
            e r110 = (e) r109.next();
            Class<?> r111 = r110.getClass();
            CompositeModelExtensionInfoHolder r112 = ModelExtensionProcessor.f270937a;
            Intrinsics.checkNotNullParameter(r111, "implType");
            Class<?> r113 = ModelExtensionProcessor.f270937a.d(r111);
            if (r113 != null) goto L48;
            Iterator<T> r114 = r109;
            List<com.bytedance.tools.kcp.modelx.runtime.internal.reflect.c> r115 = null;
            String r116 = null;
        L99:
            if (r115 == null) goto L163;
            Iterator<T> r117 = r115.iterator();
        L103:
            if (r117.hasNext() == false) goto L163;
            com.bytedance.tools.kcp.modelx.runtime.internal.reflect.c r118 = (com.bytedance.tools.kcp.modelx.runtime.internal.reflect.c) r117.next();
            JsonElement r119 = GsonProtectorUtils.toJsonTree(this.f270966d, r118.f270988c.invoke(r110, new Object[0]));
            if (r119 != null) goto L107;
            r119 = JsonNull.INSTANCE;
        L107:
            JsonElement r120 = r108.get(r118.f270986a);
            int r121 = r118.f270987b;
            if (r121 == 2) goto L124;
            if (r121 == 3) goto L113;
        L131:
            if (r120 == null) goto L132;
            String r122 = r118.f270986a;
            Intrinsics.checkNotNullParameter(r101, "type");
            Intrinsics.checkNotNullParameter(r122, "key");
            Intrinsics.checkNotNullParameter(r108, "jsonObject");
            Intrinsics.checkNotNullParameter(r120, "v1");
            Intrinsics.checkNotNullParameter(r119, "v2");
            vh7.d r123 = vh7.f.f554983a;
            if ((!Intrinsics.areEqual(r120.getClass(), r119.getClass())) == true) goto L136;
        L140:
            String r124 = r116;
        L141:
            if (r124 == null) goto L144;
            vh7.f.f554984b.error(r124);
        L144:
            if ((r120 instanceof JsonPrimitive) == true) goto L103;
            if ((r120 instanceof JsonObject) == true) goto L149;
            if ((r120 instanceof JsonArray) == true) goto L154;
            if ((r120 instanceof JsonNull) == true) goto L103;
            throw new IllegalStateException(("unknown type of JsonElement: " + r120 + ", " + r119).toString());
        L154:
            if ((r119 instanceof JsonArray) == false) goto L103;
            e((JsonArray) r120, r101, (JsonArray) r119);
            goto L103
        L149:
            if ((r119 instanceof JsonObject) == false) goto L103;
            f((JsonObject) r120, r101, (JsonObject) r119);
            goto L103
        L136:
            if (r120.isJsonNull() == true) goto L140;
            if (r119.isJsonNull() == true) goto L140;
            r124 = "merging different type of json elements: [" + r120 + ", " + r119 + "] for type [" + r101 + "] at key " + r122 + ", current json: " + r108;
            goto L141
        L132:
            r108.add(r118.f270986a, r119);
            goto L103
        L113:
            if (r119.isJsonNull() == false) goto L115;
        L118:
            boolean r125 = true;
        L119:
            if (r125 == true) goto L131;
            throw new IllegalStateException(("type mismatch: " + r118 + ", " + r119).toString());
        L115:
            if (r119.isJsonObject() == true) goto L118;
            r125 = false;
            goto L119
        L124:
            if (r119.isJsonNull() == false) goto L126;
        L129:
            boolean r126 = true;
        L130:
            if (r126 == true) goto L131;
            throw new IllegalStateException(("type mismatch: " + r118 + ", " + r119).toString());
        L126:
            if (r119.isJsonArray() == true) goto L129;
            r126 = false;
        L163:
            r109 = r114;
            goto L44
        L48:
            Gson r127 = ModelXReflections.f270980a;
            Intrinsics.checkNotNullParameter(r113, "type");
            if (r113.isInterface() == false) goto L165;
            ConcurrentHashMap<Class<?>, List<com.bytedance.tools.kcp.modelx.runtime.internal.reflect.c>> r128 = ModelXReflections.f270982c;
            List<com.bytedance.tools.kcp.modelx.runtime.internal.reflect.c> r129 = r128.get(r113);
            if (r129 != null) goto L97;
            LinkedHashMap r130 = new LinkedHashMap();
            Method[] r131 = r113.getDeclaredMethods();
            int r132 = r131.length;
            int r133 = 0;
        L53:
            if (r133 >= r132) goto L79;
            Method r134 = r131[r133];
            Intrinsics.checkNotNullParameter(r134, com.alipay.sdk.m.p.e.f25671s);
            Annotation[] r135 = r134.getAnnotations();
            int r136 = r135.length;
            Iterator<T> r137 = r109;
            int r138 = 0;
        L55:
            if (r138 >= r136) goto L60;
            int r139 = r132;
            Annotation r140 = r135[r138];
            Annotation[] r141 = r135;
            if ((r140 instanceof FieldName) == true) goto L61;
            r138 = r138 + 1;
            r132 = r139;
            r135 = r141;
        L61:
            FieldName r142 = (FieldName) r140;
            if (r142 != null) goto L64;
            Method[] r143 = r131;
            Pair r144 = null;
        L68:
            if (r144 == null) goto L78;
            String r145 = (String) r144.component1();
            boolean r146 = ((Boolean) r144.component2()).booleanValue();
            Object r147 = r130.get(r145);
            if (r147 != null) goto L76;
            int r148 = 2;
            Method[] r149 = new Method[2];
            int r150 = 0;
        L73:
            if (r150 >= r148) goto L75;
            r149[r150] = null;
            r150 = r150 + 1;
            r148 = 2;
            goto L73
        L75:
            r130.put(r145, r149);
            Object r151 = r149;
        L77:
            ((Method[]) r151)[r146 ? 1 : 0] = r134;
            goto L78
        L76:
            r151 = r147;
        L78:
            r133 = r133 + 1;
            r109 = r137;
            r132 = r139;
            r131 = r143;
            goto L53
        L64:
            r143 = r131;
            if (StringsKt.endsWith$default(r142.name(), "#setter", false, 2, null) == false) goto L67;
            r144 = TuplesKt.to(StringsKt.substringBeforeLast$default(r142.name(), "#setter", null, 2, null), Boolean.TRUE);
            goto L68
        L67:
            r144 = TuplesKt.to(r142.name(), Boolean.FALSE);
            goto L68
        L60:
            r139 = r132;
            r140 = null;
            goto L61
        L79:
            r114 = r109;
            r116 = null;
            ArrayList r152 = new ArrayList(r130.size());
            Iterator r153 = r130.entrySet().iterator();
        L81:
            if (r153.hasNext() == false) goto L94;
            Map.Entry r154 = (Map.Entry) r153.next();
            String r155 = (String) r154.getKey();
            Method[] r156 = (Method[]) r154.getValue();
            Method r157 = r156[0];
            if (r157 == null) goto L93;
            if (Collection.class.isAssignableFrom(r157.getReturnType()) == false) goto L88;
            int r158 = 2;
        L91:
            r152.add(new com.bytedance.tools.kcp.modelx.runtime.internal.reflect.c(r155, r158, r157, r156[1]));
            goto L81
        L88:
            if (Map.class.isAssignableFrom(r157.getReturnType()) == false) goto L90;
            r158 = 3;
            goto L91
        L90:
            r158 = 1;
            goto L91
        L93:
            throw new IllegalStateException(("getter is null for field [" + r155 + "] at type [" + r113 + ']').toString());
        L94:
            r129 = r128.putIfAbsent(r113, r152);
            if (r129 != null) goto L98;
            r129 = r152;
        L98:
            r115 = r129;
            goto L99
        L97:
            r114 = r109;
            r116 = null;
            goto L98
        L165:
            throw new IllegalStateException(("type must be interface: " + r113).toString());
        L166:
            r100 = r210;
        L167:
            Streams.write(r108, r100);
            return;
        L38:
            r108 = r103.invoke(r102);
            goto L40
        L18:
            if (r105 == true) goto L24;
            d r159 = ModelExtensionProcessor.f270937a.a(r106);
            if (r159 == null) goto L23;
            r106 = r159.f270958a;
            goto L24
        L23:
            r106 = null;
        L24:
            if (r106 != null) goto L26;
            r107 = CollectionsKt.emptyList();
            goto L36
        L26:
            List<d> r160 = ModelExtensionProcessor.f270937a.b(r106);
            ArrayList r161 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r160, 10));
            Iterator<T> r162 = r160.iterator();
        L28:
            if (r162.hasNext() == false) goto L34;
            e r163 = com.bytedance.tools.kcp.modelx.runtime.internal.e.a(r102, ((d) r162.next()).f270959b);
            if (r163 == null) goto L33;
            r161.add(r163);
            goto L28
        L33:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.tools.kcp.modelx.runtime.ModelExtension<*>");
        L34:
            r107 = r161;
            goto L36
        L15:
            r106 = ModelExtensionProcessor.f270937a.d(r101);
            goto L16
        L9:
            if (e.class.isAssignableFrom(r101) == true) goto L11;
            r105 = true;
            goto L13
        }

        public TypeAdapterImpl(Gson r100, Class<?> r101, TypeAdapterFactory r102) {
            Intrinsics.checkNotNullParameter(r100, "gson");
            Intrinsics.checkNotNullParameter(r101, "rawType");
            Intrinsics.checkNotNullParameter(r102, "factory");
            this.f270966d = r100;
            this.f270967e = r101;
            this.f270968f = r102;
        }

        public static void e(JsonArray r100, Type r101, JsonArray r102) {
            if (r100.size() == r102.size()) goto L13;
            if (r100.size() <= 0) goto L13;
            if (r102.size() <= 0) goto L13;
            Intrinsics.checkNotNullParameter(r101, "type");
            Intrinsics.checkNotNullParameter(r100, "value1");
            Intrinsics.checkNotNullParameter(r102, "value2");
            vh7.d r103 = vh7.f.f554983a;
            String r104 = "merging json arrays with different sizes is not supported: " + r100 + ", " + r102 + ", type: " + r101;
            if (r104 == null) goto L49;
            vh7.f.f554984b.error(r104);
            return;
        L49:
            return;
        L13:
            if (r100.size() != 0) goto L16;
            return;
        L16:
            if (r102.size() != 0) goto L18;
            return;
        L18:
            int r105 = 0;
        L20:
            if (r105 >= r100.size()) goto L40;
            JsonElement r106 = r100.get(r105);
            Intrinsics.checkNotNull(r106);
            if ((r106 instanceof JsonPrimitive) == true) goto L23;
            if ((r106 instanceof JsonNull) == true) goto L37;
            if ((r106 instanceof JsonObject) == false) goto L33;
            JsonElement r107 = r102.get(r105);
            Intrinsics.checkNotNull(r107);
            if ((r107 instanceof JsonObject) == false) goto L37;
            f((JsonObject) r106, r101, (JsonObject) r107);
            goto L37
        L33:
            if ((r106 instanceof JsonArray) == false) goto L39;
            JsonElement r108 = r102.get(r105);
            Intrinsics.checkNotNull(r108);
            if ((r108 instanceof JsonArray) == false) goto L37;
            e((JsonArray) r106, r101, (JsonArray) r108);
            goto L37
        L39:
            throw new IllegalStateException(("unknown type of JsonElement: " + r106).toString());
        L37:
            r105 = r105 + 1;
            goto L20
        L23:
            return;
        }

        public static void f(JsonObject r100, Type r101, JsonObject r102) {
            Set<Map.Entry<String, JsonElement>> r103 = r102.entrySet();
            Intrinsics.checkNotNull(r103);
            Iterator<T> r104 = CollectionsKt.toList(r103).iterator();
        L4:
            if (r104.hasNext() == false) goto L26;
            Map.Entry r105 = (Map.Entry) r104.next();
            String r106 = (String) r105.getKey();
            JsonElement r107 = (JsonElement) r105.getValue();
            JsonElement r108 = r100.get(r106);
            if (r108 == null) goto L4;
            if ((r108 instanceof JsonPrimitive) == true) goto L4;
            if ((r108 instanceof JsonObject) == true) goto L14;
            if ((r108 instanceof JsonArray) == true) goto L19;
            if ((r108 instanceof JsonNull) == true) goto L4;
            throw new IllegalStateException(("unknown type of JsonElement: " + r102.get(r106)).toString());
        L19:
            if ((r107 instanceof JsonArray) == false) goto L4;
            e((JsonArray) r108, r101, (JsonArray) r107);
            goto L4
        L14:
            if ((r107 instanceof JsonObject) == false) goto L4;
            f((JsonObject) r108, r101, (JsonObject) r107);
            goto L4
        }
    }

    public FlexModelJsonAdapter() {
    }

    @Override // com.google.gson.TypeAdapterFactory
    public final <T> TypeAdapter<T> create(Gson r100, TypeToken<T> r101) {
        Intrinsics.checkNotNullParameter(r100, "gson");
        Intrinsics.checkNotNullParameter(r101, "typeToken");
        Class<? super T> r102 = r101.getRawType();
        if (r102 != null) goto L6;
        return null;
    L6:
        if (vh7.c.class.isAssignableFrom(r102) == true) goto L9;
        return null;
    L9:
        return new TypeAdapterImpl(r100, r102, this);
    }
}
