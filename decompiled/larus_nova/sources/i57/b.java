package i57;

import android.content.Context;
import com.bytedance.platform.aio.context.CallContextDslMaker;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@CallContextDslMaker
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Object> f488317a;

    public b() {
        this.f488317a = new LinkedHashMap();
    }

    public final void a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        this.f488317a.put(e.f488324f.a().f488316a, r100);
    }
}
