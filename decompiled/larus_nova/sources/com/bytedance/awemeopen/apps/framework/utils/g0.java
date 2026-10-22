package com.bytedance.awemeopen.apps.framework.utils;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.model.ScaleType;
import com.bytedance.awemeopen.infra.base.image.AoImageView;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f197697a = 0;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f197698a = null;

        static {
            int[] r100 = new int[ScaleType.values().length];
            r100[ScaleType.AUTO_MODE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r100[ScaleType.ALWAYS_FIT_WIDTH.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r100[ScaleType.CENTER_CROP.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r100[ScaleType.FIT_CENTER.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f197698a = r100;
        }
    }

    static {
    }

    public static float a(Context r100, r14.c r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        boolean r102 = false;
        if (r101 == null) goto L20;
        List<r14.y> r103 = r101.v();
        if (r103 == null) goto L7;
        int r104 = r103.size();
    L8:
        if (r104 <= 0) goto L20;
        List<r14.y> r105 = r101.v();
        Intrinsics.checkNotNull(r105);
        Iterator<r14.y> r106 = r105.iterator();
        int r107 = 0;
    L12:
        if (r106.hasNext() == false) goto L19;
        r14.y r108 = r106.next();
        if ((r108.d() * r108.a()) != 0) goto L16;
        int r109 = 0;
    L17:
        if (r109 <= r107) goto L12;
        r107 = r109;
        goto L12
    L16:
        r109 = (r108.a() * d0.d(r100)) / r108.d();
        goto L17
    L19:
        float r110 = r107;
    L22:
        if (r110 != 0.0f) goto L25;
        r102 = true;
    L25:
        if (r102 == true) goto L35;
        if (r110 > ((d0.d(r100) * 4.0f) / 3.0f)) goto L35;
        if (r110 < ((d0.d(r100) * 9.0f) / 16.0f)) goto L32;
        return r110;
    L32:
        return (d0.d(r100) * 9.0f) / 16.0f;
    L35:
        return (d0.d(r100) * 4.0f) / 3.0f;
    L7:
        r104 = 0;
    L20:
        r110 = 0.0f;
        goto L22
    }

    public static boolean b(AoImageView r100, int r101, int r102, int r103, int r104, float r105, ScaleType r106) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r106, "scaleType");
        if (r103 <= 0) goto L37;
        if (r104 <= 0) goto L37;
        if (r102 <= 0) goto L37;
        float r107 = (r104 * 1.0f) / (r103 * 1.0f);
        ImageView.ScaleType r108 = ImageView.ScaleType.CENTER_CROP;
        int r109 = a.f197698a[r106.ordinal()];
        if (r109 == 1) goto L23;
        if (r109 != 2) goto L12;
        int r110 = (int) (r102 / r107);
        if (r110 <= r101) goto L21;
        r101 = r110;
    L21:
        r108 = ImageView.ScaleType.FIT_CENTER;
    L32:
        Objects.toString(r108);
        if ((r100 instanceof ImageView) == false) goto L35;
        r100.setScaleType(r108);
    L35:
        ViewGroup.LayoutParams r111 = r100.getLayoutParams();
        r111.height = r101;
        r111.width = r102;
        r100.setLayoutParams(r111);
        return true;
    L12:
        if (r109 != 3) goto L14;
        r108 = ImageView.ScaleType.CENTER_CROP;
        goto L32
    L14:
        if (r109 != 4) goto L32;
        r108 = ImageView.ScaleType.FIT_CENTER;
        goto L32
    L23:
        if (r107 <= r105) goto L28;
        int r112 = (int) (r102 / r107);
        if (r112 <= r101) goto L27;
        r101 = r112;
    L27:
        r108 = ImageView.ScaleType.FIT_CENTER;
        goto L32
    L28:
        int r113 = (int) (r101 * r107);
        if (r113 <= r102) goto L31;
        r102 = r113;
    L31:
        r108 = ImageView.ScaleType.CENTER_CROP;
    L37:
        ViewGroup.LayoutParams r114 = r100.getLayoutParams();
        r114.height = -1;
        r114.width = -1;
        r100.setLayoutParams(r114);
        r100.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        return false;
    }
}
