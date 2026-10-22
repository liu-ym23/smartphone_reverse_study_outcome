package com.ss.android.lark.photoeditor.impl.ui;

import android.app.Activity;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.larksuite.framework.mvp.BasePresenter;
import com.larksuite.framework.mvp.IView;

/* JADX INFO: loaded from: classes37.dex */
public final class o extends BasePresenter<com.ss.android.lark.photoeditor.impl.ui.a, b, b.a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Activity f438596a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f438597b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f438598c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f438599d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f438600e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final a f438601f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f438602g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f438603h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f438604i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final q0c.a f438605j;

    public interface a {
    }

    @Override // com.larksuite.framework.mvp.BasePresenter
    public final IView.IViewDelegate createViewDelegate() {
        return new m(this);
    }

    @Override // com.larksuite.framework.mvp.BasePresenter, com.larksuite.framework.mvp.ILifecycle
    public final void create() {
        super.create();
    }

    public o(String r100, String r110, String r111, boolean r112, boolean r113, String r114, String r115, String r116, FragmentActivity r117, View r118, PhotoEditorFragment.a r119, PhotoEditorFragment.b r210, q0c.a r211) {
        this.f438597b = r110;
        this.f438601f = r210;
        this.f438598c = r111;
        this.f438599d = r112;
        this.f438600e = r113;
        this.f438602g = r114;
        this.f438603h = r115;
        this.f438604i = r116;
        this.f438596a = r117;
        this.f438605j = r211;
        r r101 = new r(r117, r118, r111, r100, r119);
        h r102 = new h();
        r101.f438615f = new m(this);
        setView(r101);
        setModel(r102);
    }
}
