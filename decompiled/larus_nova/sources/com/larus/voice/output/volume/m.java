package com.larus.voice.output.volume;

import com.bytedance.keva.Keva;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class m implements com.larus.voice.output.volume.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile String f376048b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile boolean f376049c;

    public static final class a {
    }

    public m() {
    }

    static {
        f376048b = "";
    }

    @Override // com.larus.voice.output.volume.a
    public final void a(c r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r101 = c68.b.f22600a;
        c68.b.d("ZeroVolumeAutoPlayHelper", "[ZeroVolumeToastHandler][handle]: scene: " + r100.f376038c + "， hasShownTTSAutoPlayToast: " + f376049c + ", lastShownScene: " + f376048b);
        t0.d(new l(), 300);
        f376048b = r100.f376038c;
        if (com.larus.voice.output.volume.a.b.a(r100) == false) goto L6;
        f376049c = true;
    L6:
        if (z2.f365865a.enableZeroVolumeToastFrequencyControl() == false) goto L8;
        ((Keva) k.f376047a.getValue()).storeLong("zero_volume_toast_shown_date", System.currentTimeMillis());
    L8:
        IZeroVolumeHandlerKt.a(r100);
    }

    @Override // com.larus.voice.output.volume.a
    public final boolean b(c r110) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        boolean r100 = false;
        if (r110.f376036a != 1) goto L5;
        boolean r101 = true;
    L7:
        if (r101 == true) goto L9;
        int r102 = c68.b.f22600a;
        c68.b.d("ZeroVolumeAutoPlayHelper", "[ZeroVolumeToastHandler][checkCondition]: strategyId not match, strategyId = " + r110.f376036a);
    L34:
        int r111 = c68.b.f22600a;
        c68.b.d("ZeroVolumeAutoPlayHelper", "[ZeroVolumeToastHandler][canHandle]: result = " + r100);
        return r100;
    L9:
        z2 r103 = z2.f365865a;
        if (r103.enableZeroVolumeToastFrequencyControl() == false) goto L20;
        long r104 = ((Keva) k.f376047a.getValue()).getLong("zero_volume_toast_shown_date", -1);
        if (r104 > 0) goto L14;
        FLogger.f375446a.i("ZeroVolumeAutoPlayHelper", "[ZeroVolumeToastFrequencyManager] [isToastShownToday]: lastShownTime(" + r104 + ") is invalid");
    L17:
        boolean r105 = false;
    L18:
        if (r105 == false) goto L20;
        boolean r106 = false;
    L24:
        if (r106 == true) goto L27;
        int r107 = c68.b.f22600a;
        c68.b.d("ZeroVolumeAutoPlayHelper", "[ZeroVolumeToastHandler][checkCondition]: frequency not match, scene = " + r110.f376038c + ", lastShownScene = " + f376048b + ", enableZeroVolumeToastFrequencyControl = " + r103.enableZeroVolumeToastFrequencyControl());
        goto L34
    L27:
        if (com.larus.voice.output.volume.a.b.a(r110) == true) goto L29;
    L33:
        r100 = true;
        goto L34
    L29:
        if (r110.f376037b == true) goto L31;
    L32:
        int r108 = c68.b.f22600a;
        c68.b.d("ZeroVolumeAutoPlayHelper", "[ZeroVolumeToastHandler][checkCondition]: enableAutoPlayToast is " + r110.f376037b + ", hasShownTTSAutoPlayToast = " + f376049c);
        goto L34
    L31:
        if (f376049c == false) goto L33;
    L14:
        long r109 = System.currentTimeMillis();
        FLogger.f375446a.i("ZeroVolumeAutoPlayHelper", "[ZeroVolumeToastFrequencyManager] [isToastShownToday]: lastShownTime = " + r104 + ", currentTime = " + r109);
        if ((r109 - r104) > 86400000) goto L17;
        r105 = true;
    L20:
        String r112 = r110.f376038c;
        com.larus.voice.output.volume.a.f376033a.getClass();
        if (com.larus.voice.output.volume.a.C4519a.f376035b.contains(r112) == false) goto L23;
        r106 = !Intrinsics.areEqual(r112, f376048b);
        goto L24
    L23:
        r106 = true;
        goto L24
    L5:
        r101 = false;
        goto L7
    }
}
