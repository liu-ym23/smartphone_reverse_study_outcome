package com.obric.assistant.cocreationreview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Build;
import android.util.LruCache;
import android.widget.ImageView;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes32.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ExecutorService f387634a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f387635b = null;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f387636a = null;

        static {
            int[] r100 = new int[FeedbackMediaType.values().length];
            r100[FeedbackMediaType.IMAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[FeedbackMediaType.VIDEO.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f387636a = r100;
        }
    }

    public static final class b extends LruCache<String, Bitmap> {
        public b(int r100) {
            super(r100);
        }

        @Override // android.util.LruCache
        public final int sizeOf(String r100, Bitmap r101) {
            Bitmap r102 = r101;
            Intrinsics.checkNotNullParameter(r100, "key");
            Intrinsics.checkNotNullParameter(r102, "value");
            return RangesKt.coerceAtLeast(r102.getByteCount() / 1024, 1);
        }
    }

    static {
        f387634a = PThreadExecutorsUtils.newFixedThreadPool(2, new DefaultThreadFactory("CocreationFeedbackMediaThumbnailLoader"));
        f387635b = new b(RangesKt.coerceAtLeast((int) ((Runtime.getRuntime().maxMemory() / ((long) 1024)) / ((long) 16)), 4096));
    }

    public static Bitmap b(MediaMetadataRetriever r100, int r101) {
        if (Build.VERSION.SDK_INT >= 27) goto L5;
        Bitmap r102 = r100.getFrameAtTime(0, 2);
        if (r102 == null) goto L16;
        int r103 = Math.max(r102.getWidth(), r102.getHeight());
        if (r103 <= r101) goto L18;
        if (r103 <= 0) goto L20;
        float r104 = r101 / r103;
        Bitmap r105 = Bitmap.createScaledBitmap(r102, RangesKt.coerceAtLeast((int) (r102.getWidth() * r104), 1), RangesKt.coerceAtLeast((int) (r102.getHeight() * r104), 1), true);
        if (r105 == r102) goto L19;
        r102.recycle();
    L19:
        return r105;
    L20:
        return r102;
    L18:
        return r102;
    L16:
        return null;
    L5:
        return r100.getScaledFrameAtTime(0, 2, r101, r101);
    }

    public static Bitmap a(Context r100, Uri r101, int r102) {
        BitmapFactory.Options r103 = new BitmapFactory.Options();
        int r104 = 1;
        r103.inJustDecodeBounds = true;
        InputStream r105 = ContentResolverWrapper.openInputStream(r100.getContentResolver(), r101);
        BitmapFactory.decodeStream(r105, null, r103);     // Catch: Throwable -> L21
        CloseableKt.closeFinally(r105, null);
        BitmapFactory.Options r106 = new BitmapFactory.Options();
    L5:
        int r107 = r102 * 2;
        if ((r103.outWidth / r104) > r107) goto L20;
        if ((r103.outHeight / r104) > r107) goto L20;
        r106.inSampleSize = r104;
        InputStream r108 = ContentResolverWrapper.openInputStream(r100.getContentResolver(), r101);
        if (r108 != null) goto L32;
        return null;
    L32:
        Bitmap r109 = BitmapFactory.decodeStream(r108, null, r106);     // Catch: Throwable -> L14
        CloseableKt.closeFinally(r108, null);
        return r109;
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        CloseableKt.closeFinally(r108, th);
        throw th;
    L20:
        r104 = r104 * 2;
    L21:
        th = move-exception;
        throw th;     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        CloseableKt.closeFinally(r105, th);
        throw th;
    }

    public static void c(final ImageView r110, final b5 r111, final int r112) {
        Intrinsics.checkNotNullParameter(r110, "imageView");
        Intrinsics.checkNotNullParameter(r111, "media");
        final String r100 = CollectionsKt.joinToString$default(CollectionsKt.listOf(new Object[]{r111.getType().name(), r111.f387199b, Integer.valueOf(r112)}), HiAnalyticsConstant.REPORT_VAL_SEPARATOR, null, null, 0, null, null, 62, null);
        r110.setTag(r100);
        Bitmap r101 = f387635b.get(r100);
        if (r101 == null) goto L6;
        r110.setImageBitmap(r101);
        return;
    L6:
        f387634a.execute(new n(r100, r110, r111, r112));
    }

    public static Bitmap d(b5 r100, Uri r101, int r102) {
        String r103 = r101.getPath();
        if (r103 != null) goto L5;
        r103 = r100.f387199b;
    L5:
        FeedbackMediaType r104 = r100.getType();
        int r105 = a.f387636a[r104.ordinal()];
        int r106 = 1;
        if (r105 == 1) goto L16;
        if (r105 != 2) goto L15;
        MediaMetadataRetriever r107 = new MediaMetadataRetriever();
        r107.setDataSource(r103);     // Catch: Throwable -> L11
        Bitmap r108 = b(r107, r102);     // Catch: Throwable -> L11
        r107.release();
        return r108;
    L11:
        th = move-exception;
        r107.release();
        throw th;
    L15:
        throw new NoWhenBranchMatchedException();
    L16:
        BitmapFactory.Options r109 = new BitmapFactory.Options();
        r109.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(r103, r109);
        BitmapFactory.Options r110 = new BitmapFactory.Options();
    L17:
        int r111 = r102 * 2;
        if ((r109.outWidth / r106) > r111) goto L24;
        if ((r109.outHeight / r106) > r111) goto L24;
        r110.inSampleSize = r106;
        return BitmapFactory.decodeFile(r103, r110);
    L24:
        r106 = r106 * 2;
        goto L17
    }
}
