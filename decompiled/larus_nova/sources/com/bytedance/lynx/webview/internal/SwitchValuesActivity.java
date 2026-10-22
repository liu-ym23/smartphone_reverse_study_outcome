package com.bytedance.lynx.webview.internal;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.Html;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.mira.core.opt.res.NewMiraResourcesManager;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public class SwitchValuesActivity extends Activity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public EditText f265189a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Button f265190b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Button f265191c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f265192d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Button f265193e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public JSONObject f265194f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f265195g;

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public final void attachBaseContext(Context r100) {
        super.attachBaseContext(r100);
        NewMiraResourcesManager.getInstance().installActivity(this);
    }

    public final void a() {
        JSONObject r100 = this.f265194f;
        if (r100 != null) goto L5;
    L33:
        this.f265192d.setText("暂无开关配置数据");
        return;
    L5:
        if (r100.length() == 0) goto L33;
        StringBuilder r101 = new StringBuilder();
        ArrayList r102 = new ArrayList();
        Iterator<String> r103 = this.f265194f.keys();
    L9:
        if (r103.hasNext() == false) goto L11;
        r102.add(r103.next());
        goto L9
    L11:
        Collections.sort(r102);
        Iterator r104 = r102.iterator();
        int r105 = 0;
        int r106 = 0;
    L13:
        if (r104.hasNext() == false) goto L28;
        String r107 = (String) r104.next();
        r105 = r105 + 1;
        if (this.f265195g.isEmpty() == true) goto L19;
        if (r107.toLowerCase().contains(this.f265195g.toLowerCase()) == false) goto L13;
    L19:
        r106 = r106 + 1;
        String r108 = b(this.f265194f.get(r107));     // Catch: JSONException -> L26
        if (r107.length() <= 50) goto L23;
        String r109 = r107.substring(0, 47) + "...";     // Catch: JSONException -> L26
    L24:
        r101.append(String.format("• <b>%s</b>: %s<br/>", new Object[]{r109, r108}));     // Catch: JSONException -> L26
        goto L13
    L23:
        r109 = r107;
    L26:
        r101.append(String.format("• <b>%s</b>: <font color='#F44336'>错误</font><br/>", new Object[]{r107}));
        goto L13
    L28:
        if (this.f265195g.isEmpty() == true) goto L30;
        r101.append(String.format("<br/><font color='#FF9800'>搜索结果: %d / %d 个开关</font>", new Object[]{Integer.valueOf(r106), Integer.valueOf(r105)}));
    L31:
        this.f265192d.setText(Html.fromHtml(r101.toString()));
        return;
    L30:
        r101.append(String.format("<br/><font color='#FF9800'>总计: %d 个开关</font>", new Object[]{Integer.valueOf(r105)}));
        goto L31
    }

    public SwitchValuesActivity() {
        this.f265195g = "";
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
        overridePendingTransition(R.anim.fade_in, R.anim.slide_out_right);     // Catch: Throwable -> L42
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

    public static String b(Object r100) {
        if (r100 != null) goto L5;
        return "<font color='#9E9E9E'>null</font>";
    L5:
        String r101 = r100.toString();
        if (r101.length() <= 100) goto L9;
        r101 = r101.substring(0, 97) + "...";
    L9:
        if ((r100 instanceof Boolean) == false) goto L17;
        boolean r102 = ((Boolean) r100).booleanValue();
        Object[] r103 = new Object[2];
        if (r102 == false) goto L13;
        String r104 = "#4CAF50";
    L14:
        r103[0] = r104;
        r103[1] = Boolean.valueOf(r102);
        return String.format("<font color='%s'>%b</font>", r103);
    L13:
        r104 = "#F44336";
        goto L14
    L17:
        if ((r100 instanceof Number) == false) goto L21;
        return String.format("<font color='#2196F3'>%s</font>", new Object[]{r101});
    L21:
        if ((r100 instanceof String) == false) goto L39;
        String r105 = (String) r100;
        if (r105.startsWith("http") == true) goto L37;
        if (r105.startsWith("https") == true) goto L37;
        if (r105.contains(HTTP.URL_DEFAULT) == true) goto L35;
        if (r105.contains("\\") == true) goto L35;
        return String.format("<font color='#388E3C'>\"%s\"</font>", new Object[]{r101});
    L35:
        return String.format("<font color='#795548'>%s</font>", new Object[]{r101});
    L37:
        return String.format("<font color='#3F51B5'>%s</font>", new Object[]{r101});
    L39:
        return String.format("<font color='#757575'>%s</font>", new Object[]{r101});
    }

    @Override // android.app.Activity
    public final void onCreate(Bundle r100) {
        if (z2.f365865a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (v19.f.f(this) == false) goto L10;
        v19.f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        super.onCreate(r100);
        setContentView(com.larus.nova.R.layout.switch_values_activity);
        setTitle("开关配置详情");
        this.f265189a = (EditText) findViewById(com.larus.nova.R.id.search_edit_text);
        this.f265190b = (Button) findViewById(com.larus.nova.R.id.search_button);
        this.f265191c = (Button) findViewById(com.larus.nova.R.id.clear_button);
        this.f265192d = (TextView) findViewById(com.larus.nova.R.id.switch_values_text);
        this.f265193e = (Button) findViewById(com.larus.nova.R.id.back_button);
        this.f265192d.setMovementMethod(new ScrollingMovementMethod());
        this.f265190b.setOnClickListener(new j0(this));
        this.f265191c.setOnClickListener(new k0(this));
        this.f265193e.setOnClickListener(new l0(this));
        this.f265189a.addTextChangedListener(new m0(this));
        Setting r101 = Setting.c();
        r101.getClass();
        JSONObject r102 = new JSONObject();
        if (r101.f265171b == null) goto L23;
        ((ReentrantReadWriteLock) r101.f265174e).readLock().lock();
        Iterator<String> r103 = r101.f265171b.keySet().iterator();     // Catch: Throwable -> L25
    L16:
        if (r103.hasNext() == false) goto L22;
        String r104 = r103.next();     // Catch: Throwable -> L25
        Object r105 = r101.f265171b.get(r104);     // Catch: JSONException -> L28 Throwable -> L25
        if (r105 == null) goto L16;
        r102.put(r104, r105);     // Catch: JSONException -> L28 Throwable -> L25
        goto L16
    L22:
        ((ReentrantReadWriteLock) r101.f265174e).readLock().unlock();
    L25:
        th = move-exception;
        ((ReentrantReadWriteLock) r101.f265174e).readLock().unlock();
        throw th;
    L23:
        this.f265194f = r102;
        a();
    }
}
