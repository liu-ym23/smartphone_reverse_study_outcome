package com.bytedance.android.shopping.mall;

import android.view.View;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b extends a {
    public a b;

    @Override // com.bytedance.android.shopping.mall.a
    public final void onBeforeGlobalPropsInitialize() {
        a r0 = this.b;
        if (r0 == null) goto L6;
        r0.onBeforeGlobalPropsInitialize();
        return;
    }

    @Override // com.bytedance.android.shopping.mall.a
    public final void onBeforeInitialPropsInitialize() {
        a r0 = this.b;
        if (r0 == null) goto L6;
        r0.onBeforeInitialPropsInitialize();
        return;
    }

    @Override // com.bytedance.android.shopping.mall.a
    public final void onBeforeJsbRegister() {
        a r0 = this.b;
        if (r0 == null) goto L6;
        r0.onBeforeJsbRegister();
        return;
    }

    @Override // com.bytedance.android.shopping.mall.a
    public final void onBeforeOpenContainer() {
        a r0 = this.b;
        if (r0 == null) goto L6;
        r0.onBeforeOpenContainer();
        return;
    }

    @Override // com.bytedance.android.shopping.mall.a
    public final void onContainerInitEnd() {
        a r0 = this.b;
        if (r0 == null) goto L6;
        r0.onContainerInitEnd();
        return;
    }

    @Override // com.bytedance.android.shopping.mall.a
    public final void onContainerInitStart() {
        a r0 = this.b;
        if (r0 == null) goto L6;
        r0.onContainerInitStart();
        return;
    }

    @Override // com.bytedance.android.shopping.mall.a
    public final void onGlobalPropsInitialized() {
        a r0 = this.b;
        if (r0 == null) goto L6;
        r0.onGlobalPropsInitialized();
        return;
    }

    @Override // com.bytedance.android.shopping.mall.a
    public final void onInitialPropsInitialized() {
        a r0 = this.b;
        if (r0 == null) goto L6;
        r0.onInitialPropsInitialized();
        return;
    }

    @Override // com.bytedance.android.shopping.mall.a
    public final void onJsbRegistered() {
        a r0 = this.b;
        if (r0 == null) goto L6;
        r0.onJsbRegistered();
        return;
    }

    @Override // com.bytedance.android.shopping.mall.a
    public final void onLynxEnvInitialized() {
        a r0 = this.b;
        if (r0 == null) goto L6;
        r0.onLynxEnvInitialized();
        return;
    }

    @Override // com.bytedance.android.shopping.mall.a
    public final void onPrepareComponentEnd() {
        a r0 = this.b;
        if (r0 == null) goto L6;
        r0.onPrepareComponentEnd();
        return;
    }

    @Override // com.bytedance.android.shopping.mall.a
    public final void onPrepareComponentStart() {
        a r0 = this.b;
        if (r0 == null) goto L6;
        r0.onPrepareComponentStart();
        return;
    }

    @Override // com.bytedance.android.shopping.mall.a
    public final void onPrepareInitDataEnd() {
        a r0 = this.b;
        if (r0 == null) goto L6;
        r0.onPrepareInitDataEnd();
        return;
    }

    @Override // com.bytedance.android.shopping.mall.a
    public final void onPrepareTemplateEnd() {
        a r0 = this.b;
        if (r0 == null) goto L6;
        r0.onPrepareTemplateEnd();
        return;
    }

    @Override // com.bytedance.android.shopping.mall.a
    public final void onPrepareTemplateStart() {
        a r0 = this.b;
        if (r0 == null) goto L6;
        r0.onPrepareTemplateStart();
        return;
    }

    @Override // com.bytedance.android.shopping.mall.a
    public final void onRelease() {
        a r0 = this.b;
        if (r0 == null) goto L6;
        r0.onRelease();
        return;
    }

    public b(LynxMallFragment.a r1) {
        this.b = r1;
    }

    @Override // com.bytedance.android.shopping.mall.a
    public final void onBeforeCreateRenderData(View r2) {
        Intrinsics.checkNotNullParameter(r2, "hybridView");
        a r0 = this.b;
        if (r0 == null) goto L6;
        r0.onBeforeCreateRenderData(r2);
        return;
    }

    @Override // com.bytedance.android.shopping.mall.a
    public final void onBeforeLynxEnvInitialize(boolean r2) {
        a r0 = this.b;
        if (r0 == null) goto L6;
        r0.onBeforeLynxEnvInitialize(r2);
        return;
    }

    @Override // com.bytedance.android.shopping.mall.a
    public final void onLoadSuccess(View r2) {
        a r0 = this.b;
        if (r0 == null) goto L6;
        r0.onLoadSuccess(r2);
        return;
    }

    @Override // com.bytedance.android.shopping.mall.a
    public final void onAttachView(View r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, FreqActions.ACTION_VIEW);
        Intrinsics.checkNotNullParameter(r3, "hybridType");
        a r0 = this.b;
        if (r0 == null) goto L6;
        r0.onAttachView(r2, r3);
        return;
    }

    @Override // com.bytedance.android.shopping.mall.a
    public final void onCreateRenderData(View r2, Set<String> r3) {
        Intrinsics.checkNotNullParameter(r2, "hybridView");
        Intrinsics.checkNotNullParameter(r3, "stateKeys");
        a r0 = this.b;
        if (r0 == null) goto L6;
        r0.onCreateRenderData(r2, r3);
        return;
    }

    @Override // com.bytedance.android.shopping.mall.a
    public final void onFallback(int r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "errorMessage");
        a r0 = this.b;
        if (r0 == null) goto L6;
        r0.onFallback(r2, r3);
        return;
    }

    @Override // com.bytedance.android.shopping.mall.a
    public final void onInnerFallback(int r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "errorMessage");
        a r0 = this.b;
        if (r0 == null) goto L6;
        r0.onInnerFallback(r2, r3);
        return;
    }

    @Override // com.bytedance.android.shopping.mall.a
    public final void onLoadStart(View r2, boolean r3) {
        a r0 = this.b;
        if (r0 == null) goto L6;
        r0.onLoadStart(r2, r3);
        return;
    }

    @Override // com.bytedance.android.shopping.mall.a
    public final void onContainerError(View r2, int r3, String r4) {
        Intrinsics.checkNotNullParameter(r4, "errorMessage");
        a r0 = this.b;
        if (r0 == null) goto L6;
        r0.onContainerError(r2, r3, r4);
        return;
    }

    @Override // com.bytedance.android.shopping.mall.a
    public final void onLoadFail(View r2, String r3, String r4) {
        a r0 = this.b;
        if (r0 == null) goto L6;
        r0.onLoadFail(r2, r3, r4);
        return;
    }

    @Override // com.bytedance.android.shopping.mall.a
    public final void onPrepareInitDataStart(String r2, String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "scheme");
        Intrinsics.checkNotNullParameter(r3, "fallbackUrl");
        a r0 = this.b;
        if (r0 == null) goto L6;
        r0.onPrepareInitDataStart(r2, r3, r4);
        return;
    }
}
