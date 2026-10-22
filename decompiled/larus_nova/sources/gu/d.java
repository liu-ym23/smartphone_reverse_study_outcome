package gu;

import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import java.io.Serializable;
import java.lang.reflect.Type;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Keva f482735a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f482736b;

    public d() {
        Intrinsics.checkNotNullParameter("ttlive_sdk_keva_cache", "fileName");
        this.f482736b = "ttlive_sdk_keva_cache";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T> T a(String r100, T r101, Type r102) {
        String r103 = this.f482736b;
        if (this.f482735a != null) goto L5;
        this.f482735a = Keva.getRepo(r103);
    L5:
        String r104 = (T) null;
        if ((r101 instanceof Boolean) == false) goto L11;
        boolean r105 = ((Boolean) r101).booleanValue();
        Keva r106 = this.f482735a;
        Object r107 = r104;
        if (r106 == null) goto L44;
        r107 = (T) Boolean.valueOf(r106.getBoolean(r100, r105));
    L44:
        Object r108 = r107;
        return (T) r107;
    L11:
        if ((r101 instanceof Integer) == false) goto L16;
        int r109 = ((Number) r101).intValue();
        Keva r110 = this.f482735a;
        r107 = r104;
        if (r110 == null) goto L44;
        r107 = (T) Integer.valueOf(r110.getInt(r100, r109));
        goto L44
    L16:
        if ((r101 instanceof String) == false) goto L21;
        String r111 = (String) r101;
        Keva r112 = this.f482735a;
        r107 = r104;
        if (r112 == null) goto L44;
        r107 = (T) r112.getString(r100, r111);
        goto L44
    L21:
        if ((r101 instanceof Long) == false) goto L26;
        long r113 = ((Number) r101).longValue();
        Keva r114 = this.f482735a;
        r107 = r104;
        if (r114 == null) goto L44;
        r107 = (T) Long.valueOf(r114.getLong(r100, r113));
        goto L44
    L26:
        if ((r101 instanceof Float) == false) goto L31;
        float r115 = ((Number) r101).floatValue();
        Keva r116 = this.f482735a;
        r107 = r104;
        if (r116 == null) goto L44;
        r107 = (T) Float.valueOf(r116.getFloat(r100, r115));
        goto L44
    L31:
        if ((r101 instanceof Double) == false) goto L36;
        double r117 = ((Number) r101).doubleValue();
        Keva r118 = this.f482735a;
        r107 = r104;
        if (r118 == null) goto L44;
        r107 = (T) Double.valueOf(r118.getDouble(r100, r117));
        goto L44
    L36:
        if ((r101 instanceof byte[]) == false) goto L40;
        byte[] r119 = (byte[]) r101;
        Keva r120 = this.f482735a;
        r107 = r104;
        if (r120 == null) goto L44;
        r107 = (T) r120.getBytes(r100, r119);
        goto L44
    L40:
        Gson r121 = new Gson();
        String r122 = GsonProtectorUtils.toJson(new Gson(), r101);
        Keva r123 = this.f482735a;
        String r124 = r104;
        if (r123 == null) goto L43;
        r124 = (T) r123.getString(r100, r122);
    L43:
        r107 = (T) ((Serializable) GsonProtectorUtils.fromJson(r121, r124, r102));
        goto L44
    }
}
