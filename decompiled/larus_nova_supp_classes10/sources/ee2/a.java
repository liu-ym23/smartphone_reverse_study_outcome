package ee2;

import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.trace.MultiTraceData;
import com.bytedance.android.livesdk.ktvimpl.base.orderedsong.KtvComponentOrderedSongDataContext;
import com.bytedance.android.livesdk.message.model.InteractiveSongUserInfo;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.google.gson.JsonObject;
import ih0.b;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import xe2.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void b(String r9) {
        Intrinsics.checkNotNullParameter("realtime_chorus", "businessId");
        Intrinsics.checkNotNullParameter(r9, "status");
        JsonObject r2 = new JsonObject();
        r2.addProperty("status", r9);
        c("realtime_chorus", "onMusicStatusChanged", r2);
        int r1 = g.a;
        KtvComponentOrderedSongDataContext r3 = KtvComponentOrderedSongDataContext.Companion.getContext();
        if (r3 == null) goto L5;
        MusicPanel r4 = r3.getKtvPublicFirstOrderedSong();
    L6:
        Intrinsics.checkNotNullParameter(r9, "status");
        JSONObject r7 = new JSONObject();
        r7.put("status", r9);
        String r10 = "";
        if (r4 == null) goto L11;
        KtvMusic r0 = r4.a;
        if (r0 == null) goto L11;
        Object r5 = Long.valueOf(r0.getMId());
    L12:
        r7.put("music_id", r5);
        if (r4 == null) goto L18;
        KtvMusic r6 = r4.a;
        if (r6 == null) goto L18;
        String r8 = r6.getMTitle();
        if (r8 == null) goto L18;
    L19:
        r7.put("music_name", r8);
        if (r4 == null) goto L27;
        InteractiveSongUserInfo r11 = r4.f();
        if (r11 == null) goto L27;
        String r12 = String.valueOf(r11.getId());
        if (r12 == null) goto L27;
        r10 = r12;
    L27:
        r7.put("order_user_id", r10);
        int r13 = rd0.a.a;
        rd0.a.b(MultiTraceData.TraceBusiness.RTChorus, MultiTraceData.TraceEvent.JoinChorus, "MusicPlayStateChanged", 0, null, r7, 88);
        return;
    L18:
        r8 = "";
    L11:
        r5 = "";
        goto L12
    L5:
        r4 = null;
        goto L6
    }

    public static void a(boolean r4, String r5, String r6) {
        Intrinsics.checkNotNullParameter("realtime_chorus", "businessId");
        Intrinsics.checkNotNullParameter(r5, "musicId");
        Intrinsics.checkNotNullParameter(r6, "ownerId");
        JsonObject r2 = new JsonObject();
        r2.addProperty("success", Boolean.valueOf(r4));
        r2.addProperty("id", r5);
        r2.addProperty("ownerId", r6);
        c("realtime_chorus", "onMusicDownloadStatus", r2);
    }

    public static void c(String r2, String r3, JsonObject r4) {
        r4.addProperty("sub_type", "karaoke");
        IInteractService r0 = k.f(IInteractService.class);
        if (r0 == null) goto L8;
        b r1 = r0.dynamicService(null);
        if (r1 == null) goto L9;
        r1.Dk(r2, r3, r4, false);
        return;
    L9:
        return;
    }
}
