package pj5;

import android.view.View;
import com.bytedance.ee.bear.more.fresh.DocFreshNessAdapter;

/* JADX INFO: loaded from: classes18.dex */
public final class h implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DocFreshNessAdapter f529475a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ i f529476b;

    public h(DocFreshNessAdapter r100, i r101) {
        this.f529475a = r100;
        this.f529476b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        p r101 = this.f529475a.f234529a;
        if (r101 == null) goto L6;
        r101.b(this.f529476b);
        return;
    }
}
