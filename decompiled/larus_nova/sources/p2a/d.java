package p2a;

import com.larus.im.bean.bot.SpeakerVoice;
import kotlin.collections.MapsKt;
import ouc.d0;

/* JADX INFO: loaded from: classes32.dex */
public interface d {

    public static final class a {
        public static /* synthetic */ void a(d r210, SpeakerVoice r211, String r212, boolean r213, String r214, String r215, String r216, String r310, String r311, String r312, Float r313, Float r314, Integer r315, String r316, String r317, String r318, String r319, String r410, String r411, String r412, String r413, d0 r414, int r415) {
            if ((r415 & 1) == 0) goto L5;
            SpeakerVoice r100 = null;
        L7:
            if ((r415 & 2) == 0) goto L9;
            String r101 = null;
        L11:
            if ((r415 & 4) == 0) goto L13;
            boolean r102 = false;
        L15:
            if ((r415 & 8) == 0) goto L17;
            String r103 = null;
        L19:
            if ((r415 & 16) == 0) goto L21;
            String r104 = null;
        L23:
            if ((r415 & 32) == 0) goto L25;
            String r105 = null;
        L27:
            if ((r415 & 64) == 0) goto L29;
            String r106 = null;
        L31:
            if ((r415 & 128) == 0) goto L33;
            String r107 = null;
        L35:
            if ((r415 & 256) == 0) goto L37;
            String r110 = null;
        L39:
            if ((r415 & 512) == 0) goto L41;
            String r111 = null;
        L43:
            if ((r415 & 1024) == 0) goto L45;
            Float r112 = null;
        L47:
            if ((r415 & 2048) == 0) goto L49;
            Float r113 = null;
        L51:
            if ((r415 & 4096) == 0) goto L53;
            Integer r114 = null;
        L55:
            if ((r415 & 8192) == 0) goto L57;
            String r115 = null;
        L59:
            if ((r415 & 16384) == 0) goto L61;
            String r108 = null;
        L63:
            if ((r415 & 32768) == 0) goto L65;
            String r116 = null;
        L67:
            if ((r415 & 65536) == 0) goto L69;
            String r117 = null;
        L71:
            if ((r415 & 131072) == 0) goto L73;
            String r118 = null;
        L75:
            if ((r415 & 262144) == 0) goto L77;
            String r217 = null;
        L79:
            if ((r415 & 524288) == 0) goto L81;
            String r218 = null;
        L83:
            if ((r415 & 1048576) == 0) goto L85;
            String r119 = null;
        L87:
            if ((r415 & 2097152) == 0) goto L89;
            d0 r109 = new d0(MapsKt.emptyMap());
        L90:
            r210.a(r100, r101, r102, r103, r104, r105, r106, r107, r110, r111, r112, r113, r114, r115, r108, r116, r117, r118, r217, r218, r119, r109);
            return;
        L89:
            r109 = r414;
            goto L90
        L85:
            r119 = r413;
            goto L87
        L81:
            r218 = r412;
            goto L83
        L77:
            r217 = r411;
            goto L79
        L73:
            r118 = r410;
            goto L75
        L69:
            r117 = r319;
            goto L71
        L65:
            r116 = r318;
            goto L67
        L61:
            r108 = r317;
            goto L63
        L57:
            r115 = r316;
            goto L59
        L53:
            r114 = r315;
            goto L55
        L49:
            r113 = r314;
            goto L51
        L45:
            r112 = r313;
            goto L47
        L41:
            r111 = r312;
            goto L43
        L37:
            r110 = r311;
            goto L39
        L33:
            r107 = r310;
            goto L35
        L29:
            r106 = r216;
            goto L31
        L25:
            r105 = r215;
            goto L27
        L21:
            r104 = "bot_voice_change";
            goto L23
        L17:
            r103 = r214;
            goto L19
        L13:
            r102 = r213;
            goto L15
        L9:
            r101 = r212;
            goto L11
        L5:
            r100 = r211;
            goto L7
        }
    }

    void a(SpeakerVoice r100, String r101, boolean r102, String r103, String r104, String r105, String r106, String r107, String r108, String r110, Float r111, Float r112, Integer r113, String r114, String r115, String r116, String r117, String r118, String r119, String r210, String r211, d0 r212);
}
