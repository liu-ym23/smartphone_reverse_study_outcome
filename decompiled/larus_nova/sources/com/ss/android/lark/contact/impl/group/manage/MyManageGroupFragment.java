package com.ss.android.lark.contact.impl.group.manage;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.larus.nova.R;
import com.ss.android.lark.base.fragment.BaseFragment;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import q9b.m;

/* JADX INFO: loaded from: classes35.dex */
public class MyManageGroupFragment extends BaseFragment {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f419497i = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public MyManageGroupPresenter f419498d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final c f419499e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<String> f419500f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public m f419501g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public q9b.a f419502h;

    public class a implements q9b.a.InterfaceC7301a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MyManageGroupFragment f419503a;

        @Override // q9b.a.InterfaceC7301a
        public final void a() {
            MyManageGroupPresenter r100 = this.f419503a.f419498d;
            if (r100 == null) goto L8;
            b r101 = r100.getView();
            if (r101 == null) goto L9;
            r101.refresh();
            return;
        L9:
            return;
        }

        public a(MyManageGroupFragment r100) {
            this.f419503a = r100;
        }
    }

    public MyManageGroupFragment() {
        this.f419499e = new c(this);
        this.f419500f = new ArrayList();
        this.f419501g = null;
        this.f419502h = null;
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragment, com.ss.android.lark.desktopmode.app.DesktopCompatFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        this.f419498d.destroy();
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration r100) {
        super.onConfigurationChanged(r100);
        q9b.a r101 = this.f419502h;
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
        this.f419502h = r102;
        a r103 = new a(this);
        Intrinsics.checkNotNullParameter(r103, "onWindowChangedListener");
        r102.f532180b = r103;
        return;
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        super.onViewCreated(r100, r101);
        MyManageGroupPresenter r102 = new MyManageGroupPresenter(new d(), new MyManageGroupView(this.f419499e, this.f419500f, this.f419501g));
        this.f419498d = r102;
        r102.create();
        this.f419498d.getView().setEnableChatPreview(false);
        this.f419498d.getView().setExtras(null);
    }

    @Override // com.ss.android.lark.desktopmode.app.DesktopCompatFragment, androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        fsb.f.b().i("MyManageGroup");
        View r103 = r100.inflate(R.layout.fragment_contacts_my_manage_group, r101, false);
        fsb.f.b().h("MyManageGroup");
        return r103;
    }
}
