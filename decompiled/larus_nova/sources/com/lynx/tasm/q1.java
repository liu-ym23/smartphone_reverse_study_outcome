package com.lynx.tasm;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import com.lynx.tasm.event.LynxEventDetail;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.xml.transform.Transformer;

/* JADX INFO: loaded from: classes32.dex */
public abstract class q1 extends p implements com.lynx.tasm.behavior.m {

    public static class a {
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f383564a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f383565b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f383566c;

        public final String toString() {
            return String.format("ViewInfo @%d view %s, name %s, monitor-name %s", new Object[]{Integer.valueOf(hashCode()), this.f383564a.getClass().getSimpleName(), this.f383565b, this.f383566c});
        }

        public b(View r100, String r101, String r102) {
            this.f383564a = r100;
            this.f383565b = r101;
            this.f383566c = r102;
        }
    }

    public void loadImage(Context r100, String r101, String r102, float r103, float r104, Transformer r105, com.lynx.tasm.behavior.m.a r106) {
    }

    public void onCallJSBFinished(Map<String, Object> r100) {
    }

    public void onDataUpdated() {
    }

    public void onDestroy() {
    }

    public void onDynamicComponentPerfReady(HashMap<String, Object> r100) {
    }

    public void onFirstLoadPerfReady(v0 r100) {
    }

    public void onFirstScreen() {
    }

    public void onFling(b r100) {
    }

    public void onFlushFinish(a r100) {
    }

    public void onJSBInvoked(Map<String, Object> r100) {
    }

    public void onKeyEvent(KeyEvent r100, boolean r101) {
    }

    public void onLoadFailed(String r100) {
    }

    public void onLoadSuccess() {
    }

    public void onLynxEvent(LynxEventDetail r100) {
    }

    public void onLynxViewAndJSRuntimeDestroy() {
    }

    @Override // com.lynx.tasm.p
    public void onModuleMethodInvoked(String r100, String r101, int r102) {
    }

    public void onPageStart(String r100) {
    }

    public void onPageUpdate() {
    }

    public void onPiperInvoked(Map<String, Object> r100) {
    }

    @Override // com.lynx.tasm.p
    public void onReceivedError(LynxError r100) {
    }

    public void onReceivedError(String r100) {
    }

    public void onReceivedJSError(LynxError r100) {
    }

    public void onReceivedJavaError(LynxError r100) {
    }

    public void onReceivedNativeError(LynxError r100) {
    }

    public void onReportComponentInfo(Set<String> r100) {
    }

    public void onReportLynxConfigInfo(LynxConfigInfo r100) {
    }

    public void onRuntimeReady() {
    }

    public void onScrollStart(b r100) {
    }

    public void onScrollStop(b r100) {
    }

    public void onTASMFinishedByNative() {
    }

    public void onTemplateBundleReady(TemplateBundle r100) {
    }

    public void onTimingSetup(Map<String, Object> r100) {
    }

    public void onTimingUpdate(Map<String, Object> r100, Map<String, Long> r101, String r102) {
    }

    public void onUpdateDataWithoutChange() {
    }

    public void onUpdatePerfReady(v0 r100) {
    }

    public String shouldRedirectImageUrl(String r100) {
        return null;
    }

    public q1() {
    }
}
