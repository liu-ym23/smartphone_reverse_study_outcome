package com.bytedance.ee.bear.debug.fgpreview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.contract.z;
import com.bytedance.ee.bear.facade.common.BaseActivity;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.util.ui.j;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.Flowable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0014J \u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0015H\u0002R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ee/bear/debug/fgpreview/FGPreviewActivity;", "Lcom/bytedance/ee/bear/facade/common/BaseActivity;", "<init>", "()V", "recyclerViewFromXml", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerViewFromXml", "()Landroidx/recyclerview/widget/RecyclerView;", "setRecyclerViewFromXml", "(Landroidx/recyclerview/widget/RecyclerView;)V", "infoProvideService", "Lcom/bytedance/ee/bear/contract/InfoProvideService;", "getInfoProvideService", "()Lcom/bytedance/ee/bear/contract/InfoProvideService;", "onDoCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "buildRequestInfo", "Lcom/bytedance/ee/bear/contract/NetService$Request;", com.bytedance.android.ec.core.event.a.KEY_DID, "", "uid", "tenantId", "Companion", "dev-tools-debug-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FGPreviewActivity extends BaseActivity {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public RecyclerView f217376c;

    public static final class Companion {

        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00020\u0001B\u0011\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/ee/bear/debug/fgpreview/FGPreviewActivity$Companion$FGConfigResult;", "Lcom/bytedance/ee/bear/contract/Result;", "Ljava/util/HashMap;", "", "jsonObj", "Lorg/json/JSONObject;", "<init>", "(Lorg/json/JSONObject;)V", "getJsonObj", "()Lorg/json/JSONObject;", "dev-tools-debug-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class FGConfigResult extends Result<HashMap<String, String>> {
            private final JSONObject jsonObj;

            public final JSONObject getJsonObj() {
                return this.jsonObj;
            }

            public FGConfigResult(JSONObject r100) {
                this.jsonObj = r100;
            }
        }

        public static final class a implements NetService.c<FGConfigResult> {
            public a() {
            }

            @Override // com.bytedance.ee.bear.contract.NetService.c
            public final Result parse(String r100) {
                Intrinsics.checkNotNullParameter(r100, "json");
                HashMap r101 = new HashMap();
                JSONObject r102 = null;
            L8:
                e = move-exception;
                tt5.a.e("FGPreviewActivity", "parse: error", e, false);
            L10:
                FGConfigResult r103 = new FGConfigResult(r102);
                r103.data = r101;
                return r103;
            L4:
                if (new JSONObject(r100).optInt("code") != 0) goto L6;
                r102 = new JSONObject(r100).optJSONObject("data");     // Catch: JSONException -> L8
                tt5.a.h("FGPreviewActivity", "parse: data = " + r102);     // Catch: JSONException -> L8
                r101 = ox4.b.a(r102);     // Catch: JSONException -> L8
            L12:
                goto L10
            L6:
                tt5.a.d("FGPreviewActivity", "parse: request fail, json = " + r100);     // Catch: JSONException -> L8
                goto L12
            }
        }
    }

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ EditText f217377a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ FGPreviewActivity f217378b;

        public a(EditText r100, FGPreviewActivity r101) {
            this.f217377a = r100;
            this.f217378b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            String r101 = StringsKt.trim(this.f217377a.getText().toString()).toString();
            Boolean r102 = (Boolean) com.bytedance.ee.bear.appsetting.c.a.f206237a.d(r101, Boolean.FALSE);
            Toast.showCenterToast(this.f217378b, String.valueOf(r102), 1);
        }
    }

    public static final class b<T1, T2, R> implements BiFunction {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b<T1, T2, R> f217379a = null;

        static {
            f217379a = new b();
        }

        public b() {
        }

        @Override // io.reactivex.functions.BiFunction
        public final Object apply(Object r100, Object r101) {
            Companion.FGConfigResult r102 = (Companion.FGConfigResult) r100;
            Companion.FGConfigResult r103 = (Companion.FGConfigResult) r101;
            Intrinsics.checkNotNullParameter(r102, "rcConfig");
            Intrinsics.checkNotNullParameter(r103, "gaConfig");
            return new ox4.a(r102.getJsonObj(), r103.getJsonObj(), (HashMap) r102.data, (HashMap) r103.data);
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FGPreviewActivity f217380a;

        public c(FGPreviewActivity r100) {
            this.f217380a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            ox4.a r101 = (ox4.a) r100;
            Intrinsics.checkNotNull(r101);
            this.f217380a.D1().setAdapter(new FGPreviewAdapter(r101));
            this.f217380a.D1().addItemDecoration(new DividerItemDecoration(this.f217380a, 1));
            this.f217380a.D1().setLayoutManager(new LinearLayoutManager(this.f217380a));
            tt5.a.b("FGPreviewActivity", "rc result: " + r101.f527082c + ", ga result: " + r101.f527083d);
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FGPreviewActivity f217381a;

        public d(FGPreviewActivity r100) {
            this.f217381a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            j.c(new com.bytedance.ee.bear.debug.fgpreview.a(this.f217381a));
            tt5.a.f("FGPreviewActivity", (Throwable) r100, false);
        }
    }

    static {
    }

    public final RecyclerView D1() {
        KeyEvent.Callback r100 = this.f217376c;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.recyclerView);
        this.f217376c = (RecyclerView) r100;
    L6:
        return (RecyclerView) r100;
    }

    /* JADX INFO: Removed unreachable split cross block B:51:0x0104 */
    @Override // com.bytedance.ee.bear.facade.common.BaseActivity, com.bytedance.ee.bear.facade.common.BaseCommonActivity, com.bytedance.ee.bear.facade.common.LifeCycleActivity, com.larksuite.component.air.WindowInsetsCompatAirActivity, com.larksuite.component.air.AirActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r100 = FLogger.f375446a;
        r100.i("ActivityLancet", "finish ".concat(FGPreviewActivity.class.getName()));
        long r101 = SystemClock.uptimeMillis();
        Map<Activity, Long> r102 = ActivityLancet.LAST_FINISH_HANDLED_MS;
        monitor-enter(r102);
        Long r103 = r102.get(this);     // Catch: Throwable -> L45
        if (r103 != null) goto L10;
    L13:
        r102.put(this, Long.valueOf(r101));     // Catch: Throwable -> L45
        monitor-exit(r102);     // Catch: Throwable -> L45
    L42:
        th = move-exception;
        FLogger.f375446a.e("ActivityLancet", "handle onBackPressed strategy failed", th);
    L48:
        return;
    L16:
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L19;
        r100.i("ActivityLancet", "quit !resume, current state = " + getLifecycle().getCurrentState());     // Catch: Throwable -> L42
        goto L48
    L19:
        if (isFinishing() == true) goto L22;
        r100.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L42
        goto L48
    L22:
        if (ActivityStartBehavior.isInternalActivityConsumed(this) == true) goto L25;
        r100.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L42
        goto L48
    L25:
        if (ActivityLancet.isOnlyActivityInTask(this) == true) goto L28;
        r100.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L42
        goto L48
    L28:
        if (ActivityLancet.isExcludedActivity(this) == false) goto L31;
        r100.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L42
        goto L48
    L31:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L33;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L42
        goto L48
    L33:
        Intent r104 = getPackageManager().getLaunchIntentForPackage(getPackageName());     // Catch: Throwable -> L42
        if (r104 == null) goto L48;
        r104.addFlags(268435456);     // Catch: Throwable -> L42
        r104.addFlags(2097152);     // Catch: Throwable -> L42
        r100.i("ActivityLancet", "start launcher intent after backPressed, activity=" + this);     // Catch: Throwable -> L42
        startActivity(r104);     // Catch: Throwable -> L39
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.slide_out_right);     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        FLogger.f375446a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L42
        goto L48
    L10:
        if ((r101 - r103.longValue()) >= 800) goto L13;
        monitor-exit(r102);     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseActivity, com.bytedance.ee.bear.facade.common.BaseCommonActivity, com.bytedance.ee.bear.facade.common.LifeCycleActivity, com.larksuite.component.air.WindowInsetsCompatAirActivity, com.larksuite.component.air.AirActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.f375446a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(FGPreviewActivity.class.getName()));
    L5:
        super.onDestroy();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
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

    public FGPreviewActivity() {
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseActivity
    public final void B1(Bundle r100) {
        if (((z) org.koin.java.a.c(z.class, null, null, 6)).isDebugEnabled(this) == true) goto L5;
        finish();
    L5:
        setContentView(R.layout.activity_fg_preview);
        EditText r101 = (EditText) findViewById(R.id.fg_input);
        ((Button) findViewById(R.id.fg_look)).setOnClickListener(new a(r101, this));
        NetService r102 = (NetService) org.koin.java.a.c(NetService.class, null, null, 6);
        Flowable.zip(r102.Vc(new Companion.a()).a(C1("68617655291", "6641719470769307912", "1")), r102.Vc(new Companion.a()).a(C1("61893416078", "6650021622726017288", "2")), b.f217379a).observeOn(fo5.d.d()).subscribe(new c(this), new d(this));
    }

    public static NetService.f C1(String r100, String r101, String r102) {
        HashMap r103 = new HashMap();
        r103.put("appId", "2");
        r103.put("version", "online-1.0");
        r103.put("platform", "android");
        r103.put("device_id", r100);
        r103.put("user_id", r101);
        r103.put("tenant_id", r102);
        NetService.f r104 = new NetService.f("/api/appconfig/get/");
        r104.f216906c = 1;
        r104.d(r103);
        tt5.a.h("FGPreviewActivity", "buildRequestInfo: " + r103);
        return r104;
    }
}
