package com.larus.dora.impl.device.settings.gesture;

import androidx.core.app.NotificationCompat;
import com.larus.dora.impl.DoraBuryPointManager;
import com.larus.dora.impl.core.DoraAdapterExtKt;
import com.larus.dora.impl.device.settings.gesture.wakeup.GestureWakeupType;
import com.larus.dora.impl.dynamic.quicknote.QuickNoteRepo;
import com.larus.dora.impl.model.GestureSettingsKey;
import com.larus.utils.o0;
import com.lynx.serval.svg.SVGRenderEngine;
import java.util.Map;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes27.dex */
public final class GestureSettingsTracker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final GestureSettingsTracker f334416a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static com.larus.dora.impl.network.z f334417b;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f334418a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f334419b = null;

        static {
            int[] r100 = new int[GestureSettingsKey.values().length];
            r100[GestureSettingsKey.MEDIA_LEFT_DOUBLE_CLICK.ordinal()] = 1;     // Catch: NoSuchFieldError -> L15
        L26:
            r100[GestureSettingsKey.MEDIA_RIGHT_DOUBLE_CLICK.ordinal()] = 2;     // Catch: NoSuchFieldError -> L16
        L34:
            r100[GestureSettingsKey.CALLING_LEFT_DOUBLE_CLICK.ordinal()] = 3;     // Catch: NoSuchFieldError -> L17
        L28:
            r100[GestureSettingsKey.CALLING_RIGHT_DOUBLE_CLICK.ordinal()] = 4;     // Catch: NoSuchFieldError -> L18
        L9:
            f334418a = r100;
            int[] r101 = new int[GestureWakeupType.values().length];
            r101[GestureWakeupType.RADIO.ordinal()] = 1;     // Catch: NoSuchFieldError -> L19
        L30:
            r101[GestureWakeupType.RADIO_CONTINUOUS_DIALOGUE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L20
        L22:
            r101[GestureWakeupType.RADIO_RECORD.ordinal()] = 3;     // Catch: NoSuchFieldError -> L21
        L13:
            f334419b = r101;
        }
    }

    static {
        f334416a = new GestureSettingsTracker();
    }

    public GestureSettingsTracker() {
    }

    public static String a(byte r100) {
        if (r100 != 16) goto L6;
        return "play_and_pause";
    L6:
        if (r100 != 19) goto L9;
        return "play_previous";
    L9:
        if (r100 != 20) goto L12;
        return "play_next";
    L12:
        if (r100 != 6) goto L15;
        return "volume_adjustment";
    L15:
        if (r100 != 2) goto L18;
        return "pickup";
    L18:
        if (r100 != 3) goto L21;
        return "hangup";
    L21:
        if (r100 != 1) goto L24;
        return "pickup_and_hangup";
    L24:
        if (r100 != 33) goto L27;
        return "toggle_live_ai";
    L27:
        if (r100 != 32) goto L30;
        return "start_continuous_dialog";
    L30:
        if (r100 != 34) goto L33;
        return "enter_exit_interpretation";
    L33:
        if (r100 != 35) goto L36;
        return "dora_radio";
    L36:
        if (r100 != 37) goto L39;
        return "enter_exit_audio_summary";
    L39:
        if (r100 != 38) goto L42;
        return "quick_note";
    L42:
        if (r100 != 40) goto L45;
        return "enter_exit_headphone_mode";
    L45:
        if (r100 != 39) goto L47;
        return "non_ai_recording";
    L47:
        return "none";
    }

    public static String b(byte r100) {
        if (r100 != 16) goto L6;
        return "play_and_pause";
    L6:
        if (r100 != 19) goto L9;
        return "play_previous";
    L9:
        if (r100 != 20) goto L12;
        return "play_next";
    L12:
        if (r100 != 6) goto L15;
        return "volume_adjustment";
    L15:
        if (r100 != 7) goto L18;
        return "take_image";
    L18:
        if (r100 != 1) goto L21;
        return "pickup_and_hangup";
    L21:
        if (r100 != 2) goto L24;
        return "pickup";
    L24:
        if (r100 != 4) goto L27;
        return "reject_call";
    L27:
        if (r100 != 3) goto L29;
        return "hangup";
    L29:
        if (r100 != 0) goto L32;
        return "none";
    L32:
        if (r100 != (-1)) goto L35;
        return "query_note_content";
    L35:
        if (r100 != 34) goto L37;
        return "start_interpretation";
    L37:
        return "";
    }

    public static String c(GestureWakeupType r100) {
        int r101 = a.f334419b[r100.ordinal()];
        if (r101 != 1) goto L5;
        return "long_press_single_round";
    L5:
        if (r101 != 2) goto L7;
        return "long_press_multi_round_mode";
    L7:
        if (r101 == 3) goto L9;
        return "none";
    L9:
        return "gesture_note";
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v15, types: [T, com.larus.dora.impl.device.settings.gesture.wakeup.GestureWakeupType] */
    /* JADX WARN: Type inference failed for: r5v1, types: [T, com.larus.dora.impl.device.settings.gesture.wakeup.GestureWakeupType] */
    /* JADX WARN: Type inference failed for: r5v28, types: [T, com.larus.dora.impl.device.settings.gesture.wakeup.GestureWakeupType] */
    public final Object e(Continuation<? super Unit> r110) {
        if ((r110 instanceof GestureSettingsTracker$traceGestureSettingsResult$1) == false) goto L7;
        GestureSettingsTracker$traceGestureSettingsResult$1 r100 = (GestureSettingsTracker$traceGestureSettingsResult$1) r110;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r111 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L16;
        if (r103 == 1) goto L15;
        if (r103 != 2) goto L14;
        Ref.ObjectRef r104 = (Ref.ObjectRef) r100.L$2;
        Ref.ObjectRef r105 = (Ref.ObjectRef) r100.L$1;
        Map r106 = (Map) r100.L$0;
        ResultKt.throwOnFailure(r111);
    L23:
        com.larus.dora.impl.network.z r112 = (com.larus.dora.impl.network.z) r111;
        f334417b = r112;
        if (r112 == null) goto L35;
        T r107 = r105.element;
        GestureWakeupType r108 = GestureWakeupType.RADIO;
        if (r107 != r108) goto L31;
        if (o0.d(r112.c()) == false) goto L31;
        r105.element = GestureWakeupType.RADIO_RECORD;
    L31:
        if (r104.element != r108) goto L35;
        if (o0.d(r112.e()) == false) goto L35;
        r104.element = GestureWakeupType.RADIO_RECORD;
    L35:
        Pair[] r113 = new Pair[6];
        Byte r109 = (Byte) r106.get(GestureSettingsKey.MEDIA_LEFT_DOUBLE_CLICK);
        String r114 = null;
        String r115 = "none";
        if (r109 == null) goto L47;
        byte r116 = r109.byteValue();
        if (r116 != 0) goto L46;
        com.larus.dora.impl.network.z r117 = f334417b;
        if (r117 == null) goto L42;
        String r118 = r117.b();
    L44:
        if (o0.d(r118) == false) goto L46;
        String r119 = b((byte) -1);
    L48:
        r113[0] = TuplesKt.to("med_double_click_left", r119);
        Byte r120 = (Byte) r106.get(GestureSettingsKey.MEDIA_RIGHT_DOUBLE_CLICK);
        if (r120 == null) goto L59;
        byte r121 = r120.byteValue();
        if (r121 != 0) goto L58;
        com.larus.dora.impl.network.z r122 = f334417b;
        if (r122 == null) goto L56;
        r114 = r122.d();
    L56:
        if (o0.d(r114) == false) goto L58;
        String r123 = b((byte) -1);
    L60:
        r113[1] = TuplesKt.to("med_double_click_right", r123);
        Byte r124 = (Byte) r106.get(GestureSettingsKey.CALLING_LEFT_DOUBLE_CLICK);
        if (r124 == null) goto L63;
        String r125 = b(r124.byteValue());
    L64:
        r113[2] = TuplesKt.to("call_double_click_left", r125);
        Byte r126 = (Byte) r106.get(GestureSettingsKey.CALLING_RIGHT_DOUBLE_CLICK);
        if (r126 == null) goto L67;
        String r127 = b(r126.byteValue());
    L68:
        r113[3] = TuplesKt.to("call_double_click_right", r127);
        GestureWakeupType r128 = (GestureWakeupType) r105.element;
        if (r128 == null) goto L71;
        String r129 = c(r128);
    L72:
        r113[4] = TuplesKt.to("wakeup_longpress_left", r129);
        GestureWakeupType r130 = (GestureWakeupType) r104.element;
        if (r130 == null) goto L75;
        r115 = c(r130);
    L75:
        r113[5] = TuplesKt.to("wakeup_longpress_right", r115);
        DoraBuryPointManager.f331862a.L("dora_gesture_settings_result", MapsKt.mapOf(r113));
        return Unit.INSTANCE;
    L71:
        r129 = "none";
        goto L72
    L67:
        r127 = "none";
        goto L68
    L63:
        r125 = "none";
    L58:
        r123 = b(r121);
        goto L60
    L59:
        r123 = "none";
        goto L60
    L42:
        r118 = null;
    L46:
        r119 = b(r116);
        goto L48
    L47:
        r119 = "none";
        goto L48
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r111);
    L19:
        Map r131 = (Map) r111;
        r105 = new Ref.ObjectRef();
        r105.element = DoraAdapterExtKt.o(kj4.a.g());
        Ref.ObjectRef r132 = new Ref.ObjectRef();
        r132.element = r105.element;
        QuickNoteRepo r133 = QuickNoteRepo.f335241a;
        r100.L$0 = r131;
        r100.L$1 = r105;
        r100.L$2 = r132;
        r100.label = 2;
        Object r134 = r133.c(r100);
        if (r134 != r102) goto L22;
        return r102;
    L22:
        r104 = r132;
        r106 = r131;
        r111 = r134;
        goto L23
    L16:
        ResultKt.throwOnFailure(r111);
        kj4.a r135 = kj4.a.g();
        r100.label = 1;
        r111 = DoraAdapterExtKt.n(r135);
        if (r111 != r102) goto L19;
        return r102;
    L7:
        r100 = new GestureSettingsTracker$traceGestureSettingsResult$1(this, r110);
        goto L8
    }

    public static void f(GestureSettingsKey r110, byte r111) {
        Intrinsics.checkNotNullParameter(r110, "key");
        int r112 = a.f334418a[r110.ordinal()];
        if (r112 != 1) goto L5;
        MapsKt.mapOf(new Pair[]{TuplesKt.to("gesture_scene", "media"), TuplesKt.to("gesture", "double_click_left_ear"), TuplesKt.to("gesture_effect", b(r111)), TuplesKt.to("status", SVGRenderEngine.SAVE)});
        return;
    L5:
        if (r112 != 2) goto L7;
        MapsKt.mapOf(new Pair[]{TuplesKt.to("gesture_scene", "media"), TuplesKt.to("gesture", "double_click_right_ear"), TuplesKt.to("gesture_effect", b(r111)), TuplesKt.to("status", SVGRenderEngine.SAVE)});
        return;
    L7:
        if (r112 == 3) goto L11;
        if (r112 == 4) goto L10;
        return;
    L10:
        MapsKt.mapOf(new Pair[]{TuplesKt.to("gesture_scene", NotificationCompat.CATEGORY_CALL), TuplesKt.to("gesture", "double_click_right_ear"), TuplesKt.to("gesture_effect", b(r111)), TuplesKt.to("status", SVGRenderEngine.SAVE)});
        return;
    L11:
        MapsKt.mapOf(new Pair[]{TuplesKt.to("gesture_scene", NotificationCompat.CATEGORY_CALL), TuplesKt.to("gesture", "double_click_left_ear"), TuplesKt.to("gesture_effect", b(r111)), TuplesKt.to("status", SVGRenderEngine.SAVE)});
    }

    public static void d(DoraGGestureSettings r100, DoraGGestureSettings r101, int r110, boolean r111, long r112) {
        Intrinsics.checkNotNullParameter(r101, "settings");
        byte r102 = r101.f334358b;
        if (r102 != 6) goto L5;
        String r103 = "quickControl";
    L10:
        byte r104 = r101.f334359c;
        if (r104 != 1) goto L13;
        String r105 = "single_click";
    L21:
        if (r100 == null) goto L23;
        String r106 = a(r100.f334360d);
    L24:
        DoraBuryPointManager.J(DoraBuryPointManager.f331862a, "dora_gesture_settings_dm", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("gesture_scene", r103), TuplesKt.to("gesture", r105), TuplesKt.to("gesture_effect", a(r101.f334360d)), TuplesKt.to("error_code", Integer.valueOf(r110)), TuplesKt.to("is_success", String.valueOf(r111 ? 1 : 0)), TuplesKt.to("from_gesture_effect", r106), TuplesKt.to("duration", Long.valueOf(r112))}), true, 4);
        return;
    L23:
        r106 = "none";
        goto L24
    L13:
        if (r104 != 2) goto L15;
        r105 = "double_click";
        goto L21
    L15:
        if (r104 != 3) goto L18;
        r105 = "triple_click";
        goto L21
    L18:
        if (r104 != 16) goto L20;
        r105 = com.bytedance.android.ec.core.event.a.VALUE_ACTION_TYPE_SWIPE;
        goto L21
    L20:
        r105 = com.bytedance.android.ec.core.event.a.VALUE_LONG_CLICK;
        goto L21
    L5:
        if (r102 != 0) goto L7;
        r103 = "media";
        goto L10
    L7:
        if (r102 != 1) goto L9;
        r103 = NotificationCompat.CATEGORY_CALL;
        goto L10
    L9:
        r103 = "doubao";
        goto L10
    }
}
