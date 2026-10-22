package com.bytedance.ee.bear.wikiv2.spacedetail;

import android.R;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.bytedance.ee.bear.wikiv2.common.widget.ExpandableTextView;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.convention.PassportcConvention;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Map;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class WikiSpaceDetailActivity extends b implements d0c.c {
    public static final /* synthetic */ int p = 0;
    public BaseTitleBar d;
    public ExpandableTextView e;
    public RecyclerView f;
    public WikiSpaceMemberAdapter g;
    public View h;
    public TextView i;
    public String j;
    public String k;
    public String l;
    public Disposable m;
    public i n;

    @Inject
    public NetService o;

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

    public final /* synthetic */ e0c.l provideComponent() {
        return d0c.b.b(this);
    }

    public final void C1() {
        i r0 = this.n;
        String r1 = this.j;
        NetService r2 = this.o;
        r0.getClass();
        NetService.d r3 = r2.Vc(new j());
        NetService.f r4 = new NetService.f("/space/api/wiki/v2/space/get_member/");
        ((NetService.e) r4).c = 2;
        r4.b("space_id", r1);
        this.m = r3.a(r4).map(new h()).subscribe(new e(this), new f(this));
    }

    /* JADX INFO: Removed unreachable split cross block B:53:0x0106 */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ee.bear.wikiv2.spacedetail.b
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

    @Override // com.bytedance.ee.bear.wikiv2.spacedetail.b
    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(getClass().getName()));
    L5:
        Disposable r0 = this.m;
        if (r0 == null) goto L8;
        r0.dispose();
    L8:
        super.onDestroy();
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
    public final /* bridge */ /* synthetic */ Object m688provideComponent() {
        return provideComponent();
    }

    public WikiSpaceDetailActivity() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void B1(Bundle r4) {
        if (getIntent() != null) goto L5;
        tt5.a.d("WikiSpaceDetailActivity", "getIntent is null");
        finish();
    L6:
        setContentView(2131568255);
        this.n = new i();
        this.d = (BaseTitleBar) findViewById(2131393263);
        this.e = (ExpandableTextView) findViewById(2131371899);
        this.f = findViewById(2131393235);
        this.i = (TextView) findViewById(2131390931);
        this.h = findViewById(2131377538);
        this.g = new WikiSpaceMemberAdapter(this);
        this.f.setLayoutManager(new LinearLayoutManager(this));
        this.f.setAdapter(this.g);
        WikiSpaceMemberAdapter r5 = this.g;
        ArrayList r0 = new ArrayList();
        int r1 = 0;
    L8:
        if (r1 >= 10) goto L10;
        r0.add(new SpaceBean.MembersBean());
        r1 = r1 + 1;
        goto L8
    L10:
        r5.a = r0;
        r5.c = true;
        this.g.notifyDataSetChanged();
        WikiSpaceMemberAdapter r6 = this.g;
        r6.d = new c(this);
        this.h.setOnClickListener(new d(this));
        this.d.setTitle(2131888350);
        String r7 = this.k;
        if (TextUtils.isEmpty(r7) == true) goto L13;
        this.e.setText(r7);
    L14:
        C1();
        return;
    L13:
        this.e.setText(getResources().getString(2131888345));
        goto L14
    L5:
        this.j = getIntent().getStringExtra("space_id");
        this.k = getIntent().getStringExtra("EXTRA_WIKI_DESCRIPTION");
        this.l = getIntent().getStringExtra("node_name");
        goto L6
    }
}
