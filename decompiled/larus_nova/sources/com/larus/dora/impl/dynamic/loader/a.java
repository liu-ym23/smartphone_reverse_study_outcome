package com.larus.dora.impl.dynamic.loader;

import android.app.Application;
import com.bytedance.dora.annotation.ProductNameType;
import com.bytedance.keva.Keva;
import com.google.gson.Gson;
import com.larus.common.apphost.AppHost;
import com.larus.dora.impl.dynamic.a2;
import com.larus.dora.impl.dynamic.v1;
import com.larus.dora.impl.dynamic.viewmodel.DoraDynamicViewModel;
import com.larus.dora.impl.dynamic.y1;
import com.larus.dora.impl.dynamic.z1;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes27.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g59.d f335203a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Gson f335204b;

    /* JADX INFO: renamed from: com.larus.dora.impl.dynamic.loader.a$a, reason: collision with other inner class name */
    public static final class C4247a {
    }

    public interface b {
        void a();

        void b(List<com.larus.dora.impl.dynamic.d> r100, com.larus.dora.impl.dynamic.e r101, Map<String, String> r102);

        void onFail(String r100);
    }

    static {
    }

    public a() {
        this.f335203a = new g59.d();
        this.f335204b = new Gson();
    }

    public static void c(a2 r100, b r101) {
        if (r100.a() == null) goto L46;
        boolean r102 = true;
        if ((!r100.a().isEmpty()) == false) goto L46;
        List r103 = CollectionsKt.filterNotNull(r100.a());
        Map<String, String> r104 = null;
        if (r103 == null) goto L14;
        ArrayList r105 = new ArrayList();
        Iterator r106 = r103.iterator();
    L10:
        if (r106.hasNext() == false) goto L15;
        com.larus.dora.impl.dynamic.d r107 = ((v1) r106.next()).a();
        if (r107 == null) goto L10;
        r105.add(r107);
    L15:
        FLogger r108 = FLogger.f375446a;
        StringBuilder r109 = new StringBuilder("cardList size: ");
        if (r105 == null) goto L18;
        int r110 = r105.size();
    L19:
        r109.append(r110);
        r108.e("DoraDynamicDataLoader", r109.toString());
        Map<String, String> r111 = r100.c();
        if (r111 == null) goto L38;
        LinkedHashMap r112 = new LinkedHashMap();
        Iterator<Map.Entry<String, String>> r113 = r111.entrySet().iterator();
    L23:
        if (r113.hasNext() == false) goto L30;
        Map.Entry<String, String> r114 = r113.next();
        if (r114.getValue() == null) goto L27;
        boolean r115 = true;
    L28:
        if (r115 == false) goto L23;
        r112.put(r114.getKey(), r114.getValue());
        goto L23
    L27:
        r115 = false;
        goto L28
    L30:
        LinkedHashMap r116 = new LinkedHashMap(MapsKt.mapCapacity(r112.size()));
        Iterator r117 = r112.entrySet().iterator();
    L32:
        if (r117.hasNext() == false) goto L37;
        Map.Entry r118 = (Map.Entry) r117.next();
        Object r119 = r118.getKey();
        String r120 = (String) r118.getValue();
        if (r120 != null) goto L36;
        r120 = "";
    L36:
        r116.put(r119, r120);
        goto L32
    L37:
        r104 = r116;
    L38:
        if (r105 != null) goto L40;
    L42:
        r102 = false;
    L43:
        if (r102 == false) goto L45;
        r101.b(r105, r100.b(), r104);
        return;
    L45:
        r101.a();
        return;
    L40:
        if ((!r105.isEmpty()) != true) goto L42;
    L18:
        r110 = 0;
        goto L19
    L14:
        r105 = null;
    L46:
        r101.a();
    }

    public final void b(CoroutineScope r210, Integer r211, String r212, String r213, DoraDynamicViewModel.g r214) {
        String r100 = "";
        Intrinsics.checkNotNullParameter(r214, "callback");
        FLogger.f375446a.i("DoraDynamicDataLoader", "fetchData productId :" + r211 + ",model:" + r212 + ",pageKey:" + r213 + ' ');
        ProductNameType r101 = ProductNameType.DORA_E;
        int r102 = r101.f204375id;
        if (r211 == null) goto L9;
        if (r102 != r211.intValue()) goto L9;
        String r103 = r101.name;
    L12:
        boolean r104 = false;
        String r110 = CollectionsKt.joinToString$default(CollectionsKt.listOfNotNull(new String[]{r103, r213}), "_", null, null, 0, null, null, 62, null).toLowerCase(Locale.US);
        Keva r111 = g49.c.f480007a;     // Catch: Exception -> L32
        Intrinsics.checkNotNullParameter(r110, "key");     // Catch: Exception -> L32
        String r112 = g49.c.f480007a.getString("key_http_response" + r110, "");     // Catch: Exception -> L32
        g59.f.a(r110);     // Catch: Exception -> L32
        if (r112.length() <= 0) goto L16;
        r104 = true;
    L16:
        if (r104 == true) goto L39;
        g59.d r105 = this.f335203a;     // Catch: Exception -> L32
        Application r106 = AppHost.f326268a.getApplication();     // Catch: Exception -> L32
        if (r213 == null) goto L25;
        r100 = r213;
    L25:
        if (r211 == null) goto L27;
        int r107 = r211.intValue();     // Catch: Exception -> L32
    L28:
        a2 r108 = r105.a(r106, r100, r107);     // Catch: Exception -> L32
        if (r108 == null) goto L34;
        c(r108, r214);     // Catch: Exception -> L32
    L34:
        if (r210 == null) goto L36;
        BuildersKt.launch$default(r210, Dispatchers.getIO(), null, new DoraDynamicDataLoader$fetchData$1$1(this, r211, r212, r213, r110, r214, null), 2, null);
    L36:
        Unit r109 = Unit.INSTANCE;
        return;
    L27:
        r107 = Integer.MAX_VALUE;
        goto L28
    L39:
        c((a2) this.f335204b.fromJson(r112, a2.class), r214);     // Catch: Exception -> L19
    L19:
        e = move-exception;
        FLogger.f375446a.e("DoraDynamicDataLoader", "JSON parsing error: " + e.getMessage());     // Catch: Exception -> L32
    L32:
        e = move-exception;
        FLogger.f375446a.e("DoraDynamicDataLoader", "local fetchData error: " + e.getMessage());
        r214.onFail("local fetchData error: " + e.getMessage());
    L9:
        if (o59.a.o(r211) == false) goto L11;
        r103 = ProductNameType.DORA_G.name;
        goto L12
    L11:
        r103 = ProductNameType.DORA_LITE.name;
        goto L12
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v2, types: [com.larus.dora.impl.dynamic.loader.a$b] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v9, types: [com.larus.dora.impl.dynamic.loader.a$b] */
    public static final Object a(a r110, Integer r111, String r112, String r113, String r210, b r211, Continuation r212) {
        r110.getClass();
        ?? r100 = "Requesting data - productId:";
        if ((r212 instanceof DoraDynamicDataLoader$requestAndProcessData$1) == false) goto L7;
        DoraDynamicDataLoader$requestAndProcessData$1 r101 = (DoraDynamicDataLoader$requestAndProcessData$1) r212;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        DoraDynamicDataLoader$requestAndProcessData$1 r103 = r101;
        Object r104 = r103.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r103.label;
        boolean r114 = true;
        if (r106 == 0) goto L18;
        if (r106 != 1) goto L17;
        b r107 = (b) r103.L$1;
        String r108 = (String) r103.L$0;
        ResultKt.throwOnFailure(r104);     // Catch: Exception -> L14
        Object r109 = r104;
        String r115 = r108;
        r100 = r107;
    L24:
        z1 r116 = (z1) r109;     // Catch: Exception -> L14
        if (r116 == null) goto L48;
        y1 r117 = r116.b();     // Catch: Exception -> L14
        Map<String, String> r118 = null;
        if (r117 == null) goto L29;
        String r119 = r117.a();     // Catch: Exception -> L14
    L30:
        if (r119 != null) goto L32;
        r119 = "";
    L32:
        com.larus.dora.impl.dynamic.c r120 = r116.a();     // Catch: Exception -> L14
        if (r120 == null) goto L35;
        r118 = r120.a();     // Catch: Exception -> L14
    L35:
        g49.d.d("DoraDynamicDataLoader", "starlingMap: " + r118);     // Catch: Exception -> L14
        int r121 = 0;
    L37:
        if (r121 >= r119.length()) goto L57;
        int r122 = RangesKt.coerceAtMost(r121 + 2000, r119.length());     // Catch: Exception -> L14
        if (r114 == false) goto L41;
        String r123 = "**##" + r119.substring(r121, r122);     // Catch: Exception -> L14
    L42:
        g49.d.d("DoraDynamicDataLoader", r123);     // Catch: Exception -> L14
        r121 = r122;
        r114 = false;
        goto L37
    L41:
        r123 = r119.substring(r121, r122);     // Catch: Exception -> L14
        goto L42
    L57:
        a2 r124 = (a2) r110.f335204b.fromJson(r119, a2.class);     // Catch: Exception -> L46
        g49.c.a(r115, r119);     // Catch: Exception -> L46
        String r125 = r110.f335204b.toJson(r118);     // Catch: Exception -> L46
        Intrinsics.checkNotNullParameter(r115, "key");     // Catch: Exception -> L46
        Intrinsics.checkNotNullParameter(r125, "value");     // Catch: Exception -> L46
        g49.c.f480007a.storeString("dora_key_http_response_starling" + r115, r125);     // Catch: Exception -> L46
        c(r124, r100);     // Catch: Exception -> L46
    L54:
        return Unit.INSTANCE;
    L46:
        e = move-exception;
        FLogger.f375446a.e("DoraDynamicDataLoader", "JSON parsing error: " + e.getMessage());     // Catch: Exception -> L14
        goto L54
    L29:
        r119 = null;
        goto L30
    L48:
        r100.onFail("Network request failed");     // Catch: Exception -> L14
        goto L54
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r104);
        FLogger.f375446a.e("DoraDynamicDataLoader", "Requesting data - productId:" + r111 + ", model:" + r112 + ", pageKey:" + r113);     // Catch: Exception -> L50
        CoroutineDispatcher r126 = Dispatchers.getIO();     // Catch: Exception -> L50
        DoraDynamicDataLoader$requestAndProcessData$$inlined$requestData$1 r127 = new DoraDynamicDataLoader$requestAndProcessData$$inlined$requestData$1(r110, r111, r112, r113, null);     // Catch: Exception -> L50
        r115 = r210;
        r103.L$0 = r115;     // Catch: Exception -> L50
        b r128 = r211;
        r103.L$1 = r128;     // Catch: Exception -> L14
        r103.label = 1;     // Catch: Exception -> L14
        r109 = BuildersKt.withContext(r126, r127, r103);     // Catch: Exception -> L14
        r100 = r128;
        if (r109 != r105) goto L24;
        return r105;
    L50:
        e = e;
        r100 = r211;
    L52:
        FLogger.f375446a.e("DoraDynamicDataLoader", "fetchData error: " + e.getMessage());
        r100.onFail(e.getMessage());
    L14:
        e = e;
    L7:
        r101 = new DoraDynamicDataLoader$requestAndProcessData$1(r110, r212);
        goto L8
    }
}
