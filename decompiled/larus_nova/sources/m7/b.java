package m7;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import com.bytedance.android.annie.param.AnnieXLiveContext;
import com.lynx.tasm.LynxConfigInfo;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.behavior.m;
import com.lynx.tasm.event.LynxEventDetail;
import com.lynx.tasm.q1;
import com.lynx.tasm.v0;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.xml.transform.Transformer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class b extends q1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AnnieXLiveContext f512315a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final q1 f512316b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b7.b f512317c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ia.c f512318d;

    public static final class a {
    }

    static {
    }

    @Override // com.lynx.tasm.q1
    public final void onDataUpdated() {
        super.onDataUpdated();
        this.f512316b.onDataUpdated();
    }

    @Override // com.lynx.tasm.q1
    public final void onDestroy() {
        super.onDestroy();
        this.f512316b.onDestroy();
    }

    @Override // com.lynx.tasm.q1
    public final void onFirstScreen() {
        super.onFirstScreen();
        this.f512316b.onFirstScreen();
        b7.b r100 = this.f512317c;
        if (r100 == null) goto L6;
        r100.onLynxFirstScreen();
        return;
    }

    @Override // com.lynx.tasm.q1
    public final void onLoadSuccess() {
        super.onLoadSuccess();
        this.f512316b.onLoadSuccess();
    }

    @Override // com.lynx.tasm.q1
    public final void onLynxViewAndJSRuntimeDestroy() {
        super.onLynxViewAndJSRuntimeDestroy();
        this.f512316b.onLynxViewAndJSRuntimeDestroy();
    }

    @Override // com.lynx.tasm.q1
    public final void onPageUpdate() {
        super.onPageUpdate();
        this.f512316b.onPageUpdate();
    }

    @Override // com.lynx.tasm.q1
    public final void onRuntimeReady() {
        super.onRuntimeReady();
        this.f512316b.onRuntimeReady();
        b7.b r100 = this.f512317c;
        if (r100 == null) goto L10;
        ia.c r101 = this.f512318d;
        if (r101 == null) goto L7;
        View r102 = r101.getKitView();
    L8:
        r100.onLoadSuccess(r102);
        return;
    L7:
        r102 = null;
        goto L8
    }

    @Override // com.lynx.tasm.q1
    public final void onUpdateDataWithoutChange() {
        super.onUpdateDataWithoutChange();
        this.f512316b.onUpdateDataWithoutChange();
    }

    @Override // com.lynx.tasm.q1
    public final void onCallJSBFinished(Map<String, Object> r100) {
        super.onCallJSBFinished(r100);
        this.f512316b.onCallJSBFinished(r100);
    }

    @Override // com.lynx.tasm.q1
    public final void onDynamicComponentPerfReady(HashMap<String, Object> r100) {
        super.onDynamicComponentPerfReady(r100);
        this.f512316b.onDynamicComponentPerfReady(r100);
    }

    @Override // com.lynx.tasm.q1
    public final void onFirstLoadPerfReady(v0 r100) {
        super.onFirstLoadPerfReady(r100);
        this.f512316b.onFirstLoadPerfReady(r100);
    }

    @Override // com.lynx.tasm.q1
    public final void onFling(q1.b r100) {
        super.onFling(r100);
        this.f512316b.onFling(r100);
    }

    @Override // com.lynx.tasm.q1
    public final void onFlushFinish(q1.a r100) {
        super.onFlushFinish(null);
        this.f512316b.onFlushFinish(null);
    }

    @Override // com.lynx.tasm.q1
    public final void onJSBInvoked(Map<String, Object> r100) {
        super.onJSBInvoked(r100);
        this.f512316b.onJSBInvoked(r100);
    }

    @Override // com.lynx.tasm.q1
    public final void onLoadFailed(String r100) {
        super.onLoadFailed(r100);
        this.f512316b.onLoadFailed(r100);
        b7.b r101 = this.f512317c;
        if (r101 == null) goto L13;
        ia.c r102 = this.f512318d;
        String r103 = null;
        if (r102 == null) goto L7;
        View r104 = r102.getKitView();
    L8:
        AnnieXLiveContext r105 = this.f512315a;
        if (r105 == null) goto L11;
        r103 = r105.getUrl();
    L11:
        r101.onLoadFail(r104, String.valueOf(r103), r100);
        return;
    L7:
        r104 = null;
        goto L8
    }

    @Override // com.lynx.tasm.q1
    public final void onLynxEvent(LynxEventDetail r100) {
        super.onLynxEvent(r100);
        this.f512316b.onLynxEvent(r100);
    }

    @Override // com.lynx.tasm.q1
    public final void onPageStart(String r100) {
        super.onPageStart(r100);
        this.f512316b.onPageStart(r100);
        b7.b r101 = this.f512317c;
        if (r101 == null) goto L6;
        r101.onLoadStart(null, false);
        return;
    }

    @Override // com.lynx.tasm.q1
    public final void onPiperInvoked(Map<String, Object> r100) {
        super.onPiperInvoked(r100);
        this.f512316b.onPiperInvoked(r100);
    }

    @Override // com.lynx.tasm.q1, com.lynx.tasm.p
    public final void onReceivedError(LynxError r100) {
        super.onReceivedError(r100);
        this.f512316b.onReceivedError(r100);
    }

    @Override // com.lynx.tasm.q1
    public final void onReceivedJSError(LynxError r100) {
        super.onReceivedJSError(r100);
        this.f512316b.onReceivedJSError(r100);
    }

    @Override // com.lynx.tasm.q1
    public final void onReceivedJavaError(LynxError r100) {
        super.onReceivedJavaError(r100);
        this.f512316b.onReceivedJavaError(r100);
    }

    @Override // com.lynx.tasm.q1
    public final void onReceivedNativeError(LynxError r100) {
        super.onReceivedNativeError(r100);
        this.f512316b.onReceivedNativeError(r100);
    }

    @Override // com.lynx.tasm.q1
    public final void onReportComponentInfo(Set<String> r100) {
        super.onReportComponentInfo(r100);
        this.f512316b.onReportComponentInfo(r100);
    }

    @Override // com.lynx.tasm.q1
    public final void onReportLynxConfigInfo(LynxConfigInfo r100) {
        super.onReportLynxConfigInfo(r100);
        this.f512316b.onReportLynxConfigInfo(r100);
    }

    @Override // com.lynx.tasm.q1
    public final void onScrollStart(q1.b r100) {
        super.onScrollStart(r100);
        this.f512316b.onScrollStart(r100);
    }

    @Override // com.lynx.tasm.q1
    public final void onScrollStop(q1.b r100) {
        super.onScrollStop(r100);
        this.f512316b.onScrollStop(r100);
    }

    @Override // com.lynx.tasm.q1
    public final void onTimingSetup(Map<String, Object> r100) {
        super.onTimingSetup(r100);
        this.f512316b.onTimingSetup(r100);
    }

    @Override // com.lynx.tasm.q1
    public final void onUpdatePerfReady(v0 r100) {
        super.onUpdatePerfReady(r100);
        this.f512316b.onUpdatePerfReady(r100);
    }

    @Override // com.lynx.tasm.q1, com.lynx.tasm.behavior.m
    public final String shouldRedirectImageUrl(String r100) {
        this.f512316b.shouldRedirectImageUrl(r100);
        return super.shouldRedirectImageUrl(r100);
    }

    @Override // com.lynx.tasm.q1
    public final void onReceivedError(String r100) {
        super.onReceivedError(r100);
        this.f512316b.onReceivedError(r100);
    }

    public b(AnnieXLiveContext r100, q1 r101) {
        Intrinsics.checkNotNullParameter(r101, "lynxViewClient");
        this.f512315a = r100;
        this.f512316b = r101;
        if (r100 == null) goto L5;
        b7.b r102 = r100.getCommonLifecycle();
    L6:
        this.f512317c = r102;
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.lynx.tasm.q1
    public final void onKeyEvent(KeyEvent r100, boolean r101) {
        super.onKeyEvent(r100, r101);
        this.f512316b.onKeyEvent(r100, r101);
    }

    @Override // com.lynx.tasm.q1, com.lynx.tasm.p
    public final void onModuleMethodInvoked(String r100, String r101, int r102) {
        super.onModuleMethodInvoked(r100, r101, r102);
        this.f512316b.onModuleMethodInvoked(r100, r101, r102);
    }

    @Override // com.lynx.tasm.q1
    public final void onTimingUpdate(Map<String, Object> r100, Map<String, Long> r101, String r102) {
        super.onTimingUpdate(r100, r101, r102);
        this.f512316b.onTimingUpdate(r100, r101, r102);
    }

    @Override // com.lynx.tasm.q1, com.lynx.tasm.behavior.m
    public final void loadImage(Context r110, String r111, String r112, float r113, float r114, Transformer r115, m.a r116) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r116, "handler");
        super.loadImage(r110, r111, r112, r113, r114, r115, r116);
        this.f512316b.loadImage(r110, r111, r112, r113, r114, r115, r116);
    }
}
