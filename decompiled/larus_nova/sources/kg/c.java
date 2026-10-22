package kg;

import android.view.View;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import ti.e;

/* JADX INFO: loaded from: classes43.dex */
public final class c implements pd.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f503344a;

    @Override // pd.c
    public final void onBeforeGlobalPropsInitialize() {
        this.f503344a.onBeforeGlobalPropsInitialize();
    }

    @Override // pd.c
    public final void onBeforeInitialPropsInitialize() {
        this.f503344a.onBeforeInitialPropsInitialize();
    }

    @Override // pd.c
    public final void onBeforeJsbRegister() {
        this.f503344a.onBeforeJsbRegister();
    }

    @Override // pd.c
    public final void onBeforeOpenContainer() {
        this.f503344a.onBeforeOpenContainer();
    }

    @Override // pd.c
    public final void onContainerInitEnd() {
        this.f503344a.onContainerInitEnd();
    }

    @Override // pd.c
    public final void onContainerInitStart() {
        this.f503344a.onContainerInitStart();
    }

    @Override // pd.c
    public final void onGlobalPropsInitialized() {
        this.f503344a.onGlobalPropsInitialized();
    }

    @Override // pd.c
    public final void onInitialPropsInitialized() {
        this.f503344a.onInitialPropsInitialized();
    }

    @Override // pd.c
    public final void onJsbRegistered() {
        this.f503344a.onJsbRegistered();
    }

    @Override // pd.c
    public final void onLynxEnvInitialized() {
        this.f503344a.onLynxEnvInitialized();
    }

    @Override // pd.c
    public final void onPrepareComponentEnd() {
        this.f503344a.onPrepareComponentEnd();
    }

    @Override // pd.c
    public final void onPrepareComponentStart() {
        this.f503344a.onPrepareComponentStart();
    }

    @Override // pd.c
    public final void onPrepareInitDataEnd() {
        this.f503344a.onPrepareInitDataEnd();
    }

    @Override // pd.c
    public final void onPrepareTemplateEnd() {
        this.f503344a.onPrepareTemplateEnd();
    }

    @Override // pd.c
    public final void onPrepareTemplateStart() {
        this.f503344a.onPrepareTemplateStart();
    }

    @Override // pd.c
    public final void onRelease() {
        this.f503344a.onRelease();
    }

    public c(e r100) {
        Intrinsics.checkNotNullParameter(r100, NewBroadcastMonitor.STAGE.LIFECYCLE);
        this.f503344a = r100;
    }

    @Override // pd.c
    public final void onBeforeCreateRenderData(View r100) {
        Intrinsics.checkNotNullParameter(r100, "hybridView");
        this.f503344a.onBeforeCreateRenderData(r100);
    }

    @Override // pd.c
    public final void onBeforeLynxEnvInitialize(boolean r100) {
        this.f503344a.onBeforeLynxEnvInitialize(r100);
    }

    @Override // pd.c
    public final void onLoadSuccess(View r100) {
        this.f503344a.onLoadSuccess(r100);
    }

    @Override // pd.c
    public final void onAttachView(View r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "hybridType");
        this.f503344a.onAttachView(r100, r101);
    }

    @Override // pd.c
    public final void onCreateRenderData(View r100, Set<String> r101) {
        Intrinsics.checkNotNullParameter(r100, "hybridView");
        Intrinsics.checkNotNullParameter(r101, "stateKeys");
        this.f503344a.onCreateRenderData(r100, r101);
    }

    @Override // pd.c
    public final boolean onFallback(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "errorMessage");
        this.f503344a.onFallback(r100, r101);
        return false;
    }

    @Override // pd.c
    public final void onInnerFallback(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "errorMessage");
        this.f503344a.onInnerFallback(r100, r101);
    }

    @Override // pd.c
    public final void onLoadStart(View r100, boolean r101) {
        this.f503344a.onLoadStart(r100, r101);
    }

    @Override // pd.c
    public final void onContainerError(View r100, int r101, String r102) {
        Intrinsics.checkNotNullParameter(r102, "errorMessage");
        this.f503344a.onContainerError(r100, r101, r102);
    }

    @Override // pd.c
    public final void onLoadFail(View r100, String r101, String r102) {
        this.f503344a.onLoadFail(r100, r101, r102);
    }

    @Override // pd.c
    public final void onPrepareInitDataStart(String r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "scheme");
        Intrinsics.checkNotNullParameter(r101, "fallbackUrl");
        this.f503344a.onPrepareInitDataStart(r100, r101, r102);
    }
}
