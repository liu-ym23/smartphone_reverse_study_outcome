package zmb;

import com.ss.android.lark.biz.im.api.page.plugin.PluginType;
import com.ss.android.lark.scaffold.PagePlugin;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class b implements qya.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<PluginType, Provider<PagePlugin>> f572883a;

    @Inject
    public b(Map<PluginType, Provider<PagePlugin>> r100) {
        Intrinsics.checkNotNullParameter(r100, "map");
        this.f572883a = r100;
    }

    @Override // qya.a
    public final PagePlugin a(PluginType r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Provider<PagePlugin> r101 = this.f572883a.get(r100);
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.get();
    }
}
