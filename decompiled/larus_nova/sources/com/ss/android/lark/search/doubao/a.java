package com.ss.android.lark.search.doubao;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.search.doubao.api.request.r;
import com.ss.android.lark.search.dto.Scene;
import com.ss.android.lark.search.dto.SearchResponse;
import com.ss.android.lark.search.dto.service.SearchContext;
import com.ss.android.lark.search.dto.service.Union;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class a implements z3c.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f439936c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.ss.android.lark.search.doubao.b f439937a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public IGetDataCallback<SearchResponse> f439938b;

    /* JADX INFO: renamed from: com.ss.android.lark.search.doubao.a$a, reason: collision with other inner class name */
    public static final class C5283a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f439939a = null;

        static {
            int[] r100 = new int[Union.values().length];
            r100[Union.YES.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[Union.NO.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[Union.ALL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f439939a = r100;
        }
    }

    static {
    }

    public a() {
        this.f439937a = new com.ss.android.lark.search.doubao.b();
    }

    @Override // z3c.a
    public final void onLoadMore(String r100, SearchContext r101) {
        Intrinsics.checkNotNullParameter(r100, "requestId");
        IGetDataCallback<SearchResponse> r102 = this.f439938b;
        if (r102 != null) goto L6;
        Log.w("DocCollaboratorSearchObserver", "onLoadMore called before onSearch, requestId=" + r100 + ", scene=null");
        return;
    L6:
        this.f439937a.a(r100, r102);
    }

    @Override // z3c.a
    public final void onLoadMore(String r100, SearchContext r101, IGetDataCallback<SearchResponse> r102) {
        Intrinsics.checkNotNullParameter(r100, "requestId");
        Intrinsics.checkNotNullParameter(r102, "callback");
        if (r101.f440172a == Scene.Type.SEARCH_DOC_COLLABORATOR) goto L6;
        Log.w("DocCollaboratorSearchObserver", "onLoadMore unsupported scene, requestId=" + r100 + ", scene=" + r101.f440172a);
        StringBuilder r103 = new StringBuilder("unsupported doc collaborator search scene: ");
        r103.append(r101.f440172a);
        r102.onError(new ErrorResult(r103.toString()));
        return;
    L6:
        this.f439937a.a(r100, r102);
    }

    @Override // z3c.a
    public final void onSearch(String r100, final SearchContext r101, IGetDataCallback<SearchResponse> r102) {
        Intrinsics.checkNotNullParameter(r100, "requestId");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "callback");
        if (r101.f440172a == Scene.Type.SEARCH_DOC_COLLABORATOR) goto L6;
        Log.w("DocCollaboratorSearchObserver", "onSearch unsupported scene, requestId=" + r100 + ", scene=" + r101.f440172a);
        StringBuilder r103 = new StringBuilder("unsupported doc collaborator search scene: ");
        r103.append(r101.f440172a);
        r102.onError(new ErrorResult(r103.toString()));
        return;
    L6:
        this.f439938b = r102;
        this.f439937a.b(r100, r.a(new DocCollaboratorSearchLifecycleObserver$toDocCollaboratorRequest$1(r101, this)), r102);
    }
}
