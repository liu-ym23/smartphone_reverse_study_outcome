package com.larus.dora.obric.onboarding;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.dora.impl.databinding.ObricDoraGOnboardingEnvObserveContentBinding;
import com.larus.dora.impl.device.settings.lab.env.auth.EnvAuthViewModel;
import com.larus.dora.impl.resource.DoraResourceDeviceType;
import com.larus.dora.impl.resource.DoraResourceType;
import com.larus.dora.impl.view.DoraTextViewWithAnim;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.oui.button.OButton;
import com.obric.oui.sheet.v2.OSheet;
import com.obric.oui.sheet.v2.OSheetBase;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes27.dex */
public final class m {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final a f340884j = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AppCompatActivity f340885a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f340886b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<Unit> f340887c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function1<ObricDoraGEnvAuthResult, Unit> f340888d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final EnvAuthViewModel f340889e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f340890f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Job f340891g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final h f340892h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final OSheet f340893i;

    public static final class a {
        public a() {
        }

        public static boolean a(a r100, Context r101, String r102, com.larus.dora.obric.device_management.device_home.z0 r103, int r104) {
            if ((r104 & 8) == 0) goto L5;
            r103 = null;
        L5:
            r100.getClass();
            Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
            if ((r101 instanceof AppCompatActivity) == false) goto L8;
            AppCompatActivity r105 = (AppCompatActivity) r101;
        L10:
            if (r105 != null) goto L22;
            g49.d.e("ObricDoraGEnvAuthSheet", "context is not AppCompatActivity, fallback to onboarding page");
            return false;
        L22:
            Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L14
            m.a(new m(r105, r102, null, r103));     // Catch: Throwable -> L14
            Object r107 = Result.m9449constructorimpl(Boolean.TRUE);     // Catch: Throwable -> L14
        L16:
            Throwable r108 = Result.m9452exceptionOrNullimpl(r107);
            if (r108 == null) goto L21;
            g49.d.c("ObricDoraGEnvAuthSheet", "show env auth sheet failed, fallback to onboarding page", r108);
            r107 = Boolean.FALSE;
        L21:
            return ((Boolean) r107).booleanValue();
        L14:
            th = move-exception;
            Result.Companion r109 = Result.Companion;
            r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L16
        L8:
            r105 = null;
            goto L10
        }
    }

    static {
        f340884j = new a();
    }

    public static final void a(final m r100) {
        r100.f340891g = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r100.f340885a), null, null, new ObricDoraGEnvAuthSheet$observeAuthResult$1(r100, null), 3, null);
        r100.f340893i.setOnDismissListener(new i(r100));
        OSheet r101 = r100.f340893i;
        if (DialogLancet.shouldBlockDialogShow(r101) == false) goto L9;
        DialogLancet.handleBlockedDialogShow(r101);
        return;
    L9:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        DialogLancet.beforeDialogShow(r101);
        r101.show();
        DialogLancet.afterDialogShow(r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v1, types: [com.larus.dora.obric.onboarding.j] */
    public m(AppCompatActivity r100, String r110, Function0<Unit> r111, Function1<? super ObricDoraGEnvAuthResult, Unit> r112) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        this.f340885a = r100;
        this.f340886b = r110;
        this.f340887c = r111;
        this.f340888d = r112;
        View r113 = LayoutInflater.from(r100).inflate(R.layout.obric_dora_g_onboarding_env_observe_content, null, false);
        int r114 = R.id.obric_env_observe_agree_button;
        OButton r101 = (OButton) ViewBindings.findChildViewById(r113, R.id.obric_env_observe_agree_button);
        if (r101 == null) goto L14;
        r114 = R.id.obric_env_observe_icon;
        SimpleDraweeView r102 = (SimpleDraweeView) ViewBindings.findChildViewById(r113, R.id.obric_env_observe_icon);
        if (r102 == null) goto L14;
        r114 = R.id.obric_env_observe_later_button;
        DoraTextViewWithAnim r103 = (DoraTextViewWithAnim) ViewBindings.findChildViewById(r113, R.id.obric_env_observe_later_button);
        if (r103 == null) goto L14;
        ScrollView r115 = (ScrollView) r113;
        ObricDoraGOnboardingEnvObserveContentBinding r116 = new ObricDoraGOnboardingEnvObserveContentBinding(r115, r101, r102, r103);
        this.f340889e = (EnvAuthViewModel) new ViewModelProvider(r100).get(EnvAuthViewModel.class);
        this.f340892h = new h(new j(this));
        final OSheet r104 = new OSheet(r100, 0, false, 30);
        OSheetBase.DefaultImpls.q(r104, OSheet.HeightMode.FULL_HEIGHT);
        ImageLoaderKt.s(r116.f333422b, com.larus.dora.impl.resource.j0.g(com.larus.dora.impl.resource.j0.f337886a, r100, DoraResourceDeviceType.G2, DoraResourceType.DRAWABLE, "obric_onboarding_service_recommendation_icon"), null);
        r101.setOnClickListener(new k(this));
        r103.setOnClickListener(new l(this, r104));
        r115.setVisibility(0);
        View r117 = r115.getChildAt(0);
        if (r117 == null) goto L11;
        Resources r118 = r100.getResources();
        r117.setPadding(r117.getPaddingLeft(), (int) ((68 * WindowDisplayMetricsOverride.apply(r118, r118.getDisplayMetrics()).density) + 0.5f), r117.getPaddingRight(), r117.getPaddingBottom());
    L11:
        FrameLayout r119 = new FrameLayout(r100);
        r119.addView(r115, new FrameLayout.LayoutParams(-1, -1));
        OSheetBase.DefaultImpls.j(r104, r119);
        this.f340893i = r104;
        return;
    L14:
        throw new NullPointerException("Missing required view with ID: ".concat(r113.getResources().getResourceName(r114)));
    }
}
