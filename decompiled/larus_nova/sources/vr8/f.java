package vr8;

import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.larus.utils.logger.FLogger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class f implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f556927a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final vr8.a f556928b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f556929c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f556930d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f556931e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final d f556932f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final e f556933g;

    public static final class a {
    }

    static {
    }

    public f(vr8.a r100) {
        Intrinsics.checkNotNullParameter(r100, "loader");
        this.f556927a = 30;
        this.f556928b = r100;
        this.f556929c = LazyKt.lazy(new c(this));
        this.f556932f = new d(this);
        this.f556933g = new e(this);
    }

    @Override // vr8.b
    public final void b(com.larus.bmhome.social.page.datasource.event.e.a r100) {
        Intrinsics.checkNotNullParameter(r100, WikiFolderPushPlugin.OPT);
        FLogger.f375446a.i("SimplePagingPrefetch", "onFailed——operation(" + r100 + ')');
        c(r100, 0, 0);
    }

    @Override // vr8.b
    public final void a(com.larus.bmhome.social.page.datasource.event.e.a r100, int r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, WikiFolderPushPlugin.OPT);
        FLogger.f375446a.i("SimplePagingPrefetch", "onSuccess——operation(" + r100 + "), complete(" + r102 + ')');
        if (r102 == false) goto L5;
        int r103 = 2;
    L6:
        c(r100, r101, r103);
        return;
    L5:
        r103 = 0;
        goto L6
    }

    public final void c(com.larus.bmhome.social.page.datasource.event.e.a r100, int r101, int r110) {
        if ((r100 instanceof com.larus.bmhome.social.page.datasource.event.e.a.b) == false) goto L9;
        if (this.f556931e == 2) goto L9;
        this.f556931e = r110;
        FLogger.f375446a.i("SimplePagingPrefetch", "resetFetchType——operation:(" + r100 + "), fetch_type(" + this.f556931e + "), fetch_size(" + r101 + ')');
        return;
    L9:
        if ((r100 instanceof com.larus.bmhome.social.page.datasource.event.e.a.C4103a) == true) goto L11;
        return;
    L11:
        if (this.f556930d == 2) goto L15;
        this.f556930d = r110;
        FLogger.f375446a.i("SimplePagingPrefetch", "resetFetchType——operation:(" + r100 + "), fetch_type(" + this.f556930d + "), fetch_size(" + r101 + ')');
        return;
    }
}
