package com.bytedance.android.shopping.sku.inner.container;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ecom.arch.slice.render.context.SlcRenderContext;
import com.bytedance.android.shopping.sku.common.ability.SkuCommonAbility;
import com.bytedance.android.shopping.sku.inner.controller.SkuYataSliceServerTimeController;
import com.bytedance.android.shopping.sku.inner.controller.SkuYataStatusController;
import com.bytedance.kmp.ec.yata.AndroidYaTaInstance;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public interface b extends com.bytedance.android.ec.core.gallery2.opt.b, com.bytedance.android.shopping.sku.inner.yata.abilities.a, com.bytedance.android.ec.core.async.b {
    SkuYataSliceServerTimeController AG();

    Activity P2();

    RecyclerView QB();

    SlcRenderContext Ul();

    AndroidYaTaInstance bV();

    ViewGroup cM();

    void close(int r1);

    Context context();

    com.bytedance.android.ecom.arch.slice.render.context.b d8();

    SkuCommonAbility dq();

    View i();

    SkuYataStatusController n20();

    SkuYataViewModel qn();

    PageFinder tS();

    String tag();

    com.bytedance.android.shopping.sku.common.ability.c zJ();
}
