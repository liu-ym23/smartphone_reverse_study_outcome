package rk9;

import android.media.AudioDeviceInfo;
import android.os.Build;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class d {
    public static final String a(AudioDeviceInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "device");
        StringBuilder r101 = new StringBuilder();
        int r102 = r100.getType();
        if (Build.VERSION.SDK_INT >= 31) goto L5;
    L12:
        if (r102 != 0) goto L14;
        String r103 = "UNKNOWN";
    L46:
        r101.append(r103);
        r101.append('#');
        r101.append(r100.getId());
        r101.append('(');
        r101.append(r100.getProductName());
        r101.append(')');
        return r101.toString();
    L14:
        if (r102 != 1) goto L16;
        r103 = "BUILTIN_EARPIECE";
        goto L46
    L16:
        if (r102 != 2) goto L18;
        r103 = "BUILTIN_SPEAKER";
        goto L46
    L18:
        if (r102 != 3) goto L20;
        r103 = "WIRED_HEADSET";
        goto L46
    L20:
        if (r102 != 4) goto L22;
        r103 = "WIRED_HEADPHONES";
        goto L46
    L22:
        if (r102 != 7) goto L24;
        r103 = "BLUETOOTH_SCO";
        goto L46
    L24:
        if (r102 != 8) goto L26;
        r103 = "BLUETOOTH_A2DP";
        goto L46
    L26:
        if (r102 != 15) goto L28;
        r103 = "BUILTIN_MIC";
        goto L46
    L28:
        if (r102 != 18) goto L30;
        r103 = "TELEPHONY";
        goto L46
    L30:
        if (r102 == 22) goto L36;
        switch(r102) {
            case 11: goto L35;
            case 12: goto L34;
            case 13: goto L33;
            default: goto L32;
        };
    L32:
        r103 = "TYPE_" + r102;
        goto L46
    L33:
        r103 = "DOCK";
        goto L46
    L34:
        r103 = "USB_ACCESSORY";
        goto L46
    L35:
        r103 = "USB_DEVICE";
        goto L46
    L36:
        r103 = "USB_HEADSET";
        goto L46
    L5:
        if (r102 == 30) goto L11;
        switch(r102) {
            case 25: goto L10;
            case 26: goto L9;
            case 27: goto L8;
            default: goto L12;
        };
    L8:
        r103 = "BLE_SPEAKER";
        goto L46
    L9:
        r103 = "BLE_HEADSET";
        goto L46
    L10:
        r103 = "REMOTE_SUBMIX";
        goto L46
    L11:
        r103 = "BLE_BROADCAST";
        goto L46
    }

    public static final String b(List<AudioDeviceInfo> r100) {
        Intrinsics.checkNotNullParameter(r100, "devices");
        ArrayList r101 = new ArrayList();
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L20;
        Object r103 = r102.next();
        AudioDeviceInfo r104 = (AudioDeviceInfo) r103;
        boolean r105 = true;
        if (c(r104) == true) goto L17;
        Intrinsics.checkNotNullParameter(r104, "<this>");
        if (e(r104) == false) goto L10;
    L13:
        boolean r106 = true;
    L14:
        if (r106 == true) goto L17;
        r105 = false;
        goto L17
    L10:
        if (c(r104) == true) goto L13;
        r106 = false;
    L17:
        if (r105 == false) goto L4;
        r101.add(r103);
        goto L4
    L20:
        if (r101.isEmpty() == false) goto L23;
        return "[]";
    L23:
        return CollectionsKt.joinToString$default(r101, null, "[", "]", 0, null, new c(), 25, null);
    }

    public static final boolean c(AudioDeviceInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.getType() != 7) goto L5;
    L10:
        return true;
    L5:
        if (Build.VERSION.SDK_INT >= 31) goto L7;
    L9:
        return false;
    L7:
        if (r100.getType() != 26) goto L9;
        goto L9
    }

    public static final boolean d(AudioDeviceInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        int r101 = r100.getType();
        if (r101 != 1) goto L5;
        return true;
    L5:
        if (r101 == 2) goto L9;
        return false;
    L9:
        return true;
    }

    public static final boolean e(AudioDeviceInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (Build.VERSION.SDK_INT >= 31) goto L5;
    L7:
        int r101 = r100.getType();
        if (r101 != 3) goto L10;
        return true;
    L10:
        if (r101 != 4) goto L12;
        return true;
    L12:
        if (r101 != 7) goto L14;
        return true;
    L14:
        if (r101 != 8) goto L16;
        return true;
    L16:
        if (r101 != 11) goto L18;
        return true;
    L18:
        if (r101 != 12) goto L20;
        return true;
    L20:
        if (r101 == 22) goto L29;
        return false;
    L29:
        return true;
    L5:
        if (r100.getType() != 26) goto L7;
        return true;
    }

    public static final boolean f(AudioDeviceInfo r100, AudioDeviceInfo r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "other");
        if (r100.getId() == r101.getId()) goto L5;
    L7:
        return false;
    L5:
        if (r100.getType() != r101.getType()) goto L7;
        return true;
    }
}
