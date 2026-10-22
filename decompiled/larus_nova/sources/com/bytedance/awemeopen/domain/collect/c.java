package com.bytedance.awemeopen.domain.collect;

import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.awemeopen.domain.base.repo.ConstantsKt;
import com.bytedance.awemeopen.domain.base.repo.GsonHolder;
import com.bytedance.awemeopen.infra.base.net.AoFromSource;
import com.bytedance.awemeopen.infra.base.net.AoNet;
import com.bytedance.awemeopen.infra.base.net.AoNetResponse;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f198254a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f198255b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f198256c = null;

    public c() {
    }

    static {
        f198254a = new c();
        String r100 = ConstantsKt.a();
        f198255b = r100 + "/aweme/open/export_sdk/collect/item";
        f198256c = r100 + "/aweme/open/export_sdk/collect/item_list";
    }

    public static void b(s34.d r100) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L18
        if (r100 == null) goto L16;
        List<r14.c> r102 = r100.g();     // Catch: Throwable -> L18
        if (r102 == null) goto L14;
        ArrayList r103 = new ArrayList();     // Catch: Throwable -> L18
        Iterator<T> r104 = r102.iterator();     // Catch: Throwable -> L18
    L9:
        if (r104.hasNext() == false) goto L13;
        Object r105 = r104.next();     // Catch: Throwable -> L18
        if ((!Intrinsics.areEqual(((r14.c) r105).r().f535653e, Boolean.TRUE)) == false) goto L9;
        r103.add(r105);     // Catch: Throwable -> L18
        goto L9
    L13:
        List<r14.c> r106 = CollectionsKt.toMutableList(r103);     // Catch: Throwable -> L18
    L15:
        r100.i(r106);     // Catch: Throwable -> L18
        goto L16
    L14:
        r106 = null;
    L16:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L18
        return;
    L18:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    public static com.bytedance.awemeopen.domain.base.repo.e a(String r100, int r101, String r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "token");
        Intrinsics.checkNotNullParameter(r102, "aid");
        d r104 = null;
        JSONObject r105 = new JSONObject();     // Catch: Exception -> L18
        r105.put("item_id", r102);     // Catch: Exception -> L18
        r105.put(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_ITEM_TYPE, r101);     // Catch: Exception -> L18
        r105.put("action", r103);     // Catch: Exception -> L18
        int r106 = com.bytedance.awemeopen.domain.base.repo.b.f198240b;     // Catch: Exception -> L18
        String r107 = com.bytedance.awemeopen.domain.base.repo.b.a.a(f198255b, MapsKt.emptyMap());     // Catch: Exception -> L18
        Function0<String> r108 = AoNet.f198669a;     // Catch: Exception -> L18
        AoNetResponse r109 = AoNet.h(r107, AoFromSource.f98default, r105, MapsKt.mapOf(new Pair[]{TuplesKt.to("access-token", r100), TuplesKt.to("Content-Type", "application/json")}));     // Catch: Exception -> L18
        Throwable r110 = r109.getThrowable();     // Catch: Exception -> L18
        String r111 = com.bytedance.awemeopen.domain.base.repo.d.a(r109);     // Catch: Exception -> L18
    L16:
        e = move-exception;
        Exception e100 = e;
        String r112 = null;
    L20:
        Exception r113 = e100;
        String r114 = r112;
        Exception r115 = r113;
    L21:
        int r116 = com.bytedance.awemeopen.domain.base.repo.a.f198239a;
        com.bytedance.awemeopen.domain.base.repo.a.a(com.bytedance.awemeopen.domain.base.repo.d.b(f198255b), r104, r111, r114, r115);
        return new com.bytedance.awemeopen.domain.base.repo.e(r104, r115);
    L5:
        if (r109.isSuccessful() == false) goto L11;
        r112 = r109.stringBody();     // Catch: Exception -> L16
        d r117 = (d) GsonHolder.a().fromJson(r112, d.class);     // Catch: Exception -> L9
        r114 = r112;
        r115 = null;
        r104 = r117;
    L9:
        e100 = e;
        goto L20
    L11:
        if (r110 == null) goto L14;
        r115 = com.bytedance.awemeopen.domain.base.repo.d.c(r110);     // Catch: Exception -> L16
    L15:
        r114 = null;
        goto L21
    L14:
        r115 = new RuntimeException("code=" + r109.getCode() + ", logId=" + r111);     // Catch: Exception -> L16
    L18:
        e = move-exception;
        e100 = e;
        r112 = null;
        r111 = null;
        goto L20
    }
}
