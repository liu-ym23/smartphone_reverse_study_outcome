package com.huawei.hms.utils;

import android.text.TextUtils;
import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.support.log.common.Base64;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.security.AccessController;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes23.dex */
public class JsonUtil {
    protected static final int VAL_BYTE = 2;
    protected static final int VAL_ENTITY = 0;
    protected static final int VAL_LIST = 1;
    protected static final int VAL_MAP = 3;
    protected static final int VAL_NULL = -1;
    protected static final String VAL_TYPE = "_val_type_";

    public JsonUtil() {
    }

    private static String a(IMessageEntity r100) throws IllegalAccessException, JSONException {
        Class<?> r101 = r100.getClass();
        JSONObject r102 = new JSONObject();
    L3:
        if (r101 == null) goto L12;
        Field[] r103 = r101.getDeclaredFields();
        int r104 = r103.length;
        int r105 = 0;
    L5:
        if (r105 >= r104) goto L10;
        Field r106 = r103[r105];
        if (r106.isAnnotationPresent(Packed.class) == false) goto L9;
        boolean r107 = r106.isAccessible();
        a(r106, true);
        String r108 = r106.getName();
        Object r109 = r106.get(r100);
        a(r106, r107);
        a(r108, r109, r102);
    L9:
        r105 = r105 + 1;
        goto L5
    L10:
        r101 = r101.getSuperclass();
        goto L3
    L12:
        return r102.toString();
    }

    public static String createJsonString(IMessageEntity r100) {
        if (r100 != null) goto L13;
        HMSLog.e("JsonUtil", "createJsonString error, the input IMessageEntity is null");
        return "";
    L13:
        return a(r100);
    L10:
        e = move-exception;
        HMSLog.e("JsonUtil", "catch IllegalAccessException " + e.getMessage());
    L12:
        return "";
    L8:
        e = move-exception;
        HMSLog.e("JsonUtil", "catch JSONException " + e.getMessage());
        goto L12
    }

    private static byte[] a(JSONObject r100) throws JSONException {
        return Base64.decode(JSONObjectProtectorUtils.getString(r100, "_byte_"));
    L4:
        e = move-exception;
        HMSLog.e("JsonUtil", "readByte failed : " + e.getMessage());
        return null;
    }

    private static List<Object> a(Type r100, JSONObject r101) throws JSONException, IllegalAccessException, InstantiationException {
        int r102 = JSONObjectProtectorUtils.getInt(r101, "_list_size_");
        int r103 = JSONObjectProtectorUtils.getInt(r101, VAL_TYPE);
        ArrayList r104 = new ArrayList(r102);
        int r105 = 0;
    L3:
        if (r105 >= r102) goto L11;
        Object r106 = r101.get("_list_item_" + r105);
        if (r103 != 0) goto L8;
        r104.add(jsonToEntity((String) r106, (IMessageEntity) ((Class) ((ParameterizedType) r100).getActualTypeArguments()[0]).newInstance()));
    L10:
        r105 = r105 + 1;
        goto L3
    L8:
        if (r103 != 1) goto L10;
        r104.add(r106);
        goto L10
    L11:
        return r104;
    }

    private static Map b(Type r100, JSONObject r101) throws JSONException, IllegalAccessException, InstantiationException {
        Class r102 = (Class) ((ParameterizedType) r100).getActualTypeArguments()[1];
        JSONArray r103 = new JSONArray(JSONObjectProtectorUtils.getString(r101, "_map_"));
        HashMap r104 = new HashMap();
        int r105 = 0;
    L4:
        if (r105 >= r103.length()) goto L10;
        if ((r102.newInstance() instanceof IMessageEntity) == false) goto L8;
        IMessageEntity r106 = jsonToEntity(JSONArrayProtectorUtils.getString(r103, r105 + 1), (IMessageEntity) r102.newInstance());
        r104.put(r103.get(r105), r106);
    L9:
        r105 = r105 + 2;
        goto L4
    L8:
        r104.put(r103.get(r105), r103.get(r105 + 1));
        goto L9
    L10:
        return r104;
    }

    public static Object getInfoFromJsonobject(String r100, String r101) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
    L14:
        return null;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L14;
        JSONObject r102 = new JSONObject(r100);     // Catch: JSONException -> L13
        if (r102.has(r101) == true) goto L10;
        return null;
    L10:
        Object r103 = r102.get(r101);     // Catch: JSONException -> L13
        if ((r103 instanceof String) == false) goto L14;
        return r103;
    L13:
        HMSLog.e("JsonUtil", "getInfoFromJsonobject:parser json error :" + r101);
        goto L14
    }

    public static int getIntValue(JSONObject r100, String r101) throws JSONException {
        if (r100 != null) goto L4;
    L6:
        return -1;
    L4:
        if (r100.has(r101) == false) goto L6;
        return JSONObjectProtectorUtils.getInt(r100, r101);
    }

    public static String getStringValue(JSONObject r100, String r101) throws JSONException {
        if (r100 != null) goto L4;
    L6:
        return null;
    L4:
        if (r100.has(r101) == false) goto L6;
        return JSONObjectProtectorUtils.getString(r100, r101);
    }

    public static IMessageEntity jsonToEntity(String r100, IMessageEntity r101) {
        if (r101 != null) goto L27;
        return null;
    L27:
        Class<?> r102 = r101.getClass();     // Catch: JSONException -> L22
        JSONObject r103 = new JSONObject(r100);     // Catch: JSONException -> L22
    L7:
        if (r102 == null) goto L24;
        Field[] r104 = r102.getDeclaredFields();     // Catch: JSONException -> L22
        if (r104 != null) goto L12;
        Class<? super Object> r105 = r102.getSuperclass();     // Catch: JSONException -> L22
    L11:
        r102 = r105;
        goto L7
    L12:
        int r106 = r104.length;     // Catch: JSONException -> L22
        int r107 = 0;
    L13:
        if (r107 >= r106) goto L20;
        Field r108 = r104[r107];     // Catch: JSONException -> L22
        if (r108.isAnnotationPresent(Packed.class) == false) goto L19;
        a(r101, r108, r103);     // Catch: IllegalAccessException -> L18 JSONException -> L22
    L18:
        HMSLog.e("JsonUtil", "jsonToEntity, set value of the field exception, field name:" + r108.getName());     // Catch: JSONException -> L22
    L19:
        r107 = r107 + 1;     // Catch: JSONException -> L22
        goto L13
    L20:
        r105 = r102.getSuperclass();     // Catch: JSONException -> L22
    L24:
        return r101;
    L22:
        e = move-exception;
        HMSLog.e("JsonUtil", "catch JSONException when parse jsonString" + e.getMessage());
        goto L24
    }

    private static Object a(String r100, JSONObject r101) throws JSONException {
        if (r101.has(r100) == false) goto L7;
        return r101.get(r100);
    L7:
        if (r101.has("header") == false) goto L13;
        if (JSONObjectProtectorUtils.getJSONObject(r101, "header").has(r100) == false) goto L13;
        return JSONObjectProtectorUtils.getJSONObject(r101, "header").get(r100);
    L13:
        if (r101.has(ContainerPosition.BODY) == true) goto L15;
        return null;
    L15:
        if (JSONObjectProtectorUtils.getJSONObject(r101, ContainerPosition.BODY).has(r100) == true) goto L17;
        return null;
    L17:
        return JSONObjectProtectorUtils.getJSONObject(r101, ContainerPosition.BODY).get(r100);
    }

    private static void a(final Field r100, final boolean r101) {
        AccessController.doPrivileged(new AnonymousClass1(r100, r101));
    }

    private static boolean a(String r100, Object r101, JSONObject r102) throws JSONException, IllegalAccessException {
        if ((r101 instanceof String) == false) goto L6;
        r102.put(r100, (String) r101);
        return true;
    L6:
        if ((r101 instanceof Integer) == false) goto L9;
        r102.put(r100, ((Integer) r101).intValue());
        return true;
    L9:
        if ((r101 instanceof Short) == false) goto L12;
        r102.put(r100, (Short) r101);
        return true;
    L12:
        if ((r101 instanceof Long) == false) goto L15;
        r102.put(r100, (Long) r101);
        return true;
    L15:
        if ((r101 instanceof Float) == false) goto L18;
        r102.put(r100, (Float) r101);
        return true;
    L18:
        if ((r101 instanceof Double) == false) goto L21;
        r102.put(r100, (Double) r101);
        return true;
    L21:
        if ((r101 instanceof Boolean) == false) goto L24;
        r102.put(r100, (Boolean) r101);
        return true;
    L24:
        if ((r101 instanceof JSONObject) == false) goto L27;
        r102.put(r100, (JSONObject) r101);
        return true;
    L27:
        if ((r101 instanceof byte[]) == false) goto L30;
        a(r100, (byte[]) r101, r102);
        return true;
    L30:
        if ((r101 instanceof List) == false) goto L33;
        a(r100, (List) r101, r102);
        return true;
    L33:
        if ((r101 instanceof Map) == false) goto L36;
        a(r100, (Map) r101, r102);
        return true;
    L36:
        if ((r101 instanceof IMessageEntity) == true) goto L43;
    L42:
        return false;
    L43:
        r102.put(r100, a((IMessageEntity) r101));     // Catch: IllegalAccessException -> L40
        return true;
    L40:
        e = move-exception;
        HMSLog.e("JsonUtil", "IllegalAccessException , " + e);
        goto L42
    }

    private static Object b(IMessageEntity r100, Field r101, JSONObject r102) throws JSONException, IllegalAccessException {
        Object r103 = a(r101.getName(), r102);
        if (r103 != null) goto L32;
    L31:
        return null;
    L32:
    L30:
        HMSLog.e("JsonUtil", "InstantiationException  ");
        goto L31
    L5:
        if (r101.getType().getName().startsWith("com.huawei") == false) goto L11;
        if ((r101.getType().newInstance() instanceof IMessageEntity) == false) goto L11;
        return jsonToEntity((String) r103, (IMessageEntity) r101.getType().newInstance());
    L11:
        if ((r103 instanceof JSONObject) == true) goto L13;
    L29:
        return r103;
    L13:
        if (((JSONObject) r103).has(VAL_TYPE) == false) goto L29;
        int r104 = JSONObjectProtectorUtils.getInt((JSONObject) r103, VAL_TYPE);     // Catch: InstantiationException -> L30
        if (r104 == 1) goto L28;
        if (r104 == 0) goto L28;
        if (r104 != 2) goto L23;
        return a((JSONObject) r103);
    L23:
        if (r104 == 3) goto L25;
        HMSLog.e("JsonUtil", "cannot support type : " + r104);     // Catch: InstantiationException -> L30
        goto L31
    L25:
        return b(r101.getGenericType(), (JSONObject) r103);
    L28:
        return a(r101.getGenericType(), (JSONObject) r103);
    }

    private static void a(String r100, Map r101, JSONObject r102) throws JSONException, IllegalAccessException {
        Iterator r103 = r101.entrySet().iterator();
        JSONArray r104 = new JSONArray();
    L4:
        if (r103.hasNext() == false) goto L13;
        Map.Entry r105 = (Map.Entry) r103.next();
        Object r106 = r105.getKey();
        Object r107 = r105.getValue();
        if ((r106 instanceof IMessageEntity) == false) goto L8;
        r104.put(a((IMessageEntity) r106));
    L10:
        if ((r107 instanceof IMessageEntity) == true) goto L11;
        r104.put(r107);
        goto L4
    L11:
        r104.put(a((IMessageEntity) r107));
        goto L4
    L8:
        r104.put(r106);
        goto L10
    L13:
        JSONObject r108 = new JSONObject();
        r108.put(VAL_TYPE, 3);
        r108.put("_map_", r104.toString());
        r102.put(r100, r108);
    }

    private static void a(String r100, List<?> r101, JSONObject r102) throws JSONException, IllegalAccessException {
        JSONObject r103 = new JSONObject();
        r103.put(VAL_TYPE, 1);
        r103.put("_list_size_", r101.size());
        int r104 = 0;
    L4:
        if (r104 >= r101.size()) goto L9;
        a("_list_item_" + r104, ListProtector.get(r101, r104), r103);
        if ((ListProtector.get(r101, r104) instanceof IMessageEntity) == false) goto L8;
        r103.put(VAL_TYPE, 0);
    L8:
        r104 = r104 + 1;
        goto L4
    L9:
        r102.put(r100, r103);
    }

    private static void a(String r100, byte[] r101, JSONObject r102) throws JSONException {
        JSONObject r103 = new JSONObject();
        r103.put(VAL_TYPE, 2);
        r103.put("_byte_", Base64.encode(r101));     // Catch: IllegalArgumentException -> L5
    L7:
        r102.put(r100, r103);
        return;
    L5:
        e = move-exception;
        HMSLog.e("JsonUtil", "writeByte failed : " + e.getMessage());
        goto L7
    }

    private static void a(IMessageEntity r100, Field r101, JSONObject r102) throws JSONException, IllegalAccessException {
        Object r103 = b(r100, r101, r102);
        if (r103 == null) goto L6;
        boolean r104 = r101.isAccessible();
        a(r101, true);
        r101.set(r100, r103);
        a(r101, r104);
        return;
    }
}
