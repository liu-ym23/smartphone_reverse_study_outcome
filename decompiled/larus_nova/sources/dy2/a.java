package dy2;

import am3.g;
import am3.h;
import java.lang.reflect.Type;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class a extends com.bytedance.tools.kcp.modelx.runtime.internal.decode.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f470519a = null;

    static {
        f470519a = new a();
    }

    public a() {
    }

    @Override // com.bytedance.tools.kcp.modelx.runtime.internal.decode.a
    public final Pair<Integer, Type> b(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "name");
        if (r100 == 0) goto L6;
        return TuplesKt.to(-1, Object.class);
    L6:
        return com.bytedance.tools.kcp.modelx.runtime.internal.decode.a.C3795a.c(com.bytedance.android.live.base.model.message.guestlink.a.class, r101);
    }

    @Override // com.bytedance.tools.kcp.modelx.runtime.internal.decode.a
    public final Object a(int r100, int r101, g r102) {
        Intrinsics.checkNotNullParameter(r102, "reader");
        if (r100 == 0) goto L7;
        h.e(r102);
        return null;
    L7:
        return null;
    }
}
