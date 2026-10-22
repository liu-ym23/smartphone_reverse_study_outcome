package pp2;

import android.os.Bundle;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.eventbus.JumpToOtherRoomEvent;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class b extends com.bytedance.ies.web.jsbridge2.g<a, Object> {

    public static class a {

        @SerializedName("extra")
        private JsonObject extra;

        @SerializedName("orientation")
        private int orientation;

        @SerializedName("rank")
        private String rank;

        @SerializedName("rank_type")
        private String rankType;

        @SerializedName("room_id")
        private long roomId;

        @SerializedName("room_ids")
        private long[] roomIds;

        @SerializedName("user_id")
        private String userId;

        public a() {
        }

        public static /* synthetic */ String a(a r100) {
            return r100.rankType;
        }

        public static /* synthetic */ String b(a r100) {
            return r100.userId;
        }

        public static /* synthetic */ String c(a r100) {
            return r100.rank;
        }

        public static /* synthetic */ long[] d(a r100) {
            return r100.roomIds;
        }

        public static /* synthetic */ long e(a r100) {
            return r100.roomId;
        }

        public static /* synthetic */ JsonObject f(a r100) {
            return r100.extra;
        }
    }

    public b(DataCenter r100) {
    }

    @Override // com.bytedance.ies.web.jsbridge2.g
    public final Object invoke(a r110, CallContext r111) throws Exception {
        a r112 = r110;
        int r100 = rp2.a.f538839a;
        ContextUtil.contextToActivity(r111.getContext());
        String r113 = a.a(r112);
        String r101 = a.b(r112);
        String r102 = a.c(r112);
        long[] r103 = a.d(r112);
        long r104 = a.e(r112);
        JsonObject r114 = a.f(r112);
        Intrinsics.checkNotNullParameter(r101, "userId");
        Intrinsics.checkNotNullParameter(r102, "rank");
        Bundle r105 = new Bundle();
        r105.putString("source", r113);
        r105.putString("enter_from", "live_detail");
        r105.putString("source", r113);
        r105.putString("anchor_id", r101);
        r105.putString("enter_from_merge", "live_detail");
        r105.putString("enter_method", r113);
        r105.putString("starlight_rank", r102);
        Bundle r106 = new Bundle();
        r106.putString(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_LIVE_SOURCE_V1, r113);
        r105.putBundle(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_LIVE_EXTRA_V1, r106);
        r105.putString("anchor_id", r101);
        r105.putLongArray(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_ROOM_IDS, r103);
        if (r114 == null) goto L5;
        r105.putString(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_JUMP_EXTRA, r114.toString());
    L5:
        r105.putInt("back_source", 3);
        ((com.bytedance.android.livesdk.revenue.service.room.b) vh6.c.b(com.bytedance.android.livesdk.revenue.service.room.b.class)).fd();
        JumpToOtherRoomEvent r115 = new JumpToOtherRoomEvent(r104, "live_detail", r105);
        r115.source = "sourceJumpToOtherRankService";
        xs2.b.a().post(r115);
        return null;
    }
}
