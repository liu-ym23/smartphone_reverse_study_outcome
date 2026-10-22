package com.bytedance.assem.arch.core;

import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.ai.model.viewmodel.RenderStateVM;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b&\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u00022\b\u0012\u0004\u0012\u00020\u00000\u00032\u00020\u00042\u00020\u00052\u00020\u0006B\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/assem/arch/core/UIAssem;", "Lcom/bytedance/assem/arch/core/Assem;", "Lcom/bytedance/assem/arch/viewModel/e;", "Lcom/bytedance/tiktok/proxy/c;", "Lcom/bytedance/tiktok/proxy/a;", "Lcom/bytedance/tiktok/proxy/b;", "", "<init>", "()V", "assem_release"}, k = 1, mv = {1, 4, 0})
public abstract class UIAssem extends Assem implements com.bytedance.assem.arch.viewModel.e<UIAssem>, com.bytedance.tiktok.proxy.c<UIAssem>, com.bytedance.tiktok.proxy.a, com.bytedance.tiktok.proxy.b {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View f192883h;

    @Override // com.bytedance.assem.arch.viewModel.e
    public final void F60() {
    }

    @Override // com.bytedance.assem.arch.viewModel.e
    public final com.bytedance.tiktok.proxy.b NY() {
        return this;
    }

    @Override // com.bytedance.assem.arch.viewModel.e
    public final LifecycleOwner Tm() {
        return this;
    }

    @Override // com.bytedance.tiktok.proxy.b
    public final LifecycleOwner aM() {
        return this;
    }

    @Override // com.bytedance.assem.arch.viewModel.e
    public final /* bridge */ /* synthetic */ com.bytedance.tiktok.proxy.a dh() {
        return null;
    }

    @Override // com.bytedance.assem.arch.viewModel.e
    public final LifecycleOwner fr() {
        return null;
    }

    @Override // com.bytedance.assem.arch.core.Assem
    public void onDestroy() {
    }

    @Override // com.bytedance.tiktok.proxy.c
    public final com.bytedance.tiktok.proxy.a oq() {
        return this;
    }

    public abstract void p();

    @Override // com.bytedance.assem.arch.viewModel.e
    public final com.bytedance.tiktok.proxy.c<UIAssem> pF() {
        return this;
    }

    public abstract void r(View r100);

    public UIAssem() {
    }

    @Override // com.bytedance.assem.arch.core.Assem
    public final void onCreate() {
        p();
    }

    @Override // com.bytedance.assem.arch.viewModel.e
    public final void vT(RenderStateVM r100, com.bytedance.assem.arch.viewModel.i r101, Function1 r102, Function2 r103) {
        com.bytedance.assem.arch.viewModel.e.a.a(this, r100, r101, r102, r103);
    }
}
