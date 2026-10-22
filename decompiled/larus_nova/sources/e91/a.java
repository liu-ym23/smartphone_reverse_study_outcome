package e91;

import android.view.ViewGroup;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public class a<T> extends com.bytedance.android.live.room.navi.userinfo.cert.d<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f471423a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f471424b;

    @Override // com.bytedance.android.live.room.navi.userinfo.cert.d
    public void b() {
        this.f471423a = false;
        ViewGroup r100 = this.f471424b.getContainer();
        if (r100 == null) goto L5;
        r100.removeAllViews();
        r100.setVisibility(8);
    L5:
        this.f471424b.onUnload();
    }

    public void c() {
        ViewGroup r100 = this.f471424b.getContainer();
        if (r100 == null) goto L9;
        this.f471424b.a();
        r100.setVisibility(8);
        if (r100.getChildCount() <= 0) goto L7;
        r100.removeAllViews();
    L7:
        this.f471423a = false;
        return;
    }

    public a(com.bytedance.android.live.room.navi.userinfo_p.presenter.h r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        this.f471424b = r100;
    }
}
