package com.bytedance.awemeopen.apps.framework.utils;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.model.ScaleType;
import com.bytedance.awemeopen.infra.base.image.AoImageView;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class g0 {
    public static final /* synthetic */ int a = 0;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ScaleType.values().length];
            r0[ScaleType.AUTO_MODE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[ScaleType.ALWAYS_FIT_WIDTH.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[ScaleType.CENTER_CROP.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[ScaleType.FIT_CENTER.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    static {
    }

    public static float a(Context r6, r14.c r7) {
        Intrinsics.checkNotNullParameter(r6, "context");
        boolean r1 = false;
        if (r7 == null) goto L20;
        List r2 = r7.v();
        if (r2 == null) goto L7;
        int r3 = r2.size();
    L8:
        if (r3 <= 0) goto L20;
        List r8 = r7.v();
        Intrinsics.checkNotNull(r8);
        Iterator r9 = r8.iterator();
        int r4 = 0;
    L12:
        if (r9.hasNext() == false) goto L19;
        r14.y r5 = (r14.y) r9.next();
        if ((r5.d() * r5.a()) != 0) goto L16;
        int r10 = 0;
    L17:
        if (r10 <= r4) goto L12;
        r4 = r10;
        goto L12
    L16:
        r10 = (r5.a() * d0.d(r6)) / r5.d();
        goto L17
    L19:
        float r11 = r4;
    L22:
        if (r11 != 0.0f) goto L25;
        r1 = true;
    L25:
        if (r1 == true) goto L35;
        if (r11 > ((d0.d(r6) * 4.0f) / 3.0f)) goto L35;
        if (r11 < ((d0.d(r6) * 9.0f) / 16.0f)) goto L32;
        return r11;
    L32:
        return (d0.d(r6) * 9.0f) / 16.0f;
    L35:
        return (d0.d(r6) * 4.0f) / 3.0f;
    L7:
        r3 = 0;
    L20:
        r11 = 0.0f;
        goto L22
    }

    public static boolean b(AoImageView r1, int r2, int r3, int r4, int r5, float r6, ScaleType r7) {
        Intrinsics.checkNotNullParameter(r1, "view");
        Intrinsics.checkNotNullParameter(r7, "scaleType");
        if (r4 <= 0) goto L37;
        if (r5 <= 0) goto L37;
        if (r3 <= 0) goto L37;
        float r8 = (r5 * 1.0f) / (r4 * 1.0f);
        ImageView.ScaleType r9 = ImageView.ScaleType.CENTER_CROP;
        int r10 = a.a[r7.ordinal()];
        if (r10 == 1) goto L23;
        if (r10 != 2) goto L12;
        int r11 = (int) (r3 / r8);
        if (r11 <= r2) goto L21;
        r2 = r11;
    L21:
        r9 = ImageView.ScaleType.FIT_CENTER;
    L32:
        Objects.toString(r9);
        if ((r1 instanceof ImageView) == false) goto L35;
        r1.setScaleType(r9);
    L35:
        ViewGroup.LayoutParams r12 = r1.getLayoutParams();
        r12.height = r2;
        r12.width = r3;
        r1.setLayoutParams(r12);
        return true;
    L12:
        if (r10 != 3) goto L14;
        r9 = ImageView.ScaleType.CENTER_CROP;
        goto L32
    L14:
        if (r10 != 4) goto L32;
        r9 = ImageView.ScaleType.FIT_CENTER;
        goto L32
    L23:
        if (r8 <= r6) goto L28;
        int r13 = (int) (r3 / r8);
        if (r13 <= r2) goto L27;
        r2 = r13;
    L27:
        r9 = ImageView.ScaleType.FIT_CENTER;
        goto L32
    L28:
        int r14 = (int) (r2 * r8);
        if (r14 <= r3) goto L31;
        r3 = r14;
    L31:
        r9 = ImageView.ScaleType.CENTER_CROP;
    L37:
        ViewGroup.LayoutParams r15 = r1.getLayoutParams();
        r15.height = -1;
        r15.width = -1;
        r1.setLayoutParams(r15);
        r1.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        return false;
    }
}
