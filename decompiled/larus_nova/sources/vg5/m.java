package vg5;

import android.view.View;
import com.bytedance.ee.bear.share.export.UserInfo;

/* JADX INFO: loaded from: classes18.dex */
public final class m implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f554722a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ UserInfo f554723b;

    public m(g r100, UserInfo r101) {
        this.f554722a = r100;
        this.f554723b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f554722a.S0(this.f554723b);
    }
}
