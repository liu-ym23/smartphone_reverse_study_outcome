package sr9;

import com.larus.bmhome.actionbar.model.z0;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class f implements com.larus.bmhome.view.actionbar.custom.cache.k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f543240a = null;

    static {
        f543240a = new f();
    }

    public f() {
    }

    @Override // com.larus.bmhome.view.actionbar.custom.cache.k
    public final boolean a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "botId");
        Intrinsics.checkNotNullParameter(r101, "itemId");
        return false;
    }

    @Override // com.larus.bmhome.view.actionbar.custom.cache.k
    public final void b(List<z0> r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "botId");
    }
}
