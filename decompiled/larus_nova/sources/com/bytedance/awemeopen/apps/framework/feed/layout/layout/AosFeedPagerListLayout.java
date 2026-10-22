package com.bytedance.awemeopen.apps.framework.feed.layout.layout;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.lifecycle.Lifecycle;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.bytedance.awemeopen.apps.framework.AosExtConfig;
import com.bytedance.awemeopen.apps.framework.feed.AosEventReporter;
import com.bytedance.awemeopen.apps.framework.feed.pages.recommend.holder.PhotoFeedViewHolder;
import com.bytedance.awemeopen.apps.framework.feed.pages.recommend.holder.VideoFeedViewHolder;
import com.bytedance.awemeopen.apps.framework.framework.datawithstate.ListState;
import com.bytedance.awemeopen.apps.framework.framework.viewpager.FeedPagerListViewModel;
import com.bytedance.awemeopen.apps.framework.utils.AccountUsageHintHelper;
import com.bytedance.awemeopen.apps.framework.utils.IconSettingUtils;
import com.bytedance.awemeopen.apps.framework.utils.c0;
import com.bytedance.awemeopen.apps.framework.utils.z;
import com.bytedance.awemeopen.bizmodels.profile.User;
import com.bytedance.awemeopen.export.api.AosConfigService;
import com.bytedance.awemeopen.export.api.pageconfig.recfeed.FeedPageConfig;
import com.bytedance.awemeopen.export.api.pageconfig.recfeed.FeedPageConfigBuilder;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.share.panel.ShareChannel;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import r14.a0;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000\u00032\u00020\u0005B\u000f\u0012\u0006\u0010(\u001a\u00020'¢\u0006\u0004\b)\u0010*J\u0006\u0010\u0007\u001a\u00020\u0006J\u0012\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u000e\u0010\u000e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000fR$\u0010\u0018\u001a\u0004\u0018\u00010\u000f8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R(\u0010\u001e\u001a\u0004\u0018\u00010\f2\b\u0010\u0019\u001a\u0004\u0018\u00010\f8F@BX\u0086\u000e¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR$\u0010&\u001a\u0004\u0018\u00010\u001f8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%¨\u0006+"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/feed/layout/layout/AosFeedPagerListLayout;", "Lcom/bytedance/awemeopen/apps/framework/framework/viewpager/FeedPagerListViewModel;", "VM", "Lcom/bytedance/awemeopen/apps/framework/feed/layout/layout/AosPagerListLayout;", "Ljz3/a;", "Lcom/bytedance/awemeopen/apps/framework/utils/z;", "Lcom/bytedance/awemeopen/apps/framework/utils/audio/a;", "getAudioHelper", "Landroid/os/Bundle;", "bundle", "", "setArguments", "Lk54/c;", "listener", "setFeedPageListener", "Ljz3/b;", "feedContext", "setFeedListContext", FaceService.girlLabel, "Ljz3/b;", "getAosFeedListContext", "()Ljz3/b;", "setAosFeedListContext", "(Ljz3/b;)V", "aosFeedListContext", "<set-?>", "G", "Lk54/c;", "getFeedPageListener", "()Lk54/c;", "feedPageListener", "Lr14/c;", FaceService.neutralLabel, "Lr14/c;", "getAweme", "()Lr14/c;", "setAweme", "(Lr14/c;)V", ShareChannel.DOUYIN, "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public abstract class AosFeedPagerListLayout<VM extends FeedPagerListViewModel> extends AosPagerListLayout<jz3.a, VM> implements z {
    public static final /* synthetic */ int O = 0;
    public boolean E;
    public jz3.b F;
    public k54.c G;
    public r14.c H;
    public jz3.a I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final com.bytedance.awemeopen.apps.framework.utils.audio.a f194861J;
    public boolean K;
    public boolean L;
    public boolean M;
    public final AosFeedPagerListLayout$enterPinchObserver$1 N;

    public abstract void a0(int r100, jz3.a r101);

    @Override // com.bytedance.awemeopen.apps.framework.feed.layout.layout.AosBaseLayout
    public int f() {
        return R.layout.aos_fragment_feed_recommend;
    }

    public final k54.c getFeedPageListener() {
        if (this.G != null) goto L12;
        jz3.b r100 = this.F;
        if (r100 == null) goto L9;
        Function0<? extends k54.c> r101 = r100.f501182b;
        if (r101 == null) goto L9;
        k54.c r102 = r101.invoke();
    L10:
        this.G = r102;
    L9:
        r102 = null;
    L12:
        return this.G;
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [java.lang.Object] */
    public final boolean W() {
        Object r100 = getVm().getDataList().getValue();
        Intrinsics.checkNotNull(r100);
        List r101 = (List) ((ListState) r100).f196927a;
        int r102 = getVm().getCurrentSelectedIndex();
        if (r102 >= 0) goto L5;
        return false;
    L5:
        if (r102 >= r101.size()) goto L21;
        com.bytedance.awemeopen.apps.framework.framework.viewpager.g<jz3.a> r103 = getAdapter().k(ListProtector.get(r101, r102));
        if ((r103 instanceof VideoFeedViewHolder) == false) goto L9;
    L12:
        boolean r104 = true;
    L13:
        if (r104 == true) goto L15;
        return false;
    L15:
        if (r103 != null) goto L17;
        return false;
    L17:
        if (r103.d() != true) goto L23;
        return true;
    L23:
        return false;
    L9:
        if ((r103 instanceof PhotoFeedViewHolder) == true) goto L12;
        r104 = false;
        goto L13
    L21:
        return false;
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [java.lang.Object] */
    public final void Z() {
        Object r100 = getVm().getDataList().getValue();
        Intrinsics.checkNotNull(r100);
        List r101 = (List) ((ListState) r100).f196927a;
        int r102 = getVm().getCurrentSelectedIndex();
        if (r102 >= 0) goto L5;
        return;
    L5:
        if (r102 >= r101.size()) goto L19;
        com.bytedance.awemeopen.apps.framework.framework.viewpager.g<jz3.a> r103 = getAdapter().k(ListProtector.get(r101, r102));
        PhotoFeedViewHolder r104 = null;
        if ((r103 instanceof VideoFeedViewHolder) == false) goto L9;
        VideoFeedViewHolder r105 = (VideoFeedViewHolder) r103;
    L10:
        if (r105 == null) goto L13;
        r105.f195123i.r();
    L13:
        if ((r103 instanceof PhotoFeedViewHolder) == false) goto L15;
        r104 = (PhotoFeedViewHolder) r103;
    L15:
        if (r104 == null) goto L20;
        r104.f195115l.r();
        return;
    L20:
        return;
    L9:
        r105 = null;
        goto L10
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.layout.layout.AosPagerListLayout, com.bytedance.awemeopen.apps.framework.feed.layout.layout.AosBaseLayout
    public void h() {
        super.h();
        boolean r100 = getVm().getPageConfig().getShowBackButton();
        View r101 = findViewById(R.id.feed_back_btn);
        if (r100 == false) goto L5;
        x54.b.d(r101);
        r101.setOnClickListener(new a(this));
    L6:
        getVm().getFeedPlayerHelper().c(new b(this));
        getVm().getEnterPinchMode().observe(this, this.N);
        String[] r102 = c0.f197682a;
        c0.b(getContext(), this);
        return;
    L5:
        x54.b.a(r101);
        goto L6
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.layout.layout.AosPagerListLayout, com.bytedance.awemeopen.apps.framework.feed.layout.layout.AosBaseLayout
    public void i() {
        super.i();
        String[] r100 = c0.f197682a;
        c0.c(getContext(), this);
        getVm().getEnterPinchMode().removeObserver(this.N);
        this.M = false;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.layout.layout.AosBaseLayout
    public void j() {
        getVm().getFeedHomeContainerDeliverHiddenState().setValue(Boolean.valueOf(getDeliverHiddenChangedCache()));
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.layout.layout.AosPagerListLayout, com.bytedance.awemeopen.apps.framework.feed.layout.layout.AosBaseLayout
    public final void k() {
        Bundle r100 = getBundle();
        if (r100 == null) goto L5;
        FeedPageConfig r101 = (FeedPageConfig) r100.getParcelable(FeedPageConfigBuilder.CONFIG_KEY);
    L6:
        if (r101 != null) goto L8;
        r101 = new FeedPageConfig();
    L8:
        getVm().initPageConfig(r101);
        return;
    L5:
        r101 = null;
        goto L6
    }

    public final jz3.b getAosFeedListContext() {
        return this.F;
    }

    public final com.bytedance.awemeopen.apps.framework.utils.audio.a getAudioHelper() {
        return this.f194861J;
    }

    public final r14.c getAweme() {
        return this.H;
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [com.bytedance.awemeopen.apps.framework.feed.layout.layout.AosFeedPagerListLayout$enterPinchObserver$1] */
    public AosFeedPagerListLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        new LinkedHashMap();
        super(r100);
        this.E = true;
        this.f194861J = new com.bytedance.awemeopen.apps.framework.utils.audio.a();
        this.N = new AosFeedPagerListLayout$enterPinchObserver$1(this);
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.layout.layout.AosPagerListLayout
    public void M(boolean r100) {
        if (r100 == false) goto L13;
        k54.c r101 = getFeedPageListener();
        if (r101 == null) goto L14;
        ListState r102 = (ListState) getVm().getDataList().getValue();
        if (r102 == null) goto L8;
        String r103 = r102.f196935i;
    L9:
        if (r103 != null) goto L11;
        r103 = "";
    L11:
        r101.onLoadError(r103);
        return;
    L8:
        r103 = null;
        goto L9
    L14:
        return;
    }

    @Override // com.bytedance.awemeopen.apps.framework.utils.z
    public final void M00(String r100) {
        Intrinsics.checkNotNullParameter(r100, "filePath");
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == false) goto L6;
        AosEventReporter r101 = AosEventReporter.f194596a;
        VM r102 = getVm();
        r14.c r103 = this.H;
        r101.getClass();
        AosEventReporter.P(r102, r103);
        return;
    }

    public final void setAosFeedListContext(jz3.b r100) {
        this.F = r100;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.layout.layout.AosPagerListLayout, com.bytedance.awemeopen.apps.framework.feed.layout.layout.AosBaseLayout
    public void setArguments(Bundle r100) {
        super.setArguments(r100);
        setBundle(r100);
    }

    public final void setAweme(r14.c r100) {
        this.H = r100;
    }

    public final void setFeedListContext(jz3.b r100) {
        Intrinsics.checkNotNullParameter(r100, "feedContext");
        this.F = r100;
    }

    public final void setFeedPageListener(k54.c r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.G = r100;
    }

    public void V(int r110, jz3.a r210) {
        Intrinsics.checkNotNullParameter(r210, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        ListState r100 = (ListState) getVm().getDataList().getValue();
        Drawable r101 = null;
        if (r100 == null) goto L7;
        List r102 = (List) r100.f196927a;
        if (r102 == null) goto L7;
        jz3.a r103 = (jz3.a) CollectionsKt.getOrNull(r102, r110);
    L8:
        if (r103 == null) goto L10;
        r14.c r104 = r103.f501173a;
    L11:
        r14.c r105 = this.H;
        if (r105 == null) goto L14;
        Long r106 = Long.valueOf(r105.f535621c);
    L15:
        if (r104 == null) goto L17;
        Long r107 = Long.valueOf(r104.f535621c);
    L19:
        if (Intrinsics.areEqual(r106, r107) == true) goto L21;
        a0(r110, r210);
    L21:
        jz3.a r108 = this.I;
        boolean r109 = true;
        if (r108 != null) goto L24;
    L26:
        boolean r111 = false;
    L27:
        if (r111 == false) goto L31;
        if (r108 == null) goto L31;
        r108.f501179g = false;
    L31:
        this.I = r210;
        this.H = r104;
        RelativeLayout r112 = (RelativeLayout) findViewById(R.id.right_area);
        if (r112 == null) goto L89;
        Ref.ObjectRef r113 = new Ref.ObjectRef();
        Integer r114 = Integer.valueOf(r110);
        if (r114.intValue() < 0) goto L37;
        boolean r115 = true;
    L38:
        if (r115 == true) goto L41;
        r114 = null;
    L41:
        if (r103 == null) goto L43;
        AosConfigService.b r116 = new AosConfigService.b(u(r110, r103), r114);
    L44:
        AosExtConfig r117 = AosExtConfig.f193138b;
        Context r118 = getContext();
        r14.c r119 = this.H;
        if (r119 == null) goto L47;
        String r120 = r119.u();
    L48:
        View r121 = r117.L1(r118, r120, getVm().getContentScene(), new c(this, r103, r113), r116);
        r112.removeAllViews();
        if (r121 == null) goto L89;
        r112.addView(r121);
        List r122 = (List) r113.element;
        if (r122 == null) goto L89;
        Iterator r123 = r122.iterator();
    L55:
        if (r123.hasNext() == false) goto L89;
        String r124 = (String) r123.next();
        AosEventReporter r125 = AosEventReporter.f194596a;
        VM r126 = getVm();
        r125.getClass();
        Intrinsics.checkNotNullParameter(r124, "function_name");
        String r127 = "";
        if (r126 == null) goto L60;
        String r128 = r126.sceneId();
        if (r128 == null) goto L60;
    L61:
        if (r103 == null) goto L55;
        r14.c r129 = r103.f501173a;
        if (r129 == null) goto L55;
        d14.a r130 = b14.a.f16924a;
        t24.a r131 = (t24.a) b14.a.a(t24.a.class);
        User r132 = r129.f();
        if (r132 == null) goto L68;
        String r133 = r132.u();
        if (r133 == null) goto L68;
    L69:
        String r134 = r129.c();
        a0 r135 = r129.f535622d;
        if (r135 == null) goto L75;
        String r136 = r135.a();
        if (r136 == null) goto L75;
        String r137 = r136;
    L76:
        String r138 = AosEventReporter.c(r103.f501173a);
        if (r103.f501173a.W() == false) goto L79;
        String r139 = PlayerResolution.SDKKEY.ORIGIN;
    L80:
        String r140 = r139;
        if (r126 == null) goto L88;
        FeedPageConfig r141 = r126.getPageConfig();
        if (r141 == null) goto L88;
        String r142 = r141.getPreviousPage();
        if (r142 == null) goto L88;
        r127 = r142;
    L88:
        r131.K1(r128, r133, r134, r137, r138, r140, r127, r124);
        goto L55
    L79:
        r139 = "sdk";
    L75:
        r137 = "";
    L68:
        r133 = "";
    L60:
        r128 = "";
        goto L61
    L47:
        r120 = null;
        goto L48
    L43:
        r116 = null;
        goto L44
    L37:
        r115 = false;
    L89:
        ImageView r143 = (ImageView) findViewById(R.id.aweme_icon);
        if (r143 != null) goto L93;
    L141:
        if (r110 == 0) goto L144;
        this.E = false;
    L144:
        if (this.E == true) goto L146;
        getVm().setStartType("next_video");
    L146:
        getVm().setOverType("next_video");
        return;
    L93:
        if (((Boolean) IconSettingUtils.f197661b.getValue()).booleanValue() == false) goto L97;
        Context r144 = getContext();
        if (r144 == null) goto L100;
        r101 = r144.getDrawable(R.drawable.aos_douyin_short_top_water_mark);
    L100:
        r143.setImageDrawable(r101);
        if (IconSettingUtils.a() != (-1)) goto L122;
        if (com.bytedance.awemeopen.apps.framework.feed.ui.information.a.f195993e == false) goto L105;
    L123:
        boolean r145 = true;
    L125:
        r14.c r146 = this.H;
        if (r146 != null) goto L128;
    L130:
        boolean r147 = false;
    L131:
        if (r147 == true) goto L137;
        if (r145 == true) goto L137;
        if (((Boolean) IconSettingUtils.f197660a.getValue()).booleanValue() == true) goto L137;
        r109 = false;
    L137:
        if (r109 == false) goto L139;
        int r148 = 8;
    L140:
        r143.setVisibility(r148);
        goto L141
    L139:
        r148 = 0;
        goto L140
    L128:
        if (r146.W() != true) goto L130;
        r147 = true;
        goto L131
    L105:
        if (com.bytedance.awemeopen.apps.framework.feed.ui.information.a.f195996h == true) goto L123;
        if (AosExtConfig.f193138b.W1().f22481a == false) goto L116;
        FeedPageConfig r149 = getVm().getPageConfig();
        if (r149 != null) goto L111;
    L113:
        boolean r150 = false;
    L114:
        if (r150 == false) goto L116;
        boolean r151 = true;
    L117:
        if (r151 == true) goto L123;
        if (getVm().getPageConfig().getShowSeriesChannel() == true) goto L123;
    L124:
        r145 = false;
        goto L125
    L111:
        if (r149.getUselessFollowChannel() == true) goto L113;
        r150 = true;
    L116:
        r151 = false;
        goto L117
    L122:
        if (IconSettingUtils.a() == 0) goto L124;
    L97:
        Context r152 = getContext();
        if (r152 == null) goto L100;
        r101 = r152.getDrawable(R.drawable.aos_douyin_top_water_mark);
        goto L100
    L24:
        if (r108.f501179g != true) goto L26;
        r111 = true;
        goto L27
    L17:
        r107 = null;
        goto L19
    L14:
        r106 = null;
        goto L15
    L10:
        r104 = null;
    L7:
        r103 = null;
        goto L8
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.layout.layout.AosPagerListLayout
    public final boolean t(jz3.a r100, com.bytedance.awemeopen.apps.framework.framework.viewpager.g<jz3.a> r101) {
        jz3.a r102 = r100;
        Intrinsics.checkNotNullParameter(r102, "data");
        jz3.a r103 = r101.f197059b;
        if (r103 == null) goto L9;
        r14.c r104 = r103.f501173a;
        if (r104 == null) goto L9;
        if (r102.f501173a.f535621c != r104.f535621c) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.layout.layout.AosPagerListLayout
    public /* bridge */ /* synthetic */ void w(int r100, jz3.a r101) {
        V(r100, r101);
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.layout.layout.AosPagerListLayout
    public void N(List<jz3.a> r100, boolean r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Intrinsics.checkNotNullParameter(r100, "data");
        Object r103 = getVm().getDataList().getValue();
        Intrinsics.checkNotNull(r103);
        if (((ListState) r103).f196929c != ListState.State.INITIAL_SUCCESS) goto L5;
        boolean r104 = true;
    L6:
        if (r104 == false) goto L23;
        Iterator<T> r105 = r100.iterator();
    L9:
        if (r105.hasNext() == false) goto L12;
        ((jz3.a) r105.next()).f501180h = true;
        goto L9
    L12:
        if (Intrinsics.areEqual(getVm().sceneId(), UserProfileEvent.DATA_TYPE_HOME_PAGE_HOT) == false) goto L18;
        getVm().getPageConfig().getEnterAid();
        if ((getContext() instanceof Activity) == false) goto L16;
        Context r106 = getContext();
        Intrinsics.checkNotNull(r106, "null cannot be cast to non-null type android.app.Activity");
        Activity r107 = (Activity) r106;
    L17:
        Lazy r108 = AccountUsageHintHelper.f197654a;
        AccountUsageHintHelper.c(r107);
        goto L18
    L16:
        r107 = null;
    L18:
        k54.c r109 = getFeedPageListener();
        if (r109 == null) goto L24;
        r109.onLoadSuccess();
        return;
    L24:
        return;
    L23:
        return;
    L5:
        r104 = false;
        goto L6
    }
}
