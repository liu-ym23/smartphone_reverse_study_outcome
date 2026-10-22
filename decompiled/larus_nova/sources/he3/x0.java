package he3;

import com.bytedance.android.shopping.infeed.data.idl.HeaderBannerItemType;
import com.bytedance.android.shopping.infeed.data.idl.InFeedUrlModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class x0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HeaderBannerItemType f484855a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public InFeedUrlModel f484856b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public qe3.a f484857c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f484858d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f484859e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f484860f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f484861g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public h f484862h;

    public x0() {
        this.f484855a = HeaderBannerItemType.Image;
        this.f484858d = -1;
        this.f484860f = -1;
    }

    public final HeaderBannerItemType getType() {
        return this.f484855a;
    }

    public final void a(HeaderBannerItemType r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f484855a = r100;
    }
}
