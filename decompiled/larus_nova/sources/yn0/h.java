package yn0;

import com.bytedance.android.live.link.ILinkServiceExternal;

/* JADX INFO: loaded from: classes46.dex */
public final class h implements l81.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f568504a = null;

    public h() {
    }

    static {
        f568504a = new h();
    }

    @Override // l81.h
    public final String getLinkAnchorCount() {
        ILinkServiceExternal r100 = (ILinkServiceExternal) jc1.k.f(ILinkServiceExternal.class);
        if (r100 == null) goto L6;
        String r101 = r100.getLinkAnchorCount();
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "";
    }
}
