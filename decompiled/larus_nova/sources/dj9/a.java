package dj9;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.XReadableType;
import com.bytedance.ies.xbridge.v;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p56.d;

/* JADX INFO: loaded from: classes30.dex */
public final class a implements d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Gson f468960b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SharedPreferences f468961a;

    /* JADX INFO: renamed from: dj9.a$a, reason: collision with other inner class name */
    public static final class C5677a {
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\n"}, d2 = {"Lcom/larus/live/impl/utils/AdNativeStorageImpl$StorageValue;", "", "type", "", "value", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getType", "()Ljava/lang/String;", "getValue", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class b {

        @SerializedName("type")
        private final String type;

        @SerializedName("value")
        private final String value;

        public b() {
            this(null, null);
        }

        public final String a() {
            return this.value;
        }

        public final String getType() {
            return this.type;
        }

        public b(String r100, String r101) {
            this.type = r100;
            this.value = r101;
        }
    }

    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f468962a = null;

        static {
            int[] r100 = new int[XReadableType.values().length];
            r100[XReadableType.Boolean.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L19:
            r100[XReadableType.Int.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L27:
            r100[XReadableType.Number.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L21:
            r100[XReadableType.String.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L23:
            r100[XReadableType.Array.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L17:
            r100[XReadableType.Map.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L9:
            f468962a = r100;
        }
    }

    static {
        f468960b = new Gson();
    }

    @Override // p56.d
    public final Set<String> c() {
        return this.f468961a.getAll().keySet();
    }

    public a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f468961a = r100.getSharedPreferences("rifle-lite-storage", 0);
    }

    @Override // p56.d
    public final boolean a(String r100) {
        if (r100 == null) goto L5;
        this.f468961a.edit().remove(r100).apply();
        return true;
    L5:
        return false;
    }

    @Override // p56.d
    public final Object d(String r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if (this.f468961a.contains(r100) == true) goto L8;
        return null;
    L8:
        String r101 = this.f468961a.getString(r100, "");
        if (TextUtils.isEmpty(r101) == false) goto L11;
        return null;
    L11:
        Intrinsics.checkNotNull(r101);
        Gson r102 = f468960b;
        b r103 = (b) GsonProtectorUtils.fromJson(r102, r101, b.class);
        String r104 = r103.a();
        if (r104 == null) goto L32;
        String r105 = r103.getType();
        if (r105 == null) goto L33;
        XReadableType r106 = XReadableType.valueOf(r105);
        switch(c.f468962a[r106.ordinal()]) {
            case 1: goto L26;
            case 2: goto L31;
            case 3: goto L30;
            case 4: goto L29;
            case 5: goto L28;
            case 6: goto L27;
            default: goto L34;
        };
    L34:
        return null;
    L27:
        return GsonProtectorUtils.fromJson(r102, r104, Map.class);
    L28:
        return GsonProtectorUtils.fromJson(r102, r104, List.class);
    L29:
        return r104;
    L30:
        return Double.valueOf(CastDoubleProtector.parseDouble(r104));
    L31:
        return Integer.valueOf(CastIntegerProtector.parseInt(r104));
    L26:
        return Boolean.valueOf(Boolean.parseBoolean(r104));
    L33:
        return null;
    L32:
        return null;
    }

    public final String h(Object r100) {
        new LinkedHashMap();
        if ((r100 instanceof Boolean) == false) goto L6;
        b r101 = new b("Boolean", String.valueOf(((Boolean) r100).booleanValue()));
        return GsonProtectorUtils.toJson(f468960b, r101);
    L6:
        if ((r100 instanceof Integer) == false) goto L9;
        b r102 = new b("Int", String.valueOf(((Number) r100).intValue()));
        return GsonProtectorUtils.toJson(f468960b, r102);
    L9:
        if ((r100 instanceof Double) == false) goto L12;
        b r103 = new b("Number", String.valueOf(((Number) r100).doubleValue()));
        return GsonProtectorUtils.toJson(f468960b, r103);
    L12:
        if ((r100 instanceof String) == false) goto L15;
        b r104 = new b("String", ((String) r100).toString());
        return GsonProtectorUtils.toJson(f468960b, r104);
    L15:
        if ((r100 instanceof v) == false) goto L18;
        return h(((v) r100).toList());
    L18:
        if ((r100 instanceof XReadableMap) == false) goto L21;
        return h(((XReadableMap) r100).toMap());
    L21:
        if ((r100 instanceof List) == false) goto L24;
        Gson r105 = f468960b;
        return GsonProtectorUtils.toJson(r105, new b("Array", GsonProtectorUtils.toJson(r105, r100)));
    L24:
        if ((r100 instanceof Map) == false) goto L26;
        Gson r106 = f468960b;
        return GsonProtectorUtils.toJson(r106, new b("Map", GsonProtectorUtils.toJson(r106, r100)));
    L26:
        return "";
    }

    @Override // p56.d
    public final boolean e(String r100, Object r101) {
        if (r100 == null) goto L6;
        if (r101 == null) goto L8;
        this.f468961a.edit().putString(r100, h(r101)).apply();
        return true;
    L8:
        return false;
    L6:
        return false;
    }
}
