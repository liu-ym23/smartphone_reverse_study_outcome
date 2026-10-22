package com.ss.android.lark.chat.preview.service.impl;

import b38.b;
import com.bytedance.lark.pb.basic.v1.PreviewHangPoint;
import com.bytedance.lark.pb.basic.v1.SyncDataStrategy;
import com.bytedance.lark.pb.url.v1.AppScene;
import com.bytedance.lark.pb.url.v1.DeletePreviewsByIdsRequest;
import com.bytedance.lark.pb.url.v1.GetPreviewRequest;
import com.bytedance.lark.pb.url.v1.GetTempPreviewRequest;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.rucket.job.RucketJob;
import com.ss.android.lark.export.entity.UrlCardPreviewEntity;
import com.ss.android.lark.log.Log;
import h6b.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes35.dex */
@Singleton
public final class UrlPreviewService {

    public static final class a {
    }

    static {
    }

    @Inject
    public UrlPreviewService() {
    }

    public static void a(List r100) {
        Intrinsics.checkNotNullParameter(r100, "previewIds");
        ArrayList r101 = new ArrayList();
        Iterator r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        Object r103 = r102.next();
        if ((true ^ StringsKt.isBlank((String) r103)) == false) goto L4;
        r101.add(r103);
        goto L4
    L8:
        List<String> r104 = CollectionsKt.distinct(r101);
        if (r104.isEmpty() == false) goto L11;
        return;
    L11:
        DeletePreviewsByIdsRequest r105 = new DeletePreviewsByIdsRequest.Builder().preview_ids(r104).build();
        com.ss.android.lark.chat.preview.service.impl.a r106 = (com.ss.android.lark.chat.preview.service.impl.a) b.f17382a.create(com.ss.android.lark.chat.preview.service.impl.a.class);
        Intrinsics.checkNotNull(r105);
        RucketJob.error$default(RucketJob.then$default(r106.deletePreviewsByIds(r105), null, new UrlPreviewService$deletePreviewsByIds$1(r104, null), 1, null), null, new UrlPreviewService$deletePreviewsByIds$2(null), 1, null);
    }

    public final Object b(List<PreviewHangPoint> r100, Continuation<? super Map<String, UrlCardPreviewEntity>> r101) {
        return BuildersKt.withContext(Dispatchers.getIO(), new UrlPreviewService$getPreviewByHangPoints$2(r100, this, null), r101);
    }

    public static void c(List r100, SyncDataStrategy r101, IGetDataCallback r102) {
        Intrinsics.checkNotNullParameter(r100, "previewIds");
        Intrinsics.checkNotNullParameter(r101, "syncDataStrategy");
        Intrinsics.checkNotNullParameter(r102, "callback");
        if (r100.isEmpty() == false) goto L5;
        return;
    L5:
        StringBuilder r103 = new StringBuilder("start,");
        g r104 = g.f483951b;
        r104.getClass();
        Intrinsics.checkNotNullParameter(r100, "stringList");
        r104.f483952a.getClass();
        r103.append(k6b.a.d(r100));
        Log.i("[URLPreview] GetMessagePreviewsRequest", r103.toString());
        GetPreviewRequest.Builder r105 = new GetPreviewRequest.Builder().preview_ids(r100).sync_data_strategy(SyncDataStrategy.fromValue(r101.getValue()));
        RucketJob.then$default(((com.ss.android.lark.chat.preview.service.impl.a) b.f17382a.create(com.ss.android.lark.chat.preview.service.impl.a.class)).getPreviewEntity(r105.build()), null, new UrlPreviewService$getPreviewEntity$1(r102, null), 1, null).error(Dispatchers.getMain(), new UrlPreviewService$getPreviewEntity$2(r102, null));
    }

    public static void d(String r100, long r101, long r102, IGetDataCallback r103) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r103, "callback");
        Log.i("[URLPreview] GetTempPreviewRequest", "start, url.length:" + r100.length());
        ((com.ss.android.lark.chat.preview.service.impl.a) b.f17382a.create(com.ss.android.lark.chat.preview.service.impl.a.class)).getTempPreview(new GetTempPreviewRequest.Builder().app_id(Long.valueOf(r101)).url(r100).app_scene(new AppScene.Builder().type(Long.valueOf(r102)).base_ctx(null).build()).build()).then(Dispatchers.getMain(), new UrlPreviewService$getTempPreview$1(r103, null)).error(Dispatchers.getMain(), new UrlPreviewService$getTempPreview$2(r103, null));
    }
}
