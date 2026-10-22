package com.larus.dora.impl.util;

import com.bytedance.android.ec.model.response.ECPromotion;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b,\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u0002002\b\b\u0002\u00101\u001a\u000202j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,¨\u00063"}, d2 = {"Lcom/larus/dora/impl/util/DoraVideoType;", "", "<init>", "(Ljava/lang/String;I)V", "UNKNOWN", "ONBOARDING_UNBOXING", "ONBOARDING_UNBOXING_LOOP", "ONBOARDING_MEDIA_CONTROL", "ONBOARDING_DORA_WEARING", "ONBOARDING_GESTURE_AWAKE", "ONBOARDING_BLUETOOTH_SETTING", "DORA_GESTURE_WAKEUP", "DORA_E_VIDEO_ONBOARDING_DISCOVER_OPEN_BOX", "DORA_E_VIDEO_ONBOARDING_DISCOVER_NO_RADAR", "DORA_E_VIDEO_ONBOARDING_DISCOVER_RADAR", "DORA_E_VIDEO_ONBOARDING_LIVE_AI_GESTURE", "DORA_E_VIDEO_ONBOARDING_LIVE_AI_VOICE", "DORA_E_VIDEO_ONBOARDING_WEAR", "DORA_E_VIDEO_ONBOARDING_WELCOME", "DORA_G_VIDEO_ONBOARDING_DISCOVER_OPEN_BOX", "DORA_G_VIDEO_ONBOARDING_DISCOVER_OPEN_BOX_TIMEOUT", "DORA_G_VIDEO_ONBOARDING_WELCOME_1", "DORA_G_VIDEO_ONBOARDING_WELCOME_2", "DORA_G_VIDEO_ONBOARDING_PHOTOGRAPHY", "DORA_G_VIDEO_ONBOARDING_PHOTOGRAPHY_LOOP", "DORA_G_VIDEO_ONBOARDING_KEY", "DORA_G_VIDEO_ONBOARDING_KEY_LOOP", "DORA_G_VIDEO_ONBOARDING_VIDEO", "DORA_G_VIDEO_ONBOARDING_VIDEO_LOOP", "DORA_G_VIDEO_ONBOARDING_LIVE_AI_1", "DORA_G_VIDEO_ONBOARDING_LIVE_AI_2", "DORA_G_VIDEO_ONBOARDING_LIVE_AI_LOOP", "DORA_G_VIDEO_ONBOARDING_TAKE_PHOTO", "DORA_G_VIDEO_ONBOARDING_TAKE_PHOTO_LOOP", "DORA_G_VIDEO_ONBOARDING_VIDEO_CALL", "DORA_G_VIDEO_ONBOARDING_VIDEO_CALL_LOOP", "DORA_G_VIDEO_ONBOARDING_MEDIA_CONTROL", "DORA_G_VIDEO_ONBOARDING_MEDIA_CONTROL_LOOP", "DORA_G_VIDEO_ONBOARDING_FINISH", "DORA_G_GESTURE_L_2_M", "DORA_G_GESTURE_L", "DORA_G_GESTURE_M_2_L", "DORA_G_GESTURE_M_2_R", "DORA_G_GESTURE_R_2_M", "DORA_G_GESTURE_R", "fileName", "", ECPromotion.SKU, "Lcom/larus/dora/impl/util/DoraSKU;", "isDarkMode", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DoraVideoType extends Enum<DoraVideoType> {
    public static final DoraVideoType DORA_E_VIDEO_ONBOARDING_DISCOVER_NO_RADAR = null;
    public static final DoraVideoType DORA_E_VIDEO_ONBOARDING_DISCOVER_OPEN_BOX = null;
    public static final DoraVideoType DORA_E_VIDEO_ONBOARDING_DISCOVER_RADAR = null;
    public static final DoraVideoType DORA_E_VIDEO_ONBOARDING_LIVE_AI_GESTURE = null;
    public static final DoraVideoType DORA_E_VIDEO_ONBOARDING_LIVE_AI_VOICE = null;
    public static final DoraVideoType DORA_E_VIDEO_ONBOARDING_WEAR = null;
    public static final DoraVideoType DORA_E_VIDEO_ONBOARDING_WELCOME = null;
    public static final DoraVideoType DORA_GESTURE_WAKEUP = null;
    public static final DoraVideoType DORA_G_GESTURE_L = null;
    public static final DoraVideoType DORA_G_GESTURE_L_2_M = null;
    public static final DoraVideoType DORA_G_GESTURE_M_2_L = null;
    public static final DoraVideoType DORA_G_GESTURE_M_2_R = null;
    public static final DoraVideoType DORA_G_GESTURE_R = null;
    public static final DoraVideoType DORA_G_GESTURE_R_2_M = null;
    public static final DoraVideoType DORA_G_VIDEO_ONBOARDING_DISCOVER_OPEN_BOX = null;
    public static final DoraVideoType DORA_G_VIDEO_ONBOARDING_DISCOVER_OPEN_BOX_TIMEOUT = null;
    public static final DoraVideoType DORA_G_VIDEO_ONBOARDING_FINISH = null;
    public static final DoraVideoType DORA_G_VIDEO_ONBOARDING_KEY = null;
    public static final DoraVideoType DORA_G_VIDEO_ONBOARDING_KEY_LOOP = null;
    public static final DoraVideoType DORA_G_VIDEO_ONBOARDING_LIVE_AI_1 = null;
    public static final DoraVideoType DORA_G_VIDEO_ONBOARDING_LIVE_AI_2 = null;
    public static final DoraVideoType DORA_G_VIDEO_ONBOARDING_LIVE_AI_LOOP = null;
    public static final DoraVideoType DORA_G_VIDEO_ONBOARDING_MEDIA_CONTROL = null;
    public static final DoraVideoType DORA_G_VIDEO_ONBOARDING_MEDIA_CONTROL_LOOP = null;
    public static final DoraVideoType DORA_G_VIDEO_ONBOARDING_PHOTOGRAPHY = null;
    public static final DoraVideoType DORA_G_VIDEO_ONBOARDING_PHOTOGRAPHY_LOOP = null;
    public static final DoraVideoType DORA_G_VIDEO_ONBOARDING_TAKE_PHOTO = null;
    public static final DoraVideoType DORA_G_VIDEO_ONBOARDING_TAKE_PHOTO_LOOP = null;
    public static final DoraVideoType DORA_G_VIDEO_ONBOARDING_VIDEO = null;
    public static final DoraVideoType DORA_G_VIDEO_ONBOARDING_VIDEO_CALL = null;
    public static final DoraVideoType DORA_G_VIDEO_ONBOARDING_VIDEO_CALL_LOOP = null;
    public static final DoraVideoType DORA_G_VIDEO_ONBOARDING_VIDEO_LOOP = null;
    public static final DoraVideoType DORA_G_VIDEO_ONBOARDING_WELCOME_1 = null;
    public static final DoraVideoType DORA_G_VIDEO_ONBOARDING_WELCOME_2 = null;
    public static final DoraVideoType ONBOARDING_BLUETOOTH_SETTING = null;
    public static final DoraVideoType ONBOARDING_DORA_WEARING = null;
    public static final DoraVideoType ONBOARDING_GESTURE_AWAKE = null;
    public static final DoraVideoType ONBOARDING_MEDIA_CONTROL = null;
    public static final DoraVideoType ONBOARDING_UNBOXING = null;
    public static final DoraVideoType ONBOARDING_UNBOXING_LOOP = null;
    public static final DoraVideoType UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DoraVideoType[] f338118a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f338119b = null;

    public static EnumEntries<DoraVideoType> getEntries() {
        return f338119b;
    }

    static {
        DoraVideoType r100 = new DoraVideoType("UNKNOWN", 0);
        UNKNOWN = r100;
        DoraVideoType r101 = new DoraVideoType("ONBOARDING_UNBOXING", 1);
        ONBOARDING_UNBOXING = r101;
        DoraVideoType r102 = new DoraVideoType("ONBOARDING_UNBOXING_LOOP", 2);
        ONBOARDING_UNBOXING_LOOP = r102;
        DoraVideoType r103 = new DoraVideoType("ONBOARDING_MEDIA_CONTROL", 3);
        ONBOARDING_MEDIA_CONTROL = r103;
        DoraVideoType r104 = new DoraVideoType("ONBOARDING_DORA_WEARING", 4);
        ONBOARDING_DORA_WEARING = r104;
        DoraVideoType r105 = new DoraVideoType("ONBOARDING_GESTURE_AWAKE", 5);
        ONBOARDING_GESTURE_AWAKE = r105;
        DoraVideoType r110 = new DoraVideoType("ONBOARDING_BLUETOOTH_SETTING", 6);
        ONBOARDING_BLUETOOTH_SETTING = r110;
        DoraVideoType r111 = new DoraVideoType("DORA_GESTURE_WAKEUP", 7);
        DORA_GESTURE_WAKEUP = r111;
        DoraVideoType r112 = new DoraVideoType("DORA_E_VIDEO_ONBOARDING_DISCOVER_OPEN_BOX", 8);
        DORA_E_VIDEO_ONBOARDING_DISCOVER_OPEN_BOX = r112;
        DoraVideoType r113 = new DoraVideoType("DORA_E_VIDEO_ONBOARDING_DISCOVER_NO_RADAR", 9);
        DORA_E_VIDEO_ONBOARDING_DISCOVER_NO_RADAR = r113;
        DoraVideoType r114 = new DoraVideoType("DORA_E_VIDEO_ONBOARDING_DISCOVER_RADAR", 10);
        DORA_E_VIDEO_ONBOARDING_DISCOVER_RADAR = r114;
        DoraVideoType r115 = new DoraVideoType("DORA_E_VIDEO_ONBOARDING_LIVE_AI_GESTURE", 11);
        DORA_E_VIDEO_ONBOARDING_LIVE_AI_GESTURE = r115;
        DoraVideoType r106 = new DoraVideoType("DORA_E_VIDEO_ONBOARDING_LIVE_AI_VOICE", 12);
        DORA_E_VIDEO_ONBOARDING_LIVE_AI_VOICE = r106;
        DoraVideoType r107 = new DoraVideoType("DORA_E_VIDEO_ONBOARDING_WEAR", 13);
        DORA_E_VIDEO_ONBOARDING_WEAR = r107;
        DoraVideoType r108 = new DoraVideoType("DORA_E_VIDEO_ONBOARDING_WELCOME", 14);
        DORA_E_VIDEO_ONBOARDING_WELCOME = r108;
        DoraVideoType r109 = new DoraVideoType("DORA_G_VIDEO_ONBOARDING_DISCOVER_OPEN_BOX", 15);
        DORA_G_VIDEO_ONBOARDING_DISCOVER_OPEN_BOX = r109;
        DoraVideoType r116 = new DoraVideoType("DORA_G_VIDEO_ONBOARDING_DISCOVER_OPEN_BOX_TIMEOUT", 16);
        DORA_G_VIDEO_ONBOARDING_DISCOVER_OPEN_BOX_TIMEOUT = r116;
        DoraVideoType r117 = new DoraVideoType("DORA_G_VIDEO_ONBOARDING_WELCOME_1", 17);
        DORA_G_VIDEO_ONBOARDING_WELCOME_1 = r117;
        DoraVideoType r118 = new DoraVideoType("DORA_G_VIDEO_ONBOARDING_WELCOME_2", 18);
        DORA_G_VIDEO_ONBOARDING_WELCOME_2 = r118;
        DoraVideoType r119 = new DoraVideoType("DORA_G_VIDEO_ONBOARDING_PHOTOGRAPHY", 19);
        DORA_G_VIDEO_ONBOARDING_PHOTOGRAPHY = r119;
        DoraVideoType r120 = new DoraVideoType("DORA_G_VIDEO_ONBOARDING_PHOTOGRAPHY_LOOP", 20);
        DORA_G_VIDEO_ONBOARDING_PHOTOGRAPHY_LOOP = r120;
        DoraVideoType r121 = new DoraVideoType("DORA_G_VIDEO_ONBOARDING_KEY", 21);
        DORA_G_VIDEO_ONBOARDING_KEY = r121;
        DoraVideoType r122 = new DoraVideoType("DORA_G_VIDEO_ONBOARDING_KEY_LOOP", 22);
        DORA_G_VIDEO_ONBOARDING_KEY_LOOP = r122;
        DoraVideoType r123 = new DoraVideoType("DORA_G_VIDEO_ONBOARDING_VIDEO", 23);
        DORA_G_VIDEO_ONBOARDING_VIDEO = r123;
        DoraVideoType r124 = new DoraVideoType("DORA_G_VIDEO_ONBOARDING_VIDEO_LOOP", 24);
        DORA_G_VIDEO_ONBOARDING_VIDEO_LOOP = r124;
        DoraVideoType r125 = new DoraVideoType("DORA_G_VIDEO_ONBOARDING_LIVE_AI_1", 25);
        DORA_G_VIDEO_ONBOARDING_LIVE_AI_1 = r125;
        DoraVideoType r126 = new DoraVideoType("DORA_G_VIDEO_ONBOARDING_LIVE_AI_2", 26);
        DORA_G_VIDEO_ONBOARDING_LIVE_AI_2 = r126;
        DoraVideoType r127 = new DoraVideoType("DORA_G_VIDEO_ONBOARDING_LIVE_AI_LOOP", 27);
        DORA_G_VIDEO_ONBOARDING_LIVE_AI_LOOP = r127;
        DoraVideoType r128 = new DoraVideoType("DORA_G_VIDEO_ONBOARDING_TAKE_PHOTO", 28);
        DORA_G_VIDEO_ONBOARDING_TAKE_PHOTO = r128;
        DoraVideoType r129 = new DoraVideoType("DORA_G_VIDEO_ONBOARDING_TAKE_PHOTO_LOOP", 29);
        DORA_G_VIDEO_ONBOARDING_TAKE_PHOTO_LOOP = r129;
        DoraVideoType r130 = new DoraVideoType("DORA_G_VIDEO_ONBOARDING_VIDEO_CALL", 30);
        DORA_G_VIDEO_ONBOARDING_VIDEO_CALL = r130;
        DoraVideoType r131 = new DoraVideoType("DORA_G_VIDEO_ONBOARDING_VIDEO_CALL_LOOP", 31);
        DORA_G_VIDEO_ONBOARDING_VIDEO_CALL_LOOP = r131;
        DoraVideoType r132 = new DoraVideoType("DORA_G_VIDEO_ONBOARDING_MEDIA_CONTROL", 32);
        DORA_G_VIDEO_ONBOARDING_MEDIA_CONTROL = r132;
        DoraVideoType r133 = new DoraVideoType("DORA_G_VIDEO_ONBOARDING_MEDIA_CONTROL_LOOP", 33);
        DORA_G_VIDEO_ONBOARDING_MEDIA_CONTROL_LOOP = r133;
        DoraVideoType r134 = new DoraVideoType("DORA_G_VIDEO_ONBOARDING_FINISH", 34);
        DORA_G_VIDEO_ONBOARDING_FINISH = r134;
        DoraVideoType r135 = new DoraVideoType("DORA_G_GESTURE_L_2_M", 35);
        DORA_G_GESTURE_L_2_M = r135;
        DoraVideoType r136 = new DoraVideoType("DORA_G_GESTURE_L", 36);
        DORA_G_GESTURE_L = r136;
        DoraVideoType r137 = new DoraVideoType("DORA_G_GESTURE_M_2_L", 37);
        DORA_G_GESTURE_M_2_L = r137;
        DoraVideoType r138 = new DoraVideoType("DORA_G_GESTURE_M_2_R", 38);
        DORA_G_GESTURE_M_2_R = r138;
        DoraVideoType r139 = new DoraVideoType("DORA_G_GESTURE_R_2_M", 39);
        DORA_G_GESTURE_R_2_M = r139;
        DoraVideoType r140 = new DoraVideoType("DORA_G_GESTURE_R", 40);
        DORA_G_GESTURE_R = r140;
        DoraVideoType[] r141 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127, r128, r129, r130, r131, r132, r133, r134, r135, r136, r137, r138, r139, r140};
        f338118a = r141;
        f338119b = EnumEntriesKt.enumEntries(r141);
    }

    public static DoraVideoType[] values() {
        return (DoraVideoType[]) f338118a.clone();
    }

    public static DoraVideoType valueOf(String r100) {
        return (DoraVideoType) r27.a.a(DoraVideoType.class, r100);
    }

    public DoraVideoType(String r100, int r101) {
        super(r100, r101);
    }

    public final String fileName(DoraSKU r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, ECPromotion.SKU);
        StringBuilder r102 = new StringBuilder();
        r102.append(name().toLowerCase(Locale.US));
        r102.append('_');
        r102.append(r100.getSkuName());
        r102.append('_');
        if (r101 == false) goto L5;
        String r103 = "dark";
    L6:
        r102.append(r103);
        r102.append(".mp4");
        return r102.toString();
    L5:
        r103 = "light";
        goto L6
    }

    public static /* synthetic */ String fileName$default(DoraVideoType r100, DoraSKU r101, boolean r102, int r103, Object r104) {
        if (r104 != null) goto L9;
        if ((r103 & 2) == 0) goto L7;
        r102 = false;
    L7:
        return r100.fileName(r101, r102);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fileName");
    }
}
