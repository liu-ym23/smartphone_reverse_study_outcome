package n2c;

import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes37.dex */
public final /* synthetic */ class h implements com.ss.android.lark.reaction.widget.detailwindow.scroller.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.ss.android.lark.reaction.widget.detailwindow.a f516848a;

    public /* synthetic */ h(com.ss.android.lark.reaction.widget.detailwindow.a r100) {
        this.f516848a = r100;
    }

    public final boolean a(int r100) {
        RecyclerView r101 = this.f516848a.f439221r;
        if (r101 != null) goto L6;
        return false;
    L6:
        return r101.canScrollVertically(r100);
    }
}
