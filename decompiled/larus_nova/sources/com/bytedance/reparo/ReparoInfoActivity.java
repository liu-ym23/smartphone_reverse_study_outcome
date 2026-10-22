package com.bytedance.reparo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.bytedance.mira.core.opt.res.NewMiraResourcesManager;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.reparo.core.l;
import com.bytedance.reparo.core.o;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.nova.R;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes21.dex */
public class ReparoInfoActivity extends Activity implements l.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f267296a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<d97.d> f267297b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Handler f267298c;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            g.a().f();
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            e r101 = g.a().f267443b;
            if (r101.f267432f == false) goto L7;
            com.bytedance.reparo.d r102 = r101.f267429c;
            r102.getClass();
            w87.b.delete(new PolarisFileWrapper(r102.f267425a.getFilesDir(), "reparo-root"));
            o r103 = o.c();
            if (r103.f267413c == false) goto L7;
            r103.f267414d.b(true);
        L7:
            System.exit(0);
        }
    }

    public class c extends BaseAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ReparoInfoActivity f267299a;

        @Override // android.widget.Adapter
        public final long getItemId(int r100) {
            return r100;
        }

        @Override // android.widget.Adapter
        public final int getCount() {
            return this.f267299a.f267297b.size();
        }

        public c(ReparoInfoActivity r100) {
            this.f267299a = r100;
        }

        @Override // android.widget.Adapter
        public final Object getItem(int r100) {
            return ListProtector.get(this.f267299a.f267297b, r100);
        }

        @Override // android.widget.Adapter
        public final View getView(int r100, View r101, ViewGroup r102) {
            if (r101 == null) goto L4;
            d r103 = (d) r101.getTag();
        L5:
            c97.h r104 = ((d97.d) ListProtector.get(this.f267299a.f267297b, r100)).f467633c;
            r103.f267300a.setText(r104.f22890j);
            r103.f267301b.setText(r104.f22889i);
            TextView r105 = r103.f267302c;
            File r106 = r104.f22881a;
            if (r106 != null) goto L8;
            String r107 = "";
        L9:
            r105.setText(r107);
            return r101;
        L8:
            r107 = r106.getAbsolutePath();
            goto L9
        L4:
            r101 = this.f267299a.getLayoutInflater().inflate(R.layout.reparo_info_item, r102, false);
            r103 = new d();
            r101.setTag(r103);
            r103.f267300a = (TextView) r101.findViewById(R.id.reparo_patch_id);
            r103.f267301b = (TextView) r101.findViewById(R.id.reparo_patch_version);
            r103.f267302c = (TextView) r101.findViewById(R.id.reparo_patch_install_dir);
            goto L5
        }
    }

    public class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public TextView f267300a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public TextView f267301b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public TextView f267302c;

        public d() {
        }
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public final void attachBaseContext(Context r100) {
        super.attachBaseContext(r100);
        NewMiraResourcesManager.getInstance().installActivity(this);
    }

    @Override // com.bytedance.reparo.core.l.d
    public final void onChanged() {
        this.f267298c.post(new h(this));
    }

    public ReparoInfoActivity() {
        this.f267297b = new ArrayList();
        this.f267298c = new Handler();
    }

    /* JADX INFO: Removed unreachable split cross block B:54:0x0114 */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.app.Activity
    public final void finish() {
        super.finish();
        if ((this instanceof FragmentActivity) == true) goto L6;
        return;
    L6:
        if ((this instanceof ChatWindowActivity) == true) goto L59;
        FLogger r100 = FLogger.f375446a;
        r100.i("ActivityLancet", "finish ".concat(getClass().getName()));
        long r101 = SystemClock.uptimeMillis();
        Map<Activity, Long> r102 = ActivityLancet.LAST_FINISH_HANDLED_MS;
        monitor-enter(r102);
        Long r103 = r102.get(this);     // Catch: Throwable -> L48
        if (r103 != null) goto L13;
    L16:
        r102.put(this, Long.valueOf(r101));     // Catch: Throwable -> L48
        monitor-exit(r102);     // Catch: Throwable -> L48
    L45:
        th = move-exception;
        FLogger.f375446a.e("ActivityLancet", "handle onBackPressed strategy failed", th);
    L51:
        return;
    L19:
        if (((FragmentActivity) this).getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L22;
        r100.i("ActivityLancet", "quit !resume, current state = " + ((FragmentActivity) this).getLifecycle().getCurrentState());     // Catch: Throwable -> L45
        goto L51
    L22:
        if (isFinishing() == true) goto L25;
        r100.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L45
        goto L51
    L25:
        if (ActivityStartBehavior.isInternalActivityConsumed(this) == true) goto L28;
        r100.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L45
        goto L51
    L28:
        if (ActivityLancet.isOnlyActivityInTask(this) == true) goto L31;
        r100.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L45
        goto L51
    L31:
        if (ActivityLancet.isExcludedActivity(this) == false) goto L34;
        r100.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L45
        goto L51
    L34:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L36;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L45
        goto L51
    L36:
        Intent r104 = getPackageManager().getLaunchIntentForPackage(getPackageName());     // Catch: Throwable -> L45
        if (r104 == null) goto L51;
        r104.addFlags(268435456);     // Catch: Throwable -> L45
        r104.addFlags(2097152);     // Catch: Throwable -> L45
        r100.i("ActivityLancet", "start launcher intent after backPressed, activity=" + this);     // Catch: Throwable -> L45
        startActivity(r104);     // Catch: Throwable -> L42
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.slide_out_right);     // Catch: Throwable -> L42
    L42:
        th = move-exception;
        FLogger.f375446a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L45
        goto L51
    L13:
        if ((r101 - r103.longValue()) >= 800) goto L16;
        monitor-exit(r102);     // Catch: Throwable -> L48
    L48:
        th = move-exception;
        throw th;
    }

    @Override // android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        g r100 = g.a();
        if (r100.f267447f == true) goto L5;
    L7:
        boolean r101 = false;
    L8:
        if (r101 == false) goto L15;
        o r102 = o.c();
        r102.a();
        l r103 = r102.f267414d;
        List<l.d> r104 = r103.f267388g;
        if (r104 != null) goto L12;
        return;
    L12:
        if (((ArrayList) r104).contains(this) == false) goto L17;
        ((ArrayList) r103.f267388g).remove(this);
        return;
    L17:
        return;
    L15:
        return;
    L5:
        if (r100.f267443b.f267432f == false) goto L7;
        r101 = true;
        goto L8
    }

    @Override // android.app.Activity
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

    @Override // android.app.Activity
    public final void onCreate(Bundle r100) {
        if (z2.f365865a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(getTheme());     // Catch: Throwable -> L18
    L6:
        if (v19.f.f(this) == false) goto L8;
        v19.f.c(getTheme());     // Catch: Throwable -> L18
    L8:
        super.onCreate(r100);
        setContentView(R.layout.reparo_info);
        g r101 = g.a();
        if (r101.f267447f == true) goto L11;
    L13:
        boolean r102 = false;
    L14:
        if (r102 == true) goto L16;
        findViewById(R.id.reparo_error_msg).setVisibility(0);
        findViewById(R.id.reparo_info_container).setVisibility(8);
        return;
    L16:
        Map<c97.h, d97.d> r103 = o.c().e();
        o.c().f(this);
        this.f267297b.clear();
        this.f267297b.addAll(((ConcurrentHashMap) r103).values());
        ListView r104 = (ListView) findViewById(R.id.reparo_info_list);
        c r105 = new c(this);
        this.f267296a = r105;
        r104.setAdapter(r105);
        findViewById(R.id.reparo_fetch_patchs).setOnClickListener(new a());
        findViewById(R.id.reparo_clear_patchs).setOnClickListener(new b());
        return;
    L11:
        if (r101.f267443b.f267432f == false) goto L13;
        r102 = true;
        goto L14
    }
}
