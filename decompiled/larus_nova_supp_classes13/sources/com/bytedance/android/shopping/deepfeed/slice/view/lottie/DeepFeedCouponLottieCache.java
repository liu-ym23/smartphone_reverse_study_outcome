package com.bytedance.android.shopping.deepfeed.slice.view.lottie;

import android.content.Context;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.t;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class DeepFeedCouponLottieCache {
    public static final DeepFeedCouponLottieCache a = null;

    public static final class a implements Runnable {
    }

    public DeepFeedCouponLottieCache() {
    }

    static {
        a = new DeepFeedCouponLottieCache();
    }

    public static PolarisFileWrapper b(String r10) {
        Context r0 = ECAppInfoService.e.getApplicationContext();
        String r1 = null;
        if (r0 != null) goto L24;
        return null;
    L24:
        byte[] r2 = r10.getBytes();     // Catch: Exception -> L15
        MessageDigest r3 = MessageDigest.getInstance("MD5");     // Catch: Exception -> L12
        r3.update(r2);     // Catch: Exception -> L12
        byte[] r4 = r3.digest();     // Catch: Exception -> L12
        char[] r5 = new char[32];     // Catch: Exception -> L12
        int r6 = 0;
        int r7 = 0;
    L8:
        if (r6 >= 16) goto L10;
        byte r8 = r4[r6];     // Catch: Exception -> L12
        int r9 = r7 + 1;     // Catch: Exception -> L12
        char[] r11 = t.a;     // Catch: Exception -> L12
        r5[r7] = r11[(r8 >>> 4) & 15];     // Catch: Exception -> L12
        r7 = r9 + 1;     // Catch: Exception -> L12
        r5[r9] = r11[r8 & 15];     // Catch: Exception -> L12
        r6 = r6 + 1;     // Catch: Exception -> L12
        goto L8
    L10:
        r1 = new String(r5);     // Catch: Exception -> L12
    L17:
        if (r1 != null) goto L20;
        r1 = "";
    L20:
        if (StringsKt.isBlank(r1) == false) goto L23;
        r1 = String.valueOf(r10.hashCode());
    L23:
        return new PolarisFileWrapper(r0.getCacheDir(), "deep_feed_coupon_lottie/" + r1 + ".json");
    L12:
        e = move-exception;
        ECExceptionMonitor.e(e);     // Catch: Exception -> L15
    L15:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L17
    }

    public static void c(List r6) {
        Intrinsics.checkNotNullParameter(r6, "urls");
        Iterator r7 = SequencesKt.distinct(SequencesKt.filter(SequencesKt.map(CollectionsKt.asSequence(r6), DeepFeedCouponLottieCache$deleteCachedFiles$1.INSTANCE), DeepFeedCouponLottieCache$deleteCachedFiles$2.INSTANCE)).iterator();
    L4:
        if (r7.hasNext() == false) goto L20;
        String r2 = (String) r7.next();
        DeepFeedCouponLottieCache r3 = a;
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L18
        r3.getClass();     // Catch: Throwable -> L18
        int r5 = ed3.b.a;     // Catch: Throwable -> L18
        Intrinsics.checkNotNullParameter(r2, "key");     // Catch: Throwable -> L18
        Intrinsics.checkNotNullParameter("", "default");     // Catch: Throwable -> L18
        File r8 = null;
        if (StringsKt.isBlank("") == false) goto L9;
        File r9 = null;
    L10:
        if (r9 != null) goto L12;
    L16:
        Intrinsics.checkNotNullParameter(r2, "key");     // Catch: Throwable -> L18
        Intrinsics.checkNotNullParameter("", "value");     // Catch: Throwable -> L18
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L18
        goto L4
    L12:
        if (r9.exists() == false) goto L14;
        r8 = r9;
    L14:
        if (r8 == null) goto L16;
        r8.delete();     // Catch: Throwable -> L18
        goto L16
    L9:
        r9 = new PolarisFileWrapper("");     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L4
    }

    public static void d(List r3) {
        Intrinsics.checkNotNullParameter(r3, "urls");
        Iterator r4 = SequencesKt.distinct(SequencesKt.filter(SequencesKt.map(CollectionsKt.asSequence(r3), DeepFeedCouponLottieCache$preload$1.INSTANCE), DeepFeedCouponLottieCache$preload$2.INSTANCE)).iterator();
    L4:
        if (r4.hasNext() == false) goto L14;
        final String r0 = (String) r4.next();
        a.getClass();
        int r1 = ed3.b.a;
        Intrinsics.checkNotNullParameter(r0, "key");
        Intrinsics.checkNotNullParameter("", "default");
        if (StringsKt.isBlank("") == false) goto L8;
        File r2 = null;
    L9:
        if (r2 == null) goto L13;
        if (r2.exists() == true) goto L4;
    L13:
        int r5 = DeepFeedLottieUrlLoader.a;
        DeepFeedLottieUrlLoader.b(r0, new DeepFeedCouponLottieCache$preload$3$1(r0), DeepFeedCouponLottieCache$preload$3$2.INSTANCE);
        goto L4
    L8:
        r2 = new PolarisFileWrapper("");
        goto L9
    }

    public static final void a(DeepFeedCouponLottieCache r1, String r2, String r3) {
        r1.getClass();
        if (StringsKt.isBlank(r3) == true) goto L19;
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L13
        PolarisFileWrapper r5 = b(r2);     // Catch: Throwable -> L13
        if (r5 == null) goto L18;
        File r0 = r5.getParentFile();     // Catch: Throwable -> L13
        if (r0 == null) goto L11;
        r0.mkdirs();     // Catch: Throwable -> L13
    L11:
        FilesKt.writeText(r5, r3, StandardCharsets.UTF_8);     // Catch: Throwable -> L13
        int r6 = ed3.b.a;     // Catch: Throwable -> L13
        String r7 = r5.getAbsolutePath();     // Catch: Throwable -> L13
        Intrinsics.checkNotNullParameter(r2, "key");     // Catch: Throwable -> L13
        Intrinsics.checkNotNullParameter(r7, "value");     // Catch: Throwable -> L13
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L13
        return;
    L18:
        return;
    L13:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        return;
    }
}
