package pj5;

import android.view.View;
import com.bytedance.ee.bear.more.fresh.DocFreshNessAdapter;

/* JADX INFO: loaded from: classes18.dex */
public final class g implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f529473a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DocFreshNessAdapter f529474b;

    public g(i r100, DocFreshNessAdapter r101) {
        this.f529473a = r100;
        this.f529474b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        i r101 = this.f529473a;
        if (r101.f529477a == true) goto L5;
    L7:
        p r102 = this.f529474b.f234529a;
        if (r102 == null) goto L11;
        r102.a(r101);
        return;
    L11:
        return;
    L5:
        if (r101.f529485i == true) goto L7;
    }
}
