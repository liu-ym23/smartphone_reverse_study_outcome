package com.larus.dora.impl.noti_v3.social_message.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewbinding.ViewBindings;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.larus.bmhome.view.item.ItemGroup;
import com.larus.bmhome.view.item.ItemTextArrow;
import com.larus.dora.impl.databinding.LarusDoraPageNotiV3SocialMessageBinding;
import com.larus.dora.impl.device.DoraBaseFragment;
import com.larus.dora.impl.noti_v3.social_message.dialog.NotificationBroadcastV3MessageModeBottomSheetDialogFragment;
import com.larus.dora.impl.noti_v3.social_message.model.MessageModeSheetSource;
import com.larus.dora.impl.noti_v3.social_message.viewmodel.NotificationBroadcastV3SocialMessageViewModel;
import com.larus.dora.impl.view.DoraNovaTitleBarEx;
import com.larus.nova.R;
import com.larus.utils.e1;
import com.larus.utils.j0;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 '2\u00020\u0001:\u0001'B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u001a\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u001a\u001a\u00020\u0018H\u0016J\b\u0010\u001b\u001a\u00020\rH\u0016J\n\u0010\u001c\u001a\u0004\u0018\u00010\u0010H\u0016J\n\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0002J\u000f\u0010\u001f\u001a\u0004\u0018\u00010\u0018H\u0002¢\u0006\u0002\u0010 J\b\u0010!\u001a\u00020\u0018H\u0002J\u001a\u0010\"\u001a\u00020\u00182\u0006\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\rH\u0002J\b\u0010&\u001a\u00020\u0018H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/larus/dora/impl/noti_v3/social_message/ui/NotificationBroadcastV3SocialMessageFragment;", "Lcom/larus/dora/impl/device/DoraBaseFragment;", "<init>", "()V", "binding", "Lcom/larus/dora/impl/databinding/LarusDoraPageNotiV3SocialMessageBinding;", "viewModel", "Lcom/larus/dora/impl/noti_v3/social_message/viewmodel/NotificationBroadcastV3SocialMessageViewModel;", "getViewModel", "()Lcom/larus/dora/impl/noti_v3/social_message/viewmodel/NotificationBroadcastV3SocialMessageViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "currentSingleMessageMode", "", "currentGroupMessageMode", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onDestroyView", "getCurrentPageName", "getPageMaskView", "setupTitle", "Lcom/larus/dora/impl/view/DoraNovaTitleBarEx;", "setupClicks", "()Lkotlin/Unit;", "observeSocialMessageSettings", "showModeBottomSheet", "source", "Lcom/larus/dora/impl/noti_v3/social_message/model/MessageModeSheetSource;", "selectedMode", "setupMessageModeResultListener", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NotificationBroadcastV3SocialMessageFragment extends DoraBaseFragment {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f336473j = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public LarusDoraPageNotiV3SocialMessageBinding f336474f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f336475g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f336476h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f336477i;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f336478a = null;

        static {
            int[] r100 = new int[MessageModeSheetSource.values().length];
            r100[MessageModeSheetSource.SINGLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[MessageModeSheetSource.GROUP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f336478a = r100;
        }
    }

    static {
    }

    @Override // com.larus.trace.tracknode.a
    public final String k() {
        return "dora_broadcast_social_settings";
    }

    @Override // com.larus.dora.impl.device.DoraBaseFragment
    public final View U90() {
        LarusDoraPageNotiV3SocialMessageBinding r100 = this.f336474f;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.f333092e;
    }

    public final NotificationBroadcastV3SocialMessageViewModel W90() {
        return (NotificationBroadcastV3SocialMessageViewModel) this.f336475g.getValue();
    }

    public NotificationBroadcastV3SocialMessageFragment() {
        final Function0<Fragment> r100 = new NotificationBroadcastV3SocialMessageFragment$special$$inlined$viewModels$default$1(this);
        this.f336475g = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(NotificationBroadcastV3SocialMessageViewModel.class), new NotificationBroadcastV3SocialMessageFragment$special$$inlined$viewModels$default$2(r100), new NotificationBroadcastV3SocialMessageFragment$special$$inlined$viewModels$default$3(r100, this));
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        this.f336474f = null;
    }

    public final void X90(MessageModeSheetSource r100, String r101) {
        if (getChildFragmentManager().findFragmentByTag("notification_broadcast_v3_message_mode_sheet") == null) goto L5;
        return;
    L5:
        int r102 = NotificationBroadcastV3MessageModeBottomSheetDialogFragment.f336466f;
        NotificationBroadcastV3MessageModeBottomSheetDialogFragment r103 = NotificationBroadcastV3MessageModeBottomSheetDialogFragment.a.a(r100, r101);
        FragmentManager r104 = getChildFragmentManager();
        LandscapeRestrictionOperation r105 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r103, "notification_broadcast_v3_message_mode_sheet", r105);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r104, r103, r105) == true) goto L14;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L11
    L9:
        r103.show(r104, "notification_broadcast_v3_message_mode_sheet");
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        LarusDoraPageNotiV3SocialMessageBinding r102 = this.f336474f;
        if (r102 == null) goto L5;
        DoraNovaTitleBarEx r103 = r102.f333093f;
        int r104 = j0.f375426a;
        DoraNovaTitleBarEx.S5(r103, j0.d(R.string.larus_dora_broadcast_v3_social_message_title_cn));
        DoraNovaTitleBarEx.T5(r103, new com.larus.dora.impl.noti_v3.social_message.ui.a(this));
    L5:
        LarusDoraPageNotiV3SocialMessageBinding r105 = this.f336474f;
        if (r105 == null) goto L8;
        e1.d(r105.f333091d, new c(this));
        e1.d(r105.f333090c, new d(this));
        e1.d(r105.f333089b, new e(this));
        Unit r106 = Unit.INSTANCE;
    L8:
        getChildFragmentManager().setFragmentResultListener("request_key_message_mode_result", getViewLifecycleOwner(), new com.larus.dora.impl.noti_v3.social_message.ui.b(this));
        Lifecycle.State r107 = Lifecycle.State.STARTED;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new NotificationBroadcastV3SocialMessageFragment$observeSocialMessageSettings$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, r107, null, this), 3, null);
        W90().syncSettings();
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r110) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        View r102 = r100.inflate(R.layout.larus_dora_page_noti_v3_social_message, r101, false);
        int r103 = R.id.dora_noti_v3_social_message_group;
        if (((ItemGroup) ViewBindings.findChildViewById(r102, R.id.dora_noti_v3_social_message_group)) == null) goto L19;
        r103 = R.id.dora_noti_v3_social_message_group_item;
        ItemTextArrow r104 = (ItemTextArrow) ViewBindings.findChildViewById(r102, R.id.dora_noti_v3_social_message_group_item);
        if (r104 == null) goto L19;
        r103 = R.id.dora_noti_v3_social_message_single;
        ItemTextArrow r105 = (ItemTextArrow) ViewBindings.findChildViewById(r102, R.id.dora_noti_v3_social_message_single);
        if (r105 == null) goto L19;
        r103 = R.id.dora_noti_v3_social_message_special;
        ItemTextArrow r106 = (ItemTextArrow) ViewBindings.findChildViewById(r102, R.id.dora_noti_v3_social_message_special);
        if (r106 == null) goto L19;
        r103 = R.id.dora_page_mask;
        View r107 = ViewBindings.findChildViewById(r102, R.id.dora_page_mask);
        if (r107 == null) goto L19;
        r103 = R.id.scroll_view;
        if (((ScrollView) ViewBindings.findChildViewById(r102, R.id.scroll_view)) == null) goto L19;
        r103 = R.id.title;
        DoraNovaTitleBarEx r108 = (DoraNovaTitleBarEx) ViewBindings.findChildViewById(r102, R.id.title);
        if (r108 == null) goto L19;
        ConstraintLayout r109 = (ConstraintLayout) r102;
        this.f336474f = new LarusDoraPageNotiV3SocialMessageBinding(r109, r104, r105, r106, r107, r108);
        return r109;
    L19:
        throw new NullPointerException("Missing required view with ID: ".concat(r102.getResources().getResourceName(r103)));
    }
}
