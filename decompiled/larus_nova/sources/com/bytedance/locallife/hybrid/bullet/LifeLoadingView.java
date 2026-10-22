package com.bytedance.locallife.hybrid.bullet;

import android.content.Context;
import android.view.View;
import com.bytedance.ies.bullet.service.base.q;
import com.bytedance.locallife.biz.common.ui.LocalLifeLoadingLayout;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class LifeLoadingView implements q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f259061a;

    public static final class a implements View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LifeLoadingView f259062a;

        public a(LifeLoadingView r100) {
            this.f259062a = r100;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r100) {
            Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
            ((LocalLifeLoadingLayout) this.f259062a.f259061a.getValue()).a();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r100) {
            Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
            ((LocalLifeLoadingLayout) this.f259062a.f259061a.getValue()).b();
        }
    }

    @Override // com.bytedance.ies.bullet.service.base.q
    public final View getView() {
        ((LocalLifeLoadingLayout) this.f259061a.getValue()).addOnAttachStateChangeListener(new a(this));
        return (LocalLifeLoadingLayout) this.f259061a.getValue();
    }

    @Override // com.bytedance.ies.bullet.service.base.q
    public final void hide() {
        getView().setVisibility(8);
    }

    @Override // com.bytedance.ies.bullet.service.base.q
    public final void show() {
        getView().setVisibility(0);
    }

    public LifeLoadingView(final Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f259061a = LazyKt.lazy(new LifeLoadingView$view$2(r100));
    }
}
