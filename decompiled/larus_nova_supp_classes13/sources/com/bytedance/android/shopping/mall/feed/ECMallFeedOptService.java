package com.bytedance.android.shopping.mall.feed;

import android.net.Uri;
import com.bytedance.android.ec.hybrid.data.entity.MallLynxSchemaConfig;
import com.bytedance.android.shopping.api.mall.common.tools.MallSchemaSetting;
import com.bytedance.android.shopping.searchsimilar.model.SimilarProductParam;
import com.bytedance.mt.protector.impl.UriProtector;
import com.google.gson.internal.LinkedTreeMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class ECMallFeedOptService {
    public final ConcurrentHashMap<String, com.bytedance.android.shopping.api.mall.idl.b> a;
    public final Lazy b;
    public final Map<String, String> c;
    public final Lazy d;

    public static final class a {
    }

    static {
    }

    public ECMallFeedOptService() {
        this.a = new ConcurrentHashMap();
        LazyThreadSafetyMode r0 = LazyThreadSafetyMode.NONE;
        this.b = LazyKt.lazy(r0, ECMallFeedOptService$mallCardConfig$2.INSTANCE);
        this.c = new LinkedHashMap();
        this.d = LazyKt.lazy(r0, ECMallFeedOptService$mallSaasPreloadCardConfig$2.INSTANCE);
    }

    public final HashMap<String, Object> a() {
        yj.g r0 = com.bytedance.android.ec.hybrid.a.b();
        if (r0 == null) goto L5;
        com.bytedance.android.ec.hybrid.data.i r1 = r0.k();
    L6:
        HashMap<String, Object> r2 = new HashMap();
        boolean r3 = true;
        int r4 = 0;
        if (r1 != null) goto L9;
    L12:
        boolean r5 = true;
    L13:
        r2.put("image_prefetch_first_screen_enable", Boolean.valueOf(r5));
        int r6 = 4;
        r2.put("image_prefetch_first_screen_count", 4);
        if (r1 != null) goto L16;
    L19:
        r2.put("image_prefetch_load_more_enable", Boolean.valueOf(r3));
        if (r1 == null) goto L22;
        r6 = r1.a();
    L22:
        r2.put("image_prefetch_load_more_count", Integer.valueOf(r6));
        if (r1 == null) goto L27;
        Integer r7 = r1.g;
        if (r7 == null) goto L27;
        r4 = r7.intValue();
    L27:
        r2.put("image_prefetch_load_more_immediate", Integer.valueOf(r4));
        return r2;
    L16:
        if (r1.c == true) goto L19;
        r3 = false;
        goto L19
    L9:
        if (r1.b == true) goto L12;
        r5 = false;
        goto L13
    L5:
        r1 = null;
        goto L6
    }

    public final Map<String, Object> b(Map<String, String> r7) {
        LinkedHashMap r0 = new LinkedHashMap();
        boolean r1 = false;
        if (r7 == null) goto L20;
        Set<Map.Entry<String, String>> r3 = r7.entrySet();
        if (r3 == null) goto L20;
        Iterator<T> r4 = r3.iterator();
    L8:
        if (r4.hasNext() == false) goto L20;
        Map.Entry r5 = (Map.Entry) r4.next();
        if ((!StringsKt.isBlank((CharSequence) r5.getKey())) == false) goto L8;
        CharSequence r6 = (CharSequence) r5.getValue();
        if (r6 != null) goto L14;
    L17:
        boolean r8 = true;
    L18:
        if (r8 == true) goto L8;
        Object r9 = r5.getKey();
        Object r10 = r5.getValue();
        Intrinsics.checkNotNull(r10);
        r0.put(r9, r10);
        goto L8
    L14:
        if (StringsKt.isBlank(r6) == true) goto L17;
        r8 = false;
    L20:
        if (r7 == null) goto L22;
        String r11 = r7.get("history_path");
    L23:
        if (r11 != null) goto L25;
    L26:
        r1 = true;
    L28:
        if (r1 == false) goto L33;
        if (r7 == null) goto L32;
        r11 = r7.get(SimilarProductParam.ENTER_FROM);
        if (r11 != null) goto L33;
    L32:
        r11 = "";
    L33:
        r0.put(SimilarProductParam.ENTER_FROM, r11);
        return r0;
    L25:
        if (StringsKt.isBlank(r11) == false) goto L28;
    L22:
        r11 = null;
        goto L23
    }

    public final List<com.bytedance.android.ec.hybrid.list.entity.p> c(String r13) {
        Intrinsics.checkNotNullParameter(r13, "pageName");
        ArrayList r0 = new ArrayList();
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L46
        ArrayList r2 = (ArrayList) ((Map) this.d.getValue()).get(r13);     // Catch: Throwable -> L46
        Unit r3 = null;
        if (r2 == null) goto L44;
        Iterator r4 = r2.iterator();     // Catch: Throwable -> L46
    L7:
        if (r4.hasNext() == false) goto L43;
        LinkedTreeMap r5 = (LinkedTreeMap) r4.next();     // Catch: Throwable -> L46
        Object r6 = r5.get("item_type");     // Catch: Throwable -> L46
        if ((r6 instanceof Double) == true) goto L11;
        r6 = null;
    L11:
        Double r7 = (Double) r6;     // Catch: Throwable -> L46
        if (r7 == null) goto L7;
        int r8 = (int) r7.doubleValue();     // Catch: Throwable -> L46
        String r9 = (String) ((LinkedHashMap) this.c).get(r13 + '_' + r8);     // Catch: Throwable -> L46
        if (r9 != null) goto L34;
        List<MallLynxSchemaConfig> r10 = ((MallSchemaSetting) this.b.getValue()).getCardConfig();     // Catch: Throwable -> L46
        if (r10 == null) goto L34;
        Iterator<T> r11 = r10.iterator();     // Catch: Throwable -> L46
    L19:
        if (r11.hasNext() == false) goto L34;
        MallLynxSchemaConfig r12 = (MallLynxSchemaConfig) r11.next();     // Catch: Throwable -> L46
        Integer r14 = r12.getItemType();     // Catch: Throwable -> L46
        if (r14 == null) goto L19;
        if (r14.intValue() != r8) goto L19;
        String r15 = r12.getLynxSchema();     // Catch: Throwable -> L46
        if (r15 == null) goto L19;
        Uri.Builder r16 = UriProtector.parse("hybrid://lynxview").buildUpon();     // Catch: Throwable -> L46
        TreeMap r17 = d(r12.getQueryMap(), r5);     // Catch: Throwable -> L46
        r17.put("surl", r15);     // Catch: Throwable -> L46
        Iterator r18 = r17.keySet().iterator();     // Catch: Throwable -> L46
    L29:
        if (r18.hasNext() == false) goto L33;
        String r19 = (String) r18.next();     // Catch: Throwable -> L46
        Object r110 = r17.get(r19);     // Catch: Throwable -> L46
        if (r110 == null) goto L29;
        r16.appendQueryParameter(r19, r110.toString());     // Catch: Throwable -> L46
        goto L29
    L33:
        r9 = r16.build().toString();     // Catch: Throwable -> L46
        this.c.put(r13 + '_' + r8, r9);     // Catch: Throwable -> L46
    L34:
        if (r9 == null) goto L7;
        Object r20 = r5.get("preload_num");     // Catch: Throwable -> L46
        if ((r20 instanceof Double) == true) goto L38;
        r20 = null;
    L38:
        Double r21 = (Double) r20;     // Catch: Throwable -> L46
        if (r21 == null) goto L41;
        int r22 = (int) r21.doubleValue();     // Catch: Throwable -> L46
    L42:
        r0.add(new com.bytedance.android.ec.hybrid.list.entity.p(r9, r22));     // Catch: Throwable -> L46
        goto L7
    L41:
        r22 = 1;
        goto L42
    L43:
        r3 = Unit.INSTANCE;     // Catch: Throwable -> L46
    L44:
        Result.constructor-impl(r3);     // Catch: Throwable -> L46
    L48:
        return r0;
    L46:
        th = move-exception;
        Result.Companion r23 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L48
    }

    public static TreeMap d(Map r3, LinkedTreeMap r4) {
        TreeMap r0 = new TreeMap();
        if (r3 == null) goto L5;
        r0.putAll(r3);
    L5:
        Iterator r5 = r4.keySet().iterator();
    L7:
        if (r5.hasNext() == false) goto L15;
        String r1 = (String) r5.next();
        if ((!Intrinsics.areEqual(r1, "item_type")) == false) goto L7;
        if ((!Intrinsics.areEqual(r1, "preload_num")) == false) goto L7;
        Object r2 = r4.get(r1);
        if (r2 == null) goto L7;
        r0.put(r1, r2);
        goto L7
    L15:
        return r0;
    }

    public final com.bytedance.android.shopping.api.mall.idl.b e(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "pageName");
        Intrinsics.checkNotNullParameter(r4, "key");
        return this.a.remove(r3 + "_" + r4);
    }
}
