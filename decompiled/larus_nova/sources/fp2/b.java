package fp2;

import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.live.datacontext.i;
import java.util.Map;
import jc1.k;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<Integer, String> f478230a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<LiveMode, String> f478231b = null;

    static {
        f478230a = MapsKt.mapOf(new Pair[]{TuplesKt.to(1, PbRequest.SwitchType.PK), TuplesKt.to(2, "anchorLink"), TuplesKt.to(7, "anchorLink"), TuplesKt.to(4, "audienceLink"), TuplesKt.to(5, "audioChatRoom"), TuplesKt.to(8, "videoTalkRoom"), TuplesKt.to(12, "videoTalkRoom"), TuplesKt.to(9, "audioKtv")});
        f478231b = MapsKt.mapOf(new Pair[]{TuplesKt.to(LiveMode.VIDEO, "video"), TuplesKt.to(LiveMode.AUDIO, "audio"), TuplesKt.to(LiveMode.THIRD_PARTY, "thirdParty"), TuplesKt.to(LiveMode.SCREEN_RECORD, "game"), TuplesKt.to(LiveMode.OFFICIAL_ACTIVITY, "official"), TuplesKt.to(LiveMode.MEDIA, "media")});
    }

    public static LiveMode b() {
        RoomContext r100 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r100 == null) goto L8;
        i<LiveMode> r101 = r100.getLiveMode();
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.getValue();
    L8:
        return null;
    }

    public static boolean e() {
        RoomContext r100 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r100 == null) goto L9;
        i<Boolean> r101 = r100.isAnchor();
        if (r101 == null) goto L9;
        Boolean r102 = r101.getValue();
        if (r102 == null) goto L9;
        return r102.booleanValue();
    L9:
        return false;
    }

    public static cp2.b a() {
        LiveMode r100 = b();
        if (r100 == null) goto L10;
        if (a.f478229a[r100.ordinal()] != 1) goto L10;
        return new cp2.b(true, true);
    L10:
        return new cp2.b(true, true);
    }

    public static int c(String r100) {
        IInteractService r101 = (IInteractService) k.f(IInteractService.class);
        if (r101 == null) goto L5;
        int r102 = r101.getCurrentScene();
    L6:
        if (r102 <= 0) goto L9;
        return r102;
    L9:
        if (Intrinsics.areEqual(r100, "rule_tag_live_end_broadcast") == true) goto L11;
        Intrinsics.areEqual(r100, "rule_tag_live_activity_destroy");
    L11:
        return r102;
    L5:
        r102 = 0;
        goto L6
    }

    public static String d(String r100) {
        return f478230a.get(Integer.valueOf(c(r100)));
    }
}
