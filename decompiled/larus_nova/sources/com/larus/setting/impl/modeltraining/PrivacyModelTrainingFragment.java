package com.larus.setting.impl.modeltraining;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.viewbinding.ViewBindings;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.bmhome.view.item.ItemGroup;
import com.larus.bmhome.view.item.ItemTextArrow;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.view.ChatSettingScrollView;
import com.larus.common_ui.widget.UrlSpanTextView;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.nova.R;
import com.larus.setting.impl.DataPermissionBottomSheet;
import com.larus.setting.impl.SettingModel;
import com.larus.setting.impl.databinding.LarusPagePrivacyModelTrainingSettingBinding;
import com.larus.utils.e1;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.obric.assistant.spi.training.IObricPrivacyModelTrainingService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Arrays;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 .2\u00020\u0001:\u0001.B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u001a\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00152\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010\u001f\u001a\u00020\u001dH\u0016J\b\u0010 \u001a\u00020\u001dH\u0002J\b\u0010!\u001a\u00020\u001dH\u0002J\b\u0010\"\u001a\u00020\u001dH\u0002J\b\u0010#\u001a\u00020\u001dH\u0002J\b\u0010$\u001a\u00020\u001dH\u0002J\u0018\u0010%\u001a\u00020\u001d2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0002J\u0018\u0010*\u001a\u00020\u001d2\u0006\u0010&\u001a\u00020'2\u0006\u0010+\u001a\u00020\rH\u0002J\u000f\u0010,\u001a\u0004\u0018\u00010\u001dH\u0002¢\u0006\u0002\u0010-R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\t\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0011\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\t\u001a\u0004\b\u0012\u0010\u000f¨\u0006/"}, d2 = {"Lcom/larus/setting/impl/modeltraining/PrivacyModelTrainingFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "Lcom/larus/setting/impl/SettingModel;", "getModel", "()Lcom/larus/setting/impl/SettingModel;", "model$delegate", "Lkotlin/Lazy;", "binding", "Lcom/larus/setting/impl/databinding/LarusPagePrivacyModelTrainingSettingBinding;", "statusOn", "", "getStatusOn", "()Ljava/lang/String;", "statusOn$delegate", "statusOff", "getStatusOff", "statusOff$delegate", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onDestroyView", "initTopBar", "initBackButton", "initPrivacySubtitle", "initViewModel", "openPrivacyNewLink", "setSubText", MapController.ITEM_LAYER_TAG, "Lcom/larus/bmhome/view/item/ItemTextArrow;", "condition", "", "setClickListener", "tag", "initCustomModelTrainingGroup", "()Lkotlin/Unit;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PrivacyModelTrainingFragment extends Fragment {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f368401h = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f368402d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public LarusPagePrivacyModelTrainingSettingBinding f368403e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f368404f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f368405g;

    public static final class a {
    }

    public static final class b implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f368406a;

        public b(Function1 r100) {
            Intrinsics.checkNotNullParameter(r100, "function");
            this.f368406a = r100;
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
            return this.f368406a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.Observer
        public final /* synthetic */ void onChanged(Object r100) {
            this.f368406a.invoke(r100);
        }
    }

    static {
    }

    public final SettingModel T90() {
        return (SettingModel) this.f368402d.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        IObricPrivacyModelTrainingService r100 = (IObricPrivacyModelTrainingService) ServiceManager.get().getService(IObricPrivacyModelTrainingService.class);
        if (r100 == null) goto L5;
        r100.c();
    L5:
        this.f368403e = null;
        super.onDestroyView();
    }

    public PrivacyModelTrainingFragment() {
        this.f368402d = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(SettingModel.class), new PrivacyModelTrainingFragment$special$$inlined$activityViewModels$default$1(this), new PrivacyModelTrainingFragment$special$$inlined$activityViewModels$default$2(this));
        this.f368404f = LazyKt.lazy(new g(this));
        this.f368405g = LazyKt.lazy(new h(this));
    }

    public static void S90(DataPermissionBottomSheet r100, FragmentManager r101) {
        LandscapeRestrictionOperation r102 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r100, "DataPermissionBottomSheet", r102);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r101, r100, r102) == false) goto L9;
        return;
    L9:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        r100.show(r101, "DataPermissionBottomSheet");
    }

    public final void U90(ItemTextArrow r100, boolean r101) {
        if (r101 == false) goto L4;
        String r102 = (String) this.f368404f.getValue();
    L5:
        int r103 = ItemTextArrow.f316958k;
        r100.Z5(r102, null);
        return;
    L4:
        r102 = (String) this.f368405g.getValue();
        goto L5
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [com.larus.setting.impl.modeltraining.b] */
    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r110, Bundle r111) {
        Intrinsics.checkNotNullParameter(r110, "view");
        super.onViewCreated(r110, r111);
        int r112 = lt9.a.f510713a;
        Context r113 = getContext();
        IObricPrivacyModelTrainingService r114 = (IObricPrivacyModelTrainingService) ServiceManager.get().getService(IObricPrivacyModelTrainingService.class);
        if (r114 == null) goto L5;
        r114.a();
    L5:
        if (r113 == null) goto L7;
        String r115 = r113.getString(R.string.larus_privacy_model_desc_cn);
    L8:
        if (r115 == null) goto L11;
        String r116 = String.format(r115, Arrays.copyOf(new Object[]{lt9.a.a(r113)}, 1));
        if (r116 == null) goto L11;
    L12:
        LarusPagePrivacyModelTrainingSettingBinding r117 = this.f368403e;
        if (r117 == null) goto L17;
        UrlSpanTextView r118 = r117.f368182d;
        if (r118 == null) goto L17;
        r118.setUrlSpannedText(r116);
    L17:
        LarusPagePrivacyModelTrainingSettingBinding r119 = this.f368403e;
        if (r119 == null) goto L22;
        UrlSpanTextView r120 = r119.f368182d;
        if (r120 == null) goto L22;
        r120.setOnClickListener(new j(this));
    L22:
        LarusPagePrivacyModelTrainingSettingBinding r121 = this.f368403e;
        if (r121 == null) goto L25;
        NovaTitleBarEx.b6(r121.f368181c, R.drawable.larus_ic_left_back, false, null, null, new com.larus.setting.impl.modeltraining.a(this), 14);
    L25:
        SettingModel.updateUserConfigs$default(T90(), null, 0, null, 7, null);
        LarusPagePrivacyModelTrainingSettingBinding r122 = this.f368403e;
        if (r122 == null) goto L31;
        U90(r122.f368183e, T90().isAllowTrainByText());
        final String r100 = "conversation_train";
        e1.d(r122.f368183e, new i(this, r100));
        U90(r122.f368184f, T90().isAllowTrainByUpload());
        final String r101 = "multimedia_train";
        e1.d(r122.f368184f, new i(this, r101));
        U90(r122.f368186h, T90().isOptOutVoiceEnabled());
        final String r102 = "voice_train";
        e1.d(r122.f368186h, new i(this, r102));
        if (AppHost.f326268a.isOversea() == true) goto L30;
        U90(r122.f368185g, T90().isAllowTrainByVideo());
        final String r103 = "video_train";
        e1.d(r122.f368185g, new i(this, r103));
        goto L31
    L30:
        e1.o(r122.f368185g);
    L31:
        final LarusPagePrivacyModelTrainingSettingBinding r123 = this.f368403e;
        if (r123 == null) goto L36;
        T90().getAllowTrainByText().observe(getViewLifecycleOwner(), new b(new c(this, r123)));
        T90().getAllowTrainByUpload().observe(getViewLifecycleOwner(), new b(new d(this, r123)));
        T90().getOptOutVoice().observe(getViewLifecycleOwner(), new b(new e(this, r123)));
        if (AppHost.f326268a.isOversea() == true) goto L36;
        T90().getAllowTrainByVideo().observe(getViewLifecycleOwner(), new b(new f(this, r123)));
    L36:
        LarusPagePrivacyModelTrainingSettingBinding r124 = this.f368403e;
        if (r124 == null) goto L44;
        IObricPrivacyModelTrainingService r125 = (IObricPrivacyModelTrainingService) ServiceManager.get().getService(IObricPrivacyModelTrainingService.class);
        if (r125 == 0) goto L42;
        r125.d(this, r124.f368180b, new com.larus.setting.impl.modeltraining.b(this));
    L42:
        Unit r126 = Unit.INSTANCE;
        return;
    L44:
        return;
    L11:
        r116 = "";
        goto L12
    L7:
        r115 = null;
        goto L8
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r110, ViewGroup r111, Bundle r112) {
        Intrinsics.checkNotNullParameter(r110, "inflater");
        View r113 = r110.inflate(R.layout.larus_page_privacy_model_training_setting, r111, false);
        int r114 = R.id.container_layout;
        if (((LinearLayout) ViewBindings.findChildViewById(r113, R.id.container_layout)) == null) goto L43;
        LinearLayout r115 = (LinearLayout) r113;
        if (((ImageView) ViewBindings.findChildViewById(r113, R.id.model_train_title_image)) != null) goto L7;
        r114 = R.id.model_train_title_image;
        goto L43
    L7:
        if (((ItemGroup) ViewBindings.findChildViewById(r113, R.id.model_training_data_type_group)) == null) goto L40;
        ItemGroup r100 = (ItemGroup) ViewBindings.findChildViewById(r113, R.id.obric_model_training_group);
        if (r100 != null) goto L11;
        r114 = R.id.obric_model_training_group;
        goto L43
    L11:
        if (((ChatSettingScrollView) ViewBindings.findChildViewById(r113, R.id.scroll_view)) == null) goto L38;
        NovaTitleBarEx r101 = (NovaTitleBarEx) ViewBindings.findChildViewById(r113, R.id.title);
        if (r101 != null) goto L15;
        r114 = R.id.title;
        goto L43
    L15:
        if (((CardView) ViewBindings.findChildViewById(r113, R.id.title_container)) == null) goto L36;
        UrlSpanTextView r102 = (UrlSpanTextView) ViewBindings.findChildViewById(r113, R.id.train_model_sub_title);
        if (r102 != null) goto L19;
        r114 = R.id.train_model_sub_title;
        goto L43
    L19:
        if (((TextView) ViewBindings.findChildViewById(r113, R.id.train_model_title)) == null) goto L34;
        ItemTextArrow r103 = (ItemTextArrow) ViewBindings.findChildViewById(r113, R.id.type_data_conversation_item);
        if (r103 == null) goto L33;
        ItemTextArrow r104 = (ItemTextArrow) ViewBindings.findChildViewById(r113, R.id.type_data_upload_multimedia_item);
        if (r104 == null) goto L32;
        ItemTextArrow r105 = (ItemTextArrow) ViewBindings.findChildViewById(r113, R.id.type_data_video_conversation_item);
        if (r105 == null) goto L31;
        ItemTextArrow r106 = (ItemTextArrow) ViewBindings.findChildViewById(r113, R.id.type_data_voice_input_item);
        if (r106 == null) goto L30;
        this.f368403e = new LarusPagePrivacyModelTrainingSettingBinding(r115, r100, r101, r102, r103, r104, r105, r106);
        return r115;
    L30:
        r114 = R.id.type_data_voice_input_item;
        goto L43
    L31:
        r114 = R.id.type_data_video_conversation_item;
        goto L43
    L32:
        r114 = R.id.type_data_upload_multimedia_item;
        goto L43
    L33:
        r114 = R.id.type_data_conversation_item;
        goto L43
    L34:
        r114 = R.id.train_model_title;
        goto L43
    L36:
        r114 = R.id.title_container;
        goto L43
    L38:
        r114 = R.id.scroll_view;
        goto L43
    L40:
        r114 = R.id.model_training_data_type_group;
    L43:
        throw new NullPointerException("Missing required view with ID: ".concat(r113.getResources().getResourceName(r114)));
    }
}
