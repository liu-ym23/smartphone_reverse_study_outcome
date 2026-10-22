package com.lynx.tasm;

import android.content.Context;
import android.view.KeyEvent;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.event.LynxEventDetail;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.xml.transform.Transformer;

/* JADX INFO: loaded from: classes32.dex */
public class r1 extends q1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArrayList<q1> f383582a;

    @Override // com.lynx.tasm.q1
    public void onFirstLoadPerfReady(v0 r100) {
    }

    @Override // com.lynx.tasm.q1
    public void onUpdatePerfReady(v0 r100) {
    }

    @Override // com.lynx.tasm.q1
    public void onDataUpdated() {
        Iterator<q1> r100 = this.f383582a.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        r100.next().onDataUpdated();
        goto L4
    }

    @Override // com.lynx.tasm.q1
    public void onDestroy() {
        TraceEvent.beginSection("Client.onDestory");
        Iterator<q1> r100 = this.f383582a.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        r100.next().onDestroy();
        goto L4
    L6:
        TraceEvent.endSection("Client.onDestory");
    }

    @Override // com.lynx.tasm.q1
    public void onFirstScreen() {
        TraceEvent.beginSection("Client.onFirstScreen");
        Iterator<q1> r100 = this.f383582a.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        r100.next().onFirstScreen();
        goto L4
    L6:
        TraceEvent.endSection("Client.onFirstScreen");
    }

    @Override // com.lynx.tasm.q1
    public void onLoadSuccess() {
        Iterator<q1> r100 = this.f383582a.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        r100.next().onLoadSuccess();
        goto L4
    }

    @Override // com.lynx.tasm.q1
    public void onLynxViewAndJSRuntimeDestroy() {
        TraceEvent.beginSection("Client.onLynxViewAndJSRuntimeDestroy");
        Iterator<q1> r100 = this.f383582a.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        r100.next().onLynxViewAndJSRuntimeDestroy();
        goto L4
    L6:
        TraceEvent.endSection("Client.onLynxViewAndJSRuntimeDestroy");
    }

    @Override // com.lynx.tasm.q1
    public void onPageUpdate() {
        Iterator<q1> r100 = this.f383582a.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        r100.next().onPageUpdate();
        goto L4
    }

    @Override // com.lynx.tasm.q1
    public void onRuntimeReady() {
        Iterator<q1> r100 = this.f383582a.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        r100.next().onRuntimeReady();
        goto L4
    }

    @Override // com.lynx.tasm.q1
    public void onTASMFinishedByNative() {
        Iterator<q1> r100 = this.f383582a.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        r100.next().onTASMFinishedByNative();
        goto L4
    }

    @Override // com.lynx.tasm.q1
    public void onUpdateDataWithoutChange() {
        Iterator<q1> r100 = this.f383582a.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        r100.next().onUpdateDataWithoutChange();
        goto L4
    }

    public r1() {
        this.f383582a = new CopyOnWriteArrayList();
    }

    public final void a(q1 r100) {
        if (this.f383582a.contains(r100) == true) goto L6;
        this.f383582a.add(r100);
        return;
    }

    @Override // com.lynx.tasm.q1
    public void onCallJSBFinished(Map<String, Object> r100) {
        Iterator<q1> r101 = this.f383582a.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().onCallJSBFinished(r100);
        goto L4
    }

    @Override // com.lynx.tasm.q1
    public void onDynamicComponentPerfReady(HashMap<String, Object> r100) {
        Iterator<q1> r101 = this.f383582a.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().onDynamicComponentPerfReady(r100);
        goto L4
    }

    @Override // com.lynx.tasm.q1
    public void onFling(q1.b r100) {
        TraceEvent.beginSection("Client.onFling");
        Iterator<q1> r101 = this.f383582a.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().onFling(r100);
        goto L4
    L6:
        TraceEvent.endSection("Client.onFling");
    }

    @Override // com.lynx.tasm.q1
    public void onFlushFinish(q1.a r100) {
        Iterator<q1> r101 = this.f383582a.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().onFlushFinish(null);
        goto L4
    }

    @Override // com.lynx.tasm.q1
    public void onJSBInvoked(Map<String, Object> r100) {
        Iterator<q1> r101 = this.f383582a.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().onJSBInvoked(r100);
        goto L4
    }

    @Override // com.lynx.tasm.q1
    public void onLoadFailed(String r100) {
        Iterator<q1> r101 = this.f383582a.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().onLoadFailed(r100);
        goto L4
    }

    @Override // com.lynx.tasm.q1
    public void onLynxEvent(LynxEventDetail r100) {
        Iterator<q1> r101 = this.f383582a.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().onLynxEvent(r100);
        goto L4
    }

    @Override // com.lynx.tasm.q1
    public void onPageStart(String r100) {
        Iterator<q1> r101 = this.f383582a.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().onPageStart(r100);
        goto L4
    }

    @Override // com.lynx.tasm.q1
    public void onPiperInvoked(Map<String, Object> r100) {
        TraceEvent.beginSection("Client.onPiperInvoked");
        Iterator<q1> r101 = this.f383582a.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().onPiperInvoked(r100);
        goto L4
    L6:
        TraceEvent.endSection("Client.onPiperInvoked");
    }

    @Override // com.lynx.tasm.q1, com.lynx.tasm.p
    public void onReceivedError(LynxError r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.getMsg() == null) goto L12;
        Iterator<q1> r101 = this.f383582a.iterator();
    L8:
        if (r101.hasNext() == false) goto L13;
        r101.next().onReceivedError(r100);
        goto L8
    L13:
        return;
    }

    @Override // com.lynx.tasm.q1
    public void onReceivedJSError(LynxError r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.getMsg() == null) goto L12;
        Iterator<q1> r101 = this.f383582a.iterator();
    L8:
        if (r101.hasNext() == false) goto L13;
        r101.next().onReceivedJSError(r100);
        goto L8
    L13:
        return;
    }

    @Override // com.lynx.tasm.q1
    public void onReceivedJavaError(LynxError r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.getMsg() == null) goto L12;
        Iterator<q1> r101 = this.f383582a.iterator();
    L8:
        if (r101.hasNext() == false) goto L13;
        r101.next().onReceivedJavaError(r100);
        goto L8
    L13:
        return;
    }

    @Override // com.lynx.tasm.q1
    public void onReceivedNativeError(LynxError r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.getMsg() == null) goto L12;
        Iterator<q1> r101 = this.f383582a.iterator();
    L8:
        if (r101.hasNext() == false) goto L13;
        r101.next().onReceivedNativeError(r100);
        goto L8
    L13:
        return;
    }

    @Override // com.lynx.tasm.q1
    public void onReportComponentInfo(Set<String> r100) {
        Iterator<q1> r101 = this.f383582a.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().onReportComponentInfo(r100);
        goto L4
    }

    @Override // com.lynx.tasm.q1
    public void onScrollStart(q1.b r100) {
        TraceEvent.beginSection("Client.onScrollStart");
        Iterator<q1> r101 = this.f383582a.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().onScrollStart(r100);
        goto L4
    L6:
        TraceEvent.endSection("Client.onScrollStart");
    }

    @Override // com.lynx.tasm.q1
    public void onScrollStop(q1.b r100) {
        TraceEvent.beginSection("Client.onScrollStop");
        Iterator<q1> r101 = this.f383582a.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().onScrollStop(r100);
        goto L4
    L6:
        TraceEvent.endSection("Client.onScrollStop");
    }

    @Override // com.lynx.tasm.q1
    public void onTemplateBundleReady(TemplateBundle r100) {
        Iterator<q1> r101 = this.f383582a.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().onTemplateBundleReady(r100);
        goto L4
    }

    @Override // com.lynx.tasm.q1
    public void onTimingSetup(Map<String, Object> r100) {
        TraceEvent.beginSection("Client.onTimingSetup");
        Iterator<q1> r101 = this.f383582a.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().onTimingSetup(r100);
        goto L4
    L6:
        TraceEvent.endSection("Client.onTimingSetup");
    }

    @Override // com.lynx.tasm.q1, com.lynx.tasm.behavior.m
    public String shouldRedirectImageUrl(String r100) {
        Iterator<q1> r101 = this.f383582a.iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        String r102 = r101.next().shouldRedirectImageUrl(r100);
        if (r102 == null) goto L4;
        return r102;
    L8:
        return null;
    }

    @Override // com.lynx.tasm.q1
    public void onReceivedError(String r100) {
        Iterator<q1> r101 = this.f383582a.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().onReceivedError(r100);
        goto L4
    }

    @Override // com.lynx.tasm.q1
    public void onKeyEvent(KeyEvent r100, boolean r101) {
        Iterator<q1> r102 = this.f383582a.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r102.next().onKeyEvent(r100, r101);
        goto L4
    }

    @Override // com.lynx.tasm.q1, com.lynx.tasm.p
    public void onModuleMethodInvoked(String r100, String r101, int r102) {
        Iterator<q1> r103 = this.f383582a.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        r103.next().onModuleMethodInvoked(r100, r101, r102);
        goto L4
    }

    @Override // com.lynx.tasm.q1
    public void onTimingUpdate(Map<String, Object> r100, Map<String, Long> r101, String r102) {
        TraceEvent.beginSection("Client.onTimingUpdate");
        Iterator<q1> r103 = this.f383582a.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        r103.next().onTimingUpdate(r100, r101, r102);
        goto L4
    L6:
        TraceEvent.endSection("Client.onTimingUpdate");
    }

    @Override // com.lynx.tasm.q1, com.lynx.tasm.behavior.m
    public void loadImage(Context r110, String r111, String r112, float r113, float r114, Transformer r115, com.lynx.tasm.behavior.m.a r116) {
        Iterator<q1> r100 = this.f383582a.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        r100.next().loadImage(r110, r111, r112, r113, r114, r115, r116);
        goto L4
    }
}
