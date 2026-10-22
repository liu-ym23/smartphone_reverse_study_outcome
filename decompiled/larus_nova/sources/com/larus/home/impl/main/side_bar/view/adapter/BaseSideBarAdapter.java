package com.larus.home.impl.main.side_bar.view.adapter;

import android.R;
import android.os.Parcelable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.home.impl.main.side_bar.data.SideBarItemType;
import com.larus.home.impl.main.side_bar.data.d1;
import com.larus.im.bean.bot.BotModel;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import org.json.JSONObject;
import tx9.m2;
import v19.e6;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0010 \n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\t\b&\u0018\u0000 J2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001JB3\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ(\u0010%\u001a\u00020&2\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010'2\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010'H\u0016J(\u0010(\u001a\u00020&2\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010'2\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010'H\u0004J(\u0010)\u001a\u00020&2\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010'2\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010'H\u0002J\u000e\u0010%\u001a\u00020&2\u0006\u0010*\u001a\u00020 J\u0012\u0010+\u001a\u00020&2\b\b\u0002\u0010,\u001a\u00020 H\u0002J\b\u0010-\u001a\u00020&H\u0002J\u0006\u0010.\u001a\u00020&J\b\u0010/\u001a\u00020 H\u0014J\b\u00100\u001a\u00020&H\u0014J\u0016\u00101\u001a\u00020&2\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u00020'H\u0014J\b\u00103\u001a\u00020&H\u0014J\u0012\u00104\u001a\u0004\u0018\u00010\u00022\u0006\u00105\u001a\u00020\tH\u0014J\u0017\u00106\u001a\u0004\u0018\u00010\u00022\u0006\u00105\u001a\u00020\tH\u0000¢\u0006\u0002\b7J\u0016\u00108\u001a\u00020&2\f\u00109\u001a\b\u0012\u0004\u0012\u00020\u00020\u0017H\u0002J!\u0010:\u001a\u00020&2\u0006\u00105\u001a\u00020\t2\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0002\u0010<J\u0012\u0010=\u001a\u0004\u0018\u00010\u00152\u0006\u0010>\u001a\u00020\u0002H\u0016J&\u0010?\u001a\u00020&2\u0006\u00105\u001a\u00020\t2\b\u0010>\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\u0015H\u0016J\u0012\u0010A\u001a\u0004\u0018\u00010B2\u0006\u0010>\u001a\u00020\u0002H\u0016J\u0012\u0010C\u001a\u0004\u0018\u00010\u00152\u0006\u0010>\u001a\u00020\u0002H\u0016J\u0012\u0010D\u001a\u0004\u0018\u00010\u00152\u0006\u0010>\u001a\u00020\u0002H\u0016J\u0012\u0010E\u001a\u0004\u0018\u00010\u00152\u0006\u0010>\u001a\u00020\u0002H\u0016J\u0010\u0010F\u001a\u00020\t2\u0006\u0010G\u001a\u00020\tH\u0004J\u0018\u0010H\u001a\u00020\u00152\u0006\u0010G\u001a\u00020\t2\u0006\u0010>\u001a\u00020\u0002H\u0002J\u000e\u0010I\u001a\u00020\t2\u0006\u00105\u001a\u00020\tR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R!\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0018\u0010\u0019R!\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u001b\u001a\u0004\b\u001d\u0010\u0019R\u001e\u0010!\u001a\u00020 2\u0006\u0010\u001f\u001a\u00020 @BX\u0084\u000e¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0014\u0010#\u001a\b\u0012\u0004\u0012\u00020\t0$X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006K"}, d2 = {"Lcom/larus/home/impl/main/side_bar/view/adapter/BaseSideBarAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/larus/home/impl/main/side_bar/data/SideBarItemConfig;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "contentBridge", "Lcom/larus/home/impl/main/side_bar/view/ISideBarContentBridge;", "sideBarTabInfo", "Lcom/larus/home/impl/main/side_bar/data/SideBarTabInfo;", "type", "", "diffCallback", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "<init>", "(Lcom/larus/home/impl/main/side_bar/view/ISideBarContentBridge;Lcom/larus/home/impl/main/side_bar/data/SideBarTabInfo;ILandroidx/recyclerview/widget/DiffUtil$ItemCallback;)V", "getContentBridge", "()Lcom/larus/home/impl/main/side_bar/view/ISideBarContentBridge;", "getSideBarTabInfo", "()Lcom/larus/home/impl/main/side_bar/data/SideBarTabInfo;", "getType", "()I", "TAG", "", "foldConfigList", "", "getFoldConfigList", "()Ljava/util/List;", "foldConfigList$delegate", "Lkotlin/Lazy;", "unfoldConfigList", "getUnfoldConfigList", "unfoldConfigList$delegate", "value", "", "isFoldMode", "()Z", "notifyChannel", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "notifyConfigList", "", "", "notifyConfigListImmediately", "updateConfigLists", "isFoldConfigList", "tryEmitAndNotifyConfigList", "forceNotify", "notifyConfigListInternal", "refreshPendingDeleteState", "shouldDeferSourceListCommit", "onSourceListWillChange", "onPresentedConfigListChanged", "configList", "onSourceListCommitted", "getItemConfig", "position", "getPresentedItemConfig", "getPresentedItemConfig$impl_mainlandRelease", "submitListAndKeepPosition", "newList", "onItemShowMob", "totalPosition", "(ILjava/lang/Integer;)V", "getTabName", "config", "onItemClickMob", "clickType", "getItemMobInfo", "Lcom/larus/home/impl/main/side_bar/view/adapter/ItemMobInfo;", "getClickType", "getCellName", "getClickFrom", "getCellPosition", "adapterPosition", "getShowFrom", "inAdapterPosition", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class BaseSideBarAdapter extends ListAdapter<com.larus.home.impl.main.side_bar.data.j0, RecyclerView.ViewHolder> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f344862i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.larus.home.impl.main.side_bar.view.b f344863a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d1 f344864b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f344865c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f344866d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f344867e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f344868f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f344869g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final MutableSharedFlow<Integer> f344870h;

    /* JADX INFO: renamed from: com.larus.home.impl.main.side_bar.view.adapter.BaseSideBarAdapter$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.home.impl.main.side_bar.view.adapter.BaseSideBarAdapter$1", f = "BaseSideBarAdapter.kt", i = {}, l = {56}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ BaseSideBarAdapter this$0;

        /* JADX INFO: renamed from: com.larus.home.impl.main.side_bar.view.adapter.BaseSideBarAdapter$1$a */
        public static final class a<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ BaseSideBarAdapter f344871a;

            public a(BaseSideBarAdapter r100) {
                this.f344871a = r100;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public final Object emit(Object r100, Continuation r101) {
                ((Number) r100).intValue();
                FLogger.f375446a.i(this.f344871a.f344866d, "tryEmitAndNotify finally call");
                this.f344871a.H2();
                return Unit.INSTANCE;
            }
        }

        public AnonymousClass1(BaseSideBarAdapter r100, Continuation<? super AnonymousClass1> r101) {
            this.this$0 = r100;
            super(2, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass1(this.this$0, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L8;
            if (r102 != 1) goto L7;
            ResultKt.throwOnFailure(r100);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r100);
            Flow r103 = kotlinx.coroutines.flow.e.m(this.this$0.f344870h, 300);
            a r104 = new a(this.this$0);
            this.label = 1;
            if (r103.collect(r104, this) != r101) goto L12;
            return r101;
        }
    }

    public static final class a {
    }

    static {
    }

    public String A2(com.larus.home.impl.main.side_bar.data.j0 r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        return null;
    }

    public e C2(com.larus.home.impl.main.side_bar.data.j0 r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        return null;
    }

    public void K2(List<com.larus.home.impl.main.side_bar.data.j0> r100) {
        Intrinsics.checkNotNullParameter(r100, "configList");
    }

    public void L2() {
    }

    public boolean M2() {
        return false;
    }

    public String y2(com.larus.home.impl.main.side_bar.data.j0 r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        return null;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void H2() {
        FLogger.f375446a.i(this.f344866d, "notifyConfigListInternal isFoldMode=" + this.f344869g + " foldSize=" + ((List) this.f344867e.getValue()).size() + " unfoldSize=" + ((List) this.f344868f.getValue()).size() + " adapter = " + getClass().getSimpleName());
        if (M2() == false) goto L6;
        return;
    L6:
        if (this.f344869g == false) goto L8;
        List r100 = (List) this.f344867e.getValue();
    L9:
        ArrayList r101 = new ArrayList();
        Iterator r102 = r100.iterator();
    L10:
        final Parcelable r103 = null;
        String r104 = null;
        r104 = null;
        if (r102.hasNext() == false) goto L29;
        Object r105 = r102.next();
        wh8.a r106 = ((com.larus.home.impl.main.side_bar.data.j0) r105).f344507b;
        if (r106 == null) goto L17;
        wc9.e r107 = r106.f559708a;
        if (r107 == null) goto L17;
        r104 = r107.f559198a;
    L17:
        boolean r108 = false;
        if (r104 == null) goto L27;
        com.larus.home.impl.main.side_bar.view.b r109 = this.f344863a;
        if (r109 != null) goto L22;
    L24:
        boolean r110 = false;
    L25:
        if (r110 == false) goto L27;
        r108 = true;
        goto L27
    L22:
        if (r109.dw(r104) != true) goto L24;
        r110 = true;
    L27:
        if (r108 == true) goto L10;
        r101.add(r105);
        goto L10
    L29:
        K2(r101);
        List r111 = CollectionsKt.toMutableList(r101);
        com.larus.home.impl.main.side_bar.view.b r112 = this.f344863a;
        if (r112 == null) goto L34;
        RecyclerView r113 = r112.W50();
        if (r113 == null) goto L34;
        final RecyclerView.LayoutManager r114 = r113.getLayoutManager();
    L35:
        if (r114 == null) goto L37;
        r103 = r114.onSaveInstanceState();
    L37:
        submitList(r111, new com.larus.home.impl.main.side_bar.view.adapter.a(r114, r103, this));
        return;
    L34:
        r114 = null;
        goto L35
    L8:
        r100 = (List) this.f344868f.getValue();
        goto L9
    }

    public final int getType() {
        return this.f344865c;
    }

    public com.larus.home.impl.main.side_bar.data.j0 B2(int r100) {
        return (com.larus.home.impl.main.side_bar.data.j0) CollectionsKt.getOrNull(getCurrentList(), r100);
    }

    public String E2(com.larus.home.impl.main.side_bar.data.j0 r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        d1 r101 = this.f344864b;
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.f344490a;
    }

    public final void G2(boolean r100) {
        FLogger.f375446a.i(this.f344866d, "notifyConfigList isFoldMode=" + this.f344869g + " isFoldConfigList=" + r100);
        if (this.f344869g != r100) goto L5;
        return;
    L5:
        this.f344869g = r100;
        O2(true);
    }

    public final void O2(boolean r100) {
        FLogger.f375446a.i(this.f344866d, "tryEmitAndNotifyConfigList forceNotify=" + r100);
        if (r100 == false) goto L5;
        H2();
        return;
    L5:
        com.larus.home.impl.main.side_bar.view.b r101 = this.f344863a;
        if (r101 == null) goto L14;
        Fragment r102 = r101.getFragment();
        if (r102 == null) goto L15;
        LifecycleCoroutineScope r103 = LifecycleOwnerKt.getLifecycleScope(r102);
        if (r103 == null) goto L16;
        BuildersKt.launch$default(r103, null, null, new BaseSideBarAdapter$tryEmitAndNotifyConfigList$1(this, null), 3, null);
        return;
    L16:
        return;
    L15:
        return;
    }

    public final int z2(int r100) {
        if (getCurrentList().isEmpty() == true) goto L14;
        com.larus.home.impl.main.side_bar.data.j0 r101 = B2(0);
        if (r101 == null) goto L8;
        SideBarItemType r102 = r101.f344506a;
    L10:
        if (r102 == SideBarItemType.DIVIDER) goto L12;
        return r100;
    L12:
        return r100 - 1;
    L8:
        r102 = null;
        goto L10
    L14:
        return r100;
    }

    public final String D2(int r100, com.larus.home.impl.main.side_bar.data.j0 r101) {
        SideBarItemType r102 = r101.f344506a;
        if (r102 != SideBarItemType.CONVERSATION) goto L5;
    L8:
        d1 r103 = this.f344864b;
        if (r103 == null) goto L11;
        Integer r104 = r103.f344492c;
    L12:
        if (r104 != null) goto L15;
        return "direct_show";
    L15:
        if ((z2(r100) + 1) <= this.f344864b.f344492c.intValue()) goto L18;
        return "click_check_all";
    L18:
        return "direct_show";
    L11:
        r104 = null;
        goto L12
    L5:
        if (r102 == SideBarItemType.COMPONENT) goto L8;
        return "direct_show";
    }

    public void F2(List<com.larus.home.impl.main.side_bar.data.j0> r100, List<com.larus.home.impl.main.side_bar.data.j0> r101) {
        if (((List) this.f344867e.getValue()).size() == 0) goto L5;
    L7:
        boolean r102 = false;
    L8:
        FLogger r103 = FLogger.f375446a;
        String r104 = this.f344866d;
        StringBuilder r105 = new StringBuilder("notifyConfigList two list isLastListEmpty=");
        r105.append(r102);
        r105.append(" lastFoldSize=");
        r105.append(((List) this.f344867e.getValue()).size());
        r105.append(" lastUnfoldSize=");
        r105.append(((List) this.f344868f.getValue()).size());
        r105.append(" updateFoldSize=");
        Integer r106 = null;
        if (r100 == null) goto L11;
        Integer r107 = Integer.valueOf(r100.size());
    L12:
        r105.append(r107);
        r105.append(" updateUnfoldSize=");
        if (r101 == null) goto L15;
        r106 = Integer.valueOf(r101.size());
    L15:
        r105.append(r106);
        r103.i(r104, r105.toString());
        P2(r100, r101);
        O2(r102);
        return;
    L11:
        r107 = null;
        goto L12
    L5:
        if (((List) this.f344868f.getValue()).size() != 0) goto L7;
        r102 = true;
        goto L8
    }

    public void J2(int r310, Integer r311) {
        com.larus.home.impl.main.side_bar.data.j0 r100 = B2(r310);
        if (r100 != null) goto L5;
        return;
    L5:
        int r101 = z2(r310);
        SideBarItemType r102 = r100.f344506a;
        if (r102 != SideBarItemType.CONVERSATION) goto L8;
    L13:
        FLogger r103 = FLogger.f375446a;
        String r104 = this.f344866d;
        StringBuilder r105 = new StringBuilder("onItemShowMob show name=");
        wh8.a r106 = r100.f344507b;
        String r107 = null;
        if (r106 == null) goto L19;
        wc9.e r108 = r106.f559708a;
        if (r108 == null) goto L19;
        String r109 = r108.f559200c;
        if (r109 == null) goto L19;
    L25:
        r105.append(r109);
        r105.append(" botId=");
        wh8.a r110 = r100.f344507b;
        if (r110 == null) goto L30;
        BotModel r111 = r110.f559709b;
        if (r111 == null) goto L30;
        String r112 = r111.getBotId();
    L31:
        r105.append(r112);
        r105.append(" tabPosition=");
        d1 r113 = this.f344864b;
        if (r113 == null) goto L34;
        Integer r114 = r113.f344491b;
    L35:
        r105.append(r114);
        r105.append(" tabName=");
        d1 r115 = this.f344864b;
        if (r115 == null) goto L38;
        String r116 = r115.f344490a;
    L39:
        r105.append(r116);
        r105.append(" adapterPosition=");
        r105.append(r310);
        r105.append(" cellPosition=");
        r105.append(r101);
        r105.append(" itemType=");
        r105.append(r100.f344506a);
        r103.d(r104, r105.toString());
        e r117 = C2(r100);
        com.larus.home.impl.main.side_bar.view.b r118 = this.f344863a;
        if (r118 == null) goto L42;
        String r119 = r118.getCurrentPage();
    L43:
        com.larus.home.impl.main.side_bar.view.b r120 = this.f344863a;
        if (r120 == null) goto L46;
        String r121 = r120.b();
    L47:
        com.larus.home.impl.main.side_bar.view.b r122 = this.f344863a;
        if (r122 == null) goto L50;
        String r123 = r122.getEnterMethod();
    L51:
        String r124 = D2(r310, r100);
        String r125 = E2(r100);
        d1 r126 = this.f344864b;
        if (r126 == null) goto L54;
        Integer r127 = r126.f344491b;
    L55:
        String r128 = y2(r100);
        Integer r129 = Integer.valueOf(r101);
        if (r117 == null) goto L59;
        String r130 = r117.f344973b;
        if (r130 == null) goto L59;
    L60:
        String r131 = r130;
        if (r117 == null) goto L63;
        String r132 = r117.f344975d;
    L64:
        if (r117 == null) goto L66;
        String r133 = r117.f344974c;
    L67:
        if (r117 == null) goto L69;
        Integer r210 = r117.f344977f;
    L70:
        if (r117 == null) goto L72;
        r107 = r117.f344976e;
    L72:
        String r211 = r107;
        JSONObject r134 = new JSONObject();
        if (r311 == null) goto L75;
        r134.put("total_position", r311.intValue());
    L75:
        Unit r135 = Unit.INSTANCE;
        m2.a(r119, r121, r123, r124, r125, r127, r128, r129, r131, r132, r133, r210, r211, null, null, null, false, false, r134, 2851584);
        return;
    L69:
        r210 = null;
        goto L70
    L66:
        r133 = null;
        goto L67
    L63:
        r132 = null;
    L59:
        r130 = "";
        goto L60
    L54:
        r127 = null;
        goto L55
    L50:
        r123 = null;
        goto L51
    L46:
        r121 = null;
        goto L47
    L42:
        r119 = null;
        goto L43
    L38:
        r116 = null;
        goto L39
    L34:
        r114 = null;
    L30:
        r112 = null;
    L19:
        com.larus.home.impl.main.side_bar.data.p r136 = r100.f344509d;
        if (r136 == null) goto L22;
        r109 = r136.m();
    L23:
        if (r109 != null) goto L25;
        r109 = r100.f344511f;
        goto L25
    L22:
        r109 = null;
        goto L23
    L8:
        if (r102 == SideBarItemType.COMPONENT) goto L13;
        if (r102 == SideBarItemType.SHOW_ALL) goto L13;
        if (r102 == SideBarItemType.CASE_MORE) goto L13;
    }

    public final void P2(List<com.larus.home.impl.main.side_bar.data.j0> r100, List<com.larus.home.impl.main.side_bar.data.j0> r101) {
        List r102 = (List) this.f344867e.getValue();
        r102.clear();
        if (r100 == null) goto L5;
        List<com.larus.home.impl.main.side_bar.data.j0> r103 = r100;
    L6:
        r102.addAll(r103);
        List r104 = (List) this.f344868f.getValue();
        r104.clear();
        if (r101 == null) goto L9;
        List<com.larus.home.impl.main.side_bar.data.j0> r105 = r101;
    L10:
        r104.addAll(r105);
        return;
    L9:
        r105 = new ArrayList();
        goto L10
    L5:
        r103 = new ArrayList();
        goto L6
    }

    public /* synthetic */ BaseSideBarAdapter(com.larus.home.impl.main.side_bar.view.b r100, d1 r101, int r102) {
        this(r100, r101, r102, new l0());
    }

    public void I2(int r310, com.larus.home.impl.main.side_bar.data.j0 r311, String r312) {
        if (r311 != null) goto L5;
        return;
    L5:
        e r100 = C2(r311);
        int r101 = z2(r310);
        String r110 = y2(r311);
        if (Intrinsics.areEqual(r110, "scan_node_task") == false) goto L8;
        String r210 = e6.f552469a.b();
    L9:
        FLogger r102 = FLogger.f375446a;
        String r103 = this.f344866d;
        StringBuilder r104 = new StringBuilder("onItemClickMob click name=");
        wh8.a r105 = r311.f344507b;
        if (r105 == null) goto L15;
        wc9.e r106 = r105.f559708a;
        if (r106 == null) goto L15;
        String r107 = r106.f559200c;
        if (r107 == null) goto L15;
    L21:
        r104.append(r107);
        r104.append(" botId=");
        wh8.a r108 = r311.f344507b;
        if (r108 == null) goto L26;
        BotModel r109 = r108.f559709b;
        if (r109 == null) goto L26;
        String r111 = r109.getBotId();
    L27:
        r104.append(r111);
        r104.append(" tabPosition=");
        d1 r112 = this.f344864b;
        if (r112 == null) goto L30;
        Integer r113 = r112.f344491b;
    L31:
        r104.append(r113);
        r104.append(" tabName=");
        d1 r114 = this.f344864b;
        if (r114 == null) goto L34;
        String r115 = r114.f344490a;
    L35:
        r104.append(r115);
        r104.append(" adapterPosition=");
        r104.append(r310);
        r104.append(" cellPosition=");
        r104.append(r101);
        r104.append(" itemType=");
        r104.append(r311.f344506a);
        r102.d(r103, r104.toString());
        Intrinsics.checkNotNullParameter(r311, "config");
        if (Intrinsics.areEqual(y2(r311), "doubao_drive_node_task") == false) goto L38;
        String r116 = "ai_space_list";
    L39:
        com.larus.home.impl.main.side_bar.view.b r117 = this.f344863a;
        if (r117 == null) goto L42;
        String r118 = r117.getCurrentPage();
    L43:
        com.larus.home.impl.main.side_bar.view.b r119 = this.f344863a;
        if (r119 == null) goto L46;
        String r120 = r119.b();
    L47:
        com.larus.home.impl.main.side_bar.view.b r121 = this.f344863a;
        if (r121 == null) goto L50;
        String r122 = r121.getEnterMethod();
    L51:
        String r123 = D2(r310, r311);
        String r124 = E2(r311);
        d1 r125 = this.f344864b;
        if (r125 == null) goto L54;
        Integer r126 = r125.f344491b;
    L55:
        if (r312 != null) goto L57;
        String r127 = A2(r311);
    L58:
        int r128 = z2(r310);
        if (r100 == null) goto L62;
        String r129 = r100.f344973b;
        if (r129 == null) goto L62;
    L63:
        String r130 = r129;
        if (r100 == null) goto L66;
        String r131 = r100.f344975d;
    L67:
        if (r100 == null) goto L69;
        String r132 = r100.f344974c;
    L70:
        if (r100 == null) goto L72;
        Integer r133 = r100.f344977f;
    L73:
        if (r100 == null) goto L75;
        String r134 = r100.f344976e;
    L76:
        m2.b(r116, null, r118, r120, r122, r123, r124, r126, r110, Integer.valueOf(r128), r127, r130, r131, r132, r133, r134, null, null, null, null, false, false, r210, null, null, R.dimen.config_motionStandardDefaultSpatialDamping);
        return;
    L75:
        r134 = null;
        goto L76
    L72:
        r133 = null;
        goto L73
    L69:
        r132 = null;
        goto L70
    L66:
        r131 = null;
    L62:
        r129 = "";
        goto L63
    L57:
        r127 = r312;
        goto L58
    L54:
        r126 = null;
        goto L55
    L50:
        r122 = null;
        goto L51
    L46:
        r120 = null;
        goto L47
    L42:
        r118 = null;
        goto L43
    L38:
        r116 = null;
        goto L39
    L34:
        r115 = null;
        goto L35
    L30:
        r113 = null;
    L26:
        r111 = null;
    L15:
        com.larus.home.impl.main.side_bar.data.p r135 = r311.f344509d;
        if (r135 == null) goto L18;
        r107 = r135.m();
    L19:
        if (r107 != null) goto L21;
        r107 = r311.f344511f;
        goto L21
    L18:
        r107 = null;
        goto L19
    L8:
        r210 = null;
        goto L9
    }

    public BaseSideBarAdapter(com.larus.home.impl.main.side_bar.view.b r100, d1 r101, int r110, DiffUtil.ItemCallback<com.larus.home.impl.main.side_bar.data.j0> r111) {
        Intrinsics.checkNotNullParameter(r111, "diffCallback");
        super(r111);
        this.f344863a = r100;
        this.f344864b = r101;
        this.f344865c = r110;
        this.f344866d = "BaseSideBarAdapter-" + r110;
        this.f344867e = LazyKt.lazy(new b());
        this.f344868f = LazyKt.lazy(new c());
        this.f344869g = true;
        this.f344870h = SharedFlowKt.MutableSharedFlow$default(0, 1, null, 5, null);
        if (r100 == null) goto L10;
        Fragment r102 = r100.getFragment();
        if (r102 == null) goto L11;
        LifecycleCoroutineScope r103 = LifecycleOwnerKt.getLifecycleScope(r102);
        if (r103 == null) goto L12;
        BuildersKt.launch$default(r103, null, null, new AnonymousClass1(this, null), 3, null);
        return;
    L12:
        return;
    L11:
        return;
    }
}
