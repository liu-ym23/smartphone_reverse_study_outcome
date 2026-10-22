package com.bytedance.ee.bear.middleground.permission.collaborator.search.newsearch.dep;

import android.view.View;
import android.widget.TextView;
import com.bytedance.ee.util.ui.n;
import com.larksuite.framework.mvp.IView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d implements com.bytedance.ee.bear.middleground.permission.collaborator.search.newsearch.dep.a {
    public final View a;
    public com.bytedance.ee.bear.middleground.permission.collaborator.search.newsearch.dep.a.InterfaceC0097a b;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ d b;

        public a(boolean r1, d r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            if (this.a == false) goto L8;
            com.bytedance.ee.bear.middleground.permission.collaborator.search.newsearch.dep.a.InterfaceC0097a r2 = this.b.b;
            if (r2 == null) goto L9;
            r2.s();
            return;
        L9:
            return;
        }
    }

    public final void create() {
    }

    public final void destroy() {
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.newsearch.dep.a
    public final void B() {
        float r0 = n.d(44);
        this.a.findViewById(2131382148).setTranslationY(r0);
        this.a.findViewById(2131382144).setTranslationY(r0);
        h(this.a.findViewById(2131382148));
        h(this.a.findViewById(2131382144));
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.newsearch.dep.a
    public final void v() {
        float r0 = -n.d(44);
        this.a.findViewById(2131382148).setTranslationY(r0);
        this.a.findViewById(2131382144).setTranslationY(r0);
        h(this.a.findViewById(2131382148));
        h(this.a.findViewById(2131382144));
    }

    public d(View r2) {
        Intrinsics.checkNotNullParameter(r2, "rootView");
        this.a = r2;
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.newsearch.dep.a
    public final void A(String r3) {
        Intrinsics.checkNotNullParameter(r3, "tips");
        ((TextView) this.a.findViewById(2131382146)).setText(r3);
    }

    public final void h(View r3) {
        r3.animate().translationY(0.0f).setDuration(300).start();
    }

    public final void setViewDelegate(IView.IViewDelegate r1) {
        this.b = (com.bytedance.ee.bear.middleground.permission.collaborator.search.newsearch.dep.a.InterfaceC0097a) r1;
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.newsearch.dep.a
    public final void t(boolean r3) {
        ((TextView) this.a.findViewById(2131382147)).setEnabled(r3);
        ((TextView) this.a.findViewById(2131382147)).setOnClickListener(new a(r3, this));
    }
}
