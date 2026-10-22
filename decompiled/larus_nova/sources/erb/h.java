package erb;

import android.view.View;
import com.ss.android.lark.mention.base.impl.atselector.IItemContainer;
import com.ss.android.lark.mention.base.impl.atselector.bean.BaseAtBean;

/* JADX INFO: loaded from: classes36.dex */
public final class h implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IItemContainer f473672a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BaseAtBean f473673b;

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        IItemContainer.a r101 = this.f473672a.a0();
        int r102 = this.f473672a.y0();
        if (r101 != null) goto L5;
        return;
    L5:
        if (r102 != 0) goto L9;
        r101.c(this.f473673b);
        return;
    L9:
        if (this.f473673b.isSelected() == false) goto L11;
        this.f473673b.setSelected(false);
        r101.b(this.f473673b);
        return;
    L11:
        this.f473673b.setSelected(true);
        r101.a(this.f473673b);
    }

    public h(IItemContainer r100, BaseAtBean r101) {
        this.f473672a = r100;
        this.f473673b = r101;
    }
}
