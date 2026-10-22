package e92;

import com.bytedance.android.livesdkapi.depend.model.follow.FollowPair;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes9.dex */
public final class i<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k f471458a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f471459b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f471460c;

    public i(k r100, String r101, String r102) {
        this.f471458a = r100;
        this.f471459b = r101;
        this.f471460c = r102;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        FollowPair r101 = (FollowPair) r100;
        this.f471458a.f471464c = false;
        int r102 = w82.b.f558621a;
        w82.b.b(this.f471459b, this.f471460c, false);
    }
}
