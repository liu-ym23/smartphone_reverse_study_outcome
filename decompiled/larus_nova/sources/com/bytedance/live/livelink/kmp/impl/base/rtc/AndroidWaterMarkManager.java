package com.bytedance.live.livelink.kmp.impl.base.rtc;

import android.graphics.Bitmap;
import androidx.camera.video.AudioStats;
import com.bytedance.live.livelink.kmp.api.core.mixer.RTCWaterMarkRegion;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class AndroidWaterMarkManager implements ti6.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ei6.a f255295a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public HashMap<String, RTCWaterMarkRegion> f255296b;

    public static final class a {
    }

    static {
    }

    @Override // ti6.e
    public final void n() {
        oi6.d r100 = this.f255295a.s();
        if (r100 == null) goto L6;
        oi6.c.c(r100, new AndroidWaterMarkManager$removeAllWaterMarks$1(this), "removeAllWaterMarks");
        return;
    }

    @Override // ti6.e
    public final void o() {
        oi6.d r100 = this.f255295a.s();
        if (r100 == null) goto L6;
        oi6.c.c(r100, new AndroidWaterMarkManager$composeCurrentWaterMarks$1(this), "composeCurrentWaterMarks");
        return;
    }

    @Override // ti6.e
    public final void release() {
        this.f255296b.clear();
    }

    @Override // ti6.e
    public final HashMap<String, RTCWaterMarkRegion> c() {
        return this.f255296b;
    }

    public AndroidWaterMarkManager(ei6.a r100) {
        Intrinsics.checkNotNullParameter(r100, "service");
        this.f255295a = r100;
        this.f255296b = new HashMap();
    }

    public static boolean d(RTCWaterMarkRegion r100) {
        double r101 = r100.f255235a;
        if (r101 >= AudioStats.AUDIO_AMPLITUDE_NONE) goto L5;
    L33:
        return false;
    L5:
        if (r101 > 1.0d) goto L33;
        double r102 = r100.f255236b;
        if (r102 < AudioStats.AUDIO_AMPLITUDE_NONE) goto L33;
        if (r102 > 1.0d) goto L33;
        double r103 = r100.f255237c;
        if (r103 < AudioStats.AUDIO_AMPLITUDE_NONE) goto L33;
        if (r103 > 1.0d) goto L33;
        double r104 = r100.f255238d;
        if (r104 < AudioStats.AUDIO_AMPLITUDE_NONE) goto L33;
        if (r104 > 1.0d) goto L33;
        double r105 = r100.f255240f;
        if (r105 < AudioStats.AUDIO_AMPLITUDE_NONE) goto L33;
        if (r105 > 1.0d) goto L33;
        int r106 = r100.f255239e;
        if (r106 < 0) goto L33;
        if (r106 > 100) goto L33;
        Object r107 = r100.f255242h;
        if (r107 != null) goto L31;
    L32:
        return true;
    L31:
        if (((Bitmap) r107).getConfig() != Bitmap.Config.ARGB_8888) goto L33;
        goto L32
    }

    @Override // ti6.e
    public final int k(final String r100) {
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L12;
        ej6.a.b("AndroidWaterMarkManager", "removeWaterMarkWithId region param error, waterMarkId invalid");
        return -1;
    L12:
        oi6.d r102 = this.f255295a.s();
        if (r102 == null) goto L15;
        oi6.c.c(r102, new AndroidWaterMarkManager$removeWaterMarkWithId$1(this, r100), "removeWaterMarkWithId " + r100);
    L15:
        return 0;
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L9
    }

    @Override // ti6.e
    public final int a(final String r100, final RTCWaterMarkRegion r101) {
        Intrinsics.checkNotNullParameter(r100, "waterMarkId");
        Intrinsics.checkNotNullParameter(r101, EffectConfiguration.KEY_REGION);
        if (r100.length() != 0) goto L5;
        boolean r102 = true;
    L7:
        if (r102 == false) goto L11;
        ej6.a.d("AndroidWaterMarkManager", "addWaterMarkWithId waterMarkId param error, waterMarkId is null or empty");
        return -1;
    L11:
        if (d(r101) == true) goto L14;
        int r103 = ej6.a.f472874a;
        ej6.a.d("AndroidWaterMarkManager", "addWaterMarkWithId region param error, region: " + r101);
        return -1;
    L14:
        oi6.d r104 = this.f255295a.s();
        if (r104 == null) goto L17;
        oi6.c.c(r104, new AndroidWaterMarkManager$addWaterMarkWithId$1(this, r101, r100), "addWaterMarkWithId ".concat(r100));
    L17:
        return 0;
    L5:
        r102 = false;
        goto L7
    }

    @Override // ti6.e
    public final int b(final String r100, final RTCWaterMarkRegion r101) {
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L10:
        if (r102 == false) goto L14;
        ej6.a.b("AndroidWaterMarkManager", "updateWaterMarkWithId region param error, waterMarkId invalid");
        return -1;
    L14:
        if (d(r101) == true) goto L17;
        int r103 = ej6.a.f472874a;
        ej6.a.b("AndroidWaterMarkManager", "updateWaterMarkWithId region param error, region: " + r101);
        return -1;
    L17:
        oi6.d r104 = this.f255295a.s();
        if (r104 == null) goto L20;
        oi6.c.c(r104, new AndroidWaterMarkManager$updateWaterMarkWithId$1(this, r101, r100), "updateWaterMarkWithId " + r100);
    L20:
        return 0;
    L5:
        if (r100.length() == 0) goto L8;
        r102 = false;
        goto L10
    }
}
