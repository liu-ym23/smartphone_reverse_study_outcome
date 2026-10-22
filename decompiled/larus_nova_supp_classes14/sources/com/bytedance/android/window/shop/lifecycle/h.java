package com.bytedance.android.window.shop.lifecycle;

import android.content.Context;
import com.bytedance.android.ec.core.opt.ab.p;
import com.bytedance.android.ec.core.utils.t0;
import com.bytedance.android.ec.window.base.preload.WindowImagePreloadConfig;
import com.bytedance.android.ec.window.base.repository.vo.WindowV2ProductItemVO;
import com.bytedance.android.ec.window.base.utils.taskmanager.ECWindowTaskManager;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.window.shop.home.ECWindowParam;
import com.bytedance.android.window.shop.repository.compat.WindowTabInfoProvider;
import com.bytedance.android.window.shop.repository.dto.WindowHeaderResponseDTO;
import com.bytedance.android.window.shop.repository.tab.entity.WindowLayoutType;
import com.bytedance.android.window.shop.widget.WindowTypeSeparatedAdapter;
import com.google.gson.Gson;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class h implements e {
    public final Set<Integer> a;
    public WindowImagePreloadConfig b;

    @Override // com.bytedance.android.window.shop.lifecycle.e
    public final void a() {
    }

    @Override // com.bytedance.android.window.shop.lifecycle.e
    public final void b() {
    }

    @Override // com.bytedance.android.window.shop.lifecycle.e
    public final void d(long r1) {
    }

    @Override // com.bytedance.android.window.shop.lifecycle.e
    public final void f() {
    }

    @Override // com.bytedance.android.window.shop.lifecycle.e
    public final void k() {
    }

    @Override // com.bytedance.android.window.shop.lifecycle.e
    public final void l() {
    }

    @Override // com.bytedance.android.window.shop.lifecycle.e
    public final void r() {
    }

    @Override // com.bytedance.android.window.shop.lifecycle.e
    public final void u() {
    }

    @Override // com.bytedance.android.window.shop.lifecycle.e
    public final void v() {
    }

    public /* synthetic */ h() {
        this(new LinkedHashSet(), null);
    }

    @Override // com.bytedance.android.window.shop.lifecycle.e
    public final void g(ECWindowParam r2) {
        Intrinsics.checkNotNullParameter(r2, "windowParam");
        Intrinsics.checkNotNullParameter(r2, "windowParam");
    }

    @Override // com.bytedance.android.window.shop.lifecycle.e
    public final void h(ECWindowParam r2) {
        Intrinsics.checkNotNullParameter(r2, "windowParam");
        Intrinsics.checkNotNullParameter(r2, "windowParam");
    }

    @Override // com.bytedance.android.window.shop.lifecycle.e
    public final void j(WindowTabInfoProvider r2) {
        Intrinsics.checkNotNullParameter(r2, "response");
        Intrinsics.checkNotNullParameter(r2, "response");
    }

    @Override // com.bytedance.android.window.shop.lifecycle.e
    public final void n(uq3.a r2) {
        Intrinsics.checkNotNullParameter(r2, "response");
        Intrinsics.checkNotNullParameter(r2, "response");
    }

    @Override // com.bytedance.android.window.shop.lifecycle.e
    public final e s(boolean r3) {
        return new h(this.a, this.b);
    }

    public h(Set<Integer> r2, WindowImagePreloadConfig r3) {
        Intrinsics.checkNotNullParameter(r2, "cachedList");
        this.a = r2;
        this.b = r3;
    }

    @Override // com.bytedance.android.window.shop.lifecycle.e
    public final void o(Context r4, ECWindowParam r5) {
        Intrinsics.checkNotNullParameter(r5, "windowParam");
        Intrinsics.checkNotNullParameter(r5, "windowParam");
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L16
        int r7 = t0.a;     // Catch: Throwable -> L16
        Gson r8 = t0.a.a;     // Catch: Throwable -> L16
        int r9 = yq3.a.a;     // Catch: Throwable -> L16
        int r10 = p.a;     // Catch: Throwable -> L16
        Object r0 = "{\n  \"preload_image_num_first_screen\": 4,\n  \"preload_image_num_load_more\": 4\n}";
        jj4.b r1 = jj4.b.b;     // Catch: Throwable -> L8
        Object r11 = jj4.a.a("ec_window_image_preload_config", String.class, "{\n  \"preload_image_num_first_screen\": 4,\n  \"preload_image_num_load_more\": 4\n}", false);     // Catch: Throwable -> L8
        if (r11 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L8
    L14:
        Object r12 = Result.constructor-impl((WindowImagePreloadConfig) r8.fromJson((String) r11, WindowImagePreloadConfig.class));     // Catch: Throwable -> L16
    L19:
        if (Result.isFailure-impl(r12) == false) goto L21;
        r12 = null;
    L21:
        this.b = (WindowImagePreloadConfig) r12;
        return;
    L8:
        th = move-exception;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L16
        Object r13 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L16
        if (Result.isFailure-impl(r13) == true) goto L13;
        r0 = r13;
    L13:
        r11 = r0;
    L16:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L19
    }

    @Override // com.bytedance.android.window.shop.lifecycle.e
    public final void p(ECWindowParam r3, WindowHeaderResponseDTO r4) {
        Intrinsics.checkNotNullParameter(r3, "windowParam");
        Intrinsics.checkNotNullParameter(r4, "response");
        Intrinsics.checkNotNullParameter(r3, "windowParam");
        Intrinsics.checkNotNullParameter(r4, "response");
    }

    @Override // com.bytedance.android.window.shop.lifecycle.e
    public final void q(Context r3, ECWindowParam r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "windowParam");
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "windowParam");
    }

    @Override // com.bytedance.android.window.shop.lifecycle.e
    public final void e(ECWindowParam r1, JSONObject r2, JSONObject r3) {
        Intrinsics.checkNotNullParameter(r1, "windowParam");
        Intrinsics.checkNotNullParameter(r1, "windowParam");
    }

    @Override // com.bytedance.android.window.shop.lifecycle.e
    public final void i(ECWindowParam r2, WindowTabInfoProvider r3, Map<String, String> r4) {
        Intrinsics.checkNotNullParameter(r2, "windowParam");
        Intrinsics.checkNotNullParameter(r3, "response");
        Intrinsics.checkNotNullParameter(r2, "windowParam");
        Intrinsics.checkNotNullParameter(r3, "response");
        WindowImagePreloadConfig r5 = this.b;
        if (r5 == null) goto L8;
        Integer r6 = r5.getFirstScreenCount();
        if (r6 == null) goto L9;
        r6.intValue();
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.window.shop.lifecycle.e
    public final void t(int r7, Integer r8, WindowTypeSeparatedAdapter r9) {
        Intrinsics.checkNotNullParameter(r9, "adapter");
        Intrinsics.checkNotNullParameter(r9, "adapter");
        WindowImagePreloadConfig r0 = this.b;
        if (r0 == null) goto L43;
        Integer r1 = r0.getLoadMoreCount();
        if (r1 == null) goto L45;
        int r10 = r7 + 1;
        int r2 = RangesKt.coerceAtMost(r1.intValue() + r10, r9.getItemCount() - 1);
        if (r10 <= r2) goto L9;
        return;
    L9:
        if (r10 >= r9.getBasicItemCount()) goto L41;
        com.bytedance.android.window.shop.repository.tab.entity.f r3 = (com.bytedance.android.window.shop.repository.tab.entity.f) CollectionsKt.getOrNull(r9.h, r10);
        String r4 = null;
        if (r3 == null) goto L13;
        WindowV2ProductItemVO r5 = r3.c();
    L14:
        if (r5 == null) goto L41;
        List r6 = r5.h;
        int r11 = WindowLayoutType.DOUBLECOLUMN.getType();
        if (r8 != null) goto L19;
    L20:
        int r12 = WindowLayoutType.DOUBLECOLUMN_V2.getType();
        if (r8 != null) goto L24;
    L34:
        final String r13 = (String) CollectionsKt.firstOrNull(r6);
        if (r13 == null) goto L41;
        if (this.a.contains(Integer.valueOf(r13.hashCode())) == true) goto L41;
        this.a.add(Integer.valueOf(r13.hashCode()));
        Lazy r14 = ECWindowTaskManager.a;
        ECWindowTaskManager r15 = ECWindowTaskManager.a.a();
        final boolean r16 = false;
        Function0<Unit> r17 = new WindowProductImagePreloadLifecycle$preloadImageAsync$1(this, r13, r16);
        r15.getClass();
        ECWindowTaskManager.a(r17);
        goto L41
    L24:
        if (r8.intValue() != r12) goto L34;
    L25:
        List r18 = r5.B;
        if ((!r18.isEmpty()) == true) goto L29;
        r18 = null;
    L29:
        if (r18 == null) goto L32;
        r4 = (String) CollectionsKt.first(r18);
    L32:
        if (k.c(r4) == false) goto L34;
        r6 = r5.B;
        goto L34
    L19:
        if (r8.intValue() == r11) goto L25;
    L13:
        r5 = null;
    L41:
        if (r10 == r2) goto L47;
        r10 = r10 + 1;
        goto L9
    L47:
        return;
    L45:
        return;
    }

    @Override // com.bytedance.android.window.shop.lifecycle.e
    public final void c(ECWindowParam r1, long r2, JSONObject r4, JSONObject r5) {
        Intrinsics.checkNotNullParameter(r1, "windowParam");
        Intrinsics.checkNotNullParameter(r1, "windowParam");
    }

    @Override // com.bytedance.android.window.shop.lifecycle.e
    public final void m(ECWindowParam r1, long r2, JSONObject r4, JSONObject r5) {
        Intrinsics.checkNotNullParameter(r1, "windowParam");
        Intrinsics.checkNotNullParameter(r1, "windowParam");
    }
}
