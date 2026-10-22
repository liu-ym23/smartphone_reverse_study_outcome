package com.ss.android.ugc.aweme.search.common.result.sug;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.retrofit2.Call;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.gson.Gson;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.ec.search.common.LogPbBean;
import com.ss.android.ugc.aweme.feed.LogPbManager;
import com.ss.android.ugc.aweme.search.common.base.TaskManager;
import com.ss.android.ugc.aweme.search.common.bean.ECSearchSugResponse;
import com.ss.android.ugc.aweme.search.common.model.ECSearchBaseModel;
import com.ss.android.ugc.aweme.search.common.result.sug.base.BasePresenter;
import com.ss.android.ugc.aweme.search.common.result.sug.listener.SearchSugDataHandler;
import com.ss.android.ugc.aweme.search.common.result.sug.model.SearchSugRequest;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
public class ECSearchSugPresenter extends BasePresenter<ECSearchBaseModel<ECSearchSugResponse>, SearchSugDataHandler> implements Observer<ECSearchSugResponse> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Handler f451900c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ECSearchSugViewModel f451901d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f451902e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f451903f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Deque<RequestTaskWrapper> f451904g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public SearchSugRequest f451905h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f451906i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Runnable f451907j;

    /* JADX INFO: renamed from: com.ss.android.ugc.aweme.search.common.result.sug.ECSearchSugPresenter$2, reason: invalid class name */
    class AnonymousClass2 extends ECSearchBaseModel<ECSearchSugResponse> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ ECSearchSugPresenter f451909e;

        public AnonymousClass2(ECSearchSugPresenter r100) {
            this.f451909e = r100;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v1, types: [com.ss.android.ugc.aweme.search.common.result.sug.a] */
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
        @Override // com.ss.android.ugc.aweme.search.common.model.ECSearchBaseModel
        public final boolean a(final Object... r100) {
            if (b(r100) == false) goto L5;
            this.f451782a = true;
            boolean r101 = true;
        L6:
            if (r101 == true) goto L8;
            return false;
        L8:
            this.f451782a = false;
            ECSearchSugPresenter r102 = this.f451909e;
            r102.getClass();
            long r103 = r102.f451902e + 1;
            r102.f451902e = r103;
            final RequestTaskWrapper r104 = new RequestTaskWrapper();
            r104.f451910a = r103;
            ((LinkedList) this.f451909e.f451904g).addLast(r104);
            if (TaskManager.f451483c == null) goto L11;
        L20:
            TaskManager.f451483c.a(this.f451783b, new a(this, r100, r104));
            return true;
        L11:
            monitor-enter(TaskManager.class);
        L17:
            th = move-exception;
            throw th;
        L13:
            if (TaskManager.f451483c != null) goto L15;
            TaskManager.f451483c = new TaskManager();     // Catch: Throwable -> L17
        L15:
            monitor-exit(TaskManager.class);     // Catch: Throwable -> L17
            goto L20
        L5:
            r101 = false;
            goto L6
        }

        public final boolean b(Object... r100) {
            if (r100.length != 0) goto L5;
            return false;
        L5:
            SearchSugRequest r101 = (SearchSugRequest) r100[0];
            if (r101 != null) goto L9;
            return false;
        L9:
            return !TextUtils.isEmpty(r101.keyword);
        }

        @Override // com.ss.android.ugc.aweme.search.common.model.ECSearchBaseModel, com.bytedance.common.utility.collection.WeakHandler.IHandler
        public final void handleMsg(Message r110) {
            Object r100 = r110.obj;
            if ((r100 instanceof CancellationException) == false) goto L6;
            return;
        L6:
            if ((r100 instanceof ECSearchSugResponse) == false) goto L30;
            ECSearchSugResponse r101 = (ECSearchSugResponse) r100;
            RequestTaskWrapper r102 = r101.requestTaskWrapper;
            if (r102 != null) goto L10;
            return;
        L10:
            if (r102.f451913d == false) goto L13;
            return;
        L13:
            if (this.f451909e.f451904g.isEmpty() == true) goto L25;
            RequestTaskWrapper r103 = (RequestTaskWrapper) ((LinkedList) this.f451909e.f451904g).pollFirst();
            long r104 = r103.f451910a;
            long r105 = r102.f451910a;
            boolean r106 = true;
            if (r104 >= r105) goto L23;
            r103.f451913d = true;
            ListenableFuture<ECSearchSugResponse> r107 = r103.f451911b;
            if (r107 == null) goto L19;
            r107.cancel(true);
        L19:
            Call<ECSearchSugResponse> r108 = r103.f451912c;
            if (r108 == null) goto L13;
            r108.cancel();
            goto L13
        L23:
            if (r104 != r105) goto L25;
        L26:
            if (r106 == true) goto L28;
            return;
        L28:
            r101.requestTaskWrapper = null;
        L25:
            r106 = false;
        L30:
            super.handleMsg(r110);
        }
    }

    public static class RequestTaskWrapper {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f451910a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ListenableFuture<ECSearchSugResponse> f451911b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Call<ECSearchSugResponse> f451912c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f451913d;

        public RequestTaskWrapper() {
        }
    }

    @Override // com.ss.android.ugc.aweme.search.common.result.sug.base.BasePresenter, com.ss.android.ugc.aweme.search.common.model.INotifyListener
    public final void a() {
        this.f451901d.getSuggestResponse().setValue(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ss.android.ugc.aweme.search.common.result.sug.base.BasePresenter, com.ss.android.ugc.aweme.search.common.model.INotifyListener
    public final void onSuccess() {
        T r100 = this.f451932a;
        if (r100 == 0) goto L5;
        ECSearchSugResponse r101 = (ECSearchSugResponse) r100.f451784c;
    L6:
        this.f451901d.getSuggestResponse().setValue(r101);
        return;
    L5:
        r101 = null;
        goto L6
    }

    public ECSearchSugPresenter(Fragment r100) {
        this.f451900c = new Handler(Looper.getMainLooper());
        this.f451902e = 0;
        this.f451903f = "";
        this.f451904g = new LinkedList();
        this.f451907j = new AnonymousClass1(this);
        if (r100.getActivity() == null) goto L11;
        FragmentActivity r101 = r100.getActivity();
        if (r100.isDetached() == false) goto L7;
    L9:
        Fragment r102 = null;
    L10:
        ECSearchSugViewModel r103 = ECSearchSugViewModel.get(r101, r102);
        this.f451901d = r103;
        r103.getSuggestResponse().observe(r100, this);
        goto L11
    L7:
        if ((r100 instanceof ECSearchSaaSSugFragment) == false) goto L9;
        r102 = ((ECSearchSaaSSugFragment) r100).getParentFragment();
    L11:
        AnonymousClass2 r104 = new AnonymousClass2(this);
        this.f451932a = r104;
        if (r104.f451785d != null) goto L14;
        r104.f451785d = new LinkedList();
    L14:
        ((LinkedList) r104.f451785d).add(this);
        this.f451903f = "";
        this.f451906i = true;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        ECSearchSugResponse r101 = (ECSearchSugResponse) r100;
        K r102 = this.f451933b;
        if (r102 == 0) goto L18;
        if (r101 == null) goto L16;
        LogPbBean r103 = r101.getLogPb();
        if (r103 != null) goto L8;
    L15:
        ((SearchSugDataHandler) this.f451933b).NA(r101);
        return;
    L8:
        if (r103.getImprId() == null) goto L15;
        LogPbManager.f450809c.getClass();
        LogPbManager r104 = LogPbManager.Companion.a();
        String r105 = r101.getRequestId();
        String r106 = GsonProtectorUtils.toJson(new Gson(), r103);
        r104.getClass();
        if (TextUtils.isEmpty(r105) == true) goto L15;
        if (TextUtils.isEmpty(r106) == true) goto L15;
        Map<String, String> r107 = r104.f450810a;
        Intrinsics.checkNotNull(r105);
        Intrinsics.checkNotNull(r106);
        ((ConcurrentHashMap) r107).put(r105, r106);
        goto L15
    L16:
        ((SearchSugDataHandler) r102).H6();
        return;
    }
}
