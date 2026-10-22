package com.bytedance.flow.search.kmp.impl.provider;

import com.bytedance.flow.search.kmp.api.model.FlowQuery;
import com.bytedance.flow.search.kmp.api.model.FlowSearchData;
import com.bytedance.flow.search.kmp.api.model.SearchCursor;
import com.bytedance.flow.search.kmp.api.model.payload.AutoLoadMorePayload;
import com.bytedance.flow.search.kmp.api.model.payload.RecentDrivePayload;
import com.bytedance.flow.search.kmp.api.spi.SearchDriveItem;
import com.bytedance.flow.search.kmp.api.spi.SearchDriveService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes3.dex */
public final class RecentDriveDataSourceProvider implements vv5.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f243637a;

    public static final class a {
    }

    static {
    }

    public RecentDriveDataSourceProvider() {
    }

    @Override // vv5.a
    public final void reset() {
        this.f243637a = null;
    }

    @Override // vv5.a
    public final Object a(FlowQuery r210, Continuation<? super vv5.b> r211) {
        FlowQuery r100 = r210;
        if ((r211 instanceof RecentDriveDataSourceProvider$search$1) == false) goto L7;
        RecentDriveDataSourceProvider$search$1 r101 = (RecentDriveDataSourceProvider$search$1) r211;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        boolean r106 = true;
        char r107 = 1;
        char r108 = 1;
        char r109 = 1;
        boolean r110 = false;
        String r111 = "drive";
        List r112 = null;
        if (r105 == 0) goto L16;
        if (r105 != 1) goto L15;
        r100 = (FlowQuery) r101.L$0;
        ResultKt.throwOnFailure(r103);     // Catch: Exception -> L55
    L41:
        zv5.i r113 = (zv5.i) r103;     // Catch: Exception -> L55
        if (r113.f573704d == true) goto L45;
        this.f243637a = r113.f573702b;
        List<SearchDriveItem> r114 = r113.f573701a;
        ArrayList r115 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r114, 10));
        Iterator r116 = r114.iterator();
    L48:
        if (r116.hasNext() == false) goto L50;
        SearchDriveItem r117 = (SearchDriveItem) r116.next();
        String r118 = r111;
        r115.add(new FlowSearchData(r118, 114, new RecentDrivePayload(r117.f243532a, r117.f243540i, r117.f243533b, r117.f243537f, r117.f243538g, r117.f243543l, r117)));
        r116 = r116;
        r111 = r118;
        goto L48
    L50:
        String r119 = r111;
        String r120 = (String) CollectionsKt.firstOrNull(r100.f243271b);
        if (r120 != null) goto L53;
        r120 = "";
    L53:
        boolean r121 = r113.f573703c;
        SearchCursor.b r122 = SearchCursor.Companion;
        String r123 = this.f243637a;
        r122.getClass();
        return new vv5.b(CollectionsKt.plus(r115, new FlowSearchData(r119, 110, new AutoLoadMorePayload(r120, r121, SearchCursor.b.a(r123)))), false, 2);
    L45:
        return new vv5.b(r112, r106, r109 == true ? 1 : 0);
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r103);
        int r124 = 3;
        if (r100.f243271b.size() != 1) goto L58;
        if (r100.f243271b.contains("drive") == false) goto L58;
        pd6.b r125 = pd6.c.f528682a;
        SearchDriveService r126 = (SearchDriveService) pd6.c.a(Reflection.getOrCreateKotlinClass(SearchDriveService.class));
        if (r126 == null) goto L24;
        SearchCursor r127 = r100.f243273d;
        if (r127 == null) goto L28;
        String r128 = r127.f243311a;
    L29:
        if (r128 == null) goto L31;
        boolean r129 = true;
    L32:
        if (r129 == false) goto L37;
        if (r127 == null) goto L36;
        String r130 = r127.f243311a;
        if (r130 == null) goto L36;
    L38:
        r101.L$0 = r100;     // Catch: Exception -> L55
        r101.label = 1;     // Catch: Exception -> L55
        r103 = r126.G2(r130, r101);     // Catch: Exception -> L55
        if (r103 != r104) goto L41;
        return r104;
    L36:
        r130 = this.f243637a;
        goto L38
    L37:
        r130 = null;
        goto L38
    L31:
        r129 = false;
        goto L32
    L28:
        r128 = null;
        goto L29
    L24:
        return new vv5.b(r112, r110, r124);
    L58:
        return new vv5.b(r112, false, r124);
    L56:
        return new vv5.b(r112, r108 == true ? 1 : 0, r107 == true ? 1 : 0);
    L7:
        r101 = new RecentDriveDataSourceProvider$search$1(this, r211);
        goto L8
    }
}
