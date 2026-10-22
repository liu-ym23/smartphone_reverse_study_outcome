package x45;

import android.content.res.Resources;
import androidx.fragment.app.Fragment;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.i;
import com.bytedance.ee.bear.browser.plugin.n;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import com.bytedance.ee.drive.render.m;
import java.util.List;
import javax.inject.Inject;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class a implements t75.a {
    @Inject
    public a() {
    }

    @Override // t75.a
    public final void a(Resources.Theme r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "theme");
        Intrinsics.checkNotNullParameter(r101, "tag");
    }

    @Override // t75.a
    public final /* synthetic */ void c() {
    }

    @Override // t75.a
    public final void e() {
    }

    @Override // t75.a
    public final void f(m r100) {
        Intrinsics.checkNotNullParameter(r100, "abilityProvider");
    }

    @Override // t75.a
    public final void g(DrivePluginHost r100) {
        Intrinsics.checkNotNullParameter(r100, "host");
    }

    @Override // t75.a
    public final void h(DrivePluginHost r100) {
        Intrinsics.checkNotNullParameter(r100, "host");
        Intrinsics.checkNotNullParameter("drive_more_open_chat", "from");
    }

    @Override // t75.a
    public final n b(PluginHost r100) {
        Intrinsics.checkNotNullParameter(r100, "host");
        return new n(new n.a[0]);
    }

    @Override // t75.a
    public final List<i> d(Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, "parentFragment");
        return CollectionsKt.emptyList();
    }
}
