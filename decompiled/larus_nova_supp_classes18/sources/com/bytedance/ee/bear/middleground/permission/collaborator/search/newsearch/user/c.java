package com.bytedance.ee.bear.middleground.permission.collaborator.search.newsearch.user;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.ee.bear.widgets.t;
import com.bytedance.ee.util.ui.n;
import com.larksuite.framework.mvp.IView;
import com.larksuite.framework.utils.KeyboardUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c implements com.bytedance.ee.bear.middleground.permission.collaborator.search.newsearch.user.a {
    public final View a;
    public final boolean b;
    public com.bytedance.ee.bear.middleground.permission.collaborator.search.newsearch.user.a.InterfaceC0098a c;

    public static final class a extends t {
        public final /* synthetic */ c c;

        public a(c r1) {
            this.c = r1;
        }

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r2) {
            if (r2 == null) goto L4;
            c.h(this.c, r2);
        L4:
            com.bytedance.ee.bear.middleground.permission.collaborator.search.newsearch.user.a.InterfaceC0098a r3 = this.c.c;
            if (r3 == null) goto L8;
            r3.j2();
            return;
        }
    }

    public static final class b extends t {
        public final /* synthetic */ c c;

        public b(c r1) {
            this.c = r1;
        }

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r2) {
            if (r2 == null) goto L4;
            c.h(this.c, r2);
        L4:
            com.bytedance.ee.bear.middleground.permission.collaborator.search.newsearch.user.a.InterfaceC0098a r3 = this.c.c;
            if (r3 == null) goto L8;
            r3.g4();
            return;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ee.bear.middleground.permission.collaborator.search.newsearch.user.c$c, reason: collision with other inner class name */
    public static final class ViewOnClickListenerC0100c implements View.OnClickListener {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ c b;

        public ViewOnClickListenerC0100c(boolean r1, c r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            if (this.a == false) goto L8;
            c r0 = this.b;
            Intrinsics.checkNotNull(r2);
            c.h(r0, r2);
            com.bytedance.ee.bear.middleground.permission.collaborator.search.newsearch.user.a.InterfaceC0098a r3 = this.b.c;
            if (r3 == null) goto L9;
            r3.s();
            return;
        L9:
            return;
        }
    }

    public final void destroy() {
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.newsearch.user.a
    public final void B() {
        float r0 = n.d(44);
        ((LinearLayout) this.a.findViewById(2131382139)).setTranslationY(r0);
        ((FrameLayout) this.a.findViewById(2131382138)).setTranslationY(r0);
        k(this.a.findViewById(2131382139));
        k(this.a.findViewById(2131382138));
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.newsearch.user.a
    public final void Y0() {
        ((LinearLayout) this.a.findViewById(2131382139)).setVisibility(0);
    }

    public final void create() {
        if (this.b == false) goto L5;
        this.a.findViewById(2131382126).setVisibility(0);
        this.a.findViewById(2131382125).setVisibility(0);
        this.a.findViewById(2131382128).setVisibility(0);
        this.a.findViewById(2131382124).setVisibility(8);
    L6:
        this.a.findViewById(2131382128).setOnClickListener(new a(this));
        this.a.findViewById(2131382131).setOnClickListener(new b(this));
        return;
    L5:
        this.a.findViewById(2131382128).setVisibility(8);
        this.a.findViewById(2131382125).setVisibility(8);
        goto L6
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.newsearch.user.a
    public final void f2() {
        this.a.findViewById(2131382126).setVisibility(0);
        this.a.findViewById(2131382125).setVisibility(0);
        if (this.b == false) goto L5;
        this.a.findViewById(2131382128).setVisibility(0);
        this.a.findViewById(2131382124).setVisibility(0);
    L6:
        this.a.findViewById(2131382131).setVisibility(0);
        return;
    L5:
        this.a.findViewById(2131382128).setVisibility(8);
        this.a.findViewById(2131382124).setVisibility(8);
        goto L6
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.newsearch.user.a
    public final void s1() {
        ((LinearLayout) this.a.findViewById(2131382139)).setVisibility(8);
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.newsearch.user.a
    public final void v() {
        float r0 = -n.d(44);
        ((LinearLayout) this.a.findViewById(2131382139)).setTranslationY(r0);
        ((FrameLayout) this.a.findViewById(2131382138)).setTranslationY(r0);
        k(this.a.findViewById(2131382139));
        k(this.a.findViewById(2131382138));
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.newsearch.user.a
    public final void A(String r3) {
        Intrinsics.checkNotNullParameter(r3, "tips");
        ((TextView) this.a.findViewById(2131382123)).setText(r3);
    }

    public final void k(View r3) {
        r3.animate().translationY(0.0f).setDuration(300).start();
    }

    public final void setViewDelegate(IView.IViewDelegate r1) {
        this.c = (com.bytedance.ee.bear.middleground.permission.collaborator.search.newsearch.user.a.InterfaceC0098a) r1;
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.newsearch.user.a
    public final void t(boolean r3) {
        ((TextView) this.a.findViewById(2131382136)).setEnabled(r3);
        ((TextView) this.a.findViewById(2131382136)).setOnClickListener(new ViewOnClickListenerC0100c(r3, this));
    }

    public c(View r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "rootView");
        this.a = r2;
        this.b = r3;
    }

    public static final void h(c r0, View r1) {
        r0.getClass();
        if (r1.requestFocus() == false) goto L6;
        KeyboardUtils.hideKeyboard(r1.getContext(), r1);
        return;
    }
}
