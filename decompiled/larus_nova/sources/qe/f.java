package qe;

import android.view.View;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.livesdkapi.jsb.IExternalAnnieLifecycle;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class f implements IExternalAnnieLifecycle {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final pd.c f532612a;

    @Override // com.bytedance.android.livesdkapi.jsb.IExternalAnnieLifecycle
    public final void onBeforeGlobalPropsInitialize() {
        this.f532612a.onBeforeGlobalPropsInitialize();
    }

    @Override // com.bytedance.android.livesdkapi.jsb.IExternalAnnieLifecycle
    public final void onBeforeInitialPropsInitialize() {
        this.f532612a.onBeforeInitialPropsInitialize();
    }

    @Override // com.bytedance.android.livesdkapi.jsb.IExternalAnnieLifecycle
    public final void onBeforeJsbRegister() {
        this.f532612a.onBeforeJsbRegister();
    }

    @Override // com.bytedance.android.livesdkapi.jsb.IExternalAnnieLifecycle
    public final void onBeforeOpenContainer() {
        this.f532612a.onBeforeOpenContainer();
    }

    @Override // com.bytedance.android.livesdkapi.jsb.IExternalAnnieLifecycle
    public final void onContainerInitEnd() {
        this.f532612a.onContainerInitEnd();
    }

    @Override // com.bytedance.android.livesdkapi.jsb.IExternalAnnieLifecycle
    public final void onContainerInitStart() {
        this.f532612a.onContainerInitStart();
    }

    @Override // com.bytedance.android.livesdkapi.jsb.IExternalAnnieLifecycle
    public final void onGlobalPropsInitialized() {
        this.f532612a.onGlobalPropsInitialized();
    }

    @Override // com.bytedance.android.livesdkapi.jsb.IExternalAnnieLifecycle
    public final void onInitialPropsInitialized() {
        this.f532612a.onInitialPropsInitialized();
    }

    @Override // com.bytedance.android.livesdkapi.jsb.IExternalAnnieLifecycle
    public final void onJsbRegistered() {
        this.f532612a.onJsbRegistered();
    }

    @Override // com.bytedance.android.livesdkapi.jsb.IExternalAnnieLifecycle
    public final void onLynxEnvInitialized() {
        this.f532612a.onLynxEnvInitialized();
    }

    @Override // com.bytedance.android.livesdkapi.jsb.IExternalAnnieLifecycle
    public final void onPrepareComponentEnd() {
        this.f532612a.onPrepareComponentEnd();
    }

    @Override // com.bytedance.android.livesdkapi.jsb.IExternalAnnieLifecycle
    public final void onPrepareComponentStart() {
        this.f532612a.onPrepareComponentStart();
    }

    @Override // com.bytedance.android.livesdkapi.jsb.IExternalAnnieLifecycle
    public final void onPrepareInitDataEnd() {
        this.f532612a.onPrepareInitDataEnd();
    }

    @Override // com.bytedance.android.livesdkapi.jsb.IExternalAnnieLifecycle
    public final void onPrepareTemplateEnd() {
        this.f532612a.onPrepareTemplateEnd();
    }

    @Override // com.bytedance.android.livesdkapi.jsb.IExternalAnnieLifecycle
    public final void onPrepareTemplateStart() {
        this.f532612a.onPrepareTemplateStart();
    }

    @Override // com.bytedance.android.livesdkapi.jsb.IExternalAnnieLifecycle
    public final void onRelease() {
        this.f532612a.onRelease();
    }

    public f(pd.c r100) {
        Intrinsics.checkNotNullParameter(r100, NewBroadcastMonitor.STAGE.LIFECYCLE);
        this.f532612a = r100;
    }

    @Override // com.bytedance.android.livesdkapi.jsb.IExternalAnnieLifecycle
    public final void onBeforeCreateRenderData(View r100) {
        Intrinsics.checkNotNullParameter(r100, "hybridView");
        this.f532612a.onBeforeCreateRenderData(r100);
    }

    @Override // com.bytedance.android.livesdkapi.jsb.IExternalAnnieLifecycle
    public final void onBeforeLynxEnvInitialize(boolean r100) {
        this.f532612a.onBeforeLynxEnvInitialize(r100);
    }

    @Override // com.bytedance.android.livesdkapi.jsb.IExternalAnnieLifecycle
    public final void onLoadSuccess(View r100) {
        this.f532612a.onLoadSuccess(r100);
    }

    @Override // com.bytedance.android.livesdkapi.jsb.IExternalAnnieLifecycle
    public final void onAttachView(View r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "hybridType");
        this.f532612a.onAttachView(r100, r101);
    }

    @Override // com.bytedance.android.livesdkapi.jsb.IExternalAnnieLifecycle
    public final void onCreateRenderData(View r100, Set<String> r101) {
        Intrinsics.checkNotNullParameter(r100, "hybridView");
        Intrinsics.checkNotNullParameter(r101, "stateKeys");
        this.f532612a.onCreateRenderData(r100, r101);
    }

    @Override // com.bytedance.android.livesdkapi.jsb.IExternalAnnieLifecycle
    public final boolean onFallback(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "errorMessage");
        return this.f532612a.onFallback(r100, r101);
    }

    @Override // com.bytedance.android.livesdkapi.jsb.IExternalAnnieLifecycle
    public final void onInnerFallback(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "errorMessage");
        this.f532612a.onInnerFallback(r100, r101);
    }

    @Override // com.bytedance.android.livesdkapi.jsb.IExternalAnnieLifecycle
    public final void onLoadStart(View r100, boolean r101) {
        this.f532612a.onLoadStart(r100, r101);
    }

    @Override // com.bytedance.android.livesdkapi.jsb.IExternalAnnieLifecycle
    public final void onContainerError(View r100, int r101, String r102) {
        Intrinsics.checkNotNullParameter(r102, "errorMessage");
        this.f532612a.onContainerError(r100, r101, r102);
    }

    @Override // com.bytedance.android.livesdkapi.jsb.IExternalAnnieLifecycle
    public final void onLoadFail(View r100, String r101, String r102) {
        this.f532612a.onLoadFail(r100, r101, r102);
    }

    @Override // com.bytedance.android.livesdkapi.jsb.IExternalAnnieLifecycle
    public final void onPrepareInitDataStart(String r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "scheme");
        Intrinsics.checkNotNullParameter(r101, "fallbackUrl");
        this.f532612a.onPrepareInitDataStart(r100, r101, r102);
    }
}
