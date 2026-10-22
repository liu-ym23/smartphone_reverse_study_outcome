package mb0;

import com.bef.effectsdk.RequirementDefine;
import com.bytedance.android.live.liveinteract.api.trace.MultiTraceData$TraceBusiness;
import com.bytedance.android.live.liveinteract.api.trace.MultiTraceData$TraceEvent;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f512763a = 0;

    static {
    }

    public static void a(int r100, boolean r101, String r110, boolean r111) {
        Intrinsics.checkNotNullParameter(r110, "interactId");
        JSONObject r102 = new JSONObject();
        r102.put(DownloadSettingKeys.SegmentConfig.BUFFER_SIZE, r100);
        r102.put("isRetry", r101);
        r102.put("interact_id", r110);
        r102.put("anchor_is_singer", r111);
        int r103 = rd0.a.f537202a;
        rd0.a.b(MultiTraceData$TraceBusiness.AILyricsRecognize, MultiTraceData$TraceEvent.LyricsRecognize, "startRecognize", 0, null, r102, 88);
    }

    public static void b(boolean r100, String r101, String r102, Integer r110) {
        JSONObject r103 = new JSONObject();
        r103.put("is_recognizing", r100);
        boolean r104 = true;
        if (r101.length() != 0) goto L5;
        boolean r105 = true;
    L6:
        if (r105 == true) goto L9;
        r103.put("song_id", r101);
    L9:
        if (r102.length() == 0) goto L12;
        r104 = false;
    L12:
        if (r104 == true) goto L14;
        r103.put("song_name", r102);
    L14:
        if (r110 == null) goto L16;
        r103.put(RequirementDefine.REQUIREMENT_SIMILARITY_TAG, r110.intValue());
    L16:
        int r106 = rd0.a.f537202a;
        rd0.a.b(MultiTraceData$TraceBusiness.AILyricsRecognize, MultiTraceData$TraceEvent.LyricsRecognize, "stopRecognize", 0, null, r103, 88);
        return;
    L5:
        r105 = false;
        goto L6
    }
}
