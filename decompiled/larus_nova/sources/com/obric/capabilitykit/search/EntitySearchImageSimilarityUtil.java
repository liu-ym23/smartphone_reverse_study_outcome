package com.obric.capabilitykit.search;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.alipay.sdk.m.p.e;
import com.bytedance.android.ec.core.event.a;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.google.gson.Gson;
import com.ss.android.lark.utils.statistics.PerfLog;
import f06.b;
import f06.d;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J2\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0007J.\u0010\u0014\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00072\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0002R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/obric/capabilitykit/search/EntitySearchImageSimilarityUtil;", "", "()V", "ENTITY_URI", "Landroid/net/Uri;", "kotlin.jvm.PlatformType", "KEY_ENTITY_ID_LIST", "", "KEY_MEMORY_RESPONSE", "KEY_QUERY_TEXT", "METHOD_GET_IMAGES_SIMILARITY", "TAG", "getImagesSimilarityRankByTextFromVectorDB", "Lcom/obric/capabilitykit/search/Response;", "Lcom/obric/capabilitykit/search/Similarity;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "entityIdList", "", "queryText", "innerCall", "uri", e.f25671s, "args", "Landroid/os/Bundle;", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class EntitySearchImageSimilarityUtil {
    private static final Uri ENTITY_URI = null;
    public static final EntitySearchImageSimilarityUtil INSTANCE = null;
    private static final String KEY_ENTITY_ID_LIST = "entity_id_list";
    private static final String KEY_MEMORY_RESPONSE = "memory_response";
    private static final String KEY_QUERY_TEXT = "query_text";
    private static final String METHOD_GET_IMAGES_SIMILARITY = "getImagesSimilarityByTextFromVectorDB";
    private static final String TAG = "ImageSimilarity";

    static {
        INSTANCE = new EntitySearchImageSimilarityUtil();
        ENTITY_URI = UriProtector.parse("content://com.obric.memorydata.personalcontext.EntityProvider");
    }

    private EntitySearchImageSimilarityUtil() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Response getImagesSimilarityRankByTextFromVectorDB$default(EntitySearchImageSimilarityUtil r100, Context r101, List r102, String r103, int r104, Object r105) {
        if ((r104 & 2) == 0) goto L6;
        r102 = null;
    L6:
        if ((r104 & 4) == 0) goto L9;
        r103 = null;
    L9:
        return r100.getImagesSimilarityRankByTextFromVectorDB(r101, r102, r103);
    }

    private final String innerCall(Context r100, Uri r101, String r102, Bundle r103) {
        ContentProviderClient r104 = com_obric_capabilitykit_search_EntitySearchImageSimilarityUtil_android_content_ContentResolver_acquireUnstableContentProviderClient(r100.getContentResolver(), r101);     // Catch: Exception -> L21
        if (r104 != null) goto L27;
        return null;
    L27:
        Bundle r105 = r104.call(r102, null, r103);     // Catch: Throwable -> L8 Throwable -> L10
    L12:
        r104.close();     // Catch: Exception -> L21
        if (r105 != null) goto L15;
        return null;
    L15:
        String r106 = r105.getString(KEY_MEMORY_RESPONSE);     // Catch: Exception -> L21
        if (r106 != null) goto L29;
        return null;
    L29:
        return r106;
    L11:
        r105 = null;
    L8:
        th = move-exception;
        r104.close();     // Catch: Exception -> L21
        throw th;     // Catch: Exception -> L21
    L21:
        e = move-exception;
        e.getMessage();
        return null;
    }

    public static /* synthetic */ String innerCall$default(EntitySearchImageSimilarityUtil r100, Context r101, Uri r102, String r103, Bundle r104, int r105, Object r106) {
        if ((r105 & 8) == 0) goto L6;
        r104 = new Bundle();
    L6:
        return r100.innerCall(r101, r102, r103, r104);
    }

    public final Response<Similarity> getImagesSimilarityRankByTextFromVectorDB(Context r110, List<String> r111, String r112) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        boolean r100 = true;
        if (r112 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == true) goto L11;
        if (r111 != null) goto L14;
    L17:
        boolean r102 = true;
    L18:
        if (r102 == true) goto L20;
        Uri r103 = ENTITY_URI;
        Bundle r104 = new Bundle();
        r104.putStringArrayList(KEY_ENTITY_ID_LIST, new ArrayList(r111));
        r104.putString(KEY_QUERY_TEXT, r112);
        String r113 = innerCall(r110, r103, METHOD_GET_IMAGES_SIMILARITY, r104);
        if (r113 != null) goto L24;
    L27:
        if (r100 == false) goto L31;
        return new Response(1, "result is empty", null, 4, null);
    L31:
        return new Response(0, a.VALUE_CLICK_TYPE, (Similarity) GsonProtectorUtils.fromJson(new Gson(), r113, Similarity.class));
    L24:
        if (r113.length() == 0) goto L27;
        r100 = false;
        goto L27
    L20:
        return new Response(1, "entityIdList is empty", null, 4, null);
    L14:
        if (r111.isEmpty() == true) goto L17;
        r102 = false;
        goto L18
    L11:
        return new Response(1, "queryText is empty", null, 4, null);
    L5:
        if (r112.length() == 0) goto L8;
        r101 = false;
        goto L9
    }

    private static ContentProviderClient com_obric_capabilitykit_search_EntitySearchImageSimilarityUtil_android_content_ContentResolver_acquireUnstableContentProviderClient(ContentResolver r110, Uri r111) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r111};
        b r112 = new b();
        g06.a r102 = ApiHookConfig.f245611b.get(240008);
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r113 = r103;
        int r104 = r113.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L15;
        f06.a r106 = r113[r105];
        int r114 = r105;
        int r115 = r104;
        d r107 = r106.preInvoke(240008, "android/content/ContentResolver", "acquireUnstableContentProviderClient", r110, r101, "android.content.ContentProviderClient", r112);     // Catch: Exception -> L22
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L22
    L17:
        if (r107.f474982a == false) goto L21;
        return (ContentProviderClient) r107.f474983b;
    L21:
        return r110.acquireUnstableContentProviderClient(r111);
    L14:
        r105 = r114 + 1;
        r104 = r115;
        goto L8
    L15:
        r107 = new d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }
}
