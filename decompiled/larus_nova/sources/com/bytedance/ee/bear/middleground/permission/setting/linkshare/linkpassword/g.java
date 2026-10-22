package com.bytedance.ee.bear.middleground.permission.setting.linkshare.linkpassword;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.larksuite.framework.mvp.BasePresenter;
import com.larksuite.framework.mvp.IView;

/* JADX INFO: loaded from: classes18.dex */
public final class g extends BasePresenter<com.bytedance.ee.bear.middleground.permission.setting.linkshare.linkpassword.a, b, b.a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f234178a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f234179b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f234180c;

    public interface a {
        void RN();

        void c8();
    }

    @Override // com.larksuite.framework.mvp.BasePresenter
    public final IView.IViewDelegate createViewDelegate() {
        return new e(this);
    }

    public g(FragmentActivity r100, d r101, b r102, a r103, boolean r104) {
        super(r101, r102);
        this.f234178a = r100;
        this.f234179b = r103;
        this.f234180c = r104;
    }
}
