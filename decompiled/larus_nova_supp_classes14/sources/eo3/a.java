package eo3;

import com.bytedance.android.livesdk.config.KtvAudioVolumeAnimConfig;
import com.bytedance.android.livesdk.config.LiveLinkMicUpdateLiveCoreParamsConfig;
import com.bytedance.android.livesdk.config.MultiLinkFirstFrameOptConfig;
import com.bytedance.android.livesdk.config.MultiLinkRevenueEnterRoomOptConfig;
import com.bytedance.android.livesdk.config.RealTimeChorusDownloadOptConfig;
import com.bytedance.android.livesdk.config.a51;
import com.bytedance.android.livesdk.config.a9;
import com.bytedance.android.livesdk.config.ac1;
import com.bytedance.android.livesdk.config.b51;
import com.bytedance.android.livesdk.config.b9;
import com.bytedance.android.livesdk.config.bk1;
import com.bytedance.android.livesdk.config.c61;
import com.bytedance.android.livesdk.config.cd1;
import com.bytedance.android.livesdk.config.d21;
import com.bytedance.android.livesdk.config.d9;
import com.bytedance.android.livesdk.config.dd1;
import com.bytedance.android.livesdk.config.dg1;
import com.bytedance.android.livesdk.config.dh1;
import com.bytedance.android.livesdk.config.e1;
import com.bytedance.android.livesdk.config.e3;
import com.bytedance.android.livesdk.config.e9;
import com.bytedance.android.livesdk.config.f9;
import com.bytedance.android.livesdk.config.fe1;
import com.bytedance.android.livesdk.config.fk1;
import com.bytedance.android.livesdk.config.g1;
import com.bytedance.android.livesdk.config.gk1;
import com.bytedance.android.livesdk.config.h51;
import com.bytedance.android.livesdk.config.i51;
import com.bytedance.android.livesdk.config.i8;
import com.bytedance.android.livesdk.config.j51;
import com.bytedance.android.livesdk.config.j8;
import com.bytedance.android.livesdk.config.j81;
import com.bytedance.android.livesdk.config.jb1;
import com.bytedance.android.livesdk.config.jh1;
import com.bytedance.android.livesdk.config.k51;
import com.bytedance.android.livesdk.config.kb1;
import com.bytedance.android.livesdk.config.l5;
import com.bytedance.android.livesdk.config.l8;
import com.bytedance.android.livesdk.config.lb1;
import com.bytedance.android.livesdk.config.lh1;
import com.bytedance.android.livesdk.config.link.InteractFrequencyConfig;
import com.bytedance.android.livesdk.config.m7;
import com.bytedance.android.livesdk.config.m71;
import com.bytedance.android.livesdk.config.mf1;
import com.bytedance.android.livesdk.config.mh1;
import com.bytedance.android.livesdk.config.n5;
import com.bytedance.android.livesdk.config.n8;
import com.bytedance.android.livesdk.config.nb1;
import com.bytedance.android.livesdk.config.nf1;
import com.bytedance.android.livesdk.config.o5;
import com.bytedance.android.livesdk.config.ob1;
import com.bytedance.android.livesdk.config.of1;
import com.bytedance.android.livesdk.config.pb1;
import com.bytedance.android.livesdk.config.pf1;
import com.bytedance.android.livesdk.config.q7;
import com.bytedance.android.livesdk.config.qb1;
import com.bytedance.android.livesdk.config.r01;
import com.bytedance.android.livesdk.config.rb1;
import com.bytedance.android.livesdk.config.rj1;
import com.bytedance.android.livesdk.config.s01;
import com.bytedance.android.livesdk.config.s11;
import com.bytedance.android.livesdk.config.sb1;
import com.bytedance.android.livesdk.config.t01;
import com.bytedance.android.livesdk.config.t51;
import com.bytedance.android.livesdk.config.t61;
import com.bytedance.android.livesdk.config.tb1;
import com.bytedance.android.livesdk.config.u01;
import com.bytedance.android.livesdk.config.u41;
import com.bytedance.android.livesdk.config.u5;
import com.bytedance.android.livesdk.config.u91;
import com.bytedance.android.livesdk.config.ub1;
import com.bytedance.android.livesdk.config.v41;
import com.bytedance.android.livesdk.config.v71;
import com.bytedance.android.livesdk.config.vb1;
import com.bytedance.android.livesdk.config.w41;
import com.bytedance.android.livesdk.config.wd1;
import com.bytedance.android.livesdk.config.x21;
import com.bytedance.android.livesdk.config.x41;
import com.bytedance.android.livesdk.config.x61;
import com.bytedance.android.livesdk.config.xb1;
import com.bytedance.android.livesdk.config.y01;
import com.bytedance.android.livesdk.config.y21;
import com.bytedance.android.livesdk.config.y41;
import com.bytedance.android.livesdk.config.y61;
import com.bytedance.android.livesdk.config.y8;
import com.bytedance.android.livesdk.config.yg1;
import com.bytedance.android.livesdk.config.z01;
import com.bytedance.android.livesdk.config.z41;
import com.bytedance.android.livesdk.config.z8;
import com.bytedance.android.livesdk.config.zb1;
import com.bytedance.android.livesdk.config.zg1;
import com.bytedance.android.livesdk.config.zh1;
import com.bytedance.android.livesdk.model.u0;
import com.bytedance.android.livesdk.model.w0;
import com.bytedance.android.livesdkapi.model.AdventureLynxPanelConfig;
import com.bytedance.android.livesdkapi.model.IGuestLinkSettingConfig;
import com.bytedance.android.livesdkapi.model.ILinkmicDynamicLinkServiceConfig;
import com.bytedance.android.livesdkapi.model.ILinkmicDynamicPanelConfig;
import com.bytedance.android.livesdkapi.model.ILiveLinkCameraBackUpConfig;
import com.bytedance.android.livesdkapi.model.KtvLabelTextConfig;
import com.bytedance.android.livesdkapi.model.LinkAudioInviteGuideConfig;
import com.bytedance.android.livesdkapi.model.LinkRoomFightLynxConfig;
import com.bytedance.android.livesdkapi.model.LiveAudioSubtitleSetting;
import com.bytedance.android.livesdkapi.model.LiveChatRoomPanelLynxConfig;
import com.bytedance.android.livesdkapi.model.LiveKtvFirstLevelTabConfig;
import com.bytedance.android.livesdkapi.model.LivePlayerSmoothEnterRoomConfig;
import com.bytedance.android.livesdkapi.model.LiveThemedCompetitionResourceUrlConfig;
import com.bytedance.android.livesdkapi.model.LiveThemedCompetitionSchemaConfig;
import com.bytedance.android.livesdkapi.model.MultiLinkMatchScreenConfig;
import com.bytedance.android.livesdkapi.model.PlayModeLynxPanelConfig;
import com.bytedance.android.livesdkapi.model.RoomBattleMatchRefactorLynx;
import com.bytedance.android.livesdkapi.model.VideoDigitAvatarBgConfig;
import com.bytedance.android.livesdkapi.model.VideoTalkBgDeviceConfig;
import com.bytedance.android.livesdkapi.model.VoiceLiveThemeConfig;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.HamletBusinessConfig;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.HamletExternalRenderConfig;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.HamletLiveMediaMockConfig;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.LiveBackupSeiSettingConfig;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.LiveLinkMicDynamicCenterConfig;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.LivePreviewMultiLinkDelayConfig;
import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a {
    public static final Type A = null;
    public static final Type B = null;
    public static final Type C = null;
    public static final Type D = null;
    public static final Type E = null;
    public static final Type F = null;
    public static final Type G = null;
    public static final Type H = null;
    public static final Type I = null;
    public static final Type J = null;
    public static final Type K = null;
    public static final Type L = null;
    public static final Type M = null;
    public static final Type N = null;
    public static final Type O = null;
    public static final Type P = null;
    public static final Type a = null;
    public static final Type b = null;
    public static final Type c = null;
    public static final Type d = null;
    public static final Type e = null;
    public static final Type f = null;
    public static final Type g = null;
    public static final Type h = null;
    public static final Type i = null;
    public static final Type j = null;
    public static final Type k = null;
    public static final Type l = null;
    public static final Type m = null;
    public static final Type n = null;
    public static final Type o = null;
    public static final Type p = null;
    public static final Type q = null;
    public static final Type r = null;
    public static final Type s = null;
    public static final Type t = null;
    public static final Type u = null;
    public static final Type v = null;
    public static final Type w = null;
    public static final Type x = null;
    public static final Type y = null;
    public static final Type z = null;

    /* JADX INFO: renamed from: eo3.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"eo3/a$a", "Lcom/google/gson/reflect/TypeToken;", "", "", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class C0118a extends TypeToken<String[]> {
        public C0118a() {
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0001¨\u0006\u0005"}, d2 = {"eo3/a$a0", "Lcom/google/gson/reflect/TypeToken;", "Ljava/util/HashMap;", "", "Lcom/bytedance/android/livesdk/config/l8;", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class a0 extends TypeToken<HashMap<Integer, l8>> {
        public a0() {
        }
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"eo3/a$b", "Lcom/google/gson/reflect/TypeToken;", "", "", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class b extends TypeToken<String[]> {
        public b() {
        }
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"eo3/a$b0", "Lcom/google/gson/reflect/TypeToken;", "Ljava/util/HashMap;", "", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class b0 extends TypeToken<HashMap<String, String>> {
        public b0() {
        }
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"eo3/a$c", "Lcom/google/gson/reflect/TypeToken;", "", "", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class c extends TypeToken<String[]> {
        public c() {
        }
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"eo3/a$c0", "Lcom/google/gson/reflect/TypeToken;", "", "", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class c0 extends TypeToken<String[]> {
        public c0() {
        }
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"eo3/a$d", "Lcom/google/gson/reflect/TypeToken;", "", "", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class d extends TypeToken<String[]> {
        public d() {
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0006\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0001¨\u0006\u0005"}, d2 = {"eo3/a$d0", "Lcom/google/gson/reflect/TypeToken;", "", "", "", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class d0 extends TypeToken<Map<String, ? extends Double>> {
        public d0() {
        }
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"eo3/a$e", "Lcom/google/gson/reflect/TypeToken;", "", "", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class e extends TypeToken<List<String>> {
        public e() {
        }
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"eo3/a$e0", "Lcom/google/gson/reflect/TypeToken;", "", "", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class e0 extends TypeToken<List<? extends String>> {
        public e0() {
        }
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"eo3/a$f", "Lcom/google/gson/reflect/TypeToken;", "", "", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class f extends TypeToken<String[]> {
        public f() {
        }
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"eo3/a$f0", "Lcom/google/gson/reflect/TypeToken;", "", "", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class f0 extends TypeToken<Integer[]> {
        public f0() {
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002 \u0012\u001c\u0012\u001a\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u00020\u0001¨\u0006\u0005"}, d2 = {"eo3/a$g", "Lcom/google/gson/reflect/TypeToken;", "", "", "Lcom/bytedance/android/livesdk/config/r01;", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class g extends TypeToken<Map<String, ? extends Map<String, ? extends r01>>> {
        public g() {
        }
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"eo3/a$g0", "Lcom/google/gson/reflect/TypeToken;", "", "", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class g0 extends TypeToken<List<? extends String>> {
        public g0() {
        }
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"eo3/a$h", "Lcom/google/gson/reflect/TypeToken;", "", "", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class h extends TypeToken<Map<String, ? extends String>> {
        public h() {
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0001¨\u0006\u0005"}, d2 = {"eo3/a$h0", "Lcom/google/gson/reflect/TypeToken;", "", "", "Lcom/bytedance/android/livesdk/config/fk1;", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class h0 extends TypeToken<Map<Integer, ? extends fk1>> {
        public h0() {
        }
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"eo3/a$i", "Lcom/google/gson/reflect/TypeToken;", "", "", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class i extends TypeToken<Integer[]> {
        public i() {
        }
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"eo3/a$i0", "Lcom/google/gson/reflect/TypeToken;", "", "", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class i0 extends TypeToken<List<String>> {
        public i0() {
        }
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"eo3/a$j", "Lcom/google/gson/reflect/TypeToken;", "", "", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class j extends TypeToken<List<String>> {
        public j() {
        }
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"eo3/a$j0", "Lcom/google/gson/reflect/TypeToken;", "", "", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class j0 extends TypeToken<List<String>> {
        public j0() {
        }
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"eo3/a$k", "Lcom/google/gson/reflect/TypeToken;", "", "", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class k extends TypeToken<Integer[]> {
        public k() {
        }
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"eo3/a$k0", "Lcom/google/gson/reflect/TypeToken;", "", "", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class k0 extends TypeToken<List<? extends String>> {
        public k0() {
        }
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"eo3/a$l", "Lcom/google/gson/reflect/TypeToken;", "", "", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class l extends TypeToken<List<String>> {
        public l() {
        }
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"eo3/a$l0", "Lcom/google/gson/reflect/TypeToken;", "", "", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class l0 extends TypeToken<List<Integer>> {
        public l0() {
        }
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"eo3/a$m", "Lcom/google/gson/reflect/TypeToken;", "", "", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class m extends TypeToken<List<? extends String>> {
        public m() {
        }
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"eo3/a$m0", "Lcom/google/gson/reflect/TypeToken;", "", "Lcom/bytedance/android/livesdk/config/jh1;", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class m0 extends TypeToken<List<jh1>> {
        public m0() {
        }
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"eo3/a$n", "Lcom/google/gson/reflect/TypeToken;", "", "Ljava/lang/Integer;", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class n extends TypeToken<List<Integer>> {
        public n() {
        }
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"eo3/a$n0", "Lcom/google/gson/reflect/TypeToken;", "", "", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class n0 extends TypeToken<List<String>> {
        public n0() {
        }
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"eo3/a$o", "Lcom/google/gson/reflect/TypeToken;", "", "", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class o extends TypeToken<List<String>> {
        public o() {
        }
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"eo3/a$o0", "Lcom/google/gson/reflect/TypeToken;", "", "", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class o0 extends TypeToken<Integer[]> {
        public o0() {
        }
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"eo3/a$p", "Lcom/google/gson/reflect/TypeToken;", "", "Lcom/bytedance/android/livesdk/config/a51;", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class p extends TypeToken<List<a51>> {
        public p() {
        }
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"eo3/a$p0", "Lcom/google/gson/reflect/TypeToken;", "", "", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class p0 extends TypeToken<Integer[]> {
        public p0() {
        }
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"eo3/a$q", "Lcom/google/gson/reflect/TypeToken;", "", "Lcom/bytedance/android/livesdk/config/a51;", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class q extends TypeToken<List<a51>> {
        public q() {
        }
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"eo3/a$r", "Lcom/google/gson/reflect/TypeToken;", "", "", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class r extends TypeToken<Map<String, String>> {
        public r() {
        }
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002 \u0012\u001c\u0012\u001a\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00020\u00020\u0001¨\u0006\u0004"}, d2 = {"eo3/a$s", "Lcom/google/gson/reflect/TypeToken;", "", "", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class s extends TypeToken<Map<String, ? extends Map<String, ? extends String>>> {
        public s() {
        }
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"eo3/a$t", "Lcom/google/gson/reflect/TypeToken;", "", "", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class t extends TypeToken<Map<String, String>> {
        public t() {
        }
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"eo3/a$u", "Lcom/google/gson/reflect/TypeToken;", "", "", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class u extends TypeToken<List<Integer>> {
        public u() {
        }
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"eo3/a$v", "Lcom/google/gson/reflect/TypeToken;", "", "", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class v extends TypeToken<List<Integer>> {
        public v() {
        }
    }

    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000*\u0001\u0000\b\n\u0018\u00002,\u0012(\u0012&\u0012\u0004\u0012\u00020\u0003\u0012\u001c\u0012\u001a\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\u00040\u00040\u00020\u0001¨\u0006\u0006"}, d2 = {"eo3/a$w", "Lcom/google/gson/reflect/TypeToken;", "", "", "", "", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class w extends TypeToken<Map<String, Map<String, ? extends Map<String, ? extends Object>>>> {
        public w() {
        }
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"eo3/a$x", "Lcom/google/gson/reflect/TypeToken;", "", "", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class x extends TypeToken<List<String>> {
        public x() {
        }
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"eo3/a$y", "Lcom/google/gson/reflect/TypeToken;", "", "", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class y extends TypeToken<List<String>> {
        public y() {
        }
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0006\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"eo3/a$z", "Lcom/google/gson/reflect/TypeToken;", "", "", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class z extends TypeToken<Double[]> {
        public z() {
        }
    }

    static {
        Type r0 = new m0().getType();
        Intrinsics.checkNotNull(r0);
        a = r0;
        Type r1 = new h0().getType();
        Intrinsics.checkNotNull(r1);
        b = r1;
        Type r2 = new a0().getType();
        Intrinsics.checkNotNull(r2);
        c = r2;
        Type r3 = new g0().getType();
        Intrinsics.checkNotNull(r3);
        d = r3;
        Type r4 = new w().getType();
        Intrinsics.checkNotNull(r4);
        e = r4;
        Type r5 = new p0().getType();
        Intrinsics.checkNotNull(r5);
        f = r5;
        Type r6 = new u().getType();
        Intrinsics.checkNotNull(r6);
        g = r6;
        Type r7 = new j0().getType();
        Intrinsics.checkNotNull(r7);
        h = r7;
        Type r8 = new k().getType();
        Intrinsics.checkNotNull(r8);
        i = r8;
        Type r9 = new f0().getType();
        Intrinsics.checkNotNull(r9);
        j = r9;
        Type r10 = new t().getType();
        Intrinsics.checkNotNull(r10);
        k = r10;
        Type r11 = new g().getType();
        Intrinsics.checkNotNull(r11);
        l = r11;
        Type r12 = new y().getType();
        Intrinsics.checkNotNull(r12);
        m = r12;
        Type r13 = new b0().getType();
        Intrinsics.checkNotNull(r13);
        n = r13;
        Type r14 = new c().getType();
        Intrinsics.checkNotNull(r14);
        o = r14;
        Type r15 = new i0().getType();
        Intrinsics.checkNotNull(r15);
        p = r15;
        Type r16 = new e().getType();
        Intrinsics.checkNotNull(r16);
        q = r16;
        Type r17 = new n().getType();
        Intrinsics.checkNotNull(r17);
        r = r17;
        Type r18 = new v().getType();
        Intrinsics.checkNotNull(r18);
        s = r18;
        Type r19 = new d().getType();
        Intrinsics.checkNotNull(r19);
        t = r19;
        Type r20 = new d0().getType();
        Intrinsics.checkNotNull(r20);
        u = r20;
        Type r21 = new x().getType();
        Intrinsics.checkNotNull(r21);
        v = r21;
        Type r22 = new o0().getType();
        Intrinsics.checkNotNull(r22);
        w = r22;
        Type r23 = new j().getType();
        Intrinsics.checkNotNull(r23);
        x = r23;
        Type r24 = new f().getType();
        Intrinsics.checkNotNull(r24);
        y = r24;
        Type r25 = new q().getType();
        Intrinsics.checkNotNull(r25);
        z = r25;
        Type r26 = new C0118a().getType();
        Intrinsics.checkNotNull(r26);
        A = r26;
        Type r27 = new l().getType();
        Intrinsics.checkNotNull(r27);
        B = r27;
        Type r28 = new h().getType();
        Intrinsics.checkNotNull(r28);
        C = r28;
        Type r29 = new n0().getType();
        Intrinsics.checkNotNull(r29);
        D = r29;
        Type r30 = new m().getType();
        Intrinsics.checkNotNull(r30);
        E = r30;
        Type r31 = new z().getType();
        Intrinsics.checkNotNull(r31);
        F = r31;
        Type r32 = new s().getType();
        Intrinsics.checkNotNull(r32);
        G = r32;
        Type r33 = new o().getType();
        Intrinsics.checkNotNull(r33);
        H = r33;
        Type r34 = new b().getType();
        Intrinsics.checkNotNull(r34);
        I = r34;
        Type r35 = new p().getType();
        Intrinsics.checkNotNull(r35);
        J = r35;
        Type r36 = new e0().getType();
        Intrinsics.checkNotNull(r36);
        K = r36;
        Type r37 = new i().getType();
        Intrinsics.checkNotNull(r37);
        L = r37;
        Type r38 = new l0().getType();
        Intrinsics.checkNotNull(r38);
        M = r38;
        Type r39 = new k0().getType();
        Intrinsics.checkNotNull(r39);
        N = r39;
        Type r40 = new c0().getType();
        Intrinsics.checkNotNull(r40);
        O = r40;
        Type r41 = new r().getType();
        Intrinsics.checkNotNull(r41);
        P = r41;
    }

    @JvmStatic
    public static final void a() {
        ConcurrentHashMap r0 = UltraSettingsManager.a;
        Class r1 = Boolean.TYPE;
        UltraSettingsManager.b("live_broadcast_destroy_need_leave_and_report_ping", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_broadcast_destroy_need_leave_and_report_ping", Reflection.getOrCreateKotlinClass(r1), "主播页面销毁的时候是否需要调用连麦leave接口和ping/anchor(调用后会导致续播异常)", "ranxiongxiong"));
        UltraSettingsManager.b("ktv_opus_guide_image", new com.bytedance.tools.kcp.ultrasettings.runtime.c("ktv_opus_guide_image", Reflection.getOrCreateKotlinClass(String.class), "ktv mv引导弹窗图片", "ranxiongxiong"));
        UltraSettingsManager.b("live_solo_ktv_publish_text", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_solo_ktv_publish_text", a, "live_solo_ktv_publish_text", "ranxiongxiong"));
        UltraSettingsManager.b("enable_bitmap_crop", new com.bytedance.tools.kcp.ultrasettings.runtime.c("enable_bitmap_crop", Reflection.getOrCreateKotlinClass(r1), "是否裁剪大bitmap", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_ordered_song_context_crash_switch", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_ordered_song_context_crash_switch", Reflection.getOrCreateKotlinClass(r1), "K歌已点dataContextcrash 开关", "ranxiongxiong"));
        Class r2 = Long.TYPE;
        UltraSettingsManager.b("new_video_link_close_room_switch_delay", new com.bytedance.tools.kcp.ultrasettings.runtime.c("new_video_link_close_room_switch_delay", Reflection.getOrCreateKotlinClass(r2), "【新视频连线】厅主关播，观众延迟甩回规避", "yezhichao"));
        UltraSettingsManager.b("live_midi_freqen_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_midi_freqen_opt", Reflection.getOrCreateKotlinClass(r1), "midi背景调用频控", "ranxiongxiong"));
        UltraSettingsManager.b("live_interact_gift_emoji_settings", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_interact_gift_emoji_settings", Reflection.getOrCreateKotlinClass(i8.class), "飞麦礼物间隔时长以及场景支持", "ranxiongxiong"));
        UltraSettingsManager.b("live_linkmic_paid_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_linkmic_paid_config", Reflection.getOrCreateKotlinClass(u01.class), "视频直播间支持付费连线配置", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_lyric_file_not_existed_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_lyric_file_not_existed_opt", Reflection.getOrCreateKotlinClass(r1), "K歌歌词文件不存在导致演唱异常优化", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_link_state_change_update_banner_url", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_link_state_change_update_banner_url", Reflection.getOrCreateKotlinClass(r1), "连线状态变化刷新点歌面板Banner数据", "ranxiongxiong"));
        UltraSettingsManager.b("live_update_real_time_chorus_mix_type_switch", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_update_real_time_chorus_mix_type_switch", Reflection.getOrCreateKotlinClass(r1), "开启实时合唱更新rtc状态开关", "ranxiongxiong"));
        Class r3 = Integer.TYPE;
        UltraSettingsManager.b("live_new_midi_dimension_count", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_new_midi_dimension_count", Reflection.getOrCreateKotlinClass(r3), "K歌midi打分模式, 1（一维）， 3（三维）", "zengle"));
        UltraSettingsManager.b("live_link_follow_guide", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_link_follow_guide", Reflection.getOrCreateKotlinClass(r1), "连线用户是否开启互关引导", "ranxiongxiong"));
        UltraSettingsManager.b("live_interact_pull_stream_agc_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_interact_pull_stream_agc_config", Reflection.getOrCreateKotlinClass(sb1.class), "多人连线RTC拉流AGC响度配置", "fuminwen"));
        UltraSettingsManager.b("live_rtc_black_frame_video_capture_device_change_polling_time", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_rtc_black_frame_video_capture_device_change_polling_time", Reflection.getOrCreateKotlinClass(r2), "rtc内采黑帧视频采集设备变更轮询时长", "ranxiongxiong"));
        UltraSettingsManager.b("live_video_support_theme_replace", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_video_support_theme_replace", Reflection.getOrCreateKotlinClass(VoiceLiveThemeConfig.class), "视频直播是否支持背景", "ranxiongxiong"));
        UltraSettingsManager.b("live_interaction_anchor_waiting_list_sort_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_interaction_anchor_waiting_list_sort_enable", Reflection.getOrCreateKotlinClass(r3), "主播侧是否支持切换排序", "ranxiongxiong"));
        UltraSettingsManager.b("live_real_time_chorus_lead_voice_volume_fixed", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_real_time_chorus_lead_voice_volume_fixed", Reflection.getOrCreateKotlinClass(r1), "领唱模式是否固定音量", "ranxiongxiong"));
        UltraSettingsManager.b("live_multi_link_sei_opt_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_link_sei_opt_config", Reflection.getOrCreateKotlinClass(ub1.class), "多人场景sei优化相关配置", "ranxiongxiong"));
        UltraSettingsManager.b("live_multi_link_interactive_song_widget_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_link_interactive_song_widget_opt", Reflection.getOrCreateKotlinClass(r1), "多人场景点唱widget优化", "ranxiongxiong"));
        UltraSettingsManager.b("live_soloktv_enable_scroll_middle", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_soloktv_enable_scroll_middle", Reflection.getOrCreateKotlinClass(r1), "模版选择是否切到中间", "ranxiongxiong"));
        UltraSettingsManager.b("live_multi_link_guest_fall_back_fps", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_link_guest_fall_back_fps", Reflection.getOrCreateKotlinClass(r3), "嘉宾推流fps默认设置", "liaonanshan"));
        UltraSettingsManager.b("live_ktv_merge_mode_waiting_observe_time", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_merge_mode_waiting_observe_time", Reflection.getOrCreateKotlinClass(r2), "K歌组件连线等待监听时长", "ranxiongxiong"));
        UltraSettingsManager.b("live_rt_chorus_lifecycle_error_fix", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_rt_chorus_lifecycle_error_fix", Reflection.getOrCreateKotlinClass(r1), "合唱派对预览流进退房生命周期错乱修复", "ranxiongxiong"));
        UltraSettingsManager.b("live_multi_link_avatar_subtitle_drag_area_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_link_avatar_subtitle_drag_area_opt", Reflection.getOrCreateKotlinClass(r1), "你点我唱avatar字幕拖动区域修复", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_control_node_fix", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_control_node_fix", Reflection.getOrCreateKotlinClass(r1), "KTV control node逻辑bug修复", "ranxiongxiong"));
        UltraSettingsManager.b("live_multilink_game_dynamic_window_guest_default_visible", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multilink_game_dynamic_window_guest_default_visible", Reflection.getOrCreateKotlinClass(r1), "多人场景弹幕玩法布局麦位缩起状态下的嘉宾默认可视性", "ranxiongxiong"));
        UltraSettingsManager.b("live_interact_use_new_panel_for_lite", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_interact_use_new_panel_for_lite", Reflection.getOrCreateKotlinClass(r1), "抖音lite双人聊使用新的观众连线设置面板", "ranxiongxiong"));
        UltraSettingsManager.b("live_enable_interact_guest_setting", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_enable_interact_guest_setting", Reflection.getOrCreateKotlinClass(r1), "聊天室可分发给嘉宾朋友", "ranxiongxiong"));
        UltraSettingsManager.b("live_interaction_enable_rts_fix_media_status", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_interaction_enable_rts_fix_media_status", Reflection.getOrCreateKotlinClass(r1), "是否允许rts校准音视频状态", "ranxiongxiong"));
        UltraSettingsManager.b("live_rt_chorus_switch_scene_need_leave", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_rt_chorus_switch_scene_need_leave", Reflection.getOrCreateKotlinClass(r1), "实时合唱场景切换需要主动退出", "ranxiongxiong"));
        UltraSettingsManager.b("live_cross_room_replay_invite_audio_type", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_cross_room_replay_invite_audio_type", Reflection.getOrCreateKotlinClass(r1), "跨房放大布局强制使用语音连麦回复邀请", "luosheng"));
        UltraSettingsManager.b("fast_match_optimize_v2_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("fast_match_optimize_v2_enable", Reflection.getOrCreateKotlinClass(y21.class), "快速匹配优化二期是否开启", "ranxiongxiong"));
        UltraSettingsManager.b("multi_link_common_window_layout_config_load_strategy", new com.bytedance.tools.kcp.ultrasettings.runtime.c("multi_link_common_window_layout_config_load_strategy", Reflection.getOrCreateKotlinClass(ob1.class), "通用布局配置化参数加载策略", "ranxiongxiong"));
        UltraSettingsManager.b("live_chorus_concert_bussiness_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_chorus_concert_bussiness_config", Reflection.getOrCreateKotlinClass(d21.class), "演唱会业务配置", "zengle"));
        Class r4 = Float.TYPE;
        UltraSettingsManager.b("live_video_avatar_performance_limit_guest", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_video_avatar_performance_limit_guest", Reflection.getOrCreateKotlinClass(r4), "视频聊天室使用avatar最低机型打分要求-for嘉宾", "ranxiongxiong"));
        UltraSettingsManager.b("live_multi_link_room_scope_fallback", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_link_room_scope_fallback", Reflection.getOrCreateKotlinClass(r1), "multiLinkRoomScope兜底保护逻辑", "null"));
        UltraSettingsManager.b("live_multi_link_check_tools_plugin_before_install", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_link_check_tools_plugin_before_install", Reflection.getOrCreateKotlinClass(r1), "多人场景连麦工具线插件安装前是否先校验", "ranxiongxiong"));
        UltraSettingsManager.b("live_linkmic_online_float_window_dismiss_add_reset_linker_state_params", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_linkmic_online_float_window_dismiss_add_reset_linker_state_params", Reflection.getOrCreateKotlinClass(r1), "关闭直播小窗新增needResetLinkerState参数", "ranxiongxiong"));
        UltraSettingsManager.b("live_xplay_h5_test_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_xplay_h5_test_config", Reflection.getOrCreateKotlinClass(gk1.class), "直播多人场景云游戏H5测试配置", "ranxiongxiong"));
        UltraSettingsManager.b("live_link_opt_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_link_opt_config", Reflection.getOrCreateKotlinClass(i51.class), "开播与链路优化需求开关配置合集", "ranxiongxiong"));
        UltraSettingsManager.b("live_order_sing_upload_image_rule_page_url", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_order_sing_upload_image_rule_page_url", Reflection.getOrCreateKotlinClass(String.class), "你点我唱上传图片规则链接", "ranxiongxiong"));
        UltraSettingsManager.b("live_hour_rank_entrance_air_lynx_schema", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_hour_rank_entrance_air_lynx_schema", Reflection.getOrCreateKotlinClass(String.class), "小时榜入口Lynx Air Schema", "ranxiongxiong"));
        UltraSettingsManager.b("multi_revenue_trace_log_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("multi_revenue_trace_log_enable", Reflection.getOrCreateKotlinClass(r1), "多人营收端监控接入Trace", "ranxiongxiong"));
        UltraSettingsManager.b("webcast_asset_anim_id_map", new com.bytedance.tools.kcp.ultrasettings.runtime.c("webcast_asset_anim_id_map", Reflection.getOrCreateKotlinClass(pe1.a.class), "动态下发的特效ID的集合", "ranxiongxiong"));
        UltraSettingsManager.b("enable_link_plugin_pre_load", new com.bytedance.tools.kcp.ultrasettings.runtime.c("enable_link_plugin_pre_load", Reflection.getOrCreateKotlinClass(r3), "是否开启插件预加载", "ranxiongxiong"));
        UltraSettingsManager.b("live_video_ktv_performance_limit", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_video_ktv_performance_limit", Reflection.getOrCreateKotlinClass(r4), "视频聊天室开启ktv最低机型打分要求", "ranxiongxiong"));
        UltraSettingsManager.b("interact_audience_permission_guarantor_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("interact_audience_permission_guarantor_enable", Reflection.getOrCreateKotlinClass(r1), "观众连线音视频权限释放白名单页面机制开关", "ranxiongxiong"));
        UltraSettingsManager.b("live_party_ktv_update_push_optimize_dict", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_party_ktv_update_push_optimize_dict", Reflection.getOrCreateKotlinClass(nf1.class), "实时合唱选路逻辑优化", "ranxiongxiong"));
        UltraSettingsManager.b("live_toolbar_button_dynamic_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_toolbar_button_dynamic_enable", Reflection.getOrCreateKotlinClass(r1), "toolBar button 入口PK、连线使用 Room 信息", "ranxiongxiong"));
        UltraSettingsManager.b("live_blur_bg_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_blur_bg_opt", Reflection.getOrCreateKotlinClass(s11.class), "高斯模糊背景优化", "ranxiongxiong"));
        UltraSettingsManager.b("live_is_hit_paid_queue_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_is_hit_paid_queue_enable", Reflection.getOrCreateKotlinClass(r1), "是否支持付费队列", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_live_dialog_access_fix", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_live_dialog_access_fix", Reflection.getOrCreateKotlinClass(r1), "ktv点歌台无障碍修复", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_sei_scheduler_switch", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_sei_scheduler_switch", Reflection.getOrCreateKotlinClass(r1), "sei线程调度实验开关", "ranxiongxiong"));
        UltraSettingsManager.b("live_reset_dynamic_from_audience", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_reset_dynamic_from_audience", Reflection.getOrCreateKotlinClass(r1), "在LinkMultiControlWidget中重置dynamicFromAudience", "ranxiongxiong"));
        UltraSettingsManager.b("talk_room_fulllink_only_anchor_or_link_guest", new com.bytedance.tools.kcp.ultrasettings.runtime.c("talk_room_fulllink_only_anchor_or_link_guest", Reflection.getOrCreateKotlinClass(r1), "多人场景全链路仅主播/连线嘉宾上报", "ranxiongxiong"));
        UltraSettingsManager.b("live_interact_linkmic_sound_animation_mode", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_interact_linkmic_sound_animation_mode", Reflection.getOrCreateKotlinClass(r3), "声波动效音量优化", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_render_container_memory_leak", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_render_container_memory_leak", Reflection.getOrCreateKotlinClass(r1), "KTV 渲染容器内存泄漏治理", "ranxiongxiong"));
        UltraSettingsManager.b("ktv_opus_push_height", new com.bytedance.tools.kcp.ultrasettings.runtime.c("ktv_opus_push_height", Reflection.getOrCreateKotlinClass(r3), "推流高度", "ranxiongxiong"));
        UltraSettingsManager.b("live_enable_lyric_drop_verify", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_enable_lyric_drop_verify", Reflection.getOrCreateKotlinClass(r1), "是否启用ktv歌词校准功能", "ranxiongxiong"));
        UltraSettingsManager.b("live_enable_team_fight_audio_toolbar", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_enable_team_fight_audio_toolbar", Reflection.getOrCreateKotlinClass(r1), "语音团战toolbar入口开关", "ranxiongxiong"));
        UltraSettingsManager.b("live_interact_xplay_videomixer_planarrender_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_interact_xplay_videomixer_planarrender_enable", Reflection.getOrCreateKotlinClass(r1), "多人场景云游戏自定义合流的平面渲染模式开关", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_component_audience_add_song_limit", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_component_audience_add_song_limit", Reflection.getOrCreateKotlinClass(r3), "K歌组件观众点歌上限", "ranxiongxiong"));
        UltraSettingsManager.b("new_video_link_intercept_close_delay", new com.bytedance.tools.kcp.ultrasettings.runtime.c("new_video_link_intercept_close_delay", Reflection.getOrCreateKotlinClass(r2), "【新视频连线】观众点击关闭房间，兜底延迟5s后，再执行关闭房间操作", "yezhichao"));
        UltraSettingsManager.b("live_ktv_midi_feedback_panel_show_time", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_midi_feedback_panel_show_time", Reflection.getOrCreateKotlinClass(r2), "midi反馈面板展示时间", "ranxiongxiong"));
        UltraSettingsManager.b("live_enable_audience_feedback_in_chat_room", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_enable_audience_feedback_in_chat_room", Reflection.getOrCreateKotlinClass(r1), "直播间聊天室嘉宾侧是否开启反馈入口", "ranxiongxiong"));
        UltraSettingsManager.b("multi_link_pc_horizontal_feed_theme_gone", new com.bytedance.tools.kcp.ultrasettings.runtime.c("multi_link_pc_horizontal_feed_theme_gone", Reflection.getOrCreateKotlinClass(r1), "横屏开播预览流不展示主题背景临时解决播放器对齐问题", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_midi_sei_receiver_interval", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_midi_sei_receiver_interval", Reflection.getOrCreateKotlinClass(r2), "midi sei接收处理时间", "ranxiongxiong"));
        UltraSettingsManager.b("live_check_linker_list_opt_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_check_linker_list_opt_enable", Reflection.getOrCreateKotlinClass(r1), "check_linkers首次传参优化，默认开启", "ranxiongxiong"));
        UltraSettingsManager.b("live_solo_fix_werid_crash", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_solo_fix_werid_crash", Reflection.getOrCreateKotlinClass(r1), "个唱点歌crash修复开关", "ranxiongxiong"));
        UltraSettingsManager.b("sei_duplicate_removal_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("sei_duplicate_removal_enable", Reflection.getOrCreateKotlinClass(r1), "SEI去重", "ranxiongxiong"));
        UltraSettingsManager.b("live_paid_link_mic_count_down_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_paid_link_mic_count_down_enable", Reflection.getOrCreateKotlinClass(r1), "付费连麦倒计时兜底开关", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_score_range", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_score_range", Reflection.getOrCreateKotlinClass(r3), "K歌命中描色", "ranxiongxiong"));
        UltraSettingsManager.b("live_room_call_link_guide_url", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_room_call_link_guide_url", Reflection.getOrCreateKotlinClass(String.class), "召集连线的动画", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_gray_video_fallback", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_gray_video_fallback", Reflection.getOrCreateKotlinClass(r1), "灰度视频互斥开关", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_rt_chorus_live_icon_url", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_rt_chorus_live_icon_url", Reflection.getOrCreateKotlinClass(String.class), "实时合唱分发演唱中icon url", "ranxiongxiong"));
        UltraSettingsManager.b("multi_link_hamlet_avtar_first_empty_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("multi_link_hamlet_avtar_first_empty_opt", Reflection.getOrCreateKotlinClass(r1), "Hamlet 1v8第一个空麦位layer改造，防止首刷跳变", "ranxiongxiong"));
        UltraSettingsManager.b("live_video_mix_invalid_sei_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_video_mix_invalid_sei_enable", Reflection.getOrCreateKotlinClass(r1), "是否允许RTC客户端合流时候刷新sei配置", "ranxiongxiong"));
        UltraSettingsManager.b("live_enable_audio_chat_room_auto_join", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_enable_audio_chat_room_auto_join", Reflection.getOrCreateKotlinClass(r1), "语音聊天室是否开播自动joinChannel", "ranxiongxiong"));
        UltraSettingsManager.b("voice_spatial_audio_position_interval", new com.bytedance.tools.kcp.ultrasettings.runtime.c("voice_spatial_audio_position_interval", Reflection.getOrCreateKotlinClass(r3), "语音场景空间音频位置间隔", "ranxiongxiong"));
        UltraSettingsManager.b("live_score_view_expend_size_dp", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_score_view_expend_size_dp", Reflection.getOrCreateKotlinClass(r3), "礼物计值点击热区大小调整", "ranxiongxiong"));
        UltraSettingsManager.b("video_equal_switch_frequncy_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("video_equal_switch_frequncy_config", Reflection.getOrCreateKotlinClass(InteractFrequencyConfig.class), "平权浮窗布局切换频控", "ranxiongxiong"));
        UltraSettingsManager.b("live_room_battle_voice_wave_mix_fix", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_room_battle_voice_wave_mix_fix", Reflection.getOrCreateKotlinClass(r1), "厅战合流说话状态修复", "ranxiongxiong"));
        UltraSettingsManager.b("live_video_room_self_guide_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_video_room_self_guide_enable", Reflection.getOrCreateKotlinClass(r1), "视频聊天室麦位自见开关", "ranxiongxiong"));
        UltraSettingsManager.b("live_real_time_chorus_push_stream_fix", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_real_time_chorus_push_stream_fix", Reflection.getOrCreateKotlinClass(r1), "实时合唱推流时序问题调整", "liaonanshan"));
        UltraSettingsManager.b("live_voice_ktv_performance_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_voice_ktv_performance_opt", Reflection.getOrCreateKotlinClass(r3), "语音ktv性能优化", "ranxiongxiong"));
        UltraSettingsManager.b("live_link_mic_guide_audience_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_link_mic_guide_audience_enable", Reflection.getOrCreateKotlinClass(r1), "语音直播间观众侧上麦引导开关", "ranxiongxiong"));
        UltraSettingsManager.b("interact_check_top_activity_when_target_page_hide", new com.bytedance.tools.kcp.ultrasettings.runtime.c("interact_check_top_activity_when_target_page_hide", Reflection.getOrCreateKotlinClass(r1), "fragment detatch的时候检查top activity", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_sound_card_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_sound_card_enable", Reflection.getOrCreateKotlinClass(r1), "k歌声卡模式开关", "ranxiongxiong"));
        UltraSettingsManager.b("live_interact_xplay_mix_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_interact_xplay_mix_config", b, "描述", "ranxiongxiong"));
        UltraSettingsManager.b("live_video_avatar_bg_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_video_avatar_bg_config", Reflection.getOrCreateKotlinClass(VideoDigitAvatarBgConfig.class), "视频聊天室avatar虚拟形象背景图配置", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_video_miss_fix", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_video_miss_fix", Reflection.getOrCreateKotlinClass(r1), "视频不可见修复，视频不可见修复", "ranxiongxiong"));
        UltraSettingsManager.b("live_load_ktv_component_entrance_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_load_ktv_component_entrance_enable", Reflection.getOrCreateKotlinClass(r1), "直播K歌主播侧加载K歌组件入口开关", "ranxiongxiong"));
        UltraSettingsManager.b("live_enable_anchor_chat_opt_group", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_enable_anchor_chat_opt_group", Reflection.getOrCreateKotlinClass(r3), "双人聊主播端优化", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_first_request_lazy", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_first_request_lazy", Reflection.getOrCreateKotlinClass(r1), "点歌台首次打开，数据使用缓存", "ranxiongxiong"));
        UltraSettingsManager.b("live_multi_link_enter_room_ui_first_frame_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_link_enter_room_ui_first_frame_opt", Reflection.getOrCreateKotlinClass(lb1.class), "直播多人场景进房UI首帧优化", "ranxiongxiong"));
        UltraSettingsManager.b("live_chorus_player_advance_init", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_chorus_player_advance_init", Reflection.getOrCreateKotlinClass(r1), "合唱播放器提前初始化", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_ping_sei_frequency_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_ping_sei_frequency_opt", Reflection.getOrCreateKotlinClass(r2), "ktv sei 频率优化", "ranxiongxiong"));
        UltraSettingsManager.b("live_multi_chorus_black_frame_fix", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_chorus_black_frame_fix", Reflection.getOrCreateKotlinClass(r1), "语音场景一起唱黑帧问题修复", "guoyunguang"));
        UltraSettingsManager.b("ktv_mv_url_expire_time", new com.bytedance.tools.kcp.ultrasettings.runtime.c("ktv_mv_url_expire_time", Reflection.getOrCreateKotlinClass(r3), "mv url 过期阈值", "ranxiongxiong"));
        UltraSettingsManager.b("live_break_page_link_direact", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_break_page_link_direact", Reflection.getOrCreateKotlinClass(r1), "连线结束页点击去连线自动申请", "ranxiongxiong"));
        UltraSettingsManager.b("live_linkmic_announce", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_linkmic_announce", Reflection.getOrCreateKotlinClass(y01.class), "多人场景聊天室公告栏文字透传实验", "ranxiongxiong"));
        UltraSettingsManager.b("live_multilink_dynamic_enable_canvas", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multilink_dynamic_enable_canvas", Reflection.getOrCreateKotlinClass(r1), "lynx麦位预览流加载优化(wormhole预拉流)", "ranxiongxiong"));
        UltraSettingsManager.b("live_audio_station_text_container_pubic_screen_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_audio_station_text_container_pubic_screen_opt", Reflection.getOrCreateKotlinClass(r1), "语音电台文字容器公屏调整", "ranxiongxiong"));
        UltraSettingsManager.b("live_multi_link_lynx_seat_preview_room_info", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_link_lynx_seat_preview_room_info", Reflection.getOrCreateKotlinClass(r1), "lynx麦位预览流开启事件带上room信息", "ranxiongxiong"));
        UltraSettingsManager.b("live_player_view_layout_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_player_view_layout_config", c, "live_player_view_layout_config", "ranxiongxiong"));
        UltraSettingsManager.b("live_solo_ktv_edit_volume_scale", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_solo_ktv_edit_volume_scale", Reflection.getOrCreateKotlinClass(r4), "个人练歌房编辑页音量放大倍数", "ranxiongxiong"));
        UltraSettingsManager.b("separate_linkmic_subscribe_icon", new com.bytedance.tools.kcp.ultrasettings.runtime.c("separate_linkmic_subscribe_icon", Reflection.getOrCreateKotlinClass(r3), "会员是否使用独立勋章", "ranxiongxiong"));
        UltraSettingsManager.b("live_enable_linkmic_apply_float_window", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_enable_linkmic_apply_float_window", Reflection.getOrCreateKotlinClass(r1), "多人连线等待小窗是否全量", "ranxiongxiong"));
        UltraSettingsManager.b("live_enable_interact_activity_entry", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_enable_interact_activity_entry", Reflection.getOrCreateKotlinClass(r1), "连线活动玩法入口开关", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_widget_sync_load", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_widget_sync_load", Reflection.getOrCreateKotlinClass(r1), "是否同步加载ktv widget", "ranxiongxiong"));
        UltraSettingsManager.b("disable_lynx_debug_info", new com.bytedance.tools.kcp.ultrasettings.runtime.c("disable_lynx_debug_info", Reflection.getOrCreateKotlinClass(r1), "关闭Lynx动态化容器Debug信息展示", "chenweizhuo"));
        UltraSettingsManager.b("video_talk_audio_stream_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("video_talk_audio_stream_enable", Reflection.getOrCreateKotlinClass(r1), "视频聊天室语音上麦合流开关", "ranxiongxiong"));
        UltraSettingsManager.b("live_paid_queue_permit_button_refresh_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_paid_queue_permit_button_refresh_enable", Reflection.getOrCreateKotlinClass(r1), "双人聊主播同意申请时刷新整个申请列表", "ranxiongxiong"));
        UltraSettingsManager.b("link_multi_seat_widget_random_emoji_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("link_multi_seat_widget_random_emoji_enable", Reflection.getOrCreateKotlinClass(r1), "随机表情开关", "ranxiongxiong"));
        UltraSettingsManager.b("solo_ktv_timeline_atmos_bitmap_scale", new com.bytedance.tools.kcp.ultrasettings.runtime.c("solo_ktv_timeline_atmos_bitmap_scale", Reflection.getOrCreateKotlinClass(r4), "练唱预览合成", "ranxiongxiong"));
        UltraSettingsManager.b("live_adventure_call_delay", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_adventure_call_delay", Reflection.getOrCreateKotlinClass(r2), "奇遇通话延迟进房时间", "ranxiongxiong"));
        UltraSettingsManager.b("live_anim_be_invited", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_anim_be_invited", Reflection.getOrCreateKotlinClass(String.class), "邀请面板动画", "ranxiongxiong"));
        UltraSettingsManager.b("live_audio_subtitle_ui_widget_double_check", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_audio_subtitle_ui_widget_double_check", Reflection.getOrCreateKotlinClass(r1), "进房后待LinkmicSubtitleUIWidget被加载后再触发一次字幕展示逻辑", "ranxiongxiong"));
        UltraSettingsManager.b("live_sei_update_interval", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_sei_update_interval", Reflection.getOrCreateKotlinClass(r2), "sei更新时长", "ranxiongxiong"));
        UltraSettingsManager.b("live_multi_link_init_smooth_view_timeout_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_link_init_smooth_view_timeout_opt", Reflection.getOrCreateKotlinClass(r1), "多人场景initSmoothView超时兜底优化", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_stop_bgm_trace_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_stop_bgm_trace_opt", Reflection.getOrCreateKotlinClass(r1), "正常ktv演唱结束时将setBgm设置为null时机提前", "ranxiongxiong"));
        UltraSettingsManager.b("live_voice_room_link_mic_scene_list", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_voice_room_link_mic_scene_list", d, "语音房连麦场景列表", "ranxiongxiong"));
        UltraSettingsManager.b("live_multi_link_lynx_seat_diff_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_link_lynx_seat_diff_opt", Reflection.getOrCreateKotlinClass(r1), "lynx麦位去重逻辑优化)", "ranxiongxiong"));
        UltraSettingsManager.b("live_themed_competition", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_themed_competition", Reflection.getOrCreateKotlinClass(LiveThemedCompetitionSchemaConfig.class), "主题比赛Lynx页面schema", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_anchor_add_song_status_delay", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_anchor_add_song_status_delay", Reflection.getOrCreateKotlinClass(r3), "直播歌房主播演唱一定时长后上报状态信息（用于歌房续播）, 单位秒", "ranxiongxiong"));
        UltraSettingsManager.b("live_saas_intercept_order_song", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_saas_intercept_order_song", Reflection.getOrCreateKotlinClass(r1), "Saas拦截你点我玩法开关", "ranxiongxiong"));
        UltraSettingsManager.b("live_hamlet_external_render_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_hamlet_external_render_config", Reflection.getOrCreateKotlinClass(HamletExternalRenderConfig.class), "hamlet avatar后置渲染配置", "ranxiongxiong"));
        UltraSettingsManager.b("live_rt_chorus_rts_midi_score_fix", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_rt_chorus_rts_midi_score_fix", Reflection.getOrCreateKotlinClass(r1), "合唱派对主播，未加入合唱，未转发midi评分修复", "ranxiongxiong"));
        UltraSettingsManager.b("ktv_max_downloader_count", new com.bytedance.tools.kcp.ultrasettings.runtime.c("ktv_max_downloader_count", Reflection.getOrCreateKotlinClass(r3), "K歌物料最大下载器个数", "ranxiongxiong"));
        UltraSettingsManager.b("digg_tap_map_interval", new com.bytedance.tools.kcp.ultrasettings.runtime.c("digg_tap_map_interval", Reflection.getOrCreateKotlinClass(r2), "点赞触发间隔 (ms)", "ranxiongxiong"));
        UltraSettingsManager.b("live_paid_linkmic_integration_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_paid_linkmic_integration_enable", Reflection.getOrCreateKotlinClass(r1), "付费连麦整合开关", "ranxiongxiong"));
        UltraSettingsManager.b("live_video_talk_use_static_background", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_video_talk_use_static_background", Reflection.getOrCreateKotlinClass(r1), "视频聊天室直播低端机型是否使用静态背景", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_camera_client_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_camera_client_enable", Reflection.getOrCreateKotlinClass(r1), "KTV摄像头端上开关", "ranxiongxiong"));
        UltraSettingsManager.b("voice_room_live_core_single_view_mode_switch", new com.bytedance.tools.kcp.ultrasettings.runtime.c("voice_room_live_core_single_view_mode_switch", Reflection.getOrCreateKotlinClass(r1), "语音房RTC是否开启单View模式", "ranxiongxiong"));
        UltraSettingsManager.b("live_talk_room_support_room_data_sync_for_api", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_talk_room_support_room_data_sync_for_api", Reflection.getOrCreateKotlinClass(r1), "聊天室api是否使用本地数据同步麦位列表", "ranxiongxiong"));
        UltraSettingsManager.b("live_core_opt_disable_local_render_frame", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_core_opt_disable_local_render_frame", Reflection.getOrCreateKotlinClass(r1), "语音房停止冗余的mixFrame调用", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_sei_cache_max_capacity", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_sei_cache_max_capacity", Reflection.getOrCreateKotlinClass(r3), "sei缓存池最大容量", "ranxiongxiong"));
        UltraSettingsManager.b("live_big_party_enable_fast_match", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_big_party_enable_fast_match", Reflection.getOrCreateKotlinClass(r1), "是否开启视频聊天室快速匹配", "ranxiongxiong"));
        UltraSettingsManager.b("ktv_change_music_diff_update", new com.bytedance.tools.kcp.ultrasettings.runtime.c("ktv_change_music_diff_update", Reflection.getOrCreateKotlinClass(r1), "K歌改变播放列表增量刷新方式", "ranxiongxiong"));
        UltraSettingsManager.b("live_pc_landscape_can_show_empty_mic_seat", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_pc_landscape_can_show_empty_mic_seat", Reflection.getOrCreateKotlinClass(r1), "PC横屏开播观众连线是否展示空麦位", "ranxiongxiong"));
        UltraSettingsManager.b("live_video_talk_screen_adapt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_video_talk_screen_adapt", Reflection.getOrCreateKotlinClass(r1), "视频聊天室屏幕适配开关", "ranxiongxiong"));
        UltraSettingsManager.b("live_link_user_info_center_attach_repeat_fix", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_link_user_info_center_attach_repeat_fix", Reflection.getOrCreateKotlinClass(r1), "LinkUserInfoCenter attach去重", "ranxiongxiong"));
        UltraSettingsManager.b("ktv_chorus_open_single_view_mode_default", new com.bytedance.tools.kcp.ultrasettings.runtime.c("ktv_chorus_open_single_view_mode_default", Reflection.getOrCreateKotlinClass(r1), "实时合唱是否默认开启单view ", "ranxiongxiong"));
        UltraSettingsManager.b("live_talk_room_toolbar_icon_optimize", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_talk_room_toolbar_icon_optimize", Reflection.getOrCreateKotlinClass(bk1.class), "是否替换聊天室lottie动画", "ranxiongxiong"));
        UltraSettingsManager.b("multi_link_seat_item_differ_bugfix", new com.bytedance.tools.kcp.ultrasettings.runtime.c("multi_link_seat_item_differ_bugfix", Reflection.getOrCreateKotlinClass(r1), "多人ItemDiffer Bugfix 改造避免频繁调用requestLayout", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_config", Reflection.getOrCreateKotlinClass(u41.class), "主播端K歌控制开关", "ranxiongxiong"));
        UltraSettingsManager.b("live_shake_match_config_pix", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_shake_match_config_pix", Reflection.getOrCreateKotlinClass(dh1.class), "缘分匹配摇一摇", "ranxiongxiong"));
        UltraSettingsManager.b("new_video_link_lynx_stream_info", new com.bytedance.tools.kcp.ultrasettings.runtime.c("new_video_link_lynx_stream_info", Reflection.getOrCreateKotlinClass(r1), "【新视频连线】音视频回调上报Lynx", "yezhichao"));
        UltraSettingsManager.b("live_flymic_interact_switch", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_flymic_interact_switch", Reflection.getOrCreateKotlinClass(r1), "飞麦礼物允许麦上互送", "ranxiongxiong"));
        UltraSettingsManager.b("multi_link_seat_recyclerview_fixed_size_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("multi_link_seat_recyclerview_fixed_size_opt", Reflection.getOrCreateKotlinClass(r1), "多人场景麦位RVfixedsize改造避免频繁调用requestLayout", "ranxiongxiong"));
        UltraSettingsManager.b("solo_ktv_edit_default_voice_align", new com.bytedance.tools.kcp.ultrasettings.runtime.c("solo_ktv_edit_default_voice_align", Reflection.getOrCreateKotlinClass(r3), "练歌房编辑页默认人声偏移", "ranxiongxiong"));
        UltraSettingsManager.b("live_oppo_echo_setting_guide_lynx", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_oppo_echo_setting_guide_lynx", Reflection.getOrCreateKotlinClass(cd1.class), "OPPO耳返设置引导Lynx url复合字段", "ranxiongxiong"));
        UltraSettingsManager.b("live_interact_downlink_audio_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_interact_downlink_audio_config", e, "多人下行音频选路配置", "ranxiongxiong"));
        UltraSettingsManager.b("live_video_self_discipline_stack_monitor_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_video_self_discipline_stack_monitor_enable", Reflection.getOrCreateKotlinClass(r1), "自律模式开启路径监听开关", "ranxiongxiong"));
        UltraSettingsManager.b("live_interact_audio_capture_background_guest", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_interact_audio_capture_background_guest", Reflection.getOrCreateKotlinClass(r1), "嘉宾侧退后台是否采集音频", "ranxiongxiong"));
        UltraSettingsManager.b("live_broadcast_game_float_window_bugfix", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_broadcast_game_float_window_bugfix", Reflection.getOrCreateKotlinClass(r1), "多人场景一键开游戏主播画面悬浮窗问题修复", "huangjielin.0712"));
        UltraSettingsManager.b("live_multilink_modular_open_setting", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multilink_modular_open_setting", Reflection.getOrCreateKotlinClass(pb1.class), "多人场景模块化开关配置", "ranxiongxiong"));
        UltraSettingsManager.b("live_video_ktv_performance_anim_limit", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_video_ktv_performance_anim_limit", Reflection.getOrCreateKotlinClass(r4), "视频聊天室开启ktv动画降级打分", "ranxiongxiong"));
        UltraSettingsManager.b("live_multi_link_early_init_rtc_with_apply_resp", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_link_early_init_rtc_with_apply_resp", Reflection.getOrCreateKotlinClass(r1), "多人场景Apply回包RTC提前初始化", "ranxiongxiong"));
        UltraSettingsManager.b("ktv_order_song_dialog_load_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("ktv_order_song_dialog_load_opt", Reflection.getOrCreateKotlinClass(r1), "K歌点歌台加载优化", "ranxiongxiong"));
        UltraSettingsManager.b("live_talk_roomt_enable_restrat_audio_capture_when_resume", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_talk_roomt_enable_restrat_audio_capture_when_resume", Reflection.getOrCreateKotlinClass(r1), "是否在退后台返回前台的时候重启audiocatpure", "ranxiongxiong"));
        UltraSettingsManager.b("k歌组件加入waiting态", new com.bytedance.tools.kcp.ultrasettings.runtime.c("k歌组件加入waiting态", Reflection.getOrCreateKotlinClass(r1), "k歌组件加入waiting态", "ranxiongxiong"));
        UltraSettingsManager.b("live_multi_revenue_play_duration", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_revenue_play_duration", Reflection.getOrCreateKotlinClass(r3), "多人营收玩法强插时长", "ranxiongxiong"));
        UltraSettingsManager.b("live_switch_guest_send_gift", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_switch_guest_send_gift", Reflection.getOrCreateKotlinClass(r1), "允许观众给嘉宾送礼规则页按钮开关", "ranxiongxiong"));
        UltraSettingsManager.b("voice_chat_room_update_querier_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("voice_chat_room_update_querier_opt", Reflection.getOrCreateKotlinClass(r1), "语音场景切换更新主播合流的Querier", "ranxiongxiong"));
        UltraSettingsManager.b("live_beauty_preview_with_individual_view", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_beauty_preview_with_individual_view", Reflection.getOrCreateKotlinClass(r1), "美颜面板是否使用独立的View进行预览", "ranxiongxiong"));
        UltraSettingsManager.b("live_linkmic_voice_wave_enhance_style", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_linkmic_voice_wave_enhance_style", Reflection.getOrCreateKotlinClass(r3), "连麦语音声波配置", "ranxiongxiong"));
        UltraSettingsManager.b("live_guest_contribute_list_url", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_guest_contribute_list_url", Reflection.getOrCreateKotlinClass(String.class), "观众连线嘉宾贡献榜lynx url", "ranxiongxiong"));
        UltraSettingsManager.b("live_flymic_video_score_limits", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_flymic_video_score_limits", Reflection.getOrCreateKotlinClass(o5.class), "飞麦礼物视频特效准入开关", "ranxiongxiong"));
        UltraSettingsManager.b("voice_chat_room_stream_mixer_user_thread_local_map", new com.bytedance.tools.kcp.ultrasettings.runtime.c("voice_chat_room_stream_mixer_user_thread_local_map", f, "语音聊天室主播合流时，使用线程本地的map去计算sei的场景", "ranxiongxiong"));
        UltraSettingsManager.b("multi_link_audience_rtc_render_yuv_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("multi_link_audience_rtc_render_yuv_opt", Reflection.getOrCreateKotlinClass(r1), "多人场景嘉宾侧RTC渲染YUV优化", "ranxiongxiong"));
        UltraSettingsManager.b("live_solo_ktv_exit_live_room_keep_solo_ktv_activity", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_solo_ktv_exit_live_room_keep_solo_ktv_activity", Reflection.getOrCreateKotlinClass(r1), "直播间退房保留个唱页", "ranxiongxiong"));
        UltraSettingsManager.b("live_link_panel_honors_show_list", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_link_panel_honors_show_list", g, "荣誉勋章展示列表,多人和连屏面板部分使用", "changjianfei"));
        UltraSettingsManager.b("live_radio_widget_check_show_player", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_radio_widget_check_show_player", Reflection.getOrCreateKotlinClass(r1), "RadioWidget是否检查ShowPlayer隐藏自己", "ranxiongxiong"));
        UltraSettingsManager.b("switch_camera_frequncy_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("switch_camera_frequncy_config", Reflection.getOrCreateKotlinClass(us1.c.class), "开启摄像头频控配置", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_multi_chorus_sound_wave_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_multi_chorus_sound_wave_opt", Reflection.getOrCreateKotlinClass(r1), "一起唱麦位声波优化", "ranxiongxiong"));
        UltraSettingsManager.b("live_video_guest_battle_open", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_video_guest_battle_open", Reflection.getOrCreateKotlinClass(r1), "视频聊天室嘉宾大作战兜底开关", "ranxiongxiong"));
        UltraSettingsManager.b("live_solo_ktv_ui_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_solo_ktv_ui_config", Reflection.getOrCreateKotlinClass(mh1.class), "soloktv ui配置", "ranxiongxiong"));
        UltraSettingsManager.b("live_team_fight_open_panel_lynx", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_team_fight_open_panel_lynx", Reflection.getOrCreateKotlinClass(zh1.class), "团战灵活组队Lynx配置", "ranxiongxiong"));
        UltraSettingsManager.b("live_feed_view_support_layer_element_update", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_feed_view_support_layer_element_update", Reflection.getOrCreateKotlinClass(r1), "预览流支持动态化更新插入元素", "ranxiongxiong"));
        UltraSettingsManager.b("multi_anchor_leave_msg_opt_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("multi_anchor_leave_msg_opt_enable", Reflection.getOrCreateKotlinClass(r1), "多人主播连线消费leave消息不请求list", "ranxiongxiong"));
        UltraSettingsManager.b("enable_ktv_preview_song", new com.bytedance.tools.kcp.ultrasettings.runtime.c("enable_ktv_preview_song", Reflection.getOrCreateKotlinClass(r1), "是否开启KTV冷启歌单", "ranxiongxiong"));
        UltraSettingsManager.b("multi_link_base_common_window_ui_layout_support_list", new com.bytedance.tools.kcp.ultrasettings.runtime.c("multi_link_base_common_window_ui_layout_support_list", h, "支持使用通用布局的uiLayout列表", "ranxiongxiong"));
        UltraSettingsManager.b("live_toolbar_panel_linkmic_game_url", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_toolbar_panel_linkmic_game_url", Reflection.getOrCreateKotlinClass(String.class), "连线玩法面板url", "ranxiongxinog"));
        UltraSettingsManager.b("live_ktv_update_progress_interval", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_update_progress_interval", Reflection.getOrCreateKotlinClass(r2), "ktv更新视图进度间隔", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_midi_animator_degrade", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_midi_animator_degrade", Reflection.getOrCreateKotlinClass(r3), "KTV动画帧率降级", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_room_avatar_performance_limit", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_room_avatar_performance_limit", Reflection.getOrCreateKotlinClass(r4), "KTV模式开启avatar演唱最低机型打分要求", "ranxiongxiong"));
        UltraSettingsManager.b("multi_link_bluetooth_permission", new com.bytedance.tools.kcp.ultrasettings.runtime.c("multi_link_bluetooth_permission", Reflection.getOrCreateKotlinClass(r1), "多人场景蓝牙权限", "ranxiongxiong"));
        UltraSettingsManager.b("live_room_battle_enable_rtc_mcu", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_room_battle_enable_rtc_mcu", Reflection.getOrCreateKotlinClass(r1), "跨房厅战使用mcu方案", "ranxiongxiong"));
        UltraSettingsManager.b("live_spatial_audio_speak_position_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_spatial_audio_speak_position_config", Reflection.getOrCreateKotlinClass(w0.class), "不同场景下嘉宾和主播在空间音频中的发声位置和朝向信息", "ranxiongxiong"));
        UltraSettingsManager.b("live_enable_loop_gift_score_animation", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_enable_loop_gift_score_animation", Reflection.getOrCreateKotlinClass(r1), "启用礼物分值循环动画", "ranxiongxiong"));
        UltraSettingsManager.b("link_room_battle_support_scene", new com.bytedance.tools.kcp.ultrasettings.runtime.c("link_room_battle_support_scene", i, "厅战入口控制", "ranxiongxiong"));
        UltraSettingsManager.b("live_order_sing_mv_enable_seek", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_order_sing_mv_enable_seek", Reflection.getOrCreateKotlinClass(r1), "你点我唱mv seek 开关", "ranxiongxiong"));
        UltraSettingsManager.b("live_enable_video_chat_room_cast_native_app", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_enable_video_chat_room_cast_native_app", Reflection.getOrCreateKotlinClass(r1), "聊天室场景是否支持小程序投屏", "ranxiongxiong"));
        UltraSettingsManager.b("live_voice_chat_room_switch_scene_select_theme_balck_list", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_voice_chat_room_switch_scene_select_theme_balck_list", j, "语音聊天室切换场景请求select_theme UILayout黑名单", "ranxiongxiong"));
        UltraSettingsManager.b("live_audio_live_webp", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_audio_live_webp", Reflection.getOrCreateKotlinClass(String.class), "语音直播间动效资源", "ranxiongxiong"));
        UltraSettingsManager.b("live_push_stream_size_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_push_stream_size_opt", Reflection.getOrCreateKotlinClass(r1), "推流尺寸优化", "ranxiongxiong"));
        UltraSettingsManager.b("live_mcu_fallback_protect_time", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_mcu_fallback_protect_time", Reflection.getOrCreateKotlinClass(r3), "跨房厅战MCU公共流拉流失败兜底超时时间", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_component_anchor_add_song_limit", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_component_anchor_add_song_limit", Reflection.getOrCreateKotlinClass(r3), "K歌组件主播点歌上限", "ranxiongxiong"));
        UltraSettingsManager.b("live_pc_audio_chorus_business_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_pc_audio_chorus_business_config", Reflection.getOrCreateKotlinClass(x61.class), "pc合唱延迟配置", "zhanghao"));
        UltraSettingsManager.b("live_new_ktv_gold_room_bg", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_new_ktv_gold_room_bg", Reflection.getOrCreateKotlinClass(v41.class), "ktv改版下金牌歌房背景", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_midi_hit_combo_target", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_midi_hit_combo_target", Reflection.getOrCreateKotlinClass(r3), "midi完美连击目标数", "ranxiongxiong"));
        UltraSettingsManager.b("live_shake_enable_galileo", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_shake_enable_galileo", Reflection.getOrCreateKotlinClass(r3), "摇一摇接入伽利略", "ranxiongxiong"));
        UltraSettingsManager.b("live_multi_update_linkmic_status_jsb_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_update_linkmic_status_jsb_opt", Reflection.getOrCreateKotlinClass(r1), "updateLinkmicStatus注册优化(由业务AnnieCard自己注册)", "ranxiongxiong"));
        UltraSettingsManager.b("live_enable_control_client_mix_stream", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_enable_control_client_mix_stream", Reflection.getOrCreateKotlinClass(r1), "是否支持配置端上选择合流方式", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_component_midi_sense_enhance", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_component_midi_sense_enhance", Reflection.getOrCreateKotlinClass(r3), "k歌组件音游感midi", "ranxiongxiong"));
        UltraSettingsManager.b("live_multi_scene_enter_room_log", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_scene_enter_room_log", Reflection.getOrCreateKotlinClass(r1), "多人场景进房上报埋点", "ranxiongxiong"));
        UltraSettingsManager.b("live_device_model_overall_score", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_device_model_overall_score", Reflection.getOrCreateKotlinClass(r4), "针对观众端：观众当前机型的综合打分", "ranxiongxiong"));
        UltraSettingsManager.b("live_interact_amaz_gift_ban", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_interact_amaz_gift_ban", Reflection.getOrCreateKotlinClass(r1), "互动礼物抖Lite屏蔽开关", "ranxiongxiong"));
        UltraSettingsManager.b("live_pause_resume_to_quickly_interval", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_pause_resume_to_quickly_interval", Reflection.getOrCreateKotlinClass(r3), "退后台回前台过快判断时间", "null"));
        UltraSettingsManager.b("live_chat_room_tune_context_init_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_chat_room_tune_context_init_opt", Reflection.getOrCreateKotlinClass(r1), "聊天室K歌调音组件初始化时序调整", "ranxiongxiong"));
        UltraSettingsManager.b("live_audio_anchor_info_update_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_audio_anchor_info_update_config", Reflection.getOrCreateKotlinClass(r1), "语音聊天室1V8，主播信息更新回调", "ranxiongxiong"));
        UltraSettingsManager.b("interact_talk_invite_friends_interval", new com.bytedance.tools.kcp.ultrasettings.runtime.c("interact_talk_invite_friends_interval", Reflection.getOrCreateKotlinClass(r3), "聊天室强触达两次邀请同一用户最短间隔", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_leave_lottery_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_leave_lottery_enable", Reflection.getOrCreateKotlinClass(r1), "福袋拦截器开关", "ranxiongxiong"));
        UltraSettingsManager.b("live_multi_link_admin_fanticket_show_bugfix", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_link_admin_fanticket_show_bugfix", Reflection.getOrCreateKotlinClass(r1), "修复管理员礼物计值不展示真实值问题", "ranxiongxiong"));
        UltraSettingsManager.b("live_linkmic_leave_page_v2_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_linkmic_leave_page_v2_config", k, "多人连线结束页样式配置", "ranxiongxiong"));
        UltraSettingsManager.b("live_link_json_operation_trans_to_io", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_link_json_operation_trans_to_io", Reflection.getOrCreateKotlinClass(r1), "直播连线json操作放到io线程优化", "ranxiongxiong"));
        UltraSettingsManager.b("live_voice_ktv_feed_vh_pause_fix", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_voice_ktv_feed_vh_pause_fix", Reflection.getOrCreateKotlinClass(r1), "语音Ktv预览流VH pause修复开关", "ranxiongxiong"));
        UltraSettingsManager.b("live_multi_order_sing_audio_entrance_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_order_sing_audio_entrance_enable", Reflection.getOrCreateKotlinClass(r1), "你点我唱（点唱厅）主播端AB", "ranxiongxiong"));
        UltraSettingsManager.b("live_is_host_kt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_is_host_kt", Reflection.getOrCreateKotlinClass(r1), "直播isHostKt判断兜底回退开开关", "wuzhixin.jensen"));
        UltraSettingsManager.b("live_interact_xplay_clean_screen_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_interact_xplay_clean_screen_config", Reflection.getOrCreateKotlinClass(rs1.a.class), "云游戏弹幕玩法清屏配置", "ranxiongxiong"));
        UltraSettingsManager.b("live_multi_link_ktv_prohibit_hot_single_rank", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_link_ktv_prohibit_hot_single_rank", Reflection.getOrCreateKotlinClass(r1), "Saas禁止热度面板跳转榜单", "ranxiongxiong"));
        UltraSettingsManager.b("live_chat_channel_audio_mix_default_volume", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_chat_channel_audio_mix_default_volume", Reflection.getOrCreateKotlinClass(r3), "频道房边看边聊直播音频托管默认音量", "ranxiongxiong"));
        UltraSettingsManager.b("multi_link_customize_stream_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("multi_link_customize_stream_config", Reflection.getOrCreateKotlinClass(jb1.class), "多人场景语音聊天室素材流配置", "zhanghao"));
        UltraSettingsManager.b("live_ktv_music_beat_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_music_beat_enable", Reflection.getOrCreateKotlinClass(r1), "你点我唱2d声波能力", "ranxiongxiong"));
        UltraSettingsManager.b("live_disable_rtc_sei_for_multi_chorus", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_disable_rtc_sei_for_multi_chorus", Reflection.getOrCreateKotlinClass(r1), "一起唱在语音场景关闭替换黑帧SEI优化", "ranxiongxiong"));
        UltraSettingsManager.b("live_spatial_audio_listener_position_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_spatial_audio_listener_position_config", Reflection.getOrCreateKotlinClass(u0.class), "不同场景下观众在空间音频中的位置和朝向信息", "ranxiongxiong"));
        UltraSettingsManager.b("live_multi_link_online_status", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_link_online_status", Reflection.getOrCreateKotlinClass(r1), "连线状态增加用户在线判断", "ranxiongxiong"));
        UltraSettingsManager.b("live_enable_team_fight_video_toolbar", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_enable_team_fight_video_toolbar", Reflection.getOrCreateKotlinClass(r1), "视频团战toolbar入口开关", "ranxiongxiong"));
        UltraSettingsManager.b("live_saas_admin_linkmic_play_item_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_saas_admin_linkmic_play_item_config", Reflection.getOrCreateKotlinClass(v71.class), "saas管理员玩法控制入口", "ranxiongxiong"));
        UltraSettingsManager.b("live_video_avatar_client_switch_open", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_video_avatar_client_switch_open", Reflection.getOrCreateKotlinClass(r1), "视频聊天室avatar虚拟形象端上总开关", "ranxiongxiong"));
        UltraSettingsManager.b("new_video_link_live_core_single_view_mode", new com.bytedance.tools.kcp.ultrasettings.runtime.c("new_video_link_live_core_single_view_mode", Reflection.getOrCreateKotlinClass(r1), "【新视频连线】RTC是否开启单View模式", "yezhichao"));
        UltraSettingsManager.b("multi_trace_black_list", new com.bytedance.tools.kcp.ultrasettings.runtime.c("multi_trace_black_list", Reflection.getOrCreateKotlinClass(zb1.class), "多人场景Trace上报黑名单", "ranxiongxiong"));
        UltraSettingsManager.b("live_self_discipline_name_switch", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_self_discipline_name_switch", Reflection.getOrCreateKotlinClass(r3), "自律模式改名实验选择", "ranxiongxiong"));
        UltraSettingsManager.b("vs_room_enable_talkroom", new com.bytedance.tools.kcp.ultrasettings.runtime.c("vs_room_enable_talkroom", Reflection.getOrCreateKotlinClass(r1), "vs直播间聊天室布局加载开关", "ranxiongxiong"));
        UltraSettingsManager.b("live_old_feed_view_add_window_view", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_old_feed_view_add_window_view", Reflection.getOrCreateKotlinClass(r1), "旧版FeedView是否添加WindowView", "huangjielin"));
        UltraSettingsManager.b("live_room_battle_video_remote_mute_fallback", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_room_battle_video_remote_mute_fallback", Reflection.getOrCreateKotlinClass(r1), "视频厅战兜底muteRemoteVideo false", "ranxiongxiong"));
        UltraSettingsManager.b("multi_link_voice_chat_feed_view_enable_dynamic_widget", new com.bytedance.tools.kcp.ultrasettings.runtime.c("multi_link_voice_chat_feed_view_enable_dynamic_widget", Reflection.getOrCreateKotlinClass(r1), "语音聊天室预览流支持加载动态化框架", "ranxiongxiong"));
        UltraSettingsManager.b("link_high_score_list_open_ksong_component_conflix", new com.bytedance.tools.kcp.ultrasettings.runtime.c("link_high_score_list_open_ksong_component_conflix", Reflection.getOrCreateKotlinClass(r1), "多人团战与高分歌单开启K歌组件功能互斥（默认关闭观众演唱）", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_midi_score_debug_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_midi_score_debug_enable", Reflection.getOrCreateKotlinClass(r3), "ktv midi debug view enable", "zengle"));
        UltraSettingsManager.b("live_ktv_music_effect_type", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_music_effect_type", Reflection.getOrCreateKotlinClass(r3), "你点我唱2d声波效果类型", "ranxiongxiong"));
        UltraSettingsManager.b("live_chorus_close_refactor", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_chorus_close_refactor", Reflection.getOrCreateKotlinClass(r1), "合唱关闭逻辑调整", "ranxiongxiong"));
        UltraSettingsManager.b("multi_link_search_feed_view_fix_mob_param", new com.bytedance.tools.kcp.ultrasettings.runtime.c("multi_link_search_feed_view_fix_mob_param", Reflection.getOrCreateKotlinClass(r1), "多人预览流修复mob参数缺失问题", "yezhichao"));
        UltraSettingsManager.b("live_enable_create_new_widget_manager", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_enable_create_new_widget_manager", Reflection.getOrCreateKotlinClass(r1), "复用时是否创建一个新的wm", "ranxiongxiong"));
        UltraSettingsManager.b("live_multi_link_lynx_seat_preview_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_link_lynx_seat_preview_opt", Reflection.getOrCreateKotlinClass(r1), "lynx麦位预览流加载优化", "ranxiongxiong"));
        UltraSettingsManager.b("live_enable_multi_link_apply_early_init_rtc", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_enable_multi_link_apply_early_init_rtc", Reflection.getOrCreateKotlinClass(r1), "多人场景申请链路RTC提前初始化", "ranxiongxiong"));
        UltraSettingsManager.b("video_share_load_video_count", new com.bytedance.tools.kcp.ultrasettings.runtime.c("video_share_load_video_count", Reflection.getOrCreateKotlinClass(r3), "短视频评论视频选择非首页请求个数", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_score_line_time", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_score_line_time", Reflection.getOrCreateKotlinClass(r3), "音高线绘制频率", "ranxiongxiong"));
        UltraSettingsManager.b("live_linkmic_dynamic_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_linkmic_dynamic_config", Reflection.getOrCreateKotlinClass(j51.class), "直播多人场景动态化配置", "ranxiongxiong"));
        UltraSettingsManager.b("pk_trance_log_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("pk_trance_log_enable", Reflection.getOrCreateKotlinClass(r1), "PK端监控接入Trace", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_live_feed_reuse_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_live_feed_reuse_enable", Reflection.getOrCreateKotlinClass(r1), "KTV内外流复用重构开关", "ranxiongxiong"));
        UltraSettingsManager.b("live_enable_apply_permission_dialog", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_enable_apply_permission_dialog", Reflection.getOrCreateKotlinClass(r1), "是否收敛连麦申请权限开关到独立dialog", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_lyric_gl_opt_preload_count", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_lyric_gl_opt_preload_count", Reflection.getOrCreateKotlinClass(r3), "歌词GL预加载个数", "ranxiongxiong"));
        UltraSettingsManager.b("live_solo_ktv_add_song_title", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_solo_ktv_add_song_title", Reflection.getOrCreateKotlinClass(String.class), "个唱点歌台点歌按钮文案替换测试", "ranxiongxiong"));
        UltraSettingsManager.b("live_room_battle_optional_switch", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_room_battle_optional_switch", Reflection.getOrCreateKotlinClass(dg1.class), "厅战重构(产品)需求中一些可选开关", "ranxiongxiong"));
        UltraSettingsManager.b("live_rt_chorus_stage_upgrade_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_rt_chorus_stage_upgrade_opt", Reflection.getOrCreateKotlinClass(r1), "合唱派对舞台升级实验", "ranxiongxiong"));
        UltraSettingsManager.b("live_multi_debounce_mix_stream_interval", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_debounce_mix_stream_interval", Reflection.getOrCreateKotlinClass(r2), "debounce避免瞬时大量合流参数更新【debounce时间，单位毫秒】", "ranxiongxiong"));
        UltraSettingsManager.b("live_enable_rtc_test_env", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_enable_rtc_test_env", Reflection.getOrCreateKotlinClass(r1), "是否开启RTC测试环境", "ranxiongxiong"));
        UltraSettingsManager.b("live_share_video_invitation_sensing_enabled_audience", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_share_video_invitation_sensing_enabled_audience", Reflection.getOrCreateKotlinClass(r3), "观众测一起看新邀请流程开关", "ranxiongxiong"));
        UltraSettingsManager.b("multi_link_feed_view_offset_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("multi_link_feed_view_offset_opt", Reflection.getOrCreateKotlinClass(r1), "预览流偏移布局刷新问题", "ranxiongxiong"));
        UltraSettingsManager.b("live_enable_task_id_local_backup", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_enable_task_id_local_backup", Reflection.getOrCreateKotlinClass(r1), "合唱主唱推流任务id兜底", "ranxiongxiong"));
        UltraSettingsManager.b("live_interact_behavior_click_gap_time", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_interact_behavior_click_gap_time", Reflection.getOrCreateKotlinClass(r3), "连线icon两次点击事件触发间隔", "ranxiongxiong"));
        UltraSettingsManager.b("anchor_pk_update_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("anchor_pk_update_enable", Reflection.getOrCreateKotlinClass(r1), "PK，主播连线，双人聊的SEI更新间隔降低为1s", "ranxiongxiong"));
        UltraSettingsManager.b("interact_open_container_cast_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("interact_open_container_cast_config", l, "描述", "ranxiongxiong"));
        UltraSettingsManager.b("chat_room_enable_change_position", new com.bytedance.tools.kcp.ultrasettings.runtime.c("chat_room_enable_change_position", Reflection.getOrCreateKotlinClass(r1), "聊天室是否开启自由切换麦位", "ranxiongxiong"));
        UltraSettingsManager.b("live_multi_link_update_online_list_background_status_ignore_from", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_link_update_online_list_background_status_ignore_from", Reflection.getOrCreateKotlinClass(r1), "麦上列表更新都会触发后台状态更新", "ranxiongxiong"));
        UltraSettingsManager.b("live_rt_chorus_sync_online_list_change_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_rt_chorus_sync_online_list_change_enable", Reflection.getOrCreateKotlinClass(r1), "合唱派对主播侧同步麦上列表变更", "ranxiongxiong"));
        UltraSettingsManager.b("live_multi_pub_stream_succeed_codes", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_pub_stream_succeed_codes", m, "跨房厅战公共流Result回调，处理为成功的返回码", "ranxiongxiong"));
        UltraSettingsManager.b("live_multilink_layer_enable_nita_inflate", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multilink_layer_enable_nita_inflate", Reflection.getOrCreateKotlinClass(r1), "多人场景layer是否支持Nita优化", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_anchor_sei_data_create_use_newpanel", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_anchor_sei_data_create_use_newpanel", Reflection.getOrCreateKotlinClass(r3), "K歌主播sei构建策略", "ranxiongxiong"));
        UltraSettingsManager.b("new_video_linkmic_permission_guarantor_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("new_video_linkmic_permission_guarantor_enable", Reflection.getOrCreateKotlinClass(r1), "新视频连音视频权限释放白名单页面机制开关", "wuzhixin.jensen"));
        UltraSettingsManager.b("live_lyric_dispose_on_pase", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_lyric_dispose_on_pase", Reflection.getOrCreateKotlinClass(r1), "观众歌词组件在退后台场景需要关闭计时器", "zhanghao"));
        UltraSettingsManager.b("live_video_c_position_client_switch_open", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_video_c_position_client_switch_open", Reflection.getOrCreateKotlinClass(r1), "视频聊天室C位嘉宾放大端上总开关", "ranxiongxiong"));
        UltraSettingsManager.b("live_enable_guest_honor_entry", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_enable_guest_honor_entry", Reflection.getOrCreateKotlinClass(r1), "是否开启嘉宾荣誉入口", "ranxiongxiong"));
        UltraSettingsManager.b("link_intercept_disposed_rooms", new com.bytedance.tools.kcp.ultrasettings.runtime.c("link_intercept_disposed_rooms", Reflection.getOrCreateKotlinClass(r1), "拦截已停止的房间的连麦初始化过程（风险控制用）", "ranxiongxiong"));
        UltraSettingsManager.b("live_multi_link_early_init_rtc_with_invite_im", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_link_early_init_rtc_with_invite_im", Reflection.getOrCreateKotlinClass(r1), "多人场景邀请消息RTC提前初始化", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_bg_smooth_enter_timeout", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_bg_smooth_enter_timeout", Reflection.getOrCreateKotlinClass(r2), "ktv进房优化背景移除时间", "ranxiongxiong"));
        UltraSettingsManager.b("live_intimate_chat_use_new_panel", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_intimate_chat_use_new_panel", Reflection.getOrCreateKotlinClass(r1), "观众连线使用新面板等体验优化", "ranxiongxiong"));
        UltraSettingsManager.b("live_enable_anchor_mute_self", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_enable_anchor_mute_self", Reflection.getOrCreateKotlinClass(r1), "主播是否允许静音自己", "ranxiongxiong"));
        UltraSettingsManager.b("live_room_battle_theme_Lynx", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_room_battle_theme_Lynx", Reflection.getOrCreateKotlinClass(LinkRoomFightLynxConfig.class), "跨房对战主题Lynx配置", "ranxiongxiong"));
        UltraSettingsManager.b("live_new_ktv_default_mv_control_way", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_new_ktv_default_mv_control_way", Reflection.getOrCreateKotlinClass(r1), "默认mv播放控制方式", "ranxiongxiong"));
        UltraSettingsManager.b("live_digit_avatar_push_black_frame_opt_switch", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_digit_avatar_push_black_frame_opt_switch", Reflection.getOrCreateKotlinClass(r1), "优化虚拟数字人模式切换到语音模式推黑帧时机开关", "ranxiongxiong"));
        UltraSettingsManager.b("live_dylite_linkmic_open", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_dylite_linkmic_open", Reflection.getOrCreateKotlinClass(r1), "抖音极速版连线能力开关", "ranxiongxiong"));
        UltraSettingsManager.b("ktv_fast_enter_room_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("ktv_fast_enter_room_enable", Reflection.getOrCreateKotlinClass(r3), "KTV快速进房开关", "ranxiongxiong"));
        UltraSettingsManager.b("live_enable_anchor_feedback_in_chat_room", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_enable_anchor_feedback_in_chat_room", Reflection.getOrCreateKotlinClass(r1), "直播间聊天室主播侧是否开启反馈入口", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_midi_hit_animation_count", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_midi_hit_animation_count", Reflection.getOrCreateKotlinClass(r3), "midi增强状态下粒子动画个数", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_multi_chorus_volume_adjust_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_multi_chorus_volume_adjust_enable", Reflection.getOrCreateKotlinClass(r1), "一起唱副唱音量调整开关", "ranxiongxiong"));
        UltraSettingsManager.b("live_self_discipline_v2", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_self_discipline_v2", Reflection.getOrCreateKotlinClass(r3), "自律模式二期功能开关", "ranxiongxiong"));
        UltraSettingsManager.b("multi_link_voice_chat_pc_project_stream_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("multi_link_voice_chat_pc_project_stream_opt", Reflection.getOrCreateKotlinClass(r1), "语音聊天室投流跳变优化", "guoyunguang"));
        UltraSettingsManager.b("live_push_stream_size_map", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_push_stream_size_map", n, "推流尺寸", "ranxiongxiong"));
        UltraSettingsManager.b("live_multi_link_back_to_feed_adjust_offset", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_link_back_to_feed_adjust_offset", Reflection.getOrCreateKotlinClass(r1), "退房回到预览流调整布局offset", "ranxiongxiong"));
        UltraSettingsManager.b("live_rt_chorus_switch_scene_tips_change", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_rt_chorus_switch_scene_tips_change", Reflection.getOrCreateKotlinClass(r1), "实时合唱场景切换提示语变更", "ranxiongxiong"));
        UltraSettingsManager.b("live_anchor_audio_switch_optimize", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_anchor_audio_switch_optimize", Reflection.getOrCreateKotlinClass(r1), "主播switchAudio流程优化开关", "ranxiongxiong"));
        UltraSettingsManager.b("interact_guest_frame_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("interact_guest_frame_opt", Reflection.getOrCreateKotlinClass(r1), "首帧优化开关", "ranxiongxiong"));
        UltraSettingsManager.b("live_guest_battle_rank_url", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_guest_battle_rank_url", Reflection.getOrCreateKotlinClass(String.class), "嘉宾大作战rank列表lynx url", "ranxiongxiong"));
        UltraSettingsManager.b("live_multi_link_core_log_params_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_link_core_log_params_opt", Reflection.getOrCreateKotlinClass(r1), "多人场景核心埋点参数补充开关", "ranxiongxiong"));
        UltraSettingsManager.b("live_enable_audience_invite_friends", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_enable_audience_invite_friends", Reflection.getOrCreateKotlinClass(r1), "实验：是否开启聊天室好友邀请", "ranxiongxiong"));
        UltraSettingsManager.b("live_dynamic_container_load_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_dynamic_container_load_opt", Reflection.getOrCreateKotlinClass(MultiLinkRevenueEnterRoomOptConfig.class), "动态化容器加载优化", "ranxiongxiong"));
        UltraSettingsManager.b("live_talk_room_support_admin_operate", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_talk_room_support_admin_operate", Reflection.getOrCreateKotlinClass(r1), "聊天室是否允许管理员操作连麦用户", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_update_bgm_ear_volume_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_update_bgm_ear_volume_enable", Reflection.getOrCreateKotlinClass(r1), "ktv场景手动更新上次记忆的伴奏和耳返音量", "ranxiongxiong"));
        UltraSettingsManager.b("live_interact_xplay_first_priority_guest_update_gap_time", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_interact_xplay_first_priority_guest_update_gap_time", Reflection.getOrCreateKotlinClass(r2), "多人场景弹幕玩法布局麦位缩起状态下的麦位优先级更新冷却时间", "ranxiongxiong"));
        UltraSettingsManager.b("live_monitor_rtc_resolutio_redundancy_threshold", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_monitor_rtc_resolutio_redundancy_threshold", Reflection.getOrCreateKotlinClass(r4), "pk及多人主播连线监控推流分辨率阈值", "ranxiongxiong"));
        UltraSettingsManager.b("multi_link_base_common_window_layer_anchor_media_type_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("multi_link_base_common_window_layer_anchor_media_type_opt", Reflection.getOrCreateKotlinClass(r1), "配置化布局layer主播侧mediaType优化", "ranxiongxiong"));
        UltraSettingsManager.b("interact_activity_permission_guarantor_live_container", new com.bytedance.tools.kcp.ultrasettings.runtime.c("interact_activity_permission_guarantor_live_container", o, "命中释放音频权限的直播HostActivity名单,需要进一步检查是否加载直播做二次判断", "ranxiongxiong"));
        UltraSettingsManager.b("live_audience_open_panel", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_audience_open_panel", Reflection.getOrCreateKotlinClass(r1), "开启双人聊的时候是否展示开启面板", "ranxiongxiong"));
        UltraSettingsManager.b("audio_equal_anchor_change_position_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("audio_equal_anchor_change_position_enable", Reflection.getOrCreateKotlinClass(r1), "语音平权房主播能否换麦位", "ranxiongxiong"));
        UltraSettingsManager.b("live_multi_link_fps_adjust", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_link_fps_adjust", Reflection.getOrCreateKotlinClass(r1), "多人场景帧率优化", "liaonanshan"));
        UltraSettingsManager.b("live_audio_link_guide_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_audio_link_guide_config", Reflection.getOrCreateKotlinClass(wm2.b.class), "语音聊天室上麦引导配置", "ranxiongxiong"));
        UltraSettingsManager.b("multi_link_dynamic_equal_single_view_fix", new com.bytedance.tools.kcp.ultrasettings.runtime.c("multi_link_dynamic_equal_single_view_fix", Reflection.getOrCreateKotlinClass(r1), "动态宫格布局单View对齐问题修复", "ranxiongxiong"));
        UltraSettingsManager.b("live_linkmic_online_float_window_hide_when_background", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_linkmic_online_float_window_hide_when_background", Reflection.getOrCreateKotlinClass(r1), "连线小窗退后台是否展示状态栏常驻push", "ranxiongxiong"));
        UltraSettingsManager.b("live_audio_station_text_container_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_audio_station_text_container_enable", Reflection.getOrCreateKotlinClass(r1), "语音电台文字容器实验", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_score_wrong_count", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_score_wrong_count", Reflection.getOrCreateKotlinClass(r3), "音高球容错", "ranxiongxiong"));
        UltraSettingsManager.b("live_link_sdk_enable_texture_buffer_pool", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_link_sdk_enable_texture_buffer_pool", Reflection.getOrCreateKotlinClass(r1), "LiveLinkSDK开启Texture池", "ranxiongxiong"));
        UltraSettingsManager.b("live_digit_avatar_ready_publish_stream_delay_time", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_digit_avatar_ready_publish_stream_delay_time", Reflection.getOrCreateKotlinClass(r2), "虚拟形象就绪发布视频流延迟时间", "ranxiongxiong"));
        UltraSettingsManager.b("multi_link_layout_config_engine_v2_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("multi_link_layout_config_engine_v2_enable", Reflection.getOrCreateKotlinClass(r1), "是否启用布局配置化v2版本", "ranxiongxiong"));
        UltraSettingsManager.b("live_badge_use_v2_icon_list", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_badge_use_v2_icon_list", Reflection.getOrCreateKotlinClass(r1), "使用V2版勋章列表", "changjianfei"));
        UltraSettingsManager.b("live_double_interact_show_switch_scene_button", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_double_interact_show_switch_scene_button", Reflection.getOrCreateKotlinClass(r1), "双人聊是否展示切换场景按钮", "ranxiongxiong"));
        UltraSettingsManager.b("ktv_draglayout_limit_check", new com.bytedance.tools.kcp.ultrasettings.runtime.c("ktv_draglayout_limit_check", Reflection.getOrCreateKotlinClass(r1), "ktv 滑动区域检查", "ranxiongxiong"));
        UltraSettingsManager.b("live_ksong_public_screen_adjust", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ksong_public_screen_adjust", Reflection.getOrCreateKotlinClass(r1), "ksong 公屏调整逻辑短路", "ranxiongxiong"));
        UltraSettingsManager.b("live_multi_order_sing_label_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_order_sing_label_config", Reflection.getOrCreateKotlinClass(c61.class), "视频聊天室标签文案", "ranxiongxiong"));
        UltraSettingsManager.b("live_voice_chat_room_background_recover_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_voice_chat_room_background_recover_enable", Reflection.getOrCreateKotlinClass(r1), "语音聊天室是否允许兜底恢复背景可见", "ranxiongxiong"));
        UltraSettingsManager.b("live_position_name_leak_fix", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_position_name_leak_fix", Reflection.getOrCreateKotlinClass(r1), "修复麦位名内存泄漏，验证用户体验 @kongjie", "ranxiongxiong"));
        UltraSettingsManager.b("live_chat_channel_stop_audio_capture_after_mute", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_chat_channel_stop_audio_capture_after_mute", Reflection.getOrCreateKotlinClass(r1), "频道房语音音频采集与发布是否同步", "ranxiongxiong"));
        UltraSettingsManager.b("live_interact_ktv_bigparty_sound_animation_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_interact_ktv_bigparty_sound_animation_config", Reflection.getOrCreateKotlinClass(KtvAudioVolumeAnimConfig.class), "KTV声波动效", "ranxiongxiong"));
        UltraSettingsManager.b("live_clear_midi_score_setting", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_clear_midi_score_setting", Reflection.getOrCreateKotlinClass(r1), "midi分数清除开关", "ranxiongxiong"));
        UltraSettingsManager.b("live_chatroom_sei_fields_simplify_uid", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_chatroom_sei_fields_simplify_uid", Reflection.getOrCreateKotlinClass(r1), "是否开启聊天室sei中uid精简", "ranxiongxiong"));
        UltraSettingsManager.b("live_client_mix_stream", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_client_mix_stream", Reflection.getOrCreateKotlinClass(r1), "端上配置是否客户端合流", "ranxiongxiong"));
        UltraSettingsManager.b("live_enable_user_receive_friend_online_guide", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_enable_user_receive_friend_online_guide", Reflection.getOrCreateKotlinClass(r1), "是否展示好友上线邀请引导动画", "ranxiongxiong"));
        UltraSettingsManager.b("live_rt_chorus_support_listener_change_singer_from_sing_state", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_rt_chorus_support_listener_change_singer_from_sing_state", Reflection.getOrCreateKotlinClass(r1), "支持观众通过主播ping的演唱中消息，变为演唱者", "ranxiongxiong"));
        UltraSettingsManager.b("live_multi_debounce_mix_stream", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_debounce_mix_stream", Reflection.getOrCreateKotlinClass(r1), "debounce避免瞬时大量合流参数更新", "ranxiongxiong"));
        UltraSettingsManager.b("live_talk_room_support_room_data_sync_timeout_ms", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_talk_room_support_room_data_sync_timeout_ms", Reflection.getOrCreateKotlinClass(r2), "聊天室使用本地数据同步麦位列表等待超时时间(毫秒)", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_tuning_effect_support_increase_update", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_tuning_effect_support_increase_update", Reflection.getOrCreateKotlinClass(r1), "K歌音效列表支持增量刷新", "ranxiongxiong"));
        UltraSettingsManager.b("live_interact_anchor_label_dispatch", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_interact_anchor_label_dispatch", Reflection.getOrCreateKotlinClass(r1), "多人场景聊天室主播标签server下发优化", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_lyric_text_trim_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_lyric_text_trim_enable", Reflection.getOrCreateKotlinClass(r1), "是否对KTV折行后的歌词采取trim()处理", "ranxiongxiong"));
        UltraSettingsManager.b("live_anchor_start_rtc_update_open_voice", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_anchor_start_rtc_update_open_voice", Reflection.getOrCreateKotlinClass(r1), "语音场景主播开启RTC后更新配置开关", "ranxiongxiong"));
        UltraSettingsManager.b("ktv_back_overdraw_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("ktv_back_overdraw_opt", Reflection.getOrCreateKotlinClass(r1), "ktv开播过渡绘制修复", "ranxiongxiong"));
        UltraSettingsManager.b("live_chat_panel_activity_icon_lynx_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_chat_panel_activity_icon_lynx_opt", Reflection.getOrCreateKotlinClass(r1), "连线互动面板活动运营位迁移到Lynx实现", "ranxiongxiong"));
        UltraSettingsManager.b("live_multilink_dynamic_reuse_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multilink_dynamic_reuse_config", Reflection.getOrCreateKotlinClass(kb1.class), "多人场景Lynx容器复用配置", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_vivo_midi_color_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_vivo_midi_color_opt", Reflection.getOrCreateKotlinClass(r1), "修复vivo手机midi背景异常问题", "ranxiongxiong"));
        UltraSettingsManager.b("live_multi_link_customize_stream_ai_lyrics_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_link_customize_stream_ai_lyrics_opt", Reflection.getOrCreateKotlinClass(r1), "投流布局ai歌词适配", "guoyunguang"));
        UltraSettingsManager.b("live_ktv_state_machine_add_new_music_data_source", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_state_machine_add_new_music_data_source", Reflection.getOrCreateKotlinClass(r1), "K歌状态机是否增加歌曲数据源", "ranxiongxiong"));
        UltraSettingsManager.b("live_real_time_chorus_net_sore_mock", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_real_time_chorus_net_sore_mock", Reflection.getOrCreateKotlinClass(pf1.class), "实时合唱评分mock", "ranxiongxiong"));
        UltraSettingsManager.b("live_hamlet_avatar_stream_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_hamlet_avatar_stream_config", Reflection.getOrCreateKotlinClass(HamletLiveMediaMockConfig.class), "hamlet avatar直播流媒体参数配置", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_ktv_get_music_panel_by_sei_fall_back", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_ktv_get_music_panel_by_sei_fall_back", Reflection.getOrCreateKotlinClass(r1), "K歌getMusicPanelBySei回退开关", "ranxiongxiong"));
        UltraSettingsManager.b("live_enable_emoji_sound", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_enable_emoji_sound", Reflection.getOrCreateKotlinClass(r1), "观众连麦表情声音", "ranxiongxiong"));
        UltraSettingsManager.b("multi_link_base_common_window_support_video_position_ext_info", new com.bytedance.tools.kcp.ultrasettings.runtime.c("multi_link_base_common_window_support_video_position_ext_info", p, "通用布局下支持从VideoPositionExtInfo中获取livecore和rtc参数的uiLayout列表", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_leak_memory_fix_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_leak_memory_fix_enable", Reflection.getOrCreateKotlinClass(r1), "K歌内存泄漏问题修复开关", "ranxiongxiong"));
        UltraSettingsManager.b("live_core_surface_view_force_match_parent", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_core_surface_view_force_match_parent", Reflection.getOrCreateKotlinClass(r1), "多人单view添加到父布局时match_parent", "ranxiongxiong"));
        UltraSettingsManager.b("live_core_reset_params_leave_channel", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_core_reset_params_leave_channel", Reflection.getOrCreateKotlinClass(r1), "下麦时重置LiveCore参数新方式", "ranxiongxiong"));
        UltraSettingsManager.b("live_image_picker_permission_check_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_image_picker_permission_check_enable", Reflection.getOrCreateKotlinClass(r1), "系统图片资源权限申请配置", "ranxiongxiong"));
        UltraSettingsManager.b("live_rt_chorus_paid_red_dot_show_ts", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_rt_chorus_paid_red_dot_show_ts", Reflection.getOrCreateKotlinClass(r3), "合唱派对付费红点显示时间戳", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_score_hit_rate", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_score_hit_rate", Reflection.getOrCreateKotlinClass(r3), "特效采样率", "ranxiongxiong"));
        UltraSettingsManager.b("live_linkmic_link_success_update_livecore_params", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_linkmic_link_success_update_livecore_params", Reflection.getOrCreateKotlinClass(LiveLinkMicUpdateLiveCoreParamsConfig.class), "多人连麦场景下，用户连麦成功更新livecore参数", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_room_audience_mic_dress_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_room_audience_mic_dress_enable", Reflection.getOrCreateKotlinClass(r1), "ktv房间观众麦位声波随sei变化", "ranxiongxiong"));
        UltraSettingsManager.b("live_paid_link_optimize_guest_experiment_open", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_paid_link_optimize_guest_experiment_open", Reflection.getOrCreateKotlinClass(r1), "付费连线观众实验组开关", "ranxiongxiong"));
        UltraSettingsManager.b("interact_fulllink_point_blacklist", new com.bytedance.tools.kcp.ultrasettings.runtime.c("interact_fulllink_point_blacklist", q, "连麦全链路埋点黑名单，命中的不上报", "ranxiongxiong"));
        UltraSettingsManager.b("live_new_midi_level", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_new_midi_level", Reflection.getOrCreateKotlinClass(r3), "K歌midi打分等级，0 (专业模式)， 1 (娱乐模式)， 2 (娱乐模式1)， 3 (娱乐模式2)， 4 (娱乐模式3)， 宽松程度依次增加", "zengle"));
        UltraSettingsManager.b("live_interact_audio_capture_background_anchor", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_interact_audio_capture_background_anchor", Reflection.getOrCreateKotlinClass(r1), "主播侧退后台是否采集音频", "ranxiongxiong"));
        UltraSettingsManager.b("star_wish_open_panel_schema", new com.bytedance.tools.kcp.ultrasettings.runtime.c("star_wish_open_panel_schema", Reflection.getOrCreateKotlinClass(String.class), "星愿瓶玩法开启面板schema", "ranxiongxiong"));
        UltraSettingsManager.b("live_opus_mv_enter_room_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_opus_mv_enter_room_opt", Reflection.getOrCreateKotlinClass(r1), "新mv进房跳变优化", "ranxiongxiong"));
        UltraSettingsManager.b("live_audio_update_pk_theme_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_audio_update_pk_theme_enable", Reflection.getOrCreateKotlinClass(r1), "语音电台PK场景下更新主题", "ranxiongxiong"));
        UltraSettingsManager.b("live_video_self_discipline_auto_start", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_video_self_discipline_auto_start", Reflection.getOrCreateKotlinClass(r1), "自律模式是否支持自动开启", "ranxiongxiong"));
        UltraSettingsManager.b("live_allow_admin_operate_audience", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_allow_admin_operate_audience", Reflection.getOrCreateKotlinClass(r1), "聊天室主播侧是否显示管理员权限设置入口", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_video_render_disable_fix", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_video_render_disable_fix", Reflection.getOrCreateKotlinClass(r1), "视频不可见修复，视频不可见修复", "ranxiongxiong"));
        UltraSettingsManager.b("live_multi_link_layout_config_fix", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_link_layout_config_fix", Reflection.getOrCreateKotlinClass(r1), "修复动态化布局下移问题", "ranxiongxiong"));
        UltraSettingsManager.b("live_panel_first_frame_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_panel_first_frame_opt", Reflection.getOrCreateKotlinClass(t61.class), "面板首帧优化", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_component_lyric_download_crash_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_component_lyric_download_crash_opt", Reflection.getOrCreateKotlinClass(r1), "K歌组件歌词下载取消下载监听导致死锁", "ranxiongxiong"));
        UltraSettingsManager.b("live_talkroom_function_type_optimize", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_talkroom_function_type_optimize", Reflection.getOrCreateKotlinClass(r1), "聊天室function_type计算优化开关", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_oppo_echo_feature_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_oppo_echo_feature_enable", Reflection.getOrCreateKotlinClass(r1), "OPPO耳返入口是否开启", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_anchor_ping_fix", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_anchor_ping_fix", Reflection.getOrCreateKotlinClass(r1), "live_ktv_anchor_ping_fix", "ranxiongxiong"));
        UltraSettingsManager.b("live_multi_link_enable_video_digit_avatar", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_link_enable_video_digit_avatar", Reflection.getOrCreateKotlinClass(r1), "是否开启视频聊天室虚拟形象", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_real_time_chorus_net_detect_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_real_time_chorus_net_detect_config", Reflection.getOrCreateKotlinClass(mf1.class), "实时合唱网络检测配置", "ranxiongxiong"));
        UltraSettingsManager.b("live_comment_interact_apply", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_comment_interact_apply", Reflection.getOrCreateKotlinClass(r1), "公屏区评论连线能力实验", "ranxiongxiong"));
        UltraSettingsManager.b("solo_ktv_fake_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("solo_ktv_fake_config", Reflection.getOrCreateKotlinClass(rs1.g.class), "练唱fake配置", "ranxiongxiong"));
        UltraSettingsManager.b("live_multi_link_enable_match_count_down", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_link_enable_match_count_down", Reflection.getOrCreateKotlinClass(r1), "连线匹配页面是否展示跳转倒计时", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_hide_order_btn_feed", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_hide_order_btn_feed", Reflection.getOrCreateKotlinClass(r1), "预览流不展示点歌按钮", "ranxiongxiong"));
        UltraSettingsManager.b("live_player_layout_opt_v1", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_player_layout_opt_v1", Reflection.getOrCreateKotlinClass(r1), "播放器布局逻辑优化", "ranxiongxiong"));
        UltraSettingsManager.b("live_hamlet_avatar_monitor_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_hamlet_avatar_monitor_enable", Reflection.getOrCreateKotlinClass(r1), "Hamlet trace开关", "ranxiongxiong"));
        UltraSettingsManager.b("live_linkmic_online_float_window_exception_mock", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_linkmic_online_float_window_exception_mock", Reflection.getOrCreateKotlinClass(h51.class), "多人场景连线小窗异常情况mockConfig", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_setting_play_panel_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_setting_play_panel_enable", Reflection.getOrCreateKotlinClass(r1), "语音ktv设置面板是否支持展示玩法入口", "ranxiongxiong"));
        UltraSettingsManager.b("live_linkmic_dynamic_aggregate_alog_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_linkmic_dynamic_aggregate_alog_config", Reflection.getOrCreateKotlinClass(e3.class), "Lynx日志聚合上报", "ranxiongxiong"));
        UltraSettingsManager.b("multi_link_1v8_first_empty_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("multi_link_1v8_first_empty_opt", Reflection.getOrCreateKotlinClass(r1), "语音聊天室1v8第一个空麦位layer改造，防止首刷跳变", "ranxiongxiong"));
        UltraSettingsManager.b("local_test_use_online_gecko", new com.bytedance.tools.kcp.ultrasettings.runtime.c("local_test_use_online_gecko", Reflection.getOrCreateKotlinClass(r1), "local_test使用线上Gecko", "ranxiongxiong"));
        UltraSettingsManager.b("multi_link_voice_chat_switch_layout_check_valid", new com.bytedance.tools.kcp.ultrasettings.runtime.c("multi_link_voice_chat_switch_layout_check_valid", Reflection.getOrCreateKotlinClass(r1), "语音聊天室布局切换前检验scene和uiLayout合法性", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_score_point_rate", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_score_point_rate", Reflection.getOrCreateKotlinClass(r3), "音高球采样率", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_component_advance_unload_widget", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_component_advance_unload_widget", Reflection.getOrCreateKotlinClass(r1), "语音聊天室切KTV，提前释放组件widget", "ranxiongxiong"));
        UltraSettingsManager.b("live_solo_ktv_rt_chorus_living_icon", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_solo_ktv_rt_chorus_living_icon", Reflection.getOrCreateKotlinClass(String.class), "个人练歌房合唱派对直播中图标", "ranxiongxiong"));
        UltraSettingsManager.b("live_solo_ktv_preview_seek_time_diff", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_solo_ktv_preview_seek_time_diff", Reflection.getOrCreateKotlinClass(r2), "个人练歌房预览seek diff", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_opus_enalbe_local_test", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_opus_enalbe_local_test", Reflection.getOrCreateKotlinClass(r1), "内测环境全屏mv dophin开关", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_score_hit_rate_v2", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_score_hit_rate_v2", Reflection.getOrCreateKotlinClass(r3), "特效采样率", "ranxiongxiong"));
        UltraSettingsManager.b("live_video_self_discipline_auto_start_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_video_self_discipline_auto_start_opt", Reflection.getOrCreateKotlinClass(r1), "自律模式自动开启优化", "ranxiongxiong"));
        UltraSettingsManager.b("live_xplay_pause_or_resume_game_switch", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_xplay_pause_or_resume_game_switch", Reflection.getOrCreateKotlinClass(r1), "主播退后台是否调用 pauseGame 开关", "ranxiongxiong"));
        UltraSettingsManager.b("ksong_kmp_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("ksong_kmp_opt", Reflection.getOrCreateKotlinClass(r1), "K歌kmp改造setting", "zengle"));
        UltraSettingsManager.b("live_multi_revenue_marquee_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_revenue_marquee_config", Reflection.getOrCreateKotlinClass(xb1.class), "多人场景竞争玩法通知栏滚动配置", "ranxiongxiong"));
        UltraSettingsManager.b("live_enable_anchor_echo_global", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_enable_anchor_echo_global", Reflection.getOrCreateKotlinClass(r1), "主播耳返全局开关（KTV模式下不一定生效）", "ranxiongxiong"));
        UltraSettingsManager.b("live_solo_ktv_dangerous_copyright_song_play_duration", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_solo_ktv_dangerous_copyright_song_play_duration", Reflection.getOrCreateKotlinClass(r3), "个人练歌房高危曲库播放时长", "ranxiongxiong"));
        UltraSettingsManager.b("live_pc_landscape_linkmic_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_pc_landscape_linkmic_enable", Reflection.getOrCreateKotlinClass(r1), "伴侣横屏开播兜底开关", "ranxiongxiong"));
        UltraSettingsManager.b("live_gift_fresco_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_fresco_opt", Reflection.getOrCreateKotlinClass(r1), "Fresco自定义缓存优化", "ranxiongxiong"));
        UltraSettingsManager.b("live_new_audience_zero_linkmic_empty_mic_seat", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_new_audience_zero_linkmic_empty_mic_seat", Reflection.getOrCreateKotlinClass(r1), "观众连线0连空麦位实验", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_sei_log_key", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_sei_log_key", Reflection.getOrCreateKotlinClass(r1), "ktv sei 打印开关", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_mv_enable_hard_decode", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_mv_enable_hard_decode", Reflection.getOrCreateKotlinClass(r1), "mv 开启硬解", "ranxiongxiong"));
        UltraSettingsManager.b("live_enable_anchor_invite_friends", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_enable_anchor_invite_friends", Reflection.getOrCreateKotlinClass(r1), "实验：是否开启聊天室好友邀请", "ranxiongxiong"));
        UltraSettingsManager.b("ktv_audience_enable_open_camera", new com.bytedance.tools.kcp.ultrasettings.runtime.c("ktv_audience_enable_open_camera", Reflection.getOrCreateKotlinClass(r1), "KTV摄像头全量开关", "ranxiongxiong"));
        UltraSettingsManager.b("live_linkmic_weak_distribution_enabled", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_linkmic_weak_distribution_enabled", Reflection.getOrCreateKotlinClass(r1), "有/无用户连线分发的状态实验开关", "ranxiongxiong"));
        UltraSettingsManager.b("live_interact_audience_use_new_apply_panel", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_interact_audience_use_new_apply_panel", Reflection.getOrCreateKotlinClass(r1), "双人聊第三方开播观众端使用新的申请面板", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_ordered_data_context_init_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_ordered_data_context_init_opt", Reflection.getOrCreateKotlinClass(r1), "KTV已点歌单datacontext初始化时机优化", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_lyrics_max_length", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_lyrics_max_length", Reflection.getOrCreateKotlinClass(r3), "K歌歌词sei最大长度", "ranxiongxiong"));
        UltraSettingsManager.b("live_first_discount_view_anim_interval_time", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_first_discount_view_anim_interval_time", Reflection.getOrCreateKotlinClass(r2), "首单折扣icon动画间隔时间", "ranxiongxiong"));
        UltraSettingsManager.b("live_challenge_theme_id", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_challenge_theme_id", Reflection.getOrCreateKotlinClass(r2), "演唱挑战主题id", "ranxiongxiong"));
        UltraSettingsManager.b("live_chat_channel_audio_downgrade_switch", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_chat_channel_audio_downgrade_switch", Reflection.getOrCreateKotlinClass(r3), "频道房边看边聊语音功能是否可用（端上降级）", "ranxiongxiong"));
        UltraSettingsManager.b("video_camera_agoro_opt_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("video_camera_agoro_opt_enable", Reflection.getOrCreateKotlinClass(r1), "针对声网无回调问题适配", "ranxiongxiong"));
        UltraSettingsManager.b("live_multi_link_video_online_server_check_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_link_video_online_server_check_opt", Reflection.getOrCreateKotlinClass(r1), "多人视频上麦权限校验优化", "ranxiongxiong"));
        UltraSettingsManager.b("video_share_load_video_count_first", new com.bytedance.tools.kcp.ultrasettings.runtime.c("video_share_load_video_count_first", Reflection.getOrCreateKotlinClass(r3), "短视频评论视频选择首页请求个数", "ranxiongxiong"));
        UltraSettingsManager.b("live_multilink_game_dynamic_window_enable_show_default_guest", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multilink_game_dynamic_window_enable_show_default_guest", Reflection.getOrCreateKotlinClass(r1), "多人场景弹幕玩法布局麦位缩起状态下，观众是否显示默认兜底最高优先级嘉宾", "ranxiongxiong"));
        UltraSettingsManager.b("live_interact_small_win_close_button_abTest", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_interact_small_win_close_button_abTest", Reflection.getOrCreateKotlinClass(r1), "多人连线小窗关闭按钮展示实验", "ranxiongxiong"));
        UltraSettingsManager.b("live_interact_enable_linkmic_small_win", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_interact_enable_linkmic_small_win", Reflection.getOrCreateKotlinClass(r1), "多人连线小窗是否全量", "ranxiongxiong"));
        UltraSettingsManager.b("live_voice_ktv_lyric_use_surface_view_v2", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_voice_ktv_lyric_use_surface_view_v2", Reflection.getOrCreateKotlinClass(r1), "语音KTV 歌词使用SurfaceView V2", "ranxiongxiong"));
        UltraSettingsManager.b("live_pc_audio_chorus_volume_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_pc_audio_chorus_volume_config", Reflection.getOrCreateKotlinClass(y61.class), "pc合唱音量配置", "zhanghao"));
        UltraSettingsManager.b("live_open_fix_voice_guest_crash", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_open_fix_voice_guest_crash", Reflection.getOrCreateKotlinClass(r1), "解决语音房观众侧crash开关", "ranxiongxiong"));
        UltraSettingsManager.b("live_multi_link_recover_mode_avatar_cancel", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_link_recover_mode_avatar_cancel", Reflection.getOrCreateKotlinClass(r1), "avatar识别弹窗取消后是否恢复原有采集模式", "liaonanshan"));
        UltraSettingsManager.b("radio_dark_mask_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("radio_dark_mask_opt", Reflection.getOrCreateKotlinClass(r1), "语音电台蒙层优化", "ranxiongxiong"));
        UltraSettingsManager.b("multi_link_base_common_window_layout_fixed_float_adjust_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("multi_link_base_common_window_layout_fixed_float_adjust_opt", Reflection.getOrCreateKotlinClass(r1), "固定浮窗宽屏设备适配优化", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_cancel_preload_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_cancel_preload_enable", Reflection.getOrCreateKotlinClass(r1), "预加载取消开关", "ranxiongxiong"));
        UltraSettingsManager.b("live_interact_multi_speaking_type_sei", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_interact_multi_speaking_type_sei", Reflection.getOrCreateKotlinClass(r1), "sei中是否携带说话音量状态", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_context_fill_room", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_context_fill_room", Reflection.getOrCreateKotlinClass(r1), "roomcontext兜底", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_midi_hit_easy", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_midi_hit_easy", Reflection.getOrCreateKotlinClass(r1), "midi简单模式", "ranxiongxiong"));
        UltraSettingsManager.b("multi_anchor_cross_channel_backup_timer_duration", new com.bytedance.tools.kcp.ultrasettings.runtime.c("multi_anchor_cross_channel_backup_timer_duration", Reflection.getOrCreateKotlinClass(r3), "多人主播连线兜底超时", "ranxiongxiong"));
        UltraSettingsManager.b("live_interact_feed_view_black_list", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_interact_feed_view_black_list", r, "预览流兜底黑名单", "ranxiongxiong"));
        UltraSettingsManager.b("live_multi_link_fetch_list_wrds_backup_opt_anchor", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_link_fetch_list_wrds_backup_opt_anchor", Reflection.getOrCreateKotlinClass(r1), "多人场景麦位数据wrds兜底优化(主播)", "ranxiongxiong"));
        UltraSettingsManager.b("live_interact_emoji_disable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_interact_emoji_disable", Reflection.getOrCreateKotlinClass(r1), "聊天室是否禁止使用麦上表情", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_order_panel_mode", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_order_panel_mode", Reflection.getOrCreateKotlinClass(r3), "ktv点歌台优化开关", "ranxiongxiong"));
        UltraSettingsManager.b("live_enable_black_frame_when_preview_with_rtc_public", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_enable_black_frame_when_preview_with_rtc_public", Reflection.getOrCreateKotlinClass(r1), "视频聊天室嘉宾美颜预览是否开启黑帧", "ranxiongxiong"));
        UltraSettingsManager.b("live_paid_live_enable_video_talk_room", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_paid_live_enable_video_talk_room", Reflection.getOrCreateKotlinClass(r1), "付费直播间支持开启聊天室", "ranxiongxiong"));
        UltraSettingsManager.b("ktv_tag_scheme", new com.bytedance.tools.kcp.ultrasettings.runtime.c("ktv_tag_scheme", Reflection.getOrCreateKotlinClass(String.class), "麦位标签说面页scheme", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_sing_path_report", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_sing_path_report", Reflection.getOrCreateKotlinClass(r1), "开唱链路上报", "ranxiongxiong"));
        UltraSettingsManager.b("live_multi_scene_preview_ui_log", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_scene_preview_ui_log", Reflection.getOrCreateKotlinClass(r1), "多人场景预览流UI首帧上报埋点", "ranxiongxiong"));
        UltraSettingsManager.b("live_request_song_anim_task_executor_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_request_song_anim_task_executor_opt", Reflection.getOrCreateKotlinClass(r1), "你点我唱动画任务内存泄漏优化", "ranxiongxiong"));
        UltraSettingsManager.b("live_core_planar_render_mode_switch", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_core_planar_render_mode_switch", Reflection.getOrCreateKotlinClass(r1), "liveCore推流是否开启VideoMix平面模式", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_mv_seek_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_mv_seek_enable", Reflection.getOrCreateKotlinClass(r1), "k歌场景mv seek开关", "ranxiongxiong"));
        UltraSettingsManager.b("live_audio_station_text_container_preview_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_audio_station_text_container_preview_enable", Reflection.getOrCreateKotlinClass(r1), "语音电台文字容器预览流AB实验", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_room_midi_cal_factor", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_room_midi_cal_factor", Reflection.getOrCreateKotlinClass(r4), "K歌midi计算系数", "ranxiongxiong"));
        UltraSettingsManager.b("live_equal_talk_room_top_margin_ratio", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_equal_talk_room_top_margin_ratio", Reflection.getOrCreateKotlinClass(r4), "平权九宫格上边距的合流比例", "ranxiongxiong"));
        UltraSettingsManager.b("linkmic_video_equal_enlarge_full", new com.bytedance.tools.kcp.ultrasettings.runtime.c("linkmic_video_equal_enlarge_full", Reflection.getOrCreateKotlinClass(r3), "宫格主咖放大展示形式", "ranxiongxiong"));
        UltraSettingsManager.b("live_multi_audio_pub_stream_succeed_codes", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_audio_pub_stream_succeed_codes", s, "【语音】跨房厅战公共流Result回调，处理为成功的返回码", "ranxiongxiong"));
        UltraSettingsManager.b("live_multi_linker_backup_stream_disable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_linker_backup_stream_disable", Reflection.getOrCreateKotlinClass(r1), "多人主播连线主备流开关", "ranxiongxiong"));
        UltraSettingsManager.b("live_multi_link_enable_tools_plugin_check", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_link_enable_tools_plugin_check", Reflection.getOrCreateKotlinClass(r1), "多人场景连麦是否检查工具线插件", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_enable_mock_img", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_enable_mock_img", Reflection.getOrCreateKotlinClass(r1), "允许视频演唱平滑过渡", "ranxiongxiong"));
        UltraSettingsManager.b("live_solo_start_live_url", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_solo_start_live_url", Reflection.getOrCreateKotlinClass(String.class), "开启直播参数配置", "ranxiongxiong"));
        UltraSettingsManager.b("enable_anchor_perf_remind", new com.bytedance.tools.kcp.ultrasettings.runtime.c("enable_anchor_perf_remind", Reflection.getOrCreateKotlinClass(r1), "主播侧新版性能组件", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_real_time_chorus_anchor_resume_unmute", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_real_time_chorus_anchor_resume_unmute", Reflection.getOrCreateKotlinClass(r1), "实时合唱主播恢复所有人订阅关系", "ranxiongxiong"));
        UltraSettingsManager.b("live_memory_leak_fix_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_memory_leak_fix_enable", Reflection.getOrCreateKotlinClass(r1), "多人场景内存泄漏开关", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_init_widget_manager_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_init_widget_manager_opt", Reflection.getOrCreateKotlinClass(r1), "ktv构造widgetManger优化", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_music_time_shake_range", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_music_time_shake_range", Reflection.getOrCreateKotlinClass(r2), "歌曲时间抖动范围区间", "ranxiongxiong"));
        UltraSettingsManager.b("live_micseat_value_icon_unified", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_micseat_value_icon_unified", Reflection.getOrCreateKotlinClass(wm2.a.class), "多人麦位计值Icon统一配置", "ranxiongxiong"));
        UltraSettingsManager.b("live_video_self_discipline_client_switch", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_video_self_discipline_client_switch", Reflection.getOrCreateKotlinClass(r1), "视频聊天室自律模式端上总开关", "ranxiongxiong"));
        UltraSettingsManager.b("live_digit_avatar_ktv_stage_bg_cut_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_digit_avatar_ktv_stage_bg_cut_opt", Reflection.getOrCreateKotlinClass(r1), "ktv avatar虚拟形象舞台背景截图优化", "ranxiongxiong"));
        UltraSettingsManager.b("live_core_single_view_mode_trigger_task_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_core_single_view_mode_trigger_task_enable", Reflection.getOrCreateKotlinClass(r1), "单View模式是否开启triggerTask", "ranxiongxiong"));
        UltraSettingsManager.b("live_invite_link_mic_without_payment", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_invite_link_mic_without_payment", Reflection.getOrCreateKotlinClass(r1), "主播开启付费时，邀请观众上麦不需要付费", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_biz_destory_datacontext_clear", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_biz_destory_datacontext_clear", Reflection.getOrCreateKotlinClass(r1), "ktv预览流主动清空ktvcontext", "ranxiongxiong"));
        UltraSettingsManager.b("live_multi_link_enable_audio_scene", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_link_enable_audio_scene", Reflection.getOrCreateKotlinClass(r1), "RTC AudioScene开关", "ranxiongxiong"));
        UltraSettingsManager.b("solo_ktv_seek_pre_write_file_offset", new com.bytedance.tools.kcp.ultrasettings.runtime.c("solo_ktv_seek_pre_write_file_offset", Reflection.getOrCreateKotlinClass(r2), "练唱seek后提前录制文件的偏移量", "ranxiongxiong"));
        UltraSettingsManager.b("multi_link_prepare_waiting_list_vip_badge_fix", new com.bytedance.tools.kcp.ultrasettings.runtime.c("multi_link_prepare_waiting_list_vip_badge_fix", Reflection.getOrCreateKotlinClass(r1), "多人场景预申请等待面板会员勋章和昵称重叠问题", "ranxiongxiong"));
        UltraSettingsManager.b("live_link_sdk_video_frame_log_frequency_control_size", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_link_sdk_video_frame_log_frequency_control_size", Reflection.getOrCreateKotlinClass(r3), "livelink合流视频帧推帧上报频控", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_room_video_performance_limit", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_room_video_performance_limit", Reflection.getOrCreateKotlinClass(r4), "KTV模式开启视频演唱最低机型打分要求", "ranxiongxiong"));
        UltraSettingsManager.b("live_link_sdk_enable_frame_buffer_pool", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_link_sdk_enable_frame_buffer_pool", Reflection.getOrCreateKotlinClass(r1), "LiveLinkSDK开启FrameBuffer池", "ranxiongxiong"));
        UltraSettingsManager.b("live_interact_xplay_switch_scene_delay", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_interact_xplay_switch_scene_delay", Reflection.getOrCreateKotlinClass(r2), "多人场景开启云游戏后的布局切换delay等待时间", "ranxiongxiong"));
        UltraSettingsManager.b("live_score_view_full_mic_bug_fix", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_score_view_full_mic_bug_fix", Reflection.getOrCreateKotlinClass(r1), "启用全麦送礼闪烁效果和感谢TA动画的冲突", "ranxiongxiong"));
        UltraSettingsManager.b("multi_link_data_merge_sei_position_default_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("multi_link_data_merge_sei_position_default_opt", Reflection.getOrCreateKotlinClass(r1), "是否启用WindowListHelper seiPosition默认值优化（使用server userPosition兜底）", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_room_tune_context_init_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_room_tune_context_init_opt", Reflection.getOrCreateKotlinClass(r1), "KTV调音组件初始化时序调整", "ranxiongxiong"));
        UltraSettingsManager.b("live_multi_link_plugin_checker_host_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_link_plugin_checker_host_enable", Reflection.getOrCreateKotlinClass(r1), "多人场景连麦插件检测宿主是否支持连麦插件头条 lite 等宿主屏蔽", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_room_anchor_mic_dress_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_room_anchor_mic_dress_opt", Reflection.getOrCreateKotlinClass(r1), "ktv房间主播麦位声波接入数据中心", "ranxiongxiong"));
        UltraSettingsManager.b("live_multi_camera", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_camera", Reflection.getOrCreateKotlinClass(r1), "直播间多机位能力", "ranxiongxiong"));
        UltraSettingsManager.b("live_real_time_chorus_audio_pulse_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_real_time_chorus_audio_pulse_enable", Reflection.getOrCreateKotlinClass(r1), "实时合唱音频脉冲测试开关", "ranxiongxiong"));
        UltraSettingsManager.b("live_acquaintance_live_core_status_report", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_acquaintance_live_core_status_report", Reflection.getOrCreateKotlinClass(r1), "朋友房liveCore状态是否上报", "ranxiongxiong"));
        UltraSettingsManager.b("live_rt_chorus_stop_audio_capture_fix", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_rt_chorus_stop_audio_capture_fix", Reflection.getOrCreateKotlinClass(r1), "实时合唱静默用户未关闭音频采集修复", "ranxiongxiong"));
        UltraSettingsManager.b("enable_anchor_show_toolbar_name", new com.bytedance.tools.kcp.ultrasettings.runtime.c("enable_anchor_show_toolbar_name", Reflection.getOrCreateKotlinClass(r1), "主播侧toolbar样式改造", "ranxiongxiong"));
        UltraSettingsManager.b("live_audio_resolution_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_audio_resolution_opt", Reflection.getOrCreateKotlinClass(ns1.a.class), "语音聊天室黑帧分辨率优化", "ranxiongxiong"));
        UltraSettingsManager.b("live_order_song_select_singer_image_scheme", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_order_song_select_singer_image_scheme", Reflection.getOrCreateKotlinClass(String.class), "你点我唱玩法打开选择演唱形象scheme", "ranxiongxiong"));
        UltraSettingsManager.b("live_interact_invitation_guide_config_audience", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_interact_invitation_guide_config_audience", Reflection.getOrCreateKotlinClass(LinkAudioInviteGuideConfig.class), "观众端聊天室上麦之后邀请引导配置", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_pause_state_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_pause_state_enable", Reflection.getOrCreateKotlinClass(r1), "响应处理暂停状态", "ranxiongxiong"));
        UltraSettingsManager.b("live_multi_link_support_adventure", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_link_support_adventure", Reflection.getOrCreateKotlinClass(r1), "Saas是否支持奇遇连连", "ranxiongxiong"));
        UltraSettingsManager.b("live_talk_room_rank_user_score", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_talk_room_rank_user_score", Reflection.getOrCreateKotlinClass(r1), "直播聊天室申请列表按综合计值排序", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_sync_refactor", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_sync_refactor", Reflection.getOrCreateKotlinClass(r1), "歌词同步优化", "ranxiongxiong"));
        UltraSettingsManager.b("interact_fragment_permission_guarantor_check_content", new com.bytedance.tools.kcp.ultrasettings.runtime.c("interact_fragment_permission_guarantor_check_content", t, "跳转目标fragment，释放音频权限的名单", "ranxiongxiong"));
        UltraSettingsManager.b("ktv_chorus_assign_lead_auto_join_fix", new com.bytedance.tools.kcp.ultrasettings.runtime.c("ktv_chorus_assign_lead_auto_join_fix", Reflection.getOrCreateKotlinClass(r1), "实时合唱领唱自动加入问题修复", "ranxiongxiong"));
        UltraSettingsManager.b("multi_link_layout_config_v2_adjust_fix", new com.bytedance.tools.kcp.ultrasettings.runtime.c("multi_link_layout_config_v2_adjust_fix", Reflection.getOrCreateKotlinClass(r1), "布局配置-v2调整布局兜底", "dengzhuoyao"));
        UltraSettingsManager.b("live_lynx_switch_layout_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_lynx_switch_layout_opt", Reflection.getOrCreateKotlinClass(r1), "动态化启用异步排版)", "ranxiongxiong"));
        UltraSettingsManager.b("ktv_sei_safe_check", new com.bytedance.tools.kcp.ultrasettings.runtime.c("ktv_sei_safe_check", Reflection.getOrCreateKotlinClass(r1), "ktv sei校验能力", "ranxiongxiong"));
        UltraSettingsManager.b("live_rt_chorus_npt_valid_check", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_rt_chorus_npt_valid_check", Reflection.getOrCreateKotlinClass(r1), "合唱派对npt时间合法性校验", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_score_get_time", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_score_get_time", Reflection.getOrCreateKotlinClass(r2), "获取打分频率", "ranxiongxiong"));
        UltraSettingsManager.b("live_multilink_dynamic_center_card_recycle_leak_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multilink_dynamic_center_card_recycle_leak_opt", Reflection.getOrCreateKotlinClass(r1), "多人场景动态化中心卡片内存泄漏修复", "wuzhixin.jensen"));
        UltraSettingsManager.b("live_guest_battle_disable_datacenter_observe_ui_layout_change", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_guest_battle_disable_datacenter_observe_ui_layout_change", Reflection.getOrCreateKotlinClass(r1), "嘉宾大作战屏蔽通过dataCenter监听语音聊天室布局变化", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_full_link_report_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_full_link_report_opt", Reflection.getOrCreateKotlinClass(r1), "全链路上报策略优化", "ranxiongxiong"));
        UltraSettingsManager.b("live_multilink_new_video_link_lynx_card_visible_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multilink_new_video_link_lynx_card_visible_opt", Reflection.getOrCreateKotlinClass(r1), "新视频连线Lynx Load VISIBLE 兜底", "wuzhixin.jensen"));
        UltraSettingsManager.b("live_lynx_payforlink_apply_payinfo_request", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_lynx_payforlink_apply_payinfo_request", Reflection.getOrCreateKotlinClass(r1), "付费连线申请面板端上不拉取payinfo的接口", "ranxiongxiong"));
        UltraSettingsManager.b("live_hamlet_avatar_lip_sync_model_url", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_hamlet_avatar_lip_sync_model_url", Reflection.getOrCreateKotlinClass(String.class), "直播HamletAvatar LipSyc模型地址", "ranxiongxiong"));
        UltraSettingsManager.b("ktv_chorus_bgm_push_volume_adjust", new com.bytedance.tools.kcp.ultrasettings.runtime.c("ktv_chorus_bgm_push_volume_adjust", Reflection.getOrCreateKotlinClass(r2), "实时合唱远端音量调节策略", "ranxiongxiong"));
        UltraSettingsManager.b("video_equal_1v8fix_switch", new com.bytedance.tools.kcp.ultrasettings.runtime.c("video_equal_1v8fix_switch", Reflection.getOrCreateKotlinClass(r1), "双C全屏开关", "ranxiongxiong"));
        UltraSettingsManager.b("live_video_talk_avatar_enabled_anchor", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_video_talk_avatar_enabled_anchor", Reflection.getOrCreateKotlinClass(r1), "主播是否可以开启视频聊天室avatar虚拟形象", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_lyric_anim_fix", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_lyric_anim_fix", Reflection.getOrCreateKotlinClass(r3), "歌词滚动防跳变阈值", "ranxiongxiong"));
        UltraSettingsManager.b("live_self_discipline_v3", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_self_discipline_v3", Reflection.getOrCreateKotlinClass(r3), "自律模式三期功能开关", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktvcomp_gray_bug_switch_2930", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktvcomp_gray_bug_switch_2930", Reflection.getOrCreateKotlinClass(r1), "K歌组件2930灰度期间crash规避修复开关", "ranxiongxiong"));
        UltraSettingsManager.b("live_spatial_audio_enable_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_spatial_audio_enable_config", u, "空间音频支持场景列表", "ranxiongxiong"));
        UltraSettingsManager.b("live_mcu_test_fall_back", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_mcu_test_fall_back", Reflection.getOrCreateKotlinClass(r1), "跨房厅战公共流超时回退跨房流测试", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_lyric_release_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_lyric_release_enable", Reflection.getOrCreateKotlinClass(r1), "歌词灰度release开关", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_comonent_adjust_translation_y", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_comonent_adjust_translation_y", Reflection.getOrCreateKotlinClass(r1), "K歌组件调整Y轴位置", "ranxiongxiong"));
        UltraSettingsManager.b("live_voice_chat_room_guest_support_real_time_chorus", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_voice_chat_room_guest_support_real_time_chorus", Reflection.getOrCreateKotlinClass(r1), "语音房观众是否支持实时合唱", "ranxiongxiong"));
        UltraSettingsManager.b("live_multi_link_trace_prefix_filter_list", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_link_trace_prefix_filter_list", v, "多人场景建联Trace日志prefix上报列表", "ranxiongxiong"));
        UltraSettingsManager.b("live_linkmic_enter_room_transition", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_linkmic_enter_room_transition", Reflection.getOrCreateKotlinClass(vb1.class), "多人场景进房布局对齐配置", "ranxiongxiong"));
        UltraSettingsManager.b("solo_ktv_increase_download_progress_interval", new com.bytedance.tools.kcp.ultrasettings.runtime.c("solo_ktv_increase_download_progress_interval", Reflection.getOrCreateKotlinClass(r2), "个唱物料下载进度增加间隔，单位ms", "ranxiongxiong"));
        UltraSettingsManager.b("live_team_fight_manager_panel_lynx", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_team_fight_manager_panel_lynx", Reflection.getOrCreateKotlinClass(zh1.class), "团战灵活组队Lynx配置", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_component_lyric_load_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_component_lyric_load_opt", Reflection.getOrCreateKotlinClass(r1), "K歌组件歌词加载优化开关", "ranxiongxiong"));
        UltraSettingsManager.b("live_waiting_list_use_event_info", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_waiting_list_use_event_info", Reflection.getOrCreateKotlinClass(r1), "直播多人的申请/邀请列表是否使用统一的event_info字段", "ranxiongxiong"));
        UltraSettingsManager.b("live_link_security_check_online_list", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_link_security_check_online_list", Reflection.getOrCreateKotlinClass(r1), "多人场景音视频在线检测-检测用户列表状态", "ranxiongxiong"));
        UltraSettingsManager.b("video_talk_room_stream_mixer_user_thread_local_map", new com.bytedance.tools.kcp.ultrasettings.runtime.c("video_talk_room_stream_mixer_user_thread_local_map", w, "视频聊天室主播合流时，使用线程本地的map去计算sei的场景", "ranxiongxiong"));
        UltraSettingsManager.b("live_rt_chorus_feedback_view_fix", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_rt_chorus_feedback_view_fix", Reflection.getOrCreateKotlinClass(r1), "合唱派对结算页显示修复", "ranxiongxiong"));
        UltraSettingsManager.b("live_real_time_chorus_enter_room_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_real_time_chorus_enter_room_opt", Reflection.getOrCreateKotlinClass(r1), "实时合唱进退房体验优化", "ranxiongxiong"));
        UltraSettingsManager.b("live_digit_avatar_mute_video_stream_proc_switch", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_digit_avatar_mute_video_stream_proc_switch", Reflection.getOrCreateKotlinClass(r1), "视频连线Avatar mute视频流", "ranxiongxiong"));
        UltraSettingsManager.b("live_chat_room_panel_lynx_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_chat_room_panel_lynx_config", Reflection.getOrCreateKotlinClass(LiveChatRoomPanelLynxConfig.class), "多人场景互动面板LynxItemUrl配置下发", "ranxiongxiong"));
        UltraSettingsManager.b("live_multi_link_beauty_preview_dialog_ui_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_link_beauty_preview_dialog_ui_opt", Reflection.getOrCreateKotlinClass(r1), "多人场景申请视频连麦美颜预览弹窗saas ui 优化隐藏空白", "ranxiongxiong"));
        UltraSettingsManager.b("live_process_yuv_opt_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_process_yuv_opt_enable", Reflection.getOrCreateKotlinClass(r1), "420yuv旋转数据不处理", "ranxiongxiong"));
        UltraSettingsManager.b("link_monitor_event_black_list", new com.bytedance.tools.kcp.ultrasettings.runtime.c("link_monitor_event_black_list", x, "连麦端监控上报黑名单，用于屏蔽观众端误报", "ranxiongxiong"));
        UltraSettingsManager.b("live_link_multi_guest_set_enlarge_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_link_multi_guest_set_enlarge_enable", Reflection.getOrCreateKotlinClass(r1), "1v8C位放大支持嘉宾设置C位", "guoyunguang"));
        UltraSettingsManager.b("live_multi_link_ui_load_end_debug_toast", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_link_ui_load_end_debug_toast", Reflection.getOrCreateKotlinClass(r2), "麦位首帧测试toast", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_live_feed_region_change", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_live_feed_region_change", Reflection.getOrCreateKotlinClass(r1), "结果页位置调整", "ranxiongxiong"));
        UltraSettingsManager.b("ktv_listener_stop_by_music_check", new com.bytedance.tools.kcp.ultrasettings.runtime.c("ktv_listener_stop_by_music_check", Reflection.getOrCreateKotlinClass(r1), "KTV stopSing需要校验mid", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_lyric_parse_repeat_fix", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_lyric_parse_repeat_fix", Reflection.getOrCreateKotlinClass(r1), "重复parse修复", "ranxiongxiong"));
        UltraSettingsManager.b("live_voice_chat_enter_background_mute_fix", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_voice_chat_enter_background_mute_fix", Reflection.getOrCreateKotlinClass(r1), "语音聊天室嘉宾被主播静音后打开私信等全屏页面，主播取消静音，不应开始采集音频", "ranxiongxiong"));
        UltraSettingsManager.b("live_digit_avatar_effect_callback_time_out", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_digit_avatar_effect_callback_time_out", Reflection.getOrCreateKotlinClass(r2), "effect回调avatar加载成功超时", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_midi_hit_perfect", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_midi_hit_perfect", Reflection.getOrCreateKotlinClass(r1), "midi完美状态", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_enable_feedback_reason_single_select", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_enable_feedback_reason_single_select", Reflection.getOrCreateKotlinClass(r1), "K歌反馈面板反馈原因使用单选", "ranxiongxiong"));
        UltraSettingsManager.b("live_multi_revenue_qoe_qos_monitor_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_revenue_qoe_qos_monitor_enable", Reflection.getOrCreateKotlinClass(r1), "多人营收QoE/QoS指标埋点上报开关", "ranxiongxiong"));
        UltraSettingsManager.b("multi_link_region_mix_service_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("multi_link_region_mix_service_enable", Reflection.getOrCreateKotlinClass(r1), "是否开启下沉KMP的合流模块MultiLinkRegionMixService", "liaonanshan"));
        UltraSettingsManager.b("live_paid_live_enable_linkmic", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_paid_live_enable_linkmic", Reflection.getOrCreateKotlinClass(r1), "付费直播间支持用户连线能力", "ranxiongxiong"));
        UltraSettingsManager.b("linkmic_dynamic_panel_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("linkmic_dynamic_panel_config", Reflection.getOrCreateKotlinClass(ILinkmicDynamicPanelConfig.class), "多人连线互动面板及连线设置面板等开关", "liaonanshan"));
        UltraSettingsManager.b("ktv_schema_intercept_handle", new com.bytedance.tools.kcp.ultrasettings.runtime.c("ktv_schema_intercept_handle", Reflection.getOrCreateKotlinClass(r1), "KTV schema拦截处理开关", "ranxiongxiong"));
        UltraSettingsManager.b("live_community_tracking_fix", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_community_tracking_fix", Reflection.getOrCreateKotlinClass(r1), "社区埋点修复", "ranxiongxiong"));
        UltraSettingsManager.b("float_window_retain_dialog_frequency_control_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("float_window_retain_dialog_frequency_control_config", Reflection.getOrCreateKotlinClass(l5.class), "场景小窗挽留弹窗频控配置", "ranxiongxiong"));
        UltraSettingsManager.b("live_linkmic_fast_match_api_max_request_count", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_linkmic_fast_match_api_max_request_count", Reflection.getOrCreateKotlinClass(r2), "新增推荐列表快速匹配最大匹配次数", "ranxiongxiong"));
        UltraSettingsManager.b("live_safe_create_live_core_client", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_safe_create_live_core_client", Reflection.getOrCreateKotlinClass(r1), "临时: 保护LiveClientClient被创建多次的情况", "ranxiongxiong"));
        UltraSettingsManager.b("live_video_talk_bg_device_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_video_talk_bg_device_config", Reflection.getOrCreateKotlinClass(VideoTalkBgDeviceConfig.class), "视频聊天室静态背景降级机型打分", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_room_singer_lyrics_frequent", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_room_singer_lyrics_frequent", Reflection.getOrCreateKotlinClass(r3), "ktv演唱者歌词帧率", "ranxiongxiong"));
        UltraSettingsManager.b("multi_link_enter_room_log_extra_params", new com.bytedance.tools.kcp.ultrasettings.runtime.c("multi_link_enter_room_log_extra_params", Reflection.getOrCreateKotlinClass(r1), "多人场景进房埋点上报链路细节耗时", "ranxiongxiong"));
        UltraSettingsManager.b("interact_keep_audio_permisson_white_activity", new com.bytedance.tools.kcp.ultrasettings.runtime.c("interact_keep_audio_permisson_white_activity", y, "跳转目标activity，保持音频的白名单页面", "ranxiongxiong"));
        UltraSettingsManager.b("live_solo_ktv_sing_volume_scale", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_solo_ktv_sing_volume_scale", Reflection.getOrCreateKotlinClass(r4), "个人练歌房录制页音量放大倍数", "ranxiongxiong"));
        UltraSettingsManager.b("ttlive_link_guest_clean_optimize", new com.bytedance.tools.kcp.ultrasettings.runtime.c("ttlive_link_guest_clean_optimize", Reflection.getOrCreateKotlinClass(r1), "嘉宾连线场景支持清屏优化", "ranxiongxiong"));
        UltraSettingsManager.b("live_new_ktv_default_vid", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_new_ktv_default_vid", Reflection.getOrCreateKotlinClass(String.class), "兜底mv配置", "ranxiongxiong"));
        UltraSettingsManager.b("live_talk_room_support_room_data_sync_for_msg", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_talk_room_support_room_data_sync_for_msg", Reflection.getOrCreateKotlinClass(r1), "聊天室msg消息是否使用本地数据同步麦位列表", "ranxiongxiong"));
        UltraSettingsManager.b("live_real_time_chorus_room_order_count_limit", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_real_time_chorus_room_order_count_limit", Reflection.getOrCreateKotlinClass(r3), "实时合唱点歌上限", "ranxiongxiong"));
        UltraSettingsManager.b("video_audience_apply_reason_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("video_audience_apply_reason_enable", Reflection.getOrCreateKotlinClass(r3), "视频聊天室观众支持申请理由", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_sentence_rate", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_sentence_rate", z, "live_ktv_sentence_rate", "ranxiongxiong"));
        UltraSettingsManager.b("live_self_discipline_disconnect_intercept", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_self_discipline_disconnect_intercept", Reflection.getOrCreateKotlinClass(r1), "是否通过拦截连线退出弹窗展示自律时长", "ranxiongxiong"));
        UltraSettingsManager.b("live_enable_audience_chat_opt_group", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_enable_audience_chat_opt_group", Reflection.getOrCreateKotlinClass(r3), "双人聊观众端优化", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_mv_player_scaletype_toggle", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_mv_player_scaletype_toggle", Reflection.getOrCreateKotlinClass(r1), "mv模式scaletype开关", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_audience_midi_load_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_audience_midi_load_opt", Reflection.getOrCreateKotlinClass(r1), "K歌组件观众侧midi加载优化", "ranxiongxiong"));
        UltraSettingsManager.b("live_solo_ktv_personal_karaoke_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_solo_ktv_personal_karaoke_enable", Reflection.getOrCreateKotlinClass(r3), "直播个唱工具", "ranxiongxiong"));
        UltraSettingsManager.b("multi_link_voice_chat_feature_list_filter", new com.bytedance.tools.kcp.ultrasettings.runtime.c("multi_link_voice_chat_feature_list_filter", Reflection.getOrCreateKotlinClass(r1), "语音聊天室观众uiFeatureList过滤", "guoyunguang"));
        UltraSettingsManager.b("live_preview_load_common_widget_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_preview_load_common_widget_opt", Reflection.getOrCreateKotlinClass(r1), "loadMultiLinkCommonWidget逻辑改造", "ranxiongxiong"));
        UltraSettingsManager.b("live_guest_send_gift_rule", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_guest_send_gift_rule", Reflection.getOrCreateKotlinClass(String.class), "允许观众给嘉宾送礼规则页链接", "ranxiongxiong"));
        UltraSettingsManager.b("list_user_version_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("list_user_version_config", Reflection.getOrCreateKotlinClass(z01.class), "观众连麦用户列表版本号配置", "ranxiongxiong"));
        UltraSettingsManager.b("audience_interact_match_api_max_request_count", new com.bytedance.tools.kcp.ultrasettings.runtime.c("audience_interact_match_api_max_request_count", Reflection.getOrCreateKotlinClass(r2), "最大匹配次数", "ranxiongxiong"));
        UltraSettingsManager.b("live_self_discipiline_mode_name", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_self_discipiline_mode_name", Reflection.getOrCreateKotlinClass(String.class), "自律模式改名", "ranxiongxiong"));
        UltraSettingsManager.b("live_solo_ktv_play_stop_progress_gap", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_solo_ktv_play_stop_progress_gap", Reflection.getOrCreateKotlinClass(r3), "个人练歌房stop回调和progress之间的GAP", "ranxiongxiong"));
        UltraSettingsManager.b("live_new_ktv_mv_vid_reuse", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_new_ktv_mv_vid_reuse", Reflection.getOrCreateKotlinClass(r1), "新ktv vid复用修复", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_rt_chours_feedback_panel_fix", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_rt_chours_feedback_panel_fix", Reflection.getOrCreateKotlinClass(r1), "实时合唱主播侧反馈面板不隐藏修复", "ranxiongxiong"));
        UltraSettingsManager.b("multi_link_radio_widget_wh_adjust_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("multi_link_radio_widget_wh_adjust_opt", Reflection.getOrCreateKotlinClass(r1), "多人场景RadioWidget宽高适配优化", "ranxiongxiong"));
        UltraSettingsManager.b("linkmic_activity_position_leave_page", new com.bytedance.tools.kcp.ultrasettings.runtime.c("linkmic_activity_position_leave_page", Reflection.getOrCreateKotlinClass(r1), "直播间是否开启连线结束面板", "ranxiongxiong"));
        UltraSettingsManager.b("live_turn_on_opt_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_turn_on_opt_enable", Reflection.getOrCreateKotlinClass(r1), "开启RTC超时leave channel", "ranxiongxiong"));
        UltraSettingsManager.b("live_linkmic_admin_privilege_setting_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_linkmic_admin_privilege_setting_opt", Reflection.getOrCreateKotlinClass(r1), "聊天室管理员权限设置面板迁移到前端面板", "ranxiongxiong"));
        UltraSettingsManager.b("live_audience_video_talk_room_ktv_refact_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_audience_video_talk_room_ktv_refact_enable", Reflection.getOrCreateKotlinClass(r1), "K歌组件观众侧兜底开关", "ranxiongxiong"));
        UltraSettingsManager.b("live_block_code_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_block_code_opt", Reflection.getOrCreateKotlinClass(r1), "比较零散的耗时逻辑优化", "ranxiongxiong"));
        UltraSettingsManager.b("live_live_rtc_sei_debug_log", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_live_rtc_sei_debug_log", Reflection.getOrCreateKotlinClass(r1), "是否打印RTC SEI日志", "zengle"));
        UltraSettingsManager.b("multi_link_can_show_position_name_in_feed", new com.bytedance.tools.kcp.ultrasettings.runtime.c("multi_link_can_show_position_name_in_feed", Reflection.getOrCreateKotlinClass(r1), "预览流场景是否可以展示麦位标签", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_comp_opt_switch", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_comp_opt_switch", Reflection.getOrCreateKotlinClass(r1), "K歌组件优化需求强制开关", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_chorus_home_page_text", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_chorus_home_page_text", Reflection.getOrCreateKotlinClass(String.class), "实时合唱主页说明文案", "ranxiongxiong"));
        UltraSettingsManager.b("live_block_real_name_verify_jsb_callback", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_block_real_name_verify_jsb_callback", Reflection.getOrCreateKotlinClass(r1), "多人场景实名认证时屏蔽JSB老接口回调", "ranxiongxiong"));
        UltraSettingsManager.b("ktv_sei_singing_state_judge", new com.bytedance.tools.kcp.ultrasettings.runtime.c("ktv_sei_singing_state_judge", Reflection.getOrCreateKotlinClass(r1), "ktv场景听众对于演唱状态感知判断优化", "ranxiongxiong"));
        UltraSettingsManager.b("live_link_list_use_content", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_link_list_use_content", Reflection.getOrCreateKotlinClass(r1), "连麦列表是否用content，废弃extra", "ranxiongxiong"));
        UltraSettingsManager.b("live_rt_chorus_support_priority_download_music", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_rt_chorus_support_priority_download_music", Reflection.getOrCreateKotlinClass(r1), "合唱派对支持优先下载歌曲", "ranxiongxiong"));
        UltraSettingsManager.b("enable_link_beauty", new com.bytedance.tools.kcp.ultrasettings.runtime.c("enable_link_beauty", Reflection.getOrCreateKotlinClass(r1), "是否支持连麦美颜", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_performance_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_performance_opt", Reflection.getOrCreateKotlinClass(r1), "KTV性能优化", "ranxiongxiong"));
        UltraSettingsManager.b("live_voice_chat_room_switch_scene_before_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_voice_chat_room_switch_scene_before_enable", Reflection.getOrCreateKotlinClass(r1), "语音聊天室布局切换事件监听", "ranxiongxiong"));
        UltraSettingsManager.b("live_dismiss_ktv_component_widget_destroy_leave", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_dismiss_ktv_component_widget_destroy_leave", Reflection.getOrCreateKotlinClass(r1), "用户退房K歌组件不触发leave", "ranxiongxiong"));
        UltraSettingsManager.b("live_guest_battle_upgrade_switch", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_guest_battle_upgrade_switch", Reflection.getOrCreateKotlinClass(r1), "大作战争前三全量开关", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_force_close_ktv_component_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_force_close_ktv_component_enable", Reflection.getOrCreateKotlinClass(r1), "语音KTV和合唱派对加载强制关闭K歌组件", "ranxiongxiong"));
        UltraSettingsManager.b("link_interact_emoji_panel_single_row", new com.bytedance.tools.kcp.ultrasettings.runtime.c("link_interact_emoji_panel_single_row", Reflection.getOrCreateKotlinClass(r1), "互动表情面板是否是单排", "ranxiongxiong"));
        UltraSettingsManager.b("live_linkmic_disable_bigevent", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_linkmic_disable_bigevent", Reflection.getOrCreateKotlinClass(r1), "连线重保平台消息功能", "ranxiongxiong"));
        UltraSettingsManager.b("live_order_sing_stage_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_order_sing_stage_config", Reflection.getOrCreateKotlinClass(dd1.class), "你点我唱舞台区兜底文案配置", "ranxiongxiong"));
        UltraSettingsManager.b("live_real_time_chorus_anim_delay_millis", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_real_time_chorus_anim_delay_millis", Reflection.getOrCreateKotlinClass(r2), "合唱派对加入合唱按钮扫光动画延迟显示时间", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_midi_swicth_default_status", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_midi_swicth_default_status", Reflection.getOrCreateKotlinClass(a9.class), "打分补偿", "ranxiongxiong"));
        UltraSettingsManager.b("live_order_song_dialog_recommend_api_switch", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_order_song_dialog_recommend_api_switch", Reflection.getOrCreateKotlinClass(r1), "点歌台推荐Tab接口重构", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_draw_frequency", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_draw_frequency", Reflection.getOrCreateKotlinClass(r2), "ktv全局绘制频率", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_use_full_screen_theme", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_use_full_screen_theme", Reflection.getOrCreateKotlinClass(r2), "ktv是否使用主题自带的背景图", "ranxiongxiong"));
        UltraSettingsManager.b("live_multilink_micseat_fast_gift_ab", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multilink_micseat_fast_gift_ab", Reflection.getOrCreateKotlinClass(r3), "快捷送礼用户侧实验", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_room_midi_score_get_time", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_room_midi_score_get_time", Reflection.getOrCreateKotlinClass(r2), "midi模式获取打分频率", "ranxiongxiong"));
        UltraSettingsManager.b("live_audio_chat_stage_enter_room_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_audio_chat_stage_enter_room_opt", Reflection.getOrCreateKotlinClass(r1), "优化预览流进房舞台区麦位逻辑", "ranxiongxiong"));
        UltraSettingsManager.b("interact_permission_guarantor_check_content", new com.bytedance.tools.kcp.ultrasettings.runtime.c("interact_permission_guarantor_check_content", A, "跳转目标activity，释放音频权限的名单", "ranxiongxiong"));
        UltraSettingsManager.b("live_digit_avatar_experience_optimization_switch", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_digit_avatar_experience_optimization_switch", Reflection.getOrCreateKotlinClass(r1), "数字人体验优化开关", "ranxiongxiong"));
        UltraSettingsManager.b("live_saas_room_fight_public_stream_switch_to_single_view", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_saas_room_fight_public_stream_switch_to_single_view", Reflection.getOrCreateKotlinClass(r1), "saas厅战公共流走单view", "ranxiongxiong"));
        UltraSettingsManager.b("multilink_use_new_permission_timon", new com.bytedance.tools.kcp.ultrasettings.runtime.c("multilink_use_new_permission_timon", Reflection.getOrCreateKotlinClass(r1), "使用timon来管控权限申请", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_midi_hit_score", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_midi_hit_score", Reflection.getOrCreateKotlinClass(r4), "midi分数", "ranxiongxiong"));
        UltraSettingsManager.b("multi_link_audio_permission_task_delay", new com.bytedance.tools.kcp.ultrasettings.runtime.c("multi_link_audio_permission_task_delay", Reflection.getOrCreateKotlinClass(r2), "多人场景的音频采集白名单机制任务延时配置", "ranxiongxiong"));
        UltraSettingsManager.b("live_solo_ktv_entry_image_url", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_solo_ktv_entry_image_url", Reflection.getOrCreateKotlinClass(String.class), "个人练唱点歌台入口图片配置", "ranxiongxiong"));
        UltraSettingsManager.b("live_paid_link_add_price_fix_switch", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_paid_link_add_price_fix_switch", Reflection.getOrCreateKotlinClass(r1), "付费连线加价兜底开关", "ranxiongxiong"));
        UltraSettingsManager.b("live_multi_link_gson_optimize", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_link_gson_optimize", Reflection.getOrCreateKotlinClass(r1), "多人动态化传入JsonObject优化", "yezhichao"));
        UltraSettingsManager.b("video_talk_pos_sei_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("video_talk_pos_sei_enable", Reflection.getOrCreateKotlinClass(r1), "pos字段为空时是否写入sei", "ranxiongxiong"));
        UltraSettingsManager.b("live_multi_link_is_not_engine_on_support_silence", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_link_is_not_engine_on_support_silence", Reflection.getOrCreateKotlinClass(r1), "多人场景主播未加入连麦是否支持静音", "ranxiongxiong"));
        UltraSettingsManager.b("live_solo_ktv_audiokit_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_solo_ktv_audiokit_opt", Reflection.getOrCreateKotlinClass(r1), "个人练歌房替换为Audiiokit false: ByteAudio, true: audiokit", "ranxiongxiong"));
        UltraSettingsManager.b("live_social_matrix_page", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_social_matrix_page", Reflection.getOrCreateKotlinClass(t51.class), "直播关联矩阵详情页lynx配置", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_performance_optimize_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_performance_optimize_enable", Reflection.getOrCreateKotlinClass(r1), "K歌&KTV性能优化", "ranxiongxiong"));
        UltraSettingsManager.b("multi_link_pc_horizontal_disable_linkmic", new com.bytedance.tools.kcp.ultrasettings.runtime.c("multi_link_pc_horizontal_disable_linkmic", Reflection.getOrCreateKotlinClass(r1), "伴侣横屏开播观众横屏开播禁止在横屏上麦，需要切换到竖屏", "ranxiongxiong"));
        UltraSettingsManager.b("live_multi_order_sing_launch_panel_url", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_order_sing_launch_panel_url", Reflection.getOrCreateKotlinClass(String.class), "你点我唱玩法打开礼物选择界面", "ranxiongxiong"));
        UltraSettingsManager.b("live_core_single_view_mode_trigger_fps", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_core_single_view_mode_trigger_fps", Reflection.getOrCreateKotlinClass(r2), "单View模式开启triggerTask下的帧率", "ranxiongxiong"));
        UltraSettingsManager.b("live_3d_fly_mic_delay", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_3d_fly_mic_delay", Reflection.getOrCreateKotlinClass(r2), "多人场景3d飞麦礼物播放延迟", "ranxiongxiong"));
        UltraSettingsManager.b("multi_link_sei_canvas_backup_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("multi_link_sei_canvas_backup_opt", Reflection.getOrCreateKotlinClass(r1), "多人场景createSei兜底逻辑优化", "ranxiongxiong"));
        UltraSettingsManager.b("live_link_security_check_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_link_security_check_enable", Reflection.getOrCreateKotlinClass(r1), "多人场景音视频在线检测开关", "ranxiongxiong"));
        UltraSettingsManager.b("live_linkmic_post_online_state_switch", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_linkmic_post_online_state_switch", Reflection.getOrCreateKotlinClass(r1), "去除joinChannelSuceess时直接改为在线状态", "ranxiongxiong"));
        UltraSettingsManager.b("live_interact_audience_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_interact_audience_enable", Reflection.getOrCreateKotlinClass(r1), "抖音观众连线入口", "ranxiongxiong"));
        UltraSettingsManager.b("audience_interact_enable_fast_match", new com.bytedance.tools.kcp.ultrasettings.runtime.c("audience_interact_enable_fast_match", Reflection.getOrCreateKotlinClass(r1), "语音聊天室快速匹配开关", "ranxiongxiong"));
        UltraSettingsManager.b("live_im_send_sei_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_im_send_sei_config", Reflection.getOrCreateKotlinClass(us1.a.class), "直播流信息发送配置", "ranxiongxiong"));
        UltraSettingsManager.b("voice_anchor_apply_reason_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("voice_anchor_apply_reason_enable", Reflection.getOrCreateKotlinClass(r3), "语音聊天室主播支持申请理由", "ranxiongxiong"));
        UltraSettingsManager.b("live_multi_link_voice_switch_scene_pause_stream_fix", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_link_voice_switch_scene_pause_stream_fix", Reflection.getOrCreateKotlinClass(r1), "语音场景下切换场景因为时序问题导致误停止cdn流修复开关", "ranxiongxiong"));
        UltraSettingsManager.b("live_enable_equal_talk_room", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_enable_equal_talk_room", Reflection.getOrCreateKotlinClass(r1), "开启平权布局切换", "ranxiongxiong"));
        UltraSettingsManager.b("talk_room_rtc_sei_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("talk_room_rtc_sei_enable", Reflection.getOrCreateKotlinClass(r1), "聊天室开启非关键帧SEI", "ranxiongxiong"));
        UltraSettingsManager.b("live_link_room_fight_force_server_mix", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_link_room_fight_force_server_mix", Reflection.getOrCreateKotlinClass(r1), "跨房厅战是否强制服务端合流", "ranxiongxiong"));
        UltraSettingsManager.b("live_multi_link_link_debug_log_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_link_link_debug_log_enable", Reflection.getOrCreateKotlinClass(r1), "多人场景连麦debug log 打印开关", "ranxiongxiong"));
        UltraSettingsManager.b("video_talk_spatial_audio_position_interval", new com.bytedance.tools.kcp.ultrasettings.runtime.c("video_talk_spatial_audio_position_interval", Reflection.getOrCreateKotlinClass(r3), "视频聊天室空间音频位置间隔", "ranxiongxiong"));
        UltraSettingsManager.b("live_order_sing_mv_check_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_order_sing_mv_check_config", Reflection.getOrCreateKotlinClass(n8.class), "你点我唱mv sei check", "ranxiongxiong"));
        UltraSettingsManager.b("live_rt_chorus_update_sing_status_fix", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_rt_chorus_update_sing_status_fix", Reflection.getOrCreateKotlinClass(r1), "合唱派对更新演唱状态时机修复", "ranxiongxiong"));
        UltraSettingsManager.b("live_linkmic_multi_audio_mcu_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_linkmic_multi_audio_mcu_enable", Reflection.getOrCreateKotlinClass(r1), "跨房厅战语音场景使用mcu方案", "ranxiongxiong"));
        UltraSettingsManager.b("live_attention_room_lynx", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_attention_room_lynx", Reflection.getOrCreateKotlinClass(yg1.class), "自律模式Lynx资源配置", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_guest_multi_chorus_performance_limit", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_guest_multi_chorus_performance_limit", Reflection.getOrCreateKotlinClass(r4), "嘉宾支持一起唱最低机型打分要求", "ranxiongxiong"));
        UltraSettingsManager.b("multi_link_voice_chat_customize_stream_delay", new com.bytedance.tools.kcp.ultrasettings.runtime.c("multi_link_voice_chat_customize_stream_delay", Reflection.getOrCreateKotlinClass(r2), "语音聊天室投屏布局延时切换头像和背景", "zhanghao"));
        UltraSettingsManager.b("LIVE_MULTILINK_LINK_MOCK_CONFIG", new com.bytedance.tools.kcp.ultrasettings.runtime.c("LIVE_MULTILINK_LINK_MOCK_CONFIG", Reflection.getOrCreateKotlinClass(t01.class), "多人场景连线Mock开关", "ranxiongxiong"));
        UltraSettingsManager.b("rtc_guest_opt_volume", new com.bytedance.tools.kcp.ultrasettings.runtime.c("rtc_guest_opt_volume", Reflection.getOrCreateKotlinClass(r3), "嘉宾侧音量增益", "ranxiongxiong"));
        UltraSettingsManager.b("live_room_fight_settting_update_to_admin", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_room_fight_settting_update_to_admin", Reflection.getOrCreateKotlinClass(r1), "厅战配置更新后，同步给管理员和主播", "ranxiongxiong"));
        UltraSettingsManager.b("live_preview_multi_link_widget_try_load_by_room_for_radio", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_preview_multi_link_widget_try_load_by_room_for_radio", Reflection.getOrCreateKotlinClass(r1), "电台预览流走tryLoadByRoom逻辑解决伴侣电台黑产推流不展示预览流问题", "ranxiongxiong"));
        UltraSettingsManager.b("ktv_chorus_role_silence_leave_fix_close", new com.bytedance.tools.kcp.ultrasettings.runtime.c("ktv_chorus_role_silence_leave_fix_close", Reflection.getOrCreateKotlinClass(r1), "实时合唱静默副唱退出合唱修复", "ranxiongxiong"));
        UltraSettingsManager.b("live_chat_channel_activity_permisstion_guarantor_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_chat_channel_activity_permisstion_guarantor_enable", Reflection.getOrCreateKotlinClass(r1), "频道房连麦音视频权限释放白名单页面机制开关", "ranxiongxiong"));
        UltraSettingsManager.b("live_linkmic_dynamic_island_layout_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_linkmic_dynamic_island_layout_config", Reflection.getOrCreateKotlinClass(k51.class), "灵活布局兜底配置", "ranxiongxiong"));
        UltraSettingsManager.b("live_multi_link_status_bar_visible_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_link_status_bar_visible_opt", Reflection.getOrCreateKotlinClass(r1), "多人场景布局状态栏适配", "ranxiongxiong"));
        UltraSettingsManager.b("multi_link_play_mode_config_self_discipline", new com.bytedance.tools.kcp.ultrasettings.runtime.c("multi_link_play_mode_config_self_discipline", Reflection.getOrCreateKotlinClass(r1), "多人场景玩法配置自律模式打卡排行开关", "ranxiongxiong"));
        UltraSettingsManager.b("live_audio_anchor_send_no_link_sei", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_audio_anchor_send_no_link_sei", Reflection.getOrCreateKotlinClass(r1), "语音聊天室无人连线sei发送控制开关", "ranxiongxiong"));
        UltraSettingsManager.b("live_guest_battle_anchor_effect_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_guest_battle_anchor_effect_enable", Reflection.getOrCreateKotlinClass(r1), "大作战主播effect开关", "ranxiongxiong"));
        UltraSettingsManager.b("live_interaction_competition_graphic_resource_url_list", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_interaction_competition_graphic_resource_url_list", Reflection.getOrCreateKotlinClass(LiveThemedCompetitionResourceUrlConfig.class), "主题比赛图片资源", "ranxiongxiong"));
        UltraSettingsManager.b("live_multi_link_recommend_room_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_link_recommend_room_opt", Reflection.getOrCreateKotlinClass(rb1.class), "多人场景推荐房间优化", "ranxiongxiong"));
        UltraSettingsManager.b("multi_link_live_player_layout_size_changed_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("multi_link_live_player_layout_size_changed_opt", Reflection.getOrCreateKotlinClass(r1), "多人场景通用布局播放器LayoutSize适配开关", "ranxiongxiong"));
        UltraSettingsManager.b("live_dynamic_container_setting_preload_list", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_dynamic_container_setting_preload_list", B, "startEvent携带setting", "ranxiongxiong"));
        UltraSettingsManager.b("live_interact_xplay_mix_frame_reinit_count_limit", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_interact_xplay_mix_frame_reinit_count_limit", Reflection.getOrCreateKotlinClass(r3), "多人场景开启云游戏后的自定义合流重置限制次数", "ranxiongxiong"));
        UltraSettingsManager.b("live_linkmic_weak_distribution_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_linkmic_weak_distribution_config", C, "连线分发状态设置面板信息", "ranxiongxiong"));
        UltraSettingsManager.b("live_chat_channel_enable_audio_trace_upload", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_chat_channel_enable_audio_trace_upload", Reflection.getOrCreateKotlinClass(r1), "频道房连麦trace上报", "ranxiongxiong"));
        UltraSettingsManager.b("link_link_camera_backup_switch", new com.bytedance.tools.kcp.ultrasettings.runtime.c("link_link_camera_backup_switch", Reflection.getOrCreateKotlinClass(ILiveLinkCameraBackUpConfig.class), "多人场景嘉宾摄像头状态bad case兜底", "ranxiongxiong"));
        UltraSettingsManager.b("live_core_single_view_mode_for_anchor_stream_switch_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_core_single_view_mode_for_anchor_stream_switch_enable", Reflection.getOrCreateKotlinClass(r1), "重保场景是否支持开启单View模式", "ranxiongxiong"));
        UltraSettingsManager.b("talk_room_fulllink_disable_list", new com.bytedance.tools.kcp.ultrasettings.runtime.c("talk_room_fulllink_disable_list", D, "多人场景全链路上报屏蔽名单，命中的不上报", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_sei_progress_update_threshold", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_sei_progress_update_threshold", Reflection.getOrCreateKotlinClass(r2), "sei进度更新阈值", "ranxiongxiong"));
        UltraSettingsManager.b("live_ksong_destory_fix", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ksong_destory_fix", Reflection.getOrCreateKotlinClass(r1), "k歌组件退出释放修复", "ranxiongxiong"));
        UltraSettingsManager.b("live_audio_subtitle_setting", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_audio_subtitle_setting", Reflection.getOrCreateKotlinClass(LiveAudioSubtitleSetting.class), "语音聊天室实时字幕开关", "ranxiongxiong"));
        UltraSettingsManager.b("live_enable_rtc_sei_for_video_talk_room", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_enable_rtc_sei_for_video_talk_room", Reflection.getOrCreateKotlinClass(r1), "视频聊天室语音模式开启替换黑帧SEI优化", "ranxiongxiong"));
        UltraSettingsManager.b("live_multi_link_load_play_mode_manager_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_link_load_play_mode_manager_opt", Reflection.getOrCreateKotlinClass(r1), "仅命中基础进房优化时KTV场景提前初始化playModeManager", "ranxiongxiong"));
        UltraSettingsManager.b("ktv_singing_hot_rank", new com.bytedance.tools.kcp.ultrasettings.runtime.c("ktv_singing_hot_rank", Reflection.getOrCreateKotlinClass(e9.class), "演唱热门榜是否开启展示", "ranxiongxiong"));
        UltraSettingsManager.b("voice_chat_anchor_mic_seat_refresh", new com.bytedance.tools.kcp.ultrasettings.runtime.c("voice_chat_anchor_mic_seat_refresh", Reflection.getOrCreateKotlinClass(r1), "语音聊天室麦位Anchor View刷新开关", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_enable_ktv_countdown", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_enable_ktv_countdown", Reflection.getOrCreateKotlinClass(r1), "ktv倒计时兜底开关", "ranxiongxiong"));
        UltraSettingsManager.b("live_link_multi_enlarge_float_window_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_link_multi_enlarge_float_window_enable", Reflection.getOrCreateKotlinClass(r1), "浮窗布局是否支持多主咖模式", "ranxiongxiong"));
        UltraSettingsManager.b("live_multi_ktv_avatar_resources", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_ktv_avatar_resources", Reflection.getOrCreateKotlinClass(y8.class), "ktv avatar数字人相关的资源配置", "ranxiongxiong"));
        UltraSettingsManager.b("live_interact_bg_pre_upload_bg_types", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_interact_bg_pre_upload_bg_types", E, "开播页预上传背景生效类型", "lilin.darling"));
        UltraSettingsManager.b("live_ktv_scale_style_radio", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_scale_style_radio", Reflection.getOrCreateKotlinClass(r4), "KTV  scaleType 切换比例", "ranxiongxiong"));
        UltraSettingsManager.b("ktv_hardware_echo_ab", new com.bytedance.tools.kcp.ultrasettings.runtime.c("ktv_hardware_echo_ab", Reflection.getOrCreateKotlinClass(r1), "ktv硬件耳返实验", "ranxiongxiong"));
        UltraSettingsManager.b("live_use_new_toolbar_icon", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_use_new_toolbar_icon", Reflection.getOrCreateKotlinClass(r1), "是否使用新的toolbar图片", "ranxiongxiong"));
        UltraSettingsManager.b("live_multi_link_preview_force_list_v2_mic_room", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_link_preview_force_list_v2_mic_room", Reflection.getOrCreateKotlinClass(r1), "多人场景预览流麦序房强制使用list/v2更新麦位数据", "ranxiongxiong"));
        UltraSettingsManager.b("live_guest_link_reapply_double_check", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_guest_link_reapply_double_check", Reflection.getOrCreateKotlinClass(r1), "嘉宾连线复联是否需要二次弹窗确认", "ranxiongxiong"));
        UltraSettingsManager.b("live_interaction_audience_waiting_list_show", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_interaction_audience_waiting_list_show", Reflection.getOrCreateKotlinClass(r3), "观众侧支持新的申请面板", "ranxiongxiong"));
        UltraSettingsManager.b("live_hamlet_avatar_stream_config_v2", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_hamlet_avatar_stream_config_v2", Reflection.getOrCreateKotlinClass(HamletLiveMediaMockConfig.class), "hamlet avatar二期直播流媒体参数配置", "ranxiongxiong"));
        UltraSettingsManager.b("live_multi_pub_stream_fall_back_protect", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_pub_stream_fall_back_protect", Reflection.getOrCreateKotlinClass(r1), "跨房厅战公共流回退到跨房流后，首帧回调到来不再mute跨房流", "ranxiongxiong"));
        UltraSettingsManager.b("live_voice_chat_room_support_ktv_room", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_voice_chat_room_support_ktv_room", Reflection.getOrCreateKotlinClass(r1), "语音聊天室是否支持K房模式", "ranxiongxiong"));
        UltraSettingsManager.b("live_multi_link_first_frame_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_link_first_frame_opt", Reflection.getOrCreateKotlinClass(MultiLinkFirstFrameOptConfig.class), "是否支持多人场景内流首帧加载优化", "ranxiongxiong"));
        UltraSettingsManager.b("new_video_linkmic_check_top_activity_when_target_page_hide", new com.bytedance.tools.kcp.ultrasettings.runtime.c("new_video_linkmic_check_top_activity_when_target_page_hide", Reflection.getOrCreateKotlinClass(r1), "新视频连 fragmentdetatch的时候检查top activity", "wuzhixin.jensen"));
        UltraSettingsManager.b("live_real_time_chorus_online_list_change_revert", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_real_time_chorus_online_list_change_revert", Reflection.getOrCreateKotlinClass(r1), "实时合唱演唱嘉宾列表优化回退", "ranxiongxiong"));
        UltraSettingsManager.b("live_link_room_fight_support_wrds", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_link_room_fight_support_wrds", Reflection.getOrCreateKotlinClass(r1), "跨房厅战是否支持WRDS", "ranxiongxiong"));
        UltraSettingsManager.b("multi_link_livecore_interface_refactor", new com.bytedance.tools.kcp.ultrasettings.runtime.c("multi_link_livecore_interface_refactor", Reflection.getOrCreateKotlinClass(r1), "多人场景音频调用收敛", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_rt_chorus_launch_page_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_rt_chorus_launch_page_opt", Reflection.getOrCreateKotlinClass(r1), "个唱实时合唱页面改造", "ranxiongxiong"));
        UltraSettingsManager.b("live_matrix_support_cur_app", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_matrix_support_cur_app", Reflection.getOrCreateKotlinClass(r1), "当前宿主是否支持关联矩阵", "ranxiongxiong"));
        UltraSettingsManager.b("new_video_link_alog_disable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("new_video_link_alog_disable", Reflection.getOrCreateKotlinClass(r1), "【新视频连线】ALog开关", "yezhichao"));
        UltraSettingsManager.b("live_interact_playmode_select_panel_schema", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_interact_playmode_select_panel_schema", Reflection.getOrCreateKotlinClass(fe1.class), "连线玩开启面板url复合字段", "ranxiongxiong"));
        UltraSettingsManager.b("live_real_time_chorus_midi_sore_mock", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_real_time_chorus_midi_sore_mock", Reflection.getOrCreateKotlinClass(of1.class), "实时合唱midi评分mock", "ranxiongxiong"));
        UltraSettingsManager.b("live_interact_preview_show_seatLabels", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_interact_preview_show_seatLabels", Reflection.getOrCreateKotlinClass(r1), "多人场景预览流支持标签外显", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_midi_cal_factor_dict", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_midi_cal_factor_dict", Reflection.getOrCreateKotlinClass(z8.class), "K歌midi计算系数", "ranxiongxiong"));
        UltraSettingsManager.b("live_big_event_enable_local", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_big_event_enable_local", Reflection.getOrCreateKotlinClass(r1), "重保事件本地开关", "ranxiongxiong"));
        UltraSettingsManager.b("live_multi_ktv_avatar_enabled_anchor", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_ktv_avatar_enabled_anchor", Reflection.getOrCreateKotlinClass(r1), "主播是否可以开启Ktv数字人虚拟形象", "ranxiongxiong"));
        UltraSettingsManager.b("multi_link_base_common_window_feed_view_display_when_guest_list_ready", new com.bytedance.tools.kcp.ultrasettings.runtime.c("multi_link_base_common_window_feed_view_display_when_guest_list_ready", Reflection.getOrCreateKotlinClass(r1), "通用布局预览流调整麦位显示时机", "ranxiongxiong"));
        UltraSettingsManager.b("live_dynamic_toolbar_modify_linkmic", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_dynamic_toolbar_modify_linkmic", Reflection.getOrCreateKotlinClass(r1), "toolbar动态化改造接入连线", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_retry_delay", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_retry_delay", Reflection.getOrCreateKotlinClass(r3), "ktv重试次数", "ranxiongxiong"));
        UltraSettingsManager.b("live_backup_sei_setting_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_backup_sei_setting_config", Reflection.getOrCreateKotlinClass(LiveBackupSeiSettingConfig.class), "备份SEI框架开关配置", "ranxiongxiong"));
        UltraSettingsManager.b("LIVE_KSONG_LYRIC_OPEN", new com.bytedance.tools.kcp.ultrasettings.runtime.c("LIVE_KSONG_LYRIC_OPEN", Reflection.getOrCreateKotlinClass(r1), "LIVE_KSONG_LYRIC_OPEN", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_challenge_theme_id", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_challenge_theme_id", Reflection.getOrCreateKotlinClass(r2), "ktv演唱挑战主题ID", "ranxiongxiong"));
        UltraSettingsManager.b("slolo_ktv_permission_guarantor_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("slolo_ktv_permission_guarantor_enable", Reflection.getOrCreateKotlinClass(r1), "个人练歌房视频权限释放白名单页面机制开关", "ranxiongxiong"));
        UltraSettingsManager.b("live_video_avatar_performance_limit_anchor", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_video_avatar_performance_limit_anchor", Reflection.getOrCreateKotlinClass(r4), "视频聊天室使用avatar最低机型打分要求-for主播", "ranxiongxiong"));
        UltraSettingsManager.b("live_radio_preview_enable_preload", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_radio_preview_enable_preload", Reflection.getOrCreateKotlinClass(r1), "语音电台预览流是否开启内流预加载", "wuzhixin.jensen"));
        UltraSettingsManager.b("video_talk_margin_top", new com.bytedance.tools.kcp.ultrasettings.runtime.c("video_talk_margin_top", Reflection.getOrCreateKotlinClass(r3), "顶部距离", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_seat_anim_update", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_seat_anim_update", Reflection.getOrCreateKotlinClass(r1), "ktv动效更新开关", "ranxiongxiong"));
        UltraSettingsManager.b("live_video_ktv_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_video_ktv_enable", Reflection.getOrCreateKotlinClass(r1), "视频KTV入口AB", "ranxiongxiong"));
        UltraSettingsManager.b("live_video_interact_in_progress_can_not_apply", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_video_interact_in_progress_can_not_apply", Reflection.getOrCreateKotlinClass(r1), "saas 主播连线中暂不支持观众连线", "ranxiongxiong"));
        UltraSettingsManager.b("live_enable_rtc_sei_for_audio", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_enable_rtc_sei_for_audio", Reflection.getOrCreateKotlinClass(r1), "语音场景开启替换黑帧SEI优化", "ranxiongxiong"));
        UltraSettingsManager.b("live_link_video_exp_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_link_video_exp_opt", Reflection.getOrCreateKotlinClass(r1), "连线视频体验优化", "ranxiongxiong"));
        UltraSettingsManager.b("live_teamfight_flexible_adjust_feed_in_party_layout", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_teamfight_flexible_adjust_feed_in_party_layout", Reflection.getOrCreateKotlinClass(r3), "在视频平权布局下更新灵活团战的下移参数", "ranxiongxiong"));
        UltraSettingsManager.b("multi_link_base_common_window_dynamic_talk_disable_theme", new com.bytedance.tools.kcp.ultrasettings.runtime.c("multi_link_base_common_window_dynamic_talk_disable_theme", Reflection.getOrCreateKotlinClass(r1), "动态浮窗布局屏蔽主题加载", "ranxiongxiong"));
        UltraSettingsManager.b("live_voice_ktv_lyric_use_surface_view", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_voice_ktv_lyric_use_surface_view", Reflection.getOrCreateKotlinClass(r1), "语音KTV 歌词使用SurfaceView", "ranxiongxiong"));
        UltraSettingsManager.b("live_intimatechat_switch_camera_supported", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_intimatechat_switch_camera_supported", Reflection.getOrCreateKotlinClass(r1), "是否允许切换摄像头", "ranxiongxiong"));
        UltraSettingsManager.b("live_pk_simple_atmosphere_animation_urls_v2", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_pk_simple_atmosphere_animation_urls_v2", Reflection.getOrCreateKotlinClass(com.bytedance.android.livesdk.model.h0.class), "pk运营氛围的一大堆动画url,pk降噪进行表情合并", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_lyric_recognization_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_lyric_recognization_config", Reflection.getOrCreateKotlinClass(j81.class), "AI歌词识别配置", "ranxiongxiong"));
        UltraSettingsManager.b("live_multi_audio_audience_see_audience_onSeat", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_audio_audience_see_audience_onSeat", Reflection.getOrCreateKotlinClass(r1), "聊天室观众是否展示预上麦列表ab", "ranxiongxiong"));
        UltraSettingsManager.b("multi_link_live_player_video_size_changed_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("multi_link_live_player_video_size_changed_opt", Reflection.getOrCreateKotlinClass(r1), "多人场景通用布局播放器VideoSize适配开关", "ranxiongxiong"));
        UltraSettingsManager.b("live_preview_enter_room_smooth_value", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_preview_enter_room_smooth_value", Reflection.getOrCreateKotlinClass(r3), "预览流/内流滑动进房优化", "ranxiongxiong"));
        UltraSettingsManager.b("live_multilink_new_video_link_lynx_card_leak_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multilink_new_video_link_lynx_card_leak_opt", Reflection.getOrCreateKotlinClass(r1), "新视频连线Lynx leak 修复", "wuzhixin.jensen"));
        UltraSettingsManager.b("live_multi_link_saas_support_game_entrance", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_link_saas_support_game_entrance", Reflection.getOrCreateKotlinClass(r1), "Saas是否支持管理员显示连线玩法入口", "ranxiongxiong"));
        UltraSettingsManager.b("big_party_enable_open_camera", new com.bytedance.tools.kcp.ultrasettings.runtime.c("big_party_enable_open_camera", Reflection.getOrCreateKotlinClass(r3), "嘉宾侧是否支持开聊天室", "ranxiongxiong"));
        UltraSettingsManager.b("live_pk_kick_out_reset_after_end_success", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_pk_kick_out_reset_after_end_success", Reflection.getOrCreateKotlinClass(r1), "浮窗布局下Pk踢人在onEndSuccess中提前reset", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_bgm_not_stop_switch", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_bgm_not_stop_switch", Reflection.getOrCreateKotlinClass(r1), "解决ktv bgm 未停止兜底开关", "ranxiongxiong"));
        UltraSettingsManager.b("live_linkmic_request_song_continue_broadcast_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_linkmic_request_song_continue_broadcast_opt", Reflection.getOrCreateKotlinClass(r1), "你点我唱断播续播优化", "ranxiongxiong"));
        UltraSettingsManager.b("live_check_linker_interval", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_check_linker_interval", Reflection.getOrCreateKotlinClass(r3), "连线id上传轮训间隔", "ranxiongxiong"));
        UltraSettingsManager.b("live_interact_new_message_disable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_interact_new_message_disable", Reflection.getOrCreateKotlinClass(r1), "连麦接入新消息开关", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_lyric_temp_callback_check", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_lyric_temp_callback_check", Reflection.getOrCreateKotlinClass(r1), "歌词回调校验.灰度前加上，加个开关", "ranxiongxiong"));
        UltraSettingsManager.b("multi_link_render_widget_accessibility_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("multi_link_render_widget_accessibility_opt", Reflection.getOrCreateKotlinClass(r1), "多人场景渲染容器屏蔽无障碍提示", "ranxiongxiong"));
        UltraSettingsManager.b("live_shake_match_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_shake_match_config", Reflection.getOrCreateKotlinClass(dh1.class), "快速匹配优化二期中摇一摇的配置", "ranxiongxiong"));
        UltraSettingsManager.b("live_hamlet_avatar_fix_link_mic_position", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_hamlet_avatar_fix_link_mic_position", Reflection.getOrCreateKotlinClass(r1), "avatar布局fix麦位位置", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_component_block_reverse_ab", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_component_block_reverse_ab", Reflection.getOrCreateKotlinClass(r1), "k歌组件阻断反转实验", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_post_add_video_view", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_post_add_video_view", Reflection.getOrCreateKotlinClass(r1), "开关解决进房时，playview尺寸问题", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_real_time_chorus_bussiness_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_real_time_chorus_bussiness_config", Reflection.getOrCreateKotlinClass(y41.class), "实时合唱业务配置", "ranxiongxiong"));
        UltraSettingsManager.b("live_playmode_switch_to_voice_chat_room_forbid_select_theme", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_playmode_switch_to_voice_chat_room_forbid_select_theme", Reflection.getOrCreateKotlinClass(r1), "营收玩法切换回语音聊天室不请求select_theme", "ranxiongxiong"));
        UltraSettingsManager.b("live_core_single_view_mode_test_color_switch", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_core_single_view_mode_test_color_switch", Reflection.getOrCreateKotlinClass(r1), "单View模式下连线是否使用测试背景色", "ranxiongxiong"));
        UltraSettingsManager.b("live_voice_ktv_gl_render_fps", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_voice_ktv_gl_render_fps", Reflection.getOrCreateKotlinClass(r3), "语音KTV GL绘制帧率", "ranxiongxiong"));
        UltraSettingsManager.b("live_rt_chorus_cancel_process_range_check", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_rt_chorus_cancel_process_range_check", Reflection.getOrCreateKotlinClass(r1), "合唱派对取消进度异常切歌", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_fix_ktv_mv_pre_load_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_fix_ktv_mv_pre_load_enable", Reflection.getOrCreateKotlinClass(r1), "修复ktv预加载导致mv提前显示问题", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_anchor_ping_sei_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_anchor_ping_sei_opt", Reflection.getOrCreateKotlinClass(r1), "ktv主播sei发送歌词信息逻辑优化", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_lyric_gl_opt_preload_index", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_lyric_gl_opt_preload_index", Reflection.getOrCreateKotlinClass(r3), "歌词Gl开始预加载的index", "ranxiongxiong"));
        UltraSettingsManager.b("live_multilink_apply_video_keep_client_intercept", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multilink_apply_video_keep_client_intercept", Reflection.getOrCreateKotlinClass(r1), "多人场景嘉宾申请开启视频保持端上拦截能力", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_realtime_chorus_annix_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_realtime_chorus_annix_enable", Reflection.getOrCreateKotlinClass(r1), "实时合唱是否启用annix容器", "ranxiongxiong"));
        UltraSettingsManager.b("multi_link_pc_landscape_ignore_statusbar", new com.bytedance.tools.kcp.ultrasettings.runtime.c("multi_link_pc_landscape_ignore_statusbar", Reflection.getOrCreateKotlinClass(r1), "多人场景PC横屏场景是否忽略StatusBar", "wuzhixin.jensen"));
        UltraSettingsManager.b("multi_link_voice_chat_switch_layout_failed_to_1v8", new com.bytedance.tools.kcp.ultrasettings.runtime.c("multi_link_voice_chat_switch_layout_failed_to_1v8", Reflection.getOrCreateKotlinClass(r1), "语音聊天室布局加载失败兜底为1v8布局", "ranxiongxiong"));
        UltraSettingsManager.b("live_multi_link_audio_layout_first_notify", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_link_audio_layout_first_notify", Reflection.getOrCreateKotlinClass(r1), "语音场景进房通知动态化布局变化首次问题修复", "ranxiongxiong"));
        UltraSettingsManager.b("ktv_music_path_check_switch", new com.bytedance.tools.kcp.ultrasettings.runtime.c("ktv_music_path_check_switch", Reflection.getOrCreateKotlinClass(r1), "K歌歌曲路径校验开关", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_lyric_shake_range", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_lyric_shake_range", Reflection.getOrCreateKotlinClass(r2), "歌词抖动范围区间", "ranxiongxiong"));
        UltraSettingsManager.b("live_golden_mic_sponsor_bg", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_golden_mic_sponsor_bg", Reflection.getOrCreateKotlinClass(String.class), "你点我唱冠名底色", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_song_info_record_limit", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_song_info_record_limit", Reflection.getOrCreateKotlinClass(r3), "K歌/KTV", "ranxiongxiong"));
        UltraSettingsManager.b("live_multi_link_render_filter_fix_gray3", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_link_render_filter_fix_gray3", Reflection.getOrCreateKotlinClass(r1), "多人特效Lynx 语音麦位合流开关", "changjianfei"));
        UltraSettingsManager.b("linkmic_dynamic_link_service_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("linkmic_dynamic_link_service_config", Reflection.getOrCreateKotlinClass(ILinkmicDynamicLinkServiceConfig.class), "连线中间层开关", "liaonanshan"));
        UltraSettingsManager.b("live_ktv_room_order_count_limit", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_room_order_count_limit", Reflection.getOrCreateKotlinClass(r3), "KTV点歌上限", "ranxiongxiong"));
        UltraSettingsManager.b("multi_link_av_monitor_log_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("multi_link_av_monitor_log_config", Reflection.getOrCreateKotlinClass(q7.class), "多人场景音频链路埋点配置", "ranxiongxiong"));
        UltraSettingsManager.b("live_core_set_listener_opt_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_core_set_listener_opt_enable", Reflection.getOrCreateKotlinClass(r1), "LiveCore设置listener优化开关", "ranxiongxiong"));
        UltraSettingsManager.b("live_enable_interact_emoji", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_enable_interact_emoji", Reflection.getOrCreateKotlinClass(r1), "主播嘉宾麦上互动表情", "ranxiongxiong"));
        UltraSettingsManager.b("live_force_unmute_when_video_talk_finish", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_force_unmute_when_video_talk_finish", Reflection.getOrCreateKotlinClass(r1), "视频聊天室结束时强制打开主播mic", "ranxiongxiong"));
        UltraSettingsManager.b("live_multi_ktv_avatar_enabled_audience", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_ktv_avatar_enabled_audience", Reflection.getOrCreateKotlinClass(r1), "嘉宾是否可以开启Ktv数字人虚拟形象", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_sort_bubble_view_show_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_sort_bubble_view_show_opt", Reflection.getOrCreateKotlinClass(r1), "ktv 评分排序弹窗view显示逻辑优化", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_mock_other_resource_delay_download", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_mock_other_resource_delay_download", Reflection.getOrCreateKotlinClass(b9.class), "K歌物料其他资源mock延迟下载", "ranxiongxiong"));
        UltraSettingsManager.b("live_multi_link_gift_improve", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_link_gift_improve", Reflection.getOrCreateKotlinClass(nb1.class), "多人动效渲染升级配置", "ranxiongxiong"));
        UltraSettingsManager.b("live_multi_link_lynx_effect_url", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_link_lynx_effect_url", Reflection.getOrCreateKotlinClass(com.bytedance.android.livesdk.model.e0.class), "多人特效Lynx Sar debug链接配置页面", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_multi_chorus_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_multi_chorus_enable", Reflection.getOrCreateKotlinClass(r3), "一起唱功能开关", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_double_reset_check", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_double_reset_check", Reflection.getOrCreateKotlinClass(r1), "预览流重复reset校验", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_real_time_chorus_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_real_time_chorus_config", Reflection.getOrCreateKotlinClass(String.class), "实时合唱编码参数", "ranxiongxiong"));
        UltraSettingsManager.b("live_linkmic_waiting_or_online_disable_shake_fast_match", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_linkmic_waiting_or_online_disable_shake_fast_match", Reflection.getOrCreateKotlinClass(r1), "连线等待中或连线中用户屏蔽摇一摇快速匹配", "ranxiongxiong"));
        UltraSettingsManager.b("live_player_smooth_enter_room", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_player_smooth_enter_room", Reflection.getOrCreateKotlinClass(LivePlayerSmoothEnterRoomConfig.class), "多人场景预览流播放器平滑进房优化", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_component_screen_record_diable_sei", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_component_screen_record_diable_sei", Reflection.getOrCreateKotlinClass(r1), "录屏直播中的k歌组件屏蔽掉sei", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_sei_cache_max_capacity_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_sei_cache_max_capacity_opt", Reflection.getOrCreateKotlinClass(r3), "sei缓存池最大容量(进房优化)", "ranxiongxiong"));
        UltraSettingsManager.b("live_multi_link_handle_leave_room_error", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_link_handle_leave_room_error", Reflection.getOrCreateKotlinClass(r1), "是否处理MSG_ERROR_LEAVE_ROOM错误", "huangzhi.jackie"));
        UltraSettingsManager.b("live_ktv_chorus_midi_score_sync_time", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_chorus_midi_score_sync_time", Reflection.getOrCreateKotlinClass(r3), "合唱midi分数同步时间", "ranxiongxiong"));
        UltraSettingsManager.b("live_new_midi_dimension_weights", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_new_midi_dimension_weights", F, "K歌midi分数权重， [0]音准，[1]情感，[2]节奏", "zengle"));
        UltraSettingsManager.b("live_preview_use_multi_link_widget", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_preview_use_multi_link_widget", Reflection.getOrCreateKotlinClass(r1), "直播预览流多人场景新架构", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_memory_leak_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_memory_leak_opt", Reflection.getOrCreateKotlinClass(r1), "KTV内存泄漏修复开关", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_enable_room_hot_show_play_count", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_enable_room_hot_show_play_count", Reflection.getOrCreateKotlinClass(r3), "ktv房间热门列表演唱时长文案AB", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_chorus_guest_linkmic_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_chorus_guest_linkmic_enable", Reflection.getOrCreateKotlinClass(r1), "实时合唱支持嘉宾连线", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_lyric_interlude_gap", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_lyric_interlude_gap", Reflection.getOrCreateKotlinClass(r3), "KTV歌词间奏大小", "ranxiongxiong"));
        UltraSettingsManager.b("ktv_chorus_link_guest_push_fix", new com.bytedance.tools.kcp.ultrasettings.runtime.c("ktv_chorus_link_guest_push_fix", Reflection.getOrCreateKotlinClass(r1), "实时合唱连线嘉宾推流问题修复", "ranxiongxiong"));
        UltraSettingsManager.b("live_enable_video_effect_micseat_in_mix_stream", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_enable_video_effect_micseat_in_mix_stream", Reflection.getOrCreateKotlinClass(r1), "多人特效Lynx 语音麦位合流开关", "changjianfei"));
        UltraSettingsManager.b("enable_scene_live_float_window_play", new com.bytedance.tools.kcp.ultrasettings.runtime.c("enable_scene_live_float_window_play", Reflection.getOrCreateKotlinClass(r1), "线上无场景触发 false 场景+线上小窗 true", "ranxiongxiong"));
        UltraSettingsManager.b("live_background_notification_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_background_notification_enable", Reflection.getOrCreateKotlinClass(r1), "语音直播后台播放通知开关", "ranxiongxiong"));
        UltraSettingsManager.b("live_interact_gift_score_limits", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_interact_gift_score_limits", Reflection.getOrCreateKotlinClass(j8.class), "飞麦大礼物场景机型评分限制", "ranxiongxiong"));
        UltraSettingsManager.b("live_multi_link_playmode_widget_load_fix", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_link_playmode_widget_load_fix", Reflection.getOrCreateKotlinClass(r1), "多人玩法widget加载修复", "ranxiongxiong"));
        UltraSettingsManager.b("live_multi_scene_preview_log", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_scene_preview_log", Reflection.getOrCreateKotlinClass(r1), "多人场景预览流上下滑上报埋点", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_ui_resource_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_ui_resource_config", Reflection.getOrCreateKotlinClass(d9.class), "KTV房间UI资源", "ranxiongxiong"));
        UltraSettingsManager.b("live_enable_dynamic_window", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_enable_dynamic_window", Reflection.getOrCreateKotlinClass(r1), "宫格模式是否显示动态麦位变化开关", "ranxiongxiong"));
        UltraSettingsManager.b("multi_link_float_window_rv_height_fix", new com.bytedance.tools.kcp.ultrasettings.runtime.c("multi_link_float_window_rv_height_fix", Reflection.getOrCreateKotlinClass(r1), "固定浮窗布局，主播使用radioUILayoutHeight避免rvWidth/rvHeight<contentWidth/contentHeight导致视频画面和麦位对不齐问题", "ranxiongxiong"));
        UltraSettingsManager.b("live_interact_self_guide_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_interact_self_guide_enable", Reflection.getOrCreateKotlinClass(r1), "语音聊天室麦位自见开关", "ranxiongxiong"));
        UltraSettingsManager.b("live_normal_lyric_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_normal_lyric_opt", Reflection.getOrCreateKotlinClass(r1), "普通版本歌词优化", "ranxiongxiong"));
        UltraSettingsManager.b("live_video_comment_send_style_new", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_video_comment_send_style_new", Reflection.getOrCreateKotlinClass(r1), "评论发送视频面板使用新的样式", "ranxiongxiong"));
        UltraSettingsManager.b("multi_link_switch_scene_check_version_valid", new com.bytedance.tools.kcp.ultrasettings.runtime.c("multi_link_switch_scene_check_version_valid", Reflection.getOrCreateKotlinClass(r1), "聊天室switch_scene前检验消息version合法性", "ranxiongxiong"));
        UltraSettingsManager.b("live_preview_multi_link_update_ui_layout_enable_delay", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_preview_multi_link_update_ui_layout_enable_delay", Reflection.getOrCreateKotlinClass(LivePreviewMultiLinkDelayConfig.class), "验证预览流UI首帧对进房渗透影响", "ranxiongxiong"));
        UltraSettingsManager.b("live_interact_invitation_guide_anim_repeat_count", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_interact_invitation_guide_anim_repeat_count", Reflection.getOrCreateKotlinClass(r3), "邀请好友引导动画循环次数", "ranxiongxiong"));
        UltraSettingsManager.b("talk_room_fulllink_guest_fall_back_to_alogger", new com.bytedance.tools.kcp.ultrasettings.runtime.c("talk_room_fulllink_guest_fall_back_to_alogger", Reflection.getOrCreateKotlinClass(r1), "多人场景全链路上报观众侧打印ALog", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_chorus_volume_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_chorus_volume_config", Reflection.getOrCreateKotlinClass(z41.class), "实时合唱音量配置", "ranxiongxiong"));
        UltraSettingsManager.b("multi_link_video_chat_feed_view_enable_dynamic_widget", new com.bytedance.tools.kcp.ultrasettings.runtime.c("multi_link_video_chat_feed_view_enable_dynamic_widget", Reflection.getOrCreateKotlinClass(r1), "视频聊天室预览流支持加载动态化框架", "ranxiongxiong"));
        UltraSettingsManager.b("interact_gl_flymic_gift", new com.bytedance.tools.kcp.ultrasettings.runtime.c("interact_gl_flymic_gift", Reflection.getOrCreateKotlinClass(r1), "直播多人场景飞麦礼物覆盖率提升实验", "ranxiongxiong"));
        UltraSettingsManager.b("multi_link_seat_item_differ_paid_link_bugfix", new com.bytedance.tools.kcp.ultrasettings.runtime.c("multi_link_seat_item_differ_paid_link_bugfix", Reflection.getOrCreateKotlinClass(r1), "多人ItemDiffer 付费连线玩法Bugfix 改造避免频繁调用requestLayout", "ranxiongxiong"));
        UltraSettingsManager.b("multi_link_voice_chat_sei_update_layout", new com.bytedance.tools.kcp.ultrasettings.runtime.c("multi_link_voice_chat_sei_update_layout", Reflection.getOrCreateKotlinClass(r1), "语音聊天室sei中uiLayout更新驱动布局切换", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_sei_load_release_check", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_sei_load_release_check", Reflection.getOrCreateKotlinClass(r1), "sei release状态check", "ranxiongxiong"));
        UltraSettingsManager.b("live_multi_link_bitrate_adjust", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_link_bitrate_adjust", Reflection.getOrCreateKotlinClass(r1), "多人场景码率优化", "liaonanshan"));
        UltraSettingsManager.b("live_hamlet_avatar_guide_webp_url", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_hamlet_avatar_guide_webp_url", Reflection.getOrCreateKotlinClass(String.class), "hamlet avatar引导webp路径", "ranxiongxiong"));
        UltraSettingsManager.b("live_solo_ktv_rt_chorus_launch_page_lynx_url", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_solo_ktv_rt_chorus_launch_page_lynx_url", Reflection.getOrCreateKotlinClass(String.class), "个唱实时合唱分发页面lynx url", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_lyric_setting", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_lyric_setting", Reflection.getOrCreateKotlinClass(x41.class), "歌词同步方案优化", "ranxiongxiong"));
        UltraSettingsManager.b("live_cross_link_base_feat", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_cross_link_base_feat", Reflection.getOrCreateKotlinClass(r1), "跨房基础能力开关", "ranxiongxiong"));
        UltraSettingsManager.b("live_multi_audio_anchor_show_audience_onSeat", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_audio_anchor_show_audience_onSeat", Reflection.getOrCreateKotlinClass(r1), "聊天室主播设置是否有观众预上麦选项", "ranxiongxiong"));
        UltraSettingsManager.b("live_guest_link_setting_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_guest_link_setting_config", Reflection.getOrCreateKotlinClass(IGuestLinkSettingConfig.class), "嘉宾连线配置", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_sing_fps", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_sing_fps", Reflection.getOrCreateKotlinClass(r3), "ktv演唱频率", "ranxiongxiong"));
        UltraSettingsManager.b("live_voice_c_position_client_switch_open", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_voice_c_position_client_switch_open", Reflection.getOrCreateKotlinClass(r1), "语音聊天室C位嘉宾放大端上总开关", "ranxiongxiong"));
        UltraSettingsManager.b("rtc_adjust_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("rtc_adjust_enable", Reflection.getOrCreateKotlinClass(r1), "开启RTC同步媒体音量", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_singing_record_text_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_singing_record_text_config", Reflection.getOrCreateKotlinClass(KtvLabelTextConfig.class), "KTV演唱记录文案配置", "ranxiongxiong"));
        UltraSettingsManager.b("live_vice_singer_show_second_line_lyric_fall_back", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_vice_singer_show_second_line_lyric_fall_back", Reflection.getOrCreateKotlinClass(r1), "一起唱副唱显示第二行歌词兜底开关", "ranxiongxiong"));
        UltraSettingsManager.b("send_gift_to_linker_setting", new com.bytedance.tools.kcp.ultrasettings.runtime.c("send_gift_to_linker_setting", Reflection.getOrCreateKotlinClass(zg1.class), "是否开启对嘉宾送礼", "ranxiongxiong"));
        UltraSettingsManager.b("live_multi_link_lynx_seat_preview_opt_prefetch", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_link_lynx_seat_preview_opt_prefetch", Reflection.getOrCreateKotlinClass(r1), "lynx麦位预览流加载优化(wormhole预拉流)", "ranxiongxiong"));
        UltraSettingsManager.b("live_multi_revenue_gift_monitor_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_revenue_gift_monitor_enable", Reflection.getOrCreateKotlinClass(r1), "多人营收礼物指标埋点上报开关", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_opus_enalbe", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_opus_enalbe", Reflection.getOrCreateKotlinClass(r1), "全屏mv dophin开关", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_mv_preload_size", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_mv_preload_size", Reflection.getOrCreateKotlinClass(r3), "预加载大小", "ranxiongxiong"));
        UltraSettingsManager.b("live_self_discipline_like_effect_url", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_self_discipline_like_effect_url", Reflection.getOrCreateKotlinClass(String.class), "自律模式点赞动效资源", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_room_state_sync", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_room_state_sync", Reflection.getOrCreateKotlinClass(r1), "房间状态同步开关", "ranxiongxiong"));
        UltraSettingsManager.b("video_anchor_apply_reason_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("video_anchor_apply_reason_enable", Reflection.getOrCreateKotlinClass(r3), "视频聊天室主播支持申请理由", "ranxiongxiong"));
        UltraSettingsManager.b("live_pk_end_enable_stream_mixer_anchor_self", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_pk_end_enable_stream_mixer_anchor_self", Reflection.getOrCreateKotlinClass(r1), "pk带嘉宾结束时，避免短暂合流画面位置错乱，优化只合主播自己", "ranxiongxiong"));
        UltraSettingsManager.b("live_link_multi_enlarge_relist_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_link_multi_enlarge_relist_enable", Reflection.getOrCreateKotlinClass(r1), "主咖模式下端上是否需要进行重排序", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_singing_record_ab_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_singing_record_ab_config", Reflection.getOrCreateKotlinClass(r1), "KTV演唱沉淀AB实验", "ranxiongxiong"));
        UltraSettingsManager.b("ktv_mv_download_by_url", new com.bytedance.tools.kcp.ultrasettings.runtime.c("ktv_mv_download_by_url", Reflection.getOrCreateKotlinClass(r1), "mv下载走url的方式", "ranxiongxiong"));
        UltraSettingsManager.b("multi_link_feed_view_unselected_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("multi_link_feed_view_unselected_opt", Reflection.getOrCreateKotlinClass(r1), "FeedView切换时上一个FeedView调用unselected", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_delete_fake_request_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_delete_fake_request_enable", Reflection.getOrCreateKotlinClass(r1), "删除K歌组件fakeRequest逻辑开关", "ranxiongxiong"));
        UltraSettingsManager.b("solo_ktv_start_delay_play_bgm", new com.bytedance.tools.kcp.ultrasettings.runtime.c("solo_ktv_start_delay_play_bgm", Reflection.getOrCreateKotlinClass(r2), "练唱delay开始bgm延迟配置", "ranxiongxiong"));
        UltraSettingsManager.b("live_enable_lyric_local_backup", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_enable_lyric_local_backup", Reflection.getOrCreateKotlinClass(r1), "合唱观众歌词加载逻辑兜底", "ranxiongxiong"));
        UltraSettingsManager.b("live_mcu_play_failed_retry_times", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_mcu_play_failed_retry_times", Reflection.getOrCreateKotlinClass(r3), "跨房厅战MCU公共流拉流失败重试次数", "ranxiongxiong"));
        UltraSettingsManager.b("live_linkmic_play_status_name", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_linkmic_play_status_name", G, "多人场景竞争玩法高峰期管控-文案", "ranxiongxiong"));
        UltraSettingsManager.b("ktv_order_song_list_use_increase_update", new com.bytedance.tools.kcp.ultrasettings.runtime.c("ktv_order_song_list_use_increase_update", Reflection.getOrCreateKotlinClass(r1), "点歌列表使用增量刷新", "ranxiongxiong"));
        UltraSettingsManager.b("live_room_battle_match_refactor_Lynx", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_room_battle_match_refactor_Lynx", Reflection.getOrCreateKotlinClass(RoomBattleMatchRefactorLynx.class), "厅战重构(产品向)Lynx页面地址和Schema", "ranxiongxiong"));
        UltraSettingsManager.b("live_interact_rtc_mix_pic_sei_ver_block_list", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_interact_rtc_mix_pic_sei_ver_block_list", H, "视频聊天室图片合流sei_ver黑名单", "ranxiongxiong"));
        UltraSettingsManager.b("link_enable_reset_mute_when_inconsistent", new com.bytedance.tools.kcp.ultrasettings.runtime.c("link_enable_reset_mute_when_inconsistent", Reflection.getOrCreateKotlinClass(r1), "静音UI显示但实际未静音时闭麦自己", "ranxiongxiong"));
        UltraSettingsManager.b("ktv_chorus_role_witch_change", new com.bytedance.tools.kcp.ultrasettings.runtime.c("ktv_chorus_role_witch_change", Reflection.getOrCreateKotlinClass(r1), "实时合唱角色切换时机变更", "ranxiongxiong"));
        UltraSettingsManager.b("live_singer_leak_fix", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_singer_leak_fix", Reflection.getOrCreateKotlinClass(r1), "演唱端内存泄露修复", "ranxiongxiong"));
        UltraSettingsManager.b("multi_link_order_sing_3d_avatar_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("multi_link_order_sing_3d_avatar_config", Reflection.getOrCreateKotlinClass(qb1.class), "多人场景语音聊天室你点我唱avatar配置", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_sing_report_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_sing_report_enable", Reflection.getOrCreateKotlinClass(r1), "开场上报开关", "ranxiongxiong"));
        UltraSettingsManager.b("live_pk_audience_paid_link_anonymous_avatar_fix", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_pk_audience_paid_link_anonymous_avatar_fix", Reflection.getOrCreateKotlinClass(r1), "修复付费连线匿名连线后开启PK头像不是匿名头像问题", "ranxiongxiong"));
        UltraSettingsManager.b("live_new_gift_score_interact_view", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_new_gift_score_interact_view", Reflection.getOrCreateKotlinClass(r1), "麦位礼物分值是否使用新的互动view兜底开关", "ranxiongxiong"));
        UltraSettingsManager.b("live_talkroom_function_type_bugfix_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_talkroom_function_type_bugfix_enable", Reflection.getOrCreateKotlinClass(r1), "聊天室function_type计算bugfix开关", "ranxiongxiong"));
        UltraSettingsManager.b("live_interact_invitation_guide_config_anchor", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_interact_invitation_guide_config_anchor", Reflection.getOrCreateKotlinClass(LinkAudioInviteGuideConfig.class), "主播端聊天室上麦之后邀请引导配置", "ranxiongxiong"));
        UltraSettingsManager.b("live_order_sing_mv_loop_time", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_order_sing_mv_loop_time", Reflection.getOrCreateKotlinClass(r3), "你点我唱mv最长播放时长配置", "ranxiongxiong"));
        UltraSettingsManager.b("live_anchor_start_rtc_update_open", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_anchor_start_rtc_update_open", Reflection.getOrCreateKotlinClass(r1), "主播开启RTC后更新配置开关", "ranxiongxiong"));
        UltraSettingsManager.b("big_party_remember_camera", new com.bytedance.tools.kcp.ultrasettings.runtime.c("big_party_remember_camera", Reflection.getOrCreateKotlinClass(r1), "是否记住开启摄像头状态", "ranxiongxiong"));
        UltraSettingsManager.b("ktv_opus_push_width", new com.bytedance.tools.kcp.ultrasettings.runtime.c("ktv_opus_push_width", Reflection.getOrCreateKotlinClass(r3), "推流宽度", "ranxiongxiong"));
        UltraSettingsManager.b("live_multi_link_enable_param_adjust", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_link_enable_param_adjust", Reflection.getOrCreateKotlinClass(r1), "多人场景LiveCore参数调整开关", "liaonanshan"));
        UltraSettingsManager.b("live_ktv_core_path_bug_fix_fallback", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_core_path_bug_fix_fallback", Reflection.getOrCreateKotlinClass(r1), "K歌历史bug 修复兜底开关", "ranxiongxiong"));
        UltraSettingsManager.b("live_order_song_panel_data_delay_load_time", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_order_song_panel_data_delay_load_time", Reflection.getOrCreateKotlinClass(r2), "点歌台数据延迟加载时长，单位ms", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_volume_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_volume_config", Reflection.getOrCreateKotlinClass(b51.class), "k歌默认音量配置", "ranxiongxiong"));
        UltraSettingsManager.b("live_video_talk_anchor_c_position_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_video_talk_anchor_c_position_enable", Reflection.getOrCreateKotlinClass(r1), "视频聊天室主播是否有设置C位嘉宾放大入口", "ranxiongxiong"));
        UltraSettingsManager.b("live_solo_ktv_volume_test", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_solo_ktv_volume_test", Reflection.getOrCreateKotlinClass(rs1.f.class), "个人练歌房音量调整", "ranxiongxiong"));
        UltraSettingsManager.b("live_enable_user_invite_path_adjust", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_enable_user_invite_path_adjust", Reflection.getOrCreateKotlinClass(r1), "是否把邀请面板转化为一级入口", "ranxiongxiong"));
        UltraSettingsManager.b("live_anchor_only_join_through_invite_show", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_anchor_only_join_through_invite_show", Reflection.getOrCreateKotlinClass(r1), "主播连线申请显示“仅允许通过邀请连线”入口", "ranxiongxiong"));
        UltraSettingsManager.b("live_multi_link_seat_offset_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_link_seat_offset_config", Reflection.getOrCreateKotlinClass(tb1.class), "玩法麦位偏移配置", "ranxiongxiong"));
        UltraSettingsManager.b("live_linker_beauty_dialog_enable_audio_apply", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_linker_beauty_dialog_enable_audio_apply", Reflection.getOrCreateKotlinClass(r1), "视频聊天室美颜面板是否可以语音上麦", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_room_host_tag_opt_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_room_host_tag_opt_enable", Reflection.getOrCreateKotlinClass(r1), "ktv主持人标签优先级调整", "ranxiongxiong"));
        UltraSettingsManager.b("ktv_component_order_song_dialog_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("ktv_component_order_song_dialog_opt", Reflection.getOrCreateKotlinClass(r1), "K歌组件点歌台组件化", "ranxiongxiong"));
        UltraSettingsManager.b("live_vertical_pre_inflate", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_vertical_pre_inflate", Reflection.getOrCreateKotlinClass(com.bytedance.android.livesdk.model.k0.class), "垂直场景xml预加载是否开启", "ranxiongxiong"));
        UltraSettingsManager.b("interact_permission_guarantor_check_content_common", new com.bytedance.tools.kcp.ultrasettings.runtime.c("interact_permission_guarantor_check_content_common", I, "跳转目标activity，释放音频权限的名单[common]", "ranxiongxiong"));
        UltraSettingsManager.b("live_interact_audience_micdress_entry_switch", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_interact_audience_micdress_entry_switch", Reflection.getOrCreateKotlinClass(r1), "双人聊麦位装扮入口开关", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_dress_preview_midi_skin_switch", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_dress_preview_midi_skin_switch", Reflection.getOrCreateKotlinClass(r1), "预览流ktv midi皮肤是否支持开启和关闭", "ranxiongxiong"));
        UltraSettingsManager.b("live_multi_link_amaz_effect_debug", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_link_amaz_effect_debug", Reflection.getOrCreateKotlinClass(com.bytedance.android.livesdk.model.e0.class), "多人特效Lynx Amaz debug链接配置页面", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_support_theme_replace", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_support_theme_replace", Reflection.getOrCreateKotlinClass(VoiceLiveThemeConfig.class), "语音直播是否支持背景", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_download_retry_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_download_retry_enable", Reflection.getOrCreateKotlinClass(r1), "K歌是否开启下载失败重试", "ranxiongxiong"));
        UltraSettingsManager.b("ktv_music_download_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("ktv_music_download_opt", Reflection.getOrCreateKotlinClass(r1), "K歌物料资源下载优化", "ranxiongxiong"));
        UltraSettingsManager.b("live_real_time_chorus_join_optimize_dict", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_real_time_chorus_join_optimize_dict", Reflection.getOrCreateKotlinClass(RealTimeChorusDownloadOptConfig.class), "实时合唱加入合唱优化", "ranxiongxiong"));
        UltraSettingsManager.b("live_anonymous_paid_link_mic", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_anonymous_paid_link_mic", Reflection.getOrCreateKotlinClass(r1), "付费匿名客户端实验开关", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_score_rate", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_score_rate", J, "live_ktv_score_rate", "ranxiongxiong"));
        UltraSettingsManager.b("live_soloktv_entrance_tips_bg", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_soloktv_entrance_tips_bg", Reflection.getOrCreateKotlinClass(String.class), "个人练歌房提示图片", "ranxiongxiong"));
        UltraSettingsManager.b("live_multi_link_use_enter_room_media_info", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_link_use_enter_room_media_info", Reflection.getOrCreateKotlinClass(r1), "多人场景是否使用进房消息更新媒体参数", "ranxiongxiong"));
        UltraSettingsManager.b("release_av_permission_when_close_notification_on_background", new com.bytedance.tools.kcp.ultrasettings.runtime.c("release_av_permission_when_close_notification_on_background", Reflection.getOrCreateKotlinClass(r1), "手动在后台关闭通知栏权限，释放音视频采集权限", "ranxiongxiong"));
        UltraSettingsManager.b("enable_live_interact", new com.bytedance.tools.kcp.ultrasettings.runtime.c("enable_live_interact", Reflection.getOrCreateKotlinClass(r1), "是否打开视频连麦功能", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_midi_sense_enhance", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_midi_sense_enhance", Reflection.getOrCreateKotlinClass(r3), "语音ktv音游感midi", "ranxiongxiong"));
        UltraSettingsManager.b("live_audio_subtitle_sei_check", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_audio_subtitle_sei_check", Reflection.getOrCreateKotlinClass(r1), "检查字幕sei是否符合json格式", "ranxiongxiong"));
        UltraSettingsManager.b("live_chat_channel_link_debug_view_switch", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_chat_channel_link_debug_view_switch", Reflection.getOrCreateKotlinClass(r1), "频道房语音功能debug日志窗口", "ranxiongxiong"));
        UltraSettingsManager.b("live_lyric_dettach_switch", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_lyric_dettach_switch", Reflection.getOrCreateKotlinClass(r1), "观众歌词组件dettach是否dispose timer。临时解决内存泄露问题", "ranxiongxiong"));
        UltraSettingsManager.b("live_opus_ktv_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_opus_ktv_opt", Reflection.getOrCreateKotlinClass(r1), "竖屏ktv性能优化", "ranxiongxiong"));
        UltraSettingsManager.b("multi_link_base_common_window_layout_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("multi_link_base_common_window_layout_enable", Reflection.getOrCreateKotlinClass(r1), "是否启用WindowLayout新布局", "ranxiongxiong"));
        UltraSettingsManager.b("live_request_camera_permission_before_video_link", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_request_camera_permission_before_video_link", Reflection.getOrCreateKotlinClass(r1), "视频上麦是否前置申请相机权限", "ranxiongxiong"));
        UltraSettingsManager.b("live_3d_fly_mic_timer", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_3d_fly_mic_timer", Reflection.getOrCreateKotlinClass(r2), "多人场景3d飞麦等待礼物队列时间", "ranxiongxiong"));
        UltraSettingsManager.b("link_room_battle_enter_result_anim_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("link_room_battle_enter_result_anim_enable", Reflection.getOrCreateKotlinClass(r1), "多人场景竞争玩法高峰期管控-跨房厅战进房是否展示战果动画", "ranxiongxiong"));
        UltraSettingsManager.b("live_preview_multi_link_widget_try_load_by_room", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_preview_multi_link_widget_try_load_by_room", Reflection.getOrCreateKotlinClass(r1), "内外流同构新架构通过Room信息提前加载FeedView", "ranxiongxiong"));
        UltraSettingsManager.b("live_rt_chorus_midi_error_fix", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_rt_chorus_midi_error_fix", Reflection.getOrCreateKotlinClass(r1), "实时合唱偶现midi异常修复", "ranxiongxiong"));
        UltraSettingsManager.b("live_ui_layouts_can_not_show_link_result_page", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ui_layouts_can_not_show_link_result_page", K, "断连不必弹出断连页的ui_layout集合", "ranxiongxiong"));
        UltraSettingsManager.b("live_linkmic_default_unsilence_double_check", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_linkmic_default_unsilence_double_check", Reflection.getOrCreateKotlinClass(r1), "默认静音上麦主播取消静音二次确认", "ranxiongxiong"));
        UltraSettingsManager.b("live_real_time_chorus_log_view_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_real_time_chorus_log_view_enable", Reflection.getOrCreateKotlinClass(r1), "合唱信息页面展示", "ranxiongxiong"));
        UltraSettingsManager.b("ktv_video_preview_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("ktv_video_preview_enable", Reflection.getOrCreateKotlinClass(r1), "KTV摄像头预览流开关", "ranxiongxiong"));
        UltraSettingsManager.b("live_multi_link_fan_ticket_reset_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_link_fan_ticket_reset_opt", Reflection.getOrCreateKotlinClass(r1), "礼物记值增加重置能力", "guoyunguang"));
        UltraSettingsManager.b("live_voice_chat_anchor_switch_scene_update_ktv_open_twice_optimize", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_voice_chat_anchor_switch_scene_update_ktv_open_twice_optimize", Reflection.getOrCreateKotlinClass(r1), "[兜底]避免语音聊天室/KTV接收swtich_scene消息时更新KTV开启状态两次", "ranxiongxiong"));
        UltraSettingsManager.b("live_pk_to_video_camera_dynamic_video_state_bugifx", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_pk_to_video_camera_dynamic_video_state_bugifx", Reflection.getOrCreateKotlinClass(r1), "关闭PK回到动态浮窗布局videoState修复", "ranxiongxiong"));
        UltraSettingsManager.b("live_voice_chat_schema_check_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_voice_chat_schema_check_opt", Reflection.getOrCreateKotlinClass(r1), "语音聊天室schema跳转判断逻辑跟新", "ranxiongxiong"));
        UltraSettingsManager.b("live_voice_ktv_midi_use_surface_view", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_voice_ktv_midi_use_surface_view", Reflection.getOrCreateKotlinClass(r1), "语音KTV MIDI使用SurfaceView", "ranxiongxiong"));
        UltraSettingsManager.b("live_hamlet_avatar_business_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_hamlet_avatar_business_config", Reflection.getOrCreateKotlinClass(HamletBusinessConfig.class), "hamlet avatar业务参数配置", "ranxiongxiong"));
        UltraSettingsManager.b("playmode_lynx_trans_fitst", new com.bytedance.tools.kcp.ultrasettings.runtime.c("playmode_lynx_trans_fitst", Reflection.getOrCreateKotlinClass(PlayModeLynxPanelConfig.class), "玩法面板Lynx动态化", "ranxiongxiong"));
        UltraSettingsManager.b("link_mute_fallback_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("link_mute_fallback_config", Reflection.getOrCreateKotlinClass(ac1.class), "静音异常兜底配置", "ranxiongxiong"));
        UltraSettingsManager.b("multi_link_play_mode_config_paid_link", new com.bytedance.tools.kcp.ultrasettings.runtime.c("multi_link_play_mode_config_paid_link", Reflection.getOrCreateKotlinClass(r1), "多人场景玩法配置付费连线开关", "ranxiongxiong"));
        UltraSettingsManager.b("live_solo_ktv_banner_lynx_url", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_solo_ktv_banner_lynx_url", Reflection.getOrCreateKotlinClass(String.class), "个唱banner lynx url", "ranxiongxiong"));
        UltraSettingsManager.b("multi_link_play_mode_config_themed_competition", new com.bytedance.tools.kcp.ultrasettings.runtime.c("multi_link_play_mode_config_themed_competition", Reflection.getOrCreateKotlinClass(r1), "多人场景玩法配置主题比赛开关", "ranxiongxiong"));
        UltraSettingsManager.b("live_voice_chat_room_guest_support_short_video", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_voice_chat_room_guest_support_short_video", Reflection.getOrCreateKotlinClass(r1), "语音房观众是否支持一起看", "ranxiongxiong"));
        UltraSettingsManager.b("live_adventure_lynx_setting", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_adventure_lynx_setting", Reflection.getOrCreateKotlinClass(AdventureLynxPanelConfig.class), "奇遇连连玩法面板地址URL配置", "ranxiongxiong"));
        UltraSettingsManager.b("live_auto_apply_paid_link_audio", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_auto_apply_paid_link_audio", Reflection.getOrCreateKotlinClass(r1), "付费连线强触达进房是否默认走语音", "ranxiongxiong"));
        UltraSettingsManager.b("multi_anchor_cross_channel_check_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("multi_anchor_cross_channel_check_enable", Reflection.getOrCreateKotlinClass(r3), "主播连线跨房兜底逻辑", "ranxiongxiong"));
        UltraSettingsManager.b("live_link_emoji_sound_filter_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_link_emoji_sound_filter_enable", Reflection.getOrCreateKotlinClass(r1), "观众连麦表情声音filter逻辑", "ranxiongxiong"));
        UltraSettingsManager.b("live_chat_channel_single_user_linkmic_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_chat_channel_single_user_linkmic_enable", Reflection.getOrCreateKotlinClass(e1.class), "频道房语音上麦单人限制", "ranxiongxiong"));
        UltraSettingsManager.b("ttlive_opus_mv_default", new com.bytedance.tools.kcp.ultrasettings.runtime.c("ttlive_opus_mv_default", Reflection.getOrCreateKotlinClass(String.class), "练唱首页默认视频", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_old_challenge_delay_load_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_old_challenge_delay_load_enable", Reflection.getOrCreateKotlinClass(r1), "旧版演唱挑战观众端延迟加载", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_prepare_download_song_tips_switch", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_prepare_download_song_tips_switch", Reflection.getOrCreateKotlinClass(r1), "ktv预下载歌曲提示开关", "ranxiongxiong"));
        UltraSettingsManager.b("solo_ktv_record_delay_time", new com.bytedance.tools.kcp.ultrasettings.runtime.c("solo_ktv_record_delay_time", Reflection.getOrCreateKotlinClass(r2), "练唱人声和BGM对齐偏移量", "ranxiongxiong"));
        UltraSettingsManager.b("live_linkmic_dynamic_widget_notify_when_observe_regist", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_linkmic_dynamic_widget_notify_when_observe_regist", Reflection.getOrCreateKotlinClass(r1), "动态化widget注册datacenter使用notifyWhenObserve", "ranxiongxiong"));
        UltraSettingsManager.b("live_chat_channel_public_stream_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_chat_channel_public_stream_enable", Reflection.getOrCreateKotlinClass(r1), "频道房语音功能是否开启公共流", "ranxiongxiong"));
        UltraSettingsManager.b("live_room_backend_business_switch", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_room_backend_business_switch", Reflection.getOrCreateKotlinClass(a50.a.class), "进房接入backend业务集合开关", "ranxiongxiong"));
        UltraSettingsManager.b("enable_guest_link_auto_silence_setting", new com.bytedance.tools.kcp.ultrasettings.runtime.c("enable_guest_link_auto_silence_setting", Reflection.getOrCreateKotlinClass(r1), "聊天室设置面板是否展示观众连线默认静音设置项", "ranxiongxiong"));
        UltraSettingsManager.b("interact_sei_uid_disabled", new com.bytedance.tools.kcp.ultrasettings.runtime.c("interact_sei_uid_disabled", Reflection.getOrCreateKotlinClass(r1), "sei中是否使用uid", "ranxiongxiong"));
        UltraSettingsManager.b("live_interact_xplay_layout_optimize", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_interact_xplay_layout_optimize", Reflection.getOrCreateKotlinClass(r1), "多人场景云游戏的观众游戏画面布局适配优化", "ranxiongxiong"));
        UltraSettingsManager.b("live_real_time_chorus_vice_play_song_compatible", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_real_time_chorus_vice_play_song_compatible", Reflection.getOrCreateKotlinClass(r1), "实时合唱副唱歌曲播放兜底策略", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_default_mv_vid", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_default_mv_vid", Reflection.getOrCreateKotlinClass(String.class), "默认mv对应的vid", "ranxiongxiong"));
        UltraSettingsManager.b("flyingstar_multilink_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("flyingstar_multilink_config", Reflection.getOrCreateKotlinClass(n5.class), "飞星 - 多人侧配置", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_midi_lyric_load_time_out_duration", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_midi_lyric_load_time_out_duration", Reflection.getOrCreateKotlinClass(r2), "KTV歌词和midi加载超时时长 (单位 ms)", "ranxiongxiong"));
        UltraSettingsManager.b("ktv_enable_open_camera", new com.bytedance.tools.kcp.ultrasettings.runtime.c("ktv_enable_open_camera", Reflection.getOrCreateKotlinClass(r1), "KTV主播是否支持摄像头能力端上开关", "ranxiongxiong"));
        UltraSettingsManager.b("live_voice_ktv_cup_opt_use_gl", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_voice_ktv_cup_opt_use_gl", Reflection.getOrCreateKotlinClass(r1), "语音ktv氛围颜色使用GL绘制", "ranxiongxiong"));
        UltraSettingsManager.b("live_fast_match_settings", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_fast_match_settings", Reflection.getOrCreateKotlinClass(x21.class), "视频聊天室快速匹配相关配置", "ranxiongxiong"));
        UltraSettingsManager.b("live_multi_order_sing_order_panel_schema", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_order_sing_order_panel_schema", Reflection.getOrCreateKotlinClass(String.class), "你点我唱玩法打开点唱列表", "ranxiongxiong"));
        UltraSettingsManager.b("live_merge_vs_room_keep_linker_detail", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_merge_vs_room_keep_linker_detail", Reflection.getOrCreateKotlinClass(r1), "节目直播间横竖屏切换不更新linkerDetail字段", "zhanghao"));
        UltraSettingsManager.b("live_ktv_enable_new_mv_layout", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_enable_new_mv_layout", Reflection.getOrCreateKotlinClass(r1), "新的mv 舞台布局方式", "ranxiongxiong"));
        UltraSettingsManager.b("multi_link_lynxview_window_manager_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("multi_link_lynxview_window_manager_enable", Reflection.getOrCreateKotlinClass(r1), "多人场景动态框架是否支持windowManager能力", "ranxiongxiong"));
        UltraSettingsManager.b("live_stream_enable_sei_sign", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_stream_enable_sei_sign", Reflection.getOrCreateKotlinClass(r1), "是否启用SEI帧签名", "ranxiongxiong"));
        UltraSettingsManager.b("live_enable_video_talk_link_view_start_video_on_init", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_enable_video_talk_link_view_start_video_on_init", Reflection.getOrCreateKotlinClass(r1), "多人场景VideoTalkLinkView初始化时是否开启视频采集", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_rt_chorus_distribute_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_rt_chorus_distribute_opt", Reflection.getOrCreateKotlinClass(r1), "K歌模块支持实时合唱分发", "ranxiongxiong"));
        UltraSettingsManager.b("live_anchor_apply_list_use_waiting_list", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_anchor_apply_list_use_waiting_list", Reflection.getOrCreateKotlinClass(r1), "主播申请列表是否使用waiting_list接口", "ranxiongxiong"));
        UltraSettingsManager.b("live_base_popup_manager_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_base_popup_manager_enable", Reflection.getOrCreateKotlinClass(r1), "直播间气泡统一管理开关", "ranxiongxiong"));
        UltraSettingsManager.b("live_social_help_page_lynx", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_social_help_page_lynx", Reflection.getOrCreateKotlinClass(m7.class), "玩法说明页Lynx资源配置", "ranxiongxiong"));
        UltraSettingsManager.b("live_opus_midi_bg_fix", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_opus_midi_bg_fix", Reflection.getOrCreateKotlinClass(r1), "ktv midi bg修复", "ranxiongxiong"));
        UltraSettingsManager.b("live_multi_link_enable_link_opt_v4", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_link_enable_link_opt_v4", Reflection.getOrCreateKotlinClass(r1), "多人场景建联优化四期开关", "ranxiongxiong"));
        UltraSettingsManager.b("live_order_sing_mv_mask_view_default_visible", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_order_sing_mv_mask_view_default_visible", Reflection.getOrCreateKotlinClass(r1), "你点我唱MV蒙层默认可见性", "ranxiongxiong"));
        UltraSettingsManager.b("live_aimv_video_engine_leak_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_aimv_video_engine_leak_opt", Reflection.getOrCreateKotlinClass(r1), "AIMV TTVideoEngine泄露优化", "wuzhixin.jensen"));
        UltraSettingsManager.b("live_ktv_loudness_balance", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_loudness_balance", Reflection.getOrCreateKotlinClass(w41.class), "音量均衡开关及其配置", "ranxiongxiong"));
        UltraSettingsManager.b("live_voice_chat_enter_info_clear_fix", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_voice_chat_enter_info_clear_fix", Reflection.getOrCreateKotlinClass(r1), "语音聊天室关闭清除enter_info数据", "ranxiongxiong"));
        UltraSettingsManager.b("live_multi_link_use__media_change_info", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_link_use__media_change_info", Reflection.getOrCreateKotlinClass(r1), "多人场景是否使用更新媒体参数消息", "liaonanshan"));
        UltraSettingsManager.b("linkmic_chorus_concert_enable_link_service", new com.bytedance.tools.kcp.ultrasettings.runtime.c("linkmic_chorus_concert_enable_link_service", Reflection.getOrCreateKotlinClass(r1), "演唱会模式开启连线服务中间层", "zhanghao"));
        UltraSettingsManager.b("live_ktv_lyrics_animation_res", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_lyrics_animation_res", Reflection.getOrCreateKotlinClass(String.class), "k歌歌词动效资源地址", "ranxiongxiong"));
        UltraSettingsManager.b("ktv_chorus_push_stream_mode_change", new com.bytedance.tools.kcp.ultrasettings.runtime.c("ktv_chorus_push_stream_mode_change", Reflection.getOrCreateKotlinClass(r1), "实时合唱角色推流模式变更", "ranxiongxiong"));
        UltraSettingsManager.b("multi_link_rtc_time_out_threshold", new com.bytedance.tools.kcp.ultrasettings.runtime.c("multi_link_rtc_time_out_threshold", Reflection.getOrCreateKotlinClass(r2), "RTC超时阈值配置", "ranxiongxiong"));
        UltraSettingsManager.b("live_anchor_enable_video_mock_push_stream", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_anchor_enable_video_mock_push_stream", Reflection.getOrCreateKotlinClass(r1), "支持视频mock推流", "ranxiongxiong"));
        UltraSettingsManager.b("live_interact_xplay_mix_frame_reinit_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_interact_xplay_mix_frame_reinit_enable", Reflection.getOrCreateKotlinClass(r1), "多人场景开启云游戏后的自定义合流重置机制是否开启", "ranxiongxiong"));
        UltraSettingsManager.b("live_chat_channel_link_audio_process_delay_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_chat_channel_link_audio_process_delay_enable", Reflection.getOrCreateKotlinClass(r1), "频道房边看边聊音频托管是否延后", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_support_soft_ware_ear_monitor", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_support_soft_ware_ear_monitor", Reflection.getOrCreateKotlinClass(r1), "ktv支持软件耳返", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_global_echo_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_global_echo_enable", Reflection.getOrCreateKotlinClass(r1), "k歌场景下全局耳返开关", "ranxiongxiong"));
        UltraSettingsManager.b("live_new_ktv_mv_gray_fix_fallback", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_new_ktv_mv_gray_fix_fallback", Reflection.getOrCreateKotlinClass(r1), "灰度fix开关", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_preview_songs", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_preview_songs", Reflection.getOrCreateKotlinClass(r3), "歌房冷启推荐歌单", "ranxiongxiong"));
        UltraSettingsManager.b("linkmic_list_and_get_settings_using_wrds", new com.bytedance.tools.kcp.ultrasettings.runtime.c("linkmic_list_and_get_settings_using_wrds", Reflection.getOrCreateKotlinClass(r1), "listv2-setting-msg支持WRDS", "ranxiongxiong"));
        UltraSettingsManager.b("live_quick_interact_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_quick_interact_enable", Reflection.getOrCreateKotlinClass(r1), "是否开启快捷互动能力", "ranxiongxiong"));
        UltraSettingsManager.b("solo_ktv_stream_monitor_interval", new com.bytedance.tools.kcp.ultrasettings.runtime.c("solo_ktv_stream_monitor_interval", Reflection.getOrCreateKotlinClass(r2), "录唱流监控interaval", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_admin_role_change_refresh_waiting_list", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_admin_role_change_refresh_waiting_list", Reflection.getOrCreateKotlinClass(r1), "管理员角色变更，刷新等待列表", "ranxiongxiong"));
        UltraSettingsManager.b("live_link_supported_force_server_mix", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_link_supported_force_server_mix", Reflection.getOrCreateKotlinClass(r1), "多人场景是否支持强制服务端合流", "ranxiongxiong"));
        UltraSettingsManager.b("live_linkmic_charge_opt_lynx", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_linkmic_charge_opt_lynx", Reflection.getOrCreateKotlinClass(wd1.class), "付费连线玩法开启面板url复合字段", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_room_sub_view_record_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_room_sub_view_record_enable", Reflection.getOrCreateKotlinClass(r1), "ktv模式各元素首帧埋点", "ranxiongxiong"));
        UltraSettingsManager.b("live_2990_share_callback", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_2990_share_callback", Reflection.getOrCreateKotlinClass(r1), "分享fix直接跟板兜底", "ranxiongxiong"));
        UltraSettingsManager.b("live_solo_ktv_export_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_solo_ktv_export_opt", Reflection.getOrCreateKotlinClass(r1), "个人练歌房导出优化", "ranxiongxiong"));
        UltraSettingsManager.b("live_multi_link_guest_player_view_sei_update_timeout_switch_preview_v2", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_link_guest_player_view_sei_update_timeout_switch_preview_v2", Reflection.getOrCreateKotlinClass(r1), "预览流多人场景观众seiVersion更新过期开关", "ranxiongxiong"));
        UltraSettingsManager.b("live_multi_link_non_full_preview_dynamic", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_link_non_full_preview_dynamic", Reflection.getOrCreateKotlinClass(r1), "非全屏预览流加载动态容器", "ranxiongxiong"));
        UltraSettingsManager.b("anchor_data_handover_by_pk_is_stopengine", new com.bytedance.tools.kcp.ultrasettings.runtime.c("anchor_data_handover_by_pk_is_stopengine", Reflection.getOrCreateKotlinClass(r1), "PK结束后的数据交接与否与PK是否stopEngine保持一致", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_lyric_read_fix", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_lyric_read_fix", Reflection.getOrCreateKotlinClass(u91.class), "歌词解析修复", "ranxiongxiong"));
        UltraSettingsManager.b("live_share_video_invitation_sensing_enabled_anchor", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_share_video_invitation_sensing_enabled_anchor", Reflection.getOrCreateKotlinClass(r3), "主播测一起看新邀请流程开关", "ranxiongxiong"));
        UltraSettingsManager.b("multi_link_feed_view_player_flutter_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("multi_link_feed_view_player_flutter_opt", Reflection.getOrCreateKotlinClass(r1), "多人场景预览流特定设备播放器抖动问题修复开关", "ranxiongxiong"));
        UltraSettingsManager.b("ktv_decorate_tag_scheme", new com.bytedance.tools.kcp.ultrasettings.runtime.c("ktv_decorate_tag_scheme", Reflection.getOrCreateKotlinClass(String.class), "ktv装扮荣誉标签说明页", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_frist_level_tab_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_frist_level_tab_config", Reflection.getOrCreateKotlinClass(LiveKtvFirstLevelTabConfig.class), "KTV 一级tab 配置", "ranxiongxiong"));
        UltraSettingsManager.b("live_solo_ktv_midi_score", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_solo_ktv_midi_score", Reflection.getOrCreateKotlinClass(r1), "个人练midi得分获取方式", "ranxiongxiong"));
        UltraSettingsManager.b("live_digit_avatar_recognition_open_camera_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_digit_avatar_recognition_open_camera_enable", Reflection.getOrCreateKotlinClass(r1), "avatar虚拟形象识别及预览时是否可以打开摄像实时驱动", "ranxiongxiong"));
        UltraSettingsManager.b("live_disable_audio_capture_in_picker_custom_image", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_disable_audio_capture_in_picker_custom_image", Reflection.getOrCreateKotlinClass(r1), "表情上传跳转相册是否禁用音频采集", "wuzhixin.jensen"));
        UltraSettingsManager.b("solo_ktv_segment_end_time_offset", new com.bytedance.tools.kcp.ultrasettings.runtime.c("solo_ktv_segment_end_time_offset", Reflection.getOrCreateKotlinClass(r2), "个人练歌房片断唱结束时间往后偏移", "ranxiongxiong"));
        UltraSettingsManager.b("live_quick_interact_max_queue", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_quick_interact_max_queue", Reflection.getOrCreateKotlinClass(r3), "快捷互动队列最大值", "ranxiongxiong"));
        UltraSettingsManager.b("live_multilink_new_video_link_lynx_card_fail_release_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multilink_new_video_link_lynx_card_fail_release_opt", Reflection.getOrCreateKotlinClass(r1), "新视频连线Lynx Load Fail release 兜底", "wuzhixin.jensen"));
        UltraSettingsManager.b("live_ktv_player_progress_frequency_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_player_progress_frequency_opt", Reflection.getOrCreateKotlinClass(r3), "ktv播放降频优化开关", "ranxiongxiong"));
        UltraSettingsManager.b("video_ktv_update_rtc_param_when_switch_camera", new com.bytedance.tools.kcp.ultrasettings.runtime.c("video_ktv_update_rtc_param_when_switch_camera", Reflection.getOrCreateKotlinClass(r1), "视频KTV是否在切换视频上麦时更新RTC参数", "ranxiongxiong"));
        UltraSettingsManager.b("live_enable_multi_link_join_room_in_advance", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_enable_multi_link_join_room_in_advance", Reflection.getOrCreateKotlinClass(r1), "多人场景建联提前建联优化", "ranxiongxiong"));
        UltraSettingsManager.b("live_lyric_live_data_update", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_lyric_live_data_update", Reflection.getOrCreateKotlinClass(r1), "旧舞台歌词刷新fix", "ranxiongxiong"));
        UltraSettingsManager.b("live_chatroom_lynx_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_chatroom_lynx_config", Reflection.getOrCreateKotlinClass(g1.class), "多人场景聊天室Lynx通用配置", "ranxiongxiong"));
        UltraSettingsManager.b("live_lynx_schema_guest_honor_hall", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_lynx_schema_guest_honor_hall", Reflection.getOrCreateKotlinClass(String.class), "嘉宾荣誉馆入口schema", "ranxiongxiong"));
        UltraSettingsManager.b("live_enable_new_midi", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_enable_new_midi", Reflection.getOrCreateKotlinClass(r1), "新midi总开关", "zengle"));
        UltraSettingsManager.b("live_video_linker_when_beauty_change_2_audio", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_video_linker_when_beauty_change_2_audio", Reflection.getOrCreateKotlinClass(r1), "视频聊天室嘉宾美颜时是否切换到语音连麦", "ranxiongxiong"));
        UltraSettingsManager.b("live_core_single_view_mode_switch", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_core_single_view_mode_switch", Reflection.getOrCreateKotlinClass(r1), "RTC是否开启单View模式", "ranxiongxiong"));
        UltraSettingsManager.b("live_link_multi_enlarge_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_link_multi_enlarge_enable", Reflection.getOrCreateKotlinClass(r1), "是否支持多主咖模式", "ranxiongxiong"));
        UltraSettingsManager.b("live_chat_channel_audio_playback_default_volume", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_chat_channel_audio_playback_default_volume", Reflection.getOrCreateKotlinClass(r3), "频道房边看边聊聊天默认音量", "ranxiongxiong"));
        UltraSettingsManager.b("live_linkmic_dynamic_center_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_linkmic_dynamic_center_config", Reflection.getOrCreateKotlinClass(LiveLinkMicDynamicCenterConfig.class), "直播新连线动态化配置", "ranxiongxiong"));
        UltraSettingsManager.b("live_icon_panel_refact", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_icon_panel_refact", Reflection.getOrCreateKotlinClass(r1), "聊天室互动面板重构", "ranxiongxiong"));
        UltraSettingsManager.b("link_guest_battle_support_scene", new com.bytedance.tools.kcp.ultrasettings.runtime.c("link_guest_battle_support_scene", L, "嘉宾大作战入口控制", "ranxiongxiong"));
        UltraSettingsManager.b("live_audio_chat_stage_enlarge_guest_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_audio_chat_stage_enlarge_guest_opt", Reflection.getOrCreateKotlinClass(r1), "优化单双主咖切换时舞台区麦位逻辑", "ranxiongxiong"));
        UltraSettingsManager.b("live_multi_audio_pub_stream_fall_back_protect", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_audio_pub_stream_fall_back_protect", Reflection.getOrCreateKotlinClass(r1), "【语音】跨房厅战公共流回退到跨房流后，首帧回调到来不再mute跨房流", "ranxiongxiong"));
        UltraSettingsManager.b("multi_anchor_cache_list_opt_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("multi_anchor_cache_list_opt_enable", Reflection.getOrCreateKotlinClass(r1), "PK&主播连线cacheList在leave消息时不清理", "ranxiongxiong"));
        UltraSettingsManager.b("live_multi_ktv_new_entrance_style", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_ktv_new_entrance_style", Reflection.getOrCreateKotlinClass(r1), "KTV一级入口优化", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_my_sei_check", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_my_sei_check", Reflection.getOrCreateKotlinClass(r1), "sei身份校验，不处理自己发送的sei", "ranxiongxiong"));
        UltraSettingsManager.b("live_linkmic_leave_page_v2_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_linkmic_leave_page_v2_enable", Reflection.getOrCreateKotlinClass(r1), "多人连线结束页样式(0: 旧样式, 1: 新样式带嘉宾贡献榜和房间推荐)", "ranxiongxiong"));
        UltraSettingsManager.b("live_link_float_layout_empty_style", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_link_float_layout_empty_style", Reflection.getOrCreateKotlinClass(r3), "浮窗布局加入连线按钮样式反转", "ranxiongxiong"));
        UltraSettingsManager.b("live_audience_default_open_camera", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_audience_default_open_camera", Reflection.getOrCreateKotlinClass(r1), "嘉宾默认视频连线和展示美颜面板开关", "ranxiongxiong"));
        UltraSettingsManager.b("live_interact_xplay_mix_frame_detect_delay", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_interact_xplay_mix_frame_detect_delay", Reflection.getOrCreateKotlinClass(r3), "多人场景开启云游戏后的自定义合流首帧超时检测时间", "ranxiongxiong"));
        UltraSettingsManager.b("live_multi_link_duration_upload_delay_duration", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_link_duration_upload_delay_duration", Reflection.getOrCreateKotlinClass(r2), "多人场景建联耗时上报延时", "ranxiongxiong"));
        UltraSettingsManager.b("live_ksong_roomcontext_check", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ksong_roomcontext_check", Reflection.getOrCreateKotlinClass(r1), "roomcontext离开直播间校验", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_load_delay", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_load_delay", Reflection.getOrCreateKotlinClass(r1), "KTV内外流复用加载时机延后到bind", "ranxiongxiong"));
        UltraSettingsManager.b("live_playmode_entrance_optimize_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_playmode_entrance_optimize_enable", Reflection.getOrCreateKotlinClass(r1), "是否开启多人场景玩法路径优化", "ranxiongxiong"));
        UltraSettingsManager.b("live_voice_chat_room_short_video_switch_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_voice_chat_room_short_video_switch_enable", Reflection.getOrCreateKotlinClass(r1), "语音房是否允许一起看玩法与KTV&聊天室互切", "ranxiongxiong"));
        UltraSettingsManager.b("multi_link_apply_list_permit_remove_item_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("multi_link_apply_list_permit_remove_item_opt", Reflection.getOrCreateKotlinClass(r1), "多人场景申请列表接受连线申请后隐藏该用户申请", "ranxiongxiong"));
        UltraSettingsManager.b("live_check_linker_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_check_linker_enable", Reflection.getOrCreateKotlinClass(r1), "是否开启上报，默认开启", "ranxiongxiong"));
        UltraSettingsManager.b("live_real_time_chorus_lynx_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_real_time_chorus_lynx_config", Reflection.getOrCreateKotlinClass(m71.class), "实时合唱lynx配置", "ranxiongxiong"));
        UltraSettingsManager.b("live_multi_link_fetch_list_wrds_backup_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_link_fetch_list_wrds_backup_opt", Reflection.getOrCreateKotlinClass(r1), "多人场景麦位数据wrds兜底优化", "ranxiongxiong"));
        UltraSettingsManager.b("live_big_party_fast_match_and_strong_reach_audio_apply", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_big_party_fast_match_and_strong_reach_audio_apply", Reflection.getOrCreateKotlinClass(r1), "视频聊天室摇一摇快速匹配和强触达默认使用语音连线", "ranxiongxiong"));
        UltraSettingsManager.b("interact_permission_guarantor_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("interact_permission_guarantor_enable", Reflection.getOrCreateKotlinClass(r1), "音视频权限释放白名单页面机制开关", "ranxiongxiong"));
        UltraSettingsManager.b("link_list_interact_optimize_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("link_list_interact_optimize_enable", Reflection.getOrCreateKotlinClass(r1), "listV1接口下线开关", "ranxiongxiong"));
        UltraSettingsManager.b("live_interact_keep_gift_value_after_leave_mic", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_interact_keep_gift_value_after_leave_mic", Reflection.getOrCreateKotlinClass(r1), "清空嘉宾计值实验入口", "ranxiongxiong"));
        UltraSettingsManager.b("LIVE_NEW_KTV_USE_ABR", new com.bytedance.tools.kcp.ultrasettings.runtime.c("LIVE_NEW_KTV_USE_ABR", Reflection.getOrCreateKotlinClass(r1), "新mv开启码率自适应开关", "ranxiongxiong"));
        UltraSettingsManager.b("voice_audience_apply_reason_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("voice_audience_apply_reason_enable", Reflection.getOrCreateKotlinClass(r3), "语音聊天室观众支持申请理由", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_component_lyric_download_auto_remove_listener", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_component_lyric_download_auto_remove_listener", Reflection.getOrCreateKotlinClass(r1), "K歌组件歌词下载自动取消下载监听器", "ranxiongxiong"));
        UltraSettingsManager.b("video_friend_open_pair_duration", new com.bytedance.tools.kcp.ultrasettings.runtime.c("video_friend_open_pair_duration", Reflection.getOrCreateKotlinClass(r2), "视频交友触发配对的冷却时间", "ranxiongxiong"));
        UltraSettingsManager.b("live_new_video_linkmic_fix_screen", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_new_video_linkmic_fix_screen", Reflection.getOrCreateKotlinClass(r1), "新视频连线卡片适配全屏", "wuzhixin.jensen"));
        UltraSettingsManager.b("live_multi_scene_enter_room_sync_to_full_link", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_scene_enter_room_sync_to_full_link", Reflection.getOrCreateKotlinClass(r1), "多人场景进房上报埋点到全链路", "ranxiongxiong"));
        UltraSettingsManager.b("enable_ktv_hardware_echo", new com.bytedance.tools.kcp.ultrasettings.runtime.c("enable_ktv_hardware_echo", Reflection.getOrCreateKotlinClass(r1), "KTV支持硬件耳返", "ranxiongxiong"));
        UltraSettingsManager.b("live_myself_sei_filter", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_myself_sei_filter", Reflection.getOrCreateKotlinClass(r1), "嘉宾过滤自己的sei", "ranxiongxiong"));
        UltraSettingsManager.b("new_video_linkmic_anchor_react_click_enable_layouts", new com.bytedance.tools.kcp.ultrasettings.runtime.c("new_video_linkmic_anchor_react_click_enable_layouts", M, "主播模式处理区域点击事件的可用布局列表", "wuzhixin.jensen"));
        UltraSettingsManager.b("live_quick_thank_choose_panel_url", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_quick_thank_choose_panel_url", Reflection.getOrCreateKotlinClass(String.class), "快捷互动感谢面板lynx url", "ranxiongxiong"));
        UltraSettingsManager.b("link_interact_audience_opt_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("link_interact_audience_opt_enable", Reflection.getOrCreateKotlinClass(r1), "是否开启观众连线异常处理", "ranxiongxiong"));
        UltraSettingsManager.b("live_gift_gl_optimize", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_gift_gl_optimize", Reflection.getOrCreateKotlinClass(r1), "GL优化飞麦礼物性能及覆盖率", "ranxiongxiong"));
        UltraSettingsManager.b("live_lip_sync_custom_download_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_lip_sync_custom_download_enable", Reflection.getOrCreateKotlinClass(r1), "lipsync模型自定义下载", "ranxiongxiong"));
        UltraSettingsManager.b("multi_link_match_screen_right_margin_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("multi_link_match_screen_right_margin_opt", Reflection.getOrCreateKotlinClass(MultiLinkMatchScreenConfig.class), "多人场景通用布局公屏RightMargin改造", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_chorus_midi_report_count", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_chorus_midi_report_count", Reflection.getOrCreateKotlinClass(r2), "实时合唱评分上报频率", "ranxiongxiong"));
        UltraSettingsManager.b("live_real_time_chorus_lead_voice_volume_set", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_real_time_chorus_lead_voice_volume_set", Reflection.getOrCreateKotlinClass(r1), "领唱模式用户人声音量设置时机修复", "ranxiongxiong"));
        UltraSettingsManager.b("live_solo_ktv_template_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_solo_ktv_template_enable", Reflection.getOrCreateKotlinClass(r3), "个人练歌房模版实验", "ranxiongxiong"));
        UltraSettingsManager.b("live_dynamic_toolbar_linkmic_double_check", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_dynamic_toolbar_linkmic_double_check", Reflection.getOrCreateKotlinClass(r1), "toolbar动态化改造连线组件二次确认", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_cut_song_clear_sing_state_fix", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_cut_song_clear_sing_state_fix", Reflection.getOrCreateKotlinClass(r1), "ktv场景切歌后情况演唱状态修复", "ranxiongxiong"));
        UltraSettingsManager.b("multi_link_enter_room_log_keys", new com.bytedance.tools.kcp.ultrasettings.runtime.c("multi_link_enter_room_log_keys", N, "多人场景进房埋点上报链路细节耗时keys集合", "ranxiongxiong"));
        UltraSettingsManager.b("live_multi_link_request_song_init_fix", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_link_request_song_init_fix", Reflection.getOrCreateKotlinClass(r1), "你点我唱初始化修复", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_chorus_guest_linkmic_height", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_chorus_guest_linkmic_height", Reflection.getOrCreateKotlinClass(r3), "实时合唱常驻嘉宾区公屏压缩高度", "ranxiongxiong"));
        UltraSettingsManager.b("live_order_fragment_lazy_load", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_order_fragment_lazy_load", Reflection.getOrCreateKotlinClass(r1), "点歌面板数据懒加载", "ranxiongxiong"));
        UltraSettingsManager.b("solo_ktv_volume_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("solo_ktv_volume_config", Reflection.getOrCreateKotlinClass(lh1.class), "Solo Ktv默认音量配置", "ranxiongxiong"));
        UltraSettingsManager.b("live_multilink_dynamic_memory_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multilink_dynamic_memory_opt", Reflection.getOrCreateKotlinClass(r1), "多人场景Lynx容器复用内存释放", "ranxiongxiong"));
        UltraSettingsManager.b("live_order_song_2d_virtual_avatar_opt_full_switch", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_order_song_2d_virtual_avatar_opt_full_switch", Reflection.getOrCreateKotlinClass(r1), "你点我唱可视化升级2d虚拟形象全量开关", "ranxiongxiong"));
        UltraSettingsManager.b("solo_ktv_stream_monitor_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("solo_ktv_stream_monitor_enable", Reflection.getOrCreateKotlinClass(r1), "录唱流监控", "ranxiongxiong"));
        UltraSettingsManager.b("live_linkmic_online_float_window_rtc_backup_switch", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_linkmic_online_float_window_rtc_backup_switch", Reflection.getOrCreateKotlinClass(r1), "多人场景连线小窗异常情况RTC兜底开关，默认开", "ranxiongxiong"));
        UltraSettingsManager.b("live_interact_api_list_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_interact_api_list_enable", Reflection.getOrCreateKotlinClass(r1), "观众连麦是否使用接口返回的listuser信息", "ranxiongxiong"));
        UltraSettingsManager.b("live_enable_multi_link_monitor_trace", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_enable_multi_link_monitor_trace", Reflection.getOrCreateKotlinClass(r1), "是否开启多人场景连线流程日志trace", "ranxiongxiong"));
        UltraSettingsManager.b("live_flymic_random_probability_delivery_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_flymic_random_probability_delivery_enable", Reflection.getOrCreateKotlinClass(r1), "飞麦礼物是否开启server下发麦位动画", "ranxiongxiong"));
        UltraSettingsManager.b("voice_chat_room_interact_mode_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("voice_chat_room_interact_mode_enable", Reflection.getOrCreateKotlinClass(r1), "语音聊天室interactMode更新", "ranxiongxiong"));
        UltraSettingsManager.b("live_multi_link_feedback_dialog_info_hide", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_link_feedback_dialog_info_hide", Reflection.getOrCreateKotlinClass(r1), "多人连线反馈面板内容交互优化", "ranxiongxiong"));
        UltraSettingsManager.b("live_radio_anchor_info_visibility_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_radio_anchor_info_visibility_opt", Reflection.getOrCreateKotlinClass(r1), "语音电台头像显隐优化", "ranxiongxiong"));
        UltraSettingsManager.b("live_dylite_audio_capture_background_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_dylite_audio_capture_background_enable", Reflection.getOrCreateKotlinClass(r1), "抖音极速版语音直播退后台是否采集音频", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_singing_rank_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_singing_rank_config", Reflection.getOrCreateKotlinClass(f9.class), "ktv单曲贡献榜和实时榜切换开关", "ranxiongxiong"));
        UltraSettingsManager.b("live_real_time_chorus_lead_download_count", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_real_time_chorus_lead_download_count", Reflection.getOrCreateKotlinClass(r3), "实时合唱领唱下载歌曲数量", "ranxiongxiong"));
        UltraSettingsManager.b("live_guest_battle_hide_heartbroken", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_guest_battle_hide_heartbroken", Reflection.getOrCreateKotlinClass(r3), "语音麦位去掉头像心碎", "ranxiongxiong"));
        UltraSettingsManager.b("live_party_ktv_dynamic_lynx", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_party_ktv_dynamic_lynx", Reflection.getOrCreateKotlinClass(String.class), "实时合唱舞台Lynx url", "ranxiongxiong"));
        UltraSettingsManager.b("live_interact_function_type_settings", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_interact_function_type_settings", Reflection.getOrCreateKotlinClass(u5.class), "function_type2埋点参数映射规则", "ranxiongxiong"));
        UltraSettingsManager.b("solo_ktv_fragment_permission_guarantor_check_content", new com.bytedance.tools.kcp.ultrasettings.runtime.c("solo_ktv_fragment_permission_guarantor_check_content", O, "个人练歌房跳转目标fragment，释放音频权限的名单", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_sing_record_lynx", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_sing_record_lynx", P, "ktv演唱沉淀lynx配置", "ranxiongxiong"));
        UltraSettingsManager.b("link_multi_seat_widget_component_audio_clear_anim", new com.bytedance.tools.kcp.ultrasettings.runtime.c("link_multi_seat_widget_component_audio_clear_anim", Reflection.getOrCreateKotlinClass(r1), "语音场景Layer挂件动画clear兜底", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_preview_wrds_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_preview_wrds_enable", Reflection.getOrCreateKotlinClass(r1), "ktv观众预览流优化开关", "ranxiongxiong"));
        UltraSettingsManager.b("live_multi_link_video_startmode_setting", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_link_video_startmode_setting", Reflection.getOrCreateKotlinClass(rj1.class), "视频聊天室开启路径优化", "ranxiongxiong"));
        UltraSettingsManager.b("live_digit_avatar_slow_function_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_digit_avatar_slow_function_opt", Reflection.getOrCreateKotlinClass(r1), "数字人慢函数优化", "ranxiongxiong"));
        UltraSettingsManager.b("multi_link_base_common_window_adapte_screen_cast_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("multi_link_base_common_window_adapte_screen_cast_enable", Reflection.getOrCreateKotlinClass(r1), "通用布局适配动态浮窗投屏的开关", "ranxiongxiong"));
        UltraSettingsManager.b("live_link_integration_guide_res", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_link_integration_guide_res", Reflection.getOrCreateKotlinClass(s01.class), "连线整合引导资源", "ranxiongxiong"));
        UltraSettingsManager.b("live_ktv_chorus_guest_linkmic_url", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ktv_chorus_guest_linkmic_url", Reflection.getOrCreateKotlinClass(String.class), "实时合唱支持嘉宾连线麦位schema", "ranxiongxiong"));
    }
}
