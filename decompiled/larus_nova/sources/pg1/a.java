package pg1;

import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes7.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<Integer, String> f529139a = null;

    static {
        f529139a = MapsKt.mapOf(new Pair[]{TuplesKt.to(1, "更多直播"), TuplesKt.to(2, "更多关注"), TuplesKt.to(3, "更多同城"), TuplesKt.to(4, "更多好物"), TuplesKt.to(5, "更多精选"), TuplesKt.to(11, "购物频道"), TuplesKt.to(12, "游戏频道"), TuplesKt.to(13, "聊天频道"), TuplesKt.to(14, "语音频道"), TuplesKt.to(15, "音乐频道")});
    }

    public static String a(int r100) {
        return f529139a.get(Integer.valueOf(r100));
    }
}
