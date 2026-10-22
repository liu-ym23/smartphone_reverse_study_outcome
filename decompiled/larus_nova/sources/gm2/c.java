package gm2;

import com.bytedance.android.livesdkapi.depend.message.DistributionStatusMessage;
import com.bytedance.android.livesdkapi.depend.message.FollowTopRefreshMessage;
import com.bytedance.android.livesdkapi.depend.message.InnerDrawRefreshMessage;
import com.bytedance.android.livesdkapi.depend.message.PcuLevelBroadcastMessage;
import com.bytedance.android.livesdkapi.depend.message.RoomFeatureMessage;
import java.util.Map;

/* JADX INFO: loaded from: classes11.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f481653a = null;

    public c() {
    }

    static {
        f481653a = new c();
        new com.bytedance.android.livesdk.sharedpref.e("bytelink_persist_cursor", "");
    }

    public static void a() {
        Map<String, Class<?>> r100 = qmc.a.f533977a;
        qmc.a.C7364a.a("WebcastDistributionStatusMessage", DistributionStatusMessage.class);
        qmc.a.C7364a.a("WebcastPcuLevelBroadcastMessage", PcuLevelBroadcastMessage.class);
        qmc.a.C7364a.a("WebcastFollowTopRefreshMessage", FollowTopRefreshMessage.class);
        qmc.a.C7364a.a("WebcastRoomFeatureMessage", RoomFeatureMessage.class);
        qmc.a.C7364a.a("InnerDrawRefreshMessage", InnerDrawRefreshMessage.class);
    }
}
