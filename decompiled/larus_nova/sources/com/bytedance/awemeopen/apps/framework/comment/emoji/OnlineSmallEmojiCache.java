package com.bytedance.awemeopen.apps.framework.comment.emoji;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.LruCache;
import com.bytedance.awemeopen.apps.framework.comment.emoji.model.OnlineSmallEmojiResInfo;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class OnlineSmallEmojiCache {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f194140d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OnlineSmallEmojiResInfo f194141a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f194142b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f194143c;

    public static final class a {
    }

    static {
    }

    public OnlineSmallEmojiCache(OnlineSmallEmojiResInfo r100) {
        this.f194141a = r100;
        this.f194142b = LazyKt.lazy(OnlineSmallEmojiCache$lruCache$2.INSTANCE);
        this.f194143c = LazyKt.lazy(OnlineSmallEmojiCache$weakRefCache$2.INSTANCE);
    }

    public final Bitmap a(String r110) {
        d r100 = d.f194160a;
        String r101 = this.f194141a.getPicFileDirPath();
        Intrinsics.checkNotNullParameter(r101, "picFileDirPath");
        Intrinsics.checkNotNullParameter(r110, "picFileName");
        boolean r102 = true;
        final List r103 = CollectionsKt.mutableListOf(new String[]{r110});
        Bitmap r104 = null;
        if (r103.isEmpty() == false) goto L5;
        r103.toString();
    L54:
        LinkedHashMap r105 = null;
    L55:
        if (r105 != null) goto L57;
    L69:
        if (r104 == null) goto L77;
        monitor-enter(this);
        ((LruCache) this.f194142b.getValue()).put(r110, r104);     // Catch: Throwable -> L74
        monitor-exit(this);
    L74:
        th = move-exception;
        throw th;
    L77:
        return r104;
    L57:
        if (r105.size() == 1) goto L60;
        r102 = false;
    L60:
        if (r102 == true) goto L63;
        r105 = null;
    L63:
        if (r105 == null) goto L69;
        ArrayList r106 = new ArrayList(r105.size());
        Iterator r107 = r105.entrySet().iterator();
    L66:
        if (r107.hasNext() == false) goto L68;
        r106.add((Bitmap) ((Map.Entry) r107.next()).getValue());
        goto L66
    L68:
        r104 = (Bitmap) ListProtector.get(r106, 0);
        goto L69
    L5:
        PolarisFileWrapper r108 = new PolarisFileWrapper(r101);
        if (r108.exists() == true) goto L8;
    L53:
        r103.toString();
        goto L54
    L8:
        if (r108.isDirectory() == false) goto L53;
        File[] r109 = r108.listFiles(new c(r103));
        if (r109 != null) goto L13;
    L19:
        boolean r111 = true;
    L20:
        if (r111 == false) goto L22;
        r103.toString();
        goto L54
    L22:
        r105 = new LinkedHashMap();
        int r112 = r109.length;
        int r113 = 0;
    L23:
        if (r113 >= r112) goto L55;
        File r114 = r109[r113];
        int r115 = d.f194162c;
        BitmapFactory.Options r116 = new BitmapFactory.Options();     // Catch: Exception -> L46
        r116.inJustDecodeBounds = true;     // Catch: Exception -> L46
        PolarisFileInputStreamWrapper r117 = new PolarisFileInputStreamWrapper(r114);     // Catch: Exception -> L46
        BitmapFactory.decodeStream(r117, null, r116);     // Catch: Exception -> L46
        r117.close();     // Catch: Exception -> L46
        if (r116.outWidth > 0) goto L28;
    L44:
        r114.delete();     // Catch: Exception -> L46
        Bitmap r118 = null;
    L49:
        if (r118 == null) goto L51;
        r105.put(r114.getName(), r118);
    L52:
        r113 = r113 + 1;
        goto L23
    L51:
        r114.getName();
        r103.toString();
        goto L52
    L28:
        if (r116.outHeight <= 0) goto L44;
        int r119 = 1;
    L31:
        int r120 = r116.outWidth;     // Catch: Exception -> L46
        if (r120 < (r115 * 2)) goto L37;
        int r121 = r116.outHeight;     // Catch: Exception -> L46
        if (r121 < 4000) goto L37;
        r116.outWidth = r120 / 2;     // Catch: Exception -> L46
        r116.outHeight = r121 / 2;     // Catch: Exception -> L46
        r119 = r119 * 2;     // Catch: Exception -> L46
    L37:
        BitmapFactory.Options r122 = new BitmapFactory.Options();     // Catch: Exception -> L46
        r122.inSampleSize = r119;     // Catch: Exception -> L46
        r122.inPurgeable = true;     // Catch: Exception -> L46
        r122.inPreferredConfig = Bitmap.Config.RGB_565;     // Catch: Exception -> L46
        PolarisFileInputStreamWrapper r123 = new PolarisFileInputStreamWrapper(r114);     // Catch: Exception -> L46
        r118 = BitmapFactory.decodeStream(r123, null, r122);     // Catch: Exception -> L46
        r123.close();     // Catch: Exception -> L42
        if (r118 != null) goto L49;
        r114.delete();     // Catch: Exception -> L42
    L42:
        e = e;
    L48:
        e.printStackTrace();
    L46:
        e = e;
        r118 = null;
        goto L48
    L13:
        if (r109.length != 0) goto L15;
        boolean r124 = true;
    L16:
        if (r124 == true) goto L19;
        r111 = false;
        goto L20
    L15:
        r124 = false;
        goto L16
    }

    public final Bitmap b(String r100, boolean r101) {
        if (r100 == null) goto L13;
        monitor-enter(this);
        Bitmap r102 = (Bitmap) ((LruCache) this.f194142b.getValue()).get(r100);     // Catch: Throwable -> L10
        monitor-exit(this);
        if (r102 != null) goto L18;
        if (r101 == false) goto L13;
        return a(r100);
    L18:
        return r102;
    L10:
        th = move-exception;
        throw th;
    L13:
        return null;
    }
}
