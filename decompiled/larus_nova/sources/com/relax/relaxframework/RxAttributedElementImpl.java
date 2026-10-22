package com.relax.relaxframework;

import androidx.camera.video.AudioStats;
import com.bytedance.rts.foundation.Promise;
import com.facebook.keyframes.model.KFAnimation;
import com.lynx.tasm.event.LynxTouchEvent;
import com.relax.runtime.gen.NativeLayoutProxy;
import java.util.ArrayList;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public class RxAttributedElementImpl extends RxElementImpl {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f404911a = null;

        static {
            int[] r100 = new int[AttributeNumberValuePattern.values().length];
            r100[AttributeNumberValuePattern.BOOLEAN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[AttributeNumberValuePattern.INT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[AttributeNumberValuePattern.DOUBLE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f404911a = r100;
        }
    }

    public final void c0(final Function1<? super ExposureEvent, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "handler");
        if (this.f404932u.rtsPipelineEnabled() == true) goto L5;
        long r101 = E();
        int r102 = s2.f405262a;
        qpa.d.a(r101, "bindEvent", EventKey.Appear.getValue(), new u4(r100), "{\"type\":\"class\",\"class\":\"com.relax.relaxframework.ExposureEvent\",\"fields\":{\"detail\":{\"type\":\"class\",\"class\":\"com.relax.relaxframework.ExposureEventDetail\",\"fields\":{\"sign\":{\"type\":\"primitive\",\"class\":\"int32\",\"name\":\"sign\",\"index\":0},\"exposureID\":{\"type\":\"primitive\",\"class\":\"string\",\"name\":\"exposureID\",\"index\":1},\"exposureScene\":{\"type\":\"primitive\",\"class\":\"string\",\"name\":\"exposureScene\",\"index\":2}},\"index\":0},\"type\":{\"type\":\"primitive\",\"class\":\"string\",\"name\":\"type\",\"index\":1},\"timestamp\":{\"type\":\"primitive\",\"class\":\"int64\",\"name\":\"timestamp\",\"index\":2},\"target\":{\"type\":\"primitive\",\"class\":\"rptr\",\"name\":\"target\",\"index\":3},\"currentTarget\":{\"type\":\"primitive\",\"class\":\"rptr\",\"name\":\"currentTarget\",\"index\":4}}}");
    L5:
        d0(this, "uiappear", r100, RxAttributedElementImpl$bindAppear$2.INSTANCE);
    }

    public final void e0(final Function1<? super LayoutEvent, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "handler");
        if (this.f404932u.rtsPipelineEnabled() == true) goto L5;
        long r101 = E();
        int r102 = s2.f405262a;
        qpa.d.a(r101, "bindEvent", EventKey.LayoutChange.getValue(), new x4(r100), "{\"type\":\"class\",\"class\":\"com.relax.relaxframework.LayoutEvent\",\"fields\":{\"detail\":{\"type\":\"class\",\"class\":\"com.relax.relaxframework.LayoutEventDetail\",\"fields\":{\"top\":{\"type\":\"primitive\",\"class\":\"float64\",\"name\":\"top\",\"index\":0},\"bottom\":{\"type\":\"primitive\",\"class\":\"float64\",\"name\":\"bottom\",\"index\":1},\"left\":{\"type\":\"primitive\",\"class\":\"float64\",\"name\":\"left\",\"index\":2},\"right\":{\"type\":\"primitive\",\"class\":\"float64\",\"name\":\"right\",\"index\":3},\"width\":{\"type\":\"primitive\",\"class\":\"float64\",\"name\":\"width\",\"index\":4},\"height\":{\"type\":\"primitive\",\"class\":\"float64\",\"name\":\"height\",\"index\":5}},\"index\":0},\"type\":{\"type\":\"primitive\",\"class\":\"string\",\"name\":\"type\",\"index\":1},\"timestamp\":{\"type\":\"primitive\",\"class\":\"int64\",\"name\":\"timestamp\",\"index\":2},\"target\":{\"type\":\"primitive\",\"class\":\"rptr\",\"name\":\"target\",\"index\":3},\"currentTarget\":{\"type\":\"primitive\",\"class\":\"rptr\",\"name\":\"currentTarget\",\"index\":4}}}");
    L5:
        int r103 = y0.f405356a;
        d0(this, "layoutchange", r100, RxAttributedElementImpl$bindLayoutChange$2.INSTANCE);
    }

    public final void f0(final Function1<? super LongPressEvent, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "handler");
        int r101 = s2.f405262a;
        if (this.f404932u.rtsPipelineEnabled() == true) goto L5;
        qpa.d.a(E(), "bindEvent", EventKey.LongPress.getValue(), new w4(r100), "{\"type\":\"class\",\"class\":\"com.relax.relaxframework.LongPressEvent\",\"fields\":{\"changedTouches\":{\"type\":\"array\",\"dim\":1,\"class\":\"com.relax.relaxframework.TouchEventDetailTouches\",\"fields\":{\"identifier\":{\"type\":\"primitive\",\"class\":\"int32\",\"name\":\"identifier\",\"index\":0},\"x\":{\"type\":\"primitive\",\"class\":\"float64\",\"name\":\"x\",\"index\":1},\"y\":{\"type\":\"primitive\",\"class\":\"float64\",\"name\":\"y\",\"index\":2},\"clientX\":{\"type\":\"primitive\",\"class\":\"float64\",\"name\":\"clientX\",\"index\":3},\"clientY\":{\"type\":\"primitive\",\"class\":\"float64\",\"name\":\"clientY\",\"index\":4},\"pageX\":{\"type\":\"primitive\",\"class\":\"float64\",\"name\":\"pageX\",\"index\":5},\"pageY\":{\"type\":\"primitive\",\"class\":\"float64\",\"name\":\"pageY\",\"index\":6}},\"index\":0},\"touches\":{\"type\":\"array\",\"dim\":1,\"class\":\"com.relax.relaxframework.TouchEventDetailTouches\",\"fields\":{\"identifier\":{\"type\":\"primitive\",\"class\":\"int32\",\"name\":\"identifier\",\"index\":0},\"x\":{\"type\":\"primitive\",\"class\":\"float64\",\"name\":\"x\",\"index\":1},\"y\":{\"type\":\"primitive\",\"class\":\"float64\",\"name\":\"y\",\"index\":2},\"clientX\":{\"type\":\"primitive\",\"class\":\"float64\",\"name\":\"clientX\",\"index\":3},\"clientY\":{\"type\":\"primitive\",\"class\":\"float64\",\"name\":\"clientY\",\"index\":4},\"pageX\":{\"type\":\"primitive\",\"class\":\"float64\",\"name\":\"pageX\",\"index\":5},\"pageY\":{\"type\":\"primitive\",\"class\":\"float64\",\"name\":\"pageY\",\"index\":6}},\"index\":1},\"detail\":{\"type\":\"class\",\"class\":\"com.relax.relaxframework.TouchEventDetail\",\"fields\":{\"x\":{\"type\":\"primitive\",\"class\":\"float64\",\"name\":\"x\",\"index\":0},\"y\":{\"type\":\"primitive\",\"class\":\"float64\",\"name\":\"y\",\"index\":1}},\"index\":2},\"type\":{\"type\":\"primitive\",\"class\":\"string\",\"name\":\"type\",\"index\":3},\"timestamp\":{\"type\":\"primitive\",\"class\":\"int64\",\"name\":\"timestamp\",\"index\":4},\"target\":{\"type\":\"primitive\",\"class\":\"rptr\",\"name\":\"target\",\"index\":5},\"currentTarget\":{\"type\":\"primitive\",\"class\":\"rptr\",\"name\":\"currentTarget\",\"index\":6}}}");
        return;
    L5:
        int r102 = y0.f405356a;
        v("longpress", new t2(new RxAttributedElementImpl$attachLongPressHandler$2(r100), RelaxFrameworkKt.N("bindEvent")));
    }

    public final void g0(Function1<? super TapEvent, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "handler");
        int r101 = s2.f405262a;
        b0(r100, "bindEvent");
    }

    public final void h0(final Function1<? super TouchEvent, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "handler");
        int r101 = s2.f405262a;
        Intrinsics.checkNotNullParameter(r100, "handler");
        Intrinsics.checkNotNullParameter("bindEvent", "eventType");
        if (this.f404932u.rtsPipelineEnabled() == true) goto L5;
        qpa.d.a(E(), "bindEvent", EventKey.TouchMove.getValue(), new t4(r100), "{\"type\":\"class\",\"class\":\"com.relax.relaxframework.TouchEvent\",\"fields\":{\"changedTouches\":{\"type\":\"array\",\"dim\":1,\"class\":\"com.relax.relaxframework.TouchEventDetailTouches\",\"fields\":{\"identifier\":{\"type\":\"primitive\",\"class\":\"int32\",\"name\":\"identifier\",\"index\":0},\"x\":{\"type\":\"primitive\",\"class\":\"float64\",\"name\":\"x\",\"index\":1},\"y\":{\"type\":\"primitive\",\"class\":\"float64\",\"name\":\"y\",\"index\":2},\"clientX\":{\"type\":\"primitive\",\"class\":\"float64\",\"name\":\"clientX\",\"index\":3},\"clientY\":{\"type\":\"primitive\",\"class\":\"float64\",\"name\":\"clientY\",\"index\":4},\"pageX\":{\"type\":\"primitive\",\"class\":\"float64\",\"name\":\"pageX\",\"index\":5},\"pageY\":{\"type\":\"primitive\",\"class\":\"float64\",\"name\":\"pageY\",\"index\":6}},\"index\":0},\"touches\":{\"type\":\"array\",\"dim\":1,\"class\":\"com.relax.relaxframework.TouchEventDetailTouches\",\"fields\":{\"identifier\":{\"type\":\"primitive\",\"class\":\"int32\",\"name\":\"identifier\",\"index\":0},\"x\":{\"type\":\"primitive\",\"class\":\"float64\",\"name\":\"x\",\"index\":1},\"y\":{\"type\":\"primitive\",\"class\":\"float64\",\"name\":\"y\",\"index\":2},\"clientX\":{\"type\":\"primitive\",\"class\":\"float64\",\"name\":\"clientX\",\"index\":3},\"clientY\":{\"type\":\"primitive\",\"class\":\"float64\",\"name\":\"clientY\",\"index\":4},\"pageX\":{\"type\":\"primitive\",\"class\":\"float64\",\"name\":\"pageX\",\"index\":5},\"pageY\":{\"type\":\"primitive\",\"class\":\"float64\",\"name\":\"pageY\",\"index\":6}},\"index\":1},\"detail\":{\"type\":\"class\",\"class\":\"com.relax.relaxframework.TouchEventDetail\",\"fields\":{\"x\":{\"type\":\"primitive\",\"class\":\"float64\",\"name\":\"x\",\"index\":0},\"y\":{\"type\":\"primitive\",\"class\":\"float64\",\"name\":\"y\",\"index\":1}},\"index\":2},\"type\":{\"type\":\"primitive\",\"class\":\"string\",\"name\":\"type\",\"index\":3},\"timestamp\":{\"type\":\"primitive\",\"class\":\"int64\",\"name\":\"timestamp\",\"index\":4},\"target\":{\"type\":\"primitive\",\"class\":\"rptr\",\"name\":\"target\",\"index\":5},\"currentTarget\":{\"type\":\"primitive\",\"class\":\"rptr\",\"name\":\"currentTarget\",\"index\":6}}}");
        return;
    L5:
        int r102 = y0.f405356a;
        v(LynxTouchEvent.EVENT_TOUCH_MOVE, new i8(new RxAttributedElementImpl$attachTouchMoveHandler$2(r100), RelaxFrameworkKt.N("bindEvent")));
    }

    public final void i0(Function1<? super TapEvent, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "handler");
        int r101 = s2.f405262a;
        b0(r100, "catchEvent");
    }

    public final void r0(ArrayList<p6> r100) {
        Intrinsics.checkNotNullParameter(r100, "modifiers");
        if (this.f404932u.rtsPipelineEnabled() == false) goto L5;
        markDirty();
        u(r100);
        return;
    L5:
        RelaxFrameworkKt.U(r100, E());
    }

    public RxAttributedElementImpl(String r100, Long r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        super(r100, r101);
    }

    public final void b0(final Function1<? super TapEvent, Unit> r100, String r101) {
        if (this.f404932u.rtsPipelineEnabled() == true) goto L5;
        qpa.d.a(E(), r101, EventKey.Tap.getValue(), new v4(r100), "{\"type\":\"class\",\"class\":\"com.relax.relaxframework.TapEvent\",\"fields\":{\"changedTouches\":{\"type\":\"array\",\"dim\":1,\"class\":\"com.relax.relaxframework.TouchEventDetailTouches\",\"fields\":{\"identifier\":{\"type\":\"primitive\",\"class\":\"int32\",\"name\":\"identifier\",\"index\":0},\"x\":{\"type\":\"primitive\",\"class\":\"float64\",\"name\":\"x\",\"index\":1},\"y\":{\"type\":\"primitive\",\"class\":\"float64\",\"name\":\"y\",\"index\":2},\"clientX\":{\"type\":\"primitive\",\"class\":\"float64\",\"name\":\"clientX\",\"index\":3},\"clientY\":{\"type\":\"primitive\",\"class\":\"float64\",\"name\":\"clientY\",\"index\":4},\"pageX\":{\"type\":\"primitive\",\"class\":\"float64\",\"name\":\"pageX\",\"index\":5},\"pageY\":{\"type\":\"primitive\",\"class\":\"float64\",\"name\":\"pageY\",\"index\":6}},\"index\":0},\"touches\":{\"type\":\"array\",\"dim\":1,\"class\":\"com.relax.relaxframework.TouchEventDetailTouches\",\"fields\":{\"identifier\":{\"type\":\"primitive\",\"class\":\"int32\",\"name\":\"identifier\",\"index\":0},\"x\":{\"type\":\"primitive\",\"class\":\"float64\",\"name\":\"x\",\"index\":1},\"y\":{\"type\":\"primitive\",\"class\":\"float64\",\"name\":\"y\",\"index\":2},\"clientX\":{\"type\":\"primitive\",\"class\":\"float64\",\"name\":\"clientX\",\"index\":3},\"clientY\":{\"type\":\"primitive\",\"class\":\"float64\",\"name\":\"clientY\",\"index\":4},\"pageX\":{\"type\":\"primitive\",\"class\":\"float64\",\"name\":\"pageX\",\"index\":5},\"pageY\":{\"type\":\"primitive\",\"class\":\"float64\",\"name\":\"pageY\",\"index\":6}},\"index\":1},\"detail\":{\"type\":\"class\",\"class\":\"com.relax.relaxframework.TouchEventDetail\",\"fields\":{\"x\":{\"type\":\"primitive\",\"class\":\"float64\",\"name\":\"x\",\"index\":0},\"y\":{\"type\":\"primitive\",\"class\":\"float64\",\"name\":\"y\",\"index\":1}},\"index\":2},\"type\":{\"type\":\"primitive\",\"class\":\"string\",\"name\":\"type\",\"index\":3},\"timestamp\":{\"type\":\"primitive\",\"class\":\"int64\",\"name\":\"timestamp\",\"index\":4},\"target\":{\"type\":\"primitive\",\"class\":\"rptr\",\"name\":\"target\",\"index\":5},\"currentTarget\":{\"type\":\"primitive\",\"class\":\"rptr\",\"name\":\"currentTarget\",\"index\":6}}}");
        return;
    L5:
        int r102 = y0.f405356a;
        v("tap", new b8(new RxAttributedElementImpl$attachTapHandler$2(r100), RelaxFrameworkKt.N(r101)));
    }

    public final void k0(ElementAttribute r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        int r102 = com.bytedance.rts.foundation.d.f267577a;
        s0(r100, r101, AttributeNumberValuePattern.INT);
    }

    public final void l0(ElementAttribute r100, g2 r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        int r102 = com.bytedance.rts.foundation.d.f267577a;
        s0(r100, r101.f405102a, AttributeNumberValuePattern.INT);
    }

    public final void m0(ElementAttribute r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        u0(r100, r101);
    }

    public final void n0(ElementAttribute r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        if (r101 == false) goto L5;
        double r102 = 1.0d;
    L6:
        s0(r100, r102, AttributeNumberValuePattern.BOOLEAN);
        return;
    L5:
        r102 = AudioStats.AUDIO_AMPLITUDE_NONE;
        goto L6
    }

    public final void o0(final ElementAttribute r100, final Function0<Boolean> r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        RelaxFrameworkKt.K(new RxAttributedElementImpl$setAttribute__M_ElementAttribute_PFB$1(this, r100, r101));
    }

    public final void p0(final ElementAttribute r100, final Function0<Integer> r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        RelaxFrameworkKt.K(new RxAttributedElementImpl$setAttribute__M_ElementAttribute_PFI32$1(this, r100, r101));
    }

    public final void q0(final ElementAttribute r100, final Function0<String> r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        RelaxFrameworkKt.K(new RxAttributedElementImpl$setAttribute__M_ElementAttribute_PFS$1(this, r100, r101));
    }

    public final void t0(ElementAttribute r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        if (this.f404932u.rtsPipelineEnabled() == true) goto L6;
        qpa.d.e(E(), r100.getValue(), r101);
        return;
    L6:
        if (r100 != ElementAttribute.BlockNativeEventAreas) goto L8;
    L9:
        this.f404924m = false;
    L10:
        v0(r100, r101);
        return;
    L8:
        if (r100 != ElementAttribute.ConsumeSlideEvent) goto L10;
        goto L9
    }

    public void u0(ElementAttribute r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        if (this.f404932u.rtsPipelineEnabled() == true) goto L6;
        long r102 = E();
        int r103 = r100.getValue();
        RelaxInstance.Companion.getClass();
        RelaxInstance.access$getCurrentInstance$cp().getRendererFunction().B0(r102, r103, r101);
        return;
    L6:
        if (r100 != ElementAttribute.Name) goto L8;
    L13:
        this.f404924m = false;
    L14:
        v0(r100, r101);
        return;
    L8:
        if (r100 != ElementAttribute.ExposureScene) goto L10;
    L11:
        IntCompanionObject r104 = IntCompanionObject.INSTANCE;
        int r105 = r101.length();
        com.bytedance.rts.foundation.k.c(r104, r105);
        if (r105 <= 0) goto L14;
    L10:
        if (r100 != ElementAttribute.ExposureId) goto L14;
        goto L11
    }

    public final void v0(ElementAttribute r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        K();
        if (this.f404932u.getUIProxy() == null) goto L5;
        r100.getValue();
        throw null;
    L5:
        if (V() == true) goto L7;
    L11:
        markDirty();
        return;
    L7:
        if (this.f404932u.getShadowNodeProxy() == null) goto L11;
        r100.getValue();
        throw null;
    }

    public final <T> Promise<T> m(final String r100, final Object r101, final Object r102) {
        Intrinsics.checkNotNullParameter(r100, "methodName");
        return (Promise) RelaxFrameworkKt.g0(this.f404932u, new RxAttributedElementImpl$invokeUIMethod$1(this, r101, r100, r102));
    }

    public void s0(ElementAttribute r110, double r111, AttributeNumberValuePattern r112) {
        Intrinsics.checkNotNullParameter(r110, "key");
        Intrinsics.checkNotNullParameter(r112, "pattern");
        if (this.f404932u.rtsPipelineEnabled() == true) goto L5;
        long r100 = E();
        int r101 = r110.getValue();
        int r102 = r112.getValue();
        RelaxInstance.Companion.getClass();
        RelaxInstance.access$getCurrentInstance$cp().getRendererFunction().z0(r100, r101, r111, r102);
        return;
    L5:
        n0 r103 = RelaxFrameworkKt.f404871a;
        Intrinsics.checkNotNullParameter(r110, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        boolean r104 = false;
        if (RelaxFrameworkKt.d(r110) == CSSModifierProperty.None) goto L8;
        boolean r105 = true;
    L9:
        if (r105 == false) goto L15;
        ModifierValuePattern r113 = ModifierValuePattern.NUMBER;
        Intrinsics.checkNotNullParameter(r110, "key");
        Intrinsics.checkNotNullParameter(r113, "pattern");
        NativeLayoutProxy r106 = this.f404932u.getLayoutProxy();
        if (r106 == null) goto L13;
        r106.t(this.f404921j, RelaxFrameworkKt.d(r110).getValue(), r111, r113.getValue());
    L13:
        markDirty();
        return;
    L15:
        if (r110 != ElementAttribute.UserInteractionEnabled) goto L17;
    L18:
        this.f404924m = false;
    L19:
        int r114 = a.f404911a[r112.ordinal()];
        if (r114 == 1) goto L30;
        if (r114 != 2) goto L24;
        int r115 = com.bytedance.rts.foundation.c.f267576a;
        v0(r110, Long.valueOf((long) r111));
        return;
    L24:
        if (r114 != 3) goto L27;
        v0(r110, Double.valueOf(r111));
        return;
    L27:
        throw new NoWhenBranchMatchedException();
    L30:
        if (r111 != AudioStats.AUDIO_AMPLITUDE_NONE) goto L32;
        r104 = true;
    L32:
        v0(r110, Boolean.valueOf(!r104));
        return;
    L17:
        if (r110 != ElementAttribute.BlockNativeEvent) goto L19;
    L8:
        r105 = false;
        goto L9
    }

    public static void d0(RxAttributedElementImpl r100, String r101, Function1 r102, Function1 r103) {
        EventBindType r104 = EventBindType.Bind;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "type");
        Intrinsics.checkNotNullParameter(r102, "handler");
        Intrinsics.checkNotNullParameter(r103, "eventObjectCreator");
        Intrinsics.checkNotNullParameter(r104, "bindType");
        if (r100.f404932u.rtsPipelineEnabled() == false) goto L7;
        r100.v(r101, new CustomEventListener(r102, r104, r103));
        return;
    }

    public static /* synthetic */ void j0(RxAttributedElementImpl r100, String r101, Object r102, int r103) {
        if ((r103 & 2) == 0) goto L5;
        r102 = null;
    L5:
        r100.m(r101, r102, null);
    }
}
