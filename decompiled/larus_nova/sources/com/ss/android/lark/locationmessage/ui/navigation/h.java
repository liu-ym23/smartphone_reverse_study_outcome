package com.ss.android.lark.locationmessage.ui.navigation;

import android.content.Context;
import com.bytedance.supervisor.token.Token;
import com.larksuite.framework.mvp.BasePresenter;
import com.larksuite.framework.mvp.IView;
import com.ss.android.lark.location.dto.Scene;

/* JADX INFO: loaded from: classes36.dex */
public final class h extends BasePresenter<b, Object, c> {

    public class a implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h f431366a;

        @Override // com.ss.android.lark.locationmessage.ui.navigation.c
        public final boolean isAdminGpsEnabled() {
            return this.f431366a.getModel().isAdminGpsEnabled();
        }

        public a(h r100) {
            this.f431366a = r100;
        }

        @Override // com.ss.android.lark.locationmessage.ui.navigation.c
        public final void S(Context r100, Token r101, Scene r102, u r103) {
            this.f431366a.getModel().S(r100, r101, r102, r103);
        }
    }

    @Override // com.larksuite.framework.mvp.BasePresenter
    public final IView.IViewDelegate createViewDelegate() {
        return new a(this);
    }

    @Override // com.larksuite.framework.mvp.BasePresenter, com.larksuite.framework.mvp.ILifecycle
    public final void create() {
        super.create();
    }

    @Override // com.larksuite.framework.mvp.BasePresenter, com.larksuite.framework.mvp.ILifecycle
    public final void destroy() {
        super.destroy();
    }

    public h(NavigateView r100) {
        super(new g(), r100);
    }
}
