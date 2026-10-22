package com.bytedance.android.livesdk.livecommerce.playback.main;

import android.net.Uri;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.opt.ab.p;
import com.bytedance.android.ec.core.utils.t0;
import com.bytedance.android.ec.model.playback.ECReplayVideo;
import com.bytedance.android.ec.model.playback.ExplainPlaybackRequest;
import com.bytedance.android.ec.model.playback.ExplainPlaybackVideoInfo;
import com.bytedance.android.ec.model.playback.ExplainReplaySubTitle;
import com.bytedance.android.ec.model.playback.LogExtraData;
import com.bytedance.android.ec.model.playback.PlaybackEventExtraData;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.playback.applog.ExplainPlayBackPDPEntryLogExtra;
import com.bytedance.android.livesdk.livecommerce.utils.EComABUtils;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.network.model.DeviceStatus$DiffDimension;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.google.gson.reflect.TypeToken;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b {
    public static final /* synthetic */ int k = 0;
    public final ExplainPlaybackRequest a;
    public final String b;
    public final String c;
    public final LogExtraData d;
    public final PlaybackEventExtraData e;
    public final ExplainPlayBackPDPEntryLogExtra f;
    public final String g;
    public final ExplainPlaybackVideoInfo h;
    public final ECReplayVideo i;
    public final List<ExplainReplaySubTitle> j;

    public static final class a {

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.playback.main.b$a$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"com/bytedance/android/livesdk/livecommerce/playback/main/b$a$a", "Lcom/google/gson/reflect/TypeToken;", "", "Lcom/bytedance/android/ec/model/playback/ExplainReplaySubTitle;", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class C0083a extends TypeToken<List<? extends ExplainReplaySubTitle>> {
            public C0083a() {
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r40v0, types: [java.util.List] */
        public static b a(String r43) {
            Intrinsics.checkNotNullParameter(r43, "url");
            Uri r1 = UriProtector.parse(r43);
            String r3 = c.b(UriProtector.getQueryParameter(r1, "promotion_id"));
            String r13 = c.b(UriProtector.getQueryParameter(r1, "fragment_id"));
            String r20 = c.b(UriProtector.getQueryParameter(r1, "room_id"));
            String r29 = c.b(UriProtector.getQueryParameter(r1, "author_id"));
            String r6 = c.b(UriProtector.getQueryParameter(r1, "sec_author_id"));
            String r33 = UriProtector.getQueryParameter(r1, "entrance_info");
            String r2 = UriProtector.getQueryParameter(r1, "source_page");
            Object r4 = null;
            if (r2 != null) goto L5;
        L14:
            if (r33 == null) goto L18;
            JSONObject r5 = c.c(r33);
            if (r5 == null) goto L18;
            String r0 = r5.optString("source_page");
        L19:
            String r21 = c.b(r0);
        L20:
            String r7 = UriProtector.getQueryParameter(r1, "enter_method");
            if (r7 != null) goto L23;
            r7 = c.b(UriProtector.getQueryParameter(r1, "source_method"));
        L23:
            String r22 = r7;
            String r34 = UriProtector.getQueryParameter(r1, "ad_extra_data");
            UriProtector.getQueryParameter(r1, "v3_events_additions");
            String r8 = UriProtector.getQueryParameter(r1, "enter_from_merge");
            if (r8 != null) goto L26;
            r8 = c.b(UriProtector.getQueryParameter(r1, "carrier_source"));
        L26:
            String r23 = r8;
            String r30 = UriProtector.getQueryParameter(r1, "commodity_type");
            String r9 = UriProtector.getQueryParameter(r1, "follow_status");
            if (r9 != null) goto L29;
            String r31 = BDLocationException.ERROR_TIMEOUT;
        L30:
            String r10 = UriProtector.getQueryParameter(r1, "with_sku");
            if (r10 != null) goto L33;
            String r32 = BDLocationException.ERROR_TIMEOUT;
        L34:
            String r35 = c.b(UriProtector.getQueryParameter(r1, "from_live"));
            if (r35.length() <= 0) goto L37;
            boolean r11 = true;
        L38:
            if (r11 == false) goto L40;
            String r12 = "live_room";
        L41:
            String r14 = UriProtector.getQueryParameter(r1, "entrance_form");
            if (r14 != null) goto L44;
            String r15 = "";
        L45:
            String r16 = UriProtector.getQueryParameter(r1, "is_float");
            if (r16 != null) goto L48;
            String r17 = "";
        L49:
            String r18 = c.b(UriProtector.getQueryParameter(r1, "carrier_source"));
            int r36 = k.r(c.b(UriProtector.getQueryParameter(r1, "replay_start_time")), 0);
            if (r35.length() <= 0) goto L52;
            boolean r19 = true;
        L53:
            if (r19 == false) goto L55;
            String r25 = c.b(UriProtector.getQueryParameter(r1, "enter_from_merge"));
        L56:
            String r24 = c.b(UriProtector.getQueryParameter(r1, "enter_scene"));
            String r26 = UriProtector.getQueryParameter(r1, "model_type");     // Catch: NumberFormatException -> L63
            if (r26 == null) goto L61;
            Integer r27 = Integer.valueOf(CastIntegerProtector.parseInt(r26));     // Catch: NumberFormatException -> L63
        L62:
            Integer r37 = r27;
        L64:
            int r28 = k.r(UriProtector.getQueryParameter(r1, "enable_multi_card"), 0);
            if (EComABUtils.replayPreloadEnable() == false) goto L73;
            String r38 = UriProtector.getQueryParameter(r1, "video_data");
            if (r38 == null) goto L73;
            int r39 = t0.a;     // Catch: Exception -> L70
            ExplainPlaybackVideoInfo r40 = (ExplainPlaybackVideoInfo) t0.a.a.fromJson(r38, ExplainPlaybackVideoInfo.class);     // Catch: Exception -> L70
        L72:
            ExplainPlaybackVideoInfo r310 = r40;
        L75:
            if (EComABUtils.replayPreloadEnable() == true) goto L77;
        L88:
            ECReplayVideo r311 = null;
        L90:
            if (EComABUtils.replayPreloadEnable() == true) goto L92;
        L104:
            ?? r41 = r4;
            if (r33 != null) goto L107;
            String r42 = "";
        L108:
            boolean r110 = aj2.a.a();
            Integer r111 = Integer.valueOf(r28);
            Lazy r44 = ECSettingKeys.a;
            int r45 = p.a;
            Object r46 = 10;
            Result.Companion r47 = Result.Companion;     // Catch: Throwable -> L113
            jj4.b r48 = jj4.b.b;     // Catch: Throwable -> L113
            Object r49 = jj4.a.a("iesec_live_replay_request_page_size", Integer.class, r46, false);     // Catch: Throwable -> L113
            if (r49 != null) goto L120;
            Intrinsics.throwNpe();     // Catch: Throwable -> L113
        L120:
            return new b(new ExplainPlaybackRequest(r3, r20, r29, r6, r12, r42, r110, r25, r37, r24, r13, r111, Integer.valueOf(((Number) r49).intValue()), 1, null, 16384, null), r34, r33, new LogExtraData(r21, r22, r23, null, null, r20, r33, null, null, r24, r25, null, 2456, null), new PlaybackEventExtraData(r29, r31, r32, r30, r35, null, null, r37, Integer.valueOf(r36), 96, null), new ExplainPlayBackPDPEntryLogExtra(r17, r15), null, r310, r311, r41, 64);
        L113:
            th = move-exception;
            Result.Companion r50 = Result.Companion;
            Object r51 = Result.constructor-impl(ResultKt.createFailure(th));
            if (Result.isFailure-impl(r51) == true) goto L118;
            r46 = r51;
        L118:
            r49 = r46;
            goto L120
        L107:
            r42 = r33;
            goto L108
        L92:
            if (ECLiveABUtils.INSTANCE.getECOM_ENABLE_REPLAY_SUBTITLE() == false) goto L104;
            String r52 = UriProtector.getQueryParameter(r1, "video_subtitle");
            if (r52 == null) goto L104;
            Result.Companion r53 = Result.Companion;     // Catch: Throwable -> L97
            int r54 = t0.a;     // Catch: Throwable -> L97
            Object r55 = Result.constructor-impl((List) t0.a.a.fromJson(r52, new C0083a().getType()));     // Catch: Throwable -> L97
        L100:
            if (Result.isFailure-impl(r55) == true) goto L103;
            r4 = r55;
        L103:
            r4 = (List) r4;
        L97:
            th = move-exception;
            Result.Companion r56 = Result.Companion;
            r55 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L100
        L77:
            if (ECSettingKeys.I0() == false) goto L88;
            String r57 = UriProtector.getQueryParameter(r1, "video_mbr");
            if (r57 == null) goto L88;
            Result.Companion r58 = Result.Companion;     // Catch: Throwable -> L82
            int r59 = t0.a;     // Catch: Throwable -> L82
            Object r60 = Result.constructor-impl((ECReplayVideo) t0.a.a.fromJson(r57, ECReplayVideo.class));     // Catch: Throwable -> L82
        L85:
            if (Result.isFailure-impl(r60) == false) goto L87;
            r60 = null;
        L87:
            r311 = (ECReplayVideo) r60;
        L82:
            th = move-exception;
            Result.Companion r61 = Result.Companion;
            r60 = Result.constructor-impl(ResultKt.createFailure(th));
        L70:
            e = move-exception;
            ECExceptionMonitor.c(e.toString());
            r40 = null;
        L73:
            r310 = null;
            goto L75
        L61:
            r27 = null;
        L63:
            r37 = null;
            goto L64
        L55:
            r25 = r18;
            goto L56
        L52:
            r19 = false;
            goto L53
        L48:
            r17 = r16;
            goto L49
        L44:
            r15 = r14;
            goto L45
        L40:
            r12 = r21;
            goto L41
        L37:
            r11 = false;
            goto L38
        L33:
            r32 = r10;
            goto L34
        L29:
            r31 = r9;
        L18:
            r0 = null;
            goto L19
        L5:
            if (r2.length() <= 0) goto L7;
            boolean r62 = true;
        L8:
            if (r62 == true) goto L11;
            r2 = null;
        L11:
            if (r2 == null) goto L14;
            r21 = r2;
            goto L20
        L7:
            r62 = false;
            goto L8
        }
    }

    static {
    }

    public b() {
        throw null;
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof b) == false) goto L26;
        b r4 = (b) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r4.c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r4.d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.e, r4.e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f, r4.f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.g, r4.g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.h, r4.h) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.i, r4.i) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.j, r4.j) == true) goto L40;
        return false;
    L40:
        return true;
    L26:
        return false;
    }

    public final int hashCode() {
        ExplainPlaybackRequest r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.b;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.c;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        LogExtraData r10 = this.d;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        PlaybackEventExtraData r13 = this.e;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        ExplainPlayBackPDPEntryLogExtra r16 = this.f;
        if (r16 == null) goto L25;
        int r17 = r16.hashCode();
    L26:
        int r18 = (r15 + r17) * 31;
        String r19 = this.g;
        if (r19 == null) goto L29;
        int r20 = r19.hashCode();
    L30:
        int r21 = (r18 + r20) * 31;
        ExplainPlaybackVideoInfo r22 = this.h;
        if (r22 == null) goto L33;
        int r23 = r22.hashCode();
    L34:
        int r24 = (r21 + r23) * 31;
        ECReplayVideo r25 = this.i;
        if (r25 == null) goto L37;
        int r26 = r25.hashCode();
    L38:
        int r27 = (r24 + r26) * 31;
        List<ExplainReplaySubTitle> r28 = this.j;
        if (r28 == null) goto L42;
        r1 = r28.hashCode();
    L42:
        return r27 + r1;
    L37:
        r26 = 0;
        goto L38
    L33:
        r23 = 0;
        goto L34
    L29:
        r20 = 0;
        goto L30
    L25:
        r17 = 0;
        goto L26
    L21:
        r14 = 0;
        goto L22
    L17:
        r11 = 0;
        goto L18
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "ExplainPlaybackOriginParams(explainPlaybackRequest=" + this.a + ", adLogExtra=" + this.b + ", entranceInfoString=" + this.c + ", logExtraData=" + this.d + ", playbackExtraData=" + this.e + ", pdpEntryLogExtra=" + this.f + ", tracker=" + this.g + ", carriedVideoInfo=" + this.h + ", carriedVideoMbrInfo=" + this.i + ", carriedVideoSubTitle=" + this.j + ")";
    }

    public b(ExplainPlaybackRequest r3, String r4, String r5, LogExtraData r6, PlaybackEventExtraData r7, ExplainPlayBackPDPEntryLogExtra r8, String r9, ExplainPlaybackVideoInfo r10, ECReplayVideo r11, List r12, int r13) {
        if ((r13 & 2) == 0) goto L6;
        r4 = null;
    L6:
        if ((r13 & 4) == 0) goto L9;
        r5 = null;
    L9:
        if ((r13 & 16) == 0) goto L12;
        r7 = null;
    L12:
        if ((r13 & 32) == 0) goto L15;
        r8 = null;
    L15:
        if ((r13 & 64) == 0) goto L18;
        r9 = null;
    L18:
        if ((r13 & DeviceStatus$DiffDimension.DIFF_RESTRICTED_MODE) == 0) goto L21;
        r10 = null;
    L21:
        if ((r13 & DeviceStatus$DiffDimension.DIFF_LOCATION_MODE) == 0) goto L24;
        r11 = null;
    L24:
        if ((r13 & DeviceStatus$DiffDimension.DIFF_IS_STRICT_RESTRICTED_MODE) == 0) goto L26;
        r12 = null;
    L26:
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r8;
        this.g = r9;
        this.h = r10;
        this.i = r11;
        this.j = r12;
    }
}
