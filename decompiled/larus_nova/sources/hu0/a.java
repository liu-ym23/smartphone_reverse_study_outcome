package hu0;

import android.os.Handler;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.profit.format.ProfitFormatLoaderServiceKt;
import com.bytedance.android.live.profit.format.voicechat.message.MessageType;
import com.bytedance.android.live.profit.format.voicechat.model.VoiceChatState;
import com.bytedance.android.live.profit.format.voicechat.rtc.c;
import com.bytedance.android.live.profit.format.voicechat.trace.VoiceChatTraceStep;
import com.bytedance.android.scope.m;
import com.ss.cast.discovery.mdns.nsdhelper.NsdHelper;
import io.reactivex.disposables.Disposable;
import ju0.d;
import ju0.e;
import ju0.f;
import kotlin.ExceptionsKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import nu0.j;
import nu0.l;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.live.profit.format.voicechat.rtc.b f487200a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f487201b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public e f487202c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.bytedance.android.live.profit.format.voicechat.model.e f487203d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f487204e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f487205f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public InterfaceC6196a f487206g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Disposable f487207h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f487208i;

    /* JADX INFO: renamed from: hu0.a$a, reason: collision with other inner class name */
    public interface InterfaceC6196a {
        void a(f r100);

        void b(VoiceChatState r100);

        void c(String r100);
    }

    public static final class b extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f487209a;

        public b(a r100) {
            this.f487209a = r100;
        }

        @Override // com.bytedance.android.live.profit.format.voicechat.rtc.a
        public final void L(String r100) {
            long r101 = System.currentTimeMillis();
            com.bytedance.android.live.profit.format.voicechat.model.e r102 = this.f487209a.f487203d;
            if (r102 == null) goto L5;
            long r103 = r102.f87671e;
        L6:
            long r104 = r101 - r103;
            j.d(this, "onFirstRemoteAudioFrame, id: " + r100, "rtcListener");
            String r105 = mu0.c.f515718a;
            mu0.c.c(VoiceChatTraceStep.FIRST_FRAME, UtilityKotlinExtentionsKt.o(new Pair[]{TuplesKt.to("duration", String.valueOf(r104))}), null, 0, 12);
            int r106 = com.bytedance.android.live.profit.format.voicechat.log.a.f87660c;
            com.bytedance.android.live.profit.format.voicechat.log.a.C1334a.a("format_call_first_audio_frame", MapsKt.plus(MapsKt.mapOf(TuplesKt.to("duration", String.valueOf(r104))), mu0.c.f515719b));
            return;
        L5:
            r103 = System.currentTimeMillis();
            goto L6
        }

        @Override // com.bytedance.android.live.profit.format.voicechat.rtc.a
        public final void onUserJoined(String r100) {
            Intrinsics.checkNotNullParameter(r100, "interactId");
            j.d(this, "onUserJoined, id: " + r100, "rtcListener");
            com.bytedance.android.live.profit.format.voicechat.model.e r101 = this.f487209a.f487203d;
            if (r101 == null) goto L5;
            String r102 = r101.f87668b;
        L7:
            if (Intrinsics.areEqual(r100, r102) == false) goto L12;
            a r103 = this.f487209a;
            if (r103.f487208i == true) goto L11;
            r103.f487200a.f();
        L11:
            String r104 = mu0.c.f515718a;
            mu0.c.c(VoiceChatTraceStep.JOIN_ROOM, null, null, 1, 6);
            return;
        L12:
            this.f487209a.f487205f = r100;
            String r105 = mu0.c.f515718a;
            Pair[] r106 = {TuplesKt.to("ai_id", r100)};
            Intrinsics.checkNotNullParameter(r106, "params");
            MapsKt.putAll(mu0.c.f515719b, r106);
            Disposable r107 = this.f487209a.f487207h;
            if (r107 == null) goto L17;
            r107.dispose();
            return;
        L17:
            return;
        L5:
            r102 = null;
            goto L7
        }

        @Override // com.bytedance.android.live.profit.format.voicechat.rtc.a
        public final void t(String r100) {
            j.d(this, "onUserLeaved, id: " + r100 + ", reason: 0", "rtcListener");
            if (Intrinsics.areEqual(this.f487209a.f487205f, r100) == false) goto L8;
            InterfaceC6196a r101 = this.f487209a.f487206g;
            if (r101 == null) goto L9;
            r101.c("aiLeave");
            return;
        L9:
            return;
        }

        @Override // com.bytedance.android.live.profit.format.voicechat.rtc.a
        public final void v(long r100) {
            j.b(this, "onError, code: " + r100, null, "rtcListener");
            InterfaceC6196a r101 = this.f487209a.f487206g;
            if (r101 == null) goto L6;
            r101.c("rtcError");
            return;
        }

        @Override // com.bytedance.android.live.profit.format.voicechat.rtc.a
        public final void R(long r100, Exception r101) {
            j.b(this, "onStartFailed, code: " + r100, r101, "rtcListener");
            String r102 = mu0.c.f515718a;
            mu0.c.c(VoiceChatTraceStep.JOIN_ROOM, null, UtilityKotlinExtentionsKt.o(new Pair[]{TuplesKt.to("error_code", String.valueOf(r100)), TuplesKt.to("error_msg", ExceptionsKt.stackTraceToString(r101))}), -1, 2);
            InterfaceC6196a r103 = this.f487209a.f487206g;
            if (r103 == null) goto L6;
            r103.c("userJoinError");
            return;
        }

        @Override // com.bytedance.android.live.profit.format.voicechat.rtc.a
        public final void s(String r100, String r110) {
            if (r110 != null) goto L4;
            return;
        L4:
            d.f500402a.getClass();
            Intrinsics.checkNotNullParameter(r110, "msg");
            Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L7
            Object r102 = Result.m9449constructorimpl(new JSONObject(r110));     // Catch: Throwable -> L7
        L9:
            Handler r103 = UtilityKotlinExtentionsKt.f66103a;
            JSONObject r104 = new JSONObject();
            if (Result.m9455isFailureimpl(r102) == false) goto L12;
            r102 = r104;
        L12:
            JSONObject r105 = (JSONObject) r102;
            MessageType.a r106 = MessageType.Companion;
            String r107 = r105.optString("type", "unknown");
            r106.getClass();
            Intrinsics.checkNotNullParameter(r107, "type");
            MessageType[] r108 = MessageType.values();
            int r109 = r108.length;
            int r111 = 0;
        L13:
            VoiceChatState r112 = null;
            if (r111 >= r109) goto L19;
            MessageType r113 = r108[r111];
            if (Intrinsics.areEqual(r113.getType(), r107) == true) goto L20;
            r111 = r111 + 1;
        L20:
            if (r113 != null) goto L63;
            r113 = MessageType.UNKNOWN;
        L63:
            Result.Companion r114 = Result.Companion;     // Catch: Throwable -> L24
            Object r115 = Result.m9449constructorimpl(new JSONObject(r105.optString("data")));     // Catch: Throwable -> L24
        L26:
            JSONObject r116 = new JSONObject();
            if (Result.m9455isFailureimpl(r115) == false) goto L29;
            r115 = r116;
        L29:
            JSONObject r117 = (JSONObject) r115;
            int r118 = ju0.c.f500401a[r113.ordinal()];
            if (r118 != 1) goto L32;
            ju0.b r119 = new e(r117);
        L41:
            if ((r119 instanceof e) == false) goto L57;
            a r120 = this.f487209a;
            e r121 = (e) r119;
            r120.getClass();
            long r122 = r121.f500404c;
            e r123 = r120.f487202c;
            if (r123 == null) goto L45;
            long r124 = r123.f500404c;
        L47:
            if (r122 <= r124) goto L69;
            if (r123 == null) goto L51;
            r112 = r123.f500403b;
        L51:
            if (r112 == r121.f500403b) goto L55;
            j.d(r120, "handleStateChangeMsg, newState: " + r121.f500400a, "rtcManager");
            InterfaceC6196a r125 = r120.f487206g;
            if (r125 == null) goto L55;
            r125.b(r121.f500403b);
        L55:
            r120.f487202c = r121;
            return;
        L69:
            return;
        L45:
            r124 = 0;
            goto L47
        L57:
            if ((r119 instanceof f) == false) goto L61;
            a r126 = this.f487209a;
            f r127 = (f) r119;
            r126.getClass();
            j.d(r126, "handleWarmUpTopicMsg, newState: " + r127.f500400a, "rtcManager");
            InterfaceC6196a r128 = r126.f487206g;
            if (r128 == null) goto L71;
            r128.a(r127);
            return;
        L71:
            return;
        L61:
            j.b(this, "parseMessageFailed, uid: " + r100 + ", message: " + r110, null, "rtcListener");
            return;
        L32:
            if (r118 != 2) goto L34;
            r119 = new f(r117);
            goto L41
        L34:
            if (r118 != 3) goto L37;
            r119 = new ju0.a(r117);
            goto L41
        L37:
            throw new NoWhenBranchMatchedException();
        L24:
            th = move-exception;
            Result.Companion r129 = Result.Companion;
            r115 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L26
        L19:
            r113 = null;
        L7:
            th = move-exception;
            Result.Companion r130 = Result.Companion;
            r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L9
        }
    }

    public final void a() {
        StringBuilder r100 = new StringBuilder("stopRoom, roomId: ");
        com.bytedance.android.live.profit.format.voicechat.model.e r101 = this.f487203d;
        if (r101 == null) goto L5;
        String r102 = r101.f87670d.getRtcRoomId();
    L6:
        r100.append(r102);
        j.d(this, r100.toString(), null);
        this.f487203d = null;
        this.f487206g = null;
        this.f487205f = null;
        this.f487202c = null;
        this.f487204e = false;
        this.f487208i = false;
        Disposable r103 = this.f487207h;
        if (r103 == null) goto L9;
        r103.dispose();
    L9:
        this.f487200a.stopAndRelease();
        return;
    L5:
        r102 = null;
        goto L6
    }

    public a() {
        com.bytedance.android.live.profit.format.b r100 = (com.bytedance.android.live.profit.format.b) ProfitFormatLoaderServiceKt.f87603a.getValue();
        Intrinsics.checkNotNullParameter(r100, "$this$rtcService");
        KClass r101 = Reflection.getOrCreateKotlinClass(com.bytedance.android.live.profit.format.voicechat.rtc.b.class);
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, NsdHelper.serviceTypeKey);
        m r102 = m.f163449e;
        com.bytedance.android.live.profit.format.f r103 = r100.f87604a;
        if (r103 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("profitFormatScope");
    L5:
        com.bytedance.android.live.profit.format.d r104 = (com.bytedance.android.live.profit.format.d) r102.d(r103, JvmClassMappingKt.getJavaClass(r101));
        if (r104 == null) goto L10;
        this.f487200a = (com.bytedance.android.live.profit.format.voicechat.rtc.b) r104;
        ((iu0.a) l.f520587c.getValue(null, l.f520585a[1])).getClass();
        this.f487201b = new b(this);
        return;
    L10:
        throw new IllegalStateException(("Required service " + r101 + " not found").toString());
    }
}
