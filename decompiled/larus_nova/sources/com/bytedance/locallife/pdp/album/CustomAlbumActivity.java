package com.bytedance.locallife.pdp.album;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.MutableLiveData;
import androidx.viewpager.widget.ViewPager;
import aq6.l;
import com.bytedance.ies.dmt.ui.widget.ButtonStyle;
import com.bytedance.ies.dmt.ui.widget.DmtStatusView;
import com.bytedance.ies.dmt.ui.widget.tablayout.DmtTabLayout;
import com.bytedance.locallife.biz.widget.SimpleLynxView;
import com.bytedance.locallife.common.utils.m;
import com.bytedance.locallife.cube.api.model.PublishEvent;
import com.bytedance.locallife.live.model.LiveLocalLifeRoomInfo;
import com.bytedance.locallife.model.album.PoiAlbumParams;
import com.bytedance.locallife.model.album.TabInfo;
import com.bytedance.locallife.pdp.album.model.CustomAlbumViewModel;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.gyf.barlibrary.ImmersionBar;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.search.vision.model.data.PhotoEnterModel;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\bB\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¨\u0006\t"}, d2 = {"Lcom/bytedance/locallife/pdp/album/CustomAlbumActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/bytedance/locallife/cube/api/model/PublishEvent;", "event", "", "onPublishEvent", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "locallife-pdp-impl_release"}, k = 1, mv = {1, 4, 3})
public final class CustomAlbumActivity extends AppCompatActivity {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ int f260929o = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f260930a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f260931b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f260932c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f260933d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public PoiAlbumParams f260934e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f260935f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public SimpleLynxView f260936g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public SimpleLynxView f260937h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public DmtStatusView f260938i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public DmtTabLayout f260939j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ViewPager f260940k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public CustomAlbumViewModel f260941l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Set<Integer> f260942m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final CustomAlbumActivity$onPageChangeListener$1 f260943n;

    public static final class a {
    }

    static {
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.f375446a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(CustomAlbumActivity.class.getName()));
    L5:
        super.onDestroy();
        com.bytedance.locallife.dito.event.a.b(this);
        ImmersionBar.with(this).destroy();
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.locallife.pdp.album.CustomAlbumActivity$onPageChangeListener$1] */
    public CustomAlbumActivity() {
        this.f260933d = 1;
        this.f260942m = new LinkedHashSet();
        this.f260943n = new CustomAlbumActivity$onPageChangeListener$1(this);
    }

    /* JADX INFO: Removed unreachable split cross block B:53:0x0106 */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r100 = FLogger.f375446a;
        r100.i("ActivityLancet", "finish ".concat(CustomAlbumActivity.class.getName()));
        long r101 = SystemClock.uptimeMillis();
        Map<Activity, Long> r102 = ActivityLancet.LAST_FINISH_HANDLED_MS;
        monitor-enter(r102);
        Long r103 = r102.get(this);     // Catch: Throwable -> L45
        if (r103 != null) goto L10;
    L13:
        r102.put(this, Long.valueOf(r101));     // Catch: Throwable -> L45
        monitor-exit(r102);     // Catch: Throwable -> L45
    L42:
        th = move-exception;
        FLogger.f375446a.e("ActivityLancet", "handle onBackPressed strategy failed", th);
    L50:
        return;
    L16:
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L19;
        r100.i("ActivityLancet", "quit !resume, current state = " + getLifecycle().getCurrentState());     // Catch: Throwable -> L42
        goto L50
    L19:
        if (isFinishing() == true) goto L22;
        r100.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L42
        goto L50
    L22:
        if (ActivityStartBehavior.isInternalActivityConsumed(this) == true) goto L25;
        r100.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L42
        goto L50
    L25:
        if (ActivityLancet.isOnlyActivityInTask(this) == true) goto L28;
        r100.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L42
        goto L50
    L28:
        if (ActivityLancet.isExcludedActivity(this) == false) goto L31;
        r100.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L42
        goto L50
    L31:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L33;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L42
        goto L50
    L33:
        Intent r104 = getPackageManager().getLaunchIntentForPackage(getPackageName());     // Catch: Throwable -> L42
        if (r104 == null) goto L50;
        r104.addFlags(268435456);     // Catch: Throwable -> L42
        r104.addFlags(2097152);     // Catch: Throwable -> L42
        r100.i("ActivityLancet", "start launcher intent after backPressed, activity=" + this);     // Catch: Throwable -> L42
        startActivity(r104);     // Catch: Throwable -> L39
        overridePendingTransition(R.anim.fade_in, R.anim.slide_out_right);     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        FLogger.f375446a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L42
        goto L50
    L10:
        if ((r101 - r103.longValue()) >= 800) goto L13;
        monitor-exit(r102);     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        throw th;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onResume() {
        super.onResume();
        ImmersionBar.with(this).statusBarColor(com.larus.nova.R.color.Transparent).statusBarDarkFont(true).init();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onStop() {
        super.onStop();
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L14;
        View r100 = getWindow().getDecorView();     // Catch: Throwable -> L11
        if (com.larus.home.impl.utils.c.f346345e == false) goto L9;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");     // Catch: Throwable -> L11
        Thread r101 = ThreadMethodProxy.currentThread();     // Catch: Throwable -> L11
        if (r101 == com.larus.home.impl.utils.c.f346341a) goto L9;
        com.larus.home.impl.utils.c.a(r101, "getDecorView");     // Catch: Throwable -> L11
    L9:
        r100.getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L11
        return;
    L15:
        return;
    }

    public final void y1() {
        MutableLiveData<CustomAlbumViewModel.RequestStatus> r100 = null;
        if (aq6.g.a(this) == false) goto L13;
        CustomAlbumViewModel r101 = this.f260941l;
        if (r101 == null) goto L7;
        r100 = r101.getFirstRequestStatus();
    L7:
        if (r100 == null) goto L10;
        r100.setValue(CustomAlbumViewModel.RequestStatus.LOADING);
    L10:
        CustomAlbumViewModel r102 = this.f260941l;
        if (r102 == null) goto L20;
        r102.requestTabData();
        return;
    L20:
        return;
    L13:
        CustomAlbumViewModel r103 = this.f260941l;
        if (r103 == null) goto L16;
        r100 = r103.getFirstRequestStatus();
    L16:
        if (r100 == null) goto L22;
        r100.setValue(CustomAlbumViewModel.RequestStatus.FAIL);
        return;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle r100) {
        if (z2.f365865a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (v19.f.f(this) == false) goto L10;
        v19.f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        super.onCreate(r100);
        setContentView(com.larus.nova.R.layout.saas_activity_custom_album);
        this.f260935f = findViewById(com.larus.nova.R.id.custom_album_status_bar);
        this.f260938i = (DmtStatusView) findViewById(com.larus.nova.R.id.custom_album_status_view);
        this.f260936g = (SimpleLynxView) findViewById(com.larus.nova.R.id.custom_album_top_bar_lynx);
        this.f260937h = (SimpleLynxView) findViewById(com.larus.nova.R.id.custom_album_bottom_bar_lynx);
        this.f260939j = (DmtTabLayout) findViewById(com.larus.nova.R.id.custom_album_tab_layout);
        this.f260940k = (ViewPager) findViewById(com.larus.nova.R.id.custom_album_view_pager);
        Intent r101 = getIntent();
        PoiAlbumParams r102 = null;
        if (r101 == null) goto L13;
        String r103 = r101.getStringExtra(PhotoEnterModel.SOURCE_BTM_TOKEN);
    L14:
        Intrinsics.checkNotNullParameter(this, "<this>");
        Intrinsics.checkNotNullParameter("a2552.b149253", "btmAb");
        com.bytedance.locallife.biz.btm.c.i(this, "a2552.b149253", r103, null);
        this.f260941l = (CustomAlbumViewModel) m.a(this, CustomAlbumViewModel.class);
        Serializable r104 = getIntent().getSerializableExtra("custom_album_params");
        if ((r104 instanceof PoiAlbumParams) == false) goto L17;
        r102 = (PoiAlbumParams) r104;
    L17:
        this.f260934e = r102;
        CustomAlbumViewModel r105 = this.f260941l;
        String r106 = "";
        if (r105 == null) goto L25;
        if (r102 == null) goto L23;
        String r107 = r102.getPoiName();
        if (r107 == null) goto L23;
    L24:
        r105.setPoiName(r107);
    L23:
        r107 = "";
    L25:
        CustomAlbumViewModel r108 = this.f260941l;
        if (r108 == null) goto L34;
        PoiAlbumParams r109 = this.f260934e;
        if (r109 == null) goto L32;
        String r110 = r109.getPoiId();
        if (r110 == null) goto L32;
    L33:
        r108.setPoiId(r110);
    L32:
        r110 = "";
    L34:
        CustomAlbumViewModel r111 = this.f260941l;
        if (r111 == null) goto L43;
        PoiAlbumParams r112 = this.f260934e;
        if (r112 == null) goto L41;
        String r113 = r112.getPoiBackendType();
        if (r113 == null) goto L41;
    L42:
        r111.setPoiBackendType(r113);
    L41:
        r113 = "";
    L43:
        CustomAlbumViewModel r114 = this.f260941l;
        if (r114 == null) goto L53;
        PoiAlbumParams r115 = this.f260934e;
        if (r115 == null) goto L52;
        String r116 = r115.getProductId();
        if (r116 == null) goto L52;
        r106 = r116;
    L52:
        r114.setProductId(r106);
    L53:
        CustomAlbumViewModel r117 = this.f260941l;
        if (r117 == null) goto L57;
        r117.setAlbumParams(this.f260934e);
    L57:
        DmtStatusView r118 = this.f260938i;
        if (r118 == null) goto L68;
        com.bytedance.ies.dmt.ui.widget.b r119 = new com.bytedance.ies.dmt.ui.widget.b();
        Context r120 = getApplicationContext();
        r119.f248443a = com.larus.nova.R.drawable.img_s_s_network_error;
        r119.f248444b = r120.getResources().getDrawable(com.larus.nova.R.drawable.img_s_s_network_error);
        r119.f248451i = true;
        String r121 = r120.getString(com.larus.nova.R.string.uikit_network_error);
        r119.f248445c = r121;
        if (TextUtils.isEmpty(r121) == true) goto L67;
        r119.f248452j = true;
        r119.f248446d = r120.getString(com.larus.nova.R.string.uikit_check_and_retry);
        r119.f248453k = true;
        ButtonStyle r122 = ButtonStyle.BORDER;
        e r123 = new e(this);
        r119.f248447e = r122;
        r119.f248448f = r120.getString(com.larus.nova.R.string.uikit_retry);
        r119.f248449g = r123;
        r119.f248454l = true;
        com.bytedance.ies.dmt.ui.widget.b r124 = new com.bytedance.ies.dmt.ui.widget.b();
        Context r125 = getApplicationContext();
        String r126 = r125.getString(com.larus.nova.R.string.trade_goods_empty);
        r124.f248445c = r126;
        if (TextUtils.isEmpty(r126) == true) goto L65;
        r124.f248452j = true;
        r124.f248446d = r125.getString(com.larus.nova.R.string.trade_goods_later);
        r124.f248453k = true;
        d r127 = new d(this);
        r124.f248447e = r122;
        r124.f248448f = r125.getString(com.larus.nova.R.string.uikit_retry);
        r124.f248449g = r127;
        r124.f248454l = true;
        DmtStatusView.a r128 = DmtStatusView.a.a(this);
        r128.e(r119);
        r128.c(r124);
        r118.setBuilder(r128);
        r118.setForceLightTheme(Boolean.TRUE);
        goto L68
    L65:
        throw new IllegalArgumentException("title should not be empty string!");
    L67:
        throw new IllegalArgumentException("title should not be empty string!");
    L68:
        CustomAlbumViewModel r129 = this.f260941l;
        if (r129 == null) goto L73;
        MutableLiveData<CustomAlbumViewModel.RequestStatus> r130 = r129.getFirstRequestStatus();
        if (r130 == null) goto L73;
        r130.observe(this, new f(this));
    L73:
        int r131 = l.f15909a;
        l.b(this.f260935f);
        CustomAlbumViewModel r132 = this.f260941l;
        if (r132 == null) goto L78;
        MutableLiveData<List<TabInfo>> r133 = r132.getTabInfo();
        if (r133 == null) goto L78;
        r133.observe(this, new com.bytedance.locallife.pdp.album.a(this));
    L78:
        CustomAlbumViewModel r134 = this.f260941l;
        if (r134 == null) goto L83;
        MutableLiveData<tv6.b> r135 = r134.getTopLynxInfo();
        if (r135 == null) goto L83;
        r135.observe(this, new b(this));
    L83:
        CustomAlbumViewModel r136 = this.f260941l;
        if (r136 == null) goto L88;
        MutableLiveData<tv6.b> r137 = r136.getBottomLynxInfo();
        if (r137 == null) goto L88;
        r137.observe(this, new c(this));
    L88:
        y1();
        com.bytedance.locallife.dito.event.a.a(this);
        return;
    L13:
        r103 = null;
        goto L14
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onPublishEvent(PublishEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        Map<String, Object> r101 = r100.params();
        if (r101 == null) goto L5;
        String r102 = com.bytedance.locallife.common.utils.a.a(r101, LiveLocalLifeRoomInfo.TRACE_SESSION_ID);
    L6:
        PoiAlbumParams r103 = this.f260934e;
        if (r103 == null) goto L9;
        String r104 = r103.getTraceSessionId();
    L11:
        if (TextUtils.equals(r102, r104) == true) goto L13;
        return;
    L13:
        String r105 = r100.name();
        if (Intrinsics.areEqual(r105, "close_custom_album_page") == false) goto L17;
        finish();
        return;
    L17:
        if (Intrinsics.areEqual(r105, "select_poi_changed") == false) goto L46;
        this.f260931b = true;
        Map<String, Object> r106 = r100.params();
        if (r106 == null) goto L21;
        String r107 = com.bytedance.locallife.common.utils.a.a(r106, "poi_id");
    L22:
        Map<String, Object> r108 = r100.params();
        if (r108 == null) goto L25;
        String r109 = com.bytedance.locallife.common.utils.a.a(r108, "poi_name");
    L27:
        if (TextUtils.isEmpty(r107) == true) goto L47;
        CustomAlbumViewModel r110 = this.f260941l;
        if (r110 == null) goto L31;
        String r111 = r110.getPoiId();
    L33:
        if (TextUtils.equals(r107, r111) == false) goto L35;
        return;
    L35:
        if (this.f260932c == true) goto L49;
        this.f260932c = true;
        CustomAlbumViewModel r112 = this.f260941l;
        if (r112 == null) goto L39;
        Intrinsics.checkNotNull(r107);
        r112.clearAlbumData(r107, r109);
    L39:
        ViewPager r113 = this.f260940k;
        if (r113 == null) goto L43;
        r113.setAdapter(null);
    L43:
        y1();
        return;
    L49:
        return;
    L31:
        r111 = null;
        goto L33
    L47:
        return;
    L25:
        r109 = null;
        goto L27
    L21:
        r107 = null;
        goto L22
    L46:
        return;
    L9:
        r104 = null;
        goto L11
    L5:
        r102 = null;
        goto L6
    }
}
