package com.bytedance.android.livesdk.log.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrl;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeExtraInfo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeMod;
import com.bytedance.android.livesdkapi.depend.model.live.episode.IBaseEpisodeMod;
import com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeExtraInfo;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.network.model.DeviceStatus$DiffDimension;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/log/model/LiveVSLog;", "Landroid/os/Parcelable;", "b", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveVSLog implements Parcelable {
    public static final Parcelable.Creator<LiveVSLog> CREATOR = null;
    public static boolean p;
    public static final String[] q = null;
    public static final b r = null;
    public boolean a;
    public int b;
    public String c;
    public String d;
    public String e;
    public String f;
    public final String g;
    public final String h;
    public int i;
    public final int j;
    public int k;
    public final String l;
    public final String m;
    public final long n;
    public final String o;

    public static final class a implements Parcelable.Creator<LiveVSLog> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final LiveVSLog createFromParcel(Parcel r18) {
            Intrinsics.checkNotNullParameter(r18, "parcel");
            Intrinsics.checkNotNullParameter(r18, "parcel");
            String r1 = r18.readString();
            if (r1 != null) goto L5;
            String r3 = "";
        L6:
            String r2 = r18.readString();
            if (r2 != null) goto L9;
            String r4 = "";
        L10:
            String r5 = r18.readString();
            if (r5 != null) goto L13;
            String r6 = "";
        L14:
            String r7 = r18.readString();
            if (r7 != null) goto L17;
            String r8 = "";
        L18:
            String r9 = r18.readString();
            if (r9 != null) goto L21;
            String r10 = "";
        L22:
            String r11 = r18.readString();
            if (r11 != null) goto L25;
            String r12 = "";
        L26:
            int r13 = r18.readInt();
            int r14 = r18.readInt();
            int r15 = r18.readInt();
            String r16 = r18.readString();
            if (r16 != null) goto L29;
            String r17 = "";
        L30:
            String r19 = r18.readString();
            if (r19 != null) goto L33;
            String r110 = "";
        L34:
            long r111 = r18.readLong();
            String r20 = r18.readString();
            if (r20 != null) goto L37;
            r20 = "";
        L37:
            LiveVSLog r112 = new LiveVSLog(r3, r4, r6, r8, r10, r12, r13, r14, r15, r17, r110, r111, r20);
            boolean r21 = false;
            if (r18.readByte() == ((byte) 0)) goto L40;
            r21 = true;
        L40:
            r112.a = r21;
            r112.b = r18.readInt();
            return r112;
        L33:
            r110 = r19;
            goto L34
        L29:
            r17 = r16;
            goto L30
        L25:
            r12 = r11;
            goto L26
        L21:
            r10 = r9;
            goto L22
        L17:
            r8 = r7;
            goto L18
        L13:
            r6 = r5;
            goto L14
        L9:
            r4 = r2;
            goto L10
        L5:
            r3 = r1;
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final LiveVSLog[] newArray(int r1) {
            return new LiveVSLog[r1];
        }
    }

    public static final class b {
        public b() {
        }

        public static LiveVSLog a(Room r8) {
            Intrinsics.checkNotNullParameter(r8, "room");
            LiveVSLog r0 = new LiveVSLog(null, null, null, null, 0, 8191);
            EpisodeExtraInfo r1 = r8.getEpisodeExtra2();
            long r2 = -1;
            if (r1 == null) goto L5;
            long r4 = r1.getId();
        L6:
            String r3 = String.valueOf(r4);
            Intrinsics.checkNotNullParameter(r3, "<set-?>");
            r0.e = r3;
            EpisodeExtraInfo r5 = r8.getEpisodeExtra2();
            String r6 = "";
            if (r5 == null) goto L10;
            String r7 = r5.getItemId();
            if (r7 == null) goto L10;
        L11:
            Intrinsics.checkNotNullParameter(r7, "<set-?>");
            r0.c = r7;
            String r9 = String.valueOf(r8.id);
            Intrinsics.checkNotNullParameter(r9, "<set-?>");
            r0.d = r9;
            EpisodeExtraInfo r10 = r8.getEpisodeExtra2();
            if (r10 == null) goto L19;
            Long r11 = r10.getSeasonId();
            if (r11 == null) goto L19;
            String r12 = String.valueOf(r11.longValue());
            if (r12 == null) goto L19;
            r6 = r12;
        L19:
            Intrinsics.checkNotNullParameter(r6, "<set-?>");
            r0.f = r6;
            EpisodeExtraInfo r13 = r8.getEpisodeExtra2();
            if (r13 == null) goto L22;
            r2 = r13.getId();
        L22:
            String r14 = String.valueOf(r2);
            Intrinsics.checkNotNullParameter(r14, "<set-?>");
            r0.e = r14;
            EpisodeExtraInfo r15 = r8.getEpisodeExtra2();
            int r16 = -1;
            if (r15 == null) goto L27;
            IBaseEpisodeMod r17 = r15.getMod();
            if (r17 == null) goto L27;
            int r18 = r17.getEpisodeStage();
        L28:
            r0.i = r18;
            LiveVSLog.r.getClass();
            r0.k = b(r8);
            EpisodeExtraInfo r19 = r8.getEpisodeExtra2();
            if (r19 == null) goto L31;
            boolean r20 = r19.isInteractConfigExist();
        L32:
            r0.a = r20;
            EpisodeExtraInfo r21 = r8.getEpisodeExtra2();
            if (r21 == null) goto L37;
            IBaseEpisodeMod r22 = r21.getMod();
            if (r22 == null) goto L37;
            r16 = r22.getEpisodeSubType();
        L37:
            r0.b = r16;
            return r0;
        L31:
            r20 = false;
        L27:
            r18 = -1;
        L10:
            r7 = "";
            goto L11
        L5:
            r4 = -1;
            goto L6
        }

        public static int b(IRoom r6) {
            int r0 = 0;
            if (r6 != null) goto L5;
            return 0;
        L5:
            int r2 = 1;
            Integer r4 = null;
            if (LiveVSLog.p == false) goto L23;
            IBaseStreamUrl r1 = r6.getStreamUrl();
            if (r1 == null) goto L10;
            r4 = Integer.valueOf(r1.getStreamOrientation());
        L10:
            if (r4 != null) goto L13;
        L15:
            if (r4 != null) goto L18;
        L21:
            if (r6.isVrRoom() == false) goto L53;
            return 2;
        L53:
            return r0;
        L18:
            if (r4.intValue() != 2) goto L21;
            r0 = 1;
            goto L21
        L13:
            if (r4.intValue() != 1) goto L15;
            r0 = 2;
            goto L21
        L23:
            IEpisodeExtraInfo r3 = r6.getEpisodeComponentData();
            if (r3 == null) goto L45;
            if (r3.getStyle() != 0) goto L45;
            IEpisodeExtraInfo r5 = r6.getEpisodeComponentData();
            if (r5 == null) goto L45;
            IBaseStreamUrl r7 = r6.getStreamUrl();
            if (r7 == null) goto L32;
            r4 = Integer.valueOf(r7.getStreamOrientation());
        L32:
            if (r4 != null) goto L35;
        L37:
            if (r4 != null) goto L40;
        L42:
            r2 = 0;
        L43:
            r5.setStyle(r2);
            goto L45
        L40:
            if (r4.intValue() != 2) goto L42;
        L35:
            if (r4.intValue() != 1) goto L37;
            r2 = 2;
        L45:
            if (r6.isVrRoom() == false) goto L49;
            IEpisodeExtraInfo r8 = r6.getEpisodeComponentData();
            if (r8 == null) goto L49;
            r8.setStyle(2);
        L49:
            IEpisodeExtraInfo r9 = r6.getEpisodeComponentData();
            if (r9 != null) goto L52;
            return 0;
        L52:
            return r9.getStyle();
        }

        public static void c(LiveVSLog r4, Map r5) {
            if (r5 != null) goto L4;
            return;
        L4:
            String[] r0 = LiveVSLog.q;
            int r1 = r0.length;
            int r2 = 0;
        L5:
            if (r2 >= r1) goto L7;
            r5.remove(r0[r2]);
            r2 = r2 + 1;
            goto L5
        L7:
            if (r4 != null) goto L9;
            return;
        L9:
            r5.putAll(r4.a());
        }
    }

    public LiveVSLog() {
        this(null, null, null, null, 0, 8191);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        r = new b();
        CREATOR = new a();
        q = new String[]{"vs_episode_id", "vs_ep_group_id", "vs_season_id", "vs_episode_stage", "vs_is_portraid_content", "vs_from_episode_id", "vs_is_chatroom", "is_vs", "vs_is_auto_play", "vs_from_others_homepage_uid", "vs_machine_id", "vs_episode_sub_type", "vs_machine_type", "from_vs_machine_id", "from_vs_machine_type"};
    }

    public final Map<String, String> a() {
        HashMap r0 = new HashMap();
        boolean r2 = false;
        if (this.e.length() <= 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L9;
        r0.put("vs_episode_id", this.e);
    L9:
        if (this.c.length() <= 0) goto L11;
        boolean r3 = true;
    L12:
        if (r3 == false) goto L15;
        r0.put("vs_ep_group_id", this.c);
    L15:
        if (this.f.length() <= 0) goto L17;
        boolean r4 = true;
    L18:
        if (r4 == false) goto L20;
        r0.put("vs_season_id", this.f);
    L20:
        int r5 = this.i;
        String r6 = "premiere";
        String r8 = "";
        if (r5 != EpisodeMod.EpisodeStageType.LIVE) goto L24;
        String r7 = "live";
    L31:
        if (r7.length() <= 0) goto L33;
        boolean r9 = true;
    L34:
        if (r9 == false) goto L46;
        int r10 = this.i;
        if (r10 != EpisodeMod.EpisodeStageType.LIVE) goto L39;
        r6 = "live";
    L45:
        r0.put("vs_episode_stage", r6);
        goto L46
    L39:
        if (r10 != EpisodeMod.EpisodeStageType.RECORD) goto L42;
        r6 = "record";
        goto L45
    L42:
        if (r10 == EpisodeMod.EpisodeStageType.PREMIERE) goto L45;
        r6 = "";
    L46:
        int r11 = this.k;
        if (r11 < 0) goto L54;
        if (r11 != 2) goto L51;
        Object r12 = "1";
    L52:
        r0.put("vs_is_portraid_content", r12);
        goto L54
    L51:
        r12 = BDLocationException.ERROR_TIMEOUT;
    L54:
        if (this.h.length() <= 0) goto L56;
        boolean r13 = true;
    L57:
        if (r13 == false) goto L60;
        r0.put("vs_from_episode_id", this.h);
    L60:
        if (this.g.length() <= 0) goto L62;
        boolean r14 = true;
    L63:
        if (r14 == false) goto L66;
        r0.put("video_id", this.g);
    L66:
        if (this.l.length() <= 0) goto L68;
        boolean r15 = true;
    L69:
        if (r15 == false) goto L72;
        r0.put("vs_from_others_homepage_uid", this.l);
    L72:
        if (this.m.length() <= 0) goto L74;
        boolean r16 = true;
    L75:
        if (r16 == false) goto L77;
        r0.put("previous_page", this.m);
    L77:
        r0.put("is_vs", "1");
        r0.put("vs_is_auto_play", BDLocationException.ERROR_TIMEOUT);
        if (this.a == false) goto L80;
        r0.put("vs_interact_config_exist", "1");
    L81:
        int r17 = this.b;
        if (r17 != EpisodeMod.EpisodeSubType.GUIDE) goto L85;
        String r18 = "pilot_file";
    L92:
        if (r18.length() <= 0) goto L94;
        r2 = true;
    L94:
        if (r2 == false) goto L105;
        int r19 = this.b;
        if (r19 != EpisodeMod.EpisodeSubType.GUIDE) goto L99;
        r8 = "pilot_file";
    L104:
        r0.put("vs_episode_sub_type", r8);
        goto L105
    L99:
        if (r19 != EpisodeMod.EpisodeSubType.NORMAL) goto L102;
        r8 = "normal";
        goto L104
    L102:
        if (r19 != EpisodeMod.EpisodeSubType.UNKNOWN) goto L104;
        r8 = LocationInfoConst.UNKNOWN_SERVER_LOCATE_METHOD;
    L105:
        return r0;
    L85:
        if (r17 != EpisodeMod.EpisodeSubType.NORMAL) goto L88;
        r18 = "normal";
        goto L92
    L88:
        if (r17 != EpisodeMod.EpisodeSubType.UNKNOWN) goto L90;
        r18 = LocationInfoConst.UNKNOWN_SERVER_LOCATE_METHOD;
        goto L92
    L90:
        r18 = "";
        goto L92
    L80:
        r0.put("vs_interact_config_exist", BDLocationException.ERROR_TIMEOUT);
        goto L81
    L74:
        r16 = false;
        goto L75
    L68:
        r15 = false;
        goto L69
    L62:
        r14 = false;
        goto L63
    L56:
        r13 = false;
        goto L57
    L33:
        r9 = false;
        goto L34
    L24:
        if (r5 != EpisodeMod.EpisodeStageType.RECORD) goto L27;
        r7 = "record";
        goto L31
    L27:
        if (r5 != EpisodeMod.EpisodeStageType.PREMIERE) goto L29;
        r7 = "premiere";
        goto L31
    L29:
        r7 = "";
        goto L31
    L17:
        r4 = false;
        goto L18
    L11:
        r3 = false;
        goto L12
    L5:
        r1 = false;
        goto L6
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parcel");
        r3.writeString(this.c);
        r3.writeString(this.d);
        r3.writeString(this.e);
        r3.writeString(this.f);
        r3.writeString(this.g);
        r3.writeString(this.h);
        r3.writeInt(this.i);
        r3.writeInt(this.j);
        r3.writeInt(this.k);
        r3.writeString(this.l);
        r3.writeString(this.m);
        r3.writeLong(this.n);
        r3.writeString(this.o);
        r3.writeByte(this.a ? 1 : 0);
        r3.writeInt(this.b);
    }

    public /* synthetic */ LiveVSLog(String r19, String r20, String r21, String r22, int r23, int r24) {
        if ((r24 & 1) == 0) goto L5;
        String r4 = "";
    L7:
        if ((r24 & 2) == 0) goto L9;
        String r5 = "";
    L11:
        if ((r24 & 4) == 0) goto L13;
        String r6 = "";
    L15:
        if ((r24 & 8) == 0) goto L17;
        String r7 = "";
    L19:
        if ((r24 & 16) == 0) goto L21;
        String r8 = "";
    L23:
        if ((r24 & 32) == 0) goto L25;
        String r9 = "";
    L27:
        if ((r24 & 64) == 0) goto L29;
        int r1 = -1;
    L30:
        int r12 = 0;
        if ((r24 & DeviceStatus$DiffDimension.DIFF_RESTRICTED_MODE) == 0) goto L33;
        int r11 = -1;
    L35:
        if ((r24 & DeviceStatus$DiffDimension.DIFF_LOCATION_MODE) == 0) goto L38;
        r12 = -1;
    L38:
        if ((r24 & DeviceStatus$DiffDimension.DIFF_IS_STRICT_RESTRICTED_MODE) == 0) goto L40;
        String r13 = "";
    L42:
        if ((r24 & DeviceStatus$DiffDimension.DIFF_BLUETOOTH_PERMISSION) == 0) goto L44;
        String r14 = "";
    L46:
        if ((r24 & 4096) == 0) goto L48;
        String r17 = "";
    L49:
        this(r4, r5, r6, r7, r8, r9, r1, r11, r12, r13, r14, 0, r17);
        return;
    L48:
        r17 = null;
        goto L49
    L44:
        r14 = null;
        goto L46
    L40:
        r13 = null;
        goto L42
    L33:
        r11 = 0;
        goto L35
    L29:
        r1 = r23;
        goto L30
    L25:
        r9 = null;
        goto L27
    L21:
        r8 = null;
        goto L23
    L17:
        r7 = r22;
        goto L19
    L13:
        r6 = r21;
        goto L15
    L9:
        r5 = r20;
        goto L11
    L5:
        r4 = r19;
        goto L7
    }

    public LiveVSLog(String r2, String r3, String r4, String r5, String r6, String r7, int r8, int r9, int r10, String r11, String r12, long r13, String r15) {
        Intrinsics.checkNotNullParameter(r2, "episodeGroupId");
        Intrinsics.checkNotNullParameter(r3, "roomId");
        Intrinsics.checkNotNullParameter(r4, "episodeId");
        Intrinsics.checkNotNullParameter(r5, "seasonId");
        Intrinsics.checkNotNullParameter(r6, "videoId");
        Intrinsics.checkNotNullParameter(r7, "fromEpisodeId");
        Intrinsics.checkNotNullParameter(r11, "fromOtherHomepageUid");
        Intrinsics.checkNotNullParameter(r12, "previousPage");
        Intrinsics.checkNotNullParameter(r15, "cameraType");
        this.c = r2;
        this.d = r3;
        this.e = r4;
        this.f = r5;
        this.g = r6;
        this.h = r7;
        this.i = r8;
        this.j = r9;
        this.k = r10;
        this.l = r11;
        this.m = r12;
        this.n = r13;
        this.o = r15;
        this.b = -1;
    }
}
