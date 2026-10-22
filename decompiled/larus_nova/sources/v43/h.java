package v43;

import com.bytedance.android.shopping.abscontainer.common_biz.constant.PageStartupStatus;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class h implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f553067a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public PageStartupStatus f553068b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f553069c;

    public h() {
        int r100 = j43.d.f497356a;
        long r101 = System.currentTimeMillis();
        PageStartupStatus r102 = PageStartupStatus.LOADING;
        Intrinsics.checkNotNullParameter(r102, "pageStartupStatus");
        Intrinsics.checkNotNullParameter("others", "closeMethod");
        this.f553067a = r101;
        this.f553068b = r102;
        this.f553069c = "others";
    }

    @Override // v43.o
    public final long F() {
        return this.f553067a;
    }

    @Override // v43.o
    public final String K() {
        return this.f553069c;
    }

    @Override // v43.o
    public final PageStartupStatus c() {
        return this.f553068b;
    }

    @Override // v43.o
    public final void M(PageStartupStatus r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f553068b = r100;
    }

    @Override // v43.o
    public final void S(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f553069c = r100;
    }
}
