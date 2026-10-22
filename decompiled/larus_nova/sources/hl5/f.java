package hl5;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.DialogFragment;
import com.bytedance.ee.bear.quoto.k0;
import com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEmptyState;
import com.larksuite.framework.mvp.IView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes18.dex */
public final class f implements IView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f485679a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DialogFragment f485680b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f485681c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public CommonActionPanelLayout f485682d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public SpaceEmptyState f485683e;

    @Override // com.larksuite.framework.mvp.ILifecycle
    public final void destroy() {
    }

    @Override // com.larksuite.framework.mvp.ILifecycle
    public final void create() {
        this.f485682d = (CommonActionPanelLayout) this.f485679a.findViewById(R.id.title_panel);
        this.f485683e = (SpaceEmptyState) this.f485679a.findViewById(R.id.ud_empty_state_view);
        this.f485682d.setOnActionListener(new d(this));
        this.f485683e.setTitle(this.f485681c.getString(R.string.CreationMobile_Activity_Plan_Desc1));
        SpaceEmptyState r100 = this.f485683e;
        Context r101 = this.f485681c;
        r100.setDesc(xo5.a.c(r101, R.string.CreationMobile_Activity_Plan_Desc2, "edition", k0.a(r101, null)));
        this.f485683e.setPrimaryClickListener(new e(this));
    }

    @Override // com.larksuite.framework.mvp.IView
    public final /* bridge */ /* synthetic */ void setViewDelegate(IView.IViewDelegate r100) {
        a r101 = (a) r100;
    }

    public f(View r100, DialogFragment r101, Context r102) {
        this.f485679a = r100;
        this.f485680b = r101;
        this.f485681c = r102;
    }
}
