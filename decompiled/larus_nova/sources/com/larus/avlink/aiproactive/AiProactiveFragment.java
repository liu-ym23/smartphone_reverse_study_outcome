package com.larus.avlink.aiproactive;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.widget.TextViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.android.ttcjpaysdk.integrated.sign.counter.activity.SignCounterLaunchArgs;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.router.SmartRouter;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.larus.avlink.impl.databinding.LarusAvlinkPageAiProactiveBinding;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.bmhome.view.menu.CreateMenu;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.common_ui.dialog.p0;
import com.larus.nova.R;
import com.larus.settings.value.e10;
import com.larus.settings.value.y6;
import com.larus.trace.tracknode.TraceFragment;
import com.larus.utils.e1;
import com.larus.utils.l0;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.skydoves.balloon.Balloon;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ttnet.org.chromium.net.NetError;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import v19.i5;

/* JADX INFO: loaded from: classes23.dex */
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 i2\u00020\u00012\u00020\u0002:\u0001iB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J$\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u001a\u0010%\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020 2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u0010\u0010'\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020 H\u0002J\u0010\u0010(\u001a\u00020\u00122\u0006\u0010)\u001a\u00020*H\u0002J\b\u0010+\u001a\u00020\u001cH\u0016J\b\u0010,\u001a\u00020\u001cH\u0016J\b\u0010-\u001a\u00020\u001cH\u0002J\u0010\u0010.\u001a\u00020\u001c2\u0006\u0010/\u001a\u00020\u001eH\u0002J\u0018\u00100\u001a\u00020\u001c2\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u000204H\u0002J\b\u00105\u001a\u00020\u001cH\u0016J\b\u00106\u001a\u00020\u0012H\u0016J\b\u00107\u001a\u00020\u001cH\u0002J\u0016\u00108\u001a\u00020\u001c2\f\u00109\u001a\b\u0012\u0004\u0012\u00020;0:H\u0002J\u0010\u0010<\u001a\u00020\u001c2\u0006\u0010=\u001a\u00020;H\u0016J\u0018\u0010>\u001a\u00020\u001c2\u0006\u0010?\u001a\u00020 2\u0006\u0010=\u001a\u00020;H\u0016J\b\u0010@\u001a\u00020\u001cH\u0002J\u0018\u0010A\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020 2\u0006\u0010B\u001a\u00020\u0012H\u0002J\b\u0010B\u001a\u00020\u0012H\u0002J\u0018\u0010C\u001a\u00020\u00122\u0006\u0010=\u001a\u00020;2\u0006\u0010D\u001a\u00020\u0012H\u0016J\u0010\u0010E\u001a\u00020\u001c2\u0006\u0010=\u001a\u00020;H\u0016J\u0010\u0010F\u001a\u00020\u001c2\u0006\u0010G\u001a\u00020HH\u0002J1\u0010I\u001a\u00020\u001c2\n\b\u0002\u0010J\u001a\u0004\u0018\u00010*2\n\b\u0002\u00101\u001a\u0004\u0018\u0001022\n\b\u0002\u00103\u001a\u0004\u0018\u000104H\u0002¢\u0006\u0002\u0010KJ!\u0010L\u001a\u00020\u001c2\b\u00101\u001a\u0004\u0018\u0001022\b\u0010M\u001a\u0004\u0018\u00010*H\u0002¢\u0006\u0002\u0010NJ)\u0010O\u001a\u00020\u001c2\u0006\u0010P\u001a\u00020Q2\b\u0010R\u001a\u0004\u0018\u0001022\b\b\u0002\u0010S\u001a\u000204H\u0002¢\u0006\u0002\u0010TJ\b\u0010U\u001a\u000204H\u0002J\u0017\u0010V\u001a\u0002042\b\u0010W\u001a\u0004\u0018\u000104H\u0002¢\u0006\u0002\u0010XJ\u0010\u0010Y\u001a\u00020\u00122\u0006\u0010P\u001a\u00020QH\u0002J\u001a\u0010Z\u001a\u00020\u001c2\u0010\b\u0002\u0010[\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\\H\u0002J\b\u0010]\u001a\u00020\u001cH\u0002J\b\u0010^\u001a\u00020\u001cH\u0002J\u0010\u0010_\u001a\u00020\u001c2\u0006\u0010=\u001a\u00020;H\u0002J\b\u0010`\u001a\u00020\u001cH\u0016J\b\u0010a\u001a\u00020\u0012H\u0002J\u001a\u0010b\u001a\u00020\u001c2\u0006\u0010c\u001a\u00020d2\b\u0010e\u001a\u0004\u0018\u00010*H\u0002J\u001a\u0010f\u001a\u00020\u001c2\u0006\u0010c\u001a\u00020\u00102\b\u0010e\u001a\u0004\u0018\u00010*H\u0002J\b\u0010g\u001a\u00020\u001cH\u0002J\b\u0010h\u001a\u00020*H\u0016R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0015R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\u00020\u00178BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a¨\u0006j"}, d2 = {"Lcom/larus/avlink/aiproactive/AiProactiveFragment;", "Lcom/larus/trace/tracknode/TraceFragment;", "Lcom/larus/avlink/aiproactive/AiProactiveTaskAdapter$Listener;", "<init>", "()V", "viewModel", "Lcom/larus/avlink/aiproactive/AiProactiveTaskViewModel;", "getViewModel", "()Lcom/larus/avlink/aiproactive/AiProactiveTaskViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "taskAdapter", "Lcom/larus/avlink/aiproactive/AiProactiveTaskAdapter;", "currentBalloon", "Lcom/skydoves/balloon/Balloon;", "currentDialog", "Lcom/larus/common_ui/dialog/CommonDialog;", "shouldScrollToLatestCreatedTask", "", "isSyncingBehaviorAware", "currentCalibrationStatus", "Ljava/lang/Boolean;", "_binding", "Lcom/larus/avlink/impl/databinding/LarusAvlinkPageAiProactiveBinding;", "binding", "getBinding", "()Lcom/larus/avlink/impl/databinding/LarusAvlinkPageAiProactiveBinding;", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "onViewCreated", "view", "openUsageGuide", "isValidWebUrl", "url", "", WidgetCostModule.TYPE_ON_START, "onResume", "consumeEnvAuthResultIfNeeded", "clearEnvAuthPendingArgs", "args", "enableTaskAfterEnvAuth", DBDefinition.TASK_ID, "", SignCounterLaunchArgs.EXTRA_SCENE_TYPE, "", "onStop", "autoLogEnterPage", "observeState", "renderTaskList", "taskList", "", "Lcom/larus/avlink/aiproactive/model/UserAonTaskData;", "onItemClick", "task", "onItemLongClick", "anchor", "renderCapacityMode", "updateContentBottomConstraint", "isFullCapacityMode", "onItemSwitchChange", "newChecked", "onTaskBotomBannerClick", "renderTopBanner", "state", "Lcom/larus/avlink/aiproactive/TopBannerState;", "jumpToEnvAuth", "authSource", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Integer;)V", "showTaskEditDialog", "initialContent", "(Ljava/lang/Long;Ljava/lang/String;)V", "showTaskConfirmDialog", "draft", "Lcom/larus/avlink/aiproactive/model/UserAonTaskDraft;", "editTaskId", "initialReminderMethod", "(Lcom/larus/avlink/aiproactive/model/UserAonTaskDraft;Ljava/lang/Long;I)V", "consumePendingReminderMethod", "normalizeReminderMethod", "reminderMethod", "(Ljava/lang/Integer;)I", "isImuTaskDraft", "showBehaviorAwareEnableDialog", "onDialogClosed", "Lkotlin/Function0;", "syncBehaviorAwareThenRefresh", "showEnableFailedToast", "showDeleteConfirmDialog", "onDestroyView", "canShowDialog", "showDialogSafely", "dialog", "Landroidx/fragment/app/DialogFragment;", "tag", "showCommonDialogSafely", "dismissCommonDialogSafely", "getCurrentPageName", "Companion", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AiProactiveFragment extends TraceFragment implements AiProactiveTaskAdapter.b {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f291504m = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f291505e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AiProactiveTaskAdapter f291506f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Balloon f291507g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public CommonDialog f291508h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f291509i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f291510j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Boolean f291511k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public LarusAvlinkPageAiProactiveBinding f291512l;

    public static final class a {
    }

    public static final class b implements p0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AiProactiveFragment f291513a;

        @Override // com.larus.common_ui.dialog.p0
        public final void confirm() {
            AiProactiveFragment r100 = this.f291513a;
            if (r100.f291510j == true) goto L7;
            r100.f291510j = true;
            BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r100.getViewLifecycleOwner()), null, null, new AiProactiveFragment$syncBehaviorAwareThenRefresh$1(r100, null), 3, null);
            return;
        }

        public b(AiProactiveFragment r100) {
            this.f291513a = r100;
        }
    }

    public static final class c implements com.larus.common_ui.dialog.u {
        public c() {
        }

        @Override // com.larus.common_ui.dialog.u
        public final void cancel() {
        }
    }

    public static final class d implements AiProactiveTaskConfirmDialog.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AiProactiveFragment f291514a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Long f291515b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ t88.o f291516c;

        @Override // com.larus.avlink.aiproactive.AiProactiveTaskConfirmDialog.b
        public final void c() {
        }

        @Override // com.larus.avlink.aiproactive.AiProactiveTaskConfirmDialog.b
        public final void a(int r100) {
            Bundle r101 = this.f291514a.getArguments();
            if (r101 != null) goto L5;
            r101 = new Bundle();
            this.f291514a.setArguments(r101);
        L5:
            AiProactiveFragment r102 = this.f291514a;
            Integer r103 = Integer.valueOf(r100);
            int r104 = AiProactiveFragment.f291504m;
            r101.putInt("key_pending_reminder_method", r102.Z90(r103));
            this.f291514a.ea0(this.f291515b, this.f291516c.c());
        }

        @Override // com.larus.avlink.aiproactive.AiProactiveTaskConfirmDialog.b
        public final void b(final t88.o r100, final int r101) {
            Intrinsics.checkNotNullParameter(r100, "draft");
            AiProactiveFragment r102 = this.f291514a;
            int r103 = AiProactiveFragment.f291504m;
            r102.getClass();
            boolean r104 = true;
            if (r100.d() == 3) goto L43;
            List<t88.b> r105 = r100.b();
            if (r105 == null) goto L42;
            List<t88.b> r106 = r105;
            if ((r106 instanceof Collection) == true) goto L10;
        L12:
            Iterator<T> r107 = r106.iterator();
        L14:
            if (r107.hasNext() == false) goto L39;
            t88.b r108 = (t88.b) r107.next();
            if (r108 == null) goto L23;
            Integer r109 = r108.b();
            if (r109 == null) goto L23;
            if (r109.intValue() != 7) goto L23;
            boolean r110 = true;
        L24:
            if (r110 == true) goto L36;
            if (r108 == null) goto L32;
            Integer r111 = r108.b();
            if (r111 == null) goto L32;
            if (r111.intValue() != 8) goto L32;
            boolean r112 = true;
        L33:
            if (r112 == true) goto L36;
            boolean r113 = false;
        L37:
            if (r113 == false) goto L14;
            boolean r114 = true;
        L40:
            if (r114 != true) goto L42;
        L32:
            r112 = false;
        L36:
            r113 = true;
        L23:
            r110 = false;
        L39:
            r114 = false;
            goto L40
        L10:
            if (r106.isEmpty() == false) goto L12;
        L42:
            r104 = false;
        L43:
            if (r104 == true) goto L45;
        L48:
            this.f291514a.X90().createUserAonTask(r100, r101);
            return;
        L45:
            if (this.f291514a.X90().isBehaviorAwareEnabled() == true) goto L48;
            final AiProactiveFragment r115 = this.f291514a;
            r115.ba0(new p(r115, r100, r101));
        }

        public d(AiProactiveFragment r100, Long r101, t88.o r102) {
            this.f291514a = r100;
            this.f291515b = r101;
            this.f291516c = r102;
        }

        @Override // com.larus.avlink.aiproactive.AiProactiveTaskConfirmDialog.b
        public final void d(long r100, t88.o r101, int r102) {
            Intrinsics.checkNotNullParameter(r101, "draft");
            AiProactiveFragment r103 = this.f291514a;
            int r104 = AiProactiveFragment.f291504m;
            r103.X90().editUserAonTask(r100, r101, r102);
        }
    }

    static {
    }

    @Override // com.larus.trace.tracknode.TraceFragment
    public final boolean S90() {
        return true;
    }

    @Override // com.larus.trace.tracknode.a
    public final String k() {
        return AiProactiveTaskViewModel.PAGE_DORA_PROACTIVE_TASKS;
    }

    public final void W90() {
        CommonDialog r100 = this.f291508h;
        if (r100 != null) goto L12;
    L10:
        this.f291508h = null;
        return;
    L12:
        r100.dismissAllowingStateLoss();     // Catch: Exception -> L6
    L6:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r101 = DialogFragmentLancet.sLastShowStack;
        if (r101 == null) goto L10;
        com.bytedance.crash.d.d(r101, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L10
    }

    public final AiProactiveTaskViewModel X90() {
        return (AiProactiveTaskViewModel) this.f291505e.getValue();
    }

    public final void aa0() {
        e10 r100 = e10.f368561a;
        int r101 = l0.f375430a;
        boolean r102 = false;
        Integer r103 = ((nu9.c) l0.a(new nu9.c(0), new y6())).a();
        if (r103 == null) goto L5;
        int r104 = r103.intValue();
    L7:
        if (r104 != 1) goto L9;
        r102 = true;
    L9:
        LarusAvlinkPageAiProactiveBinding r105 = this.f291512l;
        Intrinsics.checkNotNull(r105);
        e1.y(r105.f293157b, !r102);
        LarusAvlinkPageAiProactiveBinding r106 = this.f291512l;
        Intrinsics.checkNotNull(r106);
        fa0(r106.f293162g, r102);
        LarusAvlinkPageAiProactiveBinding r107 = this.f291512l;
        Intrinsics.checkNotNull(r107);
        fa0(r107.f293158c, r102);
        return;
    L5:
        r104 = 0;
        goto L7
    }

    public AiProactiveFragment() {
        final Function0<Fragment> r100 = new AiProactiveFragment$special$$inlined$viewModels$default$1(this);
        this.f291505e = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(AiProactiveTaskViewModel.class), new AiProactiveFragment$special$$inlined$viewModels$default$2(r100), new AiProactiveFragment$special$$inlined$viewModels$default$3(r100, this));
        this.f291506f = new AiProactiveTaskAdapter(this);
    }

    public final boolean V90() {
        if (isAdded() == true) goto L5;
    L9:
        return false;
    L5:
        if (getView() == null) goto L9;
        if (getChildFragmentManager().isStateSaved() == true) goto L9;
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        Balloon r100 = this.f291507g;
        if (r100 == null) goto L5;
        r100.h();
    L5:
        this.f291507g = null;
        W90();
        this.f291512l = null;
    }

    @Override // com.larus.trace.tracknode.TraceFragment, androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        aa0();
        X90().refreshEnvObserveStatus();
        X90().refreshBehaviorAwareStatus();
        Bundle r100 = getArguments();
        if (r100 == null) goto L42;
        String r101 = r100.getString("dora_env_auth_source");
        if (r101 != null) goto L8;
        r100.remove("dora_env_auth_finish_after_success");
        r100.remove("dora_env_auth_source");
        r100.remove("dora_env_auth_task_id");
        r100.remove("dora_env_auth_task_scene_type");
        return;
    L8:
        final long r102 = r100.getLong("dora_env_auth_task_id", -1);
        final int r110 = r100.getInt("dora_env_auth_task_scene_type", -1);
        r100.remove("dora_env_auth_finish_after_success");
        r100.remove("dora_env_auth_source");
        r100.remove("dora_env_auth_task_id");
        r100.remove("dora_env_auth_task_scene_type");
        if (X90().isEnvObserveEnable() == false) goto L43;
        int r103 = r101.hashCode();
        if (r103 == (-287472212)) goto L24;
        if (r103 == 126464888) goto L20;
        if (r103 != 196103521) goto L44;
        r101.equals("FROM_BANNER");
        return;
    L44:
        return;
    L20:
        if (r101.equals("FROM_ADD_TASK") == false) goto L45;
        ea0(null, null);
        return;
    L45:
        return;
    L24:
        if (r101.equals("FROM_ENABLE_TASK") == true) goto L27;
        return;
    L27:
        if (r102 == (-1)) goto L40;
        if (r110 != (-1)) goto L31;
        return;
    L31:
        if (r110 == 3) goto L33;
    L35:
        X90().changeTaskStatus(r102, true, r110);
        return;
    L33:
        if (X90().isBehaviorAwareEnabled() == true) goto L35;
        ba0(new com.larus.avlink.aiproactive.a(this, r102, r110));
        return;
    L40:
        return;
    L43:
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onStart() {
        super.onStart();
        X90().startObserveEnvScene();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onStop() {
        X90().stopObserveEnvScene();
        super.onStop();
    }

    public final int Z90(Integer r100) {
        if (r100 != null) goto L5;
    L6:
        if (r100 != null) goto L9;
    L11:
        return 0;
    L9:
        if (r100.intValue() != 1) goto L11;
    L13:
        return r100.intValue();
    L5:
        if (r100.intValue() == 0) goto L13;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [com.larus.avlink.aiproactive.k] */
    public final void ba0(final Function0<Unit> r100) {
        Context r101 = getContext();
        if (r101 != null) goto L8;
        if (r100 == null) goto L18;
        r100.invoke();
        return;
    L18:
        return;
    L8:
        if (getChildFragmentManager().findFragmentByTag("AiProactiveBehaviorAwareDialog") == null) goto L12;
        if (r100 == null) goto L19;
        r100.invoke();
        return;
    L19:
        return;
    L12:
        final Ref.BooleanRef r102 = new Ref.BooleanRef();
        final ?? r103 = new k(r102, r100);
        CommonDialog.a r104 = new CommonDialog.a();
        r104.i(r101.getString(R.string.larus_dora_ai_active_behavior_state_confirm_title_cn));
        r104.g(r101.getString(R.string.larus_dora_ai_active_behavior_state_confirm_desc_cn));
        r104.f327188q = ContextCompat.getColor(r101, R.color.primary_50);
        CommonDialog.a.f(r104, new b(this), r101.getString(R.string.larus_dora_ai_active_confirm_cn), false, 12);
        r104.f327189r = ContextCompat.getColor(r101, R.color.neutral_100);
        CommonDialog.a.e(r104, new c(), r101.getString(R.string.larus_dora_ai_active_cancel_cn), 4);
        DialogInterface.OnDismissListener r105 = new l(r103);
        Intrinsics.checkNotNullParameter(r105, "listener");
        r104.f327195x = r105;
        CommonDialog r106 = r104.a();
        this.f291508h = r106;
        if (V90() == true) goto L16;
        this.f291508h = null;
        r103.invoke();
        return;
    L16:
        U90(r106, getChildFragmentManager(), "AiProactiveBehaviorAwareDialog");
    }

    @Override // com.larus.avlink.aiproactive.AiProactiveTaskAdapter.b
    public final void gz(t88.n r100) {
        Intrinsics.checkNotNullParameter(r100, "task");
        Context r101 = getContext();
        if (r101 != null) goto L5;
        return;
    L5:
        SmartRouter.buildRoute(r101, "//flow/dora/lab_head_down_detection").d();
    }

    @Override // com.larus.trace.tracknode.TraceFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        X90().takeLongHeadDownCalibrationOnce();
    }

    public static void fa0(View r100, boolean r101) {
        ViewGroup.LayoutParams r102 = r100.getLayoutParams();
        if ((r102 instanceof ConstraintLayout.LayoutParams) == false) goto L5;
        ConstraintLayout.LayoutParams r103 = (ConstraintLayout.LayoutParams) r102;
    L6:
        if (r103 != null) goto L9;
        return;
    L9:
        if (r101 == false) goto L11;
        r103.bottomToTop = -1;
        r103.bottomToBottom = 0;
    L12:
        r100.setLayoutParams(r103);
        return;
    L11:
        r103.bottomToBottom = -1;
        r103.bottomToTop = R.id.ai_proactive_add_task_btn;
        goto L12
    L5:
        r103 = null;
        goto L6
    }

    @Override // com.larus.avlink.aiproactive.AiProactiveTaskAdapter.b
    public final void JK(View r510, final t88.n r511) {
        Intrinsics.checkNotNullParameter(r510, "anchor");
        Intrinsics.checkNotNullParameter(r511, "task");
        Context r100 = getContext();
        if (r100 != null) goto L5;
        return;
    L5:
        boolean r101 = true;
        List r110 = CollectionsKt.mutableListOf(new com.larus.bmhome.view.screenmenu.l0[]{new com.larus.bmhome.view.screenmenu.l0(1, 0, requireContext().getString(R.string.larus_dora_ai_active_task_action_edit_cn), null, null, Integer.valueOf(R.color.larus_neutral_100), null, Integer.valueOf(R.drawable.larus_ic_screen_menu_modify), null, false, false, null, null, null, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, NetError.ERR_ICANN_NAME_COLLISION, 127)});
        e10 r102 = e10.f368561a;
        int r103 = l0.f375430a;
        Integer r104 = ((nu9.c) l0.a(new nu9.c(0), new y6())).a();
        if (r104 == null) goto L8;
        int r105 = r104.intValue();
    L9:
        if (r105 == 1) goto L12;
        r101 = false;
    L12:
        if (r101 == true) goto L14;
        r110.add(new com.larus.bmhome.view.screenmenu.l0(2, 0, requireContext().getString(R.string.larus_dora_ai_active_task_action_delete_cn), null, null, Integer.valueOf(R.color.larus_danger_50), null, Integer.valueOf(R.drawable.larus_ic_screen_menu_delete), null, false, false, null, null, null, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, NetError.ERR_ICANN_NAME_COLLISION, 127));
    L14:
        Balloon r106 = com.larus.bmhome.view.screenmenu.d.a(com.larus.bmhome.view.screenmenu.d.f317270a, r510, CreateMenu.f(new CreateMenu(r100), r110, 0, false, null, null, null, null, new com.larus.avlink.aiproactive.c(this, r511), 510), false, null, null, null, null, 124);
        this.f291507g = r106;
        r106.v(r510, i5.m0(), i5.t0());
        return;
    L8:
        r105 = 0;
        goto L9
    }

    public final void ca0(BottomSheetDialogFragment r100, String r101) {
        if (V90() == true) goto L5;
        return;
    L5:
        FragmentManager r102 = getChildFragmentManager();
        LandscapeRestrictionOperation r103 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r100, r101, r103);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r102, r100, r103) == true) goto L14;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L11
    L9:
        r100.show(r102, r101);
        return;
    }

    public final void ea0(Long r100, String r101) {
        AiProactiveTaskEditDialog r102 = new AiProactiveTaskEditDialog();
        Bundle r103 = new Bundle();
        if (r100 == null) goto L5;
        r103.putLong("arg_task_id", r100.longValue());
    L5:
        if (r101 == null) goto L7;
        r103.putString("arg_initial_content", r101);
    L7:
        r102.setArguments(r103);
        r102.f291542h = new h(r102, this);
        ca0(r102, "AiProactiveTaskEditDialog");
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r210, Bundle r211) {
        Intrinsics.checkNotNullParameter(r210, "view");
        super.onViewCreated(r210, r211);
        LarusAvlinkPageAiProactiveBinding r100 = this.f291512l;
        Intrinsics.checkNotNull(r100);
        NovaTitleBarEx r101 = r100.f293163h;
        NovaTitleBarEx.Y5(r101, r101.getContext().getString(R.string.larus_dora_ai_active_task_title_cn), null, null, 6);
        TextView r102 = r101.getBinding().f326844j;
        TextViewCompat.setAutoSizeTextTypeWithDefaults(r102, 0);
        r102.setTextSize(2, 17.0f);
        r102.setTypeface(Typeface.DEFAULT);
        NovaTitleBarEx.b6(r101, R.drawable.larus_ic_left_back, false, null, null, new com.larus.avlink.aiproactive.d(this), 14);
        e10 r103 = e10.f368561a;
        int r104 = l0.f375430a;
        String r105 = ((nu9.c) l0.a(new nu9.c(0), new y6())).b();
        boolean r106 = true;
        if (r105 != null) goto L5;
    L10:
        r105 = "";
    L12:
        if (StringsKt.isBlank(r105) == false) goto L14;
        r101.getBinding().f326842h.setVisibility(8);
    L30:
        LarusAvlinkPageAiProactiveBinding r107 = this.f291512l;
        Intrinsics.checkNotNull(r107);
        RecyclerView r108 = r107.f293162g;
        r108.setLayoutManager(new LinearLayoutManager(r108.getContext()));
        r108.setAdapter(this.f291506f);
        LarusAvlinkPageAiProactiveBinding r109 = this.f291512l;
        Intrinsics.checkNotNull(r109);
        r109.f293157b.setOnClickListener(new f(this));
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new AiProactiveFragment$observeState$1(this, null), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new AiProactiveFragment$observeState$2(this, null), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new AiProactiveFragment$observeState$3(this, null), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new AiProactiveFragment$observeState$4(this, null), 3, null);
        if (r211 != null) goto L34;
        X90().fetchTaskList();
        return;
    L34:
        return;
    L14:
        NovaTitleBarEx.o6(r101, r101.getContext().getString(R.string.larus_dora_ai_active_task_instruction_button_cn), new e(this));
        TextView r110 = r101.getBinding().f326842h;
        Drawable r111 = ContextCompat.getDrawable(r110.getContext(), R.drawable.larus_dora_avlink_ai_proactive_instruction);
        Resources r112 = r110.getResources();
        int r113 = (int) ((WindowDisplayMetricsOverride.apply(r112, r112.getDisplayMetrics()).density * 16.0f) + 0.5f);
        if (r111 != null) goto L17;
    L25:
        int r114 = r113;
    L26:
        Resources r115 = r110.getResources();
        int r116 = (int) ((WindowDisplayMetricsOverride.apply(r115, r115.getDisplayMetrics()).density * 3.0f) + 0.5f);
        if (r111 == null) goto L29;
        r111.setBounds(0, 0, r114, r113);
    L29:
        r110.setCompoundDrawablesRelative(r111, null, null, null);
        r110.setCompoundDrawablePadding(r116);
        goto L30
    L17:
        if (r111.getIntrinsicHeight() > 0) goto L20;
        r106 = false;
    L20:
        if (r106 == false) goto L22;
        Drawable r117 = r111;
    L23:
        if (r117 == null) goto L25;
        r114 = (r117.getIntrinsicWidth() * r113) / r117.getIntrinsicHeight();
        goto L26
    L22:
        r117 = null;
        goto L23
    L5:
        if ((!StringsKt.isBlank(r105)) == true) goto L8;
        r105 = null;
    L8:
        if (r105 == null) goto L10;
        goto L10
    }

    @Override // com.larus.avlink.aiproactive.AiProactiveTaskAdapter.b
    public final boolean vu(final t88.n r100, final boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "task");
        if (r101 == false) goto L9;
        if (X90().isEnvObserveEnable() == true) goto L9;
        Y90("FROM_ENABLE_TASK", Long.valueOf(r100.i()), Integer.valueOf(r100.h()));
        return false;
    L9:
        if (r101 == true) goto L11;
    L16:
        X90().changeTaskStatus(r100.i(), r101, r100.h());
        return true;
    L11:
        if (r100.h() != 3) goto L16;
        if (X90().isBehaviorAwareEnabled() == true) goto L16;
        ba0(new com.larus.avlink.aiproactive.b(this, r100, r101));
        return true;
    }

    public static void U90(CommonDialog r100, FragmentManager r101, String r102) {
        LandscapeRestrictionOperation r103 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r100, r102, r103);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r101, r100, r103) == false) goto L9;
        return;
    L9:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        r100.show(r101, r102);
    }

    public final void Y90(String r100, Long r101, Integer r102) {
        Context r103 = getContext();
        if (r103 != null) goto L5;
        return;
    L5:
        Bundle r104 = getArguments();
        if (r104 != null) goto L8;
        r104 = new Bundle();
        setArguments(r104);
    L8:
        r104.putBoolean("dora_env_auth_finish_after_success", true);
        if (r100 == null) goto L11;
        r104.putString("dora_env_auth_source", r100);
    L13:
        if (r101 == null) goto L15;
        r104.putLong("dora_env_auth_task_id", r101.longValue());
    L17:
        if (r102 == null) goto L19;
        r104.putInt("dora_env_auth_task_scene_type", r102.intValue());
    L20:
        com.bytedance.router.i r105 = SmartRouter.buildRoute(r103, "//flow/dora/env_auth");
        r105.f267554c.putExtras(r104);
        r105.d();
        return;
    L19:
        r104.remove("dora_env_auth_task_scene_type");
        goto L20
    L15:
        r104.remove("dora_env_auth_task_id");
        goto L17
    L11:
        r104.remove("dora_env_auth_source");
        goto L13
    }

    public final void da0(t88.o r100, Long r101, int r102) {
        int r103 = AiProactiveTaskConfirmDialog.f291530j;
        int r104 = Z90(Integer.valueOf(r102));
        AiProactiveTaskConfirmDialog r105 = new AiProactiveTaskConfirmDialog();
        r105.f291533f = r100;
        Bundle r106 = new Bundle();
        if (r101 == null) goto L5;
        r106.putLong("arg_edit_task_id", r101.longValue());
    L5:
        r106.putInt("arg_reminder_method", r104);
        r105.setArguments(r106);
        r105.f291532e = new d(this, r101, r100);
        ca0(r105, "AiProactiveTaskConfirmDialog");
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r110, ViewGroup r111, Bundle r112) {
        Intrinsics.checkNotNullParameter(r110, "inflater");
        View r113 = r110.inflate(R.layout.larus_avlink_page_ai_proactive, r111, false);
        int r114 = R.id.ai_proactive_add_task_btn;
        LinearLayout r100 = (LinearLayout) ViewBindings.findChildViewById(r113, R.id.ai_proactive_add_task_btn);
        if (r100 == null) goto L19;
        r114 = R.id.ai_proactive_empty_text;
        AppCompatTextView r101 = (AppCompatTextView) ViewBindings.findChildViewById(r113, R.id.ai_proactive_empty_text);
        if (r101 == null) goto L19;
        r114 = R.id.ai_proactive_env_notice_banner;
        ConstraintLayout r102 = (ConstraintLayout) ViewBindings.findChildViewById(r113, R.id.ai_proactive_env_notice_banner);
        if (r102 == null) goto L19;
        r114 = R.id.ai_proactive_env_notice_btn;
        TextView r103 = (TextView) ViewBindings.findChildViewById(r113, R.id.ai_proactive_env_notice_btn);
        if (r103 == null) goto L19;
        r114 = R.id.ai_proactive_env_notice_text;
        TextView r104 = (TextView) ViewBindings.findChildViewById(r113, R.id.ai_proactive_env_notice_text);
        if (r104 == null) goto L19;
        r114 = R.id.ai_proactive_task_list;
        RecyclerView r105 = (RecyclerView) ViewBindings.findChildViewById(r113, R.id.ai_proactive_task_list);
        if (r105 == null) goto L19;
        r114 = R.id.title;
        NovaTitleBarEx r106 = (NovaTitleBarEx) ViewBindings.findChildViewById(r113, R.id.title);
        if (r106 == null) goto L19;
        ConstraintLayout r115 = (ConstraintLayout) r113;
        LarusAvlinkPageAiProactiveBinding r116 = new LarusAvlinkPageAiProactiveBinding(r115, r100, r101, r102, r103, r104, r105, r106);
        this.f291512l = r116;
        Intrinsics.checkNotNull(r116);
        return r115;
    L19:
        throw new NullPointerException("Missing required view with ID: ".concat(r113.getResources().getResourceName(r114)));
    }
}
