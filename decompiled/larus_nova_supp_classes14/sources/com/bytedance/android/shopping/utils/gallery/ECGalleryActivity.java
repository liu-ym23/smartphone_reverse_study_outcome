package com.bytedance.android.shopping.utils.gallery;

import android.R;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.Window;
import androidx.lifecycle.Lifecycle;
import com.bytedance.android.ec.core.utils.t0;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.shopping.utils.r;
import com.bytedance.ies.uikit.base.AbsActivity;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.google.gson.Gson;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/shopping/utils/gallery/ECGalleryActivity;", "Lcom/bytedance/ies/uikit/base/AbsActivity;", "<init>", "()V", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECGalleryActivity extends AbsActivity {
    public static final /* synthetic */ int m = 0;
    public View j;
    public int k;
    public final Lazy l;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ ECGalleryActivity a;

        public b(ECGalleryActivity r1) {
            this.a = r1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r16v0, types: [android.app.Dialog, com.bytedance.android.shopping.gallery2.GalleryViewer, com.bytedance.android.shopping.utils.gallery.HybridViewerDialog, com.bytedance.android.ui.ec.widget.photodraweeview.PhotoViewerDialog] */
        /* JADX WARN: Type inference failed for: r1v0, types: [android.app.Activity, com.bytedance.android.shopping.utils.gallery.ECGalleryActivity, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r4v0, types: [java.util.List] */
        /* JADX WARN: Type inference failed for: r4v1, types: [java.util.List] */
        /* JADX WARN: Type inference failed for: r4v3, types: [java.util.ArrayList] */
        public final void a() {
            ?? r1 = this.a;
            int r2 = ECGalleryActivity.m;
            r1.getClass();
            int r3 = t0.a;
            Gson r4 = t0.a.b;
            Intent r5 = r1.getIntent();
            if (r5 == null) goto L12;
            ArrayList<String> r6 = r5.getStringArrayListExtra("video");
            if (r6 == null) goto L12;
            ?? r7 = new ArrayList();
            Iterator r8 = r6.iterator();
        L8:
            if (r8.hasNext() == false) goto L13;
            fj.d r9 = (fj.d) GsonProtectorUtils.fromJson(r4, (String) r8.next(), fj.d.class);
            if (r9 == null) goto L8;
            r7.add(r9);
        L13:
            Intent r10 = r1.getIntent();
            if (r10 == null) goto L18;
            List r11 = r10.getStringArrayListExtra("image");
            if (r11 == null) goto L18;
        L19:
            Intent r12 = r1.getIntent();
            if (r12 == null) goto L24;
            List r13 = r12.getStringArrayListExtra("title");
            if (r13 == null) goto L24;
        L25:
            Intent r14 = r1.getIntent();
            if (r14 == null) goto L28;
            Integer r15 = Integer.valueOf(r14.getIntExtra("position", 0));
        L29:
            Intent r16 = r1.getIntent();
            if (r16 == null) goto L32;
            r16.getBooleanExtra("position", true);
        L32:
            Intent r17 = r1.getIntent();
            if (r17 == null) goto L35;
            r17.getBooleanExtra("position", false);
        L35:
            fj.d r18 = (fj.d) CollectionsKt.firstOrNull(r7);
            if (r18 == null) goto L42;
            l53.b r19 = (l53.b) r1.l.getValue();
            Intrinsics.checkNotNullParameter(r1, "context");
            Intrinsics.checkNotNullParameter(r1, "mContext");
            ECUrlModel r20 = new ECUrlModel();
            if (r11 == null) goto L40;
            String r110 = (String) CollectionsKt.firstOrNull(r11);
        L41:
            r20.setUrlList(CollectionsKt.listOfNotNull(r110));
            Unit r21 = Unit.INSTANCE;
            ECGalleryActivity$openGalleryViewer$1$1$2 r22 = ECGalleryActivity$openGalleryViewer$1$1$2.INSTANCE;
            Intrinsics.checkNotNullParameter(r18, "videoModel");
            Intrinsics.checkNotNullParameter(r22, "clickCB");
            goto L42
        L40:
            r110 = null;
        L42:
            HybridViewerDialog r23 = new HybridViewerDialog(r1);
            ArrayList r24 = new ArrayList();
            Iterator r111 = r7.iterator();
        L44:
            if (r111.hasNext() == false) goto L46;
            fj.d r112 = (fj.d) r111.next();
            int r113 = com.bytedance.android.ec.model.k.n;
            r24.add(com.bytedance.android.ec.model.k.a.d(r112.a, r112.g, Integer.valueOf((int) r112.d), Integer.valueOf((int) r112.e), null));
            r23 = r23;
            goto L44
        L46:
            ?? r114 = r23;
            Iterator r25 = r11.iterator();
        L48:
            if (r25.hasNext() == false) goto L50;
            String r26 = (String) r25.next();
            int r115 = com.bytedance.android.ec.model.k.n;
            r24.add(com.bytedance.android.ec.model.k.a.c(r26, null));
            goto L48
        L50:
            Unit r27 = Unit.INSTANCE;
            r114.a(r24, false);
            r114.g.f = null;
            Intrinsics.checkNotNullParameter(r13, "titles");
            List<String> r28 = CollectionsKt.mutableListOf(new String[]{""});
            Iterator r116 = r13.iterator();
        L52:
            if (r116.hasNext() == false) goto L54;
            r28.add((String) r116.next());
            goto L52
        L54:
            r28.add("");
            r114.f = r28;
            r114.setOnDismissListener(new f(r1, r7, r11, r13));
            r114.setOnPageSelectedListener(new g(r1, r7, r11, r13));
            r114.setOnCancelListener(new h(r1, r7, r11, r13));
            if (r15 == null) goto L57;
            int r29 = r15.intValue();
        L58:
            r114.showAnimated(r29, r114.getRootContainer());
            return;
        L57:
            r29 = 0;
            goto L58
        L28:
            r15 = null;
        L24:
            r13 = CollectionsKt.emptyList();
        L18:
            r11 = CollectionsKt.emptyList();
        L12:
            r7 = CollectionsKt.emptyList();
            goto L13
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    /* JADX INFO: Removed unreachable split cross block B:51:0x0104 */
    /* JADX WARN: Multi-variable type inference failed */
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(ECGalleryActivity.class.getName()));
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

    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(ECGalleryActivity.class.getName()));
    L5:
        int r0 = r.a;
        super.onDestroy();
    }

    public ECGalleryActivity() {
        this.l = LazyKt.lazy(ECGalleryActivity$collisionNegotiator$2.INSTANCE);
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
    public final void onCreate(Bundle r4) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (v19.f.f(this) == false) goto L10;
        v19.f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        super.onCreate(r4);
        setContentView(2131560618);
        Window r5 = getWindow();
        if (r5 == null) goto L13;
        r5.setLayout(-1, -1);
        r5.setBackgroundDrawable(new ColorDrawable(0));
        r5.clearFlags(2);
    L13:
        View r6 = findViewById(2131384822);
        this.j = r6;
        if (r6 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("rootContainer");
    L16:
        r6.setBackgroundColor(com.bytedance.android.shopping.extensions.j.b(R.color.black));
        View r7 = this.j;
        if (r7 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("rootContainer");
    L19:
        r7.getBackground().setAlpha(0);
        View r8 = this.j;
        if (r8 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("rootContainer");
    L22:
        r8.post(new b(this));
    }
}
