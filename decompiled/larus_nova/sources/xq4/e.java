package xq4;

import com.bytedance.ee.bear.bitable.card.view.cell.CellEditDragView;

/* JADX INFO: loaded from: classes15.dex */
public final class e implements CellEditDragView.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f564805a;

    public e(g r100) {
        this.f564805a = r100;
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.CellEditDragView.a
    public final void a(int r100, int r101) {
        if (r101 >= r100) goto L7;
        g r102 = this.f564805a;
        if (r102.f486405i <= 0) goto L8;
        r102.hideKeyboard();
        return;
    L8:
        return;
    }
}
