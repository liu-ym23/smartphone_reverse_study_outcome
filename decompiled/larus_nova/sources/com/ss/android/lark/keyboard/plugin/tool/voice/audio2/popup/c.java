package com.ss.android.lark.keyboard.plugin.tool.voice.audio2.popup;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AudioPopupWindowImpl f429978a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f429979b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f429980c;

    public static final class a implements View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f429981a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AudioPopupWindowImpl f429982b;

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r100) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r100) {
            this.f429981a.removeOnAttachStateChangeListener(this);
            AudioPopupWindowImpl r101 = this.f429982b;
            ViewCompat.setOnApplyWindowInsetsListener(r101.f429945d, new b(r101));
            ViewCompat.requestApplyInsets(this.f429982b.f429945d);
        }

        public a(View r100, AudioPopupWindowImpl r101) {
            this.f429981a = r100;
            this.f429982b = r101;
        }
    }

    public static final class b implements OnApplyWindowInsetsListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AudioPopupWindowImpl f429983a;

        public b(AudioPopupWindowImpl r100) {
            this.f429983a = r100;
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public final WindowInsetsCompat onApplyWindowInsets(View r100, WindowInsetsCompat r101) {
            Intrinsics.checkNotNullParameter(r100, "<unused var>");
            Intrinsics.checkNotNullParameter(r101, "insets");
            Insets r102 = r101.getInsets(WindowInsetsCompat.Type.systemBars());
            FrameLayout r103 = this.f429983a.f429945d;
            int r104 = r102.bottom;
            r103.setPadding(r103.getPaddingLeft(), r103.getPaddingTop(), r103.getPaddingRight(), r104);
            return r101;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.keyboard.plugin.tool.voice.audio2.popup.c$c, reason: collision with other inner class name */
    public static final class ViewOnClickListenerC5109c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ViewOnClickListenerC5109c f429984a = null;

        static {
            f429984a = new ViewOnClickListenerC5109c();
        }

        public ViewOnClickListenerC5109c() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
        }
    }

    public final void a() {
        AudioPopupWindowImpl r100 = this.f429978a;
        ViewGroup r101 = null;
        if (r100.f429950i != this) goto L5;
        r100.f429950i = null;
    L5:
        com.ss.android.lark.keyboard.plugin.tool.voice.audio2.popup.abs.a r102 = r100.f429946e;
        if (r102 == null) goto L8;
        View r103 = r102.getContentView();
    L10:
        if (this.f429978a.isShown() == false) goto L12;
        return;
    L12:
        com.ss.android.lark.keyboard.plugin.tool.voice.audio2.popup.abs.a r104 = this.f429978a.f429946e;
        if (r104 == null) goto L16;
        Pair<Integer, Integer> r105 = r104.getLayoutParamAttributes();
        if (r105 == null) goto L16;
    L17:
        if (r103 == null) goto L19;
        ViewParent r106 = r103.getParent();
    L21:
        if ((r106 instanceof ViewGroup) == false) goto L23;
        ViewGroup r107 = (ViewGroup) r106;
    L24:
        if (r107 == null) goto L26;
        r107.removeView(r103);
    L26:
        this.f429978a.f429944c.removeAllViews();
        if (r103 == null) goto L32;
        AudioPopupWindowImpl r108 = this.f429978a;
        if (r103.isAttachedToWindow() == false) goto L31;
        ViewCompat.setOnApplyWindowInsetsListener(r108.f429945d, new b(r108));
        ViewCompat.requestApplyInsets(r108.f429945d);
        goto L32
    L31:
        r103.addOnAttachStateChangeListener(new a(r103, r108));
    L32:
        AudioPopupWindowImpl r109 = this.f429978a;
        AudioPopupWindowImpl.b r110 = r109.f429944c;
        FrameLayout r111 = r109.f429945d;
        r111.addView(r103, new FrameLayout.LayoutParams(r105.getFirst().intValue(), r105.getSecond().intValue(), 80));
        r111.setOnClickListener(ViewOnClickListenerC5109c.f429984a);
        r110.addView(r111, new AudioPopupWindowImpl.b.a(r105.getFirst().intValue(), r105.getSecond().intValue(), this.f429979b, this.f429980c));
        AudioPopupWindowImpl r112 = this.f429978a;
        Drawable r113 = r112.f429947f;
        if (r113 == null) goto L35;
        r112.f429944c.setBackground(r113);
    L35:
        ViewParent r114 = this.f429978a.f429944c.getParent();
        if ((r114 instanceof ViewGroup) == false) goto L38;
        r101 = (ViewGroup) r114;
    L38:
        if (r101 == null) goto L40;
        r101.removeView(this.f429978a.f429944c);
    L40:
        ViewGroup r115 = this.f429978a.f429943b.a();
        if (r115 == null) goto L43;
        r115.addView(this.f429978a.f429944c, new ViewGroup.LayoutParams(-1, -1));
    L43:
        this.f429978a.f429944c.setFocusableInTouchMode(true);
        this.f429978a.f429944c.requestFocus();
        return;
    L23:
        r107 = null;
        goto L24
    L19:
        r106 = null;
    L16:
        r105 = new Pair(-1, -2);
        goto L17
    L8:
        r103 = null;
        goto L10
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public c(AudioPopupWindowImpl r100) {
        this.f429978a = r100;
        this.f429979b = 8388691;
        this.f429980c = 0;
    }
}
