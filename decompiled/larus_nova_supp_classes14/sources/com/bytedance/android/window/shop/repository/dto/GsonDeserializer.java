package com.bytedance.android.window.shop.repository.dto;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class GsonDeserializer {
    public static final Gson a = null;
    public static final Map<Class<?>, List<Field>> b = null;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/window/shop/repository/dto/GsonDeserializer$WrapperJsonDeserializer;", "", "T", "Lcom/google/gson/JsonDeserializer;", "<init>", "()V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class WrapperJsonDeserializer<T> implements JsonDeserializer<T> {
        public WrapperJsonDeserializer() {
        }

        public final T deserialize(JsonElement r8, Type r9, JsonDeserializationContext r10) {
            if (r8 != null) goto L5;
            return null;
        L5:
            if (r9 != null) goto L7;
            return null;
        L7:
            Gson r0 = GsonDeserializer.a;
            T r11 = (T) GsonProtectorUtils.fromJson(GsonDeserializer.a, r8, r9);
        L11:
            if (r11 != null) goto L13;
            return null;
        L13:
            Gson r1 = GsonDeserializer.a;
            Class<?> r2 = r11.getClass();
            List r3 = (List) ((LinkedHashMap) GsonDeserializer.b).get(r2);
            if (r3 != null) goto L22;
            Field[] r4 = r2.getDeclaredFields();
            ArrayList r5 = new ArrayList();
            int r6 = r4.length;
            int r7 = 0;
        L16:
            if (r7 >= r6) goto L21;
            Field r12 = r4[r7];
            if (r12.isAnnotationPresent(SubDTO.class) == false) goto L20;
            r5.add(r12);
        L20:
            r7 = r7 + 1;
            goto L16
        L21:
            GsonDeserializer.b.put(r2, r5);
            r3 = r5;
        L22:
            Iterator<T> r13 = r3.iterator();
        L24:
            if (r13.hasNext() == false) goto L32;
            Field r14 = (Field) r13.next();
            Gson r15 = GsonDeserializer.a;     // Catch: Exception -> L28
            Object r16 = GsonDeserializer.a.fromJson(r8, r14.getType());     // Catch: Exception -> L28
        L29:
            if (r16 == null) goto L24;
            r14.setAccessible(true);
            r14.set(r11, r16);
        L28:
            r16 = null;
            goto L29
        L32:
            return r11;
        L10:
            r11 = null;
            goto L11
        }
    }

    static {
        a = new Gson();
        b = new LinkedHashMap();
    }
}
