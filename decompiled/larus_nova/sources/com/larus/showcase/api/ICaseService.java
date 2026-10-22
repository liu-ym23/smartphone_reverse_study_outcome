package com.larus.showcase.api;

import androidx.fragment.app.Fragment;
import com.larus.im.bean.message.Message;
import com.larus.platform.api.j1;
import com.larus.platform.model.showcase.Case;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u0000 \"2\u00020\u0001:\u0001\"J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J \u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH&J(\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\nH¦@¢\u0006\u0002\u0010\fJ&\u0010\r\u001a\u00020\u000e2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\nH¦@¢\u0006\u0002\u0010\u0010J\u0018\u0010\u0011\u001a\u00020\n2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H¦@¢\u0006\u0002\u0010\u0012J\u0018\u0010\u0013\u001a\u00020\n2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H¦@¢\u0006\u0002\u0010\u0012J\u0018\u0010\u0014\u001a\u00020\u000e2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H¦@¢\u0006\u0002\u0010\u0012J\u0010\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0017H&J\u0010\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0017H&J\u000e\u0010\u0019\u001a\u00020\u000eH¦@¢\u0006\u0002\u0010\u001aJ\b\u0010\u001b\u001a\u00020\u000eH&J\b\u0010\u001c\u001a\u00020\u001dH&J\u000e\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007H&J\b\u0010\u001f\u001a\u00020\nH&J\b\u0010 \u001a\u00020\nH&J\b\u0010!\u001a\u00020\nH&¨\u0006#"}, d2 = {"Lcom/larus/showcase/api/ICaseService;", "", "getCaseModel", "Lcom/larus/platform/model/showcase/Case;", "caseId", "", "getCaseMessageListByCache", "", "Lcom/larus/im/bean/message/Message;", "isFromRecommend", "", "getCaseMessageListByRemote", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "preFetchMessageListByRemote", "", "caseIds", "(Ljava/util/List;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clickCase", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteCase", "updateCreateTime", "registerRecommendCaseChangeListener", "listener", "Lcom/larus/platform/api/IRecommendCaseChangeListener;", "unregisterRecommendCaseChangeListener", "fetchRecommendCaseList", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "initForConversationCase", "createCaseListFragment", "Landroidx/fragment/app/Fragment;", "getRecommendCaseList", "enableCaseFunction", "enablePinGreyBackground", "enableCheckbox", "Companion", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ICaseService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f369257a = null;

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0096A¢\u0006\u0002\u0010\bJ\t\u0010\t\u001a\u00020\nH\u0096\u0001J\u0018\u0010\u000b\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0096A¢\u0006\u0002\u0010\bJ\t\u0010\f\u001a\u00020\u0005H\u0096\u0001J\t\u0010\r\u001a\u00020\u0005H\u0096\u0001J\t\u0010\u000e\u001a\u00020\u0005H\u0096\u0001J\u000e\u0010\u000f\u001a\u00020\u0010H\u0096A¢\u0006\u0002\u0010\u0011J!\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00132\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0005H\u0096\u0001J(\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00132\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0015\u001a\u00020\u0005H\u0096A¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\u000f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u0013H\u0096\u0001J\t\u0010\u001b\u001a\u00020\u0010H\u0096\u0001J&\u0010\u001c\u001a\u00020\u00102\u000e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00132\u0006\u0010\u0015\u001a\u00020\u0005H\u0096A¢\u0006\u0002\u0010\u001eJ\u0011\u0010\u001f\u001a\u00020\u00102\u0006\u0010 \u001a\u00020!H\u0096\u0001J\u0011\u0010\"\u001a\u00020\u00102\u0006\u0010 \u001a\u00020!H\u0096\u0001J\u0018\u0010#\u001a\u00020\u00102\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0096A¢\u0006\u0002\u0010\b¨\u0006$"}, d2 = {"Lcom/larus/showcase/api/ICaseService$Companion;", "Lcom/larus/showcase/api/ICaseService;", "<init>", "()V", "clickCase", "", "caseId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createCaseListFragment", "Landroidx/fragment/app/Fragment;", "deleteCase", "enableCaseFunction", "enableCheckbox", "enablePinGreyBackground", "fetchRecommendCaseList", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCaseMessageListByCache", "", "Lcom/larus/im/bean/message/Message;", "isFromRecommend", "getCaseMessageListByRemote", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCaseModel", "Lcom/larus/platform/model/showcase/Case;", "getRecommendCaseList", "initForConversationCase", "preFetchMessageListByRemote", "caseIds", "(Ljava/util/List;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "registerRecommendCaseChangeListener", "listener", "Lcom/larus/platform/api/IRecommendCaseChangeListener;", "unregisterRecommendCaseChangeListener", "updateCreateTime", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion implements ICaseService {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ Companion f369258c = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ICaseService f369259b;

        static {
            f369258c = new Companion();
        }

        @Override // com.larus.showcase.api.ICaseService
        public final List<Message> a(String r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, "caseId");
            return this.f369259b.a(r100, r101);
        }

        @Override // com.larus.showcase.api.ICaseService
        public final Object b(String r100, boolean r101, Continuation<? super List<Message>> r102) {
            return this.f369259b.b(r100, r101, r102);
        }

        @Override // com.larus.showcase.api.ICaseService
        public final Object c(Continuation<? super Unit> r100) {
            return this.f369259b.c(r100);
        }

        @Override // com.larus.showcase.api.ICaseService
        public final Object d(String r100, Continuation<? super Unit> r101) {
            return this.f369259b.d(r100, r101);
        }

        @Override // com.larus.showcase.api.ICaseService
        public final Fragment e() {
            return this.f369259b.e();
        }

        @Override // com.larus.showcase.api.ICaseService
        public final boolean f() {
            return this.f369259b.f();
        }

        @Override // com.larus.showcase.api.ICaseService
        public final void g(j1 r100) {
            Intrinsics.checkNotNullParameter(r100, "listener");
            this.f369259b.g(r100);
        }

        @Override // com.larus.showcase.api.ICaseService
        public final Object h(List r100, Continuation r101) {
            return this.f369259b.h(r100, r101);
        }

        @Override // com.larus.showcase.api.ICaseService
        public final List<Case> i() {
            return this.f369259b.i();
        }

        @Override // com.larus.showcase.api.ICaseService
        public final Object j(String r100, Continuation<? super Boolean> r101) {
            return this.f369259b.j(r100, r101);
        }

        @Override // com.larus.showcase.api.ICaseService
        public final boolean k() {
            return this.f369259b.k();
        }

        @Override // com.larus.showcase.api.ICaseService
        public final Case l(String r100) {
            Intrinsics.checkNotNullParameter(r100, "caseId");
            return this.f369259b.l(r100);
        }

        @Override // com.larus.showcase.api.ICaseService
        public final boolean m() {
            return this.f369259b.m();
        }

        @Override // com.larus.showcase.api.ICaseService
        public final void n() {
            this.f369259b.n();
        }

        @Override // com.larus.showcase.api.ICaseService
        public final void o(j1 r100) {
            Intrinsics.checkNotNullParameter(r100, "listener");
            this.f369259b.o(r100);
        }

        @Override // com.larus.showcase.api.ICaseService
        public final Object p(String r100, Continuation<? super Boolean> r101) {
            return this.f369259b.p(r100, r101);
        }

        private Companion() {
            Object r100 = ServiceManager.get().getService(ICaseService.class);
            Intrinsics.checkNotNull(r100);
            this.f369259b = (ICaseService) r100;
        }
    }

    static {
        f369257a = Companion.f369258c;
    }

    List<Message> a(String r100, boolean r101);

    Object b(String r100, boolean r101, Continuation<? super List<Message>> r102);

    Object c(Continuation<? super Unit> r100);

    Object d(String r100, Continuation<? super Unit> r101);

    Fragment e();

    boolean f();

    void g(j1 r100);

    Object h(List r100, Continuation r101);

    List<Case> i();

    Object j(String r100, Continuation<? super Boolean> r101);

    boolean k();

    Case l(String r100);

    boolean m();

    void n();

    void o(j1 r100);

    Object p(String r100, Continuation<? super Boolean> r101);
}
