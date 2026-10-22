package com.bytedance.ee.bear.drive.biz.preview.more.menu;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import com.bytedance.ee.bear.more.moreprotocol.CommonMoreItemId;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DrivePluginHost f223566a;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.drive.biz.preview.more.menu.a$a, reason: collision with other inner class name */
    public static final class C3203a {
    }

    static {
    }

    private final FragmentActivity getActivity() {
        Fragment r100 = this.f223566a.getHostFragment();
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

    public final boolean c() {
        return this.f223566a.f224125c.isTypeWiki();
    }

    public a(DrivePluginHost r100) {
        Intrinsics.checkNotNullParameter(r100, "pluginHost");
        this.f223566a = r100;
    }

    public static final /* synthetic */ FragmentActivity b(a r100) {
        return r100.getActivity();
    }

    public static final com.bytedance.ee.bear.more.protocol3.b a(a r100, CommonMoreItemId r101) {
        FragmentActivity r102 = r100.getActivity();
        if (r102 != null) goto L6;
        tt5.a.k("DriveBaselineMoreItemFactories", "common item noop, id=" + r101 + ", activity is null");
        return d0.f223577c;
    L6:
        return ((com.bytedance.ee.bear.more.b) org.koin.java.a.c(com.bytedance.ee.bear.more.b.class, null, null, 6)).q(r102, r101, ((dn4.a) r100.f223566a.getUserComponent().a(dn4.a.class)).a(), (by4.d) r100.f223566a.getUserComponent().a(by4.d.class));
    }

    public final void d(com.bytedance.ee.bear.more.protocol3.panel.e r100, String r101, CommonMoreItemId r102) {
        r100.d(r101, new b(this, r102));
    }
}
