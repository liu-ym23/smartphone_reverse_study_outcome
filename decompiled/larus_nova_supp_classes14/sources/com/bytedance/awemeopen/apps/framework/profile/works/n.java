package com.bytedance.awemeopen.apps.framework.profile.works;

import android.os.Build;
import android.widget.ImageView;
import com.bytedance.awemeopen.bizmodels.feed.Video;
import com.bytedance.awemeopen.infra.base.image.AoImageView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import r14.y;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class n {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(r14.c r1, ImageView r2) {
        Intrinsics.checkNotNullParameter(r1, "aweme");
        Intrinsics.checkNotNullParameter(r2, "photoTag");
        d14.a r0 = b14.a.a;
        if (b14.a.a(x24.a.class).W(r1) == false) goto L6;
        x54.b.a(r2);
        return;
    L6:
        if (b14.a.a(x24.a.class).v3(r1) == false) goto L8;
        x54.b.d(r2);
        return;
    L8:
        x54.b.a(r2);
    }

    public static void b(r14.c r2, AoImageView r3) {
        Intrinsics.checkNotNullParameter(r2, "aweme");
        Intrinsics.checkNotNullParameter(r3, "imageView");
        d14.a r0 = b14.a.a;
        if (b14.a.a(x24.a.class).W(r2) == false) goto L6;
        c(r2, r3);
        return;
    L6:
        if (b14.a.a(x24.a.class).v3(r2) == false) goto L20;
        List r1 = new ArrayList();
        if (r2.v() == null) goto L19;
        List r4 = r2.v();
        Intrinsics.checkNotNull(r4);
        if (r4.size() <= 0) goto L19;
        List r5 = r2.v();
        if (r5 == null) goto L17;
        y r6 = (y) ListProtector.get(r5, 0);
        if (r6 == null) goto L17;
        List r7 = r6.c();
        if (r7 == null) goto L17;
    L18:
        r1 = r7;
    L17:
        r7 = new ArrayList();
    L19:
        com.bytedance.awemeopen.infra.base.image.b r8 = new com.bytedance.awemeopen.infra.base.image.b(r1);
        r8.b(2131100239);
        r8.m = ImageView.ScaleType.CENTER_CROP;
        r3.j(r8);
        return;
    L20:
        c(r2, r3);
    }

    public static void c(r14.c r5, AoImageView r6) {
        t14.a r1 = null;
        if (r5.P() == null) goto L56;
        Video r0 = r5.P();
        if (r0 == null) goto L7;
        t14.a r2 = r0.getResetCover();
    L8:
        if (r2 == null) goto L15;
        Video r7 = r5.P();
        if (com.bytedance.awemeopen.apps.framework.utils.f.a(r7.getResetCover()) == false) goto L12;
        t14.a r8 = r7.getResetCover();
    L13:
        d(r8, false, r6);
        return;
    L12:
        r8 = r7.getCover();
        goto L13
    L15:
        if (r5.Y() == false) goto L21;
        Video r9 = r5.P();
        if (com.bytedance.awemeopen.apps.framework.utils.f.a(r9.blurCover) == false) goto L19;
        t14.a r10 = r9.blurCover;
    L20:
        d(r10, false, r6);
        return;
    L19:
        r10 = r9.getCover();
        goto L20
    L21:
        Video r3 = r5.P();
        if (r3 != null) goto L25;
    L33:
        boolean r4 = false;
    L34:
        if (r4 == false) goto L51;
        Video r11 = r5.P();
        if (com.bytedance.awemeopen.apps.framework.utils.f.a(r11.getAnimatedCover()) == false) goto L38;
        t14.a r12 = r11.getAnimatedCover();
    L39:
        if (r12 != null) goto L44;
        Video r13 = r5.P();
        if (com.bytedance.awemeopen.apps.framework.utils.f.a(r13.getDynamicCover()) == false) goto L43;
        r1 = r13.getDynamicCover();
    L43:
        r12 = r1;
    L44:
        if (r12 == null) goto L46;
        d(r12, true, r6);
        return;
    L46:
        Video r14 = r5.P();
        if (com.bytedance.awemeopen.apps.framework.utils.f.a(r14.getOptimizedCover()) == false) goto L49;
        t14.a r15 = r14.getOptimizedCover();
    L50:
        d(r15, false, r6);
        return;
    L49:
        r15 = r14.getCover();
        goto L50
    L38:
        r12 = null;
        goto L39
    L51:
        Video r16 = r5.P();
        if (com.bytedance.awemeopen.apps.framework.utils.f.a(r16.getOptimizedCover()) == false) goto L54;
        t14.a r17 = r16.getOptimizedCover();
    L55:
        d(r17, false, r6);
        return;
    L54:
        r17 = r16.getCover();
        goto L55
    L25:
        if (com.bytedance.awemeopen.apps.framework.feed.ui.information.a.p == false) goto L33;
        if (r3.isUseStaticCover() == true) goto L33;
        if (Build.VERSION.SDK_INT < 23) goto L33;
        r4 = true;
        goto L34
    L7:
        r2 = null;
        goto L8
    L56:
        d(null, false, r6);
    }

    public static void d(t14.a r1, boolean r2, AoImageView r3) {
        if (r1 == null) goto L6;
        List r4 = r1.g();
        if (r4 == null) goto L6;
    L7:
        com.bytedance.awemeopen.infra.base.image.b r0 = new com.bytedance.awemeopen.infra.base.image.b(r4);
        r0.b(2131100239);
        r0.m = ImageView.ScaleType.CENTER_CROP;
        r0.v = r2;
        r3.j(r0);
        return;
    L6:
        r4 = new ArrayList();
        goto L7
    }
}
