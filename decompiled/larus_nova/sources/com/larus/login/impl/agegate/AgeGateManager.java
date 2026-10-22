package com.larus.login.impl.agegate;

import android.app.Activity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.router.SmartRouter;
import com.larus.account.base.provider.agegate.IAgeGateManagerInterface;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.network.http.HttpExtKt;
import com.larus.network.http.ServiceType;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import org.json.JSONObject;
import v19.j5;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\b\u0007\u0018\u0000 &2\u00020\u0001:\u0001&B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000f\u001a\u00020\nH\u0016J\u000f\u0010\u0010\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0002\u0010\u0011J$\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0015\u001a\u00020\n2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J2\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0002J\u0010\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020\u001dH\u0016J\u0010\u0010 \u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\b\u0010!\u001a\u00020\u0013H\u0002J\u0016\u0010\"\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u001dH\u0086@¢\u0006\u0002\u0010#J(\u0010$\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020\u001dH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006'"}, d2 = {"Lcom/larus/login/impl/agegate/AgeGateManager;", "Lcom/larus/account/base/provider/agegate/IAgeGateManagerInterface;", "<init>", "()V", "ageGateCallback", "Lcom/larus/account/base/provider/agegate/IAgeGateResultCallback;", "internalNeutralAgeGateStyle", "", "Ljava/lang/Integer;", "mLoginPlatform", "", "getMLoginPlatform", "()Ljava/lang/String;", "setMLoginPlatform", "(Ljava/lang/String;)V", "getLoginPlatform", "getNeutralAgeGateStyle", "()Ljava/lang/Integer;", "verifyAgeGate", "", "callback", "platform", "trackerJson", "Lorg/json/JSONObject;", "enterAgeGate", "type", "neutralAgeGateStyle", "neutralAgeGatePage", "isMinorEnabled", "", "onPassAgeGate", "pass", "enterNonNeutralAgeGate", "showConfirmDialog", "reportAgeGageResult", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "enterNeutralAgeGate", "isFromNonNeutral", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AgeGateManager implements IAgeGateManagerInterface {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f357296d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public s38.b f357297a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Integer f357298b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f357299c;

    public static final class a {
    }

    static {
    }

    public AgeGateManager() {
        this.f357299c = "";
    }

    @Override // com.larus.account.base.provider.agegate.IAgeGateManagerInterface
    public final Integer b() {
        return this.f357298b;
    }

    @Override // com.larus.account.base.provider.agegate.IAgeGateManagerInterface
    public final String getLoginPlatform() {
        return this.f357299c;
    }

    public static final void e(final AgeGateManager r100) {
        tx9.e.a(r100.f357299c, null, 14);
        AppHost.Companion r101 = AppHost.f326268a;
        Activity r102 = r101.a().getCurrentActivity();
        if ((r102 instanceof FragmentActivity) == false) goto L5;
        FragmentActivity r103 = (FragmentActivity) r102;
    L6:
        if (r103 != null) goto L9;
        return;
    L9:
        if (r101.isOversea() == false) goto L11;
        String r104 = j5.a(r103, R.string.app_string_name, R.string.larus_dola_age_gate_reject_global);
    L12:
        CommonDialog.a r105 = new CommonDialog.a();
        r105.i(r104);
        CommonDialog.a.f(r105, new w(r100), r103.getString(R.string.larus_guest_limited_usage_confirm), false, 12);
        Function0<Boolean> r106 = new u(r100);
        Intrinsics.checkNotNullParameter(r106, "callback");
        r105.B = r106;
        r105.f327194w = true;
        r105.f327197z = false;
        d(r105.d(ContextCompat.getColor(r103, R.color.larus_primary_50)), r103.getSupportFragmentManager(), null);
        return;
    L11:
        r104 = r103.getString(R.string.larus_age_gate_reject);
        goto L12
    L5:
        r103 = null;
        goto L6
    }

    @Override // com.larus.account.base.provider.agegate.IAgeGateManagerInterface
    public final void c(boolean r100) {
        if (r100 == false) goto L6;
        s38.b r101 = this.f357297a;
        if (r101 == null) goto L10;
        r101.l();
        return;
    L10:
        return;
    L6:
        s38.b r102 = this.f357297a;
        if (r102 == null) goto L12;
        r102.A(0);
        return;
    }

    public final Object g(boolean r110, Continuation<? super Boolean> r111) {
        if ((r111 instanceof AgeGateManager$reportAgeGageResult$1) == false) goto L7;
        AgeGateManager$reportAgeGageResult$1 r100 = (AgeGateManager$reportAgeGageResult$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        AgeGateManager$reportAgeGageResult$1 r112 = r100;
        Object r102 = r112.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r112.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        boolean r105 = r112.Z$0;
        ResultKt.throwOnFailure(r102);
        boolean r106 = r105;
        boolean r113 = true;
    L18:
        com.larus.network.http.a r107 = (com.larus.network.http.a) r102;
        if ((r107 instanceof com.larus.network.http.f) == false) goto L22;
        FLogger.f375446a.i("AgeGateManager", "reportAgeGageResult fail");
        Lazy r108 = com.larus.login.impl.utils.f.f358319a;
        com.larus.login.impl.utils.f.a("age_gate_non_neutral", r106, false, false, this.f357299c, String.valueOf(((com.larus.network.http.f) r107).f360157d.getCode()));
        return Boxing.boxBoolean(false);
    L22:
        Lazy r109 = com.larus.login.impl.utils.f.f358319a;
        com.larus.login.impl.utils.f.a("age_gate_non_neutral", r106, true, true, this.f357299c, null);
        return Boxing.boxBoolean(r113);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r102);
        JSONObject r114 = new JSONObject();
        r114.put("scene", 1);
        r114.put("pass", r110);
        r114.put(BdpAppEventConstant.PARAMS_SUB_SCENE, !Intrinsics.areEqual(this.f357299c, "visitor") ? 1 : 0);
        Unit r115 = Unit.INSTANCE;
        r112.Z$0 = r110;
        r112.label = 1;
        r113 = true;
        r102 = HttpExtKt.k(ServiceType.UGC, q38.e.class, "/alice/age_gate/report", r114, null, null, false, null, null, null, r112, 1008);
        if (r102 != r103) goto L17;
        return r103;
    L17:
        r106 = r110;
    L7:
        r100 = new AgeGateManager$reportAgeGageResult$1(this, r111);
        goto L8
    }

    public static void d(CommonDialog r100, FragmentManager r101, String r102) {
        LandscapeRestrictionOperation r103 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r100, r102, r103);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r101, r100, r103) == false) goto L9;
        return;
    L9:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        r100.show(r101, r102);
    }

    @Override // com.larus.account.base.provider.agegate.IAgeGateManagerInterface
    public final void a(s38.b r100, String r101, JSONObject r102) {
        Intrinsics.checkNotNullParameter(r101, "platform");
        this.f357297a = r100;
        this.f357299c = r101;
        this.f357298b = null;
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getMain(), null, new AgeGateManager$verifyAgeGate$1(this, r101, r102, null), 2, null);
    }

    public final void f(int r100, int r101, boolean r102, boolean r103) {
        Activity r104 = AppHost.f326268a.a().getCurrentActivity();
        if ((r104 instanceof FragmentActivity) == false) goto L5;
        FragmentActivity r105 = (FragmentActivity) r104;
    L6:
        if (r105 == null) goto L12;
        com.bytedance.router.i r106 = SmartRouter.buildRoute(r105, "//flow/account_age_gate");
        r106.f267554c.putExtra("neutral_age_gate_style", r100);
        r106.f267554c.putExtra("neutral_age_gate_page", r101);
        r106.f267554c.putExtra("neutral_age_gate_is_minor_enabled", r102);
        int r107 = !Intrinsics.areEqual(this.f357299c, "visitor") ? 1 : 0;
        r106.f267554c.putExtra("neutral_age_gate_sub_scene", r107);
        r106.f267554c.putExtra("neutral_age_gate_is_from_non_neutral", r103);
        String r108 = r105.getIntent().getStringExtra("pending_deeplink_schema");
        if (r108 == null) goto L10;
        FLogger.f375446a.i("AgeGateManager", "pass uri from push when route to ROUTER_ACCOUNT_AGE_GATE");
        r106.j("pending_deeplink_schema", r108);
    L10:
        r106.f267555d = R.anim.larus_router_slide_in_right;
        r106.f267556e = R.anim.larus_router_no_anim;
        r106.d();
        return;
    L12:
        return;
    L5:
        r105 = null;
        goto L6
    }
}
