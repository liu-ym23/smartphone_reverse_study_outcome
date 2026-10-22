package g58;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.larus.media.MediaResourceManager;
import com.larus.utils.l0;
import com.larus.utils.logger.FLogger;
import com.mammon.audiosdk.enums.SAMICoreCallBackEventType;
import com.mammon.audiosdk.enums.SAMICoreDataType;
import com.mammon.audiosdk.structures.SAMICoreWebSocketConnectionEvent;
import kotlin.Lazy;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class n implements r78.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f480097a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f480098b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f480099c;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f480100a = null;

        static {
            int[] r100 = new int[SAMICoreCallBackEventType.values().length];
            r100[SAMICoreCallBackEventType.TaskStarted.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L21:
            r100[SAMICoreCallBackEventType.SessionStarted.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L31:
            r100[SAMICoreCallBackEventType.TaskFailed.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L23:
            r100[SAMICoreCallBackEventType.SessionFailed.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L25:
            r100[SAMICoreCallBackEventType.ASRInfo.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L19:
            r100[SAMICoreCallBackEventType.WebSocketStateChanged.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L27:
            r100[SAMICoreCallBackEventType.ASREnded.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L10:
            f480100a = r100;
        }
    }

    @Override // r78.b
    public final void a(int r100, final r78.a r110) {
        Intrinsics.checkNotNullParameter(r110, "data");
        SAMICoreCallBackEventType r101 = SAMICoreCallBackEventType.fromInt(r100);
        int r102 = -1;
        if (r101 != null) goto L5;
        int r103 = -1;
    L6:
        boolean r104 = false;
        switch(r103) {
            case 1: goto L55;
            case 2: goto L38;
            case 3: goto L33;
            case 4: goto L33;
            case 5: goto L32;
            case 6: goto L11;
            case 7: goto L9;
            default: goto L68;
        };
    L9:
        FLogger.f375446a.i("AiAsrManager", "ASREnded, data: " + g2a.d.c(GsonProtectorUtils.toJson(new Gson(), ArraysKt.firstOrNull(r110.f536470c))));
        h.b(this.f480097a, this.f480099c);
        return;
    L32:
        int r105 = l0.f375430a;
        final h r106 = this.f480097a;
        l0.b(new k(r110, r106));
        return;
    L33:
        FLogger.f375446a.i("AiAsrManager", r101 + ", data: " + g2a.d.c(GsonProtectorUtils.toJson(new Gson(), ArraysKt.firstOrNull(r110.f536470c))));
        h r107 = this.f480097a;
        if (r101 == SAMICoreCallBackEventType.TaskFailed) goto L37;
        r102 = -2;
    L37:
        r107.f480075j = r102;
        r107.f480076k = g2a.d.c(GsonProtectorUtils.toJson(new Gson(), ArraysKt.firstOrNull(r110.f536470c)));
        h.a(this.f480097a);
        com.larus.audio.ainotes.a.f288325a.a("sami task failed");
        h.b(this.f480097a, this.f480099c);
        return;
    L38:
        FLogger r108 = FLogger.f375446a;
        r108.i("AiAsrManager", "SessionStarted, isSessionValid: " + this.f480097a.f480083r + ", hasCalledEndAsr: " + this.f480097a.f480084s);
        h r111 = this.f480097a;
        if (r111.f480071f == true) goto L42;
        r111.f480071f = true;
    L42:
        if (r111.f480083r == false) goto L44;
        return;
    L44:
        if (r111.f480084s == true) goto L64;
        r111.f480083r = true;
        r111.f480080o = System.currentTimeMillis();
        this.f480097a.c().getClass();
        String r109 = "";
        l0.b(new i58.a(this.f480097a.f480073h, 0, r109));
        if (this.f480098b == true) goto L48;
        Lazy r112 = MediaResourceManager.f358950a;
        final h r113 = this.f480097a;
        MediaResourceManager.l(r113.f480090y, r113.f480089x, new i(r113), new j(r113), 48);
        return;
    L48:
        r108.i("AiAsrManager", "record in DoraG, not requestMedia");
        h r114 = this.f480097a;
        r114.getClass();
        r108.i("AiAsrManager", "startTimeLimitTimer");
        q r115 = new q();
        r114.f480088w = r115;
        r115.d();
        h r116 = this.f480097a;
        p68.c r117 = r116.f480085t;
        if (r117 == null) goto L66;
        String r118 = r116.f480074i;
        if (r118 == null) goto L54;
        r109 = r118;
    L54:
        r117.a(r109);
        return;
    L66:
        return;
    L64:
        return;
    L55:
        FLogger.f375446a.i("AiAsrManager", "TaskStarted, isSessionValid: " + this.f480097a.f480083r + ", hasCalledEndAsr: " + this.f480097a.f480084s);
        return;
    L68:
        return;
    L11:
        if (r110.f536468a != SAMICoreDataType.SAMICoreDataType_WebSocket_Connection_Event.getValue()) goto L58;
        Object r119 = ArraysKt.firstOrNull(r110.f536470c);
        Integer r120 = null;
        if ((r119 instanceof SAMICoreWebSocketConnectionEvent) == false) goto L15;
        SAMICoreWebSocketConnectionEvent r121 = (SAMICoreWebSocketConnectionEvent) r119;
    L16:
        FLogger r122 = FLogger.f375446a;
        StringBuilder r123 = new StringBuilder("WebSocketStateChanged, state=");
        if (r121 == null) goto L19;
        r120 = Integer.valueOf(r121.state);
    L19:
        r123.append(r120);
        r123.append(", data: ");
        r123.append(g2a.d.c(GsonProtectorUtils.toJson(new Gson(), ArraysKt.firstOrNull(r110.f536470c))));
        r122.i("AiAsrManager", r123.toString());
        if (r121 != null) goto L22;
    L24:
        boolean r124 = false;
    L25:
        if (r124 == true) goto L31;
        if (r121 != null) goto L28;
    L30:
        if (r104 == true) goto L31;
        return;
    L28:
        if (r121.state != 3) goto L30;
        r104 = true;
    L31:
        h r125 = this.f480097a;
        r125.f480075j = -3;
        r125.f480076k = g2a.d.c(GsonProtectorUtils.toJson(new Gson(), ArraysKt.firstOrNull(r110.f536470c)));
        h.a(this.f480097a);
        com.larus.audio.ainotes.a.f288325a.a("WebSocket connect exception");
        h.b(this.f480097a, this.f480099c);
        return;
    L22:
        if (r121.state != 2) goto L24;
        r124 = true;
        goto L25
    L15:
        r121 = null;
        goto L16
    L58:
        return;
    L5:
        r103 = a.f480100a[r101.ordinal()];
        goto L6
    }

    public n(h r100, boolean r101, String r102) {
        this.f480097a = r100;
        this.f480098b = r101;
        this.f480099c = r102;
    }
}
