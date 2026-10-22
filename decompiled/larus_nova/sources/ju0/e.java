package ju0;

import com.bytedance.android.live.profit.format.voicechat.model.VoiceChatState;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
public final class e extends b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final VoiceChatState f500403b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f500404c;

    public e(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        super(r100);
        VoiceChatState.a r101 = VoiceChatState.Companion;
        String r102 = r100.optString("cur_state", "unknown");
        r101.getClass();
        Intrinsics.checkNotNullParameter(r102, "state");
        VoiceChatState[] r103 = VoiceChatState.values();
        int r104 = r103.length;
        int r105 = 0;
    L3:
        if (r105 >= r104) goto L8;
        VoiceChatState r106 = r103[r105];
        if (Intrinsics.areEqual(r106.getState(), r102) == true) goto L9;
        r105 = r105 + 1;
    L9:
        if (r106 != null) goto L11;
        r106 = VoiceChatState.UNKNOWN;
    L11:
        this.f500403b = r106;
        this.f500404c = r100.optLong("event_time", 0);
        return;
    L8:
        r106 = null;
        goto L9
    }
}
