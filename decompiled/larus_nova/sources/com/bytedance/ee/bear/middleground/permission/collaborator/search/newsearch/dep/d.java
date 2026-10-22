package com.bytedance.ee.bear.middleground.permission.collaborator.search.newsearch.dep;

import android.view.View;
import android.widget.TextView;
import com.bytedance.ee.bear.facade.common.widget.MainViewPager;
import com.bytedance.ee.util.ui.n;
import com.larksuite.framework.mvp.IView;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class d implements com.bytedance.ee.bear.middleground.permission.collaborator.search.newsearch.dep.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f233487a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.bytedance.ee.bear.middleground.permission.collaborator.search.newsearch.dep.a.InterfaceC3344a f233488b;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f233489a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d f233490b;

        public a(boolean r100, d r101) {
            this.f233489a = r100;
            this.f233490b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            if (this.f233489a == false) goto L8;
            com.bytedance.ee.bear.middleground.permission.collaborator.search.newsearch.dep.a.InterfaceC3344a r101 = this.f233490b.f233488b;
            if (r101 == null) goto L9;
            r101.s();
            return;
        L9:
            return;
        }
    }

    @Override // com.larksuite.framework.mvp.ILifecycle
    public final void create() {
    }

    @Override // com.larksuite.framework.mvp.ILifecycle
    public final void destroy() {
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.newsearch.dep.a
    public final void B() {
        float r100 = n.d(44);
        this.f233487a.findViewById(R.id.permSelectDivider).setTranslationY(r100);
        ((MainViewPager) this.f233487a.findViewById(R.id.permSelectContainer)).setTranslationY(r100);
        h(this.f233487a.findViewById(R.id.permSelectDivider));
        h(this.f233487a.findViewById(R.id.permSelectContainer));
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.newsearch.dep.a
    public final void v() {
        float r100 = -n.d(44);
        this.f233487a.findViewById(R.id.permSelectDivider).setTranslationY(r100);
        ((MainViewPager) this.f233487a.findViewById(R.id.permSelectContainer)).setTranslationY(r100);
        h(this.f233487a.findViewById(R.id.permSelectDivider));
        h(this.f233487a.findViewById(R.id.permSelectContainer));
    }

    public d(View r100) {
        Intrinsics.checkNotNullParameter(r100, "rootView");
        this.f233487a = r100;
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.newsearch.dep.a
    public final void A(String r100) {
        Intrinsics.checkNotNullParameter(r100, "tips");
        ((TextView) this.f233487a.findViewById(R.id.permSelectDepBottomTips)).setText(r100);
    }

    public final void h(View r100) {
        r100.animate().translationY(0.0f).setDuration(300).start();
    }

    @Override // com.larksuite.framework.mvp.IView
    public final void setViewDelegate(IView.IViewDelegate r100) {
        this.f233488b = (com.bytedance.ee.bear.middleground.permission.collaborator.search.newsearch.dep.a.InterfaceC3344a) r100;
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.newsearch.dep.a
    public final void t(boolean r100) {
        ((TextView) this.f233487a.findViewById(R.id.permSelectDepNextBtn)).setEnabled(r100);
        ((TextView) this.f233487a.findViewById(R.id.permSelectDepNextBtn)).setOnClickListener(new a(r100, this));
    }
}
