package com.bytedance.ee.bear.document.more;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.more.moreprotocol.CommonMoreItemId;
import com.bytedance.ee.bear.more.moreprotocol.IBaseMoreItem;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DocumentPluginHost f220339a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f220340b;

    public static final class a {
    }

    static {
    }

    private final FragmentActivity getActivity() {
        Fragment r100 = this.f220339a.getHostFragment();
        if (r100 == null) goto L5;
        FragmentActivity r101 = r100.getActivity();
    L7:
        if ((r101 instanceof FragmentActivity) == true) goto L9;
        return null;
    L9:
        return r101;
    L5:
        r101 = null;
        goto L7
    }

    public final jdb.g c() {
        return ((dn4.a) this.f220339a.getUserComponent().a(dn4.a.class)).a();
    }

    public static final /* synthetic */ FragmentActivity a(i r100) {
        return r100.getActivity();
    }

    public i(DocumentPluginHost r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "pluginHost");
        this.f220339a = r100;
        this.f220340b = r101;
    }

    public final IBaseMoreItem b(CommonMoreItemId r100, String r101) {
        FragmentActivity r102 = getActivity();
        if (r102 != null) goto L6;
        tt5.a.k("BaselineMoreItemFactories", "commonItem skip item, id=" + r100 + ", activity is null");
        return null;
    L6:
        com.bytedance.ee.bear.more.b r103 = (com.bytedance.ee.bear.more.b) org.koin.java.a.c(com.bytedance.ee.bear.more.b.class, null, null, 6);
        if (r101 != null) goto L10;
        return r103.q(r102, r100, c(), (by4.d) this.f220339a.getUserComponent().a(by4.d.class));
    L10:
        return r103.g(r102, r100, c(), (by4.d) this.f220339a.getUserComponent().a(by4.d.class), r101);
    }

    public final void d(com.bytedance.ee.bear.more.protocol3.panel.e r100, String r101, CommonMoreItemId r102) {
        r100.d(r101, new k(this, r102));
    }
}
