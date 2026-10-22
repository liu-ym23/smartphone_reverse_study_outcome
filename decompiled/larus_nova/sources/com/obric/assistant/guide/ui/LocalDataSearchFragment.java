package com.obric.assistant.guide.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.impl.databinding.ObricGuideForLocalDataSearchBinding;
import com.obric.assistant.settings.AILabSettingItem;
import com.obric.assistant.settings.IAILabService;
import com.obric.assistant.settings.ObricPersonalContextSettingApiDelegate;
import com.obric.assistant.settings.SelectableToggleItem;
import com.obric.assistant.settings.ToggleName;
import com.obric.common.oea.foundation.animation.token.Token$Bounce;
import com.obric.oui.button.OButton;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.List;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u001a\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0082@¢\u0006\u0002\u0010\u0016J\u0016\u0010\u0017\u001a\u00020\u00112\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0002J\b\u0010\u0019\u001a\u00020\u0011H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/obric/assistant/guide/ui/LocalDataSearchFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "binding", "Lcom/obric/assistant/impl/databinding/ObricGuideForLocalDataSearchBinding;", "isObricOS", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "buildCustomPermissionToggleList", "", "Lcom/obric/assistant/settings/SelectableToggleItem;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestCustomPermissions", "toggleList", "goToNextView", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LocalDataSearchFragment extends Fragment {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f389330f = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ObricGuideForLocalDataSearchBinding f389331d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f389332e;

    public static final class a {
        public static LocalDataSearchFragment a(boolean r100) {
            LocalDataSearchFragment r101 = new LocalDataSearchFragment();
            Bundle r102 = new Bundle();
            r102.putBoolean("is_last_page", r100);
            r101.setArguments(r102);
            return r101;
        }
    }

    public static final class b implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f389333a;

        public b(q r100) {
            Intrinsics.checkNotNullParameter(r100, "function");
            this.f389333a = r100;
        }

        public final boolean equals(Object r100) {
            if ((r100 instanceof Observer) == true) goto L5;
            return false;
        L5:
            if ((r100 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r100).getFunctionDelegate());
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> getFunctionDelegate() {
            return this.f389333a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.Observer
        public final /* synthetic */ void onChanged(Object r100) {
            this.f389333a.invoke(r100);
        }
    }

    static {
    }

    public LocalDataSearchFragment() {
        this.f389332e = t9a.b.a().b();
    }

    public final void U90() {
        FragmentActivity r100 = getActivity();
        if ((r100 instanceof UserGuideActivity) == false) goto L5;
        UserGuideActivity r101 = (UserGuideActivity) r100;
    L6:
        if (r101 != null) goto L8;
        return;
    L8:
        int r102 = r101.Q1().getCurrentItem();
        RecyclerView.Adapter r103 = r101.Q1().getAdapter();
        if (r103 == null) goto L11;
        int r104 = r103.getItemCount();
    L12:
        FLogger.f375446a.i("LocalDataSearchFragment", "goToNextView, currentPage=" + r102 + ", totalPage=" + r104);
        int r105 = r102 + 1;
        if (r105 != r104) goto L15;
        r101.S1("local_data_search_finish");
        r101.finish();
        return;
    L15:
        r101.Q1().setCurrentItem(r105, true);
        return;
    L11:
        r104 = 0;
        goto L12
    L5:
        r101 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r9v0, types: [androidx.fragment.app.Fragment, com.obric.assistant.guide.ui.LocalDataSearchFragment, java.lang.Object] */
    public static final Object S90(LocalDataSearchFragment r100, Continuation r110) {
        r100.getClass();
        if ((r110 instanceof LocalDataSearchFragment$buildCustomPermissionToggleList$1) == false) goto L7;
        LocalDataSearchFragment$buildCustomPermissionToggleList$1 r101 = (LocalDataSearchFragment$buildCustomPermissionToggleList$1) r110;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r111 = r101.result;
        ?? r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r101.label;
        boolean r105 = false;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        List r106 = (List) r101.L$0;
        ResultKt.throwOnFailure(r111);
    L21:
        if (((Boolean) r111).booleanValue() != true) goto L23;
        r103 = r106;
        r105 = true;
    L25:
        if (r105 == false) goto L27;
        T90(r103, ToggleName.AI_DIARY, r100.getString(R.string.obric_fragment_personal_context_setting_data_source_ai_diary), r100.getString(R.string.obric_fragment_personal_context_open_ai_diary_permission));
    L27:
        return r103;
    L23:
        List r112 = r106;
    L24:
        r103 = r112;
        goto L25
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r111);
        r112 = new ArrayList();
        String r107 = tga.b.a();
        T90(r112, ToggleName.NOTES, r107, r100.getString(R.string.obric_fragment_personal_context_open_notes_permission, new Object[]{r107}));
        T90(r112, ToggleName.CLOCK, r100.getString(R.string.obric_fragment_personal_context_setting_data_source_clock), r100.getString(R.string.obric_fragment_personal_context_open_clock_permission));
        T90(r112, ToggleName.RECORD, r100.getString(R.string.obric_fragment_personal_context_setting_data_source_record), r100.getString(R.string.obric_fragment_personal_context_open_record_permission));
        T90(r112, ToggleName.GLOBAL_MEMORY, r100.getString(R.string.obric_fragment_personal_context_setting_data_source_memory_global), r100.getString(R.string.obric_fragment_personal_context_open_memory_global_permission));
        IAILabService r108 = (IAILabService) ServiceManager.get().getService(IAILabService.class);
        if (r108 == null) goto L24;
        AILabSettingItem r109 = AILabSettingItem.ScreenMemory;
        r101.L$0 = r112;
        r101.label = 1;
        Object r113 = r108.b(r109, r101);
        if (r113 == r103) goto L27;
        r106 = r112;
        r111 = r113;
    L7:
        r101 = new LocalDataSearchFragment$buildCustomPermissionToggleList$1(r100, r110);
        goto L8
    }

    /* JADX WARN: Type inference failed for: r9v8, types: [com.obric.assistant.guide.ui.s] */
    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r110) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r110);
        Bundle r101 = getArguments();
        boolean r102 = false;
        if (r101 != null) goto L5;
    L7:
        boolean r103 = false;
    L8:
        FLogger r104 = FLogger.f375446a;
        StringBuilder r105 = new StringBuilder("onViewCreated, savedInstanceState=");
        if (r110 == null) goto L11;
        r102 = true;
    L11:
        r105.append(r102);
        r105.append(", isObricOS=");
        r105.append(this.f389332e);
        r105.append(", isLastPage=");
        r105.append(r103);
        r105.append(", localDataSearchEnabled=");
        r105.append(ObricPersonalContextSettingApiDelegate.f391714b.q());
        r104.i("LocalDataSearchFragment", r105.toString());
        if (this.f389332e == false) goto L14;
        if (r103 == false) goto L14;
    L19:
        ObricGuideForLocalDataSearchBinding r106 = this.f389331d;
        if (r106 == null) goto L24;
        ImageView r107 = r106.f389581e;
        if (r107 == null) goto L24;
        r107.setImageDrawable(requireContext().getDrawable(R.drawable.obric_guide_local_data_search_o));
    L24:
        ObricGuideForLocalDataSearchBinding r108 = this.f389331d;
        if (r108 == null) goto L29;
        OButton r109 = r108.f389578b;
        if (r109 == null) goto L29;
        r109.setOnClickListener(new r(this));
    L29:
        final ?? r111 = new s(this);
        if (this.f389332e == false) goto L41;
        ObricGuideForLocalDataSearchBinding r112 = this.f389331d;
        if (r112 == null) goto L36;
        OFloatingTitleBar r113 = r112.f389580d;
        if (r113 == null) goto L36;
        OFloatingTitleBar.k(r113, new t(r111), 2);
    L36:
        ObricGuideForLocalDataSearchBinding r114 = this.f389331d;
        if (r114 == null) goto L65;
        OFloatingTitleBar r115 = r114.f389580d;
        if (r115 == null) goto L65;
        View.OnClickListener r116 = new u(this);
        Token$Bounce r117 = OFloatingTitleBar.H0;
        r115.h(R.drawable.o_floating_title_bar_icon_close, -1, r116);
    L65:
        ObricGuideForLocalDataSearchBinding r118 = this.f389331d;
        if (r118 == null) goto L71;
        OButton r119 = r118.f389579c;
        if (r119 == null) goto L72;
        r119.setOnClickListener(new w(this));
        return;
    L72:
        return;
    L71:
        return;
    L41:
        int r120 = rda.a.f537347a;
        ObricGuideForLocalDataSearchBinding r121 = this.f389331d;
        if (r121 == null) goto L44;
        OFloatingTitleBar r122 = r121.f389580d;
    L45:
        NovaTitleBarEx.b6(rda.a.b(r122), R.drawable.larus_ic_left_back, false, null, null, new v(r111), 14);
        int r123 = getResources().getDimensionPixelSize(v19.c.b(R.attr.larus_dp_16, null, R.dimen.larus_dp_16));
        ObricGuideForLocalDataSearchBinding r124 = this.f389331d;
        if (r124 == null) goto L50;
        OButton r125 = r124.f389579c;
        if (r125 == null) goto L50;
        r125.setBackgroundResource(R.drawable.obric_bg_account_button_white);
    L50:
        ObricGuideForLocalDataSearchBinding r126 = this.f389331d;
        if (r126 == null) goto L55;
        OButton r127 = r126.f389579c;
        if (r127 == null) goto L55;
        r127.setRadius(r123);
    L55:
        ObricGuideForLocalDataSearchBinding r128 = this.f389331d;
        if (r128 == null) goto L60;
        OButton r129 = r128.f389579c;
        if (r129 == null) goto L60;
        r129.setTextColor(ContextCompat.getColor(requireContext(), R.color.larus_base_1));
    L60:
        ObricGuideForLocalDataSearchBinding r130 = this.f389331d;
        if (r130 == null) goto L65;
        OButton r131 = r130.f389578b;
        if (r131 == null) goto L65;
        r131.setRadius(r123);
        goto L65
    L44:
        r122 = null;
    L14:
        ObricGuideForLocalDataSearchBinding r132 = this.f389331d;
        if (r132 == null) goto L19;
        OButton r133 = r132.f389578b;
        if (r133 == null) goto L19;
        r133.setText(R.string.obric_setting_later);
        goto L19
    L5:
        if (r101.getBoolean("is_last_page") != true) goto L7;
        r103 = true;
        goto L8
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        View r103 = r100.inflate(R.layout.obric_guide_for_local_data_search, r101, false);
        int r104 = R.id.foot_zone;
        if (((ConstraintLayout) ViewBindings.findChildViewById(r103, R.id.foot_zone)) == null) goto L19;
        r104 = R.id.mid_zone;
        if (((ConstraintLayout) ViewBindings.findChildViewById(r103, R.id.mid_zone)) == null) goto L19;
        r104 = R.id.open_cancel;
        OButton r105 = (OButton) ViewBindings.findChildViewById(r103, R.id.open_cancel);
        if (r105 == null) goto L19;
        r104 = R.id.open_start;
        OButton r106 = (OButton) ViewBindings.findChildViewById(r103, R.id.open_start);
        if (r106 == null) goto L19;
        r104 = R.id.title_bar;
        OFloatingTitleBar r107 = (OFloatingTitleBar) ViewBindings.findChildViewById(r103, R.id.title_bar);
        if (r107 == null) goto L19;
        r104 = R.id.top_zone;
        if (((ConstraintLayout) ViewBindings.findChildViewById(r103, R.id.top_zone)) == null) goto L19;
        r104 = R.id.voice_enroll_image;
        ImageView r108 = (ImageView) ViewBindings.findChildViewById(r103, R.id.voice_enroll_image);
        if (r108 == null) goto L19;
        ConstraintLayout r109 = (ConstraintLayout) r103;
        this.f389331d = new ObricGuideForLocalDataSearchBinding(r109, r105, r106, r107, r108);
        return r109;
    L19:
        throw new NullPointerException("Missing required view with ID: ".concat(r103.getResources().getResourceName(r104)));
    }

    public static final void T90(List<SelectableToggleItem> r110, ToggleName r111, String r112, String r113) {
        boolean r100 = ObricPersonalContextSettingApiDelegate.f391714b.o(r111);
        FLogger.f375446a.i("LocalDataSearchFragment", "buildCustomPermissionToggleList, toggle=" + r111 + ", isOn=" + r100);
        if (r100 == true) goto L6;
        r110.add(new SelectableToggleItem(r111, r112, r113, null, 24));
        return;
    }
}
