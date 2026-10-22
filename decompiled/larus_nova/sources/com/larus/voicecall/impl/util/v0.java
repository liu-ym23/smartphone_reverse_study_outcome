package com.larus.voicecall.impl.util;

import android.graphics.BitmapFactory;
import com.larus.utils.logger.FLogger;
import com.ss.ttm.player.MediaPlayer;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes32.dex */
public final class v0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f379491a = null;

    static {
        f379491a = LazyKt.lazy(new u0());
    }

    public static final Pair<Integer, Integer> a(x3a.a r100) {
        float r101 = r100.f562406c * 1.0f;
        float r102 = r100.f562405b;
        float r103 = r101 / r102;
        float r104 = Math.min(((r102 * 1.0f) * MediaPlayer.MEDIA_PLAYER_OPTION_PREPARE_CACHE_MS) / MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_MAX_CRYPTO_RETRANSMISSION_TIME_MS, ((Number) f379491a.getValue()).floatValue());
        if (r103 <= 5.0f) goto L7;
        FLogger.f375446a.d("RealtimeSubtitleImageHelper", "generatePhotoWH h:w=[5:1] maxLimit=" + r104);
        return new Pair(Integer.valueOf((int) (r104 / 5.0f)), Integer.valueOf((int) r104));
    L7:
        if (r103 >= 0.2f) goto L11;
        FLogger.f375446a.d("RealtimeSubtitleImageHelper", "generatePhotoWH h:w=[1:5] ");
        return new Pair(Integer.valueOf((int) r104), Integer.valueOf((int) (r104 / 5.0f)));
    L11:
        if (r103 >= 1.0f) goto L13;
        FLogger.f375446a.d("RealtimeSubtitleImageHelper", "generatePhotoWH h:w=[" + r103 + ":1] ");
        return new Pair(Integer.valueOf((int) r104), Integer.valueOf((int) (r103 * r104)));
    L13:
        return new Pair(Integer.valueOf((int) (r104 / r103)), Integer.valueOf((int) r104));
    }

    public static final x3a.a b(ic8.m0 r110, int r111) {
        Intrinsics.checkNotNullParameter(r110, "<this>");
        String r100 = r110.f489227e;
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == true) goto L11;
        BitmapFactory.Options r102 = new BitmapFactory.Options();     // Catch: Throwable -> L22
        r102.inJustDecodeBounds = true;     // Catch: Throwable -> L22
        BitmapFactory.decodeFile(r110.f489227e, r102);     // Catch: Throwable -> L22
        int r103 = r102.outWidth;     // Catch: Throwable -> L22
        int r104 = r102.outHeight;     // Catch: Throwable -> L22
        String r105 = r110.f489227e;     // Catch: Throwable -> L22
        String r106 = "";
        if (r105 != null) goto L16;
        r105 = "";
    L16:
        int r107 = StringsKt.lastIndexOf$default(r105, ".", 0, false, 6, null);     // Catch: Throwable -> L22
        if (r107 == (-1)) goto L20;
        r106 = r105.substring(r107);     // Catch: Throwable -> L22
    L20:
        x3a.a r108 = new x3a.a(r110, r103, r104, r111, UUID.randomUUID() + r106);     // Catch: Throwable -> L22
        r108.f562411h = a(r108);     // Catch: Throwable -> L22
        return r108;
    L22:
        th = move-exception;
        FLogger.f375446a.e("RealtimeSubtitleImageHelper", "ProcessFileInfo.wrap() err=" + th);
        return new x3a.a(r110, r111);
    L11:
        return new x3a.a(r110, r111);
    L5:
        if (StringsKt.isBlank(r100) == true) goto L8;
        r101 = false;
        goto L9
    }
}
