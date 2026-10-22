package com.bytedance.locallife.photo.photopage.view;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.dmt.ui.widget.DmtTextView;
import com.bytedance.ies.dmt.ui.widget.tablayout.DmtTabLayout;
import com.bytedance.locallife.biz.common.utils.HostServiceUtilsKt;
import com.bytedance.locallife.cube.view.CubeContainerView;
import com.bytedance.locallife.model.album.PhotoData;
import com.bytedance.locallife.model.album.PoiAlbumParams;
import com.bytedance.locallife.photo.album.model.AlbumPageStatus;
import com.bytedance.locallife.photo.album.model.AlbumViewModel;
import com.bytedance.locallife.photo.photopage.fragment.PoiAlbumContainerFragment;
import com.bytedance.locallife.photo.view.RoundedRelativeLayout;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.gyf.barlibrary.ImmersionBar;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.android.ugc.aweme.poi.model.AlbumTabListModel;
import com.ss.android.ugc.aweme.poi.model.PhotoPageTabStruct;
import com.ss.android.ugc.aweme.poi.model.PoiBundle;
import com.ss.android.ugc.aweme.poi.model.VIDEO_TAB_STYLE;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.ttm.player.MediaPlayer;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/locallife/photo/photopage/view/PoiAlbumPageActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "locallife-photo-impl_release"}, k = 1, mv = {1, 4, 3})
public final class PoiAlbumPageActivity extends AppCompatActivity {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final /* synthetic */ int f262251u = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.bytedance.locallife.photo.photodraweeview.i f262252a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f262253b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public AlbumViewModel f262254c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final qn6.a f262255d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public xl4.a f262256e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public PoiAlbumContainerFragment f262257f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public LinearLayout f262258g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public AppCompatImageView f262259h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public AppCompatImageView f262260i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public DmtTextView f262261j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public RoundedRelativeLayout f262262k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public AppCompatImageView f262263l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public AppCompatImageView f262264m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public View f262265n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public DmtTabLayout f262266o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public TextView f262267p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public TextView f262268q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public TextView f262269r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public CubeContainerView f262270s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Lazy f262271t;

    public static final class a {
    }

    static {
    }

    public final List<AlbumTabListModel> B1() {
        AlbumViewModel r100 = this.f262254c;
        if (r100 == null) goto L9;
        PoiAlbumParams r101 = r100.getAlbumParams();
        if (r101 == null) goto L9;
        List<AlbumTabListModel> r102 = r101.getPhotoPageTabList();
        if (r102 == null) goto L9;
        return r102;
    L9:
        return CollectionsKt.mutableListOf(new AlbumTabListModel[]{new AlbumTabListModel(null, null, null, null, null, null, 63, null)});
    }

    public final void C1() {
        AlbumViewModel r100 = this.f262254c;
        boolean r101 = true;
        if (r100 == null) goto L9;
        PoiAlbumParams r102 = r100.getAlbumParams();
        if (r102 == null) goto L9;
        if (r102.getUseNewStyle() != true) goto L9;
        boolean r103 = true;
    L10:
        String r104 = null;
        if (r103 == false) goto L34;
        AlbumViewModel r105 = this.f262254c;
        if (r105 == null) goto L15;
        String r106 = r105.getCurrentSelectTabId();
    L17:
        if (Intrinsics.areEqual(r106, "video") == true) goto L34;
        LinearLayout r107 = this.f262258g;
        if (r107 == null) goto L21;
        r107.setVisibility(0);
    L21:
        AppCompatImageView r108 = this.f262260i;
        if (r108 == null) goto L24;
        r108.setVisibility(0);
    L24:
        LinearLayout r109 = this.f262258g;
        if (r109 == null) goto L27;
        r109.setVisibility(8);
    L27:
        AppCompatImageView r110 = this.f262259h;
        if (r110 == null) goto L30;
        r110.setVisibility(8);
    L30:
        AppCompatImageView r111 = this.f262260i;
        if (r111 == null) goto L86;
        r111.setVisibility(8);
    L86:
        AlbumViewModel r112 = this.f262254c;
        if (r112 == null) goto L93;
        PoiAlbumParams r113 = r112.getAlbumParams();
        if (r113 == null) goto L93;
        if (r113.getUseNewStyle() != true) goto L93;
    L94:
        if (r101 == true) goto L103;
        AlbumViewModel r114 = this.f262254c;
        if (r114 == null) goto L99;
        r104 = r114.getCurrentSelectTabId();
    L99:
        if (Intrinsics.areEqual(r104, "photo") == true) goto L103;
        AppCompatImageView r115 = this.f262260i;
        if (r115 == null) goto L103;
        r115.setVisibility(8);
    L103:
        DmtTextView r116 = this.f262261j;
        if (r116 == null) goto L106;
        r116.setVisibility(8);
    L106:
        AppCompatImageView r117 = this.f262260i;
        if (r117 == null) goto L109;
        r117.setVisibility(8);
    L109:
        LinearLayout r118 = this.f262258g;
        if (r118 == null) goto L113;
        r118.setVisibility(8);
        return;
    L113:
        return;
    L93:
        r101 = false;
        goto L94
    L15:
        r106 = null;
    L34:
        if (B1().size() < 2) goto L44;
        LinearLayout r119 = this.f262258g;
        if (r119 == null) goto L38;
        r119.setVisibility(0);
    L38:
        AppCompatImageView r120 = this.f262259h;
        if (r120 == null) goto L41;
        r120.setVisibility(8);
    L41:
        AppCompatImageView r121 = this.f262260i;
        if (r121 == null) goto L86;
        r121.setVisibility(0);
        goto L86
    L44:
        AlbumViewModel r122 = this.f262254c;
        if (r122 == null) goto L51;
        PoiAlbumParams r123 = r122.getAlbumParams();
        if (r123 == null) goto L51;
        if (r123.getShowShareIcon() != true) goto L51;
        boolean r124 = true;
    L52:
        if (r124 == false) goto L77;
        LinearLayout r125 = this.f262258g;
        if (r125 == null) goto L56;
        r125.setVisibility(0);
    L56:
        AlbumViewModel r126 = this.f262254c;
        if (r126 == null) goto L63;
        PoiAlbumParams r127 = r126.getAlbumParams();
        if (r127 == null) goto L63;
        if (r127.getShowMoreIconOnly() != true) goto L63;
        boolean r128 = true;
    L64:
        if (r128 == false) goto L71;
        AppCompatImageView r129 = this.f262259h;
        if (r129 == null) goto L68;
        r129.setVisibility(8);
    L68:
        AppCompatImageView r130 = this.f262260i;
        if (r130 == null) goto L86;
        r130.setVisibility(0);
        goto L86
    L71:
        AppCompatImageView r131 = this.f262259h;
        if (r131 == null) goto L74;
        r131.setVisibility(0);
    L74:
        AppCompatImageView r132 = this.f262260i;
        if (r132 == null) goto L86;
        r132.setVisibility(0);
    L63:
        r128 = false;
        goto L64
    L77:
        LinearLayout r133 = this.f262258g;
        if (r133 == null) goto L80;
        r133.setVisibility(0);
    L80:
        AppCompatImageView r134 = this.f262259h;
        if (r134 == null) goto L83;
        r134.setVisibility(8);
    L83:
        AppCompatImageView r135 = this.f262260i;
        if (r135 == null) goto L86;
        r135.setVisibility(0);
    L51:
        r124 = false;
    L9:
        r103 = false;
        goto L10
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.f375446a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(PoiAlbumPageActivity.class.getName()));
    L5:
        this.f262255d.i();
        ImmersionBar.with(this).destroy();
        AlbumViewModel r100 = this.f262254c;
        if (r100 == null) goto L8;
        r100.clearAlbumData();
    L8:
        super.onDestroy();
    }

    public PoiAlbumPageActivity() {
        this.f262255d = new qn6.a();
        this.f262271t = LazyKt.lazy(new PoiAlbumPageActivity$toastTimer$2(this));
    }

    /* JADX INFO: Removed unreachable split cross block B:53:0x0106 */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r100 = FLogger.f375446a;
        r100.i("ActivityLancet", "finish ".concat(PoiAlbumPageActivity.class.getName()));
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
        AlbumViewModel r100 = this.f262254c;
        if (r100 == null) goto L6;
        r100.checkHasDeletePhoto();
        return;
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

    public static final void y1(PoiAlbumPageActivity r100) {
        AlbumViewModel r101 = r100.f262254c;
        if (r101 == null) goto L5;
        MutableLiveData<AlbumPageStatus> r102 = r101.getAlbumPageStatus();
    L6:
        if (r102 == null) goto L9;
        r102.setValue(AlbumPageStatus.ERROR_REPORT);
    L9:
        int r103 = com.bytedance.locallife.photo.photopage.a.f262144a;
        AlbumViewModel r104 = r100.f262254c;
        if (r104 == null) goto L14;
        PoiAlbumParams r105 = r104.getAlbumParams();
        if (r105 == null) goto L14;
        PoiBundle r106 = r105.getPoiBundle();
    L15:
        Intrinsics.checkNotNullParameter("album_page", "enterFrom");
        if (r106 != null) goto L19;
    L23:
        int r107 = com.bytedance.locallife.poi.utils.b.f264219a;
        if ((!HostServiceUtilsKt.i0().g("poi_repo", "keva_key_poi_album_error_toast", false)) == false) goto L30;
        RoundedRelativeLayout r108 = r100.f262262k;
        if (r108 == null) goto L28;
        r108.setVisibility(0);
    L28:
        ((com.bytedance.locallife.common.utils.h) r100.f262271t.getValue()).c();
        HostServiceUtilsKt.i0().d("poi_repo", "keva_key_poi_album_error_toast", true);
        return;
    L30:
        return;
    L19:
        if (yx6.a.a(r106.cityCode) == false) goto L21;
        String r109 = "1";
    L22:
        int r110 = com.bytedance.locallife.biz.mob.a.f256703c;
        mq6.c r111 = new mq6.c();
        String r112 = r106.backendType;
        mq6.a r113 = mq6.c.a.f514894a;
        r111.g("poi_backend_type", r112);
        r111.g("poi_id", r106.poiId);
        r111.g("poi_device_samecity", r109);
        r111.g("poi_enter_id", r106.enterId);
        r111.g("enter_from", "album_page");
        r111.g("previous_page", null);
        com.bytedance.locallife.biz.mob.a.C3646a.c("click_image_error_icon", r111.f514893a);
        goto L23
    L21:
        r109 = "0";
    L14:
        r106 = null;
        goto L15
    L5:
        r102 = null;
        goto L6
    }

    public static final void z1(PoiAlbumPageActivity r100) {
        AlbumViewModel r101 = r100.f262254c;
        if (r101 == null) goto L15;
        List<PhotoData> r102 = r101.getErrorPicList();
        if (r102 != null) goto L7;
        return;
    L7:
        if (r102.size() <= 0) goto L11;
        TextView r103 = r100.f262268q;
        if (r103 == null) goto L17;
        r103.setTextColor(ResourcesCompat.getColor(r100.getResources(), com.larus.nova.R.color.POITextPrimary, null));
        return;
    L17:
        return;
    L11:
        TextView r104 = r100.f262268q;
        if (r104 == null) goto L19;
        r104.setTextColor(ResourcesCompat.getColor(r100.getResources(), com.larus.nova.R.color.POITextQuaternary, null));
        return;
    L19:
        return;
    }

    public final Map A1(String r100) {
        LinkedHashMap r101 = new LinkedHashMap();
        Comparable r102 = "";
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        r101.put(EventConstant.Key.RAW_DATA, r100);
        r101.put("enter_from", "album_page");
        AlbumViewModel r103 = this.f262254c;
        String r104 = null;
        if (r103 == null) goto L12;
        PoiAlbumParams r105 = r103.getAlbumParams();
        if (r105 == null) goto L12;
        PoiBundle r106 = r105.getPoiBundle();
        if (r106 == null) goto L12;
        String r107 = r106.poiId;
    L13:
        if (r107 != null) goto L15;
        r107 = "";
    L15:
        r101.put("poi_id", r107);
        AlbumViewModel r108 = this.f262254c;
        if (r108 == null) goto L22;
        PoiAlbumParams r109 = r108.getAlbumParams();
        if (r109 == null) goto L22;
        PoiBundle r110 = r109.getPoiBundle();
        if (r110 == null) goto L22;
        String r111 = r110.backendType;
    L23:
        if (r111 != null) goto L25;
        r111 = "";
    L25:
        r101.put("poi_backend_type", r111);
        AlbumViewModel r112 = this.f262254c;
        if (r112 == null) goto L32;
        PoiAlbumParams r113 = r112.getAlbumParams();
        if (r113 == null) goto L32;
        PoiBundle r114 = r113.getPoiBundle();
        if (r114 == null) goto L32;
        String r115 = r114.enterId;
    L33:
        if (r115 != null) goto L35;
        r115 = "";
    L35:
        r101.put("poi_enter_id", r115);
        AlbumViewModel r116 = this.f262254c;
        if (r116 == null) goto L42;
        PoiAlbumParams r117 = r116.getAlbumParams();
        if (r117 == null) goto L42;
        PoiBundle r118 = r117.getPoiBundle();
        if (r118 == null) goto L42;
        String r119 = r118.from;
    L43:
        if (r119 != null) goto L45;
        r119 = "";
    L45:
        r101.put("poi_enter_page", r119);
        AlbumViewModel r120 = this.f262254c;
        if (r120 == null) goto L52;
        PoiAlbumParams r121 = r120.getAlbumParams();
        if (r121 == null) goto L52;
        PoiBundle r122 = r121.getPoiBundle();
        if (r122 == null) goto L52;
        r104 = r122.enterMethod;
    L52:
        if (r104 != null) goto L54;
        r104 = "";
    L54:
        r101.put(BdpAppEventConstant.PARAMS_POI_ENTER_METHOD, r104);
        AlbumViewModel r123 = this.f262254c;
        if (r123 == null) goto L59;
        PoiAlbumParams r124 = r123.getAlbumParams();
        if (r124 == null) goto L59;
        r102 = Integer.valueOf(r124.getPoiPicMode());
    L59:
        r101.put("poi_pic_mode", r102);
        int r125 = com.bytedance.locallife.photo.photopage.a.f262144a;
        r101.put(com.bytedance.android.ec.core.event.a.KEY_TAB_NAME, com.bytedance.locallife.photo.photopage.a.b(this.f262254c));
        return r101;
    L42:
        r119 = null;
    L32:
        r115 = null;
    L22:
        r111 = null;
    L12:
        r107 = null;
        goto L13
    }

    public final void D1(List<AlbumTabListModel> r100) {
        DmtTabLayout r101 = this.f262266o;
        if (r101 == null) goto L17;
        if (r100.size() <= 1) goto L7;
        int r102 = 0;
    L8:
        r101.setVisibility(r102);
        int r103 = com.bytedance.locallife.poi.newdetail.h.f263265d;
        if (r103 > 0) goto L12;
        r103 = UIUtils.getScreenWidth(r101.getContext());
    L12:
        float r104 = MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_RENDER_MS_GAPS;
        Resources r105 = Resources.getSystem();
        if (r103 < MathKt.roundToInt(TypedValue.applyDimension(1, r104, WindowDisplayMetricsOverride.apply(r105, r105.getDisplayMetrics())))) goto L15;
        float r106 = 12;
        Resources r107 = Resources.getSystem();
        r101.setTabPaddingStart(MathKt.roundToInt(TypedValue.applyDimension(1, r106, WindowDisplayMetricsOverride.apply(r107, r107.getDisplayMetrics()))));
        Resources r108 = Resources.getSystem();
        r101.setTabPaddingEnd(MathKt.roundToInt(TypedValue.applyDimension(1, r106, WindowDisplayMetricsOverride.apply(r108, r108.getDisplayMetrics()))));
        goto L17
    L15:
        float r109 = 10;
        Resources r110 = Resources.getSystem();
        r101.setTabPaddingStart(MathKt.roundToInt(TypedValue.applyDimension(1, r109, WindowDisplayMetricsOverride.apply(r110, r110.getDisplayMetrics()))));
        Resources r111 = Resources.getSystem();
        r101.setTabPaddingEnd(MathKt.roundToInt(TypedValue.applyDimension(1, r109, WindowDisplayMetricsOverride.apply(r111, r111.getDisplayMetrics()))));
        goto L17
    L7:
        r102 = 8;
    L17:
        if (r100.size() <= 1) goto L21;
        TextView r112 = this.f262267p;
        if (r112 == null) goto L26;
        r112.setVisibility(8);
    L26:
        if ((!r100.isEmpty()) == false) goto L34;
        View r113 = this.f262265n;
        if (r113 == null) goto L30;
        r113.setBackgroundColor(0);
    L30:
        DmtTabLayout r114 = this.f262266o;
        if (r114 == null) goto L35;
        r114.setBackgroundColor(0);
        return;
    L35:
        return;
    L34:
        return;
    L21:
        TextView r115 = this.f262267p;
        if (r115 == null) goto L26;
        r115.setText(((AlbumTabListModel) ListProtector.get(r100, 0)).getTabName());
        goto L26
    }

    public final void F1(String r100) {
        TextView r101 = this.f262267p;
        if (r101 == null) goto L5;
        r101.setVisibility(0);
    L5:
        TextView r102 = this.f262267p;
        if (r102 == null) goto L13;
        if (r100 != null) goto L11;
        r100 = getString(com.larus.nova.R.string.poi_album_page);
    L11:
        r102.setText(r100);
    L13:
        if (this.f262257f != null) goto L20;
        FragmentTransaction r103 = getSupportFragmentManager().beginTransaction();
        int r104 = PoiAlbumContainerFragment.f262162o;
        PoiAlbumContainerFragment r105 = new PoiAlbumContainerFragment();
        r105.setArguments(new Bundle());
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r103, r105, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, null, com.larus.nova.R.id.album_fragment_container_view) == true) goto L18;
        r103.add(com.larus.nova.R.id.album_fragment_container_view, r105);
    L18:
        r103.commit();
        this.f262257f = r105;
        return;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        this.f262255d.c(getWindow(), r100);
        return super.dispatchTouchEvent(r100);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration r100) {
        Intrinsics.checkNotNullParameter(r100, "newConfig");
        super.onConfigurationChanged(r100);
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type android.app.Activity");     // Catch: Throwable -> L17
        if (dc9.d.a() == true) goto L19;
        int r101 = getRequestedOrientation();     // Catch: Throwable -> L17
        if (r100 == null) goto L8;
        Integer r102 = Integer.valueOf(r100.orientation);     // Catch: Throwable -> L17
    L9:
        if (r102 != null) goto L12;
    L14:
        if (r101 != 3) goto L19;
        setRequestedOrientation(1);     // Catch: Throwable -> L17
        FLogger.f375446a.i("PadLancet", "onConfigurationChanged, phone reset page:PoiAlbumPageActivity portrait");     // Catch: Throwable -> L17
        goto L19
    L12:
        if (r102.intValue() == r101) goto L19;
    L8:
        r102 = null;
    L19:
        int r103 = r100.orientation;
        if (r103 == 2) goto L22;
    L26:
        if (r103 == 1) goto L28;
        return;
    L28:
        if (this.f262253b == false) goto L38;
        this.f262253b = false;
        com.bytedance.locallife.photo.photodraweeview.i r104 = this.f262252a;
        if (r104 == null) goto L39;
        r104.b();
        return;
    L39:
        return;
    L38:
        return;
    L22:
        if (this.f262253b == true) goto L26;
        this.f262253b = true;
        com.bytedance.locallife.photo.photodraweeview.i r105 = this.f262252a;
        if (r105 == null) goto L35;
        r105.a();
        return;
    L35:
        return;
    L17:
        th = move-exception;
        FLogger.f375446a.e("PadLancet", "hook onConfigurationChanged error:" + th, th);
        goto L19
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle r310) {
        if (z2.f365865a.enableGlobalActivityTheme() == false) goto L7;
        v19.f.a(getTheme());     // Catch: Throwable -> L10
    L7:
        if (v19.f.f(this) == false) goto L11;
        v19.f.c(getTheme());     // Catch: Throwable -> L10
    L11:
        super.onCreate(r310);
        setContentView(com.larus.nova.R.layout.poi_activity_poi_photes_page);
        CubeContainerView r100 = (CubeContainerView) findViewById(com.larus.nova.R.id.bottom_lynx_container_resident);
        this.f262270s = r100;
        if (r100 == null) goto L15;
        r100.setVisibility(8);
    L15:
        this.f262258g = (LinearLayout) findViewById(com.larus.nova.R.id.share_and_more_container);
        this.f262259h = (AppCompatImageView) findViewById(com.larus.nova.R.id.album_share);
        this.f262260i = (AppCompatImageView) findViewById(com.larus.nova.R.id.album_more);
        this.f262261j = (DmtTextView) findViewById(com.larus.nova.R.id.album_error_report);
        this.f262262k = (RoundedRelativeLayout) findViewById(com.larus.nova.R.id.error_toast_view);
        this.f262263l = (AppCompatImageView) findViewById(com.larus.nova.R.id.toast_cancel_btn);
        this.f262264m = (AppCompatImageView) findViewById(com.larus.nova.R.id.album_toolbar_back);
        this.f262265n = findViewById(com.larus.nova.R.id.album_page_status_bar);
        this.f262266o = (DmtTabLayout) findViewById(com.larus.nova.R.id.album_page_title_tab_layout);
        this.f262267p = (TextView) findViewById(com.larus.nova.R.id.album_page_title);
        this.f262268q = (TextView) findViewById(com.larus.nova.R.id.next_step);
        this.f262269r = (TextView) findViewById(com.larus.nova.R.id.cancel_btn);
        this.f262254c = (AlbumViewModel) com.bytedance.locallife.common.utils.m.a(this, AlbumViewModel.class);
        Serializable r101 = getIntent().getSerializableExtra("poi_album_params");
        if ((r101 instanceof PoiAlbumParams) == false) goto L18;
        PoiAlbumParams r102 = (PoiAlbumParams) r101;
    L19:
        AlbumViewModel r103 = this.f262254c;
        if (r103 == null) goto L22;
        MutableLiveData<AlbumPageStatus> r104 = r103.getAlbumPageStatus();
    L23:
        if (r104 == null) goto L26;
        r104.setValue(AlbumPageStatus.LOOK);
    L26:
        boolean r105 = false;
        String r110 = "";
        if (r102 != null) goto L45;
        AlbumViewModel r106 = this.f262254c;
        if (r106 == null) goto L49;
        PoiAlbumParams r107 = r106.getAlbumParams();
        if (r107 == null) goto L49;
        String r111 = getIntent().getStringExtra("poi_id");
        if (r111 != null) goto L35;
        r111 = "";
    L35:
        r107.setPoiId(r111);
        String r112 = getIntent().getStringExtra("enter_from");
        if (r112 != null) goto L38;
        r112 = "";
    L38:
        r107.setEnterFrom(r112);
        String r113 = getIntent().getStringExtra("enter_method");
        if (r113 != null) goto L41;
        r113 = "";
    L41:
        r107.setEnterMethod(r113);
        String r114 = getIntent().getStringExtra("poi_backend_type");
        if (r114 != null) goto L44;
        r114 = "";
    L44:
        r107.setPoiBackendType(r114);
        r107.setPoiPicMode(getIntent().getIntExtra("poi_pic_mode", 0));
    L49:
        AlbumViewModel r108 = this.f262254c;
        if (r108 == null) goto L54;
        PoiAlbumParams r109 = r108.getAlbumParams();
        if (r109 == null) goto L54;
        List<AlbumTabListModel> r115 = r109.getPhotoPageTabList();
    L55:
        if (r115 != null) goto L57;
        r115 = CollectionsKt.emptyList();
    L57:
        ArrayList r116 = new ArrayList();
        Iterator<T> r117 = r115.iterator();
    L58:
        boolean r118 = true;
        if (r117.hasNext() == false) goto L69;
        Object r119 = r117.next();
        Integer r120 = ((AlbumTabListModel) r119).getTabType();
        int r121 = PhotoPageTabStruct.PHOTO.getValue();
        if (r120 != null) goto L64;
    L66:
        r118 = false;
    L67:
        if (r118 == false) goto L58;
        r116.add(r119);
        goto L58
    L64:
        if (r120.intValue() != r121) goto L66;
    L69:
        boolean r122 = r116.isEmpty();
        List<AlbumTabListModel> r123 = r116;
        if (r122 == false) goto L72;
        r123 = CollectionsKt.listOf(new AlbumTabListModel(null, Integer.valueOf(PhotoPageTabStruct.PHOTO.getValue()), null, null, null, null, 61, null));
    L72:
        List<AlbumTabListModel> r124 = r123;
        AlbumViewModel r125 = this.f262254c;
        if (r125 == null) goto L75;
        PoiAlbumParams r126 = r125.getAlbumParams();
    L76:
        if (r126 == null) goto L79;
        r126.setPhotoPageTabList(r124);
    L79:
        AlbumViewModel r127 = this.f262254c;
        if (r127 == null) goto L82;
        PoiAlbumParams r128 = r127.getAlbumParams();
    L84:
        if (r128 == null) goto L87;
        r128.setAnchorPagerType("photo");
    L87:
        AlbumViewModel r129 = this.f262254c;
        if (r129 == null) goto L90;
        PoiAlbumParams r130 = r129.getAlbumParams();
    L91:
        if (r130 == null) goto L94;
        r130.setShowUploadButton(false);
    L94:
        AlbumViewModel r131 = this.f262254c;
        if (r131 == null) goto L106;
        PoiAlbumParams r132 = r131.getAlbumParams();
        if (r132 == null) goto L102;
        PoiBundle r133 = r132.getPoiBundle();
        if (r133 == null) goto L102;
        String r134 = r133.enterId;
    L103:
        if (r134 != null) goto L105;
        r134 = "";
    L105:
        r131.setPoiEnterId(r134);
    L102:
        r134 = null;
    L106:
        AlbumViewModel r135 = this.f262254c;
        if (r135 == null) goto L109;
        r135.initAlbumData();
    L109:
        AlbumViewModel r136 = this.f262254c;
        if (r136 == null) goto L116;
        PoiAlbumParams r137 = r136.getAlbumParams();
        if (r137 == null) goto L116;
        if (r137.getUseNewStyle() != true) goto L116;
        boolean r138 = true;
    L117:
        if (r138 == false) goto L121;
        AlbumViewModel r139 = this.f262254c;
        if (r139 == null) goto L121;
        r139.requestTopBottomData();
    L121:
        Iterator<T> r140 = B1().iterator();
    L123:
        if (r140.hasNext() == false) goto L132;
        Object r141 = r140.next();
        Integer r142 = ((AlbumTabListModel) r141).getTabType();
        if (r142 != null) goto L127;
    L129:
        boolean r143 = false;
    L130:
        if (r143 == false) goto L123;
    L133:
        AlbumTabListModel r144 = (AlbumTabListModel) r141;
        if (r144 == null) goto L138;
        Integer r145 = r144.getTabStyleMode();
        if (r145 == null) goto L138;
        int r146 = r145.intValue();
    L140:
        if (r146 != VIDEO_TAB_STYLE.LIGHT.getValue()) goto L148;
        AlbumViewModel r147 = this.f262254c;
        if (r147 == null) goto L144;
        PoiAlbumParams r148 = r147.getAlbumParams();
    L145:
        if (r148 == null) goto L148;
        r148.setVideoDarkMode(false);
        goto L148
    L144:
        r148 = null;
    L148:
        List<AlbumTabListModel> r149 = B1();
        AlbumViewModel r150 = this.f262254c;
        if (r150 == null) goto L153;
        MutableLiveData<AlbumPageStatus> r151 = r150.getAlbumPageStatus();
        if (r151 == null) goto L153;
        r151.observe(this, new d(this, r149));
    L153:
        AlbumViewModel r152 = this.f262254c;
        if (r152 == null) goto L158;
        MutableLiveData<PhotoData> r153 = r152.getErrorPicChange();
        if (r153 == null) goto L158;
        r153.observe(this, new f(this));
    L158:
        DmtTextView r154 = this.f262261j;
        if (r154 == null) goto L161;
        r154.setOnClickListener(new g(this));
    L161:
        AppCompatImageView r155 = this.f262259h;
        if (r155 == null) goto L164;
        r155.setOnClickListener(h.f262336a);
    L164:
        AppCompatImageView r156 = this.f262260i;
        if (r156 == null) goto L167;
        r156.setOnClickListener(new PoiAlbumPageActivity$initListener$5(this));
    L167:
        TextView r157 = this.f262269r;
        if (r157 == null) goto L170;
        r157.setOnClickListener(new i(this));
    L170:
        TextView r158 = this.f262268q;
        if (r158 == null) goto L173;
        r158.setOnClickListener(new j(this));
    L173:
        AppCompatImageView r159 = this.f262263l;
        if (r159 == null) goto L176;
        r159.setOnClickListener(new k(this));
    L176:
        AlbumViewModel r160 = this.f262254c;
        if (r160 == null) goto L183;
        PoiAlbumParams r161 = r160.getAlbumParams();
        if (r161 == null) goto L183;
        if (r161.getUseNewStyle() != true) goto L183;
        boolean r162 = true;
    L184:
        if (r162 == false) goto L195;
        AlbumViewModel r163 = this.f262254c;
        if (r163 == null) goto L190;
        MutableLiveData<tv6.b> r164 = r163.getCommonBottomLynxInfo();
        if (r164 == null) goto L190;
        r164.observe(this, new l(this));
    L190:
        AlbumViewModel r165 = this.f262254c;
        if (r165 == null) goto L195;
        MutableLiveData<String> r166 = r165.getCurrentSelectTabLiveData();
        if (r166 == null) goto L195;
        r166.observe(this, new e(this));
    L195:
        Drawable r167 = ContextCompat.getDrawable(this, com.larus.nova.R.drawable.ic_s_s_xmarkthin_outlined_16);
        if (r167 == null) goto L200;
        Drawable r168 = DrawableCompat.wrap(r167).mutate();
        DrawableCompat.setTint(r168, ContextCompat.getColor(this, com.larus.nova.R.color.POIBgPrimary));
        AppCompatImageView r169 = this.f262263l;
        if (r169 == null) goto L200;
        r169.setImageDrawable(r168);
    L200:
        ImmersionBar.with(this).statusBarColor(com.larus.nova.R.color.Transparent).statusBarDarkFont(true).init();
        AppCompatImageView r170 = this.f262264m;
        if (r170 == null) goto L203;
        r170.setOnClickListener(new m(this));
    L203:
        View r171 = this.f262265n;
        if (r171 == null) goto L206;
        ViewGroup.LayoutParams r172 = r171.getLayoutParams();
        Context r173 = r171.getContext();
        r172.height = r173.getResources().getDimensionPixelSize(r173.getResources().getIdentifier("status_bar_height", "dimen", "android"));
    L206:
        TextView r174 = this.f262268q;
        if (r174 == null) goto L209;
        r174.setVisibility(8);
    L209:
        TextView r175 = this.f262269r;
        if (r175 == null) goto L212;
        r175.setVisibility(8);
    L212:
        RoundedRelativeLayout r176 = this.f262262k;
        if (r176 == null) goto L215;
        r176.setVisibility(8);
    L215:
        C1();
        AlbumViewModel r177 = this.f262254c;
        if (r177 == null) goto L220;
        PoiAlbumParams r178 = r177.getAlbumParams();
        if (r178 == null) goto L220;
        String r179 = r178.getAnchorPagerType();
    L222:
        if (Intrinsics.areEqual(r179, "photo") == true) goto L229;
        DmtTextView r180 = this.f262261j;
        if (r180 == null) goto L226;
        r180.setVisibility(8);
    L226:
        AppCompatImageView r181 = this.f262260i;
        if (r181 == null) goto L229;
        r181.setVisibility(8);
    L229:
        AppCompatImageView r182 = this.f262264m;
        if (r182 == null) goto L232;
        r182.setVisibility(0);
    L232:
        List<AlbumTabListModel> r183 = B1();
        if ((!r183.isEmpty()) == true) goto L235;
    L243:
        AlbumViewModel r184 = this.f262254c;
        if (r184 == null) goto L252;
        PoiAlbumParams r185 = r184.getAlbumParams();
        if (r185 == null) goto L250;
        String r186 = r185.getAnchorPagerType();
        if (r186 == null) goto L250;
    L251:
        r184.setCurrentSelectTabId(r186);
    L250:
        r186 = "";
    L252:
        AlbumViewModel r187 = this.f262254c;
        if (r187 == null) goto L255;
        MutableLiveData<String> r188 = r187.getCurrentSelectTabLiveData();
    L256:
        if (r188 == null) goto L266;
        AlbumViewModel r189 = this.f262254c;
        if (r189 == null) goto L264;
        PoiAlbumParams r190 = r189.getAlbumParams();
        if (r190 == null) goto L264;
        String r191 = r190.getAnchorPagerType();
        if (r191 == null) goto L264;
    L265:
        r188.setValue(r191);
    L264:
        r191 = "";
    L266:
        qn6.a.f(this.f262255d, getWindow().getContext(), CollectionsKt.emptyList(), 3, "operation_on_album_page", null, null, null, "click", false, null, 1760);
        qn6.a r192 = this.f262255d;
        AlbumViewModel r193 = this.f262254c;
        if (r193 == null) goto L271;
        PoiAlbumParams r194 = r193.getAlbumParams();
        if (r194 == null) goto L271;
        PoiBundle r195 = r194.getPoiBundle();
    L272:
        Pair[] r196 = new Pair[11];
        r196[0] = TuplesKt.to("enter_from", "album_page");
        AlbumViewModel r197 = this.f262254c;
        if (r197 == null) goto L278;
        PoiAlbumParams r198 = r197.getAlbumParams();
        if (r198 == null) goto L278;
        String r199 = r198.getEnterMethod();
        if (r199 == null) goto L278;
    L279:
        r196[1] = TuplesKt.to("enter_method", r199);
        if (r195 == null) goto L282;
        String r200 = r195.poiId;
    L283:
        if (r200 != null) goto L285;
        r200 = "";
    L285:
        r196[2] = TuplesKt.to("poi_id", r200);
        if (r195 == null) goto L288;
        String r201 = r195.backendType;
    L289:
        if (r201 != null) goto L291;
        r201 = "";
    L291:
        r196[3] = TuplesKt.to("poi_backend_type", r201);
        if (r195 == null) goto L294;
        String r202 = r195.cityCode;
    L296:
        if (yx6.a.a(r202) == false) goto L298;
        String r203 = "1";
    L299:
        r196[4] = TuplesKt.to("poi_device_samecity", r203);
        if (r195 == null) goto L302;
        String r204 = r195.from;
    L303:
        if (r204 != null) goto L305;
        r204 = "";
    L305:
        r196[5] = TuplesKt.to("poi_enter_page", r204);
        if (r195 == null) goto L308;
        String r205 = r195.enterId;
    L309:
        if (r205 != null) goto L311;
        r205 = "";
    L311:
        r196[6] = TuplesKt.to("poi_enter_id", r205);
        AlbumViewModel r206 = this.f262254c;
        if (r206 == null) goto L317;
        PoiAlbumParams r207 = r206.getAlbumParams();
        if (r207 == null) goto L317;
        String r208 = Integer.valueOf(r207.getPoiPicMode()).toString();
        if (r208 == null) goto L317;
    L318:
        r196[7] = TuplesKt.to("poi_pic_mode", r208);
        if (r195 == null) goto L321;
        String r209 = r195.enterMethod;
    L322:
        if (r209 != null) goto L324;
        r209 = "";
    L324:
        r196[8] = TuplesKt.to(BdpAppEventConstant.PARAMS_POI_ENTER_METHOD, r209);
        AlbumViewModel r210 = this.f262254c;
        if (r210 == null) goto L329;
        PoiAlbumParams r211 = r210.getAlbumParams();
        if (r211 == null) goto L329;
        int r212 = r211.getCheckInVideoCnt();
    L330:
        r196[9] = TuplesKt.to("check_in_video_cnt", String.valueOf(r212));
        AlbumViewModel r213 = this.f262254c;
        if (r213 == null) goto L338;
        PoiAlbumParams r214 = r213.getAlbumParams();
        if (r214 == null) goto L338;
        String r215 = r214.getAlbumEnterMethod();
        if (r215 == null) goto L338;
        r110 = r215;
    L338:
        r196[10] = TuplesKt.to("album_enter_method", r110);
        HashMap r216 = MapsKt.hashMapOf(r196);
        AlbumViewModel r217 = this.f262254c;
        if (r217 == null) goto L345;
        PoiAlbumParams r218 = r217.getAlbumParams();
        if (r218 == null) goto L345;
        if (r218.isHomePoiStyle() != true) goto L345;
        r105 = true;
    L345:
        if (r105 == false) goto L347;
        r216.put("page_name", "page_album_page");
        r216.put("element_type", "be_null");
        r216.put("position", "be_null");
        r216.put(BdpAppEventConstant.PARAMS_CLICK_POSITION, "be_null");
        r216.put("enter_from", "album_page");
        r216.put("extra_params", "be_null");
    L347:
        r192.getClass();
        Intrinsics.checkNotNullParameter(r216, "map");
        r192.f534088e.putAll(r216);
        AppCompatImageView r219 = this.f262264m;
        if (r219 == null) goto L365;
        ViewTreeObserver r220 = r219.getViewTreeObserver();
        if (r220 == null) goto L366;
        r220.addOnPreDrawListener(new c(r219, this));
        return;
    L366:
        return;
    L365:
        return;
    L329:
        r212 = 0;
        goto L330
    L321:
        r209 = null;
    L317:
        r208 = "";
        goto L318
    L308:
        r205 = null;
        goto L309
    L302:
        r204 = null;
        goto L303
    L298:
        r203 = "0";
        goto L299
    L294:
        r202 = null;
        goto L296
    L288:
        r201 = null;
        goto L289
    L282:
        r200 = null;
    L278:
        r199 = "";
    L271:
        r195 = null;
        goto L272
    L255:
        r188 = null;
        goto L256
    L235:
        if (r183.size() != 1) goto L242;
        Integer r221 = ((AlbumTabListModel) ListProtector.get(r183, 0)).getTabType();
        int r1100 = PhotoPageTabStruct.PHOTO.getValue();
        if (r221 == null) goto L242;
        if (r221.intValue() != r1100) goto L242;
        F1(((AlbumTabListModel) ListProtector.get(r183, 0)).getTabName());
    L242:
        D1(r183);
    L220:
        r179 = null;
    L183:
        r162 = false;
    L138:
        r146 = VIDEO_TAB_STYLE.DRAK.getValue();
        goto L140
    L127:
        if (r142.equals(Integer.valueOf(PhotoPageTabStruct.VIDEO.getValue())) != true) goto L129;
        r143 = true;
        goto L130
    L132:
        r141 = null;
    L116:
        r138 = false;
        goto L117
    L90:
        r130 = null;
        goto L91
    L82:
        r128 = null;
        goto L84
    L75:
        r126 = null;
    L54:
        r115 = null;
        goto L55
    L45:
        AlbumViewModel r1101 = this.f262254c;
        if (r1101 == null) goto L49;
        r1101.setAlbumParams(r102);
        goto L49
    L22:
        r104 = null;
        goto L23
    L18:
        r102 = null;
        goto L19
    }
}
