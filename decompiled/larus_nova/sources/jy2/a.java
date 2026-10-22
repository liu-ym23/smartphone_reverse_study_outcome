package jy2;

import am3.g;
import am3.h;
import com.bytedance.android.live.base.model.message.f3;
import com.bytedance.android.livesdk.chatroom.vs_base.base.api.ReplayInfoApi;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeHighLight;
import java.lang.reflect.Type;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class a extends com.bytedance.tools.kcp.modelx.runtime.internal.decode.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f500940a = null;

    static {
        f500940a = new a();
    }

    public a() {
    }

    @Override // com.bytedance.tools.kcp.modelx.runtime.internal.decode.a
    public final Pair<Integer, Type> b(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "name");
        if (r100 == 0) goto L15;
        if (r100 == 1) goto L8;
        return TuplesKt.to(-1, Object.class);
    L8:
        if (r101.hashCode() != (-982754077)) goto L24;
        if (r101.equals("points") == false) goto L24;
        return TuplesKt.to(2, com.bytedance.tools.kcp.modelx.runtime.internal.decode.a.C3795a.d(List.class, CollectionsKt.listOf(EpisodeHighLight.class)));
    L24:
        return com.bytedance.tools.kcp.modelx.runtime.internal.decode.a.C3795a.c(f3.class, r101);
    L15:
        if (r101.hashCode() != 1082186007) goto L21;
        if (r101.equals("lvideo_item_id") == false) goto L21;
        return TuplesKt.to(3, Long.TYPE);
    L21:
        return com.bytedance.tools.kcp.modelx.runtime.internal.decode.a.C3795a.c(ReplayInfoApi.a.class, r101);
    }

    @Override // com.bytedance.tools.kcp.modelx.runtime.internal.decode.a
    public final Object a(int r100, int r101, g r102) {
        Intrinsics.checkNotNullParameter(r102, "reader");
        if (r100 == 0) goto L14;
        if (r100 == 1) goto L9;
        h.e(r102);
        return null;
    L9:
        if (r101 == 2) goto L12;
        return null;
    L12:
        return com.bytedance.tools.kcp.modelx.runtime.internal.decode.a.C3795a.e(com.bytedance.tools.kcp.modelx.runtime.internal.decode.a.C3795a.a(EpisodeHighLight.class, r102));
    L14:
        if (r101 == 3) goto L17;
        return null;
    L17:
        return Long.valueOf(r102.j());
    }
}
