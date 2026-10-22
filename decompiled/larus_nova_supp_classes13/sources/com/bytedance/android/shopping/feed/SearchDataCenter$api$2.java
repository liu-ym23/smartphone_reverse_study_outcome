package com.bytedance.android.shopping.feed;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/bytedance/android/shopping/feed/SearchWordApi;", "invoke"}, k = 3, mv = {1, 4, 3})
final class SearchDataCenter$api$2 extends Lambda implements Function0<SearchWordApi> {
    public static final SearchDataCenter$api$2 INSTANCE = null;

    static {
        INSTANCE = new SearchDataCenter$api$2();
    }

    public SearchDataCenter$api$2() {
        super(0);
    }

    public final SearchWordApi invoke() {
        int r0 = ld3.f.a;
        int r1 = com.bytedance.android.ec.core.opt.ab.p.a;
        Object r2 = Boolean.TRUE;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r4 = jj4.b.b;     // Catch: Throwable -> L7
        Object r5 = jj4.a.a("ec_video_search_domain_opt", Boolean.class, r2, false);     // Catch: Throwable -> L7
        if (r5 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        if (((Boolean) r5).booleanValue() == false) goto L17;
        return (SearchWordApi) com.bytedance.android.ec.sdk.helper.n.a.create("https://tsearch.amemv.com", SearchWordApi.class);
    L17:
        return (SearchWordApi) com.bytedance.android.ec.sdk.helper.n.a.create("https://search.amemv.com", SearchWordApi.class);
    L7:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        Object r7 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r7) == true) goto L12;
        r2 = r7;
    L12:
        r5 = r2;
        goto L14
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m862invoke() {
        return invoke();
    }
}
