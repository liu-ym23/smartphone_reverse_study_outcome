package com.bytedance.ee.bear.drive.biz.versions;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.common.utility.collection.CollectionUtils;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseOpenEntity;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.SpaceFileOpenEntity;
import com.bytedance.ee.bear.drive.biz.permission.DriveMGPermissionVM;
import com.bytedance.ee.bear.drive.biz.versions.adapter.VersionOperationRecordAdapter;
import com.bytedance.ee.bear.drive.biz.versions.model.DriveVersionHistoryRecord;
import com.bytedance.ee.bear.drive.biz.versions.model.VersionPayLoadData;
import com.bytedance.ee.bear.facade.common.empty.EmptyView;
import com.bytedance.ee.bear.facade.common.widget.recyclerview.LoadMoreFooter;
import com.bytedance.ee.bear.facade.common.widget.recyclerview.LoadRefreshHeader;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.lynx.tasm.LynxError;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.ss.android.dypay.api.DyPayConstant;
import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.convention.PassportcConvention;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import d0c.b;
import d75.c;
import d75.i;
import d75.j;
import d75.k;
import d75.n;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import dagger.hilt.android.dwarf.DwarfInjectPoint;
import e0c.l;
import f0c.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import m75.d;

/* JADX INFO: loaded from: classes16.dex */
@DwarfInjectPoint(parent = l.class)
@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 E2\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\u00020\u00032\u00020\u00042\u00020\u0005:\u0001EB\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010 \u001a\u00020!H\u0014J\b\u0010\"\u001a\u00020#H\u0014J\b\u0010$\u001a\u00020#H\u0014J\b\u0010%\u001a\u00020#H\u0014J\b\u0010&\u001a\u00020#H\u0014J\b\u0010'\u001a\u00020#H\u0002J\b\u0010(\u001a\u00020#H\u0002J\b\u0010)\u001a\u00020#H\u0002J\b\u0010*\u001a\u00020#H\u0002J\b\u0010+\u001a\u00020#H\u0014J\u0010\u0010,\u001a\u00020\u00022\u0006\u0010-\u001a\u00020.H\u0014J6\u0010/\u001a\u00020#2\u0006\u00100\u001a\u0002012\u000e\u00102\u001a\n\u0012\u0004\u0012\u000204\u0018\u0001032\u0014\u00105\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u000207\u0018\u000106H\u0016J6\u00108\u001a\u00020#2\u0006\u00100\u001a\u0002012\u000e\u00102\u001a\n\u0012\u0004\u0012\u000204\u0018\u0001032\u0014\u00105\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u000207\u0018\u000106H\u0016J\b\u00109\u001a\u00020#H\u0016J\u0010\u0010:\u001a\u00020#2\u0006\u0010;\u001a\u00020<H\u0016J\u0010\u0010A\u001a\u00020#2\u0006\u0010B\u001a\u000204H\u0016J\b\u0010C\u001a\u00020DH\u0016R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u001a\u001a\u00020\u001b8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u000e\u0010=\u001a\u00020>X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010?\u001a\u0002018BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b?\u0010@¨\u0006F"}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/versions/VersionOperationRecordV2Activity;", "Lcom/bytedance/ee/bear/drive/common/mvpframeworks/app/activity/DriveAbsMvpActivity;", "Lcom/bytedance/ee/bear/drive/biz/versions/VersionOperationRecordPresenter;", "Lcom/bytedance/ee/bear/drive/biz/versions/IVersionOperationRecordView;", "Lcom/bytedance/ee/bear/drive/biz/versions/adapter/VersionOperationRecordAdapter$OnItemClickListener;", "Lcom/ss/android/lark/passportc/convention/view/UserScopeView;", "<init>", "()V", "mCommonTitleBar", "Lcom/bytedance/ee/bear/widgets/BaseTitleBar;", "mSmartRefreshLayout", "Lcom/scwang/smartrefresh/layout/SmartRefreshLayout;", "mRecordRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "mEmptyView", "Lcom/bytedance/ee/bear/facade/common/empty/EmptyView;", "mRecordAdapter", "Lcom/bytedance/ee/bear/drive/biz/versions/adapter/VersionOperationRecordAdapter;", "mObjToken", "", "mLaunchVersion", "mMountPoint", "mDriveMultiVersionPush", "Lcom/bytedance/ee/bear/drive/biz/versions/push/DriveMultiVersionPush;", "mDriveSpaceFilePermissionPush", "Lcom/bytedance/ee/bear/drive/biz/permission/push/DriveSpaceFilePermissionPush;", "userNetService", "Lcom/bytedance/ee/bear/contract/NetService;", "getUserNetService", "()Lcom/bytedance/ee/bear/contract/NetService;", "setUserNetService", "(Lcom/bytedance/ee/bear/contract/NetService;)V", "getContentViewLayoutId", "", "bindViews", "", "initData", "initViews", "initActions", "parseIntent", "findWidget", "initWidget", "setListener", LiveCommonConstants.REASON_ON_DEDTROY, "createPresenter", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "showHistoryRecord", "hasMore", "", "recordBeanList", "", "Lcom/bytedance/ee/bear/drive/biz/versions/model/DriveVersionHistoryRecord$RecordBean;", "userBeanMap", "", "Lcom/bytedance/ee/bear/drive/biz/versions/model/DriveVersionHistoryRecord$UserBean;", "appendHistoryRecord", DyPayConstant.KEY_SHOW_LOADING, "showFirstLoadError", LynxError.LYNX_THROWABLE, "", "lastClickTime", "", "isValidClick", "()Z", "onItemClick", "recordBean", "provideUserSession", "Lcom/ss/android/lark/passportc/entity/UserSession;", "Companion", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VersionOperationRecordV2Activity extends Hilt_VersionOperationRecordV2Activity<i> implements c, VersionOperationRecordAdapter.b, d0c.c {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final /* synthetic */ int f223963r = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public BaseTitleBar f223964f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public SmartRefreshLayout f223965g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public RecyclerView f223966h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public EmptyView f223967i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public VersionOperationRecordAdapter f223968j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f223969k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f223970l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f223971m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public f75.a f223972n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public v55.c f223973o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @Inject
    public NetService f223974p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f223975q;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.drive.common.mvpframeworks.app.activity.DriveAbsBaseActivity
    public final int D1() {
        return R.layout.drive_activity_version_operation_record;
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void afterUserOffline(h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void afterUserOnline(h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // dagger.hilt.android.dwarf.DwarfComponentProvider, dagger.hilt.internal.GeneratedComponentManager
    public final /* synthetic */ Object generatedComponent() {
        return DwarfComponentProvider.CC.$default$generatedComponent(this);
    }

    @Override // com.ss.android.lark.passportc.api.r
    public final /* synthetic */ m getPassport() {
        return b.a(this);
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void onUserOffline(h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void onUserOnline(h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // d0c.c, dagger.hilt.android.dwarf.DwarfComponentProvider
    public final /* synthetic */ l provideComponent() {
        return b.b(this);
    }

    /* JADX INFO: Removed unreachable split cross block B:51:0x0104 */
    @Override // com.bytedance.ee.bear.drive.biz.versions.Hilt_VersionOperationRecordV2Activity, com.bytedance.ee.bear.drive.common.mvpframeworks.app.activity.DriveAbsMvpActivity, com.bytedance.ee.bear.drive.common.mvpframeworks.app.activity.DriveAbsBaseActivity, com.bytedance.ee.bear.drive.common.mvpframeworks.app.activity.DriveRootActivity, com.bytedance.ee.bear.facade.common.BaseActivity, com.bytedance.ee.bear.facade.common.BaseCommonActivity, com.bytedance.ee.bear.facade.common.LifeCycleActivity, com.larksuite.component.air.WindowInsetsCompatAirActivity, com.larksuite.component.air.AirActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r100 = FLogger.f375446a;
        r100.i("ActivityLancet", "finish ".concat(VersionOperationRecordV2Activity.class.getName()));
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
    L48:
        return;
    L16:
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L19;
        r100.i("ActivityLancet", "quit !resume, current state = " + getLifecycle().getCurrentState());     // Catch: Throwable -> L42
        goto L48
    L19:
        if (isFinishing() == true) goto L22;
        r100.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L42
        goto L48
    L22:
        if (ActivityStartBehavior.isInternalActivityConsumed(this) == true) goto L25;
        r100.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L42
        goto L48
    L25:
        if (ActivityLancet.isOnlyActivityInTask(this) == true) goto L28;
        r100.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L42
        goto L48
    L28:
        if (ActivityLancet.isExcludedActivity(this) == false) goto L31;
        r100.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L42
        goto L48
    L31:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L33;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L42
        goto L48
    L33:
        Intent r104 = getPackageManager().getLaunchIntentForPackage(getPackageName());     // Catch: Throwable -> L42
        if (r104 == null) goto L48;
        r104.addFlags(268435456);     // Catch: Throwable -> L42
        r104.addFlags(2097152);     // Catch: Throwable -> L42
        r100.i("ActivityLancet", "start launcher intent after backPressed, activity=" + this);     // Catch: Throwable -> L42
        startActivity(r104);     // Catch: Throwable -> L39
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.slide_out_right);     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        FLogger.f375446a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L42
        goto L48
    L10:
        if ((r101 - r103.longValue()) >= 800) goto L13;
        monitor-exit(r102);     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.ee.bear.drive.common.mvpframeworks.app.activity.DriveAbsBaseActivity
    public final void initActions() {
        i r100 = (i) this.f224079d;
        if (r100 == null) goto L6;
        r100.j(this.f223969k, true);
        return;
    }

    @Override // com.bytedance.ee.bear.drive.common.mvpframeworks.app.activity.DriveAbsBaseActivity
    public final void initViews() {
        BaseTitleBar r100 = this.f223964f;
        if (r100 == null) goto L5;
        r100.setTitle(R.string.Drive_Drive_HistoryRecordPageTitle);
    L5:
        SmartRefreshLayout r101 = this.f223965g;
        if (r101 == null) goto L8;
        r101.G(new LoadRefreshHeader(this), -2);
    L8:
        LoadMoreFooter r102 = new LoadMoreFooter(this);
        r102.setBackgroundColor(getResources().getColor(R.color.bg_base));
        SmartRefreshLayout r103 = this.f223965g;
        if (r103 == null) goto L11;
        r103.F(r102, -2);
    L11:
        RecyclerView r104 = this.f223966h;
        if (r104 == null) goto L14;
        r104.setLayoutManager(new LinearLayoutManager(this));
    L14:
        VersionOperationRecordAdapter r105 = new VersionOperationRecordAdapter(this);
        this.f223968j = r105;
        RecyclerView r106 = this.f223966h;
        if (r106 == null) goto L17;
        r106.setAdapter(r105);
    L17:
        VersionOperationRecordAdapter r107 = this.f223968j;
        if (r107 == null) goto L20;
        r107.f223980d = this;
    L20:
        EmptyView r108 = this.f223967i;
        if (r108 == null) goto L23;
        r108.setOnRetryListener(new j(this));
    L23:
        SmartRefreshLayout r109 = this.f223965g;
        if (r109 == null) goto L26;
        r109.W = new k(this);
    L26:
        if (r109 == null) goto L29;
        r109.i(new d75.l(this));
    L29:
        if (com.bytedance.ee.util.ui.b.a(this) == false) goto L39;
        ((DriveMGPermissionVM) new ViewModelProvider(this).get(DriveMGPermissionVM.class)).livePerm().observe(this, new d75.m(this));
        f75.a r110 = this.f223972n;
        if (r110 == null) goto L37;
        MutableLiveData<VersionPayLoadData> r111 = r110.f475760e;
        if (r111 == null) goto L38;
        r111.observe(this, new n(this));
        return;
    L38:
        return;
    L37:
        return;
    }

    @Override // com.bytedance.ee.bear.drive.biz.versions.Hilt_VersionOperationRecordV2Activity, com.bytedance.ee.bear.drive.common.mvpframeworks.app.activity.DriveAbsMvpActivity, com.bytedance.ee.bear.drive.common.mvpframeworks.app.activity.DriveAbsBaseActivity, com.bytedance.ee.bear.drive.common.mvpframeworks.app.activity.DriveRootActivity, com.bytedance.ee.bear.facade.common.BaseActivity, com.bytedance.ee.bear.facade.common.BaseCommonActivity, com.bytedance.ee.bear.facade.common.LifeCycleActivity, com.larksuite.component.air.WindowInsetsCompatAirActivity, com.larksuite.component.air.AirActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.f375446a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(VersionOperationRecordV2Activity.class.getName()));
    L5:
        super.onDestroy();
        f75.a r100 = this.f223972n;
        if (r100 == null) goto L8;
        r100.b();
    L8:
        v55.c r101 = this.f223973o;
        if (r101 == null) goto L12;
        r101.a();
        return;
    }

    @Override // d75.c
    public final void showLoading() {
        EmptyView r100 = this.f223967i;
        if (r100 == null) goto L5;
        r100.setVisibility(0);
    L5:
        EmptyView r101 = this.f223967i;
        if (r101 == null) goto L9;
        r101.showLoading();
        return;
    }

    @Override // com.bytedance.ee.bear.drive.common.mvpframeworks.app.activity.DriveAbsBaseActivity
    public final void bindViews() {
        this.f223964f = (BaseTitleBar) findViewById(R.id.common_title_bar);
        this.f223965g = (SmartRefreshLayout) findViewById(R.id.list_refresh_layout);
        this.f223966h = (RecyclerView) findViewById(R.id.record_recy_view);
        this.f223967i = (EmptyView) findViewById(R.id.list_no_data_tip);
    }

    @Override // d0c.c
    public final UserSession e9() {
        return PassportcConvention.c(this);
    }

    @Override // com.bytedance.ee.bear.drive.common.mvpframeworks.app.activity.DriveAbsBaseActivity
    public final void initData() {
        this.f223969k = getIntent().getStringExtra("extra_obj_token");
        this.f223970l = getIntent().getStringExtra("extra_launch_version");
        this.f223971m = getIntent().getStringExtra("extra_launch_mountPoint");
        if (TextUtils.isEmpty(this.f223969k) == false) goto L5;
        this.f224078c = true;
        finish();
    L5:
        f75.a r100 = new f75.a(this.f223969k);
        this.f223972n = r100;
        r100.a();
        String r101 = this.f223969k;
        if (r101 != null) goto L8;
        r101 = "";
    L8:
        this.f223973o = new v55.c(r101, (DriveMGPermissionVM) new ViewModelProvider(this).get(DriveMGPermissionVM.class));
    }

    @Override // com.bytedance.ee.bear.drive.common.mvpframeworks.app.activity.DriveAbsMvpActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
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

    @Override // dagger.hilt.android.dwarf.DwarfComponentProvider
    public final /* bridge */ /* synthetic */ Object provideComponent() {
        return provideComponent();
    }

    public VersionOperationRecordV2Activity() {
    }

    @Override // com.bytedance.ee.bear.drive.common.mvpframeworks.app.activity.DriveAbsMvpActivity
    public final d G1(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        NetService r101 = this.f223974p;
        if (r101 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("userNetService");
        r101 = null;
    L7:
        return new i(r100, r101);
    }

    @Override // d75.c
    public final void iG(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, LynxError.LYNX_THROWABLE);
        SmartRefreshLayout r101 = this.f223965g;
        if (r101 == null) goto L5;
        r101.u(0, true, Boolean.FALSE);
    L5:
        EmptyView r102 = this.f223967i;
        if (r102 == null) goto L8;
        r102.setVisibility(0);
    L8:
        EmptyView r103 = this.f223967i;
        if (r103 == null) goto L12;
        r103.a();
        return;
    }

    @Override // com.bytedance.ee.bear.drive.biz.versions.adapter.VersionOperationRecordAdapter.b
    public final void u(DriveVersionHistoryRecord.RecordBean r110) {
        Intrinsics.checkNotNullParameter(r110, "recordBean");
        long r100 = SystemClock.uptimeMillis();
        if ((r100 - this.f223975q) >= 800) goto L5;
        boolean r101 = false;
    L7:
        if (r101 == true) goto L11;
        tt5.a.k("VersionOperationRecordActivity", "unValidClick in version item");
        return;
    L11:
        if (r110.isCipherDeleted() == false) goto L15;
        tt5.a.h("VersionOperationRecordActivity", "DriveVersionHistoryRecord click ignore, isCipherDeleted");
        return;
    L15:
        if (TextUtils.equals(this.f223970l, r110.getVersion()) == false) goto L17;
        finish();
        return;
    L17:
        SpaceFileOpenEntity r102 = new SpaceFileOpenEntity(this.f223969k, "");
        r102.setPreviewFrom("history");
        r102.setVersion(r110.getVersion());
        r102.setDataVersion(r110.getDataVersion());
        r102.setMountPoint(this.f223971m);
        Bundle r103 = new Bundle();
        r103.putString("extra_history_date", zu5.a.b(this, r110.getEditTime()));
        r103.putBoolean("history", true);
        r102.setExtras(r103);
        ArrayList<? extends BaseOpenEntity> r104 = new ArrayList();
        r104.add(r102);
        ma5.a r111 = new ma5.a();
        r111.f512702d = true;
        ((com.bytedance.ee.bear.i) org.koin.java.a.c(com.bytedance.ee.bear.i.class, null, null, 6)).f(this, r104, 0, r111, null);
        return;
    L5:
        this.f223975q = r100;
        r101 = true;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // d75.c
    public final void q70(boolean r100, List<? extends DriveVersionHistoryRecord.RecordBean> r101, Map<String, ? extends DriveVersionHistoryRecord.UserBean> r102) {
        SmartRefreshLayout r103 = this.f223965g;
        if (r103 == null) goto L6;
        r103.u(0, true, Boolean.FALSE);
    L6:
        if (CollectionUtils.isEmpty(r101) == false) goto L16;
        BaseTitleBar r104 = this.f223964f;
        if (r104 == null) goto L10;
        r104.setDividerVisible(true);
    L10:
        EmptyView r105 = this.f223967i;
        if (r105 == null) goto L13;
        r105.setVisibility(0);
    L13:
        EmptyView r106 = this.f223967i;
        if (r106 == null) goto L34;
        r106.showNoContent();
    L34:
        SmartRefreshLayout r107 = this.f223965g;
        if (r107 == null) goto L39;
        r107.g(r100);
        return;
    L39:
        return;
    L16:
        EmptyView r108 = this.f223967i;
        if (r108 == null) goto L19;
        r108.setVisibility(4);
    L19:
        BaseTitleBar r109 = this.f223964f;
        if (r109 == null) goto L22;
        r109.setDividerVisible(false);
    L22:
        VersionOperationRecordAdapter r110 = this.f223968j;
        if (r110 == null) goto L34;
        if (CollectionUtils.isEmpty(r101) == true) goto L34;
        if (r102 == 0) goto L29;
        r110.f223979c = r102;
    L29:
        ((ArrayList) r110.f223978b).clear();
        ((ArrayList) r110.f223978b).add(new com.bytedance.ee.bear.drive.biz.versions.model.a.C3216a());
        Iterator<? extends DriveVersionHistoryRecord.RecordBean> r111 = r101.iterator();
    L31:
        if (r111.hasNext() == false) goto L33;
        DriveVersionHistoryRecord.RecordBean r112 = r111.next();
        ((ArrayList) r110.f223978b).add(new com.bytedance.ee.bear.drive.biz.versions.model.a.b(r112));
        goto L31
    L33:
        r110.f223981e = ((DriveVersionHistoryRecord.RecordBean) ListProtector.get(r101, r101.size() - 1)).getEditTime();
        r110.notifyDataSetChanged();
        goto L34
    }

    @Override // d75.c
    public final void sp(boolean r100, List<? extends DriveVersionHistoryRecord.RecordBean> r101, Map<String, ? extends DriveVersionHistoryRecord.UserBean> r102) {
        SmartRefreshLayout r103 = this.f223965g;
        if (r103 == null) goto L6;
        r103.b(0, false);
    L6:
        if (CollectionUtils.isEmpty(r101) == false) goto L8;
        return;
    L8:
        VersionOperationRecordAdapter r104 = this.f223968j;
        if (r104 != null) goto L11;
    L20:
        SmartRefreshLayout r105 = this.f223965g;
        if (r105 == null) goto L25;
        r105.g(r100);
        return;
    L25:
        return;
    L11:
        if (CollectionUtils.isEmpty(r101) == true) goto L20;
        if (r102 == null) goto L15;
        r104.f223979c.putAll(r102);
    L15:
        Iterator<? extends DriveVersionHistoryRecord.RecordBean> r106 = r101.iterator();
    L17:
        if (r106.hasNext() == false) goto L19;
        DriveVersionHistoryRecord.RecordBean r107 = r106.next();
        ((ArrayList) r104.f223978b).add(new com.bytedance.ee.bear.drive.biz.versions.model.a.b(r107));
        goto L17
    L19:
        r104.f223981e = ((DriveVersionHistoryRecord.RecordBean) ListProtector.get(r101, r101.size() - 1)).getEditTime();
        r104.notifyDataSetChanged();
        goto L20
    }
}
