package com.ss.android.lark.chameleon.util;

import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.ToNumberPolicy;
import com.ss.android.lark.chameleon.idependency.Log;
import java.util.Arrays;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0002J\u0010\u0010\n\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\u0007J#\u0010\n\u001a\u0004\u0018\u00010\u0007\"\u0004\b\u0000\u0010\u000b2\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\f\u001a\u0002H\u000b¢\u0006\u0002\u0010\rJ)\u0010\u000e\u001a\u0002H\u000b\"\u0004\b\u0000\u0010\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00072\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u0011¢\u0006\u0002\u0010\u0012J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0007J#\u0010\u0016\u001a\n \u0005*\u0004\u0018\u00010\u00070\u0007\"\u0004\b\u0000\u0010\u000b2\b\u0010\f\u001a\u0004\u0018\u0001H\u000b¢\u0006\u0002\u0010\u0017R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/ss/android/lark/chameleon/util/JsonUtils;", "", "()V", "GSON", "Lcom/google/gson/Gson;", "kotlin.jvm.PlatformType", "TAG", "", "checkFunctionName", "functionName", "combineRequestContent", ExifInterface.GPS_DIRECTION_TRUE, "functionParam", "(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;", "fromJson", "json", "classOfT", "Ljava/lang/Class;", "(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;", "isJSONValid", "", "str", "toJsonString", "(Ljava/lang/Object;)Ljava/lang/String;", "chameleon-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class JsonUtils {
    private static final Gson GSON = null;
    public static final JsonUtils INSTANCE = null;
    private static final String TAG = "JsonUtils";

    private JsonUtils() {
    }

    static {
        INSTANCE = new JsonUtils();
        GsonBuilder r100 = new GsonBuilder();
        Class r101 = Integer.TYPE;
        GSON = r100.registerTypeAdapter(r101, new IntTypeAdapter()).registerTypeAdapter(r101, new IntTypeAdapter()).setObjectToNumberStrategy(ToNumberPolicy.LONG_OR_DOUBLE).create();
    }

    private final String checkFunctionName(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L14;
        boolean r101 = false;
        if (StringsKt.contains$default(r100, "(", false, 2, null) == false) goto L7;
    L9:
        if (r101 == false) goto L12;
        return r100;
    L12:
        throw new IllegalArgumentException("function name can't contain brackets".toString());
    L7:
        if (StringsKt.contains$default(r100, ")", false, 2, null) == true) goto L9;
        r101 = true;
        goto L9
    L14:
        throw new NullPointerException("function name must not be null");
    }

    public final String combineRequestContent(String r100) {
        Intrinsics.checkNotNullParameter(r100, "functionName");
    L9:
        e = move-exception;
        Log.e(TAG, e.toString());
        return null;
    L4:
        if ((!TextUtils.isEmpty(r100)) == false) goto L8;
        return StringsKt.replace$default(checkFunctionName(r100), "\n", "\\n", false, 4, null);
    L8:
        throw new IllegalArgumentException("js func empty !".toString());     // Catch: Exception -> L9
    }

    public final boolean isJSONValid(String r100) {
        Intrinsics.checkNotNullParameter(r100, "str");
        new JSONObject(r100);     // Catch: JSONException -> L5
        return true;
    L5:
        new JSONArray(r100);     // Catch: JSONException -> L8
        return true;
    L8:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T> String toJsonString(T r100) {
        if (r100 != 0) goto L5;
        return "";
    L5:
        if ((r100 instanceof String) == false) goto L8;
        return (String) r100;
    L8:
        if ((r100 instanceof JSONObject) == false) goto L11;
        return ((JSONObject) r100).toString();
    L11:
        if ((r100 instanceof Map) == false) goto L14;
        return GsonProtectorUtils.toJsonTree(GSON, r100).getAsJsonObject().toString();
    L14:
        return GsonProtectorUtils.toJson(GSON, r100);
    }

    public final <T> String combineRequestContent(String r100, T r110) {
        Intrinsics.checkNotNullParameter(r100, "functionName");
    L9:
        e = move-exception;
        Log.e(TAG, e.toString());
        return null;
    L4:
        if ((!TextUtils.isEmpty(r100)) == false) goto L8;
        StringCompanionObject r101 = StringCompanionObject.INSTANCE;     // Catch: Exception -> L9
        String r102 = String.format("%s(%s)", Arrays.copyOf(new Object[]{checkFunctionName(r100), toJsonString(r110)}, 2));     // Catch: Exception -> L9
        Log.i(TAG, r102);     // Catch: Exception -> L9
        return StringsKt.replace$default(r102, "\n", "\\n", false, 4, null);
    L8:
        throw new IllegalArgumentException("js func empty !".toString());     // Catch: Exception -> L9
    }

    public final <T> T fromJson(String r100, Class<T> r101) {
        Intrinsics.checkNotNullParameter(r101, "classOfT");
        return (T) GsonProtectorUtils.fromJson(GSON, r100, r101);
    }
}
