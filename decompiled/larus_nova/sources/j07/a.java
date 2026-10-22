package j07;

import android.content.Context;
import android.widget.FrameLayout;
import androidx.camera.video.AudioStats;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.lynx.media.playable.IVideoEnginePlayable;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.react.bridge.ReadableMapKeySetIterator;
import com.lynx.tasm.base.LLog;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttm.player.PlaybackParams;
import com.ss.ttvideoengine.ITTVideoEngineEventSource;
import com.ss.ttvideoengine.TTVideoEngine;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes21.dex */
public final class a extends j07.b {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final m07.a f496813f;

    /* JADX INFO: renamed from: j07.a$a, reason: collision with other inner class name */
    public static final class C6378a {
    }

    public static final class b extends f07.a.C5843a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f496814a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f496815b;

        @Override // f07.a
        public final int a() {
            if (Intrinsics.areEqual("light", this.f496815b) == false) goto L5;
            return 2;
        L5:
            return 0;
        }

        public b(a r100, String r101) {
            this.f496814a = r100;
            this.f496815b = r101;
        }

        @Override // f07.a
        public final void b(TTVideoEngine r100, g07.b r101) {
            Intrinsics.checkNotNullParameter(r100, "engine");
            Intrinsics.checkNotNullParameter(r101, MapController.ITEM_LAYER_TAG);
            this.f496814a.f496819d = new WeakReference(r100);
            String r102 = r101.f479495k;
            if (r102 != null) goto L5;
        L8:
            boolean r103 = true;
        L9:
            if (r103 == true) goto L11;
            r100.setTag(r101.f479495k);
        L11:
            String r104 = r101.f479496l;
            if (r104 != null) goto L14;
        L17:
            boolean r105 = true;
        L18:
            if (r105 == true) goto L20;
            r100.setSubTag(r101.f479496l);
        L20:
            r100.setIsMute(r101.f479498n.f479475a);
            r100.setLooping(r101.f479498n.f479476b);
            double r106 = r101.f479498n.f479477c;
            if (AudioStats.AUDIO_AMPLITUDE_NONE <= r106) goto L23;
        L25:
            boolean r107 = false;
        L26:
            if (r107 == false) goto L28;
            r100.setIntOption(415, 1);
            float r108 = r101.f479498n.f479477c;
            r100.setVolume(r108, r108);
        L28:
            float r109 = r101.f479498n.f479478d;
            PlaybackParams r110 = new PlaybackParams();
            r110.setSpeed(r109);
            r100.setPlaybackParams(r110);
            ReadableMap r111 = r101.f479498n.f479481g;
            if (r111 == null) goto L39;
            ReadableMapKeySetIterator r112 = r111.keySetIterator();
        L32:
            if (r112.hasNextKey() == false) goto L39;
            String r113 = r112.nextKey();
            String r114 = r111.getString(r113, "");
            if (r114.length() <= 0) goto L36;
            boolean r115 = true;
        L37:
            if (r115 == false) goto L32;
            r100.setCustomHeader(r113, r114);
            goto L32
        L36:
            r115 = false;
        L39:
            int r116 = r101.f479497m;
            if (r116 <= 0) goto L42;
            r100.setStartTime(r116);
        L42:
            int r117 = r101.f479494j;
            if (r117 <= 0) goto L45;
            r100.setIntOption(161, r117);
        L45:
            a r118 = this.f496814a;
            Map<Integer, ? extends Pair<? extends Object, ? extends IVideoEnginePlayable.IVideoEnginePlayablePlayOptionType>> r119 = r118.f496820e;
            if (r119 == null) goto L48;
            r118.p(r119);
        L48:
            this.f496814a.f496820e = null;
            return;
        L23:
            if (r106 > 1.0d) goto L25;
            r107 = true;
            goto L26
        L14:
            if (r104.length() == 0) goto L17;
            r105 = false;
            goto L18
        L5:
            if (r102.length() == 0) goto L8;
            r103 = false;
            goto L9
        }
    }

    static {
    }

    @Override // com.bytedance.lynx.media.playable.IVideoEnginePlayable
    public final void l(FrameLayout r100) {
        Intrinsics.checkNotNullParameter(r100, "parentLayout");
    }

    @Override // com.bytedance.lynx.media.playable.IVideoEnginePlayable
    public final void initialize() {
        m07.a r100 = this.f496813f;
        Intrinsics.checkNotNullParameter(r100, "delegate");
        this.f496817b = r100;
    }

    public a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f496813f = new m07.a(r100);
    }

    @Override // com.bytedance.lynx.media.playable.IVideoEnginePlayable
    public final void c(com.bytedance.lynx.media.b r100) {
        r100.a(3, null, 0, "exitFullScreen not supported");
    }

    @Override // com.bytedance.lynx.media.playable.IVideoEnginePlayable
    public final void f(com.bytedance.lynx.media.b r100) {
        if (this.f496813f.e() == true) goto L7;
        if (r100 == null) goto L11;
        r100.a(7, null, -1, "player is not prepared");
        return;
    L11:
        return;
    L7:
        this.f496813f.h();
        if (r100 == null) goto L12;
        r100.a(0, null, 0, null);
        return;
    }

    @Override // com.bytedance.lynx.media.playable.IVideoEnginePlayable
    public final void g(IVideoEnginePlayable.a r100) {
        m07.a r101 = this.f496813f;
        if (r101.d() == true) goto L6;
        LLog.i("AudioMediaView", "Failed to trigger prepare due to not properly initialized");
    L11:
        if (r100 == null) goto L13;
        r100.a(0, null, 0, null);
    L13:
        LLog.i("TTVideoEngineAudioPlayable", "Trigger prepare in MediaPlayable instance");
        return;
    L6:
        if (r101.f511489h == false) goto L8;
        LLog.i("AudioMediaView", "Failed to trigger prepare due to already called");
        goto L11
    L8:
        r101.f264837b.e(false);
        LLog.i("AudioMediaView", "Did trigger VideoController prepare in AudioMediaView");
        if (r101.f511489h == true) goto L11;
        r101.f511489h = true;
        goto L11
    }

    @Override // com.bytedance.lynx.media.playable.IVideoEnginePlayable
    public final void i(com.bytedance.lynx.media.b r100) {
        r100.a(3, null, 0, "requestPortraitFullScreen not supported");
    }

    @Override // com.bytedance.lynx.media.playable.IVideoEnginePlayable
    public final void m(com.bytedance.lynx.media.b r100) {
        r100.a(3, null, 0, "enterFullScreen not supported");
    }

    @Override // com.bytedance.lynx.media.playable.IVideoEnginePlayable
    public final void o(Map<String, ? extends Object> r310) {
        Intrinsics.checkNotNullParameter(r310, "params");
        Intrinsics.checkNotNullParameter(r310, "params");
        boolean r100 = true;
        int r101 = 0;
        if (r310.size() == 1) goto L5;
    L7:
        boolean r102 = false;
    L8:
        Integer r103 = null;
        String r110 = "";
        if (r102 == true) goto L11;
        m07.a r104 = this.f496813f;
        Object r111 = r310.get("skip_prepare_check");
        if ((r111 instanceof Boolean) == false) goto L104;
        Boolean r112 = (Boolean) r111;
    L105:
        if (r112 != null) goto L107;
        r112 = Boolean.FALSE;
    L107:
        r104.f264842g = r112;
        Object r105 = r310.get("player-type");
        if ((r105 instanceof String) == false) goto L110;
        String r106 = (String) r105;
    L111:
        if (r106 != null) goto L114;
        r106 = "default";
    L114:
        if (r310.containsKey("video_model") == false) goto L121;
        Object r107 = r310.get("video_model");
        if ((r107 instanceof String) == false) goto L118;
        String r113 = (String) r107;
    L119:
        this.f496818c = new g07.b(null, r113, null, null, null, null, null, 125);
    L169:
        g07.b r108 = this.f496818c;
        if (r108 != null) goto L172;
    L272:
        g07.b r109 = this.f496818c;
        if (r109 == null) goto L279;
        this.f496813f.g(r109, new b(this, r106));
        return;
    L279:
        return;
    L172:
        if (r310.containsKey("muted") == false) goto L182;
        g07.a r114 = r108.f479498n;
        Object r115 = r310.get("muted");
        if ((r115 instanceof Boolean) == false) goto L176;
        Boolean r116 = (Boolean) r115;
    L177:
        if (r116 == null) goto L179;
        boolean r117 = r116.booleanValue();
    L180:
        r114.f479475a = r117;
        goto L182
    L179:
        r117 = false;
        goto L180
    L176:
        r116 = null;
    L182:
        if (r310.containsKey("loop") == false) goto L192;
        g07.a r118 = r108.f479498n;
        Object r119 = r310.get("loop");
        if ((r119 instanceof Boolean) == false) goto L186;
        Boolean r120 = (Boolean) r119;
    L187:
        if (r120 == null) goto L189;
        boolean r121 = r120.booleanValue();
    L190:
        r118.f479476b = r121;
        goto L192
    L189:
        r121 = false;
        goto L190
    L186:
        r120 = null;
    L192:
        if (r310.containsKey("inittime") == false) goto L202;
        Object r122 = r310.get("inittime");
        if ((r122 instanceof Integer) == false) goto L196;
        Integer r123 = (Integer) r122;
    L197:
        if (r123 == null) goto L199;
        int r124 = r123.intValue();
    L200:
        r108.f479497m = r124;
        goto L202
    L199:
        r124 = -1;
        goto L200
    L196:
        r123 = null;
    L202:
        if (r310.containsKey("headers") == false) goto L209;
        g07.a r125 = r108.f479498n;
        Object r126 = r310.get("headers");
        if ((r126 instanceof ReadableMap) == false) goto L206;
        ReadableMap r127 = (ReadableMap) r126;
    L207:
        r125.f479481g = r127;
        goto L209
    L206:
        r127 = null;
    L209:
        if (r310.containsKey("experimental-props") == false) goto L216;
        g07.a r128 = r108.f479498n;
        Object r129 = r310.get("experimental-props");
        if ((r129 instanceof Map) == false) goto L213;
        Map<String, String> r130 = (Map) r129;
    L214:
        r128.f479483i = r130;
        goto L216
    L213:
        r130 = null;
    L216:
        if (r310.containsKey(ITTVideoEngineEventSource.KEY_VOLUME) == false) goto L226;
        g07.a r131 = r108.f479498n;
        Object r132 = r310.get(ITTVideoEngineEventSource.KEY_VOLUME);
        if ((r132 instanceof Float) == false) goto L220;
        Float r133 = (Float) r132;
    L221:
        if (r133 == null) goto L223;
        float r134 = r133.floatValue();
    L224:
        r131.f479477c = r134;
        goto L226
    L223:
        r134 = -1.0f;
        goto L224
    L220:
        r133 = null;
    L226:
        if (r310.containsKey("speed") == false) goto L236;
        g07.a r135 = r108.f479498n;
        Object r136 = r310.get("speed");
        if ((r136 instanceof Float) == false) goto L230;
        Float r137 = (Float) r136;
    L231:
        if (r137 == null) goto L233;
        float r138 = r137.floatValue();
    L234:
        r135.f479478d = r138;
        goto L236
    L233:
        r138 = 1.0f;
        goto L234
    L230:
        r137 = null;
    L236:
        if (r310.containsKey("tag") == false) goto L245;
        Object r139 = r310.get("tag");
        if ((r139 instanceof String) == false) goto L240;
        String r140 = (String) r139;
    L241:
        if (r140 != null) goto L243;
        r140 = "";
    L243:
        r108.f479495k = r140;
        goto L245
    L240:
        r140 = null;
    L245:
        if (r310.containsKey("sub_tag") == false) goto L255;
        Object r141 = r310.get("sub_tag");
        if ((r141 instanceof String) == false) goto L249;
        String r142 = (String) r141;
    L250:
        if (r142 == null) goto L253;
        r110 = r142;
    L253:
        r108.f479496l = r110;
        goto L255
    L249:
        r142 = null;
    L255:
        if (r310.containsKey("cache-size") == false) goto L265;
        Object r143 = r310.get("cache-size");
        if ((r143 instanceof Integer) == false) goto L259;
        Integer r144 = (Integer) r143;
    L260:
        if (r144 == null) goto L262;
        int r145 = r144.intValue();
    L263:
        r108.f479494j = r145;
        goto L265
    L262:
        r145 = 0;
        goto L263
    L259:
        r144 = null;
    L265:
        if (r310.containsKey("progress_update_interval") == false) goto L272;
        g07.a r146 = r108.f479498n;
        Object r147 = r310.get("progress_update_interval");
        if ((r147 instanceof Integer) == false) goto L269;
        r103 = (Integer) r147;
    L269:
        if (r103 == null) goto L271;
        r101 = r103.intValue();
    L271:
        r146.f479484j = r101;
        goto L272
    L118:
        r113 = null;
        goto L119
    L121:
        if (r310.containsKey("video_id") == false) goto L136;
        Object r148 = r310.get("video_id");
        if ((r148 instanceof String) == false) goto L125;
        String r149 = (String) r148;
    L126:
        Object r150 = r310.get("token");
        if ((r150 instanceof String) == false) goto L129;
        String r210 = (String) r150;
    L130:
        Object r151 = r310.get("domain");
        if ((r151 instanceof String) == false) goto L133;
        String r211 = (String) r151;
    L134:
        this.f496818c = new g07.b(r149, null, r210, r211, null, null, null, 114);
        goto L169
    L133:
        r211 = null;
        goto L134
    L129:
        r210 = null;
        goto L130
    L125:
        r149 = null;
        goto L126
    L136:
        if (r310.containsKey("play_url") == false) goto L169;
        if (r310.containsKey("preload-key") == false) goto L146;
        Object r152 = r310.get("preload-key");
        if ((r152 instanceof String) == false) goto L142;
        String r153 = (String) r152;
    L143:
        if (r153 == null) goto L146;
        String r212 = r153;
    L147:
        Object r154 = r310.get("play_url");
        if ((r154 instanceof String) == false) goto L150;
        String r155 = (String) r154;
    L151:
        if (r155 != null) goto L153;
        r155 = "";
    L153:
        Intrinsics.checkNotNullParameter(r155, "url");
        if (StringsKt.startsWith$default(r155, "http://", false, 2, null) == false) goto L156;
    L159:
        boolean r156 = true;
    L160:
        if (r156 == true) goto L162;
        this.f496818c = new g07.b(null, null, null, null, null, null, r155, 63);
        goto L169
    L162:
        if (r212.length() <= 0) goto L164;
        boolean r157 = true;
    L165:
        if (r157 == false) goto L167;
        this.f496818c = new g07.b(null, null, null, null, r212, r155, null, 79);
        goto L169
    L167:
        this.f496818c = new g07.b(null, null, null, null, null, r155, null, 95);
        goto L169
    L164:
        r157 = false;
        goto L165
    L156:
        if (StringsKt.startsWith$default(r155, "https://", false, 2, null) == true) goto L159;
        r156 = false;
        goto L160
    L150:
        r155 = null;
        goto L151
    L142:
        r153 = null;
    L146:
        r212 = "";
        goto L147
    L110:
        r106 = null;
        goto L111
    L104:
        r112 = null;
        goto L105
    L11:
        if (r310.containsKey("muted") == false) goto L21;
        m07.a r158 = this.f496813f;
        Object r159 = r310.get("muted");
        if ((r159 instanceof Boolean) == false) goto L15;
        Boolean r160 = (Boolean) r159;
    L16:
        if (r160 == null) goto L18;
        boolean r161 = r160.booleanValue();
    L19:
        r158.setMute(r161);
        goto L21
    L18:
        r161 = false;
        goto L19
    L15:
        r160 = null;
    L21:
        if (r310.containsKey("loop") == false) goto L31;
        m07.a r162 = this.f496813f;
        Object r163 = r310.get("loop");
        if ((r163 instanceof Boolean) == false) goto L25;
        Boolean r164 = (Boolean) r163;
    L26:
        if (r164 == null) goto L28;
        boolean r165 = r164.booleanValue();
    L29:
        r162.setLoop(r165);
        goto L31
    L28:
        r165 = false;
        goto L29
    L25:
        r164 = null;
    L31:
        if (r310.containsKey("speed") == false) goto L41;
        m07.a r166 = this.f496813f;
        Object r167 = r310.get("speed");
        if ((r167 instanceof Float) == false) goto L35;
        Float r168 = (Float) r167;
    L36:
        if (r168 == null) goto L38;
        float r169 = r168.floatValue();
    L39:
        r166.setSpeed(r169);
        goto L41
    L38:
        r169 = 1.0f;
        goto L39
    L35:
        r168 = null;
    L41:
        if (r310.containsKey(ITTVideoEngineEventSource.KEY_VOLUME) == false) goto L62;
        Object r170 = r310.get(ITTVideoEngineEventSource.KEY_VOLUME);
        if ((r170 instanceof Float) == false) goto L45;
        Float r171 = (Float) r170;
    L46:
        if (r171 == null) goto L48;
        float r172 = r171.floatValue();
    L49:
        double r173 = r172;
        if (AudioStats.AUDIO_AMPLITUDE_NONE <= r173) goto L52;
    L54:
        r100 = false;
    L55:
        if (r100 == false) goto L62;
        WeakReference<TTVideoEngine> r174 = this.f496819d;
        if (r174 == null) goto L62;
        TTVideoEngine r175 = r174.get();
        if (r175 == null) goto L62;
        r175.setVolume(r172, r172);
        goto L62
    L52:
        if (r173 > 1.0d) goto L54;
    L48:
        r172 = 1.0f;
        goto L49
    L45:
        r171 = null;
    L62:
        if (r310.containsKey("tag") == false) goto L75;
        Object r176 = r310.get("tag");
        if ((r176 instanceof String) == false) goto L66;
        String r177 = (String) r176;
    L67:
        if (r177 != null) goto L69;
        r177 = "";
    L69:
        WeakReference<TTVideoEngine> r178 = this.f496819d;
        if (r178 == null) goto L75;
        TTVideoEngine r179 = r178.get();
        if (r179 == null) goto L75;
        r179.setTag(r177);
        goto L75
    L66:
        r177 = null;
    L75:
        if (r310.containsKey("sub_tag") == false) goto L89;
        Object r180 = r310.get("sub_tag");
        if ((r180 instanceof String) == false) goto L79;
        String r181 = (String) r180;
    L80:
        if (r181 == null) goto L83;
        r110 = r181;
    L83:
        WeakReference<TTVideoEngine> r182 = this.f496819d;
        if (r182 == null) goto L89;
        TTVideoEngine r183 = r182.get();
        if (r183 == null) goto L89;
        r183.setSubTag(r110);
        goto L89
    L79:
        r181 = null;
    L89:
        if (r310.containsKey("cache-size") == false) goto L276;
        Object r184 = r310.get("cache-size");
        if ((r184 instanceof Integer) == false) goto L93;
        r103 = (Integer) r184;
    L93:
        if (r103 == null) goto L95;
        r101 = r103.intValue();
    L95:
        WeakReference<TTVideoEngine> r185 = this.f496819d;
        if (r185 == null) goto L277;
        TTVideoEngine r186 = r185.get();
        if (r186 == null) goto L278;
        r186.setIntOption(161, r101);
        return;
    L278:
        return;
    L277:
        return;
    L276:
        return;
    L5:
        if (q(r310) == false) goto L7;
        r102 = true;
        goto L8
    }

    @Override // com.bytedance.lynx.media.playable.IVideoEnginePlayable
    public final void b(long r100, boolean r101, com.bytedance.lynx.media.b r102) {
        if (this.f496813f.e() == true) goto L6;
        r102.a(7, null, -1, "player is not prepared");
        return;
    L6:
        m07.a r103 = this.f496813f;
        int r104 = (int) r100;
        if (r103.d() == false) goto L16;
        f07.c r105 = r103.f264837b;
        if (r105.f474984a == null) goto L16;
        WeakHandler r106 = r105.f475003t;
        if (r106 == null) goto L15;
        r106.removeMessages(201);
    L15:
        r105.f474994k = r104;
        r105.f474984a.seekTo(r104, r105.f475001r);
    L16:
        if (r101 == false) goto L18;
        this.f496813f.h();
    L19:
        r102.a(0, null, 0, null);
        return;
    L18:
        this.f496813f.f();
        goto L19
    }
}
