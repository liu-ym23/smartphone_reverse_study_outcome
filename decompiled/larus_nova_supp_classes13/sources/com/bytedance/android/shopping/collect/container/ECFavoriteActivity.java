package com.bytedance.android.shopping.collect.container;

import android.R;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.shopping.api.IEShoppingService;
import com.bytedance.android.shopping.searchsimilar.model.SimilarProductParam;
import com.bytedance.ies.uikit.base.AbsActivity;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.gyf.barlibrary.ImmersionBar;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import sc3.g;
import v19.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/shopping/collect/container/ECFavoriteActivity;", "Lcom/bytedance/ies/uikit/base/AbsActivity;", "<init>", "()V", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECFavoriteActivity extends AbsActivity {
    public static final /* synthetic */ int m = 0;
    public String j;
    public String k;
    public String l;

    public static final class a {
        public static void a(Context r5, Uri r6, boolean r7) {
            Intrinsics.checkNotNullParameter(r5, "context");
            Intrinsics.checkNotNullParameter(r6, "uri");
            Intent r0 = new Intent(r5, ECFavoriteActivity.class);
            r0.setData(r6);
            int r1 = ECFavoriteActivity.m;
            Bundle r2 = new Bundle();
            Iterator r3 = UriProtector.getQueryParameterNames(r6).iterator();
        L4:
            if (r3.hasNext() == false) goto L9;
            String r4 = (String) r3.next();
            String r8 = UriProtector.getQueryParameter(r6, r4);
            if (r8 == null) goto L4;
            r2.putString(r4, r8);
            goto L4
        L9:
            if (r2.containsKey("tab_name") == true) goto L12;
            r2.putString("tab_name", "goods");
        L12:
            if (r2.containsKey("user_favorites_type_key") == true) goto L14;
            r2.putInt("user_favorites_type_key", 103);
        L14:
            r0.putExtras(r2);
            if ((r5 instanceof Application) == false) goto L17;
            r0.addFlags(268435456);
        L17:
            r5.startActivity(r0);
            if (r7 == true) goto L20;
            return;
        L20:
            if ((r5 instanceof Activity) == true) goto L22;
            r5 = null;
        L22:
            Activity r9 = (Activity) r5;
            if (r9 == null) goto L32;
            r9.finish();
            return;
        }
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void finish() {
        super.finish();
        overridePendingTransition(2130772255, 2130772258);
        if ((this instanceof ChatWindowActivity) == true) goto L56;
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(ECFavoriteActivity.class.getName()));
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
    L53:
        return;
    L16:
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L19;
        r2.i("ActivityLancet", "quit !resume, current state = " + getLifecycle().getCurrentState());     // Catch: Throwable -> L42
    L48:
        goto L53
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

    /* JADX WARN: Multi-variable type inference failed */
    public final void init() {
        Fragment r2 = null;
        BtmSDK.INSTANCE.registerBtmPageOnCreate(this, "a1.b4649", null);
        FragmentManager r0 = getSupportFragmentManager();
        FragmentTransaction r1 = r0.beginTransaction();
        Fragment r3 = r0.findFragmentByTag("user_favorites_type_fragment_tag");
        if (r3 != null) goto L78;
        int r4 = ECSdk.a;
        IEShoppingService r5 = (IEShoppingService) ECSdk.a(IEShoppingService.class);
        if (r5 == null) goto L77;
        g r6 = r5.getCollectService();
        if (r6 == null) goto L77;
        LinkedHashMap r7 = new LinkedHashMap();
        Intent r8 = getIntent();
        if (r8 == null) goto L30;
        Bundle r9 = r8.getExtras();
        if (r9 == null) goto L30;
        Set<String> r10 = r9.keySet();
        if (r10 == null) goto L30;
        Iterator<T> r11 = r10.iterator();
    L16:
        if (r11.hasNext() == false) goto L30;
        String r12 = (String) r11.next();
        Intent r13 = getIntent();
        if (r13 == null) goto L22;
        Bundle r14 = r13.getExtras();
        if (r14 == null) goto L22;
        Object r15 = r14.get(r12);
    L24:
        if ((r15 instanceof String) == true) goto L26;
        r15 = null;
    L26:
        String r16 = (String) r15;
        if (r16 == null) goto L16;
        r7.put(r12, r16);
    L22:
        r15 = null;
    L30:
        if (r7.get("is_from_personal") != null) goto L33;
        r7.put("is_from_personal", "0");
    L33:
        if (r7.get("collect_experiment_value") != null) goto L35;
        r7.put("collect_experiment_value", "2");
    L35:
        CharSequence r17 = (CharSequence) r7.get("previous_page");
        boolean r18 = false;
        if (r17 != null) goto L38;
    L41:
        boolean r19 = true;
    L42:
        if (r19 == true) goto L44;
    L50:
        CharSequence r20 = (CharSequence) r7.get("ecom_scene_id");
        if (r20 != null) goto L53;
    L56:
        boolean r21 = true;
    L57:
        if (r21 == false) goto L76;
        String r22 = (String) r7.get("entrance_info");
        if (r22 == null) goto L76;
        Result.Companion r23 = Result.Companion;     // Catch: Throwable -> L62
        Object r24 = Result.constructor-impl(new JSONObject(r22).optString("ecom_scene_id"));     // Catch: Throwable -> L62
    L65:
        if (Result.isFailure-impl(r24) == false) goto L67;
        r24 = null;
    L67:
        Fragment r25 = (String) r24;
        if (r25 == null) goto L76;
        if (r25.length() <= 0) goto L72;
        r18 = true;
    L72:
        if (r18 == false) goto L74;
        r2 = r25;
    L74:
        if (r2 == null) goto L76;
        r7.put("ecom_scene_id", r2);
    L62:
        th = move-exception;
        Result.Companion r26 = Result.Companion;
        r24 = Result.constructor-impl(ResultKt.createFailure(th));
    L76:
        r2 = r6.a(this, r7);
        goto L77
    L53:
        if (r20.length() == 0) goto L56;
        r21 = false;
        goto L57
    L44:
        if (Intrinsics.areEqual((String) r7.get(SimilarProductParam.ENTER_FROM), "toolbar_a1.b8094") == false) goto L46;
        String r27 = "product_detail";
    L49:
        r7.put("previous_page", r27);
        goto L50
    L46:
        r27 = (String) r7.get("history_path");
        if (r27 != null) goto L49;
        r27 = "";
        goto L49
    L38:
        if (r17.length() == 0) goto L41;
        r19 = false;
    L77:
        r3 = r2;
    L78:
        if (r3 != null) goto L80;
        return;
    L80:
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r1, r3, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, "user_favorites_type_fragment_tag", 2131367728) == true) goto L83;
        r1 = r1.replace(2131367728, r3, "user_favorites_type_fragment_tag");
    L83:
        r1.commit();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(ECFavoriteActivity.class.getName()));
    L5:
        super.onDestroy();
        ImmersionBar.with(this).destroy();
    }

    public ECFavoriteActivity() {
        this.j = "h5";
    }

    /* JADX WARN: Multi-variable type inference failed */
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

    /* JADX WARN: Multi-variable type inference failed */
    public final void y1() {
        ImmersionBar.with(this).statusBarColor(2131109391).statusBarDarkFont(true).navigationBarColor(2131109391).init();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r12) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (f.f(this) == false) goto L10;
        f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        super.onCreate(r12);
        overridePendingTransition(2130772256, 2130772257);
        setContentView(2131560700);
        Intent r5 = getIntent();
        if (r5 == null) goto L52;
        String r7 = r5.getStringExtra(SimilarProductParam.ENTER_FROM);
        if (r7 != null) goto L15;
        r7 = "h5";
    L15:
        this.j = r7;
        String r8 = r5.getStringExtra("enter_method");
        if (r8 != null) goto L18;
        r8 = "click_h5";
    L18:
        this.k = r8;
        this.l = r5.getStringExtra("tab_name");
        JSONObject r9 = new JSONObject();
    L50:
        th = move-exception;
        th.printStackTrace();
        goto L52
    L20:
        if (TextUtils.isEmpty(this.j) == true) goto L23;
        r9.put(SimilarProductParam.ENTER_FROM, this.j);     // Catch: Throwable -> L50
    L23:
        if (r5.hasExtra("scene_id") == false) goto L26;
        r9.put("scene_id", String.valueOf(z1(r5, "scene_id", 0)));     // Catch: Throwable -> L50
    L26:
        if (TextUtils.isEmpty(this.k) == true) goto L29;
        String r4 = this.k;     // Catch: Throwable -> L50
        Intrinsics.checkNotNull(r4);     // Catch: Throwable -> L50
        r9.put("enter_method", r4);     // Catch: Throwable -> L50
    L29:
        if (TextUtils.isEmpty(this.l) == true) goto L31;
        String r6 = this.l;     // Catch: Throwable -> L50
        Intrinsics.checkNotNull(r6);     // Catch: Throwable -> L50
        r9.put("tab_name", r6);     // Catch: Throwable -> L50
    L31:
        int r10 = z1(r5, "group_source", -1);     // Catch: Throwable -> L50
        if (r10 == (-1)) goto L34;
        r9.put("group_source", String.valueOf(r10));     // Catch: Throwable -> L50
    L34:
        String r3 = r5.getStringExtra("episode_type");     // Catch: Throwable -> L50
        if (TextUtils.isEmpty(r3) == true) goto L37;
        Intrinsics.checkNotNull(r3);     // Catch: Throwable -> L50
        r9.put("episode_type", r3);     // Catch: Throwable -> L50
    L37:
        String r2 = r5.getStringExtra("album_id");     // Catch: Throwable -> L50
        if (TextUtils.isEmpty(r2) == true) goto L40;
        Intrinsics.checkNotNull(r2);     // Catch: Throwable -> L50
        r9.put("album_id", r2);     // Catch: Throwable -> L50
    L40:
        String r1 = r5.getStringExtra("episode_id");     // Catch: Throwable -> L50
        if (TextUtils.isEmpty(r1) == true) goto L43;
        Intrinsics.checkNotNull(r1);     // Catch: Throwable -> L50
        r9.put("episode_id", r1);     // Catch: Throwable -> L50
    L43:
        String r0 = r5.getStringExtra("group_id");     // Catch: Throwable -> L50
        if (TextUtils.isEmpty(r0) == true) goto L47;
        Intrinsics.checkNotNull(r0);     // Catch: Throwable -> L50
        r9.put("group_id", r0);     // Catch: Throwable -> L50
    L47:
        if (TextUtils.isEmpty(this.l) == true) goto L52;
        com.bytedance.android.ec.sdk.helper.g.a.logV3("enter_personal_favourite", r9);     // Catch: Throwable -> L50
    L52:
        init();
    }

    public static int z1(Intent r0, String r1, int r2) {
        Bundle r3 = r0.getExtras();
        if (r3 == null) goto L5;
        Object r4 = r3.get(r1);
    L7:
        if ((r4 instanceof Number) == false) goto L10;
        return ((Number) r4).intValue();
    L10:
        if ((r4 instanceof String) == false) goto L16;
        Integer r5 = StringsKt.toIntOrNull((String) r4);
        if (r5 != null) goto L14;
        return r2;
    L14:
        return r5.intValue();
    L16:
        return r2;
    L5:
        r4 = null;
        goto L7
    }
}
