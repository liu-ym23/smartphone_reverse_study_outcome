package hl5;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.DialogFragment;
import com.bytedance.ee.bear.quoto.k0;
import com.bytedance.ee.bear.widgets.panel.CommonActionPanelLayout;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEmptyState;
import com.larksuite.framework.mvp.IView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f implements IView {
    public final View a;
    public final DialogFragment b;
    public final Context c;
    public CommonActionPanelLayout d;
    public SpaceEmptyState e;

    public final void destroy() {
    }

    public final void create() {
        this.d = (CommonActionPanelLayout) this.a.findViewById(2131388889);
        this.e = (SpaceEmptyState) this.a.findViewById(2131391810);
        this.d.setOnActionListener(new d(this));
        this.e.setTitle(this.c.getString(2131887116));
        SpaceEmptyState r0 = this.e;
        Context r1 = this.c;
        r0.setDesc(xo5.a.c(r1, 2131887117, "edition", k0.a(r1, null)));
        this.e.setPrimaryClickListener(new e(this));
    }

    public final /* bridge */ /* synthetic */ void setViewDelegate(IView.IViewDelegate r1) {
        a r2 = (a) r1;
    }

    public f(View r1, DialogFragment r2, Context r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
