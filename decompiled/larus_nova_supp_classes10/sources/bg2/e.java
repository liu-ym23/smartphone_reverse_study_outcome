package bg2;

import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.live.LiveWrappedInterpolationMode;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.live.LiveWrappedMixedStreamAudioCodecType;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.live.LiveWrappedMixedStreamAudioProfile;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.live.LiveWrappedMixedStreamSEIContentMode;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.live.LiveWrappedMixedStreamSyncStrategy;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.live.LiveWrappedMixedStreamVideoCodecType;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.live.LiveWrappedStreamLayoutMode;
import com.bytedance.android.livesdk.livecommerce.promotionlist.opt.repo.monitor.MonitorLevel;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class e {
    public static final /* synthetic */ int q = 0;
    public p a;
    public c b;
    public f c;
    public k d;
    public d e;
    public q f;
    public j g;
    public g[] h;
    public String i;
    public String j;
    public final String k;
    public String l;
    public String m;
    public JSONObject n;
    public final LiveWrappedInterpolationMode o;
    public LiveWrappedStreamLayoutMode p;

    public static final class a {
        public static e a() {
            p r0 = new p();
            LiveWrappedMixedStreamVideoCodecType r1 = LiveWrappedMixedStreamVideoCodecType.MIXED_STREAM_VIDEO_CODEC_TYPE_H264;
            Intrinsics.checkNotNullParameter(r1, "<set-?>");
            r0.a = r1;
            r0.b = 15;
            r0.c = 2;
            r0.g = false;
            r0.f = 640;
            r0.e = 360;
            r0.d = MonitorLevel.FATAL;
            c r4 = new c();
            r4.a = LiveWrappedMixedStreamAudioCodecType.MIXED_STREAM_AUDIO_CODEC_TYPE_AAC;
            r4.d = 2;
            r4.b = 64;
            r4.c = 48000;
            r4.e = LiveWrappedMixedStreamAudioProfile.MIXED_STREAM_AUDIO_PROFILE_LC;
            f r2 = new f();
            r2.a = false;
            LiveWrappedMixedStreamSEIContentMode r5 = LiveWrappedMixedStreamSEIContentMode.MIXED_STREAM_SEI_CONTENT_MODE_DEFAULT;
            Intrinsics.checkNotNullParameter(r5, "<set-?>");
            r2.e = r5;
            r2.d = false;
            r2.c = 0;
            r2.b = 2.0f;
            r2.f = 100;
            Intrinsics.checkNotNullParameter("", "<set-?>");
            r2.g = "";
            k r6 = new k();
            Intrinsics.checkNotNullParameter("", "<set-?>");
            r6.d = "";
            Intrinsics.checkNotNullParameter("", "<set-?>");
            r6.e = "";
            LiveWrappedMixedStreamSyncStrategy r7 = LiveWrappedMixedStreamSyncStrategy.MIXED_STREAM_SYNC_STRATEGY_NO_SYNC;
            Intrinsics.checkNotNullParameter(r7, "<set-?>");
            r6.a = r7;
            r6.b = 2000;
            r6.c = true;
            r6.f = 0;
            d r3 = new d();
            r3.a = "";
            q r8 = new q();
            Intrinsics.checkNotNullParameter("", "<set-?>");
            r8.a = "";
            Intrinsics.checkNotNullParameter("", "<set-?>");
            r8.b = "";
            j r9 = new j();
            e r10 = new e();
            r10.b = r4;
            r10.a = r0;
            r10.c = r2;
            r10.d = r6;
            r10.e = r3;
            r10.f = r8;
            r10.g = r9;
            r10.j = "#000000";
            r10.i = "";
            return r10;
        }
    }

    static {
    }

    public final JSONObject a() {
        String r4 = "height";
        String r5 = "width";
        JSONObject r7 = new JSONObject();
        JSONObject r8 = new JSONObject();
        JSONObject r9 = new JSONObject();
        JSONObject r10 = new JSONObject();
        JSONObject r11 = new JSONObject();
        JSONObject r12 = new JSONObject();
        JSONObject r13 = new JSONObject();
        JSONObject r14 = new JSONObject();
        new JSONObject();
        JSONArray r15 = new JSONArray();
        JSONObject r16 = new JSONObject();
        JSONObject r17 = new JSONObject();
        JSONObject r1 = new JSONObject();
        p r18 = this.a;     // Catch: Exception -> L39
        Intrinsics.checkNotNull(r18);     // Catch: Exception -> L39
        r7.put("videoCodec", r18.a);     // Catch: Exception -> L39
        p r19 = this.a;     // Catch: Exception -> L39
        Intrinsics.checkNotNull(r19);     // Catch: Exception -> L39
        r7.put("fps", r19.b);     // Catch: Exception -> L39
        p r110 = this.a;     // Catch: Exception -> L39
        Intrinsics.checkNotNull(r110);     // Catch: Exception -> L39
        r7.put("gop", r110.c);     // Catch: Exception -> L39
        p r2 = this.a;     // Catch: Exception -> L39
        Intrinsics.checkNotNull(r2);     // Catch: Exception -> L39
        r7.put("bitrate", r2.d);     // Catch: Exception -> L39
        p r3 = this.a;     // Catch: Exception -> L39
        Intrinsics.checkNotNull(r3);     // Catch: Exception -> L39
        r7.put("width", r3.e);     // Catch: Exception -> L39
        p r6 = this.a;     // Catch: Exception -> L39
        Intrinsics.checkNotNull(r6);     // Catch: Exception -> L39
        r7.put("height", r6.f);     // Catch: Exception -> L39
        p r111 = this.a;     // Catch: Exception -> L39
        Intrinsics.checkNotNull(r111);     // Catch: Exception -> L39
        r7.put("enableBframe", r111.g);     // Catch: Exception -> L39
        c r112 = this.b;     // Catch: Exception -> L39
        Intrinsics.checkNotNull(r112);     // Catch: Exception -> L39
        r8.put("audioCodec", r112.a);     // Catch: Exception -> L39
        c r20 = this.b;     // Catch: Exception -> L39
        Intrinsics.checkNotNull(r20);     // Catch: Exception -> L39
        r8.put("bitrate", r20.b);     // Catch: Exception -> L39
        c r21 = this.b;     // Catch: Exception -> L39
        Intrinsics.checkNotNull(r21);     // Catch: Exception -> L39
        r8.put("sampleRate", r21.c);     // Catch: Exception -> L39
        c r22 = this.b;     // Catch: Exception -> L39
        Intrinsics.checkNotNull(r22);     // Catch: Exception -> L39
        r8.put("channels", r22.d);     // Catch: Exception -> L39
        c r23 = this.b;     // Catch: Exception -> L39
        Intrinsics.checkNotNull(r23);     // Catch: Exception -> L39
        r8.put("audioProfile", r23.e);     // Catch: Exception -> L39
        f r24 = this.c;     // Catch: Exception -> L39
        Intrinsics.checkNotNull(r24);     // Catch: Exception -> L39
        r9.put("enableVolumeIndication", r24.a);     // Catch: Exception -> L39
        f r25 = this.c;     // Catch: Exception -> L39
        Intrinsics.checkNotNull(r25);     // Catch: Exception -> L39
        r9.put("talkVolume", r25.c);     // Catch: Exception -> L39
        f r26 = this.c;     // Catch: Exception -> L39
        Intrinsics.checkNotNull(r26);     // Catch: Exception -> L39
        r9.put("isAddVolumeValue", r26.d);     // Catch: Exception -> L39
        f r27 = this.c;     // Catch: Exception -> L39
        Intrinsics.checkNotNull(r27);     // Catch: Exception -> L39
        r9.put("volumeIndicationInterval", r27.b);     // Catch: Exception -> L39
        f r28 = this.c;     // Catch: Exception -> L39
        Intrinsics.checkNotNull(r28);     // Catch: Exception -> L39
        r9.put("seiContentMode", r28.e);     // Catch: Exception -> L39
        f r29 = this.c;     // Catch: Exception -> L39
        Intrinsics.checkNotNull(r29);     // Catch: Exception -> L39
        r9.put("seiPayloadType", r29.f);     // Catch: Exception -> L39
        f r30 = this.c;     // Catch: Exception -> L39
        Intrinsics.checkNotNull(r30);     // Catch: Exception -> L39
        r9.put("seiPayloadUuid", r30.g);     // Catch: Exception -> L39
        f r31 = this.c;     // Catch: Exception -> L39
        Intrinsics.checkNotNull(r31);     // Catch: Exception -> L39
        r9.put("mediaType", r31.h);     // Catch: Exception -> L39
        f r32 = this.c;     // Catch: Exception -> L39
        Intrinsics.checkNotNull(r32);     // Catch: Exception -> L39
        r9.put("pushStreamMode", r32.i);     // Catch: Exception -> L39
        k r33 = this.d;     // Catch: Exception -> L39
        Intrinsics.checkNotNull(r33);     // Catch: Exception -> L39
        r11.put("syncStrategy", r33.a);     // Catch: Exception -> L39
        k r34 = this.d;     // Catch: Exception -> L39
        Intrinsics.checkNotNull(r34);     // Catch: Exception -> L39
        r11.put("maxCacheTimeMs", r34.b);     // Catch: Exception -> L39
        k r35 = this.d;     // Catch: Exception -> L39
        Intrinsics.checkNotNull(r35);     // Catch: Exception -> L39
        r11.put("videoNeedSdkMix", r35.c);     // Catch: Exception -> L39
        k r36 = this.d;     // Catch: Exception -> L39
        Intrinsics.checkNotNull(r36);     // Catch: Exception -> L39
        r11.put("baseuserID", r36.d);     // Catch: Exception -> L39
        k r37 = this.d;     // Catch: Exception -> L39
        Intrinsics.checkNotNull(r37);     // Catch: Exception -> L39
        r11.put("baseRoomID", r37.e);     // Catch: Exception -> L39
        k r38 = this.d;     // Catch: Exception -> L39
        Intrinsics.checkNotNull(r38);     // Catch: Exception -> L39
        r11.put("baseStreamStartDelayMs", r38.f);     // Catch: Exception -> L39
        d r39 = this.e;     // Catch: Exception -> L39
        Intrinsics.checkNotNull(r39);     // Catch: Exception -> L39
        r12.put(LocationMonitorConst.TYPE, r39.a);     // Catch: Exception -> L39
        q r40 = this.f;     // Catch: Exception -> L39
        if (r40 == null) goto L22;
        Intrinsics.checkNotNull(r40);     // Catch: Exception -> L39
        r13.put("effectResourceUrl", r40.a);     // Catch: Exception -> L39
        q r41 = this.f;     // Catch: Exception -> L39
        Intrinsics.checkNotNull(r41);     // Catch: Exception -> L39
        r13.put("effectResourceLocalPath", r41.b);     // Catch: Exception -> L39
        q r42 = this.f;     // Catch: Exception -> L39
        Intrinsics.checkNotNull(r42);     // Catch: Exception -> L39
        r r43 = r42.c;     // Catch: Exception -> L39
        if (r43 == null) goto L8;
        Long r44 = Long.valueOf(r43.a);     // Catch: Exception -> L39
    L9:
        r13.put("msgID", r44);     // Catch: Exception -> L39
        q r45 = this.f;     // Catch: Exception -> L39
        Intrinsics.checkNotNull(r45);     // Catch: Exception -> L39
        r r46 = r45.c;     // Catch: Exception -> L39
        if (r46 == null) goto L12;
        Long r47 = Long.valueOf(r46.b);     // Catch: Exception -> L39
    L13:
        r13.put("arg1", r47);     // Catch: Exception -> L39
        q r48 = this.f;     // Catch: Exception -> L39
        Intrinsics.checkNotNull(r48);     // Catch: Exception -> L39
        r r49 = r48.c;     // Catch: Exception -> L39
        if (r49 == null) goto L16;
        Long r50 = Long.valueOf(r49.c);     // Catch: Exception -> L39
    L17:
        r13.put("arg2", r50);     // Catch: Exception -> L39
        q r51 = this.f;     // Catch: Exception -> L39
        Intrinsics.checkNotNull(r51);     // Catch: Exception -> L39
        r r52 = r51.c;     // Catch: Exception -> L39
        if (r52 == null) goto L20;
        String r53 = r52.d;     // Catch: Exception -> L39
    L21:
        r13.put("arg3", r53);     // Catch: Exception -> L39
        goto L22
    L20:
        r53 = null;
        goto L21
    L16:
        r50 = null;
        goto L17
    L12:
        r47 = null;
        goto L13
    L8:
        r44 = null;
    L22:
        r17.put("backgroundColor", this.j);     // Catch: Exception -> L39
        r17.put("backgroundImageURL", this.k);     // Catch: Exception -> L39
        g[] r54 = this.h;     // Catch: Exception -> L39
        String r55 = "roomID";
        String r56 = "userID";
        if (r54 == null) goto L33;
        Intrinsics.checkNotNull(r54);     // Catch: Exception -> L39
        int r57 = r54.length;     // Catch: Exception -> L39
        int r113 = 0;
    L26:
        if (r113 >= r57) goto L32;
        int r210 = r57;
        g r58 = r54[r113];     // Catch: Exception -> L39
        if (r58 == null) goto L31;
        JSONObject r59 = new JSONObject();     // Catch: Exception -> L39
        r59.put(r56, r58.a);     // Catch: Exception -> L39
        r59.put(r55, r58.b);     // Catch: Exception -> L39
        r59.put("wtnStreamID", r58.c);     // Catch: Exception -> L39
        r59.put("locationX", r58.d);     // Catch: Exception -> L39
        r59.put("locationY", r58.e);     // Catch: Exception -> L39
        r59.put(r5, r58.f);     // Catch: Exception -> L39
        r59.put(r4, r58.g);     // Catch: Exception -> L39
        r59.put("zOrder", r58.h);     // Catch: Exception -> L39
        r59.put("alpha", r58.i);     // Catch: Exception -> L39
        r59.put("cornerRadius", r58.j);     // Catch: Exception -> L39
        r59.put("mediaType", r58.k);     // Catch: Exception -> L39
        r59.put("renderMode", r58.l);     // Catch: Exception -> L39
        r59.put("isLocalUser", r58.m);     // Catch: Exception -> L39
        r59.put("streamType", r58.n);     // Catch: Exception -> L39
        r59.put("applySpatialAudio", r58.q);     // Catch: Exception -> L39
        r59.put("alternateImageFillMode", r58.o);     // Catch: Exception -> L39
        r59.put("alternateImageURL", r58.p);     // Catch: Exception -> L39
        r59.put("sourceCropX", r58.r.a);     // Catch: Exception -> L39
        r59.put("sourceCropY", r58.r.b);     // Catch: Exception -> L39
        r59.put("sourceCropW", r58.r.c);     // Catch: Exception -> L39
        r59.put("sourceCropH", r58.r.d);     // Catch: Exception -> L39
        r59.put("videoEnhancement", r58.s);     // Catch: Exception -> L39
        r59.put("ignoreRtcSei", r58.u);     // Catch: Exception -> L39
        r59.put("superResolutionMode", r58.t);     // Catch: Exception -> L39
        r15.put(r59);     // Catch: Exception -> L39
    L31:
        r113 = r113 + 1;     // Catch: Exception -> L39
        r55 = r55;
        r4 = r4;
        r57 = r210;
        r54 = r54;
        r12 = r12;
        r56 = r56;
        r5 = r5;
        goto L26
    L32:
        String r211 = r56;
        JSONObject r212 = r12;
    L34:
        String r60 = r55;
        r17.put("regions", r15);     // Catch: Exception -> L39
        r17.put("userConfigExtraInfo", this.i);     // Catch: Exception -> L39
        r17.put("transcode", r16);     // Catch: Exception -> L39
        r17.put("video", r7);     // Catch: Exception -> L39
        r17.put("audio", r8);     // Catch: Exception -> L39
        r17.put("serverControl", r9);     // Catch: Exception -> L39
        r17.put("clientMix", r10);     // Catch: Exception -> L39
        r17.put("syncControl", r11);     // Catch: Exception -> L39
        r17.put("audioEffect", r212);     // Catch: Exception -> L39
        r17.put("videoEffect", r13);     // Catch: Exception -> L39
        r17.put("layout", r14);     // Catch: Exception -> L39
        JSONObject r61 = this.n;     // Catch: Exception -> L39
        if (r61 == null) goto L37;
        r17.put("authInfo", r61);     // Catch: Exception -> L39
    L37:
        r1.put(LocationMonitorConst.TYPE, "transcode");     // Catch: Exception -> L39
        r1.put(r60, this.l);     // Catch: Exception -> L39
        r1.put(r211, this.m);     // Catch: Exception -> L39
        r1.put("transcodeMeta", r17);     // Catch: Exception -> L39
        r1.put("layoutMode", this.p);     // Catch: Exception -> L39
        r1.put("interpolationMode", this.o);     // Catch: Exception -> L39
        return r1;
    L33:
        r211 = "userID";
        r212 = r12;
    L39:
        return null;
    }

    public e() {
        this.i = "";
        this.j = "#000000";
        this.k = "";
        this.l = "";
        this.m = "";
        this.o = LiveWrappedInterpolationMode.LAST_FRAME_FILL;
        this.p = LiveWrappedStreamLayoutMode.AUTO;
    }
}
