package com.relax.runtime.gen;

import androidx.camera.video.AudioStats;
import com.relax.relaxframework.PipelineOptions;
import com.relax.relaxframework.f4;
import com.relax.relaxframework.g4;
import com.relax.relaxframework.g5;
import com.relax.relaxframework.k5;
import java.util.ArrayList;
import spa.a;

/* JADX INFO: loaded from: classes34.dex */
public class RendererFunction {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f405695a;

    private native void nativeAddEventListener(long r100, long r101, String r102, int r103, CommonCallback r104, String r105);

    private native void nativeAddEventListenerByName(long r100, long r101, String r102, String r103, CommonCallback r104, String r105);

    private native void nativeAnchoring(long r100, long r101, String r102, int r103, double r104, int r105, double r110, int r111);

    private native long nativeAppendClonedElement(long r100, long r101, long r102);

    private native long nativeAppendElement(long r100, long r101, long r102);

    private native void nativeBatchSetKeyFramesPropertyBoxShadow(long r100, int r101, int[] r102, Object[] r103, Object[] r104);

    private native void nativeBatchSetKeyFramesPropertyFilter(long r100, int r101, int[] r102, Object[] r103, Object[] r104);

    private native void nativeBatchSetKeyFramesPropertyTransform(long r100, int r101, int[] r102, Object[] r103, Object[] r104);

    private native void nativeBatchSetModifierPropertyNum(long r100, int r101, int[] r102, double[] r103, int[] r104);

    private native void nativeBatchSetNumAttribute(long r100, long r101, int[] r102, double[] r103, int[] r104);

    private native void nativeBatchSetNumAttributeByName(long r100, long r101, Object[] r102, double[] r103, int[] r104);

    private native void nativeBatchSetStringAttribute(long r100, long r101, int[] r102, Object[] r103);

    private native void nativeBatchSetStringAttributeByName(long r100, long r101, Object[] r102, Object[] r103);

    private native void nativeCancelAnchoring(long r100, long r101, String r102);

    private native long nativeCloneElement(long r100, long r101, boolean r102, boolean r103);

    private native void nativeConsumeGesture(long r100, long r101, int r102, Object r103);

    private native long nativeCreate(long r100);

    private native void nativeCreateAnchor(long r100, long r101, String r102);

    private native long nativeCreateAnimaxView(long r100);

    private native long nativeCreateAudio(long r100);

    private native long nativeCreateCamera(long r100);

    private native long nativeCreateCanvas(long r100);

    private native long nativeCreateColumn(long r100);

    private native long nativeCreateContainerElement(long r100, String r101);

    private native long nativeCreateElement(long r100, String r101);

    private native long nativeCreateFlex(long r100);

    private native void nativeCreateFlexModifier(long r100, int r101);

    private native long nativeCreateFoldView(long r100);

    private native long nativeCreateFoldViewHeader(long r100);

    private native long nativeCreateFoldViewSlot(long r100);

    private native long nativeCreateFoldViewSlotDrag(long r100);

    private native long nativeCreateFoldViewToolbar(long r100);

    private native long nativeCreateGrid(long r100);

    private native void nativeCreateGridModifier(long r100, int r101);

    private native long nativeCreateImage(long r100);

    private native long nativeCreateInlineImage(long r100);

    private native long nativeCreateInlineText(long r100);

    private native long nativeCreateInlineTruncation(long r100);

    private native long nativeCreateInput(long r100);

    private native void nativeCreateKeyframesAnimationModifier(long r100, int r101, double r102, int r103, double r104, int r105, int r110, int r111, int r112, Object[] r113);

    private native void nativeCreateKeyframesWithNumericProperties(long r100, int r101, String r102, int[] r103, Object[] r104, Object[] r105, Object[] r106);

    private native long nativeCreateLinear(long r100);

    private native void nativeCreateLinearModifier(long r100, int r101);

    private native long nativeCreateList(long r100, ComponentAtIndexCallback r101, EnqueueComponentCallback r102);

    private native long nativeCreateListContainer(long r100, ComponentAtIndexCallback r101, EnqueueComponentCallback r102);

    private native long nativeCreateListItem(long r100);

    private native long nativeCreateLottie(long r100);

    private native long nativeCreateMap(long r100);

    private native long nativeCreateMarkdown(long r100);

    private native long nativeCreateNavigation(long r100);

    private native long nativeCreatePage(long r100);

    private native Object nativeCreatePageWrapper(long r100);

    private native long nativeCreateRawText(long r100, String r101);

    private native long nativeCreateRefresh(long r100);

    private native long nativeCreateRefreshFooter(long r100);

    private native long nativeCreateRefreshHeader(long r100);

    private native long nativeCreateRelaxScrollView(long r100);

    private native void nativeCreateRoute(long r100, String r101, Object r102);

    private native long nativeCreateRow(long r100);

    private native long nativeCreateScrollView(long r100);

    private native long nativeCreateStack(long r100);

    private native void nativeCreateStylePropertyTimingFunction(long r100, int r101, int r102, double[] r103);

    private native long nativeCreateSvg(long r100);

    private native long nativeCreateSwiper(long r100);

    private native long nativeCreateSwiperItem(long r100);

    private native long nativeCreateText(long r100);

    private native long nativeCreateTextArea(long r100);

    private native void nativeCreateTextModifier(long r100, int r101);

    private native void nativeCreateTimingFunction(long r100, int r101, int r102, double[] r103);

    private native void nativeCreateTransitionAnimationModifier(long r100, int r101, int r102, double r103, double r104, int r105);

    private native long nativeCreateVideo(long r100);

    private native long nativeCreateView(long r100);

    private native void nativeCreateViewModifier(long r100, int r101);

    private native long nativeCreateViewPager(long r100);

    private native long nativeCreateViewPagerItem(long r100);

    private native long nativeCreateWrap(long r100);

    private native long nativeCreateWrapperElement(long r100);

    private native void nativeDestroy(long r100);

    private native void nativeDestroyElement(long r100, long r101, boolean r102);

    private native boolean nativeElementIsEqual(long r100, long r101, long r102);

    private native long nativeFirstElement(long r100, long r101);

    private native void nativeFlushElementTree(long r100);

    private native void nativeFlushElementTreeByRoot(long r100, long r101, Object r102);

    private native long[] nativeGetChildren(long r100, long r101);

    private native int nativeGetElementUniqueID(long r100, long r101);

    private native Object nativeGetEngineInfo(long r100);

    private native long nativeGetParent(long r100, long r101);

    private native String nativeGetTag(long r100, long r101);

    private native long[] nativeGetTemplateParts(long r100, long r101);

    private native long nativeInsertClonedElementBefore(long r100, long r101, long r102, long r103);

    private native long nativeInsertElementBefore(long r100, long r101, long r102, long r103);

    private native void nativeInvokeUIMethod(long r100, long r101, String r102, Object r103, CommonCallback r104, String r105);

    private native boolean nativeIsPartElement(long r100, long r101);

    private native boolean nativeIsTemplateElement(long r100, long r101);

    private native long nativeLastElement(long r100, long r101);

    private native boolean nativeMarkPartElement(long r100, long r101, String r102);

    private native boolean nativeMarkTemplateElement(long r100, long r101);

    private native MeasuredResult nativeMeasureText(long r100, String r101, MeasureOptions r102, String r103);

    private native long nativeNextElement(long r100, long r101);

    private native void nativeRelayoutForTesting(long r100);

    private native void nativeRemoveAnchor(long r100, long r101, String r102);

    private native long nativeRemoveElement(long r100, long r101, long r102);

    private native void nativeRemoveEventListener(long r100, long r101, String r102, int r103, CommonCallback r104);

    private native void nativeRemoveEventListenerByName(long r100, long r101, String r102, String r103, CommonCallback r104);

    private native void nativeReplaceElement(long r100, long r101, long r102);

    private native void nativeReplaceElements(long r100, long r101, long r102, long r103);

    private native void nativeResetStyleProperty(long r100, int r101, int r102);

    private native void nativeSetAttribute(long r100, long r101, int r102, Object r103);

    private native void nativeSetElementModifiers(long r100, long r101, int[] r102);

    private native void nativeSetFontFace(long r100, String r101, Object[] r102);

    private native void nativeSetGestureState(long r100, long r101, int r102, int r103);

    private native void nativeSetGestures(long r100, long r101, Object r102, GestureCallback r103);

    private native void nativeSetInitialRoute(long r100, String r101);

    private native void nativeSetModifierPropertyArray(long r100, int r101, int r102, double[] r103, int[] r104);

    private native void nativeSetModifierPropertyBackgroundPosition(long r100, int r101, double[] r102, int[] r103, double[] r104, int[] r105);

    private native void nativeSetModifierPropertyBackgroundSize(long r100, int r101, double[] r102, int[] r103, double[] r104, int[] r105);

    private native void nativeSetModifierPropertyBoxShadow(long r100, int r101, Object[] r102, Object[] r103, double[] r104, int[] r105, double[] r106, int[] r107, long[] r110, int[] r111);

    private native void nativeSetModifierPropertyConicGradient(long r100, int r101, int r102, double r103, double[] r104, int[] r105, long[] r106, Object[] r110);

    private native void nativeSetModifierPropertyFilter(long r100, int r101, int r102, int[] r103, Object[] r104);

    private native void nativeSetModifierPropertyLinearGradient(long r100, int r101, int r102, double r103, long[] r104, double[] r105);

    private native void nativeSetModifierPropertyNum(long r100, int r101, int r102, double r103, int r104);

    private native void nativeSetModifierPropertyRadialGradient(long r100, int r101, int r102, long[] r103, double[] r104, long r105, double[] r106, double[] r110);

    private native void nativeSetModifierPropertyString(long r100, int r101, int r102, String r103);

    private native void nativeSetModifierPropertyTextDecoration(long r100, int r101, double r102, double r103, long r104);

    private native void nativeSetModifierPropertyTextShadow(long r100, int r101, Object[] r102, Object[] r103, double[] r104, int[] r105, long[] r106);

    private native void nativeSetModifierPropertyTransform(long r100, int r101, int r102, int[] r103, Object[] r104);

    private native void nativeSetNumAttribute(long r100, long r101, int r102, double r103, int r104);

    private native void nativeSetNumAttributeByName(long r100, long r101, String r102, double r103, int r104);

    private native void nativeSetStringAttribute(long r100, long r101, int r102, String r103);

    private native void nativeSetStringAttributeByName(long r100, long r101, String r102, String r103);

    private native void nativeSetStylePropertyArray(long r100, int r101, int r102, double[] r103, int[] r104);

    private native void nativeSetStylePropertyBackgroundPosition(long r100, int r101, double[] r102, int[] r103, double[] r104, int[] r105);

    private native void nativeSetStylePropertyBackgroundSize(long r100, int r101, double[] r102, int[] r103, double[] r104, int[] r105);

    private native void nativeSetStylePropertyBoxShadow(long r100, int r101, Object[] r102, Object[] r103, double[] r104, int[] r105, double[] r106, int[] r107, long[] r110, int[] r111);

    private native void nativeSetStylePropertyConicGradient(long r100, int r101, int r102, double r103, double[] r104, int[] r105, long[] r106, Object[] r110);

    private native void nativeSetStylePropertyFilter(long r100, int r101, int r102, int[] r103, Object[] r104);

    private native void nativeSetStylePropertyKeyframesAnimation(long r100, int r101, double r102, int r103, double r104, int r105, int r110, int r111, int r112, Object[] r113);

    private native void nativeSetStylePropertyLinearGradient(long r100, int r101, int r102, double r103, long[] r104, double[] r105);

    private native void nativeSetStylePropertyNum(long r100, int r101, int r102, double r103, int r104);

    private native void nativeSetStylePropertyRadialGradient(long r100, int r101, int r102, long[] r103, double[] r104, long r105, double[] r106, double[] r110);

    private native void nativeSetStylePropertyString(long r100, int r101, int r102, String r103);

    private native void nativeSetStylePropertyTextDecoration(long r100, int r101, double r102, double r103, long r104);

    private native void nativeSetStylePropertyTextShadow(long r100, int r101, Object[] r102, Object[] r103, double[] r104, int[] r105, long[] r106);

    private native void nativeSetStylePropertyTransform(long r100, int r101, int r102, int[] r103, Object[] r104);

    private native void nativeSetStylePropertyTransition(long r100, int r101, int r102, double r103, double r104, int r105, int r110, double r111, double r112, double r113, double r114);

    private native void nativeSetTimingFlag(long r100, Object r101);

    private native void nativeSwapElement(long r100, long r101, long r102);

    public final long B() {
        return nativeCreateListItem(this.f405695a);
    }

    public final long C() {
        return nativeCreateLottie(this.f405695a);
    }

    public final long D() {
        return nativeCreatePage(this.f405695a);
    }

    public final Object E() {
        return nativeCreatePageWrapper(this.f405695a);
    }

    public final long F() {
        return nativeCreateRawText(this.f405695a, "");
    }

    public final long G() {
        return nativeCreateRefresh(this.f405695a);
    }

    public final long H() {
        return nativeCreateRefreshFooter(this.f405695a);
    }

    public final long I() {
        return nativeCreateRefreshHeader(this.f405695a);
    }

    public final long J() {
        return nativeCreateRelaxScrollView(this.f405695a);
    }

    public final long K() {
        return nativeCreateRow(this.f405695a);
    }

    public final long L() {
        return nativeCreateScrollView(this.f405695a);
    }

    public final long M() {
        return nativeCreateStack(this.f405695a);
    }

    public final long N() {
        return nativeCreateSvg(this.f405695a);
    }

    public final long O() {
        return nativeCreateSwiper(this.f405695a);
    }

    public final long P() {
        return nativeCreateSwiperItem(this.f405695a);
    }

    public final long Q() {
        return nativeCreateText(this.f405695a);
    }

    public final long R() {
        return nativeCreateTextArea(this.f405695a);
    }

    public final long W() {
        return nativeCreateViewPager(this.f405695a);
    }

    public final long X() {
        return nativeCreateViewPagerItem(this.f405695a);
    }

    public final long Y() {
        return nativeCreateWrap(this.f405695a);
    }

    public final long Z() {
        return nativeCreateWrapperElement(this.f405695a);
    }

    public final void a0() {
        nativeDestroy(this.f405695a);
    }

    public final void c0() {
        nativeFlushElementTree(this.f405695a);
    }

    public final long h() {
        return nativeCreateAnimaxView(this.f405695a);
    }

    public final long i() {
        return nativeCreateColumn(this.f405695a);
    }

    public final long k() {
        return nativeCreateFlex(this.f405695a);
    }

    public final long m() {
        return nativeCreateFoldView(this.f405695a);
    }

    public final long n() {
        return nativeCreateFoldViewHeader(this.f405695a);
    }

    public final long o() {
        return nativeCreateFoldViewSlot(this.f405695a);
    }

    public final long p() {
        return nativeCreateFoldViewSlotDrag(this.f405695a);
    }

    public final long q() {
        return nativeCreateFoldViewToolbar(this.f405695a);
    }

    public final long r() {
        return nativeCreateGrid(this.f405695a);
    }

    public final long s() {
        return nativeCreateImage(this.f405695a);
    }

    public final long t() {
        return nativeCreateInlineImage(this.f405695a);
    }

    public final long u() {
        return nativeCreateInlineText(this.f405695a);
    }

    public final long v() {
        return nativeCreateInlineTruncation(this.f405695a);
    }

    public final long w() {
        return nativeCreateInput(this.f405695a);
    }

    public final long z() {
        return nativeCreateLinear(this.f405695a);
    }

    public RendererFunction() {
        this.f405695a = 0;
    }

    public RendererFunction(long r100) {
        this.f405695a = 0;
        this.f405695a = nativeCreate(r100);
    }

    public final void S(int r100) {
        nativeCreateTextModifier(this.f405695a, r100);
    }

    public final void V(int r100) {
        nativeCreateViewModifier(this.f405695a, r100);
    }

    public final void b0(long r100) {
        nativeDestroyElement(this.f405695a, r100, true);
    }

    public final int e0(long r100) {
        return nativeGetElementUniqueID(this.f405695a, r100);
    }

    public final long j(String r100) {
        return nativeCreateContainerElement(this.f405695a, r100);
    }

    public final void l(int r100) {
        nativeCreateFlexModifier(this.f405695a, r100);
    }

    public final long A(f4 r100, g4 r101) {
        return nativeCreateListContainer(this.f405695a, r100, r101);
    }

    public final long c(long r100, long r110) {
        return nativeAppendElement(this.f405695a, r100, r110);
    }

    public final void d0(long r100, PipelineOptions r101) {
        nativeFlushElementTreeByRoot(this.f405695a, r100, r101);
    }

    public final long h0(long r100, long r110) {
        return nativeRemoveElement(this.f405695a, r100, r110);
    }

    public final void j0(long r100, ArrayList<Integer> r101) {
        nativeSetElementModifiers(this.f405695a, r100, a.b(r101));
    }

    public final void B0(long r100, int r110, String r111) {
        nativeSetStringAttribute(this.f405695a, r100, r110, r111);
    }

    public final void C0(long r100, String r110, String r111) {
        nativeSetStringAttributeByName(this.f405695a, r100, r110, r111);
    }

    public final void T(int r100, int r101, ArrayList<Double> r102) {
        nativeCreateTimingFunction(this.f405695a, r100, r101, a.a(r102));
    }

    public final void b(long r110, g5 r111, Object r112) {
        nativeAddEventListenerByName(this.f405695a, r110, "bindEvent", "RTSAnchorStatusHybridCard_onLoadSuccess", r111, (String) r112);
    }

    public final long f0(long r110, long r111, long r112) {
        return nativeInsertElementBefore(this.f405695a, r110, r111, r112);
    }

    public final void g(long r100, int r110, Object r111) {
        nativeConsumeGesture(this.f405695a, r100, r110, r111);
    }

    public final void i0(long r100, int r110, Object r111) {
        nativeSetAttribute(this.f405695a, r100, r110, r111);
    }

    public final void k0(long r100, int r110, int r111) {
        nativeSetGestureState(this.f405695a, r100, r110, r111);
    }

    public final void l0(long r100, Object r110, k5 r111) {
        nativeSetGestures(this.f405695a, r100, r110, r111);
    }

    public final void v0(int r100, int r101, String r102) {
        nativeSetModifierPropertyString(this.f405695a, r100, r101, r102);
    }

    public final void A0(long r110, String r111, double r112, int r113) {
        nativeSetNumAttributeByName(this.f405695a, r110, r111, r112, r113);
    }

    public final void U(int r110, int r111, double r112, int r113) {
        nativeCreateTransitionAnimationModifier(this.f405695a, r110, r111, r112, AudioStats.AUDIO_AMPLITUDE_NONE, r113);
    }

    public final void d(int r100, ArrayList<Integer> r101, ArrayList<ArrayList<Integer>> r110, ArrayList<ArrayList<ArrayList<Double>>> r111) {
        nativeBatchSetKeyFramesPropertyFilter(this.f405695a, r100, a.b(r101), a.d(r110), a.d(r111));
    }

    public final void e(int r100, ArrayList<Integer> r101, ArrayList<ArrayList<Integer>> r110, ArrayList<ArrayList<ArrayList<Double>>> r111) {
        nativeBatchSetKeyFramesPropertyTransform(this.f405695a, r100, a.b(r101), a.d(r110), a.d(r111));
    }

    public final void f(int r100, ArrayList<Integer> r101, ArrayList<Double> r110, ArrayList<Integer> r111) {
        nativeBatchSetModifierPropertyNum(this.f405695a, r100, a.b(r101), a.a(r110), a.b(r111));
    }

    public final void m0(int r100, int r101, ArrayList<Double> r110, ArrayList<Integer> r111) {
        nativeSetModifierPropertyArray(this.f405695a, r100, r101, a.a(r110), a.b(r111));
    }

    public final void r0(int r100, int r101, ArrayList<Integer> r110, ArrayList<ArrayList<Double>> r111) {
        nativeSetModifierPropertyFilter(this.f405695a, r100, r101, a.b(r110), a.d(r111));
    }

    public final void t0(int r100, int r110, double r111, int r112) {
        nativeSetModifierPropertyNum(this.f405695a, r100, r110, r111, r112);
    }

    public final void w0(int r110, double r111, double r112, long r113) {
        nativeSetModifierPropertyTextDecoration(this.f405695a, r110, r111, r112, r113);
    }

    public final void y0(int r100, int r101, ArrayList<Integer> r110, ArrayList<ArrayList<Double>> r111) {
        nativeSetModifierPropertyTransform(this.f405695a, r100, r101, a.b(r110), a.d(r111));
    }

    public final void z0(long r110, int r111, double r112, int r113) {
        nativeSetNumAttribute(this.f405695a, r110, r111, r112, r113);
    }

    public final void a(long r110, String r111, int r112, CommonCallback r113, Object r114) {
        nativeAddEventListener(this.f405695a, r110, r111, r112, r113, (String) r114);
    }

    public final void g0(long r110, String r111, Object r112, CommonCallback r113, Object r114) {
        nativeInvokeUIMethod(this.f405695a, r110, r111, r112, r113, (String) r114);
    }

    public final void n0(int r100, ArrayList<Double> r110, ArrayList<Integer> r111, ArrayList<Double> r112, ArrayList<Integer> r113) {
        nativeSetModifierPropertyBackgroundPosition(this.f405695a, r100, a.a(r110), a.b(r111), a.a(r112), a.b(r113));
    }

    public final void o0(int r100, ArrayList<Double> r110, ArrayList<Integer> r111, ArrayList<Double> r112, ArrayList<Integer> r113) {
        nativeSetModifierPropertyBackgroundSize(this.f405695a, r100, a.a(r110), a.b(r111), a.a(r112), a.b(r113));
    }

    public final void s0(int r110, int r111, double r112, ArrayList<Long> r113, ArrayList<Double> r114) {
        nativeSetModifierPropertyLinearGradient(this.f405695a, r110, r111, r112, a.c(r113), a.a(r114));
    }

    public final void q0(int r110, int r111, ArrayList r112, ArrayList r113, ArrayList r114, ArrayList r115) {
        nativeSetModifierPropertyConicGradient(this.f405695a, r110, r111, AudioStats.AUDIO_AMPLITUDE_NONE, a.a(r112), a.b(r113), a.c(r114), a.d(r115));
    }

    public final void x0(int r110, ArrayList<ArrayList<Double>> r111, ArrayList<ArrayList<Integer>> r112, ArrayList<Double> r113, ArrayList<Integer> r114, ArrayList<Long> r115) {
        nativeSetModifierPropertyTextShadow(this.f405695a, r110, a.d(r111), a.d(r112), a.a(r113), a.b(r114), a.c(r115));
    }

    public final void y(int r110, String r111, ArrayList<Integer> r112, ArrayList<ArrayList<Integer>> r113, ArrayList<ArrayList<Double>> r114, ArrayList<ArrayList<Integer>> r115) {
        nativeCreateKeyframesWithNumericProperties(this.f405695a, r110, r111, a.b(r112), a.d(r113), a.d(r114), a.d(r115));
    }

    public final void u0(int r110, int r111, ArrayList<Long> r112, ArrayList<Double> r113, long r114, ArrayList<Double> r115, ArrayList<Double> r210) {
        nativeSetModifierPropertyRadialGradient(this.f405695a, r110, r111, a.c(r112), a.a(r113), r114, a.a(r115), a.a(r210));
    }

    public final void p0(int r110, ArrayList<ArrayList<Double>> r111, ArrayList<ArrayList<Integer>> r112, ArrayList<Double> r113, ArrayList<Integer> r114, ArrayList<Double> r115, ArrayList<Integer> r210, ArrayList<Long> r211, ArrayList<Integer> r212) {
        nativeSetModifierPropertyBoxShadow(this.f405695a, r110, a.d(r111), a.d(r112), a.a(r113), a.b(r114), a.a(r115), a.b(r210), a.c(r211), a.b(r212));
    }

    public final void x(int r110, double r111, int r112, double r210, int r211, int r212, int r213, int r214, ArrayList<String> r215) {
        nativeCreateKeyframesAnimationModifier(this.f405695a, r110, r111, r112, r210, r211, r212, r213, r214, a.d(r215));
    }
}
