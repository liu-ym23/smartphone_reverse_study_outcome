package com.bytedance.ee.bear.debug.fgpreview;

import android.R;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
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
import com.bytedance.ee.bear.document.imageviewer.diagram.DiagramData$RESULT;
import com.bytedance.ee.bear.facade.common.BaseActivity;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.util.ui.j;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0014J \u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0015H\u0002R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ee/bear/debug/fgpreview/FGPreviewActivity;", "Lcom/bytedance/ee/bear/facade/common/BaseActivity;", "<init>", "()V", "recyclerViewFromXml", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerViewFromXml", "()Landroidx/recyclerview/widget/RecyclerView;", "setRecyclerViewFromXml", "(Landroidx/recyclerview/widget/RecyclerView;)V", "infoProvideService", "Lcom/bytedance/ee/bear/contract/InfoProvideService;", "getInfoProvideService", "()Lcom/bytedance/ee/bear/contract/InfoProvideService;", "onDoCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "buildRequestInfo", "Lcom/bytedance/ee/bear/contract/NetService$Request;", "did", "", "uid", "tenantId", "Companion", "dev-tools-debug-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FGPreviewActivity extends BaseActivity {
    public RecyclerView c;

    public static final class Companion {

        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00020\u0001B\u0011\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/ee/bear/debug/fgpreview/FGPreviewActivity$Companion$FGConfigResult;", "Lcom/bytedance/ee/bear/contract/Result;", "Ljava/util/HashMap;", "", "jsonObj", "Lorg/json/JSONObject;", "<init>", "(Lorg/json/JSONObject;)V", "getJsonObj", "()Lorg/json/JSONObject;", "dev-tools-debug-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class FGConfigResult extends Result<HashMap<String, String>> {
            private final JSONObject jsonObj;

            public final JSONObject getJsonObj() {
                return this.jsonObj;
            }

            public FGConfigResult(JSONObject r1) {
                this.jsonObj = r1;
            }
        }

        public static final class a implements NetService.c<FGConfigResult> {
            public a() {
            }

            @Override // com.bytedance.ee.bear.contract.NetService.c
            public final Result parse(String r8) {
                Intrinsics.checkNotNullParameter(r8, "json");
                HashMap r3 = new HashMap();
                JSONObject r4 = null;
            L8:
                e = move-exception;
                tt5.a.e("FGPreviewActivity", "parse: error", e, false);
            L10:
                FGConfigResult r9 = new FGConfigResult(r4);
                r9.data = r3;
                return r9;
            L4:
                if (new JSONObject(r8).optInt("code") != 0) goto L6;
                r4 = new JSONObject(r8).optJSONObject("data");     // Catch: JSONException -> L8
                tt5.a.h("FGPreviewActivity", "parse: data = " + r4);     // Catch: JSONException -> L8
                r3 = ox4.b.a(r4);     // Catch: JSONException -> L8
            L12:
                goto L10
            L6:
                tt5.a.d("FGPreviewActivity", "parse: request fail, json = " + r8);     // Catch: JSONException -> L8
                goto L12
            }
        }
    }

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ EditText a;
        public final /* synthetic */ FGPreviewActivity b;

        public a(EditText r1, FGPreviewActivity r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            String r4 = StringsKt.trim(this.a.getText().toString()).toString();
            Boolean r5 = (Boolean) com.bytedance.ee.bear.appsetting.c.a.a.d(r4, Boolean.FALSE);
            Toast.showCenterToast(this.b, String.valueOf(r5), 1);
        }
    }

    public static final class b<T1, T2, R> implements BiFunction {
        public static final b<T1, T2, R> a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final Object apply(Object r4, Object r5) {
            Companion.FGConfigResult r6 = (Companion.FGConfigResult) r4;
            Companion.FGConfigResult r7 = (Companion.FGConfigResult) r5;
            Intrinsics.checkNotNullParameter(r6, "rcConfig");
            Intrinsics.checkNotNullParameter(r7, "gaConfig");
            return new ox4.a(r6.getJsonObj(), r7.getJsonObj(), (HashMap) r6.data, (HashMap) r7.data);
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ FGPreviewActivity a;

        public c(FGPreviewActivity r1) {
            this.a = r1;
        }

        public final void accept(Object r5) {
            ox4.a r6 = (ox4.a) r5;
            Intrinsics.checkNotNull(r6);
            this.a.D1().setAdapter(new FGPreviewAdapter(r6));
            this.a.D1().addItemDecoration(new DividerItemDecoration(this.a, 1));
            this.a.D1().setLayoutManager(new LinearLayoutManager(this.a));
            tt5.a.b("FGPreviewActivity", "rc result: " + r6.c + ", ga result: " + r6.d);
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ FGPreviewActivity a;

        public d(FGPreviewActivity r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            j.c(new com.bytedance.ee.bear.debug.fgpreview.a(this.a));
            tt5.a.f("FGPreviewActivity", (Throwable) r3, false);
        }
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final RecyclerView D1() {
        RecyclerView r0 = this.c;
        if (r0 != null) goto L6;
        r0 = findViewById(2131384071);
        this.c = r0;
    L6:
        return r0;
    }

    /* JADX INFO: Removed unreachable split cross block B:51:0x0104 */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ee.bear.facade.common.BaseActivity, com.bytedance.ee.bear.facade.common.BaseCommonActivity, com.bytedance.ee.bear.facade.common.LifeCycleActivity
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(FGPreviewActivity.class.getName()));
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

    @Override // com.bytedance.ee.bear.facade.common.BaseActivity, com.bytedance.ee.bear.facade.common.BaseCommonActivity, com.bytedance.ee.bear.facade.common.LifeCycleActivity
    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(FGPreviewActivity.class.getName()));
    L5:
        super.onDestroy();
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

    public FGPreviewActivity() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ee.bear.facade.common.BaseActivity
    public final void B1(Bundle r5) {
        if (((z) org.koin.java.a.c(z.class, null, null, 6)).isDebugEnabled(this) == true) goto L5;
        finish();
    L5:
        setContentView(2131558478);
        EditText r6 = (EditText) findViewById(2131372325);
        ((Button) findViewById(2131372326)).setOnClickListener(new a(r6, this));
        NetService r7 = (NetService) org.koin.java.a.c(NetService.class, null, null, 6);
        Flowable.zip(r7.Vc(new Companion.a()).a(C1("68617655291", "6641719470769307912", DiagramData$RESULT.SUCCESS)), r7.Vc(new Companion.a()).a(C1("61893416078", "6650021622726017288", "2")), b.a).observeOn(fo5.d.d()).subscribe(new c(this), new d(this));
    }

    public static NetService.f C1(String r3, String r4, String r5) {
        HashMap r0 = new HashMap();
        r0.put("appId", "2");
        r0.put("version", "online-1.0");
        r0.put("platform", "android");
        r0.put("device_id", r3);
        r0.put("user_id", r4);
        r0.put("tenant_id", r5);
        NetService.f r6 = new NetService.f("/api/appconfig/get/");
        r6.c = 1;
        r6.d(r0);
        tt5.a.h("FGPreviewActivity", "buildRequestInfo: " + r0);
        return r6;
    }
}
