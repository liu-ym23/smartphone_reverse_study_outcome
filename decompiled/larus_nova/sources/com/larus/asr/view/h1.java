package com.larus.asr.view;

import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.asr.api.databinding.LarusWidgetSpeakerHandsfreeBinding;
import com.larus.nova.R;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes3.dex */
public final class h1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f288160a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f288161b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f288162c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f288163d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Function0<Unit> f288164e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Function1<? super Boolean, Unit> f288165f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Function1<? super Boolean, Unit> f288166g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f288167h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f288168i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f288169j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final i1 f288170k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public LarusWidgetSpeakerHandsfreeBinding f288171l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Integer f288172m;

    public static final class a {
    }

    static {
    }

    public final boolean b() {
        if (this.f288161b == false) goto L5;
    L8:
        return true;
    L5:
        if (this.f288162c == true) goto L8;
        return false;
    }

    public final void g() {
        boolean r100 = this.f288160a;
        boolean r101 = this.f288162c;
        LarusWidgetSpeakerHandsfreeBinding r102 = this.f288171l;
        if (r102 != null) goto L6;
        FLogger.f375446a.w("HandsfreeManager", "[HF] updateHandsFreeUI: handsfreeBinding is null");
        return;
    L6:
        FLogger r103 = FLogger.f375446a;
        StringBuilder r104 = new StringBuilder("[HF] updateHandsFreeUI begin: enable=");
        r104.append(r100);
        r104.append(" locked=");
        r104.append(r101);
        r104.append(" rootVis=");
        boolean r105 = true;
        if (r102.f287195a.getVisibility() != 0) goto L9;
        boolean r106 = true;
    L10:
        r104.append(r106);
        r103.i("HandsfreeManager", r104.toString());
        if (r100 == false) goto L13;
        com.larus.utils.e1.x(r102.f287196b);
        com.larus.utils.e1.x(r102.f287197c);
    L14:
        if (r100 == true) goto L16;
        return;
    L16:
        if (r101 == false) goto L22;
        d(r102);
        int r107 = this.f288163d;
        ImageView r108 = r102.f287197c;
        if (r107 != 0) goto L20;
        int r109 = R.drawable.larus_ic_hands_free_delete_trash_v1;
    L21:
        r108.setBackgroundResource(r109);
        com.larus.utils.e1.x(r102.f287200f);
    L23:
        StringBuilder r110 = new StringBuilder("[HF] updateHandsFreeUI done: functionBg=");
        if (r102.f287196b.getVisibility() != 0) goto L26;
        boolean r111 = true;
    L27:
        r110.append(r111);
        r110.append(" handsFreeFunction=");
        if (r102.f287197c.getVisibility() != 0) goto L30;
        boolean r112 = true;
    L31:
        r110.append(r112);
        r110.append(" handsFreeSendBg=");
        if (r102.f287200f.getVisibility() == 0) goto L35;
        r105 = false;
    L35:
        r110.append(r105);
        r103.i("HandsfreeManager", r110.toString());
        return;
    L30:
        r112 = false;
        goto L31
    L26:
        r111 = false;
        goto L27
    L20:
        r109 = R.drawable.larus_ic_hands_free_delete_x_v1;
        goto L21
    L22:
        i(r102, false);
        goto L23
    L13:
        d(r102);
        com.larus.utils.e1.o(r102.f287196b);
        com.larus.utils.e1.o(r102.f287197c);
        com.larus.utils.e1.o(r102.f287200f);
        goto L14
    L9:
        r106 = false;
        goto L10
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [com.larus.asr.view.c1] */
    public h1() {
        this.f288164e = new z0();
        this.f288165f = new a1();
        this.f288166g = new b1();
        this.f288170k = new i1(new c1());
    }

    public final void a(LarusWidgetSpeakerHandsfreeBinding r100) {
        Integer r101 = this.f288172m;
        if (r101 == null) goto L14;
        int r102 = r101.intValue();
        FrameLayout r103 = r100.f287198d;
        ViewGroup.LayoutParams r104 = r103.getLayoutParams();
        if (r104 == null) goto L13;
        ViewGroup.MarginLayoutParams r105 = (ViewGroup.MarginLayoutParams) r104;
        r105.setMarginStart(r102);
        r103.setLayoutParams(r105);
        FrameLayout r106 = r100.f287200f;
        ViewGroup.LayoutParams r107 = r106.getLayoutParams();
        if (r107 == null) goto L11;
        ViewGroup.MarginLayoutParams r108 = (ViewGroup.MarginLayoutParams) r107;
        r108.setMarginEnd(r102);
        r106.setLayoutParams(r108);
        return;
    L11:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L13:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    public final void d(LarusWidgetSpeakerHandsfreeBinding r100) {
        this.f288168i = false;
        this.f288169j = false;
        e(r100, false);
        f(r100, false);
    }

    public static void e(LarusWidgetSpeakerHandsfreeBinding r100, boolean r101) {
        if (r101 == false) goto L6;
        Drawable r102 = r100.f287197c.getBackground();
        if (r102 == null) goto L10;
        r102.setColorFilter(ColorProtector.parseColor("#FFE5E5E5"), PorterDuff.Mode.SRC_IN);
        return;
    L10:
        return;
    L6:
        Drawable r103 = r100.f287197c.getBackground();
        if (r103 == null) goto L12;
        r103.clearColorFilter();
        return;
    }

    public static void f(LarusWidgetSpeakerHandsfreeBinding r100, boolean r101) {
        if (r101 == false) goto L4;
        r100.f287199e.setColorFilter(ColorProtector.parseColor("#FFE5E5E5"), PorterDuff.Mode.SRC_IN);
        return;
    L4:
        r100.f287199e.clearColorFilter();
    }

    public final void i(LarusWidgetSpeakerHandsfreeBinding r100, boolean r101) {
        d(r100);
        ImageView r102 = r100.f287197c;
        if (r101 == false) goto L5;
        int r103 = R.drawable.larus_ic_hands_free_lock_v1;
    L6:
        r102.setBackgroundResource(r103);
        com.larus.utils.e1.o(r100.f287200f);
        if (z2.f365865a.voiceInputHandsfreeConfig().isHandsfreeSupported() == false) goto L13;
        if (r101 == false) goto L10;
        float r104 = 1.2f;
    L11:
        r100.f287197c.animate().scaleX(r104).scaleY(r104).setDuration(120).start();
        return;
    L10:
        r104 = 1.0f;
        goto L11
    L13:
        return;
    L5:
        r103 = R.drawable.larus_ic_hands_free_unlock_v1;
        goto L6
    }

    public static boolean c(View r100, int r101, int r102) {
        if (r100.getVisibility() != 0) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == true) goto L8;
        return false;
    L8:
        Rect r104 = new Rect();
        r100.getGlobalVisibleRect(r104);
        return r104.contains(r101, r102);
    L5:
        r103 = false;
        goto L6
    }

    public final void h(LarusWidgetSpeakerHandsfreeBinding r100, int r101, int r102) {
        boolean r103 = c(r100.f287198d, r101, r102);
        boolean r104 = c(r100.f287200f, r101, r102);
        if (r103 == this.f288168i) goto L6;
        this.f288168i = r103;
        e(r100, r103);
    L6:
        if (r104 == this.f288169j) goto L9;
        this.f288169j = r104;
        f(r100, r104);
        return;
    }
}
