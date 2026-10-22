package yx2;

import am3.g;
import am3.h;
import com.bytedance.android.live.profit.fansclub.backend.IFansclubParticipateIncentive;
import java.lang.reflect.Type;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class a extends com.bytedance.tools.kcp.modelx.runtime.internal.decode.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f569378a = null;

    static {
        f569378a = new a();
    }

    public a() {
    }

    @Override // com.bytedance.tools.kcp.modelx.runtime.internal.decode.a
    public final Pair<Integer, Type> b(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "name");
        if (r100 == 0) goto L6;
        return TuplesKt.to(-1, Object.class);
    L6:
        if (r101.hashCode() != (-1911372963)) goto L12;
        if (r101.equals("popup_data") == false) goto L12;
        return TuplesKt.to(3, String.class);
    L12:
        return com.bytedance.tools.kcp.modelx.runtime.internal.decode.a.C3795a.c(IFansclubParticipateIncentive.class, r101);
    }

    @Override // com.bytedance.tools.kcp.modelx.runtime.internal.decode.a
    public final Object a(int r100, int r101, g r102) {
        Intrinsics.checkNotNullParameter(r102, "reader");
        if (r100 == 0) goto L7;
        h.e(r102);
        return null;
    L7:
        if (r101 == 3) goto L10;
        return null;
    L10:
        return h.c(r102);
    }
}
