package com.larus.audio;

import android.app.Application;
import android.os.Build;
import com.bytedance.flow_audio.api.business.asr.config.FlowAsrMockSamiCoreEventType;
import com.bytedance.flow_audio.api.config.connection.FlowAudioAudioTransportType;
import com.bytedance.flow_audio.api.config.connection.FlowAudioTokenType;
import com.bytedance.flow_audio.api.config.session.FlowAudioSessionRequestType;
import com.bytedance.flow_audio.api.scene.FlowAudioAssistantScene;
import com.bytedance.keva.Keva;
import com.larus.audio.audiov3.report.IAudioEventCommonParams;
import com.larus.audio.audiov3.util.IAudioDeviceHelper;
import com.larus.audio.settings.audio.data.AudioRetransmitStrategy;
import com.larus.business.debug.base.audio.module.ASRModule;
import com.larus.common.apphost.AppHost;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.z2;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.ttvideoengine.model.VideoRef;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i0 f289764a = null;

    static {
        f289764a = new i0();
    }

    public i0() {
    }

    public static qw5.a c(qw5.a r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        if (Intrinsics.areEqual(m58.h.f512145p.getValue(), Boolean.TRUE) == true) goto L5;
        return null;
    L5:
        x58.a r101 = m58.h.f512130a;
        if (r101 != null) goto L9;
        return null;
    L9:
        return qw5.a.a(r100, null, b(r101, r100.f534993a), null, 8063);
    }

    public static pw5.a b(x58.a r210, String r211) {
        Function1<? super String, String> r100 = r210.f562542p;
        if (r100 == null) goto L5;
        String r101 = r100.invoke(r210.f562527a);
    L7:
        if (r101 != null) goto L9;
        String r110 = "";
    L10:
        String r102 = r210.f562536j;
        if (r102 != null) goto L13;
        String r103 = "";
    L14:
        String r104 = r210.f562529c;
        boolean r105 = true;
        if (r104 != null) goto L17;
    L22:
        r104 = null;
    L23:
        FlowAudioAudioTransportType r106 = FlowAudioAudioTransportType.WEBSOCKET;
        if (r110.length() <= 0) goto L26;
        boolean r107 = true;
    L27:
        if (r107 == true) goto L29;
    L34:
        boolean r108 = false;
    L36:
        if (r210.f562540n == true) goto L40;
        r105 = false;
    L40:
        if (r105 == false) goto L46;
        if (r108 == false) goto L46;
        if (r210.f562545s == false) goto L46;
        c68.b.d("FlowAudioSessionConfigFactory", "quic enable");
        r106 = FlowAudioAudioTransportType.QUIC;
    L45:
        FlowAudioAudioTransportType r109 = r106;
        String r111 = r210.f562527a;
        if (r111 != null) goto L50;
        String r112 = "";
    L51:
        FlowAudioTokenType r113 = FlowAudioTokenType.TOKEN_TO_B;
        String r114 = r210.f562528b;
        if (r114 != null) goto L54;
        String r115 = "";
    L55:
        int r116 = r210.f562537k;
        AudioRetransmitStrategy r117 = r210.f562538l;
        if (r117 == null) goto L60;
        t78.a r118 = r117.getData();
        if (r118 == null) goto L60;
        boolean r119 = r118.a();
    L61:
        AudioRetransmitStrategy r120 = r210.f562538l;
        if (r120 == null) goto L69;
        t78.a r121 = r120.getData();
        if (r121 == null) goto L69;
        int[] r122 = r121.b();
        if (r122 == null) goto L69;
        List r123 = ArraysKt.toList(r122);
        if (r123 == null) goto L69;
    L70:
        List r124 = r123;
        String r125 = r210.f562534h;
        if (r125 != null) goto L73;
        String r126 = "";
    L75:
        return new pw5.a(r103, r104, r109, r112, r113, r115, r116, r119, r124, r126, r110, r211, r210.f562544r, r210.f562546t, r210.f562547u);
    L73:
        r126 = r125;
    L69:
        r123 = CollectionsKt.emptyList();
    L60:
        r119 = false;
        goto L61
    L54:
        r115 = r114;
        goto L55
    L50:
        r112 = r111;
    L46:
        int r127 = c68.b.f22600a;
        c68.b.d("FlowAudioSessionConfigFactory", "quic not enable. isUseFrontierQuic=" + Boolean.valueOf(r210.f562540n) + ", isConnectPoolEnableForBusiness=" + r108 + ", audioFrontierQuicEnable=" + Boolean.valueOf(r210.f562545s) + ", isConnectPoolEnable=" + Boolean.valueOf(r210.f562544r));
        goto L45
    L29:
        if (r210.f562541o != true) goto L31;
        boolean r128 = true;
    L32:
        if (r128 == false) goto L34;
        r108 = true;
        goto L36
    L31:
        r128 = false;
        goto L32
    L26:
        r107 = false;
        goto L27
    L17:
        if (r104.length() <= 0) goto L19;
        boolean r129 = true;
    L20:
        if (r129 == false) goto L22;
    L19:
        r129 = false;
        goto L20
    L13:
        r103 = r102;
        goto L14
    L9:
        r110 = r101;
        goto L10
    L5:
        r101 = null;
        goto L7
    }

    /* JADX WARN: Type inference failed for: r11v20, types: [com.larus.audio.h0] */
    public static qw5.a a(boolean r310, String r311, String r312, String r410, String r411, long r412, String r413, String r414, String r415) {
        Intrinsics.checkNotNullParameter(r311, "conversationId");
        String r100 = r312;
        Intrinsics.checkNotNullParameter(r100, "botId");
        Intrinsics.checkNotNullParameter(r410, "currentTaskId");
        Intrinsics.checkNotNullParameter(r411, "asrContextExtra");
        Intrinsics.checkNotNullParameter(r413, "audioFilePath");
        Intrinsics.checkNotNullParameter(r414, "asrLanguage");
        String r101 = r415;
        Intrinsics.checkNotNullParameter(r101, "asrModel");
        FlowAudioSessionRequestType r102 = FlowAudioSessionRequestType.MessageASR;
        FlowAudioAssistantScene r103 = FlowAudioAssistantScene.Im;
        int r110 = r103.getBusiness();
        JSONObject r111 = new JSONObject();
        int r112 = 0;
        if (StringsKt.startsWith$default(r311, "local", false, 2, null) == false) goto L5;
    L8:
        String r113 = "0";
    L9:
        r111.put("conversation_id", r113);
        r111.put("local_message_id", r410);
        r111.put("new_conversation", r310);
        r111.put("uid", AccountService.f365697a.getUserId());
        if (r312.length() <= 0) goto L12;
        boolean r114 = true;
    L13:
        if (r114 == true) goto L16;
        r100 = null;
    L16:
        if (r100 == null) goto L18;
        r111.put("bot_id", r100);
    L18:
        String r115 = r111.toString();
        x58.a r104 = m58.h.f512130a;
        if (r104 == null) goto L21;
        pw5.a r116 = b(r104, r410);
    L22:
        mw5.c r117 = null;
        if (r415.length() <= 0) goto L25;
        boolean r105 = true;
    L26:
        if (r105 == true) goto L29;
        r101 = null;
    L29:
        gw5.f r106 = new gw5.f(r101, r414);
        com.bytedance.flow_audio.api.foundation.record.a r107 = new com.bytedance.flow_audio.api.foundation.record.a(r112);
        IAudioEventCommonParams r108 = (IAudioEventCommonParams) ServiceManager.get().getService(IAudioEventCommonParams.class);
        Result.Companion r118 = Result.Companion;     // Catch: Throwable -> L60
        if (r108 == null) goto L37;
        m58.b r119 = m58.h.f512140k;     // Catch: Throwable -> L60
        if (r119 == null) goto L35;
        Application r120 = r119.getApplication();     // Catch: Throwable -> L60
    L36:
        r108.b(r120);     // Catch: Throwable -> L60
        goto L37
    L35:
        r120 = null;
    L37:
        if (r108 == null) goto L39;
        IAudioDeviceHelper.a r109 = r108.a();     // Catch: Throwable -> L60
    L40:
        JSONObject r121 = new JSONObject(r411);     // Catch: Throwable -> L60
        r121.put("device_model", Build.MODEL);     // Catch: Throwable -> L60
        if (r109 == null) goto L43;
        String r122 = r109.f288703a;     // Catch: Throwable -> L60
    L44:
        if (r122 != null) goto L46;
        r122 = "";
    L46:
        r121.put("input_device", r122);     // Catch: Throwable -> L60
        if (r109 == null) goto L49;
        String r123 = r109.f288704b;     // Catch: Throwable -> L60
    L50:
        if (r123 != null) goto L52;
        r123 = "";
    L52:
        r121.put("output_device", r123);     // Catch: Throwable -> L60
        if (r109 == null) goto L55;
        String r124 = r109.f288705c;     // Catch: Throwable -> L60
    L56:
        if (r124 != null) goto L58;
        r124 = "";
    L58:
        r121.put("bluetooth_device_name", r124);     // Catch: Throwable -> L60
        Object r125 = Result.m9449constructorimpl(r121.toString());     // Catch: Throwable -> L60
    L62:
        Throwable r126 = Result.m9452exceptionOrNullimpl(r125);
        if (r126 == null) goto L66;
        int r127 = c68.b.f22600a;
        c68.b.c("FlowAudioSessionConfigFactory", "appendAudioDeviceInfo failed: " + r126.getMessage(), r126);
        r125 = r411;
    L66:
        gw5.b r128 = new gw5.b((String) r125, 63);
        m58.t r129 = m58.h.f512142m;
        if (r129 != null) goto L69;
    L71:
        boolean r130 = false;
    L72:
        Boolean r131 = Boolean.valueOf(r130);
        m58.t r132 = m58.h.f512142m;
        if (r132 == null) goto L75;
        float r133 = r132.c();
    L76:
        Float r134 = Float.valueOf(r133);
        m58.t r135 = m58.h.f512142m;
        if (r135 != null) goto L79;
    L81:
        boolean r136 = false;
    L82:
        gw5.a r137 = new gw5.a(r131, r134, Boolean.valueOf(r136), new g0());
        pw5.a r138 = r116;
        gw5.g r139 = new gw5.g(r413, r412, 4);
        Keva r140 = c78.a.f22663g;
        if (r140.getInt("key_asr_retry_times", -1) == (-1)) goto L85;
        int r141 = r140.getInt("key_asr_retry_times", -1);
    L97:
        if (r140.getInt("key_asr_timeout_duration", -1) == (-1)) goto L99;
        int r142 = r140.getInt("key_asr_timeout_duration", -1);
    L111:
        m58.t r143 = m58.h.f512142m;
        if (r143 == null) goto L117;
        o58.a r144 = r143.a();
        if (r144 == null) goto L117;
        List<String> r145 = r144.f522105b;
        if (r145 == null) goto L117;
    L118:
        m58.t r146 = m58.h.f512142m;
        if (r146 == null) goto L124;
        o58.a r147 = r146.a();
        if (r147 == null) goto L124;
        List<String> r148 = r147.f522104a;
        if (r148 == null) goto L124;
    L125:
        gw5.c r149 = new gw5.c(r141, r142, r145, r148);
        AppHost.Companion r150 = AppHost.f326268a;
        if (r150.isTestChannel() == false) goto L128;
    L131:
        m58.q r151 = m58.h.f512133d;
        if (r151 == null) goto L159;
        final ASRModule r152 = r151.c();
        if (r152 == null) goto L159;
        long r210 = r152.e();
        int r153 = r152.b();
        if (r152.m() == false) goto L158;
        if (r153 <= 0) goto L140;
    L142:
        FlowAsrMockSamiCoreEventType.a r154 = FlowAsrMockSamiCoreEventType.Companion;
        int r155 = r152.g();
        r154.getClass();
        Iterator<FlowAsrMockSamiCoreEventType> r156 = FlowAsrMockSamiCoreEventType.getEntries().iterator();
    L144:
        if (r156.hasNext() == false) goto L152;
        FlowAsrMockSamiCoreEventType r157 = r156.next();
        if (r157.getValue() != r155) goto L148;
        boolean r158 = true;
    L149:
        if (r158 == false) goto L144;
    L153:
        FlowAsrMockSamiCoreEventType r159 = r157;
        if (r159 != null) goto L156;
        FlowAsrMockSamiCoreEventType r211 = FlowAsrMockSamiCoreEventType.NONE;
    L157:
        gw5.e r212 = new gw5.e(true, new h0(r152), r211, r152.f(), r210, 224);
    L161:
        JSONObject r160 = new JSONObject();
        AppHost.Companion r161 = AppHost.f326268a;
        r160.put("app_version", r161.getVersionName());
        r160.put(Constants.EXTRA_KEY_APP_VERSION_CODE, r161.getUpdateVersionCode());
        r160.put(com.bytedance.android.ec.core.event.a.KEY_DID, com.larus.platform.service.o.f365780a.getDeviceId());
        r160.put("uid", AccountService.f365697a.getUserId());
        r160.put("flow_social", m58.x.f512148a);
        r160.put("extra", "");
        return new qw5.a(r410, r311, r102, null, r103, r110, r115, r138, r117, new gw5.i(r106, r107, r128, r137, r139, r149, r212, 144), null, r160.toString(), 5376);
    L156:
        r211 = r159;
        goto L157
    L148:
        r158 = false;
        goto L149
    L152:
        r157 = null;
        goto L153
    L140:
        if (r153 == (-1)) goto L142;
    L158:
        gw5.e r162 = new gw5.e(false, null, null, 0, r210, VideoRef.VALUE_VIDEO_REF_SUBTITLE_POSITION_X);
    L160:
        r212 = r162;
    L159:
        r162 = new gw5.e(false, null, null, 0, 0, 254);
        goto L160
    L128:
        if (Intrinsics.areEqual(r150.getBuildChannel(), "auto_test") == true) goto L131;
        r162 = new gw5.e(false, null, null, 0, 0, 254);
    L124:
        r148 = CollectionsKt.emptyList();
    L117:
        r145 = CollectionsKt.emptyList();
        goto L118
    L99:
        z2 r163 = z2.f365865a;
        lq9.h r164 = r163.U0().c();
        if (r164 == null) goto L105;
        if (r164.a() != true) goto L105;
        boolean r165 = true;
    L106:
        if (r165 == false) goto L110;
        lq9.h r166 = r163.U0().c();
        if (r166 == null) goto L110;
        r142 = r166.b();
    L110:
        r142 = 25000;
    L105:
        r165 = false;
        goto L106
    L85:
        z2 r167 = z2.f365865a;
        lq9.h r168 = r167.U0().c();
        if (r168 != null) goto L88;
    L90:
        boolean r169 = false;
    L91:
        if (r169 == false) goto L95;
        lq9.h r170 = r167.U0().c();
        if (r170 == null) goto L95;
        r141 = r170.c();
    L95:
        r141 = 1;
        goto L97
    L88:
        if (r168.a() != true) goto L90;
        r169 = true;
        goto L91
    L79:
        if (r135.b() != true) goto L81;
        r136 = true;
        goto L82
    L75:
        r133 = 0.0f;
        goto L76
    L69:
        if (r129.d() != true) goto L71;
        r130 = true;
        goto L72
    L55:
        r124 = null;
        goto L56
    L49:
        r123 = null;
        goto L50
    L43:
        r122 = null;
        goto L44
    L39:
        r109 = null;
    L60:
        th = move-exception;
        Result.Companion r171 = Result.Companion;
        r125 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L62
    L25:
        r105 = false;
        goto L26
    L21:
        r116 = null;
        goto L22
    L12:
        r114 = false;
        goto L13
    L5:
        if (StringsKt.endsWith$default(r311, "local", false, 2, null) == true) goto L8;
        r113 = r311;
        goto L9
    }
}
