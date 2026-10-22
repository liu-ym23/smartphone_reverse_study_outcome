package com.bytedance.ugc.glue.json;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public class UGCJson {
    private static UGCJson instance;

    public static class a implements GenericArrayType {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Type f272383a;

        @Override // java.lang.reflect.GenericArrayType
        public final Type getGenericComponentType() {
            return this.f272383a;
        }

        public a(Type r100) {
            this.f272383a = r100;
        }
    }

    public static class b implements ParameterizedType {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Type f272384a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Type[] f272385b;

        @Override // java.lang.reflect.ParameterizedType
        public final Type getOwnerType() {
            return null;
        }

        @Override // java.lang.reflect.ParameterizedType
        public final Type[] getActualTypeArguments() {
            return this.f272385b;
        }

        @Override // java.lang.reflect.ParameterizedType
        public final Type getRawType() {
            return this.f272384a;
        }

        public static void a(Type r100) {
            if ((r100 instanceof Class) == false) goto L9;
            Class r101 = (Class) r100;
            if (r101.isPrimitive() == true) goto L8;
            return;
        L8:
            throw new IllegalArgumentException("ParameterizedType doesn't support primitive Type: " + r101);
        }

        public b(Type r100, Type[] r101) {
            this.f272384a = r100;
            this.f272385b = r101;
            a(r100);
            int r102 = r101.length;
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L5;
            a(r101[r103]);
            r103 = r103 + 1;
            goto L3
        }
    }

    public <T> T fromJsonImpl(Object r100, Type r101) {
        return null;
    }

    public String toJsonImpl(Object r100) {
        return "";
    }

    static {
        instance = new UGCJson();
    }

    private static UGCJson getInstance() {
        int r100 = ep7.a.f473437a;
        return instance;
    }

    public UGCJson() {
    }

    public final void register() {
        instance = this;
    }

    public static Type buildGenericArrayType(Type r100) {
        return new a(r100);
    }

    public static JSONObject jsonObject(Throwable r100) {
        JSONObject r101 = new JSONObject();
        r101.put("class", r100.getClass().getName());     // Catch: Throwable -> L11
        r101.put("message", r100.getMessage());     // Catch: Throwable -> L11
        StackTraceElement[] r102 = r100.getStackTrace();     // Catch: Throwable -> L11
        int r103 = 0;
    L5:
        if (r103 >= 10) goto L10;
        if (r103 >= r102.length) goto L10;
        StackTraceElement r104 = r102[r103];     // Catch: Throwable -> L11
        r101.put("trace" + r103, r104.getClassName() + "#" + r104.getMethodName() + "@" + r104.getLineNumber());     // Catch: Throwable -> L11
        r103 = r103 + 1;
    L10:
        return r101;
    }

    public static JSONObject mergeJSONObject(JSONObject... r100) {
        JSONObject r101 = new JSONObject();
        if (r100 == null) goto L14;
        int r102 = r100.length;
        int r103 = 0;
    L5:
        if (r103 >= r102) goto L14;
        JSONObject r104 = r100[r103];
        if (r104 == null) goto L13;
        Iterator<String> r105 = r104.keys();     // Catch: Throwable -> L15
    L10:
        if (r105.hasNext() == false) goto L13;
        String r106 = r105.next();     // Catch: Throwable -> L15
        r101.putOpt(r106, r104.get(r106));     // Catch: Throwable -> L15
    L13:
        r103 = r103 + 1;
    L14:
        return r101;
    }

    public static String toJson(Object r100) {
        return getInstance().toJsonImpl(r100);
    }

    public static JSONObject jsonObject(String r100) {
        return new JSONObject(r100);
    L5:
        return new JSONObject();
    }

    public static Type buildParameterizedType(Type r100, Type... r101) {
        return new b(r100, r101);
    }

    public static <T> T convert(Object r100, Type r101) {
        return (T) getInstance().convertImpl(r100, r101);
    }

    public static <T> T fromJson(InputStream r100, Type r101) {
        return (T) getInstance().fromJsonImpl(new InputStreamReader(r100), r101);
    }

    public <T> T convertImpl(Object r100, Type r101) {
        return (T) fromJsonImpl(toJsonImpl(r100), r101);
    }

    public static <T> T fromJson(Reader r100, Type r101) {
        return (T) getInstance().fromJsonImpl(r100, r101);
    }

    public static <T> T fromJson(String r100, Type r101) {
        return (T) getInstance().fromJsonImpl(r100, r101);
    }

    public static JSONObject put(JSONObject r100, String r101, Object r102) {
        if (r100 != null) goto L4;
        r100 = new JSONObject();
    L4:
        if (r101 == null) goto L7;
        if (r102 == null) goto L7;
        r100.put(r101, r102);     // Catch: Throwable -> L8
    L7:
        return r100;
    }
}
