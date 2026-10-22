package rm6;

import com.bytedance.locallife.common.utils.d;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f538571a = 0;

    static {
    }

    public static Object a(String r100, Class r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "originClass");
        b r102 = b.f538567a;
        Intrinsics.checkNotNullParameter(r100, "key");
        int r103 = com.bytedance.ies.bullet.kit.resourceloader.loader.b.f246865a;
        r102.b();
        String r104 = b.f538569c.get(r100);
        if (r104 != null) goto L7;
        return null;
    L7:
        if (r101.isInstance(r104) == false) goto L10;
        return r104;
    L10:
        return GsonProtectorUtils.fromJson(d.b(), r104, r101);
    }
}
