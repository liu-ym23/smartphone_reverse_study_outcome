package com.bytedance.navigation.kmp.handler.projection;

import com.bytedance.badger.collect.impl.constants.Constants;
import com.larus.navigation.impl.platform.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ouc.v;
import ouc.w;

/* JADX INFO: loaded from: classes21.dex */
public final class ProjectionUploadApi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ProjectionUploadApi f265834a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final v f265835b = null;

    public ProjectionUploadApi() {
    }

    static {
        f265834a = new ProjectionUploadApi();
        f265835b = w.a(new d());
    }

    public final Object a(String r110, List<c> r210, Continuation<? super Boolean> r211) {
        if ((r211 instanceof ProjectionUploadApi$upload$1) == false) goto L7;
        ProjectionUploadApi$upload$1 r100 = (ProjectionUploadApi$upload$1) r211;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        ProjectionUploadApi$upload$1 r111 = r100;
        Object r102 = r111.result;
        Object r112 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r111.label;
        boolean r113 = false;
        if (r103 == 0) goto L14;
        if (r103 != 1) goto L13;
        ResultKt.throwOnFailure(r102);
    L96:
        if (r102 == null) goto L99;
        r113 = true;
    L99:
        return Boxing.boxBoolean(r113);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r102);
        if (r210.isEmpty() == true) goto L17;
        v r114 = f265835b;
        int r104 = w27.g.f558041a;
        long r105 = System.currentTimeMillis();
        e.Companion.getClass();
        Intrinsics.checkNotNullParameter(r110, "navId");
        Intrinsics.checkNotNullParameter(r210, "records");
        if ((!r210.isEmpty()) == false) goto L103;
        List<c> r106 = r210;
        if ((r106 instanceof Collection) == true) goto L23;
    L25:
        Iterator<T> r107 = r106.iterator();
    L27:
        if (r107.hasNext() == false) goto L31;
        if (Intrinsics.areEqual(((c) r107.next()).f265862a, r110) == true) goto L27;
        boolean r108 = false;
    L32:
        if (r108 == false) goto L101;
        ArrayList r109 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r106, 10));
        Iterator<T> r115 = r106.iterator();
    L35:
        if (r115.hasNext() == false) goto L37;
        r109.add(Double.valueOf(((c) r115.next()).f265863b));
        goto L35
    L37:
        ArrayList r116 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r106, 10));
        Iterator<T> r117 = r106.iterator();
    L39:
        if (r117.hasNext() == false) goto L41;
        r116.add(Double.valueOf(((c) r117.next()).f265864c));
        r112 = r112;
        goto L39
    L41:
        Object r212 = r112;
        ArrayList r118 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r106, 10));
        Iterator<T> r119 = r106.iterator();
    L43:
        if (r119.hasNext() == false) goto L45;
        r118.add(Long.valueOf(((c) r119.next()).f265865d));
        goto L43
    L45:
        ArrayList r120 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r106, 10));
        Iterator<T> r121 = r106.iterator();
    L47:
        if (r121.hasNext() == false) goto L49;
        r120.add(Integer.valueOf(((c) r121.next()).f265866e));
        goto L47
    L49:
        ArrayList r122 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r106, 10));
        Iterator<T> r123 = r106.iterator();
    L51:
        if (r123.hasNext() == false) goto L53;
        r122.add(Double.valueOf(((c) r123.next()).f265867f));
        r109 = r109;
        goto L51
    L53:
        ArrayList r213 = r109;
        ArrayList r124 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r106, 10));
        Iterator<T> r125 = r106.iterator();
    L55:
        if (r125.hasNext() == false) goto L57;
        r124.add(Long.valueOf(((c) r125.next()).f265868g));
        goto L55
    L57:
        f r126 = new f(r105, new e(r110, r213, r116, r118, r120, r122, r124));
        r114.getClass();
        String r127 = r114.a(f.Companion.serializer(), r126);
        int r128 = w27.e.f558039a;
        e37.f r129 = w27.f.f558040a;
        if (r129 == null) goto L60;
        l r130 = r129.a();
    L61:
        if (r130 != null) goto L104;
        d37.i r131 = d37.i.f466749a;
        e37.c.a.a("Projection upload skipped: network unavailable");
        return Boxing.boxBoolean(false);
    L104:
        Result.Companion r132 = Result.Companion;     // Catch: Throwable -> L73
        e37.f r133 = w27.f.f558040a;     // Catch: Throwable -> L73
        if (r133 == null) goto L67;
        e37.a r134 = r133.f();     // Catch: Throwable -> L73
    L68:
        if (r134 == null) goto L70;
        String r135 = r134.a();     // Catch: Throwable -> L73
    L71:
        Object r136 = Result.m9449constructorimpl(r135);     // Catch: Throwable -> L73
    L76:
        if (Result.m9455isFailureimpl(r136) == false) goto L78;
        r136 = null;
    L78:
        String r137 = (String) r136;
        if (r137 == null) goto L91;
        String r138 = StringsKt.trim(r137).toString();
        if (r138 == null) goto L91;
        if (r138.length() <= 0) goto L85;
        boolean r139 = true;
    L86:
        if (r139 == true) goto L89;
        r138 = null;
    L89:
        if (r138 == null) goto L91;
        Map r140 = MapsKt.mapOf(TuplesKt.to("sdk_version", r138));
    L92:
        Map r141 = MapsKt.mapOf(TuplesKt.to("Content-Type", "application/json"));
        r111.label = 1;
        Object r142 = r130.b(Constants.PATHS.HOST_PSEUDO_CODE, "/location/navi_submit_tmp/", r140, r127, r141, r111);
        if (r142 != r212) goto L95;
        return r212;
    L95:
        r102 = r142;
        goto L96
    L85:
        r139 = false;
    L91:
        r140 = null;
        goto L92
    L70:
        r135 = null;
        goto L71
    L67:
        r134 = null;
    L73:
        th = move-exception;
        Result.Companion r143 = Result.Companion;
        r136 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L76
    L60:
        r130 = null;
        goto L61
    L101:
        throw new IllegalArgumentException("all records must use the same navId".toString());
    L31:
        r108 = true;
        goto L32
    L23:
        if (r106.isEmpty() == false) goto L25;
    L103:
        throw new IllegalArgumentException("records must not be empty".toString());
    L17:
        return Boxing.boxBoolean(true);
    L7:
        r100 = new ProjectionUploadApi$upload$1(this, r211);
        goto L8
    }
}
