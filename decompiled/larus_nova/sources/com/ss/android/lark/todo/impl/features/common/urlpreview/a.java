package com.ss.android.lark.todo.impl.features.common.urlpreview;

import android.text.TextUtils;
import com.bytedance.lark.pb.basic.v1.PreviewEntityPair;
import com.bytedance.lark.pb.basic.v1.RichContent;
import com.bytedance.lark.pb.basic.v1.UrlPreviewEntity;
import com.bytedance.lark.pb.basic.v1.UrlPreviewHangPoint;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.todo.impl.rustadapter.service.TodoRustCommon;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashMap<String, UrlPreviewEntity> f442485a = null;

    public a() {
    }

    static {
        f442485a = new HashMap();
    }

    public static PreviewEntityPair a(List r100) {
        Intrinsics.checkNotNullParameter(r100, "ids");
        HashMap r101 = new HashMap();
        Iterator r102 = ((ArrayList) r100).iterator();
    L4:
        if (r102.hasNext() == false) goto L9;
        String r103 = (String) r102.next();
        UrlPreviewEntity r104 = f442485a.get(r103);
        if (r104 == null) goto L4;
        UrlPreviewEntity r105 = (UrlPreviewEntity) r101.put(r103, r104);
        goto L4
    L9:
        if (CollectionUtils.isEmpty(r101) == false) goto L12;
        return null;
    L12:
        return new PreviewEntityPair.Builder().preview_entity(r101).build();
    }

    public final Object b(RichContent r100, Continuation r101) {
        if ((r101 instanceof UrlPreviewLoader$getPreviewEntityPair$1) == false) goto L7;
        UrlPreviewLoader$getPreviewEntityPair$1 r102 = (UrlPreviewLoader$getPreviewEntityPair$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        String r107 = (String) r102.L$0;
        ResultKt.throwOnFailure(r104);
    L52:
        Map r108 = (Map) r104;
        if (r108 == null) goto L58;
        Map<String, UrlPreviewEntity> r109 = (Map) r108.get(r107);
        if (r109 == null) goto L58;
        return new PreviewEntityPair.Builder().preview_entity(r109).build();
    L58:
        return null;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        HashMap r110 = new HashMap();
        Map<String, UrlPreviewHangPoint> r111 = r100.url_preview_hang_points;
        if (r111 == null) goto L17;
        Integer r112 = Boxing.boxInt(r111.size());
    L18:
        PreviewEntityPair r113 = r100.url_preview_entities;
        if (r113 == null) goto L23;
        Map<String, UrlPreviewEntity> r114 = r113.preview_entity;
        if (r114 == null) goto L23;
        Integer r115 = Boxing.boxInt(r114.size());
    L25:
        if (Intrinsics.areEqual(r112, r115) == true) goto L47;
        Map<String, UrlPreviewHangPoint> r116 = r100.url_preview_hang_points;
        if (r116 == null) goto L36;
        Collection<UrlPreviewHangPoint> r117 = r116.values();
        if (r117 == null) goto L36;
        ArrayList r118 = new ArrayList();
        Iterator<T> r119 = r117.iterator();
    L32:
        if (r119.hasNext() == false) goto L37;
        Object r120 = r119.next();
        if ((!TextUtils.isEmpty(((UrlPreviewHangPoint) r120).preview_id)) == false) goto L32;
        r118.add(r120);
    L37:
        if (r118 != null) goto L39;
    L42:
        boolean r121 = true;
    L43:
        if (r121 == false) goto L45;
        return null;
    L45:
        r110.put(null, r118);
        goto L47
    L39:
        if (r118.isEmpty() == true) goto L42;
        r121 = false;
    L36:
        r118 = null;
    L47:
        if ((!r110.isEmpty()) == false) goto L58;
        TodoRustCommon r122 = TodoRustCommon.f444251a;
        r102.L$0 = null;
        r102.label = 1;
        r104 = TodoRustCommon.b(r110, r102);
        if (r104 != r105) goto L51;
        return r105;
    L51:
        r107 = null;
    L23:
        r115 = null;
        goto L25
    L17:
        r112 = null;
    L7:
        r102 = new UrlPreviewLoader$getPreviewEntityPair$1(this, r101);
        goto L8
    }
}
