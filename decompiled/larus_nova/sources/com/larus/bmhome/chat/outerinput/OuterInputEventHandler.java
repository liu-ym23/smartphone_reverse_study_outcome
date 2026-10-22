package com.larus.bmhome.chat.outerinput;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.bmhome.chat.component.bottom.attachment.g1;
import com.larus.bmhome.chat.component.bottom.bottommenu.f1;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.component.bottom.core.n5;
import com.larus.input.impl.databinding.LarusWidgetInputBinding;
import com.larus.nova.R;
import com.larus.trace.tracknode.TraceFragment;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* JADX INFO: loaded from: classes25.dex */
public final class OuterInputEventHandler {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f308406i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TraceFragment f308407a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<LarusWidgetInputBinding> f308408b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f308409c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f308410d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f308411e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f308412f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f308413g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f308414h;

    public static final class a {
    }

    static {
    }

    public final void c() {
        if (this.f308409c == true) goto L28;
        this.f308409c = true;
        TraceFragment r100 = this.f308407a;
        if (r100 == null) goto L10;
        Bundle r101 = r100.getArguments();
        if (r101 == null) goto L10;
        String r102 = r101.getString("arg_outer_input_tab_key");
        if (r102 == null) goto L10;
    L11:
        this.f308410d = r102;
        FLogger.f375446a.i("OuterInputEventHandler", "handleEvent, tabKey:" + this.f308410d);
        TraceFragment r103 = this.f308407a;
        if (r103 == null) goto L29;
        Bundle r104 = r103.getArguments();
        if (r104 == null) goto L30;
        int r105 = r104.getInt("arg_outer_input_event_id");
        if (r105 >= 101) goto L18;
        return;
    L18:
        if (r105 >= 201) goto L20;
        b(r105);
        return;
    L20:
        TraceFragment r106 = this.f308407a;
        if (r106 == null) goto L25;
        Bundle r107 = r106.getArguments();
        if (r107 == null) goto L25;
        OuterInputEventBus.OuterInputEvent r108 = (OuterInputEventBus.OuterInputEvent) r107.getParcelable("arg_outer_input_down_event");
    L26:
        a(r105, r108);
        return;
    L25:
        r108 = null;
        goto L26
    L30:
        return;
    L29:
        return;
    L10:
        r102 = "";
        goto L11
    }

    public final void b(int r100) {
        FLogger r101 = FLogger.f375446a;
        r101.i("OuterInputEventHandler", "handleClickEvent, eventId:" + r100);
        boolean r102 = true;
        switch(r100) {
            case 101: goto L30;
            case 102: goto L29;
            case 103: goto L28;
            case 104: goto L27;
            case 105: goto L24;
            case 106: goto L10;
            case 107: goto L5;
            default: goto L43;
        };
    L5:
        TraceFragment r103 = this.f308407a;
        if (r103 == null) goto L32;
        final t1a.b r104 = s1a.a.g(r103);
        if (r104 == null) goto L33;
        t0.f375468a.post(new z(r104));
        return;
    L33:
        return;
    L32:
        return;
    L10:
        g1 r105 = (g1) this.f308413g.getValue();
        if (r105 != null) goto L13;
    L15:
        r102 = false;
    L16:
        if (r102 == false) goto L18;
        t0.f375468a.post(new y(this));
        return;
    L18:
        TraceFragment r106 = this.f308407a;
        if (r106 == null) goto L21;
        f1 r107 = (f1) s1a.a.g(r106).getAbility(f1.class);
    L22:
        if (r107 == null) goto L36;
        r107.XM();
        return;
    L36:
        return;
    L21:
        r107 = null;
        goto L22
    L13:
        if (r105.isVisible() != true) goto L15;
    L24:
        ICoreInputAbility r108 = (ICoreInputAbility) this.f308414h.getValue();
        if (r108 == null) goto L38;
        r108.BU(true, true, "");
        return;
    L38:
        return;
    L27:
        t0.f375468a.post(new x(this));
        return;
    L28:
        t0.f375468a.post(new w(this));
        return;
    L29:
        t0.f375468a.post(new v(this));
        return;
    L30:
        r101.e("OuterInputEventHandler", "click first phone");
        return;
    }

    public OuterInputEventHandler(TraceFragment r100, n5 r101) {
        Intrinsics.checkNotNullParameter(r101, "binding");
        this.f308407a = r100;
        this.f308408b = r101;
        this.f308410d = "";
        this.f308411e = LazyKt.lazy(new r(this));
        this.f308412f = LazyKt.lazy(new s(this));
        this.f308413g = LazyKt.lazy(new t(this));
        this.f308414h = LazyKt.lazy(new u(this));
    }

    public final void a(int r110, OuterInputEventBus.OuterInputEvent r111) {
        FLogger r100 = FLogger.f375446a;
        r100.i("OuterInputEventHandler", "handleTouchEvent, eventId:" + r110);
        ICoreInputAbility r101 = (ICoreInputAbility) this.f308414h.getValue();
        if (r101 == null) goto L6;
        r101.s3(100);
    L6:
        switch(r110) {
            case 201: goto L14;
            case 202: goto L11;
            case 203: goto L8;
            default: goto L33;
        };
    L8:
        LarusWidgetInputBinding r112 = this.f308408b.invoke();
        if (r112 == null) goto L17;
        View r113 = r112.f351513w;
    L18:
        if (r111 != null) goto L20;
        return;
    L20:
        r100.i("OuterInputEventHandler", "handleTouchEvent, downEvent:" + r111);
        if (r113 == null) goto L23;
        r113.setTag(R.id.chat_input_touch_delta, TuplesKt.to(Float.valueOf(r111.f308404d), Float.valueOf(r111.f308405e)));
    L23:
        if (r113 == null) goto L25;
        MutableSharedFlow<Integer> r102 = OuterInputEventBus.f308397a;
        Intrinsics.checkNotNullParameter(r111, "<this>");
        r113.dispatchTouchEvent(MotionEvent.obtain(System.currentTimeMillis(), System.currentTimeMillis(), r111.f308401a, r111.f308402b, r111.f308403c, 0));
    L25:
        TraceFragment r114 = this.f308407a;
        if (r114 == null) goto L34;
        LifecycleCoroutineScope r103 = LifecycleOwnerKt.getLifecycleScope(r114);
        if (r103 == null) goto L35;
        BuildersKt.launch$default(r103, null, null, new OuterInputEventHandler$doHandleTouchEvent$1(this, r113, null), 3, null);
        return;
    L35:
        return;
    L34:
        return;
    L17:
        r113 = null;
        goto L18
    L11:
        LarusWidgetInputBinding r115 = this.f308408b.invoke();
        if (r115 == null) goto L31;
        r113 = r115.R;
        goto L18
    L31:
        r113 = null;
        goto L18
    L14:
        LarusWidgetInputBinding r116 = this.f308408b.invoke();
        if (r116 == null) goto L32;
        r113 = r116.M;
        goto L18
    L32:
        r113 = null;
        goto L18
    L33:
        r113 = null;
        goto L18
    }

    public final void d(Integer r100, String r101, OuterInputEventBus.OuterInputEvent r102) {
        Intrinsics.checkNotNullParameter(r101, "tabKey");
        this.f308410d = r101;
        FLogger.f375446a.i("OuterInputEventHandler", "handleEvent2, tabKey:".concat(r101));
        if (r100 == null) goto L11;
        r100.intValue();
        if (r100.intValue() >= 101) goto L7;
        return;
    L7:
        if (r100.intValue() >= 201) goto L9;
        b(r100.intValue());
        return;
    L9:
        a(r100.intValue(), r102);
        return;
    }
}
