package com.obric.memorydata.sdk.entity.search.oauto;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter;
import com.obric.memorydata.sdk.MemoryResponse;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import pka.a;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/sdk/entity/search/oauto/OAutoGlobalSearch;", "", "<init>", "()V", "searchByQUResult", "Lcom/obric/memorydata/sdk/entity/search/oauto/OAutoSearchResult;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "quResult", "", "isVoiceQuery", "", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class OAutoGlobalSearch {
    public static final OAutoGlobalSearch INSTANCE = null;

    static {
        INSTANCE = new OAutoGlobalSearch();
    }

    private OAutoGlobalSearch() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final OAutoSearchResult searchByQUResult(Context r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        a r103 = a.f529681a;
        JSONObject r104 = new JSONObject();
        r104.put("quResult", r101);
        if (r102 == false) goto L5;
        String r105 = "VOICE";
    L6:
        r104.put("interactionType", r105);
        r103.getClass();
        Intrinsics.checkNotNullParameter(r104, "params");
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Bundle r106 = new Bundle();
        r106.putString("oAutoGlobalSearchExecutorParams", r104.toString());
        MemoryResponse r107 = a.c(r100, "oAutoGlobalSearchIntent", r106);
        OAutoSearchResult r108 = (OAutoSearchResult) r107.f397053c;
        if (r107.f397051a != 0) goto L11;
        if (r108 == null) goto L11;
        return r108;
    L11:
        return new OAutoSearchResult(r107.f397051a, r107.f397052b, null);
    L5:
        r105 = CardAdapter.TEXT;
        goto L6
    }
}
