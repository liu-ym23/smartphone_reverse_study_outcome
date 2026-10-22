package com.larus.showcase.service;

import androidx.fragment.app.Fragment;
import com.larus.im.bean.message.Message;
import com.larus.platform.api.j1;
import com.larus.platform.model.showcase.Case;
import com.larus.platform.service.z2;
import com.larus.showcase.api.ICaseService;
import com.larus.showcase.view.CaseListFragment;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.GlobalScope;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J \u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0016J(\u0010\r\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0096@¢\u0006\u0002\u0010\u000eJ&\u0010\u000f\u001a\u00020\u00102\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\fH\u0096@¢\u0006\u0002\u0010\u0012J\u0018\u0010\u0013\u001a\u00020\f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0096@¢\u0006\u0002\u0010\u0014J\u0018\u0010\u0015\u001a\u00020\f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0096@¢\u0006\u0002\u0010\u0014J\u0018\u0010\u0016\u001a\u00020\u00102\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0096@¢\u0006\u0002\u0010\u0014J\u0010\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u000e\u0010\u001b\u001a\u00020\u0010H\u0096@¢\u0006\u0002\u0010\u001cJ\b\u0010\u001d\u001a\u00020\u0010H\u0016J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\u000e\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00050\tH\u0016J\b\u0010!\u001a\u00020\fH\u0016J\b\u0010\"\u001a\u00020\fH\u0016J\b\u0010#\u001a\u00020\fH\u0016¨\u0006$"}, d2 = {"Lcom/larus/showcase/service/CaseServiceImpl;", "Lcom/larus/showcase/api/ICaseService;", "<init>", "()V", "getCaseModel", "Lcom/larus/platform/model/showcase/Case;", "caseId", "", "getCaseMessageListByCache", "", "Lcom/larus/im/bean/message/Message;", "isFromRecommend", "", "getCaseMessageListByRemote", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "preFetchMessageListByRemote", "", "caseIds", "(Ljava/util/List;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clickCase", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteCase", "updateCreateTime", "registerRecommendCaseChangeListener", "listener", "Lcom/larus/platform/api/IRecommendCaseChangeListener;", "unregisterRecommendCaseChangeListener", "fetchRecommendCaseList", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "initForConversationCase", "createCaseListFragment", "Landroidx/fragment/app/Fragment;", "getRecommendCaseList", "enableCaseFunction", "enablePinGreyBackground", "enableCheckbox", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CaseServiceImpl implements ICaseService {
    public CaseServiceImpl() {
    }

    @Override // com.larus.showcase.api.ICaseService
    public final Fragment e() {
        return new CaseListFragment();
    }

    @Override // com.larus.showcase.api.ICaseService
    public final boolean f() {
        int r100 = uw9.a.f551950a;
        if (z2.f365865a.getSidebarCaseConfig().f486739c != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.larus.showcase.api.ICaseService
    public final List<Case> i() {
        CaseRepo r100 = CaseRepo.f369269a;
        return CaseRepo.f369274f;
    }

    @Override // com.larus.showcase.api.ICaseService
    public final boolean k() {
        int r100 = uw9.a.f551950a;
        return z2.f365865a.getSidebarCaseConfig().f486737a;
    }

    @Override // com.larus.showcase.api.ICaseService
    public final boolean m() {
        int r100 = uw9.a.f551950a;
        if (z2.f365865a.getSidebarCaseConfig().f486740d != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.larus.showcase.api.ICaseService
    public final void n() {
        CaseRepo r100 = CaseRepo.f369269a;
        if (ICaseService.f369257a.k() == false) goto L7;
        BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new CaseRepo$initForConversationCase$1(null), 3, null);
        return;
    }

    @Override // com.larus.showcase.api.ICaseService
    public final Object c(Continuation<? super Unit> r100) {
        Object r101 = CaseRepo.f369269a.c(r100);
        if (r101 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r101;
    L6:
        return Unit.INSTANCE;
    }

    @Override // com.larus.showcase.api.ICaseService
    public final void g(j1 r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        CaseRepo r101 = CaseRepo.f369269a;
        Intrinsics.checkNotNullParameter(r100, "listener");
        CopyOnWriteArrayList<j1> r102 = CaseRepo.f369276h;
        if (r102.contains(r100) == false) goto L6;
        r102.remove(r100);
        return;
    }

    @Override // com.larus.showcase.api.ICaseService
    public final Case l(String r100) {
        Intrinsics.checkNotNullParameter(r100, "caseId");
        CaseRepo r101 = CaseRepo.f369269a;
        return CaseRepo.g(r100, false, false);
    }

    @Override // com.larus.showcase.api.ICaseService
    public final void o(j1 r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        CaseRepo r101 = CaseRepo.f369269a;
        Intrinsics.checkNotNullParameter(r100, "listener");
        CopyOnWriteArrayList<j1> r102 = CaseRepo.f369276h;
        if (r102.contains(r100) == true) goto L8;
        r102.add(r100);
        CopyOnWriteArrayList<Case> r103 = CaseRepo.f369274f;
        if ((!r103.isEmpty()) == false) goto L9;
        r100.av(r103);
        return;
    L9:
        return;
    }

    @Override // com.larus.showcase.api.ICaseService
    public final List<Message> a(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "caseId");
        CaseRepo r102 = CaseRepo.f369269a;
        return CaseRepo.e(r100);
    }

    @Override // com.larus.showcase.api.ICaseService
    public final Object d(String r100, Continuation<? super Unit> r101) {
        if (r100 != null) goto L4;
    L7:
        boolean r102 = true;
    L8:
        if (r102 == true) goto L10;
        Object r103 = CaseRepo.f369269a.j(r100, r101);
        if (r103 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L15;
        return r103;
    L15:
        return Unit.INSTANCE;
    L10:
        return Unit.INSTANCE;
    L4:
        if (r100.length() == 0) goto L7;
        r102 = false;
        goto L8
    }

    @Override // com.larus.showcase.api.ICaseService
    public final Object h(List r100, Continuation r101) {
        if ((r101 instanceof CaseServiceImpl$preFetchMessageListByRemote$1) == false) goto L7;
        CaseServiceImpl$preFetchMessageListByRemote$1 r102 = (CaseServiceImpl$preFetchMessageListByRemote$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        boolean r107 = r102.Z$0;
        Iterator r108 = (Iterator) r102.L$0;
        ResultKt.throwOnFailure(r104);
    L18:
        if (r108.hasNext() == false) goto L23;
        String r109 = (String) r108.next();
        CaseRepo r110 = CaseRepo.f369269a;
        r102.L$0 = r108;
        r102.Z$0 = r107;
        r102.label = 1;
        if (r110.i(r109, r107, r102) != r105) goto L18;
        return r105;
    L23:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        if (r100 == null) goto L23;
        r108 = r100.iterator();
        r107 = false;
    L7:
        r102 = new CaseServiceImpl$preFetchMessageListByRemote$1(this, r101);
        goto L8
    }

    @Override // com.larus.showcase.api.ICaseService
    public final Object j(String r100, Continuation<? super Boolean> r101) {
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L13;
        return Boxing.boxBoolean(false);
    L13:
        return CaseRepo.f369269a.b(r100, r101);
    L5:
        if (r100.length() == 0) goto L8;
        r102 = false;
        goto L9
    }

    @Override // com.larus.showcase.api.ICaseService
    public final Object p(String r100, Continuation<? super Boolean> r101) {
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L13;
        return Boxing.boxBoolean(false);
    L13:
        return CaseRepo.f369269a.a(r100, r101);
    L5:
        if (r100.length() == 0) goto L8;
        r102 = false;
        goto L9
    }

    @Override // com.larus.showcase.api.ICaseService
    public final Object b(String r100, boolean r101, Continuation<? super List<Message>> r102) {
        return CaseRepo.f369269a.f(r100, r101, r102);
    }
}
