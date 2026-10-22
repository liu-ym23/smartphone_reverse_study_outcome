package rtb;

import com.ss.android.lark.feed.molten.cache.FeedItemsMoltenLocalCache;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class a implements stb.a {

    /* JADX INFO: renamed from: rtb.a$a, reason: collision with other inner class name */
    public static final class C7533a {
    }

    static {
    }

    public a() {
    }

    @Override // stb.a
    public final String a() {
        stb.a r100 = (stb.a) OfficeSDKManager.getHostGlobalService(stb.a.class);
        if (r100 == null) goto L6;
        String r101 = r100.a();
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "";
    }

    @Override // stb.a
    public final void Y0(FeedItemsMoltenLocalCache.b r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        stb.a r101 = (stb.a) OfficeSDKManager.getHostGlobalService(stb.a.class);
        if (r101 == null) goto L6;
        r101.Y0(r100);
        return;
    }
}
