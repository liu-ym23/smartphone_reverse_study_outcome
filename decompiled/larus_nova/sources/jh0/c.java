package jh0;

import am2.x;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.live.liveinteract.linkpanel.util.o;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.plantform.utils.u0;
import com.bytedance.android.livesdk.app.dataholder.Observer;
import com.bytedance.android.livesdk.chatroom.viewmodel.LivePlayModeLogContext;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.config.FastStartLiveConfig;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.live.datacontext.j;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes46.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Integer, Long> f499068a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f499069b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f499070c;

    public static final class a {
    }

    public static final class b<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f499071a;

        public b(c r100) {
            this.f499071a = r100;
        }

        @Override // com.bytedance.android.livesdk.app.dataholder.Observer
        public final void onChanged(Object r100) {
            Integer r101 = (Integer) r100;
            if (gh0.a.d() == true) goto L23;
            ALogger.i("DynamicBizLogHelper", "linkPlayerState onChanged: " + r101);
            if (this.f499071a.f499069b == true) goto L13;
            if (hd0.c.f().h() == false) goto L13;
            c r102 = this.f499071a;
            r102.f499069b = true;
            ALogger.i("DynamicBizLogHelper", "onStartMultiLink");
            if ((!r102.f499068a.isEmpty()) == false) goto L13;
            r102.b(null);
        L13:
            if (this.f499071a.f499069b == true) goto L15;
            return;
        L15:
            if (hd0.c.f().h() == true) goto L21;
            c r103 = this.f499071a;
            r103.f499069b = false;
            ALogger.i("DynamicBizLogHelper", "onStartMultiLink");
            if ((!r103.f499068a.isEmpty()) == false) goto L22;
            r103.c(null);
            return;
        L22:
            return;
        L21:
            return;
        }
    }

    static {
    }

    public c() {
        this.f499068a = new LinkedHashMap();
        this.f499069b = hd0.c.f().h();
        this.f499070c = new b(this);
    }

    public final void a(Integer r110) {
        ALogger.i("DynamicBizLogHelper", "logAudiencePlaymodeRoomWatchDuration, playModes: " + ((LinkedHashMap) this.f499068a).keySet());
        HashMap r100 = new HashMap();
        zi0.d.b(r100, true);
        if (r110 == null) goto L7;
        Long r101 = (Long) ((LinkedHashMap) this.f499068a).get(r110);
        if (r101 == null) goto L16;
        long r102 = r101.longValue();
        r100.put(FastStartLiveConfig.PLAY_MODE, u0.k(r110.intValue()));
        r100.put("duration", String.valueOf((System.currentTimeMillis() - r102) / ((long) 1000)));
        j0.l().sendLog("livesdk_audience_playmode_room_watch_duration", r100, new Object[]{IRoom.class, x.class});
        return;
    L16:
        return;
    L7:
        Set r111 = ((LinkedHashMap) this.f499068a).keySet();
        if (r111 != null) goto L10;
        return;
    L10:
        Iterator r112 = r111.iterator();
    L12:
        if (r112.hasNext() == false) goto L23;
        int r103 = ((Number) r112.next()).intValue();
        r100.put(FastStartLiveConfig.PLAY_MODE, u0.k(r103));
        Long r104 = (Long) ((LinkedHashMap) this.f499068a).get(Integer.valueOf(r103));
        if (r104 == null) goto L12;
        r100.put("duration", String.valueOf((System.currentTimeMillis() - r104.longValue()) / ((long) 1000)));
        j0.l().sendLog("livesdk_audience_playmode_room_watch_duration", r100, new Object[]{IRoom.class, x.class});
        goto L12
    }

    public final void b(Integer r110) {
        ALogger.i("DynamicBizLogHelper", "logAudiencePlaymodeRoomlink, playModes: " + ((LinkedHashMap) this.f499068a).keySet());
        LinkedHashMap r100 = new LinkedHashMap();
        TalkRoomLogUtils.V0(r100);
        if (o.c() != 16) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L18;
        j<LivePlayModeLogContext> r102 = m.d().J();
        if (r102 == null) goto L17;
        LivePlayModeLogContext r103 = r102.getValue();
        if (r103 == null) goto L17;
        com.bytedance.live.datacontext.m<Set<Integer>> r104 = r103.getPlayModes();
        if (r104 == null) goto L17;
        Set<Integer> r105 = r104.getValue();
        if (r105 == null) goto L17;
        if (r105.contains(16) == true) goto L18;
    L17:
        boolean r106 = true;
    L20:
        if (r110 == null) goto L25;
        if (r106 == false) goto L23;
        r100.put(FastStartLiveConfig.PLAY_MODE, "link_room");
    L24:
        j0.l().sendLog("livesdk_audience_playmode_room_link", r100, new Object[]{IRoom.class, x.class});
        return;
    L23:
        r100.put(FastStartLiveConfig.PLAY_MODE, u0.k(r110.intValue()));
        goto L24
    L25:
        if (r106 == false) goto L27;
        r100.put(FastStartLiveConfig.PLAY_MODE, "link_room");
        j0.l().sendLog("livesdk_audience_playmode_room_link", r100, new Object[]{IRoom.class, x.class});
        return;
    L27:
        Set r111 = ((LinkedHashMap) this.f499068a).keySet();
        if (r111 != null) goto L30;
        return;
    L30:
        Iterator r112 = r111.iterator();
    L32:
        if (r112.hasNext() == false) goto L37;
        r100.put(FastStartLiveConfig.PLAY_MODE, u0.k(((Number) r112.next()).intValue()));
        j0.l().sendLog("livesdk_audience_playmode_room_link", r100, new Object[]{IRoom.class, x.class});
        goto L32
    L37:
        return;
    L18:
        r106 = false;
        goto L20
    L5:
        r101 = false;
        goto L6
    }

    public final void c(Integer r110) {
        ALogger.i("DynamicBizLogHelper", "logAudiencePlaymodeRoomlinkDuration, playModes: " + ((LinkedHashMap) this.f499068a).keySet());
        LinkedHashMap r100 = new LinkedHashMap();
        TalkRoomLogUtils.V0(r100);
        if (o.c() != 16) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L18;
        j<LivePlayModeLogContext> r102 = m.d().J();
        if (r102 == null) goto L17;
        LivePlayModeLogContext r103 = r102.getValue();
        if (r103 == null) goto L17;
        com.bytedance.live.datacontext.m<Set<Integer>> r104 = r103.getPlayModes();
        if (r104 == null) goto L17;
        Set<Integer> r105 = r104.getValue();
        if (r105 == null) goto L17;
        if (r105.contains(16) == true) goto L18;
    L17:
        boolean r106 = true;
    L20:
        if (r110 == null) goto L25;
        if (r106 == false) goto L23;
        r100.put(FastStartLiveConfig.PLAY_MODE, "link_room");
    L24:
        j0.l().sendLog("livesdk_audience_playmode_room_link_duration", r100, new Object[]{IRoom.class, x.class});
        return;
    L23:
        r100.put(FastStartLiveConfig.PLAY_MODE, u0.k(r110.intValue()));
        goto L24
    L25:
        if (r106 == false) goto L27;
        r100.put(FastStartLiveConfig.PLAY_MODE, "link_room");
        j0.l().sendLog("livesdk_audience_playmode_room_link_duration", r100, new Object[]{IRoom.class, x.class});
        return;
    L27:
        Set r111 = ((LinkedHashMap) this.f499068a).keySet();
        if (r111 != null) goto L30;
        return;
    L30:
        Iterator r112 = r111.iterator();
    L32:
        if (r112.hasNext() == false) goto L37;
        r100.put(FastStartLiveConfig.PLAY_MODE, u0.k(((Number) r112.next()).intValue()));
        j0.l().sendLog("livesdk_audience_playmode_room_link_duration", r100, new Object[]{IRoom.class, x.class});
        goto L32
    L37:
        return;
    L18:
        r106 = false;
        goto L20
    L5:
        r101 = false;
        goto L6
    }
}
