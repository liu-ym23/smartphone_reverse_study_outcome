package com.bytedance.ee.bear.list.folder;

import android.R;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import com.bytedance.ee.bear.facade.common.BaseActivity;
import com.bytedance.ee.bear.list.dto.FolderVersion;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.convention.PassportcConvention;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import e0c.l;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class FolderListActivity extends BaseActivity implements FolderRouteFragment.b, d0c.c {
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public int j;
    public String k;
    public int l;
    public int m;
    public boolean n;
    public boolean o;
    public Fragment p;

    public final void afterUserOffline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final void afterUserOnline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final /* synthetic */ Object generatedComponent() {
        return DwarfComponentProvider.-CC.$default$generatedComponent(this);
    }

    public final /* synthetic */ m getPassport() {
        return d0c.b.a(this);
    }

    public final void onUserOffline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final void onUserOnline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final /* synthetic */ l provideComponent() {
        return d0c.b.b(this);
    }

    /* JADX INFO: Removed unreachable split cross block B:53:0x0106 */
    /* JADX WARN: Multi-variable type inference failed */
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(getClass().getName()));
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
    L50:
        return;
    L16:
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L19;
        r2.i("ActivityLancet", "quit !resume, current state = " + getLifecycle().getCurrentState());     // Catch: Throwable -> L42
        goto L50
    L19:
        if (isFinishing() == true) goto L22;
        r2.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L42
        goto L50
    L22:
        if (ActivityStartBehavior.isInternalActivityConsumed(this) == true) goto L25;
        r2.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L42
        goto L50
    L25:
        if (ActivityLancet.isOnlyActivityInTask(this) == true) goto L28;
        r2.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L42
        goto L50
    L28:
        if (ActivityLancet.isExcludedActivity(this) == false) goto L31;
        r2.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L42
        goto L50
    L31:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L33;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L42
        goto L50
    L33:
        Intent r1 = getPackageManager().getLaunchIntentForPackage(getPackageName());     // Catch: Throwable -> L42
        if (r1 == null) goto L50;
        r1.addFlags(268435456);     // Catch: Throwable -> L42
        r1.addFlags(2097152);     // Catch: Throwable -> L42
        r2.i("ActivityLancet", "start launcher intent after backPressed, activity=" + this);     // Catch: Throwable -> L42
        startActivity(r1);     // Catch: Throwable -> L39
        overridePendingTransition(R.anim.fade_in, R.anim.slide_out_right);     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L42
        goto L50
    L10:
        if ((r3 - r6.longValue()) >= 800) goto L13;
        monitor-exit(r5);     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        throw th;
    }

    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(getClass().getName()));
    L5:
        super.onDestroy();
    }

    public final UserSession e9() {
        return PassportcConvention.c(this);
    }

    public final void onResume() {
        super/*androidx.fragment.app.FragmentActivity*/.onResume();
        if (TextUtils.isEmpty(this.c) == true) goto L6;
        lc5.f.h(this.c);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onStop() {
        super/*androidx.appcompat.app.AppCompatActivity*/.onStop();
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
    public final /* bridge */ /* synthetic */ Object m12provideComponent() {
        return provideComponent();
    }

    public FolderListActivity() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void A1(Bundle r5) {
        super/*com.bytedance.ee.bear.facade.common.BaseCommonActivity*/.A1(r5);
        getWindow().setBackgroundDrawable(new ColorDrawable(ResourcesCompat.getColor(getResources(), 2131100548, null)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void B1(Bundle r15) {
        Intent r16 = getIntent();
        this.c = r16.getStringExtra(ResourceData.KEY_TOKEN);
        this.d = r16.getStringExtra(ResourceData.KEY_URL);
        this.e = r16.getStringExtra("title");
        this.f = r16.getStringExtra("parent_space_id");
        this.h = r16.getStringExtra("current_module");
        this.i = r16.getStringExtra("source");
        this.j = r16.getIntExtra("depth", 0);
        this.k = r16.getStringExtra(ResourceData.KEY_TYPE);
        this.m = r16.getIntExtra("owner_type", 0);
        this.l = r16.getIntExtra("permission", 2);
        this.n = r16.getBooleanExtra("is_external", false);
        this.o = r16.getBooleanExtra("is_personal_folder", false);
        this.g = r16.getStringExtra("parent_token");
        if (r16.getBooleanExtra("open_route", false) == false) goto L9;
        Bundle r17 = new Bundle();
        r17.putString(ResourceData.KEY_URL, this.d);
        r17.putString(ResourceData.KEY_TOKEN, this.c);
        Fragment r18 = Fragment.instantiate(this, FolderRouteFragment.class.getName(), r17);
        FragmentTransaction r0 = getSupportFragmentManager().beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r0, r18, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, R.id.content) == true) goto L8;
        r0 = r0.replace(R.id.content, r18);
    L8:
        r0.commitAllowingStateLoss();
        return;
    L9:
        Bundle r19 = new Bundle();
        r19.putString(ResourceData.KEY_TOKEN, this.c);
        r19.putString("title", this.e);
        r19.putString("parent_space_id", this.f);
        r19.putString("current_module", this.h);
        r19.putString("source", this.i);
        r19.putInt("depth", this.j);
        r19.putString(ResourceData.KEY_TYPE, this.k);
        r19.putInt("permission", this.l);
        r19.putBoolean("is_external", this.n);
        r19.putBoolean("is_personal_folder", this.o);
        r19.putString("parent_token", this.g);
        C1(r19, this.m);
    }

    @Override // com.bytedance.ee.bear.list.folder.FolderRouteFragment.b
    public final void lc(int r4) {
        Bundle r0 = new Bundle();
        r0.putString(ResourceData.KEY_TOKEN, this.c);
        r0.putString(ResourceData.KEY_URL, this.d);
        C1(r0, r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void C1(Bundle r4, int r5) {
        if (FolderVersion.isShareFolderV2(Integer.valueOf(r5)) == false) goto L5;
        String r6 = SubFolderFragment.class.getName();
    L6:
        tt5.a.h("FolderListActivity", "initFragment()...fragmentName = ".concat(r6));
        this.p = Fragment.instantiate(this, r6, r4);
        FragmentTransaction r7 = getSupportFragmentManager().beginTransaction();
        Fragment r8 = this.p;
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r7, r8, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, R.id.content) == true) goto L10;
        r7 = r7.replace(R.id.content, r8);
    L10:
        r7.commitAllowingStateLoss();
        return;
    L5:
        r6 = FolderDetailFragment.class.getName();
        goto L6
    }

    public final void onActivityResult(int r2, int r3, Intent r4) {
        super/*com.bytedance.ee.bear.facade.common.BaseCommonActivity*/.onActivityResult(r2, r3, r4);
        Fragment r0 = this.p;
        if (r0 == null) goto L6;
        r0.onActivityResult(r2, r3, r4);
        return;
    }
}
