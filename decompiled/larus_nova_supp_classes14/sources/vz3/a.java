package vz3;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.awemeopen.apps.framework.AosExtConfig;
import com.bytedance.awemeopen.apps.framework.collect.AosUserCollectActivity;
import com.bytedance.awemeopen.apps.framework.feed.AosEventReporter;
import com.bytedance.awemeopen.apps.framework.feed.home.AosFeedsHomeFragment;
import com.bytedance.awemeopen.apps.framework.feed.home.FeedHomeContainerViewModel;
import com.bytedance.awemeopen.apps.framework.feed.profile.AosUserProfileFeedFragmentViewModel;
import com.bytedance.awemeopen.apps.framework.framework.extension.ViewModelProviderFactory;
import com.bytedance.awemeopen.apps.framework.framework.viewpager.o;
import com.bytedance.awemeopen.apps.framework.profile.AosUserProfileActivity;
import com.bytedance.awemeopen.apps.framework.story.profile.StoryUserProfileFeedFragmentViewModel;
import com.bytedance.awemeopen.apps.framework.utils.j;
import com.bytedance.awemeopen.apps.framework.utils.v;
import com.bytedance.awemeopen.apps.photo.pinch.PinchEnterMethod;
import com.bytedance.awemeopen.bizmodels.profile.User;
import com.bytedance.awemeopen.export.api.pageconfig.collect.CollectPageConfig;
import com.bytedance.awemeopen.export.api.pageconfig.collect.CollectPageConfigBuilder;
import com.bytedance.awemeopen.export.api.pageconfig.profile.ProfilePageConfig;
import com.bytedance.awemeopen.export.api.pageconfig.profile.ProfilePageConfigBuilder;
import com.bytedance.awemeopen.infra.base.log.AoLogger;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import r14.a0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public a() {
    }

    public static void a(Context r3, ProfilePageConfig r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "profileConfig");
        if (r4.getOpenId() != null) goto L6;
        AoLogger.h("AuthorPageHelper", new Object[]{"openId不能为空"});
        return;
    L6:
        int r1 = AosUserProfileActivity.c;
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "config");
        Intent r0 = new Intent(r3, AosUserProfileActivity.class);
        r0.addFlags(268435456);
        if (r4.getClearTop() == false) goto L9;
        r0.addFlags(67108864);
    L9:
        Bundle r2 = new Bundle();
        r2.putParcelable("PROFILE_PAGE_CONFIG_CONFIG_KEY", r4);
        r0.putExtra("PROFILE_PAGE_CONFIG_CONFIG_KEY_BUNDLE", r2);
        if (r5 == null) goto L12;
        r0.putExtras(r5);
    L12:
        r3.startActivity(r0);
    }

    public static void c(Context r3, JSONObject r4, String r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        d14.a r1 = b14.a.a;
        com.bytedance.awemeopen.bizmodels.user.c r2 = b14.a.a(k34.b.class).getAccessToken();
        if (r2 == null) goto L5;
        String r6 = r2.b;
    L6:
        if (r6 != null) goto L9;
        AoLogger.h("AuthorPageHelper", new Object[]{"用户未授权，openId为空, 跳转收藏页面失败"});
        return;
    L9:
        CollectPageConfigBuilder.Companion.getClass();
        CollectPageConfigBuilder r7 = new CollectPageConfigBuilder().withOpenId(r6).withFromReqId(r5);
        if (r4 != null) goto L12;
        r4 = new JSONObject();
    L12:
        CollectPageConfig r8 = r7.withHostCommonParams(r4).build();
        int r9 = AosUserCollectActivity.d;
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r8, "config");
        Intent r10 = new Intent(r3, AosUserCollectActivity.class);
        r10.addFlags(268435456);
        r10.putExtra("COLLECT_PAGE_CONFIG_CONFIG_KEY", r8);
        r3.startActivity(r10);
        return;
    L5:
        r6 = null;
        goto L6
    }

    public static void b(Activity r19, o r20, r14.c r21, boolean r22, boolean r23) {
        Intrinsics.checkNotNullParameter(r19, "activity");
        Intrinsics.checkNotNullParameter(r20, "vm");
        Intrinsics.checkNotNullParameter(r21, "aweme");
        String r2 = r20.sceneId();
        if (Intrinsics.areEqual(r20.getPageConfig().getEnterAid(), r21.c()) == false) goto L5;
        String r5 = r20.getPageConfig().getEnterHostGid();
    L6:
        boolean r13 = true;
        if (r21.f() != null) goto L10;
        AoLogger.c("AuthorPageHelper", new Object[]{"forwardToAuthorPage author null"});
        return;
    L10:
        String r3 = r21.r().b;
        if (r3 != null) goto L13;
    L16:
        boolean r6 = true;
    L17:
        AosUserProfileFeedFragmentViewModel r15 = null;
        if (r6 == false) goto L23;
        User r4 = r21.f();
        if (r4 == null) goto L22;
        r3 = r4.u();
        goto L23
    L22:
        r3 = null;
    L23:
        String r7 = r21.u();
        if (r7 != null) goto L26;
    L31:
        boolean r8 = false;
    L32:
        if (r8 == false) goto L34;
        String r9 = new JSONObject(r7).optString("host_user_profile");
    L36:
        if (Intrinsics.areEqual(r20.getPageConfig().getEnterAid(), r21.c()) == false) goto L38;
        String r10 = PinchEnterMethod.CLICK;
    L39:
        String r11 = r10;
        ProfilePageConfigBuilder.Companion.getClass();
        ProfilePageConfigBuilder r12 = new ProfilePageConfigBuilder().withSceneId(r2);
        if (r3 != null) goto L42;
        String r14 = "";
    L43:
        ProfilePageConfigBuilder r16 = r12.withOpenId(r14).withAid(r21.c());
        a0 r17 = r21.d;
        if (r17 == null) goto L46;
        String r18 = r17.a();
    L47:
        ProfilePageConfigBuilder r24 = r16.withFromReqId(r18);
        if (r9 != null) goto L50;
        r9 = "";
    L50:
        ProfilePageConfigBuilder r25 = r24.withUserProfile(r9).withIsLiveType(v.b(r21)).withHideLongPressTab(r20.getPageConfig().getHideLongPressTab());
        JSONObject r26 = new JSONObject();
        r26.put("host_enter_from", r20.getPageConfig().getHostEnterFrom());
        ProfilePageConfigBuilder r27 = r25.withHostCommonParams(r26);
        JSONObject r28 = r20.getPageConfig().getHostExtraParams();
        if (r28 != null) goto L53;
        r28 = new JSONObject();
    L53:
        ProfilePageConfig r110 = r27.withHostExtraParams(r28).withCardMode(r20.getPageConfig().isCardMode()).withActionType(r11).build();
        r110.setClearTop(r23);
        String r29 = "click_head";
        if (Intrinsics.areEqual(r2, "collection_feed") == false) goto L56;
    L127:
        AosEventReporter r30 = AosEventReporter.a;
        String r31 = r20.sceneId();
        String r32 = r20.getPageConfig().getHostEnterFrom();
        if (r22 == true) goto L131;
        r29 = "click_name";
    L131:
        User r33 = r21.f();
        if (r33 == null) goto L135;
        String r34 = r33.u();
        if (r34 == null) goto L135;
    L136:
        if (r22 == false) goto L138;
        AosEventReporter.EnterPersonalDetail r35 = AosEventReporter.EnterPersonalDetail.click_avatar;
    L139:
        String r111 = r20.getPageConfig().getPreviousPage();
        boolean r112 = r20.getPageConfig().isCardMode();
        JSONObject r113 = r20.getPageConfig().getHostExtraParams();
        r30.getClass();
        ProfilePageConfig r210 = r110;
        AosEventReporter.w(r31, r32, r21, r5, r29, r34, r35, r111, r112, r11, r113);
        String r1 = r210.getOpenId();
        if (r1 != null) goto L142;
    L145:
        if (r13 == false) goto L151;
        User r36 = r21.f();
        if (r36 == null) goto L149;
        String r37 = r36.u();
    L150:
        r210.setOpenId(r37);
    L152:
        a(r19, r210, null);
        return;
    L149:
        r37 = null;
        goto L150
    L151:
        r210 = r210;
        goto L152
    L142:
        if (r1.length() == 0) goto L145;
        r13 = false;
        goto L145
    L138:
        r35 = AosEventReporter.EnterPersonalDetail.click_name;
    L135:
        r34 = "";
        goto L136
    L56:
        if ((r20 instanceof StoryUserProfileFeedFragmentViewModel) == true) goto L127;
        if (Intrinsics.areEqual(r2, "others_homepage") == false) goto L73;
        if ((r20 instanceof AosUserProfileFeedFragmentViewModel) == false) goto L63;
        r15 = (AosUserProfileFeedFragmentViewModel) r20;
    L63:
        if (r15 != null) goto L65;
        return;
    L65:
        if (Intrinsics.areEqual(r15.getFromUserOpenId(), r3) == false) goto L67;
        r19.finish();
        return;
    L67:
        Bundle r38 = new Bundle();
        if (r22 == true) goto L71;
        r29 = "click_name";
    L71:
        r38.putString("user_profile_feed_enter_method", r29);
        Unit r39 = Unit.INSTANCE;
        a(r19, r110, r38);
        return;
    L73:
        if (Intrinsics.areEqual(r2, "compilation_play") == false) goto L76;
        a(r19, r110, null);
        return;
    L76:
        if (Intrinsics.areEqual(r2, "homepage_hot") == true) goto L82;
        if (Intrinsics.areEqual(r2, "homepage_follow") == true) goto L82;
        if (Intrinsics.areEqual(r2, "video_channel") == true) goto L82;
        return;
    L82:
        if ((r19 instanceof FragmentActivity) == false) goto L90;
        Iterator r40 = ((FragmentActivity) r19).getSupportFragmentManager().getFragments().iterator();
        Fragment r41 = null;
    L85:
        if (r40.hasNext() == false) goto L89;
        Fragment r42 = (Fragment) r40.next();
        if ((r42 instanceof AosFeedsHomeFragment) == false) goto L85;
        r41 = r42;
        goto L85
    L89:
        Fragment r114 = r41;
    L91:
        if (r114 == null) goto L112;
        AosFeedsHomeFragment r115 = (AosFeedsHomeFragment) r114;
        if (Intrinsics.areEqual(r115.W90().getScrollable().getValue(), Boolean.FALSE) == false) goto L95;
        return;
    L95:
        AosEventReporter r0 = AosEventReporter.a;
        String r43 = r20.sceneId();
        String r44 = r20.getPageConfig().getHostEnterFrom();
        if (r22 == true) goto L99;
        r29 = "click_name";
    L99:
        User r45 = r21.f();
        if (r45 == null) goto L103;
        String r46 = r45.u();
        if (r46 == null) goto L103;
    L104:
        if (r22 == false) goto L106;
        AosEventReporter.EnterPersonalDetail r47 = AosEventReporter.EnterPersonalDetail.click_avatar;
    L107:
        String r48 = r20.getPageConfig().getPreviousPage();
        boolean r116 = r20.getPageConfig().isCardMode();
        JSONObject r117 = r20.getPageConfig().getHostExtraParams();
        r0.getClass();
        AosEventReporter.w(r43, r44, r21, r5, r29, r46, r47, r48, r116, r11, r117);
        ViewModelProviderFactory r49 = ViewModelProviderFactory.a;
        r49.getClass();
        FeedHomeContainerViewModel r50 = (FeedHomeContainerViewModel) new ViewModelProvider(r114, r49).get(FeedHomeContainerViewModel.class);
        if (r22 == false) goto L110;
        FeedHomeContainerViewModel.EnterProfileStyle r51 = FeedHomeContainerViewModel.EnterProfileStyle.ClickHeadToEnter;
    L111:
        r50.updateStartEnteringToProfile(r51);
        r115.ea0(1);
        return;
    L110:
        r51 = FeedHomeContainerViewModel.EnterProfileStyle.ClickUserNameToEnter;
        goto L111
    L106:
        r47 = AosEventReporter.EnterPersonalDetail.click_name;
    L103:
        r46 = "";
        goto L104
    L112:
        AosEventReporter r52 = AosEventReporter.a;
        String r53 = r20.sceneId();
        String r54 = r20.getPageConfig().getHostEnterFrom();
        if (r22 == true) goto L116;
        r29 = "click_name";
    L116:
        User r55 = r21.f();
        if (r55 == null) goto L120;
        String r56 = r55.u();
        if (r56 == null) goto L120;
    L121:
        if (r22 == false) goto L123;
        AosEventReporter.EnterPersonalDetail r57 = AosEventReporter.EnterPersonalDetail.click_avatar;
    L124:
        String r118 = r20.getPageConfig().getPreviousPage();
        boolean r119 = r20.getPageConfig().isCardMode();
        JSONObject r120 = r20.getPageConfig().getHostExtraParams();
        r52.getClass();
        AosEventReporter.w(r53, r54, r21, r5, r29, r56, r57, r118, r119, r11, r120);
        a(r19, r110, null);
        if (j.a() == false) goto L165;
        r19.overridePendingTransition(AosExtConfig.b.U0().getEnterAnim(), 2130772032);
        return;
    L165:
        return;
    L123:
        r57 = AosEventReporter.EnterPersonalDetail.click_name;
    L120:
        r56 = "";
        goto L121
    L90:
        r114 = null;
        goto L91
    L46:
        r18 = null;
        goto L47
    L42:
        r14 = r3;
        goto L43
    L38:
        r10 = "draw";
        goto L39
    L34:
        r9 = null;
        goto L36
    L26:
        if (r7.length() <= 0) goto L28;
        boolean r58 = true;
    L29:
        if (r58 != true) goto L31;
        r8 = true;
        goto L32
    L28:
        r58 = false;
        goto L29
    L13:
        if (r3.length() == 0) goto L16;
        r6 = false;
        goto L17
    L5:
        r5 = "";
        goto L6
    }
}
