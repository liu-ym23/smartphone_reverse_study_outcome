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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class OnlineSmallEmojiCache {
    public static final /* synthetic */ int d = 0;
    public final OnlineSmallEmojiResInfo a;
    public final Lazy b;
    public final Lazy c;

    public static final class a {
    }

    static {
    }

    public OnlineSmallEmojiCache(OnlineSmallEmojiResInfo r1) {
        this.a = r1;
        this.b = LazyKt.lazy(OnlineSmallEmojiCache$lruCache$2.INSTANCE);
        this.c = LazyKt.lazy(OnlineSmallEmojiCache$weakRefCache$2.INSTANCE);
    }

    public final Bitmap a(String r17) {
        d r0 = d.a;
        String r1 = this.a.getPicFileDirPath();
        Intrinsics.checkNotNullParameter(r1, "picFileDirPath");
        Intrinsics.checkNotNullParameter(r17, "picFileName");
        boolean r3 = true;
        final List r4 = CollectionsKt.mutableListOf(new String[]{r17});
        Bitmap r7 = null;
        if (r4.isEmpty() == false) goto L5;
        r4.toString();
    L54:
        LinkedHashMap r8 = null;
    L55:
        if (r8 != null) goto L57;
    L69:
        if (r7 == null) goto L77;
        monitor-enter(this);
        ((LruCache) this.b.getValue()).put(r17, r7);     // Catch: Throwable -> L74
        monitor-exit(this);
    L74:
        th = move-exception;
        throw th;
    L77:
        return r7;
    L57:
        if (r8.size() == 1) goto L60;
        r3 = false;
    L60:
        if (r3 == true) goto L63;
        r8 = null;
    L63:
        if (r8 == null) goto L69;
        ArrayList r2 = new ArrayList(r8.size());
        Iterator r5 = r8.entrySet().iterator();
    L66:
        if (r5.hasNext() == false) goto L68;
        r2.add((Bitmap) ((Map.Entry) r5.next()).getValue());
        goto L66
    L68:
        r7 = (Bitmap) ListProtector.get(r2, 0);
        goto L69
    L5:
        PolarisFileWrapper r6 = new PolarisFileWrapper(r1);
        if (r6.exists() == true) goto L8;
    L53:
        r4.toString();
        goto L54
    L8:
        if (r6.isDirectory() == false) goto L53;
        File[] r9 = r6.listFiles(new c(r4));
        if (r9 != null) goto L13;
    L19:
        boolean r10 = true;
    L20:
        if (r10 == false) goto L22;
        r4.toString();
        goto L54
    L22:
        r8 = new LinkedHashMap();
        int r11 = r9.length;
        int r12 = 0;
    L23:
        if (r12 >= r11) goto L55;
        File r13 = r9[r12];
        int r14 = d.c;
        BitmapFactory.Options r15 = new BitmapFactory.Options();     // Catch: Exception -> L46
        r15.inJustDecodeBounds = true;     // Catch: Exception -> L46
        PolarisFileInputStreamWrapper r16 = new PolarisFileInputStreamWrapper(r13);     // Catch: Exception -> L46
        BitmapFactory.decodeStream(r16, null, r15);     // Catch: Exception -> L46
        r16.close();     // Catch: Exception -> L46
        if (r15.outWidth > 0) goto L28;
    L44:
        r13.delete();     // Catch: Exception -> L46
        Bitmap r18 = null;
    L49:
        if (r18 == null) goto L51;
        r8.put(r13.getName(), r18);
    L52:
        r12 = r12 + 1;
        goto L23
    L51:
        r13.getName();
        r4.toString();
        goto L52
    L28:
        if (r15.outHeight <= 0) goto L44;
        int r19 = 1;
    L31:
        int r110 = r15.outWidth;     // Catch: Exception -> L46
        if (r110 < (r14 * 2)) goto L37;
        int r111 = r15.outHeight;     // Catch: Exception -> L46
        if (r111 < 4000) goto L37;
        r15.outWidth = r110 / 2;     // Catch: Exception -> L46
        r15.outHeight = r111 / 2;     // Catch: Exception -> L46
        r19 = r19 * 2;     // Catch: Exception -> L46
    L37:
        BitmapFactory.Options r20 = new BitmapFactory.Options();     // Catch: Exception -> L46
        r20.inSampleSize = r19;     // Catch: Exception -> L46
        r20.inPurgeable = true;     // Catch: Exception -> L46
        r20.inPreferredConfig = Bitmap.Config.RGB_565;     // Catch: Exception -> L46
        PolarisFileInputStreamWrapper r21 = new PolarisFileInputStreamWrapper(r13);     // Catch: Exception -> L46
        r18 = BitmapFactory.decodeStream(r21, null, r20);     // Catch: Exception -> L46
        r21.close();     // Catch: Exception -> L42
        if (r18 != null) goto L49;
        r13.delete();     // Catch: Exception -> L42
    L42:
        e = e;
    L48:
        e.printStackTrace();
    L46:
        e = e;
        r18 = null;
        goto L48
    L13:
        if (r9.length != 0) goto L15;
        boolean r22 = true;
    L16:
        if (r22 == true) goto L19;
        r10 = false;
        goto L20
    L15:
        r22 = false;
        goto L16
    }

    public final Bitmap b(String r2, boolean r3) {
        if (r2 == null) goto L13;
        monitor-enter(this);
        Bitmap r0 = (Bitmap) ((LruCache) this.b.getValue()).get(r2);     // Catch: Throwable -> L10
        monitor-exit(this);
        if (r0 != null) goto L18;
        if (r3 == false) goto L13;
        return a(r2);
    L18:
        return r0;
    L10:
        th = move-exception;
        throw th;
    L13:
        return null;
    }
}
