package com.relax;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.relax.utils.NaturalTypeAdapter;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;

/* JADX INFO: loaded from: classes34.dex */
public class JNIMethodSignatureHelper {
    public JNIMethodSignatureHelper() {
    }

    public static List<String[]> getInstanceFieldNamesAndSignatures(Class<?> r100) {
        ArrayList r101 = new ArrayList();
    L3:
        if (r100 == null) goto L13;
        if (r100 == Object.class) goto L13;
        Field[] r102 = r100.getDeclaredFields();
        int r103 = r102.length;
        int r104 = 0;
    L7:
        if (r104 >= r103) goto L12;
        Field r105 = r102[r104];
        if (Modifier.isStatic(r105.getModifiers()) == true) goto L11;
        r101.add(new String[]{r105.getName(), getJNITypeSignature(r105.getType())});
    L11:
        r104 = r104 + 1;
        goto L7
    L12:
        r100 = r100.getSuperclass();
    L13:
        return r101;
    }

    public static List<String[]> getInstanceMethodNamesAndSignatures(Class<?> r100) {
        ArrayList r101 = new ArrayList();
        HashSet r102 = new HashSet();
    L3:
        if (r100 == null) goto L16;
        if (r100 == Object.class) goto L16;
        Method[] r103 = r100.getDeclaredMethods();
        int r104 = r103.length;
        int r105 = 0;
    L7:
        if (r105 >= r104) goto L15;
        Method r106 = r103[r105];
        if (Modifier.isStatic(r106.getModifiers()) == true) goto L14;
        String r107 = r106.getName();
        String r108 = getJNIMethodSignature(r106);
        if (r102.contains(r107 + r108) == true) goto L14;
        r102.add(r107 + r108);
        r101.add(new String[]{r107, r108});
    L14:
        r105 = r105 + 1;
        goto L7
    L15:
        r100 = r100.getSuperclass();
    L16:
        return r101;
    }

    public static String getJNIMethodSignature(Method r100) {
        StringBuilder r101 = new StringBuilder("(");
        Class<?>[] r102 = r100.getParameterTypes();
        int r103 = r102.length;
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L5;
        r101.append(getJNITypeSignature(r102[r104]));
        r104 = r104 + 1;
        goto L3
    L5:
        r101.append(')');
        r101.append(getJNITypeSignature(r100.getReturnType()));
        return r101.toString();
    }

    public static String getJNITypeSignature(Class<?> r100) {
        if (r100.isArray() == false) goto L7;
        return r100.getName().replace('.', '/');
    L7:
        if (r100.isPrimitive() == false) goto L47;
        if (r100 != Void.TYPE) goto L13;
        return "V";
    L13:
        if (r100 != Integer.TYPE) goto L17;
        return "I";
    L17:
        if (r100 != Boolean.TYPE) goto L21;
        return "Z";
    L21:
        if (r100 != Byte.TYPE) goto L25;
        return "B";
    L25:
        if (r100 != Character.TYPE) goto L29;
        return "C";
    L29:
        if (r100 != Short.TYPE) goto L33;
        return ExifInterface.LATITUDE_SOUTH;
    L33:
        if (r100 != Long.TYPE) goto L37;
        return "J";
    L37:
        if (r100 != Float.TYPE) goto L41;
        return FaceService.girlLabel;
    L41:
        if (r100 != Double.TYPE) goto L45;
        return "D";
    L45:
        throw new IllegalArgumentException("Unknown type: " + r100);
    L47:
        return "L" + r100.getName().replace('.', '/') + com.alipay.sdk.m.u.i.f25853b;
    }

    public static List<String[]> getStaticFieldNamesAndSignatures(Class<?> r100) {
        ArrayList r101 = new ArrayList();
    L3:
        if (r100 == null) goto L13;
        if (r100 == Object.class) goto L13;
        Field[] r102 = r100.getDeclaredFields();
        int r103 = r102.length;
        int r104 = 0;
    L7:
        if (r104 >= r103) goto L12;
        Field r105 = r102[r104];
        if (Modifier.isStatic(r105.getModifiers()) == false) goto L11;
        r101.add(new String[]{r105.getName(), getJNITypeSignature(r105.getType())});
    L11:
        r104 = r104 + 1;
        goto L7
    L12:
        r100 = r100.getSuperclass();
    L13:
        return r101;
    }

    public static List<String[]> getStaticMethodNamesAndSignatures(Class<?> r100) {
        ArrayList r101 = new ArrayList();
        HashSet r102 = new HashSet();
    L3:
        if (r100 == null) goto L16;
        if (r100 == Object.class) goto L16;
        Method[] r103 = r100.getDeclaredMethods();
        int r104 = r103.length;
        int r105 = 0;
    L7:
        if (r105 >= r104) goto L15;
        Method r106 = r103[r105];
        if (Modifier.isStatic(r106.getModifiers()) == false) goto L14;
        String r107 = r106.getName();
        String r108 = getJNIMethodSignature(r106);
        if (r102.contains(r107 + r108) == true) goto L14;
        r102.add(r107 + r108);
        r101.add(new String[]{r107, r108});
    L14:
        r105 = r105 + 1;
        goto L7
    L15:
        r100 = r100.getSuperclass();
    L16:
        return r101;
    }

    public static LinkedHashMap<String, Object> parseJsonToLinkedHashMap(String r100) {
        return (LinkedHashMap) GsonProtectorUtils.fromJson(new GsonBuilder().registerTypeAdapter(new AnonymousClass1().getType(), new NaturalTypeAdapter()).create(), r100, new AnonymousClass2().getType());
    }

    public static String parseLinkedHashMapToJson(LinkedHashMap<String, Object> r100) {
        return GsonProtectorUtils.toJson(new Gson(), r100);
    }
}
