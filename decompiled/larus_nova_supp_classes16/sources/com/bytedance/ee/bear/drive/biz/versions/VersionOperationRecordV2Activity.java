package com.bytedance.ee.bear.drive.biz.versions;

import android.R;
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
import com.bytedance.common.utility.collection.CollectionUtils;
import com.bytedance.ee.bear.contract.NetService;
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
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.convention.PassportcConvention;
import com.ss.android.lark.passportc.entity.UserSession;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@DwarfInjectPoint(parent = l.class)
@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 E2\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\u00020\u00032\u00020\u00042\u00020\u0005:\u0001EB\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010 \u001a\u00020!H\u0014J\b\u0010\"\u001a\u00020#H\u0014J\b\u0010$\u001a\u00020#H\u0014J\b\u0010%\u001a\u00020#H\u0014J\b\u0010&\u001a\u00020#H\u0014J\b\u0010'\u001a\u00020#H\u0002J\b\u0010(\u001a\u00020#H\u0002J\b\u0010)\u001a\u00020#H\u0002J\b\u0010*\u001a\u00020#H\u0002J\b\u0010+\u001a\u00020#H\u0014J\u0010\u0010,\u001a\u00020\u00022\u0006\u0010-\u001a\u00020.H\u0014J6\u0010/\u001a\u00020#2\u0006\u00100\u001a\u0002012\u000e\u00102\u001a\n\u0012\u0004\u0012\u000204\u0018\u0001032\u0014\u00105\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u000207\u0018\u000106H\u0016J6\u00108\u001a\u00020#2\u0006\u00100\u001a\u0002012\u000e\u00102\u001a\n\u0012\u0004\u0012\u000204\u0018\u0001032\u0014\u00105\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u000207\u0018\u000106H\u0016J\b\u00109\u001a\u00020#H\u0016J\u0010\u0010:\u001a\u00020#2\u0006\u0010;\u001a\u00020<H\u0016J\u0010\u0010A\u001a\u00020#2\u0006\u0010B\u001a\u000204H\u0016J\b\u0010C\u001a\u00020DH\u0016R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u001a\u001a\u00020\u001b8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u000e\u0010=\u001a\u00020>X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010?\u001a\u0002018BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b?\u0010@¨\u0006F"}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/versions/VersionOperationRecordV2Activity;", "Lcom/bytedance/ee/bear/drive/common/mvpframeworks/app/activity/DriveAbsMvpActivity;", "Lcom/bytedance/ee/bear/drive/biz/versions/VersionOperationRecordPresenter;", "Lcom/bytedance/ee/bear/drive/biz/versions/IVersionOperationRecordView;", "Lcom/bytedance/ee/bear/drive/biz/versions/adapter/VersionOperationRecordAdapter$OnItemClickListener;", "Lcom/ss/android/lark/passportc/convention/view/UserScopeView;", "<init>", "()V", "mCommonTitleBar", "Lcom/bytedance/ee/bear/widgets/BaseTitleBar;", "mSmartRefreshLayout", "Lcom/scwang/smartrefresh/layout/SmartRefreshLayout;", "mRecordRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "mEmptyView", "Lcom/bytedance/ee/bear/facade/common/empty/EmptyView;", "mRecordAdapter", "Lcom/bytedance/ee/bear/drive/biz/versions/adapter/VersionOperationRecordAdapter;", "mObjToken", "", "mLaunchVersion", "mMountPoint", "mDriveMultiVersionPush", "Lcom/bytedance/ee/bear/drive/biz/versions/push/DriveMultiVersionPush;", "mDriveSpaceFilePermissionPush", "Lcom/bytedance/ee/bear/drive/biz/permission/push/DriveSpaceFilePermissionPush;", "userNetService", "Lcom/bytedance/ee/bear/contract/NetService;", "getUserNetService", "()Lcom/bytedance/ee/bear/contract/NetService;", "setUserNetService", "(Lcom/bytedance/ee/bear/contract/NetService;)V", "getContentViewLayoutId", "", "bindViews", "", "initData", "initViews", "initActions", "parseIntent", "findWidget", "initWidget", "setListener", "onDestroy", "createPresenter", "context", "Landroid/content/Context;", "showHistoryRecord", "hasMore", "", "recordBeanList", "", "Lcom/bytedance/ee/bear/drive/biz/versions/model/DriveVersionHistoryRecord$RecordBean;", "userBeanMap", "", "Lcom/bytedance/ee/bear/drive/biz/versions/model/DriveVersionHistoryRecord$UserBean;", "appendHistoryRecord", "showLoading", "showFirstLoadError", "throwable", "", "lastClickTime", "", "isValidClick", "()Z", "onItemClick", "recordBean", "provideUserSession", "Lcom/ss/android/lark/passportc/entity/UserSession;", "Companion", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VersionOperationRecordV2Activity extends Hilt_VersionOperationRecordV2Activity<i> implements c, VersionOperationRecordAdapter.b, d0c.c {
    public static final /* synthetic */ int r = 0;
    public BaseTitleBar f;
    public SmartRefreshLayout g;
    public RecyclerView h;
    public EmptyView i;
    public VersionOperationRecordAdapter j;
    public String k;
    public String l;
    public String m;
    public f75.a n;
    public v55.c o;

    @Inject
    public NetService p;
    public long q;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.drive.common.mvpframeworks.app.activity.DriveAbsBaseActivity
    public final int D1() {
        return 2131560180;
    }

    public final void afterUserOffline(h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final void afterUserOnline(h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final /* synthetic */ Object generatedComponent() {
        return DwarfComponentProvider.-CC.$default$generatedComponent(this);
    }

    public final /* synthetic */ m getPassport() {
        return b.a(this);
    }

    public final void onUserOffline(h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final void onUserOnline(h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final /* synthetic */ l provideComponent() {
        return b.b(this);
    }

    /* JADX INFO: Removed unreachable split cross block B:51:0x0104 */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ee.bear.drive.biz.versions.Hilt_VersionOperationRecordV2Activity, com.bytedance.ee.bear.drive.common.mvpframeworks.app.activity.DriveAbsMvpActivity, com.bytedance.ee.bear.drive.common.mvpframeworks.app.activity.DriveAbsBaseActivity, com.bytedance.ee.bear.drive.common.mvpframeworks.app.activity.DriveRootActivity, com.bytedance.ee.bear.facade.common.BaseActivity, com.bytedance.ee.bear.facade.common.BaseCommonActivity, com.bytedance.ee.bear.facade.common.LifeCycleActivity
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(VersionOperationRecordV2Activity.class.getName()));
        long r3 = SystemClock.uptimeMillis();
        Map r5 = ActivityLancet.LAST_FINISH_HANDLED_MS;
        monitor-enter(r5);
        Long r6 = (Long) r5.get(this);     // Catch: Throwable -> L45
        if (r6 != null) goto L10;
    L13:
        r5.put(this, Long.valueOf(r3));     // Catch: Throwable -> L45
        monitor-exit(r5);     // Catch: Throwable -> L45
    L42:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "handle onBackPressed strategy failed", th);
    L48:
        return;
    L16:
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L19;
        r2.i("ActivityLancet", "quit !resume, current state = " + getLifecycle().getCurrentState());     // Catch: Throwable -> L42
        goto L48
    L19:
        if (isFinishing() == true) goto L22;
        r2.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L42
        goto L48
    L22:
        if (ActivityStartBehavior.isInternalActivityConsumed(this) == true) goto L25;
        r2.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L42
        goto L48
    L25:
        if (ActivityLancet.isOnlyActivityInTask(this) == true) goto L28;
        r2.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L42
        goto L48
    L28:
        if (ActivityLancet.isExcludedActivity(this) == false) goto L31;
        r2.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L42
        goto L48
    L31:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L33;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L42
        goto L48
    L33:
        Intent r1 = getPackageManager().getLaunchIntentForPackage(getPackageName());     // Catch: Throwable -> L42
        if (r1 == null) goto L48;
        r1.addFlags(268435456);     // Catch: Throwable -> L42
        r1.addFlags(2097152);     // Catch: Throwable -> L42
        r2.i("ActivityLancet", "start launcher intent after backPressed, activity=" + this);     // Catch: Throwable -> L42
        startActivity(r1);     // Catch: Throwable -> L39
        overridePendingTransition(R.anim.fade_in, R.anim.slide_out_right);     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L42
        goto L48
    L10:
        if ((r3 - r6.longValue()) >= 800) goto L13;
        monitor-exit(r5);     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.ee.bear.drive.common.mvpframeworks.app.activity.DriveAbsBaseActivity
    public final void initActions() {
        i r0 = (i) this.d;
        if (r0 == null) goto L6;
        r0.j(this.k, true);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ee.bear.drive.common.mvpframeworks.app.activity.DriveAbsBaseActivity
    public final void initViews() {
        BaseTitleBar r0 = this.f;
        if (r0 == null) goto L5;
        r0.setTitle(2131888402);
    L5:
        SmartRefreshLayout r1 = this.g;
        if (r1 == null) goto L8;
        r1.G(new LoadRefreshHeader(this), -2);
    L8:
        LoadMoreFooter r2 = new LoadMoreFooter(this);
        r2.setBackgroundColor(getResources().getColor(2131100545));
        SmartRefreshLayout r3 = this.g;
        if (r3 == null) goto L11;
        r3.F(r2, -2);
    L11:
        RecyclerView r4 = this.h;
        if (r4 == null) goto L14;
        r4.setLayoutManager(new LinearLayoutManager(this));
    L14:
        VersionOperationRecordAdapter r5 = new VersionOperationRecordAdapter(this);
        this.j = r5;
        RecyclerView r6 = this.h;
        if (r6 == null) goto L17;
        r6.setAdapter(r5);
    L17:
        VersionOperationRecordAdapter r7 = this.j;
        if (r7 == null) goto L20;
        r7.d = this;
    L20:
        EmptyView r8 = this.i;
        if (r8 == null) goto L23;
        r8.setOnRetryListener(new j(this));
    L23:
        SmartRefreshLayout r9 = this.g;
        if (r9 == null) goto L26;
        r9.W = new k(this);
    L26:
        if (r9 == null) goto L29;
        r9.i(new d75.l(this));
    L29:
        if (com.bytedance.ee.util.ui.b.a(this) == false) goto L39;
        ((DriveMGPermissionVM) new ViewModelProvider(this).get(DriveMGPermissionVM.class)).livePerm().observe(this, new d75.m(this));
        f75.a r10 = this.n;
        if (r10 == null) goto L37;
        MutableLiveData<VersionPayLoadData> r11 = r10.e;
        if (r11 == null) goto L38;
        r11.observe(this, new n(this));
        return;
    L38:
        return;
    L37:
        return;
    }

    @Override // com.bytedance.ee.bear.drive.biz.versions.Hilt_VersionOperationRecordV2Activity, com.bytedance.ee.bear.drive.common.mvpframeworks.app.activity.DriveAbsMvpActivity, com.bytedance.ee.bear.drive.common.mvpframeworks.app.activity.DriveAbsBaseActivity, com.bytedance.ee.bear.drive.common.mvpframeworks.app.activity.DriveRootActivity, com.bytedance.ee.bear.facade.common.BaseActivity, com.bytedance.ee.bear.facade.common.BaseCommonActivity, com.bytedance.ee.bear.facade.common.LifeCycleActivity
    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(VersionOperationRecordV2Activity.class.getName()));
    L5:
        super.onDestroy();
        f75.a r0 = this.n;
        if (r0 == null) goto L8;
        r0.b();
    L8:
        v55.c r1 = this.o;
        if (r1 == null) goto L12;
        r1.a();
        return;
    }

    @Override // d75.c
    public final void showLoading() {
        EmptyView r0 = this.i;
        if (r0 == null) goto L5;
        r0.setVisibility(0);
    L5:
        EmptyView r1 = this.i;
        if (r1 == null) goto L9;
        r1.showLoading();
        return;
    }

    @Override // com.bytedance.ee.bear.drive.common.mvpframeworks.app.activity.DriveAbsBaseActivity
    public final void bindViews() {
        this.f = findViewById(2131367579);
        this.g = findViewById(2131378171);
        this.h = findViewById(2131384025);
        this.i = (EmptyView) findViewById(2131378162);
    }

    public final UserSession e9() {
        return PassportcConvention.c(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ee.bear.drive.common.mvpframeworks.app.activity.DriveAbsBaseActivity
    public final void initData() {
        this.k = getIntent().getStringExtra("extra_obj_token");
        this.l = getIntent().getStringExtra("extra_launch_version");
        this.m = getIntent().getStringExtra("extra_launch_mountPoint");
        if (TextUtils.isEmpty(this.k) == false) goto L5;
        this.c = true;
        finish();
    L5:
        f75.a r0 = new f75.a(this.k);
        this.n = r0;
        r0.a();
        String r1 = this.k;
        if (r1 != null) goto L8;
        r1 = "";
    L8:
        this.o = new v55.c(r1, (DriveMGPermissionVM) new ViewModelProvider(this).get(DriveMGPermissionVM.class));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ee.bear.drive.common.mvpframeworks.app.activity.DriveAbsMvpActivity
    public final void onStop() {
        super.onStop();
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L14;
        View r0 = getWindow().getDecorView();     // Catch: Throwable -> L11
        if (com.larus.home.impl.utils.c.e == false) goto L9;
        FLogger.a.i("DecorViewLancet", "getDecorView");     // Catch: Throwable -> L11
        Thread r1 = ThreadMethodProxy.currentThread();     // Catch: Throwable -> L11
        if (r1 == com.larus.home.impl.utils.c.a) goto L9;
        com.larus.home.impl.utils.c.a(r1, "getDecorView");     // Catch: Throwable -> L11
    L9:
        r0.getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L11
        return;
    L15:
        return;
    }

    /* JADX INFO: renamed from: provideComponent, reason: collision with other method in class */
    public final /* bridge */ /* synthetic */ Object m324provideComponent() {
        return provideComponent();
    }

    public VersionOperationRecordV2Activity() {
    }

    @Override // com.bytedance.ee.bear.drive.common.mvpframeworks.app.activity.DriveAbsMvpActivity
    public final d G1(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        NetService r1 = this.p;
        if (r1 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("userNetService");
        r1 = null;
    L7:
        return new i(r3, r1);
    }

    @Override // d75.c
    public final void iG(Throwable r4) {
        Intrinsics.checkNotNullParameter(r4, "throwable");
        SmartRefreshLayout r5 = this.g;
        if (r5 == null) goto L5;
        r5.u(0, true, Boolean.FALSE);
    L5:
        EmptyView r6 = this.i;
        if (r6 == null) goto L8;
        r6.setVisibility(0);
    L8:
        EmptyView r7 = this.i;
        if (r7 == null) goto L12;
        r7.a();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ee.bear.drive.biz.versions.adapter.VersionOperationRecordAdapter.b
    public final void u(DriveVersionHistoryRecord.RecordBean r14) {
        Intrinsics.checkNotNullParameter(r14, "recordBean");
        long r0 = SystemClock.uptimeMillis();
        if ((r0 - this.q) >= 800) goto L5;
        boolean r1 = false;
    L7:
        if (r1 == true) goto L11;
        tt5.a.k("VersionOperationRecordActivity", "unValidClick in version item");
        return;
    L11:
        if (r14.isCipherDeleted() == false) goto L15;
        tt5.a.h("VersionOperationRecordActivity", "DriveVersionHistoryRecord click ignore, isCipherDeleted");
        return;
    L15:
        if (TextUtils.equals(this.l, r14.getVersion()) == false) goto L17;
        finish();
        return;
    L17:
        SpaceFileOpenEntity r2 = new SpaceFileOpenEntity(this.k, "");
        r2.setPreviewFrom("history");
        r2.setVersion(r14.getVersion());
        r2.setDataVersion(r14.getDataVersion());
        r2.setMountPoint(this.m);
        Bundle r3 = new Bundle();
        r3.putString("extra_history_date", zu5.a.b(this, r14.getEditTime()));
        r3.putBoolean("history", true);
        r2.setExtras(r3);
        ArrayList r9 = new ArrayList();
        r9.add(r2);
        ma5.a r11 = new ma5.a();
        r11.d = true;
        ((com.bytedance.ee.bear.i) org.koin.java.a.c(com.bytedance.ee.bear.i.class, null, null, 6)).f(this, r9, 0, r11, null);
        return;
    L5:
        this.q = r0;
        r1 = true;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // d75.c
    public final void q70(boolean r5, List<? extends DriveVersionHistoryRecord.RecordBean> r6, Map<String, ? extends DriveVersionHistoryRecord.UserBean> r7) {
        SmartRefreshLayout r0 = this.g;
        if (r0 == null) goto L6;
        r0.u(0, true, Boolean.FALSE);
    L6:
        if (CollectionUtils.isEmpty(r6) == false) goto L16;
        BaseTitleBar r8 = this.f;
        if (r8 == null) goto L10;
        r8.setDividerVisible(true);
    L10:
        EmptyView r9 = this.i;
        if (r9 == null) goto L13;
        r9.setVisibility(0);
    L13:
        EmptyView r10 = this.i;
        if (r10 == null) goto L34;
        r10.showNoContent();
    L34:
        SmartRefreshLayout r11 = this.g;
        if (r11 == null) goto L39;
        r11.g(r5);
        return;
    L39:
        return;
    L16:
        EmptyView r1 = this.i;
        if (r1 == null) goto L19;
        r1.setVisibility(4);
    L19:
        BaseTitleBar r2 = this.f;
        if (r2 == null) goto L22;
        r2.setDividerVisible(false);
    L22:
        VersionOperationRecordAdapter r3 = this.j;
        if (r3 == null) goto L34;
        if (CollectionUtils.isEmpty(r6) == true) goto L34;
        if (r7 == 0) goto L29;
        r3.c = r7;
    L29:
        ((ArrayList) r3.b).clear();
        ((ArrayList) r3.b).add(new com.bytedance.ee.bear.drive.biz.versions.model.a.C0160a());
        Iterator<? extends DriveVersionHistoryRecord.RecordBean> r12 = r6.iterator();
    L31:
        if (r12.hasNext() == false) goto L33;
        DriveVersionHistoryRecord.RecordBean r4 = r12.next();
        ((ArrayList) r3.b).add(new com.bytedance.ee.bear.drive.biz.versions.model.a.b(r4));
        goto L31
    L33:
        r3.e = ((DriveVersionHistoryRecord.RecordBean) ListProtector.get(r6, r6.size() - 1)).getEditTime();
        r3.notifyDataSetChanged();
        goto L34
    }

    @Override // d75.c
    public final void sp(boolean r5, List<? extends DriveVersionHistoryRecord.RecordBean> r6, Map<String, ? extends DriveVersionHistoryRecord.UserBean> r7) {
        SmartRefreshLayout r0 = this.g;
        if (r0 == null) goto L6;
        r0.b(0, false);
    L6:
        if (CollectionUtils.isEmpty(r6) == false) goto L8;
        return;
    L8:
        VersionOperationRecordAdapter r1 = this.j;
        if (r1 != null) goto L11;
    L20:
        SmartRefreshLayout r8 = this.g;
        if (r8 == null) goto L25;
        r8.g(r5);
        return;
    L25:
        return;
    L11:
        if (CollectionUtils.isEmpty(r6) == true) goto L20;
        if (r7 == null) goto L15;
        r1.c.putAll(r7);
    L15:
        Iterator<? extends DriveVersionHistoryRecord.RecordBean> r9 = r6.iterator();
    L17:
        if (r9.hasNext() == false) goto L19;
        DriveVersionHistoryRecord.RecordBean r2 = r9.next();
        ((ArrayList) r1.b).add(new com.bytedance.ee.bear.drive.biz.versions.model.a.b(r2));
        goto L17
    L19:
        r1.e = ((DriveVersionHistoryRecord.RecordBean) ListProtector.get(r6, r6.size() - 1)).getEditTime();
        r1.notifyDataSetChanged();
        goto L20
    }
}
