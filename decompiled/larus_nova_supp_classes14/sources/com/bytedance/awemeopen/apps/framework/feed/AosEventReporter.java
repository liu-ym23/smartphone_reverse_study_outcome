package com.bytedance.awemeopen.apps.framework.feed;

import android.text.TextUtils;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.p;
import com.bytedance.awemeopen.apps.framework.feed.profile.AosUserProfileFeedFragmentViewModel;
import com.bytedance.awemeopen.apps.framework.feed.ui.information.bottomcomponent.b;
import com.bytedance.awemeopen.apps.framework.feed.ui.rightbar.digg.DiggType;
import com.bytedance.awemeopen.apps.framework.framework.viewpager.o;
import com.bytedance.awemeopen.apps.framework.utils.e;
import com.bytedance.awemeopen.apps.photo.pinch.PinchEnterMethod;
import com.bytedance.awemeopen.bizmodels.feed.shopping.card.ShoppingCardInfo;
import com.bytedance.awemeopen.bizmodels.profile.User;
import com.bytedance.awemeopen.domain.base.repo.GsonHolder;
import com.bytedance.awemeopen.export.api.pageconfig.recfeed.FeedPageConfig;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONObject;
import r14.a0;
import r14.c;
import s14.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class AosEventReporter {
    public static final AosEventReporter a = null;
    public static final String b = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/feed/AosEventReporter$EnterPersonalDetail;", "", "slide", "click_avatar", "click_name", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
    public static final enum EnterPersonalDetail extends Enum<EnterPersonalDetail> {
        public static final /* synthetic */ EnterPersonalDetail[] a = null;
        public static final EnterPersonalDetail click_avatar = null;
        public static final EnterPersonalDetail click_name = null;
        public static final EnterPersonalDetail slide = null;

        public static EnterPersonalDetail valueOf(String r1) {
            return (EnterPersonalDetail) r27.a.a(EnterPersonalDetail.class, r1);
        }

        public static EnterPersonalDetail[] values() {
            return (EnterPersonalDetail[]) a.clone();
        }

        static {
            EnterPersonalDetail r0 = new EnterPersonalDetail("slide", 0);
            slide = r0;
            EnterPersonalDetail r1 = new EnterPersonalDetail("click_avatar", 1);
            click_avatar = r1;
            EnterPersonalDetail r3 = new EnterPersonalDetail("click_name", 2);
            click_name = r3;
            a = new EnterPersonalDetail[]{r0, r1, r3};
        }

        public EnterPersonalDetail(String r1, int r2) {
            super(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/feed/AosEventReporter$FollowType;", "", "from_group", "from_profile", "from_graphic", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
    public static final enum FollowType extends Enum<FollowType> {
        public static final /* synthetic */ FollowType[] a = null;
        public static final FollowType from_graphic = null;
        public static final FollowType from_group = null;
        public static final FollowType from_profile = null;

        public static FollowType valueOf(String r1) {
            return (FollowType) r27.a.a(FollowType.class, r1);
        }

        public static FollowType[] values() {
            return (FollowType[]) a.clone();
        }

        static {
            FollowType r0 = new FollowType("from_group", 0);
            from_group = r0;
            FollowType r1 = new FollowType("from_profile", 1);
            from_profile = r1;
            FollowType r3 = new FollowType("from_graphic", 2);
            from_graphic = r3;
            a = new FollowType[]{r0, r1, r3};
        }

        public FollowType(String r1, int r2) {
            super(r1, r2);
        }
    }

    public /* synthetic */ class a {
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

    public AosEventReporter() {
    }

    static {
        a = new AosEventReporter();
        String r0 = Reflection.getOrCreateKotlinClass(AosEventReporter.class).getSimpleName();
        if (r0 != null) goto L5;
        r0 = "AosEventReporter";
    L5:
        b = r0;
    }

    public static String c(c r1) {
        return GsonProtectorUtils.toJson(GsonHolder.a(), r1.d);
    }

    public static boolean d(jz3.a r0) {
        if (r0 != null) goto L6;
        return false;
    L6:
        return e(r0.a);
    }

    public static boolean e(c r1) {
        Intrinsics.checkNotNullParameter(r1, "aweme");
        User r2 = r1.f();
        if (r2 != null) goto L7;
        return false;
    L7:
        return r2.O();
    }

    public static void F(o r21, c r22) {
        Intrinsics.checkNotNullParameter(r21, "vm");
        Intrinsics.checkNotNullParameter(r22, "data");
        FeedPageConfig r2 = r21.getPageConfig();
        b.a(r21.getHostExtensionInfo());
        if (r2.isTeenagerModel() == true) goto L5;
        d14.a r3 = b14.a.a;
        t24.a r4 = b14.a.a(t24.a.class);
        String r5 = r21.sceneId();
        String r6 = r22.c();
        String r7 = b(r22, r2);
        if (r7 != null) goto L35;
        r7 = "";
    L35:
        boolean r11 = r22.t;
        boolean r12 = r2.isCardMode();
        a0 r8 = r22.d;
        if (r8 == null) goto L39;
        String r9 = r8.a();
        if (r9 == null) goto L39;
    L40:
        String r10 = GsonProtectorUtils.toJson(GsonHolder.a(), r22.d);
        boolean r13 = e(r22);
        String r14 = r22.u();
        User r15 = r22.f();
        if (r15 == null) goto L46;
        String r16 = r15.u();
        if (r16 == null) goto L46;
        String r17 = r16;
    L47:
        String r18 = r2.getPreviousPage();
        if (r18 != null) goto L50;
        String r19 = "";
    L51:
        User r20 = r22.f();
        if (r20 != null) goto L54;
    L56:
        boolean r110 = false;
    L58:
        if (r22.W() == false) goto L60;
        String r23 = "origin";
    L61:
        JSONObject r111 = r21.getPageConfig().getHostExtraParams();
        e r0 = new e(r22);
        r4.e2(r5, r6, r7, r9, r10, r13, r11, r12, r0, r14, r17, r19, r23, r111, r110, "");
        return;
    L60:
        r23 = "sdk";
        goto L61
    L54:
        if (r20.R() != true) goto L56;
        r110 = true;
        goto L58
    L50:
        r19 = r18;
    L46:
        r17 = "";
    L39:
        r9 = "";
        goto L40
    L5:
        if (Intrinsics.areEqual(r21.sceneId(), "others_homepage") == true) goto L7;
    L12:
        String r112 = "";
    L13:
        d14.a r24 = b14.a.a;
        t24.a r25 = b14.a.a(t24.a.class);
        String r26 = r21.sceneId();
        User r1 = r22.f();
        if (r1 == null) goto L19;
        String r27 = r1.u();
        if (r27 == null) goto L19;
        String r28 = r27;
    L20:
        String r29 = r22.c();
        String r30 = b(r22, r2);
        if (r30 != null) goto L23;
        String r31 = "";
    L24:
        a0 r32 = r22.d;
        if (r32 == null) goto L30;
        String r33 = r32.a();
        if (r33 == null) goto L30;
        String r113 = r33;
    L31:
        r25.K2(r26, r28, r29, r31, r113, r112);
        return;
    L30:
        r113 = "";
        goto L31
    L23:
        r31 = r30;
    L19:
        r28 = "";
        goto L20
    L7:
        if ((r21 instanceof AosUserProfileFeedFragmentViewModel) == false) goto L9;
        AosUserProfileFeedFragmentViewModel r34 = (AosUserProfileFeedFragmentViewModel) r21;
    L10:
        if (r34 == null) goto L12;
        r112 = r34.getFromGroupId();
        goto L13
    L9:
        r34 = null;
        goto L10
    }

    public static void P(o r10, c r11) {
        Intrinsics.checkNotNullParameter(r10, "vm");
        if (r11 != null) goto L6;
        return;
    L6:
        if (Intrinsics.areEqual(r10.sceneId(), "others_homepage") == true) goto L8;
    L13:
        String r7 = "";
    L14:
        d14.a r0 = b14.a.a;
        t24.a r2 = b14.a.a(t24.a.class);
        String r1 = r10.sceneId();
        if (r1 != null) goto L17;
        String r3 = "";
    L18:
        User r4 = r11.f();
        if (r4 == null) goto L24;
        String r5 = r4.u();
        if (r5 == null) goto L24;
        String r6 = r5;
    L25:
        String r8 = r11.c();
        a0 r9 = r11.d;
        if (r9 == null) goto L31;
        String r12 = r9.a();
        if (r12 == null) goto L31;
        String r13 = r12;
    L32:
        r2.r1(r3, r6, r8, r13, r7, r10.getPageConfig().getHostExtraParams(), new e(r11));
        return;
    L31:
        r13 = "";
    L24:
        r6 = "";
        goto L25
    L17:
        r3 = r1;
        goto L18
    L8:
        if ((r10 instanceof AosUserProfileFeedFragmentViewModel) == false) goto L10;
        AosUserProfileFeedFragmentViewModel r14 = (AosUserProfileFeedFragmentViewModel) r10;
    L11:
        if (r14 == null) goto L13;
        r7 = r14.getFromGroupId();
        goto L14
    L10:
        r14 = null;
        goto L11
    }

    public static void S(com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a r25, jz3.a r26) {
        Intrinsics.checkNotNullParameter(r25, "feedGroupParameters");
        Intrinsics.checkNotNullParameter(r26, "data");
        String r4 = r25.c.sceneId();
        String r3 = null;
        if (Intrinsics.areEqual(r4, "others_homepage") == false) goto L10;
        o r2 = r25.c;
        if ((r2 instanceof AosUserProfileFeedFragmentViewModel) == false) goto L7;
        AosUserProfileFeedFragmentViewModel r5 = (AosUserProfileFeedFragmentViewModel) r2;
    L8:
        if (r5 == null) goto L10;
        String r6 = r5.getFromGroupId();
    L11:
        FeedPageConfig r7 = r25.c.getPageConfig();
        JSONObject r22 = r7.getHostExtraParams();
        b.a(r25.c.getHostExtensionInfo());
        if (r7.isTeenagerModel() == false) goto L30;
        d14.a r0 = b14.a.a;
        t24.a r8 = b14.a.a(t24.a.class);
        User r1 = r26.a.f();
        if (r1 == null) goto L17;
        String r9 = r1.u();
        if (r9 == null) goto L17;
    L18:
        String r10 = r26.a.c();
        String r11 = b(r26.a, r7);
        if (r11 != null) goto L21;
        String r12 = "";
    L22:
        a0 r13 = r26.a.d;
        if (r13 == null) goto L28;
        String r14 = r13.a();
        if (r14 == null) goto L28;
        String r15 = r14;
    L29:
        r8.d0(r4, r9, r10, r12, r15, r6, r26.a.t);
        return;
    L28:
        r15 = "";
        goto L29
    L21:
        r12 = r11;
    L17:
        r9 = "";
        goto L18
    L30:
        d14.a r16 = b14.a.a;
        t24.a r17 = b14.a.a(t24.a.class);
        String r18 = r26.a.c();
        String r19 = b(r26.a, r7);
        if (r19 != null) goto L33;
        r19 = "";
    L33:
        a0 r20 = r26.a.d;
        if (r20 == null) goto L37;
        String r21 = r20.a();
        if (r21 == null) goto L37;
    L38:
        boolean r110 = r26.g;
        c r111 = r26.a;
        boolean r112 = r111.t;
        User r113 = r111.f();
        if (r113 == null) goto L44;
        String r114 = r113.u();
        if (r114 == null) goto L44;
        String r115 = r114;
    L45:
        String r116 = r7.getPreviousPage();
        if (r116 != null) goto L48;
        String r117 = "";
    L50:
        if (r26.a.W() == false) goto L52;
        String r118 = "origin";
    L53:
        String r119 = r118;
        boolean r120 = r7.isCardMode();
        a0 r23 = r26.a.d;
        if (r23 == null) goto L56;
        r3 = r23.a();
    L56:
        if (r3 != null) goto L58;
        String r24 = "";
    L59:
        String r27 = r26.a.r().d;
        if (r27 != null) goto L62;
        String r28 = "";
    L63:
        User r29 = r26.a.f();
        if (r29 != null) goto L66;
    L68:
        boolean r210 = false;
    L69:
        r17.j2(r4, r18, r19, r21, r6, r110, r112, r120, "", "", new e(r26.a), r115, r117, r119, null, r24, r28, r210, r22, "");
        return;
    L66:
        if (r29.R() != true) goto L68;
        r210 = true;
        goto L69
    L62:
        r28 = r27;
        goto L63
    L58:
        r24 = r3;
        goto L59
    L52:
        r118 = "sdk";
        goto L53
    L48:
        r117 = r116;
    L44:
        r115 = "";
    L37:
        r21 = "";
        goto L38
    L7:
        r5 = null;
    L10:
        r6 = "";
        goto L11
    }

    public static boolean a(String r2, jz3.a r3) {
        Intrinsics.checkNotNullParameter(r2, "sceneId");
        if (r3 != null) goto L6;
        return false;
    L6:
        if (r3.d == 0) goto L8;
    L13:
        return false;
    L8:
        if (r3.e == true) goto L13;
        if (Intrinsics.areEqual(r2, "homepage_hot") == false) goto L13;
        return true;
    }

    public static String b(c r2, FeedPageConfig r3) {
        Intrinsics.checkNotNullParameter(r2, "aweme");
        String r0 = r2.r().c;
        if (TextUtils.isEmpty(r0) == false) goto L10;
        if (r3 != null) goto L6;
    L8:
        return null;
    L6:
        if (Intrinsics.areEqual(r3.getEnterAid(), r2.c()) == false) goto L8;
        return r3.getEnterHostGid();
    L10:
        return r0;
    }

    public static void j(o r12, c r13) {
        Intrinsics.checkNotNullParameter(r12, "vm");
        Intrinsics.checkNotNullParameter(r13, "data");
        d14.a r0 = b14.a.a;
        t24.a r1 = b14.a.a(t24.a.class);
        String r2 = r12.sceneId();
        String r3 = r12.getPageConfig().getHostEnterFrom();
        User r4 = r13.f();
        if (r4 == null) goto L6;
        String r5 = r4.u();
        if (r5 == null) goto L6;
    L7:
        String r6 = r13.c();
        String r7 = b(r13, r12.getPageConfig());
        if (r7 != null) goto L10;
        r7 = "";
    L10:
        a0 r8 = r13.d;
        if (r8 == null) goto L14;
        String r9 = r8.a();
        if (r9 == null) goto L14;
    L15:
        boolean r10 = r12.getPageConfig().isCardMode();
        User r14 = r13.f();
        if (r14 != null) goto L18;
    L20:
        boolean r11 = false;
    L21:
        String r15 = r5;
        r1.d3(r2, r3, r15, r6, r7, r9, r10, r11, r12.getPageConfig().getHostExtraParams(), null);
        return;
    L18:
        if (r14.R() != true) goto L20;
        r11 = true;
    L14:
        r9 = "";
    L6:
        r5 = "";
        goto L7
    }

    public static void n(o r18, c r19) {
        Intrinsics.checkNotNullParameter(r18, "vm");
        Intrinsics.checkNotNullParameter(r19, "data");
        b.a(r18.getHostExtensionInfo());
        d14.a r1 = b14.a.a;
        t24.a r2 = b14.a.a(t24.a.class);
        String r3 = r18.sceneId();
        User r4 = r19.f();
        if (r4 == null) goto L6;
        String r5 = r4.u();
        if (r5 == null) goto L6;
    L7:
        String r6 = r19.c();
        String r7 = b(r19, r18.getPageConfig());
        if (r7 != null) goto L10;
        r7 = "";
    L10:
        a0 r8 = r19.d;
        if (r8 == null) goto L14;
        String r9 = r8.a();
        if (r9 == null) goto L14;
    L15:
        String r10 = GsonProtectorUtils.toJson(GsonHolder.a(), r19.d);
        boolean r11 = e(r19);
        boolean r12 = r18.getPageConfig().isCardMode();
        String r13 = r19.u();
        if (r19.W() == false) goto L18;
        String r14 = "origin";
    L19:
        String r15 = r18.getPageConfig().getPreviousPage();
        if (r15 != null) goto L22;
        r15 = "";
    L22:
        User r16 = r19.f();
        if (r16 == null) goto L27;
        boolean r17 = true;
        if (r16.R() != true) goto L27;
    L28:
        String r110 = r18.getPageConfig().getHostEnterFrom();
        JSONObject r111 = r18.getPageConfig().getHostExtraParams();
        String r20 = r7;
        String r21 = r9;
        r2.Q2(r3, r5, r6, r20, r21, r10, r11, r12, new e(r19), r13, r14, r15, r17, r110, r111);
        return;
    L27:
        r17 = false;
        goto L28
    L18:
        r14 = "sdk";
    L14:
        r9 = "";
    L6:
        r5 = "";
        goto L7
    }

    public static void r(o r12, c r13) {
        Intrinsics.checkNotNullParameter(r12, "vm");
        Intrinsics.checkNotNullParameter(r13, "data");
        d14.a r0 = b14.a.a;
        t24.a r1 = b14.a.a(t24.a.class);
        String r2 = r12.sceneId();
        String r3 = r12.getPageConfig().getHostEnterFrom();
        String r4 = r13.c();
        String r5 = b(r13, r12.getPageConfig());
        if (r5 != null) goto L5;
        r5 = "";
    L5:
        User r6 = r13.f();
        if (r6 == null) goto L9;
        String r7 = r6.u();
        if (r7 == null) goto L9;
    L10:
        a0 r8 = r13.d;
        if (r8 == null) goto L14;
        String r9 = r8.a();
        if (r9 == null) goto L14;
    L15:
        boolean r10 = r12.getPageConfig().isCardMode();
        User r11 = r13.f();
        if (r11 == null) goto L20;
        boolean r14 = true;
        if (r11.R() != true) goto L20;
    L21:
        JSONObject r15 = r12.getPageConfig().getHostExtraParams();
        e r16 = new e(r13);
        b.a(r12.getHostExtensionInfo());
        r1.h1(r2, r3, r4, r5, r7, r9, r10, r14, r15, r16);
        return;
    L20:
        r14 = false;
    L14:
        r9 = "";
    L9:
        r7 = "";
        goto L10
    }

    public static void M(AosEventReporter r20, com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a r21, jz3.a r22) {
        r20.getClass();
        Intrinsics.checkNotNullParameter(r21, "feedGroupParameters");
        Intrinsics.checkNotNullParameter(r22, "data");
        String r4 = r21.c.sceneId();
        if (Intrinsics.areEqual(r4, "others_homepage") == false) goto L10;
        o r2 = r21.c;
        if ((r2 instanceof AosUserProfileFeedFragmentViewModel) == false) goto L7;
        AosUserProfileFeedFragmentViewModel r3 = (AosUserProfileFeedFragmentViewModel) r2;
    L8:
        if (r3 == null) goto L10;
        String r10 = r3.getFromGroupId();
    L12:
        if (r21.c.getPostPlayTimeDurationRecord() != 0) goto L14;
        long r5 = r21.c.getDuration();
    L15:
        long r7 = r5;
        r21.c.setPostPlayTimeDurationRecord(System.currentTimeMillis());
        FeedPageConfig r6 = r21.c.getPageConfig();
        d14.a r8 = b14.a.a;
        t24.a r9 = b14.a.a(t24.a.class);
        String r11 = r22.a.c();
        String r12 = b(r22.a, r6);
        if (r12 != null) goto L18;
        r12 = "";
    L18:
        a0 r13 = r22.a.d;
        if (r13 == null) goto L22;
        String r14 = r13.a();
        if (r14 == null) goto L22;
    L23:
        String r15 = GsonProtectorUtils.toJson(GsonHolder.a(), r22.a.d);
        boolean r16 = e(r22.a);
        c r17 = r22.a;
        boolean r18 = r17.t;
        User r19 = r17.f();
        if (r19 == null) goto L27;
        String r110 = r19.u();
        if (r110 == null) goto L27;
    L28:
        String r23 = r6.getPreviousPage();
        if (r23 != null) goto L32;
        r23 = "";
    L32:
        if (r22.a.W() == false) goto L34;
        String r24 = "origin";
    L35:
        String r111 = r21.c.getOverType();
        String r112 = String.valueOf(r22.a.q() / ECDraweeView.SQUARE);
        String r25 = r12;
        String r26 = r14;
        String r113 = r23;
        r9.M0(r4, r11, r25, r7, r26, r10, r15, r16, r18, r110, r113, r24, r111, r22.a.u(), r112);
        return;
    L34:
        r24 = "sdk";
    L27:
        r110 = "";
    L22:
        r14 = "";
        goto L23
    L14:
        r5 = System.currentTimeMillis() - r21.c.getPostPlayTimeDurationRecord();
        goto L15
    L7:
        r3 = null;
    L10:
        r10 = "";
        goto L12
    }

    public static void N(com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a r23, jz3.a r24, p r25) {
        Intrinsics.checkNotNullParameter(r23, "feedGroupParameters");
        Intrinsics.checkNotNullParameter(r24, "data");
        Intrinsics.checkNotNullParameter(r25, "eventRecorder");
        String r5 = r23.c.sceneId();
        if (Intrinsics.areEqual(r5, "others_homepage") == false) goto L10;
        o r3 = r23.c;
        if ((r3 instanceof AosUserProfileFeedFragmentViewModel) == false) goto L7;
        AosUserProfileFeedFragmentViewModel r4 = (AosUserProfileFeedFragmentViewModel) r3;
    L8:
        if (r4 == null) goto L10;
        String r9 = r4.getFromGroupId();
    L11:
        FeedPageConfig r6 = r23.c.getPageConfig();
        d14.a r7 = b14.a.a;
        t24.a r8 = b14.a.a(t24.a.class);
        String r10 = r24.a.c();
        String r11 = b(r24.a, r6);
        if (r11 != null) goto L14;
        r11 = "";
    L14:
        a0 r12 = r24.a.d;
        if (r12 == null) goto L18;
        String r13 = r12.a();
        if (r13 == null) goto L18;
    L19:
        String r14 = GsonProtectorUtils.toJson(GsonHolder.a(), r24.a.d);
        boolean r15 = e(r24.a);
        boolean r2 = r25.b;
        c r16 = r24.a;
        boolean r17 = r16.t;
        User r18 = r16.f();
        if (r18 == null) goto L25;
        String r19 = r18.u();
        if (r19 == null) goto L25;
        String r110 = r19;
    L26:
        String r111 = r6.getPreviousPage();
        if (r111 != null) goto L29;
        String r112 = "";
    L31:
        if (r24.a.W() == false) goto L33;
        String r20 = "origin";
    L34:
        String r21 = r23.c.getStartType();
        String r22 = r24.a.u();
        r6.isCardMode();
        String r26 = r11;
        String r27 = r13;
        r8.K0(r5, r10, r26, r27, r9, r14, r15, "detail", r2, r17, "", false, null, r110, r112, r20, r21, r22);
        return;
    L33:
        r20 = "sdk";
        goto L34
    L29:
        r112 = r111;
    L25:
        r110 = "";
    L18:
        r13 = "";
        goto L19
    L7:
        r4 = null;
    L10:
        r9 = "";
        goto L11
    }

    public static void R(com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a r20, jz3.a r21, p r22) {
        Intrinsics.checkNotNullParameter(r20, "feedGroupParameters");
        Intrinsics.checkNotNullParameter(r21, "data");
        Intrinsics.checkNotNullParameter(r22, "eventRecorder");
        String r5 = r20.c.sceneId();
        FeedPageConfig r0 = r20.c.getPageConfig();
        r22.getClass();
        long r13 = System.currentTimeMillis() - r22.d;
        r22.d = 0;
        long r11 = r22.f;
        r22.e = 0;
        r22.f = 0;
        d14.a r3 = b14.a.a;
        t24.a r4 = b14.a.a(t24.a.class);
        String r6 = r0.getHostEnterFrom();
        User r7 = r21.a.f();
        if (r7 == null) goto L6;
        String r8 = r7.u();
        if (r8 == null) goto L6;
    L7:
        String r9 = r21.a.c();
        String r1 = b(r21.a, r0);
        if (r1 != null) goto L10;
        String r10 = "";
    L11:
        a0 r2 = r21.a.d;
        if (r2 == null) goto L17;
        String r12 = r2.a();
        if (r12 == null) goto L17;
        String r14 = r12;
    L18:
        String r15 = r8;
        r4.X1(r5, r6, r15, r9, r10, r14, c(r21.a), e(r21.a), r13, r11, r22.b, r21.a.r().a, null);
        return;
    L17:
        r14 = "";
        goto L18
    L10:
        r10 = r1;
    L6:
        r8 = "";
        goto L7
    }

    public static void f(com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a r11, jz3.a r12, String r13) {
        Intrinsics.checkNotNullParameter(r11, "feedGroupParameters");
        Intrinsics.checkNotNullParameter(r12, "data");
        Intrinsics.checkNotNullParameter("long_press", "enterMethod");
        Intrinsics.checkNotNullParameter(r13, "showType");
        String r1 = r11.c.sceneId();
        FeedPageConfig r14 = r11.c.getPageConfig();
        d14.a r0 = b14.a.a;
        t24.a r2 = b14.a.a(t24.a.class);
        User r3 = r12.a.f();
        if (r3 == null) goto L6;
        String r4 = r3.u();
        if (r4 == null) goto L6;
    L7:
        String r5 = r12.a.c();
        String r15 = b(r12.a, r14);
        if (r15 != null) goto L10;
        r15 = "";
    L10:
        a0 r6 = r12.a.d;
        if (r6 == null) goto L14;
        String r7 = r6.a();
        if (r7 == null) goto L14;
    L15:
        String r8 = r15;
        r2.k1(r1, r4, r5, r8, r7, c(r12.a), d(r12), "long_press", r13, null);
        return;
    L14:
        r7 = "";
    L6:
        r4 = "";
        goto L7
    }

    public static void g(com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a r11, jz3.a r12, String r13) {
        Intrinsics.checkNotNullParameter("long_press", "enterMethod");
        Intrinsics.checkNotNullParameter(r13, "showType");
        if (r11 == null) goto L8;
        o r1 = r11.c;
        if (r1 == null) goto L8;
        String r2 = r1.sceneId();
        if (r2 == null) goto L8;
    L9:
        if (r11 == null) goto L13;
        o r14 = r11.c;
        if (r14 == null) goto L13;
        FeedPageConfig r15 = r14.getPageConfig();
    L14:
        if (r12 == null) goto L32;
        c r3 = r12.a;
        if (r3 == null) goto L33;
        d14.a r4 = b14.a.a;
        t24.a r5 = b14.a.a(t24.a.class);
        User r6 = r3.f();
        if (r6 == null) goto L21;
        String r7 = r6.u();
        if (r7 == null) goto L21;
    L22:
        String r8 = r3.c();
        a.getClass();
        String r16 = b(r3, r15);
        if (r16 != null) goto L25;
        r16 = "";
    L25:
        a0 r9 = r3.d;
        if (r9 == null) goto L29;
        String r10 = r9.a();
        if (r10 == null) goto L29;
    L30:
        String r17 = r7;
        String r18 = r16;
        String r19 = r10;
        r5.H2(r2, r17, r8, r18, r19, c(r3), d(r12), "long_press", r13, null);
        return;
    L29:
        r10 = "";
    L21:
        r7 = "";
        goto L22
    L33:
        return;
    L32:
        return;
    L13:
        r15 = null;
    L8:
        r2 = "";
        goto L9
    }

    public static void l(String r10, String r11, c r12) {
        Intrinsics.checkNotNullParameter(r10, "sceneId");
        Intrinsics.checkNotNullParameter(r12, "data");
        d14.a r0 = b14.a.a;
        t24.a r1 = b14.a.a(t24.a.class);
        User r2 = r12.f();
        if (r2 == null) goto L8;
        String r3 = r2.u();
        if (r3 == null) goto L8;
        String r4 = r3;
    L9:
        String r5 = r12.c();
        String r6 = b(r12, null);
        if (r6 != null) goto L14;
        if (r11 != null) goto L13;
        String r7 = "";
    L15:
        a0 r13 = r12.d;
        if (r13 == null) goto L21;
        String r14 = r13.a();
        if (r14 == null) goto L21;
        String r8 = r14;
    L22:
        r1.e0(r10, r4, r5, r7, r8, c(r12), e(r12), null);
        return;
    L21:
        r8 = "";
        goto L22
    L13:
        r7 = r11;
        goto L15
    L14:
        r7 = r6;
    L8:
        r4 = "";
        goto L9
    }

    public static void m(o r12, c r13, String r14) {
        Intrinsics.checkNotNullParameter(r12, "vm");
        Intrinsics.checkNotNullParameter(r13, "data");
        Intrinsics.checkNotNullParameter(r14, "eventName");
        d14.a r0 = b14.a.a;
        t24.a r1 = b14.a.a(t24.a.class);
        String r3 = r12.sceneId();
        String r4 = r12.getPageConfig().getHostEnterFrom();
        String r5 = r13.c();
        String r2 = b(r13, r12.getPageConfig());
        if (r2 != null) goto L5;
        String r6 = "";
    L6:
        User r7 = r13.f();
        if (r7 == null) goto L12;
        String r8 = r7.u();
        if (r8 == null) goto L12;
        String r9 = r8;
    L13:
        a0 r10 = r13.d;
        if (r10 == null) goto L19;
        String r11 = r10.a();
        if (r11 == null) goto L19;
        String r15 = r11;
    L20:
        boolean r16 = r12.getPageConfig().isCardMode();
        User r17 = r13.f();
        if (r17 != null) goto L23;
    L25:
        boolean r18 = false;
    L26:
        r1.U(r14, r3, r4, r5, r6, r9, r15, r16, r18, r12.getPageConfig().getHostExtraParams());
        return;
    L23:
        if (r17.R() != true) goto L25;
        r18 = true;
    L19:
        r15 = "";
    L12:
        r9 = "";
        goto L13
    L5:
        r6 = r2;
        goto L6
    }

    public static void t(o r11, String r12, c r13) {
        Intrinsics.checkNotNullParameter(r11, "vm");
        Intrinsics.checkNotNullParameter(r12, "unfoldMethod");
        if (r13 != null) goto L5;
        return;
    L5:
        String r3 = r11.sceneId();
        if (Intrinsics.areEqual(r3, "others_homepage") == true) goto L8;
    L13:
        String r6 = "";
    L14:
        d14.a r0 = b14.a.a;
        t24.a r1 = b14.a.a(t24.a.class);
        User r2 = r13.f();
        if (r2 == null) goto L18;
        String r4 = r2.u();
        if (r4 == null) goto L18;
    L19:
        String r5 = r13.c();
        if (r5 != null) goto L22;
        r5 = "";
    L22:
        a0 r7 = r13.d;
        if (r7 == null) goto L26;
        String r8 = r7.a();
        if (r8 == null) goto L26;
    L28:
        if (r13.W() == false) goto L30;
        String r9 = "origin";
    L31:
        String r10 = r9;
        String r14 = r11.getPageConfig().getPreviousPage();
        if (r14 != null) goto L34;
        String r15 = "";
    L35:
        r1.q0(r4, r3, r5, r8, r6, r12, r10, r15, r13.u());
        return;
    L34:
        r15 = r14;
        goto L35
    L30:
        r9 = "sdk";
    L26:
        r8 = "";
    L18:
        r4 = "";
        goto L19
    L8:
        if ((r11 instanceof AosUserProfileFeedFragmentViewModel) == false) goto L10;
        AosUserProfileFeedFragmentViewModel r16 = (AosUserProfileFeedFragmentViewModel) r11;
    L11:
        if (r16 == null) goto L13;
        r6 = r16.getFromGroupId();
        goto L14
    L10:
        r16 = null;
        goto L11
    }

    public static void E(o r25, c r26, DiggType r27, boolean r28) {
        Intrinsics.checkNotNullParameter(r25, "vm");
        Intrinsics.checkNotNullParameter(r26, "data");
        Intrinsics.checkNotNullParameter(r27, "diggType");
        FeedPageConfig r2 = r25.getPageConfig();
        b.a(r25.getHostExtensionInfo());
        if (r2.isTeenagerModel() == false) goto L34;
        if (r28 == false) goto L7;
        return;
    L7:
        if (Intrinsics.areEqual(r25.sceneId(), "others_homepage") == true) goto L9;
    L14:
        String r12 = "";
    L15:
        d14.a r3 = b14.a.a;
        t24.a r6 = b14.a.a(t24.a.class);
        String r7 = r25.sceneId();
        User r0 = r26.f();
        if (r0 == null) goto L21;
        String r1 = r0.u();
        if (r1 == null) goto L21;
        String r8 = r1;
    L22:
        String r9 = r26.c();
        String r4 = b(r26, r2);
        if (r4 != null) goto L25;
        String r10 = "";
    L26:
        a0 r5 = r26.d;
        if (r5 == null) goto L32;
        String r11 = r5.a();
        if (r11 == null) goto L32;
        String r13 = r11;
    L33:
        r6.N1(r7, r8, r9, r10, r13, r12);
        return;
    L32:
        r13 = "";
        goto L33
    L25:
        r10 = r4;
    L21:
        r8 = "";
        goto L22
    L9:
        if ((r25 instanceof AosUserProfileFeedFragmentViewModel) == false) goto L11;
        AosUserProfileFeedFragmentViewModel r14 = (AosUserProfileFeedFragmentViewModel) r25;
    L12:
        if (r14 == null) goto L14;
        r12 = r14.getFromGroupId();
        goto L15
    L11:
        r14 = null;
        goto L12
    L34:
        int r15 = a.a[r27.ordinal()];
        if (r15 != 1) goto L37;
        String r16 = "detail_bottom_bar";
    L42:
        String r17 = r16;
        d14.a r18 = b14.a.a;
        t24.a r19 = b14.a.a(t24.a.class);
        String r20 = r25.sceneId();
        String r21 = r26.c();
        String r22 = b(r26, r2);
        if (r22 != null) goto L45;
        String r23 = "";
    L46:
        a0 r24 = r26.d;
        if (r24 == null) goto L52;
        String r29 = r24.a();
        if (r29 == null) goto L52;
        String r110 = r29;
    L53:
        String r111 = GsonProtectorUtils.toJson(GsonHolder.a(), r26.d);
        boolean r112 = e(r26);
        boolean r113 = r26.t;
        boolean r114 = r2.isCardMode();
        String r115 = r26.u();
        User r30 = r26.f();
        if (r30 == null) goto L59;
        String r31 = r30.u();
        if (r31 == null) goto L59;
        String r116 = r31;
    L60:
        String r32 = r2.getPreviousPage();
        if (r32 != null) goto L63;
        String r117 = "";
    L65:
        if (r26.W() == false) goto L67;
        String r33 = "origin";
    L68:
        String r210 = r33;
        User r34 = r26.f();
        if (r34 != null) goto L71;
    L73:
        boolean r211 = false;
    L74:
        String r212 = r2.getHostEnterFrom();
        JSONObject r213 = r25.getPageConfig().getHostExtraParams();
        r19.X(r28, r20, r21, r23, r110, r111, r17, r112, r113, r114, new e(r26), r115, r116, r117, r210, r211, r212, r213, "");
        return;
    L71:
        if (r34.R() != true) goto L73;
        r211 = true;
        goto L74
    L67:
        r33 = "sdk";
        goto L68
    L63:
        r117 = r32;
    L59:
        r116 = "";
    L52:
        r110 = "";
        goto L53
    L45:
        r23 = r22;
        goto L46
    L37:
        if (r15 != 2) goto L40;
        r16 = "double_like";
        goto L42
    L40:
        throw new NoWhenBranchMatchedException();
    }

    public static void L(com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a r34, jz3.a r35, long r36, String r38) {
        Intrinsics.checkNotNullParameter(r34, "feedGroupParameters");
        Intrinsics.checkNotNullParameter(r35, "data");
        if (r36 != 0) goto L5;
        return;
    L5:
        String r5 = r34.c.sceneId();
        String r27 = r34.c.getPageConfig().getHostEnterFrom();
        JSONObject r32 = r34.c.getPageConfig().getHostExtraParams();
        String r3 = null;
        if (Intrinsics.areEqual(r5, "others_homepage") == false) goto L13;
        o r2 = r34.c;
        if ((r2 instanceof AosUserProfileFeedFragmentViewModel) == false) goto L10;
        AosUserProfileFeedFragmentViewModel r4 = (AosUserProfileFeedFragmentViewModel) r2;
    L11:
        if (r4 == null) goto L13;
        String r12 = r4.getFromGroupId();
    L14:
        FeedPageConfig r6 = r34.c.getPageConfig();
        b.a(r34.c.getHostExtensionInfo());
        if (r6.isTeenagerModel() == false) goto L35;
        d14.a r0 = b14.a.a;
        t24.a r1 = b14.a.a(t24.a.class);
        User r7 = r35.a.f();
        if (r7 == null) goto L22;
        String r8 = r7.u();
        if (r8 == null) goto L22;
        String r9 = r8;
    L23:
        String r10 = r35.a.c();
        String r11 = b(r35.a, r6);
        if (r11 != null) goto L26;
        String r13 = "";
    L27:
        a0 r14 = r35.a.d;
        if (r14 == null) goto L33;
        String r15 = r14.a();
        if (r15 == null) goto L33;
        String r16 = r15;
    L34:
        r1.l3(r5, r9, r10, r13, r16, r36, r12, r35.a.t);
        return;
    L33:
        r16 = "";
        goto L34
    L26:
        r13 = r11;
    L22:
        r9 = "";
        goto L23
    L35:
        d14.a r17 = b14.a.a;
        t24.a r18 = b14.a.a(t24.a.class);
        String r19 = r35.a.c();
        String r20 = b(r35.a, r6);
        if (r20 != null) goto L38;
        r20 = "";
    L38:
        float r110 = r35.a.q() / 1000.0f;
        a0 r21 = r35.a.d;
        if (r21 == null) goto L44;
        String r22 = r21.a();
        if (r22 == null) goto L44;
        String r111 = r22;
    L45:
        String r112 = GsonProtectorUtils.toJson(GsonHolder.a(), r35.a.d);
        boolean r113 = e(r35.a);
        boolean r114 = r35.a.t;
        String r23 = r6.getPreviousPage();
        if (r23 != null) goto L48;
        String r24 = "";
    L50:
        if (r35.a.W() == false) goto L52;
        String r25 = "origin";
    L53:
        String r26 = r25;
        User r28 = r35.a.f();
        if (r28 == null) goto L59;
        String r29 = r28.u();
        if (r29 == null) goto L59;
        String r210 = r29;
    L60:
        boolean r115 = r6.isCardMode();
        a0 r30 = r35.a.d;
        if (r30 == null) goto L63;
        r3 = r30.a();
    L63:
        if (r3 != null) goto L65;
        String r211 = "";
    L66:
        String r31 = r35.a.r().d;
        if (r31 != null) goto L69;
        String r212 = "";
    L70:
        User r33 = r35.a.f();
        if (r33 != null) goto L73;
    L75:
        boolean r37 = false;
    L76:
        r18.b3(r5, r19, r20, r36, r110, r111, r12, r112, r113, r114, "", false, r115, 0, "", "", new e(r35.a), r24, r26, r210, r27, r211, r212, r38, r37, r32, "");
        return;
    L73:
        if (r33.R() != true) goto L75;
        r37 = true;
        goto L76
    L69:
        r212 = r31;
        goto L70
    L65:
        r211 = r3;
    L59:
        r210 = "";
        goto L60
    L52:
        r25 = "sdk";
        goto L53
    L48:
        r24 = r23;
    L44:
        r111 = "";
        goto L45
    L10:
        r4 = null;
    L13:
        r12 = "";
        goto L14
    }

    public static void q(o r24, c r25, DiggType r26, String r27) {
        Intrinsics.checkNotNullParameter(r24, "vm");
        Intrinsics.checkNotNullParameter(r25, "data");
        Intrinsics.checkNotNullParameter(r26, "diggType");
        Intrinsics.checkNotNullParameter(r27, "event");
        FeedPageConfig r1 = r24.getPageConfig();
        int r3 = a.a[r26.ordinal()];
        if (r3 != 1) goto L5;
        String r4 = "detail_bottom_bar";
    L10:
        String r10 = r4;
        d14.a r5 = b14.a.a;
        t24.a r6 = b14.a.a(t24.a.class);
        String r7 = r24.sceneId();
        String r8 = r25.c();
        String r9 = b(r25, r1);
        if (r9 != null) goto L13;
        r9 = "";
    L13:
        a0 r11 = r25.d;
        if (r11 == null) goto L17;
        String r12 = r11.a();
        if (r12 == null) goto L17;
    L18:
        String r13 = GsonProtectorUtils.toJson(GsonHolder.a(), r25.d);
        boolean r14 = e(r25);
        boolean r15 = r25.t;
        boolean r16 = r1.isCardMode();
        String r17 = r25.u();
        User r18 = r25.f();
        if (r18 == null) goto L24;
        String r19 = r18.u();
        if (r19 == null) goto L24;
        String r110 = r19;
    L25:
        String r111 = r1.getPreviousPage();
        if (r111 != null) goto L28;
        String r112 = "";
    L30:
        if (r25.W() == false) goto L32;
        String r20 = "origin";
    L33:
        String r22 = r20;
        User r21 = r25.f();
        if (r21 != null) goto L36;
    L38:
        boolean r23 = false;
    L39:
        String r28 = r1.getHostEnterFrom();
        JSONObject r29 = r24.getPageConfig().getHostExtraParams();
        String r30 = r9;
        String r31 = r12;
        r6.C(r27, r7, r8, r30, r31, r13, r10, r14, r15, r16, new e(r25), r17, r110, r112, r22, r23, r28, r29);
        return;
    L36:
        if (r21.R() != true) goto L38;
        r23 = true;
        goto L39
    L32:
        r20 = "sdk";
        goto L33
    L28:
        r112 = r111;
    L24:
        r110 = "";
    L17:
        r12 = "";
        goto L18
    L5:
        if (r3 != 2) goto L8;
        r4 = "double_like";
        goto L10
    L8:
        throw new NoWhenBranchMatchedException();
    }

    public static void v(String r11, String r12, String r13, c r14) {
        Intrinsics.checkNotNullParameter(r11, "enterFrom");
        Intrinsics.checkNotNullParameter(r12, "enterMethod");
        Intrinsics.checkNotNullParameter(r14, "aweme");
        d14.a r0 = b14.a.a;
        t24.a r1 = b14.a.a(t24.a.class);
        User r2 = r14.f();
        if (r2 == null) goto L8;
        String r3 = r2.u();
        if (r3 == null) goto L8;
        String r4 = r3;
    L9:
        String r5 = r14.c();
        String r6 = b(r14, null);
        if (r6 != null) goto L14;
        if (r13 != null) goto L13;
        String r7 = "";
    L15:
        a0 r15 = r14.d;
        if (r15 == null) goto L21;
        String r16 = r15.a();
        if (r16 == null) goto L21;
        String r8 = r16;
    L22:
        r1.S1(r11, r12, r4, r5, r7, r8, c(r14), e(r14), new e(r14));
        return;
    L21:
        r8 = "";
        goto L22
    L13:
        r7 = r13;
        goto L15
    L14:
        r7 = r6;
    L8:
        r4 = "";
        goto L9
    }

    public static void B(String r16, String r17, c r18, FollowType r19, String r20) {
        Intrinsics.checkNotNullParameter(r19, "followType");
        if (r18 != null) goto L5;
        return;
    L5:
        d14.a r1 = b14.a.a;
        t24.a r2 = b14.a.a(t24.a.class);
        if (r16 != null) goto L8;
        String r4 = "";
    L9:
        String r5 = r18.c();
        String r6 = b(r18, null);
        if (r6 != null) goto L14;
        if (r17 != null) goto L13;
        r6 = "";
        goto L14
    L13:
        r6 = r17;
    L14:
        a0 r7 = r18.d;
        if (r7 == null) goto L18;
        String r8 = r7.a();
        if (r8 == null) goto L18;
    L19:
        String r9 = c(r18);
        boolean r10 = e(r18);
        User r11 = r18.f();
        if (r11 == null) goto L23;
        String r12 = r11.u();
        if (r12 == null) goto L23;
    L25:
        if (r18.W() == false) goto L27;
        String r3 = "origin";
    L28:
        String r14 = r18.u();
        String r13 = r19.name();
        String r15 = r4;
        String r21 = r12;
        r2.a3(r15, r21, r5, r6, r8, r9, r10, r13, null, r20, r3, r14, Integer.valueOf(r18.i()));
        return;
    L27:
        r3 = "sdk";
    L23:
        r12 = "";
    L18:
        r8 = "";
        goto L19
    L8:
        r4 = r16;
        goto L9
    }

    public static void Q(com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a r18, jz3.a r19, String r20, float r21, long r22) {
        Intrinsics.checkNotNullParameter(r20, "enterMethod");
        if (r18 == null) goto L10;
        o r3 = r18.c;
        if (r3 == null) goto L10;
        String r4 = r3.sceneId();
        if (r4 == null) goto L10;
        String r5 = r4;
    L11:
        if (r18 == null) goto L15;
        o r0 = r18.c;
        if (r0 == null) goto L15;
        FeedPageConfig r1 = r0.getPageConfig();
    L16:
        if (r19 == null) goto L36;
        c r6 = r19.a;
        if (r6 == null) goto L37;
        d14.a r7 = b14.a.a;
        t24.a r8 = b14.a.a(t24.a.class);
        User r9 = r6.f();
        if (r9 == null) goto L23;
        String r10 = r9.u();
        if (r10 == null) goto L23;
    L24:
        String r11 = r6.c();
        a.getClass();
        String r2 = b(r6, r1);
        if (r2 != null) goto L27;
        r2 = "";
    L27:
        a0 r12 = r6.d;
        if (r12 == null) goto L33;
        String r13 = r12.a();
        if (r13 == null) goto L33;
        String r14 = r13;
    L34:
        String r15 = r10;
        String r16 = r2;
        r8.x(r5, r15, r11, r16, r14, c(r19.a), d(r19), r20, PinchEnterMethod.CLICK, "long_press_panel", r21, r22, null);
        return;
    L33:
        r14 = "";
    L23:
        r10 = "";
        goto L24
    L37:
        return;
    L36:
        return;
    L15:
        r1 = null;
    L10:
        r5 = "";
        goto L11
    }

    public static void x(long r9, int r11, String r12, String r13, String r14) {
        Intrinsics.checkNotNullParameter(r12, "scene");
        Intrinsics.checkNotNullParameter(r13, "loadingType");
        d14.a r0 = b14.a.a;
        b14.a.a(t24.a.class).J2(r9, r11, r12, r13, r14, null);
    }

    public static void O(boolean r10, int r11, String r12, String r13, long r14, int r16) {
        Intrinsics.checkNotNullParameter(r12, "enterAid");
        Intrinsics.checkNotNullParameter(r13, "enterLiveRoomId");
        d14.a r0 = b14.a.a;
        b14.a.a(t24.a.class).Z0(r10, r11, r12, r13, r14, r16, null);
    }

    public static void h(o r15, jz3.a r16, String r17, String r18, String r19, JSONObject r20) {
        Intrinsics.checkNotNullParameter(r17, "bar_name");
        Intrinsics.checkNotNullParameter("topic", "bar_type");
        Intrinsics.checkNotNullParameter(r18, "topic_id");
        Intrinsics.checkNotNullParameter(r19, "topic_name");
        String r1 = "";
        if (r15 == null) goto L8;
        String r2 = r15.sceneId();
        if (r2 == null) goto L8;
        String r3 = r2;
    L9:
        if (r15 == null) goto L11;
        FeedPageConfig r4 = r15.getPageConfig();
    L12:
        if (r16 == null) goto L37;
        c r5 = r16.a;
        if (r5 != null) goto L16;
        return;
    L16:
        if (r5.W() == false) goto L18;
        String r6 = "origin";
    L19:
        String r8 = r6;
        d14.a r7 = b14.a.a;
        t24.a r9 = b14.a.a(t24.a.class);
        User r10 = r5.f();
        if (r10 == null) goto L23;
        String r11 = r10.u();
        if (r11 == null) goto L23;
    L24:
        String r12 = r5.c();
        a0 r13 = r5.d;
        if (r13 == null) goto L28;
        String r14 = r13.a();
        if (r14 == null) goto L28;
    L29:
        AosEventReporter r110 = a;
        c r0 = r16.a;
        r110.getClass();
        String r21 = c(r0);
        if (r4 == null) goto L35;
        String r22 = r4.getPreviousPage();
        if (r22 == null) goto L35;
        r1 = r22;
    L35:
        String r111 = r5.u();
        r9.L2(r3, r11, r12, r14, r21, r8, r1, r17, r18, r19, r111, r20);
        return;
    L28:
        r14 = "";
    L23:
        r11 = "";
        goto L24
    L18:
        r6 = "sdk";
        goto L19
    L37:
        return;
    L11:
        r4 = null;
    L8:
        r3 = "";
        goto L9
    }

    public static void i(o r15, jz3.a r16, String r17, String r18, String r19, JSONObject r20) {
        Intrinsics.checkNotNullParameter(r17, "bar_name");
        Intrinsics.checkNotNullParameter("topic", "bar_type");
        Intrinsics.checkNotNullParameter(r18, "topic_id");
        Intrinsics.checkNotNullParameter(r19, "topic_name");
        String r1 = "";
        if (r15 == null) goto L8;
        String r2 = r15.sceneId();
        if (r2 == null) goto L8;
        String r3 = r2;
    L9:
        if (r15 == null) goto L11;
        FeedPageConfig r4 = r15.getPageConfig();
    L12:
        if (r16 == null) goto L37;
        c r5 = r16.a;
        if (r5 != null) goto L16;
        return;
    L16:
        if (r5.W() == false) goto L18;
        String r6 = "origin";
    L19:
        String r8 = r6;
        d14.a r7 = b14.a.a;
        t24.a r9 = b14.a.a(t24.a.class);
        User r10 = r5.f();
        if (r10 == null) goto L23;
        String r11 = r10.u();
        if (r11 == null) goto L23;
    L24:
        String r12 = r5.c();
        a0 r13 = r5.d;
        if (r13 == null) goto L28;
        String r14 = r13.a();
        if (r14 == null) goto L28;
    L29:
        AosEventReporter r110 = a;
        c r0 = r16.a;
        r110.getClass();
        String r21 = c(r0);
        if (r4 == null) goto L35;
        String r22 = r4.getPreviousPage();
        if (r22 == null) goto L35;
        r1 = r22;
    L35:
        String r111 = r5.u();
        r9.R(r3, r11, r12, r14, r21, r8, r1, r17, r18, r19, r111, r20);
        return;
    L28:
        r14 = "";
    L23:
        r11 = "";
        goto L24
    L18:
        r6 = "sdk";
        goto L19
    L37:
        return;
    L11:
        r4 = null;
    L8:
        r3 = "";
        goto L9
    }

    public static void D(o r19, c r20, String r21, String r22, int r23, int r24, JSONObject r25) {
        Intrinsics.checkNotNullParameter("", "from_group_id");
        Intrinsics.checkNotNullParameter(r21, "component_type");
        Intrinsics.checkNotNullParameter(r22, "content_id");
        if (r19 == null) goto L8;
        String r2 = r19.sceneId();
        if (r2 == null) goto L8;
        String r5 = r2;
    L9:
        FeedPageConfig r4 = null;
        if (Intrinsics.areEqual(r5, "others_homepage") == true) goto L12;
    L17:
        String r12 = "";
    L18:
        if (r19 == null) goto L20;
        r4 = r19.getPageConfig();
    L20:
        if (r20 != null) goto L22;
        return;
    L22:
        if (r20.W() == false) goto L24;
        String r0 = "origin";
    L25:
        String r10 = r0;
        d14.a r1 = b14.a.a;
        t24.a r3 = b14.a.a(t24.a.class);
        User r6 = r20.f();
        if (r6 == null) goto L31;
        String r7 = r6.u();
        if (r7 == null) goto L31;
        String r8 = r7;
    L32:
        String r9 = r20.c();
        a0 r11 = r20.d;
        if (r11 == null) goto L38;
        String r13 = r11.a();
        if (r13 == null) goto L38;
        String r14 = r13;
    L39:
        a.getClass();
        String r15 = c(r20);
        if (r4 == null) goto L45;
        String r16 = r4.getPreviousPage();
        if (r16 == null) goto L45;
        String r17 = r16;
    L46:
        r3.r(r5, r8, r9, r14, r15, r10, r17, r12, r21, r22, r23, r24, r20.u(), r25);
        return;
    L45:
        r17 = "";
    L38:
        r14 = "";
    L31:
        r8 = "";
        goto L32
    L24:
        r0 = "sdk";
        goto L25
    L12:
        if ((r19 instanceof AosUserProfileFeedFragmentViewModel) == false) goto L14;
        AosUserProfileFeedFragmentViewModel r18 = (AosUserProfileFeedFragmentViewModel) r19;
    L15:
        if (r18 == null) goto L17;
        r12 = r18.getFromGroupId();
        goto L18
    L14:
        r18 = null;
    L8:
        r5 = "";
        goto L9
    }

    public static void k(com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a r17, jz3.a r18, String r19, float r20, boolean r21, String r22, String r23) {
        Intrinsics.checkNotNullParameter(r19, "enterMethod");
        Intrinsics.checkNotNullParameter(r22, "speedMethod");
        Intrinsics.checkNotNullParameter(r23, "speedPosition");
        if (r17 == null) goto L10;
        o r3 = r17.c;
        if (r3 == null) goto L10;
        String r4 = r3.sceneId();
        if (r4 == null) goto L10;
        String r5 = r4;
    L11:
        if (r17 == null) goto L15;
        o r0 = r17.c;
        if (r0 == null) goto L15;
        FeedPageConfig r1 = r0.getPageConfig();
    L16:
        if (r18 == null) goto L34;
        c r6 = r18.a;
        if (r6 == null) goto L35;
        d14.a r7 = b14.a.a;
        t24.a r8 = b14.a.a(t24.a.class);
        User r9 = r6.f();
        if (r9 == null) goto L23;
        String r10 = r9.u();
        if (r10 == null) goto L23;
    L24:
        String r11 = r6.c();
        a.getClass();
        String r2 = b(r6, r1);
        if (r2 != null) goto L27;
        r2 = "";
    L27:
        a0 r12 = r6.d;
        if (r12 == null) goto L31;
        String r13 = r12.a();
        if (r13 == null) goto L31;
    L32:
        String r14 = r10;
        String r15 = r2;
        r8.x1(r5, r14, r11, r15, r13, c(r18.a), d(r18), r19, r22, r23, r20, r21, new e(r6));
        return;
    L31:
        r13 = "";
    L23:
        r10 = "";
        goto L24
    L35:
        return;
    L34:
        return;
    L15:
        r1 = null;
    L10:
        r5 = "";
        goto L11
    }

    public static void s(AosEventReporter r1, String r2, Map r3, String r4, JSONObject r5, e r6, int r7) {
        if ((r7 & 4) == 0) goto L6;
        r4 = null;
    L6:
        if ((r7 & 8) == 0) goto L8;
        r5 = null;
    L8:
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, "eventName");
        d14.a r8 = b14.a.a;
        b14.a.a(t24.a.class).D(r2, r3, r4, r5);
    }

    public static void u(c r22, String r23, String r24, boolean r25, String r26, String r27, JSONObject r28) {
        d14.a r1 = b14.a.a;
        t24.a r2 = b14.a.a(t24.a.class);
        User r3 = r22.f();
        if (r3 == null) goto L8;
        String r4 = r3.u();
        if (r4 == null) goto L8;
        String r5 = r4;
    L9:
        String r6 = r22.c();
        if (r24 != null) goto L12;
        String r7 = "";
    L13:
        a0 r8 = r22.d;
        if (r8 == null) goto L19;
        String r9 = r8.a();
        if (r9 == null) goto L19;
        String r10 = r9;
    L20:
        String r11 = c(r22);
        boolean r12 = e(r22);
        if (r22.W() == false) goto L23;
        String r13 = "origin";
    L24:
        String r14 = r13;
        String r15 = r22.u();
        if (r26 != null) goto L27;
        String r16 = "";
    L28:
        ShoppingCardInfo r17 = (ShoppingCardInfo) CollectionsKt.firstOrNull(r22.K());
        if (r17 == null) goto L34;
        String r18 = r17.getProductId();
        if (r18 == null) goto L34;
        String r19 = r18;
    L35:
        String r20 = r22.e();
        if (r20 != null) goto L38;
        String r110 = "";
    L39:
        d r21 = r22.d();
        if (r21 == null) goto L42;
        Integer r29 = r21.getType();
    L43:
        Integer r111 = r29;
        User r30 = r22.f();
        if (r30 != null) goto L46;
    L48:
        boolean r112 = false;
    L49:
        Map r210 = r22.b0();
        String r31 = r5;
        String r32 = r7;
        String r33 = r10;
        r2.E2(r23, r31, r6, r32, r33, r11, r12, r25, r14, "long_press", new e(r22), r15, r16, r19, r110, r111, r27, r112, r28, r210);
        return;
    L46:
        if (r30.R() != true) goto L48;
        r112 = true;
        goto L49
    L42:
        r29 = null;
        goto L43
    L38:
        r110 = r20;
    L34:
        r19 = "";
        goto L35
    L27:
        r16 = r26;
        goto L28
    L23:
        r13 = "sdk";
    L19:
        r10 = "";
        goto L20
    L12:
        r7 = r24;
    L8:
        r5 = "";
        goto L9
    }

    public static void C(o r19, c r20, String r21, String r22, String r23, int r24, int r25, JSONObject r26) {
        Intrinsics.checkNotNullParameter(r21, "component_type");
        Intrinsics.checkNotNullParameter(r22, "content_id");
        Intrinsics.checkNotNullParameter(r23, "click_area");
        if (r19 == null) goto L8;
        String r3 = r19.sceneId();
        if (r3 == null) goto L8;
        String r4 = r3;
    L10:
        if (Intrinsics.areEqual(r4, "others_homepage") == true) goto L12;
    L17:
        String r11 = "";
    L18:
        if (r20 == null) goto L43;
        d14.a r5 = b14.a.a;
        t24.a r6 = b14.a.a(t24.a.class);
        User r7 = r20.f();
        if (r7 == null) goto L23;
        String r8 = r7.u();
        if (r8 == null) goto L23;
    L24:
        String r9 = r20.c();
        a0 r10 = r20.d;
        if (r10 == null) goto L28;
        String r12 = r10.a();
        if (r12 == null) goto L28;
    L29:
        a.getClass();
        String r13 = c(r20);
        if (r20.W() == false) goto L32;
        String r14 = "origin";
    L33:
        if (r19 == null) goto L40;
        FeedPageConfig r0 = r19.getPageConfig();
        if (r0 == null) goto L40;
        String r1 = r0.getPreviousPage();
        if (r1 == null) goto L40;
        String r15 = r1;
    L41:
        r6.y2(r4, r8, r9, r12, r13, r14, r15, r11, r21, r22, r24, r25, r23, r20.u(), r26);
        return;
    L40:
        r15 = "";
        goto L41
    L32:
        r14 = "sdk";
    L28:
        r12 = "";
    L23:
        r8 = "";
        goto L24
    L43:
        return;
    L12:
        if ((r19 instanceof AosUserProfileFeedFragmentViewModel) == false) goto L14;
        AosUserProfileFeedFragmentViewModel r16 = (AosUserProfileFeedFragmentViewModel) r19;
    L15:
        if (r16 == null) goto L17;
        r11 = r16.getFromGroupId();
        goto L18
    L14:
        r16 = null;
    L8:
        r4 = "";
        goto L10
    }

    public static void I(String r11, String r12, String r13, String r14, String r15, String r16, String r17, JSONObject r18) {
        Intrinsics.checkNotNullParameter(r11, "enterFromMerge");
        Intrinsics.checkNotNullParameter(r12, "enterMethod");
        Intrinsics.checkNotNullParameter(PinchEnterMethod.CLICK, "actionType");
        Intrinsics.checkNotNullParameter(r13, "anchorId");
        Intrinsics.checkNotNullParameter(r14, "roomId");
        Intrinsics.checkNotNullParameter("", "fromRoomId");
        Intrinsics.checkNotNullParameter(r15, "requestId");
        Intrinsics.checkNotNullParameter(r16, "anchorAid");
        Intrinsics.checkNotNullParameter(r17, "xgUid");
        Intrinsics.checkNotNullParameter("sdk_video", "videoSource");
        d14.a r0 = b14.a.a;
        b14.a.a(t24.a.class).F1(r11, r12, r13, r14, r15, r16, r17, null, r18);
    }

    public static void J(String r10, String r11, String r12, String r13, float r14, float r15, String r16, e r17) {
        Intrinsics.checkNotNullParameter(r10, "authorOpenId");
        Intrinsics.checkNotNullParameter(r11, "enterFrom");
        Intrinsics.checkNotNullParameter(r12, "groupId");
        Intrinsics.checkNotNullParameter(r13, "imprId");
        d14.a r0 = b14.a.a;
        b14.a.a(t24.a.class).S(r10, r11, r12, r13, r16, r14, r15, r17);
    }

    public static /* synthetic */ void p(AosEventReporter r10, String r11, String r12, String r13, String r14, c r15, FollowType r16, String r17, boolean r18) {
        r10.getClass();
        o(r11, r12, r13, r14, r15, r16, r17, false, r18, null);
    }

    public static void K(String r20, c r21, String r22, String r23, boolean r24, String r25, String r26, String r27, double r28, int r30) {
        Intrinsics.checkNotNullParameter(r20, "sceneId");
        Intrinsics.checkNotNullParameter(r21, "aweme");
        Intrinsics.checkNotNullParameter(r22, "enterMethod");
        Intrinsics.checkNotNullParameter(r23, "slideDirection");
        Intrinsics.checkNotNullParameter(r25, "photoSerialNum");
        Intrinsics.checkNotNullParameter(r26, "allPhotoNum");
        Intrinsics.checkNotNullParameter(r27, "previousPage");
        d14.a r1 = b14.a.a;
        t24.a r2 = b14.a.a(t24.a.class);
        User r3 = r21.f();
        if (r3 == null) goto L6;
        String r4 = r3.u();
        if (r4 == null) goto L6;
    L7:
        String r5 = r21.c();
        String r6 = r21.r().c;
        if (r6 != null) goto L10;
        r6 = "";
    L10:
        String r10 = GsonProtectorUtils.toJson(GsonHolder.a(), r21.d);
        a0 r9 = r21.d;
        if (r9 == null) goto L14;
        String r11 = r9.a();
        if (r11 == null) goto L14;
    L15:
        String r7 = r4;
        r2.Z1(r20, r7, r5, r6, r22, r23, r11, r10, e(r21), r24, r25, r26, r27, r28, r30, new e(r21));
        return;
    L14:
        r11 = "";
    L6:
        r4 = "";
        goto L7
    }

    public static void o(String r22, String r23, String r24, String r25, c r26, FollowType r27, String r28, boolean r29, boolean r30, JSONObject r31) {
        Intrinsics.checkNotNullParameter(r22, "evenName");
        Intrinsics.checkNotNullParameter(r27, "followType");
        if (r26 != null) goto L5;
        return;
    L5:
        d14.a r1 = b14.a.a;
        t24.a r2 = b14.a.a(t24.a.class);
        if (r23 != null) goto L8;
        String r5 = "";
    L9:
        User r6 = r26.f();
        if (r6 == null) goto L13;
        String r7 = r6.u();
        if (r7 == null) goto L13;
    L14:
        String r8 = r26.c();
        String r9 = b(r26, null);
        if (r9 != null) goto L19;
        if (r25 != null) goto L18;
        r9 = "";
        goto L19
    L18:
        r9 = r25;
    L19:
        a0 r10 = r26.d;
        if (r10 == null) goto L23;
        String r11 = r10.a();
        if (r11 == null) goto L23;
    L24:
        String r12 = c(r26);
        int r13 = r26.i();
        boolean r14 = e(r26);
        if (r26.W() == false) goto L27;
        String r15 = "origin";
    L28:
        String r17 = r15;
        String r18 = r26.u();
        String r16 = r27.name();
        boolean r0 = r26.t;
        if (r28 != null) goto L31;
        String r19 = "";
    L32:
        r2.W0(r22, r5, r7, r8, r9, r11, r12, r13, r14, r16, r0, r29, null, r19, r17, r18, r24, r31, r30);
        return;
    L31:
        r19 = r28;
        goto L32
    L27:
        r15 = "sdk";
    L23:
        r11 = "";
    L13:
        r7 = "";
        goto L14
    L8:
        r5 = r23;
        goto L9
    }

    public static void y(String r21, String r22, String r23, c r24, FollowType r25, String r26, boolean r27, boolean r28, JSONObject r29, String r30) {
        Intrinsics.checkNotNullParameter(r25, "followType");
        if (r24 != null) goto L5;
        return;
    L5:
        d14.a r1 = b14.a.a;
        t24.a r2 = b14.a.a(t24.a.class);
        if (r21 != null) goto L8;
        String r4 = "";
    L9:
        User r5 = r24.f();
        if (r5 == null) goto L13;
        String r6 = r5.u();
        if (r6 == null) goto L13;
    L14:
        String r7 = r24.c();
        String r8 = b(r24, null);
        if (r8 != null) goto L19;
        if (r23 != null) goto L18;
        r8 = "";
        goto L19
    L18:
        r8 = r23;
    L19:
        a0 r9 = r24.d;
        if (r9 == null) goto L23;
        String r10 = r9.a();
        if (r10 == null) goto L23;
    L24:
        String r11 = c(r24);
        boolean r12 = e(r24);
        if (r24.W() == false) goto L27;
        String r13 = "origin";
    L28:
        String r15 = r13;
        String r16 = r24.u();
        String r14 = r25.name();
        boolean r17 = r24.t;
        if (r26 != null) goto L31;
        String r18 = "";
    L32:
        String r3 = r4;
        String r19 = r6;
        String r20 = r8;
        String r31 = r10;
        r2.b0(r3, r19, r7, r20, r31, r11, r12, r14, r17, r27, new e(r24), r18, r15, r16, r22, r29, r28, r30);
        return;
    L31:
        r18 = r26;
        goto L32
    L27:
        r13 = "sdk";
    L23:
        r10 = "";
    L13:
        r6 = "";
        goto L14
    L8:
        r4 = r21;
        goto L9
    }

    public static /* synthetic */ void H(AosEventReporter r13, String r14, String r15, String r16, String r17, String r18, String r19, String r20, String r21, String r22, String r23) {
        r13.getClass();
        G(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, null, "", "");
    }

    public static void w(String r22, String r23, c r24, String r25, String r26, String r27, EnterPersonalDetail r28, String r29, boolean r30, String r31, JSONObject r32) {
        Intrinsics.checkNotNullParameter(r22, "sceneId");
        Intrinsics.checkNotNullParameter(r24, "aweme");
        Intrinsics.checkNotNullParameter(r26, "enterMethod");
        Intrinsics.checkNotNullParameter(r27, "toUserId");
        Intrinsics.checkNotNullParameter(r28, "position");
        d14.a r1 = b14.a.a;
        t24.a r2 = b14.a.a(t24.a.class);
        String r5 = r24.c();
        String r6 = b(r24, null);
        if (r6 != null) goto L7;
        if (r25 != null) goto L6;
        r6 = "";
        goto L7
    L6:
        r6 = r25;
    L7:
        a0 r9 = r24.d;
        if (r9 == null) goto L11;
        String r10 = r9.a();
        if (r10 == null) goto L11;
    L12:
        String r11 = c(r24);
        boolean r12 = e(r24);
        String r13 = r28.name();
        String r14 = r24.u();
        User r3 = r24.f();
        if (r3 == null) goto L18;
        String r4 = r3.u();
        if (r4 == null) goto L18;
        String r15 = r4;
    L19:
        if (r29 != null) goto L21;
        String r16 = "";
    L23:
        if (r24.W() == false) goto L25;
        String r7 = "origin";
    L26:
        String r17 = r7;
        User r8 = r24.f();
        if (r8 != null) goto L29;
    L31:
        boolean r20 = false;
    L32:
        String r18 = r10;
        r2.V1(r22, r26, r5, r6, r27, r18, r11, r12, r30, r13, new e(r24), r14, r15, r16, r17, r23, r31, r20, r32);
        return;
    L29:
        if (r8.R() != true) goto L31;
        r20 = true;
        goto L32
    L25:
        r7 = "sdk";
        goto L26
    L21:
        r16 = r29;
    L18:
        r15 = "";
    L11:
        r10 = "";
        goto L12
    }

    public static /* synthetic */ void z(AosEventReporter r13, String r14, String r15, String r16, c r17, FollowType r18, String r19, boolean r20, boolean r21, JSONObject r22, int r23) {
        if ((r23 & 64) == 0) goto L5;
        boolean r9 = false;
    L7:
        if ((r23 & 128) == 0) goto L9;
        boolean r10 = false;
    L11:
        if ((r23 & 256) == 0) goto L13;
        JSONObject r11 = null;
    L14:
        r13.getClass();
        y(r14, r15, r16, r17, r18, r19, r9, r10, r11, null);
        return;
    L13:
        r11 = r22;
        goto L14
    L9:
        r10 = r21;
        goto L11
    L5:
        r9 = r20;
        goto L7
    }

    public static void A(AosEventReporter r19, String r20, String r21, String r22, String r23, String r24, String r25, boolean r26, FollowType r27, String r28, boolean r29, JSONObject r30, int r31) {
        if ((r31 & 128) == 0) goto L5;
        boolean r9 = false;
    L7:
        if ((r31 & 512) == 0) goto L9;
        String r1 = "";
    L11:
        if ((r31 & 1024) == 0) goto L13;
        boolean r16 = false;
    L15:
        if ((r31 & 2048) == 0) goto L17;
        JSONObject r15 = null;
    L18:
        r19.getClass();
        Intrinsics.checkNotNullParameter(r25, "logPb");
        Intrinsics.checkNotNullParameter(r27, "followType");
        d14.a r0 = b14.a.a;
        t24.a r2 = b14.a.a(t24.a.class);
        if (r20 != null) goto L21;
        String r4 = "";
    L22:
        if (r23 != null) goto L24;
        String r7 = "";
    L25:
        String r11 = r27.name();
        if (r22 != null) goto L28;
        String r12 = "";
    L29:
        if (r1 != null) goto L31;
        String r18 = "";
    L32:
        t24.a.a.g(r2, r4, r7, r24, r21, r25, false, r11, false, r9, null, r12, r18, "", "", r15, r16, 147968);
        return;
    L31:
        r18 = r1;
        goto L32
    L28:
        r12 = r22;
        goto L29
    L24:
        r7 = r23;
        goto L25
    L21:
        r4 = r20;
        goto L22
    L17:
        r15 = r30;
        goto L18
    L13:
        r16 = r29;
        goto L15
    L9:
        r1 = r28;
        goto L11
    L5:
        r9 = r26;
        goto L7
    }

    public static void G(String r16, String r17, String r18, String r19, String r20, String r21, String r22, String r23, String r24, String r25, JSONObject r26, String r27, String r28) {
        Intrinsics.checkNotNullParameter(r16, "enterFromMerge");
        Intrinsics.checkNotNullParameter(r17, "enterMethod");
        Intrinsics.checkNotNullParameter(PinchEnterMethod.CLICK, "actionType");
        Intrinsics.checkNotNullParameter(r18, "aoEnterFromMerge");
        Intrinsics.checkNotNullParameter(r19, "aoEnterMethod");
        Intrinsics.checkNotNullParameter(r20, "aoActionType");
        Intrinsics.checkNotNullParameter(r21, "anchorId");
        Intrinsics.checkNotNullParameter(r22, "roomId");
        Intrinsics.checkNotNullParameter("", "fromRoomId");
        Intrinsics.checkNotNullParameter(r23, "requestId");
        Intrinsics.checkNotNullParameter(r24, "anchorAid");
        Intrinsics.checkNotNullParameter(r25, "xgUid");
        Intrinsics.checkNotNullParameter("sdk_video", "videoSource");
        Intrinsics.checkNotNullParameter(r27, "itemId");
        Intrinsics.checkNotNullParameter(r28, "enterRequestId");
        d14.a r0 = b14.a.a;
        b14.a.a(t24.a.class).D2(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, null, r26, r27, r28);
    }
}
