package hx6;

import android.view.View;
import com.bytedance.locallife.pdp.headimage.view.HeadImageItemAdapter;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import jx6.p;

/* JADX INFO: loaded from: classes21.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HeadImageItemAdapter f487508a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f487509b;

    public a(HeadImageItemAdapter r100, int r101) {
        this.f487508a = r100;
        this.f487509b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        HeadImageItemAdapter r101 = this.f487508a;
        b r102 = r101.f261471c;
        if (r102 == null) goto L6;
        r102.a((p) ListProtector.get(r101.f261469a, this.f487509b), this.f487509b);
        return;
    }
}
