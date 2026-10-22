package qx2;

import am3.g;
import am3.h;
import com.bytedance.android.livesdkapi.depend.model.live.ActivityRoomSkinInfo;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.lang.reflect.Type;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class a extends com.bytedance.tools.kcp.modelx.runtime.internal.decode.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f535101a = null;

    static {
        f535101a = new a();
    }

    public a() {
    }

    @Override // com.bytedance.tools.kcp.modelx.runtime.internal.decode.a
    public final Pair<Integer, Type> b(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "name");
        if (r100 == 0) goto L6;
        return TuplesKt.to(-1, Object.class);
    L6:
        if (r101.hashCode() != (-1534157060)) goto L12;
        if (r101.equals("activity_room_skin_info") == false) goto L12;
        return TuplesKt.to(158, ActivityRoomSkinInfo.class);
    L12:
        return com.bytedance.tools.kcp.modelx.runtime.internal.decode.a.C3795a.c(IRoom.class, r101);
    }

    @Override // com.bytedance.tools.kcp.modelx.runtime.internal.decode.a
    public final Object a(int r100, int r101, g r102) {
        Intrinsics.checkNotNullParameter(r102, "reader");
        if (r100 == 0) goto L7;
        h.e(r102);
        return null;
    L7:
        if (r101 == 158) goto L10;
        return null;
    L10:
        return (ActivityRoomSkinInfo) com.bytedance.tools.kcp.modelx.runtime.internal.decode.a.C3795a.a(ActivityRoomSkinInfo.class, r102);
    }
}
