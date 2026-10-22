package com.larus.bmhome.chat.list.cell.prompt;

import android.view.View;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.layout.item.PromptSpan;
import com.larus.im.bean.message.Message;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes25.dex */
public final class s1 implements View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f305691a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ICoreInputAbility f305692b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final va8.o f305693c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function0<Message> f305694d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function1<Boolean, Unit> f305695e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f305696f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f305697g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f305698h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f305699i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final r1 f305700j;

    public final void a() {
        Message r100 = this.f305694d.invoke();
        String r101 = null;
        boolean r102 = false;
        if (r100 != null) goto L5;
    L25:
        boolean r103 = false;
    L26:
        if (r103 == false) goto L38;
        va8.o r104 = this.f305693c;
        if (r104 == null) goto L30;
        r101 = r104.u7();
    L30:
        if (r101 != null) goto L32;
    L33:
        r102 = true;
    L34:
        if (r102 == true) goto L39;
        this.f305699i = true;
        b(this.f305691a.isAttachedToWindow());
        c(true, true);
        return;
    L39:
        return;
    L32:
        if (StringsKt.isBlank(r101) == false) goto L34;
    L38:
        return;
    L5:
        if (com.larus.bmhome.chat.bean.d.W0(r100) == true) goto L8;
        r100 = null;
    L8:
        if (r100 == null) goto L25;
        Map<String, String> r105 = r100.getBusinessExt();
        if (r105 == null) goto L16;
        String r106 = r105.get("next_pulse_scene");
        if (r106 == null) goto L16;
        Integer r107 = StringsKt.toIntOrNull(r106);
        if (r107 == null) goto L16;
    L20:
        if (r107 == null) goto L25;
        if (r107.intValue() != 10) goto L25;
        r103 = true;
    L16:
        String r108 = (String) com.larus.bmhome.chat.bean.d.x(r100).get("next_pulse_scene");
        if (r108 == null) goto L19;
        r107 = StringsKt.toIntOrNull(r108);
        goto L20
    L19:
        r107 = null;
        goto L20
    }

    public final boolean e() {
        Message r100 = this.f305694d.invoke();
        if (r100 == null) goto L31;
        Integer r101 = null;
        if (com.larus.bmhome.chat.bean.d.W0(r100) == true) goto L8;
        r100 = null;
    L8:
        if (r100 == null) goto L33;
        Map<String, String> r102 = r100.getBusinessExt();
        if (r102 == null) goto L18;
        String r103 = r102.get("next_pulse_scene");
        if (r103 == null) goto L18;
        Integer r104 = StringsKt.toIntOrNull(r103);
        if (r104 == null) goto L18;
        r101 = r104;
    L21:
        if (r101 != null) goto L24;
    L25:
        if (r101 != null) goto L28;
        return false;
    L28:
        if (r101.intValue() != 11) goto L32;
    L29:
        return true;
    L32:
        return false;
    L24:
        if (r101.intValue() == 12) goto L29;
    L18:
        String r105 = (String) com.larus.bmhome.chat.bean.d.x(r100).get("next_pulse_scene");
        if (r105 == null) goto L21;
        r101 = StringsKt.toIntOrNull(r105);
        goto L21
    L33:
        return false;
    L31:
        return false;
    }

    public final boolean d() {
        if (e() == false) goto L5;
    L6:
        va8.o r100 = this.f305693c;
        if (r100 == null) goto L9;
        String r101 = r100.u7();
    L11:
        if (r101 != null) goto L13;
    L16:
        boolean r102 = true;
    L17:
        if (r102 == true) goto L21;
        return true;
    L21:
        return false;
    L13:
        if (StringsKt.isBlank(r101) == true) goto L16;
        r102 = false;
        goto L17
    L9:
        r101 = null;
        goto L11
    L5:
        if (this.f305699i == true) goto L6;
        return false;
    }

    public final void f() {
        if (e() == true) goto L7;
        if (this.f305699i == true) goto L7;
    L9:
        boolean r100 = false;
    L10:
        b(r100);
        c(d(), false);
        return;
    L7:
        if (this.f305691a.isAttachedToWindow() == false) goto L9;
        r100 = true;
        goto L10
    }

    public final void b(boolean r100) {
        if (this.f305697g != r100) goto L5;
        return;
    L5:
        if (r100 == false) goto L9;
        ICoreInputAbility r101 = this.f305692b;
        if (r101 == null) goto L12;
        r101.QG(this.f305700j);
    L12:
        this.f305697g = r100;
        return;
    L9:
        ICoreInputAbility r102 = this.f305692b;
        if (r102 == null) goto L12;
        r102.Vs(this.f305700j);
        goto L12
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        f();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        b(false);
        this.f305691a.animate().cancel();
        this.f305691a.setAlpha(1.0f);
    }

    public final void c(boolean r100, boolean r110) {
        this.f305691a.animate().cancel();
        boolean r101 = true;
        View r102 = null;
        if (r100 == true) goto L5;
    L16:
        this.f305696f = r100;
        float r103 = 0.0f;
        if (r100 == false) goto L24;
        if (r110 == true) goto L20;
    L22:
        lf8.a.e(this.f305691a);
        this.f305691a.setAlpha(1.0f);
        this.f305695e.invoke(Boolean.TRUE);
        return;
    L20:
        if (this.f305691a.isShown() == false) goto L22;
        this.f305691a.animate().alpha(0.0f).setDuration(150).withEndAction(new q1(this)).start();
        return;
    L24:
        if (this.f305698h == false) goto L47;
        Object r104 = this.f305691a.getParent();
        if ((r104 instanceof View) == false) goto L29;
        r102 = (View) r104;
    L29:
        if (r102 != null) goto L31;
    L33:
        r101 = false;
    L34:
        if (r101 == false) goto L36;
        r103 = this.f305691a.getAlpha();
    L36:
        lf8.a.f(this.f305691a);
        this.f305698h = false;
        this.f305695e.invoke(Boolean.FALSE);
        View r105 = this.f305691a;
        if (r110 == true) goto L40;
        r103 = 1.0f;
    L40:
        r105.setAlpha(r103);
        if (r110 == false) goto L46;
        this.f305691a.animate().alpha(1.0f).setDuration(150).start();
        return;
    L46:
        return;
    L31:
        if (r102.getVisibility() != 0) goto L33;
    L47:
        return;
    L5:
        if (this.f305696f == true) goto L16;
        Object r106 = this.f305691a.getParent();
        if ((r106 instanceof View) == false) goto L9;
        View r107 = (View) r106;
    L10:
        if (r107 != null) goto L12;
    L14:
        boolean r108 = false;
    L15:
        this.f305698h = r108;
        goto L16
    L12:
        if (r107.getVisibility() != 0) goto L14;
        r108 = true;
        goto L15
    L9:
        r107 = null;
        goto L10
    }

    public s1(PromptSpan r100, ICoreInputAbility r101, va8.o r102, d0 r103, e0 r104) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r103, "source");
        Intrinsics.checkNotNullParameter(r104, "onVisibilityChanged");
        this.f305691a = r100;
        this.f305692b = r101;
        this.f305693c = r102;
        this.f305694d = r103;
        this.f305695e = r104;
        this.f305700j = new r1(this);
        r100.addOnAttachStateChangeListener(this);
        if (r100.isAttachedToWindow() == false) goto L6;
        f();
        return;
    }
}
