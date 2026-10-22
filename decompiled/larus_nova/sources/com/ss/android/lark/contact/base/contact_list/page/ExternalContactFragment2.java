package com.ss.android.lark.contact.base.contact_list.page;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.ss.android.lark.base.fragment.BaseFragment;
import com.ss.android.lark.contact.base.contact_list.mvp.ExternalContactPresenter2;
import com.ss.android.lark.contact.base.contact_list.mvp.ExternalContactView2;
import qqb.c;

/* JADX INFO: loaded from: classes35.dex */
public class ExternalContactFragment2 extends BaseFragment {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f418610g = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ExternalContactPresenter2 f418611d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f418612e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public a f418613f;

    public class a implements ExternalContactView2.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ExternalContactFragment2 f418614a;

        public a(ExternalContactFragment2 r100) {
            this.f418614a = r100;
        }
    }

    public ExternalContactFragment2() {
        this.f418613f = new a(this);
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragment, androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        ExternalContactPresenter2 r100 = this.f418611d;
        if (r100 == null) goto L5;
        r100.destroy();
    L5:
        this.f418613f = null;
    }

    @Override // com.ss.android.lark.desktopmode.app.DesktopCompatFragment, androidx.fragment.app.Fragment
    public final View onCreateView(final LayoutInflater r100, final ViewGroup r101, Bundle r102) {
        return (View) c.b("ExternalContactFragment2 onCreateView", new x8b.a(this, r100, r101));
    }
}
