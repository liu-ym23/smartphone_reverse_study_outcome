package com.larus.dora.impl.device.settings.gesture.options;

import com.larus.dora.impl.device.settings.gesture.DoraGGestureSettings;
import com.larus.nova.R;
import com.larus.utils.j0;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f334473a = 0;

    static {
    }

    public static p a(DoraGGestureSettings r110, List r111) {
        Intrinsics.checkNotNullParameter(r110, "gesture");
        Intrinsics.checkNotNullParameter(r111, "currentSettings");
        if (r110.f334358b == 6) goto L5;
    L22:
        return null;
    L5:
        if (r110.f334359c != 1) goto L22;
        if (r110.f334357a != 16) goto L10;
        int r100 = j0.f375426a;
        int r101 = R.string.larus_dora_gesture_left_temple_cn;
    L11:
        j0.d(r101);
        byte r102 = r110.f334360d;
        if (r102 == 16) goto L14;
        if (r102 != 0) goto L22;
        if (c(r111, r110.f334357a, r110.f334358b, (byte) 16, (byte) 20) == true) goto L22;
        int r103 = j0.f375426a;
        String r104 = j0.d(R.string.larus_dora_g_gesture_switch_guide_singleclick_title_cn);
        String r105 = j0.d(R.string.larus_dora_g_gesture_switch_guide_singleclick_subtitle2_cn);
        byte r106 = r110.f334357a;
        byte r112 = r110.f334358b;
        return new p(r104, r105, CollectionsKt.listOf(new DoraGGestureSettings[]{new DoraGGestureSettings(r106, r112, (byte) 2, (byte) 16), new DoraGGestureSettings(r106, r112, (byte) 3, (byte) 20)}));
    L14:
        if (c(r111, r110.f334357a, r110.f334358b, (byte) 20, (byte) 19) == true) goto L22;
        int r107 = j0.f375426a;
        String r108 = j0.d(R.string.larus_dora_g_gesture_switch_guide_singleclick_title_cn);
        String r109 = j0.d(R.string.larus_dora_g_gesture_switch_guide_singleclick_subtitle_cn);
        byte r113 = r110.f334357a;
        byte r114 = r110.f334358b;
        return new p(r108, r109, CollectionsKt.listOf(new DoraGGestureSettings[]{new DoraGGestureSettings(r113, r114, (byte) 2, (byte) 20), new DoraGGestureSettings(r113, r114, (byte) 3, (byte) 19)}));
    L10:
        int r115 = j0.f375426a;
        r101 = R.string.larus_dora_gesture_right_temple_cn;
        goto L11
    }

    public static Byte b(List r100, byte r101, byte r102, byte r103) {
        Iterator r104 = r100.iterator();
    L4:
        if (r104.hasNext() == false) goto L15;
        Object r105 = r104.next();
        DoraGGestureSettings r106 = (DoraGGestureSettings) r105;
        if (r106.f334357a == r101) goto L8;
    L12:
        boolean r107 = false;
    L13:
        if (r107 == false) goto L4;
    L16:
        DoraGGestureSettings r108 = (DoraGGestureSettings) r105;
        if (r108 != null) goto L19;
        return null;
    L19:
        return Byte.valueOf(r108.f334360d);
    L8:
        if (r106.f334358b != r102) goto L12;
        if (r106.f334359c != r103) goto L12;
        r107 = true;
        goto L13
    L15:
        r105 = null;
        goto L16
    }

    public static boolean c(List r100, byte r101, byte r102, byte r103, byte r104) {
        Byte r105 = b(r100, r101, r102, (byte) 2);
        Byte r106 = b(r100, r101, r102, (byte) 3);
        if (r105 != null) goto L5;
    L7:
        boolean r107 = false;
    L8:
        if (r107 == false) goto L17;
        if (r106 != null) goto L11;
    L13:
        boolean r108 = false;
    L14:
        if (r108 == false) goto L18;
        return true;
    L18:
        return false;
    L11:
        if (r106.byteValue() != r104) goto L13;
        r108 = true;
        goto L14
    L17:
        return false;
    L5:
        if (r105.byteValue() != r103) goto L7;
        r107 = true;
        goto L8
    }
}
