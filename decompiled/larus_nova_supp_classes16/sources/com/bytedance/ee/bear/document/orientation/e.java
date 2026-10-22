package com.bytedance.ee.bear.document.orientation;

import android.content.res.Resources;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.bizwidget.helper.FGDowngradeHelper;
import com.bytedance.ee.bear.document.forseti.PageSelectedViewModel;
import com.bytedance.ee.bear.document.forseti.PageUnSelectedViewModel;
import kotlin.Lazy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class e implements com.bytedance.ee.bear.document.plugin.selection.a {
    public int a;
    public boolean b;
    public final c c;
    public d d;
    public boolean e;
    public boolean f;
    public boolean g;

    public class a extends com.bytedance.ee.bear.widgets.t {
        public final /* synthetic */ boolean c;
        public final /* synthetic */ e d;

        public final void a(View r4) {
            final e r5 = this.d;
            final boolean r0 = this.c;
            if (r5.c == null) goto L8;
            d r1 = r5.d;
            if (r1 == null) goto L9;
            r1.a.setVisibility(8);
            r5.d.a.post(new com.bytedance.ee.bear.document.orientation.a(r5, r0));
            return;
        L9:
            return;
        }

        public a(e r1, boolean r2) {
            this.d = r1;
            this.c = r2;
        }
    }

    public class b extends com.bytedance.ee.bear.widgets.t {
        public final /* synthetic */ e c;

        public b(e r1) {
            this.c = r1;
        }

        public final void a(View r3) {
            final e r4 = this.c;
            if (r4.c == null) goto L8;
            d r0 = r4.d;
            if (r0 == null) goto L9;
            r0.a.setVisibility(8);
            r4.d.a.post(new com.bytedance.ee.bear.document.orientation.d(r4));
            return;
        L9:
            return;
        }
    }

    public interface c {
        int a();

        void b(int r1);

        void c();

        void d();

        void e(boolean r1);

        void f();

        Fragment getHostFragment();
    }

    public class d {
        public final View a;
        public final View b;

        public d(View r2) {
            this.a = r2;
            this.b = r2.findViewById(2131381670);
        }
    }

    @Override // com.bytedance.ee.bear.document.plugin.selection.a
    public final void a() {
        d r0 = this.d;
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L11;
        e();
        this.f = true;
        return;
    L11:
        return;
    L5:
        if (r0.a.getVisibility() != 0) goto L7;
        r1 = true;
        goto L8
    }

    @Override // com.bytedance.ee.bear.document.plugin.selection.a
    public final void b() {
        if (this.f == false) goto L6;
        this.d.a.setVisibility(0);
        this.f = false;
        return;
    }

    public final void c() {
        if (this.e == false) goto L12;
        boolean r0 = false;
        this.e = false;
        d r1 = this.d;
        if (r1 != null) goto L7;
    L9:
        if (r0 == false) goto L13;
        e();
        this.f = true;
        return;
    L13:
        return;
    L7:
        if (r1.a.getVisibility() != 0) goto L9;
        r0 = true;
        goto L9
    }

    public final void d() {
        if (this.e == true) goto L10;
        this.e = true;
        d r0 = this.d;
        if (r0 != null) goto L7;
        return;
    L7:
        if (this.f == false) goto L12;
        r0.a.setVisibility(0);
        this.f = false;
        return;
    L12:
        return;
    }

    public final void e() {
        d r0 = this.d;
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L10;
        Animation r2 = AnimationUtils.loadAnimation(this.d.a.getContext(), 2130772529);
        this.d.a.startAnimation(r2);
        this.d.a.setVisibility(8);
    L10:
        this.f = false;
        return;
    L5:
        if (r0.a.getVisibility() != 0) goto L7;
        r1 = true;
        goto L8
    }

    public final void f() {
        c r0 = this.c;     // Catch: Exception -> L18
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.getHostFragment() != null) goto L7;
        return;
    L7:
        if (this.c.getHostFragment().getActivity() != null) goto L9;
        return;
    L9:
        if (ForsetiHelper.s(this.c.getHostFragment()) == true) goto L11;
        return;
    L11:
        if (ForsetiHelper.e() == false) goto L27;
        FragmentActivity r1 = this.c.getHostFragment().getActivity();     // Catch: Exception -> L18
        Lazy r2 = FGDowngradeHelper.a;     // Catch: Exception -> L18
        if (FGDowngradeHelper.b() == false) goto L15;
        FragmentActivity r3 = this.c.getHostFragment().getActivity();     // Catch: Exception -> L18
    L16:
        final PageUnSelectedViewModel r4 = (PageUnSelectedViewModel) new ViewModelProvider(r1).get(PageUnSelectedViewModel.class);     // Catch: Exception -> L18
        r4.getPageUnSelected().observe(r3, new com.bytedance.ee.bear.document.orientation.b(this, r4));     // Catch: Exception -> L18
        final PageSelectedViewModel r5 = (PageSelectedViewModel) new ViewModelProvider(r1).get(PageSelectedViewModel.class);     // Catch: Exception -> L18
        r5.getPageSelected().observe(r3, new com.bytedance.ee.bear.document.orientation.c(this, r5));     // Catch: Exception -> L18
        return;
    L15:
        r3 = this.c.getHostFragment();     // Catch: Exception -> L18
        goto L16
    L27:
        return;
    L18:
        e = move-exception;
        tt5.a.d("DocsOrientationTipPresenter", "observePageUnSelected:" + e);
    }

    public final void g() {
        tt5.a.h("DocsOrientationTipPresenter", "onResume() called applyWindowInsets:" + this.b);
        if (this.b == true) goto L5;
        return;
    L5:
        if (ForsetiHelper.s(this.c.getHostFragment()) == true) goto L7;
        return;
    L7:
        if (ForsetiHelper.e() == false) goto L18;
        c r0 = this.c;
        if (r0 != null) goto L11;
        return;
    L11:
        if (r0.getHostFragment() != null) goto L13;
        return;
    L13:
        if (this.c.getHostFragment().getView() == null) goto L21;
        this.b = false;
        this.c.getHostFragment().getView().requestApplyInsets();
        return;
    L21:
        return;
    }

    public e(c r3) {
        this.a = -1;
        this.b = false;
        this.e = true;
        this.g = false;
        this.c = r3;
    }

    public final void i(boolean r3) {
        h(r3, 2131168416, new a(this, r3));
    }

    public final void j(boolean r3) {
        h(!r3, 2131168421, new b(this));
    }

    public final void h(boolean r6, int r7, com.bytedance.ee.bear.widgets.t r8) {
        if (this.e == true) goto L5;
        return;
    L5:
        if (this.d == null) goto L29;
        c r0 = this.c;
        if (r0 == null) goto L10;
        r0.c();
    L10:
        Resources r1 = this.d.a.getResources();
        int r2 = r1.getDimensionPixelSize(2131167893);
        int r9 = r1.getDimensionPixelSize(r7);
        int r3 = r1.getDimensionPixelSize(2131167892);
        int r4 = 0;
        this.d.a.setVisibility(0);
        View r5 = this.d.b;
        if (r6 == false) goto L13;
        float r10 = -90.0f;
    L14:
        r5.setRotation(r10);
        if ((this.d.b.getParent() instanceof View) == false) goto L18;
        r4 = ((View) this.d.b.getParent()).getWidth();
    L18:
        if (ForsetiHelper.s(this.c.getHostFragment()) == false) goto L21;
        if (r4 <= 0) goto L21;
    L22:
        View r11 = this.d.b;
        if (r6 == false) goto L25;
        float r12 = r3;
    L26:
        r11.setTranslationX(r12);
        this.d.b.setTranslationY(r9);
        this.d.b.setOnClickListener(r8);
        this.d.a.startAnimation(AnimationUtils.loadAnimation(this.d.a.getContext(), 2130772620));
        return;
    L25:
        r12 = (r4 - r2) - r3;
    L21:
        r4 = com.bytedance.ee.util.ui.n.v();
        goto L22
    L13:
        r10 = 90.0f;
        goto L14
    }
}
