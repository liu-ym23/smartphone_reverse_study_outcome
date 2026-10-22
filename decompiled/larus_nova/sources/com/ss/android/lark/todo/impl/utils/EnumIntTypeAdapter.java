package com.ss.android.lark.todo.impl.utils;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.squareup.wire.WireEnum;
import java.io.IOException;
import java.lang.Enum;
import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes38.dex */
public class EnumIntTypeAdapter<T extends Enum<T>> extends TypeAdapter<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Integer, T> f444268a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<T, Integer> f444269b;

    public class a implements PrivilegedAction<Void> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Field f444270a;

        @Override // java.security.PrivilegedAction
        public final Void run() {
            this.f444270a.setAccessible(true);
            return null;
        }

        public a(Field r100) {
            this.f444270a = r100;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public EnumIntTypeAdapter(Class<T> r100) {
        this.f444268a = new HashMap();
        this.f444269b = new HashMap();
        Field[] r101 = r100.getDeclaredFields();     // Catch: IllegalAccessException -> L14
        int r102 = r101.length;     // Catch: IllegalAccessException -> L14
        int r103 = 0;
    L4:
        if (r103 >= r102) goto L13;
        Field r104 = r101[r103];     // Catch: IllegalAccessException -> L14
        if (r104.isEnumConstant() == false) goto L12;
        AccessController.doPrivileged(new a(r104));     // Catch: IllegalAccessException -> L14
        Enum r105 = (Enum) r104.get(null);     // Catch: IllegalAccessException -> L14
        int r106 = r105.ordinal();     // Catch: IllegalAccessException -> L14
        if ((r105 instanceof WireEnum) == false) goto L11;
        r106 = ((WireEnum) r105).getValue();     // Catch: IllegalAccessException -> L14
    L11:
        Map<Integer, T> r107 = this.f444268a;     // Catch: IllegalAccessException -> L14
        HashMap r108 = (HashMap) r107;     // Catch: IllegalAccessException -> L14
        r108.put(Integer.valueOf(r106), r105);     // Catch: IllegalAccessException -> L14
        Map<T, Integer> r109 = this.f444269b;     // Catch: IllegalAccessException -> L14
        HashMap r110 = (HashMap) r109;     // Catch: IllegalAccessException -> L14
        r110.put(r105, Integer.valueOf(r106));     // Catch: IllegalAccessException -> L14
    L12:
        r103 = r103 + 1;
        goto L4
    L13:
        return;
    L14:
        e = move-exception;
        throw new AssertionError(e);
    }

    @Override // com.google.gson.TypeAdapter
    public final Object read(JsonReader r100) throws IOException {
        if (r100.peek() != JsonToken.NULL) goto L5;
        r100.nextNull();
        return null;
    L5:
        Map<Integer, T> r101 = this.f444268a;
        HashMap r102 = (HashMap) r101;
        return (Enum) r102.get(Integer.valueOf(r100.nextInt()));
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter r100, Object r101) throws IOException {
        Enum r102 = (Enum) r101;
        if (r102 != null) goto L5;
        Integer r103 = null;
    L6:
        r100.value(r103);
        return;
    L5:
        r103 = (Integer) ((HashMap) this.f444269b).get(r102);
        goto L6
    }
}
