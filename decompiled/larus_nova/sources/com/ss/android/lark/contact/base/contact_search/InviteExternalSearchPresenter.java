package com.ss.android.lark.contact.base.contact_search;

import android.app.Activity;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.mvp.BasePresenter;
import com.larksuite.framework.mvp.IView;
import com.ss.android.lark.utils.ApiUtils;

/* JADX INFO: loaded from: classes35.dex */
public final class InviteExternalSearchPresenter extends BasePresenter<a, b, b.a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f418769a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f418770b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f418771c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Fragment f418772d;

    public abstract class InviteSearchViewDelegate<T> implements b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public IGetDataCallback<T> f418773a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ InviteExternalSearchPresenter f418774b;

        @Override // com.ss.android.lark.contact.base.contact_search.b.a
        public final void H4() {
            if (TextUtils.isEmpty(this.f418774b.f418769a) == false) goto L5;
            Activity r100 = this.f418774b.getView().getActivity();
            ApiUtils.a r101 = new u(this);
            int r102 = com.ss.android.lark.contact.base.service.c0.f418914a;
            com.ss.android.lark.contact.base.service.c0.a.a(r100, r101);
            return;
        L5:
            b r103 = this.f418774b.getView();
            InviteExternalSearchPresenter r104 = this.f418774b;
            String r105 = r104.f418770b;
            r103.M0(r104.f418769a);
        }

        @Override // com.ss.android.lark.contact.base.contact_search.b.a
        public final String getUniqueId() {
            return this.f418774b.f418771c;
        }

        public InviteSearchViewDelegate(InviteExternalSearchPresenter r100) {
            this.f418774b = r100;
        }

        @Override // com.ss.android.lark.contact.base.contact_search.b.a
        public final void x0(final String r100) {
            this.f418774b.getView().N5();
            this.f418773a = new AnonymousClass1(this, r100);
            this.f418774b.getModel().x3(r100, this.f418773a);
        }

        @Override // com.ss.android.lark.contact.base.contact_search.b.a
        public final void v3(String r100, boolean r101) {
            final InviteExternalSearchPresenter r102 = this.f418774b;
            r102.getView().i0();
            r102.getModel().w4(r100, r101, new AnonymousClass2(r102));
        }
    }

    @Override // com.larksuite.framework.mvp.BasePresenter
    public final IView.IViewDelegate createViewDelegate() {
        return new t(this);
    }

    public InviteExternalSearchPresenter(Fragment r100, c r101, b0 r102) {
        super(r101, r102);
        this.f418772d = r100;
        r102.f418776b = new t(this);
    }
}
