package com.bytedance.ee.bear.debug;

import android.R;
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
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 +2\u00020\u0001:\u0004+,-.B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'H\u0014J\b\u0010(\u001a\u00020%H\u0002J\b\u0010)\u001a\u00020%H\u0002J\b\u0010*\u001a\u00020%H\u0002R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u0004\u0018\u00010\u000b8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u00118FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00118FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001cX\u0082.¢\u0006\u0002\n\u0000R\u001e\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020 0\u001fj\b\u0012\u0004\u0012\u00020 `!X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/bytedance/ee/bear/debug/AppendParamsActivity;", "Lcom/bytedance/ee/bear/facade/common/BaseActivity;", "<init>", "()V", "titleBarFromXml", "Lcom/bytedance/ee/bear/widgets/BaseTitleBar;", "getTitleBarFromXml", "()Lcom/bytedance/ee/bear/widgets/BaseTitleBar;", "setTitleBarFromXml", "(Lcom/bytedance/ee/bear/widgets/BaseTitleBar;)V", "paramsRvFromXml", "Landroidx/recyclerview/widget/RecyclerView;", "getParamsRvFromXml", "()Landroidx/recyclerview/widget/RecyclerView;", "setParamsRvFromXml", "(Landroidx/recyclerview/widget/RecyclerView;)V", "confirmBtnFromXml", "Landroid/widget/Button;", "getConfirmBtnFromXml", "()Landroid/widget/Button;", "setConfirmBtnFromXml", "(Landroid/widget/Button;)V", "clearBtnFromXml", "getClearBtnFromXml", "setClearBtnFromXml", "appendParamsSP", "Landroid/content/SharedPreferences;", "title", "", "toastMsg", "paramsList", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/debug/AppendParamsActivity$ParamsItem;", "Lkotlin/collections/ArrayList;", "adapter", "Lcom/bytedance/ee/bear/debug/AppendParamsActivity$ParamsAdapter;", "onDoCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "initFromIntent", "initData", "initView", "Companion", "ParamsItem", "ParamsAdapter", "TextWatcherImpl", "dev-tools-debug-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppendParamsActivity extends BaseActivity {
    public BaseTitleBar c;
    public RecyclerView d;
    public Button e;
    public Button f;
    public SharedPreferences g;
    public String h;
    public String i;
    public final ArrayList<b> j;
    public final ParamsAdapter k;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0002H\u0014J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0003H\u0016¨\u0006\f"}, d2 = {"Lcom/bytedance/ee/bear/debug/AppendParamsActivity$ParamsAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/bytedance/ee/bear/debug/AppendParamsActivity$ParamsItem;", "Lcom/chad/library/adapter/base/BaseViewHolder;", "<init>", "()V", "convert", "", "helper", "paramsItem", "onViewRecycled", "holder", "dev-tools-debug-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ParamsAdapter extends BaseQuickAdapter<b, BaseViewHolder> {
        public ParamsAdapter() {
            super(2131561657);
        }

        public final void onViewRecycled(RecyclerView.ViewHolder r5) {
            BaseViewHolder r6 = (BaseViewHolder) r5;
            Intrinsics.checkNotNullParameter(r6, "holder");
            super/*androidx.recyclerview.widget.RecyclerView.Adapter*/.onViewRecycled(r6);
            Object r0 = ((RecyclerView.ViewHolder) r6).itemView.findViewById(2131381921).getTag(2131388154);
            if ((r0 instanceof TextWatcher) == false) goto L5;
            ((RecyclerView.ViewHolder) r6).itemView.findViewById(2131381921).removeTextChangedListener((TextWatcher) r0);
        L5:
            Object r1 = ((RecyclerView.ViewHolder) r6).itemView.findViewById(2131381923).getTag(2131388154);
            if ((r1 instanceof TextWatcher) == false) goto L9;
            ((RecyclerView.ViewHolder) r6).itemView.findViewById(2131381923).removeTextChangedListener((TextWatcher) r1);
            return;
        }

        public final void convert(BaseViewHolder r5, Object r6) {
            b r7 = (b) r6;
            Intrinsics.checkNotNullParameter(r5, "helper");
            Intrinsics.checkNotNullParameter(r7, "paramsItem");
            View r8 = ((RecyclerView.ViewHolder) r5).itemView;
            r8.findViewById(2131381921).setText(r7.a);
            r8.findViewById(2131381923).setText(r7.b);
            com.bytedance.ee.bear.debug.b r2 = new com.bytedance.ee.bear.debug.b(r7);
            r8.findViewById(2131381921).addTextChangedListener(r2);
            r8.findViewById(2131381921).setTag(2131388154, r2);
            com.bytedance.ee.bear.debug.c r0 = new com.bytedance.ee.bear.debug.c(r7);
            r8.findViewById(2131381923).addTextChangedListener(r0);
            r8.findViewById(2131381923).setTag(2131388154, r0);
            ((ImageView) r8.findViewById(2131368779)).setOnClickListener(new com.bytedance.ee.bear.debug.a(this, r7));
        }
    }

    public static final class a {
    }

    public static final class b {
        public String a;
        public String b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "ParamsItem(key=" + this.a + ", value=" + this.b + ')';
        }

        public b(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "key");
            Intrinsics.checkNotNullParameter(r3, "value");
            this.a = r2;
            this.b = r3;
        }
    }

    public static abstract class c implements TextWatcher {
        public c() {
        }

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
        }
    }

    static {
    }

    /* JADX INFO: Removed unreachable split cross block B:51:0x0104 */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ee.bear.facade.common.BaseActivity, com.bytedance.ee.bear.facade.common.BaseCommonActivity, com.bytedance.ee.bear.facade.common.LifeCycleActivity
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(AppendParamsActivity.class.getName()));
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
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(AppendParamsActivity.class.getName()));
    L5:
        super.onDestroy();
    }

    public AppendParamsActivity() {
        this.j = new ArrayList();
        this.k = new ParamsAdapter();
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
    @Override // com.bytedance.ee.bear.facade.common.BaseActivity
    public final void B1(Bundle r8) {
        setContentView(2131558443);
        Intent r9 = getIntent();
        if (r9 == null) goto L6;
        String r10 = r9.getStringExtra("key_sp_name");
        if (r10 == null) goto L6;
    L7:
        this.g = eu5.b.a.getSharedPreferences(r10, 0);
        Intent r11 = getIntent();
        if (r11 == null) goto L11;
        String r12 = r11.getStringExtra("key_title");
        if (r12 == null) goto L11;
    L12:
        this.h = r12;
        Intent r13 = getIntent();
        if (r13 == null) goto L16;
        String r14 = r13.getStringExtra("key_success_toast");
        if (r14 == null) goto L16;
    L17:
        this.i = r14;
        SharedPreferences r16 = this.g;
        String r2 = null;
        if (r16 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("appendParamsSP");
        r16 = null;
    L20:
        Map<String, ?> r17 = r16.getAll();
        Intrinsics.checkNotNull(r17, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");
        Iterator<Map.Entry<String, ?>> r18 = r17.entrySet().iterator();
    L22:
        if (r18.hasNext() == false) goto L25;
        Map.Entry<String, ?> r3 = r18.next();
        this.j.add(new b(r3.getKey(), (String) r3.getValue()));
        goto L22
    L25:
        if (this.j.isEmpty() == false) goto L27;
        this.j.add(new b("", ""));
    L27:
        BaseTitleBar r19 = this.c;
        if (r19 != null) goto L30;
        r19 = findViewById(2131388775);
        this.c = r19;
    L30:
        BaseTitleBar r20 = r19;
        String r4 = this.h;
        if (r4 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("title");
    L34:
        r20.setTitle(r2);
        BaseTitleBar r21 = this.c;
        if (r21 != null) goto L37;
        r21 = findViewById(2131388775);
        this.c = r21;
    L37:
        r21.a(new d(this), true);
        this.k.setNewData(this.j);
        RecyclerView r22 = this.d;
        if (r22 != null) goto L40;
        r22 = findViewById(2131381922);
        this.d = r22;
    L40:
        r22.setLayoutManager(new LinearLayoutManager(this, 1, false));
        RecyclerView r23 = this.d;
        if (r23 != null) goto L43;
        r23 = findViewById(2131381922);
        this.d = r23;
    L43:
        r23.setAdapter(this.k);
        KeyEvent.Callback r24 = this.e;
        if (r24 != null) goto L46;
        r24 = findViewById(2131367640);
        this.e = (Button) r24;
    L46:
        ((Button) r24).setOnClickListener(new e(this));
        KeyEvent.Callback r26 = this.f;
        if (r26 != null) goto L49;
        r26 = findViewById(2131366928);
        this.f = (Button) r26;
    L49:
        ((Button) r26).setOnClickListener(new f(this));
        return;
    L33:
        r2 = r4;
    L16:
        r14 = "保存成功";
    L11:
        r12 = "";
    L6:
        r10 = "append_params_sp";
        goto L7
    }
}
