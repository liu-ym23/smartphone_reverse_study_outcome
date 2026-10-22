package com.ss.android.lark.contact.impl.group.join;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.larus.nova.R;
import com.ss.android.lark.base.fragment.BaseFragment;
import kotlin.jvm.internal.Intrinsics;
import q9b.m;

/* JADX INFO: loaded from: classes35.dex */
public class MyJoinGroupFragment extends BaseFragment {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public MyJoinGroupPresenter f419478d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public m f419479e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public q9b.a f419480f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final a f419481g;

    public class a implements MyJoinGroupView.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MyJoinGroupFragment f419482a;

        public a(MyJoinGroupFragment r100) {
            this.f419482a = r100;
        }
    }

    public class b implements q9b.a.InterfaceC7301a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MyJoinGroupFragment f419483a;

        @Override // q9b.a.InterfaceC7301a
        public final void a() {
            MyJoinGroupPresenter r100 = this.f419483a.f419478d;
            if (r100 == null) goto L8;
            com.ss.android.lark.contact.impl.group.join.b r101 = r100.getView();
            if (r101 == null) goto L9;
            r101.refresh();
            return;
        L9:
            return;
        }

        public b(MyJoinGroupFragment r100) {
            this.f419483a = r100;
        }
    }

    public MyJoinGroupFragment() {
        this.f419479e = null;
        this.f419480f = null;
        this.f419481g = new a(this);
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragment, com.ss.android.lark.desktopmode.app.DesktopCompatFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        this.f419478d.destroy();
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration r100) {
        super.onConfigurationChanged(r100);
        q9b.a r101 = this.f419480f;
        if (r101 == null) goto L6;
        r101.a(r100);
        return;
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragment, com.ss.android.lark.desktopmode.app.DesktopCompatFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        Configuration r101 = getContext().getResources().getConfiguration();
        if (r101 == null) goto L6;
        q9b.a r102 = new q9b.a(r101);
        this.f419480f = r102;
        b r103 = new b(this);
        Intrinsics.checkNotNullParameter(r103, "onWindowChangedListener");
        r102.f532180b = r103;
        return;
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        super.onViewCreated(r100, r101);
        MyJoinGroupPresenter r102 = new MyJoinGroupPresenter(new c(), new MyJoinGroupView(this.f419481g, this.f419479e));
        this.f419478d = r102;
        r102.create();
    }

    @Override // com.ss.android.lark.desktopmode.app.DesktopCompatFragment, androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        return r100.inflate(R.layout.fragment_contacts_my_join_group, r101, false);
    }
}
