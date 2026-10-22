package ih;

import com.bytedance.android.ec.core.apt.ActionType;
import com.bytedance.android.ec.core.monitor.attribution.UserActionCacheMap;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<String> f489763a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final UserActionCacheMap<ActionType> f489764b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final UserActionCacheMap<String> f489765c;

    public b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "prefix");
        this.f489763a = new ArrayList();
        this.f489764b = new UserActionCacheMap(r100);
        this.f489765c = new UserActionCacheMap(r100);
    }
}
