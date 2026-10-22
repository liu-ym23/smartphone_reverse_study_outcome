package com.bytedance.ee.bear.document.more;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.more.moreprotocol.CommonMoreItemId;
import com.bytedance.ee.bear.more.moreprotocol.IBaseMoreItem;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class i {
    public final DocumentPluginHost a;
    public final boolean b;

    public static final class a {
    }

    static {
    }

    private final FragmentActivity getActivity() {
        Fragment r0 = this.a.getHostFragment();
        if (r0 == null) goto L5;
        FragmentActivity r1 = r0.getActivity();
    L7:
        if ((r1 instanceof FragmentActivity) == true) goto L9;
        return null;
    L9:
        return r1;
    L5:
        r1 = null;
        goto L7
    }

    public final jdb.g c() {
        return ((dn4.a) this.a.getUserComponent().a(dn4.a.class)).a();
    }

    public static final /* synthetic */ FragmentActivity a(i r0) {
        return r0.getActivity();
    }

    public i(DocumentPluginHost r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "pluginHost");
        this.a = r2;
        this.b = r3;
    }

    public final IBaseMoreItem b(CommonMoreItemId r7, String r8) {
        FragmentActivity r1 = getActivity();
        if (r1 != null) goto L6;
        tt5.a.k("BaselineMoreItemFactories", "commonItem skip item, id=" + r7 + ", activity is null");
        return null;
    L6:
        com.bytedance.ee.bear.more.b r0 = (com.bytedance.ee.bear.more.b) org.koin.java.a.c(com.bytedance.ee.bear.more.b.class, null, null, 6);
        if (r8 != null) goto L10;
        return r0.q(r1, r7, c(), (by4.d) this.a.getUserComponent().a(by4.d.class));
    L10:
        return r0.g(r1, r7, c(), (by4.d) this.a.getUserComponent().a(by4.d.class), r8);
    }

    public final void d(com.bytedance.ee.bear.more.protocol3.panel.e r2, String r3, CommonMoreItemId r4) {
        r2.d(r3, new k(this, r4));
    }
}
