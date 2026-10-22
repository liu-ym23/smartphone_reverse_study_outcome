package com.bytedance.kmp.ec.yata.view.render.controller.common;

import android.view.View;
import ba6.g;
import com.bytedance.kmp.ec.yata.common.log.YaTaLog;
import com.bytedance.kmp.ec.yata.view.render.tree.RenderTreeManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class YataViewHolder implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RenderTreeManager f251839a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g f251840b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ba6.d f251841c;

    @Override // com.bytedance.kmp.ec.yata.view.render.controller.common.c
    public final View a() {
        return this.f251839a.a(this.f251841c.getContainer());
    }

    @Override // com.bytedance.kmp.ec.yata.view.render.controller.common.c
    public final int b() {
        RenderTreeManager r100 = this.f251839a;
        ba6.d r101 = this.f251841c;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "renderNode");
        com.bytedance.kmp.ec.yata.common.protocol.data.b r102 = r101.getContainer();
        return r100.f252104c.b(r102).a(r101);
    }

    @Override // com.bytedance.kmp.ec.yata.view.render.controller.common.c
    public final ba6.d c() {
        return this.f251841c;
    }

    @Override // com.bytedance.kmp.ec.yata.view.render.controller.common.c
    public final void d(View r100) {
        if (r100 != null) goto L5;
        String r101 = YaTaLog.f251436a;
        YaTaLog.d("YataViewHolder", YataViewHolder$updateData$1.INSTANCE);
        return;
    L5:
        this.f251839a.e(r100, this.f251840b, this.f251841c);
    }

    public YataViewHolder(RenderTreeManager r100, g r101, ba6.d r102) {
        Intrinsics.checkNotNullParameter(r100, "treeManager");
        Intrinsics.checkNotNullParameter(r101, "storeData");
        Intrinsics.checkNotNullParameter(r102, "renderNode");
        this.f251839a = r100;
        this.f251840b = r101;
        this.f251841c = r102;
    }
}
