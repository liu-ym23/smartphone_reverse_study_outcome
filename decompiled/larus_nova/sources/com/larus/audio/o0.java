package com.larus.audio;

import android.os.SystemClock;
import com.larus.im.bean.message.Message;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes24.dex */
public interface o0 {

    public static final class a {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void a(o0 r110, String r111, Function1 r112, Function1 r113, Function1 r114, Function4 r115, com.larus.bmhome.chat.component.bottom.voice.service.m r116, com.larus.audio.asr.a0 r117, int r118) {
            if ((r118 & 2) == 0) goto L5;
            Function1 r100 = null;
        L7:
            if ((r118 & 4) == 0) goto L9;
            Function1 r101 = null;
        L11:
            if ((r118 & 8) == 0) goto L13;
            Function1 r102 = null;
        L15:
            if ((r118 & 16) == 0) goto L17;
            Function4 r103 = null;
        L19:
            if ((r118 & 32) == 0) goto L21;
            com.larus.bmhome.chat.component.bottom.voice.service.m r104 = null;
        L23:
            if ((r118 & 64) == 0) goto L25;
            com.larus.audio.asr.a0 r105 = null;
        L26:
            r110.a(r111, r100, r101, r102, r103, r104, r105);
            return;
        L25:
            r105 = r117;
            goto L26
        L21:
            r104 = r116;
            goto L23
        L17:
            r103 = r115;
            goto L19
        L13:
            r102 = r114;
            goto L15
        L9:
            r101 = r113;
            goto L11
        L5:
            r100 = r112;
            goto L7
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void b(o0 r210, Message r211, String r212, String r213, String r214, String r310, JSONObject r311, boolean r312, String r313, boolean r314, Long r315, n58.b r316, String r317, long r318, Integer r410, Long r411, h68.d r412, Function0 r413, long r414, com.larus.audio.asr.c0 r415, int r416) {
            String r100 = null;
            if ((r416 & 8) == 0) goto L5;
            String r101 = null;
        L7:
            if ((r416 & 16) == 0) goto L9;
            String r102 = null;
        L11:
            if ((r416 & 32) == 0) goto L13;
            JSONObject r103 = new JSONObject();
        L14:
            int r104 = 0;
            if ((r416 & 64) == 0) goto L17;
            boolean r110 = false;
        L19:
            if ((r416 & 128) == 0) goto L21;
            String r111 = "";
        L23:
            if ((r416 & 256) == 0) goto L25;
            boolean r112 = false;
        L27:
            if ((r416 & 512) == 0) goto L29;
            Long r113 = null;
        L31:
            if ((r416 & 1024) == 0) goto L33;
            n58.b r114 = null;
        L35:
            if ((r416 & 2048) == 0) goto L37;
            String r115 = null;
        L39:
            if ((r416 & 4096) == 0) goto L41;
            long r116 = SystemClock.elapsedRealtime();
        L43:
            if ((r416 & 8192) == 0) goto L45;
            Integer r117 = null;
        L47:
            if ((r416 & 16384) == 0) goto L49;
            Long r118 = null;
        L51:
            if ((32768 & r416) == 0) goto L53;
            h68.d r215 = null;
        L55:
            if ((65536 & r416) == 0) goto L57;
            Function0 r216 = new m0();
        L59:
            if ((131072 & r416) == 0) goto L61;
            long r217 = 500;
        L63:
            if ((r416 & 262144) == 0) goto L65;
            com.larus.audio.asr.c0 r218 = new com.larus.audio.asr.c0(r100, r100, r104, 255);
        L66:
            r210.e(r211, r212, r213, r101, r102, r103, r110, r111, r112, r113, r114, r115, r116, r117, r118, r215, r216, r217, r218);
            return;
        L65:
            r218 = r415;
            goto L66
        L61:
            r217 = r414;
            goto L63
        L57:
            r216 = r413;
            goto L59
        L53:
            r215 = r412;
            goto L55
        L49:
            r118 = r411;
            goto L51
        L45:
            r117 = r410;
            goto L47
        L41:
            r116 = r318;
            goto L43
        L37:
            r115 = r317;
            goto L39
        L33:
            r114 = r316;
            goto L35
        L29:
            r113 = r315;
            goto L31
        L25:
            r112 = r314;
            goto L27
        L21:
            r111 = r313;
            goto L23
        L17:
            r110 = r312;
            goto L19
        L13:
            r103 = r311;
            goto L14
        L9:
            r102 = r310;
            goto L11
        L5:
            r101 = r214;
            goto L7
        }
    }

    void a(String r100, Function1<? super byte[], Unit> r101, Function1<? super String, Unit> r102, Function1<? super b, Unit> r103, Function4<? super String, ? super String, ? super Long, ? super Integer, Unit> r104, Function1<? super String, Unit> r105, com.larus.audio.asr.a0 r106);

    void b();

    void c();

    String d();

    void e(Message r100, String r101, String r102, String r103, String r104, JSONObject r105, boolean r106, String r107, boolean r108, Long r110, n58.b r111, String r112, long r113, Integer r114, Long r115, h68.d r116, Function0<Unit> r117, long r118, com.larus.audio.asr.c0 r210);

    void f();

    void g(String r100, String r101, String r102, String r103, com.larus.audio.asr.y r104, boolean r105, String r106, boolean r107, Long r108, n58.b r110, long r111, Function0 r112, h68.d r113);

    String getTaskId();

    String h();
}
