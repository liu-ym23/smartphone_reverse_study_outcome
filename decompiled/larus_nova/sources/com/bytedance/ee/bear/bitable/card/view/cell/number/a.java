package com.bytedance.ee.bear.bitable.card.view.cell.number;

import android.content.Context;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f207921a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final STNumberKeyboardView f207922b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f207923c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public c f207924d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public d f207925e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public e f207926f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f207927g;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.bitable.card.view.cell.number.a$a, reason: collision with other inner class name */
    public class AnimationAnimationListenerC3001a implements Animation.AnimationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f207928a;

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationRepeat(Animation r100) {
        }

        public AnimationAnimationListenerC3001a(a r100) {
            this.f207928a = r100;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationEnd(Animation r100) {
            e r101 = this.f207928a.f207926f;
            if (r101 == null) goto L6;
            r101.a();
            return;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationStart(Animation r100) {
            e r101 = this.f207928a.f207926f;
            if (r101 == null) goto L6;
            r101.b();
            return;
        }
    }

    public class b implements Animation.AnimationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f207929a;

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationRepeat(Animation r100) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationStart(Animation r100) {
        }

        public b(a r100) {
            this.f207929a = r100;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationEnd(Animation r100) {
            a r101 = this.f207929a;
            View r102 = r101.f207921a;
            if (r102 == null) goto L10;
            r102.setVisibility(8);
            if (r101.f207927g == true) goto L8;
            a.e(r101.f207921a);
        L8:
            tt5.a.h("NumberEditPanel", "removeRootView");
            return;
        }
    }

    public interface c {
        void a(boolean r100);
    }

    public interface d {
        void a(int r100);
    }

    public interface e {
        void a();

        void b();
    }

    public final boolean b() {
        View r100 = this.f207921a;
        if (r100 != null) goto L5;
    L8:
        tt5.a.h("NumberEditPanel", "clearAnimationIfNeed false");
        return false;
    L5:
        if (r100.getAnimation() == null) goto L8;
        this.f207921a.clearAnimation();
        tt5.a.h("NumberEditPanel", "clearAnimationIfNeed true");
        return true;
    }

    public static void e(View r100) {
        if (r100 == null) goto L6;
        ViewParent r101 = r100.getParent();
        if ((r101 instanceof ViewGroup) == false) goto L6;
        ((ViewGroup) r101).removeView(r100);
    L6:
        tt5.a.h("NumberEditPanel", "unBindView");
    }

    public final void a(Editable r100) {
        if (this.f207923c == false) goto L9;
        STNumberKeyboardView r101 = this.f207922b;
        if (r101 == null) goto L10;
        if (r100 == null) goto L11;
        r101.f207920a = r100;
        return;
    L11:
        return;
    L10:
        return;
    }

    public final void c(boolean r110) {
        if (this.f207923c == false) goto L24;
        View r100 = this.f207921a;
        if (r100 == null) goto L24;
        if ((r100.getParent() instanceof ViewGroup) == false) goto L24;
        this.f207923c = false;
        STNumberKeyboardView r101 = this.f207922b;
        if (r101 == null) goto L11;
        r101.f207920a = null;
    L11:
        c r102 = this.f207924d;
        if (r102 == null) goto L15;
        r102.a(r110);
    L15:
        if (b() == false) goto L23;
        View r111 = this.f207921a;
        if (r111 == null) goto L24;
        r111.setVisibility(8);
        if (this.f207927g == true) goto L22;
        e(this.f207921a);
    L22:
        tt5.a.h("NumberEditPanel", "removeRootView");
        goto L24
    L23:
        TranslateAnimation r112 = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, 1.0f);
        r112.setDuration(200);
        r112.setAnimationListener(new b(this));
        this.f207921a.startAnimation(r112);
    L24:
        tt5.a.h("NumberEditPanel", "dismiss");
    }

    public a(Context r100, boolean r101) {
        this.f207927g = false;
        View r102 = LayoutInflater.from(r100).inflate(R.layout.bitable_card_number_edit_panel, null);
        this.f207921a = r102;
        wp4.a r103 = new wp4.a();
        STNumberKeyboardView r104 = (STNumberKeyboardView) r102.findViewById(R.id.number_keyboard_view);
        this.f207922b = r104;
        Intrinsics.checkNotNullParameter(r104, "keyboardView");
        Intrinsics.checkNotNullParameter(this, "panel");
        r104.setOnKeyboardActionListener(new wp4.b(r104, r103, this));
        this.f207927g = r101;
    }

    public final void d(ViewGroup r110, Editable r111) {
        tt5.a.h("NumberEditPanel", "show");
        b();
        if (this.f207927g == true) goto L5;
        e(this.f207921a);
    L5:
        if (r110 == null) goto L21;
        View r100 = this.f207921a;
        if (r100 == null) goto L22;
        this.f207923c = true;
        STNumberKeyboardView r101 = this.f207922b;
        if (r101 == null) goto L11;
        r101.f207920a = r111;
    L11:
        r100.setVisibility(0);
        if (this.f207927g == true) goto L14;
        FrameLayout.LayoutParams r112 = new FrameLayout.LayoutParams(-1, -2);
        r112.gravity = 80;
        r110.addView(this.f207921a, r112);
    L19:
        TranslateAnimation r113 = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
        r113.setDuration(200);
        r113.setAnimationListener(new AnimationAnimationListenerC3001a(this));
        this.f207921a.startAnimation(r113);
        return;
    L14:
        if (r110 == this.f207921a.getParent()) goto L16;
    L17:
        e(this.f207921a);
        FrameLayout.LayoutParams r114 = new FrameLayout.LayoutParams(-1, -2);
        r114.gravity = 80;
        r110.addView(this.f207921a, r114);
        goto L19
    L16:
        if (r110.indexOfChild(this.f207921a) == (r110.getChildCount() - 1)) goto L19;
    L22:
        return;
    }
}
