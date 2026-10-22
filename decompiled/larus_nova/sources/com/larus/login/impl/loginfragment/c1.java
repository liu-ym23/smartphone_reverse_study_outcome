package com.larus.login.impl.loginfragment;

import android.view.View;
import android.view.ViewTreeObserver;
import com.larus.home.api.main.IHomeApi;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes30.dex */
public final class c1 implements ViewTreeObserver.OnPreDrawListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f357941a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AccountLoginFragment f357942b;

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        this.f357941a.getViewTreeObserver().removeOnPreDrawListener(this);
        this.f357942b.f357895e = true;
        IHomeApi r100 = (IHomeApi) ServiceManager.get().getService(IHomeApi.class);
        if (r100 == null) goto L5;
        r100.L(new JSONObject());
    L5:
        return true;
    }

    public c1(View r100, AccountLoginFragment r101) {
        this.f357941a = r100;
        this.f357942b = r101;
    }
}
