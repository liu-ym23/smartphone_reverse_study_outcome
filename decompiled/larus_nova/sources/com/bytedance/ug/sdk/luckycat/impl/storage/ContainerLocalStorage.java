package com.bytedance.ug.sdk.luckycat.impl.storage;

import android.content.SharedPreferences;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.utils.j;
import com.bytedance.ies.xbridge.v;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.ug.sdk.luckycat.impl.manager.m;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import rj7.c;

/* JADX INFO: loaded from: classes22.dex */
public final class ContainerLocalStorage {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static ContainerLocalStorage f271488b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SharedPreferences f271489a;

    public static final enum XReadableType extends Enum<XReadableType> {
        public static final XReadableType TYPE_ARRAY = null;
        public static final XReadableType TYPE_BOOLEAN = null;
        public static final XReadableType TYPE_DOUBLE = null;
        public static final XReadableType TYPE_INT = null;
        public static final XReadableType TYPE_MAP = null;
        public static final XReadableType TYPE_STRING = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ XReadableType[] f271490a = null;

        static {
            XReadableType r100 = new XReadableType("TYPE_BOOLEAN", 0);
            TYPE_BOOLEAN = r100;
            XReadableType r101 = new XReadableType("TYPE_INT", 1);
            TYPE_INT = r101;
            XReadableType r102 = new XReadableType("TYPE_DOUBLE", 2);
            TYPE_DOUBLE = r102;
            XReadableType r103 = new XReadableType("TYPE_ARRAY", 3);
            TYPE_ARRAY = r103;
            XReadableType r104 = new XReadableType("TYPE_MAP", 4);
            TYPE_MAP = r104;
            XReadableType r105 = new XReadableType("TYPE_STRING", 5);
            TYPE_STRING = r105;
            f271490a = new XReadableType[]{r100, r101, r102, r103, r104, r105};
        }

        public static XReadableType[] values() {
            return (XReadableType[]) f271490a.clone();
        }

        public static XReadableType valueOf(String r100) {
            return (XReadableType) r27.a.a(XReadableType.class, r100);
        }

        public XReadableType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f271491a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ContainerLocalStorage f271492b;

        @Override // java.lang.Runnable
        public final void run() {
            this.f271492b.f271489a.edit().remove(this.f271491a).apply();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(ContainerLocalStorage r100, String r101) {
            this.f271492b = r100;
            this.f271491a = r101;
        }
    }

    public static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f271493a = null;

        static {
            int[] r100 = new int[XReadableType.values().length];
            f271493a = r100;
            r100[XReadableType.TYPE_BOOLEAN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L16:
            f271493a[XReadableType.TYPE_INT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L20:
            f271493a[XReadableType.TYPE_DOUBLE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L26:
            f271493a[XReadableType.TYPE_ARRAY.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L18:
            f271493a[XReadableType.TYPE_MAP.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L22:
            f271493a[XReadableType.TYPE_STRING.ordinal()] = 6;     // Catch: NoSuchFieldError -> L15
            return;
        }
    }

    public static ContainerLocalStorage a() {
        if (f271488b != null) goto L15;
        monitor-enter(ContainerLocalStorage.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f271488b != null) goto L9;
        f271488b = new ContainerLocalStorage();     // Catch: Throwable -> L11
    L9:
        monitor-exit(ContainerLocalStorage.class);     // Catch: Throwable -> L11
    L15:
        return f271488b;
    }

    public ContainerLocalStorage() {
        this.f271489a = m.a.f271349a.f().getSharedPreferences("luckycat_container_local_storage", 0);
    }

    public final Object b(String r110) {
        if (TextUtils.isEmpty(r110) == false) goto L5;
        return null;
    L5:
        if (this.f271489a.contains(r110) == false) goto L59;
        String r100 = "";
        String r101 = this.f271489a.getString(r110, "");
        JSONObject r102 = new JSONObject(r101);     // Catch: JSONException -> L14
        long r103 = r102.optLong("expired_time", -1);     // Catch: JSONException -> L14
        long r104 = r102.optLong("storage_time");     // Catch: JSONException -> L14
        if (r103 != (-1)) goto L11;
    L45:
        JSONObject r111 = new JSONObject(r101);     // Catch: IllegalArgumentException -> L38 JSONException -> L40
        if (r111.names() == null) goto L51;
        JSONArray r105 = r111.names();     // Catch: IllegalArgumentException -> L38 JSONException -> L40
        int r106 = 0;
    L21:
        if (r106 >= r105.length()) goto L28;
        String r107 = JSONArrayProtectorUtils.getString(r105, r106);     // Catch: IllegalArgumentException -> L38 JSONException -> L40
        if (TextUtils.isEmpty(r107) == true) goto L27;
        if (r107.startsWith("TYPE") == false) goto L27;
        r100 = r107;
    L27:
        r106 = r106 + 1;     // Catch: IllegalArgumentException -> L38 JSONException -> L40
    L28:
        String r112 = JSONObjectProtectorUtils.getString(r111, r100);     // Catch: IllegalArgumentException -> L38 JSONException -> L40
        switch(b.f271493a[XReadableType.valueOf(r100).ordinal()]) {
            case 1: goto L60;
            case 2: goto L57;
            case 3: goto L56;
            case 4: goto L33;
            case 5: goto L32;
            case 6: goto L53;
            default: goto L52;
        };     // Catch: IllegalArgumentException -> L38 JSONException -> L40
    L32:
        int r108 = j.f249563a;     // Catch: IllegalArgumentException -> L38 JSONException -> L40
        return j.b(new JSONObject(r112));
    L33:
        int r109 = j.f249563a;     // Catch: IllegalArgumentException -> L38 JSONException -> L40
        return j.a(new JSONArray(r112));
    L52:
        return null;
    L53:
        return r112;
    L56:
        return Double.valueOf(CastDoubleProtector.parseDouble(r112));
    L57:
        return CastIntegerProtector.valueOf(r112);
    L60:
        return Boolean.valueOf(r112);
    L51:
        return null;
    L38:
        e = move-exception;
        e.printStackTrace();
        return null;
    L40:
        e = move-exception;
        e.printStackTrace();
        return null;
    L11:
        if ((System.currentTimeMillis() - r104) <= TimeUnit.SECONDS.toMillis(r103)) goto L45;
        c(r110);     // Catch: JSONException -> L14
        return null;
    L14:
        e = move-exception;
        e.getMessage();
        goto L45
    L59:
        return null;
    }

    public final boolean c(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L7;
        return false;
    L7:
        if (Looper.getMainLooper() != Looper.myLooper()) goto L10;
        c.a(new a(this, r100));
        return true;
    L10:
        this.f271489a.edit().remove(r100).apply();
        return true;
    }

    public static String d(Object r100, long r101) {
        HashMap r102 = new HashMap();
        if ((r100 instanceof Boolean) == false) goto L6;
        r102.put(XReadableType.TYPE_BOOLEAN.name(), r100.toString());
    L20:
        r102.put("expired_time", Long.valueOf(r101));
        r102.put("storage_time", Long.valueOf(System.currentTimeMillis()));
        return new JSONObject(r102).toString();
    L6:
        if ((r100 instanceof Integer) == false) goto L9;
        r102.put(XReadableType.TYPE_INT.name(), r100.toString());
        goto L20
    L9:
        if ((r100 instanceof String) == false) goto L12;
        r102.put(XReadableType.TYPE_STRING.name(), r100);
        goto L20
    L12:
        if ((r100 instanceof Double) == false) goto L15;
        r102.put(XReadableType.TYPE_DOUBLE.name(), r100.toString());
        goto L20
    L15:
        if ((r100 instanceof v) == false) goto L18;
        String r103 = XReadableType.TYPE_ARRAY.name();
        int r104 = j.f249563a;
        r102.put(r103, j.c((v) r100));
        goto L20
    L18:
        if ((r100 instanceof XReadableMap) == false) goto L22;
        String r105 = XReadableType.TYPE_MAP.name();
        int r106 = j.f249563a;
        r102.put(r105, j.d((XReadableMap) r100));
        goto L20
    L22:
        return "";
    }
}
