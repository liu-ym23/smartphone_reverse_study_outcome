package com.lynx.rts.gen;

import mpa.f;
import mpa.h;
import mpa.i;
import s87.g;

/* JADX INFO: loaded from: classes32.dex */
public class RendererFunctionNG {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f381464a;

    private native void nativeAddEventListener(long r100, String r101, CommonCallbackNG r102);

    private native void nativeAdoptStyleSheet(long r100);

    private native Object nativeBridgeInvoke(long r100, String r101, String r102, Object r103, BridgeCallback r104, BridgeCallback r105);

    private native void nativeCancelAnimationFrame(long r100, long r101);

    private native void nativeClearTimeInterval(long r100, long r101);

    private native void nativeClearTimeout(long r100, long r101);

    private native long nativeCreate(long r100);

    private native void nativeDestroy(long r100);

    private native void nativeElementAnimate(long r100, long r101, Object[] r102);

    private native void nativeEnableStaticPageDirectMode(long r100);

    private native void nativeFiberAddClass(long r100, long r101, String r102);

    private native void nativeFiberAddConfig(long r100, long r101, String r102, Object r103);

    private native void nativeFiberAddDataset(long r100, long r101, String r102, Object r103);

    private native void nativeFiberAddEventListener(long r100, long r101, String r102, CommonCallbackNG r103, FiberEventListenerOption r104);

    private native void nativeFiberAddInlineStyle(long r100, long r101, Object r102, Object r103);

    private native long nativeFiberAppendElement(long r100, long r101, long r102);

    private native void nativeFiberAsyncResolveElement(long r100, long r101);

    private native void nativeFiberAsyncResolveSubtreeProperty(long r100, long r101);

    private native long nativeFiberCloneElement(long r100, long r101, Object r102);

    private native void nativeFiberConsumeGesture(long r100, long r101, long r102, ConsumeGestureOption r103);

    private native long nativeFiberCreateBlock(long r100, long r101, Object r102);

    private native long nativeFiberCreateComponent(long r100, long r101, String r102, long r103, String r104, String r105, String r110, Object r111);

    private native long nativeFiberCreateElement(long r100, String r101, long r102);

    private native long[] nativeFiberCreateElementWithProperties(long r100, int r101, Object r102, Object r103);

    private native long nativeFiberCreateFor(long r100, long r101, Object r102);

    private native long[] nativeFiberCreateFrame(long r100, long r101, FiberCreateFrameOption r102);

    private native long nativeFiberCreateIf(long r100, long r101, Object r102);

    private native long nativeFiberCreateImage(long r100, long r101);

    private native long nativeFiberCreateList(long r100, int r101, ComponentAtIndexCallbackNG r102, EnqueueComponentCallbackNG r103, Object r104, ComponentAtIndexesCallbackNG r105);

    private native long nativeFiberCreateNonElement(long r100, long r101);

    private native long nativeFiberCreatePage(long r100, String r101, long r102);

    private native long nativeFiberCreateRawText(long r100, String r101);

    private native long nativeFiberCreateScrollView(long r100, long r101, Object r102);

    private native long nativeFiberCreateText(long r100, long r101, Object r102);

    private native long nativeFiberCreateView(long r100, long r101);

    private native long nativeFiberCreateWrapperElement(long r100, long r101, Object r102);

    private native long[] nativeFiberElementFromBinary(long r100, String r101, long r102, String r103);

    private native void nativeFiberElementFromBinaryAsync(long r100);

    private native long nativeFiberElementIsEqual(long r100, long r101, long r102);

    private native long nativeFiberFirstElement(long r100, long r101);

    private native void nativeFiberFlushElementTree(long r100, long r101, Object r102);

    private native void nativeFiberFreeValue(long r100, long r101);

    private native Object nativeFiberGetAttributeByName(long r100, long r101, String r102);

    private native String[] nativeFiberGetAttributeNames(long r100, long r101);

    private native Object nativeFiberGetAttributes(long r100, long r101);

    private native long[] nativeFiberGetChildren(long r100, long r101);

    private native String[] nativeFiberGetClasses(long r100, long r101);

    private native String nativeFiberGetComponentID(long r100, long r101);

    private native Object nativeFiberGetComputedStyleByKey(long r100, long r101, String r102);

    private native void nativeFiberGetComputedStyles(long r100);

    private native Object nativeFiberGetDataByKey(long r100, long r101, String r102);

    private native Object nativeFiberGetDataset(long r100, long r101);

    private native long[] nativeFiberGetElementByUniqueID(long r100, long r101);

    private native Object nativeFiberGetElementConfig(long r100, long r101);

    private native long nativeFiberGetElementUniqueID(long r100, long r101);

    private native String nativeFiberGetID(long r100, long r101);

    private native Object nativeFiberGetInlineStyle(long r100, long r101, long r102);

    private native String nativeFiberGetInlineStyles(long r100, long r101);

    private native long nativeFiberGetPageElement(long r100);

    private native long nativeFiberGetParent(long r100, long r101);

    private native String nativeFiberGetTag(long r100, long r101);

    private native Object nativeFiberGetTemplateParts(long r100, long r101);

    private native long nativeFiberInsertElementBefore(long r100, long r101, long r102, long r103);

    private native boolean nativeFiberIsPartElement(long r100, long r101);

    private native boolean nativeFiberIsTemplateElement(long r100, long r101);

    private native long nativeFiberLastElement(long r100, long r101);

    private native void nativeFiberMarkAsyncResolveRoot(long r100, long r101);

    private native void nativeFiberMarkPartElement(long r100, long r101, String r102);

    private native void nativeFiberMarkTemplateElement(long r100, long r101);

    private native long nativeFiberNextElement(long r100, long r101);

    private native void nativeFiberOnLifecycleEvent(long r100, Object r101);

    private native Object nativeFiberQueryComponent(long r100, String r101, CommonCallbackNG r102);

    private native long nativeFiberQuerySelector(long r100, long r101, String r102, Object r103);

    private native long[] nativeFiberQuerySelectorAll(long r100, long r101, String r102, Object r103);

    private native long nativeFiberRemoveElement(long r100, long r101, long r102);

    private native void nativeFiberRemoveEventListener(long r100, long r101, String r102, CommonCallbackNG r103, FiberEventListenerOption r104);

    private native void nativeFiberRemoveGestureDetector(long r100, long r101, long r102);

    private native long nativeFiberReplaceElement(long r100, long r101, long r102);

    private native void nativeFiberReplaceElements(long r100, long r101, long[] r102, long[] r103);

    private native void nativeFiberSetAttribute(long r100, long r101, Object r102, Object r103);

    private native void nativeFiberSetCSSId(long r100, long[] r101, long r102, String r103);

    private native void nativeFiberSetClasses(long r100, long r101, String r102);

    private native void nativeFiberSetConfig(long r100, long r101, Object r102);

    private native void nativeFiberSetDataset(long r100, long r101, Object r102);

    private native void nativeFiberSetGestureDetector(long r100, long r101, long r102, int r103, Object r104, Object r105, Object[] r110, CommonCallbackNG r111);

    private native void nativeFiberSetGestureState(long r100, long r101, long r102, int r103);

    private native void nativeFiberSetID(long r100, long r101, String r102);

    private native void nativeFiberSetInlineStyles(long r100, long r101, Object r102);

    private native void nativeFiberSetParsedStyles(long r100, long r101, String r102, Object r103);

    private native void nativeFiberSetStringAttribute(long r100, long r101, String r102, String r103);

    private native void nativeFiberStopImmediatePropagation(long r100, long r101);

    private native void nativeFiberStopPropagation(long r100, long r101);

    private native long nativeFiberSwapElement(long r100, long r101, long r102);

    private native void nativeFiberUpdateComponentID(long r100, long r101, String r102);

    private native void nativeFiberUpdateComponentInfo(long r100);

    private native Object nativeFiberUpdateForChildCount(long r100, long r101, int r102);

    private native Object nativeFiberUpdateIfNodeIndex(long r100, long r101, int r102);

    private native void nativeFiberUpdateListCallbacks(long r100, long r101, ComponentAtIndexCallbackNG r102, EnqueueComponentCallbackNG r103, ComponentAtIndexesCallbackNG r104);

    private native void nativeFilterI18nResource(long r100, Object r101);

    private native Object nativeGeneratePipelineOptions(long r100);

    private native Object nativeGetGlobalProps(long r100);

    private native int nativeGetInstanceId(long r100);

    private native Object nativeGetSessionStorageItem(long r100, String r101);

    private native Object nativeGetSystemInfo(long r100);

    private native Object nativeI18nResourceTranslation(long r100, Object r101);

    private native void nativeInvokeUIMethod(long r100, long r101, String r102, Object r103, CommonCallbackNG r104);

    private native boolean nativeIsProfileRecording(long r100);

    private native boolean[] nativeLoadLepusChunk(long r100, String r101, LoadLepusChunkOption r102);

    private native void nativeLoadStyleSheet(long r100, String r101, String r102);

    private native void nativeMarkPipelineTiming(long r100, String r101, String r102);

    private native void nativeOnPipelineStart(long r100, String r101, String r102);

    private native void nativeProfileEnd(long r100);

    private native int nativeProfileFlowId(long r100);

    private native void nativeProfileMark(long r100, String r101, Object r102);

    private native void nativeProfileStart(long r100, String r101, Object r102);

    private native void nativeReplaceStyleSheets(long r100);

    private native void nativeReportError(long r100, RendererError r101, ErrorOption r102);

    private native long nativeRequestAnimationFrame(long r100, CommonCallbackNG r101);

    private native long nativeRequestFrameCommitCallback(long r100, CommonCallbackNG r101);

    private native void nativeRuntimeAddEventListener(long r100, String r101, CommonCallbackNG r102, int r103);

    private native void nativeRuntimeDispatchEvent(long r100, RuntimeDispatchEventOption r101, int r102);

    private native void nativeRuntimeRemoveEventListener(long r100, String r101, CommonCallbackNG r102, int r103);

    private native void nativeSendGlobalEvent(long r100, String r101, Object r102);

    private native void nativeSetDynamicStyleObject(long r100, long r101, Object r102);

    private native void nativeSetDynamicStyleObjectKV(long r100, long r101, int r102, Object r103);

    private native void nativeSetDynamicStyleString(long r100, long r101, String r102);

    private native long nativeSetInterval(long r100, CommonCallbackNG r101, long r102);

    private native void nativeSetSessionStorageItem(long r100, String r101, Object r102);

    private native void nativeSetSourceMapRelease(long r100, RendererError r101);

    private native void nativeSetStyleObject(long r100, long r101, String r102);

    private native long nativeSetTimeout(long r100, CommonCallbackNG r101, long r102);

    private native void nativeSubscribeSessionStorage(long r100, String r101, int r102, CommonCallbackNG r103);

    private native void nativeUnsubscribeSessionStorage(long r100, String r101, int r102);

    public final synchronized void e() {
        monitor-enter(this);
        long r100 = this.f381464a;     // Catch: Throwable -> L11
        if (r100 != 0) goto L8;
        monitor-exit(this);
        return;
    L8:
        this.f381464a = 0;     // Catch: Throwable -> L11
        nativeDestroy(r100);     // Catch: Throwable -> L11
        monitor-exit(this);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public final Object B() {
        return nativeGeneratePipelineOptions(this.f381464a);
    }

    public final Object C() {
        return nativeGetGlobalProps(this.f381464a);
    }

    public final int D() {
        return nativeGetInstanceId(this.f381464a);
    }

    public final void f() {
        nativeEnableStaticPageDirectMode(this.f381464a);
    }

    public final long j() {
        return nativeFiberCreatePage(this.f381464a, "page", 0);
    }

    public RendererFunctionNG() {
        this.f381464a = 0;
    }

    public RendererFunctionNG(long r100) {
        this.f381464a = 0;
        this.f381464a = nativeCreate(r100);
    }

    public final long H(CommonCallbackNG r100) {
        return nativeRequestAnimationFrame(this.f381464a, r100);
    }

    public final long I(CommonCallbackNG r100) {
        return nativeRequestFrameCommitCallback(this.f381464a, r100);
    }

    public final void b(long r100) {
        nativeCancelAnimationFrame(this.f381464a, r100);
    }

    public final void c(long r100) {
        nativeClearTimeInterval(this.f381464a, r100);
    }

    public final void d(long r100) {
        nativeClearTimeout(this.f381464a, r100);
    }

    public final long k(String r100) {
        return nativeFiberCreateRawText(this.f381464a, r100);
    }

    public final long l(long r100) {
        return nativeFiberCreateText(this.f381464a, r100, null);
    }

    public final long m(long r100) {
        return nativeFiberCreateView(this.f381464a, r100);
    }

    public final void p(long r100) {
        nativeFiberFreeValue(this.f381464a, r100);
    }

    public final long q(long r100) {
        return nativeFiberGetElementUniqueID(this.f381464a, r100);
    }

    public final void F(String r100, String r101) {
        nativeMarkPipelineTiming(this.f381464a, r100, r101);
    }

    public final void G(String r100, String r101) {
        nativeOnPipelineStart(this.f381464a, r100, r101);
    }

    public final void L(long r100, String r101) {
        nativeSetStyleObject(this.f381464a, r100, r101);
    }

    public final long M(CommonCallbackNG r100, long r101) {
        return nativeSetTimeout(this.f381464a, r100, r101);
    }

    public final void h(long r100, long r110) {
        nativeFiberAppendElement(this.f381464a, r100, r110);
    }

    public final long i(String r100, long r101) {
        return nativeFiberCreateElement(this.f381464a, r100, r101);
    }

    public final long n(long r100, Object r101) {
        return nativeFiberCreateWrapperElement(this.f381464a, r100, r101);
    }

    public final void o(long r100, Object r101) {
        nativeFiberFlushElementTree(this.f381464a, r100, r101);
    }

    public final void t(long r100, long r110) {
        nativeFiberRemoveElement(this.f381464a, r100, r110);
    }

    public final void v(long r100, long r110) {
        nativeFiberRemoveGestureDetector(this.f381464a, r100, r110);
    }

    public final void w(long r100, long r110) {
        nativeFiberReplaceElement(this.f381464a, r100, r110);
    }

    public final void y(long r100, String r101) {
        nativeFiberSetID(this.f381464a, r100, r101);
    }

    public final void E(long r100, Object r110, g r111) {
        nativeInvokeUIMethod(this.f381464a, r100, "setValue", r110, r111);
    }

    public final void J(String r100, CommonCallbackNG r101, int r102) {
        nativeRuntimeAddEventListener(this.f381464a, r100, r101, r102);
    }

    public final void K(String r100, CommonCallbackNG r101, int r102) {
        nativeRuntimeRemoveEventListener(this.f381464a, r100, r101, r102);
    }

    public final void r(long r110, long r111, long r112) {
        nativeFiberInsertElementBefore(this.f381464a, r110, r111, r112);
    }

    public final long s(long r100, String r110, Object r111) {
        return nativeFiberQuerySelector(this.f381464a, r100, r110, r111);
    }

    public final void x(long r100, Object r110, Object r111) {
        nativeFiberSetAttribute(this.f381464a, r100, r110, r111);
    }

    public final void z(long r100, String r110, String r111) {
        nativeFiberSetStringAttribute(this.f381464a, r100, r110, r111);
    }

    public final void A(long r100, h r110, i r111, f r112) {
        nativeFiberUpdateListCallbacks(this.f381464a, r100, r110, r111, r112);
    }

    public final void g(long r100, String r110, CommonCallbackNG r111, FiberEventListenerOption r112) {
        nativeFiberAddEventListener(this.f381464a, r100, r110, r111, r112);
    }

    public final void u(long r100, String r110, CommonCallbackNG r111, FiberEventListenerOption r112) {
        nativeFiberRemoveEventListener(this.f381464a, r100, r110, r111, r112);
    }

    public final Object a(String r100, String r110, Object r111, BridgeCallback r112, BridgeCallback r113) {
        return nativeBridgeInvoke(this.f381464a, r100, r110, r111, r112, r113);
    }
}
