package com.bytedance.ee.bear.document.forecast;

import android.text.TextUtils;
import ay4.b;
import com.bytedance.ee.bear.contract.AccountService$Account;
import com.bytedance.ee.bear.contract.c;
import com.bytedance.ee.bear.contract.h0;
import com.google.gson.GsonBuilder;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.jvm.internal.Intrinsics;
import sbb.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a {
    public static OperationRecord a;
    public static final o15.a b = null;
    public static ForecastConfig c;
    public static String d;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.document.forecast.a$a, reason: collision with other inner class name */
    public static final class C0076a extends c {
        public C0076a() {
        }

        @Override // com.bytedance.ee.bear.contract.c
        public final void b(AccountService$Account r4) {
            String r0 = a.d;
            String r1 = null;
            if (r4 == null) goto L5;
            String r2 = r4.uid;
        L7:
            if (TextUtils.equals(r0, r2) == true) goto L13;
            tt5.a.h("DocumentForecast", "onAccountChanged");
            if (r4 == null) goto L11;
            r1 = r4.uid;
        L11:
            a.d = r1;
            a.c();
            return;
        L13:
            return;
        L5:
            r2 = null;
            goto L7
        }
    }

    static {
        b = new o15.a();
        if (p15.a.a() == false) goto L9;
        c();
        String r1 = null;
        h0 r0 = (h0) org.koin.java.a.c(h0.class, null, null, 6);
        AccountService$Account r2 = r0.G2();
        if (r2 == null) goto L7;
        r1 = r2.uid;
    L7:
        d = r1;
        r0.Pe(new C0076a());
        return;
    }

    public static void c() {
        ForecastConfig r0 = (ForecastConfig) com.bytedance.ee.bear.appsetting.c.a.a.c("docs_forecast_config", ForecastConfig.class, new ForecastConfig());
        c = r0;
        o15.a r1 = b;
        if (r0 == null) goto L5;
        int r2 = r0.getMaxRecordLength();
    L6:
        r1.getClass();
        Object r3 = new GsonBuilder().create().fromJson(b.d("document", 6).getString("operation_record", "{}"), OperationRecord.class);     // Catch: Exception -> L9
        Intrinsics.checkNotNull(r3);     // Catch: Exception -> L9
        OperationRecord r4 = (OperationRecord) r3;     // Catch: Exception -> L9
    L11:
        r4.init(r2);
        o15.a.a(r4);
        a = r4;
        tt5.a.h("DocumentForecast", "loadUserOperationRecord, forecastConfig = " + c + ", operationRecord = " + a);
        return;
    L9:
        e = move-exception;
        tt5.a.e("RecordPersistence", "deserialize failed", e, false);
        r4 = new OperationRecord();
        goto L11
    L5:
        r2 = 0;
        goto L6
    }

    public static boolean e() {
        if (p15.a.a() == true) goto L5;
        return true;
    L5:
        ForecastConfig r0 = c;
        if (r0 == null) goto L8;
        int r1 = r0.getDisableWebViewPreload();
    L9:
        if (r1 > 0) goto L11;
        return true;
    L11:
        OperationRecord r3 = a;
        if (r3 == null) goto L22;
        Collection<OperationRecord.Record> r4 = r3.getAllRecords();
        if (r4 == null) goto L22;
        Iterator<T> r5 = r4.iterator();
    L17:
        if (r5.hasNext() == false) goto L21;
        if (a(((OperationRecord.Record) r5.next()).getRecentOpenCount(), r1) == false) goto L17;
        return true;
    L21:
        return false;
    L22:
        return true;
    L8:
        r1 = 0;
        goto L9
    }

    public static List b(List r5) {
        Intrinsics.checkNotNullParameter(r5, "input");
        if (p15.a.a() == true) goto L5;
        return r5;
    L5:
        ArrayList r1 = new ArrayList();
        Iterator r0 = r5.iterator();
    L7:
        if (r0.hasNext() == false) goto L24;
        Object r2 = r0.next();
        int r3 = e.e((String) r2).b;
        if (p15.a.a() == false) goto L21;
        OperationRecord r4 = a;
        if (r4 == null) goto L21;
        OperationRecord.Record r6 = r4.findRecordByType(r3);
        if (r6 == null) goto L21;
        ForecastConfig r7 = c;
        if (r7 == null) goto L18;
        int r8 = r7.getDisableTemplatePreload();
    L19:
        if (r8 <= 0) goto L21;
        boolean r9 = a(r6.getRecentOpenCount(), r8);
    L22:
        if (r9 == false) goto L7;
        r1.add(r2);
        goto L7
    L18:
        r8 = 0;
    L21:
        r9 = true;
        goto L22
    L24:
        boolean r10 = r1.isEmpty();
        List r11 = r1;
        if (r10 == false) goto L27;
        r11 = CollectionsKt.emptyList();
    L27:
        tt5.a.h("DocumentForecast", "getPreloadJsSequencingConfig, origin = " + r5 + ", result = " + r11);
        return r11;
    }

    public static void d(int r1) {
        OperationRecord r0 = a;
        if (r0 == null) goto L6;
        r0.recordOpenDoc(r1);
        b.getClass();
        o15.a.a(r0);
        return;
    }

    public static boolean a(ArrayDeque r2, int r3) {
        Iterator r4 = CollectionsKt.withIndex(r2.descendingIterator());
    L4:
        if (r4.hasNext() == false) goto L11;
        IndexedValue r0 = (IndexedValue) r4.next();
        if (((Number) r0.getValue()).intValue() > 0) goto L11;
        if (r0.getIndex() < r3) goto L4;
        return false;
    L11:
        return true;
    }
}
