package com.bytedance.awemeopen.apps.framework.feed;

import android.text.TextUtils;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.p;
import com.bytedance.awemeopen.apps.framework.feed.profile.AosUserProfileFeedFragmentViewModel;
import com.bytedance.awemeopen.apps.framework.feed.ui.information.bottomcomponent.b;
import com.bytedance.awemeopen.apps.framework.feed.ui.rightbar.digg.DiggType;
import com.bytedance.awemeopen.apps.framework.framework.viewpager.o;
import com.bytedance.awemeopen.apps.framework.utils.e;
import com.bytedance.awemeopen.bizmodels.feed.shopping.card.ShoppingCardInfo;
import com.bytedance.awemeopen.bizmodels.profile.User;
import com.bytedance.awemeopen.domain.base.repo.GsonHolder;
import com.bytedance.awemeopen.export.api.pageconfig.recfeed.FeedPageConfig;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.larus.bmhome.share.panel.ShareChannel;
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

/* JADX INFO: loaded from: classes14.dex */
public final class AosEventReporter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AosEventReporter f194596a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f194597b = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/feed/AosEventReporter$EnterPersonalDetail;", "", "slide", "click_avatar", "click_name", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
    public static final enum EnterPersonalDetail extends Enum<EnterPersonalDetail> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ EnterPersonalDetail[] f194598a = null;
        public static final EnterPersonalDetail click_avatar = null;
        public static final EnterPersonalDetail click_name = null;
        public static final EnterPersonalDetail slide = null;

        public static EnterPersonalDetail valueOf(String r100) {
            return (EnterPersonalDetail) r27.a.a(EnterPersonalDetail.class, r100);
        }

        public static EnterPersonalDetail[] values() {
            return (EnterPersonalDetail[]) f194598a.clone();
        }

        static {
            EnterPersonalDetail r100 = new EnterPersonalDetail("slide", 0);
            slide = r100;
            EnterPersonalDetail r101 = new EnterPersonalDetail("click_avatar", 1);
            click_avatar = r101;
            EnterPersonalDetail r102 = new EnterPersonalDetail("click_name", 2);
            click_name = r102;
            f194598a = new EnterPersonalDetail[]{r100, r101, r102};
        }

        public EnterPersonalDetail(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/feed/AosEventReporter$FollowType;", "", "from_group", "from_profile", "from_graphic", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
    public static final enum FollowType extends Enum<FollowType> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ FollowType[] f194599a = null;
        public static final FollowType from_graphic = null;
        public static final FollowType from_group = null;
        public static final FollowType from_profile = null;

        public static FollowType valueOf(String r100) {
            return (FollowType) r27.a.a(FollowType.class, r100);
        }

        public static FollowType[] values() {
            return (FollowType[]) f194599a.clone();
        }

        static {
            FollowType r100 = new FollowType("from_group", 0);
            from_group = r100;
            FollowType r101 = new FollowType("from_profile", 1);
            from_profile = r101;
            FollowType r102 = new FollowType("from_graphic", 2);
            from_graphic = r102;
            f194599a = new FollowType[]{r100, r101, r102};
        }

        public FollowType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f194600a = null;

        static {
            int[] r100 = new int[DiggType.values().length];
            r100[DiggType.from_click_right_bar.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[DiggType.from_double_click_video.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f194600a = r100;
        }
    }

    public AosEventReporter() {
    }

    static {
        f194596a = new AosEventReporter();
        String r100 = Reflection.getOrCreateKotlinClass(AosEventReporter.class).getSimpleName();
        if (r100 != null) goto L5;
        r100 = "AosEventReporter";
    L5:
        f194597b = r100;
    }

    public static String c(c r100) {
        return GsonProtectorUtils.toJson(GsonHolder.a(), r100.f535622d);
    }

    public static boolean d(jz3.a r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        return e(r100.f501173a);
    }

    public static boolean e(c r100) {
        Intrinsics.checkNotNullParameter(r100, ShareChannel.DOUYIN);
        User r101 = r100.f();
        if (r101 != null) goto L7;
        return false;
    L7:
        return r101.O();
    }

    public static void F(o r210, c r211) {
        Intrinsics.checkNotNullParameter(r210, "vm");
        Intrinsics.checkNotNullParameter(r211, "data");
        FeedPageConfig r100 = r210.getPageConfig();
        b.a(r210.getHostExtensionInfo());
        if (r100.isTeenagerModel() == true) goto L5;
        d14.a r101 = b14.a.f16924a;
        t24.a r102 = (t24.a) b14.a.a(t24.a.class);
        String r103 = r210.sceneId();
        String r104 = r211.c();
        String r105 = b(r211, r100);
        if (r105 != null) goto L35;
        r105 = "";
    L35:
        boolean r110 = r211.f535638t;
        boolean r111 = r100.isCardMode();
        a0 r106 = r211.f535622d;
        if (r106 == null) goto L39;
        String r107 = r106.a();
        if (r107 == null) goto L39;
    L40:
        String r108 = GsonProtectorUtils.toJson(GsonHolder.a(), r211.f535622d);
        boolean r112 = e(r211);
        String r113 = r211.u();
        User r114 = r211.f();
        if (r114 == null) goto L46;
        String r115 = r114.u();
        if (r115 == null) goto L46;
        String r116 = r115;
    L47:
        String r109 = r100.getPreviousPage();
        if (r109 != null) goto L50;
        String r117 = "";
    L51:
        User r118 = r211.f();
        if (r118 != null) goto L54;
    L56:
        boolean r119 = false;
    L58:
        if (r211.W() == false) goto L60;
        String r120 = PlayerResolution.SDKKEY.ORIGIN;
    L61:
        JSONObject r121 = r210.getPageConfig().getHostExtraParams();
        e r122 = new e(r211);
        r102.e2(r103, r104, r105, r107, r108, r112, r110, r111, r122, r113, r116, r117, r120, r121, r119, "");
        return;
    L60:
        r120 = "sdk";
        goto L61
    L54:
        if (r118.R() != true) goto L56;
        r119 = true;
        goto L58
    L50:
        r117 = r109;
    L46:
        r116 = "";
    L39:
        r107 = "";
        goto L40
    L5:
        if (Intrinsics.areEqual(r210.sceneId(), "others_homepage") == true) goto L7;
    L12:
        String r123 = "";
    L13:
        d14.a r124 = b14.a.f16924a;
        t24.a r125 = (t24.a) b14.a.a(t24.a.class);
        String r126 = r210.sceneId();
        User r127 = r211.f();
        if (r127 == null) goto L19;
        String r128 = r127.u();
        if (r128 == null) goto L19;
        String r129 = r128;
    L20:
        String r130 = r211.c();
        String r131 = b(r211, r100);
        if (r131 != null) goto L23;
        String r132 = "";
    L24:
        a0 r133 = r211.f535622d;
        if (r133 == null) goto L30;
        String r134 = r133.a();
        if (r134 == null) goto L30;
        String r135 = r134;
    L31:
        r125.K2(r126, r129, r130, r132, r135, r123);
        return;
    L30:
        r135 = "";
        goto L31
    L23:
        r132 = r131;
    L19:
        r129 = "";
        goto L20
    L7:
        if ((r210 instanceof AosUserProfileFeedFragmentViewModel) == false) goto L9;
        AosUserProfileFeedFragmentViewModel r136 = (AosUserProfileFeedFragmentViewModel) r210;
    L10:
        if (r136 == null) goto L12;
        r123 = r136.getFromGroupId();
        goto L13
    L9:
        r136 = null;
        goto L10
    }

    public static void P(o r110, c r111) {
        Intrinsics.checkNotNullParameter(r110, "vm");
        if (r111 != null) goto L6;
        return;
    L6:
        if (Intrinsics.areEqual(r110.sceneId(), "others_homepage") == true) goto L8;
    L13:
        String r100 = "";
    L14:
        d14.a r101 = b14.a.f16924a;
        t24.a r102 = (t24.a) b14.a.a(t24.a.class);
        String r103 = r110.sceneId();
        if (r103 != null) goto L17;
        String r104 = "";
    L18:
        User r105 = r111.f();
        if (r105 == null) goto L24;
        String r106 = r105.u();
        if (r106 == null) goto L24;
        String r107 = r106;
    L25:
        String r108 = r111.c();
        a0 r109 = r111.f535622d;
        if (r109 == null) goto L31;
        String r112 = r109.a();
        if (r112 == null) goto L31;
        String r113 = r112;
    L32:
        r102.r1(r104, r107, r108, r113, r100, r110.getPageConfig().getHostExtraParams(), new e(r111));
        return;
    L31:
        r113 = "";
    L24:
        r107 = "";
        goto L25
    L17:
        r104 = r103;
        goto L18
    L8:
        if ((r110 instanceof AosUserProfileFeedFragmentViewModel) == false) goto L10;
        AosUserProfileFeedFragmentViewModel r114 = (AosUserProfileFeedFragmentViewModel) r110;
    L11:
        if (r114 == null) goto L13;
        r100 = r114.getFromGroupId();
        goto L14
    L10:
        r114 = null;
        goto L11
    }

    public static void S(com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a r210, jz3.a r211) {
        Intrinsics.checkNotNullParameter(r210, "feedGroupParameters");
        Intrinsics.checkNotNullParameter(r211, "data");
        String r100 = r210.f195163c.sceneId();
        String r101 = null;
        if (Intrinsics.areEqual(r100, "others_homepage") == false) goto L10;
        o r102 = r210.f195163c;
        if ((r102 instanceof AosUserProfileFeedFragmentViewModel) == false) goto L7;
        AosUserProfileFeedFragmentViewModel r103 = (AosUserProfileFeedFragmentViewModel) r102;
    L8:
        if (r103 == null) goto L10;
        String r104 = r103.getFromGroupId();
    L11:
        FeedPageConfig r105 = r210.f195163c.getPageConfig();
        JSONObject r212 = r105.getHostExtraParams();
        b.a(r210.f195163c.getHostExtensionInfo());
        if (r105.isTeenagerModel() == false) goto L30;
        d14.a r106 = b14.a.f16924a;
        t24.a r107 = (t24.a) b14.a.a(t24.a.class);
        User r108 = r211.f501173a.f();
        if (r108 == null) goto L17;
        String r109 = r108.u();
        if (r109 == null) goto L17;
    L18:
        String r110 = r211.f501173a.c();
        String r111 = b(r211.f501173a, r105);
        if (r111 != null) goto L21;
        String r112 = "";
    L22:
        a0 r113 = r211.f501173a.f535622d;
        if (r113 == null) goto L28;
        String r114 = r113.a();
        if (r114 == null) goto L28;
        String r115 = r114;
    L29:
        r107.d0(r100, r109, r110, r112, r115, r104, r211.f501173a.f535638t);
        return;
    L28:
        r115 = "";
        goto L29
    L21:
        r112 = r111;
    L17:
        r109 = "";
        goto L18
    L30:
        d14.a r116 = b14.a.f16924a;
        t24.a r117 = (t24.a) b14.a.a(t24.a.class);
        String r118 = r211.f501173a.c();
        String r119 = b(r211.f501173a, r105);
        if (r119 != null) goto L33;
        r119 = "";
    L33:
        a0 r120 = r211.f501173a.f535622d;
        if (r120 == null) goto L37;
        String r121 = r120.a();
        if (r121 == null) goto L37;
    L38:
        boolean r122 = r211.f501179g;
        c r123 = r211.f501173a;
        boolean r124 = r123.f535638t;
        User r125 = r123.f();
        if (r125 == null) goto L44;
        String r126 = r125.u();
        if (r126 == null) goto L44;
        String r127 = r126;
    L45:
        String r128 = r105.getPreviousPage();
        if (r128 != null) goto L48;
        String r129 = "";
    L50:
        if (r211.f501173a.W() == false) goto L52;
        String r130 = PlayerResolution.SDKKEY.ORIGIN;
    L53:
        String r131 = r130;
        boolean r132 = r105.isCardMode();
        a0 r133 = r211.f501173a.f535622d;
        if (r133 == null) goto L56;
        r101 = r133.a();
    L56:
        if (r101 != null) goto L58;
        String r213 = "";
    L59:
        String r134 = r211.f501173a.r().f535652d;
        if (r134 != null) goto L62;
        String r214 = "";
    L63:
        User r135 = r211.f501173a.f();
        if (r135 != null) goto L66;
    L68:
        boolean r215 = false;
    L69:
        r117.j2(r100, r118, r119, r121, r104, r122, r124, r132, "", "", new e(r211.f501173a), r127, r129, r131, null, r213, r214, r215, r212, "");
        return;
    L66:
        if (r135.R() != true) goto L68;
        r215 = true;
        goto L69
    L62:
        r214 = r134;
        goto L63
    L58:
        r213 = r101;
        goto L59
    L52:
        r130 = "sdk";
        goto L53
    L48:
        r129 = r128;
    L44:
        r127 = "";
    L37:
        r121 = "";
        goto L38
    L7:
        r103 = null;
    L10:
        r104 = "";
        goto L11
    }

    public static boolean a(String r100, jz3.a r101) {
        Intrinsics.checkNotNullParameter(r100, "sceneId");
        if (r101 != null) goto L6;
        return false;
    L6:
        if (r101.f501176d == 0) goto L8;
    L13:
        return false;
    L8:
        if (r101.f501177e == true) goto L13;
        if (Intrinsics.areEqual(r100, UserProfileEvent.DATA_TYPE_HOME_PAGE_HOT) == false) goto L13;
        return true;
    }

    public static String b(c r100, FeedPageConfig r101) {
        Intrinsics.checkNotNullParameter(r100, ShareChannel.DOUYIN);
        String r102 = r100.r().f535651c;
        if (TextUtils.isEmpty(r102) == false) goto L10;
        if (r101 != null) goto L6;
    L8:
        return null;
    L6:
        if (Intrinsics.areEqual(r101.getEnterAid(), r100.c()) == false) goto L8;
        return r101.getEnterHostGid();
    L10:
        return r102;
    }

    public static void j(o r110, c r111) {
        Intrinsics.checkNotNullParameter(r110, "vm");
        Intrinsics.checkNotNullParameter(r111, "data");
        d14.a r100 = b14.a.f16924a;
        t24.a r101 = (t24.a) b14.a.a(t24.a.class);
        String r102 = r110.sceneId();
        String r103 = r110.getPageConfig().getHostEnterFrom();
        User r104 = r111.f();
        if (r104 == null) goto L6;
        String r105 = r104.u();
        if (r105 == null) goto L6;
    L7:
        String r106 = r111.c();
        String r107 = b(r111, r110.getPageConfig());
        if (r107 != null) goto L10;
        r107 = "";
    L10:
        a0 r108 = r111.f535622d;
        if (r108 == null) goto L14;
        String r109 = r108.a();
        if (r109 == null) goto L14;
    L15:
        boolean r112 = r110.getPageConfig().isCardMode();
        User r113 = r111.f();
        if (r113 != null) goto L18;
    L20:
        boolean r114 = false;
    L21:
        String r115 = r105;
        r101.d3(r102, r103, r115, r106, r107, r109, r112, r114, r110.getPageConfig().getHostExtraParams(), null);
        return;
    L18:
        if (r113.R() != true) goto L20;
        r114 = true;
    L14:
        r109 = "";
    L6:
        r105 = "";
        goto L7
    }

    public static void n(o r110, c r111) {
        Intrinsics.checkNotNullParameter(r110, "vm");
        Intrinsics.checkNotNullParameter(r111, "data");
        b.a(r110.getHostExtensionInfo());
        d14.a r100 = b14.a.f16924a;
        t24.a r101 = (t24.a) b14.a.a(t24.a.class);
        String r102 = r110.sceneId();
        User r103 = r111.f();
        if (r103 == null) goto L6;
        String r104 = r103.u();
        if (r104 == null) goto L6;
    L7:
        String r105 = r111.c();
        String r106 = b(r111, r110.getPageConfig());
        if (r106 != null) goto L10;
        r106 = "";
    L10:
        a0 r107 = r111.f535622d;
        if (r107 == null) goto L14;
        String r108 = r107.a();
        if (r108 == null) goto L14;
    L15:
        String r109 = GsonProtectorUtils.toJson(GsonHolder.a(), r111.f535622d);
        boolean r112 = e(r111);
        boolean r113 = r110.getPageConfig().isCardMode();
        String r114 = r111.u();
        if (r111.W() == false) goto L18;
        String r115 = PlayerResolution.SDKKEY.ORIGIN;
    L19:
        String r116 = r110.getPageConfig().getPreviousPage();
        if (r116 != null) goto L22;
        r116 = "";
    L22:
        User r117 = r111.f();
        if (r117 == null) goto L27;
        boolean r118 = true;
        if (r117.R() != true) goto L27;
    L28:
        String r119 = r110.getPageConfig().getHostEnterFrom();
        JSONObject r120 = r110.getPageConfig().getHostExtraParams();
        String r121 = r106;
        String r122 = r108;
        r101.Q2(r102, r104, r105, r121, r122, r109, r112, r113, new e(r111), r114, r115, r116, r118, r119, r120);
        return;
    L27:
        r118 = false;
        goto L28
    L18:
        r115 = "sdk";
    L14:
        r108 = "";
    L6:
        r104 = "";
        goto L7
    }

    public static void r(o r110, c r111) {
        Intrinsics.checkNotNullParameter(r110, "vm");
        Intrinsics.checkNotNullParameter(r111, "data");
        d14.a r100 = b14.a.f16924a;
        t24.a r101 = (t24.a) b14.a.a(t24.a.class);
        String r102 = r110.sceneId();
        String r103 = r110.getPageConfig().getHostEnterFrom();
        String r104 = r111.c();
        String r105 = b(r111, r110.getPageConfig());
        if (r105 != null) goto L5;
        r105 = "";
    L5:
        User r106 = r111.f();
        if (r106 == null) goto L9;
        String r107 = r106.u();
        if (r107 == null) goto L9;
    L10:
        a0 r108 = r111.f535622d;
        if (r108 == null) goto L14;
        String r109 = r108.a();
        if (r109 == null) goto L14;
    L15:
        boolean r112 = r110.getPageConfig().isCardMode();
        User r113 = r111.f();
        if (r113 == null) goto L20;
        boolean r114 = true;
        if (r113.R() != true) goto L20;
    L21:
        JSONObject r115 = r110.getPageConfig().getHostExtraParams();
        e r116 = new e(r111);
        b.a(r110.getHostExtensionInfo());
        r101.h1(r102, r103, r104, r105, r107, r109, r112, r114, r115, r116);
        return;
    L20:
        r114 = false;
    L14:
        r109 = "";
    L9:
        r107 = "";
        goto L10
    }

    public static void M(AosEventReporter r210, com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a r211, jz3.a r212) {
        r210.getClass();
        Intrinsics.checkNotNullParameter(r211, "feedGroupParameters");
        Intrinsics.checkNotNullParameter(r212, "data");
        String r100 = r211.f195163c.sceneId();
        if (Intrinsics.areEqual(r100, "others_homepage") == false) goto L10;
        o r101 = r211.f195163c;
        if ((r101 instanceof AosUserProfileFeedFragmentViewModel) == false) goto L7;
        AosUserProfileFeedFragmentViewModel r102 = (AosUserProfileFeedFragmentViewModel) r101;
    L8:
        if (r102 == null) goto L10;
        String r110 = r102.getFromGroupId();
    L12:
        if (r211.f195163c.getPostPlayTimeDurationRecord() != 0) goto L14;
        long r103 = r211.f195163c.getDuration();
    L15:
        long r104 = r103;
        r211.f195163c.setPostPlayTimeDurationRecord(System.currentTimeMillis());
        FeedPageConfig r105 = r211.f195163c.getPageConfig();
        d14.a r106 = b14.a.f16924a;
        t24.a r107 = (t24.a) b14.a.a(t24.a.class);
        String r108 = r212.f501173a.c();
        String r109 = b(r212.f501173a, r105);
        if (r109 != null) goto L18;
        r109 = "";
    L18:
        a0 r111 = r212.f501173a.f535622d;
        if (r111 == null) goto L22;
        String r112 = r111.a();
        if (r112 == null) goto L22;
    L23:
        String r113 = GsonProtectorUtils.toJson(GsonHolder.a(), r212.f501173a.f535622d);
        boolean r114 = e(r212.f501173a);
        c r115 = r212.f501173a;
        boolean r116 = r115.f535638t;
        User r117 = r115.f();
        if (r117 == null) goto L27;
        String r118 = r117.u();
        if (r118 == null) goto L27;
    L28:
        String r119 = r105.getPreviousPage();
        if (r119 != null) goto L32;
        r119 = "";
    L32:
        if (r212.f501173a.W() == false) goto L34;
        String r120 = PlayerResolution.SDKKEY.ORIGIN;
    L35:
        String r121 = r211.f195163c.getOverType();
        String r122 = String.valueOf(r212.f501173a.q() / 1000);
        String r123 = r109;
        String r124 = r112;
        String r125 = r119;
        r107.M0(r100, r108, r123, r104, r124, r110, r113, r114, r116, r118, r125, r120, r121, r212.f501173a.u(), r122);
        return;
    L34:
        r120 = "sdk";
    L27:
        r118 = "";
    L22:
        r112 = "";
        goto L23
    L14:
        r103 = System.currentTimeMillis() - r211.f195163c.getPostPlayTimeDurationRecord();
        goto L15
    L7:
        r102 = null;
    L10:
        r110 = "";
        goto L12
    }

    public static void N(com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a r210, jz3.a r211, p r212) {
        Intrinsics.checkNotNullParameter(r210, "feedGroupParameters");
        Intrinsics.checkNotNullParameter(r211, "data");
        Intrinsics.checkNotNullParameter(r212, "eventRecorder");
        String r100 = r210.f195163c.sceneId();
        if (Intrinsics.areEqual(r100, "others_homepage") == false) goto L10;
        o r101 = r210.f195163c;
        if ((r101 instanceof AosUserProfileFeedFragmentViewModel) == false) goto L7;
        AosUserProfileFeedFragmentViewModel r102 = (AosUserProfileFeedFragmentViewModel) r101;
    L8:
        if (r102 == null) goto L10;
        String r103 = r102.getFromGroupId();
    L11:
        FeedPageConfig r104 = r210.f195163c.getPageConfig();
        d14.a r105 = b14.a.f16924a;
        t24.a r106 = (t24.a) b14.a.a(t24.a.class);
        String r107 = r211.f501173a.c();
        String r108 = b(r211.f501173a, r104);
        if (r108 != null) goto L14;
        r108 = "";
    L14:
        a0 r110 = r211.f501173a.f535622d;
        if (r110 == null) goto L18;
        String r111 = r110.a();
        if (r111 == null) goto L18;
    L19:
        String r112 = GsonProtectorUtils.toJson(GsonHolder.a(), r211.f501173a.f535622d);
        boolean r113 = e(r211.f501173a);
        boolean r109 = r212.f195088b;
        c r114 = r211.f501173a;
        boolean r115 = r114.f535638t;
        User r116 = r114.f();
        if (r116 == null) goto L25;
        String r117 = r116.u();
        if (r117 == null) goto L25;
        String r118 = r117;
    L26:
        String r119 = r104.getPreviousPage();
        if (r119 != null) goto L29;
        String r120 = "";
    L31:
        if (r211.f501173a.W() == false) goto L33;
        String r121 = PlayerResolution.SDKKEY.ORIGIN;
    L34:
        String r213 = r210.f195163c.getStartType();
        String r214 = r211.f501173a.u();
        r104.isCardMode();
        String r122 = r108;
        String r123 = r111;
        r106.K0(r100, r107, r122, r123, r103, r112, r113, "detail", r109, r115, "", false, null, r118, r120, r121, r213, r214);
        return;
    L33:
        r121 = "sdk";
        goto L34
    L29:
        r120 = r119;
    L25:
        r118 = "";
    L18:
        r111 = "";
        goto L19
    L7:
        r102 = null;
    L10:
        r103 = "";
        goto L11
    }

    public static void R(com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a r210, jz3.a r211, p r212) {
        Intrinsics.checkNotNullParameter(r210, "feedGroupParameters");
        Intrinsics.checkNotNullParameter(r211, "data");
        Intrinsics.checkNotNullParameter(r212, "eventRecorder");
        String r100 = r210.f195163c.sceneId();
        FeedPageConfig r101 = r210.f195163c.getPageConfig();
        r212.getClass();
        long r110 = System.currentTimeMillis() - r212.f195090d;
        r212.f195090d = 0;
        long r111 = r212.f195092f;
        r212.f195091e = 0;
        r212.f195092f = 0;
        d14.a r102 = b14.a.f16924a;
        t24.a r103 = (t24.a) b14.a.a(t24.a.class);
        String r104 = r101.getHostEnterFrom();
        User r105 = r211.f501173a.f();
        if (r105 == null) goto L6;
        String r106 = r105.u();
        if (r106 == null) goto L6;
    L7:
        String r107 = r211.f501173a.c();
        String r108 = b(r211.f501173a, r101);
        if (r108 != null) goto L10;
        String r109 = "";
    L11:
        a0 r112 = r211.f501173a.f535622d;
        if (r112 == null) goto L17;
        String r113 = r112.a();
        if (r113 == null) goto L17;
        String r114 = r113;
    L18:
        String r115 = r106;
        r103.X1(r100, r104, r115, r107, r109, r114, c(r211.f501173a), e(r211.f501173a), r110, r111, r212.f195088b, r211.f501173a.r().f535649a, null);
        return;
    L17:
        r114 = "";
        goto L18
    L10:
        r109 = r108;
    L6:
        r106 = "";
        goto L7
    }

    public static void f(com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a r110, jz3.a r111, String r112) {
        Intrinsics.checkNotNullParameter(r110, "feedGroupParameters");
        Intrinsics.checkNotNullParameter(r111, "data");
        Intrinsics.checkNotNullParameter(com.bytedance.android.ec.core.event.a.VALUE_LONG_CLICK, "enterMethod");
        Intrinsics.checkNotNullParameter(r112, "showType");
        String r100 = r110.f195163c.sceneId();
        FeedPageConfig r113 = r110.f195163c.getPageConfig();
        d14.a r101 = b14.a.f16924a;
        t24.a r102 = (t24.a) b14.a.a(t24.a.class);
        User r103 = r111.f501173a.f();
        if (r103 == null) goto L6;
        String r104 = r103.u();
        if (r104 == null) goto L6;
    L7:
        String r105 = r111.f501173a.c();
        String r114 = b(r111.f501173a, r113);
        if (r114 != null) goto L10;
        r114 = "";
    L10:
        a0 r106 = r111.f501173a.f535622d;
        if (r106 == null) goto L14;
        String r107 = r106.a();
        if (r107 == null) goto L14;
    L15:
        String r108 = r114;
        r102.k1(r100, r104, r105, r108, r107, c(r111.f501173a), d(r111), com.bytedance.android.ec.core.event.a.VALUE_LONG_CLICK, r112, null);
        return;
    L14:
        r107 = "";
    L6:
        r104 = "";
        goto L7
    }

    public static void g(com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a r110, jz3.a r111, String r112) {
        Intrinsics.checkNotNullParameter(com.bytedance.android.ec.core.event.a.VALUE_LONG_CLICK, "enterMethod");
        Intrinsics.checkNotNullParameter(r112, "showType");
        if (r110 == null) goto L8;
        o r100 = r110.f195163c;
        if (r100 == null) goto L8;
        String r101 = r100.sceneId();
        if (r101 == null) goto L8;
    L9:
        if (r110 == null) goto L13;
        o r113 = r110.f195163c;
        if (r113 == null) goto L13;
        FeedPageConfig r114 = r113.getPageConfig();
    L14:
        if (r111 == null) goto L32;
        c r102 = r111.f501173a;
        if (r102 == null) goto L33;
        d14.a r103 = b14.a.f16924a;
        t24.a r104 = (t24.a) b14.a.a(t24.a.class);
        User r105 = r102.f();
        if (r105 == null) goto L21;
        String r106 = r105.u();
        if (r106 == null) goto L21;
    L22:
        String r107 = r102.c();
        f194596a.getClass();
        String r115 = b(r102, r114);
        if (r115 != null) goto L25;
        r115 = "";
    L25:
        a0 r108 = r102.f535622d;
        if (r108 == null) goto L29;
        String r109 = r108.a();
        if (r109 == null) goto L29;
    L30:
        String r116 = r106;
        String r117 = r115;
        String r118 = r109;
        r104.H2(r101, r116, r107, r117, r118, c(r102), d(r111), com.bytedance.android.ec.core.event.a.VALUE_LONG_CLICK, r112, null);
        return;
    L29:
        r109 = "";
    L21:
        r106 = "";
        goto L22
    L33:
        return;
    L32:
        return;
    L13:
        r114 = null;
    L8:
        r101 = "";
        goto L9
    }

    public static void l(String r110, String r111, c r112) {
        Intrinsics.checkNotNullParameter(r110, "sceneId");
        Intrinsics.checkNotNullParameter(r112, "data");
        d14.a r100 = b14.a.f16924a;
        t24.a r101 = (t24.a) b14.a.a(t24.a.class);
        User r102 = r112.f();
        if (r102 == null) goto L8;
        String r103 = r102.u();
        if (r103 == null) goto L8;
        String r104 = r103;
    L9:
        String r105 = r112.c();
        String r106 = b(r112, null);
        if (r106 != null) goto L14;
        if (r111 != null) goto L13;
        String r107 = "";
    L15:
        a0 r113 = r112.f535622d;
        if (r113 == null) goto L21;
        String r114 = r113.a();
        if (r114 == null) goto L21;
        String r108 = r114;
    L22:
        r101.e0(r110, r104, r105, r107, r108, c(r112), e(r112), null);
        return;
    L21:
        r108 = "";
        goto L22
    L13:
        r107 = r111;
        goto L15
    L14:
        r107 = r106;
    L8:
        r104 = "";
        goto L9
    }

    public static void m(o r110, c r111, String r112) {
        Intrinsics.checkNotNullParameter(r110, "vm");
        Intrinsics.checkNotNullParameter(r111, "data");
        Intrinsics.checkNotNullParameter(r112, "eventName");
        d14.a r100 = b14.a.f16924a;
        t24.a r101 = (t24.a) b14.a.a(t24.a.class);
        String r102 = r110.sceneId();
        String r103 = r110.getPageConfig().getHostEnterFrom();
        String r104 = r111.c();
        String r105 = b(r111, r110.getPageConfig());
        if (r105 != null) goto L5;
        String r106 = "";
    L6:
        User r107 = r111.f();
        if (r107 == null) goto L12;
        String r108 = r107.u();
        if (r108 == null) goto L12;
        String r109 = r108;
    L13:
        a0 r113 = r111.f535622d;
        if (r113 == null) goto L19;
        String r114 = r113.a();
        if (r114 == null) goto L19;
        String r115 = r114;
    L20:
        boolean r116 = r110.getPageConfig().isCardMode();
        User r117 = r111.f();
        if (r117 != null) goto L23;
    L25:
        boolean r118 = false;
    L26:
        r101.U(r112, r102, r103, r104, r106, r109, r115, r116, r118, r110.getPageConfig().getHostExtraParams());
        return;
    L23:
        if (r117.R() != true) goto L25;
        r118 = true;
    L19:
        r115 = "";
    L12:
        r109 = "";
        goto L13
    L5:
        r106 = r105;
        goto L6
    }

    public static void t(o r110, String r111, c r112) {
        Intrinsics.checkNotNullParameter(r110, "vm");
        Intrinsics.checkNotNullParameter(r111, "unfoldMethod");
        if (r112 != null) goto L5;
        return;
    L5:
        String r100 = r110.sceneId();
        if (Intrinsics.areEqual(r100, "others_homepage") == true) goto L8;
    L13:
        String r101 = "";
    L14:
        d14.a r102 = b14.a.f16924a;
        t24.a r103 = (t24.a) b14.a.a(t24.a.class);
        User r104 = r112.f();
        if (r104 == null) goto L18;
        String r105 = r104.u();
        if (r105 == null) goto L18;
    L19:
        String r106 = r112.c();
        if (r106 != null) goto L22;
        r106 = "";
    L22:
        a0 r107 = r112.f535622d;
        if (r107 == null) goto L26;
        String r108 = r107.a();
        if (r108 == null) goto L26;
    L28:
        if (r112.W() == false) goto L30;
        String r109 = PlayerResolution.SDKKEY.ORIGIN;
    L31:
        String r113 = r109;
        String r114 = r110.getPageConfig().getPreviousPage();
        if (r114 != null) goto L34;
        String r115 = "";
    L35:
        r103.q0(r105, r100, r106, r108, r101, r111, r113, r115, r112.u());
        return;
    L34:
        r115 = r114;
        goto L35
    L30:
        r109 = "sdk";
    L26:
        r108 = "";
    L18:
        r105 = "";
        goto L19
    L8:
        if ((r110 instanceof AosUserProfileFeedFragmentViewModel) == false) goto L10;
        AosUserProfileFeedFragmentViewModel r116 = (AosUserProfileFeedFragmentViewModel) r110;
    L11:
        if (r116 == null) goto L13;
        r101 = r116.getFromGroupId();
        goto L14
    L10:
        r116 = null;
        goto L11
    }

    public static void E(o r210, c r211, DiggType r212, boolean r213) {
        Intrinsics.checkNotNullParameter(r210, "vm");
        Intrinsics.checkNotNullParameter(r211, "data");
        Intrinsics.checkNotNullParameter(r212, "diggType");
        FeedPageConfig r100 = r210.getPageConfig();
        b.a(r210.getHostExtensionInfo());
        if (r100.isTeenagerModel() == false) goto L34;
        if (r213 == false) goto L7;
        return;
    L7:
        if (Intrinsics.areEqual(r210.sceneId(), "others_homepage") == true) goto L9;
    L14:
        String r110 = "";
    L15:
        d14.a r101 = b14.a.f16924a;
        t24.a r102 = (t24.a) b14.a.a(t24.a.class);
        String r103 = r210.sceneId();
        User r104 = r211.f();
        if (r104 == null) goto L21;
        String r105 = r104.u();
        if (r105 == null) goto L21;
        String r106 = r105;
    L22:
        String r107 = r211.c();
        String r108 = b(r211, r100);
        if (r108 != null) goto L25;
        String r111 = "";
    L26:
        a0 r109 = r211.f535622d;
        if (r109 == null) goto L32;
        String r112 = r109.a();
        if (r112 == null) goto L32;
        String r113 = r112;
    L33:
        r102.N1(r103, r106, r107, r111, r113, r110);
        return;
    L32:
        r113 = "";
        goto L33
    L25:
        r111 = r108;
    L21:
        r106 = "";
        goto L22
    L9:
        if ((r210 instanceof AosUserProfileFeedFragmentViewModel) == false) goto L11;
        AosUserProfileFeedFragmentViewModel r114 = (AosUserProfileFeedFragmentViewModel) r210;
    L12:
        if (r114 == null) goto L14;
        r110 = r114.getFromGroupId();
        goto L15
    L11:
        r114 = null;
        goto L12
    L34:
        int r115 = a.f194600a[r212.ordinal()];
        if (r115 != 1) goto L37;
        String r116 = "detail_bottom_bar";
    L42:
        String r117 = r116;
        d14.a r118 = b14.a.f16924a;
        t24.a r119 = (t24.a) b14.a.a(t24.a.class);
        String r120 = r210.sceneId();
        String r121 = r211.c();
        String r122 = b(r211, r100);
        if (r122 != null) goto L45;
        String r123 = "";
    L46:
        a0 r124 = r211.f535622d;
        if (r124 == null) goto L52;
        String r125 = r124.a();
        if (r125 == null) goto L52;
        String r126 = r125;
    L53:
        String r127 = GsonProtectorUtils.toJson(GsonHolder.a(), r211.f535622d);
        boolean r128 = e(r211);
        boolean r129 = r211.f535638t;
        boolean r130 = r100.isCardMode();
        String r131 = r211.u();
        User r132 = r211.f();
        if (r132 == null) goto L59;
        String r133 = r132.u();
        if (r133 == null) goto L59;
        String r134 = r133;
    L60:
        String r135 = r100.getPreviousPage();
        if (r135 != null) goto L63;
        String r136 = "";
    L65:
        if (r211.W() == false) goto L67;
        String r137 = PlayerResolution.SDKKEY.ORIGIN;
    L68:
        String r214 = r137;
        User r138 = r211.f();
        if (r138 != null) goto L71;
    L73:
        boolean r215 = false;
    L74:
        String r216 = r100.getHostEnterFrom();
        JSONObject r217 = r210.getPageConfig().getHostExtraParams();
        r119.X(r213, r120, r121, r123, r126, r127, r117, r128, r129, r130, new e(r211), r131, r134, r136, r214, r215, r216, r217, "");
        return;
    L71:
        if (r138.R() != true) goto L73;
        r215 = true;
        goto L74
    L67:
        r137 = "sdk";
        goto L68
    L63:
        r136 = r135;
    L59:
        r134 = "";
    L52:
        r126 = "";
        goto L53
    L45:
        r123 = r122;
        goto L46
    L37:
        if (r115 != 2) goto L40;
        r116 = "double_like";
        goto L42
    L40:
        throw new NoWhenBranchMatchedException();
    }

    public static void L(com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a r310, jz3.a r311, long r312, String r313) {
        Intrinsics.checkNotNullParameter(r310, "feedGroupParameters");
        Intrinsics.checkNotNullParameter(r311, "data");
        if (r312 != 0) goto L5;
        return;
    L5:
        String r100 = r310.f195163c.sceneId();
        String r210 = r310.f195163c.getPageConfig().getHostEnterFrom();
        JSONObject r314 = r310.f195163c.getPageConfig().getHostExtraParams();
        String r101 = null;
        if (Intrinsics.areEqual(r100, "others_homepage") == false) goto L13;
        o r102 = r310.f195163c;
        if ((r102 instanceof AosUserProfileFeedFragmentViewModel) == false) goto L10;
        AosUserProfileFeedFragmentViewModel r103 = (AosUserProfileFeedFragmentViewModel) r102;
    L11:
        if (r103 == null) goto L13;
        String r110 = r103.getFromGroupId();
    L14:
        FeedPageConfig r104 = r310.f195163c.getPageConfig();
        b.a(r310.f195163c.getHostExtensionInfo());
        if (r104.isTeenagerModel() == false) goto L35;
        d14.a r105 = b14.a.f16924a;
        t24.a r106 = (t24.a) b14.a.a(t24.a.class);
        User r107 = r311.f501173a.f();
        if (r107 == null) goto L22;
        String r108 = r107.u();
        if (r108 == null) goto L22;
        String r109 = r108;
    L23:
        String r111 = r311.f501173a.c();
        String r112 = b(r311.f501173a, r104);
        if (r112 != null) goto L26;
        String r113 = "";
    L27:
        a0 r114 = r311.f501173a.f535622d;
        if (r114 == null) goto L33;
        String r115 = r114.a();
        if (r115 == null) goto L33;
        String r116 = r115;
    L34:
        r106.l3(r100, r109, r111, r113, r116, r312, r110, r311.f501173a.f535638t);
        return;
    L33:
        r116 = "";
        goto L34
    L26:
        r113 = r112;
    L22:
        r109 = "";
        goto L23
    L35:
        d14.a r117 = b14.a.f16924a;
        t24.a r118 = (t24.a) b14.a.a(t24.a.class);
        String r119 = r311.f501173a.c();
        String r120 = b(r311.f501173a, r104);
        if (r120 != null) goto L38;
        r120 = "";
    L38:
        float r121 = r311.f501173a.q() / 1000.0f;
        a0 r122 = r311.f501173a.f535622d;
        if (r122 == null) goto L44;
        String r123 = r122.a();
        if (r123 == null) goto L44;
        String r124 = r123;
    L45:
        String r125 = GsonProtectorUtils.toJson(GsonHolder.a(), r311.f501173a.f535622d);
        boolean r126 = e(r311.f501173a);
        boolean r127 = r311.f501173a.f535638t;
        String r128 = r104.getPreviousPage();
        if (r128 != null) goto L48;
        String r211 = "";
    L50:
        if (r311.f501173a.W() == false) goto L52;
        String r129 = PlayerResolution.SDKKEY.ORIGIN;
    L53:
        String r212 = r129;
        User r130 = r311.f501173a.f();
        if (r130 == null) goto L59;
        String r131 = r130.u();
        if (r131 == null) goto L59;
        String r213 = r131;
    L60:
        boolean r132 = r104.isCardMode();
        a0 r133 = r311.f501173a.f535622d;
        if (r133 == null) goto L63;
        r101 = r133.a();
    L63:
        if (r101 != null) goto L65;
        String r214 = "";
    L66:
        String r134 = r311.f501173a.r().f535652d;
        if (r134 != null) goto L69;
        String r215 = "";
    L70:
        User r135 = r311.f501173a.f();
        if (r135 != null) goto L73;
    L75:
        boolean r315 = false;
    L76:
        r118.b3(r100, r119, r120, r312, r121, r124, r110, r125, r126, r127, "", false, r132, 0, "", "", new e(r311.f501173a), r211, r212, r213, r210, r214, r215, r313, r315, r314, "");
        return;
    L73:
        if (r135.R() != true) goto L75;
        r315 = true;
        goto L76
    L69:
        r215 = r134;
        goto L70
    L65:
        r214 = r101;
    L59:
        r213 = "";
        goto L60
    L52:
        r129 = "sdk";
        goto L53
    L48:
        r211 = r128;
    L44:
        r124 = "";
        goto L45
    L10:
        r103 = null;
    L13:
        r110 = "";
        goto L14
    }

    public static void q(o r210, c r211, DiggType r212, String r213) {
        Intrinsics.checkNotNullParameter(r210, "vm");
        Intrinsics.checkNotNullParameter(r211, "data");
        Intrinsics.checkNotNullParameter(r212, "diggType");
        Intrinsics.checkNotNullParameter(r213, "event");
        FeedPageConfig r100 = r210.getPageConfig();
        int r101 = a.f194600a[r212.ordinal()];
        if (r101 != 1) goto L5;
        String r102 = "detail_bottom_bar";
    L10:
        String r110 = r102;
        d14.a r103 = b14.a.f16924a;
        t24.a r104 = (t24.a) b14.a.a(t24.a.class);
        String r105 = r210.sceneId();
        String r106 = r211.c();
        String r107 = b(r211, r100);
        if (r107 != null) goto L13;
        r107 = "";
    L13:
        a0 r111 = r211.f535622d;
        if (r111 == null) goto L17;
        String r112 = r111.a();
        if (r112 == null) goto L17;
    L18:
        String r113 = GsonProtectorUtils.toJson(GsonHolder.a(), r211.f535622d);
        boolean r114 = e(r211);
        boolean r115 = r211.f535638t;
        boolean r116 = r100.isCardMode();
        String r117 = r211.u();
        User r118 = r211.f();
        if (r118 == null) goto L24;
        String r119 = r118.u();
        if (r119 == null) goto L24;
        String r120 = r119;
    L25:
        String r121 = r100.getPreviousPage();
        if (r121 != null) goto L28;
        String r122 = "";
    L30:
        if (r211.W() == false) goto L32;
        String r108 = PlayerResolution.SDKKEY.ORIGIN;
    L33:
        String r214 = r108;
        User r109 = r211.f();
        if (r109 != null) goto L36;
    L38:
        boolean r215 = false;
    L39:
        String r216 = r100.getHostEnterFrom();
        JSONObject r217 = r210.getPageConfig().getHostExtraParams();
        String r123 = r107;
        String r124 = r112;
        r104.C(r213, r105, r106, r123, r124, r113, r110, r114, r115, r116, new e(r211), r117, r120, r122, r214, r215, r216, r217);
        return;
    L36:
        if (r109.R() != true) goto L38;
        r215 = true;
        goto L39
    L32:
        r108 = "sdk";
        goto L33
    L28:
        r122 = r121;
    L24:
        r120 = "";
    L17:
        r112 = "";
        goto L18
    L5:
        if (r101 != 2) goto L8;
        r102 = "double_like";
        goto L10
    L8:
        throw new NoWhenBranchMatchedException();
    }

    public static void v(String r110, String r111, String r112, c r113) {
        Intrinsics.checkNotNullParameter(r110, "enterFrom");
        Intrinsics.checkNotNullParameter(r111, "enterMethod");
        Intrinsics.checkNotNullParameter(r113, ShareChannel.DOUYIN);
        d14.a r100 = b14.a.f16924a;
        t24.a r101 = (t24.a) b14.a.a(t24.a.class);
        User r102 = r113.f();
        if (r102 == null) goto L8;
        String r103 = r102.u();
        if (r103 == null) goto L8;
        String r104 = r103;
    L9:
        String r105 = r113.c();
        String r106 = b(r113, null);
        if (r106 != null) goto L14;
        if (r112 != null) goto L13;
        String r107 = "";
    L15:
        a0 r114 = r113.f535622d;
        if (r114 == null) goto L21;
        String r115 = r114.a();
        if (r115 == null) goto L21;
        String r108 = r115;
    L22:
        r101.S1(r110, r111, r104, r105, r107, r108, c(r113), e(r113), new e(r113));
        return;
    L21:
        r108 = "";
        goto L22
    L13:
        r107 = r112;
        goto L15
    L14:
        r107 = r106;
    L8:
        r104 = "";
        goto L9
    }

    public static void B(String r110, String r111, c r112, FollowType r113, String r210) {
        Intrinsics.checkNotNullParameter(r113, "followType");
        if (r112 != null) goto L5;
        return;
    L5:
        d14.a r100 = b14.a.f16924a;
        t24.a r101 = (t24.a) b14.a.a(t24.a.class);
        if (r110 != null) goto L8;
        String r102 = "";
    L9:
        String r103 = r112.c();
        String r104 = b(r112, null);
        if (r104 != null) goto L14;
        if (r111 != null) goto L13;
        r104 = "";
        goto L14
    L13:
        r104 = r111;
    L14:
        a0 r105 = r112.f535622d;
        if (r105 == null) goto L18;
        String r106 = r105.a();
        if (r106 == null) goto L18;
    L19:
        String r107 = c(r112);
        boolean r108 = e(r112);
        User r114 = r112.f();
        if (r114 == null) goto L23;
        String r115 = r114.u();
        if (r115 == null) goto L23;
    L25:
        if (r112.W() == false) goto L27;
        String r109 = PlayerResolution.SDKKEY.ORIGIN;
    L28:
        String r116 = r112.u();
        String r117 = r113.name();
        String r118 = r102;
        String r119 = r115;
        r101.a3(r118, r119, r103, r104, r106, r107, r108, r117, null, r210, r109, r116, Integer.valueOf(r112.i()));
        return;
    L27:
        r109 = "sdk";
    L23:
        r115 = "";
    L18:
        r106 = "";
        goto L19
    L8:
        r102 = r110;
        goto L9
    }

    public static void Q(com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a r110, jz3.a r111, String r210, float r211, long r212) {
        Intrinsics.checkNotNullParameter(r210, "enterMethod");
        if (r110 == null) goto L10;
        o r100 = r110.f195163c;
        if (r100 == null) goto L10;
        String r101 = r100.sceneId();
        if (r101 == null) goto L10;
        String r102 = r101;
    L11:
        if (r110 == null) goto L15;
        o r103 = r110.f195163c;
        if (r103 == null) goto L15;
        FeedPageConfig r104 = r103.getPageConfig();
    L16:
        if (r111 == null) goto L36;
        c r105 = r111.f501173a;
        if (r105 == null) goto L37;
        d14.a r106 = b14.a.f16924a;
        t24.a r107 = (t24.a) b14.a.a(t24.a.class);
        User r108 = r105.f();
        if (r108 == null) goto L23;
        String r109 = r108.u();
        if (r109 == null) goto L23;
    L24:
        String r112 = r105.c();
        f194596a.getClass();
        String r113 = b(r105, r104);
        if (r113 != null) goto L27;
        r113 = "";
    L27:
        a0 r114 = r105.f535622d;
        if (r114 == null) goto L33;
        String r115 = r114.a();
        if (r115 == null) goto L33;
        String r116 = r115;
    L34:
        String r117 = r109;
        String r118 = r113;
        r107.x(r102, r117, r112, r118, r116, c(r111.f501173a), d(r111), r210, "click", "long_press_panel", r211, r212, null);
        return;
    L33:
        r116 = "";
    L23:
        r109 = "";
        goto L24
    L37:
        return;
    L36:
        return;
    L15:
        r104 = null;
    L10:
        r102 = "";
        goto L11
    }

    public static void x(long r100, int r110, String r111, String r112, String r113) {
        Intrinsics.checkNotNullParameter(r111, "scene");
        Intrinsics.checkNotNullParameter(r112, "loadingType");
        d14.a r101 = b14.a.f16924a;
        ((t24.a) b14.a.a(t24.a.class)).J2(r100, r110, r111, r112, r113, null);
    }

    public static void O(boolean r110, int r111, String r112, String r113, long r114, int r115) {
        Intrinsics.checkNotNullParameter(r112, "enterAid");
        Intrinsics.checkNotNullParameter(r113, "enterLiveRoomId");
        d14.a r100 = b14.a.f16924a;
        ((t24.a) b14.a.a(t24.a.class)).Z0(r110, r111, r112, r113, r114, r115, null);
    }

    public static void h(o r110, jz3.a r111, String r112, String r113, String r114, JSONObject r210) {
        Intrinsics.checkNotNullParameter(r112, "bar_name");
        Intrinsics.checkNotNullParameter("topic", ILiveRoomPlayFragmentConstant.EXTRA_BAR_TYPE);
        Intrinsics.checkNotNullParameter(r113, "topic_id");
        Intrinsics.checkNotNullParameter(r114, "topic_name");
        String r100 = "";
        if (r110 == null) goto L8;
        String r101 = r110.sceneId();
        if (r101 == null) goto L8;
        String r102 = r101;
    L9:
        if (r110 == null) goto L11;
        FeedPageConfig r103 = r110.getPageConfig();
    L12:
        if (r111 == null) goto L37;
        c r104 = r111.f501173a;
        if (r104 != null) goto L16;
        return;
    L16:
        if (r104.W() == false) goto L18;
        String r105 = PlayerResolution.SDKKEY.ORIGIN;
    L19:
        String r106 = r105;
        d14.a r107 = b14.a.f16924a;
        t24.a r108 = (t24.a) b14.a.a(t24.a.class);
        User r109 = r104.f();
        if (r109 == null) goto L23;
        String r115 = r109.u();
        if (r115 == null) goto L23;
    L24:
        String r116 = r104.c();
        a0 r117 = r104.f535622d;
        if (r117 == null) goto L28;
        String r118 = r117.a();
        if (r118 == null) goto L28;
    L29:
        AosEventReporter r119 = f194596a;
        c r120 = r111.f501173a;
        r119.getClass();
        String r121 = c(r120);
        if (r103 == null) goto L35;
        String r122 = r103.getPreviousPage();
        if (r122 == null) goto L35;
        r100 = r122;
    L35:
        String r123 = r104.u();
        r108.L2(r102, r115, r116, r118, r121, r106, r100, r112, r113, r114, r123, r210);
        return;
    L28:
        r118 = "";
    L23:
        r115 = "";
        goto L24
    L18:
        r105 = "sdk";
        goto L19
    L37:
        return;
    L11:
        r103 = null;
    L8:
        r102 = "";
        goto L9
    }

    public static void i(o r110, jz3.a r111, String r112, String r113, String r114, JSONObject r210) {
        Intrinsics.checkNotNullParameter(r112, "bar_name");
        Intrinsics.checkNotNullParameter("topic", ILiveRoomPlayFragmentConstant.EXTRA_BAR_TYPE);
        Intrinsics.checkNotNullParameter(r113, "topic_id");
        Intrinsics.checkNotNullParameter(r114, "topic_name");
        String r100 = "";
        if (r110 == null) goto L8;
        String r101 = r110.sceneId();
        if (r101 == null) goto L8;
        String r102 = r101;
    L9:
        if (r110 == null) goto L11;
        FeedPageConfig r103 = r110.getPageConfig();
    L12:
        if (r111 == null) goto L37;
        c r104 = r111.f501173a;
        if (r104 != null) goto L16;
        return;
    L16:
        if (r104.W() == false) goto L18;
        String r105 = PlayerResolution.SDKKEY.ORIGIN;
    L19:
        String r106 = r105;
        d14.a r107 = b14.a.f16924a;
        t24.a r108 = (t24.a) b14.a.a(t24.a.class);
        User r109 = r104.f();
        if (r109 == null) goto L23;
        String r115 = r109.u();
        if (r115 == null) goto L23;
    L24:
        String r116 = r104.c();
        a0 r117 = r104.f535622d;
        if (r117 == null) goto L28;
        String r118 = r117.a();
        if (r118 == null) goto L28;
    L29:
        AosEventReporter r119 = f194596a;
        c r120 = r111.f501173a;
        r119.getClass();
        String r121 = c(r120);
        if (r103 == null) goto L35;
        String r122 = r103.getPreviousPage();
        if (r122 == null) goto L35;
        r100 = r122;
    L35:
        String r123 = r104.u();
        r108.R(r102, r115, r116, r118, r121, r106, r100, r112, r113, r114, r123, r210);
        return;
    L28:
        r118 = "";
    L23:
        r115 = "";
        goto L24
    L18:
        r105 = "sdk";
        goto L19
    L37:
        return;
    L11:
        r103 = null;
    L8:
        r102 = "";
        goto L9
    }

    public static void D(o r110, c r210, String r211, String r212, int r213, int r214, JSONObject r215) {
        Intrinsics.checkNotNullParameter("", com.bytedance.android.ec.core.event.a.KEY_FROM_GROUP_ID);
        Intrinsics.checkNotNullParameter(r211, "component_type");
        Intrinsics.checkNotNullParameter(r212, com.bytedance.android.ec.core.event.a.KEY_CONTENT_ID);
        if (r110 == null) goto L8;
        String r100 = r110.sceneId();
        if (r100 == null) goto L8;
        String r101 = r100;
    L9:
        FeedPageConfig r102 = null;
        if (Intrinsics.areEqual(r101, "others_homepage") == true) goto L12;
    L17:
        String r111 = "";
    L18:
        if (r110 == null) goto L20;
        r102 = r110.getPageConfig();
    L20:
        if (r210 != null) goto L22;
        return;
    L22:
        if (r210.W() == false) goto L24;
        String r103 = PlayerResolution.SDKKEY.ORIGIN;
    L25:
        String r112 = r103;
        d14.a r104 = b14.a.f16924a;
        t24.a r105 = (t24.a) b14.a.a(t24.a.class);
        User r106 = r210.f();
        if (r106 == null) goto L31;
        String r107 = r106.u();
        if (r107 == null) goto L31;
        String r108 = r107;
    L32:
        String r109 = r210.c();
        a0 r113 = r210.f535622d;
        if (r113 == null) goto L38;
        String r114 = r113.a();
        if (r114 == null) goto L38;
        String r115 = r114;
    L39:
        f194596a.getClass();
        String r116 = c(r210);
        if (r102 == null) goto L45;
        String r117 = r102.getPreviousPage();
        if (r117 == null) goto L45;
        String r118 = r117;
    L46:
        r105.r(r101, r108, r109, r115, r116, r112, r118, r111, r211, r212, r213, r214, r210.u(), r215);
        return;
    L45:
        r118 = "";
    L38:
        r115 = "";
    L31:
        r108 = "";
        goto L32
    L24:
        r103 = "sdk";
        goto L25
    L12:
        if ((r110 instanceof AosUserProfileFeedFragmentViewModel) == false) goto L14;
        AosUserProfileFeedFragmentViewModel r119 = (AosUserProfileFeedFragmentViewModel) r110;
    L15:
        if (r119 == null) goto L17;
        r111 = r119.getFromGroupId();
        goto L18
    L14:
        r119 = null;
    L8:
        r101 = "";
        goto L9
    }

    public static void k(com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a r110, jz3.a r111, String r112, float r210, boolean r211, String r212, String r213) {
        Intrinsics.checkNotNullParameter(r112, "enterMethod");
        Intrinsics.checkNotNullParameter(r212, "speedMethod");
        Intrinsics.checkNotNullParameter(r213, "speedPosition");
        if (r110 == null) goto L10;
        o r100 = r110.f195163c;
        if (r100 == null) goto L10;
        String r101 = r100.sceneId();
        if (r101 == null) goto L10;
        String r102 = r101;
    L11:
        if (r110 == null) goto L15;
        o r103 = r110.f195163c;
        if (r103 == null) goto L15;
        FeedPageConfig r104 = r103.getPageConfig();
    L16:
        if (r111 == null) goto L34;
        c r105 = r111.f501173a;
        if (r105 == null) goto L35;
        d14.a r106 = b14.a.f16924a;
        t24.a r107 = (t24.a) b14.a.a(t24.a.class);
        User r108 = r105.f();
        if (r108 == null) goto L23;
        String r109 = r108.u();
        if (r109 == null) goto L23;
    L24:
        String r113 = r105.c();
        f194596a.getClass();
        String r114 = b(r105, r104);
        if (r114 != null) goto L27;
        r114 = "";
    L27:
        a0 r115 = r105.f535622d;
        if (r115 == null) goto L31;
        String r116 = r115.a();
        if (r116 == null) goto L31;
    L32:
        String r117 = r109;
        String r118 = r114;
        r107.x1(r102, r117, r113, r118, r116, c(r111.f501173a), d(r111), r112, r212, r213, r210, r211, new e(r105));
        return;
    L31:
        r116 = "";
    L23:
        r109 = "";
        goto L24
    L35:
        return;
    L34:
        return;
    L15:
        r104 = null;
    L10:
        r102 = "";
        goto L11
    }

    public static void s(AosEventReporter r100, String r101, Map r102, String r103, JSONObject r104, e r105, int r106) {
        if ((r106 & 4) == 0) goto L6;
        r103 = null;
    L6:
        if ((r106 & 8) == 0) goto L8;
        r104 = null;
    L8:
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "eventName");
        d14.a r107 = b14.a.f16924a;
        ((t24.a) b14.a.a(t24.a.class)).D(r101, r102, r103, r104);
    }

    public static void u(c r210, String r211, String r212, boolean r213, String r214, String r215, JSONObject r216) {
        d14.a r100 = b14.a.f16924a;
        t24.a r101 = (t24.a) b14.a.a(t24.a.class);
        User r102 = r210.f();
        if (r102 == null) goto L8;
        String r103 = r102.u();
        if (r103 == null) goto L8;
        String r104 = r103;
    L9:
        String r105 = r210.c();
        if (r212 != null) goto L12;
        String r106 = "";
    L13:
        a0 r107 = r210.f535622d;
        if (r107 == null) goto L19;
        String r108 = r107.a();
        if (r108 == null) goto L19;
        String r109 = r108;
    L20:
        String r110 = c(r210);
        boolean r111 = e(r210);
        if (r210.W() == false) goto L23;
        String r112 = PlayerResolution.SDKKEY.ORIGIN;
    L24:
        String r113 = r112;
        String r114 = r210.u();
        if (r214 != null) goto L27;
        String r115 = "";
    L28:
        ShoppingCardInfo r116 = (ShoppingCardInfo) CollectionsKt.firstOrNull(r210.K());
        if (r116 == null) goto L34;
        String r117 = r116.getProductId();
        if (r117 == null) goto L34;
        String r118 = r117;
    L35:
        String r119 = r210.e();
        if (r119 != null) goto L38;
        String r120 = "";
    L39:
        d r121 = r210.d();
        if (r121 == null) goto L42;
        Integer r122 = r121.getType();
    L43:
        Integer r123 = r122;
        User r124 = r210.f();
        if (r124 != null) goto L46;
    L48:
        boolean r125 = false;
    L49:
        Map<String, String> r217 = r210.b0();
        String r126 = r104;
        String r127 = r106;
        String r128 = r109;
        r101.E2(r211, r126, r105, r127, r128, r110, r111, r213, r113, com.bytedance.android.ec.core.event.a.VALUE_LONG_CLICK, new e(r210), r114, r115, r118, r120, r123, r215, r125, r216, r217);
        return;
    L46:
        if (r124.R() != true) goto L48;
        r125 = true;
        goto L49
    L42:
        r122 = null;
        goto L43
    L38:
        r120 = r119;
    L34:
        r118 = "";
        goto L35
    L27:
        r115 = r214;
        goto L28
    L23:
        r112 = "sdk";
    L19:
        r109 = "";
        goto L20
    L12:
        r106 = r212;
    L8:
        r104 = "";
        goto L9
    }

    public static void C(o r110, c r210, String r211, String r212, String r213, int r214, int r215, JSONObject r216) {
        Intrinsics.checkNotNullParameter(r211, "component_type");
        Intrinsics.checkNotNullParameter(r212, com.bytedance.android.ec.core.event.a.KEY_CONTENT_ID);
        Intrinsics.checkNotNullParameter(r213, com.bytedance.android.ec.core.event.a.KEY_CLICK_AREA);
        if (r110 == null) goto L8;
        String r100 = r110.sceneId();
        if (r100 == null) goto L8;
        String r101 = r100;
    L10:
        if (Intrinsics.areEqual(r101, "others_homepage") == true) goto L12;
    L17:
        String r111 = "";
    L18:
        if (r210 == null) goto L43;
        d14.a r102 = b14.a.f16924a;
        t24.a r103 = (t24.a) b14.a.a(t24.a.class);
        User r104 = r210.f();
        if (r104 == null) goto L23;
        String r105 = r104.u();
        if (r105 == null) goto L23;
    L24:
        String r106 = r210.c();
        a0 r107 = r210.f535622d;
        if (r107 == null) goto L28;
        String r108 = r107.a();
        if (r108 == null) goto L28;
    L29:
        f194596a.getClass();
        String r109 = c(r210);
        if (r210.W() == false) goto L32;
        String r112 = PlayerResolution.SDKKEY.ORIGIN;
    L33:
        if (r110 == null) goto L40;
        FeedPageConfig r113 = r110.getPageConfig();
        if (r113 == null) goto L40;
        String r114 = r113.getPreviousPage();
        if (r114 == null) goto L40;
        String r115 = r114;
    L41:
        r103.y2(r101, r105, r106, r108, r109, r112, r115, r111, r211, r212, r214, r215, r213, r210.u(), r216);
        return;
    L40:
        r115 = "";
        goto L41
    L32:
        r112 = "sdk";
    L28:
        r108 = "";
    L23:
        r105 = "";
        goto L24
    L43:
        return;
    L12:
        if ((r110 instanceof AosUserProfileFeedFragmentViewModel) == false) goto L14;
        AosUserProfileFeedFragmentViewModel r116 = (AosUserProfileFeedFragmentViewModel) r110;
    L15:
        if (r116 == null) goto L17;
        r111 = r116.getFromGroupId();
        goto L18
    L14:
        r116 = null;
    L8:
        r101 = "";
        goto L10
    }

    public static void I(String r110, String r111, String r112, String r113, String r114, String r115, String r116, JSONObject r117) {
        Intrinsics.checkNotNullParameter(r110, "enterFromMerge");
        Intrinsics.checkNotNullParameter(r111, "enterMethod");
        Intrinsics.checkNotNullParameter("click", ReportConstant.COMMON_ACTION_TYPE);
        Intrinsics.checkNotNullParameter(r112, "anchorId");
        Intrinsics.checkNotNullParameter(r113, "roomId");
        Intrinsics.checkNotNullParameter("", "fromRoomId");
        Intrinsics.checkNotNullParameter(r114, "requestId");
        Intrinsics.checkNotNullParameter(r115, "anchorAid");
        Intrinsics.checkNotNullParameter(r116, "xgUid");
        Intrinsics.checkNotNullParameter("sdk_video", "videoSource");
        d14.a r100 = b14.a.f16924a;
        ((t24.a) b14.a.a(t24.a.class)).F1(r110, r111, r112, r113, r114, r115, r116, null, r117);
    }

    public static void J(String r110, String r111, String r112, String r113, float r114, float r115, String r116, e r117) {
        Intrinsics.checkNotNullParameter(r110, "authorOpenId");
        Intrinsics.checkNotNullParameter(r111, "enterFrom");
        Intrinsics.checkNotNullParameter(r112, "groupId");
        Intrinsics.checkNotNullParameter(r113, "imprId");
        d14.a r100 = b14.a.f16924a;
        ((t24.a) b14.a.a(t24.a.class)).S(r110, r111, r112, r113, r116, r114, r115, r117);
    }

    public static /* synthetic */ void p(AosEventReporter r110, String r111, String r112, String r113, String r114, c r115, FollowType r116, String r117, boolean r118) {
        r110.getClass();
        o(r111, r112, r113, r114, r115, r116, r117, false, r118, null);
    }

    public static void K(String r210, c r211, String r212, String r213, boolean r214, String r215, String r216, String r217, double r218, int r310) {
        Intrinsics.checkNotNullParameter(r210, "sceneId");
        Intrinsics.checkNotNullParameter(r211, ShareChannel.DOUYIN);
        Intrinsics.checkNotNullParameter(r212, "enterMethod");
        Intrinsics.checkNotNullParameter(r213, "slideDirection");
        Intrinsics.checkNotNullParameter(r215, "photoSerialNum");
        Intrinsics.checkNotNullParameter(r216, "allPhotoNum");
        Intrinsics.checkNotNullParameter(r217, "previousPage");
        d14.a r100 = b14.a.f16924a;
        t24.a r101 = (t24.a) b14.a.a(t24.a.class);
        User r102 = r211.f();
        if (r102 == null) goto L6;
        String r103 = r102.u();
        if (r103 == null) goto L6;
    L7:
        String r104 = r211.c();
        String r105 = r211.r().f535651c;
        if (r105 != null) goto L10;
        r105 = "";
    L10:
        String r110 = GsonProtectorUtils.toJson(GsonHolder.a(), r211.f535622d);
        a0 r106 = r211.f535622d;
        if (r106 == null) goto L14;
        String r107 = r106.a();
        if (r107 == null) goto L14;
    L15:
        String r108 = r103;
        r101.Z1(r210, r108, r104, r105, r212, r213, r107, r110, e(r211), r214, r215, r216, r217, r218, r310, new e(r211));
        return;
    L14:
        r107 = "";
    L6:
        r103 = "";
        goto L7
    }

    public static void o(String r210, String r211, String r212, String r213, c r214, FollowType r215, String r216, boolean r217, boolean r310, JSONObject r311) {
        Intrinsics.checkNotNullParameter(r210, "evenName");
        Intrinsics.checkNotNullParameter(r215, "followType");
        if (r214 != null) goto L5;
        return;
    L5:
        d14.a r100 = b14.a.f16924a;
        t24.a r101 = (t24.a) b14.a.a(t24.a.class);
        if (r211 != null) goto L8;
        String r102 = "";
    L9:
        User r103 = r214.f();
        if (r103 == null) goto L13;
        String r104 = r103.u();
        if (r104 == null) goto L13;
    L14:
        String r105 = r214.c();
        String r106 = b(r214, null);
        if (r106 != null) goto L19;
        if (r213 != null) goto L18;
        r106 = "";
        goto L19
    L18:
        r106 = r213;
    L19:
        a0 r107 = r214.f535622d;
        if (r107 == null) goto L23;
        String r108 = r107.a();
        if (r108 == null) goto L23;
    L24:
        String r110 = c(r214);
        int r111 = r214.i();
        boolean r112 = e(r214);
        if (r214.W() == false) goto L27;
        String r113 = PlayerResolution.SDKKEY.ORIGIN;
    L28:
        String r114 = r113;
        String r115 = r214.u();
        String r116 = r215.name();
        boolean r109 = r214.f535638t;
        if (r216 != null) goto L31;
        String r117 = "";
    L32:
        r101.W0(r210, r102, r104, r105, r106, r108, r110, r111, r112, r116, r109, r217, null, r117, r114, r115, r212, r311, r310);
        return;
    L31:
        r117 = r216;
        goto L32
    L27:
        r113 = "sdk";
    L23:
        r108 = "";
    L13:
        r104 = "";
        goto L14
    L8:
        r102 = r211;
        goto L9
    }

    public static void y(String r210, String r211, String r212, c r213, FollowType r214, String r215, boolean r216, boolean r217, JSONObject r218, String r310) {
        Intrinsics.checkNotNullParameter(r214, "followType");
        if (r213 != null) goto L5;
        return;
    L5:
        d14.a r100 = b14.a.f16924a;
        t24.a r101 = (t24.a) b14.a.a(t24.a.class);
        if (r210 != null) goto L8;
        String r102 = "";
    L9:
        User r103 = r213.f();
        if (r103 == null) goto L13;
        String r104 = r103.u();
        if (r104 == null) goto L13;
    L14:
        String r105 = r213.c();
        String r106 = b(r213, null);
        if (r106 != null) goto L19;
        if (r212 != null) goto L18;
        r106 = "";
        goto L19
    L18:
        r106 = r212;
    L19:
        a0 r107 = r213.f535622d;
        if (r107 == null) goto L23;
        String r108 = r107.a();
        if (r108 == null) goto L23;
    L24:
        String r109 = c(r213);
        boolean r110 = e(r213);
        if (r213.W() == false) goto L27;
        String r111 = PlayerResolution.SDKKEY.ORIGIN;
    L28:
        String r112 = r111;
        String r113 = r213.u();
        String r114 = r214.name();
        boolean r115 = r213.f535638t;
        if (r215 != null) goto L31;
        String r116 = "";
    L32:
        String r117 = r102;
        String r118 = r104;
        String r119 = r106;
        String r120 = r108;
        r101.b0(r117, r118, r105, r119, r120, r109, r110, r114, r115, r216, new e(r213), r116, r112, r113, r211, r218, r217, r310);
        return;
    L31:
        r116 = r215;
        goto L32
    L27:
        r111 = "sdk";
    L23:
        r108 = "";
    L13:
        r104 = "";
        goto L14
    L8:
        r102 = r210;
        goto L9
    }

    public static /* synthetic */ void H(AosEventReporter r110, String r111, String r112, String r113, String r114, String r115, String r116, String r210, String r211, String r212, String r213) {
        r110.getClass();
        G(r111, r112, r113, r114, r115, r116, r210, r211, r212, r213, null, "", "");
    }

    public static void w(String r210, String r211, c r212, String r213, String r214, String r215, EnterPersonalDetail r216, String r217, boolean r310, String r311, JSONObject r312) {
        Intrinsics.checkNotNullParameter(r210, "sceneId");
        Intrinsics.checkNotNullParameter(r212, ShareChannel.DOUYIN);
        Intrinsics.checkNotNullParameter(r214, "enterMethod");
        Intrinsics.checkNotNullParameter(r215, "toUserId");
        Intrinsics.checkNotNullParameter(r216, "position");
        d14.a r100 = b14.a.f16924a;
        t24.a r101 = (t24.a) b14.a.a(t24.a.class);
        String r102 = r212.c();
        String r103 = b(r212, null);
        if (r103 != null) goto L7;
        if (r213 != null) goto L6;
        r103 = "";
        goto L7
    L6:
        r103 = r213;
    L7:
        a0 r104 = r212.f535622d;
        if (r104 == null) goto L11;
        String r105 = r104.a();
        if (r105 == null) goto L11;
    L12:
        String r110 = c(r212);
        boolean r111 = e(r212);
        String r112 = r216.name();
        String r113 = r212.u();
        User r106 = r212.f();
        if (r106 == null) goto L18;
        String r107 = r106.u();
        if (r107 == null) goto L18;
        String r114 = r107;
    L19:
        if (r217 != null) goto L21;
        String r115 = "";
    L23:
        if (r212.W() == false) goto L25;
        String r108 = PlayerResolution.SDKKEY.ORIGIN;
    L26:
        String r116 = r108;
        User r109 = r212.f();
        if (r109 != null) goto L29;
    L31:
        boolean r218 = false;
    L32:
        String r117 = r105;
        r101.V1(r210, r214, r102, r103, r215, r117, r110, r111, r310, r112, new e(r212), r113, r114, r115, r116, r211, r311, r218, r312);
        return;
    L29:
        if (r109.R() != true) goto L31;
        r218 = true;
        goto L32
    L25:
        r108 = "sdk";
        goto L26
    L21:
        r115 = r217;
    L18:
        r114 = "";
    L11:
        r105 = "";
        goto L12
    }

    public static /* synthetic */ void z(AosEventReporter r110, String r111, String r112, String r113, c r114, FollowType r115, String r116, boolean r210, boolean r211, JSONObject r212, int r213) {
        if ((r213 & 64) == 0) goto L5;
        boolean r100 = false;
    L7:
        if ((r213 & 128) == 0) goto L9;
        boolean r117 = false;
    L11:
        if ((r213 & 256) == 0) goto L13;
        JSONObject r118 = null;
    L14:
        r110.getClass();
        y(r111, r112, r113, r114, r115, r116, r100, r117, r118, null);
        return;
    L13:
        r118 = r212;
        goto L14
    L9:
        r117 = r211;
        goto L11
    L5:
        r100 = r210;
        goto L7
    }

    public static void A(AosEventReporter r110, String r210, String r211, String r212, String r213, String r214, String r215, boolean r216, FollowType r217, String r218, boolean r219, JSONObject r310, int r311) {
        if ((r311 & 128) == 0) goto L5;
        boolean r100 = false;
    L7:
        if ((r311 & 512) == 0) goto L9;
        String r101 = "";
    L11:
        if ((r311 & 1024) == 0) goto L13;
        boolean r111 = false;
    L15:
        if ((r311 & 2048) == 0) goto L17;
        JSONObject r112 = null;
    L18:
        r110.getClass();
        Intrinsics.checkNotNullParameter(r215, "logPb");
        Intrinsics.checkNotNullParameter(r217, "followType");
        d14.a r102 = b14.a.f16924a;
        t24.a r103 = (t24.a) b14.a.a(t24.a.class);
        if (r210 != null) goto L21;
        String r104 = "";
    L22:
        if (r213 != null) goto L24;
        String r105 = "";
    L25:
        String r113 = r217.name();
        if (r212 != null) goto L28;
        String r114 = "";
    L29:
        if (r101 != null) goto L31;
        String r115 = "";
    L32:
        t24.a.C7679a.g(r103, r104, r105, r214, r211, r215, false, r113, false, r100, null, r114, r115, "", "", r112, r111, 147968);
        return;
    L31:
        r115 = r101;
        goto L32
    L28:
        r114 = r212;
        goto L29
    L24:
        r105 = r213;
        goto L25
    L21:
        r104 = r210;
        goto L22
    L17:
        r112 = r310;
        goto L18
    L13:
        r111 = r219;
        goto L15
    L9:
        r101 = r218;
        goto L11
    L5:
        r100 = r216;
        goto L7
    }

    public static void G(String r110, String r111, String r112, String r113, String r210, String r211, String r212, String r213, String r214, String r215, JSONObject r216, String r217, String r218) {
        Intrinsics.checkNotNullParameter(r110, "enterFromMerge");
        Intrinsics.checkNotNullParameter(r111, "enterMethod");
        Intrinsics.checkNotNullParameter("click", ReportConstant.COMMON_ACTION_TYPE);
        Intrinsics.checkNotNullParameter(r112, "aoEnterFromMerge");
        Intrinsics.checkNotNullParameter(r113, "aoEnterMethod");
        Intrinsics.checkNotNullParameter(r210, "aoActionType");
        Intrinsics.checkNotNullParameter(r211, "anchorId");
        Intrinsics.checkNotNullParameter(r212, "roomId");
        Intrinsics.checkNotNullParameter("", "fromRoomId");
        Intrinsics.checkNotNullParameter(r213, "requestId");
        Intrinsics.checkNotNullParameter(r214, "anchorAid");
        Intrinsics.checkNotNullParameter(r215, "xgUid");
        Intrinsics.checkNotNullParameter("sdk_video", "videoSource");
        Intrinsics.checkNotNullParameter(r217, "itemId");
        Intrinsics.checkNotNullParameter(r218, "enterRequestId");
        d14.a r100 = b14.a.f16924a;
        ((t24.a) b14.a.a(t24.a.class)).D2(r110, r111, r112, r113, r210, r211, r212, r213, r214, r215, null, r216, r217, r218);
    }
}
