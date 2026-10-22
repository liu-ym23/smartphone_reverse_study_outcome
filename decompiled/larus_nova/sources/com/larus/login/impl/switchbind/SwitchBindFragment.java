package com.larus.login.impl.switchbind;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewbinding.ViewBindings;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.ixigua.lib.track.TrackParams;
import com.larus.common_ui.dialog.l0;
import com.larus.login.api.SwitchBindParam;
import com.larus.login.impl.databinding.LarusFragmentSwitchBindBinding;
import com.larus.login.impl.switchbind.view.AccountCardView;
import com.larus.nova.R;
import com.larus.trace.tracknode.TraceFragment;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u0000 .2\u00020\u0001:\u0001.B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u001a\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00132\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001d\u001a\u00020\u0011H\u0016J\u0010\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020 H\u0016J\b\u0010!\u001a\u00020\u001bH\u0016J\b\u0010\"\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020\u001bH\u0002J\b\u0010%\u001a\u00020\u001bH\u0002J\u001c\u0010&\u001a\u00020\u001b2\u0006\u0010'\u001a\u00020\u00112\n\b\u0002\u0010(\u001a\u0004\u0018\u00010#H\u0002J\u0010\u0010)\u001a\u00020\u001b2\u0006\u0010*\u001a\u00020\u0011H\u0002J\b\u0010+\u001a\u00020\u001bH\u0002J\b\u0010,\u001a\u00020\u001bH\u0002J\b\u0010-\u001a\u00020\u000fH\u0002R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/larus/login/impl/switchbind/SwitchBindFragment;", "Lcom/larus/trace/tracknode/TraceFragment;", "<init>", "()V", "viewModel", "Lcom/larus/login/impl/switchbind/SwitchBindViewModel;", "getViewModel", "()Lcom/larus/login/impl/switchbind/SwitchBindViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "binding", "Lcom/larus/login/impl/databinding/LarusFragmentSwitchBindBinding;", "loadingDialog", "Lcom/larus/common_ui/dialog/CommonLoadDialog;", "switchBindParam", "Lcom/larus/login/api/SwitchBindParam;", "enterPageReported", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "autoLogEnterPage", "onAttach", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "onDestroyView", "getCurrentPageName", "", "setupUI", "observeState", "reportBindResult", "success", "errorResult", "reportEnterPage", "switchBindDisabled", "showConfirmationDialog", "fetchConflictUserInfo", "getSwitchBindParamFromBundle", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SwitchBindFragment extends TraceFragment {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f358228j = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f358229e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public LarusFragmentSwitchBindBinding f358230f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public l0 f358231g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public SwitchBindParam f358232h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f358233i;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.trace.tracknode.TraceFragment
    public final boolean S90() {
        return false;
    }

    @Override // com.larus.trace.tracknode.a
    public final String k() {
        return "douyin_account_rebind";
    }

    public final SwitchBindViewModel U90() {
        return (SwitchBindViewModel) this.f358229e.getValue();
    }

    public SwitchBindFragment() {
        Function0 r100 = new c();
        final Function0<Fragment> r101 = new SwitchBindFragment$special$$inlined$viewModels$default$1(this);
        this.f358229e = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(SwitchBindViewModel.class), new SwitchBindFragment$special$$inlined$viewModels$default$2(r101), r100);
        this.f358232h = new SwitchBindParam(null, null, null, null, null, 127);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        FLogger.f375446a.i("SwitchBindFragment", "onDestroyView");
        this.f358230f = null;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onAttach(Context r110) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super.onAttach(r110);
        FLogger r111 = FLogger.f375446a;
        r111.i("SwitchBindFragment", "onAttach");
        if (Build.VERSION.SDK_INT < 33) goto L7;
        Bundle r100 = getArguments();
        if (r100 == null) goto L10;
        SwitchBindParam r101 = (SwitchBindParam) r100.getParcelable("key_switch_bind_param", SwitchBindParam.class);
    L11:
        if (r101 != null) goto L13;
        r101 = new SwitchBindParam(null, null, null, null, null, 127);
    L13:
        this.f358232h = r101;
        StringBuilder r102 = new StringBuilder("fetchConflictUserInfo, switchBindParam: previousPage=");
        r102.append(this.f358232h.f356998e);
        r102.append(", enterMethod=");
        r102.append(this.f358232h.f356997d);
        r102.append(", scene=");
        r102.append(this.f358232h.f356999f);
        r102.append(", platformAppIdPresent=");
        String r103 = this.f358232h.f356995b;
        boolean r104 = false;
        if (r103 != null) goto L16;
    L19:
        boolean r105 = true;
    L20:
        r102.append(!r105);
        r102.append(", platformPresent=");
        String r106 = this.f358232h.f356996c;
        if (r106 != null) goto L23;
    L26:
        boolean r107 = true;
    L27:
        r102.append(!r107);
        r102.append(", profileKeyPresent=");
        String r108 = this.f358232h.f356994a;
        if (r108 != null) goto L30;
    L31:
        r104 = true;
    L32:
        r102.append(!r104);
        r111.i("SwitchBindFragment", r102.toString());
        U90().dispatch(new g.b(this.f358232h));
        return;
    L30:
        if (r108.length() != 0) goto L32;
    L23:
        if (r106.length() == 0) goto L26;
        r107 = false;
        goto L27
    L16:
        if (r103.length() == 0) goto L19;
        r105 = false;
    L10:
        r101 = null;
        goto L11
    L7:
        Bundle r109 = getArguments();
        if (r109 == null) goto L10;
        r101 = (SwitchBindParam) r109.getParcelable("key_switch_bind_param");
        goto L11
    }

    public final void V90(boolean r110, String r111) {
        String r100 = null;
        if (r110 == false) goto L5;
        r111 = null;
    L5:
        if (r110 == true) goto L8;
        r100 = "douyin_verify";
    L8:
        JSONObject r101 = new JSONObject();
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L26
        Iterator<String> r103 = this.f358232h.f357000g.keySet().iterator();     // Catch: Throwable -> L26
    L11:
        if (r103.hasNext() == false) goto L24;
        String r104 = r103.next();     // Catch: Throwable -> L26
        Object r105 = this.f358232h.f357000g.get(r104);     // Catch: Throwable -> L26
        if (r105 == null) goto L11;
        if ((r105 instanceof String) == true) goto L23;
        if ((r105 instanceof Number) == true) goto L23;
        if ((r105 instanceof Boolean) == true) goto L23;
        r101.put(r104, r105.toString());     // Catch: Throwable -> L26
    L23:
        r101.put(r104, r105);     // Catch: Throwable -> L26
        goto L11
    L24:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L26
    L28:
        int r106 = h.f358249a;
        SwitchBindParam r107 = this.f358232h;
        String r108 = r107.f356998e;
        String r109 = r107.f356999f;
        if (r109 != null) goto L31;
        r109 = "douyin_account_rebind";
    L31:
        Intrinsics.checkNotNullParameter("douyin", "type");
        Intrinsics.checkNotNullParameter(r109, "scene");
        Intrinsics.checkNotNullParameter(r101, "params");
        r101.put("current_page", "douyin_account_rebind");     // Catch: JSONException -> L46
        if (r108 == null) goto L36;
        r101.put("previous_page", r108);     // Catch: JSONException -> L46
    L36:
        if (r110 == false) goto L38;
        int r112 = 1;
    L39:
        r101.put("success", String.valueOf(r112));     // Catch: JSONException -> L46
        if (r111 == null) goto L42;
        r101.put("result", r111);     // Catch: JSONException -> L46
    L42:
        if (r100 == null) goto L44;
        r101.put("bind_fail_step", r100);     // Catch: JSONException -> L46
    L44:
        r101.put("type", "douyin");     // Catch: JSONException -> L46
        r101.put("scene", r109);     // Catch: JSONException -> L46
    L48:
        TrackParams r113 = new TrackParams().merge(r101);
        by7.a r114 = new by7.a("bind_with_account");
        r114.f21464b = this;
        r114.f21463a.merge(r113);
        r114.b();
        return;
    L38:
        r112 = 0;
    L46:
        e = move-exception;
        FLogger.f375446a.e("SwitchBindMobUtil", "[onSwitchBindResult] " + e);
    L26:
        th = move-exception;
        Result.Companion r115 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L28
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        FLogger r102 = FLogger.f375446a;
        r102.i("SwitchBindFragment", "onViewCreated");
        r102.i("SwitchBindFragment", "setupUI");
        LarusFragmentSwitchBindBinding r103 = this.f358230f;
        if (r103 == null) goto L7;
        AccountCardView r104 = r103.f357559c;
        if (r104 == null) goto L7;
        r104.setOnBindClickListener(new d(this));
    L7:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new SwitchBindFragment$observeState$1(this, null), 3, null);
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        FLogger.f375446a.i("SwitchBindFragment", "onCreateView");
        View r103 = r100.inflate(R.layout.larus_fragment_switch_bind, r101, false);
        int r104 = R.id.conflict_account_card;
        AccountCardView r105 = (AccountCardView) ViewBindings.findChildViewById(r103, R.id.conflict_account_card);
        if (r105 == null) goto L12;
        r104 = R.id.current_account_card;
        AccountCardView r106 = (AccountCardView) ViewBindings.findChildViewById(r103, R.id.current_account_card);
        if (r106 == null) goto L12;
        ConstraintLayout r107 = (ConstraintLayout) r103;
        this.f358230f = new LarusFragmentSwitchBindBinding(r107, r105, r106);
        if (r107 == null) goto L10;
        return r107;
    L10:
        return new View(getContext());
    L12:
        throw new NullPointerException("Missing required view with ID: ".concat(r103.getResources().getResourceName(r104)));
    }
}
