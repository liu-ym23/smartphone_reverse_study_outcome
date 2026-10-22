package zmb;

import com.ss.android.lark.biz.im.api.page.configurator.ConfiguratorType;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;
import l3c.c;

/* JADX INFO: loaded from: classes36.dex */
public final class a implements pya.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<ConfiguratorType, Provider<c>> f572882a;

    @Inject
    public a(Map<ConfiguratorType, Provider<c>> r100) {
        Intrinsics.checkNotNullParameter(r100, "map");
        this.f572882a = r100;
    }

    @Override // pya.a
    public final c a(ConfiguratorType r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Provider<c> r101 = this.f572882a.get(r100);
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.get();
    }
}
