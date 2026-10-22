package xe2;

import am2.x;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.livesdk.chatroom.utils.o3;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class d<T, R> implements Function {
    public final /* synthetic */ c a;

    public d(c r1) {
        this.a = r1;
    }

    public final Object apply(Object r18) {
        Object[] r1 = (Object[]) r18;
        Intrinsics.checkNotNullParameter(r1, "args");
        ArrayList r2 = new ArrayList();
        int r3 = r1.length;
        int r5 = 0;
    L3:
        if (r5 >= r3) goto L11;
        Object r6 = r1[r5];
        if ((r6 instanceof Long) == true) goto L7;
        r6 = null;
    L7:
        Long r7 = (Long) r6;
        if (r7 == null) goto L10;
        r2.add(r7);
    L10:
        r5 = r5 + 1;
        goto L3
    L11:
        long r8 = 0;
        if (r2.isEmpty() == true) goto L23;
        Iterator r4 = r2.iterator();
    L16:
        if (r4.hasNext() == false) goto L23;
        if (((Number) r4.next()).longValue() != 0) goto L20;
        boolean r9 = true;
    L21:
        if (r9 == false) goto L16;
        boolean r10 = false;
    L24:
        if (r10 == false) goto L50;
        long r11 = this.a.b("music_download_time") - this.a.b("start_time");
        if (r11 > 0) goto L29;
        r11 = 0;
    L29:
        long r12 = this.a.b("music_set_time") - this.a.b("music_download_time");
        if (r12 > 0) goto L33;
        r12 = 0;
    L33:
        long r13 = this.a.b("seek_sync_info_time") - this.a.b("music_set_time");
        if (r13 > 0) goto L37;
        r13 = 0;
    L37:
        long r14 = this.a.b("seek_sync_info_time") - this.a.b("start_time");
        if (r14 <= 0) goto L40;
        r8 = r14;
    L40:
        ALogger.i("RTChorusJoinChorusMonitor", "musicDownloadDuration == " + r11 + " ;; musicSetDuration == " + r12 + " ;; seekSyncInfoDuration == " + r13 + " ;; joinChorusTotalDuration == " + r8);
        LinkedHashMap r15 = new LinkedHashMap();
        r15.put("music_download_duration", String.valueOf(r11));
        r15.put("music_set_duration", String.valueOf(r12));
        r15.put("seek_sync_info_duration", String.valueOf(r13));
        r15.put("join_chorus_total_duration", String.valueOf(r8));
        this.a.getClass();
        r15.put("use_parallel_strategy", String.valueOf(0));
        b.b.getClass();
        Intrinsics.checkNotNullParameter(r15, "extraParams");
        JSONObject r16 = new JSONObject();
        Iterator r17 = r15.entrySet().iterator();
    L42:
        if (r17.hasNext() == false) goto L44;
        Map.Entry r19 = (Map.Entry) r17.next();
        r16.put((String) r19.getKey(), r19.getValue());
        goto L42
    L44:
        b.s(LinkMonitorData.UserJoinChorusTime, r16);
        Intrinsics.checkNotNullParameter(r15, "extraParams");
        HashMap r20 = new HashMap();
        if (Intrinsics.areEqual(o3.f().isAnchor(), Boolean.TRUE) == false) goto L47;
        String r21 = "anchor";
    L48:
        r20.put("user_type", r21);
        r20.putAll(r15);
        j0.l().sendLog("livesdk_chorus_join_duration", r20, new Object[]{IRoom.class, x.class});
        this.a.a();
        goto L50
    L47:
        r21 = "user";
    L50:
        return Unit.INSTANCE;
    L20:
        r9 = false;
    L23:
        r10 = true;
        goto L24
    }
}
