package mv6;

import com.bytedance.locallife.live.message.LiveLocalLifeMessage;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<Class<?>, am3.c<?>> f515895a = null;

    static {
        HashMap r100 = new HashMap();
        f515895a = r100;
        Intrinsics.checkNotNullParameter(r100, "map");
        r100.put(LiveLocalLifeMessage.class, new h());
    }
}
