package com.bytedance.ee.bear.document.offline.sync.rust;

import com.alibaba.fastjson.JSON;
import com.bytedance.ee.bear.document.offline.sync.preloadtask.EmbedDocList;
import com.bytedance.ee.bear.document.offline.sync.preloadtask.PreloadSubblock;
import com.bytedance.ee.bear.document.offline.sync.preloadtask.ResDetail;
import com.bytedance.ee.bear.document.offline.sync.preloadtask.ResDetaildata;
import com.bytedance.lark.pb.space.doc.v1.CCMEmbedDocItem;
import com.bytedance.lark.pb.space.doc.v1.CCMPreloadSubBlockData;
import com.bytedance.lark.pb.space.doc.v1.CCMResourceItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static PreloadSubblock a(CCMPreloadSubBlockData r8) {
        Intrinsics.checkNotNullParameter(r8, "proto");
        PreloadSubblock r0 = new PreloadSubblock();
        r0.setCode(0);
        r0.setToken(r8.docx_token);
        List r1 = r8.res_list;
        ArrayList r2 = new ArrayList();
        Iterator r3 = r1.iterator();
    L4:
        if (r3.hasNext() == false) goto L19;
        CCMResourceItem r4 = (CCMResourceItem) r3.next();
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L8
        ResDetail r6 = new ResDetail();     // Catch: Throwable -> L8
        r6.setType(r4.res_type);     // Catch: Throwable -> L8
        r6.setData((ResDetaildata) JSON.parseObject(r4.data_json, ResDetaildata.class));     // Catch: Throwable -> L8
        Object r7 = Result.constructor-impl(r6);     // Catch: Throwable -> L8
    L10:
        Throwable r9 = Result.exceptionOrNull-impl(r7);
        if (r9 == null) goto L14;
        tt5.a.l("DocsRustPreloadProtoBridge", "[rust_preload] skip invalid res item, type=" + r4.res_type, r9);
    L14:
        if (Result.isFailure-impl(r7) == false) goto L16;
        r7 = null;
    L16:
        ResDetail r10 = (ResDetail) r7;
        if (r10 == null) goto L4;
        r2.add(r10);
    L8:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    L19:
        r0.setResList(new ArrayList(r2));
        List r12 = r8.embed_doc_list;
        ArrayList r13 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r12, 10));
        Iterator r14 = r12.iterator();
    L21:
        if (r14.hasNext() == false) goto L23;
        CCMEmbedDocItem r16 = (CCMEmbedDocItem) r14.next();
        EmbedDocList r17 = new EmbedDocList();
        r17.setToken(r16.token);
        r17.setFileType(r16.file_type);
        r13.add(r17);
        goto L21
    L23:
        r0.setEmbedDocList(new ArrayList(r13));
        return r0;
    }
}
