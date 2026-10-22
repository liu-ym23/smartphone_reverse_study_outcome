package com.bytedance.android.shopping.mall;

import android.view.View;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public class a implements ti.e {
    public final String a;

    public void onContainerError(View r1, int r2, String r3) {
        throw null;
    }

    public void onFallback(int r1, String r2) {
        throw null;
    }

    public void onLoadFail(View r1, String r2, String r3) {
        throw null;
    }

    public void onLoadStart(View r1, boolean r2) {
        throw null;
    }

    public void onLoadSuccess(View r1) {
        throw null;
    }

    public void onBeforeGlobalPropsInitialize() {
        int r0 = e.a;
        e.a(this.a, "onBeforeGlobalPropsInitialize");
    }

    public void onBeforeInitialPropsInitialize() {
        int r0 = e.a;
        e.a(this.a, "onBeforeInitialPropsInitialize");
    }

    public void onBeforeJsbRegister() {
        int r0 = e.a;
        e.a(this.a, "onBeforeJsbRegister");
    }

    public void onBeforeOpenContainer() {
        int r0 = e.a;
        e.a(this.a, "onBeforeOpenContainer");
    }

    public void onContainerInitEnd() {
        int r0 = e.a;
        e.a(this.a, "onContainerInitEnd");
    }

    public void onContainerInitStart() {
        int r0 = e.a;
        e.a(this.a, "onContainerInitStart");
    }

    public void onGlobalPropsInitialized() {
        int r0 = e.a;
        e.a(this.a, "onGlobalPropsInitialized");
    }

    public void onInitialPropsInitialized() {
        int r0 = e.a;
        e.a(this.a, "onInitialPropsInitialized");
    }

    public void onJsbRegistered() {
        int r0 = e.a;
        e.a(this.a, "onJsbRegistered");
    }

    public void onLynxEnvInitialized() {
        int r0 = e.a;
        e.a(this.a, "onLynxEnvInitialized");
    }

    public void onPrepareComponentEnd() {
        int r0 = e.a;
        e.a(this.a, "onPrepareComponentEnd");
    }

    public void onPrepareComponentStart() {
        int r0 = e.a;
        e.a(this.a, "onPrepareComponentStart");
    }

    public void onPrepareInitDataEnd() {
        int r0 = e.a;
        e.a(this.a, "onPrepareInitDataEnd");
    }

    public void onPrepareTemplateEnd() {
        int r0 = e.a;
        e.a(this.a, "onPrepareTemplateEnd");
    }

    public void onPrepareTemplateStart() {
        int r0 = e.a;
        e.a(this.a, "onPrepareTemplateStart");
    }

    public void onRelease() {
        int r0 = e.a;
        e.a(this.a, "onRelease");
    }

    public a() {
        this.a = "AnnieLifecycleAdapter";
    }

    public void onBeforeCreateRenderData(View r2) {
        Intrinsics.checkNotNullParameter(r2, "hybridView");
        int r3 = e.a;
        e.a(this.a, "onBeforeCreateRenderData");
    }

    public void onBeforeLynxEnvInitialize(boolean r2) {
        int r3 = e.a;
        e.a(this.a, "onBeforeLynxEnvInitialize");
    }

    public void onAttachView(View r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, FreqActions.ACTION_VIEW);
        Intrinsics.checkNotNullParameter(r3, "hybridType");
        int r4 = e.a;
        e.a(this.a, "onAttachView");
    }

    public void onCreateRenderData(View r2, Set<String> r3) {
        Intrinsics.checkNotNullParameter(r2, "hybridView");
        Intrinsics.checkNotNullParameter(r3, "stateKeys");
        int r4 = e.a;
        e.a(this.a, "onCreateRenderData");
    }

    public void onInnerFallback(int r4, String r5) {
        Intrinsics.checkNotNullParameter(r5, "errorMessage");
        int r0 = e.a;
        e.a(this.a, "onInnerFallback errorCode=" + r4 + " errorMessage=" + r5);
    }

    public void onPrepareInitDataStart(String r3, String r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r3, "scheme");
        Intrinsics.checkNotNullParameter(r4, "fallbackUrl");
        int r6 = e.a;
        e.a(this.a, "onPrepareInitDataStart fallbaclUrl=" + r4 + " isFallback=" + r5);
    }
}
