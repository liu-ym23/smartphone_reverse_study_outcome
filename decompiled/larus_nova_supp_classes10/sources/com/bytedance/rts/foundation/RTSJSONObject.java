package com.bytedance.rts.foundation;

import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 12\u00020\u0001:\u0001(B\u0011\u0012\b\u0010.\u001a\u0004\u0018\u00010'¢\u0006\u0004\b/\u0010-B\t\b\u0016¢\u0006\u0004\b/\u00100J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\u000f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\tJ#\u0010\u0012\u001a\u0004\u0018\u00010\u00102\u0006\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0012\u0010\u0013J#\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0015\u0010\u0016J#\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u0018\u0010\u0019J\u001c\u0010\u001a\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\tJ#\u0010\u001b\u001a\u0004\u0018\u00010\r2\u0006\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u001b\u0010\u001cJ\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u00002\u0006\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0000J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\u001f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010 \u001a\u00020\r2\u0006\u0010\n\u001a\u00020\tJ#\u0010!\u001a\u0004\u0018\u00010\u00102\u0006\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b!\u0010\u0013J#\u0010\"\u001a\u0004\u0018\u00010\u00142\u0006\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\"\u0010\u0016J#\u0010#\u001a\u0004\u0018\u00010\u00172\u0006\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b#\u0010\u0019J\u001c\u0010$\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\tJ#\u0010%\u001a\u0004\u0018\u00010\r2\u0006\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b%\u0010\u001cJ\u001c\u0010&\u001a\u0004\u0018\u00010\u00002\u0006\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0000R\"\u0010.\u001a\u00020'8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-¨\u00062"}, d2 = {"Lcom/bytedance/rts/foundation/RTSJSONObject;", "Ljava/io/Serializable;", "Ljava/io/ObjectOutputStream;", "out", "", "writeObject", "Ljava/io/ObjectInputStream;", "in", "readObject", "", "key", "", "rts_get", "", "rts_has", "rts_isNull", "", "fallback", "rts_getInt", "(Ljava/lang/String;Ljava/lang/Integer;)Ljava/lang/Integer;", "", "rts_getLong", "(Ljava/lang/String;Ljava/lang/Long;)Ljava/lang/Long;", "", "rts_getDouble", "(Ljava/lang/String;Ljava/lang/Double;)Ljava/lang/Double;", "rts_getString", "rts_getBoolean", "(Ljava/lang/String;Ljava/lang/Boolean;)Ljava/lang/Boolean;", "rts_getObject", "get", "has", "isNull", "getInt", "getLong", "getDouble", "getString", "getBoolean", "getObject", "Lorg/json/JSONObject;", "a", "Lorg/json/JSONObject;", "getRawMap$lib_release", "()Lorg/json/JSONObject;", "setRawMap$lib_release", "(Lorg/json/JSONObject;)V", "rawMap", "<init>", "()V", "Companion", "lib_release"}, k = 1, mv = {1, 7, 1})
public final class RTSJSONObject implements Serializable {
    public static final a Companion = null;
    public transient JSONObject a;

    public static final class a {
        public a() {
        }

        public static Object a(JSONObject r1, String r2) {
            if (r1.has(r2) == true) goto L5;
            return null;
        L5:
            return r1.opt(r2);
        }

        public static Integer b(a r0, JSONObject r1, String r2) {
            r0.getClass();
            Intrinsics.checkNotNullParameter(r1, "map");
            Intrinsics.checkNotNullParameter(r2, "key");
            return c(r1, r2, null);
        }

        public static Integer c(JSONObject r0, String r1, Integer r2) {
            Object r3 = a(r0, r1);
            if ((r3 instanceof Integer) == false) goto L7;
            return (Integer) r3;
        L7:
            if ((r3 instanceof Number) == false) goto L11;
            return Integer.valueOf(((Number) r3).intValue());
        L11:
            if ((r3 instanceof String) == true) goto L13;
            return r2;
        L13:
            return Integer.valueOf(CastIntegerProtector.parseInt((String) r3));
        }

        public static Long d(JSONObject r2, String r3, Long r4) {
            Object r0 = a(r2, r3);
            if ((r0 instanceof Long) == false) goto L7;
            return (Long) r0;
        L7:
            if ((r0 instanceof Number) == false) goto L11;
            return Long.valueOf(((Number) r0).longValue());
        L11:
            if ((r0 instanceof String) == true) goto L13;
            return r4;
        L13:
            return Long.valueOf(r2.optLong(r3));
        }

        public static String e(a r0, JSONObject r1, String r2) {
            r0.getClass();
            Intrinsics.checkNotNullParameter(r1, "map");
            Intrinsics.checkNotNullParameter(r2, "key");
            Object r3 = a(r1, r2);
            if ((r3 instanceof String) == false) goto L5;
            String r4 = (String) r3;
        L6:
            if (r4 != null) goto L9;
            return null;
        L9:
            return r4;
        L5:
            r4 = null;
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
        return this.a;
    }

    public RTSJSONObject(JSONObject r1) {
        if (r1 != null) goto L5;
        r1 = new JSONObject();
    L5:
        this.a = r1;
    }

    private final void readObject(ObjectInputStream r3) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        r3.defaultReadObject();     // Catch: Throwable -> L4
        Object r4 = r3.readObject();     // Catch: Throwable -> L4
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type kotlin.String");     // Catch: Throwable -> L4
        this.a = new JSONObject((String) r4);     // Catch: Throwable -> L4
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    private final void writeObject(ObjectOutputStream r2) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        r2.defaultWriteObject();     // Catch: Throwable -> L4
        r2.writeObject(this.a.toString());     // Catch: Throwable -> L4
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    public final Object get(String r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        return rts_get(r2);
    }

    public final boolean has(String r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        return rts_has(r2);
    }

    public final boolean isNull(String r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        return rts_isNull(r2);
    }

    public final Object rts_get(String r3) {
        Intrinsics.checkNotNullParameter(r3, "key");
        a r0 = Companion;
        JSONObject r1 = this.a;
        r0.getClass();
        return a.a(r1, r3);
    }

    public final boolean rts_has(String r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        return this.a.has(r2);
    }

    public final boolean rts_isNull(String r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        return this.a.isNull(r2);
    }

    public final void setRawMap$lib_release(JSONObject r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.a = r2;
    }

    public final Boolean getBoolean(String r2, Boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        return rts_getBoolean(r2, r3);
    }

    public final Double getDouble(String r2, Double r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        return rts_getDouble(r2, r3);
    }

    public final Integer getInt(String r2, Integer r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        return rts_getInt(r2, r3);
    }

    public final Long getLong(String r2, Long r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        return rts_getLong(r2, r3);
    }

    public final RTSJSONObject getObject(String r2, RTSJSONObject r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        return rts_getObject(r2, r3);
    }

    public final String getString(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        return rts_getString(r2, r3);
    }

    public final Boolean rts_getBoolean(String r3, Boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "key");
        a r0 = Companion;
        JSONObject r1 = this.a;
        r0.getClass();
        Object r5 = a.a(r1, r3);
        if ((r5 instanceof Boolean) == false) goto L5;
        Boolean r6 = (Boolean) r5;
    L6:
        if (r6 != null) goto L9;
        return r4;
    L9:
        return r6;
    L5:
        r6 = null;
        goto L6
    }

    public final Double rts_getDouble(String r3, Double r4) {
        Intrinsics.checkNotNullParameter(r3, "key");
        a r0 = Companion;
        JSONObject r1 = this.a;
        r0.getClass();
        Object r5 = a.a(r1, r3);
        if ((r5 instanceof Double) == false) goto L6;
        return (Double) r5;
    L6:
        if ((r5 instanceof Number) == false) goto L9;
        return Double.valueOf(((Number) r5).doubleValue());
    L9:
        if ((r5 instanceof String) == true) goto L11;
        return r4;
    L11:
        return Double.valueOf(CastDoubleProtector.parseDouble((String) r5));
    }

    public final Integer rts_getInt(String r3, Integer r4) {
        Intrinsics.checkNotNullParameter(r3, "key");
        a r0 = Companion;
        JSONObject r1 = this.a;
        r0.getClass();
        return a.c(r1, r3, r4);
    }

    public final Long rts_getLong(String r3, Long r4) {
        Intrinsics.checkNotNullParameter(r3, "key");
        a r0 = Companion;
        JSONObject r1 = this.a;
        r0.getClass();
        return a.d(r1, r3, r4);
    }

    public final RTSJSONObject rts_getObject(String r3, RTSJSONObject r4) {
        Intrinsics.checkNotNullParameter(r3, "key");
        a r0 = Companion;
        JSONObject r1 = this.a;
        r0.getClass();
        Object r5 = a.a(r1, r3);
        if ((r5 instanceof JSONObject) == false) goto L5;
        JSONObject r6 = (JSONObject) r5;
    L6:
        if (r6 != null) goto L8;
        return r4;
    L8:
        return new RTSJSONObject(r6);
    L5:
        r6 = null;
        goto L6
    }

    public final String rts_getString(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "key");
        a r0 = Companion;
        JSONObject r1 = this.a;
        r0.getClass();
        Object r5 = a.a(r1, r3);
        if ((r5 instanceof String) == false) goto L5;
        String r6 = (String) r5;
    L6:
        if (r6 != null) goto L9;
        return r4;
    L9:
        return r6;
    L5:
        r6 = null;
        goto L6
    }

    public static /* synthetic */ Boolean getBoolean$default(RTSJSONObject r0, String r1, Boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = null;
    L6:
        return r0.getBoolean(r1, r2);
    }

    public static /* synthetic */ Double getDouble$default(RTSJSONObject r0, String r1, Double r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = null;
    L6:
        return r0.getDouble(r1, r2);
    }

    public static /* synthetic */ Integer getInt$default(RTSJSONObject r0, String r1, Integer r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = null;
    L6:
        return r0.getInt(r1, r2);
    }

    public static /* synthetic */ Long getLong$default(RTSJSONObject r0, String r1, Long r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = null;
    L6:
        return r0.getLong(r1, r2);
    }

    public static /* synthetic */ RTSJSONObject getObject$default(RTSJSONObject r0, String r1, RTSJSONObject r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = null;
    L6:
        return r0.getObject(r1, r2);
    }

    public static /* synthetic */ String getString$default(RTSJSONObject r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = null;
    L6:
        return r0.getString(r1, r2);
    }

    public static /* synthetic */ Boolean rts_getBoolean$default(RTSJSONObject r0, String r1, Boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = null;
    L6:
        return r0.rts_getBoolean(r1, r2);
    }

    public static /* synthetic */ Double rts_getDouble$default(RTSJSONObject r0, String r1, Double r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = null;
    L6:
        return r0.rts_getDouble(r1, r2);
    }

    public static /* synthetic */ Integer rts_getInt$default(RTSJSONObject r0, String r1, Integer r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = null;
    L6:
        return r0.rts_getInt(r1, r2);
    }

    public static /* synthetic */ Long rts_getLong$default(RTSJSONObject r0, String r1, Long r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = null;
    L6:
        return r0.rts_getLong(r1, r2);
    }

    public static /* synthetic */ RTSJSONObject rts_getObject$default(RTSJSONObject r0, String r1, RTSJSONObject r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = null;
    L6:
        return r0.rts_getObject(r1, r2);
    }

    public static /* synthetic */ String rts_getString$default(RTSJSONObject r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = null;
    L6:
        return r0.rts_getString(r1, r2);
    }
}
