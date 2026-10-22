package com.larus.dora.impl.device.settings.gesture;

import androidx.core.app.NotificationCompat;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class a {
    public static final String a(DoraGGestureSettings r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        byte r101 = r100.f334360d;
        if (r101 != 0) goto L6;
        return "none";
    L6:
        if (r101 != 16) goto L9;
        return "play_pause";
    L9:
        if (r101 != 19) goto L12;
        return "previous_track";
    L12:
        if (r101 != 20) goto L15;
        return "next_track";
    L15:
        if (r101 != 6) goto L18;
        return "volume_control";
    L18:
        if (r101 != 1) goto L21;
        return "answer_or_hang_up";
    L21:
        if (r101 != 2) goto L24;
        return "answer_only";
    L24:
        if (r101 != 3) goto L27;
        return "hang_up_only";
    L27:
        if (r101 != 33) goto L30;
        return "enter_exit_companion";
    L30:
        if (r101 != 34) goto L33;
        return "enter_exit_interpretation";
    L33:
        if (r101 != 35) goto L36;
        return "dora_radio";
    L36:
        if (r101 != 32) goto L39;
        return "continuous_dialogue";
    L39:
        if (r101 != 37) goto L42;
        return "enter_exit_audio_summary";
    L42:
        if (r101 != 38) goto L45;
        return "quick_note";
    L45:
        if (r101 != 40) goto L48;
        return "enter_exit_headphone_mode";
    L48:
        if (r101 != 39) goto L65;
        return "non_ai_recording";
    L65:
        return "none";
    }

    public static final String b(DoraGGestureSettings r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        byte r101 = r100.f334357a;
        String r102 = "none";
        if (r101 != 0) goto L5;
        String r103 = "right";
    L10:
        byte r104 = r100.f334358b;
        if (r104 != 6) goto L13;
        String r105 = "quick_control";
    L23:
        byte r106 = r100.f334359c;
        if (r106 != 1) goto L26;
        r102 = "single_click";
    L36:
        return r103 + '_' + r105 + '_' + r102;
    L26:
        if (r106 != 2) goto L29;
        r102 = "double_click";
        goto L36
    L29:
        if (r106 != 3) goto L31;
        r102 = "tripple_click";
        goto L36
    L31:
        if (r106 != 6) goto L33;
        r102 = com.bytedance.android.ec.core.event.a.VALUE_LONG_CLICK;
        goto L36
    L33:
        if (r106 != 16) goto L36;
        r102 = com.bytedance.android.ec.core.event.a.VALUE_ACTION_TYPE_SWIPE;
        goto L36
    L13:
        if (r104 != 0) goto L15;
        r105 = "media";
        goto L23
    L15:
        if (r104 != 1) goto L17;
        r105 = NotificationCompat.CATEGORY_CALL;
        goto L23
    L17:
        if (r104 != 2) goto L20;
        r105 = "doubao";
        goto L23
    L20:
        if (r104 != 4) goto L22;
        r105 = "button";
        goto L23
    L22:
        r105 = "none";
        goto L23
    L5:
        if (r101 == 16) goto L9;
        if (r101 == 16) goto L9;
        r103 = "none";
    L9:
        r103 = "left";
        goto L10
    }
}
