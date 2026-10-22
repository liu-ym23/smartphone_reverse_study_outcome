package com.bytedance.ee.bear.wikiv2.wikitreev2;

import android.R;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import com.bytedance.ee.bear.facade.common.BaseActivity;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.bear.wikiv2.wikitreev2.create.WikiCreateToFragment;
import com.bytedance.ee.bear.wikiv2.wikitreev2.main.WikiTreeFragment;
import com.bytedance.ee.bear.wikiv2.wikitreev2.makecopy.WikiMakeCopyFragment;
import com.bytedance.ee.bear.wikiv2.wikitreev2.move.WikiMovToFragment;
import com.bytedance.ee.bear.wikiv2.wikitreev2.shortcut.WikiShortcutToFragment;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.insets.WindowInsetsUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0016\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0014J\u0012\u0010\r\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0014J\u0010\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0012\u0010\u0011\u001a\u00020\n2\b\u0010\u0012\u001a\u0004\u0018\u00010\fH\u0002J\u0017\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0002¢\u0006\u0002\u0010\u0017J\"\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u00162\b\u0010\u001b\u001a\u0004\u0018\u00010\u000fH\u0014J\"\u0010\u001c\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u00162\b\u0010\u001b\u001a\u0004\u0018\u00010\u000fH\u0002R\u0016\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/wikitreev2/WikiTreeActivity;", "Lcom/bytedance/ee/bear/facade/common/BaseActivity;", "<init>", "()V", "contractName", "", "kotlin.jvm.PlatformType", "contract", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/WikiTreeActivityContract;", "onDoCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onNewIntent", "intent", "Landroid/content/Intent;", "init", "setupContent", "extra", "provideTypeFragment", "Landroidx/fragment/app/Fragment;", "mode", "", "(Ljava/lang/Integer;)Landroidx/fragment/app/Fragment;", "onActivityResult", "requestCode", "resultCode", WikiFolderPushPlugin.DATA, "fragmentActivityResult", "Companion", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class WikiTreeActivity extends BaseActivity {
    public final String c;
    public WikiTreeActivityContract d;

    public static final class a {
    }

    static {
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

    public WikiTreeActivity() {
        this.c = WikiTreeActivityContract.class.getName();
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

    /* JADX WARN: Multi-variable type inference failed */
    public final void B1(Bundle r2) {
        setContentView(2131568265);
        if (r2 != null) goto L6;
        C1(getIntent());
    L6:
        if (com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.mobile.wiki_tree_consume_status_bar") == false) goto L9;
        WindowInsetsUtils.c(this).c(false);
        return;
    }

    public final void C1(Intent r7) {
        WikiTreeActivityContract r0 = (WikiTreeActivityContract) r7.getParcelableExtra(this.c);
        if (r0 != null) goto L6;
        tt5.a.k("Wiki_WikiTreeActivity", "init. invalid contract! return. ");
        finish();
        return;
    L6:
        this.d = r0;
        StringBuilder r1 = new StringBuilder("init. mode: ");
        WikiTreeActivityContract r2 = this.d;
        WikiTreeActivityContract r4 = null;
        if (r2 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("contract");
        r2 = null;
    L9:
        r1.append(r2.getPageMode());
        tt5.a.h("Wiki_WikiTreeActivity", r1.toString());
        Long r3 = gq5.b.a;
        gq5.b.a = Long.valueOf(System.currentTimeMillis());
        Bundle r8 = r7.getExtras();
        WikiTreeActivityContract r5 = this.d;
        if (r5 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("contract");
        r5 = null;
    L12:
        Integer r6 = Integer.valueOf(r5.getPageMode());
        if (r6 != null) goto L16;
    L18:
        if (r6 != null) goto L21;
    L23:
        if (r6 != null) goto L26;
    L28:
        if (r6 != null) goto L31;
    L33:
        Fragment r9 = new WikiTreeFragment();
    L34:
        Bundle r10 = new Bundle();
        String r11 = this.c;
        WikiTreeActivityContract r12 = this.d;
        if (r12 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("contract");
    L38:
        r10.putParcelable(r11, r4);
        if (r8 == null) goto L41;
        r10.putAll(r8);
    L41:
        r9.setArguments(r10);
        FragmentTransaction r13 = getSupportFragmentManager().beginTransaction();
        String r14 = r9.getClass().getSimpleName();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r13, r9, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, r14, 2131393266) == true) goto L45;
        r13 = r13.replace(2131393266, r9, r14);
    L45:
        r13.commitAllowingStateLoss();
        return;
    L37:
        r4 = r12;
        goto L38
    L31:
        if (r6.intValue() != 4) goto L33;
        r9 = new WikiMakeCopyFragment();
        goto L34
    L26:
        if (r6.intValue() != 3) goto L28;
        r9 = new WikiShortcutToFragment();
        goto L34
    L21:
        if (r6.intValue() != 2) goto L23;
        r9 = new WikiMovToFragment();
        goto L34
    L16:
        if (r6.intValue() != 1) goto L18;
        r9 = new WikiCreateToFragment();
        goto L34
    }

    public final void onNewIntent(Intent r1) {
        super/*androidx.fragment.app.FragmentActivity*/.onNewIntent(r1);
        if (r1 == null) goto L6;
        C1(r1);
        return;
    }

    public final void onActivityResult(int r3, int r4, Intent r5) {
        super/*com.bytedance.ee.bear.facade.common.BaseCommonActivity*/.onActivityResult(r3, r4, r5);
        Iterator r0 = getSupportFragmentManager().getFragments().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((Fragment) r0.next()).onActivityResult(r3, r4, r5);
        goto L4
    }
}
