package com.bytedance.ee.bear.middleground.permission.setting.linkshare.linkpassword;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.larksuite.framework.mvp.BasePresenter;
import com.larksuite.framework.mvp.IView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class g extends BasePresenter<com.bytedance.ee.bear.middleground.permission.setting.linkshare.linkpassword.a, b, b.a> {
    public final Context a;
    public final a b;
    public final boolean c;

    public interface a {
        void RN();

        void c8();
    }

    public final IView.IViewDelegate createViewDelegate() {
        return new e(this);
    }

    public g(FragmentActivity r1, d r2, b r3, a r4, boolean r5) {
        super(r2, r3);
        this.a = r1;
        this.b = r4;
        this.c = r5;
    }
}
