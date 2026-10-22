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

/* JADX INFO: loaded from: classes14.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f573304a = 0;

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
        Gson r100 = zq3.c.f573295a;
        Object r101 = CollectionsKt.emptyList();
        if (zq3.c.f573296b == false) goto L14;
        int r102 = com.bytedance.android.ec.core.opt.ab.p.f45243a;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L9
        jj4.b r104 = jj4.b.f499326b;     // Catch: Throwable -> L9
        Object r105 = jj4.a.a("ecom_window_supported_dynamic_types", List.class, r101, false);     // Catch: Throwable -> L9
        if (r105 != null) goto L41;
        Intrinsics.throwNpe();     // Catch: Throwable -> L9
    L41:
        return (List) r105;
    L9:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        Object r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r107) == true) goto L39;
    L13:
        r101 = r107;
    L39:
        r105 = r101;
        goto L41
    L14:
        String r108 = hq7.d.b("debug.shopping.mock.ecom_window_supported_dynamic_types");
        if (r108 != null) goto L17;
    L20:
        boolean r109 = true;
    L21:
        if (r109 == true) goto L29;
        Type r110 = new a().getType();
        r105 = zq3.c.f573295a.fromJson(r108, r110);     // Catch: Exception -> L27
        if (r105 == null) goto L29;
    L30:
        if (r105 != null) goto L41;
        int r111 = com.bytedance.android.ec.core.opt.ab.p.f45243a;
        Result.Companion r112 = Result.Companion;     // Catch: Throwable -> L36
        jj4.b r113 = jj4.b.f499326b;     // Catch: Throwable -> L36
        r105 = jj4.a.a("ecom_window_supported_dynamic_types", List.class, r101, false);     // Catch: Throwable -> L36
        if (r105 != null) goto L41;
        Intrinsics.throwNpe();     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        Result.Companion r114 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r107) == false) goto L13;
    L27:
        e = move-exception;
        ECExceptionMonitor.e(e);
    L29:
        r105 = null;
        goto L30
    L17:
        if (StringsKt.isBlank(r108) == true) goto L20;
        r109 = false;
        goto L21
    }

    public static boolean b() {
        Gson r100 = zq3.c.f573295a;
        Object r101 = Boolean.FALSE;
        if (zq3.c.f573296b == false) goto L14;
        int r102 = com.bytedance.android.ec.core.opt.ab.p.f45243a;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L9
        jj4.b r104 = jj4.b.f499326b;     // Catch: Throwable -> L9
        Object r105 = jj4.a.a("window_top_search_bar_opt", Boolean.class, r101, false);     // Catch: Throwable -> L9
        if (r105 != null) goto L41;
        Intrinsics.throwNpe();     // Catch: Throwable -> L9
    L41:
        return ((Boolean) r105).booleanValue();
    L9:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        Object r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r107) == true) goto L39;
    L13:
        r101 = r107;
    L39:
        r105 = r101;
        goto L41
    L14:
        String r108 = hq7.d.b("debug.shopping.mock.window_top_search_bar_opt");
        if (r108 != null) goto L17;
    L20:
        boolean r109 = true;
    L21:
        if (r109 == true) goto L29;
        Type r110 = new b().getType();
        r105 = zq3.c.f573295a.fromJson(r108, r110);     // Catch: Exception -> L27
        if (r105 == null) goto L29;
    L30:
        if (r105 != null) goto L41;
        int r111 = com.bytedance.android.ec.core.opt.ab.p.f45243a;
        Result.Companion r112 = Result.Companion;     // Catch: Throwable -> L36
        jj4.b r113 = jj4.b.f499326b;     // Catch: Throwable -> L36
        r105 = jj4.a.a("window_top_search_bar_opt", Boolean.class, r101, false);     // Catch: Throwable -> L36
        if (r105 != null) goto L41;
        Intrinsics.throwNpe();     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        Result.Companion r114 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r107) == false) goto L13;
    L27:
        e = move-exception;
        ECExceptionMonitor.e(e);
    L29:
        r105 = null;
        goto L30
    L17:
        if (StringsKt.isBlank(r108) == true) goto L20;
        r109 = false;
        goto L21
    }

    @SettingPanel("橱窗首屏加载卡片数量")
    public static int c() {
        Gson r100 = zq3.c.f573295a;
        Object r101 = 10;
        if (zq3.c.f573296b == false) goto L14;
        int r102 = com.bytedance.android.ec.core.opt.ab.p.f45243a;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L9
        jj4.b r104 = jj4.b.f499326b;     // Catch: Throwable -> L9
        Object r105 = jj4.a.a("window_tab_first_request_page_size", Integer.class, r101, false);     // Catch: Throwable -> L9
        if (r105 != null) goto L41;
        Intrinsics.throwNpe();     // Catch: Throwable -> L9
    L41:
        return ((Number) r105).intValue();
    L9:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        Object r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r107) == true) goto L39;
    L13:
        r101 = r107;
    L39:
        r105 = r101;
        goto L41
    L14:
        String r108 = hq7.d.b("debug.shopping.mock.window_tab_first_request_page_size");
        if (r108 != null) goto L17;
    L20:
        boolean r109 = true;
    L21:
        if (r109 == true) goto L29;
        Type r110 = new c().getType();
        r105 = zq3.c.f573295a.fromJson(r108, r110);     // Catch: Exception -> L27
        if (r105 == null) goto L29;
    L30:
        if (r105 != null) goto L41;
        int r111 = com.bytedance.android.ec.core.opt.ab.p.f45243a;
        Result.Companion r112 = Result.Companion;     // Catch: Throwable -> L36
        jj4.b r113 = jj4.b.f499326b;     // Catch: Throwable -> L36
        r105 = jj4.a.a("window_tab_first_request_page_size", Integer.class, r101, false);     // Catch: Throwable -> L36
        if (r105 != null) goto L41;
        Intrinsics.throwNpe();     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        Result.Companion r114 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r107) == false) goto L13;
    L27:
        e = move-exception;
        ECExceptionMonitor.e(e);
    L29:
        r105 = null;
        goto L30
    L17:
        if (StringsKt.isBlank(r108) == true) goto L20;
        r109 = false;
        goto L21
    }

    public static boolean d() {
        Gson r100 = zq3.c.f573295a;
        Object r101 = Boolean.FALSE;
        if (zq3.c.f573296b == false) goto L14;
        int r102 = com.bytedance.android.ec.core.opt.ab.p.f45243a;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L9
        jj4.b r104 = jj4.b.f499326b;     // Catch: Throwable -> L9
        Object r105 = jj4.a.a("window_vane_control_all_tab", Boolean.class, r101, false);     // Catch: Throwable -> L9
        if (r105 != null) goto L41;
        Intrinsics.throwNpe();     // Catch: Throwable -> L9
    L41:
        return ((Boolean) r105).booleanValue();
    L9:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        Object r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r107) == true) goto L39;
    L13:
        r101 = r107;
    L39:
        r105 = r101;
        goto L41
    L14:
        String r108 = hq7.d.b("debug.shopping.mock.window_vane_control_all_tab");
        if (r108 != null) goto L17;
    L20:
        boolean r109 = true;
    L21:
        if (r109 == true) goto L29;
        Type r110 = new d().getType();
        r105 = zq3.c.f573295a.fromJson(r108, r110);     // Catch: Exception -> L27
        if (r105 == null) goto L29;
    L30:
        if (r105 != null) goto L41;
        int r111 = com.bytedance.android.ec.core.opt.ab.p.f45243a;
        Result.Companion r112 = Result.Companion;     // Catch: Throwable -> L36
        jj4.b r113 = jj4.b.f499326b;     // Catch: Throwable -> L36
        r105 = jj4.a.a("window_vane_control_all_tab", Boolean.class, r101, false);     // Catch: Throwable -> L36
        if (r105 != null) goto L41;
        Intrinsics.throwNpe();     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        Result.Companion r114 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r107) == false) goto L13;
    L27:
        e = move-exception;
        ECExceptionMonitor.e(e);
    L29:
        r105 = null;
        goto L30
    L17:
        if (StringsKt.isBlank(r108) == true) goto L20;
        r109 = false;
        goto L21
    }

    static {
    }
}
