package erb;

import android.view.View;
import com.ss.android.lark.mention.base.impl.atselector.IItemContainer;
import com.ss.android.lark.mention.base.impl.atselector.bean.AllAtBean;

/* JADX INFO: loaded from: classes36.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AllAtBean f473649a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b f473650b;

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        IItemContainer.a r101 = this.f473650b.f473654e;
        if (r101 == null) goto L6;
        r101.c(this.f473649a);
        return;
    }

    public a(b r100, AllAtBean r101) {
        this.f473650b = r100;
        this.f473649a = r101;
    }
}
