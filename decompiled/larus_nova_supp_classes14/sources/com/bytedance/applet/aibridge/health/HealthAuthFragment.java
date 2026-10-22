package com.bytedance.applet.aibridge.health;

import android.content.Intent;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0011\u001a\u00020\tH\u0016J\b\u0010\u0012\u001a\u00020\tH\u0002J\b\u0010\u0013\u001a\u00020\tH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u0006\u001a\u0018\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0010\u0012\f\u0012\n \u0010*\u0004\u0018\u00010\u00050\u00050\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/bytedance/applet/aibridge/health/HealthAuthFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "pendingIntent", "Landroid/content/Intent;", "onResult", "Lkotlin/Function2;", "", "", "onLaunchFailure", "Lkotlin/Function0;", "launched", "", "launcher", "Landroidx/activity/result/ActivityResultLauncher;", "kotlin.jvm.PlatformType", "onResume", "clearCallbacks", "detachSelf", "Companion", "huawei-health-impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HealthAuthFragment extends Fragment {
    public static final a i = null;
    public Intent d;
    public Function2<? super Integer, ? super Intent, Unit> e;
    public Function0<Unit> f;
    public boolean g;
    public final ActivityResultLauncher<Intent> h;

    public static final class a {
        public a() {
        }

        public static void a(FragmentActivity r2, Intent r3, Function2 r4, Function0 r5) {
            Intrinsics.checkNotNullParameter(r2, "activity");
            Intrinsics.checkNotNullParameter(r3, "intent");
            Intrinsics.checkNotNullParameter(r4, "onResult");
            Intrinsics.checkNotNullParameter(r5, "onLaunchFailure");
            HealthAuthFragment r1 = new HealthAuthFragment();
            r1.d = r3;
            r1.e = r4;
            r1.f = r5;
            Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L9
            FragmentTransaction r7 = r2.getSupportFragmentManager().beginTransaction();     // Catch: Throwable -> L9
            String r8 = "AISDK_HealthAuth-" + System.identityHashCode(r1);     // Catch: Throwable -> L9
            if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r7, r1, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, r8, 0) == true) goto L7;
            r7 = r7.add(r1, r8);     // Catch: Throwable -> L9
        L7:
            Object r9 = Result.constructor-impl(Integer.valueOf(r7.commitAllowingStateLoss()));     // Catch: Throwable -> L9
        L12:
            if (Result.exceptionOrNull-impl(r9) == null) goto L17;
            r5.invoke();
            return;
        L17:
            return;
        L9:
            th = move-exception;
            Result.Companion r10 = Result.Companion;
            r9 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L12
        }
    }

    static {
        i = new a();
    }

    public HealthAuthFragment() {
        this.h = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new nv3.a(this));
    }

    public final void S90() {
        FragmentActivity r0 = getActivity();
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.isFinishing() == false) goto L8;
        return;
    L8:
        if (r0.isDestroyed() == true) goto L18;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L12
        Result.constructor-impl(Integer.valueOf(r0.getSupportFragmentManager().beginTransaction().remove(this).commitAllowingStateLoss()));     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        return;
    }

    public final void onResume() {
        super.onResume();
        Intent r0 = this.d;
        if (r0 != null) goto L6;
        return;
    L6:
        if (this.g == false) goto L8;
        return;
    L8:
        this.g = true;
        this.d = null;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L11
        this.h.launch(r0);     // Catch: Throwable -> L11
        Object r1 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L11
    L14:
        if (Result.exceptionOrNull-impl(r1) == null) goto L22;
        Function0<Unit> r3 = this.f;
        if (r3 == null) goto L18;
        r3.invoke();
    L18:
        this.e = null;
        this.f = null;
        S90();
        return;
    L22:
        return;
    L11:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    }
}
