package com.larus.project;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.os.BundleKt;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.byted.cast.common.auth.AuthConstants;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.larus.bmhome.taskskill.l2;
import com.larus.bmhome.taskskill.model.PcDevice;
import com.larus.bmhome.taskskill.service.IProjectListDataSource;
import com.larus.common_res.common_ui.databinding.LarusLayoutBottomSheetHeaderBinding;
import com.larus.common_ui.dialog.RoundedBottomSheetDialogFragment;
import com.larus.dispatcher.api.AllDeviceResponse;
import com.larus.dispatcher.api.GetAllDevicesRepo;
import com.larus.flowskill.impl.databinding.LarusFragmentProjectBinding;
import com.larus.flowskill.impl.databinding.LarusItemTaskProjectBinding;
import com.larus.flowskill.impl.databinding.LarusLayoutTaskSkillStateBinding;
import com.larus.nova.R;
import com.larus.platform.model.SlashMentionConfig;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.ss.android.dypay.api.DyPayConstant;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.texturerender.effect.ICEffect.ICEffectKeys;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import v19.i5;
import v19.m7;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u009f\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\"\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0016*\u0003(+.\u0018\u0000 j2\u00020\u0001:\u0001jB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u000103H\u0016J&\u00104\u001a\u0004\u0018\u00010\u00122\u0006\u00105\u001a\u0002062\b\u00107\u001a\u0004\u0018\u0001082\b\u00102\u001a\u0004\u0018\u000103H\u0016J\u001a\u00109\u001a\u0002012\u0006\u0010:\u001a\u00020\u00122\b\u00102\u001a\u0004\u0018\u000103H\u0016J\u001e\u0010;\u001a\u0002012\u0006\u0010<\u001a\u00020\u00122\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0014J\u0012\u0010=\u001a\u0002012\b\b\u0002\u0010>\u001a\u00020\u0005H\u0002J\b\u0010?\u001a\u00020\u0005H\u0002J\b\u0010@\u001a\u00020\u0005H\u0002J\u0018\u0010A\u001a\u00020\u00052\u0006\u0010B\u001a\u00020\u00052\u0006\u0010C\u001a\u00020\u0005H\u0002J\b\u0010D\u001a\u00020\u0005H\u0002J\b\u0010E\u001a\u00020\u0005H\u0002J\u0010\u0010F\u001a\u00020\u00052\u0006\u0010<\u001a\u00020\u0012H\u0002J\u0010\u0010G\u001a\u0002012\u0006\u0010H\u001a\u00020\u0005H\u0002J\b\u0010I\u001a\u000201H\u0002J\b\u0010J\u001a\u000201H\u0002J\u0018\u0010K\u001a\u0002012\u000e\u0010L\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010N0MH\u0002J\u0010\u0010O\u001a\u00020&2\u0006\u0010P\u001a\u00020&H\u0002J\b\u0010Q\u001a\u000201H\u0002J\b\u0010R\u001a\u000201H\u0002J\u0010\u0010S\u001a\u00020\u00052\u0006\u0010T\u001a\u00020UH\u0002J \u0010V\u001a\u0002012\u0006\u0010T\u001a\u00020U2\u0006\u0010W\u001a\u00020\u001a2\u0006\u0010X\u001a\u00020\u001aH\u0002J\u0010\u0010Y\u001a\u00020\u001a2\u0006\u0010P\u001a\u00020&H\u0002J\u001c\u0010Z\u001a\u0002012\b\b\u0002\u0010W\u001a\u00020\u001a2\b\b\u0002\u0010X\u001a\u00020\u001aH\u0002J\u001c\u0010[\u001a\u0002012\b\b\u0002\u0010W\u001a\u00020\u001a2\b\b\u0002\u0010X\u001a\u00020\u001aH\u0002J\b\u0010\\\u001a\u000201H\u0002J$\u0010]\u001a\u0002012\u0006\u0010^\u001a\u00020\u001a2\b\b\u0002\u0010W\u001a\u00020\u001a2\b\b\u0002\u0010X\u001a\u00020\u001aH\u0002J\u0018\u0010_\u001a\u0002012\u0006\u0010W\u001a\u00020\u001a2\u0006\u0010X\u001a\u00020\u001aH\u0002J\b\u0010`\u001a\u00020\u0005H\u0002J\b\u0010a\u001a\u000201H\u0002J\b\u0010b\u001a\u000201H\u0002J\u0010\u0010c\u001a\u0002012\u0006\u0010P\u001a\u00020&H\u0002J\b\u0010d\u001a\u000201H\u0002J(\u0010e\u001a\u0002012\u0006\u0010P\u001a\u00020&2\n\b\u0002\u0010f\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010g\u001a\u0004\u0018\u00010\u0017H\u0002J\b\u0010h\u001a\u000201H\u0016J\b\u0010i\u001a\u000201H\u0016R\u0014\u0010\u0004\u001a\u00020\u00058TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00170!X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0006\u0012\u0004\u0018\u00010\u00170#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u00020(X\u0082\u0004¢\u0006\u0004\n\u0002\u0010)R\u0010\u0010*\u001a\u00020+X\u0082\u0004¢\u0006\u0004\n\u0002\u0010,R\u0010\u0010-\u001a\u00020.X\u0082\u0004¢\u0006\u0004\n\u0002\u0010/¨\u0006k"}, d2 = {"Lcom/larus/project/TaskProjectFragment;", "Lcom/larus/common_ui/dialog/RoundedBottomSheetDialogFragment;", "<init>", "()V", "roundedBottomSheetBackgroundRes", "", "getRoundedBottomSheetBackgroundRes", "()I", "roundedBottomSheetTopCornerRadius", "getRoundedBottomSheetTopCornerRadius", "binding", "Lcom/larus/flowskill/impl/databinding/LarusFragmentProjectBinding;", "headerController", "Lcom/larus/common_ui/dialog/BottomSheetHeaderController;", "stateController", "Lcom/larus/bmhome/taskskill/ui/TaskSkillStateController;", "behavior", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "Landroid/view/View;", "bottomSheetView", "adapter", "Lcom/larus/project/TaskProjectAdapter;", "selectedDeviceId", "", "selectedProjectId", "hasMore", "", "isRequesting", "isSelectingProject", "hasReachedExpandedState", "projectSectionBaseBottomMargin", "projectSectionContentHeight", "onlineDeviceIds", "", "pcVersionsByDeviceId", "", "projects", "", "Lcom/larus/project/TaskProject;", "behaviorCallback", "com/larus/project/TaskProjectFragment$behaviorCallback$1", "Lcom/larus/project/TaskProjectFragment$behaviorCallback$1;", "pagingScrollListener", "com/larus/project/TaskProjectFragment$pagingScrollListener$1", "Lcom/larus/project/TaskProjectFragment$pagingScrollListener$1;", "stopFlingOnTouchListener", "com/larus/project/TaskProjectFragment$stopFlingOnTouchListener$1", "Lcom/larus/project/TaskProjectFragment$stopFlingOnTouchListener$1;", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "onViewCreated", "view", "onRoundedBottomSheetReady", "bottomSheet", "updatePanelLayout", "listItemCount", "projectItemHeightPx", "panelHeaderHeightPx", "adaptiveDimenPx", SlcElement.KEY_ATTR, "fallbackDimen", "currentExpandedPanelHeight", "projectItemHeight", "currentVisibleSheetHeight", "updateProjectSectionHeight", "visibleSheetHeight", "bindFixedActions", "observeDeviceStatus", "updateOnlineDevices", "devices", "", "Lcom/larus/bmhome/taskskill/model/PcDevice;", "withProjectUiState", SlashMentionConfig.SLASH_CONTENT_PROJECT, "loadNextPage", "showInitialProjectSnapshot", "visibleProjectCount", "snapshot", "Lcom/larus/bmhome/taskskill/service/ProjectListSnapshot;", "showProjectSnapshot", "anchorToTop", "autoLoadWhenUnderfilled", "shouldDisplayProject", DyPayConstant.KEY_SHOW_LOADING, "showProjects", "showLoadError", "submitProjects", "showPagingLoading", "onProjectItemsCommitted", "adapterItemCount", "onCreateProjectClick", "publishClearProjectSelection", "onProjectClick", "showDeviceOfflineToast", "publishProjectSelected", "resolvedDeviceName", "resolvedDeviceType", WidgetCostModule.TYPE_ON_START, "onDestroyView", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TaskProjectFragment extends RoundedBottomSheetDialogFragment {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final /* synthetic */ int f366975w = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LarusFragmentProjectBinding f366976d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public com.larus.bmhome.taskskill.ui.q f366977e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public BottomSheetBehavior<View> f366978f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f366979g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public TaskProjectAdapter f366980h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f366981i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f366982j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f366983k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f366984l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f366985m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f366986n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f366987o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f366988p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Set<String> f366989q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Map<String, String> f366990r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final List<i> f366991s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final b f366992t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final TaskProjectFragment$pagingScrollListener$1 f366993u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final TaskProjectFragment$stopFlingOnTouchListener$1 f366994v;

    public static final class a {
    }

    public static final class b extends BottomSheetBehavior.BottomSheetCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TaskProjectFragment f366995a;

        public b(TaskProjectFragment r100) {
            this.f366995a = r100;
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public final void onSlide(View r100, float r101) {
            Intrinsics.checkNotNullParameter(r100, "bottomSheet");
            TaskProjectFragment r102 = this.f366995a;
            int r103 = TaskProjectFragment.f366975w;
            r102.ha0(r102.Y90(r100));
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public final void onStateChanged(View r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "bottomSheet");
            boolean r102 = true;
            if (r101 != 3) goto L5;
            TaskProjectFragment r103 = this.f366995a;
            r103.f366986n = true;
            BottomSheetBehavior<View> r104 = r103.f366978f;
            if (r104 == null) goto L34;
            r104.setSkipCollapsed(true);
        L34:
            TaskProjectFragment r105 = this.f366995a;
            r105.ha0(r105.Y90(r100));
            return;
        L5:
            if (r101 == 4) goto L15;
            if (r101 == 5) goto L36;
            TaskProjectFragment r106 = this.f366995a;
            int r107 = TaskProjectFragment.f366975w;
            r106.ha0(r106.Y90(r100));
            return;
        L36:
            this.f366995a.dismissAllowingStateLoss();     // Catch: Exception -> L11
            return;
        L11:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r108 = DialogFragmentLancet.sLastShowStack;
            if (r108 == null) goto L39;
            com.bytedance.crash.d.d(r108, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        L39:
            return;
        L15:
            BottomSheetBehavior<View> r109 = this.f366995a.f366978f;
            if (r109 == null) goto L26;
            Integer r110 = Integer.valueOf(r109.getPeekHeight());
            if (r110.intValue() > 0) goto L21;
            r102 = false;
        L21:
            if (r102 == true) goto L24;
            r110 = null;
        L24:
            if (r110 == null) goto L26;
            this.f366995a.ha0(r110.intValue());
        L26:
            TaskProjectFragment r111 = this.f366995a;
            if (r111.f366986n == false) goto L41;
            BottomSheetBehavior<View> r112 = r111.f366978f;
            if (r112 == null) goto L42;
            r112.setState(5);
            return;
        L42:
            return;
        }
    }

    public static final class c implements View.OnLayoutChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TaskProjectFragment f366996a;

        public c(TaskProjectFragment r100) {
            this.f366996a = r100;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
            r100.removeOnLayoutChangeListener(this);
            TaskProjectFragment r109 = this.f366996a;
            TaskProjectAdapter r110 = r109.f366980h;
            if (r110 == null) goto L5;
            int r111 = r110.getItemCount();
        L6:
            r109.ga0(r111);
            return;
        L5:
            r111 = 0;
            goto L6
        }
    }

    public static final class d implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f366997a;

        public d(p r100) {
            Intrinsics.checkNotNullParameter(r100, "function");
            this.f366997a = r100;
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
            return this.f366997a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.Observer
        public final /* synthetic */ void onChanged(Object r100) {
            this.f366997a.invoke(r100);
        }
    }

    static {
    }

    @Override // com.larus.common_ui.dialog.RoundedBottomSheetDialogFragment
    public final int S90() {
        return R.drawable.larus_bg_task_project_bottom_sheet;
    }

    public final void Z90() {
        if (this.f366984l == false) goto L5;
        return;
    L5:
        if (this.f366983k == false) goto L18;
        IProjectListDataSource r100 = (IProjectListDataSource) ServiceManager.get().getService(IProjectListDataSource.class);
        if (r100 != null) goto L11;
        FLogger.f375446a.w("TaskProjectFragment", "IProjectListDataSource not found");
        ca0();
        return;
    L11:
        this.f366984l = true;
        if (((ArrayList) this.f366991s).isEmpty() == false) goto L14;
        da0(false, false);
    L15:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new TaskProjectFragment$loadNextPage$1(r100, this, null), 3, null);
        return;
    L14:
        ea0(true, false, false);
        goto L15
    }

    public final void ca0() {
        if (((ArrayList) this.f366991s).isEmpty() == false) goto L13;
        LarusFragmentProjectBinding r100 = this.f366976d;
        if (r100 == null) goto L9;
        RecyclerView r101 = r100.f343543i;
        if (r101 == null) goto L9;
        r101.setVisibility(8);
    L9:
        com.larus.bmhome.taskskill.ui.q r102 = this.f366977e;
        if (r102 == null) goto L12;
        r102.c();
    L12:
        ga0(0);
    L14:
        Context r103 = getContext();
        if (r103 == null) goto L18;
        t19.s r104 = t19.s.f544207a;
        String r105 = r103.getString(R.string.larus_load_chat_history_failed_toast);
        r104.getClass();
        t19.s.t(r103, r105);
        return;
    L18:
        return;
    L13:
        ea0(false, false, false);
        goto L14
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        LarusFragmentProjectBinding r100 = this.f366976d;
        if (r100 == null) goto L7;
        RecyclerView r101 = r100.f343543i;
        if (r101 == null) goto L7;
        r101.removeOnScrollListener(this.f366993u);
    L7:
        LarusFragmentProjectBinding r102 = this.f366976d;
        if (r102 == null) goto L12;
        RecyclerView r103 = r102.f343543i;
        if (r103 == null) goto L12;
        r103.removeOnItemTouchListener(this.f366994v);
    L12:
        TaskProjectAdapter r104 = this.f366980h;
        if (r104 == null) goto L15;
        r104.f366973a = null;
    L15:
        this.f366984l = false;
        this.f366985m = false;
        this.f366986n = false;
        this.f366987o = 0;
        this.f366988p = 0;
        this.f366990r = MapsKt.emptyMap();
        this.f366977e = null;
        this.f366978f = null;
        this.f366979g = null;
        this.f366980h = null;
        this.f366976d = null;
        super.onDestroyView();
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [com.larus.project.TaskProjectFragment$pagingScrollListener$1] */
    /* JADX WARN: Type inference failed for: r0v6, types: [com.larus.project.TaskProjectFragment$stopFlingOnTouchListener$1] */
    public TaskProjectFragment() {
        this.f366983k = true;
        this.f366989q = SetsKt.emptySet();
        this.f366990r = MapsKt.emptyMap();
        this.f366991s = new ArrayList();
        this.f366992t = new b(this);
        this.f366993u = new TaskProjectFragment$pagingScrollListener$1(this);
        this.f366994v = new TaskProjectFragment$stopFlingOnTouchListener$1();
    }

    @Override // com.larus.common_ui.dialog.RoundedBottomSheetDialogFragment
    public final int U90() {
        return i5.E();
    }

    @Override // com.larus.common_ui.dialog.RoundedBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        Dialog r100 = getDialog();
        if (r100 == null) goto L8;
        Window r101 = r100.getWindow();
        if (r101 == null) goto L9;
        m7.a(r101);
        return;
    L9:
        return;
    }

    public final int Y90(View r100) {
        Object r101 = r100.getParent();
        if ((r101 instanceof View) == false) goto L5;
        View r102 = (View) r101;
    L7:
        if (r102 != null) goto L10;
        return 0;
    L10:
        return RangesKt.coerceIn(r102.getHeight() - r100.getTop(), 0, r102.getHeight());
    L5:
        r102 = null;
        goto L7
    }

    public final boolean ba0(i r100) {
        if (r100.f367031c == false) goto L5;
        return true;
    L5:
        String r101 = this.f366981i;
        if (r101 != null) goto L8;
    L15:
        return true;
    L8:
        if ((!StringsKt.isBlank(r101)) == true) goto L11;
        r101 = null;
    L11:
        if (r101 == null) goto L15;
        return Intrinsics.areEqual(r100.f367034f, r101);
    }

    public final void fa0(List<PcDevice> r100) {
        List<PcDevice> r101 = r100;
        ArrayList r102 = new ArrayList();
        Iterator<T> r103 = r101.iterator();
    L3:
        boolean r104 = false;
        String r105 = null;
        if (r103.hasNext() == false) goto L18;
        PcDevice r106 = (PcDevice) r103.next();
        if (r106 == null) goto L16;
        String r107 = r106.getDeviceId();
        if (r107 == null) goto L16;
        if (Intrinsics.areEqual(r106.r(), Boolean.TRUE) == true) goto L12;
    L14:
        if (r104 == false) goto L16;
        r105 = r107;
        goto L16
    L12:
        if ((!StringsKt.isBlank(r107)) == false) goto L14;
        r104 = true;
    L16:
        if (r105 == null) goto L3;
        r102.add(r105);
        goto L3
    L18:
        Set<String> r108 = CollectionsKt.toSet(r102);
        ArrayList r109 = new ArrayList();
        Iterator<T> r110 = r101.iterator();
    L20:
        if (r110.hasNext() == false) goto L34;
        PcDevice r111 = (PcDevice) r110.next();
        if (r111 == null) goto L31;
        String r112 = r111.getDeviceId();
        if (r112 == null) goto L31;
        if ((!StringsKt.isBlank(r112)) == true) goto L29;
        r112 = null;
    L29:
        if (r112 == null) goto L31;
        Pair r113 = TuplesKt.to(r112, r111.o());
    L32:
        if (r113 == null) goto L20;
        r109.add(r113);
    L31:
        r113 = null;
        goto L32
    L34:
        Map<String, String> r114 = MapsKt.toMap(r109);
        if (Intrinsics.areEqual(this.f366989q, r108) == true) goto L37;
    L39:
        this.f366989q = r108;
        this.f366990r = r114;
        Iterator<Integer> r115 = CollectionsKt.getIndices(this.f366991s).iterator();
        boolean r116 = false;
    L41:
        if (r115.hasNext() == false) goto L45;
        int r117 = ((IntIterator) r115).nextInt();
        i r118 = (i) ListProtector.get(this.f366991s, r117);
        i r119 = ia0(r118);
        if (Intrinsics.areEqual(r118, r119) == true) goto L41;
        ListProtector.set(this.f366991s, r117, r119);
        r116 = true;
        goto L41
    L45:
        if (r116 == false) goto L63;
        ea0(this.f366984l, false, false);
        return;
    L63:
        return;
    L37:
        if (Intrinsics.areEqual(this.f366990r, r114) == false) goto L39;
    }

    public final void ga0(final int r100) {
        LarusFragmentProjectBinding r101 = this.f366976d;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.f343535a.post(new n(this, r100));
    }

    public final void ha0(int r100) {
        if (r100 > 0) goto L4;
        return;
    L4:
        if (this.f366988p <= 0) goto L30;
        LarusFragmentProjectBinding r101 = this.f366976d;
        if (r101 != null) goto L9;
        return;
    L9:
        ViewGroup.LayoutParams r102 = r101.f343541g.getLayoutParams();
        Integer r103 = null;
        if ((r102 instanceof ViewGroup.MarginLayoutParams) == false) goto L12;
        ViewGroup.MarginLayoutParams r104 = (ViewGroup.MarginLayoutParams) r102;
    L13:
        if (r104 != null) goto L15;
        return;
    L15:
        Integer r105 = Integer.valueOf(r101.f343539e.f326749a.getMeasuredHeight());
        if (r105.intValue() <= 0) goto L18;
        boolean r106 = true;
    L19:
        if (r106 == false) goto L21;
        r103 = r105;
    L21:
        if (r103 == null) goto L23;
        int r107 = r103.intValue();
    L24:
        int r108 = Math.min(this.f366988p, RangesKt.coerceAtLeast(((r100 - r107) - r104.topMargin) - this.f366987o, 0));
        if (r104.height != r108) goto L27;
        return;
    L27:
        r104.height = r108;
        r101.f343541g.setLayoutParams(r104);
        return;
    L23:
        r107 = getResources().getDimensionPixelSize(v19.c.b(R.attr.larus_dp_52, getContext(), R.dimen.larus_dp_52));
        goto L24
    L18:
        r106 = false;
        goto L19
    L12:
        r104 = null;
        goto L13
    }

    public final i ia0(i r110) {
        String r100 = r110.f367034f;
        String r101 = null;
        if (r100 != null) goto L5;
    L7:
        r100 = null;
    L8:
        boolean r111 = CollectionsKt.contains(this.f366989q, r100);
        if (r100 == null) goto L13;
        if (r111 == true) goto L13;
        boolean r102 = false;
    L14:
        if (r100 == null) goto L16;
        r101 = this.f366990r.get(r100);
    L16:
        if (r101 != null) goto L18;
    L21:
        boolean r103 = true;
    L22:
        if (r103 == false) goto L24;
    L27:
        boolean r104 = true;
    L28:
        boolean r112 = Intrinsics.areEqual(r110.f367029a, this.f366982j);
        if (r102 == false) goto L32;
        if (r104 == false) goto L32;
        boolean r113 = true;
    L33:
        String r105 = r110.f367029a;
        String r106 = r110.f367030b;
        boolean r107 = r110.f367031c;
        String r114 = r110.f367032d;
        String r115 = r110.f367033e;
        String r116 = r110.f367034f;
        String r117 = r110.f367035g;
        Intrinsics.checkNotNullParameter(r105, "projectId");
        Intrinsics.checkNotNullParameter(r106, "name");
        return new i(r105, r106, r107, r114, r115, r116, r117, r111, r112, r113);
    L32:
        r113 = false;
        goto L33
    L24:
        if (l2.b(r101) == true) goto L27;
        r104 = false;
        goto L28
    L18:
        if (StringsKt.isBlank(r101) == true) goto L21;
        r103 = false;
    L13:
        r102 = true;
        goto L14
    L5:
        if ((!StringsKt.isBlank(r100)) == false) goto L7;
        goto L7
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        Bundle r101 = getArguments();
        String r102 = null;
        if (r101 == null) goto L5;
        String r103 = r101.getString("selected_device_id");
    L6:
        this.f366981i = r103;
        Bundle r104 = getArguments();
        if (r104 == null) goto L9;
        r102 = r104.getString("selected_project_id");
    L9:
        this.f366982j = r102;
        return;
    L5:
        r103 = null;
        goto L6
    }

    public static final void W90(TaskProjectFragment r100, i r110) {
        if (r100.f366985m == false) goto L6;
        return;
    L6:
        if (r110.f367031c == false) goto L8;
        r100.aa0(r110, null, null);
        return;
    L8:
        String r101 = r110.f367034f;
        if (r101 != null) goto L11;
    L13:
        r101 = null;
    L14:
        if (r101 != null) goto L18;
        Context r102 = r100.getContext();
        if (r102 == null) goto L21;
        t19.s.f544207a.getClass();
        t19.s.s(r102, R.string.larus_groupChats_toast_createChatFail_deviceOff);
        return;
    L21:
        return;
    L18:
        r100.f366985m = true;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r100.getViewLifecycleOwner()), null, null, new TaskProjectFragment$onProjectClick$1(r100, r110, r101, null), 3, null);
        return;
    L11:
        if ((!StringsKt.isBlank(r101)) == false) goto L13;
        goto L13
    }

    @Override // com.larus.common_ui.dialog.RoundedBottomSheetDialogFragment
    public final void V90(View r100, BottomSheetBehavior<View> r101) {
        Intrinsics.checkNotNullParameter(r100, "bottomSheet");
        Intrinsics.checkNotNullParameter(r101, "behavior");
        ViewGroup.LayoutParams r102 = r100.getLayoutParams();
        if (r102 == null) goto L5;
        r102.height = -1;
    L6:
        r100.setLayoutParams(r102);
        Object r103 = r100.getParent();
        if ((r103 instanceof View) == false) goto L9;
        View r104 = (View) r103;
    L10:
        if (r104 == null) goto L18;
        ViewGroup.LayoutParams r105 = r104.getLayoutParams();
        if ((r105 instanceof ViewGroup.MarginLayoutParams) == false) goto L14;
        ViewGroup.MarginLayoutParams r106 = (ViewGroup.MarginLayoutParams) r105;
    L15:
        if (r106 == null) goto L17;
        r106.topMargin = getResources().getDimensionPixelSize(v19.c.b(R.attr.larus_dp_12, null, R.dimen.larus_dp_12));
    L17:
        r104.setLayoutParams(r106);
        goto L18
    L14:
        r106 = null;
    L18:
        this.f366978f = r101;
        this.f366979g = r100;
        int r107 = 0;
        r101.setSkipCollapsed(false);
        r101.setHideable(true);
        r101.setFitToContents(true);
        r101.setBottomSheetCallback(this.f366992t);
        r101.setState(4);
        if (r100.isLaidOut() == true) goto L21;
    L27:
        r100.addOnLayoutChangeListener(new c(this));
    L28:
        TaskProjectAdapter r108 = this.f366980h;
        if (r108 == null) goto L31;
        r107 = r108.getItemCount();
    L31:
        ga0(r107);
        return;
    L21:
        if (r100.isLayoutRequested() == true) goto L27;
        TaskProjectAdapter r109 = this.f366980h;
        if (r109 == null) goto L25;
        int r110 = r109.getItemCount();
    L26:
        ga0(r110);
        goto L28
    L25:
        r110 = 0;
        goto L26
    L9:
        r104 = null;
        goto L10
    L5:
        r102 = null;
        goto L6
    }

    public final void da0(final boolean r100, final boolean r101) {
        LarusFragmentProjectBinding r102 = this.f366976d;
        if (r102 == null) goto L7;
        RecyclerView r103 = r102.f343543i;
        if (r103 == null) goto L7;
        r103.setVisibility(0);
    L7:
        com.larus.bmhome.taskskill.ui.q r104 = this.f366977e;
        if (r104 == null) goto L10;
        r104.a();
    L10:
        final List r105 = CollectionsKt.listOf(w.a.f367067a);
        TaskProjectAdapter r106 = this.f366980h;
        if (r106 == null) goto L14;
        r106.submitList(r105, new k(this, r105, r100, r101));
        return;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [com.larus.project.p] */
    @Override // com.larus.common_ui.dialog.RoundedBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        LarusFragmentProjectBinding r102 = this.f366976d;
        if (r102 == null) goto L26;
        LarusLayoutBottomSheetHeaderBinding r103 = r102.f343539e;
        Intrinsics.checkNotNullParameter(r103, "binding");
        r103.f326752d.setText(R.string.larus_local_agent_select_project_cn);
        AppCompatImageView r104 = r103.f326750b;
        ViewGroup.LayoutParams r105 = r104.getLayoutParams();
        if (r105 == null) goto L25;
        ConstraintLayout.LayoutParams r106 = (ConstraintLayout.LayoutParams) r105;
        r106.startToStart = -1;
        r106.endToEnd = 0;
        r104.setLayoutParams(r106);
        r103.f326750b.setOnClickListener(new l(this));
        this.f366977e = new com.larus.bmhome.taskskill.ui.q(r102.f343542h, new m(this));
        TaskProjectAdapter r107 = new TaskProjectAdapter();
        r107.f366973a = new TaskProjectFragment$onViewCreated$1$3$1(this);
        r102.f343543i.setLayoutManager(new LinearLayoutManager(requireContext()));
        r102.f343543i.setAdapter(r107);
        r102.f343543i.addOnScrollListener(this.f366993u);
        r102.f343543i.addOnItemTouchListener(this.f366994v);
        this.f366980h = r107;
        ViewGroup.LayoutParams r108 = r102.f343541g.getLayoutParams();
        if ((r108 instanceof ViewGroup.MarginLayoutParams) == false) goto L9;
        ViewGroup.MarginLayoutParams r109 = (ViewGroup.MarginLayoutParams) r108;
    L10:
        if (r109 == null) goto L12;
        int r110 = r109.bottomMargin;
    L13:
        this.f366987o = r110;
        LarusFragmentProjectBinding r111 = this.f366976d;
        if (r111 == null) goto L18;
        LarusItemTaskProjectBinding r112 = r111.f343537c;
        if (r112 == null) goto L18;
        AppCompatImageView r113 = r112.f343570e;
        r113.setImageResource(v19.c.b(R.attr.larus_ic_side_bar_project_add, r113.getContext(), R.drawable.larus_ic_side_bar_project_add));
        r112.f343571f.setText(R.string.larus_groupChats_navBar_project_more_menuOption_newProject2);
        r112.f343569d.setVisibility(8);
        r112.f343572g.setVisibility(8);
        r112.f343568c.setVisibility(0);
        r112.f343566a.setOnClickListener(new r(this));
    L18:
        LarusFragmentProjectBinding r114 = this.f366976d;
        if (r114 == null) goto L23;
        LarusItemTaskProjectBinding r115 = r114.f343536b;
        if (r115 == null) goto L23;
        AppCompatImageView r116 = r115.f343570e;
        r116.setImageResource(v19.c.b(R.attr.larus_ic_side_bar_project_clear, r116.getContext(), R.drawable.larus_ic_side_bar_project_clear));
        r115.f343571f.setText(R.string.larus_local_agent_not_use_project);
        r115.f343569d.setVisibility(8);
        r115.f343572g.setVisibility(8);
        r115.f343568c.setVisibility(8);
        r115.f343566a.setOnClickListener(new s(this));
    L23:
        this.f366988p = getResources().getDimensionPixelSize(v19.c.b(R.attr.larus_dp_56, getContext(), R.dimen.larus_dp_56)) * 2;
        goto L26
    L12:
        r110 = 0;
        goto L13
    L9:
        r109 = null;
        goto L10
    L25:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L26:
        GetAllDevicesRepo r117 = GetAllDevicesRepo.f330842a;
        GetAllDevicesRepo.g();
        GetAllDevicesRepo.f330856o.observe(getViewLifecycleOwner(), new d(new p(this)));
        AllDeviceResponse r118 = GetAllDevicesRepo.d();
        if (r118 == null) goto L29;
        List<PcDevice> r119 = r118.getDevices();
    L30:
        if (r119 != null) goto L32;
        r119 = CollectionsKt.emptyList();
    L32:
        fa0(r119);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new TaskProjectFragment$observeDeviceStatus$2(this, null), 3, null);
        IProjectListDataSource r120 = (IProjectListDataSource) ServiceManager.get().getService(IProjectListDataSource.class);
        if (r120 != null) goto L35;
        FLogger.f375446a.w("TaskProjectFragment", "IProjectListDataSource not found");
        ca0();
        return;
    L35:
        this.f366984l = true;
        da0(false, false);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new TaskProjectFragment$showInitialProjectSnapshot$1(r120, this, null), 3, null);
        return;
    L29:
        r119 = null;
        goto L30
    }

    public final void aa0(i r100, String r101, String r102) {
        FragmentManager r103 = getParentFragmentManager();
        Pair[] r104 = new Pair[8];
        r104[0] = TuplesKt.to(AuthConstants.PARAM_KEY_LICENSE_PROJECT_ID, r100.f367029a);
        r104[1] = TuplesKt.to("project_name", r100.f367030b);
        r104[2] = TuplesKt.to("is_cloud_project", Boolean.valueOf(r100.f367031c));
        r104[3] = TuplesKt.to("folder_name", r100.f367032d);
        r104[4] = TuplesKt.to("workspace", r100.f367033e);
        r104[5] = TuplesKt.to("device_id", r100.f367034f);
        if (r101 != null) goto L5;
        r101 = r100.f367035g;
    L5:
        r104[6] = TuplesKt.to(ICEffectKeys.KEY_IS_IC_EFFECT_DEVICE_NAME, r101);
        r104[7] = TuplesKt.to("device_type", r102);
        r103.setFragmentResult("task_project_panel_result", BundleKt.bundleOf(r104));
        dismiss();     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r105 = DialogFragmentLancet.sLastShowStack;
        if (r105 == null) goto L15;
        com.bytedance.crash.d.d(r105, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public final void ea0(boolean r100, final boolean r101, final boolean r102) {
        List r103 = CollectionsKt.createListBuilder();
        List<i> r104 = this.f366991s;
        ArrayList r105 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r104, 10));
        Iterator<T> r106 = r104.iterator();
    L4:
        if (r106.hasNext() == false) goto L6;
        r105.add(new w.b((i) r106.next()));
        goto L4
    L6:
        r103.addAll(r105);
        if (r100 == false) goto L9;
        r103.add(w.a.f367067a);
    L9:
        final List r107 = CollectionsKt.build(r103);
        TaskProjectAdapter r108 = this.f366980h;
        if (r108 == null) goto L14;
        r108.submitList(r107, new o(this, r107, r101, r102));
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r110, ViewGroup r111, Bundle r112) {
        Intrinsics.checkNotNullParameter(r110, "inflater");
        View r113 = r110.inflate(R.layout.larus_fragment_project, r111, false);
        int r114 = R.id.clear_project_item;
        View r115 = ViewBindings.findChildViewById(r113, R.id.clear_project_item);
        if (r115 == null) goto L21;
        LarusItemTaskProjectBinding r100 = LarusItemTaskProjectBinding.a(r115);
        r114 = R.id.create_project_item;
        View r116 = ViewBindings.findChildViewById(r113, R.id.create_project_item);
        if (r116 == null) goto L21;
        LarusItemTaskProjectBinding r101 = LarusItemTaskProjectBinding.a(r116);
        r114 = R.id.project_fixed_actions;
        LinearLayout r102 = (LinearLayout) ViewBindings.findChildViewById(r113, R.id.project_fixed_actions);
        if (r102 == null) goto L21;
        r114 = R.id.project_header;
        View r117 = ViewBindings.findChildViewById(r113, R.id.project_header);
        if (r117 == null) goto L21;
        LarusLayoutBottomSheetHeaderBinding r103 = LarusLayoutBottomSheetHeaderBinding.a(r117);
        r114 = R.id.project_list_container;
        FrameLayout r104 = (FrameLayout) ViewBindings.findChildViewById(r113, R.id.project_list_container);
        if (r104 == null) goto L21;
        r114 = R.id.project_section;
        ConstraintLayout r105 = (ConstraintLayout) ViewBindings.findChildViewById(r113, R.id.project_section);
        if (r105 == null) goto L21;
        r114 = R.id.project_state;
        View r118 = ViewBindings.findChildViewById(r113, R.id.project_state);
        if (r118 == null) goto L21;
        LarusLayoutTaskSkillStateBinding r106 = LarusLayoutTaskSkillStateBinding.a(r118);
        r114 = R.id.rv_projects;
        RecyclerView r107 = (RecyclerView) ViewBindings.findChildViewById(r113, R.id.rv_projects);
        if (r107 == null) goto L21;
        ConstraintLayout r119 = (ConstraintLayout) r113;
        this.f366976d = new LarusFragmentProjectBinding(r119, r100, r101, r102, r103, r104, r105, r106, r107);
        return r119;
    L21:
        throw new NullPointerException("Missing required view with ID: ".concat(r113.getResources().getResourceName(r114)));
    }

    public static final void X90(TaskProjectFragment r100, com.larus.bmhome.taskskill.service.i r101, boolean r102, boolean r103) {
        r100.getClass();
        r100.f366983k = r101.f314450b;
        ((ArrayList) r100.f366991s).clear();
        List<i> r104 = r100.f366991s;
        List<com.larus.bmhome.taskskill.service.h> r105 = r101.f314449a;
        ArrayList r106 = new ArrayList();
        Iterator<T> r107 = r105.iterator();
    L4:
        if (r107.hasNext() == false) goto L8;
        i r108 = x.a(((com.larus.bmhome.taskskill.service.h) r107.next()).f314445a);
        if (r108 == null) goto L4;
        r106.add(r108);
        goto L4
    L8:
        ArrayList r109 = new ArrayList();
        Iterator r110 = r106.iterator();
    L10:
        if (r110.hasNext() == false) goto L14;
        Object r111 = r110.next();
        if (r100.ba0((i) r111) == false) goto L10;
        r109.add(r111);
        goto L10
    L14:
        ArrayList r112 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r109, 10));
        Iterator r113 = r109.iterator();
    L16:
        if (r113.hasNext() == false) goto L18;
        r112.add(r100.ia0((i) r113.next()));
        goto L16
    L18:
        CollectionsKt.addAll(r104, r112);
        if (r101.f314451c == false) goto L21;
    L23:
        LarusFragmentProjectBinding r114 = r100.f366976d;
        if (r114 == null) goto L28;
        RecyclerView r115 = r114.f343543i;
        if (r115 == null) goto L28;
        r115.setVisibility(0);
    L28:
        com.larus.bmhome.taskskill.ui.q r116 = r100.f366977e;
        if (r116 == null) goto L31;
        r116.a();
    L31:
        r100.ea0(false, r102, r103);
        return;
    L21:
        if (((ArrayList) r100.f366991s).isEmpty() == false) goto L23;
        r100.da0(r102, r103);
    }
}
