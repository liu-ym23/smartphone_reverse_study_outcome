package com.unionpay;

import android.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.bytedance.locallife.pdp.album.model.CustomAlbumViewModel;
import com.bytedance.mira.core.opt.res.NewMiraResourcesManager;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.io.ByteArrayInputStream;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes41.dex */
public class UPPayWapActivity extends Activity {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f462117i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WebView f462118a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public WebViewJavascriptBridge f462119b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public AlertDialog f462120c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f462121d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f462122e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f462123f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f462124g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public g f462125h;

    public UPPayWapActivity() {
        this.f462121d = false;
        this.f462122e = "";
    }

    public static String b(String r100, String r101, String r102) {
        JSONObject r103 = new JSONObject("{\"code\":\"0\",\"msg\":\"success\"}");     // Catch: Exception -> L9
        r103.put("code", r100);     // Catch: Exception -> L9
        if (r101 == null) goto L5;
        r103.put("msg", r101);     // Catch: Exception -> L9
    L5:
        if (r102 == null) goto L7;
        r103.put("value", r102);     // Catch: Exception -> L9
    L7:
        return r103.toString();
    L9:
        e = move-exception;
        e.printStackTrace();
        return "";
    }

    public static String c(String r100, JSONObject r101) {
        JSONObject r102 = new JSONObject("{\"code\":\"0\",\"msg\":\"success\"}");     // Catch: Exception -> L8
        r102.put("code", "0");     // Catch: Exception -> L8
        if (r100 == null) goto L6;
        r102.put("msg", r100);     // Catch: Exception -> L8
    L6:
        r102.put("value", r101);     // Catch: Exception -> L8
        return r102.toString();
    L8:
        e = move-exception;
        e.printStackTrace();
        return "";
    }

    public final void a(String r100, String r101) {
        Intent r102 = new Intent();
        r102.putExtra("pay_result", r100);
        r102.putExtra("result_data", r101);
        setResult(-1, r102);
        finish();
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public final void attachBaseContext(Context r100) {
        super.attachBaseContext(r100);
        NewMiraResourcesManager.getInstance().installActivity(this);
    }

    @Override // android.app.Activity
    public final void onActivityResult(int r100, int r101, Intent r102) {
        super.onActivityResult(r100, r101, r102);
        if (r100 == 1) goto L5;
        return;
    L5:
        if (r101 == (-1)) goto L40;
        return;
    L40:
        Bundle r103 = r102.getExtras();     // Catch: Exception -> L35
        if (r103 != null) goto L10;
        g r104 = this.f462125h;     // Catch: Exception -> L35
        if (r104 == null) goto L38;
        r104.a(b("1", "No pay result", null));     // Catch: Exception -> L35
    L38:
        this.f462125h = null;
        return;
    L10:
        String r105 = "";
        if (r103.containsKey("pay_result") == false) goto L14;
        String r106 = r103.getString("pay_result");     // Catch: Exception -> L35
    L18:
        if (TextUtils.isEmpty(r106) == false) goto L21;
        r106 = "";
    L21:
        if (r103.containsKey("data") == false) goto L23;
        String r107 = r103.getString("data");     // Catch: Exception -> L35
    L25:
        if (TextUtils.isEmpty(r107) == true) goto L28;
        r105 = r107;
    L28:
        JSONObject r108 = new JSONObject();     // Catch: Exception -> L35
        r108.put("code", r106);     // Catch: Exception -> L35
        r108.put("data", r105);     // Catch: Exception -> L35
        g r109 = this.f462125h;     // Catch: Exception -> L35
        if (r109 == null) goto L38;
        r109.a(c(null, r108));     // Catch: Exception -> L35
        goto L38
    L23:
        r107 = "";
        goto L25
    L14:
        if (r103.containsKey("code") == false) goto L16;
        r106 = r103.getString("code");     // Catch: Exception -> L35
        goto L18
    L16:
        r106 = "";
    L35:
        g r110 = this.f462125h;
        if (r110 == null) goto L38;
        r110.a(b("1", "No pay result", null));
        goto L38
    }

    @Override // android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        View r100 = this.f462124g;
        if (r100 == null) goto L14;
        Drawable r101 = r100.getBackground();
        if (r101 == null) goto L15;
        r101.setCallback(null);
        if ((r101 instanceof BitmapDrawable) == false) goto L16;
        Bitmap r102 = ((BitmapDrawable) r101).getBitmap();
        if (r102 != null) goto L11;
        return;
    L11:
        if (r102.isRecycled() == true) goto L18;
        r102.recycle();
        return;
    L18:
        return;
    L16:
        return;
    L15:
        return;
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int r100, KeyEvent r101) {
        if (r100 != 4) goto L16;
        if (this.f462121d == false) goto L13;
        WebView r102 = this.f462118a;
        if (r102 != null) goto L9;
    L12:
        a("cancel", null);
    L14:
        return true;
    L9:
        if (r102.canGoBack() == false) goto L12;
        this.f462118a.goBack();
        return true;
    L13:
        onPause();
        goto L14
    L16:
        return super.onKeyDown(r100, r101);
    }

    /* JADX INFO: Removed unreachable split cross block B:60:0x0114 */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.app.Activity
    public final void finish() {
        super.finish();     // Catch: Exception -> L5
    L7:
        if ((this instanceof FragmentActivity) == true) goto L10;
        return;
    L10:
        if ((this instanceof ChatWindowActivity) == true) goto L65;
        FLogger r100 = FLogger.f375446a;
        r100.i("ActivityLancet", "finish ".concat(getClass().getName()));
        long r101 = SystemClock.uptimeMillis();
        Map<Activity, Long> r102 = ActivityLancet.LAST_FINISH_HANDLED_MS;
        monitor-enter(r102);
        Long r103 = r102.get(this);     // Catch: Throwable -> L52
        if (r103 != null) goto L17;
    L20:
        r102.put(this, Long.valueOf(r101));     // Catch: Throwable -> L52
        monitor-exit(r102);     // Catch: Throwable -> L52
    L49:
        th = move-exception;
        FLogger.f375446a.e("ActivityLancet", "handle onBackPressed strategy failed", th);
    L55:
        return;
    L23:
        if (((FragmentActivity) this).getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L26;
        r100.i("ActivityLancet", "quit !resume, current state = " + ((FragmentActivity) this).getLifecycle().getCurrentState());     // Catch: Throwable -> L49
        goto L55
    L26:
        if (isFinishing() == true) goto L29;
        r100.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L49
        goto L55
    L29:
        if (ActivityStartBehavior.isInternalActivityConsumed(this) == true) goto L32;
        r100.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L49
        goto L55
    L32:
        if (ActivityLancet.isOnlyActivityInTask(this) == true) goto L35;
        r100.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L49
        goto L55
    L35:
        if (ActivityLancet.isExcludedActivity(this) == false) goto L38;
        r100.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L49
        goto L55
    L38:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L40;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L49
        goto L55
    L40:
        Intent r104 = getPackageManager().getLaunchIntentForPackage(getPackageName());     // Catch: Throwable -> L49
        if (r104 == null) goto L55;
        r104.addFlags(268435456);     // Catch: Throwable -> L49
        r104.addFlags(2097152);     // Catch: Throwable -> L49
        r100.i("ActivityLancet", "start launcher intent after backPressed, activity=" + this);     // Catch: Throwable -> L49
        startActivity(r104);     // Catch: Throwable -> L46
        overridePendingTransition(R.anim.fade_in, R.anim.slide_out_right);     // Catch: Throwable -> L46
    L46:
        th = move-exception;
        FLogger.f375446a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L49
        goto L55
    L17:
        if ((r101 - r103.longValue()) >= 800) goto L20;
        monitor-exit(r102);     // Catch: Throwable -> L52
    L52:
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

    @Override // android.app.Activity
    public final void onCreate(Bundle r110) {
        if (z2.f365865a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(getTheme());     // Catch: Throwable -> L49
    L6:
        if (v19.f.f(this) == false) goto L8;
        v19.f.c(getTheme());     // Catch: Throwable -> L49
    L8:
        super.onCreate(r110);
        getWindow().addFlags(8192);
    L47:
        finish();     // Catch: Exception -> L50
        return;
    L10:
        if ("949A1CC".equalsIgnoreCase(getIntent().getStringExtra("magic_data")) == true) goto L12;
        finish();     // Catch: Exception -> L47
    L12:
        this.f462121d = "link".equals(getIntent().getStringExtra(ReportConstant.COMMON_ACTION_TYPE));     // Catch: Exception -> L47
        String r111 = getIntent().getStringExtra("ex_mode");     // Catch: Exception -> L47
        this.f462122e = r111;     // Catch: Exception -> L47
        if (TextUtils.isEmpty(r111) == false) goto L15;
        this.f462122e = CustomAlbumViewModel.DEFAULT_TAB_ID;     // Catch: Exception -> L47
    L15:
        String r112 = "";
        getWindow().requestFeature(1);     // Catch: Exception -> L47
        RelativeLayout r100 = new RelativeLayout(this);     // Catch: Exception -> L47
        LinearLayout r101 = new LinearLayout(this);     // Catch: Exception -> L47
        r101.setOrientation(1);     // Catch: Exception -> L47
        r100.addView(r101, new RelativeLayout.LayoutParams(-1, -1));     // Catch: Exception -> L47
        r100.setFitsSystemWindows(true);     // Catch: Exception -> L47
        setContentView(r100);     // Catch: Exception -> L47
        this.f462118a = new WebView(this);     // Catch: Exception -> L47
        String r102 = getIntent().getStringExtra(ReportConstant.COMMON_ACTION_TYPE);     // Catch: Exception -> L47
        this.f462123f = r102;     // Catch: Exception -> L47
        if ("link".equals(r102) == false) goto L19;
        r112 = getIntent().getStringExtra("wapurl");     // Catch: Exception -> L47
    L40:
        this.f462118a.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));     // Catch: Exception -> L47
        r101.addView(this.f462118a);     // Catch: Exception -> L47
        WebViewJavascriptBridge r103 = new WebViewJavascriptBridge(this, this.f462118a, null);     // Catch: Exception -> L47
        this.f462119b = r103;     // Catch: Exception -> L47
        r103.setAllowScheme(true);     // Catch: Exception -> L47
        WebView r104 = this.f462118a;     // Catch: Exception -> L47
        if (r104 == null) goto L43;
        r104.loadUrl(r112);     // Catch: Exception -> L47
    L43:
        WebViewJavascriptBridge r113 = this.f462119b;     // Catch: Exception -> L47
        if (r113 == null) goto L58;
        r113.registerHandler("getDeviceInfo", new v(this));     // Catch: Exception -> L47
        this.f462119b.registerHandler("saveData", new w(this));     // Catch: Exception -> L47
        this.f462119b.registerHandler("getData", new x(this));     // Catch: Exception -> L47
        this.f462119b.registerHandler("removeData", new y(this));     // Catch: Exception -> L47
        this.f462119b.registerHandler("setPageBackEnable", new z(this));     // Catch: Exception -> L47
        this.f462119b.registerHandler("payBySDK", new a0(this));     // Catch: Exception -> L47
        this.f462119b.registerHandler("payResult", new m(this));     // Catch: Exception -> L47
        this.f462119b.registerHandler("closePage", new n(this));     // Catch: Exception -> L47
        this.f462119b.registerHandler("openNewPage", new o(this));     // Catch: Exception -> L47
        this.f462119b.registerHandler("checkBankSchemes", new p(this));     // Catch: Exception -> L47
        this.f462119b.registerHandler("openBankApp", new q(this));     // Catch: Exception -> L47
        this.f462119b.registerHandler("openScheme", new r(this));     // Catch: Exception -> L47
        return;
    L58:
        return;
    L19:
        String r105 = getIntent().getStringExtra("waptype");     // Catch: Exception -> L47
        String r106 = getIntent().getStringExtra("wapurl");     // Catch: Exception -> L47
        if ("new_page".equals(r105) == false) goto L24;
        if (r106 == null) goto L23;
        r112 = r106;
    L23:
        View.OnClickListener r107 = new l(this);     // Catch: Exception -> L47
    L28:
        ImageView r108 = new ImageView(this);     // Catch: Exception -> L47
        if (TextUtils.isEmpty("iVBORw0KGgoAAAANSUhEUgAAAGAAAABgCAYAAADimHc4AAAAAXNSR0IArs4c6QAAA8JJREFUeF7tnD9uE0EUh980lmxRUEAJCLhADkABbSrgEDaWXKSg4QRQUKSIBLuXCBUtKThALoCQTQkFBbIlS86glbySieJodufP7/fIc5ViVm/m++bNTHbs58Q+UAIOGt2CiwkATwITYALABMDhLQNMAJgAOLxlgAkAEwCHtwwwAWAC4PCWASYATAAc3jLABIAJgMNbBvwPAsbj8WMReS8iT0Rk6Zz7PBwO3xwfH/8Gjy9J+KOjo9vL5fKdc+7Qez8Uka8i8rqu62+xAaIzoIHvnDv33t+61Jn5YDB4dnJy8j22k8jnZ7PZw/V6/UVEHuz2wzn3x3t/ECshhYBTEXm+B9JiMBg81SphC/9MRO7vGd+nuq5fxEyQFAJ+isidazqhUkIA/GbIv+q6vosWML9mhrR9UyUhEH4ztkVd1/8sTV1lRGfAZDL54L1/FRBYhYQO8MU597GqqmnA2Pc2iRawPSGcX96kNO4JXeCLyHw0Gh3EnvSiBTSgO3acMhNQY0giQLsEFPyGWzIBWiUg4ScXoE0CGn4WAVokMMDPJoBdAgv8rAJYJTDBzy6ATQIb/CICWCQwwi8mAC2BFX5RASgJzPCLCygtgR0+REApCRrgwwTklqAFPlRALgma4MMFpJagDT6FgFQSNMKnERArQSt8KgF9JTTPrdfr67460jRpP3S3cUkvZHZH2vfvrrN5G2ff93ao4dNlQEuro4QQ13Qzv+00XQZkkEALnzYDEkqghk8voMfGTL/mX14vaZeg3Y722BPoZz79HmACQs4WBdr0mP20Z/6rcFEvQRHw1UigFZAAvgoJlAISwqeXQCegI/yFvYpIuBF3hd/8/myz2biLi4sz7/29gK7QHU9pMqAP/PbHf9Pp9JFWCRQCYuC3s16rBLiAFPA1S4AKSAlfqwSYgBzwNUqACMgJX5uE4gJKwN+VsNlsmjoPtFeWRQWUhK9FQjEBCPgaJBQRgITPLiG7AAb4Pe+Yi7y2yCqACT6rhGwCGOEzSsgigBk+m4TkAjTAZ5KQVIAm+CwSkgnQCJ9BQhIBmuGjJUQLsJJlccVpowVY0T5w0b7JZLIIuBAv8l9lwKV8UJPQJdU596OqqpA3rXvjRmfAeDy2wq1BWq9ulELAjS1d7Jw7rarqZQT/+KJ9Vrw7roJ6dAY09m9C+frVavXWe38oIiOq8vUx6WfPJq4bakC7E0iyBHUPa0+0BEwAeC6YABMAJgAObxlgAsAEwOEtA0wAmAA4vGWACQATAIe3DDABYALg8JYBJgBMABz+L3oFF51bXkJGAAAAAElFTkSuQmCC") == false) goto L53;
    L35:
        BitmapDrawable r109 = null;
    L36:
        r108.setBackgroundDrawable(r109);     // Catch: Exception -> L47
        int r114 = com.unionpay.utils.f.a(this, 24.0f);     // Catch: Exception -> L47
        int r115 = com.unionpay.utils.f.a(this, 18.0f);     // Catch: Exception -> L47
        int r116 = com.unionpay.utils.f.a(this, 14.0f);     // Catch: Exception -> L47
        RelativeLayout.LayoutParams r117 = new RelativeLayout.LayoutParams(r114, r114);     // Catch: Exception -> L47
        r117.addRule(9, -1);     // Catch: Exception -> L47
        r117.addRule(10, -1);     // Catch: Exception -> L47
        r117.setMargins(r115, r116, 0, 0);     // Catch: Exception -> L47
        r100.addView(r108, r117);     // Catch: Exception -> L47
        if (r107 != null) goto L39;
        r107 = new s(this);     // Catch: Exception -> L47
    L39:
        r108.setOnClickListener(r107);     // Catch: Exception -> L47
        this.f462124g = r108;     // Catch: Exception -> L47
        goto L40
    L53:
        ByteArrayInputStream r118 = new ByteArrayInputStream(Base64.decode("iVBORw0KGgoAAAANSUhEUgAAAGAAAABgCAYAAADimHc4AAAAAXNSR0IArs4c6QAAA8JJREFUeF7tnD9uE0EUh980lmxRUEAJCLhADkABbSrgEDaWXKSg4QRQUKSIBLuXCBUtKThALoCQTQkFBbIlS86glbySieJodufP7/fIc5ViVm/m++bNTHbs58Q+UAIOGt2CiwkATwITYALABMDhLQNMAJgAOLxlgAkAEwCHtwwwAWAC4PCWASYATAAc3jLABIAJgMNbBvwPAsbj8WMReS8iT0Rk6Zz7PBwO3xwfH/8Gjy9J+KOjo9vL5fKdc+7Qez8Uka8i8rqu62+xAaIzoIHvnDv33t+61Jn5YDB4dnJy8j22k8jnZ7PZw/V6/UVEHuz2wzn3x3t/ECshhYBTEXm+B9JiMBg81SphC/9MRO7vGd+nuq5fxEyQFAJ+isidazqhUkIA/GbIv+q6vosWML9mhrR9UyUhEH4ztkVd1/8sTV1lRGfAZDL54L1/FRBYhYQO8MU597GqqmnA2Pc2iRawPSGcX96kNO4JXeCLyHw0Gh3EnvSiBTSgO3acMhNQY0giQLsEFPyGWzIBWiUg4ScXoE0CGn4WAVokMMDPJoBdAgv8rAJYJTDBzy6ATQIb/CICWCQwwi8mAC2BFX5RASgJzPCLCygtgR0+REApCRrgwwTklqAFPlRALgma4MMFpJagDT6FgFQSNMKnERArQSt8KgF9JTTPrdfr67460jRpP3S3cUkvZHZH2vfvrrN5G2ff93ao4dNlQEuro4QQ13Qzv+00XQZkkEALnzYDEkqghk8voMfGTL/mX14vaZeg3Y722BPoZz79HmACQs4WBdr0mP20Z/6rcFEvQRHw1UigFZAAvgoJlAISwqeXQCegI/yFvYpIuBF3hd/8/myz2biLi4sz7/29gK7QHU9pMqAP/PbHf9Pp9JFWCRQCYuC3s16rBLiAFPA1S4AKSAlfqwSYgBzwNUqACMgJX5uE4gJKwN+VsNlsmjoPtFeWRQWUhK9FQjEBCPgaJBQRgITPLiG7AAb4Pe+Yi7y2yCqACT6rhGwCGOEzSsgigBk+m4TkAjTAZ5KQVIAm+CwSkgnQCJ9BQhIBmuGjJUQLsJJlccVpowVY0T5w0b7JZLIIuBAv8l9lwKV8UJPQJdU596OqqpA3rXvjRmfAeDy2wq1BWq9ulELAjS1d7Jw7rarqZQT/+KJ9Vrw7roJ6dAY09m9C+frVavXWe38oIiOq8vUx6WfPJq4bakC7E0iyBHUPa0+0BEwAeC6YABMAJgAObxlgAsAEwOEtA0wAmAA4vGWACQATAIe3DDABYALg8JYBJgBMABz+L3oFF51bXkJGAAAAAElFTkSuQmCC", 2));     // Catch: Exception -> L33
        r109 = new BitmapDrawable(BitmapFactory.decodeStream(r118));     // Catch: Exception -> L33
        r118.close();     // Catch: Exception -> L33
    L33:
        e = move-exception;
        e.printStackTrace();     // Catch: Exception -> L47
        goto L35
    L24:
        String r119 = getIntent().getStringExtra("paydata");     // Catch: Exception -> L47
        if (r119 == null) goto L27;
        r112 = r106 + "?s=" + r119;     // Catch: Exception -> L47
    L27:
        r107 = null;
    }
}
