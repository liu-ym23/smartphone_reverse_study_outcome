package xi9;

import com.bytedance.ies.xbridge.XReadableMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class c extends com.bytedance.ies.xbridge.model.params.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f563974c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f563975a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final XReadableMap f563976b;

    public static final class a {
    }

    static {
    }

    public c(String r100, XReadableMap r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "params");
        this.f563975a = r100;
        this.f563976b = r101;
    }
}
