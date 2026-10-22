package zq3;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.dataplatform.config.SettingPanel;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class l {
    public static final /* synthetic */ int a = 0;

    @Metadata(d1 = {"\u0000\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0002¸\u0006\u0003"}, d2 = {"com/bytedance/android/window/shop/utils/OptWindowSetting$getMockValue$type$1", "Lcom/google/gson/reflect/TypeToken;", "ec-biz-store-impl_saasRelease", "zq3/o1"}, k = 1, mv = {1, 4, 3})
    public static final class a extends TypeToken<List<? extends Integer>> {
        public a() {
        }
    }

    @Metadata(d1 = {"\u0000\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0002¸\u0006\u0003"}, d2 = {"com/bytedance/android/window/shop/utils/OptWindowSetting$getMockValue$type$1", "Lcom/google/gson/reflect/TypeToken;", "ec-biz-store-impl_saasRelease", "zq3/f1"}, k = 1, mv = {1, 4, 3})
    public static final class b extends TypeToken<Boolean> {
        public b() {
        }
    }

    @Metadata(d1 = {"\u0000\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0002¸\u0006\u0003"}, d2 = {"com/bytedance/android/window/shop/utils/OptWindowSetting$getMockValue$type$1", "Lcom/google/gson/reflect/TypeToken;", "ec-biz-store-impl_saasRelease", "zq3/z0"}, k = 1, mv = {1, 4, 3})
    public static final class c extends TypeToken<Integer> {
        public c() {
        }
    }

    @Metadata(d1 = {"\u0000\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0002¸\u0006\u0003"}, d2 = {"com/bytedance/android/window/shop/utils/OptWindowSetting$getMockValue$type$1", "Lcom/google/gson/reflect/TypeToken;", "ec-biz-store-impl_saasRelease", "zq3/e1"}, k = 1, mv = {1, 4, 3})
    public static final class d extends TypeToken<Boolean> {
        public d() {
        }
    }

    @SettingPanel("橱窗支持的动态native组件")
    public static List a() {
        Gson r0 = zq3.c.a;
        Object r1 = CollectionsKt.emptyList();
        if (zq3.c.b == false) goto L14;
        int r2 = com.bytedance.android.ec.core.opt.ab.p.a;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L9
        jj4.b r4 = jj4.b.b;     // Catch: Throwable -> L9
        Object r5 = jj4.a.a("ecom_window_supported_dynamic_types", List.class, r1, false);     // Catch: Throwable -> L9
        if (r5 != null) goto L41;
        Intrinsics.throwNpe();     // Catch: Throwable -> L9
    L41:
        return (List) r5;
    L9:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        Object r7 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r7) == true) goto L39;
    L13:
        r1 = r7;
    L39:
        r5 = r1;
        goto L41
    L14:
        String r8 = hq7.d.b("debug.shopping.mock.ecom_window_supported_dynamic_types");
        if (r8 != null) goto L17;
    L20:
        boolean r9 = true;
    L21:
        if (r9 == true) goto L29;
        Type r10 = new a().getType();
        r5 = zq3.c.a.fromJson(r8, r10);     // Catch: Exception -> L27
        if (r5 == null) goto L29;
    L30:
        if (r5 != null) goto L41;
        int r11 = com.bytedance.android.ec.core.opt.ab.p.a;
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L36
        jj4.b r13 = jj4.b.b;     // Catch: Throwable -> L36
        r5 = jj4.a.a("ecom_window_supported_dynamic_types", List.class, r1, false);     // Catch: Throwable -> L36
        if (r5 != null) goto L41;
        Intrinsics.throwNpe();     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r7) == false) goto L13;
    L27:
        e = move-exception;
        ECExceptionMonitor.e(e);
    L29:
        r5 = null;
        goto L30
    L17:
        if (StringsKt.isBlank(r8) == true) goto L20;
        r9 = false;
        goto L21
    }

    public static boolean b() {
        Gson r0 = zq3.c.a;
        Object r1 = Boolean.FALSE;
        if (zq3.c.b == false) goto L14;
        int r2 = com.bytedance.android.ec.core.opt.ab.p.a;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L9
        jj4.b r4 = jj4.b.b;     // Catch: Throwable -> L9
        Object r5 = jj4.a.a("window_top_search_bar_opt", Boolean.class, r1, false);     // Catch: Throwable -> L9
        if (r5 != null) goto L41;
        Intrinsics.throwNpe();     // Catch: Throwable -> L9
    L41:
        return ((Boolean) r5).booleanValue();
    L9:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        Object r7 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r7) == true) goto L39;
    L13:
        r1 = r7;
    L39:
        r5 = r1;
        goto L41
    L14:
        String r8 = hq7.d.b("debug.shopping.mock.window_top_search_bar_opt");
        if (r8 != null) goto L17;
    L20:
        boolean r9 = true;
    L21:
        if (r9 == true) goto L29;
        Type r10 = new b().getType();
        r5 = zq3.c.a.fromJson(r8, r10);     // Catch: Exception -> L27
        if (r5 == null) goto L29;
    L30:
        if (r5 != null) goto L41;
        int r11 = com.bytedance.android.ec.core.opt.ab.p.a;
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L36
        jj4.b r13 = jj4.b.b;     // Catch: Throwable -> L36
        r5 = jj4.a.a("window_top_search_bar_opt", Boolean.class, r1, false);     // Catch: Throwable -> L36
        if (r5 != null) goto L41;
        Intrinsics.throwNpe();     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r7) == false) goto L13;
    L27:
        e = move-exception;
        ECExceptionMonitor.e(e);
    L29:
        r5 = null;
        goto L30
    L17:
        if (StringsKt.isBlank(r8) == true) goto L20;
        r9 = false;
        goto L21
    }

    @SettingPanel("橱窗首屏加载卡片数量")
    public static int c() {
        Gson r0 = zq3.c.a;
        Object r1 = 10;
        if (zq3.c.b == false) goto L14;
        int r2 = com.bytedance.android.ec.core.opt.ab.p.a;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L9
        jj4.b r4 = jj4.b.b;     // Catch: Throwable -> L9
        Object r5 = jj4.a.a("window_tab_first_request_page_size", Integer.class, r1, false);     // Catch: Throwable -> L9
        if (r5 != null) goto L41;
        Intrinsics.throwNpe();     // Catch: Throwable -> L9
    L41:
        return ((Number) r5).intValue();
    L9:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        Object r7 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r7) == true) goto L39;
    L13:
        r1 = r7;
    L39:
        r5 = r1;
        goto L41
    L14:
        String r8 = hq7.d.b("debug.shopping.mock.window_tab_first_request_page_size");
        if (r8 != null) goto L17;
    L20:
        boolean r9 = true;
    L21:
        if (r9 == true) goto L29;
        Type r10 = new c().getType();
        r5 = zq3.c.a.fromJson(r8, r10);     // Catch: Exception -> L27
        if (r5 == null) goto L29;
    L30:
        if (r5 != null) goto L41;
        int r11 = com.bytedance.android.ec.core.opt.ab.p.a;
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L36
        jj4.b r13 = jj4.b.b;     // Catch: Throwable -> L36
        r5 = jj4.a.a("window_tab_first_request_page_size", Integer.class, r1, false);     // Catch: Throwable -> L36
        if (r5 != null) goto L41;
        Intrinsics.throwNpe();     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r7) == false) goto L13;
    L27:
        e = move-exception;
        ECExceptionMonitor.e(e);
    L29:
        r5 = null;
        goto L30
    L17:
        if (StringsKt.isBlank(r8) == true) goto L20;
        r9 = false;
        goto L21
    }

    public static boolean d() {
        Gson r0 = zq3.c.a;
        Object r1 = Boolean.FALSE;
        if (zq3.c.b == false) goto L14;
        int r2 = com.bytedance.android.ec.core.opt.ab.p.a;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L9
        jj4.b r4 = jj4.b.b;     // Catch: Throwable -> L9
        Object r5 = jj4.a.a("window_vane_control_all_tab", Boolean.class, r1, false);     // Catch: Throwable -> L9
        if (r5 != null) goto L41;
        Intrinsics.throwNpe();     // Catch: Throwable -> L9
    L41:
        return ((Boolean) r5).booleanValue();
    L9:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        Object r7 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r7) == true) goto L39;
    L13:
        r1 = r7;
    L39:
        r5 = r1;
        goto L41
    L14:
        String r8 = hq7.d.b("debug.shopping.mock.window_vane_control_all_tab");
        if (r8 != null) goto L17;
    L20:
        boolean r9 = true;
    L21:
        if (r9 == true) goto L29;
        Type r10 = new d().getType();
        r5 = zq3.c.a.fromJson(r8, r10);     // Catch: Exception -> L27
        if (r5 == null) goto L29;
    L30:
        if (r5 != null) goto L41;
        int r11 = com.bytedance.android.ec.core.opt.ab.p.a;
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L36
        jj4.b r13 = jj4.b.b;     // Catch: Throwable -> L36
        r5 = jj4.a.a("window_vane_control_all_tab", Boolean.class, r1, false);     // Catch: Throwable -> L36
        if (r5 != null) goto L41;
        Intrinsics.throwNpe();     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r7) == false) goto L13;
    L27:
        e = move-exception;
        ECExceptionMonitor.e(e);
    L29:
        r5 = null;
        goto L30
    L17:
        if (StringsKt.isBlank(r8) == true) goto L20;
        r9 = false;
        goto L21
    }

    static {
    }
}
