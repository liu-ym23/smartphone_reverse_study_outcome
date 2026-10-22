package mb0;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public final class e {
    public static final void a(JSONObject r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$putMusicId");
        r100.put("music_id", String.valueOf(r101));
    }

    public static final void b(JSONObject r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$putMusicName");
        Intrinsics.checkNotNullParameter(r101, "musicName");
        r100.put("music_name", r101);
    }
}
