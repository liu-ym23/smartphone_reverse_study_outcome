package mv0;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class j implements qs0.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f515823a = null;

    public j() {
    }

    static {
        f515823a = new j();
    }

    @Override // qs0.h
    public final String getCurrentPlayModes() {
        return com.bytedance.android.live.liveinteract.utils.w.a();
    }

    @Override // qs0.h
    public final void M0(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        com.bytedance.android.live.liveinteract.utils.w.b(r100);
    }
}
