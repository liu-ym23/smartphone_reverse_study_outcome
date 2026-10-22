package com.bytedance.android.shopping.sku.common.ability;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ecom.arch.slice.render.context.SlcRenderContext;
import com.bytedance.android.shopping.sku.common.controller.SkuHandleEventOpportunity;
import com.bytedance.kmp.ec.yata.AndroidYaTaInstance;
import com.bytedance.kmp.ec.yata.event.common.EventTriggerInfo;
import com.bytedance.kmp.ec.yata.event.common.h;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import ul.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public interface b {
    void a();

    long b();

    com.bytedance.kmp.ec.yata.event.ability.tracker.b c(com.bytedance.kmp.ec.yata.event.ability.tracker.a r1);

    com.bytedance.kmp.ec.yata.event.ability.uplink.b d(com.bytedance.kmp.ec.yata.event.ability.uplink.a r1);

    h e(EventTriggerInfo r1);

    void f();

    void g(SlcRenderContext r1, Window r2, RecyclerView r3, ViewGroup r4);

    void h(Context r1, com.bytedance.kmp.ec.yata.event.core.a r2);

    void i(com.bytedance.kmp.ec.yata.event.core.a r1);

    void j(com.bytedance.kmp.ec.yata.event.core.a r1, Function1 r2);

    void k(Activity r1, com.bytedance.kmp.ec.yata.event.core.a r2, PageFinder r3, int r4);

    void l(Activity r1, PageFinder r2, com.bytedance.kmp.ec.yata.event.core.a r3, Map r4);

    void m(com.bytedance.android.shopping.sku.inner.repo.a r1);

    boolean n(com.bytedance.kmp.ec.yata.common.biz.callback.a r1);

    void o(com.bytedance.kmp.ec.yata.event.core.a r1);

    void onResume();

    void onStart();

    void onStop();

    void p(com.bytedance.kmp.ec.yata.event.core.a r1, Function1 r2);

    void q(Activity r1, PageFinder r2, com.bytedance.kmp.ec.yata.event.core.a r3);

    void r(com.bytedance.kmp.ec.yata.event.core.a r1);

    void s(String r1);

    void t(Activity r1, com.bytedance.android.ec.core.gallery2.opt.b r2, com.bytedance.android.ec.core.async.b r3, com.bytedance.kmp.ec.yata.event.core.a r4, View r5, Function1 r6);

    void u(Context r1, f r2);

    void v(SkuHandleEventOpportunity r1, Object r2);

    void w(com.bytedance.android.ec.core.async.b r1, com.bytedance.android.shopping.sku.common.jsb.a r2);

    void x(Function0<AndroidYaTaInstance> r1, Function0<? extends c> r2);

    void y(com.bytedance.kmp.ec.yata.event.core.a r1, RecyclerView r2, SlcRenderContext r3);

    void z(com.bytedance.kmp.ec.yata.event.core.a r1, Function1 r2);
}
