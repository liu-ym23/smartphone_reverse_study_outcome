package com.ss.android.lark.contact.customized.department;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.contact.v1.GetAnotherNameFormatRequest;
import com.bytedance.lark.pb.contact.v1.GetAnotherNameFormatResponse;
import com.bytedance.lark.pb.contact.v1.GetDepartmentCombineChatResponse;
import com.bytedance.locallife.dito.data.DitoNode;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.sdk.SdkSender;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.e;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.z0;
import kotlinx.coroutines.j;
import mtb.i;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u001e2\u00020\u0001:\u0002\u001e\u001fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013J\u0006\u0010\u0015\u001a\u00020\u0011J\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u0010\u001b\u001a\u00020\u0011H\u0086@¢\u0006\u0002\u0010\u001cJ\u000e\u0010\u001d\u001a\u00020\u000fH\u0082@¢\u0006\u0002\u0010\u001cR\u001a\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/ss/android/lark/contact/customized/department/DepartmentStructureViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "_stack", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lcom/ss/android/lark/contact/customized/department/DepartmentStructureViewModel$PageState;", "stack", "Lkotlinx/coroutines/flow/StateFlow;", "getStack", "()Lkotlinx/coroutines/flow/StateFlow;", "modifyMutex", "Lkotlinx/coroutines/sync/Mutex;", "nameDisplayRule", "Lcom/bytedance/lark/pb/contact/v1/GetAnotherNameFormatResponse$FormatRule;", "init", "", "departmentId", "", "departmentName", DitoNode.LOAD_MORE, "back", "", "enter", "dept", "Lcom/ss/android/lark/officesdk/contact/api/model/OfficeFeishuDepartmentItem;", "fetchCurrent", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchNameDisplayRule", "Companion", "PageState", "contact-doubao_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DepartmentStructureViewModel extends ViewModel {
    public static final int $stable = 0;
    public static final a Companion = null;
    public static final String TAG = "DepartmentStructureViewModel";
    private final z0<List<b>> _stack;
    private final kotlinx.coroutines.sync.a modifyMutex;
    private GetAnotherNameFormatResponse.FormatRule nameDisplayRule;
    private final i1<List<b>> stack;

    public static final class a {
        public a() {
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final i f419092a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<mtb.c> f419093b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f419094c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f419095d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f419092a, r101.f419092a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f419093b, r101.f419093b) == true) goto L15;
            return false;
        L15:
            if (this.f419094c == r101.f419094c) goto L18;
            return false;
        L18:
            if (this.f419095d == r101.f419095d) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r100 = ((((this.f419092a.hashCode() * 31) + this.f419093b.hashCode()) * 31) + this.f419094c) * 31;
            if (this.f419095d == false) goto L5;
            int r101 = 1231;
        L7:
            return r100 + r101;
        L5:
            r101 = 1237;
            goto L7
        }

        public final String toString() {
            return "PageState(item=" + this.f419092a + ", items=" + this.f419093b + ", loadOffset=" + this.f419094c + ", hasMore=" + this.f419095d + ')';
        }

        public /* synthetic */ b(i r100) {
            this(r100, CollectionsKt.emptyList(), 0, true);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public b(i r100, List<? extends mtb.c> r101, int r102, boolean r103) {
            Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
            Intrinsics.checkNotNullParameter(r101, "items");
            this.f419092a = r100;
            this.f419093b = r101;
            this.f419094c = r102;
            this.f419095d = r103;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.contact.customized.department.DepartmentStructureViewModel$back$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.contact.customized.department.DepartmentStructureViewModel$back$1", f = "DepartmentStructureViewModel.kt", i = {0}, l = {149}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv"}, s = {"L$0"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ DepartmentStructureViewModel this$0;

        public AnonymousClass1(DepartmentStructureViewModel r100, Continuation<? super AnonymousClass1> r101) {
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
            DepartmentStructureViewModel r103 = (DepartmentStructureViewModel) this.L$1;
            kotlinx.coroutines.sync.a r104 = (kotlinx.coroutines.sync.a) this.L$0;
            ResultKt.throwOnFailure(r100);
        L18:
            DepartmentStructureViewModel.access$get_stack$p(r103).setValue(CollectionsKt.dropLast((List) DepartmentStructureViewModel.access$get_stack$p(r103).getValue(), 1));     // Catch: Throwable -> L15
            Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L15
            r104.unlock(null);
            return Unit.INSTANCE;
        L15:
            th = move-exception;
            r104.unlock(null);
            throw th;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r100);
            r104 = DepartmentStructureViewModel.access$getModifyMutex$p(this.this$0);
            DepartmentStructureViewModel r106 = this.this$0;
            this.L$0 = r104;
            this.L$1 = r106;
            this.label = 1;
            if (r104.a(null, this) != r101) goto L11;
            return r101;
        L11:
            r103 = r106;
            goto L18
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.contact.customized.department.DepartmentStructureViewModel$enter$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.contact.customized.department.DepartmentStructureViewModel$enter$1", f = "DepartmentStructureViewModel.kt", i = {0}, l = {149, 65}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv"}, s = {"L$0"})
    public static final class C118221 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ i $dept;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        final /* synthetic */ DepartmentStructureViewModel this$0;

        public C118221(DepartmentStructureViewModel r100, i r101, Continuation<? super C118221> r102) {
            this.this$0 = r100;
            this.$dept = r101;
            super(2, r102);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new C118221(this.this$0, this.$dept, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((C118221) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L10;
            if (r102 == 1) goto L9;
            if (r102 != 2) goto L8;
            ResultKt.throwOnFailure(r100);
        L19:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            i r103 = (i) this.L$2;
            DepartmentStructureViewModel r104 = (DepartmentStructureViewModel) this.L$1;
            kotlinx.coroutines.sync.a r105 = (kotlinx.coroutines.sync.a) this.L$0;
            ResultKt.throwOnFailure(r100);
        L23:
            DepartmentStructureViewModel.access$get_stack$p(r104).setValue(CollectionsKt.plus((Collection) DepartmentStructureViewModel.access$get_stack$p(r104).getValue(), new b(r103)));     // Catch: Throwable -> L20
            Unit r106 = Unit.INSTANCE;     // Catch: Throwable -> L20
            r105.unlock(null);
            DepartmentStructureViewModel r107 = this.this$0;
            this.L$0 = null;
            this.L$1 = null;
            this.L$2 = null;
            this.label = 2;
            if (r107.fetchCurrent(this) != r101) goto L19;
            return r101;
        L20:
            th = move-exception;
            r105.unlock(null);
            throw th;
        L10:
            ResultKt.throwOnFailure(r100);
            r105 = DepartmentStructureViewModel.access$getModifyMutex$p(this.this$0);
            DepartmentStructureViewModel r108 = this.this$0;
            r103 = this.$dept;
            this.L$0 = r105;
            this.L$1 = r108;
            this.L$2 = r103;
            this.label = 1;
            if (r105.a(null, this) != r101) goto L13;
            return r101;
        L13:
            r104 = r108;
            goto L23
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.contact.customized.department.DepartmentStructureViewModel$fetchCurrent$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.contact.customized.department.DepartmentStructureViewModel", f = "DepartmentStructureViewModel.kt", i = {0, 0}, l = {145, 89}, m = "fetchCurrent", n = {"state", "$completion$iv"}, s = {"L$0", "L$1"})
    public static final class C118231 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ DepartmentStructureViewModel this$0;

        public C118231(DepartmentStructureViewModel r100, Continuation<? super C118231> r101) {
            this.this$0 = r100;
            super(r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            this.result = r100;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.fetchCurrent(this);
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.contact.customized.department.DepartmentStructureViewModel$init$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.contact.customized.department.DepartmentStructureViewModel$init$1", f = "DepartmentStructureViewModel.kt", i = {}, l = {37, 38}, m = "invokeSuspend", n = {}, s = {})
    public static final class C118241 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;
        final /* synthetic */ DepartmentStructureViewModel this$0;

        public C118241(DepartmentStructureViewModel r100, Continuation<? super C118241> r101) {
            this.this$0 = r100;
            super(2, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new C118241(this.this$0, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((C118241) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L10;
            if (r102 == 1) goto L9;
            if (r102 != 2) goto L8;
            ResultKt.throwOnFailure(r100);
        L17:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            DepartmentStructureViewModel r103 = (DepartmentStructureViewModel) this.L$0;
            ResultKt.throwOnFailure(r100);
        L13:
            DepartmentStructureViewModel.access$setNameDisplayRule$p(r103, (GetAnotherNameFormatResponse.FormatRule) r100);
            DepartmentStructureViewModel r104 = this.this$0;
            this.L$0 = null;
            this.label = 2;
            if (r104.fetchCurrent(this) != r101) goto L17;
            return r101;
        L10:
            ResultKt.throwOnFailure(r100);
            r103 = this.this$0;
            this.L$0 = r103;
            this.label = 1;
            r100 = DepartmentStructureViewModel.access$fetchNameDisplayRule(r103, this);
            if (r100 != r101) goto L13;
            return r101;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.contact.customized.department.DepartmentStructureViewModel$loadMore$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.contact.customized.department.DepartmentStructureViewModel$loadMore$1", f = "DepartmentStructureViewModel.kt", i = {}, l = {44}, m = "invokeSuspend", n = {}, s = {})
    public static final class C118251 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ DepartmentStructureViewModel this$0;

        public C118251(DepartmentStructureViewModel r100, Continuation<? super C118251> r101) {
            this.this$0 = r100;
            super(2, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new C118251(this.this$0, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((C118251) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
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
            DepartmentStructureViewModel r103 = this.this$0;
            this.label = 1;
            if (r103.fetchCurrent(this) != r101) goto L12;
            return r101;
        }
    }

    static {
        Companion = new a();
        $stable = 8;
    }

    public final boolean back() {
        if (this._stack.getValue().size() > 1) goto L6;
        return false;
    L6:
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(this, null), 3, null);
        return true;
    }

    public DepartmentStructureViewModel() {
        StateFlowImpl r100 = j1.a(CollectionsKt.emptyList());
        this._stack = r100;
        this.stack = e.b(r100);
        this.modifyMutex = kotlinx.coroutines.sync.b.a();
        this.nameDisplayRule = GetAnotherNameFormatResponse.FormatRule.NAME_FIRST;
    }

    public final void loadMore() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C118251(this, null), 3, null);
    }

    public final i1<List<b>> getStack() {
        return this.stack;
    }

    public static final /* synthetic */ kotlinx.coroutines.sync.a access$getModifyMutex$p(DepartmentStructureViewModel r100) {
        return r100.modifyMutex;
    }

    public static final /* synthetic */ GetAnotherNameFormatResponse.FormatRule access$getNameDisplayRule$p(DepartmentStructureViewModel r100) {
        return r100.nameDisplayRule;
    }

    public static final /* synthetic */ z0 access$get_stack$p(DepartmentStructureViewModel r100) {
        return r100._stack;
    }

    private final Object fetchNameDisplayRule(Continuation<? super GetAnotherNameFormatResponse.FormatRule> r100) {
        final j r101 = new j(IntrinsicsKt.intercepted(r100), 1);
        r101.C();
        int r102 = d.f419102a;
        IGetDataCallback<GetAnotherNameFormatResponse.FormatRule> r103 = new DepartmentStructureViewModel$fetchNameDisplayRule$2$1(r101);
        Intrinsics.checkNotNullParameter(r103, "callback");
        SdkSender.asynSendRequestNonWrap(Command.GET_ANOTHER_NAME_FORMAT, new GetAnotherNameFormatRequest.Builder(), r103, com.ss.android.lark.contact.customized.department.b.f419100a);
        Object r104 = r101.B();
        if (r104 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r100);
    L5:
        return r104;
    }

    public final void enter(i r100) {
        Intrinsics.checkNotNullParameter(r100, "dept");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C118221(this, r100, null), 3, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v9, types: [com.ss.android.lark.contact.customized.department.DepartmentStructureViewModel$b] */
    /* JADX WARN: Type inference failed for: r6v1, types: [com.ss.android.lark.contact.customized.department.DepartmentStructureViewModel$fetchCurrent$resp$1$1$1] */
    public final Object fetchCurrent(Continuation<? super Unit> r100) {
        if ((r100 instanceof C118231) == false) goto L7;
        C118231 r101 = (C118231) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L18;
        if (r105 == 1) goto L15;
        if (r105 != 2) goto L14;
        ResultKt.throwOnFailure(r103);
    L37:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        C118231 r106 = (C118231) r101.L$1;
        r105 = (b) r101.L$0;
        ResultKt.throwOnFailure(r103);     // Catch: Throwable -> L29
    L27:
        Object r107 = Result.m9449constructorimpl((GetDepartmentCombineChatResponse) r103);     // Catch: Throwable -> L29
        b r108 = r105;
    L32:
        if (Result.m9456isSuccessimpl(r107) == false) goto L37;
        CoroutineDispatcher r109 = Dispatchers.getIO();
        DepartmentStructureViewModel$fetchCurrent$2$1 r110 = new DepartmentStructureViewModel$fetchCurrent$2$1(r108, (GetDepartmentCombineChatResponse) r107, this, null);
        r101.L$0 = r107;
        r101.L$1 = null;
        r101.label = 2;
        if (BuildersKt.withContext(r109, r110, r101) != r104) goto L37;
        return r104;
    L18:
        ResultKt.throwOnFailure(r103);
        r105 = (b) CollectionsKt.lastOrNull(this._stack.getValue());
        if (r105 == 0) goto L21;
        Result.Companion r111 = Result.Companion;     // Catch: Throwable -> L29
        r101.L$0 = r105;     // Catch: Throwable -> L29
        r101.L$1 = r101;     // Catch: Throwable -> L29
        r101.label = 1;     // Catch: Throwable -> L29
        final j r112 = new j(IntrinsicsKt.intercepted(r101), 1);     // Catch: Throwable -> L29
        r112.C();     // Catch: Throwable -> L29
        int r113 = d.f419102a;     // Catch: Throwable -> L29
        d.a(r105.f419092a.f515685b, r105.f419094c, new DepartmentStructureViewModel$fetchCurrent$resp$1$1$1(r112));     // Catch: Throwable -> L29
        r103 = r112.B();     // Catch: Throwable -> L29
        if (r103 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L25;
        DebugProbesKt.probeCoroutineSuspended(r101);     // Catch: Throwable -> L29
    L25:
        if (r103 != r104) goto L27;
        return r104;
    L21:
        return Unit.INSTANCE;
    L29:
        th = move-exception;
        Result.Companion r114 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        r108 = r105;
    L7:
        r101 = new C118231(this, r100);
        goto L8
    }

    public static final /* synthetic */ Object access$fetchNameDisplayRule(DepartmentStructureViewModel r100, Continuation r101) {
        return r100.fetchNameDisplayRule(r101);
    }

    public static final /* synthetic */ void access$setNameDisplayRule$p(DepartmentStructureViewModel r100, GetAnotherNameFormatResponse.FormatRule r101) {
        r100.nameDisplayRule = r101;
    }

    public final void init(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "departmentId");
        Intrinsics.checkNotNullParameter(r101, "departmentName");
        if (this._stack.getValue().isEmpty() == false) goto L5;
        this._stack.setValue(CollectionsKt.listOf(new b(new i(r101, r100))));
    L5:
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C118241(this, null), 3, null);
    }
}
