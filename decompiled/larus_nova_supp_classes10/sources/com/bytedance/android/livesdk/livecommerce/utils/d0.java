package com.bytedance.android.livesdk.livecommerce.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import java.io.File;
import java.util.Comparator;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class d0<T> implements ObservableOnSubscribe {
    public final /* synthetic */ f0 a;
    public final /* synthetic */ String b;

    public static final class a<T> implements Comparator<T> {
        public a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r3, T r4) {
            return ComparisonsKt.compareValues(Long.valueOf(((File) r4).lastModified()), Long.valueOf(((File) r3).lastModified()));
        }
    }

    public d0(f0 r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void subscribe(ObservableEmitter<String> r13) {
        Intrinsics.checkNotNullParameter(r13, "emitter");
        File[] r2 = new PolarisFileWrapper(this.b).listFiles();     // Catch: Exception -> L43
        if (r2 == null) goto L6;
        List r3 = ArraysKt.sortedWith(r2, new a());     // Catch: Exception -> L43
    L7:
        if (r3 == null) goto L42;
        if ((!r3.isEmpty()) == false) goto L42;
        if (((File) ListProtector.get(r3, 0)).isFile() == false) goto L42;
        String r0 = ((File) ListProtector.get(r3, 0)).getPath();     // Catch: Exception -> L43
        int r4 = g0.a;     // Catch: Exception -> L43
        long r5 = new PolarisFileWrapper(r0).length();     // Catch: Exception -> L43
        long r6 = System.currentTimeMillis();     // Catch: Exception -> L43
    L13:
        Thread.sleep(300);     // Catch: Exception -> L43
        long r7 = new PolarisFileWrapper(r0).length();     // Catch: Exception -> L43
        if (r5 == r7) goto L18;
        if ((System.currentTimeMillis() - r6) > 15000) goto L18;
        r5 = r7;
    L18:
        System.currentTimeMillis();     // Catch: Exception -> L43
        Bitmap r8 = BitmapFactory.decodeFile(r0);     // Catch: Exception -> L43
        int r9 = g0.a;     // Catch: Exception -> L43
        int r10 = r8.getWidth() - 1;     // Catch: Exception -> L43
        if (r10 <= 0) goto L36;
        int r11 = r8.getWidth();     // Catch: Exception -> L43
        int r12 = r8.getHeight();     // Catch: Exception -> L43
        if (r11 <= r10) goto L37;
        if (r12 <= r10) goto L37;
        int r14 = (Math.max(r11, r12) * r10) / Math.min(r11, r12);     // Catch: Exception -> L43
        if (r11 <= r12) goto L27;
        int r15 = r14;
    L28:
        if (r11 <= r12) goto L47;
        r14 = r10;
    L47:
        Bitmap r16 = Bitmap.createScaledBitmap(r8, r15, r14, true);     // Catch: Exception -> L35
        Bitmap r17 = Bitmap.createBitmap(r16, (r15 - r10) / 2, (r14 - r10) / 2, r10, r10);     // Catch: Exception -> L35
        r16.recycle();     // Catch: Exception -> L35
        r8 = r17;
        goto L37
    L27:
        r15 = r10;
    L37:
        if (r8 == null) goto L39;
        g0.a(r0, r8);     // Catch: Exception -> L43
    L39:
        r13.onNext(r0);     // Catch: Exception -> L43
        return;
    L36:
        r8 = null;
    L42:
        throw new RuntimeException("folder has no image , path：" + this.b);     // Catch: Exception -> L43
    L6:
        r3 = null;
    L43:
        e = move-exception;
        ECExceptionMonitor.e(e);
        this.a.b.invoke(null, "folder has no image");
    }
}
