package rx2;

import am3.g;
import am3.h;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.l1;
import com.bytedance.android.livesdk.gift.model.m2;
import java.lang.reflect.Type;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class a extends com.bytedance.tools.kcp.modelx.runtime.internal.decode.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f539809a = null;

    static {
        f539809a = new a();
    }

    public a() {
    }

    @Override // com.bytedance.tools.kcp.modelx.runtime.internal.decode.a
    public final Pair<Integer, Type> b(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "name");
        if (r100 == 0) goto L20;
        if (r100 != 1) goto L21;
        int r102 = r101.hashCode();
        if (r102 == (-1417592938)) goto L16;
        if (r102 != 3172656) goto L24;
        if (r101.equals(PbRequest.SwitchType.GIFT) == false) goto L24;
        return TuplesKt.to(17, h1.class);
    L24:
        return com.bytedance.tools.kcp.modelx.runtime.internal.decode.a.C3795a.c(m2.class, r101);
    L16:
        if (r101.equals("client_gift_source") == false) goto L24;
        return TuplesKt.to(18, Long.TYPE);
    L21:
        return TuplesKt.to(-1, Object.class);
    L20:
        return com.bytedance.tools.kcp.modelx.runtime.internal.decode.a.C3795a.c(l1.class, r101);
    }

    @Override // com.bytedance.tools.kcp.modelx.runtime.internal.decode.a
    public final Object a(int r100, int r101, g r102) {
        Intrinsics.checkNotNullParameter(r102, "reader");
        if (r100 != 0) goto L5;
        return null;
    L5:
        if (r100 == 1) goto L9;
        h.e(r102);
        return null;
    L9:
        if (r101 == 17) goto L15;
        if (r101 == 18) goto L17;
        return null;
    L17:
        return Long.valueOf(r102.j());
    L15:
        return com.bytedance.tools.kcp.modelx.runtime.internal.decode.a.C3795a.a(h1.class, r102);
    }
}
