package com.bytedance.android.shopping.anchorv4.voavhs.blur;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class f {
    public static int f;
    public static final a g = null;
    public Bitmap a;
    public final Lazy b;
    public final Context c;
    public final float d;
    public final float e;

    public static final class a {
        public a() {
        }

        public static e b(Context r7) {
            Intrinsics.checkNotNullParameter(r7, "context");
            if (f.f != 0) goto L8;
            com.bytedance.android.shopping.anchorv4.voavhs.blur.a r0 = new com.bytedance.android.shopping.anchorv4.voavhs.blur.a();     // Catch: Throwable -> L6
            Bitmap r4 = Bitmap.createBitmap(4, 4, Bitmap.Config.ARGB_8888);     // Catch: Throwable -> L6
            r0.a(r7, r4, 4.0f);     // Catch: Throwable -> L6
            r0.release();     // Catch: Throwable -> L6
            r4.recycle();     // Catch: Throwable -> L6
            f.f = 3;     // Catch: Throwable -> L6
        L8:
            if (f.f != 0) goto L13;
            ClassLoader r1 = a.class.getClassLoader();     // Catch: Throwable -> L11
            Intrinsics.checkNotNull(r1);     // Catch: Throwable -> L11
            a(r1, "androidx.renderscript.RenderScript");     // Catch: Throwable -> L11
            b r2 = new b();     // Catch: Throwable -> L11
            Bitmap r5 = Bitmap.createBitmap(4, 4, Bitmap.Config.ARGB_8888);     // Catch: Throwable -> L11
            r2.a(r7, r5, 4.0f);     // Catch: Throwable -> L11
            r2.release();     // Catch: Throwable -> L11
            r5.recycle();     // Catch: Throwable -> L11
            f.f = 1;     // Catch: Throwable -> L11
        L13:
            if (f.f != 0) goto L18;
            ClassLoader r3 = a.class.getClassLoader();     // Catch: Throwable -> L16
            Intrinsics.checkNotNull(r3);     // Catch: Throwable -> L16
            a(r3, "android.support.v8.renderscript.RenderScript");     // Catch: Throwable -> L16
            h r6 = new h();     // Catch: Throwable -> L16
            Bitmap r8 = Bitmap.createBitmap(4, 4, Bitmap.Config.ARGB_8888);     // Catch: Throwable -> L16
            r6.a(r7, r8, 4.0f);     // Catch: Throwable -> L16
            r6.release();     // Catch: Throwable -> L16
            r8.recycle();     // Catch: Throwable -> L16
            f.f = 2;     // Catch: Throwable -> L16
        L18:
            if (f.f != 0) goto L20;
            f.f = -1;
        L20:
            int r9 = f.f;
            if (r9 == 1) goto L28;
            if (r9 == 2) goto L37;
            if (r9 == 3) goto L36;
            return new g();
        L36:
            return new com.bytedance.android.shopping.anchorv4.voavhs.blur.a();
        L37:
            return new h();
        L28:
            return new b();
        }

        @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.mira.core.opt.res+"})
        public static void a(ClassLoader r2, String r3) throws ClassNotFoundException {
            ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
            FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
            if (el9.a.a() == true) goto L34;
            r2.loadClass(r3);     // Catch: Throwable -> L8
            if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L36;
            FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L8
            return;
        L36:
            return;
        L8:
            th = move-exception;
            if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
            FastClassNotFoundHandler.b(r3);
        L12:
            throw th;
        L34:
            r2.loadClass(r3);     // Catch: Throwable -> L17
            if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L37;
            FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L17
            return;
        L37:
            return;
        L17:
            th = move-exception;
            if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
            FastClassNotFoundHandler.b(r3);
        L22:
            if ((th instanceof PluginClassNotFoundException) == false) goto L24;
            throw th;
        L24:
            if ((th instanceof ClassNotFoundException) == false) goto L26;
        L29:
            MiraPluginFix.loadClass(r3);
            return;
        L26:
            if ((th instanceof NoClassDefFoundError) == true) goto L29;
            throw th;
        }
    }

    static {
        g = new a();
    }

    public final Context getContext() {
        return this.c;
    }

    public f(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.c = r2;
        this.d = 12.5f;
        this.e = 8.0f;
        this.b = LazyKt.lazy(new BlurManager$blurImpl$2(this));
    }

    public final void d(boolean r1) {
        if (r1 == false) goto L6;
        Bitmap r2 = this.a;
        if (r2 == null) goto L6;
        r2.recycle();
        this.a = null;
    L6:
        ((e) this.b.getValue()).release();
    }

    public static /* synthetic */ Bitmap b(f r7, Bitmap r8, int r9, int r10, Integer r11, int r12) {
        if ((r12 & 16) == 0) goto L6;
        r11 = null;
    L6:
        return r7.a(r8, r9, r10, 1.0f, r11, null);
    }

    public final Bitmap a(Bitmap r2, int r3, int r4, float r5, Integer r6, d r7) {
        Intrinsics.checkNotNullParameter(r2, "bitmapToBlur");
        Bitmap r8 = c(r2, r3, r4, r5, r6, r7);     // Catch: Exception -> L5
        ((e) this.b.getValue()).b(r8, r8);     // Catch: Exception -> L5
        d(false);     // Catch: Exception -> L5
        this.a = r8;     // Catch: Exception -> L5
        return r8;
    L5:
        e = move-exception;
        ECExceptionMonitor.e(e);
        d(true);
        return null;
    }

    public final Bitmap c(Bitmap r15, int r16, int r17, float r18, Integer r19, d r20) {
        Float r2 = Float.valueOf(this.e);
        float r5 = 0;
        if (r2.floatValue() <= r5) goto L5;
        boolean r3 = true;
    L7:
        if (r3 == true) goto L10;
        r2 = null;
    L10:
        if (r2 == null) goto L12;
        float r4 = r2.floatValue();
    L13:
        float r6 = this.d;
        if (r6 <= 25) goto L16;
        r6 = 25.0f;
    L16:
        int r9 = r16;
        if (r4 == 0.0f) goto L19;
        r9 = RangesKt.coerceAtLeast(1, (int) (r9 / r4));
    L19:
        if (r4 == 0.0f) goto L21;
        int r7 = RangesKt.coerceAtLeast(1, (int) (r17 / r4));
    L22:
        Bitmap r8 = Bitmap.createBitmap(r9, r7, Bitmap.Config.ARGB_8888);
        Canvas r10 = new Canvas(r8);
        Rect r11 = new Rect(0, 0, r15.getWidth(), r15.getHeight());
        float r12 = 1;
        if (r18 < r12) goto L25;
    L27:
        if (r20 == null) goto L29;
        r11.left += r20.a;
        r11.top += r20.b;
        r11.right -= r20.c;
        r11.bottom -= r20.d;
    L29:
        Unit r1 = Unit.INSTANCE;
        r10.drawBitmap(r15, r11, new Rect(0, 0, r9, r7), null);
        if (r19 == null) goto L32;
        r10.drawColor(r19.intValue());
    L32:
        ((e) this.b.getValue()).a(this.c, r8, r6);
        return r8;
    L25:
        if (r18 <= r5) goto L27;
        float r13 = r12 - r18;
        float r14 = 2;
        r11.inset((int) ((r15.getWidth() * r13) / r14), (int) ((r15.getHeight() * r13) / r14));
        goto L29
    L21:
        r7 = r17;
        goto L22
    L12:
        r4 = 4.0f;
        goto L13
    L5:
        r3 = false;
        goto L7
    }
}
