package com.bytedance.android.shopping.store.mall.follows.apidata;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.android.ec.core.utils.t0;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.google.gson.Gson;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b {
    public final SharedPreferences a;

    public static final class a {
    }

    static {
    }

    public b(Context r3) {
        if (r3 == null) goto L5;
        SharedPreferences r4 = r3.getSharedPreferences("xbridge-storage", 0);
    L6:
        this.a = r4;
        return;
    L5:
        r4 = null;
        goto L6
    }

    public final Object a(String r9) {
        SharedPreferences r0 = this.a;
        if (r0 != null) goto L6;
        return null;
    L6:
        if (r0.contains(r9) == true) goto L8;
        return null;
    L8:
        String r1 = r0.getString(r9, "");
        if (r1 != null) goto L11;
    L14:
        boolean r2 = true;
    L15:
        if (r2 == false) goto L57;
        return null;
    L57:
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L51
        int r4 = t0.a;     // Catch: Throwable -> L51
        Gson r5 = t0.a.a;     // Catch: Throwable -> L51
        StorageValue r6 = (StorageValue) r5.fromJson(r1, StorageValue.class);     // Catch: Throwable -> L51
        Long r7 = r6.getExpiredTime();     // Catch: Throwable -> L51
        long r8 = System.currentTimeMillis();     // Catch: Throwable -> L51
        if (r7 != null) goto L20;
    L35:
        String r10 = r6.getValue();     // Catch: Throwable -> L51
        if (r10 == null) goto L63;
        String r11 = r6.getType();     // Catch: Throwable -> L51
        if (r11 == null) goto L64;
        Object r12 = r10;
        switch(c.a[XReadableType.valueOf(r11).ordinal()]) {
            case 1: goto L71;
            case 2: goto L70;
            case 3: goto L69;
            case 4: goto L68;
            case 5: goto L56;
            case 6: goto L67;
            case 7: goto L66;
            default: goto L65;
        };     // Catch: Throwable -> L51
    L65:
        return null;
    L66:
        return r5.fromJson(r10, Map.class);
    L67:
        return r5.fromJson(r10, List.class);
    L68:
        return Double.valueOf(CastDoubleProtector.parseDouble(r10));
    L69:
        return Long.valueOf(CastLongProtector.parseLong(r10));
    L70:
        return Integer.valueOf(CastIntegerProtector.parseInt(r10));
    L71:
        return Boolean.valueOf(Boolean.parseBoolean(r10));
    L56:
        return r12;
    L64:
        return null;
    L63:
        return null;
    L20:
        if (r8 <= r7.longValue()) goto L35;
        SharedPreferences r13 = this.a;     // Catch: Throwable -> L51
        if (r13 != null) goto L25;
        return null;
    L25:
        if (r13.contains(r9) == false) goto L59;
        SharedPreferences r14 = this.a;     // Catch: Throwable -> L51
        if (r14 == null) goto L30;
        SharedPreferences.Editor r15 = r14.edit();     // Catch: Throwable -> L51
    L31:
        if (r15 == null) goto L60;
        SharedPreferences.Editor r16 = r15.remove(r9);     // Catch: Throwable -> L51
        if (r16 == null) goto L61;
        r16.apply();     // Catch: Throwable -> L51
        return null;
    L61:
        return null;
    L60:
        return null;
    L30:
        r15 = null;
        goto L31
    L59:
        return null;
    L51:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        Object r18 = Result.constructor-impl(ResultKt.createFailure(th));
        boolean r19 = Result.isFailure-impl(r18);
        r12 = r18;
        if (r19 == false) goto L56;
        return null;
    L11:
        if (StringsKt.isBlank(r1) == true) goto L14;
        r2 = false;
        goto L15
    }
}
