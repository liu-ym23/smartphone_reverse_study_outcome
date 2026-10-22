package vr8;

import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class g implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<b> f556934a;

    public g(f r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        this.f556934a = new WeakReference(r100);
    }

    @Override // vr8.b
    public final void b(com.larus.bmhome.social.page.datasource.event.e.a r100) {
        Intrinsics.checkNotNullParameter(r100, WikiFolderPushPlugin.OPT);
        b r101 = this.f556934a.get();
        if (r101 == null) goto L6;
        r101.b(r100);
        return;
    }

    @Override // vr8.b
    public final void a(com.larus.bmhome.social.page.datasource.event.e.a r100, int r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, WikiFolderPushPlugin.OPT);
        b r103 = this.f556934a.get();
        if (r103 == null) goto L6;
        r103.a(r100, r101, r102);
        return;
    }
}
