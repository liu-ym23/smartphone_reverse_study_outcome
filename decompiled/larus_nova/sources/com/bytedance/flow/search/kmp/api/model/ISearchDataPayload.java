package com.bytedance.flow.search.kmp.api.model;

import android.os.Parcelable;
import aw5.a;
import aw5.c;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import t1a.b;
import wv5.j;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000e\u00105\u001a\u00020\u00142\u0006\u00106\u001a\u00020\u0013R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\nX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\nX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0014\u0010\u000f\u001a\u00020\nX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR0\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR&\u0010 \u001a\u0004\u0018\u00010!8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\"\u0010\u0004\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R&\u0010'\u001a\u0004\u0018\u00010(8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b)\u0010\u0004\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R&\u0010.\u001a\u0004\u0018\u00010/8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b0\u0010\u0004\u001a\u0004\b1\u00102\"\u0004\b3\u00104¨\u00067"}, d2 = {"Lcom/bytedance/flow/search/kmp/api/model/ISearchDataPayload;", "Landroid/os/Parcelable;", "Lcom/flow/kmp/common/serialization/KmpParcelable;", "<init>", "()V", "type", "", "getType", "()I", "entityId", "", "getEntityId", "()Ljava/lang/String;", "chatType", "getChatType", "searchRequestId", "getSearchRequestId", "dispatcher", "Lkotlin/Function1;", "Lcom/bytedance/flow/search/kmp/api/store/FlowSearchAction;", "", "getDispatcher$annotations", "getDispatcher", "()Lkotlin/jvm/functions/Function1;", "setDispatcher", "(Lkotlin/jvm/functions/Function1;)V", "query", "Lcom/bytedance/flow/search/kmp/api/model/FlowQuery;", "getQuery", "()Lcom/bytedance/flow/search/kmp/api/model/FlowQuery;", "setQuery", "(Lcom/bytedance/flow/search/kmp/api/model/FlowQuery;)V", "searchState", "Lcom/bytedance/flow/search/kmp/api/store/FlowSearchState;", "getSearchState$annotations", "getSearchState", "()Lcom/bytedance/flow/search/kmp/api/store/FlowSearchState;", "setSearchState", "(Lcom/bytedance/flow/search/kmp/api/store/FlowSearchState;)V", "vContext", "Lcom/larus/ui/arch/context/external/VContext;", "getVContext$annotations", "getVContext", "()Lcom/larus/ui/arch/context/external/VContext;", "setVContext", "(Lcom/larus/ui/arch/context/external/VContext;)V", "sourceData", "Lcom/bytedance/flow/search/kmp/api/model/FlowSearchData;", "getSourceData$annotations", "getSourceData", "()Lcom/bytedance/flow/search/kmp/api/model/FlowSearchData;", "setSourceData", "(Lcom/bytedance/flow/search/kmp/api/model/FlowSearchData;)V", "dispatch", "action", "aggregate_search_kmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class ISearchDataPayload implements Parcelable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f243284a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f243285b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f243286c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Function1<? super a, Unit> f243287d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public FlowQuery f243288e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public c f243289f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public b f243290g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public FlowSearchData f243291h;

    public int getType() {
        return 0;
    }

    public ISearchDataPayload() {
        this.f243284a = "";
        this.f243285b = "";
        this.f243286c = "";
        this.f243287d = new j();
    }

    public String b() {
        return this.f243285b;
    }

    public String c() {
        return this.f243284a;
    }

    public String d() {
        return this.f243286c;
    }

    public final void a(a r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        this.f243287d.invoke(r100);
    }
}
