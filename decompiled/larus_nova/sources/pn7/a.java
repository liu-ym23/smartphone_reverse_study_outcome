package pn7;

import android.graphics.Bitmap;
import com.bytedance.ug.sdk.share.api.entity.ShareContent;

/* JADX INFO: loaded from: classes22.dex */
public final class a implements in7.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ShareContent f529979a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b f529980b;

    @Override // in7.a
    public final void onFailed() {
        this.f529980b.e(false, this.f529979a);
    }

    @Override // in7.a
    public final void onSuccess(Bitmap r100) {
        this.f529979a.setImage(r100);
        this.f529980b.d(this.f529979a);
    }

    public a(b r100, ShareContent r101) {
        this.f529980b = r100;
        this.f529979a = r101;
    }
}
