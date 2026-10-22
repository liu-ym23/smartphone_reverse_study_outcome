package com.bytedance.gkfs;

import com.bytedance.ee.bear.bitable.dao.resourcedata.BitableResourceData;
import com.bytedance.gkfs.io.ChunkFrom;
import com.bytedance.gkfs.io.n;
import com.bytedance.gkfs.io.o;
import com.bytedance.gkfs.io.p;
import com.ss.ttvideoengine.model.MediaBitrateFitterInfo;
import java.io.File;
import java.util.Iterator;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f245158a = 0;

    static {
    }

    public static void b(o r100) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L24
        JSONObject r102 = new JSONObject();     // Catch: Throwable -> L24
        r102.put("origin_file", r100.f245242b.getAbsolutePath());     // Catch: Throwable -> L24
        r102.put("gkfs_version", r100.f245241a.f245215b.f245227a);     // Catch: Throwable -> L24
        r102.put(MediaBitrateFitterInfo.KEY_FITTER_HEADER_SIZE, r100.f245241a.f245215b.f245229c);     // Catch: Throwable -> L24
        r102.put("chunk_count", r100.f245241a.f245216c.size());     // Catch: Throwable -> L24
        Iterator<T> r103 = r100.f245241a.f245216c.iterator();     // Catch: Throwable -> L24
        int r104 = 0;
        int r105 = 0;
    L4:
        if (r103.hasNext() == false) goto L6;
        r105 = r105 + ((com.bytedance.gkfs.io.d) r103.next()).f245195c.f245293h;     // Catch: Throwable -> L24
        goto L4
    L6:
        r102.put("chunk_size", r105);     // Catch: Throwable -> L24
        Iterator<T> r106 = r100.f245241a.f245216c.iterator();     // Catch: Throwable -> L24
    L8:
        if (r106.hasNext() == false) goto L10;
        r104 = r104 + ((com.bytedance.gkfs.io.d) r106.next()).f245195c.b();     // Catch: Throwable -> L24
        goto L8
    L10:
        r102.put("chunk_diluted_size", r104);     // Catch: Throwable -> L24
        r102.put("cdc_stats", r100.f245243c.f245151a.f245248c.getCode());     // Catch: Throwable -> L24
        com.bytedance.gkfs.cdc.c r107 = r100.f245243c;     // Catch: Throwable -> L24
        Throwable r108 = r107.f245151a.f245247b;     // Catch: Throwable -> L24
        if (r108 == null) goto L14;
        r102.put("cdc_error_msg", r108.getMessage() + ", cause:" + r108.getCause());     // Catch: Throwable -> L24
    L22:
        Object r109 = Result.m9449constructorimpl(r102);     // Catch: Throwable -> L24
    L27:
        if (Result.m9456isSuccessimpl(r109) == false) goto L29;
        y86.a.c("geckosdk_gkfs_store_stats", (JSONObject) r109);
    L29:
        Throwable r110 = Result.m9452exceptionOrNullimpl(r109);
        if (r110 == null) goto L33;
        r110.printStackTrace();
    L33:
        if (Result.m9455isFailureimpl(r109) == false) goto L35;
        r109 = null;
    L35:
        JSONObject r111 = (JSONObject) r109;
        return;
    L14:
        r102.put("min_size_suppress", r107.f245152b);     // Catch: Throwable -> L24
        r102.put("max_size_suppress", r100.f245243c.f245153c);     // Catch: Throwable -> L24
        Iterator<T> r112 = r100.f245243c.f245154d.values().iterator();     // Catch: Throwable -> L24
        long r113 = 0;
    L16:
        if (r112.hasNext() == false) goto L18;
        r113 = r113 + ((Number) r112.next()).longValue();     // Catch: Throwable -> L24
        goto L16
    L18:
        r102.put("cdc_chunk_time_cost", r113);     // Catch: Throwable -> L24
        r102.put("cdc_time_cost", r100.f245243c.f245156f);     // Catch: Throwable -> L24
        r102.put("store_stats", r100.f245244d.f245232c.f245248c.getCode());     // Catch: Throwable -> L24
        n r114 = r100.f245244d;     // Catch: Throwable -> L24
        Throwable r115 = r114.f245232c.f245247b;     // Catch: Throwable -> L24
        if (r115 == null) goto L21;
        r102.put("store_error_msg", r115.getMessage() + ", cause:" + r115.getCause());     // Catch: Throwable -> L24
        goto L22
    L21:
        r102.put("header_time_cost", r114.f245233d);     // Catch: Throwable -> L24
        r102.put("chunk_time_cost", CollectionsKt.sumOfLong(r100.f245244d.f245235f.f245198b.values()));     // Catch: Throwable -> L24
        r102.put("tail_size", r100.f245244d.f245238i);     // Catch: Throwable -> L24
        r102.put("tail_time_cost", r100.f245244d.f245237h);     // Catch: Throwable -> L24
        r102.put("total_time_cost", r100.f245244d.f245239j);     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        Result.Companion r116 = Result.Companion;
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L27
    }

    public static JSONObject c(Throwable r100, com.bytedance.gkfs.storage.c r101, long r102) {
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L15
        JSONObject r104 = new JSONObject();     // Catch: Throwable -> L15
        if (r100 == null) goto L10;
        String r105 = r100.getMessage();     // Catch: Throwable -> L15
        if (r105 != null) goto L9;
        r105 = r100.toString();     // Catch: Throwable -> L15
    L9:
        r104.put("error_msg", r105);     // Catch: Throwable -> L15
    L13:
        Object r106 = Result.m9449constructorimpl(r104);     // Catch: Throwable -> L15
    L18:
        if (Result.m9456isSuccessimpl(r106) == false) goto L20;
        y86.a.c("geckosdk_gkfs_resource_info", (JSONObject) r106);
    L20:
        Throwable r107 = Result.m9452exceptionOrNullimpl(r106);
        if (r107 == null) goto L24;
        r107.printStackTrace();
    L24:
        if (Result.m9455isFailureimpl(r106) == false) goto L27;
        r106 = null;
    L27:
        return (JSONObject) r106;
    L10:
        if (r101 != null) goto L12;
        r104.put("error_msg", "GkFSChunkTidyInfo is null");     // Catch: Throwable -> L15
        goto L13
    L12:
        r104.put("gecko_total_resource_usage", r102);     // Catch: Throwable -> L15
        r104.put("gkfs_file_count", r101.f245314g.f245315a);     // Catch: Throwable -> L15
        r104.put("gkfs_chunk_count", r101.f245314g.f245316b);     // Catch: Throwable -> L15
        r104.put("gkfs_chunk_usage", r101.f245314g.f245317c);     // Catch: Throwable -> L15
        r104.put("gkfs_chunk_disk_usage", r101.f245314g.f245318d);     // Catch: Throwable -> L15
        r104.put("gkfs_major_file_usage", r101.f245314g.f245319e);     // Catch: Throwable -> L15
        r104.put("gkfs_major_file_disk_usage", r101.f245314g.f245320f);     // Catch: Throwable -> L15
        r104.put("gkfs_total_resource_usage", r101.f245314g.f245321g);     // Catch: Throwable -> L15
        r104.put("gkfs_diluted_resource_usage", r101.f245314g.f245322h);     // Catch: Throwable -> L15
        r104.put("gkfs_chunk_refs_count", r101.f245314g.f245325k);     // Catch: Throwable -> L15
        r104.put("gkfs_chunk_indexing_size", r101.f245314g.f245323i);     // Catch: Throwable -> L15
        r104.put("gkfs_chunk_indexing_db_size", r101.f245314g.f245324j);     // Catch: Throwable -> L15
        r104.put("gkfs_tidy_delete_chunk_count", r101.f245308a);     // Catch: Throwable -> L15
        r104.put("gkfs_tidy_delete_chunk_size", r101.f245309b);     // Catch: Throwable -> L15
        r104.put("gkfs_tidy_refs_reduce_chunk_count", r101.f245310c);     // Catch: Throwable -> L15
        r104.put("gkfs_tidy_chunk_indexing_cost", r101.f245311d);     // Catch: Throwable -> L15
        r104.put("gkfs_tidy_chunk_io_cost", r101.f245312e);     // Catch: Throwable -> L15
        r104.put("gkfs_tidy_chunk_time_cost", r101.f245313f);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L18
    }

    public static void a(p r100, File r101, ChunkFrom r102, com.bytedance.gkfs.io.d r103) {
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L11
        if (r100.f245246a == false) goto L5;
        return;
    L5:
        JSONObject r105 = new JSONObject();     // Catch: Throwable -> L11
        r105.put("source_file", r101.getAbsolutePath());     // Catch: Throwable -> L11
        r105.put("id", r103.f245193a.f245192a);     // Catch: Throwable -> L11
        r105.put("stats", r100.f245248c.getCode());     // Catch: Throwable -> L11
        Throwable r106 = r100.f245247b;     // Catch: Throwable -> L11
        if (r106 == null) goto L8;
        r105.put("error_msg", r106.getMessage() + ", cause:" + r106.getCause());     // Catch: Throwable -> L11
    L9:
        Object r107 = Result.m9449constructorimpl(r105);     // Catch: Throwable -> L11
    L14:
        if (Result.m9456isSuccessimpl(r107) == false) goto L16;
        y86.a.c("geckosdk_gkfs_chunk_read_stats", (JSONObject) r107);
    L16:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);
        if (r108 == null) goto L20;
        r108.printStackTrace();
    L20:
        if (Result.m9455isFailureimpl(r107) == false) goto L22;
        r107 = null;
    L22:
        JSONObject r109 = (JSONObject) r107;
        return;
    L8:
        r105.put(BitableResourceData.KEY_BLOCK_ID, r103.f245195c.f245289d.f245257c.f245185a);     // Catch: Throwable -> L11
        r105.put("from", r102.getValue());     // Catch: Throwable -> L11
        r105.put("size", r103.f245195c.f245293h);     // Catch: Throwable -> L11
        r105.put("lock_cost", r103.f245195c.f245290e);     // Catch: Throwable -> L11
        r105.put("indexing_cost", r103.f245195c.f245289d.f245261g);     // Catch: Throwable -> L11
        r105.put("read_cost", r103.f245195c.f245291f);     // Catch: Throwable -> L11
        r105.put("total_cost", r103.f245195c.f245292g);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L14
    }
}
