package com.bytedance.ee.bear.debug;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.facade.common.BaseActivity;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEditText;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 +2\u00020\u0001:\u0004+,-.B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'H\u0014J\b\u0010(\u001a\u00020%H\u0002J\b\u0010)\u001a\u00020%H\u0002J\b\u0010*\u001a\u00020%H\u0002R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u0004\u0018\u00010\u000b8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u00118FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00118FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001cX\u0082.¢\u0006\u0002\n\u0000R\u001e\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020 0\u001fj\b\u0012\u0004\u0012\u00020 `!X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/bytedance/ee/bear/debug/AppendParamsActivity;", "Lcom/bytedance/ee/bear/facade/common/BaseActivity;", "<init>", "()V", "titleBarFromXml", "Lcom/bytedance/ee/bear/widgets/BaseTitleBar;", "getTitleBarFromXml", "()Lcom/bytedance/ee/bear/widgets/BaseTitleBar;", "setTitleBarFromXml", "(Lcom/bytedance/ee/bear/widgets/BaseTitleBar;)V", "paramsRvFromXml", "Landroidx/recyclerview/widget/RecyclerView;", "getParamsRvFromXml", "()Landroidx/recyclerview/widget/RecyclerView;", "setParamsRvFromXml", "(Landroidx/recyclerview/widget/RecyclerView;)V", "confirmBtnFromXml", "Landroid/widget/Button;", "getConfirmBtnFromXml", "()Landroid/widget/Button;", "setConfirmBtnFromXml", "(Landroid/widget/Button;)V", "clearBtnFromXml", "getClearBtnFromXml", "setClearBtnFromXml", "appendParamsSP", "Landroid/content/SharedPreferences;", "title", "", "toastMsg", "paramsList", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/debug/AppendParamsActivity$ParamsItem;", "Lkotlin/collections/ArrayList;", "adapter", "Lcom/bytedance/ee/bear/debug/AppendParamsActivity$ParamsAdapter;", "onDoCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "initFromIntent", "initData", "initView", "Companion", "ParamsItem", "ParamsAdapter", "TextWatcherImpl", "dev-tools-debug-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppendParamsActivity extends BaseActivity {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public BaseTitleBar f217341c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public RecyclerView f217342d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Button f217343e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Button f217344f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public SharedPreferences f217345g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f217346h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f217347i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ArrayList<b> f217348j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ParamsAdapter f217349k;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0002H\u0014J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0003H\u0016¨\u0006\f"}, d2 = {"Lcom/bytedance/ee/bear/debug/AppendParamsActivity$ParamsAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/bytedance/ee/bear/debug/AppendParamsActivity$ParamsItem;", "Lcom/chad/library/adapter/base/BaseViewHolder;", "<init>", "()V", "convert", "", "helper", "paramsItem", "onViewRecycled", "holder", "dev-tools-debug-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ParamsAdapter extends BaseQuickAdapter<b, BaseViewHolder> {
        public ParamsAdapter() {
            super(R.layout.item_params_input);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final void onViewRecycled(RecyclerView.ViewHolder r100) {
            BaseViewHolder r101 = (BaseViewHolder) r100;
            Intrinsics.checkNotNullParameter(r101, "holder");
            super.onViewRecycled(r101);
            Object r102 = ((SpaceEditText) r101.itemView.findViewById(R.id.paramsKey)).getTag(R.id.tag_watcher);
            if ((r102 instanceof TextWatcher) == false) goto L5;
            ((SpaceEditText) r101.itemView.findViewById(R.id.paramsKey)).removeTextChangedListener((TextWatcher) r102);
        L5:
            Object r103 = ((SpaceEditText) r101.itemView.findViewById(R.id.paramsValue)).getTag(R.id.tag_watcher);
            if ((r103 instanceof TextWatcher) == false) goto L9;
            ((SpaceEditText) r101.itemView.findViewById(R.id.paramsValue)).removeTextChangedListener((TextWatcher) r103);
            return;
        }

        @Override // com.chad.library.adapter.base.BaseQuickAdapter
        public final void convert(BaseViewHolder r100, b r101) {
            b r102 = r101;
            Intrinsics.checkNotNullParameter(r100, "helper");
            Intrinsics.checkNotNullParameter(r102, "paramsItem");
            View r103 = r100.itemView;
            ((SpaceEditText) r103.findViewById(R.id.paramsKey)).setText(r102.f217350a);
            ((SpaceEditText) r103.findViewById(R.id.paramsValue)).setText(r102.f217351b);
            com.bytedance.ee.bear.debug.b r104 = new com.bytedance.ee.bear.debug.b(r102);
            ((SpaceEditText) r103.findViewById(R.id.paramsKey)).addTextChangedListener(r104);
            ((SpaceEditText) r103.findViewById(R.id.paramsKey)).setTag(R.id.tag_watcher, r104);
            com.bytedance.ee.bear.debug.c r105 = new com.bytedance.ee.bear.debug.c(r102);
            ((SpaceEditText) r103.findViewById(R.id.paramsValue)).addTextChangedListener(r105);
            ((SpaceEditText) r103.findViewById(R.id.paramsValue)).setTag(R.id.tag_watcher, r105);
            ((ImageView) r103.findViewById(R.id.deleteIcon)).setOnClickListener(new com.bytedance.ee.bear.debug.a(this, r102));
        }
    }

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f217350a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f217351b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f217350a, r101.f217350a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f217351b, r101.f217351b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f217350a.hashCode() * 31) + this.f217351b.hashCode();
        }

        public final String toString() {
            return "ParamsItem(key=" + this.f217350a + ", value=" + this.f217351b + ')';
        }

        public b(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "key");
            Intrinsics.checkNotNullParameter(r101, "value");
            this.f217350a = r100;
            this.f217351b = r101;
        }
    }

    public static abstract class c implements TextWatcher {
        public c() {
        }

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
        }
    }

    static {
    }

    /* JADX INFO: Removed unreachable split cross block B:51:0x0104 */
    @Override // com.bytedance.ee.bear.facade.common.BaseActivity, com.bytedance.ee.bear.facade.common.BaseCommonActivity, com.bytedance.ee.bear.facade.common.LifeCycleActivity, com.larksuite.component.air.WindowInsetsCompatAirActivity, com.larksuite.component.air.AirActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r100 = FLogger.f375446a;
        r100.i("ActivityLancet", "finish ".concat(AppendParamsActivity.class.getName()));
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
        FLogger.f375446a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(AppendParamsActivity.class.getName()));
    L5:
        super.onDestroy();
    }

    public AppendParamsActivity() {
        this.f217348j = new ArrayList();
        this.f217349k = new ParamsAdapter();
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

    @Override // com.bytedance.ee.bear.facade.common.BaseActivity
    public final void B1(Bundle r100) {
        setContentView(R.layout.activity_append_params);
        Intent r101 = getIntent();
        if (r101 == null) goto L6;
        String r102 = r101.getStringExtra("key_sp_name");
        if (r102 == null) goto L6;
    L7:
        this.f217345g = eu5.b.f474075a.getSharedPreferences(r102, 0);
        Intent r103 = getIntent();
        if (r103 == null) goto L11;
        String r104 = r103.getStringExtra("key_title");
        if (r104 == null) goto L11;
    L12:
        this.f217346h = r104;
        Intent r105 = getIntent();
        if (r105 == null) goto L16;
        String r106 = r105.getStringExtra("key_success_toast");
        if (r106 == null) goto L16;
    L17:
        this.f217347i = r106;
        SharedPreferences r107 = this.f217345g;
        String r108 = null;
        if (r107 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("appendParamsSP");
        r107 = null;
    L20:
        Map<String, ?> r109 = r107.getAll();
        Intrinsics.checkNotNull(r109, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");
        Iterator<Map.Entry<String, ?>> r110 = r109.entrySet().iterator();
    L22:
        if (r110.hasNext() == false) goto L25;
        Map.Entry<String, ?> r111 = r110.next();
        this.f217348j.add(new b(r111.getKey(), (String) r111.getValue()));
        goto L22
    L25:
        if (this.f217348j.isEmpty() == false) goto L27;
        this.f217348j.add(new b("", ""));
    L27:
        KeyEvent.Callback r112 = this.f217341c;
        if (r112 != null) goto L30;
        r112 = findViewById(R.id.titleBar);
        this.f217341c = (BaseTitleBar) r112;
    L30:
        BaseTitleBar r113 = (BaseTitleBar) r112;
        String r114 = this.f217346h;
        if (r114 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("title");
    L34:
        r113.setTitle(r108);
        KeyEvent.Callback r115 = this.f217341c;
        if (r115 != null) goto L37;
        r115 = findViewById(R.id.titleBar);
        this.f217341c = (BaseTitleBar) r115;
    L37:
        ((BaseTitleBar) r115).a(new d(this), true);
        this.f217349k.setNewData(this.f217348j);
        KeyEvent.Callback r116 = this.f217342d;
        if (r116 != null) goto L40;
        r116 = findViewById(R.id.paramsRv);
        this.f217342d = (RecyclerView) r116;
    L40:
        ((RecyclerView) r116).setLayoutManager(new LinearLayoutManager(this, 1, false));
        KeyEvent.Callback r117 = this.f217342d;
        if (r117 != null) goto L43;
        r117 = findViewById(R.id.paramsRv);
        this.f217342d = (RecyclerView) r117;
    L43:
        ((RecyclerView) r117).setAdapter(this.f217349k);
        KeyEvent.Callback r118 = this.f217343e;
        if (r118 != null) goto L46;
        r118 = findViewById(R.id.confirmBtn);
        this.f217343e = (Button) r118;
    L46:
        ((Button) r118).setOnClickListener(new e(this));
        KeyEvent.Callback r119 = this.f217344f;
        if (r119 != null) goto L49;
        r119 = findViewById(R.id.clearBtn);
        this.f217344f = (Button) r119;
    L49:
        ((Button) r119).setOnClickListener(new f(this));
        return;
    L33:
        r108 = r114;
    L16:
        r106 = "保存成功";
    L11:
        r104 = "";
    L6:
        r102 = "append_params_sp";
        goto L7
    }
}
