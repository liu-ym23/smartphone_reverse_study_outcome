package z26;

import com.bytedance.ies.bullet.service.base.test.TEventFrom;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Object> f569787a;

    public a(String r100, TEventFrom r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "from");
        System.currentTimeMillis();
        this.f569787a = new ConcurrentHashMap();
    }
}
