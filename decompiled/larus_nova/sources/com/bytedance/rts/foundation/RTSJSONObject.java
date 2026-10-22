package com.bytedance.rts.foundation;

import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 12\u00020\u0001:\u0001(B\u0011\u0012\b\u0010.\u001a\u0004\u0018\u00010'¢\u0006\u0004\b/\u0010-B\t\b\u0016¢\u0006\u0004\b/\u00100J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\u000f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\tJ#\u0010\u0012\u001a\u0004\u0018\u00010\u00102\u0006\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0012\u0010\u0013J#\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0015\u0010\u0016J#\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u0018\u0010\u0019J\u001c\u0010\u001a\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\tJ#\u0010\u001b\u001a\u0004\u0018\u00010\r2\u0006\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u001b\u0010\u001cJ\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u00002\u0006\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0000J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\u001f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010 \u001a\u00020\r2\u0006\u0010\n\u001a\u00020\tJ#\u0010!\u001a\u0004\u0018\u00010\u00102\u0006\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b!\u0010\u0013J#\u0010\"\u001a\u0004\u0018\u00010\u00142\u0006\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\"\u0010\u0016J#\u0010#\u001a\u0004\u0018\u00010\u00172\u0006\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b#\u0010\u0019J\u001c\u0010$\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\tJ#\u0010%\u001a\u0004\u0018\u00010\r2\u0006\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b%\u0010\u001cJ\u001c\u0010&\u001a\u0004\u0018\u00010\u00002\u0006\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0000R\"\u0010.\u001a\u00020'8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-¨\u00062"}, d2 = {"Lcom/bytedance/rts/foundation/RTSJSONObject;", "Ljava/io/Serializable;", "Ljava/io/ObjectOutputStream;", Argument.OUT, "", "writeObject", "Ljava/io/ObjectInputStream;", "in", "readObject", "", "key", "", "rts_get", "", "rts_has", "rts_isNull", "", "fallback", "rts_getInt", "(Ljava/lang/String;Ljava/lang/Integer;)Ljava/lang/Integer;", "", "rts_getLong", "(Ljava/lang/String;Ljava/lang/Long;)Ljava/lang/Long;", "", "rts_getDouble", "(Ljava/lang/String;Ljava/lang/Double;)Ljava/lang/Double;", "rts_getString", "rts_getBoolean", "(Ljava/lang/String;Ljava/lang/Boolean;)Ljava/lang/Boolean;", "rts_getObject", MonitorConstants.CONNECT_TYPE_GET, "has", "isNull", "getInt", "getLong", "getDouble", "getString", "getBoolean", "getObject", "Lorg/json/JSONObject;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lorg/json/JSONObject;", "getRawMap$lib_release", "()Lorg/json/JSONObject;", "setRawMap$lib_release", "(Lorg/json/JSONObject;)V", "rawMap", "<init>", "()V", "Companion", "lib_release"}, k = 1, mv = {1, 7, 1})
public final class RTSJSONObject implements Serializable {
    public static final a Companion = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient JSONObject f267565a;

    public static final class a {
        public a() {
        }

        public static Object a(JSONObject r100, String r101) {
            if (r100.has(r101) == true) goto L5;
            return null;
        L5:
            return r100.opt(r101);
        }

        public static Integer b(a r100, JSONObject r101, String r102) {
            r100.getClass();
            Intrinsics.checkNotNullParameter(r101, "map");
            Intrinsics.checkNotNullParameter(r102, "key");
            return c(r101, r102, null);
        }

        public static Integer c(JSONObject r100, String r101, Integer r102) {
            Object r103 = a(r100, r101);
            if ((r103 instanceof Integer) == false) goto L7;
            return (Integer) r103;
        L7:
            if ((r103 instanceof Number) == false) goto L11;
            return Integer.valueOf(((Number) r103).intValue());
        L11:
            if ((r103 instanceof String) == true) goto L13;
            return r102;
        L13:
            return Integer.valueOf(CastIntegerProtector.parseInt((String) r103));
        }

        public static Long d(JSONObject r100, String r101, Long r102) {
            Object r103 = a(r100, r101);
            if ((r103 instanceof Long) == false) goto L7;
            return (Long) r103;
        L7:
            if ((r103 instanceof Number) == false) goto L11;
            return Long.valueOf(((Number) r103).longValue());
        L11:
            if ((r103 instanceof String) == true) goto L13;
            return r102;
        L13:
            return Long.valueOf(r100.optLong(r101));
        }

        public static String e(a r100, JSONObject r101, String r102) {
            r100.getClass();
            Intrinsics.checkNotNullParameter(r101, "map");
            Intrinsics.checkNotNullParameter(r102, "key");
            Object r103 = a(r101, r102);
            if ((r103 instanceof String) == false) goto L5;
            String r104 = (String) r103;
        L6:
            if (r104 != null) goto L9;
            return null;
        L9:
            return r104;
        L5:
            r104 = null;
            goto L6
        }
    }

    static {
        Companion = new a();
    }

    public RTSJSONObject() {
        this(null);
    }

    public final JSONObject getRawMap$lib_release() {
        return this.f267565a;
    }

    public RTSJSONObject(JSONObject r100) {
        if (r100 != null) goto L5;
        r100 = new JSONObject();
    L5:
        this.f267565a = r100;
    }

    private final void readObject(ObjectInputStream r100) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L4
        r100.defaultReadObject();     // Catch: Throwable -> L4
        Object r102 = r100.readObject();     // Catch: Throwable -> L4
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type kotlin.String");     // Catch: Throwable -> L4
        this.f267565a = new JSONObject((String) r102);     // Catch: Throwable -> L4
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    private final void writeObject(ObjectOutputStream r100) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L4
        r100.defaultWriteObject();     // Catch: Throwable -> L4
        r100.writeObject(this.f267565a.toString());     // Catch: Throwable -> L4
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        Result.Companion r102 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    public final Object get(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return rts_get(r100);
    }

    public final boolean has(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return rts_has(r100);
    }

    public final boolean isNull(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return rts_isNull(r100);
    }

    public final Object rts_get(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        a r101 = Companion;
        JSONObject r102 = this.f267565a;
        r101.getClass();
        return a.a(r102, r100);
    }

    public final boolean rts_has(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return this.f267565a.has(r100);
    }

    public final boolean rts_isNull(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return this.f267565a.isNull(r100);
    }

    public final void setRawMap$lib_release(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f267565a = r100;
    }

    public final Boolean getBoolean(String r100, Boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return rts_getBoolean(r100, r101);
    }

    public final Double getDouble(String r100, Double r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return rts_getDouble(r100, r101);
    }

    public final Integer getInt(String r100, Integer r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return rts_getInt(r100, r101);
    }

    public final Long getLong(String r100, Long r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return rts_getLong(r100, r101);
    }

    public final RTSJSONObject getObject(String r100, RTSJSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return rts_getObject(r100, r101);
    }

    public final String getString(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return rts_getString(r100, r101);
    }

    public final Boolean rts_getBoolean(String r100, Boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        a r102 = Companion;
        JSONObject r103 = this.f267565a;
        r102.getClass();
        Object r104 = a.a(r103, r100);
        if ((r104 instanceof Boolean) == false) goto L5;
        Boolean r105 = (Boolean) r104;
    L6:
        if (r105 != null) goto L9;
        return r101;
    L9:
        return r105;
    L5:
        r105 = null;
        goto L6
    }

    public final Double rts_getDouble(String r100, Double r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        a r102 = Companion;
        JSONObject r103 = this.f267565a;
        r102.getClass();
        Object r104 = a.a(r103, r100);
        if ((r104 instanceof Double) == false) goto L6;
        return (Double) r104;
    L6:
        if ((r104 instanceof Number) == false) goto L9;
        return Double.valueOf(((Number) r104).doubleValue());
    L9:
        if ((r104 instanceof String) == true) goto L11;
        return r101;
    L11:
        return Double.valueOf(CastDoubleProtector.parseDouble((String) r104));
    }

    public final Integer rts_getInt(String r100, Integer r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        a r102 = Companion;
        JSONObject r103 = this.f267565a;
        r102.getClass();
        return a.c(r103, r100, r101);
    }

    public final Long rts_getLong(String r100, Long r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        a r102 = Companion;
        JSONObject r103 = this.f267565a;
        r102.getClass();
        return a.d(r103, r100, r101);
    }

    public final RTSJSONObject rts_getObject(String r100, RTSJSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        a r102 = Companion;
        JSONObject r103 = this.f267565a;
        r102.getClass();
        Object r104 = a.a(r103, r100);
        if ((r104 instanceof JSONObject) == false) goto L5;
        JSONObject r105 = (JSONObject) r104;
    L6:
        if (r105 != null) goto L8;
        return r101;
    L8:
        return new RTSJSONObject(r105);
    L5:
        r105 = null;
        goto L6
    }

    public final String rts_getString(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        a r102 = Companion;
        JSONObject r103 = this.f267565a;
        r102.getClass();
        Object r104 = a.a(r103, r100);
        if ((r104 instanceof String) == false) goto L5;
        String r105 = (String) r104;
    L6:
        if (r105 != null) goto L9;
        return r101;
    L9:
        return r105;
    L5:
        r105 = null;
        goto L6
    }

    public static /* synthetic */ Boolean getBoolean$default(RTSJSONObject r100, String r101, Boolean r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = null;
    L6:
        return r100.getBoolean(r101, r102);
    }

    public static /* synthetic */ Double getDouble$default(RTSJSONObject r100, String r101, Double r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = null;
    L6:
        return r100.getDouble(r101, r102);
    }

    public static /* synthetic */ Integer getInt$default(RTSJSONObject r100, String r101, Integer r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = null;
    L6:
        return r100.getInt(r101, r102);
    }

    public static /* synthetic */ Long getLong$default(RTSJSONObject r100, String r101, Long r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = null;
    L6:
        return r100.getLong(r101, r102);
    }

    public static /* synthetic */ RTSJSONObject getObject$default(RTSJSONObject r100, String r101, RTSJSONObject r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = null;
    L6:
        return r100.getObject(r101, r102);
    }

    public static /* synthetic */ String getString$default(RTSJSONObject r100, String r101, String r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = null;
    L6:
        return r100.getString(r101, r102);
    }

    public static /* synthetic */ Boolean rts_getBoolean$default(RTSJSONObject r100, String r101, Boolean r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = null;
    L6:
        return r100.rts_getBoolean(r101, r102);
    }

    public static /* synthetic */ Double rts_getDouble$default(RTSJSONObject r100, String r101, Double r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = null;
    L6:
        return r100.rts_getDouble(r101, r102);
    }

    public static /* synthetic */ Integer rts_getInt$default(RTSJSONObject r100, String r101, Integer r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = null;
    L6:
        return r100.rts_getInt(r101, r102);
    }

    public static /* synthetic */ Long rts_getLong$default(RTSJSONObject r100, String r101, Long r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = null;
    L6:
        return r100.rts_getLong(r101, r102);
    }

    public static /* synthetic */ RTSJSONObject rts_getObject$default(RTSJSONObject r100, String r101, RTSJSONObject r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = null;
    L6:
        return r100.rts_getObject(r101, r102);
    }

    public static /* synthetic */ String rts_getString$default(RTSJSONObject r100, String r101, String r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = null;
    L6:
        return r100.rts_getString(r101, r102);
    }
}
