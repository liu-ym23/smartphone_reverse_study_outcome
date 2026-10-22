package com.larus.bmhome.chat.component.bottom.core;

import android.widget.EditText;
import android.widget.ImageView;
import com.larus.input.impl.databinding.LarusWidgetInputBinding;
import com.larus.platform.model.chat.MessageModifyStyle;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes25.dex */
public final class l7 implements Function0<Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CoreInputComponent f299289a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ EditText f299290b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ LarusWidgetInputBinding f299291c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<String> f299292d;

    public l7(CoreInputComponent r100, EditText r101, LarusWidgetInputBinding r102, Ref.ObjectRef<String> r103) {
        this.f299289a = r100;
        this.f299290b = r101;
        this.f299291c = r102;
        this.f299292d = r103;
    }

    /* JADX WARN: Type inference failed for: r1v4, types: [T, java.lang.String] */
    @Override // kotlin.jvm.functions.Function0
    public final Unit invoke() {
        CoreInputComponent r100 = this.f299289a;
        EditText r101 = this.f299290b;
        int r102 = CoreInputComponent.f298338d3;
        r100.getClass();
        boolean r103 = true;
        if (CoreInputComponent.d5(r101) <= 1) goto L5;
        r100.h3();
    L7:
        if (this.f299289a.k4().Y() == false) goto L57;
        int r104 = this.f299289a.F4().getCurrentInputStatus();
        if (r104 != 3) goto L11;
    L17:
        boolean r105 = true;
    L18:
        if (r105 == true) goto L20;
    L41:
        com.larus.utils.e1.o(this.f299291c.f351501k);
        com.larus.bmhome.chat.component.bottom.voice.a r106 = this.f299289a.Zd();
        if (r106 != null) goto L44;
    L46:
        boolean r107 = false;
    L47:
        if (r107 == true) goto L57;
        CoreInputComponent r108 = this.f299289a;
        com.larus.bmhome.chat.component.bottom.voice.a r109 = r108.Zd();
        if (r109 != null) goto L51;
    L53:
        r103 = false;
    L54:
        if (r103 == false) goto L57;
        r108.z3();
        goto L57
    L51:
        if (r109.q40() != true) goto L53;
    L44:
        if (r106.DG() != true) goto L46;
        r107 = true;
        goto L47
    L20:
        if (this.f299289a.r6(this.f299290b) == false) goto L41;
        if (com.larus.utils.e1.r(this.f299291c.f351501k) == false) goto L24;
        this.f299289a.F4().trackOnShowFullInputBoxButton(this.f299292d.element);
    L24:
        ImageView r110 = this.f299289a.P1;
        if (r110 != null) goto L27;
    L31:
        com.larus.utils.e1.x(this.f299291c.f351501k);
        CoreInputComponent r111 = this.f299289a;
        com.larus.bmhome.chat.component.bottom.voice.a r112 = r111.Zd();
        if (r112 != null) goto L34;
    L36:
        r103 = false;
    L37:
        if (r103 == false) goto L40;
        r111.p3();
    L40:
        this.f299289a.F4().setIsShowFullInputBox();
        goto L57
    L34:
        if (r112.q40() != true) goto L36;
    L27:
        if (r110.getVisibility() != 0) goto L29;
        boolean r113 = true;
    L30:
        if (r113 == true) goto L40;
    L29:
        r113 = false;
        goto L30
    L11:
        if (r104 == 4) goto L14;
    L16:
        r105 = false;
        goto L18
    L14:
        if (com.larus.platform.service.z2.f365865a.messageModifyConfig().f365575a != MessageModifyStyle.FULL_BOX) goto L16;
    L57:
        Ref.ObjectRef<String> r114 = this.f299292d;
        r114.element = this.f299290b.getText().toString();
        this.f299289a.u6();
        this.f299289a.E5();
        return Unit.INSTANCE;
    L5:
        r100.m3();
        goto L7
    }
}
