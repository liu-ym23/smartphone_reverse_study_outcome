package com.bytedance.awemeopen.apps.photo.utils;

import com.bytedance.android.shopping.store.mall.follows.basic.BaseFollowStoreViewModel;
import com.bytedance.awemeopen.apps.framework.feed.AosEventReporter;
import com.bytedance.awemeopen.apps.framework.feed.ui.rightbar.digg.DiggType;
import com.bytedance.awemeopen.bizmodels.profile.User;
import com.bytedance.awemeopen.domain.base.repo.GsonHolder;
import com.bytedance.awemeopen.export.api.picturedetail.AosPictureDetailConfig;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONObject;
import r14.a0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a {
    public static final a a = null;

    /* JADX INFO: renamed from: com.bytedance.awemeopen.apps.photo.utils.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C0111a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[DiggType.values().length];
            r0[DiggType.from_click_right_bar.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[DiggType.from_double_click_video.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public a() {
    }

    static {
        a = new a();
        Reflection.getOrCreateKotlinClass(a.class).getSimpleName();
    }

    public static Map a(a14.a r4) {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("enter_from", r4.c.sceneId());
        User r1 = r4.a.f();
        String r2 = "";
        if (r1 == null) goto L6;
        String r3 = r1.u();
        if (r3 == null) goto L6;
    L7:
        r0.put("author_openid", r3);
        r0.put("group_id", r4.a.c());
        a0 r5 = r4.a.d;
        if (r5 == null) goto L11;
        String r6 = r5.a();
        if (r6 == null) goto L11;
    L12:
        r0.put("impr_id", r6);
        AosPictureDetailConfig r7 = r4.c.getPageConfig();
        if (r7 == null) goto L18;
        String r8 = r7.getPreviousPage();
        if (r8 == null) goto L18;
        r2 = r8;
    L18:
        r0.put(BaseFollowStoreViewModel.KEY_PREVIOUS_PAGE, r2);
        return r0;
    L11:
        r6 = "";
    L6:
        r3 = "";
        goto L7
    }

    public static void b(a14.a r8, String r9) {
        Intrinsics.checkNotNullParameter(r8, "feedGroupParameters");
        Intrinsics.checkNotNullParameter(r9, "eventName");
        Map r3 = a(r8);
        AosEventReporter r1 = AosEventReporter.a;
        AosPictureDetailConfig r10 = r8.c.getPageConfig();
        if (r10 == null) goto L5;
        JSONObject r11 = r10.getHostExtraParams();
    L6:
        AosEventReporter.s(r1, r9, r3, null, r11, null, 20);
        return;
    L5:
        r11 = null;
        goto L6
    }

    public static void e(a14.a r8, long r9) {
        Intrinsics.checkNotNullParameter(r8, "feedGroupParameters");
        Map r3 = a(r8);
        AosPictureDetailConfig r0 = r8.c.getPageConfig();
        if (r0 == null) goto L6;
        String r1 = r0.getPreviousPage();
        if (r1 == null) goto L6;
    L7:
        r3.put(BaseFollowStoreViewModel.KEY_PREVIOUS_PAGE, r1);
        r3.put("duration", Long.valueOf(r9));
        AosEventReporter r2 = AosEventReporter.a;
        AosPictureDetailConfig r10 = r8.c.getPageConfig();
        if (r10 == null) goto L10;
        JSONObject r11 = r10.getHostExtraParams();
    L11:
        AosEventReporter.s(r2, "page_duration", r3, null, r11, new com.bytedance.awemeopen.apps.framework.utils.e(r8.a), 4);
        return;
    L10:
        r11 = null;
    L6:
        r1 = "";
        goto L7
    }

    public static void c(a14.a r22, DiggType r23, String r24) {
        Intrinsics.checkNotNullParameter(r22, "pictureDetailParameters");
        Intrinsics.checkNotNullParameter(r23, "diggType");
        Intrinsics.checkNotNullParameter(r24, "event");
        int r1 = C0111a.a[r23.ordinal()];
        if (r1 != 1) goto L5;
        String r2 = "detail_bottom_bar";
    L10:
        String r9 = r2;
        d14.a r3 = b14.a.a;
        t24.a r4 = b14.a.a(t24.a.class);
        String r5 = r22.c.sceneId();
        String r6 = r22.a.c();
        String r7 = r22.a.c();
        a0 r8 = r22.a.d;
        if (r8 == null) goto L14;
        String r10 = r8.a();
        if (r10 == null) goto L14;
    L15:
        String r11 = GsonProtectorUtils.toJson(GsonHolder.a(), r22.a.d);
        AosEventReporter r12 = AosEventReporter.a;
        r14.c r13 = r22.a;
        r12.getClass();
        boolean r14 = AosEventReporter.e(r13);
        r14.c r15 = r22.a;
        boolean r16 = r15.t;
        String r17 = r15.u();
        User r18 = r22.a.f();
        if (r18 == null) goto L21;
        String r19 = r18.u();
        if (r19 == null) goto L21;
        String r110 = r19;
    L22:
        AosPictureDetailConfig r111 = r22.c.getPageConfig();
        if (r111 == null) goto L28;
        String r112 = r111.getPreviousPage();
        if (r112 == null) goto L28;
        String r113 = r112;
    L30:
        if (r22.a.W() == false) goto L32;
        String r20 = "origin";
    L33:
        String r21 = r20;
        AosPictureDetailConfig r25 = r22.c.getPageConfig();
        if (r25 == null) goto L36;
        JSONObject r26 = r25.getHostExtraParams();
    L37:
        JSONObject r27 = r26;
        String r28 = r10;
        r4.C(r24, r5, r6, r7, r28, r11, r9, r14, r16, false, new com.bytedance.awemeopen.apps.framework.utils.e(r22.a), r17, r110, r113, r21, false, null, r27);
        return;
    L36:
        r26 = null;
        goto L37
    L32:
        r20 = "sdk";
    L28:
        r113 = "";
    L21:
        r110 = "";
    L14:
        r10 = "";
        goto L15
    L5:
        if (r1 != 2) goto L8;
        r2 = "double_like";
        goto L10
    L8:
        throw new NoWhenBranchMatchedException();
    }

    public static void d(a14.a r22, DiggType r23, boolean r24) {
        Intrinsics.checkNotNullParameter(r22, "pictureDetailParameters");
        Intrinsics.checkNotNullParameter(r23, "diggType");
        int r1 = C0111a.a[r23.ordinal()];
        if (r1 != 1) goto L5;
        String r2 = "detail_bottom_bar";
    L10:
        String r9 = r2;
        d14.a r3 = b14.a.a;
        t24.a r4 = b14.a.a(t24.a.class);
        String r5 = r22.c.sceneId();
        String r6 = r22.a.c();
        String r7 = r22.a.c();
        a0 r8 = r22.a.d;
        if (r8 == null) goto L16;
        String r10 = r8.a();
        if (r10 == null) goto L16;
        String r11 = r10;
    L17:
        String r12 = GsonProtectorUtils.toJson(GsonHolder.a(), r22.a.d);
        AosEventReporter r13 = AosEventReporter.a;
        r14.c r14 = r22.a;
        r13.getClass();
        boolean r15 = AosEventReporter.e(r14);
        r14.c r16 = r22.a;
        boolean r17 = r16.t;
        String r18 = r16.u();
        User r19 = r22.a.f();
        if (r19 == null) goto L23;
        String r20 = r19.u();
        if (r20 == null) goto L23;
        String r110 = r20;
    L24:
        AosPictureDetailConfig r21 = r22.c.getPageConfig();
        if (r21 == null) goto L30;
        String r25 = r21.getPreviousPage();
        if (r25 == null) goto L30;
        String r111 = r25;
    L32:
        if (r22.a.W() == false) goto L34;
        String r26 = "origin";
    L35:
        String r112 = r26;
        AosPictureDetailConfig r27 = r22.c.getPageConfig();
        if (r27 == null) goto L38;
        JSONObject r28 = r27.getHostExtraParams();
    L39:
        JSONObject r29 = r28;
        r4.X(r24, r5, r6, r7, r11, r12, r9, r15, r17, false, new com.bytedance.awemeopen.apps.framework.utils.e(r22.a), r18, r110, r111, r112, false, null, r29, null);
        return;
    L38:
        r28 = null;
        goto L39
    L34:
        r26 = "sdk";
    L30:
        r111 = "";
    L23:
        r110 = "";
    L16:
        r11 = "";
        goto L17
    L5:
        if (r1 != 2) goto L8;
        r2 = "double_like";
        goto L10
    L8:
        throw new NoWhenBranchMatchedException();
    }
}
