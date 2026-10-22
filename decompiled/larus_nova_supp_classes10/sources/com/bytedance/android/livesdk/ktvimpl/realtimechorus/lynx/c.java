package com.bytedance.android.livesdk.ktvimpl.realtimechorus.lynx;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.android.annie.api.card.HybridCard;
import com.bytedance.android.live.browser.jsbridge.base.UpdateLinkmicStatusResultModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.live.liveinteract.jsbridge.method.t;
import com.bytedance.android.live.liveinteract.linkbase.api.LoadDurationItemId;
import com.bytedance.android.live.revenue.platform.container.impl.d0;
import com.bytedance.android.livesdk.chatroom.utils.o3;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.base.sei.p;
import com.bytedance.android.livesdk.ktvimpl.realtimechorus.w;
import com.bytedance.android.livesdk.utils.d5;
import com.bytedance.android.livesdkapi.depend.message.wrds.MultiPreviewSyncDataType;
import com.bytedance.android.livesdkapi.message.OnWRDSDataUpdateListener;
import com.bytedance.android.livesdkapi.service.MessageHub;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c implements t, com.bytedance.android.livesdk.ktvimpl.realtimechorus.lynx.b {
    public HybridCard a;
    public HybridCard b;
    public Disposable c;
    public Disposable d;
    public final Map<String, Map<String, List<Object>>> e;
    public final b f;
    public final C0049c g;
    public final ViewGroup h;
    public final ViewGroup i;
    public final Context j;
    public final KtvContext k;
    public DataCenter l;
    public final Function0<Integer> m;

    public static final class a {
    }

    public static final class b implements com.bytedance.android.live.ktv.common.util.c {
        public Function2<? super Boolean, ? super Long, Unit> a;

        public final String getTypeName() {
            return "empty_seat";
        }

        public b() {
        }

        public final Function2<Boolean, Long, Unit> getOneDrawCallback() {
            return this.a;
        }

        public final void setOneDrawCallback(Function2<? super Boolean, ? super Long, Unit> r1) {
            this.a = r1;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.ktvimpl.realtimechorus.lynx.c$c, reason: collision with other inner class name */
    public static final class C0049c implements com.bytedance.android.live.ktv.common.util.c {
        public Function2<? super Boolean, ? super Long, Unit> a;

        public final String getTypeName() {
            return "guest_seat";
        }

        public C0049c() {
        }

        public final Function2<Boolean, Long, Unit> getOneDrawCallback() {
            return this.a;
        }

        public final void setOneDrawCallback(Function2<? super Boolean, ? super Long, Unit> r1) {
            this.a = r1;
        }
    }

    public static final class d implements uh6.a {
        public final /* synthetic */ HybridCard a;

        public d(HybridCard r1) {
            this.a = r1;
        }

        public final void b(String r3, d0 r4) {
            Intrinsics.checkNotNullParameter(r3, "eventName");
            Intrinsics.checkNotNullParameter(r4, "method");
            this.a.registerMethod(r3, new k(r4));
        }

        public final void sendJsEvent(String r2, Object r3) {
            Intrinsics.checkNotNullParameter(r2, "eventName");
            Intrinsics.checkNotNullParameter(r3, "data");
            this.a.sendJsEvent(r2, r3);
        }
    }

    public static final class e implements Runnable {
        public final /* synthetic */ c a;

        public e(c r1) {
            this.a = r1;
        }

        public final void a() {
            if (((Number) this.a.m.invoke()).intValue() > 0) goto L5;
            boolean r0 = true;
        L6:
            Function2<? super Boolean, ? super Long, Unit> r1 = this.a.f.a;
            if (r1 == null) goto L9;
            Unit r2 = (Unit) r1.invoke(Boolean.valueOf(r0), Long.valueOf(System.currentTimeMillis()));
        L9:
            Function2<? super Boolean, ? super Long, Unit> r3 = this.a.g.a;
            if (r3 == null) goto L13;
            Unit r4 = (Unit) r3.invoke(Boolean.valueOf(r0), Long.valueOf(System.currentTimeMillis()));
            return;
        L13:
            return;
        L5:
            r0 = false;
            goto L6
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public final JsonObject T(ih0.e r2) {
        Intrinsics.checkNotNullParameter(r2, "getStatusData");
        return null;
    }

    public final void c() {
        this.k.getStatisticHelper().b(this.f);
        this.k.getStatisticHelper().b(this.g);
        ViewGroup r0 = this.h;
        if (r0 == null) goto L6;
        r0.postDelayed(new e(this), vm2.h.A());
        return;
    }

    public final void e() {
        com.bytedance.live.datacontext.j r0 = o3.f().w1();
        Integer r1 = null;
        if (r0 == null) goto L5;
        ylc.e r2 = (ylc.e) r0.getValue();
    L6:
        Map<String, Map<String, List<Object>>> r3 = this.e;
        HybridCard r4 = this.a;
        if (r4 == null) goto L9;
        Integer r5 = Integer.valueOf(r4.hashCode());
    L10:
        Map r6 = (Map) ((LinkedHashMap) r3).get(String.valueOf(r5));
        if (r6 == null) goto L26;
        Set r7 = r6.keySet();
        if (r7 == null) goto L26;
        Iterator r8 = r7.iterator();
    L16:
        if (r8.hasNext() == false) goto L26;
        List r9 = (List) r6.get((String) r8.next());
        if (r9 == null) goto L16;
        Iterator r10 = r9.iterator();
    L21:
        if (r10.hasNext() == false) goto L16;
        Object r11 = r10.next();
        if ((r11 instanceof ylc.c) == false) goto L21;
        if (r2 == null) goto L21;
        r2.i((ylc.c) r11);
    L26:
        Map<String, Map<String, List<Object>>> r12 = this.e;
        HybridCard r13 = this.b;
        if (r13 == null) goto L29;
        r1 = Integer.valueOf(r13.hashCode());
    L29:
        Map r14 = (Map) ((LinkedHashMap) r12).get(String.valueOf(r1));
        if (r14 == null) goto L45;
        Set r15 = r14.keySet();
        if (r15 == null) goto L68;
        Iterator r16 = r15.iterator();
    L35:
        if (r16.hasNext() == false) goto L69;
        List r17 = (List) r14.get((String) r16.next());
        if (r17 == null) goto L35;
        Iterator r18 = r17.iterator();
    L40:
        if (r18.hasNext() == false) goto L35;
        Object r19 = r18.next();
        if ((r19 instanceof ylc.c) == false) goto L40;
        if (r2 == null) goto L40;
        r2.i((ylc.c) r19);
        goto L40
    L69:
        return;
    L68:
        return;
    L45:
        return;
    L9:
        r5 = null;
        goto L10
    L5:
        r2 = null;
        goto L6
    }

    public static Disposable b(HybridCard r2) {
        if (r2 == null) goto L4;
        cy0.e.a.getClass();
        cy0.j r0 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r1 = com.bytedance.android.scope.m.b(r0).a(Reflection.getOrCreateKotlinClass(uh6.b.class));
        Intrinsics.checkNotNull(r1);
        return ((f80.a) r1).h(new d(r2), null);
    L4:
        return Disposables.disposed();
    }

    public final void d(MessageHub r5) {
        Map<String, Map<String, List<Object>>> r0 = this.e;
        HybridCard r1 = this.a;
        Integer r2 = null;
        if (r1 == null) goto L5;
        Integer r3 = Integer.valueOf(r1.hashCode());
    L6:
        Map r4 = (Map) ((LinkedHashMap) r0).get(String.valueOf(r3));
        if (r4 == null) goto L16;
        List r6 = (List) r4.get(MultiPreviewSyncDataType.ROOM_LINK_MIC_SYNC_DATA.getSyncKey());
        if (r6 == null) goto L16;
        Iterator r7 = r6.iterator();
    L12:
        if (r7.hasNext() == false) goto L16;
        Object r8 = r7.next();
        if ((r8 instanceof OnWRDSDataUpdateListener) == false) goto L12;
        r5.removeWRDSListener(MultiPreviewSyncDataType.ROOM_LINK_MIC_SYNC_DATA, (OnWRDSDataUpdateListener) r8);
    L16:
        Map<String, Map<String, List<Object>>> r9 = this.e;
        HybridCard r10 = this.b;
        if (r10 == null) goto L19;
        r2 = Integer.valueOf(r10.hashCode());
    L19:
        Map r11 = (Map) ((LinkedHashMap) r9).get(String.valueOf(r2));
        if (r11 == null) goto L29;
        List r12 = (List) r11.get(MultiPreviewSyncDataType.ROOM_LINK_MIC_SYNC_DATA.getSyncKey());
        if (r12 == null) goto L40;
        Iterator r13 = r12.iterator();
    L25:
        if (r13.hasNext() == false) goto L41;
        Object r14 = r13.next();
        if ((r14 instanceof OnWRDSDataUpdateListener) == false) goto L25;
        r5.removeWRDSListener(MultiPreviewSyncDataType.ROOM_LINK_MIC_SYNC_DATA, (OnWRDSDataUpdateListener) r14);
        goto L25
    L41:
        return;
    L40:
        return;
    L29:
        return;
    L5:
        r3 = null;
        goto L6
    }

    public final void f(String r4) {
        Intrinsics.checkNotNullParameter(r4, "linkUserWaveStatus");
        JSONObject r0 = new JSONObject();
        r0.put("eventName", "event_link_user_voice_wave_status");
        r0.put("wave_status", r4);
        HybridCard r5 = this.b;
        if (r5 == null) goto L6;
        r5.sendJsEvent("event_link_user_voice_wave_status", r0);
        return;
    }

    public final void g(String r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "songName");
        Intrinsics.checkNotNullParameter(r5, "ksongId");
        JSONObject r0 = new JSONObject();
        r0.put("eventName", "event_party_ktv_music_info_update");
        r0.put("song_name", r4);
        r0.put("ksong_id", r5);
        HybridCard r6 = this.a;
        if (r6 == null) goto L6;
        r6.sendJsEvent("event_party_ktv_music_info_update", r0);
        return;
    }

    public final void h(boolean r4, boolean r5) {
        w.a("RealTimeChorusMicHybridCardManager", "updateSingStatus lynx isSing: " + r4 + " ; isLead: " + r5);
        JSONObject r0 = new JSONObject();
        r0.put("eventName", "event_party_ktv_sing_state_update");
        r0.put("is_sing", r4);
        r0.put("is_lead", r5);
        HybridCard r6 = this.a;
        if (r6 == null) goto L6;
        r6.sendJsEvent("event_party_ktv_sing_state_update", r0);
        return;
    }

    public final void B1(ih0.f r12, ih0.h r13, boolean r14) {
        Intrinsics.checkNotNullParameter(r12, "updateStatus");
        Intrinsics.checkNotNullParameter(r13, "updateCallback");
        JsonObject r15 = r12.d;
        JsonElement r0 = null;
        if (r15 != null) goto L6;
        ALogger.e("RealTimeChorusMicHybridCardManager", "update status but updateExtraInfo is empty");
        r13.a(UpdateLinkmicStatusResultModel.Code.Success, "", null);
        return;
    L6:
        String r16 = r12.c;
        boolean r3 = false;
        if (r16.length() != 0) goto L9;
        boolean r2 = true;
    L10:
        if (r2 == false) goto L12;
    L50:
        ALogger.e("RealTimeChorusMicHybridCardManager", "update status but fromBizId is empty or not party ktv, fromBizId=".concat(r16));
        return;
    L12:
        if ((!Intrinsics.areEqual(r16, "party_ktv")) == true) goto L50;
        ALogger.i("RealTimeChorusMicHybridCardManager", "update status type=" + r12.getType() + " updateExtraInfo=" + r15);
        int r17 = com.bytedance.android.livesdk.ktvimpl.realtimechorus.lynx.d.a[r12.getType().ordinal()];
        if (r17 == 1) goto L53;
        if (r17 != 2) goto L58;
        JsonObject r18 = r12.d;
        if (r18 == null) goto L22;
        r0 = r18.get("user_id");
    L22:
        String r19 = StringsKt.replace$default(String.valueOf(r0), "\"", "", false, 4, null);
        if (r19 != null) goto L25;
    L26:
        r3 = true;
    L27:
        if (r3 == false) goto L29;
        return;
    L29:
        ALogger.i("RealTimeChorusMicHybridCardManager", "OPEN_EMOJI_PANEL " + r12.d + ' ' + r19);
        DataCenter r110 = this.l;
        if (r110 == null) goto L56;
        r110.put("data_dynamic_show_emoji_panel", r19);
        return;
    L56:
        return;
    L25:
        if (r19.length() != 0) goto L27;
    L58:
        return;
    L53:
        ALogger.i("RealTimeChorusMicHybridCardManager", "ITEM_LOAD_DURATION " + r12.d);     // Catch: Exception -> L47
        tf0.f r111 = (tf0.f) new GsonBuilder().create().fromJson(r12.d, tf0.f.class);     // Catch: Exception -> L47
        if (r111 != null) goto L37;
    L52:
        return;
    L37:
        if (Intrinsics.areEqual(r111.a(), LoadDurationItemId.CHORUS_EMPTY_SEAT_LIST.getValue()) == false) goto L42;
        Function2<? super Boolean, ? super Long, Unit> r112 = this.f.a;     // Catch: Exception -> L47
        if (r112 == null) goto L52;
        Unit r113 = (Unit) r112.invoke(Boolean.FALSE, Long.valueOf(d5.c(r111.c())));     // Catch: Exception -> L47
        goto L52
    L42:
        if (Intrinsics.areEqual(r111.a(), LoadDurationItemId.CHORUS_GUEST_SEAT_LIST.getValue()) == false) goto L52;
        Function2<? super Boolean, ? super Long, Unit> r114 = this.g.a;     // Catch: Exception -> L47
        if (r114 == null) goto L52;
        Unit r115 = (Unit) r114.invoke(Boolean.FALSE, Long.valueOf(d5.c(r111.c())));     // Catch: Exception -> L47
    L47:
        e = move-exception;
        ALogger.e("RealTimeChorusMicHybridCardManager", "dynamicHandleLoadDuration gson failed!", e);
        return;
    L9:
        r2 = false;
        goto L10
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.realtimechorus.lynx.b
    public final void a(List<p> r8, JSONObject r9, Float r10) {
        Intrinsics.checkNotNullParameter(r8, "midiUser");
        if (r9 != null) goto L26;
        JSONArray r1 = null;
    L8:
        if (r1 != null) goto L10;
        JSONObject r11 = new JSONObject();     // Catch: Exception -> L25
        r11.put("eventName", "event_party_ktv_midi_update");     // Catch: Exception -> L25
        JSONArray r12 = new JSONArray();     // Catch: Exception -> L25
        Iterator<T> r13 = r8.iterator();     // Catch: Exception -> L25
    L19:
        if (r13.hasNext() == false) goto L21;
        p r2 = (p) r13.next();     // Catch: Exception -> L25
        JSONObject r4 = new JSONObject();     // Catch: Exception -> L25
        r4.put("userId", r2.b());     // Catch: Exception -> L25
        r4.put("midi", Float.valueOf(r2.a()));     // Catch: Exception -> L25
        r12.put(r4);     // Catch: Exception -> L25
        goto L19
    L21:
        r11.put("midiUsers", r12);     // Catch: Exception -> L25
        HybridCard r14 = this.a;     // Catch: Exception -> L25
        if (r14 == null) goto L29;
        r14.sendJsEvent("event_party_ktv_midi_update", r11);     // Catch: Exception -> L25
        return;
    L29:
        return;
    L10:
        if (((Boolean) KtvSettingHelper.q1.getValue()).booleanValue() == false) goto L13;
        if (r10 == null) goto L13;
        JSONObject r15 = new JSONObject();     // Catch: Exception -> L25
        r15.put("userId", gh0.a.c());     // Catch: Exception -> L25
        r15.put("midi", r10);     // Catch: Exception -> L25
        Unit r16 = Unit.INSTANCE;     // Catch: Exception -> L25
        r1.put(r15);     // Catch: Exception -> L25
    L13:
        r9.put("eventName", "event_party_ktv_midi_update");     // Catch: Exception -> L25
        HybridCard r17 = this.a;     // Catch: Exception -> L25
        if (r17 == null) goto L28;
        r17.sendJsEvent("event_party_ktv_midi_update", r9);     // Catch: Exception -> L25
        return;
    L28:
        return;
    L26:
        r1 = r9.optJSONArray("midiUsers");     // Catch: Exception -> L25
        goto L8
    }

    public c(ViewGroup r2, ViewGroup r3, Context r4, KtvContext r5, DataCenter r6, Function0<Integer> r7) {
        Intrinsics.checkNotNullParameter(r4, "mContext");
        Intrinsics.checkNotNullParameter(r5, "ktvContext");
        Intrinsics.checkNotNullParameter(r7, "getChorusSingerCountAction");
        this.h = r2;
        this.i = r3;
        this.j = r4;
        this.k = r5;
        this.l = r6;
        this.m = r7;
        this.c = Disposables.disposed();
        this.d = Disposables.disposed();
        this.e = new LinkedHashMap();
        this.f = new b();
        this.g = new C0049c();
    }
}
