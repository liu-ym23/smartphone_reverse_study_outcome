package sv6;

import com.bytedance.locallife.live.util.LiveLifeSaaSUtil;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f543666a = 0;

    static {
    }

    public static void b(String r100, Exception r101) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r101, "e");
        String r102 = "error_at_".concat(r100);
        String r103 = r101.getMessage();
        if (r103 != null) goto L5;
        r103 = "";
    L5:
        a(r102, r103, null);
        int r104 = com.bytedance.locallife.biz.mob.a.f256703c;
        com.bytedance.locallife.biz.mob.a.C3646a.c("local_live_virgo_exception", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("scene", r100), TuplesKt.to("msg", r101.getMessage())}));
    }

    public static void a(String r100, String r101, Map r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        qs6.b r103 = LiveLifeSaaSUtil.t();
        Map r104 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("sub_tag", r100), TuplesKt.to("msg", r101)});
        if (r102 != null) goto L5;
        r102 = MapsKt.emptyMap();
    L5:
        r104.putAll(r102);
        Unit r105 = Unit.INSTANCE;
        r103.d("VirgoLog", r104.toString());
    }
}
