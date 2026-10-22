package com.bytedance.ee.bear.lynx.impl.page;

import android.R;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.lifecycle.Lifecycle;
import com.bytedance.ee.bear.facade.common.BaseActivity;
import com.bytedance.ee.bear.lynx.api.CCMLynxCardView;
import com.bytedance.ee.bear.lynx.impl.route.c;
import com.bytedance.ies.xbridge.XBridgeMethod;
import com.larksuite.framework.utils.UIUtils;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.lark.insets.WindowInsetsUtils;
import dc9.d;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ta5.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0005\b&\u0018\u0000 *2\u00020\u00012\u00020\u0002:\u0001*B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0014J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0015\u001a\u00020\rH\u0014J\u0010\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u0018H$J\u0010\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u0018H$J\u0010\u0010\u001b\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u0018H$J\u0010\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u0018H$J\u0006\u0010\u001d\u001a\u00020\rJ\u0006\u0010\u001e\u001a\u00020\rJ\u0006\u0010\u001f\u001a\u00020\rJ\u0006\u0010 \u001a\u00020\rJ\u001c\u0010!\u001a\u00020\r2\u0006\u0010\"\u001a\u00020#2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%J\b\u0010'\u001a\u00020#H\u0016J\b\u0010(\u001a\u00020#H\u0016J\b\u0010)\u001a\u00020\rH\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/bytedance/ee/bear/lynx/impl/page/AbsLynxPageActivity;", "Lcom/bytedance/ee/bear/facade/common/BaseActivity;", "Lcom/bytedance/ee/bear/lynx/impl/route/RouterAbilityProvider;", "<init>", "()V", "uri", "Landroid/net/Uri;", "titleContainer", "Landroid/widget/FrameLayout;", "contentContainer", "ccmLynxCardView", "Lcom/bytedance/ee/bear/lynx/api/CCMLynxCardView;", "onDoCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "checkFieldInitIsValid", "", "onDestroy", "onShowLoading", "loadingContainer", "Landroid/view/ViewGroup;", "onShowError", "errorContainer", "onHideLoading", "onHideError", "showLoading", "hideLoading", "showError", "hideError", "sendEvent", "eventName", "", "params", "", "", "getBid", "getContainerId", "close", "Companion", "features-lynx-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbsLynxPageActivity extends BaseActivity implements c {
    public Uri c;
    public FrameLayout d;
    public FrameLayout e;
    public CCMLynxCardView f;

    public static final class a {
    }

    public static final class b implements CCMLynxCardView.b {
        public final /* synthetic */ AbsLynxPageActivity a;

        @Override // com.bytedance.ee.bear.lynx.api.CCMLynxCardView.b
        public final void a(Map<String, String> r1) {
        }

        @Override // com.bytedance.ee.bear.lynx.api.CCMLynxCardView.b
        public final void onShow() {
        }

        @Override // com.bytedance.ee.bear.lynx.api.CCMLynxCardView.b
        public final void H() {
            this.a.finish();
        }

        public b(AbsLynxPageActivity r1) {
            this.a = r1;
        }
    }

    static {
    }

    public abstract void C1(ViewGroup r1);

    public abstract void D1(ViewGroup r1);

    /* JADX INFO: Removed unreachable split cross block B:53:0x0106 */
    /* JADX WARN: Multi-variable type inference failed */
    public void finish() {
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

    public void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(getClass().getName()));
    L5:
        super.onDestroy();
        CCMLynxCardView r0 = this.f;
        if (r0 == null) goto L9;
        r0.destroy();
        return;
    }

    public AbsLynxPageActivity() {
    }

    @Override // com.bytedance.ee.bear.lynx.impl.route.c
    public final void close() {
        finish();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void B1(Bundle r9) {
        Intent r10 = getIntent();
        if (r10 == null) goto L7;
        Uri r11 = r10.getData();
        if (r11 == null) goto L7;
        this.c = r11;
    L7:
        setContentView(2131563605);
        this.d = (FrameLayout) findViewById(2131379308);
        this.e = (FrameLayout) findViewById(2131379283);
        Serializable r1 = null;
        CCMLynxCardView r12 = (CCMLynxCardView) org.koin.java.a.c(CCMLynxCardView.class, null, new AbsLynxPageActivity$onDoCreate$2(this), 2);
        this.f = r12;
        if (this.c != null) goto L10;
    L13:
        boolean r13 = false;
    L14:
        if (r13 == true) goto L17;
        finish();
        return;
    L17:
        Intent r14 = getIntent();
        if (r14 == null) goto L22;
        Bundle r15 = r14.getExtras();
        if (r15 == null) goto L22;
        Object r16 = r15.get("template-data-bundle-key");
    L24:
        if ((r16 instanceof HashMap) == false) goto L26;
        HashMap r5 = (HashMap) r16;
    L27:
        Intent r17 = getIntent();
        if (r17 == null) goto L32;
        Bundle r18 = r17.getExtras();
        if (r18 == null) goto L32;
        String r7 = r18.getString("share-context-ID");
    L33:
        Intent r19 = getIntent();
        if (r19 == null) goto L40;
        Bundle r20 = r19.getExtras();
        if (r20 == null) goto L40;
        Bundle r21 = r20.getBundle("ori-bundle");
        if (r21 == null) goto L40;
        int r22 = r21.getInt("status-bar-and-navigator-color", -1);
    L41:
        if (r22 == (-1)) goto L45;
        g r2 = vb(g.class);
        if (r2 == null) goto L45;
        r2.k(r22);
        WindowInsetsUtils.c(r2.a).i(UIUtils.getColor(r2.a, r22));
    L45:
        CCMLynxCardView r3 = this.f;
        if (r3 == null) goto L53;
        FrameLayout r4 = this.e;
        Intrinsics.checkNotNull(r4);
        Uri r23 = this.c;
        if (r23 == null) goto L51;
        String r24 = r23.toString();
        if (r24 == null) goto L51;
    L52:
        r3.a(r4, r24, r5, new ViewGroup.LayoutParams(-1, -1), r7);
    L51:
        r24 = "";
    L53:
        CCMLynxCardView r25 = this.f;
        if (r25 == null) goto L56;
        r25.f(new b(this));
    L56:
        XBridgeMethod r26 = new je5.b(this);
        CCMLynxCardView r0 = this.f;
        if (r0 == null) goto L59;
        r0.h(r26.c, r26);
    L59:
        Intent r27 = getIntent();
        if (r27 == null) goto L64;
        Bundle r28 = r27.getExtras();
        if (r28 == null) goto L64;
        r1 = r28.getSerializable("biz-method");
    L64:
        ArrayList r6 = (ArrayList) r1;
        if (r6 == null) goto L72;
        Iterator r29 = r6.iterator();
    L68:
        if (r29.hasNext() == false) goto L78;
        XBridgeMethod r8 = (XBridgeMethod) ((Class) r29.next()).newInstance();
        CCMLynxCardView r30 = this.f;
        if (r30 == null) goto L68;
        String r31 = r8.getName();
        Intrinsics.checkNotNull(r8);
        r30.h(r31, r8);
        goto L68
    L78:
        return;
    L72:
        return;
    L40:
        r22 = -1;
    L32:
        r7 = null;
        goto L33
    L26:
        r5 = null;
    L22:
        r16 = null;
        goto L24
    L10:
        if (this.e == null) goto L13;
        if (r12 == null) goto L13;
        r13 = true;
        goto L14
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onConfigurationChanged(Configuration r5) {
        Intrinsics.checkNotNullParameter(r5, "newConfig");
        super/*com.bytedance.ee.bear.facade.common.BaseCommonActivity*/.onConfigurationChanged(r5);
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type android.app.Activity");     // Catch: Throwable -> L14
        if (d.a() == true) goto L16;
        int r2 = getRequestedOrientation();     // Catch: Throwable -> L14
        Integer r6 = Integer.valueOf(r5.orientation);     // Catch: Throwable -> L14
        if (r6 != null) goto L9;
    L11:
        if (r2 != 3) goto L16;
        setRequestedOrientation(1);     // Catch: Throwable -> L14
        FLogger.a.i("PadLancet", "onConfigurationChanged, phone reset page:" + getClass().getSimpleName() + " portrait");     // Catch: Throwable -> L14
        goto L16
    L9:
        if (r6.intValue() != r2) goto L11;
    L16:
        CCMLynxCardView r7 = this.f;
        if (r7 == null) goto L22;
        r7.b();
        return;
    L22:
        return;
    L14:
        th = move-exception;
        FLogger.a.e("PadLancet", "hook onConfigurationChanged error:" + th, th);
        goto L16
    }
}
