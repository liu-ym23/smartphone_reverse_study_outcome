package com.bytedance.ee.bear.middleground.permission.collaborator.search.newsearch.user;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.ee.bear.widgets.t;
import com.bytedance.ee.util.ui.n;
import com.larksuite.framework.mvp.IView;
import com.larksuite.framework.utils.KeyboardUtils;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class c implements com.bytedance.ee.bear.middleground.permission.collaborator.search.newsearch.user.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f233505a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f233506b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.bytedance.ee.bear.middleground.permission.collaborator.search.newsearch.user.a.InterfaceC3345a f233507c;

    public static final class a extends t {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ c f233508c;

        public a(c r100) {
            this.f233508c = r100;
        }

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r100) {
            if (r100 == null) goto L4;
            c.h(this.f233508c, r100);
        L4:
            com.bytedance.ee.bear.middleground.permission.collaborator.search.newsearch.user.a.InterfaceC3345a r101 = this.f233508c.f233507c;
            if (r101 == null) goto L8;
            r101.j2();
            return;
        }
    }

    public static final class b extends t {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ c f233509c;

        public b(c r100) {
            this.f233509c = r100;
        }

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r100) {
            if (r100 == null) goto L4;
            c.h(this.f233509c, r100);
        L4:
            com.bytedance.ee.bear.middleground.permission.collaborator.search.newsearch.user.a.InterfaceC3345a r101 = this.f233509c.f233507c;
            if (r101 == null) goto L8;
            r101.g4();
            return;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ee.bear.middleground.permission.collaborator.search.newsearch.user.c$c, reason: collision with other inner class name */
    public static final class ViewOnClickListenerC3347c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f233510a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ c f233511b;

        public ViewOnClickListenerC3347c(boolean r100, c r101) {
            this.f233510a = r100;
            this.f233511b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            if (this.f233510a == false) goto L8;
            c r101 = this.f233511b;
            Intrinsics.checkNotNull(r100);
            c.h(r101, r100);
            com.bytedance.ee.bear.middleground.permission.collaborator.search.newsearch.user.a.InterfaceC3345a r102 = this.f233511b.f233507c;
            if (r102 == null) goto L9;
            r102.s();
            return;
        L9:
            return;
        }
    }

    @Override // com.larksuite.framework.mvp.ILifecycle
    public final void destroy() {
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.newsearch.user.a
    public final void B() {
        float r100 = n.d(44);
        ((LinearLayout) this.f233505a.findViewById(R.id.permSearchUserSelectLayout)).setTranslationY(r100);
        ((FrameLayout) this.f233505a.findViewById(R.id.permSearchUserResultContainer)).setTranslationY(r100);
        k(this.f233505a.findViewById(R.id.permSearchUserSelectLayout));
        k(this.f233505a.findViewById(R.id.permSearchUserResultContainer));
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.newsearch.user.a
    public final void Y0() {
        ((LinearLayout) this.f233505a.findViewById(R.id.permSearchUserSelectLayout)).setVisibility(0);
    }

    @Override // com.larksuite.framework.mvp.ILifecycle
    public final void create() {
        if (this.f233506b == false) goto L5;
        this.f233505a.findViewById(R.id.permSearchUserDepDividerTop).setVisibility(0);
        this.f233505a.findViewById(R.id.permSearchUserDepDividerBottom).setVisibility(0);
        ((ConstraintLayout) this.f233505a.findViewById(R.id.permSearchUserDepLayout)).setVisibility(0);
        this.f233505a.findViewById(R.id.permSearchUserDepDivider).setVisibility(8);
    L6:
        ((ConstraintLayout) this.f233505a.findViewById(R.id.permSearchUserDepLayout)).setOnClickListener(new a(this));
        ((ConstraintLayout) this.f233505a.findViewById(R.id.permSearchUserGroupLayout)).setOnClickListener(new b(this));
        return;
    L5:
        ((ConstraintLayout) this.f233505a.findViewById(R.id.permSearchUserDepLayout)).setVisibility(8);
        this.f233505a.findViewById(R.id.permSearchUserDepDividerBottom).setVisibility(8);
        goto L6
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.newsearch.user.a
    public final void f2() {
        this.f233505a.findViewById(R.id.permSearchUserDepDividerTop).setVisibility(0);
        this.f233505a.findViewById(R.id.permSearchUserDepDividerBottom).setVisibility(0);
        if (this.f233506b == false) goto L5;
        ((ConstraintLayout) this.f233505a.findViewById(R.id.permSearchUserDepLayout)).setVisibility(0);
        this.f233505a.findViewById(R.id.permSearchUserDepDivider).setVisibility(0);
    L6:
        ((ConstraintLayout) this.f233505a.findViewById(R.id.permSearchUserGroupLayout)).setVisibility(0);
        return;
    L5:
        ((ConstraintLayout) this.f233505a.findViewById(R.id.permSearchUserDepLayout)).setVisibility(8);
        this.f233505a.findViewById(R.id.permSearchUserDepDivider).setVisibility(8);
        goto L6
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.newsearch.user.a
    public final void s1() {
        ((LinearLayout) this.f233505a.findViewById(R.id.permSearchUserSelectLayout)).setVisibility(8);
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.newsearch.user.a
    public final void v() {
        float r100 = -n.d(44);
        ((LinearLayout) this.f233505a.findViewById(R.id.permSearchUserSelectLayout)).setTranslationY(r100);
        ((FrameLayout) this.f233505a.findViewById(R.id.permSearchUserResultContainer)).setTranslationY(r100);
        k(this.f233505a.findViewById(R.id.permSearchUserSelectLayout));
        k(this.f233505a.findViewById(R.id.permSearchUserResultContainer));
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.newsearch.user.a
    public final void A(String r100) {
        Intrinsics.checkNotNullParameter(r100, "tips");
        ((TextView) this.f233505a.findViewById(R.id.permSearchUserBottomTips)).setText(r100);
    }

    public final void k(View r100) {
        r100.animate().translationY(0.0f).setDuration(300).start();
    }

    @Override // com.larksuite.framework.mvp.IView
    public final void setViewDelegate(IView.IViewDelegate r100) {
        this.f233507c = (com.bytedance.ee.bear.middleground.permission.collaborator.search.newsearch.user.a.InterfaceC3345a) r100;
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.newsearch.user.a
    public final void t(boolean r100) {
        ((TextView) this.f233505a.findViewById(R.id.permSearchUserNextBtn)).setEnabled(r100);
        ((TextView) this.f233505a.findViewById(R.id.permSearchUserNextBtn)).setOnClickListener(new ViewOnClickListenerC3347c(r100, this));
    }

    public c(View r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "rootView");
        this.f233505a = r100;
        this.f233506b = r101;
    }

    public static final void h(c r100, View r101) {
        r100.getClass();
        if (r101.requestFocus() == false) goto L6;
        KeyboardUtils.hideKeyboard(r101.getContext(), r101);
        return;
    }
}
