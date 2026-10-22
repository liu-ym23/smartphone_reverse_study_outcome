package com.larus.business.multitask_management.impl.sheet;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.view.screenmenu.x0;
import com.larus.business.multitask_management.impl.component.DiscoverServicesFeature;
import com.larus.business.multitask_management.impl.component.OngoingTaskListAdapter;
import com.larus.business.multitask_management.impl.component.OngoingTasksFeature;
import com.larus.business.multitask_management.impl.component.PinnedServicesFeature;
import com.larus.business.multitask_management.impl.component.RecentServicesFeature;
import com.larus.business.multitask_management.impl.view.MtmQuickAccessScreenMenu;
import com.larus.common_ui.widget.concat_adapter.ConcatAdapter;
import com.larus.multitask_management.api.IMultiTaskHostAbility;
import com.larus.nova.R;
import com.larus.platform.service.z2;
import com.larus.ui.arch.component.external.api.provider.EmptyComponent;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.ttm.player.MediaPlayer;
import hq9.j3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.i1;
import org.json.JSONException;
import org.json.JSONObject;
import v19.y6;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0000\u0018\u0000 52\u00020\u0001:\u00015B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0016J\b\u0010+\u001a\u00020(H\u0016J7\u0010,\u001a\u00020(2\u0006\u0010-\u001a\u00020*2\b\u0010.\u001a\u0004\u0018\u00010\u00032\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020%2\u0006\u00102\u001a\u000203H\u0002¢\u0006\u0002\u00104R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0007\u001a\u0004\u0018\u00010\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001d\u0010\r\u001a\u0004\u0018\u00010\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0012\u001a\u0004\u0018\u00010\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\f\u001a\u0004\b\u0014\u0010\u0015R\u001d\u0010\u0017\u001a\u0004\u0018\u00010\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\f\u001a\u0004\b\u0019\u0010\u001aR\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lcom/larus/business/multitask_management/impl/sheet/MultiTaskManagementSheetComponent;", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "disallowParentInterceptOnTouchDown", "", "enableCardShadow", "<init>", "(ZZ)V", "pinnedServicesAbility", "Lcom/larus/business/multitask_management/impl/component/IPinnedServicesAbility;", "getPinnedServicesAbility", "()Lcom/larus/business/multitask_management/impl/component/IPinnedServicesAbility;", "pinnedServicesAbility$delegate", "Lkotlin/Lazy;", "ongoingTasksAbility", "Lcom/larus/business/multitask_management/impl/component/IOngoingTasksAbility;", "getOngoingTasksAbility", "()Lcom/larus/business/multitask_management/impl/component/IOngoingTasksAbility;", "ongoingTasksAbility$delegate", "recentServicesAbility", "Lcom/larus/business/multitask_management/impl/component/IRecentServicesAbility;", "getRecentServicesAbility", "()Lcom/larus/business/multitask_management/impl/component/IRecentServicesAbility;", "recentServicesAbility$delegate", "discoverServicesAbility", "Lcom/larus/business/multitask_management/impl/component/IDiscoverServicesAbility;", "getDiscoverServicesAbility", "()Lcom/larus/business/multitask_management/impl/component/IDiscoverServicesAbility;", "discoverServicesAbility$delegate", "pinnedAdapter", "Lcom/larus/business/multitask_management/impl/sheet/MtmServiceSectionAdapter;", "ongoingAdapter", "Lcom/larus/business/multitask_management/impl/component/OngoingTaskListAdapter;", "recentAdapter", "discoverAdapter", "screenMenu", "Lcom/larus/bmhome/view/screenmenu/ScreenMenu;", "language", "", "refreshRecent", "onViewCreated", "", "view", "Landroid/view/View;", "onResume", "showQuickAccessMenu", "anchorView", "pinned", "node", "Lcom/larus/multitask_management/api/data/quick_access/QuickAccessNode;", "enterMethod", "bindingAdapterPosition", "", "(Landroid/view/View;Ljava/lang/Boolean;Lcom/larus/multitask_management/api/data/quick_access/QuickAccessNode;Ljava/lang/String;I)V", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MultiTaskManagementSheetComponent extends BaseContentWidget {

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final /* synthetic */ int f320968z = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f320969m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f320970n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f320971o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Lazy f320972p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f320973q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Lazy f320974r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public MtmServiceSectionAdapter f320975s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public OngoingTaskListAdapter f320976t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public MtmServiceSectionAdapter f320977u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public MtmServiceSectionAdapter f320978v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public x0 f320979w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public String f320980x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f320981y;

    public static final class a {
    }

    public static final class b implements Function0<com.larus.business.multitask_management.impl.component.c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachReceiver f320982a;

        public b(AttachReceiver r100) {
            this.f320982a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.business.multitask_management.impl.component.c, t1a.a] */
        @Override // kotlin.jvm.functions.Function0
        public final com.larus.business.multitask_management.impl.component.c invoke() {
            AttachReceiver r100 = this.f320982a;
            if ((r100 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r100).o(Reflection.getOrCreateKotlinClass(com.larus.business.multitask_management.impl.component.c.class));
        }
    }

    public static final class c implements Function0<com.larus.business.multitask_management.impl.component.b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachReceiver f320983a;

        public c(AttachReceiver r100) {
            this.f320983a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.business.multitask_management.impl.component.b, t1a.a] */
        @Override // kotlin.jvm.functions.Function0
        public final com.larus.business.multitask_management.impl.component.b invoke() {
            AttachReceiver r100 = this.f320983a;
            if ((r100 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r100).o(Reflection.getOrCreateKotlinClass(com.larus.business.multitask_management.impl.component.b.class));
        }
    }

    public static final class d implements Function0<com.larus.business.multitask_management.impl.component.d> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachReceiver f320984a;

        public d(AttachReceiver r100) {
            this.f320984a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.business.multitask_management.impl.component.d, t1a.a] */
        @Override // kotlin.jvm.functions.Function0
        public final com.larus.business.multitask_management.impl.component.d invoke() {
            AttachReceiver r100 = this.f320984a;
            if ((r100 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r100).o(Reflection.getOrCreateKotlinClass(com.larus.business.multitask_management.impl.component.d.class));
        }
    }

    public static final class e implements Function0<com.larus.business.multitask_management.impl.component.a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachReceiver f320985a;

        public e(AttachReceiver r100) {
            this.f320985a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.business.multitask_management.impl.component.a, t1a.a] */
        @Override // kotlin.jvm.functions.Function0
        public final com.larus.business.multitask_management.impl.component.a invoke() {
            AttachReceiver r100 = this.f320985a;
            if ((r100 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r100).o(Reflection.getOrCreateKotlinClass(com.larus.business.multitask_management.impl.component.a.class));
        }
    }

    /* JADX INFO: renamed from: com.larus.business.multitask_management.impl.sheet.MultiTaskManagementSheetComponent$onViewCreated$6, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.business.multitask_management.impl.sheet.MultiTaskManagementSheetComponent$onViewCreated$6", f = "MultiTaskManagementSheetComponent.kt", i = {}, l = {444}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass6 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ConcatAdapter $concatAdapter;
        final /* synthetic */ MtmServiceSectionAdapter $discoverAdapter;
        final /* synthetic */ MtmSectionHeaderAdapter $discoverHeaderAdapter;
        final /* synthetic */ MtmEmptyStateAdapter $emptyStateAdapter;
        final /* synthetic */ Ref.BooleanRef $hasDiscover;
        final /* synthetic */ Ref.BooleanRef $hasOngoing;
        final /* synthetic */ Ref.BooleanRef $hasPinned;
        final /* synthetic */ Ref.BooleanRef $hasRecent;
        final /* synthetic */ boolean $hideOngoingTasks;
        final /* synthetic */ boolean $hidePinnedServices;
        final /* synthetic */ OngoingTaskListAdapter $ongoingAdapter;
        final /* synthetic */ MtmSectionHeaderAdapter $ongoingHeaderAdapter;
        final /* synthetic */ MtmServiceSectionAdapter $pinnedAdapter;
        final /* synthetic */ MtmSectionHeaderAdapter $pinnedHeaderAdapter;
        final /* synthetic */ MtmServiceSectionAdapter $recentAdapter;
        final /* synthetic */ MtmSectionHeaderAdapter $recentHeaderAdapter;
        int label;
        final /* synthetic */ MultiTaskManagementSheetComponent this$0;

        /* JADX INFO: renamed from: com.larus.business.multitask_management.impl.sheet.MultiTaskManagementSheetComponent$onViewCreated$6$a */
        public static final class a<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ MtmServiceSectionAdapter f320989a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Ref.BooleanRef f320990b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ ConcatAdapter f320991c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ boolean f320992d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final /* synthetic */ MtmSectionHeaderAdapter f320993e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public final /* synthetic */ Ref.BooleanRef f320994f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public final /* synthetic */ boolean f320995g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            public final /* synthetic */ MtmSectionHeaderAdapter f320996h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            public final /* synthetic */ OngoingTaskListAdapter f320997i;

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            public final /* synthetic */ Ref.BooleanRef f320998j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            public final /* synthetic */ MtmSectionHeaderAdapter f320999k;

            /* JADX INFO: renamed from: l, reason: collision with root package name */
            public final /* synthetic */ MtmServiceSectionAdapter f321000l;

            /* JADX INFO: renamed from: m, reason: collision with root package name */
            public final /* synthetic */ MtmEmptyStateAdapter f321001m;

            /* JADX INFO: renamed from: n, reason: collision with root package name */
            public final /* synthetic */ Ref.BooleanRef f321002n;

            /* JADX INFO: renamed from: o, reason: collision with root package name */
            public final /* synthetic */ MtmSectionHeaderAdapter f321003o;

            /* JADX INFO: renamed from: p, reason: collision with root package name */
            public final /* synthetic */ MtmServiceSectionAdapter f321004p;

            public a(MtmServiceSectionAdapter r100, Ref.BooleanRef r101, ConcatAdapter r102, boolean r103, MtmSectionHeaderAdapter r104, Ref.BooleanRef r105, boolean r106, MtmSectionHeaderAdapter r110, OngoingTaskListAdapter r111, Ref.BooleanRef r112, MtmSectionHeaderAdapter r113, MtmServiceSectionAdapter r114, MtmEmptyStateAdapter r115, Ref.BooleanRef r116, MtmSectionHeaderAdapter r117, MtmServiceSectionAdapter r118) {
                this.f320989a = r100;
                this.f320990b = r101;
                this.f320991c = r102;
                this.f320992d = r103;
                this.f320993e = r104;
                this.f320994f = r105;
                this.f320995g = r106;
                this.f320996h = r110;
                this.f320997i = r111;
                this.f320998j = r112;
                this.f320999k = r113;
                this.f321000l = r114;
                this.f321001m = r115;
                this.f321002n = r116;
                this.f321003o = r117;
                this.f321004p = r118;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public final Object emit(Object r110, Continuation r210) {
                com.larus.business.multitask_management.impl.component.i r100 = (com.larus.business.multitask_management.impl.component.i) r110;
                this.f320989a.A2(r100.f320812a, r100.f320813b, r100.f320814c);
                boolean r101 = !r100.f320812a.isEmpty();
                Ref.BooleanRef r102 = this.f320990b;
                if (r101 == r102.element) goto L6;
                r102.element = r101;
                MultiTaskManagementSheetComponent.m3(this.f320991c, r102, this.f320992d, this.f320993e, this.f320989a, this.f320994f, this.f320995g, this.f320996h, this.f320997i, this.f320998j, this.f320999k, this.f321000l, this.f321001m, this.f321002n, this.f321003o, this.f321004p);
            L6:
                return Unit.INSTANCE;
            }
        }

        public AnonymousClass6(MultiTaskManagementSheetComponent r100, MtmServiceSectionAdapter r101, Ref.BooleanRef r102, ConcatAdapter r103, boolean r104, MtmSectionHeaderAdapter r105, Ref.BooleanRef r110, boolean r111, MtmSectionHeaderAdapter r112, OngoingTaskListAdapter r113, Ref.BooleanRef r114, MtmSectionHeaderAdapter r115, MtmServiceSectionAdapter r116, MtmEmptyStateAdapter r117, Ref.BooleanRef r118, MtmSectionHeaderAdapter r119, MtmServiceSectionAdapter r210, Continuation<? super AnonymousClass6> r211) {
            this.this$0 = r100;
            this.$pinnedAdapter = r101;
            this.$hasPinned = r102;
            this.$concatAdapter = r103;
            this.$hidePinnedServices = r104;
            this.$pinnedHeaderAdapter = r105;
            this.$hasOngoing = r110;
            this.$hideOngoingTasks = r111;
            this.$ongoingHeaderAdapter = r112;
            this.$ongoingAdapter = r113;
            this.$hasRecent = r114;
            this.$recentHeaderAdapter = r115;
            this.$recentAdapter = r116;
            this.$emptyStateAdapter = r117;
            this.$hasDiscover = r118;
            this.$discoverHeaderAdapter = r119;
            this.$discoverAdapter = r210;
            super(2, r211);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r210, Continuation<?> r211) {
            return new AnonymousClass6(this.this$0, this.$pinnedAdapter, this.$hasPinned, this.$concatAdapter, this.$hidePinnedServices, this.$pinnedHeaderAdapter, this.$hasOngoing, this.$hideOngoingTasks, this.$ongoingHeaderAdapter, this.$ongoingAdapter, this.$hasRecent, this.$recentHeaderAdapter, this.$recentAdapter, this.$emptyStateAdapter, this.$hasDiscover, this.$discoverHeaderAdapter, this.$discoverAdapter, r211);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass6) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r210) {
            Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r101 = this.label;
            if (r101 == 0) goto L8;
            if (r101 != 1) goto L6;
            ResultKt.throwOnFailure(r210);
        L16:
            throw new KotlinNothingValueException();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r210);
            MultiTaskManagementSheetComponent r102 = this.this$0;
            int r103 = MultiTaskManagementSheetComponent.f320968z;
            com.larus.business.multitask_management.impl.component.c r104 = r102.Y2();
            if (r104 == null) goto L18;
            StateFlowImpl r105 = r104.HO();
            if (r105 == null) goto L18;
            a r110 = new a(this.$pinnedAdapter, this.$hasPinned, this.$concatAdapter, this.$hidePinnedServices, this.$pinnedHeaderAdapter, this.$hasOngoing, this.$hideOngoingTasks, this.$ongoingHeaderAdapter, this.$ongoingAdapter, this.$hasRecent, this.$recentHeaderAdapter, this.$recentAdapter, this.$emptyStateAdapter, this.$hasDiscover, this.$discoverHeaderAdapter, this.$discoverAdapter);
            this.label = 1;
            if (r105.collect(r110, this) != r100) goto L16;
            return r100;
        L18:
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.larus.business.multitask_management.impl.sheet.MultiTaskManagementSheetComponent$onViewCreated$7, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.business.multitask_management.impl.sheet.MultiTaskManagementSheetComponent$onViewCreated$7", f = "MultiTaskManagementSheetComponent.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_CMAF_HTTP_REQ_FINISH_TIME}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass7 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ConcatAdapter $concatAdapter;
        final /* synthetic */ MtmServiceSectionAdapter $discoverAdapter;
        final /* synthetic */ MtmSectionHeaderAdapter $discoverHeaderAdapter;
        final /* synthetic */ MtmEmptyStateAdapter $emptyStateAdapter;
        final /* synthetic */ Ref.BooleanRef $hasDiscover;
        final /* synthetic */ Ref.BooleanRef $hasOngoing;
        final /* synthetic */ Ref.BooleanRef $hasPinned;
        final /* synthetic */ Ref.BooleanRef $hasRecent;
        final /* synthetic */ boolean $hideOngoingTasks;
        final /* synthetic */ boolean $hidePinnedServices;
        final /* synthetic */ OngoingTaskListAdapter $ongoingAdapter;
        final /* synthetic */ MtmSectionHeaderAdapter $ongoingHeaderAdapter;
        final /* synthetic */ MtmServiceSectionAdapter $pinnedAdapter;
        final /* synthetic */ MtmSectionHeaderAdapter $pinnedHeaderAdapter;
        final /* synthetic */ MtmServiceSectionAdapter $recentAdapter;
        final /* synthetic */ MtmSectionHeaderAdapter $recentHeaderAdapter;
        int label;
        final /* synthetic */ MultiTaskManagementSheetComponent this$0;

        /* JADX INFO: renamed from: com.larus.business.multitask_management.impl.sheet.MultiTaskManagementSheetComponent$onViewCreated$7$a */
        public static final class a<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ OngoingTaskListAdapter f321005a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Ref.BooleanRef f321006b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ ConcatAdapter f321007c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ Ref.BooleanRef f321008d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final /* synthetic */ boolean f321009e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public final /* synthetic */ MtmSectionHeaderAdapter f321010f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public final /* synthetic */ MtmServiceSectionAdapter f321011g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            public final /* synthetic */ boolean f321012h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            public final /* synthetic */ MtmSectionHeaderAdapter f321013i;

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            public final /* synthetic */ Ref.BooleanRef f321014j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            public final /* synthetic */ MtmSectionHeaderAdapter f321015k;

            /* JADX INFO: renamed from: l, reason: collision with root package name */
            public final /* synthetic */ MtmServiceSectionAdapter f321016l;

            /* JADX INFO: renamed from: m, reason: collision with root package name */
            public final /* synthetic */ MtmEmptyStateAdapter f321017m;

            /* JADX INFO: renamed from: n, reason: collision with root package name */
            public final /* synthetic */ Ref.BooleanRef f321018n;

            /* JADX INFO: renamed from: o, reason: collision with root package name */
            public final /* synthetic */ MtmSectionHeaderAdapter f321019o;

            /* JADX INFO: renamed from: p, reason: collision with root package name */
            public final /* synthetic */ MtmServiceSectionAdapter f321020p;

            public a(OngoingTaskListAdapter r100, Ref.BooleanRef r101, ConcatAdapter r102, Ref.BooleanRef r103, boolean r104, MtmSectionHeaderAdapter r105, MtmServiceSectionAdapter r106, boolean r110, MtmSectionHeaderAdapter r111, Ref.BooleanRef r112, MtmSectionHeaderAdapter r113, MtmServiceSectionAdapter r114, MtmEmptyStateAdapter r115, Ref.BooleanRef r116, MtmSectionHeaderAdapter r117, MtmServiceSectionAdapter r118) {
                this.f321005a = r100;
                this.f321006b = r101;
                this.f321007c = r102;
                this.f321008d = r103;
                this.f321009e = r104;
                this.f321010f = r105;
                this.f321011g = r106;
                this.f321012h = r110;
                this.f321013i = r111;
                this.f321014j = r112;
                this.f321015k = r113;
                this.f321016l = r114;
                this.f321017m = r115;
                this.f321018n = r116;
                this.f321019o = r117;
                this.f321020p = r118;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public final Object emit(Object r110, Continuation r210) {
                List<kl9.u> r100 = (List) r110;
                this.f321005a.C2(r100);
                boolean r101 = !r100.isEmpty();
                Ref.BooleanRef r102 = this.f321006b;
                if (r101 == r102.element) goto L6;
                r102.element = r101;
                MultiTaskManagementSheetComponent.m3(this.f321007c, this.f321008d, this.f321009e, this.f321010f, this.f321011g, r102, this.f321012h, this.f321013i, this.f321005a, this.f321014j, this.f321015k, this.f321016l, this.f321017m, this.f321018n, this.f321019o, this.f321020p);
            L6:
                return Unit.INSTANCE;
            }
        }

        public AnonymousClass7(MultiTaskManagementSheetComponent r100, OngoingTaskListAdapter r101, Ref.BooleanRef r102, ConcatAdapter r103, Ref.BooleanRef r104, boolean r105, MtmSectionHeaderAdapter r110, MtmServiceSectionAdapter r111, boolean r112, MtmSectionHeaderAdapter r113, Ref.BooleanRef r114, MtmSectionHeaderAdapter r115, MtmServiceSectionAdapter r116, MtmEmptyStateAdapter r117, Ref.BooleanRef r118, MtmSectionHeaderAdapter r119, MtmServiceSectionAdapter r210, Continuation<? super AnonymousClass7> r211) {
            this.this$0 = r100;
            this.$ongoingAdapter = r101;
            this.$hasOngoing = r102;
            this.$concatAdapter = r103;
            this.$hasPinned = r104;
            this.$hidePinnedServices = r105;
            this.$pinnedHeaderAdapter = r110;
            this.$pinnedAdapter = r111;
            this.$hideOngoingTasks = r112;
            this.$ongoingHeaderAdapter = r113;
            this.$hasRecent = r114;
            this.$recentHeaderAdapter = r115;
            this.$recentAdapter = r116;
            this.$emptyStateAdapter = r117;
            this.$hasDiscover = r118;
            this.$discoverHeaderAdapter = r119;
            this.$discoverAdapter = r210;
            super(2, r211);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r210, Continuation<?> r211) {
            return new AnonymousClass7(this.this$0, this.$ongoingAdapter, this.$hasOngoing, this.$concatAdapter, this.$hasPinned, this.$hidePinnedServices, this.$pinnedHeaderAdapter, this.$pinnedAdapter, this.$hideOngoingTasks, this.$ongoingHeaderAdapter, this.$hasRecent, this.$recentHeaderAdapter, this.$recentAdapter, this.$emptyStateAdapter, this.$hasDiscover, this.$discoverHeaderAdapter, this.$discoverAdapter, r211);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass7) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r210) {
            Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r101 = this.label;
            if (r101 == 0) goto L8;
            if (r101 != 1) goto L6;
            ResultKt.throwOnFailure(r210);
        L16:
            throw new KotlinNothingValueException();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r210);
            MultiTaskManagementSheetComponent r102 = this.this$0;
            int r103 = MultiTaskManagementSheetComponent.f320968z;
            com.larus.business.multitask_management.impl.component.b r104 = (com.larus.business.multitask_management.impl.component.b) r102.f320972p.getValue();
            if (r104 == null) goto L18;
            i1<List<kl9.u>> r105 = r104.jc();
            if (r105 == null) goto L18;
            a r110 = new a(this.$ongoingAdapter, this.$hasOngoing, this.$concatAdapter, this.$hasPinned, this.$hidePinnedServices, this.$pinnedHeaderAdapter, this.$pinnedAdapter, this.$hideOngoingTasks, this.$ongoingHeaderAdapter, this.$hasRecent, this.$recentHeaderAdapter, this.$recentAdapter, this.$emptyStateAdapter, this.$hasDiscover, this.$discoverHeaderAdapter, this.$discoverAdapter);
            this.label = 1;
            if (r105.collect(r110, this) != r100) goto L16;
            return r100;
        L18:
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.larus.business.multitask_management.impl.sheet.MultiTaskManagementSheetComponent$onViewCreated$8, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.business.multitask_management.impl.sheet.MultiTaskManagementSheetComponent$onViewCreated$8", f = "MultiTaskManagementSheetComponent.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_SOCKET_ERR_CODE}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass8 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ConcatAdapter $concatAdapter;
        final /* synthetic */ MtmServiceSectionAdapter $discoverAdapter;
        final /* synthetic */ MtmSectionHeaderAdapter $discoverHeaderAdapter;
        final /* synthetic */ MtmEmptyStateAdapter $emptyStateAdapter;
        final /* synthetic */ Ref.BooleanRef $hasDiscover;
        final /* synthetic */ Ref.BooleanRef $hasOngoing;
        final /* synthetic */ Ref.BooleanRef $hasPinned;
        final /* synthetic */ Ref.BooleanRef $hasRecent;
        final /* synthetic */ boolean $hideOngoingTasks;
        final /* synthetic */ boolean $hidePinnedServices;
        final /* synthetic */ OngoingTaskListAdapter $ongoingAdapter;
        final /* synthetic */ MtmSectionHeaderAdapter $ongoingHeaderAdapter;
        final /* synthetic */ MtmServiceSectionAdapter $pinnedAdapter;
        final /* synthetic */ MtmSectionHeaderAdapter $pinnedHeaderAdapter;
        final /* synthetic */ MtmServiceSectionAdapter $recentAdapter;
        final /* synthetic */ MtmSectionHeaderAdapter $recentHeaderAdapter;
        int label;
        final /* synthetic */ MultiTaskManagementSheetComponent this$0;

        /* JADX INFO: renamed from: com.larus.business.multitask_management.impl.sheet.MultiTaskManagementSheetComponent$onViewCreated$8$a */
        public static final class a<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ MtmServiceSectionAdapter f321021a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Ref.BooleanRef f321022b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ ConcatAdapter f321023c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ Ref.BooleanRef f321024d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final /* synthetic */ boolean f321025e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public final /* synthetic */ MtmSectionHeaderAdapter f321026f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public final /* synthetic */ MtmServiceSectionAdapter f321027g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            public final /* synthetic */ Ref.BooleanRef f321028h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            public final /* synthetic */ boolean f321029i;

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            public final /* synthetic */ MtmSectionHeaderAdapter f321030j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            public final /* synthetic */ OngoingTaskListAdapter f321031k;

            /* JADX INFO: renamed from: l, reason: collision with root package name */
            public final /* synthetic */ MtmSectionHeaderAdapter f321032l;

            /* JADX INFO: renamed from: m, reason: collision with root package name */
            public final /* synthetic */ MtmEmptyStateAdapter f321033m;

            /* JADX INFO: renamed from: n, reason: collision with root package name */
            public final /* synthetic */ Ref.BooleanRef f321034n;

            /* JADX INFO: renamed from: o, reason: collision with root package name */
            public final /* synthetic */ MtmSectionHeaderAdapter f321035o;

            /* JADX INFO: renamed from: p, reason: collision with root package name */
            public final /* synthetic */ MtmServiceSectionAdapter f321036p;

            public a(MtmServiceSectionAdapter r100, Ref.BooleanRef r101, ConcatAdapter r102, Ref.BooleanRef r103, boolean r104, MtmSectionHeaderAdapter r105, MtmServiceSectionAdapter r106, Ref.BooleanRef r110, boolean r111, MtmSectionHeaderAdapter r112, OngoingTaskListAdapter r113, MtmSectionHeaderAdapter r114, MtmEmptyStateAdapter r115, Ref.BooleanRef r116, MtmSectionHeaderAdapter r117, MtmServiceSectionAdapter r118) {
                this.f321021a = r100;
                this.f321022b = r101;
                this.f321023c = r102;
                this.f321024d = r103;
                this.f321025e = r104;
                this.f321026f = r105;
                this.f321027g = r106;
                this.f321028h = r110;
                this.f321029i = r111;
                this.f321030j = r112;
                this.f321031k = r113;
                this.f321032l = r114;
                this.f321033m = r115;
                this.f321034n = r116;
                this.f321035o = r117;
                this.f321036p = r118;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public final Object emit(Object r110, Continuation r210) {
                com.larus.business.multitask_management.impl.component.i r100 = (com.larus.business.multitask_management.impl.component.i) r110;
                this.f321021a.A2(r100.f320812a, r100.f320813b, r100.f320814c);
                boolean r101 = !r100.f320812a.isEmpty();
                Ref.BooleanRef r111 = this.f321022b;
                if (r101 == r111.element) goto L6;
                r111.element = r101;
                MultiTaskManagementSheetComponent.m3(this.f321023c, this.f321024d, this.f321025e, this.f321026f, this.f321027g, this.f321028h, this.f321029i, this.f321030j, this.f321031k, r111, this.f321032l, this.f321021a, this.f321033m, this.f321034n, this.f321035o, this.f321036p);
            L6:
                return Unit.INSTANCE;
            }
        }

        public AnonymousClass8(MultiTaskManagementSheetComponent r100, MtmServiceSectionAdapter r101, Ref.BooleanRef r102, ConcatAdapter r103, Ref.BooleanRef r104, boolean r105, MtmSectionHeaderAdapter r110, MtmServiceSectionAdapter r111, Ref.BooleanRef r112, boolean r113, MtmSectionHeaderAdapter r114, OngoingTaskListAdapter r115, MtmSectionHeaderAdapter r116, MtmEmptyStateAdapter r117, Ref.BooleanRef r118, MtmSectionHeaderAdapter r119, MtmServiceSectionAdapter r210, Continuation<? super AnonymousClass8> r211) {
            this.this$0 = r100;
            this.$recentAdapter = r101;
            this.$hasRecent = r102;
            this.$concatAdapter = r103;
            this.$hasPinned = r104;
            this.$hidePinnedServices = r105;
            this.$pinnedHeaderAdapter = r110;
            this.$pinnedAdapter = r111;
            this.$hasOngoing = r112;
            this.$hideOngoingTasks = r113;
            this.$ongoingHeaderAdapter = r114;
            this.$ongoingAdapter = r115;
            this.$recentHeaderAdapter = r116;
            this.$emptyStateAdapter = r117;
            this.$hasDiscover = r118;
            this.$discoverHeaderAdapter = r119;
            this.$discoverAdapter = r210;
            super(2, r211);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r210, Continuation<?> r211) {
            return new AnonymousClass8(this.this$0, this.$recentAdapter, this.$hasRecent, this.$concatAdapter, this.$hasPinned, this.$hidePinnedServices, this.$pinnedHeaderAdapter, this.$pinnedAdapter, this.$hasOngoing, this.$hideOngoingTasks, this.$ongoingHeaderAdapter, this.$ongoingAdapter, this.$recentHeaderAdapter, this.$emptyStateAdapter, this.$hasDiscover, this.$discoverHeaderAdapter, this.$discoverAdapter, r211);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass8) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r210) {
            Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r101 = this.label;
            if (r101 == 0) goto L8;
            if (r101 != 1) goto L6;
            ResultKt.throwOnFailure(r210);
        L16:
            throw new KotlinNothingValueException();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r210);
            MultiTaskManagementSheetComponent r102 = this.this$0;
            int r103 = MultiTaskManagementSheetComponent.f320968z;
            com.larus.business.multitask_management.impl.component.d r104 = r102.h3();
            if (r104 == null) goto L18;
            StateFlowImpl r105 = r104.vl();
            if (r105 == null) goto L18;
            a r110 = new a(this.$recentAdapter, this.$hasRecent, this.$concatAdapter, this.$hasPinned, this.$hidePinnedServices, this.$pinnedHeaderAdapter, this.$pinnedAdapter, this.$hasOngoing, this.$hideOngoingTasks, this.$ongoingHeaderAdapter, this.$ongoingAdapter, this.$recentHeaderAdapter, this.$emptyStateAdapter, this.$hasDiscover, this.$discoverHeaderAdapter, this.$discoverAdapter);
            this.label = 1;
            if (r105.collect(r110, this) != r100) goto L16;
            return r100;
        L18:
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.larus.business.multitask_management.impl.sheet.MultiTaskManagementSheetComponent$onViewCreated$9, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.business.multitask_management.impl.sheet.MultiTaskManagementSheetComponent$onViewCreated$9", f = "MultiTaskManagementSheetComponent.kt", i = {}, l = {477}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass9 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ConcatAdapter $concatAdapter;
        final /* synthetic */ MtmServiceSectionAdapter $discoverAdapter;
        final /* synthetic */ MtmSectionHeaderAdapter $discoverHeaderAdapter;
        final /* synthetic */ MtmEmptyStateAdapter $emptyStateAdapter;
        final /* synthetic */ Ref.BooleanRef $hasDiscover;
        final /* synthetic */ Ref.BooleanRef $hasOngoing;
        final /* synthetic */ Ref.BooleanRef $hasPinned;
        final /* synthetic */ Ref.BooleanRef $hasRecent;
        final /* synthetic */ boolean $hideOngoingTasks;
        final /* synthetic */ boolean $hidePinnedServices;
        final /* synthetic */ OngoingTaskListAdapter $ongoingAdapter;
        final /* synthetic */ MtmSectionHeaderAdapter $ongoingHeaderAdapter;
        final /* synthetic */ MtmServiceSectionAdapter $pinnedAdapter;
        final /* synthetic */ MtmSectionHeaderAdapter $pinnedHeaderAdapter;
        final /* synthetic */ MtmServiceSectionAdapter $recentAdapter;
        final /* synthetic */ MtmSectionHeaderAdapter $recentHeaderAdapter;
        int label;
        final /* synthetic */ MultiTaskManagementSheetComponent this$0;

        /* JADX INFO: renamed from: com.larus.business.multitask_management.impl.sheet.MultiTaskManagementSheetComponent$onViewCreated$9$a */
        public static final class a<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ MtmServiceSectionAdapter f321037a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Ref.BooleanRef f321038b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ ConcatAdapter f321039c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ Ref.BooleanRef f321040d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final /* synthetic */ boolean f321041e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public final /* synthetic */ MtmSectionHeaderAdapter f321042f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public final /* synthetic */ MtmServiceSectionAdapter f321043g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            public final /* synthetic */ Ref.BooleanRef f321044h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            public final /* synthetic */ boolean f321045i;

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            public final /* synthetic */ MtmSectionHeaderAdapter f321046j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            public final /* synthetic */ OngoingTaskListAdapter f321047k;

            /* JADX INFO: renamed from: l, reason: collision with root package name */
            public final /* synthetic */ Ref.BooleanRef f321048l;

            /* JADX INFO: renamed from: m, reason: collision with root package name */
            public final /* synthetic */ MtmSectionHeaderAdapter f321049m;

            /* JADX INFO: renamed from: n, reason: collision with root package name */
            public final /* synthetic */ MtmServiceSectionAdapter f321050n;

            /* JADX INFO: renamed from: o, reason: collision with root package name */
            public final /* synthetic */ MtmEmptyStateAdapter f321051o;

            /* JADX INFO: renamed from: p, reason: collision with root package name */
            public final /* synthetic */ MtmSectionHeaderAdapter f321052p;

            public a(MtmServiceSectionAdapter r100, Ref.BooleanRef r101, ConcatAdapter r102, Ref.BooleanRef r103, boolean r104, MtmSectionHeaderAdapter r105, MtmServiceSectionAdapter r106, Ref.BooleanRef r110, boolean r111, MtmSectionHeaderAdapter r112, OngoingTaskListAdapter r113, Ref.BooleanRef r114, MtmSectionHeaderAdapter r115, MtmServiceSectionAdapter r116, MtmEmptyStateAdapter r117, MtmSectionHeaderAdapter r118) {
                this.f321037a = r100;
                this.f321038b = r101;
                this.f321039c = r102;
                this.f321040d = r103;
                this.f321041e = r104;
                this.f321042f = r105;
                this.f321043g = r106;
                this.f321044h = r110;
                this.f321045i = r111;
                this.f321046j = r112;
                this.f321047k = r113;
                this.f321048l = r114;
                this.f321049m = r115;
                this.f321050n = r116;
                this.f321051o = r117;
                this.f321052p = r118;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public final Object emit(Object r110, Continuation r210) {
                com.larus.business.multitask_management.impl.component.i r100 = (com.larus.business.multitask_management.impl.component.i) r110;
                this.f321037a.A2(r100.f320812a, r100.f320813b, r100.f320814c);
                boolean r101 = !r100.f320812a.isEmpty();
                Ref.BooleanRef r111 = this.f321038b;
                if (r101 == r111.element) goto L6;
                r111.element = r101;
                MultiTaskManagementSheetComponent.m3(this.f321039c, this.f321040d, this.f321041e, this.f321042f, this.f321043g, this.f321044h, this.f321045i, this.f321046j, this.f321047k, this.f321048l, this.f321049m, this.f321050n, this.f321051o, r111, this.f321052p, this.f321037a);
            L6:
                return Unit.INSTANCE;
            }
        }

        public AnonymousClass9(MultiTaskManagementSheetComponent r100, MtmServiceSectionAdapter r101, Ref.BooleanRef r102, ConcatAdapter r103, Ref.BooleanRef r104, boolean r105, MtmSectionHeaderAdapter r110, MtmServiceSectionAdapter r111, Ref.BooleanRef r112, boolean r113, MtmSectionHeaderAdapter r114, OngoingTaskListAdapter r115, Ref.BooleanRef r116, MtmSectionHeaderAdapter r117, MtmServiceSectionAdapter r118, MtmEmptyStateAdapter r119, MtmSectionHeaderAdapter r210, Continuation<? super AnonymousClass9> r211) {
            this.this$0 = r100;
            this.$discoverAdapter = r101;
            this.$hasDiscover = r102;
            this.$concatAdapter = r103;
            this.$hasPinned = r104;
            this.$hidePinnedServices = r105;
            this.$pinnedHeaderAdapter = r110;
            this.$pinnedAdapter = r111;
            this.$hasOngoing = r112;
            this.$hideOngoingTasks = r113;
            this.$ongoingHeaderAdapter = r114;
            this.$ongoingAdapter = r115;
            this.$hasRecent = r116;
            this.$recentHeaderAdapter = r117;
            this.$recentAdapter = r118;
            this.$emptyStateAdapter = r119;
            this.$discoverHeaderAdapter = r210;
            super(2, r211);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r210, Continuation<?> r211) {
            return new AnonymousClass9(this.this$0, this.$discoverAdapter, this.$hasDiscover, this.$concatAdapter, this.$hasPinned, this.$hidePinnedServices, this.$pinnedHeaderAdapter, this.$pinnedAdapter, this.$hasOngoing, this.$hideOngoingTasks, this.$ongoingHeaderAdapter, this.$ongoingAdapter, this.$hasRecent, this.$recentHeaderAdapter, this.$recentAdapter, this.$emptyStateAdapter, this.$discoverHeaderAdapter, r211);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass9) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r210) {
            Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r101 = this.label;
            if (r101 == 0) goto L8;
            if (r101 != 1) goto L6;
            ResultKt.throwOnFailure(r210);
        L16:
            throw new KotlinNothingValueException();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r210);
            MultiTaskManagementSheetComponent r102 = this.this$0;
            int r103 = MultiTaskManagementSheetComponent.f320968z;
            com.larus.business.multitask_management.impl.component.a r104 = (com.larus.business.multitask_management.impl.component.a) r102.f320974r.getValue();
            if (r104 == null) goto L18;
            StateFlowImpl r105 = r104.Ng();
            if (r105 == null) goto L18;
            a r110 = new a(this.$discoverAdapter, this.$hasDiscover, this.$concatAdapter, this.$hasPinned, this.$hidePinnedServices, this.$pinnedHeaderAdapter, this.$pinnedAdapter, this.$hasOngoing, this.$hideOngoingTasks, this.$ongoingHeaderAdapter, this.$ongoingAdapter, this.$hasRecent, this.$recentHeaderAdapter, this.$recentAdapter, this.$emptyStateAdapter, this.$discoverHeaderAdapter);
            this.label = 1;
            if (r105.collect(r110, this) != r100) goto L16;
            return r100;
        L18:
            return Unit.INSTANCE;
        }
    }

    static {
    }

    public MultiTaskManagementSheetComponent() {
        this(0);
    }

    public final com.larus.business.multitask_management.impl.component.c Y2() {
        return (com.larus.business.multitask_management.impl.component.c) this.f320971o.getValue();
    }

    public final com.larus.business.multitask_management.impl.component.d h3() {
        return (com.larus.business.multitask_management.impl.component.d) this.f320973q.getValue();
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void onResume() {
        IMultiTaskHostAbility r100 = (IMultiTaskHostAbility) ServiceManager.get().getService(IMultiTaskHostAbility.class);
        if (r100 == null) goto L5;
        String r101 = r100.getLanguage();
    L6:
        String r102 = this.f320980x;
        if (r102 == null) goto L20;
        if (Intrinsics.areEqual(r102, r101) == true) goto L20;
        FLogger.f375446a.i("multitask-MultiTaskManagementSheetComponent", "refresh by language: " + this.f320980x + " -> " + r101);
        com.larus.business.multitask_management.impl.component.c r103 = Y2();
        if (r103 == null) goto L13;
        r103.J(false);
    L13:
        com.larus.business.multitask_management.impl.component.d r104 = h3();
        if (r104 == null) goto L16;
        r104.J(false);
    L16:
        com.larus.business.multitask_management.impl.component.a r105 = (com.larus.business.multitask_management.impl.component.a) this.f320974r.getValue();
        if (r105 == null) goto L24;
        r105.J(false);
    L24:
        this.f320980x = r101;
        this.f320981y = false;
        return;
    L20:
        if (this.f320981y == false) goto L24;
        com.larus.business.multitask_management.impl.component.d r106 = h3();
        if (r106 == null) goto L24;
        r106.J(false);
        goto L24
    L5:
        r101 = null;
        goto L6
    }

    public /* synthetic */ MultiTaskManagementSheetComponent(int r100) {
        this(true, false);
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentWidget
    public final void onViewCreated(View r910) {
        Intrinsics.checkNotNullParameter(r910, "view");
        View r100 = r910.findViewById(R.id.mtm_sheet_container);
        if ((r100 instanceof RecyclerView) == false) goto L5;
        RecyclerView r101 = (RecyclerView) r100;
    L6:
        if (r101 != null) goto L8;
        return;
    L8:
        final View r102 = r910.findViewById(R.id.mtm_top_mask);
        j3 r103 = z2.f365865a.getMultiTaskEntranceConfig();
        boolean r610 = r103.e();
        boolean r611 = r103.a();
        x0 r104 = new x0();
        Intrinsics.checkNotNullParameter(this, "<this>");
        r104.d(com.larus.ui.arch.component.internal.attach.a.b(this, this));
        this.f320979w = r104;
        com.larus.business.multitask_management.impl.component.j r105 = PinnedServicesFeature.f320778t.a(r910.getContext());
        com.larus.business.multitask_management.impl.component.c r106 = Y2();
        if (r106 == null) goto L16;
        StateFlowImpl r107 = r106.HO();
        if (r107 == null) goto L16;
        com.larus.business.multitask_management.impl.component.i r108 = (com.larus.business.multitask_management.impl.component.i) r107.getValue();
        if (r108 == null) goto L16;
        List<ll9.t> r109 = r108.f320812a;
        if (r109 == null) goto L16;
    L17:
        MtmSectionHeaderAdapter r110 = new MtmSectionHeaderAdapter(r105.f320815a, r105.f320819e);
        final MtmServiceSectionAdapter r111 = new MtmServiceSectionAdapter("multitask-PinnedServicesFeature", r109, r105, true, 6, this.f320970n, new r(this), new x(this));
        this.f320975s = r111;
        Ref.BooleanRef r112 = new Ref.BooleanRef();
        r112.element = !r109.isEmpty();
        com.larus.business.multitask_management.impl.component.j r113 = OngoingTasksFeature.f320776i.a(r910.getContext());
        com.larus.business.multitask_management.impl.component.b r114 = (com.larus.business.multitask_management.impl.component.b) this.f320972p.getValue();
        if (r114 == null) goto L23;
        i1<List<kl9.u>> r115 = r114.jc();
        if (r115 == null) goto L23;
        List<kl9.u> r116 = r115.getValue();
        if (r116 == null) goto L23;
    L24:
        MtmSectionHeaderAdapter r117 = new MtmSectionHeaderAdapter(r113.f320815a, r113.f320819e);
        final OngoingTaskListAdapter r118 = new OngoingTaskListAdapter(r116, false, true, 3, this.f320970n, new y(this));
        r118.f320763h = true;
        r118.f320762g = 1.0f;
        this.f320976t = r118;
        Ref.BooleanRef r119 = new Ref.BooleanRef();
        r119.element = !r116.isEmpty();
        com.larus.business.multitask_management.impl.component.j r120 = RecentServicesFeature.f320792r.a(r910.getContext());
        com.larus.business.multitask_management.impl.component.d r121 = h3();
        if (r121 == null) goto L32;
        StateFlowImpl r122 = r121.vl();
        if (r122 == null) goto L32;
        com.larus.business.multitask_management.impl.component.i r123 = (com.larus.business.multitask_management.impl.component.i) r122.getValue();
        if (r123 == null) goto L32;
        List<ll9.t> r124 = r123.f320812a;
        if (r124 == null) goto L32;
    L33:
        MtmSectionHeaderAdapter r125 = new MtmSectionHeaderAdapter(r120.f320815a, r120.f320819e);
        final MtmServiceSectionAdapter r126 = new MtmServiceSectionAdapter("multitask-RecentServicesFeature", r124, r120, true, 8, this.f320970n, new z(this), new a0(this));
        this.f320977u = r126;
        Ref.BooleanRef r127 = new Ref.BooleanRef();
        r127.element = !r124.isEmpty();
        com.larus.business.multitask_management.impl.component.j r128 = DiscoverServicesFeature.f320744r.a(r910.getContext());
        com.larus.business.multitask_management.impl.component.a r129 = (com.larus.business.multitask_management.impl.component.a) this.f320974r.getValue();
        if (r129 == null) goto L41;
        StateFlowImpl r130 = r129.Ng();
        if (r130 == null) goto L41;
        com.larus.business.multitask_management.impl.component.i r131 = (com.larus.business.multitask_management.impl.component.i) r130.getValue();
        if (r131 == null) goto L41;
        List<ll9.t> r132 = r131.f320812a;
        if (r132 == null) goto L41;
    L42:
        MtmSectionHeaderAdapter r133 = new MtmSectionHeaderAdapter(r128.f320815a, r128.f320819e);
        final RecyclerView r134 = r101;
        final MtmServiceSectionAdapter r135 = new MtmServiceSectionAdapter("multitask-DiscoverServicesFeature", r132, r128, false, Integer.MAX_VALUE, this.f320970n, new b0(this), new c0(this));
        this.f320978v = r135;
        Ref.BooleanRef r136 = new Ref.BooleanRef();
        r136.element = !r132.isEmpty();
        MtmEmptyStateAdapter r137 = new MtmEmptyStateAdapter(getContext().getString(R.string.larus_appEntryManage_bottomSheet_desc_emptyState));
        final ConcatAdapter r138 = new ConcatAdapter(new RecyclerView.Adapter[0]);
        m3(r138, r112, r610, r110, r111, r119, r611, r117, r118, r127, r125, r126, r137, r136, r133, r135);
        GridLayoutManager r139 = new GridLayoutManager(r910.getContext(), 2);
        r139.setSpanSizeLookup(new MtmConcatSpanSizeLookup(r138));
        r134.setLayoutManager(r139);
        r134.setAdapter(r138);
        r134.setItemAnimator(null);
        r134.addOnItemTouchListener(new AnonymousClass1(this));
        r134.addItemDecoration(new MtmSheetItemDecoration(r113.f320821g));
        y6.d(r134, new d0(r138), null, null, new e0(r118, r111, r126, r135), 13);
        r134.addOnScrollListener(new AnonymousClass4(r102, r134));
        r134.post(new f0(r102, r134));
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new AnonymousClass6(this, r111, r112, r138, r610, r110, r119, r611, r117, r118, r127, r125, r126, r137, r136, r133, r135, null), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new AnonymousClass7(this, r118, r119, r138, r112, r610, r110, r111, r611, r117, r127, r125, r126, r137, r136, r133, r135, null), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new AnonymousClass8(this, r126, r127, r138, r112, r610, r110, r111, r119, r611, r117, r118, r125, r137, r136, r133, r135, null), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new AnonymousClass9(this, r135, r136, r138, r112, r610, r110, r111, r119, r611, r117, r118, r127, r125, r126, r137, r133, null), 3, null);
        return;
    L41:
        r132 = CollectionsKt.emptyList();
    L32:
        r124 = CollectionsKt.emptyList();
    L23:
        r116 = CollectionsKt.emptyList();
    L16:
        r109 = CollectionsKt.emptyList();
        goto L17
    L5:
        r101 = null;
        goto L6
    }

    public MultiTaskManagementSheetComponent(boolean r100, boolean r101) {
        this.f320969m = r100;
        this.f320970n = r101;
        this.f320971o = LazyKt.lazy(new b(this));
        this.f320972p = LazyKt.lazy(new c(this));
        this.f320973q = LazyKt.lazy(new d(this));
        this.f320974r = LazyKt.lazy(new e(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v1, types: [com.larus.business.multitask_management.impl.sheet.t] */
    public final void p3(final View r110, Boolean r111, final ll9.t r112, final String r210, final int r211) {
        final x0 r113 = this.f320979w;
        if (r113 != null) goto L5;
        return;
    L5:
        String r100 = String.valueOf(r112.f509774a.getValue());
        String r101 = r112.f509776c;
        String r102 = r112.f509775b;
        Integer r103 = Integer.valueOf(r211 + 1);
        JSONObject r104 = new JSONObject();
        Intrinsics.checkNotNullParameter(r104, "params");
        r104.put("current_page", "multi_task_manage");     // Catch: JSONException -> L20
        r104.put("enter_method", r210);     // Catch: JSONException -> L11
        if (r100 == null) goto L13;
        r104.put("node_type", r100);     // Catch: JSONException -> L11
    L13:
        if (r101 == null) goto L15;
        r104.put("node_title", r101);     // Catch: JSONException -> L11
    L15:
        if (r102 == null) goto L17;
        r104.put("reference_id", r102);     // Catch: JSONException -> L11
    L17:
        if (r103 == null) goto L23;
        r104.put("index", r103.toString());     // Catch: JSONException -> L11
    L23:
        TrackParams r105 = new TrackParams().merge(r104);
        by7.a r106 = new by7.a("long_press_service");
        r106.f21463a.merge(r105);
        r106.b();
        r110.setPressed(false);
        r110.invalidate();
        Bitmap r114 = Bitmap.createBitmap(RangesKt.coerceAtLeast(r110.getWidth(), 1), RangesKt.coerceAtLeast(r110.getHeight(), 1), Bitmap.Config.ARGB_8888);
        r110.draw(new Canvas(r114));
        r113.i(new s(this, r110));
        final MtmQuickAccessScreenMenu r115 = new MtmQuickAccessScreenMenu(r110.getContext());
        if (r111 != null) goto L30;
        com.larus.business.multitask_management.impl.component.c r116 = Y2();
        if (r116 == 0) goto L28;
        Boolean r107 = Boolean.valueOf(r116.w90(r112, new t(r115, r210, r112, r211, this, r113)));
    L29:
        final Boolean r108 = r107;
    L31:
        r113.j(r110, false, r114, new u(r115, r108, r210, r112, r211, this, r113));
        return;
    L28:
        r107 = null;
        goto L29
    L30:
        r108 = r111;
    L11:
        e = e;
    L22:
        FLogger.f375446a.e("multitask-MultiTaskManagementEventHelper", "error in multitask-MultiTaskManagementEventHelper mobLongPressService " + e.getLocalizedMessage());
    L20:
        e = e;
        goto L22
    }

    /* JADX WARN: Type inference failed for: r14v1, types: [com.larus.business.multitask_management.impl.sheet.w, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r14v2, types: [com.larus.business.multitask_management.impl.sheet.v, java.lang.Object] */
    public static final void z3(MtmQuickAccessScreenMenu r100, final String r101, final ll9.t r110, final int r111, final MultiTaskManagementSheetComponent r112, final x0 r113, boolean r114) {
        if (r114 == false) goto L5;
        final ?? r115 = new v(r101, r110, r111, r112, r113);
        r100.getClass();
        Intrinsics.checkNotNullParameter(r115, SendEventContainerMethodParamModel.EventKinds.onClick);
        r100.f321137a.f320856d.setText(r100.getContext().getString(R.string.larus_appEntryManage_bottomSheet_option_unpin));
        r100.f321137a.f320855c.setImageResource(v19.c.b(R.attr.larus_mtm_ic_unpin, null, R.drawable.larus_mtm_ic_unpin));
        e1.d(r100.f321137a.f320854b, new com.larus.business.multitask_management.impl.view.g(r115));
        return;
    L5:
        final ?? r116 = new w(r101, r110, r111, r112, r113);
        r100.getClass();
        Intrinsics.checkNotNullParameter(r116, SendEventContainerMethodParamModel.EventKinds.onClick);
        r100.f321137a.f320856d.setText(r100.getContext().getString(R.string.larus_appEntryManage_bottomSheet_option_pin));
        r100.f321137a.f320855c.setImageResource(v19.c.b(R.attr.larus_mtm_ic_pin, null, R.drawable.larus_mtm_ic_pin));
        e1.d(r100.f321137a.f320854b, new com.larus.business.multitask_management.impl.view.h(r116));
    }

    public static final void m3(ConcatAdapter r100, Ref.BooleanRef r101, boolean r102, MtmSectionHeaderAdapter r110, MtmServiceSectionAdapter r111, Ref.BooleanRef r112, boolean r113, MtmSectionHeaderAdapter r114, OngoingTaskListAdapter r115, Ref.BooleanRef r116, MtmSectionHeaderAdapter r117, MtmServiceSectionAdapter r118, MtmEmptyStateAdapter r119, Ref.BooleanRef r210, MtmSectionHeaderAdapter r211, MtmServiceSectionAdapter r212) {
        List r103 = CollectionsKt.createListBuilder();
        if (r101.element == false) goto L7;
        if (r102 == true) goto L7;
        r103.add(r110);
        r103.add(r111);
    L7:
        if (r112.element == false) goto L11;
        if (r113 == true) goto L11;
        r103.add(r114);
        r103.add(r115);
    L11:
        if (r116.element == false) goto L13;
        r103.add(r117);
        r103.add(r118);
    L13:
        boolean r104 = false;
        if (r101.element == false) goto L17;
        if (r102 == true) goto L17;
        boolean r105 = true;
    L19:
        if (r112.element == false) goto L22;
        if (r113 == true) goto L22;
        r104 = true;
    L22:
        if (r105 == true) goto L28;
        if (r104 == true) goto L28;
        if (r116.element == true) goto L28;
        r103.add(r119);
    L28:
        if (r210.element == false) goto L30;
        r103.add(r211);
        r103.add(r212);
    L30:
        List r106 = CollectionsKt.build(r103);
        Iterator r107 = CollectionsKt.toList(r100.getAdapters()).iterator();
    L32:
        if (r107.hasNext() == false) goto L34;
        r100.removeAdapter((RecyclerView.Adapter) r107.next());
        goto L32
    L34:
        Iterator r108 = r106.iterator();
    L36:
        if (r108.hasNext() == false) goto L38;
        RecyclerView.Adapter<RecyclerView.ViewHolder> r109 = (RecyclerView.Adapter) r108.next();
        com.larus.common_ui.widget.concat_adapter.a r120 = r100.f328556a;
        r120.a(((ArrayList) r120.f328567e).size(), r109);
        goto L36
    L38:
        return;
    L17:
        r105 = false;
        goto L19
    }
}
