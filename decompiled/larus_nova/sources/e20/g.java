package e20;

import android.view.View;
import com.ss.android.ugc.aweme.debug.LocalTestManager;

/* JADX INFO: loaded from: classes45.dex */
public final class g implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a20.e f470808a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f470809b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ f10.f f470810c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f470811d;

    public g(a20.e r100, View r101, f10.f r102, int r103) {
        this.f470808a = r100;
        this.f470809b = r101;
        this.f470810c = r102;
        this.f470811d = r103;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        if (this.f470808a != null) goto L5;
        LocalTestManager.a(new Class[]{wy.a.class});
    L5:
        a20.e r101 = this.f470808a;
        if (r101 == null) goto L9;
        r101.a(this.f470809b, this.f470810c, this.f470811d, null);
        return;
    }
}
