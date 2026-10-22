package com.larus.audio.audiov3.util;

import android.content.Context;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.os.Build;
import c68.b;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\t\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 !2\u00020\u0001:\u0001!B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0002J3\u0010\n\u001a\u00020\u00052\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000fH\u0003¢\u0006\u0002\u0010\u0012J-\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u000f2\u0016\u0010\u0015\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u000f0\f\"\u0004\u0018\u00010\u000fH\u0003¢\u0006\u0002\u0010\u0016J\u0014\u0010\u0017\u001a\u0004\u0018\u00010\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0002J\u0014\u0010\u001a\u001a\u0004\u0018\u00010\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0003J\u0014\u0010\u001d\u001a\u0004\u0018\u00010\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0003J\u0014\u0010\u001e\u001a\u0004\u0018\u00010\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0003J\u0012\u0010\u001f\u001a\u00020 2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016¨\u0006\""}, d2 = {"Lcom/larus/audio/audiov3/util/AudioDeviceHelperImpl;", "Lcom/larus/audio/audiov3/util/IAudioDeviceHelper;", "<init>", "()V", "pickDeviceType", "", "hasWired", "", "hasBluetooth", "hasBuiltin", "pickDeviceTypeFromDevices", "devices", "", "Landroid/media/AudioDeviceInfo;", "wiredTypes", "", "bluetoothTypes", "builtinTypes", "([Landroid/media/AudioDeviceInfo;[I[I[I)Ljava/lang/String;", "mergeTypes", "base", "extras", "([I[[I)[I", "sanitizeBluetoothDeviceName", "rawName", "", "getInputDeviceType", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "getOutputDeviceType", "getBluetoothDeviceName", "getAudioDeviceInfo", "Lcom/larus/audio/audiov3/util/IAudioDeviceHelper$DeviceInfo;", "Companion", "audiosdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AudioDeviceHelperImpl implements IAudioDeviceHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[] f288691a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[] f288692b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int[] f288693c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int[] f288694d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int[] f288695e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int[] f288696f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int[] f288697g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int[] f288698h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int[] f288699i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int[] f288700j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int[] f288701k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int[] f288702l = null;

    public static final class a {
    }

    public AudioDeviceHelperImpl() {
    }

    static {
        f288691a = new int[]{3, 5, 6, 11, 12, 19};
        f288692b = new int[]{22};
        f288693c = new int[]{3, 4, 5, 6, 9, 10, 11, 12, 13, 19};
        f288694d = new int[]{22};
        f288695e = new int[]{29};
        f288696f = new int[]{31};
        f288697g = new int[]{7, 8};
        f288698h = new int[]{23};
        f288699i = new int[]{26, 27, 30};
        f288700j = new int[]{15};
        f288701k = new int[]{2, 1};
        f288702l = new int[]{24};
    }

    public static String d(CharSequence r100) {
        Character r101 = null;
        if (r100 == null) goto L21;
        String r102 = r100.toString();
        if (r102 == null) goto L21;
        boolean r103 = false;
        if (StringsKt.contains$default(r102, "\\u", false, 2, null) == true) goto L17;
        int r104 = 0;
    L11:
        if (r104 >= r102.length()) goto L16;
        char r105 = r102.charAt(r104);
        if (Character.isISOControl(r105) == true) goto L14;
        r104 = r104 + 1;
        goto L11
    L14:
        r101 = Character.valueOf(r105);
    L16:
        if (r101 != null) goto L17;
    L18:
        if (r103 == false) goto L24;
        return "";
    L24:
        return r102;
    L17:
        r103 = true;
    L21:
        return null;
    }

    @Override // com.larus.audio.audiov3.util.IAudioDeviceHelper
    public final IAudioDeviceHelper.a a(Context r110) {
        Object r100 = r110.getSystemService("audio");
        if ((r100 instanceof AudioManager) == false) goto L5;
        AudioManager r101 = (AudioManager) r100;
    L6:
        int[] r102 = f288699i;
        int[] r103 = f288697g;
        int[] r104 = f288698h;
        int r105 = 0;
        String r111 = "other";
        if (r101 != null) goto L99;
        String r106 = "other";
    L25:
        Object r107 = r110.getSystemService("audio");
        if ((r107 instanceof AudioManager) == false) goto L28;
        AudioManager r108 = (AudioManager) r107;
    L29:
        if (r108 == null) goto L61;
        int r109 = Build.VERSION.SDK_INT;     // Catch: Exception -> L57
        if (r109 < 23) goto L59;
        AudioDeviceInfo[] r112 = r108.getDevices(2);     // Catch: Exception -> L57
        int[] r113 = f288695e;
        int[] r114 = f288694d;
        int[] r115 = f288693c;
        if (r109 < 34) goto L39;
        r115 = b(r115, new int[][]{r114, r113, f288696f});     // Catch: Exception -> L57
    L45:
        if (r109 < 33) goto L48;
        int[] r116 = b(r103, new int[][]{r104, r102});     // Catch: Exception -> L57
    L52:
        int[] r117 = f288701k;
        if (r109 < 34) goto L55;
        r117 = b(r117, new int[][]{f288702l});     // Catch: Exception -> L57
    L55:
        Intrinsics.checkNotNull(r112);     // Catch: Exception -> L57
        r111 = c(r112, r115, r116, r117);     // Catch: Exception -> L57
        goto L61
    L48:
        if (r109 < 29) goto L51;
        r116 = b(r103, new int[][]{r104});     // Catch: Exception -> L57
        goto L52
    L51:
        r116 = r103;
        goto L52
    L39:
        if (r109 < 31) goto L42;
        r115 = b(r115, new int[][]{r114, r113});     // Catch: Exception -> L57
        goto L45
    L42:
        if (r109 < 26) goto L45;
        r115 = b(r115, new int[][]{r114});     // Catch: Exception -> L57
    L59:
        r111 = null;
    L57:
        e = move-exception;
        int r118 = b.f22600a;
        b.b("AudioDeviceHelper", "getOutputDeviceType error: " + e.getMessage());
    L61:
        if (Intrinsics.areEqual(r106, "bluetooth") == false) goto L63;
    L64:
        int r119 = Build.VERSION.SDK_INT;
        if (r119 < 23) goto L94;
        Object r120 = r110.getSystemService("audio");
        if ((r120 instanceof AudioManager) == false) goto L69;
        AudioManager r121 = (AudioManager) r120;
    L71:
        if (r119 < 33) goto L74;
        r103 = b(r103, new int[][]{r104, r102});
    L76:
        if (r121 == null) goto L85;
        AudioDeviceInfo[] r122 = r121.getDevices(2);
        if (r122 == null) goto L85;
        int r123 = r122.length;
        int r124 = 0;
    L80:
        if (r124 >= r123) goto L85;
        AudioDeviceInfo r125 = r122[r124];
        if (ArraysKt.contains(r103, r125.getType()) == true) goto L83;
        r124 = r124 + 1;
        goto L80
    L83:
        String r126 = d(r125.getProductName());
    L96:
        return new IAudioDeviceHelper.a(r106, r111, r126);
    L85:
        if (r121 == null) goto L94;
        AudioDeviceInfo[] r127 = r121.getDevices(1);
        if (r127 == null) goto L94;
        int r128 = r127.length;
    L89:
        if (r105 >= r128) goto L94;
        AudioDeviceInfo r129 = r127[r105];
        if (ArraysKt.contains(r103, r129.getType()) == true) goto L92;
        r105 = r105 + 1;
        goto L89
    L92:
        r126 = d(r129.getProductName());
        goto L96
    L74:
        if (r119 < 29) goto L76;
        r103 = b(r103, new int[][]{r104});
        goto L76
    L69:
        r121 = null;
    L94:
        r126 = null;
        goto L96
    L63:
        if (Intrinsics.areEqual(r111, "bluetooth") == false) goto L94;
    L28:
        r108 = null;
        goto L29
    L99:
        int r130 = Build.VERSION.SDK_INT;     // Catch: Exception -> L22
        if (r130 < 23) goto L24;
        AudioDeviceInfo[] r131 = r101.getDevices(1);     // Catch: Exception -> L22
        int[] r132 = f288691a;
        if (r130 < 26) goto L15;
        r132 = b(r132, new int[][]{f288692b});     // Catch: Exception -> L22
    L15:
        if (r130 < 33) goto L17;
        int[] r133 = b(r103, new int[][]{r104, r102});     // Catch: Exception -> L22
    L20:
        Intrinsics.checkNotNull(r131);     // Catch: Exception -> L22
        r106 = c(r131, r132, r133, f288700j);     // Catch: Exception -> L22
        goto L25
    L17:
        if (r130 < 29) goto L19;
        r133 = b(r103, new int[][]{r104});     // Catch: Exception -> L22
        goto L20
    L19:
        r133 = r103;
    L24:
        r106 = null;
    L22:
        e = move-exception;
        int r134 = b.f22600a;
        b.b("AudioDeviceHelper", "getInputDeviceType error: " + e.getMessage());
        goto L24
    L5:
        r101 = null;
        goto L6
    }

    public static int[] b(int[] r100, int[]... r101) {
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        int[] r104 = r101[r103];
        if (r104 == null) goto L7;
        r100 = ArraysKt.plus(r100, r104);
    L7:
        r103 = r103 + 1;
        goto L3
    L8:
        return r100;
    }

    public static String c(AudioDeviceInfo[] r100, int[] r101, int[] r110, int[] r111) {
        int r102 = r100.length;
        int r103 = 0;
        boolean r104 = false;
        boolean r105 = false;
        boolean r106 = false;
    L3:
        if (r103 >= r102) goto L14;
        int r107 = r100[r103].getType();
        if (ArraysKt.contains(r101, r107) == false) goto L8;
        r104 = true;
    L13:
        r103 = r103 + 1;
        goto L3
    L8:
        if (ArraysKt.contains(r110, r107) == false) goto L11;
        r105 = true;
        goto L13
    L11:
        if (ArraysKt.contains(r111, r107) == false) goto L13;
        r106 = true;
        goto L13
    L14:
        if (r104 == false) goto L16;
        return "wired";
    L16:
        if (r105 == false) goto L18;
        return "bluetooth";
    L18:
        if (r106 == false) goto L20;
        return "builtin";
    L20:
        return "other";
    }
}
