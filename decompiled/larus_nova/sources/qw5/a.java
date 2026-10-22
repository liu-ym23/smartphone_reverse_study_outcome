package qw5;

import com.bytedance.flow_audio.api.config.session.FlowAudioSessionRequestType;
import com.bytedance.flow_audio.api.scene.FlowAudioAssistantScene;
import gw5.i;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f534993a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f534994b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FlowAudioSessionRequestType f534995c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f534996d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final FlowAudioAssistantScene f534997e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f534998f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f534999g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final pw5.a f535000h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final mw5.c f535001i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final i f535002j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final mw5.a f535003k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f535004l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Map<String, String> f535005m;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f534993a, r101.f534993a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f534994b, r101.f534994b) == true) goto L15;
        return false;
    L15:
        if (this.f534995c == r101.f534995c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f534996d, r101.f534996d) == true) goto L21;
        return false;
    L21:
        if (this.f534997e == r101.f534997e) goto L24;
        return false;
    L24:
        if (this.f534998f == r101.f534998f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f534999g, r101.f534999g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f535000h, r101.f535000h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f535001i, r101.f535001i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f535002j, r101.f535002j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f535003k, r101.f535003k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f535004l, r101.f535004l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f535005m, r101.f535005m) == true) goto L47;
        return false;
    L47:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f534993a.hashCode() * 31) + this.f534994b.hashCode()) * 31) + this.f534995c.hashCode()) * 31;
        String r101 = this.f534996d;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (((((((r100 + r103) * 31) + this.f534997e.hashCode()) * 31) + this.f534998f) * 31) + this.f534999g.hashCode()) * 31;
        pw5.a r105 = this.f535000h;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        mw5.c r108 = this.f535001i;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        i r111 = this.f535002j;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        mw5.a r114 = this.f535003k;
        if (r114 != null) goto L21;
        int r115 = 0;
    L22:
        int r116 = (((r113 + r115) * 31) + this.f535004l.hashCode()) * 31;
        Map<String, String> r117 = this.f535005m;
        if (r117 == null) goto L27;
        r102 = r117.hashCode();
    L27:
        return r116 + r102;
    L21:
        r115 = r114.hashCode();
        goto L22
    L17:
        r112 = r111.hashCode();
        goto L18
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "FlowAudioSessionConfig(sessionId=" + this.f534993a + ", conversationId=" + this.f534994b + ", requestType=" + this.f534995c + ", traceInfo=" + this.f534996d + ", scene=" + this.f534997e + ", business=" + this.f534998f + ", chat=" + this.f534999g + ", connection=" + this.f535000h + ", tts=" + this.f535001i + ", asr=" + this.f535002j + ", loudness=" + this.f535003k + ", extra=" + this.f535004l + ", context=" + this.f535005m + ')';
    }

    public final Map<String, String> getContext() {
        return this.f535005m;
    }

    public static a a(a r110, String r111, pw5.a r112, i r210, int r211) {
        if ((r211 & 1) == 0) goto L5;
        String r100 = r110.f534993a;
    L7:
        if ((r211 & 2) == 0) goto L9;
        String r101 = r110.f534994b;
    L11:
        if ((r211 & 4) == 0) goto L13;
        FlowAudioSessionRequestType r102 = r110.f534995c;
    L15:
        if ((r211 & 8) == 0) goto L17;
        String r103 = r110.f534996d;
    L19:
        if ((r211 & 16) == 0) goto L21;
        FlowAudioAssistantScene r104 = r110.f534997e;
    L23:
        if ((r211 & 32) == 0) goto L25;
        int r105 = r110.f534998f;
    L27:
        if ((r211 & 64) == 0) goto L29;
        String r113 = r110.f534999g;
    L31:
        if ((r211 & 128) == 0) goto L33;
        pw5.a r114 = r110.f535000h;
    L35:
        if ((r211 & 256) == 0) goto L37;
        mw5.c r115 = r110.f535001i;
    L39:
        if ((r211 & 512) == 0) goto L41;
        i r116 = r110.f535002j;
    L43:
        if ((r211 & 1024) == 0) goto L45;
        mw5.a r117 = r110.f535003k;
    L47:
        if ((r211 & 2048) == 0) goto L49;
        String r118 = r110.f535004l;
    L51:
        if ((r211 & 4096) == 0) goto L53;
        Map<String, String> r119 = r110.f535005m;
    L54:
        r110.getClass();
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        Intrinsics.checkNotNullParameter(r101, "conversationId");
        Intrinsics.checkNotNullParameter(r102, "requestType");
        Intrinsics.checkNotNullParameter(r104, "scene");
        Intrinsics.checkNotNullParameter(r113, "chat");
        Intrinsics.checkNotNullParameter(r118, "extra");
        return new a(r100, r101, r102, r103, r104, r105, r113, r114, r115, r116, r117, r118, r119);
    L53:
        r119 = null;
        goto L54
    L49:
        r118 = null;
        goto L51
    L45:
        r117 = null;
        goto L47
    L41:
        r116 = r210;
        goto L43
    L37:
        r115 = null;
        goto L39
    L33:
        r114 = r112;
        goto L35
    L29:
        r113 = null;
        goto L31
    L25:
        r105 = 0;
        goto L27
    L21:
        r104 = null;
        goto L23
    L17:
        r103 = null;
        goto L19
    L13:
        r102 = null;
        goto L15
    L9:
        r101 = null;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public /* synthetic */ a(String r110, String r111, FlowAudioSessionRequestType r112, String r210, FlowAudioAssistantScene r211, int r212, String r213, pw5.a r214, mw5.c r215, i r216, mw5.a r217, String r218, int r219) {
        if ((r219 & 16) == 0) goto L5;
        FlowAudioAssistantScene r100 = FlowAudioAssistantScene.Im;
    L7:
        if ((r219 & 32) == 0) goto L9;
        int r101 = FlowAudioAssistantScene.Im.getBusiness();
    L11:
        if ((r219 & 128) == 0) goto L13;
        pw5.a r113 = null;
    L15:
        if ((r219 & 256) == 0) goto L17;
        mw5.c r114 = null;
    L19:
        if ((r219 & 512) == 0) goto L21;
        i r115 = null;
    L23:
        if ((r219 & 1024) == 0) goto L25;
        mw5.a r116 = null;
    L26:
        this(r110, r111, r112, r210, r100, r101, r213, r113, r114, r115, r116, r218, null);
        return;
    L25:
        r116 = r217;
        goto L26
    L21:
        r115 = r216;
        goto L23
    L17:
        r114 = r215;
        goto L19
    L13:
        r113 = r214;
        goto L15
    L9:
        r101 = r212;
        goto L11
    L5:
        r100 = r211;
        goto L7
    }

    public a(String r100, String r101, FlowAudioSessionRequestType r102, String r103, FlowAudioAssistantScene r104, int r105, String r106, pw5.a r107, mw5.c r110, i r111, mw5.a r112, String r113, Map<String, String> r114) {
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        Intrinsics.checkNotNullParameter(r101, "conversationId");
        Intrinsics.checkNotNullParameter(r102, "requestType");
        Intrinsics.checkNotNullParameter(r104, "scene");
        Intrinsics.checkNotNullParameter(r106, "chat");
        Intrinsics.checkNotNullParameter(r113, "extra");
        this.f534993a = r100;
        this.f534994b = r101;
        this.f534995c = r102;
        this.f534996d = r103;
        this.f534997e = r104;
        this.f534998f = r105;
        this.f534999g = r106;
        this.f535000h = r107;
        this.f535001i = r110;
        this.f535002j = r111;
        this.f535003k = r112;
        this.f535004l = r113;
        this.f535005m = r114;
    }
}
