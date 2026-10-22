package com.bytedance.ug.sdk.luckycat.impl.lynx;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.ug.sdk.luckycat.impl.browser.webview.PageInfo;
import com.bytedance.ug.sdk.luckycat.impl.model.PageLoadReason;
import com.bytedance.ug.sdk.luckycat.impl.model.SchemaUIConfig;
import com.larus.nova.R;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001\u0007B\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/bytedance/ug/sdk/luckycat/impl/lynx/LuckyCatLynxActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/bytedance/ug/sdk/luckycat/impl/manager/f;", "", "Ldj7/b;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "luckycat_container_release"}, k = 1, mv = {1, 4, 0})
public class LuckyCatLynxActivity extends AppCompatActivity implements com.bytedance.ug.sdk.luckycat.impl.manager.f, dj7.b {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Map<String, Integer> f271171f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f271172a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SchemaUIConfig f271173b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LuckyCatLynxFragment f271174c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f271175d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Long f271176e;

    public static final class a {
    }

    static {
        f271171f = MapsKt.mapOf(new Pair[]{TuplesKt.to("state_unspecified", 0), TuplesKt.to("state_unchanged", 1), TuplesKt.to("state_hidden", 2), TuplesKt.to("state_always_hidden", 3), TuplesKt.to("state_visible", 4), TuplesKt.to("state_always_visible", 5), TuplesKt.to("adjust_unspecified", 0), TuplesKt.to("adjust_resize", 16), TuplesKt.to("adjust_pan", 32), TuplesKt.to("is_forward_navigation", 256), TuplesKt.to("adjust_nothing", 48)});
    }

    @Override // com.bytedance.ug.sdk.luckycat.impl.manager.f
    public final boolean P() {
        LuckyCatLynxFragment r100 = this.f271174c;
        if (r100 == null) goto L8;
        if (r100 == null) goto L10;
        r100.ba0();
        return true;
    L10:
        return true;
    L8:
        return false;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public final void onBackPressed() {
        SchemaUIConfig r100 = this.f271173b;
        if (r100 == null) goto L11;
        if (r100.isBlockBackPress() != true) goto L11;
        LuckyCatLynxFragment r101 = this.f271174c;
        if (r101 == null) goto L25;
        r101.ba0();
        return;
    L25:
        return;
    L11:
        if (com.bytedance.ug.sdk.luckycat.impl.manager.k.a(this) == false) goto L16;
        if (com.bytedance.ug.sdk.luckycat.impl.manager.k.b(this) == false) goto L16;
        return;
    L16:
        if (isFinishing() == false) goto L19;
        return;
    L19:
        if (isTaskRoot() == false) goto L23;
        Intent r102 = com.bytedance.ug.sdk.luckycat.impl.utils.d.b(this, getPackageName());
        if (r102 == null) goto L23;
        startActivity(r102);
    L23:
        finish();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.f375446a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(getClass().getName()));
    L5:
        super.onDestroy();
    }

    public final com.bytedance.ug.sdk.luckycat.utils.d.a y1() {
        com.bytedance.ug.sdk.luckycat.utils.d.a r100 = new com.bytedance.ug.sdk.luckycat.utils.d.a();
        SchemaUIConfig r101 = this.f271173b;
        if (r101 == null) goto L25;
        Window r102 = getWindow();
        boolean r103 = true;
        if (r102 == null) goto L11;
        if (Build.VERSION.SDK_INT < 28) goto L11;
        WindowManager.LayoutParams r104 = r102.getAttributes();
        r104.layoutInDisplayCutoutMode = 1;
        r102.setAttributes(r104);
    L11:
        if (r101.isTransStatusBar() == false) goto L13;
        r100.f271561b = true;
        r100.a(R.color.polaris_status_bar_color_transparent);
        goto L25
    L13:
        String r105 = r101.getStatusBarBgColor();
        if (r105 != null) goto L16;
    L19:
        if (r103 == false) goto L26;
        r100.a(R.color.polaris_status_bar_color_white);
        goto L25
    L26:
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L22
        r100.f271560a = Color.parseColor(r101.getStatusBarBgColor());     // Catch: Throwable -> L22
        Result.m9449constructorimpl(r100);     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L25
    L16:
        if (r105.length() == 0) goto L19;
        r103 = false;
    L25:
        return r100;
    }

    public LuckyCatLynxActivity() {
        this.f271172a = "";
        this.f271176e = -1L;
        this.f271176e = Long.valueOf(System.currentTimeMillis());
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void finish() {
        super.finish();
        SchemaUIConfig r100 = this.f271173b;
        if (r100 != null) goto L5;
    L6:
        overridePendingTransition(R.anim.polaris_transition_keep, R.anim.polaris_activity_slide_left_exit);
    L8:
        if ((this instanceof ChatWindowActivity) == true) goto L61;
        FLogger r101 = FLogger.f375446a;
        r101.i("ActivityLancet", "finish ".concat(getClass().getName()));
        long r102 = SystemClock.uptimeMillis();
        Map<Activity, Long> r103 = ActivityLancet.LAST_FINISH_HANDLED_MS;
        monitor-enter(r103);
        Long r104 = r103.get(this);     // Catch: Throwable -> L50
        if (r104 != null) goto L15;
    L18:
        r103.put(this, Long.valueOf(r102));     // Catch: Throwable -> L50
        monitor-exit(r103);     // Catch: Throwable -> L50
    L47:
        th = move-exception;
        FLogger.f375446a.e("ActivityLancet", "handle onBackPressed strategy failed", th);
    L58:
        return;
    L21:
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L24;
        r101.i("ActivityLancet", "quit !resume, current state = " + getLifecycle().getCurrentState());     // Catch: Throwable -> L47
    L53:
        goto L58
    L24:
        if (isFinishing() == true) goto L27;
        r101.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L47
        goto L53
    L27:
        if (ActivityStartBehavior.isInternalActivityConsumed(this) == true) goto L30;
        r101.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L47
        goto L53
    L30:
        if (ActivityLancet.isOnlyActivityInTask(this) == true) goto L33;
        r101.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L47
        goto L53
    L33:
        if (ActivityLancet.isExcludedActivity(this) == false) goto L36;
        r101.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L47
        goto L53
    L36:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L38;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L47
        goto L53
    L38:
        Intent r105 = getPackageManager().getLaunchIntentForPackage(getPackageName());     // Catch: Throwable -> L47
        if (r105 == null) goto L53;
        r105.addFlags(268435456);     // Catch: Throwable -> L47
        r105.addFlags(2097152);     // Catch: Throwable -> L47
        r101.i("ActivityLancet", "start launcher intent after backPressed, activity=" + this);     // Catch: Throwable -> L47
        startActivity(r105);     // Catch: Throwable -> L44
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.slide_out_right);     // Catch: Throwable -> L44
    L44:
        th = move-exception;
        FLogger.f375446a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L47
        goto L53
    L15:
        if ((r102 - r104.longValue()) >= 800) goto L18;
        monitor-exit(r103);     // Catch: Throwable -> L50
    L50:
        th = move-exception;
        throw th;
    L61:
        return;
    L5:
        if (r100.isCancelAnimation() == true) goto L8;
        goto L6
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onPause() {
        super.onPause();
        LuckyCatLynxFragment r100 = this.f271174c;
        if (r100 == null) goto L8;
        r100.getClass();
        ij7.i r101 = r100.f271190p;
        if (r101 == null) goto L9;
        r101.f();
        return;
    L9:
        return;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onResume() {
        super.onResume();
        LuckyCatLynxFragment r100 = this.f271174c;
        if (r100 == null) goto L35;
        r100.getClass();
        Map<String, WeakReference<c>> r101 = LuckyCatContainerIDManager.f271169a;
        ij7.i r102 = r100.f271190p;
        if (r102 == null) goto L7;
        r102.g();
    L7:
        String r103 = zi7.b.f572264b.x(r100.f271186l, true);
        boolean r104 = false;
        if (r103 != null) goto L10;
    L13:
        boolean r105 = true;
    L14:
        if (r105 == true) goto L23;
        String r106 = r100.f271186l;
        if (r106 != null) goto L18;
    L21:
        boolean r107 = true;
    L22:
        if (r107 == true) goto L23;
    L24:
        if (r104 == false) goto L27;
        r100 = null;
    L27:
        if (r100 == null) goto L36;
        Uri r108 = UriProtector.parse(r103);
        if ((true ^ Intrinsics.areEqual(UriProtector.parse(r100.f271186l).getPath(), r108.getPath())) == false) goto L37;
        ij7.i r109 = r100.f271190p;
        String r110 = r108.getPath();
        PageInfo r111 = r109.f490107c;
        if (r111 == null) goto L33;
        r111.f271118b = r110;
    L33:
        r100.Y90(PageLoadReason.URL_REPLACE);
        return;
    L37:
        return;
    L36:
        return;
    L18:
        if (r106.length() == 0) goto L21;
        r107 = false;
    L23:
        r104 = true;
        goto L24
    L10:
        if (r103.length() == 0) goto L13;
        r105 = false;
        goto L14
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle r110) {
        if (z2.f365865a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (v19.f.f(this) == false) goto L11;
        v19.f.c(getTheme());     // Catch: Throwable -> L9
    L11:
        if (r110 == null) goto L15;
        Intent r100 = getIntent();
        r110.remove("android:support:fragments");
        if (r100 == null) goto L15;
        r100.putExtra("luckycat_init_data", r110.getString("luckycat_init_data"));
    L15:
        super.onCreate(r110);
        Intent r111 = getIntent();
        if (r111 == null) goto L20;
        Uri r112 = r111.getData();
        if (r112 == null) goto L20;
        this.f271172a = r112.toString();
        UriProtector.getQueryParameter(r112, "url");
        this.f271173b = SchemaUIConfig.createConfig(this.f271172a);
    L20:
        String r113 = this.f271172a;
        if (r113 != null) goto L23;
    L26:
        boolean r114 = true;
    L27:
        if (r114 == false) goto L29;
        finish();
    L29:
        SchemaUIConfig r115 = this.f271173b;
        if (r115 != null) goto L173;
    L42:
        SchemaUIConfig r116 = this.f271173b;
        if (r116 == null) goto L175;
        if (r116.isHideStatusBar() == false) goto L49;
        Window r101 = getWindow();
        if (r101 == null) goto L49;
        r101.addFlags(1024);
    L49:
        Integer r117 = f271171f.get(r116.getSoftInputMode());
        if (r117 == null) goto L175;
        int r118 = r117.intValue();
        Window r102 = getWindow();
        if (r102 == null) goto L175;
        r102.setSoftInputMode(r118);
    L175:
        setContentView(R.layout.luckycat_lynx_activity);     // Catch: Exception -> L167
        View r119 = findViewById(R.id.root_view);
        this.f271175d = r119;
        if (r119 == null) goto L71;
        SchemaUIConfig r103 = this.f271173b;
        if (r103 != null) goto L61;
    L63:
        SchemaUIConfig r104 = this.f271173b;
        if (r104 == null) goto L66;
        String r105 = r104.getContainerBgColor();
    L177:
        int r106 = Color.parseColor(r105);     // Catch: Throwable -> L69
    L70:
        r119.setBackgroundColor(r106);
    L69:
        r106 = -1;
        goto L70
    L66:
        r105 = null;
        goto L177
    L61:
        if (r103.isBgTransparent() != true) goto L63;
        r119.setBackgroundColor(0);
    L71:
        com.bytedance.ug.sdk.luckycat.impl.manager.m r120 = com.bytedance.ug.sdk.luckycat.impl.manager.m.a.f271349a;
        View r121 = findViewById(R.id.back_btn);
        if ((r121 instanceof TextView) == true) goto L74;
        r121 = null;
    L74:
        TextView r122 = (TextView) r121;
        if (r122 == null) goto L142;
        r122.setOnClickListener(new f(this));
        SchemaUIConfig r107 = this.f271173b;
        if (r107 != null) goto L79;
    L80:
        SchemaUIConfig r108 = this.f271173b;
        if (r108 != null) goto L83;
    L87:
        SchemaUIConfig r109 = this.f271173b;
        if (r109 != null) goto L90;
    L92:
        SchemaUIConfig r123 = this.f271173b;
        if (r123 == null) goto L95;
        String r124 = r123.getBackBtnIcon();
    L97:
        if (r124 == null) goto L115;
        int r125 = r124.hashCode();
        if (r125 == (-1576840527)) goto L113;
        if (r125 == 94756344) goto L110;
        if (r125 != 1654553132) goto L115;
        if (r124.equals("down_arrow") == false) goto L115;
        r122.setCompoundDrawablesWithIntrinsicBounds(R.drawable.polaris_black_down_arrow_selector, 0, 0, 0);
    L116:
        Drawable[] r126 = r122.getCompoundDrawables();
        if (r126 == null) goto L119;
        Drawable r127 = r126[0];
    L120:
        SchemaUIConfig r128 = this.f271173b;
        if (r128 == null) goto L123;
        String r129 = r128.getBackBtnColor();
    L125:
        if (r129 == null) goto L140;
        int r130 = r129.hashCode();
        if (r130 == 93818879) goto L137;
        if (r130 != 113101865) goto L140;
        if (r129.equals("white") == false) goto L140;
        if (r127 == null) goto L142;
        r127.setColorFilter(getResources().getColor(R.color.polaris_white), PorterDuff.Mode.SRC_IN);
        goto L142
    L137:
        if (r129.equals("black") == false) goto L140;
        if (r127 == null) goto L142;
        r127.setColorFilter(getResources().getColor(R.color.polaris_black), PorterDuff.Mode.SRC_IN);
    L140:
        if (r127 == null) goto L142;
        r127.setColorFilter(getResources().getColor(R.color.polaris_black), PorterDuff.Mode.SRC_IN);
        goto L142
    L123:
        r129 = null;
        goto L125
    L119:
        r127 = null;
        goto L120
    L110:
        if (r124.equals("close") == false) goto L115;
        r122.setCompoundDrawablesWithIntrinsicBounds(R.drawable.polaris_title_bar_close_selector, 0, 0, 0);
        goto L116
    L113:
        if (r124.equals("back_arrow") == false) goto L115;
        r122.setCompoundDrawablesWithIntrinsicBounds(R.drawable.polaris_leftbackicon_selector, 0, 0, 0);
    L115:
        r122.setCompoundDrawablesWithIntrinsicBounds(R.drawable.polaris_leftbackicon_selector, 0, 0, 0);
        goto L116
    L95:
        r124 = null;
        goto L97
    L90:
        if (r109.isHideBackBtn() != true) goto L92;
        r122.setVisibility(8);
        goto L92
    L83:
        if (r108.isHideStatusBar() != true) goto L87;
    L84:
        ViewGroup.LayoutParams r131 = r122.getLayoutParams();
        if ((r131 instanceof ViewGroup.MarginLayoutParams) == false) goto L87;
        ((ViewGroup.MarginLayoutParams) r131).topMargin = com.bytedance.ug.sdk.luckycat.utils.h.c(this);
        r122.requestLayout();
        goto L87
    L79:
        if (r107.isTransStatusBar() == true) goto L84;
    L142:
        LuckyCatLynxFragment r132 = new LuckyCatLynxFragment();
        this.f271174c = r132;
        Bundle r133 = new Bundle();
        String r134 = this.f271172a;
        if (r134 != null) goto L146;
        r134 = "";
    L146:
        r133.putString("luckycat_lynx_bundle_scheme", r134);
        Intent r135 = getIntent();
        if (r135 == null) goto L149;
        String r136 = r135.getStringExtra("luckycat_init_data");
    L150:
        r133.putString("luckycat_init_data", r136);
        r133.putSerializable("luckycat_schema_ui_config", this.f271173b);
        Long r137 = this.f271176e;
        if (r137 == null) goto L153;
        long r138 = r137.longValue();
    L154:
        r133.putLong("activity_create_timestamp", r138);
        r132.setArguments(r133);
        if (findViewById(R.id.lynx_fragment) != null) goto L157;
        com.bytedance.ug.sdk.luckycat.impl.model.d.a("ug_sdk_luckycat_lynx_fragment_id_error", null, true);
        finish();
    L162:
        SchemaUIConfig r139 = this.f271173b;
        if (r139 != null) goto L165;
    L166:
        overridePendingTransition(R.anim.polaris_activity_slide_left_enter, R.anim.polaris_transition_keep);
        return;
    L165:
        if (r139.isCancelAnimation() != true) goto L166;
        return;
    L157:
        FragmentTransaction r140 = getSupportFragmentManager().beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r140, r132, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, null, R.id.lynx_fragment) == true) goto L161;
        r140.add(R.id.lynx_fragment, r132);
    L161:
        r140.commit();
        goto L162
    L153:
        r138 = -1;
        goto L154
    L149:
        r136 = null;
    L167:
        e = move-exception;
        com.bytedance.ug.sdk.luckycat.impl.utils.a.b("LuckyCatLynxFragment", Log.getStackTraceString(e));
        e.printStackTrace();
        finish();
        return;
    L173:
        new com.bytedance.ug.sdk.luckycat.utils.d(this, y1()).d();     // Catch: Throwable -> L40
        if (Intrinsics.areEqual("black", r115.getStatusBarTextColor()) == false) goto L36;
        com.bytedance.ug.sdk.luckycat.utils.d.c(getWindow(), true);     // Catch: Throwable -> L39
    L170:
        goto L42
    L36:
        if (Intrinsics.areEqual("white", r115.getStatusBarTextColor()) == false) goto L170;
        com.bytedance.ug.sdk.luckycat.utils.d.c(getWindow(), false);     // Catch: Throwable -> L39
    L40:
        th = move-exception;
        th.getMessage();
        goto L42
    L23:
        if (StringsKt.isBlank(r113) == true) goto L26;
        r114 = false;
        goto L27
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onSaveInstanceState(Bundle r100) {
        super.onSaveInstanceState(r100);
        Intent r101 = getIntent();
        if (r101 == null) goto L5;
        String r102 = r101.getStringExtra("luckycat_init_data");
    L6:
        r100.putString("luckycat_init_data", r102);
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public final void onRequestPermissionsResult(int r110, String[] r210, int[] r211) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {Integer.valueOf(r110), r210, r211};
        f06.b r111 = new f06.b();
        g06.a r102 = ApiHookConfig.f245611b.get(102611);
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r112 = r103;
        int r104 = r112.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L15;
        f06.a r106 = r112[r105];
        int r113 = r105;
        int r114 = r104;
        f06.d r107 = r106.preInvoke(102611, "androidx/appcompat/app/AppCompatActivity", "onRequestPermissionsResult", this, r101, "void", r111);     // Catch: Exception -> L24
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L24
    L17:
        if (r107.f474982a == true) goto L20;
        super.onRequestPermissionsResult(r110, r210, r211);
    L20:
        com.bytedance.ug.sdk.luckycat.api.depend.k r108 = com.bytedance.ug.sdk.luckycat.impl.manager.m.a.f271349a.f271341i;
        if (r108 == null) goto L30;
        r108.a();
        return;
    L30:
        return;
    L14:
        r105 = r113 + 1;
        r104 = r114;
        goto L8
    L15:
        r107 = new f06.d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }
}
