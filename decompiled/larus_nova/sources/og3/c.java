package og3;

import com.bytedance.android.shopping.prepurchase.arch.container.model.Biz;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Biz f523189a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f523190b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f523191c;

    public c(Biz r100, String r101, a r102) {
        Intrinsics.checkNotNullParameter(r100, "bizCode");
        Intrinsics.checkNotNullParameter(r101, "sessionId");
        Intrinsics.checkNotNullParameter(r102, "btmInfo");
        this.f523189a = r100;
        this.f523190b = r101;
        this.f523191c = r102;
    }
}
