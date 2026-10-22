package com.bytedance.ee.bear.wikiv2.selector;

import android.R;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import com.bytedance.ee.bear.facade.common.BaseActivity;
import com.bytedance.ee.bear.list.dto.FolderVersion;
import com.bytedance.ee.bear.list.selector.SelectorConfig;
import com.bytedance.ee.bear.list.selector.SelectorScope;
import com.bytedance.ee.bear.list.selector.SelectorType;
import com.bytedance.ee.bear.search.SelectFolderConfig;
import com.bytedance.ee.bear.search.SelectPickerConfig;
import com.bytedance.ee.bear.search.SelectTabConfig;
import com.bytedance.ee.bear.search.SelectTitleConfig;
import com.bytedance.ee.bear.search.SelectWikiConfig;
import com.bytedance.ee.bear.search.picker.filter.folder.SearchFolderFragment;
import com.bytedance.ee.bear.search.picker.filter.wiki.WikiSearchPickerFragment;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.bear.wikiv2.home.viewall_multitab.WikiSpaceTabFragment;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.passportc.convention.PassportcConvention;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.picker.statistics.PickerStatistics;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 +2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001+B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0014J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u000bH\u0002J\b\u0010\u0011\u001a\u00020\u000bH\u0002J\b\u0010\u0012\u001a\u00020\u000bH\u0002J\b\u0010\u0013\u001a\u00020\u000bH\u0002J\b\u0010\u0014\u001a\u00020\u000bH\u0016J\b\u0010\u0015\u001a\u00020\u000bH\u0016J\u0010\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u000bH\u0016J\b\u0010\u0019\u001a\u00020\u000bH\u0016J\u0010\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u001eH\u0002J\b\u0010\u001f\u001a\u00020\u000bH\u0016J\b\u0010 \u001a\u00020\u000bH\u0016J\u0010\u0010!\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020#H\u0002J\"\u0010$\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020\u001e2\u0006\u0010&\u001a\u00020\u001e2\b\u0010\u0016\u001a\u0004\u0018\u00010'H\u0014J\"\u0010(\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020\u001e2\u0006\u0010&\u001a\u00020\u001e2\b\u0010\u0016\u001a\u0004\u0018\u00010'H\u0002J\b\u0010)\u001a\u00020\u000bH\u0016J\b\u0010*\u001a\u00020\u000bH\u0014R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/selector/SelectorActivity;", "Lcom/bytedance/ee/bear/facade/common/BaseActivity;", "Lcom/bytedance/ee/bear/wikiv2/searchv2/IOpenPageSelectTrigger;", "Lcom/ss/android/lark/passportc/convention/view/UserScopeView;", "<init>", "()V", "selectorConfig", "Lcom/bytedance/ee/bear/list/selector/SelectorConfig;", "isShortCut", "", "onDoCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "provideUserSession", "Lcom/ss/android/lark/passportc/entity/UserSession;", "initData", "initFragment", "showRootSelectFragment", "showWikiDirect", "openMyLibrary", "openWiki", WikiFolderPushPlugin.DATA, "Lcom/bytedance/ee/bear/wikiv2/searchv2/WikiTreeNavigationData;", "openMySpace", "openSharedSpace", "openFolder", "bean", "Lcom/bytedance/ee/bear/list/selector/OpenFolderBean;", "getOwnerType", "", "openAllSearch", "openSpaceSearch", "commitFragment", "fragment", "Landroidx/fragment/app/Fragment;", "onActivityResult", "requestCode", "resultCode", "Landroid/content/Intent;", "fragmentActivityResult", "onBackPressed", "onDestroy", "Companion", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SelectorActivity extends BaseActivity implements com.bytedance.ee.bear.wikiv2.searchv2.a, d0c.c {
    public SelectorConfig c;
    public boolean d;

    public static final class a {
    }

    static {
    }

    public final void afterUserOffline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final void afterUserOnline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    @Override // com.bytedance.ee.bear.wikiv2.searchv2.a
    public final void back() {
    }

    public final /* synthetic */ Object generatedComponent() {
        return DwarfComponentProvider.-CC.$default$generatedComponent(this);
    }

    public final /* synthetic */ com.ss.android.lark.passportc.api.m getPassport() {
        return d0c.b.a(this);
    }

    public final void onUserOffline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final void onUserOnline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final /* synthetic */ e0c.l provideComponent() {
        return d0c.b.b(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ee.bear.wikiv2.searchv2.a
    public final void DR() {
        tt5.a.h("SelectorActivity", "openAllSearch()...");
        SelectorConfig r0 = this.c;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("selectorConfig");
        r0 = null;
    L6:
        if (r0.f != SelectorScope.SPACE_ONLY) goto L8;
        vZ();
        return;
    L8:
        String r1 = getString(2131887821);
        SelectorConfig r3 = this.c;
        if (r3 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("selectorConfig");
        r3 = null;
    L12:
        if (r3.a == SelectorType.WIKI_MOVE_TO) goto L14;
    L16:
        boolean r6 = true;
    L17:
        SelectTabConfig r14 = new SelectTabConfig(r6, false, false, 6, null);
        SelectTitleConfig r13 = new SelectTitleConfig(true, r1);
        SelectPickerConfig r2 = new SelectPickerConfig(PickerStatistics.Scene.CcmSearchInWikiAndFolder, false, false, false, new SelectWikiConfig(true), r13, r14);
        Bundle r4 = getIntent().getExtras();
        if (r4 == null) goto L20;
        r4.putSerializable("KEY_PICKER_CONFIG", r2);
    L20:
        WikiSearchPickerFragment r5 = ((com.bytedance.ee.bear.search.b) org.koin.java.a.c(com.bytedance.ee.bear.search.b.class, null, null, 6)).c(this, r4);
        Intrinsics.checkNotNull(r5);
        C1(r5);
        return;
    L14:
        if (this.d == false) goto L16;
        r6 = false;
        goto L17
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ee.bear.wikiv2.searchv2.a
    public final void E5() {
        tt5.a.h("SelectorActivity", "openMySpace()...");
        int r1 = jq5.a.a;
        if (qc5.a.h() == false) goto L5;
        int r2 = 2131887934;
    L6:
        String r5 = getString(r2);
        int r7 = FolderSource.MY_SPACE.getSource();
        qc5.a.j();
        FolderVersion.Companion.getClass();
        j7(new td5.e(4, "", r5, false, r7, 5, false));
        return;
    L5:
        r2 = 2131887935;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ee.bear.wikiv2.searchv2.a
    public final void U5() {
        tt5.a.h("SelectorActivity", "openMyLibrary()...");
        Intent r0 = getIntent();
        if (r0 == null) goto L5;
        Bundle r1 = r0.getExtras();
    L6:
        SelectorConfig r2 = this.c;
        if (r2 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("selectorConfig");
        r2 = null;
    L9:
        com.bytedance.ee.bear.wikiv2.wikitreev2.j.a(this, r1, r2.g, new ce5.a(this), null);
        return;
    L5:
        r1 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ee.bear.wikiv2.searchv2.a
    public final void V6() {
        tt5.a.h("SelectorActivity", "openWiki()...");
        WikiSpaceTabFragment r0 = new WikiSpaceTabFragment();
        r0.setArguments(getIntent().getExtras());
        C1(r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ee.bear.wikiv2.searchv2.a
    public final void Z3() {
        tt5.a.h("SelectorActivity", "openSharedSpace()...");
        String r5 = getString(jq5.a.a());
        int r7 = FolderSource.SHARED_SPACE.getSource();
        qc5.a.j();
        FolderVersion.Companion.getClass();
        j7(new td5.e(6, "", r5, true, r7, 5, false));
    }

    /* JADX INFO: Removed unreachable split cross block B:51:0x0104 */
    /* JADX WARN: Multi-variable type inference failed */
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(SelectorActivity.class.getName()));
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

    public final void onBackPressed() {
        tt5.a.h("SelectorActivity", "onBackPressed()...");
        if (getSupportFragmentManager().getBackStackEntryCount() < 1) goto L6;
        getSupportFragmentManager().popBackStack();
        return;
    L6:
        super/*com.bytedance.ee.bear.facade.common.BaseCommonActivity*/.onBackPressed();
    }

    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(SelectorActivity.class.getName()));
    L5:
        super.onDestroy();
        SelectorConfig.CREATOR.getClass();
        SelectorConfig.k = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ee.bear.wikiv2.searchv2.a
    public final void vZ() {
        tt5.a.h("SelectorActivity", "openSpaceSearch()...");
        String r4 = getString(2131887826);
        SelectFolderConfig r0 = new SelectFolderConfig(PickerStatistics.Scene.CcmSearchFolder, false, r4, false, false, 16, null);
        SearchFolderFragment r1 = ((com.bytedance.ee.bear.search.b) org.koin.java.a.c(com.bytedance.ee.bear.search.b.class, null, null, 6)).b(this, r0);
        Intrinsics.checkNotNull(r1);
        C1(r1);
    }

    public final UserSession e9() {
        return PassportcConvention.c(this);
    L5:
        return new ce5.a().b;
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
    public final /* bridge */ /* synthetic */ Object m684provideComponent() {
        return provideComponent();
    }

    public SelectorActivity() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void B1(Bundle r6) {
        Intent r7 = getIntent();
        if (r7 == null) goto L5;
        Bundle r8 = r7.getExtras();
    L7:
        if (r8 != null) goto L9;
        tt5.a.h("SelectorActivity", "bundle is null.");
        finish();
    L9:
        if (r8 == null) goto L12;
        SelectorConfig r9 = (SelectorConfig) r8.getParcelable("extra_config");
        if (r9 == null) goto L12;
    L13:
        this.c = r9;
        Bundle r10 = getIntent().getExtras();
        boolean r2 = false;
        if (r10 == null) goto L16;
        boolean r11 = r10.getBoolean("src_is_shortcut");
    L17:
        this.d = r11;
        StringBuilder r12 = new StringBuilder("initFragment()...selectorConfig = ");
        SelectorConfig r3 = this.c;
        if (r3 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("selectorConfig");
        r3 = null;
    L20:
        r12.append(r3);
        tt5.a.h("SelectorActivity", r12.toString());
        if (qc5.a.c() == false) goto L23;
    L24:
        String r13 = dq5.j.a(new ce5.a(this));
        if (r13 != null) goto L27;
    L30:
        boolean r14 = true;
    L31:
        if (r14 == true) goto L33;
        r2 = true;
    L33:
        SelectorConfig r15 = this.c;
        if (r15 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("selectorConfig");
        r15 = null;
    L37:
        if (r15.f != SelectorScope.WIKI_ONLY) goto L44;
        if (r2 == true) goto L44;
        tt5.a.h("SelectorActivity", "showWikiDirect()...");
        WikiSpaceTabFragment r16 = new WikiSpaceTabFragment();
        r16.setArguments(getIntent().getExtras());
        FragmentTransaction r0 = getSupportFragmentManager().beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r0, r16, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, "WikiSpaceTabFragment", R.id.content) == true) goto L43;
        r0 = r0.replace(R.id.content, r16, "WikiSpaceTabFragment");
    L43:
        r0.commitAllowingStateLoss();
        return;
    L44:
        tt5.a.h("SelectorActivity", "showRootSelectFragment()...");
        FragmentManager r17 = getSupportFragmentManager();
        FragmentTransaction r1 = getSupportFragmentManager().beginTransaction();
        int r4 = RootSelectFragment.m;
        Intent r5 = getIntent();
        if (r5 == null) goto L47;
        Bundle r18 = r5.getExtras();
    L48:
        Fragment r19 = RootSelectFragment.a.a(r17, this, r18);
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r1, r19, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, null, R.id.content) == true) goto L52;
        r1 = r1.add(R.id.content, r19);
    L52:
        r1.commitAllowingStateLoss();
        return;
    L47:
        r18 = null;
        goto L48
    L27:
        if (r13.length() == 0) goto L30;
        r14 = false;
        goto L31
    L23:
        if (qc5.a.h() == false) goto L33;
    L16:
        r11 = false;
    L12:
        r9 = new SelectorConfig();
        goto L13
    L5:
        r8 = null;
        goto L7
    }

    public final void C1(Fragment r6) {
        FragmentTransaction r0 = getSupportFragmentManager().beginTransaction().setCustomAnimations(2130772290, 2130772289, 2130772288, 2130772293);
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r0, r6, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, null, R.id.content) == true) goto L6;
        r0 = r0.add(R.id.content, r6);
    L6:
        r0.addToBackStack(null).commitAllowingStateLoss();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ee.bear.wikiv2.searchv2.a
    public final void Ct(com.bytedance.ee.bear.wikiv2.searchv2.c r9) {
        Intrinsics.checkNotNullParameter(r9, WikiFolderPushPlugin.DATA);
        SelectorConfig r1 = null;
        com.bytedance.ee.bear.contract.route.parcelable.f r2 = (com.bytedance.ee.bear.contract.route.parcelable.f) org.koin.java.a.c(com.bytedance.ee.bear.contract.route.parcelable.f.class, null, null, 6);
        Intent r0 = getIntent();
        if (r0 == null) goto L5;
        Bundle r5 = r0.getExtras();
    L6:
        SelectorConfig r3 = this.c;
        if (r3 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("selectorConfig");
    L10:
        r2.b(this, r9, r5, r1.g, null);
        return;
    L9:
        r1 = r3;
        goto L10
    L5:
        r5 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ee.bear.wikiv2.searchv2.a
    public final void j7(td5.e r14) {
        Intrinsics.checkNotNullParameter(r14, "bean");
        tt5.a.h("SelectorActivity", "openFolder()...folderType = " + r14 + ".folderType, isShareFolder = " + r14 + ".isShareFolder, ownerType = " + r14 + ".ownerType");
        int r0 = FolderSelectFragment.s;
        C1(FolderSelectFragment.a.a(getSupportFragmentManager(), this, r14.a, r14.b, r14.c, r14.f, r14.d, r14.g, r14.e, getIntent().getBooleanExtra("extra_is_at_vc", false), getIntent().getExtras(), r14.h));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onActivityResult(int r4, int r5, Intent r6) {
        super/*com.bytedance.ee.bear.facade.common.BaseCommonActivity*/.onActivityResult(r4, r5, r6);
        tt5.a.h("SelectorActivity", "onActivityResult()...requestCode = " + r4 + ", resultCode = " + r5);
        Iterator r0 = getSupportFragmentManager().getFragments().iterator();
    L4:
        if (r0.hasNext() == false) goto L7;
        ((Fragment) r0.next()).onActivityResult(r4, r5, r6);
        goto L4
    L7:
        if (r4 != 1024) goto L9;
    L14:
        if (r5 != (-1)) goto L16;
    L41:
        setResult(r5, r6);
        finish();
        return;
    L16:
        if (r5 == 100) goto L41;
    L18:
        if (r5 == 101) goto L41;
        if (r4 != 1025) goto L23;
    L39:
        if (r5 != (-1)) goto L47;
        setResult(r5, r6);
        finish();
        return;
    L47:
        return;
    L23:
        if (r4 == 2025) goto L39;
        if (r4 == 4025) goto L39;
        if (r4 == 1026) goto L39;
        if (r4 == 2026) goto L39;
        if (r4 == 4026) goto L39;
        if (r4 == 3026) goto L39;
        if (r4 != 1033) goto L44;
        if (r5 != 101) goto L45;
        finish();
        return;
    L45:
        return;
    L44:
        return;
    L9:
        if (r4 == 3025) goto L14;
        if (r4 == 1029) goto L14;
        if (r4 != 1031) goto L18;
        goto L14
    }
}
