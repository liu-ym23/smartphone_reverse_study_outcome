package mb0;

import com.bytedance.android.live.base.exception.ApiException;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.base.model.exception.NetworkErrorException;
import com.bytedance.android.live.core.monitor.BaseMonitor;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public abstract class b extends BaseMonitor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f512758a = 0;

    public static final class a {
        public static int a(Throwable r100) {
            if ((r100 instanceof ApiServerException) == false) goto L6;
            return ((ApiServerException) r100).getErrorCode();
        L6:
            if ((r100 instanceof NetworkErrorException) == false) goto L9;
            return ((NetworkErrorException) r100).statusCode;
        L9:
            if ((r100 instanceof ApiException) == true) goto L15;
            return 0;
        L15:
            return ((ApiException) r100).getErrorCode();
        }

        public static String b(Throwable r100) {
            if ((r100 instanceof ApiServerException) == false) goto L6;
            return ((ApiServerException) r100).getErrorMsg();
        L6:
            if ((r100 instanceof NetworkErrorException) == false) goto L9;
            return r100.getMessage();
        L9:
            if ((r100 instanceof Exception) == true) goto L15;
            return null;
        L15:
            return r100.getMessage();
        }
    }

    static {
    }

    public b() {
    }

    public static void l(JSONObject r100, MusicPanel r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$putAllPath");
        if (r101 == null) goto L6;
        r100.put("full_track_path", r101.f153590n);
        r100.put("accompaniment_track_path", r101.f153591o);
        r100.put("midi_path", r101.f153593q);
        r100.put("lyrics_path", r101.f153588l);
        return;
    }

    public static JSONObject m(JSONObject r100, Number r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$putErrorCode");
        Intrinsics.checkNotNullParameter(r101, "errorCode");
        return r100.put("error_code", r101);
    }

    public static JSONObject n(JSONObject r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$putErrorMsg");
        Intrinsics.checkNotNullParameter(r101, "errorMsg");
        return r100.put("error_msg", r101);
    }

    public static JSONObject o(JSONObject r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$putLyricsUrl");
        Intrinsics.checkNotNullParameter(r101, "lyricsUrl");
        return r100.put("lyrics_url", r101);
    }

    public static JSONObject p(JSONObject r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$putMusicId");
        return r100.put("music_id", String.valueOf(r101));
    }

    public static JSONObject q(JSONObject r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$putMusicName");
        Intrinsics.checkNotNullParameter(r101, "musicName");
        return r100.put("music_name", r101);
    }

    public static JSONObject r(JSONObject r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$putProcess");
        Intrinsics.checkNotNullParameter(r101, "process");
        return r100.put("in_process", r101);
    }
}
