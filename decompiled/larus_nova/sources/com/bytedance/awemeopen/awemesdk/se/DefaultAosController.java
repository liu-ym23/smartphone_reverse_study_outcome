package com.bytedance.awemeopen.awemesdk.se;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.awemeopen.apps.framework.AosC2RefactorService;
import com.bytedance.awemeopen.apps.framework.AosPhotoRefactorService;
import com.bytedance.awemeopen.apps.framework.AosSeriesRefactorService;
import com.bytedance.awemeopen.apps.framework.card.c;
import com.bytedance.awemeopen.apps.framework.card.dialog.AosHostCardBottomPanelDialog;
import com.bytedance.awemeopen.apps.framework.card.video.FeedVideoItemView;
import com.bytedance.awemeopen.apps.framework.feed.home.AosFeedsHomeFragment;
import com.bytedance.awemeopen.apps.framework.feed.home.AosHomeFeedActivity;
import com.bytedance.awemeopen.apps.framework.feed.pages.recommend.AosFeedsChannelFragment;
import com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment;
import com.bytedance.awemeopen.apps.framework.framework.viewpager.helper.AosEnterDyPlayerToastHelper;
import com.bytedance.awemeopen.apps.framework.report.CozeJsHandler;
import com.bytedance.awemeopen.apps.framework.utils.AosPreloadHelper;
import com.bytedance.awemeopen.apps.framework.utils.h0;
import com.bytedance.awemeopen.apps.framework.utils.p;
import com.bytedance.awemeopen.export.api.IAosController;
import com.bytedance.awemeopen.export.api.c2.C2CardConfig;
import com.bytedance.awemeopen.export.api.pageconfig.feedhome.FeedsHomePageConfig;
import com.bytedance.awemeopen.export.api.pageconfig.feedhome.HostEventParameters;
import com.bytedance.awemeopen.export.api.pageconfig.profile.ProfilePageConfig;
import com.bytedance.awemeopen.export.api.pageconfig.recfeed.FeedPageConfig;
import com.bytedance.awemeopen.export.api.pageconfig.recfeed.FeedPageConfigBuilder;
import com.bytedance.awemeopen.export.api.pageconfig.series.SeriesPageConfig;
import com.bytedance.awemeopen.export.api.picturedetail.AosPictureDetailConfig;
import com.bytedance.awemeopen.export.api.series.homepage.SeriesHomePageConfig;
import com.bytedance.awemeopen.infra.base.env.AoEnv;
import com.bytedance.awemeopen.infra.base.image.AoImageView;
import com.bytedance.awemeopen.infra.base.log.AoLogger;
import com.bytedance.awemeopen.infra.support.ListenerDispatchSupport;
import com.bytedance.bdp.bdpbase.manager.BdpManager;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import y24.d;

/* JADX INFO: loaded from: classes44.dex */
public final class DefaultAosController implements IAosController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DefaultAosController f198160a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f198161b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f198162c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f198163d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final k34.b f198164e = null;

    public DefaultAosController() {
    }

    @Override // com.bytedance.awemeopen.export.api.IAosController
    @Deprecated(message = "")
    public final void autoLogin(Context r100, i54.a r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    @Override // com.bytedance.awemeopen.export.api.IAosController
    @Deprecated(message = "")
    public final void logout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    static {
        f198160a = new DefaultAosController();
        Lazy r100 = LazyKt.lazy(DefaultAosController$followService$2.INSTANCE);
        f198161b = r100;
        f198162c = LazyKt.lazy(DefaultAosController$authorService$2.INSTANCE);
        f198163d = LazyKt.lazy(DefaultAosController$mFollowStatusDispatchSupport$2.INSTANCE);
        d14.a r101 = b14.a.f16924a;
        f198164e = (k34.b) b14.a.a(k34.b.class);
        ((d) r100.getValue()).R2(new DefaultAosController$initFollowStatusListener$1());
    }

    public static void a() {
        Aos r100 = Aos.INSTANCE;
        if (r100.isInited() == true) goto L6;
        r100.init();
        return;
    }

    @Override // com.bytedance.awemeopen.export.api.IAosController
    public final void closeSideProfile() {
        d14.a r100 = b14.a.f16924a;
        ((w24.d) b14.a.a(w24.d.class)).closeSideProfile();
    }

    @Override // com.bytedance.awemeopen.export.api.IAosController
    public final void feedDislike() {
        d14.a r100 = b14.a.f16924a;
        ((w24.d) b14.a.a(w24.d.class)).c2();
    }

    @Override // com.bytedance.awemeopen.export.api.IAosController
    public final p54.b getTopPlayerController() {
        com.bytedance.awemeopen.apps.framework.player.d r100 = com.bytedance.awemeopen.apps.framework.player.d.f197276a;
        return com.bytedance.awemeopen.apps.framework.player.d.f197279d;
    }

    @Override // com.bytedance.awemeopen.export.api.IAosController
    public final void openSideProfile() {
        d14.a r100 = b14.a.f16924a;
        ((w24.d) b14.a.a(w24.d.class)).openSideProfile();
    }

    @Override // com.bytedance.awemeopen.export.api.IAosController
    public final void recycle() {
        d14.a r100 = b14.a.f16924a;
        b14.a.f16924a.getClass();
        Iterator<T> r101 = d14.a.f466375b.values().iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        k24.a r102 = (k24.a) r101.next();
        if ((r102 instanceof n24.a) == false) goto L4;
        ((n24.a) r102).f();
        goto L4
    }

    @Override // com.bytedance.awemeopen.export.api.IAosController
    public final q54.b getPreloader() {
        a();
        return AosPreloadHelper.f197655a;
    }

    @Override // com.bytedance.awemeopen.export.api.IAosController
    public final p44.a getVideoCardProvider() {
        a();
        return c.f193814a;
    }

    @Override // com.bytedance.awemeopen.export.api.IAosController
    public final i54.b getAuthContextProvider() {
        return com.bytedance.awemeopen.apps.framework.utils.c.f197680a;
    }

    @Override // com.bytedance.awemeopen.export.api.IAosController
    public final void addFollowStatusListener(e54.b r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        ListenerDispatchSupport r101 = (ListenerDispatchSupport) f198163d.getValue();
        if (((CopyOnWriteArrayList) r101.f198939a.getValue()).contains(r100) == true) goto L6;
        ((CopyOnWriteArrayList) r101.f198939a.getValue()).add(r100);
        return;
    }

    @Override // com.bytedance.awemeopen.export.api.IAosController
    public final void addGlobalPlayerListener(p54.a r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        com.bytedance.awemeopen.apps.framework.player.d r101 = com.bytedance.awemeopen.apps.framework.player.d.f197276a;
        Intrinsics.checkNotNullParameter(r100, "listener");
        ArrayList<p54.a> r102 = com.bytedance.awemeopen.apps.framework.player.d.f197281f;
        if (r102.contains(r100) == true) goto L6;
        r102.add(r100);
        return;
    }

    @Override // com.bytedance.awemeopen.export.api.IAosController
    public final s44.a createCardBottomPanelDialog(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        return new AosHostCardBottomPanelDialog(r100);
    }

    @Override // com.bytedance.awemeopen.export.api.IAosController
    public final d54.a createRecFeedFragment(FeedPageConfig r100) {
        Intrinsics.checkNotNullParameter(r100, "pageConfig");
        a();
        AosFeedsChannelFragment r101 = new AosFeedsChannelFragment();
        Bundle r102 = new Bundle();
        r102.putParcelable(FeedPageConfigBuilder.CONFIG_KEY, r100);
        r101.setArguments(r102);
        return r101;
    }

    @Override // com.bytedance.awemeopen.export.api.IAosController
    public final u54.a createSeriesFeedView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AosSeriesRefactorService r101 = (AosSeriesRefactorService) BdpManager.getInst().getService(AosSeriesRefactorService.class);
        if (r101 == null) goto L7;
        r101.y0();
        return null;
    L7:
        return null;
    }

    @Override // com.bytedance.awemeopen.export.api.IAosController
    public final n44.a createSeriesHomepageFragment(SeriesHomePageConfig r100) {
        Intrinsics.checkNotNullParameter(r100, "pageConfig");
        a();
        AosSeriesRefactorService r101 = (AosSeriesRefactorService) BdpManager.getInst().getService(AosSeriesRefactorService.class);
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.i0();
    }

    @Override // com.bytedance.awemeopen.export.api.IAosController
    public final void feedInsert(String r100) {
        Intrinsics.checkNotNullParameter(r100, "hostRawData");
        d14.a r101 = b14.a.f16924a;
        ((w24.d) b14.a.a(w24.d.class)).insert(r100);
    }

    @Override // com.bytedance.awemeopen.export.api.IAosController
    public final Object getCozeJsHandler(WebView r100) {
        Intrinsics.checkNotNullParameter(r100, "webview");
        return new CozeJsHandler(r100);
    }

    @Override // com.bytedance.awemeopen.export.api.IAosController
    public final long getUserLastShowEnterToastTime(String r100) {
        Intrinsics.checkNotNullParameter(r100, "openId");
        a();
        Lazy r101 = AosEnterDyPlayerToastHelper.f197063a;
        Intrinsics.checkNotNullParameter(r100, "openId");
        if (r100.length() != 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == true) goto L10;
        long r103 = ((SharedPreferences) AosEnterDyPlayerToastHelper.f197063a.getValue()).getLong(r100, 0);
        if (r103 <= 0) goto L10;
        return r103;
    L10:
        return -1;
    L5:
        r102 = false;
        goto L6
    }

    @Override // com.bytedance.awemeopen.export.api.IAosController
    public final u54.b initSeriesLight(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AosSeriesRefactorService r101 = (AosSeriesRefactorService) BdpManager.getInst().getService(AosSeriesRefactorService.class);
        if (r101 == null) goto L7;
        r101.t0();
        return null;
    L7:
        return null;
    }

    @Override // com.bytedance.awemeopen.export.api.IAosController
    public final boolean onBackPressed(FragmentActivity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        a();
        int r101 = com.bytedance.awemeopen.apps.framework.utils.d.f197686a;
        return com.bytedance.awemeopen.apps.framework.utils.d.a.b(r100);
    }

    @Override // com.bytedance.awemeopen.export.api.IAosController
    public final void removeFollowStatusListener(e54.b r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        ((CopyOnWriteArrayList) ((ListenerDispatchSupport) f198163d.getValue()).f198939a.getValue()).remove(r100);
    }

    @Override // com.bytedance.awemeopen.export.api.IAosController
    public final void removeGlobalPlayerListener(p54.a r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        com.bytedance.awemeopen.apps.framework.player.d r101 = com.bytedance.awemeopen.apps.framework.player.d.f197276a;
        Intrinsics.checkNotNullParameter(r100, "listener");
        com.bytedance.awemeopen.apps.framework.player.d.f197281f.remove(r100);
    }

    @Override // com.bytedance.awemeopen.export.api.IAosController
    public final void reportVideoCardClick(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "param");
        d14.a r101 = b14.a.f16924a;
        ((t24.a) b14.a.a(t24.a.class)).reportVideoCardClick(r100);
    }

    @Override // com.bytedance.awemeopen.export.api.IAosController
    public final void reportVideoCardShow(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "param");
        d14.a r101 = b14.a.f16924a;
        ((t24.a) b14.a.a(t24.a.class)).reportVideoCardShow(r100);
    }

    @Override // com.bytedance.awemeopen.export.api.IAosController
    public final void updateCurrentHostVideoData(String r100) {
        Intrinsics.checkNotNullParameter(r100, "hostRawData");
        d14.a r101 = b14.a.f16924a;
        ((w24.d) b14.a.a(w24.d.class)).updateCurrentHostVideoData(r100);
    }

    @Override // com.bytedance.awemeopen.export.api.IAosController
    public final o44.a createC2CardLayout(Context r100, C2CardConfig r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "pageConfig");
        a();
        int r102 = com.bytedance.awemeopen.infra.support.a.f198940a;
        com.bytedance.awemeopen.infra.support.a.a("open", "call_host_start_open", AnonymousClass1.INSTANCE);
        AosC2RefactorService r103 = (AosC2RefactorService) BdpManager.getInst().getService(AosC2RefactorService.class);
        if (r103 == null) goto L7;
        r103.t2();
        return null;
    L7:
        return null;
    }

    @Override // com.bytedance.awemeopen.export.api.IAosController
    public final n54.a createPictureDetailFragment(Context r100, AosPictureDetailConfig r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "pageConfig");
        a();
        AosPhotoRefactorService r102 = (AosPhotoRefactorService) BdpManager.getInst().getService(AosPhotoRefactorService.class);
        if (r102 != null) goto L7;
        return null;
    L7:
        return r102.createPictureDetailFragment(r100, r101);
    }

    @Override // com.bytedance.awemeopen.export.api.IAosController
    public final u54.c createSeriesLightView(Context r100, u54.d r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AosSeriesRefactorService r102 = (AosSeriesRefactorService) BdpManager.getInst().getService(AosSeriesRefactorService.class);
        if (r102 == null) goto L7;
        r102.M();
        return null;
    L7:
        return null;
    }

    @Override // com.bytedance.awemeopen.export.api.IAosController
    public final void getMaaSToken(String r100, c54.d r101) {
        Intrinsics.checkNotNullParameter(r100, "tagsInString");
        final c54.d r102 = null;
        Intrinsics.checkNotNullParameter(null, "callback");
        a();
        d14.a r103 = b14.a.f16924a;
        ((w24.d) b14.a.a(w24.d.class)).t2(r100, new C104451(r102));
    }

    @Override // com.bytedance.awemeopen.export.api.IAosController
    public final void handleSchema(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L10:
        if (r102 == false) goto L13;
        AoLogger.c("SCHEMA_HANDLER", new Object[]{"schema is null or empty"});
        return;
    L13:
        a();
        List<s04.a> r103 = s04.c.f540013a;
        Uri r104 = UriProtector.parse(r101);
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r104, "uri");
        AoLogger.b("SCHEMA_HANDLER", new Object[]{"schema start handler, uri = " + r104});
        if (r104.isOpaque() == true) goto L30;
        Iterator r105 = ((ArrayList) s04.c.f540013a).iterator();
    L18:
        if (r105.hasNext() == false) goto L22;
        s04.a r106 = (s04.a) r105.next();
        if (r106.a(r104) == false) goto L18;
    L23:
        if (r106 == null) goto L25;
        r106.b(r100, r104);
    L25:
        AoLogger.b("SCHEMA_HANDLER", new Object[]{"schema handler finish, uri = " + r104});
        return;
    L22:
        r106 = null;
        goto L23
    L30:
        return;
    L5:
        if (r101.length() == 0) goto L8;
        r102 = false;
        goto L10
    }

    @Override // com.bytedance.awemeopen.export.api.IAosController
    public final void openC2CardActivity(Context r100, C2CardConfig r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "pageConfig");
        a();
        int r102 = com.bytedance.awemeopen.infra.support.a.f198940a;
        com.bytedance.awemeopen.infra.support.a.a("open", "call_host_start_open", C104461.INSTANCE);
        AosC2RefactorService r103 = (AosC2RefactorService) BdpManager.getInst().getService(AosC2RefactorService.class);
        if (r103 == null) goto L6;
        r103.R1();
        return;
    }

    @Override // com.bytedance.awemeopen.export.api.IAosController
    public final void openFeedActivity(Context r110, FeedsHomePageConfig r111) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "pageConfig");
        a();
        int r100 = com.bytedance.awemeopen.infra.support.a.f198940a;
        com.bytedance.awemeopen.infra.support.a.a("open", "call_host_start_open", C104471.INSTANCE);
        String r101 = r111.getEnterAid();
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L65;
        String r103 = r111.getEnterAids();
        if (r103 != null) goto L13;
    L16:
        boolean r104 = true;
    L17:
        if (r104 == false) goto L65;
        if (h0.a(r111.getEnterOpenAid()) == false) goto L21;
    L22:
        ArrayList r105 = new ArrayList();
        String r106 = AoEnv.d();
        String r107 = r111.getEnterOpenAids();
        if (r107 == null) goto L46;
        List r108 = StringsKt.split$default(r107, new String[]{","}, false, 0, 6, null);
        if (r108 == null) goto L46;
        Iterator r109 = r108.iterator();
    L28:
        if (r109.hasNext() == false) goto L46;
        String r112 = p.a((String) r109.next());
        if (r112 == null) goto L32;
        List r113 = StringsKt.split$default(r112, new String[]{"#"}, false, 0, 6, null);
    L33:
        if (r113 == null) goto L35;
        String r114 = (String) CollectionsKt.getOrNull(r113, 1);
    L36:
        if (r113 == null) goto L28;
        String r115 = (String) CollectionsKt.getOrNull(r113, 0);
        if (r115 == null) goto L28;
        if (h0.a(r115) == false) goto L28;
        if (Intrinsics.areEqual(r114, "all") == true) goto L45;
        if (Intrinsics.areEqual(r114, r106) == false) goto L28;
    L45:
        r105.add(r115);
        goto L28
    L35:
        r114 = null;
        goto L36
    L32:
        r113 = null;
    L46:
        r111.setEnterAids(CollectionsKt.joinToString$default(r105, ",", null, null, 0, null, null, 62, null));
        int r116 = p.f197737a;
        String r117 = p.a(r111.getEnterOpenAid());
        if (r117 == null) goto L49;
        List r118 = StringsKt.split$default(r117, new String[]{"#"}, false, 0, 6, null);
    L50:
        if (r118 == null) goto L52;
        String r119 = (String) CollectionsKt.getOrNull(r118, 0);
    L53:
        if (r118 == null) goto L55;
        String r120 = (String) CollectionsKt.getOrNull(r118, 1);
    L57:
        if (h0.a(r119) == true) goto L59;
    L63:
        r119 = null;
    L64:
        r111.setEnterAid(r119);
        goto L65
    L59:
        if (Intrinsics.areEqual(r120, "all") == true) goto L64;
        if (Intrinsics.areEqual(r120, r106) == false) goto L63;
    L55:
        r120 = null;
        goto L57
    L52:
        r119 = null;
        goto L53
    L49:
        r118 = null;
        goto L50
    L21:
        if (h0.a(r111.getEnterOpenAids()) == false) goto L65;
    L13:
        if (r103.length() == 0) goto L16;
        r104 = false;
    L65:
        int r121 = AosHomeFeedActivity.f194785b;
        AosHomeFeedActivity.a.a(r110, r111);
        return;
    L5:
        if (r101.length() == 0) goto L8;
        r102 = false;
        goto L9
    }

    @Override // com.bytedance.awemeopen.export.api.IAosController
    public final void openPictureDetailActivity(Context r100, AosPictureDetailConfig r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "pageConfig");
        a();
        int r102 = com.bytedance.awemeopen.infra.support.a.f198940a;
        com.bytedance.awemeopen.infra.support.a.a("open", "call_host_start_open", C104481.INSTANCE);
        AosPhotoRefactorService r103 = (AosPhotoRefactorService) BdpManager.getInst().getService(AosPhotoRefactorService.class);
        if (r103 == null) goto L6;
        r103.q(r100, r101);
        return;
    }

    /* JADX WARN: Type inference failed for: r8v0, types: [com.bytedance.awemeopen.awemesdk.se.b] */
    @Override // com.bytedance.awemeopen.export.api.IAosController
    public final void openProfile(Context r110, final ProfilePageConfig r111) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "profileConfig");
        a();
        HostEventParameters r100 = r111.getHostEventParameters();
        if (r100 == null) goto L5;
        String r101 = r100.getEnterFrom();
    L7:
        if (r101 != null) goto L9;
        String r102 = "";
    L10:
        HostEventParameters r103 = r111.getHostEventParameters();
        if (r103 == null) goto L13;
        String r104 = r103.getEnterMethod();
    L14:
        if (r104 != null) goto L16;
        String r105 = "";
    L17:
        HostEventParameters r106 = r111.getHostEventParameters();
        if (r106 == null) goto L20;
        String r107 = r106.getImpr();
    L21:
        if (r107 != null) goto L23;
        String r108 = "";
    L24:
        String r109 = r111.getFromReqId();
        if (r109 != null) goto L27;
    L30:
        boolean r112 = true;
    L31:
        if (r112 == false) goto L33;
        r111.setFromReqId(r108);
    L33:
        d14.a r113 = b14.a.f16924a;
        t24.a r114 = (t24.a) b14.a.a(t24.a.class);
        ?? r115 = new b(r111);
        String r116 = r111.getActionType();
        if (r116 != null) goto L36;
        r116 = "click";
    L36:
        t24.a.C7679a.f(r114, r102, r105, "", r108, r115, r116, r111.getHostExtraParams().optBoolean("is_livehead"), r111.getHostExtraParams(), 33024);
        int r117 = vz3.a.f557701a;
        vz3.a.a(r110, r111, null);
        return;
    L27:
        if (r109.length() == 0) goto L30;
        r112 = false;
        goto L31
    L23:
        r108 = r107;
        goto L24
    L20:
        r107 = null;
        goto L21
    L16:
        r105 = r104;
        goto L17
    L13:
        r104 = null;
        goto L14
    L9:
        r102 = r101;
        goto L10
    L5:
        r101 = null;
        goto L7
    }

    @Override // com.bytedance.awemeopen.export.api.IAosController
    public final void openSeriesFeedActivity(Context r100, SeriesPageConfig r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "pageConfig");
        a();
        int r102 = com.bytedance.awemeopen.infra.support.a.f198940a;
        com.bytedance.awemeopen.infra.support.a.a("open", "call_host_start_open", C104491.INSTANCE);
        AosSeriesRefactorService r103 = (AosSeriesRefactorService) BdpManager.getInst().getService(AosSeriesRefactorService.class);
        if (r103 == null) goto L6;
        r103.I1();
        return;
    }

    @Override // com.bytedance.awemeopen.export.api.IAosController
    public final void openSeriesHomepageActivity(Context r100, SeriesHomePageConfig r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "pageConfig");
        a();
        int r102 = com.bytedance.awemeopen.infra.support.a.f198940a;
        com.bytedance.awemeopen.infra.support.a.a("open", "call_host_start_open", C104501.INSTANCE);
        AosSeriesRefactorService r103 = (AosSeriesRefactorService) BdpManager.getInst().getService(AosSeriesRefactorService.class);
        if (r103 == null) goto L6;
        r103.n();
        return;
    }

    @Override // com.bytedance.awemeopen.export.api.IAosController
    public final void reportAosEvent(String r100, Map<String, String> r101) {
        Intrinsics.checkNotNullParameter(r100, "event");
        Intrinsics.checkNotNullParameter(r101, "param");
        d14.a r102 = b14.a.f16924a;
        ((t24.a) b14.a.a(t24.a.class)).o(r100, r101);
    }

    @Override // com.bytedance.awemeopen.export.api.IAosController
    public final p44.b createFeedVideoItemView(FragmentActivity r100, ViewGroup r101, l54.a r102) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "viewGroup");
        Intrinsics.checkNotNullParameter(r102, "config");
        a();
        return new FeedVideoItemView(r100, r101, r102);
    }

    @Override // com.bytedance.awemeopen.export.api.IAosController
    public final d54.a createHomeFeedFragment(FragmentManager r100, String r101, FeedsHomePageConfig r102) {
        Intrinsics.checkNotNullParameter(r100, "fragmentManager");
        Intrinsics.checkNotNullParameter(r101, "tag");
        Intrinsics.checkNotNullParameter(r102, "pageConfig");
        a();
        int r103 = com.bytedance.awemeopen.apps.framework.utils.d.f197686a;
        Fragment r104 = r100.findFragmentByTag(r101);
        if ((r104 instanceof AosFeedsHomeFragment) == true) goto L9;
        Object r105 = AosFeedsHomeFragment.class.newInstance();
        if (r105 == null) goto L8;
        r104 = (AosFeedsHomeFragment) r105;
    L10:
        AosFeedsHomeFragment r106 = (AosFeedsHomeFragment) ((AosBaseFragment) r104);
        Bundle r107 = new Bundle();
        r107.putParcelable("arguments_AosFeedsHomeFragment", r102);
        r106.setArguments(r107);
        return r106;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.awemeopen.apps.framework.feed.home.AosFeedsHomeFragment");
    L9:
        AosBaseFragment r108 = (AosBaseFragment) r104;
        goto L10
    }

    @Override // com.bytedance.awemeopen.export.api.IAosController
    public final void notifyFollowStatusChange(String r100, String r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "currentUserOpenId");
        Intrinsics.checkNotNullParameter(r101, "authorOpenId");
        ((d) f198161b.getValue()).i3(r101, r102);
    }

    @Override // com.bytedance.awemeopen.export.api.IAosController
    public final v54.a getStoryFeedProvider(Activity r100, String r101, Long r102, v54.c r103) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "openId");
        Intrinsics.checkNotNullParameter(null, "config");
        a();
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "openId");
        Intrinsics.checkNotNullParameter(null, "config");
        new com.bytedance.awemeopen.apps.framework.story.repo.b(r100, r101, r102);
        new u04.a();
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "openId");
        Intrinsics.checkNotNullParameter(null, "config");
        View r104 = LayoutInflater.from(r100).inflate(R.layout.story_bottom_follow, null);
        AoImageView r105 = (AoImageView) r104.findViewById(R.id.story_follow_icon);
        TextView r106 = (TextView) r104.findViewById(R.id.story_follow_tv);
        throw null;
    }

    @Override // com.bytedance.awemeopen.export.api.IAosController
    public final void showFragment(FragmentManager r100, int r101, Fragment r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "fragmentManager");
        Intrinsics.checkNotNullParameter(r102, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r103, "tag");
        a();
        int r104 = com.bytedance.awemeopen.infra.support.a.f198940a;
        com.bytedance.awemeopen.infra.support.a.a("open", "call_host_start_open_fragment", C104511.INSTANCE);
        int r105 = com.bytedance.awemeopen.apps.framework.utils.d.f197686a;
        com.bytedance.awemeopen.apps.framework.utils.d.a.c(r100, r101, r102, r103);
    }
}
